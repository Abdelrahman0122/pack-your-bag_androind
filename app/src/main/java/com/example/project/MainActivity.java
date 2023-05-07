package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.project.Adapter.Adapter;
import com.example.project.Constants.MyConstants;
import com.example.project.Data.AppData;
import com.example.project.Database.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {






//    ************** BroadCast *************************

BroadcastReceiver broadcastReceiver = null;

//    ************** BroadCast *************************


    ImageButton imageButton2;
    RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images ;
    Adapter adapter;
    RoomDB database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton2 = findViewById(R.id.imageButton2);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint("MissingPermission")
            public void onClick(View view) {
               Intent intent = new Intent(view.getContext(), MainActivity2.class);
               startActivity(intent);

                NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this,"My notification");
                builder.setContentTitle("Hello?");
                builder.setContentText("You enterd the AboutUs page ");
                builder.setAutoCancel(true);
                builder.setSmallIcon(R.drawable.img_1);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());


            }
        });


        //remove the top bar at the beginning
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerView);

        //this method will add all the images to the List above in 17 line to the method below with the same name
        addAddTitles();
        addAllImages();
        persistAppData();
        database = RoomDB.getInstance(this);
        System.out.println("------------->"+database.mainDao().getAllSelected(false).get(0).getItemname());

        adapter = new Adapter(this,titles,images,MainActivity.this);
//this will make the grid looking 2 by 2
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2 ,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

//    ************************************** BroadCast *************************

broadcastReceiver = new  InternetReciver();

InternerStatus();

//    ************************************** BroadCast *************************



    }

    //    ************************************** BroadCast *************************
    public  void  InternerStatus(){
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    //protected void onPause(){

      //  super.onPause();
     //   unregisterReceiver(broadcastReceiver);
    //}


    //    **************************************** BroadCast *************************

    //are you want to exit message
    private static final int TIME_INTERVAL = 2000;

    private long nBackPressed;
    @Override
    public void onBackPressed() {
      if(nBackPressed+TIME_INTERVAL>System.currentTimeMillis()){
          super.onBackPressed();
      }else{
          Toast.makeText(this, "Tap back button in order to exit", Toast.LENGTH_SHORT).show();
      }
        nBackPressed = System.currentTimeMillis();

    }



    private void persistAppData() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        database = RoomDB.getInstance(this);
        AppData appData = new AppData(database);
        int last = prefs.getInt(AppData.LAST_VERSION,0);
        if (!prefs.getBoolean(MyConstants.FIRST_TIME_CAMEL_CASE, false)) {
            appData.persistAllData();
            editor.putBoolean(MyConstants.FIRST_TIME_CAMEL_CASE, true);
            editor.commit();


        } else if (last < AppData.NEW_VERSION) {
            database.mainDao().deleteAllSystemItems(MyConstants.SYSTEM_SMALL);
            appData.persistAllData();
            editor.putInt(AppData.LAST_VERSION, AppData.NEW_VERSION);
            editor.commit();


        }

    }

    private void addAddTitles(){
        titles = new ArrayList<>();
        titles.add(MyConstants.BASIC_NEEDS_CAMEL_CASE);
        titles.add(MyConstants.CLOTHING_CAMEL_CASE);
        titles.add(MyConstants.PERSONAL_CARE_CAMEL_CASE);
        titles.add(MyConstants.BABY_NEEDS_CAMEL_CASE);
        titles.add(MyConstants.HEALTH_CAMEL_CASE);
        titles.add(MyConstants.TECHNOLOGY_CAMEL_CASE);
        titles.add(MyConstants.FOOD_CAMEL_CASE);
        titles.add(MyConstants.BEACH_SUPPLIES_CAMEL_CASE);
        titles.add(MyConstants.CAR_SUPPLIES_CAMEL_CASE);
        titles.add(MyConstants.NEEDS_CAMEL_CASE);
        titles.add(MyConstants.MY_LIST_CAMEL_CASE);
        titles.add(MyConstants.MY_SELECTIONS_CAMEL_CASE);
    }

    private  void addAllImages(){
        images = new ArrayList<>();
        images.add(R.drawable.p1);
        images.add(R.drawable.p2);
        images.add(R.drawable.p3);
        images.add(R.drawable.p4);
        images.add(R.drawable.p5);
        images.add(R.drawable.p6);
        images.add(R.drawable.p7);
        images.add(R.drawable.p8);
        images.add(R.drawable.p9);
        images.add(R.drawable.p10);
        images.add(R.drawable.p11);
        images.add(R.drawable.p12);


    }
}