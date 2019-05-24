package com.rpv_g2.Model;


import android.util.Log;
import com.rpv_g2.Interface.WebServiceConsumidor;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class WebServiceConnector {
    private OkHttpClient service;
    private WebServiceConsumidor consumidor;

    public WebServiceConnector(WebServiceConsumidor consumidor) {
        this.consumidor = consumidor;
        this.service = new OkHttpClient();
    }

    public void getMensagem(final Mensagem mensagem) {
        RequestBody formBody = new FormBody.Builder()
                .add("name", mensagem.getMensagem())
                .build();

        //IP para o webservice precisa ser configurado manualmente
        final Request request = new Request.Builder()
                .url("http://192.168.0.107:8080/greeting")
                .post(formBody)
                .build();

        service.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, e.getMessage());
                System.out.println(e.getMessage());
                consumidor.receberFalhaWebService();
            }

            @Override
            public void onResponse(Call call, Response response) {
                String resposta = "";
                try {
                    JSONObject o = new JSONObject(response.body().string());

                    resposta = o.getString("content");

                    mensagem.setOcorreuErro(false);
                    mensagem.setReposta(resposta);
                } catch (Exception e) {
                    mensagem.setOcorreuErro(true);
                    Log.e(TAG, e.getMessage());
                }

                Log.i(TAG, resposta);

                consumidor.receberRespostaWebService(mensagem);
            }
        });
    }
}
