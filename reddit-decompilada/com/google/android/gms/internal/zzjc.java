package com.google.android.gms.internal;

import java.io.IOException;

public final class zzjc extends zzfjm<zzjc> {
    public String f18125a;
    public long[] f18126b;
    public zzjb f18127c;
    public zzja f18128d;

    public zzjc() {
        this.f18125a = null;
        this.f18126b = zzfjv.f7560b;
        this.f18127c = null;
        this.f18128d = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18125a != null) {
            a += zzfjk.m6163b(10, this.f18125a);
        }
        if (this.f18126b != null && this.f18126b.length > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f18126b.length) {
                i2 += zzfjk.m6153a(this.f18126b[i]);
                i++;
            }
            a = (a + i2) + (1 * this.f18126b.length);
        }
        if (this.f18127c != null) {
            a += zzfjk.m6162b(15, this.f18127c);
        }
        return this.f18128d != null ? a + zzfjk.m6162b(18, this.f18128d) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 82) {
                this.f18125a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 112) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 112);
                r1 = this.f18126b == null ? 0 : this.f18126b.length;
                Object obj = new long[(a + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f18126b, 0, obj, 0, r1);
                }
                while (r1 < obj.length - 1) {
                    obj[r1] = com_google_android_gms_internal_zzfjj.m6147g();
                    com_google_android_gms_internal_zzfjj.m6134a();
                    r1++;
                }
                obj[r1] = com_google_android_gms_internal_zzfjj.m6147g();
                this.f18126b = obj;
            } else if (a != 114) {
                zzfjs com_google_android_gms_internal_zzfjs;
                if (a == 122) {
                    if (this.f18127c == null) {
                        this.f18127c = new zzjb();
                    }
                    com_google_android_gms_internal_zzfjs = this.f18127c;
                } else if (a == 146) {
                    if (this.f18128d == null) {
                        this.f18128d = new zzja();
                    }
                    com_google_android_gms_internal_zzfjs = this.f18128d;
                } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                    return this;
                }
                com_google_android_gms_internal_zzfjj.m6137a(com_google_android_gms_internal_zzfjs);
            } else {
                a = com_google_android_gms_internal_zzfjj.m6140c(com_google_android_gms_internal_zzfjj.m6146f());
                r1 = com_google_android_gms_internal_zzfjj.m6151k();
                int i = 0;
                while (com_google_android_gms_internal_zzfjj.m6150j() > 0) {
                    com_google_android_gms_internal_zzfjj.m6147g();
                    i++;
                }
                com_google_android_gms_internal_zzfjj.m6144e(r1);
                r1 = this.f18126b == null ? 0 : this.f18126b.length;
                Object obj2 = new long[(i + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.f18126b, 0, obj2, 0, r1);
                }
                while (r1 < obj2.length) {
                    obj2[r1] = com_google_android_gms_internal_zzfjj.m6147g();
                    r1++;
                }
                this.f18126b = obj2;
                com_google_android_gms_internal_zzfjj.m6143d(a);
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18125a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(10, this.f18125a);
        }
        if (this.f18126b != null && this.f18126b.length > 0) {
            for (long a : this.f18126b) {
                com_google_android_gms_internal_zzfjk.m6175a(14, a);
            }
        }
        if (this.f18127c != null) {
            com_google_android_gms_internal_zzfjk.m6176a(15, this.f18127c);
        }
        if (this.f18128d != null) {
            com_google_android_gms_internal_zzfjk.m6176a(18, this.f18128d);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
