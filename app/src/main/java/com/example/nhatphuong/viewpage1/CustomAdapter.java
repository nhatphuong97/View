package com.example.nhatphuong.viewpage1;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class CustomAdapter extends FragmentPagerAdapter {
    private String Name[] ={
            "Tab1","Tab2"
    };
    public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
        super(supportFragmentManager);
    }
    @Override
    public int getCount() {
        return Name.length;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragment1();
            case 1:
                return new fragment2();


            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
     //   return super.getPageTitle(position);
        return Name[position];
    }


}
