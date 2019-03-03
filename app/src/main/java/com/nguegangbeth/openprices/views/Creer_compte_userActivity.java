package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nguegangbeth.openprices.R;

public class Creer_compte_userActivity extends AppCompatActivity {

    private EditText editText_nomprenom_user;
    private EditText editText_email_user;
    private EditText editText_motpasse_user;
    private EditText editText_confirmMotdepasse_user;
    private Button button_creer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte_user);
        Init();
        EcouteButtonCreer();
    }

    private void Init(){
        editText_confirmMotdepasse_user = (EditText)findViewById(R.id.editText_confirmMotPasse_user);
        editText_email_user = (EditText)findViewById(R.id.editText_email_user);
        editText_motpasse_user = (EditText)findViewById(R.id.editText_motPasse_user);
        editText_nomprenom_user = (EditText)findViewById(R.id.editText_nom_prenom_user);
        button_creer = (Button) findViewById(R.id.button_creer_user);
    }

    private void EcouteButtonCreer(){
        button_creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Creer_compte_userActivity.this, Interface_connexion_Activity.class);
                startActivity(intent);
            }
        });
    }
}
