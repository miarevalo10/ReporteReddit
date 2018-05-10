package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Trace;

public final class TraceCompat {
    public static void m975a(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void m974a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
