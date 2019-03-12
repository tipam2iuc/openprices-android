package com.nguegangbeth.openprices.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterMarket extends FragmentStatePagerAdapter {


    int NumOfTabs;
    public  PageAdapterMarket(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.NumOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch(i){

            case 0:
                MesProduits_frag mesProduits_frag  = new MesProduits_frag();
                return mesProduits_frag;
            case 1:
                Brouillons_frag brouillons_frag = new Brouillons_frag();
                return  brouillons_frag;
            case 2:
                Adresse_frag adresse_frag = new Adresse_frag();
                return adresse_frag;
            case 3:
                Gestionnaire_frag gestionnaire_frag = new Gestionnaire_frag();
                return gestionnaire_frag;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
