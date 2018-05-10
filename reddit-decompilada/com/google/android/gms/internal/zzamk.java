package com.google.android.gms.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;

@zzzv
final class zzamk implements SensorEventListener {
    final SensorManager f6549a;
    Handler f6550b;
    zzamm f6551c;
    private final Object f6552d = new Object();
    private final Display f6553e;
    private final float[] f6554f = new float[9];
    private final float[] f6555g = new float[9];
    private float[] f6556h;

    zzamk(Context context) {
        this.f6549a = (SensorManager) context.getSystemService("sensor");
        this.f6553e = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void m5418a(int i, int i2) {
        float f = this.f6555g[i];
        this.f6555g[i] = this.f6555g[i2];
        this.f6555g[i2] = f;
    }

    final void m5419a() {
        if (this.f6550b != null) {
            this.f6549a.unregisterListener(this);
            this.f6550b.post(new zzaml());
            this.f6550b = null;
        }
    }

    final boolean m5420a(float[] fArr) {
        synchronized (this.f6552d) {
            if (this.f6556h == null) {
                return false;
            }
            System.arraycopy(this.f6556h, 0, fArr, 0, this.f6556h.length);
            return true;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f6552d) {
                if (this.f6556h == null) {
                    this.f6556h = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f6554f, fArr);
            switch (this.f6553e.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.f6554f, 2, 129, this.f6555g);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.f6554f, 129, 130, this.f6555g);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.f6554f, 130, 1, this.f6555g);
                    break;
                default:
                    System.arraycopy(this.f6554f, 0, this.f6555g, 0, 9);
                    break;
            }
            m5418a(1, 3);
            m5418a(2, 6);
            m5418a(5, 7);
            synchronized (this.f6552d) {
                System.arraycopy(this.f6555g, 0, this.f6556h, 0, 9);
            }
            if (this.f6551c != null) {
                this.f6551c.mo1751a();
            }
        }
    }
}
