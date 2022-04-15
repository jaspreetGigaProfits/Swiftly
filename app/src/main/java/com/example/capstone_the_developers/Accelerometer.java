package com.example.capstone_the_developers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class Accelerometer {

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    Listener listener;

    public Accelerometer(Context context){
        sensorManager =(SensorManager)context.getSystemService(context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorEventListener =new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                  listener.onTranslation(event.values[0],event.values[1],event.values[2]);

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    public void setListener(Listener listener){
    this.listener = this.listener;
    }
    public void register(){
        sensorManager.registerListener(sensorEventListener,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }
    public  void unregister(){
            sensorManager.unregisterListener(sensorEventListener);
    }
}
