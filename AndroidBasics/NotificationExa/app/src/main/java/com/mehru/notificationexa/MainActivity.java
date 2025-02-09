package com.mehru.notificationexa;

import static android.app.NotificationManager.IMPORTANCE_HIGH;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "my Channel";
    private static  final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.baseline_browser_updated_24,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.baseline_browser_updated_24)
                    .setSubText("hi how are you")
                    .setContentText("New Message From Meharban")
                    .setChannelId(CHANNEL_ID)
                    .build();
             nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel", IMPORTANCE_HIGH));


        }else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.baseline_browser_updated_24)
                    .setSubText("hi how are you")
                    .setContentText("New Message From Meharban")
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);
    }

}