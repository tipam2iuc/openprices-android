package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.controllers.Contole_User;
import com.nguegangbeth.openprices.modeles.User;

public class Interface_connexion_Activity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private TextView invalid_identifier;
    private Button button_connexion;
    private Contole_User contole_user;

    private Integer authenticate;//change de valeur si l'utilisateur qui se connecte existe
    private String Email, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_connexion_);
        this.contole_user = Contole_User.getInstance(this);
        Init();
        EcouteButtonConnexion();
    }

    private void Init(){
        email = (EditText)findViewById(R.id.editText_email_connect);
        password = (EditText)findViewById(R.id.editText_motpasse_connect);
        invalid_identifier = (TextView)findViewById(R.id.textView_invalid_identifiant);
        button_connexion = (Button)findViewById(R.id.button_connexion);
    }

    private void EcouteButtonConnexion(){
        button_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Email = email.getText().toString();
                    Password = password.getText().toString();
                    for(User user:contole_user.getLesUsers()){
                        if(Email.equals(user.getEMAIL()) == true && Password.equals(user.getMotPasse())){
                            authenticate=1;
                        }
                    }

                    if(authenticate == 1){
                        Intent intent = new Intent(Interface_connexion_Activity.this, User_connectActivity.class);
                        startActivity(intent);
                    }else {
                            invalid_identifier.setText("Identifiant invalid");
                    }

                }catch (Exception ex){
                    ex.getMessage();
                }
            }
        });
    }
}
