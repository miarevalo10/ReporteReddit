package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzbs;

@zzzv
public final class zzafz {
    public final Object f6361a;
    public int f6362b;
    public int f6363c;
    public final zzaft f6364d;
    public final String f6365e;

    private zzafz(zzaft com_google_android_gms_internal_zzaft, String str) {
        this.f6361a = new Object();
        this.f6364d = com_google_android_gms_internal_zzaft;
        this.f6365e = str;
    }

    public zzafz(String str) {
        this(zzbs.m4490i(), str);
    }

    public final Bundle m5119a() {
        Bundle bundle;
        synchronized (this.f6361a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f6362b);
            bundle.putInt("pmnll", this.f6363c);
        }
        return bundle;
    }
}
