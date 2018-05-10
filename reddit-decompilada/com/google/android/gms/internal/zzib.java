package com.google.android.gms.internal;

import java.util.Comparator;

public final class zzib implements Comparator<zzhp> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzhp com_google_android_gms_internal_zzhp = (zzhp) obj;
        zzhp com_google_android_gms_internal_zzhp2 = (zzhp) obj2;
        if (com_google_android_gms_internal_zzhp.f7697b < com_google_android_gms_internal_zzhp2.f7697b) {
            return -1;
        }
        if (com_google_android_gms_internal_zzhp.f7697b > com_google_android_gms_internal_zzhp2.f7697b) {
            return 1;
        }
        if (com_google_android_gms_internal_zzhp.f7696a < com_google_android_gms_internal_zzhp2.f7696a) {
            return -1;
        }
        if (com_google_android_gms_internal_zzhp.f7696a > com_google_android_gms_internal_zzhp2.f7696a) {
            return 1;
        }
        float f = (com_google_android_gms_internal_zzhp.f7699d - com_google_android_gms_internal_zzhp.f7697b) * (com_google_android_gms_internal_zzhp.f7698c - com_google_android_gms_internal_zzhp.f7696a);
        obj = (com_google_android_gms_internal_zzhp2.f7699d - com_google_android_gms_internal_zzhp2.f7697b) * (com_google_android_gms_internal_zzhp2.f7698c - com_google_android_gms_internal_zzhp2.f7696a);
        if (f > obj) {
            return -1;
        }
        if (f < obj) {
            return 1;
        }
        return null;
    }
}
