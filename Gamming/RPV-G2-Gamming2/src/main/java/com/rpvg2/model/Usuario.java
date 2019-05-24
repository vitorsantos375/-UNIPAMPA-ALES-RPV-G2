/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model;

import com.rpvg2.util.StringUtil;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Guilherm Bolfe
 */
@ManagedBean
@SessionScoped
public class Usuario implements Serializable {

    private String nome;
    private int id;
    private boolean secretario;
    private boolean membro;
    private boolean moderador;

    public Usuario() {
    }

    public boolean isSecretario() {
        return secretario;
    }

    public void setSecretario(boolean secretario) {
        this.secretario = secretario;
    }

    public boolean isMembro() {
        return membro;
    }

    public void setMembro(boolean membro) {
        this.membro = membro;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (StringUtil.verificaStringVazia(nome)) {
            throw new IllegalArgumentException("O nome não pode ser vazio!");
        }
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
