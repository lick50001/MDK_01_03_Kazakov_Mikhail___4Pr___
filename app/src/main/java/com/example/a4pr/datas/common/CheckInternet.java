package com.example.a4pr.datas.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckInternet {

    public ConnectivityManager Manager;

    public  CheckInternet(Context context){
        Manager = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public  boolean isWiFiConnection(){
        if (Manager == null) return  false;

        NetworkInfo WifiNetwork = Manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return WifiNetwork != null && WifiNetwork.isConnected();
    }

    public  boolean isMobileConnection(){
        if(Manager == null) return false;

        NetworkInfo MobileNetwork = Manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return MobileNetwork != null && MobileNetwork.isConnected();
    }
}
