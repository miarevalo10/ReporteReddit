package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzg;

final class zzffi implements zzfji {
    private final zzffg f14437a;

    private zzffi(zzffg com_google_android_gms_internal_zzffg) {
        this.f14437a = (zzffg) zzffz.m6014a(com_google_android_gms_internal_zzffg, "output");
    }

    public static zzffi m13823a(zzffg com_google_android_gms_internal_zzffg) {
        return com_google_android_gms_internal_zzffg.f14436c != null ? com_google_android_gms_internal_zzffg.f14436c : new zzffi(com_google_android_gms_internal_zzffg);
    }

    public final int mo1895a() {
        return zzg.f7413k;
    }

    public final void mo1896a(int i, Object obj) {
        try {
            if (obj instanceof zzfes) {
                this.f14437a.mo3527b(i, (zzfes) obj);
            } else {
                this.f14437a.mo3528b(i, (zzfhe) obj);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
