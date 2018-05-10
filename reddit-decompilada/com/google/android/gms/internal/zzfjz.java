package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjz extends zzfjm<zzfjz> {
    public zzfjy[] f18065a;
    private zzfka f18066b;
    private byte[] f18067c;
    private byte[] f18068d;
    private Integer f18069e;

    public zzfjz() {
        this.f18066b = null;
        this.f18065a = zzfjy.m18712b();
        this.f18067c = null;
        this.f18068d = null;
        this.f18069e = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18066b != null) {
            a += zzfjk.m6162b(1, this.f18066b);
        }
        if (this.f18065a != null && this.f18065a.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18065a) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    a += zzfjk.m6162b(2, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f18067c != null) {
            a += zzfjk.m6164b(3, this.f18067c);
        }
        if (this.f18068d != null) {
            a += zzfjk.m6164b(4, this.f18068d);
        }
        return this.f18069e != null ? a + zzfjk.m6161b(5, this.f18069e.intValue()) : a;
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18066b != null) {
            com_google_android_gms_internal_zzfjk.m6176a(1, this.f18066b);
        }
        if (this.f18065a != null && this.f18065a.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18065a) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(2, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f18067c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(3, this.f18067c);
        }
        if (this.f18068d != null) {
            com_google_android_gms_internal_zzfjk.m6179a(4, this.f18068d);
        }
        if (this.f18069e != null) {
            com_google_android_gms_internal_zzfjk.m6174a(5, this.f18069e.intValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                if (this.f18066b == null) {
                    this.f18066b = new zzfka();
                }
                com_google_android_gms_internal_zzfjj.m6137a(this.f18066b);
            } else if (a == 18) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 18);
                int length = this.f18065a == null ? 0 : this.f18065a.length;
                Object obj = new zzfjy[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f18065a, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzfjy();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    length++;
                }
                obj[length] = new zzfjy();
                com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                this.f18065a = obj;
            } else if (a == 26) {
                this.f18067c = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 34) {
                this.f18068d = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 40) {
                this.f18069e = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }
}
