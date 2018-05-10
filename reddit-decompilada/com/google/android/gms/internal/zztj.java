package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzak;
import com.google.android.gms.ads.internal.zzbs;

final class zztj {
    zzak f8012a;
    zzjj f8013b;
    zzse f8014c;
    long f8015d;
    boolean f8016e;
    boolean f8017f;
    private /* synthetic */ zzti f8018g;

    zztj(zzti com_google_android_gms_internal_zzti, zzsd com_google_android_gms_internal_zzsd, zzjj com_google_android_gms_internal_zzjj) {
        this(com_google_android_gms_internal_zzti, com_google_android_gms_internal_zzsd);
        this.f8013b = com_google_android_gms_internal_zzjj;
    }

    final boolean m6654a() {
        if (this.f8016e) {
            return false;
        }
        this.f8017f = this.f8012a.mo2003b(zztg.m6644b(this.f8013b != null ? this.f8013b : this.f8018g.f8008b));
        this.f8016e = true;
        this.f8015d = zzbs.m4492k().mo1632a();
        return true;
    }

    zztj(zzti com_google_android_gms_internal_zzti, zzsd com_google_android_gms_internal_zzsd) {
        this.f8018g = com_google_android_gms_internal_zzti;
        this.f8012a = new zzak(com_google_android_gms_internal_zzsd.f7990a.getApplicationContext(), new zzjn(), com_google_android_gms_internal_zzti.f8009c, com_google_android_gms_internal_zzsd.f7991b, com_google_android_gms_internal_zzsd.f7992c, com_google_android_gms_internal_zzsd.f7993d);
        this.f8014c = new zzse();
        com_google_android_gms_internal_zzti = this.f8014c;
        com_google_android_gms_internal_zzsd = this.f8012a;
        com_google_android_gms_internal_zzsd.mo1993a(new zzsf(com_google_android_gms_internal_zzti));
        com_google_android_gms_internal_zzsd.mo1994a(new zzsn(com_google_android_gms_internal_zzti));
        com_google_android_gms_internal_zzsd.mo1998a(new zzsp(com_google_android_gms_internal_zzti));
        com_google_android_gms_internal_zzsd.mo1992a(new zzsr(com_google_android_gms_internal_zzti));
        com_google_android_gms_internal_zzsd.mo1990a(new zzst(com_google_android_gms_internal_zzti));
    }
}
