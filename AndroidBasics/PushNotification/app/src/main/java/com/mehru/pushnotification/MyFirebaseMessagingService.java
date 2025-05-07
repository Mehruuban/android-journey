package com.mehru.pushnotification;

import android.Manifest;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    public void  getMessage (String title , String msg){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myChannel")
                .setSmallIcon(R.drawable.baseline_circle_notifications_24)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(101, builder.build());
    }
}
