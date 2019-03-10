package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

public class QuestionActivity extends AppCompatActivity {

    private TextView textView_OUI;
    private TextView textView_NON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Init();

        textView_NON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, Creer_compte_userActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Init(){
        textView_NON = (TextView)findViewById(R.id.textView_NON);
        textView_OUI = (TextView)findViewById(R.id.textView_OUI);
    }

    @Override
    public void onDestroy() {
        System.out.println("QuestionActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("QuestionActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("QuestionActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("QuestionActivity::onRestart");
        super.onRestart();
    }
}
