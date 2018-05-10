package com.google.android.gms.internal;

import android.content.Context;

public final class zzbhf {
    private static zzbhf f6712b = new zzbhf();
    private zzbhe f6713a = null;

    public static zzbhe m5574a(Context context) {
        return f6712b.m5575b(context);
    }

    private final synchronized zzbhe m5575b(Context context) {
        if (this.f6713a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f6713a = new zzbhe(context);
        }
        return this.f6713a;
    }
}
