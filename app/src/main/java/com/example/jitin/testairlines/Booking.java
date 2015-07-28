package com.example.jitin.testairlines;


import android.animation.LayoutTransition;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Booking extends Fragment {
    private static TextView yearText;
    private static TextView monthText;
    private static TextView dateText;

    public Booking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View booking = inflater.inflate(R.layout.fragment_booking, container, false);
        Button centerBtn = (Button) booking.findViewById(R.id.centerBtn);
        Button bookingBtn = (Button)booking.findViewById(R.id.searchButton);
        final Button fromBtn = (Button) booking.findViewById(R.id.fromBtn);
        final Button toBtn = (Button) booking.findViewById(R.id.toBtn);
        //Button dateBtn = (Button) booking.findViewById(R.id.dateButton);
        RelativeLayout onwardDateBtn = (RelativeLayout)booking.findViewById(R.id.onwardDateLayout);
        final RelativeLayout returnDateBtn = (RelativeLayout)booking.findViewById(R.id.returnDateLayout);
        //yearText = (TextView) booking.findViewById(R.id.date);
        monthText = (TextView)booking.findViewById(R.id.onwardMonth);
        dateText = (TextView)booking.findViewById(R.id.onwardDate);
        //final Button addButton = (Button)booking.findViewById(R.id.addCity);
        //addButton.setVisibility(View.GONE);

        //final RadioButton oneWayButton = (RadioButton)booking.findViewById(R.id.oneWay);
        //RadioButton returnWayButton = (RadioButton)booking.findViewById(R.id.returnWay);

        Calendar c = Calendar.getInstance();

        SimpleDateFormat sdf_month = new SimpleDateFormat("MMM");
        String month_name = sdf_month.format(c.getTime());
        monthText.setText(month_name);

        SimpleDateFormat sdf_date = new SimpleDateFormat("dd");
        String date_name = sdf_date.format(c.getTime());
        dateText.setText(date_name);

        centerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) fromBtn.getLayoutParams();
                RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) toBtn.getLayoutParams();

                fromBtn.setLayoutParams(params2);
                toBtn.setLayoutParams(params1);

                /// Create Intent for AnimalListActivity and Start The Activity

            }
        });

        onwardDateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        fromBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Fragment fragment2 = new FromSearch();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
                fragmentTransaction.replace(R.id.container, fragment2);
                fragmentTransaction.commit();
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            }
        });

        bookingBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(),SearchFlights.class);
                startActivity(intent);
            }
        });

        Spinner spinnerAdult = (Spinner)booking.findViewById(R.id.adultList);
        Spinner spinnerChild = (Spinner)booking.findViewById(R.id.childList);
        Spinner spinnerInfant = (Spinner)booking.findViewById(R.id.infantList);
        Spinner spinnerClass = (Spinner)booking.findViewById(R.id.cabinClass);

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

        /*oneWayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                    //addButton.setVisibility(View.GONE);
                *//*TranslateAnimation animate = new TranslateAnimation(0,returnDateBtn.getWidth(),0,0);
                animate.setDuration(500);
                animate.setFillAfter(true);
                returnDateBtn.startAnimation(animate);*//*
                returnDateBtn.setVisibility(View.GONE);

            }
        });*/

        /*returnWayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //addButton.setVisibility(View.GONE);
                returnDateBtn.setVisibility(View.VISIBLE);

            }
        });*/

        /*addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                RelativeLayout firstHidden = (RelativeLayout)booking.findViewById(R.id.hiddenFirst);
                RelativeLayout multiCityFirst = (RelativeLayout)booking.findViewById(R.id.multiCity1);
                View hideView = getActivity().getLayoutInflater().inflate(R.layout.multi_city_first,multiCityFirst,false);
                multiCityFirst.addView(hideView);
            }
        });*/
        return booking;

    }
    /*public void populateSetDate(int year, int month, int day) {
        Output.setText(month+"/"+day+"/"+year);
    }
    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }*/

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        //private TextView Output;


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

// Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar c = Calendar.getInstance();
            c.set(year, month, day);
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
            String formattedDate = sdf.format(c.getTime());
            //yearText.setText(formattedDate);

            SimpleDateFormat sdf_month = new SimpleDateFormat("MMM");
            String month_name = sdf_month.format(c.getTime());
            monthText.setText(month_name);

            SimpleDateFormat sdf_date = new SimpleDateFormat("dd");
            String date_name = sdf_date.format(c.getTime());
            dateText.setText(date_name);

            SimpleDateFormat sdf_year = new SimpleDateFormat("yy");
            String year_name = sdf_year.format(c.getTime());
        }
    }
}