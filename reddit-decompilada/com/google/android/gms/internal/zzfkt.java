package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkt extends zzfjm<zzfkt> {
    private static volatile zzfkt[] f18098b;
    public String f18099a;

    public zzfkt() {
        this.f18099a = "";
        this.X = null;
        this.Y = -1;
    }

    public static zzfkt[] m18740b() {
        if (f18098b == null) {
            synchronized (zzfjq.f7554b) {
                if (f18098b == null) {
                    f18098b = new zzfkt[0];
                }
            }
        }
        return f18098b;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        return (this.f18099a == null || this.f18099a.equals("")) ? a : a + zzfjk.m6163b(1, this.f18099a);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f18099a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (!(this.f18099a == null || this.f18099a.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f18099a);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
