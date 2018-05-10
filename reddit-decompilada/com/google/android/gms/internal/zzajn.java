package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzzv
public final class zzajn {
    private final BroadcastReceiver f6457a = new zzajo(this);
    private final Map<BroadcastReceiver, IntentFilter> f6458b = new WeakHashMap();
    private boolean f6459c = false;
    private boolean f6460d;
    private Context f6461e;

    private final synchronized void m5305a(Context context, Intent intent) {
        for (Entry entry : this.f6458b.entrySet()) {
            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                ((BroadcastReceiver) entry.getKey()).onReceive(context, intent);
            }
        }
    }

    public final synchronized void m5307a(Context context) {
        if (!this.f6459c) {
            this.f6461e = context.getApplicationContext();
            if (this.f6461e == null) {
                this.f6461e = context;
            }
            zznh.m6490a(this.f6461e);
            this.f6460d = ((Boolean) zzkb.m6350f().m6488a(zznh.bT)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f6461e.registerReceiver(this.f6457a, intentFilter);
            this.f6459c = true;
        }
    }

    public final synchronized void m5308a(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f6460d) {
            this.f6458b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public final synchronized void m5309a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f6460d) {
            this.f6458b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
