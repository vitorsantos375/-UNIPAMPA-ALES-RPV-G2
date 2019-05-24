/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvgrupo2.jsf.pre.gamming.model;

/**
 *
 * @author Guilherm Bolfe
 */
public class Mensagem {

    private String mensagem;
    private String resposta;
    private boolean ocorreuErro;

    public Mensagem() {
        this.mensagem = "";
        this.ocorreuErro = false;
        this.resposta = "";
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getResposta() {
        return resposta;
    }

    public boolean isOcorreuErro() {
        return ocorreuErro;
    }

    public void setOcorreuErro(boolean ocorreuErro) {
        this.ocorreuErro = ocorreuErro;
    }

}
