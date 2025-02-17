package com.mehru.serviceexa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;

public class AlarmManagerExa extends AppCompatActivity {
    static final int alarm_req_code = 100;

    EditText Alarm ;
    Button alarmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alarm_manager_exa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Alarm = findViewById(R.id.Alarm);
        alarmBtn = findViewById(R.id.alarmBtn);

        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                int Alarm =Integer.parseInt (((EditText)(findViewById(R.id.Alarm))).getText().toString());

                long time = 100;
                long triggerTime = System.currentTimeMillis()+(time*100);

                Intent broadcast = new Intent(AlarmManagerExa.this,MyReciever.class);

                PendingIntent pi = PendingIntent.getBroadcast(AlarmManagerExa.this,alarm_req_code ,broadcast,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);

            }
        });
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        alarmManager.set(AlarmManager.RTC_WAKEUP,);
    }
}
