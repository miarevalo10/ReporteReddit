package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjy extends zzfjm<zzfjy> {
    private static volatile zzfjy[] f18062c;
    public byte[] f18063a;
    public byte[] f18064b;

    public zzfjy() {
        this.f18063a = null;
        this.f18064b = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzfjy[] m18712b() {
        if (f18062c == null) {
            synchronized (zzfjq.f7554b) {
                if (f18062c == null) {
                    f18062c = new zzfjy[0];
                }
            }
        }
        return f18062c;
    }

    protected final int mo1927a() {
        int a = super.mo1927a() + zzfjk.m6164b(1, this.f18063a);
        return this.f18064b != null ? a + zzfjk.m6164b(2, this.f18064b) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f18063a = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 18) {
                this.f18064b = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        com_google_android_gms_internal_zzfjk.m6179a(1, this.f18063a);
        if (this.f18064b != null) {
            com_google_android_gms_internal_zzfjk.m6179a(2, this.f18064b);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
