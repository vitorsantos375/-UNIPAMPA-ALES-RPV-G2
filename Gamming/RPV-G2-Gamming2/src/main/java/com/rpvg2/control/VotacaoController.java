package com.rpvg2.control;

import com.rpvg2.model.Encaminhamento;
import com.rpvg2.model.EncaminhamentoCustomizado;
import com.rpvg2.model.Usuario;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.Reuniao;
import com.rpvg2.model.repository.ReuniaoRepository;
import com.rpvg2.view.MensagensView;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

/**
 *
 * @author Giliardi Schmidt
 */
@Named(value = "votacaoController")
@ApplicationScoped
public class VotacaoController implements Serializable {

    private Reuniao reuniao;
    private Encaminhamento encaminhamentoEmVotacao;
    private Map<Usuario, OpcaoVoto> votosPrimeiroTurno;
    private Map<Usuario, OpcaoVoto> votosSegundoTurno;
    private boolean votacaoAberta;
    private boolean possuiSegundoTurno;
    private boolean estaNoSegundoTurno;
    private boolean votacaoCancelada;
    private ReuniaoRepository reuniaoREP;
    private MensagensView mensagem;
    private OpcaoVoto opcaoVencedora;

    @Inject
    @Push
    private PushContext notificacaoItemPauta;

    @Inject
    @Push
    private PushContext resultadoVotacao;

    @Inject
    @Push
    private PushContext acompanhamentoVotacao;

    public VotacaoController() {
        this.votosPrimeiroTurno = new ConcurrentHashMap<>();
        this.votosSegundoTurno = new ConcurrentHashMap<>();
        this.reuniaoREP = new ReuniaoRepository();
        this.votacaoAberta = false;
        this.votacaoCancelada = false;
        this.mensagem = new MensagensView();
    }

    public synchronized boolean votar(Usuario membro, OpcaoVoto opcaoVoto) throws SQLException, ClassNotFoundException {
        try {
            if (!votacaoAberta) {
                throw new IllegalArgumentException("A votação para este item está encerrada");
            }

            if (!estaNoSegundoTurno) {
                if (votosPrimeiroTurno.containsKey(membro)) {
                    throw new IllegalArgumentException("Você já votou!");
                }
                votosPrimeiroTurno.put(membro, opcaoVoto);
                if (reuniao.getMembrosRegistrados().size() == votosPrimeiroTurno.size()) {
                    if (possuiSegundoTurno) {
                        adicionarOpcoesVotoSegundoTurno();
                        estaNoSegundoTurno = true;
                        notificacaoItemPauta.send("O Segundo Turno Começou.");
                        return true;
                    } else {
                        encerrarVotacaoItemPauta();
                    }
                }
            } else if (estaNoSegundoTurno) {
                if (votosSegundoTurno.containsKey(membro)) {
                    throw new IllegalArgumentException("Você já votou!");
                }

                votosSegundoTurno.put(membro, opcaoVoto);
                if (reuniao.getMembrosRegistrados().size() == votosSegundoTurno.size()) {
                    encerrarVotacaoItemPauta();
                }
            }
        } catch (Exception e) {
            System.out.println("asdsa");
        } finally {
            if (votacaoAberta) {
                acompanhamentoVotacao.send("Há alterações nos votos.");
            }
        }

        return false;
    }

    public synchronized void registrarMembro(Usuario m) throws SQLException, ClassNotFoundException {
        if (votacaoAberta) {
            throw new RuntimeException("Você não pode se registrar porque há uma votação aberta!");
        }

        if (reuniao.getMembrosCadastrados().contains(m)) {
            if (!reuniao.getMembrosRegistrados().contains(m)) {
                reuniao.getMembrosRegistrados().add(m);
                reuniaoREP.editaPreseca(m,reuniao.getDescricao(),true);
            }
        } else {
            throw new RuntimeException("Você não está registrado nesta reunião!");
        }
    }

    public synchronized void removerMembro(Usuario m) throws SQLException, ClassNotFoundException {
        reuniao.getMembrosRegistrados().remove(m);
        reuniaoREP.editaPreseca(m,reuniao.getDescricao(),false);
    }

    public synchronized void abrirEncaminhamentoParaVotacao(Encaminhamento encaminhamento) {

        encaminhamentoEmVotacao = encaminhamento;
        votosPrimeiroTurno.clear();
        votosSegundoTurno.clear();
        votacaoAberta = true;
        votacaoCancelada = false;

        possuiSegundoTurno = encaminhamento instanceof EncaminhamentoCustomizado
                && ((EncaminhamentoCustomizado) encaminhamento).isSegundoturno();

        estaNoSegundoTurno = false;

        ArrayList<String> membros = new ArrayList();

        for (Usuario membro : reuniao.getMembrosRegistrados()) {
            membros.add(membro.getNome());
        }
        notificacaoItemPauta.send("Nova votação disponível", (Collection) membros);
    }

