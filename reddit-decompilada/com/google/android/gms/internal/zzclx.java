package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclx extends zzfjm<zzclx> {
    private static volatile zzclx[] f17940e;
    public String f17941a;
    public Boolean f17942b;
    public Boolean f17943c;
    public Integer f17944d;

    public zzclx() {
        this.f17941a = null;
        this.f17942b = null;
        this.f17943c = null;
        this.f17944d = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzclx[] m18609b() {
        if (f17940e == null) {
            synchronized (zzfjq.f7554b) {
                if (f17940e == null) {
                    f17940e = new zzclx[0];
                }
            }
        }
        return f17940e;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17941a != null) {
            a += zzfjk.m6163b(1, this.f17941a);
        }
        if (this.f17942b != null) {
            this.f17942b.booleanValue();
            a += zzfjk.m6160b(2) + 1;
        }
        if (this.f17943c != null) {
            this.f17943c.booleanValue();
            a += zzfjk.m6160b(3) + 1;
        }
        return this.f17944d != null ? a + zzfjk.m6161b(4, this.f17944d.intValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f17941a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 16) {
                this.f17942b = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
            } else if (a == 24) {
                this.f17943c = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
            } else if (a == 32) {
                this.f17944d = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17941a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f17941a);
        }
        if (this.f17942b != null) {
            com_google_android_gms_internal_zzfjk.m6178a(2, this.f17942b.booleanValue());
        }
        if (this.f17943c != null) {
            com_google_android_gms_internal_zzfjk.m6178a(3, this.f17943c.booleanValue());
        }
        if (this.f17944d != null) {
            com_google_android_gms_internal_zzfjk.m6174a(4, this.f17944d.intValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclx)) {
            return false;
        }
        zzclx com_google_android_gms_internal_zzclx = (zzclx) obj;
        if (this.f17941a == null) {
            if (com_google_android_gms_internal_zzclx.f17941a != null) {
                return false;
            }
        } else if (!this.f17941a.equals(com_google_android_gms_internal_zzclx.f17941a)) {
            return false;
        }
        if (this.f17942b == null) {
            if (com_google_android_gms_internal_zzclx.f17942b != null) {
                return false;
            }
        } else if (!this.f17942b.equals(com_google_android_gms_internal_zzclx.f17942b)) {
            return false;
        }
        if (this.f17943c == null) {
            if (com_google_android_gms_internal_zzclx.f17943c != null) {
                return false;
            }
        } else if (!this.f17943c.equals(com_google_android_gms_internal_zzclx.f17943c)) {
            return false;
        }
        if (this.f17944d == null) {
            if (com_google_android_gms_internal_zzclx.f17944d != null) {
                return false;
            }
        } else if (!this.f17944d.equals(com_google_android_gms_internal_zzclx.f17944d)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclx.X);
            }
        }
        return com_google_android_gms_internal_zzclx.X == null || com_google_android_gms_internal_zzclx.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17941a == null ? 0 : this.f17941a.hashCode())) * 31) + (this.f17942b == null ? 0 : this.f17942b.hashCode())) * 31) + (this.f17943c == null ? 0 : this.f17943c.hashCode())) * 31) + (this.f17944d == null ? 0 : this.f17944d.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
