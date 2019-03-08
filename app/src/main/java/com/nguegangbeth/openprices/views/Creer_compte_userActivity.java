package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.controllers.Contole_User;

public class Creer_compte_userActivity extends AppCompatActivity {

    private EditText editText_nomprenom_user;
    private EditText editText_email_user;
    private EditText editText_motpasse_user;
    private EditText editText_confirmMotdepasse_user;
    private TextView textView_error_message;
    private Contole_User contole_user;
    private Button button_creer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte_user);
        this.contole_user = Contole_User.getInstance(this);
        Init();
        EcouteButtonCreer();
    }

    private void Init(){
        editText_confirmMotdepasse_user = (EditText)findViewById(R.id.editText_confirmMotPasse_user);
        editText_email_user = (EditText)findViewById(R.id.editText_email_user);
        editText_motpasse_user = (EditText)findViewById(R.id.editText_motPasse_user);
        editText_nomprenom_user = (EditText)findViewById(R.id.editText_nom_prenom_user);
        textView_error_message = (TextView) findViewById(R.id.textView_error_message);
        button_creer = (Button) findViewById(R.id.button_creer_user);
    }

    private void EcouteButtonCreer(){
        button_creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String motPasse = "" ;
                String confirmMotPasse = "" ;
                String email = "";
                String nomPrenom = "";
                try{
                    motPasse = editText_motpasse_user.getText().toString();
                    confirmMotPasse = editText_confirmMotdepasse_user.getText().toString();
                    email = editText_email_user.getText().toString();
                    nomPrenom = editText_nomprenom_user.getText().toString();

                }catch(Exception ex){
                    Toast.makeText(Creer_compte_userActivity.this, "Champ invalid", Toast.LENGTH_SHORT);
                }

                if(motPasse == "" || confirmMotPasse == ""|| email == ""||nomPrenom == ""){
                    textView_error_message.setText("Un ou plusieurs champ sont invalides!");
                }

                else{
                    /*if(motPasse != confirmMotPasse){
                    textView_error_message.setText("Les mots de passe ne correspondent pas");
                    }*/
                    //else{
                        contole_user.CreerUser(email, nomPrenom, motPasse, Creer_compte_userActivity.this);
                        Intent intent = new Intent(Creer_compte_userActivity.this, Interface_connexion_Activity.class);
                        startActivity(intent);
                    //}

                }

            }
        });
    }
}
