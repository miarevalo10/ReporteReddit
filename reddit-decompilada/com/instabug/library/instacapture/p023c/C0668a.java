package com.instabug.library.instacapture.p023c;

import android.util.Log;

/* compiled from: Logger */
public final class C0668a {
    private static boolean f9597a;

    public static void m8178a(CharSequence charSequence) {
        if (f9597a) {
            Log.d("InstaCapture", charSequence.toString());
        }
    }

    public static void m8180b(CharSequence charSequence) {
        if (f9597a) {
            Log.e("InstaCapture", charSequence.toString());
        }
    }

    public static void m8179a(Throwable th) {
        if (f9597a) {
            Log.e("InstaCapture", "Logging caught exception", th);
        }
    }
}
