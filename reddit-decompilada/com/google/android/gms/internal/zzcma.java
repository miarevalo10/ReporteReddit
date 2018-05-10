package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcma extends zzfjm<zzcma> {
    private static volatile zzcma[] f17954e;
    public Integer f17955a;
    public zzcmf f17956b;
    public zzcmf f17957c;
    public Boolean f17958d;

    public zzcma() {
        this.f17955a = null;
        this.f17956b = null;
        this.f17957c = null;
        this.f17958d = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzcma[] m18620b() {
        if (f17954e == null) {
            synchronized (zzfjq.f7554b) {
                if (f17954e == null) {
                    f17954e = new zzcma[0];
                }
            }
        }
        return f17954e;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17955a != null) {
            a += zzfjk.m6161b(1, this.f17955a.intValue());
        }
        if (this.f17956b != null) {
            a += zzfjk.m6162b(2, this.f17956b);
        }
        if (this.f17957c != null) {
            a += zzfjk.m6162b(3, this.f17957c);
        }
        if (this.f17958d == null) {
            return a;
        }
        this.f17958d.booleanValue();
        return a + (zzfjk.m6160b(4) + 1);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a != 8) {
                zzfjs com_google_android_gms_internal_zzfjs;
                if (a == 18) {
                    if (this.f17956b == null) {
                        this.f17956b = new zzcmf();
                    }
                    com_google_android_gms_internal_zzfjs = this.f17956b;
                } else if (a == 26) {
                    if (this.f17957c == null) {
                        this.f17957c = new zzcmf();
                    }
                    com_google_android_gms_internal_zzfjs = this.f17957c;
                } else if (a == 32) {
                    this.f17958d = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
                } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                    return this;
                }
                com_google_android_gms_internal_zzfjj.m6137a(com_google_android_gms_internal_zzfjs);
            } else {
                this.f17955a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17955a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17955a.intValue());
        }
        if (this.f17956b != null) {
            com_google_android_gms_internal_zzfjk.m6176a(2, this.f17956b);
        }
        if (this.f17957c != null) {
            com_google_android_gms_internal_zzfjk.m6176a(3, this.f17957c);
        }
        if (this.f17958d != null) {
            com_google_android_gms_internal_zzfjk.m6178a(4, this.f17958d.booleanValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcma)) {
            return false;
        }
        zzcma com_google_android_gms_internal_zzcma = (zzcma) obj;
        if (this.f17955a == null) {
            if (com_google_android_gms_internal_zzcma.f17955a != null) {
                return false;
            }
        } else if (!this.f17955a.equals(com_google_android_gms_internal_zzcma.f17955a)) {
            return false;
        }
        if (this.f17956b == null) {
            if (com_google_android_gms_internal_zzcma.f17956b != null) {
                return false;
            }
        } else if (!this.f17956b.equals(com_google_android_gms_internal_zzcma.f17956b)) {
            return false;
        }
        if (this.f17957c == null) {
            if (com_google_android_gms_internal_zzcma.f17957c != null) {
                return false;
            }
        } else if (!this.f17957c.equals(com_google_android_gms_internal_zzcma.f17957c)) {
            return false;
        }
        if (this.f17958d == null) {
            if (com_google_android_gms_internal_zzcma.f17958d != null) {
                return false;
            }
        } else if (!this.f17958d.equals(com_google_android_gms_internal_zzcma.f17958d)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcma.X);
            }
        }
        return com_google_android_gms_internal_zzcma.X == null || com_google_android_gms_internal_zzcma.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((527 + getClass().getName().hashCode()) * 31) + (this.f17955a == null ? 0 : this.f17955a.hashCode());
        zzcmf com_google_android_gms_internal_zzcmf = this.f17956b;
        hashCode = (hashCode * 31) + (com_google_android_gms_internal_zzcmf == null ? 0 : com_google_android_gms_internal_zzcmf.hashCode());
        com_google_android_gms_internal_zzcmf = this.f17957c;
        hashCode = ((((hashCode * 31) + (com_google_android_gms_internal_zzcmf == null ? 0 : com_google_android_gms_internal_zzcmf.hashCode())) * 31) + (this.f17958d == null ? 0 : this.f17958d.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
