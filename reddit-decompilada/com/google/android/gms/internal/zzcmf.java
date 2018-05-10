package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmf extends zzfjm<zzcmf> {
    public long[] f18008a;
    public long[] f18009b;

    public zzcmf() {
        this.f18008a = zzfjv.f7560b;
        this.f18009b = zzfjv.f7560b;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int i;
        int a = super.mo1927a();
        int i2 = 0;
        if (this.f18008a != null && this.f18008a.length > 0) {
            i = 0;
            int i3 = i;
            while (i < this.f18008a.length) {
                i3 += zzfjk.m6153a(this.f18008a[i]);
                i++;
            }
            a = (a + i3) + (this.f18008a.length * 1);
        }
        if (this.f18009b == null || this.f18009b.length <= 0) {
            return a;
        }
        i = 0;
        while (i2 < this.f18009b.length) {
            i += zzfjk.m6153a(this.f18009b[i2]);
            i2++;
        }
        return (a + i) + (1 * this.f18009b.length);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            int k;
            Object obj;
            if (a != 8) {
                int i;
                Object obj2;
                if (a == 10) {
                    a = com_google_android_gms_internal_zzfjj.m6140c(com_google_android_gms_internal_zzfjj.m6146f());
                    k = com_google_android_gms_internal_zzfjj.m6151k();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.m6150j() > 0) {
                        com_google_android_gms_internal_zzfjj.m6147g();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.m6144e(k);
                    k = this.f18008a == null ? 0 : this.f18008a.length;
                    obj2 = new long[(i + k)];
                    if (k != 0) {
                        System.arraycopy(this.f18008a, 0, obj2, 0, k);
                    }
                    while (k < obj2.length) {
                        obj2[k] = com_google_android_gms_internal_zzfjj.m6147g();
                        k++;
                    }
                    this.f18008a = obj2;
                } else if (a == 16) {
                    a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 16);
                    k = this.f18009b == null ? 0 : this.f18009b.length;
                    obj = new long[(a + k)];
                    if (k != 0) {
                        System.arraycopy(this.f18009b, 0, obj, 0, k);
                    }
                    while (k < obj.length - 1) {
                        obj[k] = com_google_android_gms_internal_zzfjj.m6147g();
                        com_google_android_gms_internal_zzfjj.m6134a();
                        k++;
                    }
                    obj[k] = com_google_android_gms_internal_zzfjj.m6147g();
                    this.f18009b = obj;
                } else if (a == 18) {
                    a = com_google_android_gms_internal_zzfjj.m6140c(com_google_android_gms_internal_zzfjj.m6146f());
                    k = com_google_android_gms_internal_zzfjj.m6151k();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.m6150j() > 0) {
                        com_google_android_gms_internal_zzfjj.m6147g();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.m6144e(k);
                    k = this.f18009b == null ? 0 : this.f18009b.length;
                    obj2 = new long[(i + k)];
                    if (k != 0) {
                        System.arraycopy(this.f18009b, 0, obj2, 0, k);
                    }
                    while (k < obj2.length) {
                        obj2[k] = com_google_android_gms_internal_zzfjj.m6147g();
                        k++;
                    }
                    this.f18009b = obj2;
                } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                    return this;
                }
                com_google_android_gms_internal_zzfjj.m6143d(a);
            } else {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 8);
                k = this.f18008a == null ? 0 : this.f18008a.length;
                obj = new long[(a + k)];
                if (k != 0) {
                    System.arraycopy(this.f18008a, 0, obj, 0, k);
                }
                while (k < obj.length - 1) {
                    obj[k] = com_google_android_gms_internal_zzfjj.m6147g();
                    com_google_android_gms_internal_zzfjj.m6134a();
                    k++;
                }
                obj[k] = com_google_android_gms_internal_zzfjj.m6147g();
                this.f18008a = obj;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        int i = 0;
        if (this.f18008a != null && this.f18008a.length > 0) {
            for (long a : this.f18008a) {
                com_google_android_gms_internal_zzfjk.m6175a(1, a);
            }
        }
        if (this.f18009b != null && this.f18009b.length > 0) {
            while (i < this.f18009b.length) {
                com_google_android_gms_internal_zzfjk.m6175a(2, this.f18009b[i]);
                i++;
            }
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmf)) {
            return false;
        }
        zzcmf com_google_android_gms_internal_zzcmf = (zzcmf) obj;
        if (!zzfjq.m6197a(this.f18008a, com_google_android_gms_internal_zzcmf.f18008a) || !zzfjq.m6197a(this.f18009b, com_google_android_gms_internal_zzcmf.f18009b)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcmf.X);
            }
        }
        return com_google_android_gms_internal_zzcmf.X == null || com_google_android_gms_internal_zzcmf.X.m6188a();
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((527 + getClass().getName().hashCode()) * 31) + zzfjq.m6194a(this.f18008a)) * 31) + zzfjq.m6194a(this.f18009b)) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                hashCode = this.X.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }
}
