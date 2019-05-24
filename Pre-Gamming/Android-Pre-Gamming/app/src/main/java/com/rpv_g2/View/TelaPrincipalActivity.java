package com.rpv_g2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rpv_g2.Present.TelaPrincipalPst;
import com.rpv_g2.R;

public class TelaPrincipalActivity extends AppCompatActivity {

    private TelaPrincipalPst telaPrincipalPst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        this.telaPrincipalPst = new TelaPrincipalPst(this);
    }
}
