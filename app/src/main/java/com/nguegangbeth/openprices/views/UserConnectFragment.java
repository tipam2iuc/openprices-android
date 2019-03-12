package com.nguegangbeth.openprices.views;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguegangbeth.openprices.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserConnectFragment extends Fragment implements TousProduit_frag.OnFragmentInteractionListener,
        Promotions_frag.OnFragmentInteractionListener,Favoris_frag.OnFragmentInteractionListener{

    private TabLayout tabLayout;

    public UserConnectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_connect, container, false);
        Init(view);
        return view;
    }

    private void Init(View view){
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayoutUser);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewPagerPagerUser);
        final PagerAdapter adapter = new PageAdapterUser(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDestroy() {
        System.out.println("UserConnectFragment::onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        System.out.println("UserConnectFragment::onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        System.out.println("UserConnectFragment::onResume");
        super.onResume();
    }


}
