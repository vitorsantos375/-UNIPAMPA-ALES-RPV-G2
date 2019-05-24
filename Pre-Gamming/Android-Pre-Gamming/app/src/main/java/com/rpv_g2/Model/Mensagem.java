package com.rpv_g2.Model;

public class Mensagem {

    private String mensagem;
    private String resposta;
    private boolean ocorreuErro;

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
        this.resposta = "";
        this.ocorreuErro = false;
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

    public void setReposta(String resposta) {
        this.resposta = resposta;
    }
}
