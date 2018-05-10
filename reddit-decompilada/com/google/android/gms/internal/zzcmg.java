package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmg extends zzfjm<zzcmg> {
    private static volatile zzcmg[] f18010f;
    public Long f18011a;
    public String f18012b;
    public String f18013c;
    public Long f18014d;
    public Double f18015e;
    private Float f18016g;

    public zzcmg() {
        this.f18011a = null;
        this.f18012b = null;
        this.f18013c = null;
        this.f18014d = null;
        this.f18016g = null;
        this.f18015e = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzcmg[] m18642b() {
        if (f18010f == null) {
            synchronized (zzfjq.f7554b) {
                if (f18010f == null) {
                    f18010f = new zzcmg[0];
                }
            }
        }
        return f18010f;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18011a != null) {
            a += zzfjk.m6168c(1, this.f18011a.longValue());
        }
        if (this.f18012b != null) {
            a += zzfjk.m6163b(2, this.f18012b);
        }
        if (this.f18013c != null) {
            a += zzfjk.m6163b(3, this.f18013c);
        }
        if (this.f18014d != null) {
            a += zzfjk.m6168c(4, this.f18014d.longValue());
        }
        if (this.f18016g != null) {
            this.f18016g.floatValue();
            a += zzfjk.m6160b(5) + 4;
        }
        if (this.f18015e == null) {
            return a;
        }
        this.f18015e.doubleValue();
        return a + (zzfjk.m6160b(6) + 8);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f18011a = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 18) {
                this.f18012b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 26) {
                this.f18013c = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 32) {
                this.f18014d = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 45) {
                this.f18016g = Float.valueOf(Float.intBitsToFloat(com_google_android_gms_internal_zzfjj.m6148h()));
            } else if (a == 49) {
                this.f18015e = Double.valueOf(Double.longBitsToDouble(com_google_android_gms_internal_zzfjj.m6149i()));
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18011a != null) {
            com_google_android_gms_internal_zzfjk.m6181b(1, this.f18011a.longValue());
        }
        if (this.f18012b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f18012b);
        }
        if (this.f18013c != null) {
            com_google_android_gms_internal_zzfjk.m6177a(3, this.f18013c);
        }
        if (this.f18014d != null) {
            com_google_android_gms_internal_zzfjk.m6181b(4, this.f18014d.longValue());
        }
        if (this.f18016g != null) {
            com_google_android_gms_internal_zzfjk.m6173a(5, this.f18016g.floatValue());
        }
        if (this.f18015e != null) {
            com_google_android_gms_internal_zzfjk.m6172a(6, this.f18015e.doubleValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmg)) {
            return false;
        }
        zzcmg com_google_android_gms_internal_zzcmg = (zzcmg) obj;
        if (this.f18011a == null) {
            if (com_google_android_gms_internal_zzcmg.f18011a != null) {
                return false;
            }
        } else if (!this.f18011a.equals(com_google_android_gms_internal_zzcmg.f18011a)) {
            return false;
        }
        if (this.f18012b == null) {
            if (com_google_android_gms_internal_zzcmg.f18012b != null) {
                return false;
            }
        } else if (!this.f18012b.equals(com_google_android_gms_internal_zzcmg.f18012b)) {
            return false;
        }
        if (this.f18013c == null) {
            if (com_google_android_gms_internal_zzcmg.f18013c != null) {
                return false;
            }
        } else if (!this.f18013c.equals(com_google_android_gms_internal_zzcmg.f18013c)) {
            return false;
        }
        if (this.f18014d == null) {
            if (com_google_android_gms_internal_zzcmg.f18014d != null) {
                return false;
            }
        } else if (!this.f18014d.equals(com_google_android_gms_internal_zzcmg.f18014d)) {
            return false;
        }
        if (this.f18016g == null) {
            if (com_google_android_gms_internal_zzcmg.f18016g != null) {
                return false;
            }
        } else if (!this.f18016g.equals(com_google_android_gms_internal_zzcmg.f18016g)) {
            return false;
        }
        if (this.f18015e == null) {
            if (com_google_android_gms_internal_zzcmg.f18015e != null) {
                return false;
            }
        } else if (!this.f18015e.equals(com_google_android_gms_internal_zzcmg.f18015e)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcmg.X);
            }
        }
        return com_google_android_gms_internal_zzcmg.X == null || com_google_android_gms_internal_zzcmg.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((527 + getClass().getName().hashCode()) * 31) + (this.f18011a == null ? 0 : this.f18011a.hashCode())) * 31) + (this.f18012b == null ? 0 : this.f18012b.hashCode())) * 31) + (this.f18013c == null ? 0 : this.f18013c.hashCode())) * 31) + (this.f18014d == null ? 0 : this.f18014d.hashCode())) * 31) + (this.f18016g == null ? 0 : this.f18016g.hashCode())) * 31) + (this.f18015e == null ? 0 : this.f18015e.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
