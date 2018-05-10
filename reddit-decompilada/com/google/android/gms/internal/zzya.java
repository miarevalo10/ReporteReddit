package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.common.util.zzq;

@zzzv
public final class zzya {
    public static zzaif m6803a(Context context, zza com_google_android_gms_ads_internal_zza, zzafp com_google_android_gms_internal_zzafp, zzcv com_google_android_gms_internal_zzcv, zzanh com_google_android_gms_internal_zzanh, zzux com_google_android_gms_internal_zzux, zzyb com_google_android_gms_internal_zzyb, zznu com_google_android_gms_internal_zznu) {
        zzaif com_google_android_gms_internal_zzyf;
        zzaax com_google_android_gms_internal_zzaax = com_google_android_gms_internal_zzafp.f6315b;
        zzaif com_google_android_gms_internal_zzyg;
        if (com_google_android_gms_internal_zzaax.f17447g) {
            com_google_android_gms_internal_zzyg = new zzyg(context, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzyb, com_google_android_gms_internal_zznu, com_google_android_gms_internal_zzanh);
        } else {
            if (!com_google_android_gms_internal_zzaax.f17459s) {
                if (!(com_google_android_gms_ads_internal_zza instanceof zzba)) {
                    com_google_android_gms_internal_zzyf = (((Boolean) zzkb.m6350f().m6488a(zznh.ab)).booleanValue() && zzq.m4913e() && !zzq.m4915g() && com_google_android_gms_internal_zzanh != null && com_google_android_gms_internal_zzanh.mo3474u().m5488c()) ? new zzyf(context, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzyb) : new zzyc(context, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzyb);
                }
            }
            if (com_google_android_gms_internal_zzaax.f17459s && (com_google_android_gms_ads_internal_zza instanceof zzba)) {
                com_google_android_gms_internal_zzyg = new zzyi(context, (zzba) com_google_android_gms_ads_internal_zza, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzyb, com_google_android_gms_internal_zznu);
            } else {
                com_google_android_gms_internal_zzyf = new zzyd(com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzyb);
            }
        }
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(com_google_android_gms_internal_zzyf.getClass().getName());
        zzakb.m5366b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        com_google_android_gms_internal_zzyf.mo1645e();
        return com_google_android_gms_internal_zzyf;
    }
}
