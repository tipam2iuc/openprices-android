package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

public class ChoixConnexionActivity extends AppCompatActivity {

    private Button button_facebook;
    private Button button_linkedin;
    private Button button_google;
    private Button button_inscription;
    private Button button_connexion;
    private CheckBox checkBox_terme;
    private TextView textView_passer;
    private TextView textView_termes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_connexion);
        Init();
        textView_passer.setEnabled(false);

        checkBox_terme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    textView_passer.setTextColor(getResources().getColor(R.color.violetFonce));
                    textView_passer.setEnabled(true);
                }else{
                    textView_passer.setTextColor(getResources().getColor(R.color.darkGray));
                    textView_passer.setEnabled(false);
                }

            }
        });

        EcouteTextViewPasser();

    }

    private void Init(){
        button_connexion = (Button)findViewById(R.id.button_connexion);
        button_facebook = (Button)findViewById(R.id.button_facebook);
        button_linkedin = (Button)findViewById(R.id.button_linkedin);
        button_google = (Button)findViewById(R.id.button_google);
        button_inscription = (Button)findViewById(R.id.button_inscription);
        checkBox_terme = (CheckBox)findViewById(R.id.checkBox_terme);
        textView_passer = (TextView) findViewById(R.id.textView_passer);
        textView_termes = (TextView) findViewById(R.id.textView_termes);
    }

    private void EcouteTextViewPasser(){
        ((TextView)findViewById(R.id.textView_passer)).setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChoixConnexionActivity.this, User_no_connectActivity.class);
                startActivity(intent);
            }
        });
    }

}
