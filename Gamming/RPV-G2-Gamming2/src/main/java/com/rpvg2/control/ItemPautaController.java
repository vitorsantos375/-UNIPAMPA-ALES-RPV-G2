/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.control;

/**
 *
 * @author victorqribeiro
 */
import com.rpvg2.model.ItemPauta;
import com.rpvg2.model.Relator;
import com.rpvg2.model.repository.ItemPautaRepository;
import com.rpvg2.model.repository.RelatorRepository;
import com.rpvg2.util.StringUtil;
import com.rpvg2.view.MensagensView;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ItemPautaController implements Serializable {

    private List<ItemPauta> listaItensPauta;
    private MensagensView mensagensView;
    private ItemPautaRepository itemPautaREP;
    private RelatorRepository relatorREP;
    private ItemPauta itemPautaSelecionado = new ItemPauta();
    private String descReuniao;
    private String descItemPauta;
    private String relator;

    public ItemPautaController() {
        this.listaItensPauta = new ArrayList();
        this.itemPautaREP = new ItemPautaRepository();
        this.mensagensView = new MensagensView();
        this.relatorREP = new RelatorRepository();
    }

    public void selectBancoDeDados() {
        try {
            this.listaItensPauta = this.itemPautaREP.recuperarPorReuniao(descReuniao);
        } catch (SQLException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }
    }

    public void salvarNovoItemPauta() {
        try {
            if (!StringUtil.verificaStringVazia(descItemPauta) && !StringUtil.verificaStringVazia(relator)) {
                //chamar a repository
                ItemPauta aux = itemPautaREP.inserirObjetoItemPauta(descItemPauta, relator, descReuniao);
                relator = "";
                descItemPauta = "";

                //adicionar o item de pauta criado na lista de intens de pauta
                listaItensPauta.add(aux);
                this.mensagensView.criarMensagemInfo("Item de Pauta criado com sucesso!");
            } else {
                this.mensagensView.criarMensagemWarn("Verifique se todas as informações foram inseridas corretamente!");
            }
        } catch (Exception e) {
            this.mensagensView.criarMensagemError(e.getMessage());
        }
    }

    public List<String> completeText(String query) {
        List<String> relatores = new ArrayList<>();
        List<Relator> result = new ArrayList<>();
        try {
            if (!query.trim().isEmpty() && query != null) {
                result = new RelatorRepository().recuperarTodosObjetos();
                for (Relator relator : result) {
                    if (relator.getNome().toLowerCase().contains(query.toLowerCase())) {
                        relatores.add(relator.getNome());
                    }
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            new MensagensView().criarMensagemError(ex.getMessage());
        }
        return relatores;
    }

    public void deletarItemPauta(ItemPauta itemPauta) {
        try {
            itemPautaREP.excluirObjeto(itemPauta);
            listaItensPauta.remove(itemPauta);
            this.mensagensView.criarMensagemInfo("Item Pauta excluido com sucesso!!");
        } catch (SQLException | ClassNotFoundException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }
    }

    public void atualizarItemPauta() throws IOException {
        if (itemPautaSelecionado == null) {
            this.mensagensView.criarMensagemWarn("Nenhum item de pauta selecionado!");
            return;
        }

        try {
            //passar como parametro tambem os novos dados
            if (!StringUtil.verificaStringVazia(descItemPauta) && !StringUtil.verificaStringVazia(relator)) {
                if (!relator.equalsIgnoreCase(itemPautaSelecionado.getRelator().getNome())) {
                    try {
                        Relator r = (Relator) this.relatorREP.recuperarPorDescricao(relator).get(0);
                        itemPautaSelecionado.setRelator(r);
                    } catch (Exception e) {
                        this.mensagensView.criarMensagemWarn("Relator não cadastrado no sistema!");
                        return;
                    }
                }

                if (!descItemPauta.equalsIgnoreCase(itemPautaSelecionado.getDescricao())) {
                    itemPautaSelecionado.setDescricao(descItemPauta);
                }

                itemPautaREP.editarObjetoItemPauta(itemPautaSelecionado, descReuniao);
                itemPautaSelecionado = null;

                FacesContext.getCurrentInstance().getExternalContext().redirect("edicaoitensreuniao.xhtml");
                this.mensagensView.criarMensagemInfo("Editado com sucesso!!");
            } else {
                this.mensagensView.criarMensagemWarn("Verifique se todas as informações foram inseridas corretamente!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            this.mensagensView.criarMensagemError(ex.getMessage());
        }
    }

    public void setItemPautaSelecionado(ItemPauta itemPautaSelecionado) throws IOException {
        this.itemPautaSelecionado = itemPautaSelecionado;
        this.descItemPauta = itemPautaSelecionado.getDescricao();
        this.relator = itemPautaSelecionado.getRelator().getNome();

        FacesContext.getCurrentInstance().getExternalContext().redirect("editaitempautav2.xhtml");
    }

    public String getMensagemEdicaoPersonalizada() {
        return "<strong>Dados Antigos</strong>"
                + "<br/>" + itemPautaSelecionado.getDescricao() + " - " + itemPautaSelecionado.getRelator().getNome()
                + "<br/><br/><strong>Dados Novos</strong>"
                + "<br/>" + descItemPauta + " - " + relator;
    }

    public void limparCampos() {
        this.relator = "";
        this.descItemPauta = "";
    }

//<editor-fold defaultstate="collapsed" desc="Gets e Sets">
    public List<ItemPauta> getListaItensPauta() {
        return listaItensPauta;
    }

    public void setListaItensPauta(List<ItemPauta> listaItensPauta) {
        this.listaItensPauta = listaItensPauta;
    }

    public String getDescReuniao() {
        return descReuniao;
    }

    public void setDescReuniao(String descReuniao) {
        this.descReuniao = descReuniao;
    }

    public String getDescItemPauta() {
        return descItemPauta;
    }

    public void setDescItemPauta(String descItemPauta) {
        this.descItemPauta = descItemPauta;
    }

    public String getRelator() {
        return relator;
    }

    public void setRelator(String relator) {
        this.relator = relator;
    }

    public ItemPauta getItemPautaSelecionado() {
        return itemPautaSelecionado;
    }

//</editor-fold>
}
