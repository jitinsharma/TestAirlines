package com.example.jitin.testairlines;


import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class MultiCityBooking extends Fragment {
    int i=0;


    public MultiCityBooking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootMultiCity = inflater.inflate(R.layout.fragment_multi_city_booking, container, false);
        final LayoutTransition transition = new LayoutTransition();

        //RelativeLayout firstHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenFirst);
        //RelativeLayout secondHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenSecond);
        //RelativeLayout thirdHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenThird);

        final RelativeLayout multiCityFirst = (RelativeLayout) rootMultiCity.findViewById(R.id.multiCity1);
        final RelativeLayout multiCitySecond = (RelativeLayout) rootMultiCity.findViewById(R.id.multiCity2);
        final RelativeLayout multiCityThird = (RelativeLayout) rootMultiCity.findViewById(R.id.multiCity3);

        final Button addButton = (Button)rootMultiCity.findViewById(R.id.addCity);
        final Button removeButton = (Button)rootMultiCity.findViewById(R.id.removeCity);
        Button centerButton = (Button)rootMultiCity.findViewById(R.id.centerBtn);

        removeButton.setVisibility(View.GONE);

        Spinner spinnerAdult = (Spinner)rootMultiCity.findViewById(R.id.multiCityAdultList);
        Spinner spinnerChild = (Spinner)rootMultiCity.findViewById(R.id.multiCityChildList);
        Spinner spinnerInfant = (Spinner)rootMultiCity.findViewById(R.id.multiCityInfantList);
        Spinner spinnerClass = (Spinner)rootMultiCity.findViewById(R.id.multiCityCabinClass);

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

        /*RelativeLayout firstHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenFirst);
                RelativeLayout multiCityFirst = (RelativeLayout)rootMultiCity.findViewById(R.id.multiCity1);
                View hideView = getActivity().getLayoutInflater().inflate(R.layout.multi_city_first,multiCityFirst,false);
                multiCityFirst.addView(hideView);*/

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //int i=0;
                RelativeLayout firstHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenFirst);
                RelativeLayout secondHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenSecond);
                RelativeLayout thirdHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenThird);
                removeButton.setVisibility(View.VISIBLE);

                /*RelativeLayout multiCityFirst = (RelativeLayout) rootMultiCity.findViewById(R.id.multiCity1);
                RelativeLayout multiCitySecond = (RelativeLayout) rootMultiCity.findViewById(R.id.multiCity2);
                RelativeLayout multiCityThird = (RelativeLayout) rootMultiCity.findViewById(R.id.multiCity3);*/
                if(firstHidden==null) {
                    LayoutTransition transition2 = new LayoutTransition();
                    View hideView = getActivity().getLayoutInflater().inflate(R.layout.multi_city_first, multiCityFirst, false);
                    multiCityFirst.addView(hideView);
                }
                if(secondHidden==null && firstHidden!=null) {
                    View hideView2 = getActivity().getLayoutInflater().inflate(R.layout.multi_city_second, multiCitySecond, false);
                    multiCitySecond.addView(hideView2);
                }

                if(thirdHidden==null && firstHidden!=null && secondHidden!=null) {
                    View hideView3 = getActivity().getLayoutInflater().inflate(R.layout.multi_city_third, multiCityThird, false);
                    multiCityThird.addView(hideView3);
                }
                    }
                /*RelativeLayout firstHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenFirst);
                RelativeLayout multiCityFirst = (RelativeLayout)rootMultiCity.findViewById(R.id.multiCity1);
                View hideView = getActivity().getLayoutInflater().inflate(R.layout.multi_city_first,multiCityFirst,false);
                multiCityFirst.addView(hideView);*/
               });

        multiCityFirst.setLayoutTransition(transition);
        multiCitySecond.setLayoutTransition(transition);
        multiCityThird.setLayoutTransition(transition);

        //if(removeButton!=null) {

            removeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    RelativeLayout firstHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenFirst);
                    RelativeLayout secondHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenSecond);
                    RelativeLayout thirdHidden = (RelativeLayout)rootMultiCity.findViewById(R.id.hiddenThird);

                    if(secondHidden==null && thirdHidden==null && firstHidden==null){
                        removeButton.setVisibility(View.GONE);
                    }
                    if(secondHidden==null && thirdHidden==null &&firstHidden!=null) {
                        View myView = rootMultiCity.findViewById(R.id.hiddenFirst);
                        ViewGroup parent = (ViewGroup) myView.getParent();
                        parent.removeView(myView);
                        parent.setLayoutTransition(transition);
                        removeButton.setVisibility(View.GONE);
                    }

                    if(thirdHidden==null && firstHidden!=null && secondHidden!=null){
                        View myView = rootMultiCity.findViewById(R.id.hiddenSecond);
                        ViewGroup parent = (ViewGroup) myView.getParent();
                        parent.removeView(myView);
                        parent.setLayoutTransition(transition);
                    }

                    if(thirdHidden!=null && firstHidden!=null && secondHidden!=null){
                        View myView = rootMultiCity.findViewById(R.id.hiddenThird);
                        ViewGroup parent = (ViewGroup) myView.getParent();
                        parent.removeView(myView);
                        parent.setLayoutTransition(transition);
                    }
                }
            });
        //}
        return rootMultiCity;
    }
}
