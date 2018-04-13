package com.iondew.slingshot;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by aneeshkundu on 13/04/18.
 */

public class StationList {

    private  ArrayList<String> color_list_1(String s){
        ArrayList<String> temp=new ArrayList<String>();
        temp.add(s);
        return temp;
    }
    private  ArrayList<String> color_list_2(String a,String b){
        ArrayList<String> temp=new ArrayList<String>();
        temp.add(a);temp.add(b);
        return temp;
    }

    private  ArrayList<String> color_list_3(String a,String b,String c){
        ArrayList<String> temp=new ArrayList<String>();
        temp.add(a);temp.add(b);temp.add(c);
        return temp;
    }
    private  ArrayList<String> color_list_4(String a,String b,String c,String d){
        ArrayList<String> temp=new ArrayList<String>();
        temp.add(a);temp.add(b);temp.add(c);temp.add(d);
        return temp;
    }
    ArrayList<Station> blue_stations= new ArrayList<Station>();
    ArrayList<Station> yellow_stations= new ArrayList<Station>();
    ArrayList<String> colorList;
    StationList() {
        blue_stations.add(new Station(0,44,"Dwarka Sec-21", color_list_1("blue"),28.552322,77.058383));
        blue_stations.add(new Station(1,44,"Dwarka Sec-08", color_list_1("blue"),28.565622,77.067015));
        blue_stations.add(new Station(2,44,"Dwarka Sec-09",color_list_1("blue"),28.574448,77.065171));
        blue_stations.add(new Station(3,44,"Dwarka Sec-10", color_list_1("blue"),28.581097,77.057481));
        blue_stations.add(new Station(4,44,"Dwarka Sec-11", color_list_1("blue"),28.586496,77.049385));
        blue_stations.add(new Station(5,44,"Dwarka Sec-12",color_list_1("blue"),28.592281,77.04066));
        blue_stations.add(new Station(6,44,"Dwarka Sec-13", color_list_1("blue"),28.597139,77.033463));
        blue_stations.add(new Station(7,44,"Dwarka Sec-14", color_list_1("blue"),28.602238,77.025996));
        blue_stations.add(new Station(8,44,"Dwarka",color_list_1("blue"),28.6149558,77.020523));
        blue_stations.add(new Station(9,44,"Dwarka Mor", color_list_1("blue"),28.6193698,77.0309593));
        blue_stations.add(new Station(10,44,"Nawada", color_list_1("blue"),28.620165,77.045016));
        blue_stations.add(new Station(11,44,"Uttam Nagar West",color_list_1("blue"),28.621734,77.055818));
        blue_stations.add(new Station(12,44,"Uttam Nagar East", color_list_1("blue"),28.62478,77.065125));
        blue_stations.add(new Station(13,44,"Janak Puri West", color_list_1("blue"),28.629409,77.077762));
        blue_stations.add(new Station(14,44,"Janak Puri East",color_list_1("blue"),28.633125,77.086575));
        blue_stations.add(new Station(15,44,"Tilak Nagar", color_list_1("blue"),28.636587,77.096466));
        blue_stations.add(new Station(16,44,"Subhash Nagar", color_list_1("blue"),28.640446,77.104918));
        blue_stations.add(new Station(17,44,"Tagore Garden",color_list_1("blue"),28.643895,77.11283));
        blue_stations.add(new Station(18,44,"Rajouri Garden", color_list_2("blue","pink"),28.649209,77.122449));
        blue_stations.add(new Station(19,44,"Ramesh Nagar", color_list_1("blue"),28.652717,77.131547));
        blue_stations.add(new Station(20,44,"Moti Nagar",color_list_1("blue"),28.65787,77.142674));
        blue_stations.add(new Station(21,44,"Kirti Nagar", color_list_2("blue","green"),28.655833,77.150703));
        blue_stations.add(new Station(22,44,"Shadipur", color_list_1("blue"),28.651558,77.158194));
        blue_stations.add(new Station(23,44,"Patel Nagar",color_list_1("blue"),28.645178,77.169097));
        blue_stations.add(new Station(24,44,"Rajendra Place", color_list_1("blue"),28.649209,77.122449));
        blue_stations.add(new Station(25,44,"Karol Bagh", color_list_1("blue"),28.64398,77.188435));
        blue_stations.add(new Station(26,44,"Jhandewalan",color_list_1("blue"),28.644357,77.199825));
        blue_stations.add(new Station(27,44,"R K Ashram Marg", color_list_1("blue"),28.63906,77.2061371));
        blue_stations.add(new Station(28,44,"Rajiv Chowk", color_list_2("blue","yellow"),28.632862,77.219542));
        blue_stations.add(new Station(29,44,"Barakhamba",color_list_1("blue"),28.629907,77.224159));
        blue_stations.add(new Station(30,44,"Mandi House", color_list_2("blue","violet"),28.625899,77.234296));
        blue_stations.add(new Station(31,44,"Pragati Maidan", color_list_1("blue"),28.623186,77.242761));
        blue_stations.add(new Station(32,44,"Indraprastha",color_list_1("blue"),28.620528,77.249878));
        blue_stations.add(new Station(33,44,"Yamuna Bank", color_list_1("blue"),28.623247,77.267903));
        blue_stations.add(new Station(34,44,"Akshardham", color_list_1("blue"),28.618002,77.279372));
        blue_stations.add(new Station(35,44,"Mayur Vihar Phase-1",color_list_1("blue"),28.60404,77.289563));
        blue_stations.add(new Station(36,44,"Mayur Vihar Extention", color_list_1("blue"),28.594213,77.294635));
        blue_stations.add(new Station(37,44,"New Ashok Nagar", color_list_1("blue"),28.589141,77.301883));
        blue_stations.add(new Station(38,44,"Noida Sector-15",color_list_1("blue"),28.584933,77.311776));
        blue_stations.add(new Station(39,44,"Noida Sector-16", color_list_1("blue"),28.578542,77.317462));
        blue_stations.add(new Station(30,44,"Noida Sector-18", color_list_1("blue"),28.570813,77.326116));
        blue_stations.add(new Station(41,44,"Botanical Garden",color_list_2("blue","pink"),28.56404,77.334269));
        blue_stations.add(new Station(42,44,"Golf Course", color_list_1("blue"),28.567175,77.345992));
        blue_stations.add(new Station(43,44,"Noida City Center", color_list_1("blue"),28.,77.356026));



        yellow_stations.add(new Station(44, 10, "Lok Kalyan Marg", color_list_1("yellow"), 28.5969129, 77.2108892));
        yellow_stations.add(new Station(45, 10, "Jorbagh", color_list_1("yellow"), 28.5861923, 77.2116617));
        yellow_stations.add(new Station(46, 10, "INA", color_list_1("yellow"), 28.5730116, 77.2077135));
        yellow_stations.add(new Station(47, 10, "AIIMS", color_list_1("yellow"), 28.5668322, 77.2059262));
        yellow_stations.add(new Station(48, 10, "Green Park", color_list_1("yellow"), 28.5613009, 77.2056579));
        yellow_stations.add(new Station(49, 10, "Hauz Khas", color_list_1("yellow"), 28.5467976, 77.2069239));
        yellow_stations.add(new Station(50, 10, "Malviya Nagar", color_list_1("yellow"), 28.5293231, 77.2045743));
        yellow_stations.add(new Station(51, 10, "Saket", color_list_1("yellow"), 28.5219894, 77.2009265));
        yellow_stations.add(new Station(52, 10, "Qutub Minar", color_list_1("yellow"), 28.5142875, 77.1868074));
        yellow_stations.add(new Station(53, 10, "Chattarpur", color_list_1("yellow"), 28.5075953, 77.1754527));
        yellow_stations.add(new Station(54, 10, "Sultanpur", color_list_1("yellow"), 28.4992649, 77.1591741));
        yellow_stations.add(new Station(55, 10, "Ghittorni", color_list_1("yellow"), 28.4943713, 77.1490997));
}




}
