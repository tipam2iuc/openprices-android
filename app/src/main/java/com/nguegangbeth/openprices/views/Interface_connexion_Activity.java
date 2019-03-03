package com.nguegangbeth.openprices.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nguegangbeth.openprices.R;

public class Interface_connexion_Activity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button button_connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_connexion_);
        Init();
    }

    private void Init(){
        email = (EditText)findViewById(R.id.editText_email_connect);
        password = (EditText)findViewById(R.id.editText_motpasse_connect);
        button_connexion = (Button)findViewById(R.id.button_connexion);
    }

    private void EcouteButtonConnexion(){
        button_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
