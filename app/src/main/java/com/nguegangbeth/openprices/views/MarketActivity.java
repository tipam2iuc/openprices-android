package com.nguegangbeth.openprices.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nguegangbeth.openprices.R;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }

    public void onDestroy() {
        System.out.println("MarketActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("MarketActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("MarketActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("MarketActivity::onRestart");
        super.onRestart();
    }
}