    public synchronized void cancelarVotacao() {
        votacaoAberta = false;
        votacaoCancelada = true;
        resultadoVotacao.send("Votação cancelada");
    }

    public synchronized void encerrarVotacaoItemPauta() throws SQLException, ClassNotFoundException {
        votacaoAberta = false;
        votacaoCancelada = false;

        reuniaoREP.editaVotacao(votosPrimeiroTurno, votosSegundoTurno, encaminhamentoEmVotacao, reuniao.getDescricao());
        try {

            if (possuiSegundoTurno) {
                opcaoVencedora = getNumeroVotosPorOpcaoOrdenado(votosSegundoTurno).get(0).getKey();
            } else {
                opcaoVencedora = getNumeroVotosPorOpcaoOrdenado(votosPrimeiroTurno).get(0).getKey();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        resultadoVotacao.send("Votação encerrada");
    }

    private void adicionarOpcoesVotoSegundoTurno() throws SQLException, ClassNotFoundException {
        List<Entry<OpcaoVoto, Long>> list = getNumeroVotosPorOpcaoOrdenado(votosPrimeiroTurno);

        List<OpcaoVoto> votos2 = new ArrayList<>();

        if (list.size() < 2) {
            encerrarVotacaoItemPauta();
            return;
        }

        for (int i = 0; votos2.size() < 2; i++) {
            if (i >= list.size()) {
                break;
            }
            if (list.get(i).getKey().getDescricao().equalsIgnoreCase("Abstenção")) {
            } else {
                votos2.add(list.get(i).getKey());
            }
        }

        if (votos2.size() < 2) {
            encerrarVotacaoItemPauta();
            return;
        }

        votos2.add(new OpcaoVoto("Abstenção"));

        ((EncaminhamentoCustomizado) encaminhamentoEmVotacao).setOpcoesVotosSegundoTurno(votos2);
    }

    private List<Entry<OpcaoVoto, Long>> getNumeroVotosPorOpcaoOrdenado(Map<Usuario, OpcaoVoto> votos) {
        Map<OpcaoVoto, Long> ocorrenciaVotos = getNumeroVotosPorOpcao(votos);

        List<Entry<OpcaoVoto, Long>> list = new ArrayList<>(ocorrenciaVotos.entrySet());
        list.sort(Entry.comparingByValue());

        return list;
    }

    private Map<OpcaoVoto, Long> getNumeroVotosPorOpcao(Map<Usuario, OpcaoVoto> votos) {
        Collection<OpcaoVoto> v = votos.values();
        Map<OpcaoVoto, Long> ocorrenciaVotos = v.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return ocorrenciaVotos;
    }

    public Map<OpcaoVoto, Long> getNumeroVotosPorOpcaoPrimeiroTurno() {
        Map<OpcaoVoto, Long> opcoesVotadas = getNumeroVotosPorOpcao(votosPrimeiroTurno);
        encaminhamentoEmVotacao.getOpcoesVoto().forEach((opcaoVoto) -> {
            opcoesVotadas.putIfAbsent(opcaoVoto, Long.parseLong("0"));
        });
        return opcoesVotadas;
    }

    public Map<OpcaoVoto, Long> getNumeroVotosPorOpcaoSegundoTurno() {
        Map<OpcaoVoto, Long> opcoesVotadas = getNumeroVotosPorOpcao(votosSegundoTurno);

        if (possuiSegundoTurno) {
            EncaminhamentoCustomizado c = (EncaminhamentoCustomizado) encaminhamentoEmVotacao;

            if (c.getOpcoesVotosSegundoTurno() != null) {
                c.getOpcoesVotosSegundoTurno().forEach((opcaoVoto) -> {
                    opcoesVotadas.putIfAbsent(opcaoVoto, Long.parseLong("0"));
                });
            }
        }

        return opcoesVotadas;
    }

    //<editor-fold defaultstate="collapsed" desc="GETS e SETS">
    public void setReuniao(Reuniao r) {
        this.reuniao = r;
    }

    public OpcaoVoto getOpcaoVencedora() {
        return opcaoVencedora;
    }

    public void setOpcaoVencedora(OpcaoVoto opcaoVencedora) {
        this.opcaoVencedora = opcaoVencedora;
    }

    public Encaminhamento getEncaminhamentoEmVotacao() {
        return encaminhamentoEmVotacao;
    }

    public boolean isVotacaoAberta() {
        return votacaoAberta;
    }

    public boolean isPossuiSegundoTurno() {
        return possuiSegundoTurno;
    }

    public boolean isEstaNoSegundoTurno() {
        return estaNoSegundoTurno;
    }

    public Map<Usuario, OpcaoVoto> getVotosPrimeiroTurno() {
        return votosPrimeiroTurno;
    }

    public Map<Usuario, OpcaoVoto> getVotosSegundoTurno() {
        return votosSegundoTurno;
    }

    public boolean isVotacaoCancelada() {
        return votacaoCancelada;
    }

//</editor-fold>
}
