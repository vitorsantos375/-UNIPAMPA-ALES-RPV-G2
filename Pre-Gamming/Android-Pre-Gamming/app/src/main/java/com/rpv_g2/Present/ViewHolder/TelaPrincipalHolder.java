package com.rpv_g2.Present.ViewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rpv_g2.R;

public class TelaPrincipalHolder {

    private TextView text_reposta;
    private Button button_enviar;
    private EditText input_mensagem;
    private Activity activity;

    public TelaPrincipalHolder(Activity activity) {
        this.text_reposta = activity.findViewById(R.id.text_reposta);
        this.button_enviar = activity.findViewById(R.id.button_enviar);
        this.input_mensagem = activity.findViewById(R.id.input_mensagem);
        this.activity = activity;
    }

    public void setText_reposta(final String string) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_reposta.setText(string);
            }
        });
    }


    public String getIput_Mensage() {
        return input_mensagem.getText().toString();
    }

    public void setListenecerButton_Enviar(View.OnClickListener onClickListener) {
        this.button_enviar.setOnClickListener(onClickListener);
    }

    public void desabilitarButton_Enviar() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button_enviar.setEnabled(false);
                button_enviar.setClickable(false);
            }
        });
    }

    public void habilitarButton_Enviar() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button_enviar.setEnabled(true);
                button_enviar.setClickable(true);
            }
        });
    }

    public void exibirMensageInput_Eensagem(final String mensagem) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                input_mensagem.setError(mensagem);
            }
        });
    }
}
