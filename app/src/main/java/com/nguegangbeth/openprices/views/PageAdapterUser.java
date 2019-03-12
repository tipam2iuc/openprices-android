package com.nguegangbeth.openprices.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Switch;

public class PageAdapterUser extends FragmentStatePagerAdapter {

    int NumOfTabs;
    public  PageAdapterUser(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.NumOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch(i){

            case 0:
                TousProduit_frag tousProduit_frag = new TousProduit_frag();
                return tousProduit_frag;
            case 1:
                Promotions_frag promotions_frag = new Promotions_frag();
                return  promotions_frag;
            case 2:
                Favoris_frag favoris_frag = new Favoris_frag();
                return favoris_frag;
             default:
                 return null;
        }
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
