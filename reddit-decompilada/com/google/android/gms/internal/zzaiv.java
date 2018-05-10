package com.google.android.gms.internal;

import android.content.Context;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Map;

@zzzv
public final class zzaiv {
    static zzv f6435a;
    private static final Object f6436b = new Object();
    @Deprecated
    private static zzajb<Void> f6437c = new zzaiw();

    public zzaiv(Context context) {
        m5294a(context);
    }

    public static zzakv<String> m5293a(int i, String str, Map<String, String> map, byte[] bArr) {
        zzakv com_google_android_gms_internal_zzajc = new zzajc();
        zzx com_google_android_gms_internal_zzaiz = new zzaiz(str, com_google_android_gms_internal_zzajc);
        zzajv com_google_android_gms_internal_zzajv = new zzajv(null);
        zzr com_google_android_gms_internal_zzaja = new zzaja(i, str, com_google_android_gms_internal_zzajc, com_google_android_gms_internal_zzaiz, bArr, map, com_google_android_gms_internal_zzajv);
        if (zzajv.m5355c()) {
            try {
                com_google_android_gms_internal_zzajv.m5357a(str, HttpRequest.METHOD_GET, com_google_android_gms_internal_zzaja.mo3445b(), com_google_android_gms_internal_zzaja.mo3444a());
            } catch (Throwable e) {
                zzakb.m5371e(e.getMessage());
            }
        }
        f6435a.m6692a(com_google_android_gms_internal_zzaja);
        return com_google_android_gms_internal_zzajc;
    }

    private static zzv m5294a(Context context) {
        zzv a;
        synchronized (f6436b) {
            if (f6435a == null) {
                context = context.getApplicationContext();
                zznh.m6490a(context);
                if (((Boolean) zzkb.m6350f().m6488a(zznh.cs)).booleanValue()) {
                    a = zzaip.m17792a(context);
                } else {
                    a = new zzv(new zzal(new File(context.getCacheDir(), "volley"), (byte) 0), new zzai(new zzar()), (byte) 0);
                    a.m6693a();
                }
                f6435a = a;
            }
            a = f6435a;
        }
        return a;
    }
}
