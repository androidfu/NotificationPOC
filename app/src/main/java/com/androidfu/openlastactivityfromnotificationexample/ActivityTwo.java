package com.androidfu.openlastactivityfromnotificationexample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ActivityTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);
        Button createNotification = (Button) findViewById(R.id.btn_create_notification);
        createNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(ActivityTwo.this);
                notificationBuilder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL);
                notificationBuilder
                        .setContentText(getString(R.string.notification_body))
                        .setContentTitle(getString(R.string.notification_title))
                        .setSmallIcon(R.drawable.ic_stat_av_new_releases)
                        .setTicker(getString(R.string.notification_ticker));
                Intent notificationIntent = new Intent(ActivityTwo.this, ActivityOne.class);
                notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                notificationIntent.setAction(Intent.ACTION_MAIN);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                PendingIntent pendingIntent = PendingIntent.getActivity(ActivityTwo.this, 0, notificationIntent, 0);
                notificationBuilder.setContentIntent(pendingIntent);
                notificationManager.notify(R.id.notification, notificationBuilder.build());
                Toast.makeText(ActivityTwo.this, getString(R.string.toast_notification_created), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
