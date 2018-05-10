package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;

@zzzv
public final class zznf {
    final Object f7858a = new Object();
    final ConditionVariable f7859b = new ConditionVariable();
    volatile boolean f7860c = false;
    SharedPreferences f7861d = null;
    Context f7862e;

    public final <T> T m6488a(zzmx<T> com_google_android_gms_internal_zzmx_T) {
        if (this.f7859b.block(5000)) {
            if (!this.f7860c || this.f7861d == null) {
                synchronized (this.f7858a) {
                    if (this.f7860c) {
                        if (this.f7861d == null) {
                        }
                    }
                    com_google_android_gms_internal_zzmx_T = com_google_android_gms_internal_zzmx_T.f7849c;
                    return com_google_android_gms_internal_zzmx_T;
                }
            }
            return zzajk.m5302a(this.f7862e, new zzng(this, com_google_android_gms_internal_zzmx_T));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }
}
