/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.control;

import com.rpvg2.model.Encaminhamento;
import com.rpvg2.model.EncaminhamentoCustomizado;
import com.rpvg2.model.EncaminhamentoSimples;
import com.rpvg2.model.ItemPauta;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.repository.EncaminhamentoRepository;
import com.rpvg2.model.repository.ItemPautaRepository;
import com.rpvg2.model.repository.OpcaoVotoRepository;
import com.rpvg2.view.MensagensView;
import java.io.Serializable;
import java.sql.SQLException;
import javax.el.ELContext;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author Guilherm Bolfe
 */
@Named(value = "encaminhamentosController")
@ViewScoped
@ManagedBean
public class EncaminhamentosController implements Serializable {

    private EncaminhamentoCustomizado encaminhamentoCustomziado;
    private EncaminhamentoSimples encaminhamentoSimples;
    private EncaminhamentoRepository encaminhamentoREP;
    private ItemPautaRepository itemPautaREP;
    private OpcaoVotoRepository opcaoVotoREP;
    private int e;
    private int idPauta;
    private String opcaoVotoString;
    private ItemPauta itemPauta;
    private MensagensView mensagensView;
    private boolean encRenderizado;
    private boolean votacaoRenderizado;
    private boolean resultadoRenderizado;
    private String activeIndex;
    private VotacaoController votacaoController;

