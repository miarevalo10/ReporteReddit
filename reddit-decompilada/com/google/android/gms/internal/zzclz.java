package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclz extends zzfjm<zzclz> {
    private static volatile zzclz[] f17951c;
    public String f17952a;
    public String f17953b;

    public zzclz() {
        this.f17952a = null;
        this.f17953b = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzclz[] m18616b() {
        if (f17951c == null) {
            synchronized (zzfjq.f7554b) {
                if (f17951c == null) {
                    f17951c = new zzclz[0];
                }
            }
        }
        return f17951c;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17952a != null) {
            a += zzfjk.m6163b(1, this.f17952a);
        }
        return this.f17953b != null ? a + zzfjk.m6163b(2, this.f17953b) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f17952a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 18) {
                this.f17953b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17952a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f17952a);
        }
        if (this.f17953b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17953b);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclz)) {
            return false;
        }
        zzclz com_google_android_gms_internal_zzclz = (zzclz) obj;
        if (this.f17952a == null) {
            if (com_google_android_gms_internal_zzclz.f17952a != null) {
                return false;
            }
        } else if (!this.f17952a.equals(com_google_android_gms_internal_zzclz.f17952a)) {
            return false;
        }
        if (this.f17953b == null) {
            if (com_google_android_gms_internal_zzclz.f17953b != null) {
                return false;
            }
        } else if (!this.f17953b.equals(com_google_android_gms_internal_zzclz.f17953b)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclz.X);
            }
        }
        return com_google_android_gms_internal_zzclz.X == null || com_google_android_gms_internal_zzclz.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((527 + getClass().getName().hashCode()) * 31) + (this.f17952a == null ? 0 : this.f17952a.hashCode())) * 31) + (this.f17953b == null ? 0 : this.f17953b.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
