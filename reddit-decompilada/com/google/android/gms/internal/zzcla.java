package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzbq;

public final class zzcla<T extends Context & zzcle> {
    public final T f7159a;

    public zzcla(T t) {
        zzbq.m4808a((Object) t);
        this.f7159a = t;
    }

    public static boolean m5795a(Context context) {
        zzbq.m4808a((Object) context);
        return zzclq.m18509a(context, VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    public final void m5797a(Runnable runnable) {
        zzcim a = zzcim.m5720a(this.f7159a);
        a.m5754e();
        a.m5755f().m18271a(new zzcld(a, runnable));
    }

    public final zzchm m5801c() {
        return zzcim.m5720a(this.f7159a).m5754e();
    }

    public final void m5796a() {
        zzcim.m5720a(this.f7159a).m5754e().f17822g.m5693a("Local AppMeasurementService is starting up");
    }

    public final void m5799b() {
        zzcim.m5720a(this.f7159a).m5754e().f17822g.m5693a("Local AppMeasurementService is shutting down");
    }

    public final boolean m5798a(Intent intent) {
        if (intent == null) {
            m5801c().f17816a.m5693a("onUnbind called with null intent");
            return true;
        }
        m5801c().f17822g.m5694a("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void m5800b(Intent intent) {
        if (intent == null) {
            m5801c().f17816a.m5693a("onRebind called with null intent");
            return;
        }
        m5801c().f17822g.m5694a("onRebind called. action", intent.getAction());
    }
}
