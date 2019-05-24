package com.rpv_g2.Present;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.rpv_g2.Interface.WebServiceConsumidor;
import com.rpv_g2.Model.Mensagem;
import com.rpv_g2.Model.WebServiceConnector;
import com.rpv_g2.Present.ViewHolder.TelaPrincipalHolder;


public class TelaPrincipalPst implements WebServiceConsumidor {

    private TelaPrincipalHolder telaPrincipalHolder;
    private WebServiceConnector service;
    private Activity activity;
    private Toast info;


    public TelaPrincipalPst(Activity activity) {
        this.telaPrincipalHolder = new TelaPrincipalHolder(activity);
        this.service = new WebServiceConnector(this);
        this.activity = activity;

        this.telaPrincipalHolder.setListenecerButton_Enviar(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMensagem();
            }
        });
    }


    public void enviarMensagem() {
        if (TextUtils.isEmpty(telaPrincipalHolder.getIput_Mensage())) {
            telaPrincipalHolder.exibirMensageInput_Eensagem("Digite algo!");
            return;
        }

        telaPrincipalHolder.setText_reposta("");
        telaPrincipalHolder.desabilitarButton_Enviar();

        service.getMensagem(new Mensagem(telaPrincipalHolder.getIput_Mensage()));
        exibirToast("Conectando-se ao servidor...", Toast.LENGTH_SHORT);
    }

    @Override
    public void receberRespostaWebService(Mensagem mensagem) {
        ocultarToast();

        String resposta = mensagem.getResposta();

        if (TextUtils.isEmpty(resposta) || resposta.equalsIgnoreCase("null")) {
            telaPrincipalHolder.setText_reposta("Nada encontrado =(");
        } else {
            telaPrincipalHolder.setText_reposta(resposta);
        }

        telaPrincipalHolder.habilitarButton_Enviar();
    }

    @Override
    public void receberFalhaWebService() {
        exibirToast("Erro ao conectar-se ao servidor!", Toast.LENGTH_LONG);

        telaPrincipalHolder.habilitarButton_Enviar();
    }

    private void exibirToast(String mensagem, int duracao) {
        ocultarToast();

        info = Toast.makeText(activity, mensagem, duracao);
        info.show();
    }

    private void ocultarToast() {
        if (info != null) {
            info.cancel();
        }
    }
}
