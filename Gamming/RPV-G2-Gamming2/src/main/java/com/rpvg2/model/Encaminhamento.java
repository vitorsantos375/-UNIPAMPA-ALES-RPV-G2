package com.rpvg2.model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Giliardi Schmidt
 */
@ManagedBean
@ApplicationScoped
public abstract class Encaminhamento {

    protected ItemPauta itemPauta;
    protected List<OpcaoVoto> opcoesVoto;
    protected int id;

    public Encaminhamento() {
        this.opcoesVoto = new ArrayList<>();
    }

    public void setItemPauta(ItemPauta itemPauta) {
        if(itemPauta == null){
            throw new IllegalArgumentException("ItemPauta não pode ser null");
        }
        this.itemPauta = itemPauta;
    }

    public List<OpcaoVoto> getOpcoesVoto() {
        return opcoesVoto;
    }

    public ItemPauta getItemPauta() {
        return itemPauta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
