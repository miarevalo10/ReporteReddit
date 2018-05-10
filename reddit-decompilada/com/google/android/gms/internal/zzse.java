package com.google.android.gms.internal;

import android.os.Handler;
import java.util.LinkedList;
import java.util.List;

@zzzv
final class zzse {
    private final List<zztc> f7994a = new LinkedList();

    zzse() {
    }

    final void m6635a(zztd com_google_android_gms_internal_zztd) {
        Handler handler = zzahn.f6379a;
        for (zztc com_google_android_gms_internal_zztb : this.f7994a) {
            handler.post(new zztb(com_google_android_gms_internal_zztb, com_google_android_gms_internal_zztd));
        }
        this.f7994a.clear();
    }
}
