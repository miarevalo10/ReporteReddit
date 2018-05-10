package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmb extends zzfjm<zzcmb> {
    private static volatile zzcmb[] f17959f;
    public zzcmc[] f17960a;
    public String f17961b;
    public Long f17962c;
    public Long f17963d;
    public Integer f17964e;

    public zzcmb() {
        this.f17960a = zzcmc.m18628b();
        this.f17961b = null;
        this.f17962c = null;
        this.f17963d = null;
        this.f17964e = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzcmb[] m18624b() {
        if (f17959f == null) {
            synchronized (zzfjq.f7554b) {
                if (f17959f == null) {
                    f17959f = new zzcmb[0];
                }
            }
        }
        return f17959f;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17960a != null && this.f17960a.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17960a) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    a += zzfjk.m6162b(1, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17961b != null) {
            a += zzfjk.m6163b(2, this.f17961b);
        }
        if (this.f17962c != null) {
            a += zzfjk.m6168c(3, this.f17962c.longValue());
        }
        if (this.f17963d != null) {
            a += zzfjk.m6168c(4, this.f17963d.longValue());
        }
        return this.f17964e != null ? a + zzfjk.m6161b(5, this.f17964e.intValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 10);
                int length = this.f17960a == null ? 0 : this.f17960a.length;
                Object obj = new zzcmc[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f17960a, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzcmc();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    length++;
                }
                obj[length] = new zzcmc();
                com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                this.f17960a = obj;
            } else if (a == 18) {
                this.f17961b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 24) {
                this.f17962c = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 32) {
                this.f17963d = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 40) {
                this.f17964e = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17960a != null && this.f17960a.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17960a) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(1, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17961b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17961b);
        }
        if (this.f17962c != null) {
            com_google_android_gms_internal_zzfjk.m6181b(3, this.f17962c.longValue());
        }
        if (this.f17963d != null) {
            com_google_android_gms_internal_zzfjk.m6181b(4, this.f17963d.longValue());
        }
        if (this.f17964e != null) {
            com_google_android_gms_internal_zzfjk.m6174a(5, this.f17964e.intValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmb)) {
            return false;
        }
        zzcmb com_google_android_gms_internal_zzcmb = (zzcmb) obj;
        if (!zzfjq.m6198a(this.f17960a, com_google_android_gms_internal_zzcmb.f17960a)) {
            return false;
        }
        if (this.f17961b == null) {
            if (com_google_android_gms_internal_zzcmb.f17961b != null) {
                return false;
            }
        } else if (!this.f17961b.equals(com_google_android_gms_internal_zzcmb.f17961b)) {
            return false;
        }
        if (this.f17962c == null) {
            if (com_google_android_gms_internal_zzcmb.f17962c != null) {
                return false;
            }
        } else if (!this.f17962c.equals(com_google_android_gms_internal_zzcmb.f17962c)) {
            return false;
        }
        if (this.f17963d == null) {
            if (com_google_android_gms_internal_zzcmb.f17963d != null) {
                return false;
            }
        } else if (!this.f17963d.equals(com_google_android_gms_internal_zzcmb.f17963d)) {
            return false;
        }
        if (this.f17964e == null) {
            if (com_google_android_gms_internal_zzcmb.f17964e != null) {
                return false;
            }
        } else if (!this.f17964e.equals(com_google_android_gms_internal_zzcmb.f17964e)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcmb.X);
            }
        }
        return com_google_android_gms_internal_zzcmb.X == null || com_google_android_gms_internal_zzcmb.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((527 + getClass().getName().hashCode()) * 31) + zzfjq.m6195a(this.f17960a)) * 31) + (this.f17961b == null ? 0 : this.f17961b.hashCode())) * 31) + (this.f17962c == null ? 0 : this.f17962c.hashCode())) * 31) + (this.f17963d == null ? 0 : this.f17963d.hashCode())) * 31) + (this.f17964e == null ? 0 : this.f17964e.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
