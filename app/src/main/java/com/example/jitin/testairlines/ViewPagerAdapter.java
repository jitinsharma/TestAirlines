package com.example.jitin.testairlines;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jitin on 29-03-2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    // Tab Titles
    private String tabTitles[] = new String[]{"Departure", "Return"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

// Open FragmentTab1.java
            case 0:
                //FromSearchFlights fragmenttab1 = new FromSearchFlights();
                //return fragmenttab1;
                return new FromSearchFlights();

// Open FragmentTab2.java
            case 1:
                //ReturnSearchFlights fragmenttab2 = new ReturnSearchFlights();
                //return fragmenttab2;
                return new ReturnSearchFlights();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
