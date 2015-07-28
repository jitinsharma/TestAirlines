package com.example.jitin.testairlines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyTrips extends Fragment {
    private RecyclerView recyclerView;
    private TripAdapter tripAdapter;

    public MyTrips() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootTrips = inflater.inflate(R.layout.fragment_my_trips, container, false);
        recyclerView = (RecyclerView)rootTrips.findViewById(R.id.tripListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        tripAdapter = new TripAdapter(TripDataManager.getInstance().getTrips());
        recyclerView.setAdapter(tripAdapter);

        //Code for catching back button click and redirecting to home page
        rootTrips.setFocusableInTouchMode(true);
        rootTrips.requestFocus();
        rootTrips.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        Fragment fragment = new Home();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager
                                .beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.container, fragment)
                                .commit();
                        return true;
                    }
                }
                return false;
            }
        });
        return rootTrips;
    }
}