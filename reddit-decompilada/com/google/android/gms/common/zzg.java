package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbb;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzg {
    private static zzba f5976a;
    private static final Object f5977b = new Object();
    private static Context f5978c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m4939a(android.content.Context r2) {
        /*
        r0 = com.google.android.gms.common.zzg.class;
        monitor-enter(r0);
        r1 = f5978c;	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        if (r2 == 0) goto L_0x0018;
    L_0x0009:
        r2 = r2.getApplicationContext();	 Catch:{ all -> 0x001a }
        f5978c = r2;	 Catch:{ all -> 0x001a }
        monitor-exit(r0);
        return;
    L_0x0011:
        r2 = "GoogleCertificates";
        r1 = "GoogleCertificates has been initialized already";
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r0);
        return;
    L_0x001a:
        r2 = move-exception;
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzg.a(android.content.Context):void");
    }

    private static boolean m4940a() {
        if (f5976a != null) {
            return true;
        }
        zzbq.m4808a(f5978c);
        synchronized (f5977b) {
            if (f5976a == null) {
                try {
                    f5976a = zzbb.m13102a(DynamiteModule.m4956a(f5978c, DynamiteModule.f5987c, "com.google.android.gms.googlecertificates").m4966a("com.google.android.gms.common.GoogleCertificatesImpl"));
                } catch (Throwable e) {
                    Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                    return false;
                }
            }
        }
        return true;
    }

    static boolean m4941a(String str, zzh com_google_android_gms_common_zzh) {
        return m4942a(str, com_google_android_gms_common_zzh, false);
    }

    private static boolean m4942a(String str, zzh com_google_android_gms_common_zzh, boolean z) {
        if (!m4940a()) {
            return false;
        }
        zzbq.m4808a(f5978c);
        try {
            return f5976a.mo1629a(new zzn(str, com_google_android_gms_common_zzh, z), zzn.m17692a(f5978c.getPackageManager()));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    static boolean m4943b(String str, zzh com_google_android_gms_common_zzh) {
        return m4942a(str, com_google_android_gms_common_zzh, true);
    }
}
