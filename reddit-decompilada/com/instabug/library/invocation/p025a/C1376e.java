package com.instabug.library.invocation.p025a;

import android.content.Context;
import android.hardware.SensorEventListener;
import com.instabug.library.invocation.C0729a;
import com.instabug.library.util.C0777d;
import com.instabug.library.util.C0777d.C0776a;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: ShakeInvoker */
public class C1376e implements C0711a<Void>, C0776a {
    private C0777d f15504a;
    private C0729a f15505b;

    public C1376e(Context context, C0729a c0729a) {
        this.f15505b = c0729a;
        this.f15504a = new C0777d(context, this);
    }

    public final void mo2596a() {
        SensorEventListener sensorEventListener = this.f15504a;
        sensorEventListener.f9900a.registerListener(sensorEventListener, sensorEventListener.f9901b, 3);
    }

    public final void mo2597b() {
        SensorEventListener sensorEventListener = this.f15504a;
        sensorEventListener.f9900a.unregisterListener(sensorEventListener);
    }

    public final void mo2598c() {
        InstabugSDKLogger.m8356d(this, "Shake detected, invoking SDK");
        this.f15505b.mo2599a();
    }

    public final void m15415a(int i) {
        this.f15504a.f9902c = i;
    }
}
