package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author gilis
 */
@Named(value = "membro")
@SessionScoped
public class MembroBean implements Serializable {

    private boolean botaoVotar;
    private String nomeVotacao = "banaaaaaaaaa";

    /**
     * Creates a new instance of Membro
     */
    public MembroBean() {
        botaoVotar = false;

    }

    public void iniciarVotacao(Object message) {
        String e = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("param");
        setNomeVotacao(e);
    }

    public boolean isBotaoVotar() {
        return botaoVotar;
    }

    public void setBotaoVotar(boolean botaoVotar) {
        this.botaoVotar = botaoVotar;
    }

    public String getNomeVotacao() {
        return nomeVotacao;
    }

    public void setNomeVotacao(String nomeVotacao) {
        this.nomeVotacao = nomeVotacao;
    }

}
