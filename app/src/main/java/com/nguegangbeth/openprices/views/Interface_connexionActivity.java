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

public class Interface_connexionActivity extends AppCompatActivity {

    private  EditText email;
    private EditText password;
    private TextView invalid_identifier;
    private Contole_User contole_user;
    private Button button_connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_connexion);
        Init();
        EcouteButtonConnexion();

    }

    private void Init(){
        email = (EditText)findViewById(R.id.editText_email_connect);
        password = (EditText)findViewById(R.id.editText_motpasse_connect);
        invalid_identifier = (TextView)findViewById(R.id.textView_invalid_identifiant);
        this.contole_user = Contole_User.getInstance(this);
        button_connexion = (Button)findViewById(R.id.button_connexion_connect);
    }

    private void EcouteButtonConnexion(){
        button_connexion.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Interface_connexionActivity.this, User_connectActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        System.out.println("Interface_connexionActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("Interface_connexionActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("Interface_connexionActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("Interface_connexionActivity::onRestart");
        super.onRestart();
    }
}
