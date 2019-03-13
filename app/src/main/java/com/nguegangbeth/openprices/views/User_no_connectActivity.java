package com.nguegangbeth.openprices.views;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nguegangbeth.openprices.R;

public class User_no_connectActivity extends AppCompatActivity implements TousProduit_frag.OnFragmentInteractionListener{

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_no_connect);
    }

    @Override
    public void onDestroy() {
        System.out.println("User_no_connectActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("User_no_connectActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("User_no_connectActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("User_no_connectActivity::onRestart");
        super.onRestart();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
