package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import java.util.Map;

final class zzav implements zzt<zzanh> {
    private /* synthetic */ zzvj f13777a;
    private /* synthetic */ zzab f13778b;
    private /* synthetic */ zzvm f13779c;

    zzav(zzvj com_google_android_gms_internal_zzvj, zzab com_google_android_gms_ads_internal_zzab, zzvm com_google_android_gms_internal_zzvm) {
        this.f13777a = com_google_android_gms_internal_zzvj;
        this.f13778b = com_google_android_gms_ads_internal_zzab;
        this.f13779c = com_google_android_gms_internal_zzvm;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        Object obj2 = (View) com_google_android_gms_internal_zzanh;
        if (obj2 != null) {
            try {
                if (this.f13777a == null) {
                    if (this.f13779c != null) {
                        if (this.f13779c.mo2239i()) {
                            zzaq.m4465a(com_google_android_gms_internal_zzanh);
                        } else {
                            this.f13779c.mo2229a(zzn.m17692a(obj2));
                            this.f13778b.f5496a.mo1263e();
                        }
                    }
                } else if (this.f13777a.mo2221k()) {
                    zzaq.m4465a(com_google_android_gms_internal_zzanh);
                } else {
                    this.f13777a.mo2209a(zzn.m17692a(obj2));
                    this.f13778b.f5496a.mo1263e();
                }
            } catch (Throwable e) {
                zzakb.m5369c("Unable to call handleClick on mapper", e);
            }
        }
    }
}
