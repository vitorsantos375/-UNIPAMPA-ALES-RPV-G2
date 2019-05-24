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
public class Reuniao {

    private String descricao;
    private boolean aberta;
    private List<ItemPauta> itensPauta;
    private List<Usuario> membrosCadastrados;
    private List<Usuario> membrosRegistrados;

    public Reuniao(String descricao, boolean aberta, List<ItemPauta> itensPauta, List<Usuario> membros) {
        this.descricao = descricao;
        this.aberta = aberta;
        this.itensPauta = itensPauta;
        this.membrosCadastrados = membros;
        this.membrosRegistrados = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public List<ItemPauta> getEncaminhamentos() {
        return itensPauta;
    }

    public List<Usuario> getMembrosCadastrados() {
        return membrosCadastrados;
    }

    public void setItensPauta(List<ItemPauta> itensPauta) {
        this.itensPauta = itensPauta;
    }

    public void setMembrosCadastrados(List<Usuario> membros) {
        this.membrosCadastrados = membros;
    }

    public List<Usuario> getMembrosRegistrados() {
        return membrosRegistrados;
    }

    public void setMembrosRegistrados(List<Usuario> membrosRegistrados) {
        this.membrosRegistrados = membrosRegistrados;
    }
    
    
    

}
