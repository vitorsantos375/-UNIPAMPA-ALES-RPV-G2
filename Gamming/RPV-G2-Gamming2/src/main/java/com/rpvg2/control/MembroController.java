package com.rpvg2.control;

import com.rpvg2.model.Encaminhamento;
import com.rpvg2.model.EncaminhamentoCustomizado;
import com.rpvg2.model.Usuario;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.Reuniao;
import com.rpvg2.model.repository.UsuarioRepository;
import com.rpvg2.model.repository.ReuniaoRepository;
import com.rpvg2.view.MensagensView;
import com.rpvg2.excecoes.UserNotFound;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Giliardi Schmidt
 */
@Named(value = "membroController")
@SessionScoped
@ManagedBean
public class MembroController implements Serializable {

    private Usuario membro;
    private Encaminhamento encaminhamento;
    private String voto;
    private MensagensView mensagensView;
    private VotacaoController votacaoController;
    private List<Reuniao> reunioesDisponiveis;
    private List<OpcaoVoto> opcoesVotoEncaminhamento;
    private Reuniao reuniaoSelecionada;

    public MembroController() {
        this.membro = new Usuario();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        votacaoController = (VotacaoController) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "votacaoController");
        this.mensagensView = new MensagensView();
    }

    public void exbirTelaVotacao() throws IOException {
        RequestContext.getCurrentInstance().execute("showNotification(1)");

        encaminhamento = votacaoController.getEncaminhamentoEmVotacao();

        if (!votacaoController.isEstaNoSegundoTurno()) {
            opcoesVotoEncaminhamento = encaminhamento.getOpcoesVoto();
        } else {
            opcoesVotoEncaminhamento = ((EncaminhamentoCustomizado) encaminhamento).getOpcoesVotosSegundoTurno();
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("votacao.xhtml");
    }

    public void selectReunioesAbertas(Usuario user) throws IOException {
        try {
            this.membro = user;
            this.reunioesDisponiveis = new ReuniaoRepository().recuperaPorMembroEAberta(membro, true);

        } catch (SQLException | ClassNotFoundException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            this.mensagensView.criarMensagemError("Usuário não encontrado!");
        } catch (RuntimeException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }
    }

    public void votar() throws IOException {
        try {
            if (voto == null || voto.isEmpty()) {
                mensagensView.criarMensagemWarn("Você deve selecionar uma opção de voto!");
                return;
            }

            for (OpcaoVoto ov : encaminhamento.getOpcoesVoto()) {
                if (ov.getDescricao().equals(voto)) {
                    if (votacaoController.votar(membro, ov)) {
                        exbirTelaVotacao();
                        return;
                    }
                    break;
                }
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("espera.xhtml");
            this.mensagensView.criarMensagemInfo("Seu voto foi contabilizado. Aguarde o segundo turno!");
        } catch (Exception e) {
            this.mensagensView.criarMensagemError(e.getMessage());
        }
    }

    public void registrarVotacao() throws IOException {
        try {
            votacaoController.registrarMembro(membro);
        } catch (Exception e) {
            this.mensagensView.criarMensagemError(e.getMessage());
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("espera.xhtml");
    }

    public void sairReuniao() {
        try {
            votacaoController.removerMembro(membro);
            FacesContext.getCurrentInstance().getExternalContext().redirect("selecaoreuniaomem.xhtml");
        } catch (Exception e) {
            this.mensagensView.criarMensagemError(e.getMessage());
        }
    }

//<editor-fold defaultstate="collapsed" desc="Gets e Sets">
    public Usuario getMembro() {
        return membro;
    }

    public void setMembro(Usuario membro) {
        this.membro = membro;
    }

    public void setVoto(String voto) {
        this.voto = voto;
        this.mensagensView.criarMensagemInfo(this.voto);
    }

    public String getVoto() {
        return voto;
    }

    public void setNomeMembro(String nome) {
        membro.setNome(nome);
    }

    public Encaminhamento getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(Encaminhamento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public List<Reuniao> getReunioesDisponiveis() {
        return reunioesDisponiveis;
    }

    public void setReunioesDisponiveis(List<Reuniao> reunioesDisponiveis) {
        this.reunioesDisponiveis = reunioesDisponiveis;
    }

    public List<OpcaoVoto> getOpcoesVotoEncaminhamento() {
        return opcoesVotoEncaminhamento;
    }

    public void setOpcoesVotoEncaminhamento(List<OpcaoVoto> opcoesVotoEncaminhamento) {
        this.opcoesVotoEncaminhamento = opcoesVotoEncaminhamento;
    }

    public Reuniao getReuniaoSelecionada() {
        return reuniaoSelecionada;
    }

    public void setReuniaoSelecionada(Reuniao reuniaoSelecionada) {
        this.reuniaoSelecionada = reuniaoSelecionada;
    }
//</editor-fold>

}
