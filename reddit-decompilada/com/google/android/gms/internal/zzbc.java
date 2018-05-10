package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbc extends zzfjm<zzbc> {
    private Long f17694a;
    private Integer f17695b;
    private Boolean f17696c;
    private int[] f17697d;
    private Long f17698e;

    public zzbc() {
        this.f17694a = null;
        this.f17695b = null;
        this.f17696c = null;
        this.f17697d = zzfjv.f7559a;
        this.f17698e = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17694a != null) {
            a += zzfjk.m6168c(1, this.f17694a.longValue());
        }
        if (this.f17695b != null) {
            a += zzfjk.m6161b(2, this.f17695b.intValue());
        }
        if (this.f17696c != null) {
            this.f17696c.booleanValue();
            a += zzfjk.m6160b(3) + 1;
        }
        if (this.f17697d != null && this.f17697d.length > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f17697d.length) {
                i2 += zzfjk.m6152a(this.f17697d[i]);
                i++;
            }
            a = (a + i2) + (1 * this.f17697d.length);
        }
        if (this.f17698e == null) {
            return a;
        }
        return a + (zzfjk.m6160b(5) + zzfjk.m6153a(this.f17698e.longValue()));
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f17694a = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (a == 16) {
                this.f17695b = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 24) {
                this.f17696c = Boolean.valueOf(com_google_android_gms_internal_zzfjj.m6141c());
            } else if (a == 32) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 32);
                r1 = this.f17697d == null ? 0 : this.f17697d.length;
                Object obj = new int[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17697d, 0, obj, 0, r1);
                }
                while (r1 < obj.length - 1) {
                    obj[r1] = com_google_android_gms_internal_zzfjj.m6146f();
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                obj[r1] = com_google_android_gms_internal_zzfjj.m6146f();
                this.f17697d = obj;
            } else if (a == 34) {
                a = com_google_android_gms_internal_zzfjj.m6140c(com_google_android_gms_internal_zzfjj.m6146f());
                r1 = com_google_android_gms_internal_zzfjj.m6151k();
                int i = 0;
                while (com_google_android_gms_internal_zzfjj.m6150j() > 0) {
                    com_google_android_gms_internal_zzfjj.m6146f();
                    i++;
                }
                com_google_android_gms_internal_zzfjj.m6144e(r1);
                r1 = this.f17697d == null ? 0 : this.f17697d.length;
                Object obj2 = new int[(i + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f17697d, 0, obj2, 0, r1);
                }
                while (r1 < obj2.length) {
                    obj2[r1] = com_google_android_gms_internal_zzfjj.m6146f();
                    r1++;
                }
                this.f17697d = obj2;
                com_google_android_gms_internal_zzfjj.m6143d(a);
            } else if (a == 40) {
                this.f17698e = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17694a != null) {
            com_google_android_gms_internal_zzfjk.m6181b(1, this.f17694a.longValue());
        }
        if (this.f17695b != null) {
            com_google_android_gms_internal_zzfjk.m6174a(2, this.f17695b.intValue());
        }
        if (this.f17696c != null) {
            com_google_android_gms_internal_zzfjk.m6178a(3, this.f17696c.booleanValue());
        }
        if (this.f17697d != null && this.f17697d.length > 0) {
            for (int a : this.f17697d) {
                com_google_android_gms_internal_zzfjk.m6174a(4, a);
            }
        }
        if (this.f17698e != null) {
            com_google_android_gms_internal_zzfjk.m6175a(5, this.f17698e.longValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
