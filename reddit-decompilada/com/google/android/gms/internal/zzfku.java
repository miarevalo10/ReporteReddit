package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfku extends zzfjm<zzfku> {
    public String f18100a;
    public String f18101b;
    public long f18102c;
    public String f18103d;
    public long f18104e;
    public long f18105f;
    public String f18106g;
    public String f18107h;
    public String f18108i;
    public String f18109j;
    public String f18110k;
    public int f18111l;
    public zzfkt[] f18112m;

    public zzfku() {
        this.f18100a = "";
        this.f18101b = "";
        this.f18102c = 0;
        this.f18103d = "";
        this.f18104e = 0;
        this.f18105f = 0;
        this.f18106g = "";
        this.f18107h = "";
        this.f18108i = "";
        this.f18109j = "";
        this.f18110k = "";
        this.f18111l = 0;
        this.f18112m = zzfkt.m18740b();
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (!(this.f18100a == null || this.f18100a.equals(""))) {
            a += zzfjk.m6163b(1, this.f18100a);
        }
        if (!(this.f18101b == null || this.f18101b.equals(""))) {
            a += zzfjk.m6163b(2, this.f18101b);
        }
        if (this.f18102c != 0) {
            a += zzfjk.m6168c(3, this.f18102c);
        }
        if (!(this.f18103d == null || this.f18103d.equals(""))) {
            a += zzfjk.m6163b(4, this.f18103d);
        }
        if (this.f18104e != 0) {
            a += zzfjk.m6168c(5, this.f18104e);
        }
        if (this.f18105f != 0) {
            a += zzfjk.m6168c(6, this.f18105f);
        }
        if (!(this.f18106g == null || this.f18106g.equals(""))) {
            a += zzfjk.m6163b(7, this.f18106g);
        }
        if (!(this.f18107h == null || this.f18107h.equals(""))) {
            a += zzfjk.m6163b(8, this.f18107h);
        }
        if (!(this.f18108i == null || this.f18108i.equals(""))) {
            a += zzfjk.m6163b(9, this.f18108i);
        }
        if (!(this.f18109j == null || this.f18109j.equals(""))) {
            a += zzfjk.m6163b(10, this.f18109j);
        }
        if (!(this.f18110k == null || this.f18110k.equals(""))) {
            a += zzfjk.m6163b(11, this.f18110k);
        }
        if (this.f18111l != 0) {
            a += zzfjk.m6161b(12, this.f18111l);
        }
        if (this.f18112m != null && this.f18112m.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18112m) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    a += zzfjk.m6162b(13, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        return a;
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (!(this.f18100a == null || this.f18100a.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f18100a);
        }
        if (!(this.f18101b == null || this.f18101b.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(2, this.f18101b);
        }
        if (this.f18102c != 0) {
            com_google_android_gms_internal_zzfjk.m6181b(3, this.f18102c);
        }
        if (!(this.f18103d == null || this.f18103d.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(4, this.f18103d);
        }
        if (this.f18104e != 0) {
            com_google_android_gms_internal_zzfjk.m6181b(5, this.f18104e);
        }
        if (this.f18105f != 0) {
            com_google_android_gms_internal_zzfjk.m6181b(6, this.f18105f);
        }
        if (!(this.f18106g == null || this.f18106g.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(7, this.f18106g);
        }
        if (!(this.f18107h == null || this.f18107h.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(8, this.f18107h);
        }
        if (!(this.f18108i == null || this.f18108i.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(9, this.f18108i);
        }
        if (!(this.f18109j == null || this.f18109j.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(10, this.f18109j);
        }
        if (!(this.f18110k == null || this.f18110k.equals(""))) {
            com_google_android_gms_internal_zzfjk.m6177a(11, this.f18110k);
        }
        if (this.f18111l != 0) {
            com_google_android_gms_internal_zzfjk.m6174a(12, this.f18111l);
        }
        if (this.f18112m != null && this.f18112m.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f18112m) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(13, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public static zzfku m18744a(byte[] bArr) throws zzfjr {
        return (zzfku) zzfjs.m6204a(new zzfku(), bArr, bArr.length);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            switch (a) {
                case 0:
                    return this;
                case 10:
                    this.f18100a = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 18:
                    this.f18101b = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 24:
                    this.f18102c = com_google_android_gms_internal_zzfjj.m6147g();
                    break;
                case 34:
                    this.f18103d = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 40:
                    this.f18104e = com_google_android_gms_internal_zzfjj.m6147g();
                    break;
                case 48:
                    this.f18105f = com_google_android_gms_internal_zzfjj.m6147g();
                    break;
                case 58:
                    this.f18106g = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 66:
                    this.f18107h = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 74:
                    this.f18108i = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 82:
                    this.f18109j = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 90:
                    this.f18110k = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 96:
                    this.f18111l = com_google_android_gms_internal_zzfjj.m6146f();
                    break;
                case 106:
                    a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 106);
                    int length = this.f18112m == null ? 0 : this.f18112m.length;
                    Object obj = new zzfkt[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f18112m, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new zzfkt();
                        com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                        com_google_android_gms_internal_zzfjj.m6134a();
                        length++;
                    }
                    obj[length] = new zzfkt();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    this.f18112m = obj;
                    break;
                default:
                    if (super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                        break;
                    }
                    return this;
            }
        }
    }
}
