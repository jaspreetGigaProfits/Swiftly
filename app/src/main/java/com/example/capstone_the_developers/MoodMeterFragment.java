package com.example.capstone_the_developers;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MoodMeterFragment extends Fragment {
    TextView txtStep;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    int steps=0;
    double PreMag=0;
    String stepSt="";
    ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mood_meter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtStep=view.findViewById(R.id.tv_stepsTaken);
        img=view.findViewById(R.id.img);
        sensorManager =(SensorManager)getContext().getSystemService(getContext().SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorEventListener =new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x=event.values[0];
                float y=event.values[1];
                float z=event.values[2];
                if (event!=null){
                    double mag=Math.sqrt(x*x+y*y+z*z);
                    double magdelta=mag-PreMag;
                    PreMag=mag;
                    if (magdelta>3){
                        steps++;
                    }
                    stepSt= String.valueOf(steps);
                    txtStep.setText("Steps: "+stepSt);

                    if (steps>200){
                        img.setImageDrawable(getResources().getDrawable(R.drawable.second));
                    }
                    if (steps>300){
                        img.setImageDrawable(getResources().getDrawable(R.drawable.third));                    }
                    if (steps>400){
                        img.setImageDrawable(getResources().getDrawable(R.drawable.fourth));                    }
                    if (steps>500){
                        img.setImageDrawable(getResources().getDrawable(R.drawable.fifth));                    }

                }



            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };


    }

    @Override
    public void onResume() {
        super.onResume();
        register();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregister();
    }
    public void register(){
        sensorManager.registerListener(sensorEventListener,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }
    public  void unregister(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}