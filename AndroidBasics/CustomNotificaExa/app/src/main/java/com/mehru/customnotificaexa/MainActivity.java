package com.mehru.customnotificaexa;

import static android.app.NotificationManager.IMPORTANCE_HIGH;
import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "New Message";
    private static final int NOTIFICATION_ID = 100;
    public static  final int REQ_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.baseline_backup_24,null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();
        Notification notification;



        Intent iNotify = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,REQ_CODE,iNotify, FLAG_UPDATE_CURRENT);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //BIG picture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(largeIcon)
                .setBigContentTitle("image sent by Mehru")
                .setSummaryText("image from mehru");


        //Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("c")
                .addLine("d")
                .addLine("e")
                .addLine("f")
                .addLine("g")
                .addLine("h")
                .setBigContentTitle("Suiiiiiiii")
                .setSummaryText("hattrick");






        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.baseline_backup_24)
                    .setContentText("New Message from mehru")
                    .setSubText("hey how are you ")
                    .setChannelId(CHANNEL_ID)
                    .setStyle(bigPictureStyle)  //To set created style
                    .setContentIntent(pendingIntent)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new channel", IMPORTANCE_HIGH));
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"second channel", IMPORTANCE_HIGH));
        } else {
       notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.baseline_backup_24)
                    .setContentText("New Message from mehru")
                    .setSubText("hey how are you ")
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(false)
                    .setContentIntent(pendingIntent)
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);
    }
}