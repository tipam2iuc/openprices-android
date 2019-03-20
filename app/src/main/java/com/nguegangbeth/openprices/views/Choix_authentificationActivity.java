package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

public class Choix_authentificationActivity extends AppCompatActivity {

    private Button button_continue;
    private Button button_seconnecter;
    private TextView textView_sinscrire;
    private TextView textView_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_authentification);
        Init();

        button_seconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_authentificationActivity.this, Interface_connexionActivity.class);
                startActivity(intent);
            }
        });

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_authentificationActivity.this, Interface_connexionActivity.class);
                startActivity(intent);
            }
        });

        textView_sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_authentificationActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Init(){
        button_continue = (Button)findViewById(R.id.button_continue_CCA);
        button_seconnecter = (Button)findViewById(R.id.button_seconnecter_CCA);
        textView_sinscrire = (TextView)findViewById(R.id.textview_s_inscrire_CCA);
    }
}
