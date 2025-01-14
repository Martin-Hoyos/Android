package com.example.myapplication;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor barometerSensor;
    private TextView pressureTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressureTextView = findViewById(R.id.pressureTextView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        barometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        if (barometerSensor != null) {
            sensorManager.registerListener(sensorEventListener, barometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            pressureTextView.setText("El dispositivo no tiene un barómetro.");
        }
    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
                float pressure = event.values[0];
                pressureTextView.setText("Presión atmosférica: " + pressure + " hPa");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (barometerSensor != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }
}