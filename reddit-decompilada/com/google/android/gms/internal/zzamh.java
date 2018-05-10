package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;

@zzzv
public final class zzamh extends zzamc {
    public final zzamb mo1750a(Context context, zzamp com_google_android_gms_internal_zzamp, boolean z, zznu com_google_android_gms_internal_zznu) {
        Object obj;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            if (applicationInfo.targetSdkVersion < 11) {
                obj = null;
                if (obj == null) {
                    return null;
                }
                return new zzalr(context, z, com_google_android_gms_internal_zzamp.mo3474u().m5488c(), new zzamq(context, com_google_android_gms_internal_zzamp.mo3472k(), com_google_android_gms_internal_zzamp.mo3470i(), com_google_android_gms_internal_zznu, com_google_android_gms_internal_zzamp.mo3466c()));
            }
        }
        obj = 1;
        if (obj == null) {
            return null;
        }
        return new zzalr(context, z, com_google_android_gms_internal_zzamp.mo3474u().m5488c(), new zzamq(context, com_google_android_gms_internal_zzamp.mo3472k(), com_google_android_gms_internal_zzamp.mo3470i(), com_google_android_gms_internal_zznu, com_google_android_gms_internal_zzamp.mo3466c()));
    }
}
