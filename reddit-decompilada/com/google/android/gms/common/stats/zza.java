package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.zzc;
import java.util.Collections;
import java.util.List;

public final class zza {
    private static final Object f5959a = new Object();
    private static volatile zza f5960b = null;
    private static boolean f5961c = false;
    private final List<String> f5962d = Collections.EMPTY_LIST;
    private final List<String> f5963e = Collections.EMPTY_LIST;
    private final List<String> f5964f = Collections.EMPTY_LIST;
    private final List<String> f5965g = Collections.EMPTY_LIST;

    private zza() {
    }

    public static zza m4889a() {
        if (f5960b == null) {
            synchronized (f5959a) {
                if (f5960b == null) {
                    f5960b = new zza();
                }
            }
        }
        return f5960b;
    }

    public static boolean m4890a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : zzc.m4894a(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public static boolean m4891b(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        context.getClass().getName();
        return m4890a(context, intent, serviceConnection, i);
    }
}
