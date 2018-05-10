package com.vincentbrison.openlibraries.android.dualcache;

import android.util.Log;

final class Logger {
    private final boolean f24318a;

    Logger(boolean z) {
        this.f24318a = z;
    }

    final void m26011a(Throwable th) {
        if (this.f24318a) {
            Log.e("dualcache", "error : ", th);
        }
    }

    final void m26010a(String str) {
        String str2 = "dualcache";
        if (this.f24318a) {
            Log.println(4, str2, str);
        }
    }
}
