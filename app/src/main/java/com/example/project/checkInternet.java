package com.example.project;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class checkInternet {

    public static String getNetworkInfo(Context context){
        String status = null;
//        proplem m4 3aref eh hya ya bdany
        ConnectivityManager connectivityManeger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE) ;

        NetworkInfo networkInfo = connectivityManeger.getActiveNetworkInfo();

        if (networkInfo != null){
            status = "connected";
            return status;
        }else {
            status = "disconnected";
            return status;
        }
    }
}
