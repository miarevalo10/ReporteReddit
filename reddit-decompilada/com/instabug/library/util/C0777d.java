package com.instabug.library.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: ShakeDetector */
public class C0777d implements SensorEventListener {
    public SensorManager f9900a;
    public Sensor f9901b;
    public int f9902c = 350;
    private long f9903d = 0;
    private float f9904e;
    private float f9905f;
    private float f9906g;
    private C0776a f9907h;

    /* compiled from: ShakeDetector */
    public interface C0776a {
        void mo2598c();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public C0777d(Context context, C0776a c0776a) {
        this.f9900a = (SensorManager) context.getSystemService("sensor");
        this.f9901b = this.f9900a.getDefaultSensor(1);
        this.f9907h = c0776a;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            sensorEvent = sensorEvent.values[2];
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f9903d > 400) {
                if ((Math.abs(((((f + f2) + sensorEvent) - this.f9904e) - this.f9905f) - this.f9906g) / ((float) (currentTimeMillis - this.f9903d))) * 10000.0f > ((float) this.f9902c)) {
                    this.f9907h.mo2598c();
                }
                this.f9903d = currentTimeMillis;
                this.f9904e = f;
                this.f9905f = f2;
                this.f9906g = sensorEvent;
            }
        }
    }
}
