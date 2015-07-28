package com.example.jitin.testairlines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReturnSearchFlights extends Fragment {
    private RecyclerView recyclerView;
    private  SearchDataAdapter searchDataAdapter;


    public ReturnSearchFlights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootReturn = inflater.inflate(R.layout.fragment_return_search_flights, container, false);
        recyclerView = (RecyclerView)rootReturn.findViewById(R.id.searchReturnListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchDataAdapter= new SearchDataAdapter(SearchDataManager.getInstance().getSearchDataList());
        recyclerView.setAdapter(searchDataAdapter);

        return rootReturn;
    }


}
