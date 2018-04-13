package com.iondew.slingshot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class ListOfSatations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_satations);
        List<String> blue_stations_names= Arrays.asList("Dwarka Sec-21","Dwarka Sec-08","Dwarka Sec-09","Dwarka Sec-10","Dwarka Sec-11","Dwarka Sec-12","Dwarka Sec-13","Dwarka Sec-14","Dwarka","Dwarka Mor","Nawada","Uttam Nagar West","Uttam Nagar East","Janak Puri West","Janak Puri East","Tilak Nagar","Subhash Nagar","Tagore Garden","Rajouri Garden");

        List<String> yellow_stations_names=Arrays.asList("Samaypur Badli","Rohini Sector 18,19","Haiderpur Badli Mor","Jahangirpuri","Adarsh Nagar","Azadpur","Model Town","G.T.B. Nagar","Rajiv Chowk","Vishwavidyalaya","New Delhi","Vidhan Sabha","Civil Lines","Kashmere Gate","Chandni Chowk","Chawri Bazar","Patel Chowk","Central Secretariat");

    }
}
