package com.rpv_g2.Interface;

import com.rpv_g2.Model.Mensagem;

public interface WebServiceConsumidor {
    public void receberRespostaWebService(Mensagem resposta);
    public void receberFalhaWebService();
}
