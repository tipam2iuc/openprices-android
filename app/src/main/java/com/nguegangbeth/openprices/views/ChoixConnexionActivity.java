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
    private Button button_google;
    private CheckBox checkBox_terme;
    private TextView textView_passer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_connexion);
        Init();

        button_google.setEnabled(false);

        button_facebook.setEnabled(false);

        textView_passer.setEnabled(false);

        /**
         * Valide les boutons du formulaire que lorsaque l'utilisateur accepte les termes du contrat
         */
        checkBox_terme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView_passer.setTextColor(getResources().getColor(R.color.violetFonce));
                    textView_passer.setEnabled(true);
                    button_google.setEnabled(true);
                    button_facebook.setEnabled(true);
                }else{
                    textView_passer.setTextColor(getResources().getColor(R.color.darkGray));
                    textView_passer.setEnabled(false);
                    button_google.setEnabled(false);
                    button_facebook.setEnabled(false);
                }

            }
        });

        EcouteTextViewPasser();

    }

    /**
     * Jointure des boutons a mes membres
     */
    private void Init(){
        button_facebook = (Button)findViewById(R.id.button_facebook);
        button_google = (Button)findViewById(R.id.button_google);
        checkBox_terme = (CheckBox)findViewById(R.id.checkBox_terme);
        textView_passer = (TextView) findViewById(R.id.textView_passer);
    }

    /**
     * text permettant de passer l'inscription ou la connexion
     * utiliser par ceux qui ne veulent pas etre connecte
     */
    private void EcouteTextViewPasser(){
        textView_passer.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChoixConnexionActivity.this, User_no_connectActivity.class);
                startActivity(intent);
            }
        });
    }
}
