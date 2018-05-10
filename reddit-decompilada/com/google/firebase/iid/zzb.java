package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    final ExecutorService f8624a = Executors.newSingleThreadExecutor();
    private Binder f8625b;
    private final Object f8626c = new Object();
    private int f8627d;
    private int f8628e = 0;

    private final void m7375d(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.m760a(intent);
        }
        synchronized (this.f8626c) {
            this.f8628e--;
            if (this.f8628e == 0) {
                stopSelfResult(this.f8627d);
            }
        }
    }

    public Intent mo2451a(Intent intent) {
        return intent;
    }

    public abstract void mo2452b(Intent intent);

    public boolean mo2455c(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f8625b == null) {
            this.f8625b = new zzf(this);
        }
        return this.f8625b;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f8626c) {
            this.f8627d = i2;
            this.f8628e++;
        }
        Intent a = mo2451a(intent);
        if (a == null) {
            m7375d(intent);
            return 2;
        } else if (mo2455c(a)) {
            m7375d(intent);
            return 2;
        } else {
            this.f8624a.execute(new zzc(this, a, intent));
            return 3;
        }
    }
}
