package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.Callable;

final class zzacr implements Callable<zzaco> {
    private /* synthetic */ Context f6217a;
    private /* synthetic */ zzacq f6218b;

    zzacr(zzacq com_google_android_gms_internal_zzacq, Context context) {
        this.f6218b = com_google_android_gms_internal_zzacq;
        this.f6217a = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzaco a;
        zzacs com_google_android_gms_internal_zzacs = (zzacs) this.f6218b.f6216a.get(this.f6217a);
        if (com_google_android_gms_internal_zzacs != null) {
            if ((com_google_android_gms_internal_zzacs.f6219a + ((Long) zzkb.m6350f().m6488a(zznh.bc)).longValue() < zzbs.m4492k().mo1632a() ? 1 : null) == null) {
                if (((Boolean) zzkb.m6350f().m6488a(zznh.bb)).booleanValue()) {
                    a = new zzacp(this.f6217a, com_google_android_gms_internal_zzacs.f6220b).m5012a();
                    this.f6218b.f6216a.put(this.f6217a, new zzacs(a));
                    return a;
                }
            }
        }
        a = new zzacp(this.f6217a).m5012a();
        this.f6218b.f6216a.put(this.f6217a, new zzacs(a));
        return a;
    }
}
