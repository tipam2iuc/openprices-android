package com.nguegangbeth.openprices.views;

import android.net.Uri;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.TableLayout;

import com.nguegangbeth.openprices.R;

import static android.support.design.widget.TabLayout.*;

public class User_connectActivity extends AppCompatActivity implements TousProduit_frag.OnFragmentInteractionListener,
  Promotions_frag.OnFragmentInteractionListener,Favoris_frag.OnFragmentInteractionListener{

    private TabLayout tabLayout;
    private  SpannableString ss1;

    TabItem tab ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_connect);

        Init();

    }

    private void Init(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutUser);
        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPagerPagerUser);
        final PagerAdapter adapter = new PageAdapterUser(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    /**
     *
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDestroy() {
        System.out.println("User_connectActivity::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("User_connectActivity::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("User_connectActivity::onResume");
        super.onResume();
    }

    @Override
    public void onRestart() {
        System.out.println("User_connectActivity::onRestart");
        super.onRestart();
    }
}
