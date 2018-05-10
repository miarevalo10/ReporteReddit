package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcls extends zzfjm<zzcls> {
    private static volatile zzcls[] f17916e;
    public Integer f17917a;
    public String f17918b;
    public zzclt[] f17919c;
    public zzclu f17920d;
    private Boolean f17921f;

    public zzcls() {
        this.f17917a = null;
        this.f17918b = null;
        this.f17919c = zzclt.m18593b();
        this.f17921f = null;
        this.f17920d = null;
        this.X = null;
        this.Y = -1;
    }

    public static zzcls[] m18589b() {
        if (f17916e == null) {
            synchronized (zzfjq.f7554b) {
                if (f17916e == null) {
                    f17916e = new zzcls[0];
                }
            }
        }
        return f17916e;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17917a != null) {
            a += zzfjk.m6161b(1, this.f17917a.intValue());
        }
        if (this.f17918b != null) {
            a += zzfjk.m6163b(2, this.f17918b);
        }
        if (this.f17919c != null && this.f17919c.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17919c) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    a += zzfjk.m6162b(3, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17921f != null) {
            this.f17921f.booleanValue();
            a += zzfjk.m6160b(4) + 1;
        }
        return this.f17920d != null ? a + zzfjk.m6162b(5, this.f17920d) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f17917a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 18) {
                this.f17918b = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 26) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 26);
                int length = this.f17919c == null ? 0 : this.f17919c.length;
                Object obj = new zzclt[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f17919c, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzclt();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    length++;
                }
                obj[length] = new zzclt();
                com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                this.f17919c = obj;
            } else if (a == 32) {
                this.f17921f = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
            } else if (a == 42) {
                if (this.f17920d == null) {
                    this.f17920d = new zzclu();
                }
                com_google_android_gms_internal_zzfjj.m6137a(this.f17920d);
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17917a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f17917a.intValue());
        }
        if (this.f17918b != null) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f17918b);
        }
        if (this.f17919c != null && this.f17919c.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17919c) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(3, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f17921f != null) {
            com_google_android_gms_internal_zzfjk.m6178a(4, this.f17921f.booleanValue());
        }
        if (this.f17920d != null) {
            com_google_android_gms_internal_zzfjk.m6176a(5, this.f17920d);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcls)) {
            return false;
        }
        zzcls com_google_android_gms_internal_zzcls = (zzcls) obj;
        if (this.f17917a == null) {
            if (com_google_android_gms_internal_zzcls.f17917a != null) {
                return false;
            }
        } else if (!this.f17917a.equals(com_google_android_gms_internal_zzcls.f17917a)) {
            return false;
        }
        if (this.f17918b == null) {
            if (com_google_android_gms_internal_zzcls.f17918b != null) {
                return false;
            }
        } else if (!this.f17918b.equals(com_google_android_gms_internal_zzcls.f17918b)) {
            return false;
        }
        if (!zzfjq.m6198a(this.f17919c, com_google_android_gms_internal_zzcls.f17919c)) {
            return false;
        }
        if (this.f17921f == null) {
            if (com_google_android_gms_internal_zzcls.f17921f != null) {
                return false;
            }
        } else if (!this.f17921f.equals(com_google_android_gms_internal_zzcls.f17921f)) {
            return false;
        }
        if (this.f17920d == null) {
            if (com_google_android_gms_internal_zzcls.f17920d != null) {
                return false;
            }
        } else if (!this.f17920d.equals(com_google_android_gms_internal_zzcls.f17920d)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcls.X);
            }
        }
        return com_google_android_gms_internal_zzcls.X == null || com_google_android_gms_internal_zzcls.X.m6188a();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((527 + getClass().getName().hashCode()) * 31) + (this.f17917a == null ? 0 : this.f17917a.hashCode())) * 31) + (this.f17918b == null ? 0 : this.f17918b.hashCode())) * 31) + zzfjq.m6195a(this.f17919c)) * 31) + (this.f17921f == null ? 0 : this.f17921f.hashCode());
        zzclu com_google_android_gms_internal_zzclu = this.f17920d;
        hashCode = ((hashCode * 31) + (com_google_android_gms_internal_zzclu == null ? 0 : com_google_android_gms_internal_zzclu.hashCode())) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                i = this.X.hashCode();
            }
        }
        return hashCode + i;
    }
}