    /**
     * Creates a new instance of EncaminhamentosController
     */
    public EncaminhamentosController() {
        this.mensagensView = new MensagensView();
        this.encaminhamentoREP = new EncaminhamentoRepository();
        this.itemPautaREP = new ItemPautaRepository();
        this.opcaoVotoREP = new OpcaoVotoRepository();
        this.encRenderizado = false;
        this.votacaoRenderizado = true;
        this.resultadoRenderizado = true;
        this.activeIndex = "0";
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        votacaoController = (VotacaoController) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "votacaoController");
    }

    public void selecionaPautaDaListaPorId() {
        try {
            this.itemPauta = this.itemPautaREP.recuperarPorID(idPauta);
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }
    }

    public void salvarEncaminhamentoNoBancoDeDados() {
        try {
            Encaminhamento e;
            if (this.e == 1) {
                //this.mensagensView.criarMensagemInfo(Boolean.toString(this.encaminhamentoREP.inserirObjeto(encaminhamentoSimples)));
                e = encaminhamentoSimples;
            } else {
               // this.mensagensView.criarMensagemInfo(Boolean.toString(this.encaminhamentoREP.inserirObjeto(encaminhamentoCustomziado)));
                e = encaminhamentoCustomziado;
            }

            mudarIndexExibido(1);

            votacaoController.abrirEncaminhamentoParaVotacao(e);

        } catch (NumberFormatException | NullPointerException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }

    }

    public void criarEncaminhamnetos() {
        try {
            this.e = 1;

            String[] valores = new String[3];
            valores[0] = Integer.toString(2);
            valores[1] = Integer.toString(this.itemPauta.getId());
            this.encaminhamentoCustomziado = (EncaminhamentoCustomizado) this.encaminhamentoREP.criarNovoObjeto(valores);

            valores[0] = Integer.toString(1);
            this.encaminhamentoSimples = (EncaminhamentoSimples) this.encaminhamentoREP.criarNovoObjeto(valores);
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }
    }

    public void adicionarOpcaoDeVotoEncaminhamnetoCustomizado() {
        String[] valores = new String[3];
        valores[0] = opcaoVotoString;
        valores[1] = Integer.toString(0);

        try {
            OpcaoVoto opcao = this.opcaoVotoREP.criarNovoObjeto(valores);

            if (this.encaminhamentoCustomziado.addOpcaoVoto(opcao)) {
                this.mensagensView.criarMensagemInfo("Opcao Adicionada");
            } else {
                this.mensagensView.criarMensagemError("Não foi possivel adicionar a opção de voto");
            }

            this.opcaoVotoString = "";
        } catch (IllegalArgumentException e) {
            this.mensagensView.criarMensagemWarn(e.getMessage());
        }

    }

    public void excluirOpcaoDeVotoEncaminhamentoCustomizado(OpcaoVoto opcaoVoto) {
        try {
            if (this.encaminhamentoCustomziado.removeOpcaoVoto(opcaoVoto)) {
                this.mensagensView.criarMensagemInfo("Opcão de voto excluida");
            } else {
                this.mensagensView.criarMensagemError("Não foi possivel excluir a opção de voto");
            }
        } catch (IllegalArgumentException e) {
            this.mensagensView.criarMensagemWarn(e.getMessage());
        }
    }

    public void mudarTipoDeEncaminhamento(TabChangeEvent event) {

        if (event.getTab().getId().equals("simples")) {
            this.e = 1;
        } else if (event.getTab().getId().equals("custom")) {
            this.e = 2;
        }
    }

    public void cancelarVotacao() {
        mudarIndexExibido(0);
        this.mensagensView.criarMensagemInfo("Votação cancelada!");

    }

    public void verificarAlteracaoEstadoVotacao() {
        if (votacaoController.isVotacaoCancelada()) {
            cancelarVotacao();
        } else {
            exibirResultadoVotacao();
        }
    }

    public void exibirResultadoVotacao() {
        mudarIndexExibido(2);
        this.mensagensView.criarMensagemInfo("Votação Encerrada!");
    }

    private void mudarIndexExibido(int index) {
        switch (index) {
            case 0:
                this.encRenderizado = false;
                this.votacaoRenderizado = true;
                this.resultadoRenderizado = true;
                break;
            case 1:
                this.encRenderizado = true;
                this.votacaoRenderizado = false;
                this.resultadoRenderizado = true;
                break;
            case 2:
                this.encRenderizado = true;
                this.votacaoRenderizado = true;
                this.resultadoRenderizado = false;
                break;
        }

        this.activeIndex = Integer.toString(index);

    }

    //<editor-fold defaultstate="collapsed" desc="GETS e SETS">
    public EncaminhamentoRepository getEncaminhamentoREP() {
        return encaminhamentoREP;
    }

    public void setEncaminhamentoREP(EncaminhamentoRepository encaminhamentoREP) {
        this.encaminhamentoREP = encaminhamentoREP;
    }

    public ItemPautaRepository getItemPautaREP() {
        return itemPautaREP;
    }

    public void setItemPautaREP(ItemPautaRepository itemPautaREP) {
        this.itemPautaREP = itemPautaREP;
    }

    public OpcaoVotoRepository getOpcaoVotoREP() {
        return opcaoVotoREP;
    }

    public void setOpcaoVotoREP(OpcaoVotoRepository opcaoVotoREP) {
        this.opcaoVotoREP = opcaoVotoREP;
    }

    public MensagensView getMensagensView() {
        return mensagensView;
    }

    public void setMensagensView(MensagensView mensagensView) {
        this.mensagensView = mensagensView;
    }
    
    public boolean isEncRenderizado() {
        return encRenderizado;
    }

    public void setEncRenderizado(boolean encRenderizado) {
        this.encRenderizado = encRenderizado;
    }

    public boolean isVotacaoRenderizado() {
        return votacaoRenderizado;
    }

    public void setVotacaoRenderizado(boolean votacaoRenderizado) {
        this.votacaoRenderizado = votacaoRenderizado;
    }

    public boolean isResultadoRenderizado() {
        return resultadoRenderizado;
    }

    public void setResultadoRenderizado(boolean resultadoRenderizado) {
        this.resultadoRenderizado = resultadoRenderizado;
    }

    public String getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(String activeIndex) {
        this.activeIndex = activeIndex;
    }

    public EncaminhamentoCustomizado getEncaminhamentoCustomziado() {
        return encaminhamentoCustomziado;
    }

    public void setEncaminhamentoCustomziado(EncaminhamentoCustomizado encaminhamentoCustomziado) {
        this.encaminhamentoCustomziado = encaminhamentoCustomziado;
    }

    public String getOpcaoVotoString() {
        return opcaoVotoString;
    }

    public void setOpcaoVotoString(String opcaoVotoString) {
        this.opcaoVotoString = opcaoVotoString;
    }

    public EncaminhamentoSimples getEncaminhamentoSimples() {
        return encaminhamentoSimples;
    }

    public void setEncaminhamentoSimples(EncaminhamentoSimples encaminhamentoSimples) {
        this.encaminhamentoSimples = encaminhamentoSimples;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public ItemPauta getItemPauta() {
        return itemPauta;
    }

    public void setItemPauta(ItemPauta itemPauta) {
        this.itemPauta = itemPauta;
    }

    public int getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(int idPauta) {
        this.idPauta = idPauta;
    }
//</editor-fold>
}
