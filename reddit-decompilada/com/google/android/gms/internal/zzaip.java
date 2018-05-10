package com.google.android.gms.internal;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzzv
public final class zzaip extends zzai {
    private final Context f17545a;

    private zzaip(Context context, zzaq com_google_android_gms_internal_zzaq) {
        super(com_google_android_gms_internal_zzaq);
        this.f17545a = context;
    }

    public static zzv m17792a(Context context) {
        zzv com_google_android_gms_internal_zzv = new zzv(new zzal(new File(context.getCacheDir(), "admob_volley"), (byte) 0), new zzaip(context, new zzar()), (byte) 0);
        com_google_android_gms_internal_zzv.m6693a();
        return com_google_android_gms_internal_zzv;
    }

    public final zzp mo1723a(zzr<?> com_google_android_gms_internal_zzr_) throws zzad {
        if (com_google_android_gms_internal_zzr_.f7972g && com_google_android_gms_internal_zzr_.f7966a == 0) {
            if (Pattern.matches((String) zzkb.m6350f().m6488a(zznh.ct), com_google_android_gms_internal_zzr_.f7967b)) {
                zzkb.m6345a();
                if (zzajr.m5335c(this.f17545a)) {
                    zzp a = new zzrx(this.f17545a).mo1723a((zzr) com_google_android_gms_internal_zzr_);
                    String str;
                    if (a != null) {
                        str = "Got gmscore asset response: ";
                        com_google_android_gms_internal_zzr_ = String.valueOf(com_google_android_gms_internal_zzr_.f7967b);
                        zzagf.m13278a(com_google_android_gms_internal_zzr_.length() != 0 ? str.concat(com_google_android_gms_internal_zzr_) : new String(str));
                        return a;
                    }
                    String str2 = "Failed to get gmscore asset response: ";
                    str = String.valueOf(com_google_android_gms_internal_zzr_.f7967b);
                    zzagf.m13278a(str.length() != 0 ? str2.concat(str) : new String(str2));
                }
            }
        }
        return super.mo1723a(com_google_android_gms_internal_zzr_);
    }
}
