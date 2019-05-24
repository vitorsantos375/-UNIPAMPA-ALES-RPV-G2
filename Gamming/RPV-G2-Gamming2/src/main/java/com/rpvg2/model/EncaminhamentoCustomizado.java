package com.rpvg2.model;

import com.rpvg2.util.CollectionUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Giliardi Schmidt
 */
@ManagedBean
@ApplicationScoped
public class EncaminhamentoCustomizado extends Encaminhamento implements Serializable {

    private boolean segundoturno;
    private List<OpcaoVoto> opcoesVotosSegundoTurno;

    public EncaminhamentoCustomizado() {
        super();
        this.opcoesVoto.add(new OpcaoVoto("Abstenção"));
        this.segundoturno = false;
    }

    public boolean addOpcaoVoto(OpcaoVoto opcaoVoto) {
        if (opcaoVoto == null) {
            throw new IllegalArgumentException("A opção de voto não pode estar vazia!");
        }
        if (opcoesVoto.contains(opcaoVoto)) {
            throw new IllegalArgumentException("Opção de voto já cadastrada");
        }
        return opcoesVoto.add(opcaoVoto);
    }

    public void setOpcoesVoto(List<OpcaoVoto> opcoesVoto) {
        if (opcoesVoto == null) {
            throw new NullPointerException("A lista com opções de voto não pode ser null");
        }

        if (CollectionUtil.possuiDuplicatas(opcoesVoto)) {
            throw new IllegalArgumentException("A lista de opções de votos não pode conter elementos duplicados!");
        }
        this.opcoesVoto = opcoesVoto;
    }

    public boolean removeOpcaoVoto(OpcaoVoto opcaoVoto) {
        if (opcaoVoto.equals(opcoesVoto.get(0))) {
            throw new IllegalArgumentException("Está opção de voto não pode ser removida!!");
        }
        return opcoesVoto.remove(opcaoVoto);
    }

    public boolean isSegundoturno() {
        return segundoturno;
    }

    public void setSegundoturno(boolean segundoturno) {
        this.segundoturno = segundoturno;
    }

    public List<OpcaoVoto> getOpcoesVotosSegundoTurno() {
        return opcoesVotosSegundoTurno;
    }

    public void setOpcoesVotosSegundoTurno(List<OpcaoVoto> opcoesVotosSegundoTurno) {
        if (opcoesVotosSegundoTurno == null) {
            throw new NullPointerException("A lista com opções de voto não pode ser null");
        }
        if (CollectionUtil.possuiDuplicatas(opcoesVotosSegundoTurno)) {
            throw new IllegalArgumentException("A lista de opções de votos não pode conter elementos duplicados!");
        }
        this.opcoesVotosSegundoTurno = opcoesVotosSegundoTurno;
    }

}
