package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkf extends zzfjm<zzfkf> {
    public String f18095a;
    public Long f18096b;
    public Boolean f18097c;

    public zzfkf() {
        this.f18095a = null;
        this.f18096b = null;
        this.f18097c = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18095a != null) {
            a += zzfjk.m6163b(1, this.f18095a);
        }
        if (this.f18096b != null) {
            a += zzfjk.m6168c(2, this.f18096b.longValue());
        }
        if (this.f18097c == null) {
            return a;
        }
        this.f18097c.booleanValue();
        return a + (zzfjk.m6160b(3) + 1);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18095a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f18095a);
        }
        if (this.f18096b != null) {
            com_google_android_gms_internal_zzfjk.m6181b(2, this.f18096b.longValue());
        }
        if (this.f18097c != null) {
            com_google_android_gms_internal_zzfjk.m6178a(3, this.f18097c.booleanValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f18095a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 16) {
                this.f18096b = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 24) {
                this.f18097c = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }
}
