package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbb extends zzfjm<zzbb> {
    public Long f17689a;
    public Long f17690b;
    public Long f17691c;
    private Long f17692d;
    private Long f17693e;

    public zzbb() {
        this.f17692d = null;
        this.f17693e = null;
        this.f17689a = null;
        this.f17690b = null;
        this.f17691c = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17692d != null) {
            a += zzfjk.m6168c(1, this.f17692d.longValue());
        }
        if (this.f17693e != null) {
            a += zzfjk.m6168c(2, this.f17693e.longValue());
        }
        if (this.f17689a != null) {
            a += zzfjk.m6168c(3, this.f17689a.longValue());
        }
        if (this.f17690b != null) {
            a += zzfjk.m6168c(4, this.f17690b.longValue());
        }
        return this.f17691c != null ? a + zzfjk.m6168c(5, this.f17691c.longValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f17692d = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 16) {
                this.f17693e = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 24) {
                this.f17689a = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 32) {
                this.f17690b = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 40) {
                this.f17691c = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17692d != null) {
            com_google_android_gms_internal_zzfjk.m6181b(1, this.f17692d.longValue());
        }
        if (this.f17693e != null) {
            com_google_android_gms_internal_zzfjk.m6181b(2, this.f17693e.longValue());
        }
        if (this.f17689a != null) {
            com_google_android_gms_internal_zzfjk.m6181b(3, this.f17689a.longValue());
        }
        if (this.f17690b != null) {
            com_google_android_gms_internal_zzfjk.m6181b(4, this.f17690b.longValue());
        }
        if (this.f17691c != null) {
            com_google_android_gms_internal_zzfjk.m6181b(5, this.f17691c.longValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
