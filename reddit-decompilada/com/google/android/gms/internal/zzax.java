package com.google.android.gms.internal;

import java.io.IOException;

public final class zzax extends zzfjm<zzax> {
    public String f17610a;
    private String f17611b;
    private String f17612c;
    private String f17613d;
    private String f17614e;

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17610a != null) {
            a += zzfjk.m6163b(1, this.f17610a);
        }
        if (this.f17611b != null) {
            a += zzfjk.m6163b(2, this.f17611b);
        }
        if (this.f17612c != null) {
            a += zzfjk.m6163b(3, this.f17612c);
        }
        if (this.f17613d != null) {
            a += zzfjk.m6163b(4, this.f17613d);
        }
        return this.f17614e != null ? a + zzfjk.m6163b(5, this.f17614e) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f17610a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 18) {
                this.f17611b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 26) {
                this.f17612c = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 34) {
                this.f17613d = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 42) {
                this.f17614e = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17610a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f17610a);
        }
        if (this.f17611b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17611b);
        }
        if (this.f17612c != null) {
            com_google_android_gms_internal_zzfjk.m6177a(3, this.f17612c);
        }
        if (this.f17613d != null) {
            com_google_android_gms_internal_zzfjk.m6177a(4, this.f17613d);
        }
        if (this.f17614e != null) {
            com_google_android_gms_internal_zzfjk.m6177a(5, this.f17614e);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
