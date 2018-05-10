package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzag {
    private static final Object f5877a = new Object();
    private static zzag f5878b;

    public static zzag m4782a(Context context) {
        synchronized (f5877a) {
            if (f5878b == null) {
                f5878b = new zzai(context.getApplicationContext());
            }
        }
        return f5878b;
    }

    public final void m4783a(String str, String str2, int i, ServiceConnection serviceConnection) {
        mo1624b(new zzah(str, str2, i), serviceConnection);
    }

    protected abstract boolean mo1623a(zzah com_google_android_gms_common_internal_zzah, ServiceConnection serviceConnection);

    protected abstract void mo1624b(zzah com_google_android_gms_common_internal_zzah, ServiceConnection serviceConnection);
}
