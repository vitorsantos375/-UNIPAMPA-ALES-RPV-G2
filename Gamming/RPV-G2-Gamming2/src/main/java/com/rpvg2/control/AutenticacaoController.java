/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.control;

import com.rpvg2.model.Usuario;
import com.rpvg2.model.repository.UsuarioRepository;
import com.rpvg2.view.MensagensView;
import com.rpvg2.excecoes.UserNotFound;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guilherm Bolfe
 */
@ManagedBean
@SessionScoped
public class AutenticacaoController implements Serializable {

    private String user;
    private String pass;
    private Usuario usuario;
    private MensagensView mensagensView;
    private UsuarioRepository UserREP;

    public AutenticacaoController() {
        this.user = "";
        this.pass = "";
        this.mensagensView = new MensagensView();
        this.UserREP = new UsuarioRepository();
        this.usuario = null;
    }

    public void login() throws IOException {
        try {
            this.usuario = this.UserREP.verificalogin(user, pass);
            FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        } catch (SQLException | ClassNotFoundException | UserNotFound ex) {
            this.mensagensView.criarMensagemWarn(ex.getMessage());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
