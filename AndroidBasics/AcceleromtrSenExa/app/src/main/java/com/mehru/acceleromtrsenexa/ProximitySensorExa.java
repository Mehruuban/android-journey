package com.mehru.acceleromtrsenexa;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProximitySensorExa extends AppCompatActivity implements SensorEventListener {

    TextView proxy ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_proximity_sensor_exa);
        proxy=findViewById(R.id.proxy);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager!= null){
            Sensor proxySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proxySensor!=null){
                sensorManager.registerListener(this,proxySensor,SensorManager.SENSOR_DELAY_NORMAL);
            }

        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType()==Sensor.TYPE_PROXIMITY){
            proxy.setText("Values"+ sensorEvent.values[0]);
            if (sensorEvent.values[0]>0){
                Toast.makeText(this, "Object Is far", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Object Is near", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}