package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclv extends zzfjm<zzclv> {
    private static volatile zzclv[] f17932d;
    public Integer f17933a;
    public String f17934b;
    public zzclt f17935c;

    public zzclv() {
        this.f17933a = null;
        this.f17934b = null;
        this.f17935c = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzclv[] m18601b() {
        if (f17932d == null) {
            synchronized (zzfjq.f7554b) {
                if (f17932d == null) {
                    f17932d = new zzclv[0];
                }
            }
        }
        return f17932d;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17933a != null) {
            a += zzfjk.m6161b(1, this.f17933a.intValue());
        }
        if (this.f17934b != null) {
            a += zzfjk.m6163b(2, this.f17934b);
        }
        return this.f17935c != null ? a + zzfjk.m6162b(3, this.f17935c) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f17933a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 18) {
                this.f17934b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 26) {
                if (this.f17935c == null) {
                    this.f17935c = new zzclt();
                }
                com_google_android_gms_internal_zzfjj.m6137a(this.f17935c);
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17933a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17933a.intValue());
        }
        if (this.f17934b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17934b);
        }
        if (this.f17935c != null) {
            com_google_android_gms_internal_zzfjk.m6176a(3, this.f17935c);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclv)) {
            return false;
        }
        zzclv com_google_android_gms_internal_zzclv = (zzclv) obj;
        if (this.f17933a == null) {
            if (com_google_android_gms_internal_zzclv.f17933a != null) {
                return false;
            }
        } else if (!this.f17933a.equals(com_google_android_gms_internal_zzclv.f17933a)) {
            return false;
        }
        if (this.f17934b == null) {
            if (com_google_android_gms_internal_zzclv.f17934b != null) {
                return false;
            }
        } else if (!this.f17934b.equals(com_google_android_gms_internal_zzclv.f17934b)) {
            return false;
        }
        if (this.f17935c == null) {
            if (com_google_android_gms_internal_zzclv.f17935c != null) {
                return false;
            }
        } else if (!this.f17935c.equals(com_google_android_gms_internal_zzclv.f17935c)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclv.X);
            }
        }
        return com_google_android_gms_internal_zzclv.X == null || com_google_android_gms_internal_zzclv.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((527 + getClass().getName().hashCode()) * 31) + (this.f17933a == null ? 0 : this.f17933a.hashCode())) * 31) + (this.f17934b == null ? 0 : this.f17934b.hashCode());
        zzclt com_google_android_gms_internal_zzclt = this.f17935c;
        hashCode = ((hashCode * 31) + (com_google_android_gms_internal_zzclt == null ? 0 : com_google_android_gms_internal_zzclt.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
