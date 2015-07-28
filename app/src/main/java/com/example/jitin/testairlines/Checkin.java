package com.example.jitin.testairlines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Checkin extends Fragment {


    public Checkin() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View checkIn= inflater.inflate(R.layout.fragment_checkin, container, false);
        EditText lastName = (EditText)checkIn.findViewById(R.id.lastName);
        Spinner idType = (Spinner)checkIn.findViewById(R.id.identification);
        ArrayAdapter<CharSequence> adapterId = ArrayAdapter.createFromResource(getActivity(),
                R.array.id_type, android.R.layout.simple_spinner_item);
        adapterId.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idType.setAdapter(adapterId);

        //Code for catching back button click and redirecting to home page
        checkIn.setFocusableInTouchMode(true);
        checkIn.requestFocus();
        checkIn.setOnKeyListener(new View.OnKeyListener() {
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
        return checkIn;
    }


}
