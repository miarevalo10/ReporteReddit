package io.fabric.sdk.android;

import android.util.Log;

public class DefaultLogger implements Logger {
    private int f30974a = 3;

    public DefaultLogger(byte b) {
    }

    public final boolean mo5564a(int i) {
        return this.f30974a <= i;
    }

    public final void mo5563a(String str, String str2, Throwable th) {
        if (mo5564a(3)) {
            Log.d(str, str2, th);
        }
    }

    public final void mo5566b(String str, String str2, Throwable th) {
        if (mo5564a(5)) {
            Log.w(str, str2, th);
        }
    }

    public final void mo5568c(String str, String str2, Throwable th) {
        if (mo5564a(6)) {
            Log.e(str, str2, th);
        }
    }

    public final void mo5562a(String str, String str2) {
        mo5563a(str, str2, null);
    }

    public final void mo5569d(String str, String str2) {
        mo5566b(str, str2, null);
    }

    public final void mo5570e(String str, String str2) {
        mo5568c(str, str2, null);
    }

    public final void mo5560a(int i, String str, String str2) {
        mo5561a(i, str, str2, false);
    }

    public final void mo5561a(int i, String str, String str2, boolean z) {
        if (z || mo5564a(i)) {
            Log.println(i, str, str2);
        }
    }

    public final void mo5565b(String str, String str2) {
        if (mo5564a(2)) {
            Log.v(str, str2, null);
        }
    }

    public final void mo5567c(String str, String str2) {
        if (mo5564a(4)) {
            Log.i(str, str2, null);
        }
    }
}
