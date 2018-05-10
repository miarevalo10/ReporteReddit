package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;

final class zzchn implements Runnable {
    private /* synthetic */ String f6897a;
    private /* synthetic */ zzchm f6898b;

    zzchn(zzchm com_google_android_gms_internal_zzchm, String str) {
        this.f6898b = com_google_android_gms_internal_zzchm;
        this.f6897a = str;
    }

    public final void run() {
        zzcjl d = this.f6898b.s.m5753d();
        if (d.m13544K()) {
            zzcib com_google_android_gms_internal_zzcib = d.f17829b;
            String str = this.f6897a;
            com_google_android_gms_internal_zzcib.f6935d.mo1811c();
            if (com_google_android_gms_internal_zzcib.m5705b() == 0) {
                com_google_android_gms_internal_zzcib.m5704a();
            }
            if (str == null) {
                str = "";
            }
            long j = com_google_android_gms_internal_zzcib.f6935d.m18211D().getLong(com_google_android_gms_internal_zzcib.f6932a, 0);
            if (j <= 0) {
                Editor edit = com_google_android_gms_internal_zzcib.f6935d.m18211D().edit();
                edit.putString(com_google_android_gms_internal_zzcib.f6933b, str);
                edit.putLong(com_google_android_gms_internal_zzcib.f6932a, 1);
                edit.apply();
                return;
            }
            j++;
            Object obj = (com_google_android_gms_internal_zzcib.f6935d.mo1824p().m18584z().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j ? 1 : null;
            Editor edit2 = com_google_android_gms_internal_zzcib.f6935d.m18211D().edit();
            if (obj != null) {
                edit2.putString(com_google_android_gms_internal_zzcib.f6933b, str);
            }
            edit2.putLong(com_google_android_gms_internal_zzcib.f6932a, j);
            edit2.apply();
            return;
        }
        this.f6898b.m18159a(6, "Persisted config not initialized. Not logging error/warn");
    }
}
