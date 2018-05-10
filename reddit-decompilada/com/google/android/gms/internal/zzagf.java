package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@zzzv
public final class zzagf extends zzakb {
    public static void m13278a(String str) {
        if (m13279a()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean m13279a() {
        if (zzakb.m5365a(2)) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.aX)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
