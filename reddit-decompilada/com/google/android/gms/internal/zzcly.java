package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcly extends zzfjm<zzcly> {
    public Long f17945a;
    public String f17946b;
    public zzclz[] f17947c;
    public zzclx[] f17948d;
    public zzclr[] f17949e;
    private Integer f17950f;

    public zzcly() {
        this.f17945a = null;
        this.f17946b = null;
        this.f17950f = null;
        this.f17947c = zzclz.m18616b();
        this.f17948d = zzclx.m18609b();
        this.f17949e = zzclr.m18585b();
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int i;
        int a = super.mo1927a();
        if (this.f17945a != null) {
            a += zzfjk.m6168c(1, this.f17945a.longValue());
        }
        if (this.f17946b != null) {
            a += zzfjk.m6163b(2, this.f17946b);
        }
        if (this.f17950f != null) {
            a += zzfjk.m6161b(3, this.f17950f.intValue());
        }
        int i2 = 0;
        if (this.f17947c != null && this.f17947c.length > 0) {
            i = a;
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17947c) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    i += zzfjk.m6162b(4, com_google_android_gms_internal_zzfjs);
                }
            }
            a = i;
        }
        if (this.f17948d != null && this.f17948d.length > 0) {
            i = a;
            for (zzfjs com_google_android_gms_internal_zzfjs2 : this.f17948d) {
                if (com_google_android_gms_internal_zzfjs2 != null) {
                    i += zzfjk.m6162b(5, com_google_android_gms_internal_zzfjs2);
                }
            }
            a = i;
        }
        if (this.f17949e != null && this.f17949e.length > 0) {
            while (i2 < this.f17949e.length) {
                zzfjs com_google_android_gms_internal_zzfjs3 = this.f17949e[i2];
                if (com_google_android_gms_internal_zzfjs3 != null) {
                    a += zzfjk.m6162b(6, com_google_android_gms_internal_zzfjs3);
                }
                i2++;
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
                this.f17945a = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 18) {
                this.f17946b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 24) {
                this.f17950f = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 34) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 34);
                r1 = this.f17947c == null ? 0 : this.f17947c.length;
                r0 = new zzclz[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17947c, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzclz();
                    com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                r0[r1] = new zzclz();
                com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                this.f17947c = r0;
            } else if (a == 42) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 42);
                r1 = this.f17948d == null ? 0 : this.f17948d.length;
                r0 = new zzclx[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17948d, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzclx();
                    com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                r0[r1] = new zzclx();
                com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                this.f17948d = r0;
            } else if (a == 50) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 50);
                r1 = this.f17949e == null ? 0 : this.f17949e.length;
                r0 = new zzclr[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17949e, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzclr();
                    com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                r0[r1] = new zzclr();
                com_google_android_gms_internal_zzfjj.m6137a(r0[r1]);
                this.f17949e = r0;
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17945a != null) {
            com_google_android_gms_internal_zzfjk.m6181b(1, this.f17945a.longValue());
        }
        if (this.f17946b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17946b);
        }
        if (this.f17950f != null) {
            com_google_android_gms_internal_zzfjk.m6174a(3, this.f17950f.intValue());
        }
        int i = 0;
        if (this.f17947c != null && this.f17947c.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17947c) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(4, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17948d != null && this.f17948d.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs2 : this.f17948d) {
                if (com_google_android_gms_internal_zzfjs2 != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(5, com_google_android_gms_internal_zzfjs2);
                }
            }
        }
        if (this.f17949e != null && this.f17949e.length > 0) {
            while (i < this.f17949e.length) {
                zzfjs com_google_android_gms_internal_zzfjs3 = this.f17949e[i];
                if (com_google_android_gms_internal_zzfjs3 != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(6, com_google_android_gms_internal_zzfjs3);
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
        if (!(obj instanceof zzcly)) {
            return false;
        }
        zzcly com_google_android_gms_internal_zzcly = (zzcly) obj;
        if (this.f17945a == null) {
            if (com_google_android_gms_internal_zzcly.f17945a != null) {
                return false;
            }
        } else if (!this.f17945a.equals(com_google_android_gms_internal_zzcly.f17945a)) {
            return false;
        }
        if (this.f17946b == null) {
            if (com_google_android_gms_internal_zzcly.f17946b != null) {
                return false;
            }
        } else if (!this.f17946b.equals(com_google_android_gms_internal_zzcly.f17946b)) {
            return false;
        }
        if (this.f17950f == null) {
            if (com_google_android_gms_internal_zzcly.f17950f != null) {
                return false;
            }
        } else if (!this.f17950f.equals(com_google_android_gms_internal_zzcly.f17950f)) {
            return false;
        }
        if (!zzfjq.m6198a(this.f17947c, com_google_android_gms_internal_zzcly.f17947c) || !zzfjq.m6198a(this.f17948d, com_google_android_gms_internal_zzcly.f17948d) || !zzfjq.m6198a(this.f17949e, com_google_android_gms_internal_zzcly.f17949e)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcly.X);
            }
        }
        return com_google_android_gms_internal_zzcly.X == null || com_google_android_gms_internal_zzcly.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17945a == null ? 0 : this.f17945a.hashCode())) * 31) + (this.f17946b == null ? 0 : this.f17946b.hashCode())) * 31) + (this.f17950f == null ? 0 : this.f17950f.hashCode())) * 31) + zzfjq.m6195a(this.f17947c)) * 31) + zzfjq.m6195a(this.f17948d)) * 31) + zzfjq.m6195a(this.f17949e)) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
