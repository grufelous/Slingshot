package com.iondew.slingshot;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;


public class MainActivity extends AppCompatActivity {
    Button btGo,btPayTM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGo = findViewById(R.id.btGo);
        btPayTM=findViewById(R.id.btPayTM);
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //addNotification();
                //Log.d("notif","notified");
                Intent i = new Intent(MainActivity.this, MapsActivity2.class);
                startActivity(i);
            }
        });

        btPayTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }

            }
        });


    }
    /*private void addNotification(){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_slingshot_logo)
                .setContentTitle("Wake up!")
                .setContentText("Your destination has arrived.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        int notificationId=1000;
        notificationManager.notify(notificationId, mBuilder.build());

    }*/
}

