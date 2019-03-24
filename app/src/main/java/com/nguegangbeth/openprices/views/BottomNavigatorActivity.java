package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.nguegangbeth.openprices.R;

import static android.view.View.INVISIBLE;

public class BottomNavigatorActivity extends AppCompatActivity implements MesProduits_frag.OnFragmentInteractionListener,
        Brouillons_frag.OnFragmentInteractionListener,Adresse_frag.OnFragmentInteractionListener, Gestionnaire_frag.OnFragmentInteractionListener
        ,TousProduit_frag.OnFragmentInteractionListener, Promotions_frag.OnFragmentInteractionListener, Favoris_frag.OnFragmentInteractionListener{

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private FloatingActionButton floatingActionButton;

    private  MarketFragment marketFragment;
    private UserConnectFragment userConnectFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigator);

        Init();

        setFragment(userConnectFragment);
        floatingActionButton.setVisibility(INVISIBLE);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               // setFragment(userConnectFragment);
                switch (menuItem.getItemId()) {
                    case R.id.nav_accueil:
                        setFragment(userConnectFragment);
                        floatingActionButton.setVisibility(INVISIBLE);
                        return true;
                    case R.id.nav_espacetravail:
                        setFragment(marketFragment);
                        floatingActionButton.setVisibility(View.VISIBLE);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    private void Init(){

        frameLayout = (FrameLayout)findViewById(R.id.framelayout_market);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_nav_market);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.flotting_button_botnav);
        marketFragment = new MarketFragment();
        userConnectFragment = new UserConnectFragment();
    }



    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_market, fragment);
        fragmentTransaction.commit();
    }
    public void onDestroy() {
        System.out.println("BottomNavigatorActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("BottomNavigatorActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("BottomNavigatorActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("BottomNavigatorActivity::onRestart");
        super.onRestart();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}

