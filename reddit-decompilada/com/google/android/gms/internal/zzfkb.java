package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkb extends zzfjm<zzfkb> {
    private zzfkc f18073a;
    private zzfjy[] f18074b;
    private byte[] f18075c;
    private byte[] f18076d;
    private Integer f18077e;
    private byte[] f18078f;

    public zzfkb() {
        this.f18073a = null;
        this.f18074b = zzfjy.m18712b();
        this.f18075c = null;
        this.f18076d = null;
        this.f18077e = null;
        this.f18078f = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18073a != null) {
            a += zzfjk.m6162b(1, this.f18073a);
        }
        if (this.f18074b != null && this.f18074b.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18074b) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    a += zzfjk.m6162b(2, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f18075c != null) {
            a += zzfjk.m6164b(3, this.f18075c);
        }
        if (this.f18076d != null) {
            a += zzfjk.m6164b(4, this.f18076d);
        }
        if (this.f18077e != null) {
            a += zzfjk.m6161b(5, this.f18077e.intValue());
        }
        return this.f18078f != null ? a + zzfjk.m6164b(6, this.f18078f) : a;
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18073a != null) {
            com_google_android_gms_internal_zzfjk.m6176a(1, this.f18073a);
        }
        if (this.f18074b != null && this.f18074b.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18074b) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(2, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (this.f18075c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(3, this.f18075c);
        }
        if (this.f18076d != null) {
            com_google_android_gms_internal_zzfjk.m6179a(4, this.f18076d);
        }
        if (this.f18077e != null) {
            com_google_android_gms_internal_zzfjk.m6174a(5, this.f18077e.intValue());
        }
        if (this.f18078f != null) {
            com_google_android_gms_internal_zzfjk.m6179a(6, this.f18078f);
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
                if (this.f18073a == null) {
                    this.f18073a = new zzfkc();
                }
                com_google_android_gms_internal_zzfjj.m6137a(this.f18073a);
            } else if (a == 18) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 18);
                int length = this.f18074b == null ? 0 : this.f18074b.length;
                Object obj = new zzfjy[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f18074b, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzfjy();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    length++;
                }
                obj[length] = new zzfjy();
                com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                this.f18074b = obj;
            } else if (a == 26) {
                this.f18075c = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 34) {
                this.f18076d = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 40) {
                this.f18077e = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 50) {
                this.f18078f = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }
}
