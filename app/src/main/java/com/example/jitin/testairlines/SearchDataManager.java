package com.example.jitin.testairlines;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitin on 29-03-2015.
 */
public class SearchDataManager {

    private static String[] airlineNameArray = {"Air India", "Jet Airways", "Indigo", "SpiceJet", "Go Air","Vistara","Air Asia"};
    private static String[] searchFlightNoArray = {"AI-404", "9W-108", "6E-191", "SG-805", "G8-566", "UK-160", "AK-391"};
    private static String[] departTimeArray = {"7:30","7:30","7:30","7:30","7:30","8:30","9:30"};
    private static String[] landTimeArray = {"10:00","10:00","10:00","10:00","10:00","12:30","11:00"};
    private static String[] flightTimeArray = {"2h 30m","2h 30m","2h 30m","2h 30m","2h 30m","4h","1h 30m"};
    private static String[] refundTypeArray = {"Refundable","Non Refundable","Refundable","Non Refundable","Refundable","Refundable","Refundable"};
    private static String[] flightStopArray = {"Non Stop","Non Stop","Non Stop","1 Stop", "2 Stops","3 Stops","Non Stop"};
    private static String[] priceArray = {"5000","7000","6000","2000","3000","2000","5500"};

    private static SearchDataManager mInstance;
    public List<SearchData> searchDataList;

    public static SearchDataManager getInstance(){
        if(mInstance==null){
            mInstance = new SearchDataManager();
        }
        return mInstance;
    }

    public List <SearchData> getSearchDataList(){
        if(searchDataList==null){
            searchDataList = new ArrayList<>();

            for(int i=0; i<airlineNameArray.length;i++){
                SearchData searchData =  new SearchData();
                searchData.airlineName = airlineNameArray[i];
                searchData.searchFlightNo = searchFlightNoArray[i];
                searchData.departTime = departTimeArray[i];
                searchData.landTime = landTimeArray[i];
                searchData.flightTime = flightTimeArray[i];
                searchData.refundType = refundTypeArray[i];
                searchData.flightStops = flightStopArray[i];
                searchData.price = priceArray[i];
                searchDataList.add(searchData);
            }
        }
        return searchDataList;
    }
}
