package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.LinkedList;

@zzzv
final class zzti {
    final LinkedList<zztj> f8007a = new LinkedList();
    zzjj f8008b;
    final String f8009c;
    final int f8010d;
    boolean f8011e;

    zzti(zzjj com_google_android_gms_internal_zzjj, String str, int i) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzjj);
        zzbq.m4808a((Object) str);
        this.f8008b = com_google_android_gms_internal_zzjj;
        this.f8009c = str;
        this.f8010d = i;
    }

    final zztj m6653a(zzjj com_google_android_gms_internal_zzjj) {
        if (com_google_android_gms_internal_zzjj != null) {
            this.f8008b = com_google_android_gms_internal_zzjj;
        }
        return (zztj) this.f8007a.remove();
    }
}
