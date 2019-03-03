package com.nguegangbeth.openprices.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.nguegangbeth.openprices.R;

public class Creer_compte_userActivity extends AppCompatActivity {

    private EditText editText_nomprenom_user;
    private EditText editText_email_user;
    private EditText editText_motpasse_user;
    private EditText editText_confirmMotdepasse_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte_user);
        Init();
    }

    private void Init(){
        editText_confirmMotdepasse_user = (EditText)findViewById(R.id.editText_confirmMotPasse_user);
        editText_email_user = (EditText)findViewById(R.id.editText_email_user);
        editText_motpasse_user = (EditText)findViewById(R.id.editText_motPasse_user);
        editText_nomprenom_user = (EditText)findViewById(R.id.editText_nom_prenom_user);
    }
}
