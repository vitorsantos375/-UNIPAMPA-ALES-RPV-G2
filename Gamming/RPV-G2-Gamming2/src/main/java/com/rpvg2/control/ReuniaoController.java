/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.control;

import com.rpvg2.model.Reuniao;
import com.rpvg2.model.repository.ReuniaoRepository;
import com.rpvg2.view.MensagensView;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guilherm Bolfe
 */
@ManagedBean
@SessionScoped
public class ReuniaoController implements Serializable {

    private ReuniaoRepository reuniaoREP;
    private List<Reuniao> reunioes;
    private MensagensView mensagens;

    public ReuniaoController() {
        this.reuniaoREP = new ReuniaoRepository();
        this.reunioes = new ArrayList<>();
        this.mensagens = new MensagensView();
    }

    public void selectReunioesSec(String secretario) {
        try {
            this.reunioes = this.reuniaoREP.recuperaPorSecretario(secretario);
        } catch (SQLException | ClassNotFoundException ex) {
            this.mensagens.criarMensagemError(ex.getMessage());
        }
    }

    public void selectReunioesMod(String moderador) {
        try {
            this.reunioes = this.reuniaoREP.recuperaPorMod(moderador);
        } catch (SQLException | ClassNotFoundException ex) {
            this.mensagens.criarMensagemError(ex.getMessage());
        }
    }

    public void abrirReuniao(String descReuniao) {
        try {
            this.getReuniaoREP().editaAberta(descReuniao);

            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            VotacaoController votacaoController = (VotacaoController) FacesContext.getCurrentInstance().getApplication()
                    .getELResolver().getValue(elContext, null, "votacaoController");

            votacaoController.setReuniao(reuniaoREP.recuperarPorDescricao(descReuniao).get(0));

        } catch (ClassNotFoundException | SQLException ex) {
            this.mensagens.criarMensagemError(ex.getMessage());
        }
    }

    public ReuniaoRepository getReuniaoREP() {
        return reuniaoREP;
    }

    public void setReuniaoREP(ReuniaoRepository reuniaoREP) {
        this.reuniaoREP = reuniaoREP;
    }

    public List<Reuniao> getReunioes() {
        return reunioes;
    }

    public void setReunioes(List<Reuniao> reunioes) {
        this.reunioes = reunioes;
    }

}
