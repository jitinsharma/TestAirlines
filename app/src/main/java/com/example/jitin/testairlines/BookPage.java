package com.example.jitin.testairlines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookPage extends Fragment {


    public BookPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootBookPage = inflater.inflate(R.layout.fragment_book_page, container, false);
        ViewPager viewPager = (ViewPager)rootBookPage.findViewById(R.id.homePager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getActivity().getSupportFragmentManager()));


        //Code for catching back button click and redirecting to home page
        rootBookPage.setFocusableInTouchMode(true);
        rootBookPage.requestFocus();
        rootBookPage.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        Fragment fragment = new Home();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager
                                .beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.container,fragment)
                                .commit();
                        //fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).show(fragment).commit();
                        return true;
                    }
                }
                return false;
            }
        });
        return rootBookPage;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.homePager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getActivity().getSupportFragmentManager()));
    }

    public class SampleFragmentPagerAdapter extends FragmentStatePagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[]{"One Way","Return","Multi City"};

        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            //super(getActivity().getSupportFragmentManager());
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            //return PageFragment.create(position + 1);
            switch (position) {

                case 0:
                    return new OneWayBooking();

// Open FragmentTab1.java
                case 1:
                    return new Booking();

// Open FragmentTab2.java
                case 2:
                    return new MultiCityBooking();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }

    /*@Override
    public void onBackPressed(){
        Fragment fragment = new Home();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,fragment);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            return true;
        }
        return super.getActivity().onKeyDown(keyCode, event);
    }*/
}
