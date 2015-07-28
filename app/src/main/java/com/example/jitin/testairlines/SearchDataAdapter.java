package com.example.jitin.testairlines;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jitin on 29-03-2015.
 */
public class SearchDataAdapter extends RecyclerView.Adapter<SearchDataAdapter.ViewHolder> {

    private List<SearchData> searchDataList;

    public SearchDataAdapter(List<SearchData> searchDataList) {
        this.searchDataList = searchDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SearchData searchData = searchDataList.get(i);
        viewHolder.airlineName.setText(searchData.airlineName);
        viewHolder.searchFlightNo.setText(searchData.searchFlightNo);
        viewHolder.depTime.setText(searchData.departTime);
        viewHolder.landTime.setText(searchData.landTime);
        viewHolder.price.setText(searchData.price);
        viewHolder.refundType.setText(searchData.refundType);
        if(viewHolder.refundType.getText().equals("Refundable")){
            viewHolder.refundType.setTextColor(Color.parseColor("#32CD32"));
        }
        viewHolder.flightTime.setText(searchData.flightTime);
        viewHolder.flightStops.setText(searchData.flightStops);
    }

    @Override
    public int getItemCount() {
        return searchDataList == null ? 0 : searchDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView airlineName;
        public TextView searchFlightNo;
        public TextView depTime;
        public TextView landTime;
        public TextView price;
        public TextView flightTime;
        public TextView refundType;
        public TextView flightStops;

        public ViewHolder(View itemView) {
            super(itemView);
            airlineName  = (TextView)itemView.findViewById(R.id.flightName);
            searchFlightNo = (TextView)itemView.findViewById(R.id.searchFlightNo);
            depTime = (TextView)itemView.findViewById(R.id.searchDepTime);
            landTime = (TextView)itemView.findViewById(R.id.searchLandTime);
            price = (TextView)itemView.findViewById(R.id.price);
            flightTime = (TextView)itemView.findViewById(R.id.searchFlightTime);
            refundType = (TextView)itemView.findViewById(R.id.refundStatus);
            flightStops = (TextView)itemView.findViewById(R.id.noOfStops);
        }
    }
}