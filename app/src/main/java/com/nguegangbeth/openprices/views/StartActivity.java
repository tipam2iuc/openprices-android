package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

public class StartActivity extends AppCompatActivity {
    private TextView textView_welcome;
    private ImageView imageView;
    private Button button_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SavePreferences();

        if(StartActShow()){
            startActivity(new Intent(StartActivity.this, BottomNavigatorActivity.class));
            finish();
        }
        setContentView(R.layout.activity_start);
        button_continue = (Button)findViewById(R.id.button_continue);
        textView_welcome = (TextView)findViewById(R.id.textView_welcome);
        EcoutButtonContinue();
    }

     private void EcoutButtonContinue(){
        ((Button)findViewById(R.id.button_continue)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(StartActivity.this, DescriptionActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private boolean StartActShow(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        return sharedPreferences.getBoolean("AlreadyOpenIntro", false);
    }

    private void SavePreferences(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        preferences.getBoolean("AlreadyOpenIntro", true);
        editor.apply();
        editor.commit();
    }

    @Override
    public void onDestroy() {
        System.out.println("StartActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("StartActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("StartActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("StartActivity::onRestart");
        super.onRestart();
        Intent intent = new Intent(StartActivity.this, BottomNavigatorActivity.class);
        startActivity(intent);
    }

}
