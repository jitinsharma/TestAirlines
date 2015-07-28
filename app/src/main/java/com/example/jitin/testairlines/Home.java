package com.example.jitin.testairlines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootHome = inflater.inflate(R.layout.fragment_home, container, false);
        Button homeBooking = (Button)rootHome.findViewById(R.id.homeBooking);
        Button homeCheckIn = (Button)rootHome.findViewById(R.id.homeCheckin);
        Button homeMyTrips = (Button)rootHome.findViewById(R.id.homeTrips);

        final Fragment fragmentBook = new BookPage();
        final Fragment fragmentCheckIn = new Checkin();
        final Fragment fragmentTrips = new MyTrips();
        final FragmentManager fragmentManager = getFragmentManager();

        homeBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.container, fragmentBook)
                        .commit();
            }
        });

        homeCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.container, fragmentCheckIn)
                        .commit();
            }
        });

        homeMyTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.container, fragmentTrips)
                        .commit();
            }
        });
        //ViewPager viewPager = (ViewPager)rootHome.findViewById(R.id.homePager);
        //viewPager.setAdapter(new SampleFragmentPagerAdapter(getActivity().getSupportFragmentManager()));
        return rootHome;
    }

    /*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.homePager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getActivity().getSupportFragmentManager()));
    }

    public class SampleFragmentPagerAdapter extends FragmentStatePagerAdapter {
        final int PAGE_COUNT = 2;
        private String tabTitles[] = new String[]{"Departure", "Return"};

        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            //super(getActivity().getSupportFragmentManager());
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            //return PageFragment.create(position + 1);
            switch (position) {

// Open FragmentTab1.java
                case 0:
                    return new FromSearchFlights();

// Open FragmentTab2.java
                case 1:
                    return new ReturnSearchFlights();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }*/
    /*public static class PageFragment extends Fragment {
        public static final String ARG_PAGE = "ARG_PAGE";

        private int mPage;

        public static PageFragment create(int page) {
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, page);
            PageFragment fragment = new PageFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPage = getArguments().getInt(ARG_PAGE);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_page, container, false);
            TextView textView = (TextView) view;
            textView.setText("Fragment #" + mPage);
            return view;
        }
    }*/
}