package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzae implements Callback {
    public final zzaf f5868a;
    public final ArrayList<ConnectionCallbacks> f5869b = new ArrayList();
    public ArrayList<ConnectionCallbacks> f5870c = new ArrayList();
    public final ArrayList<OnConnectionFailedListener> f5871d = new ArrayList();
    public volatile boolean f5872e = false;
    public final AtomicInteger f5873f = new AtomicInteger(0);
    public boolean f5874g = false;
    public final Handler f5875h;
    public final Object f5876i = new Object();

    public zzae(Looper looper, zzaf com_google_android_gms_common_internal_zzaf) {
        this.f5868a = com_google_android_gms_common_internal_zzaf;
        this.f5875h = new Handler(looper, this);
    }

    public final void m4779a() {
        this.f5872e = false;
        this.f5873f.incrementAndGet();
    }

    public final void m4780a(OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.m4808a((Object) onConnectionFailedListener);
        synchronized (this.f5876i) {
            if (this.f5871d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder stringBuilder = new StringBuilder(67 + String.valueOf(valueOf).length());
                stringBuilder.append("registerConnectionFailedListener(): listener ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" is already registered");
                Log.w("GmsClientEvents", stringBuilder.toString());
            } else {
                this.f5871d.add(onConnectionFailedListener);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.f5876i) {
                if (this.f5872e && this.f5868a.mo1601f() && this.f5869b.contains(connectionCallbacks)) {
                    connectionCallbacks.mo1582a(null);
                }
            }
            return true;
        }
        int i = message.what;
        StringBuilder stringBuilder = new StringBuilder(45);
        stringBuilder.append("Don't know how to handle message: ");
        stringBuilder.append(i);
        Log.wtf("GmsClientEvents", stringBuilder.toString(), new Exception());
        return false;
    }
}
