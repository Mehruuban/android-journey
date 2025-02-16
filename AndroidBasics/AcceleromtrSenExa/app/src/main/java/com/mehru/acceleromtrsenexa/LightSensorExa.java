package com.mehru.acceleromtrsenexa;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedHashMap;

public class LightSensorExa extends AppCompatActivity implements SensorEventListener {
       TextView Light;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_light_sensor_exa);

        Light = findViewById(R.id.Light);


        SensorManager sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager!= null){
            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

            if (lightSensor!= null){
                sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
            }else {
                Toast.makeText(this, "Sensor is not detected", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
            Light.setText("Values: "+ sensorEvent.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}