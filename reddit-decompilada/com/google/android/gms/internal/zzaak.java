package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzi;

final class zzaak implements zzaam {
    private /* synthetic */ Context f14026a;

    zzaak(Context context) {
        this.f14026a = context;
    }

    public final boolean mo1642a(zzakd com_google_android_gms_internal_zzakd) {
        zzkb.m6345a();
        boolean c = zzajr.m5335c(this.f14026a);
        boolean z = ((Boolean) zzkb.m6350f().m6488a(zznh.cK)).booleanValue() && com_google_android_gms_internal_zzakd.f17554d;
        if (!zzaaj.m4977a(this.f14026a, com_google_android_gms_internal_zzakd.f17554d) || !c || z) {
            return true;
        }
        if (zzi.m4903b(this.f14026a)) {
            if (!((Boolean) zzkb.m6350f().m6488a(zznh.f7868D)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
