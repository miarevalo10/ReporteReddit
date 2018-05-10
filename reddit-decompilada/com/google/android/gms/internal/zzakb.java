package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@zzzv
public class zzakb {
    public static void m5364a(String str, Throwable th) {
        if (m5365a(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m5365a(int i) {
        if (i < 5) {
            if (!Log.isLoggable(AdRequest.LOGTAG, i)) {
                return false;
            }
        }
        return true;
    }

    public static void m5366b(String str) {
        if (m5365a(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m5367b(String str, Throwable th) {
        if (m5365a(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m5368c(String str) {
        if (m5365a(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m5369c(String str, Throwable th) {
        if (m5365a(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m5370d(String str) {
        if (m5365a(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m5371e(String str) {
        if (m5365a(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
