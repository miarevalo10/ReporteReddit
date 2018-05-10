package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclt extends zzfjm<zzclt> {
    private static volatile zzclt[] f17922e;
    public zzclw f17923a;
    public zzclu f17924b;
    public Boolean f17925c;
    public String f17926d;

    public zzclt() {
        this.f17923a = null;
        this.f17924b = null;
        this.f17925c = null;
        this.f17926d = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzclt[] m18593b() {
        if (f17922e == null) {
            synchronized (zzfjq.f7554b) {
                if (f17922e == null) {
                    f17922e = new zzclt[0];
                }
            }
        }
        return f17922e;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17923a != null) {
            a += zzfjk.m6162b(1, this.f17923a);
        }
        if (this.f17924b != null) {
            a += zzfjk.m6162b(2, this.f17924b);
        }
        if (this.f17925c != null) {
            this.f17925c.booleanValue();
            a += zzfjk.m6160b(3) + 1;
        }
        return this.f17926d != null ? a + zzfjk.m6163b(4, this.f17926d) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            zzfjs com_google_android_gms_internal_zzfjs;
            if (a == 10) {
                if (this.f17923a == null) {
                    this.f17923a = new zzclw();
                }
                com_google_android_gms_internal_zzfjs = this.f17923a;
            } else if (a == 18) {
                if (this.f17924b == null) {
                    this.f17924b = new zzclu();
                }
                com_google_android_gms_internal_zzfjs = this.f17924b;
            } else if (a == 24) {
                this.f17925c = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
            } else if (a == 34) {
                this.f17926d = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
            com_google_android_gms_internal_zzfjj.m6137a(com_google_android_gms_internal_zzfjs);
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17923a != null) {
            com_google_android_gms_internal_zzfjk.m6176a(1, this.f17923a);
        }
        if (this.f17924b != null) {
            com_google_android_gms_internal_zzfjk.m6176a(2, this.f17924b);
        }
        if (this.f17925c != null) {
            com_google_android_gms_internal_zzfjk.m6178a(3, this.f17925c.booleanValue());
        }
        if (this.f17926d != null) {
            com_google_android_gms_internal_zzfjk.m6177a(4, this.f17926d);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclt)) {
            return false;
        }
        zzclt com_google_android_gms_internal_zzclt = (zzclt) obj;
        if (this.f17923a == null) {
            if (com_google_android_gms_internal_zzclt.f17923a != null) {
                return false;
            }
        } else if (!this.f17923a.equals(com_google_android_gms_internal_zzclt.f17923a)) {
            return false;
        }
        if (this.f17924b == null) {
            if (com_google_android_gms_internal_zzclt.f17924b != null) {
                return false;
            }
        } else if (!this.f17924b.equals(com_google_android_gms_internal_zzclt.f17924b)) {
            return false;
        }
        if (this.f17925c == null) {
            if (com_google_android_gms_internal_zzclt.f17925c != null) {
                return false;
            }
        } else if (!this.f17925c.equals(com_google_android_gms_internal_zzclt.f17925c)) {
            return false;
        }
        if (this.f17926d == null) {
            if (com_google_android_gms_internal_zzclt.f17926d != null) {
                return false;
            }
        } else if (!this.f17926d.equals(com_google_android_gms_internal_zzclt.f17926d)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzclt.X);
            }
        }
        return com_google_android_gms_internal_zzclt.X == null || com_google_android_gms_internal_zzclt.X.m6188a();
    }

    public final int hashCode() {
        int hashCode = 527 + getClass().getName().hashCode();
        zzclw com_google_android_gms_internal_zzclw = this.f17923a;
        int i = 0;
        hashCode = (hashCode * 31) + (com_google_android_gms_internal_zzclw == null ? 0 : com_google_android_gms_internal_zzclw.hashCode());
        zzclu com_google_android_gms_internal_zzclu = this.f17924b;
        hashCode = ((((((hashCode * 31) + (com_google_android_gms_internal_zzclu == null ? 0 : com_google_android_gms_internal_zzclu.hashCode())) * 31) + (this.f17925c == null ? 0 : this.f17925c.hashCode())) * 31) + (this.f17926d == null ? 0 : this.f17926d.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
