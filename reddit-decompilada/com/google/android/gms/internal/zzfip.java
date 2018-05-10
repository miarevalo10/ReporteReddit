package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzg;

final class zzfip extends zzfin<zzfio, zzfio> {
    zzfip() {
    }

    final /* synthetic */ Object mo1920a(Object obj) {
        return ((zzffu) obj).f19235g;
    }

    final /* synthetic */ int mo1922b(Object obj) {
        zzfio com_google_android_gms_internal_zzfio = (zzfio) obj;
        int i = com_google_android_gms_internal_zzfio.f7469d;
        if (i != -1) {
            return i;
        }
        i = 0;
        int i2 = 0;
        while (i < com_google_android_gms_internal_zzfio.f7466a) {
            i2 += zzffg.m13782d(com_google_android_gms_internal_zzfio.f7467b[i] >>> 3, (zzfes) com_google_android_gms_internal_zzfio.f7468c[i]);
            i++;
        }
        com_google_android_gms_internal_zzfio.f7469d = i2;
        return i2;
    }

    final /* synthetic */ void mo1921a(Object obj, zzfji com_google_android_gms_internal_zzfji) {
        zzfio com_google_android_gms_internal_zzfio = (zzfio) obj;
        int i;
        if (com_google_android_gms_internal_zzfji.mo1895a() == zzg.f7414l) {
            for (i = com_google_android_gms_internal_zzfio.f7466a - 1; i >= 0; i--) {
                com_google_android_gms_internal_zzfji.mo1896a(com_google_android_gms_internal_zzfio.f7467b[i] >>> 3, com_google_android_gms_internal_zzfio.f7468c[i]);
            }
            return;
        }
        for (i = 0; i < com_google_android_gms_internal_zzfio.f7466a; i++) {
            com_google_android_gms_internal_zzfji.mo1896a(com_google_android_gms_internal_zzfio.f7467b[i] >>> 3, com_google_android_gms_internal_zzfio.f7468c[i]);
        }
    }
}
