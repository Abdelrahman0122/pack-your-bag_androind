package com.example.project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InternetReciver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
String status = checkInternet.getNetworkInfo(context);
if (status.equals("connected")){
    Toast.makeText(context.getApplicationContext(), "you are online ",Toast.LENGTH_LONG).show();
} else if (status.equals("disconnected")) {

    Toast.makeText(context.getApplicationContext(), "you are offline ",Toast.LENGTH_LONG).show();

}
    }
}
