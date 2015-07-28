package com.example.jitin.testairlines;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jitin on 28-03-2015.
 */
public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private List<TripData> tripCities;

    public TripAdapter(List<TripData> tripCities) {
        this.tripCities = tripCities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trip, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        TripData tripdata = tripCities.get(i);
        viewHolder.citiesName.setText(tripdata.cities);
        viewHolder.tripDate.setText(tripdata.dateOfTrip);
        viewHolder.flightNo.setText(tripdata.flightNo);
        viewHolder.tripTime.setText(tripdata.timeOfFlight);
        viewHolder.tripStatus.setText(tripdata.status);
    }

    @Override
    public int getItemCount() {
        return tripCities == null ? 0 : tripCities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView citiesName;
        public TextView tripDate;
        public TextView flightNo;
        public TextView tripTime;
        public TextView tripStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            citiesName  = (TextView)itemView.findViewById(R.id.tripCity);
            tripDate = (TextView)itemView.findViewById(R.id.tripDate);
            flightNo = (TextView)itemView.findViewById(R.id.flightNo);
            tripTime = (TextView)itemView.findViewById(R.id.tripTime);
            tripStatus = (TextView)itemView.findViewById(R.id.tripStatus);
        }
    }
}
