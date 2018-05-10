package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclr extends zzfjm<zzclr> {
    private static volatile zzclr[] f17912d;
    public Integer f17913a;
    public zzclv[] f17914b;
    public zzcls[] f17915c;

    public zzclr() {
        this.f17913a = null;
        this.f17914b = zzclv.m18601b();
        this.f17915c = zzcls.m18589b();
        this.X = null;
        this.Y = -1;
    }

    public static zzclr[] m18585b() {
        if (f17912d == null) {
            synchronized (zzfjq.f7554b) {
                if (f17912d == null) {
                    f17912d = new zzclr[0];
                }
            }
        }
        return f17912d;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17913a != null) {
            a += zzfjk.m6161b(1, this.f17913a.intValue());
        }
        int i = 0;
        if (this.f17914b != null && this.f17914b.length > 0) {
            int i2 = a;
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17914b) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    i2 += zzfjk.m6162b(2, com_google_android_gms_internal_zzfjs);
                }
            }
            a = i2;
        }
        if (this.f17915c != null && this.f17915c.length > 0) {
            while (i < this.f17915c.length) {
                zzfjs com_google_android_gms_internal_zzfjs2 = this.f17915c[i];
                if (com_google_android_gms_internal_zzfjs2 != null) {
                    a += zzfjk.m6162b(3, com_google_android_gms_internal_zzfjs2);
                }
                i++;
            }
        }
        return a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f17913a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 18) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 18);
                r1 = this.f17914b == null ? 0 : this.f17914b.length;
                r0 = new zzclv[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17914b, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzclv();
                    com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                r0[r1] = new zzclv();
                com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                this.f17914b = r0;
            } else if (a == 26) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 26);
                r1 = this.f17915c == null ? 0 : this.f17915c.length;
                r0 = new zzcls[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17915c, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzcls();
                    com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                r0[r1] = new zzcls();
                com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                this.f17915c = r0;
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17913a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17913a.intValue());
        }
        int i = 0;
        if (this.f17914b != null && this.f17914b.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17914b) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(2, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17915c != null && this.f17915c.length > 0) {
            while (i < this.f17915c.length) {
                zzfjs com_google_android_gms_internal_zzfjs2 = this.f17915c[i];
                if (com_google_android_gms_internal_zzfjs2 != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(3, com_google_android_gms_internal_zzfjs2);
                }
                i++;
            }
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclr)) {
            return false;
        }
        zzclr com_google_android_gms_internal_zzclr = (zzclr) obj;
        if (this.f17913a == null) {
            if (com_google_android_gms_internal_zzclr.f17913a != null) {
                return false;
            }
        } else if (!this.f17913a.equals(com_google_android_gms_internal_zzclr.f17913a)) {
            return false;
        }
        if (!zzfjq.m6198a(this.f17914b, com_google_android_gms_internal_zzclr.f17914b) || !zzfjq.m6198a(this.f17915c, com_google_android_gms_internal_zzclr.f17915c)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclr.X);
            }
        }
        return com_google_android_gms_internal_zzclr.X == null || com_google_android_gms_internal_zzclr.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((527 + getClass().getName().hashCode()) * 31) + (this.f17913a == null ? 0 : this.f17913a.hashCode())) * 31) + zzfjq.m6195a(this.f17914b)) * 31) + zzfjq.m6195a(this.f17915c)) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
