package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.zzchm;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.internal.zzcir;
import com.google.android.gms.internal.zzcla;
import com.google.android.gms.internal.zzclb;
import com.google.android.gms.internal.zzcle;

public final class AppMeasurementService extends Service implements zzcle {
    private zzcla<AppMeasurementService> f14811a;

    private final zzcla<AppMeasurementService> m14508a() {
        if (this.f14811a == null) {
            this.f14811a = new zzcla(this);
        }
        return this.f14811a;
    }

    public final void mo2302a(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final void mo2303a(Intent intent) {
        WakefulBroadcastReceiver.m760a(intent);
    }

    public final boolean mo2304a(int i) {
        return stopSelfResult(i);
    }

    public final void onCreate() {
        super.onCreate();
        m14508a().m5796a();
    }

    public final void onDestroy() {
        m14508a().m5799b();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        m14508a().m5800b(intent);
    }

    public final boolean onUnbind(Intent intent) {
        return m14508a().m5798a(intent);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        i = m14508a();
        zzchm e = zzcim.m5720a(i.f7159a).m5754e();
        if (intent == null) {
            e.f17818c.m5693a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            e.f17822g.m5695a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                i.m5797a(new zzclb(i, i2, e, intent));
            }
        }
        return 2;
    }

    public final IBinder onBind(Intent intent) {
        zzcla a = m14508a();
        if (intent == null) {
            a.m5801c().f17816a.m5693a("onBind called with null intent");
            return null;
        }
        intent = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(intent)) {
            return new zzcir(zzcim.m5720a(a.f7159a));
        }
        a.m5801c().f17818c.m5694a("onBind received unknown action", intent);
        return null;
    }
}
