package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.zzc;
import com.google.android.gms.dynamite.DynamiteModule.zzd;

final class zzg implements zzd {
    zzg() {
    }

    public final zzj mo1637a(Context context, String str, zzi com_google_android_gms_dynamite_zzi) throws zzc {
        zzj com_google_android_gms_dynamite_zzj = new zzj();
        com_google_android_gms_dynamite_zzj.f5998a = com_google_android_gms_dynamite_zzi.mo1635a(context, str);
        com_google_android_gms_dynamite_zzj.f5999b = com_google_android_gms_dynamite_zzj.f5998a != 0 ? com_google_android_gms_dynamite_zzi.mo1636a(context, str, false) : com_google_android_gms_dynamite_zzi.mo1636a(context, str, true);
        if (com_google_android_gms_dynamite_zzj.f5998a == 0 && com_google_android_gms_dynamite_zzj.f5999b == 0) {
            com_google_android_gms_dynamite_zzj.f6000c = 0;
            return com_google_android_gms_dynamite_zzj;
        } else if (com_google_android_gms_dynamite_zzj.f5999b >= com_google_android_gms_dynamite_zzj.f5998a) {
            com_google_android_gms_dynamite_zzj.f6000c = 1;
            return com_google_android_gms_dynamite_zzj;
        } else {
            com_google_android_gms_dynamite_zzj.f6000c = -1;
            return com_google_android_gms_dynamite_zzj;
        }
    }
}
