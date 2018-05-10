package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzbs;

@zzzv
public final class zzagg extends Handler {
    public zzagg(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "AdMobHandler.handleMessage");
        }
    }
}
