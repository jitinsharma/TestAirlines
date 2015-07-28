package com.example.jitin.testairlines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

/**
 * Created by jitin on 02-05-2015.
 */
public class OneWayBooking extends Fragment {


    public OneWayBooking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootOneWayBook = inflater.inflate(R.layout.fragment_booking, container, false);
        RelativeLayout returnDateBtn = (RelativeLayout)rootOneWayBook.findViewById(R.id.returnDateLayout);
        Button bookingBtn = (Button)rootOneWayBook.findViewById(R.id.searchButton);

        returnDateBtn.setVisibility(View.GONE);

        Spinner spinnerAdult = (Spinner)rootOneWayBook.findViewById(R.id.adultList);
        Spinner spinnerChild = (Spinner)rootOneWayBook.findViewById(R.id.childList);
        Spinner spinnerInfant = (Spinner)rootOneWayBook.findViewById(R.id.infantList);
        Spinner spinnerClass = (Spinner)rootOneWayBook.findViewById(R.id.cabinClass);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterAdult = ArrayAdapter.createFromResource(getActivity(),
                R.array.adult_child_array, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapterInfant = ArrayAdapter.createFromResource(getActivity(),
                R.array.infant_array, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapterClass = ArrayAdapter.createFromResource(getActivity(),
                R.array.cabin_class, android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        adapterAdult.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterInfant.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        spinnerAdult.setAdapter(adapterAdult);
        spinnerChild.setAdapter(adapterInfant);
        spinnerInfant.setAdapter(adapterInfant);
        spinnerClass.setAdapter(adapterClass);

        bookingBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(),SearchFlights.class);
                startActivity(intent);
            }
        });

        return rootOneWayBook;
    }
}