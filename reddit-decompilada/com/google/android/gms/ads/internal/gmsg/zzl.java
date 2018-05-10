package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import java.util.Map;

final class zzl implements zzt<zzanh> {
    zzl() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        zzd s = com_google_android_gms_internal_zzanh.mo4011s();
        if (s != null) {
            s.m17401a();
            return;
        }
        zzd t = com_google_android_gms_internal_zzanh.mo4017t();
        if (t != null) {
            t.m17401a();
        } else {
            zzakb.m5371e("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
