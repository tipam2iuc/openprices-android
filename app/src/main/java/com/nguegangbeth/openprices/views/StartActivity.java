package com.nguegangbeth.openprices.views;

import android.content.Intent;
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
        setContentView(R.layout.activity_start);
        Init();
        EcoutButtonContinue();
    }

    private void Init(){
        button_continue = (Button)findViewById(R.id.button_continue);
        textView_welcome = (TextView)findViewById(R.id.textView_welcome);

    }
     private void EcoutButtonContinue(){
        ((Button)findViewById(R.id.button_continue)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(StartActivity.this, DescriptionActivity.class);
                startActivity(intent);
            }
        });
    }

}
