package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbe extends zzfjm<zzbe> {
    public Long f17703a;
    private String f17704b;
    private byte[] f17705c;

    public zzbe() {
        this.f17703a = null;
        this.f17704b = null;
        this.f17705c = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17703a != null) {
            a += zzfjk.m6168c(1, this.f17703a.longValue());
        }
        if (this.f17704b != null) {
            a += zzfjk.m6163b(3, this.f17704b);
        }
        return this.f17705c != null ? a + zzfjk.m6164b(4, this.f17705c) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f17703a = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 26) {
                this.f17704b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 34) {
                this.f17705c = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17703a != null) {
            com_google_android_gms_internal_zzfjk.m6181b(1, this.f17703a.longValue());
        }
        if (this.f17704b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(3, this.f17704b);
        }
        if (this.f17705c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(4, this.f17705c);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
