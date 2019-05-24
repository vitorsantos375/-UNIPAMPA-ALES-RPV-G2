package com.rpvg2.model;

import com.rpvg2.util.StringUtil;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Giliardi Schmidt
 */
@ManagedBean
@ApplicationScoped
public final class ItemPauta {

    private int id;
    private String descricao;
    private Relator relator;
    private boolean votada;

    public ItemPauta() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (StringUtil.verificaStringVazia(descricao)) {
            throw new IllegalArgumentException("A descrição não pode ser vazia");
        }
        this.descricao = descricao;
    }

    public Relator getRelator() {
        return relator;
    }

    public void setRelator(Relator relator) {
        if (relator == null) {
            throw new IllegalArgumentException("O relator não pode ser null");
        }
        this.relator = relator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVotada() {
        return votada;
    }

    public void setVotada(boolean votada) {
        this.votada = votada;
    }

}
