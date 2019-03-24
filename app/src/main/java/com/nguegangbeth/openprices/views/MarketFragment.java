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
public class MarketFragment extends Fragment implements MesProduits_frag.OnFragmentInteractionListener,
        Brouillons_frag.OnFragmentInteractionListener,Adresse_frag.OnFragmentInteractionListener, Gestionnaire_frag.OnFragmentInteractionListener{


    public MarketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market, container, false);
        Init(view);
        return view;

    }

    private void Init(View view){

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
    public void onFragmentInteraction(Uri uri) {

    }
}
