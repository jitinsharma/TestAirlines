package com.example.jitin.testairlines;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitin on 28-03-2015.
 */
public class TripDataManager {

    private static String[] tripCityArray = {"BLR-DEL", "DEL-BLR", "DEL-IXJ", "IXJ-DEL"};
    private static String[] tripDateArray = {"23 Apr", "24 Apr", "25 Apr", "26 Apr"};
    private static String[] tripFlightNoArray = {"SG-805", "6E-141", "9W-106", "AI-545"};
    private static String[] tripTimeArray = {"22:40" , "6:10", "20:10", "9:15"};
    private static String[] tripStatusArray = {"DELAYED", "CONFIRMED", "CANCELLED", "CONFIRMED"};

    private static TripDataManager mInstance;
    private List<TripData> trips;

    public static TripDataManager getInstance(){
        if(mInstance==null){
            mInstance = new TripDataManager();
        }
        return mInstance;
    }

    public List <TripData> getTrips(){
        if(trips==null){
            trips = new ArrayList<>();

            for(int i=0; i<tripCityArray.length; i++){
                TripData tripData = new TripData();
                tripData.cities = tripCityArray[i];
                tripData.dateOfTrip = tripDateArray[i];
                tripData.timeOfFlight = tripTimeArray[i];
                tripData.flightNo = tripFlightNoArray[i];
                tripData.status = tripStatusArray[i];
                trips.add(tripData);
            }
        }
        return trips;
    }
}