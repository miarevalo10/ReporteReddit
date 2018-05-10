package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmc extends zzfjm<zzcmc> {
    private static volatile zzcmc[] f17965e;
    public String f17966a;
    public String f17967b;
    public Long f17968c;
    public Double f17969d;
    private Float f17970f;

    public zzcmc() {
        this.f17966a = null;
        this.f17967b = null;
        this.f17968c = null;
        this.f17970f = null;
        this.f17969d = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzcmc[] m18628b() {
        if (f17965e == null) {
            synchronized (zzfjq.f7554b) {
                if (f17965e == null) {
                    f17965e = new zzcmc[0];
                }
            }
        }
        return f17965e;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17966a != null) {
            a += zzfjk.m6163b(1, this.f17966a);
        }
        if (this.f17967b != null) {
            a += zzfjk.m6163b(2, this.f17967b);
        }
        if (this.f17968c != null) {
            a += zzfjk.m6168c(3, this.f17968c.longValue());
        }
        if (this.f17970f != null) {
            this.f17970f.floatValue();
            a += zzfjk.m6160b(4) + 4;
        }
        if (this.f17969d == null) {
            return a;
        }
        this.f17969d.doubleValue();
        return a + (zzfjk.m6160b(5) + 8);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f17966a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 18) {
                this.f17967b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 24) {
                this.f17968c = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 37) {
                this.f17970f = Float.valueOf(Float.intBitsToFloat(com_google_android_gms_internal_zzfjj.m6148h()));
            } else if (a == 41) {
                this.f17969d = Double.valueOf(Double.longBitsToDouble(com_google_android_gms_internal_zzfjj.m6149i()));
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17966a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f17966a);
        }
        if (this.f17967b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17967b);
        }
        if (this.f17968c != null) {
            com_google_android_gms_internal_zzfjk.m6181b(3, this.f17968c.longValue());
        }
        if (this.f17970f != null) {
            com_google_android_gms_internal_zzfjk.m6173a(4, this.f17970f.floatValue());
        }
        if (this.f17969d != null) {
            com_google_android_gms_internal_zzfjk.m6172a(5, this.f17969d.doubleValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmc)) {
            return false;
        }
        zzcmc com_google_android_gms_internal_zzcmc = (zzcmc) obj;
        if (this.f17966a == null) {
            if (com_google_android_gms_internal_zzcmc.f17966a != null) {
                return false;
            }
        } else if (!this.f17966a.equals(com_google_android_gms_internal_zzcmc.f17966a)) {
            return false;
        }
        if (this.f17967b == null) {
            if (com_google_android_gms_internal_zzcmc.f17967b != null) {
                return false;
            }
        } else if (!this.f17967b.equals(com_google_android_gms_internal_zzcmc.f17967b)) {
            return false;
        }
        if (this.f17968c == null) {
            if (com_google_android_gms_internal_zzcmc.f17968c != null) {
                return false;
            }
        } else if (!this.f17968c.equals(com_google_android_gms_internal_zzcmc.f17968c)) {
            return false;
        }
        if (this.f17970f == null) {
            if (com_google_android_gms_internal_zzcmc.f17970f != null) {
                return false;
            }
        } else if (!this.f17970f.equals(com_google_android_gms_internal_zzcmc.f17970f)) {
            return false;
        }
        if (this.f17969d == null) {
            if (com_google_android_gms_internal_zzcmc.f17969d != null) {
                return false;
            }
        } else if (!this.f17969d.equals(com_google_android_gms_internal_zzcmc.f17969d)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcmc.X);
            }
        }
        return com_google_android_gms_internal_zzcmc.X == null || com_google_android_gms_internal_zzcmc.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17966a == null ? 0 : this.f17966a.hashCode())) * 31) + (this.f17967b == null ? 0 : this.f17967b.hashCode())) * 31) + (this.f17968c == null ? 0 : this.f17968c.hashCode())) * 31) + (this.f17970f == null ? 0 : this.f17970f.hashCode())) * 31) + (this.f17969d == null ? 0 : this.f17969d.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
