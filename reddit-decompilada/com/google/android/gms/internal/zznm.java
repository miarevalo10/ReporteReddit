package com.google.android.gms.internal;

import android.text.TextUtils;

@zzzv
public final class zznm {
    public static zznk m6497a(zznj com_google_android_gms_internal_zznj) {
        if (!com_google_android_gms_internal_zznj.f7919a) {
            zzagf.m13278a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (com_google_android_gms_internal_zznj.f7922d == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(com_google_android_gms_internal_zznj.f7923e)) {
            return new zznk(com_google_android_gms_internal_zznj.f7922d, com_google_android_gms_internal_zznj.f7923e, com_google_android_gms_internal_zznj.f7920b, com_google_android_gms_internal_zznj.f7921c);
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
