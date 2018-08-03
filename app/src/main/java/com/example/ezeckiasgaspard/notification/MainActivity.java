package com.example.ezeckiasgaspard.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationcall();
                //Toast.makeText(getBaseContext(),"Notification",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void notificationcall (){

        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("NOTIFICATIONS")
                .setContentText("Vous avez des notifications");

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,notificationBuilder.build());
    }
}