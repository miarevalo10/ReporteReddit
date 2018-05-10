package com.google.android.exoplayer2.util;

import android.os.Trace;

public final class TraceUtil {
    public static void m4290a(String str) {
        if (Util.f5283a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void m4289a() {
        if (Util.f5283a >= 18) {
            Trace.endSection();
        }
    }
}
