package com.rpvg2.model;

import com.rpvg2.util.StringUtil;
import java.util.Objects;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Giliardi Schmidt
 */
@ManagedBean
@ApplicationScoped
public class OpcaoVoto {

    private int id;
    private String descricao;

    public OpcaoVoto() {
    }

    public OpcaoVoto(String descricao) {
        this.setDescricao(descricao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (StringUtil.verificaStringVazia(descricao)) {
            throw new IllegalArgumentException("A descrição não pode estar vazia!");
        }
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (descricao == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpcaoVoto other = (OpcaoVoto) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

}
