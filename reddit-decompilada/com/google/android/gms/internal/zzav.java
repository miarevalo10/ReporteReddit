package com.google.android.gms.internal;

import java.io.IOException;

public final class zzav extends zzfjm<zzav> {
    public String f17596a;
    public Long f17597b;
    private String f17598c;
    private String f17599d;
    private String f17600e;
    private Long f17601f;
    private Long f17602g;
    private String f17603h;
    private Long f17604i;
    private String f17605j;

    public zzav() {
        this.f17596a = null;
        this.f17597b = null;
        this.f17598c = null;
        this.f17599d = null;
        this.f17600e = null;
        this.f17601f = null;
        this.f17602g = null;
        this.f17603h = null;
        this.f17604i = null;
        this.f17605j = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17596a != null) {
            a += zzfjk.m6163b(1, this.f17596a);
        }
        if (this.f17597b != null) {
            a += zzfjk.m6168c(2, this.f17597b.longValue());
        }
        if (this.f17598c != null) {
            a += zzfjk.m6163b(3, this.f17598c);
        }
        if (this.f17599d != null) {
            a += zzfjk.m6163b(4, this.f17599d);
        }
        if (this.f17600e != null) {
            a += zzfjk.m6163b(5, this.f17600e);
        }
        if (this.f17601f != null) {
            a += zzfjk.m6168c(6, this.f17601f.longValue());
        }
        if (this.f17602g != null) {
            a += zzfjk.m6168c(7, this.f17602g.longValue());
        }
        if (this.f17603h != null) {
            a += zzfjk.m6163b(8, this.f17603h);
        }
        if (this.f17604i != null) {
            a += zzfjk.m6168c(9, this.f17604i.longValue());
        }
        return this.f17605j != null ? a + zzfjk.m6163b(10, this.f17605j) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            switch (a) {
                case 0:
                    return this;
                case 10:
                    this.f17596a = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 16:
                    this.f17597b = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 26:
                    this.f17598c = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 34:
                    this.f17599d = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 42:
                    this.f17600e = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 48:
                    this.f17601f = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 56:
                    this.f17602g = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 66:
                    this.f17603h = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                case 72:
                    this.f17604i = Long.valueOf(com_google_android_gms_internal_zzfjj.m6147g());
                    break;
                case 82:
                    this.f17605j = com_google_android_gms_internal_zzfjj.m6142d();
                    break;
                default:
                    if (super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                        break;
                    }
                    return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17596a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f17596a);
        }
        if (this.f17597b != null) {
            com_google_android_gms_internal_zzfjk.m6181b(2, this.f17597b.longValue());
        }
        if (this.f17598c != null) {
            com_google_android_gms_internal_zzfjk.m6177a(3, this.f17598c);
        }
        if (this.f17599d != null) {
            com_google_android_gms_internal_zzfjk.m6177a(4, this.f17599d);
        }
        if (this.f17600e != null) {
            com_google_android_gms_internal_zzfjk.m6177a(5, this.f17600e);
        }
        if (this.f17601f != null) {
            com_google_android_gms_internal_zzfjk.m6181b(6, this.f17601f.longValue());
        }
        if (this.f17602g != null) {
            com_google_android_gms_internal_zzfjk.m6181b(7, this.f17602g.longValue());
        }
        if (this.f17603h != null) {
            com_google_android_gms_internal_zzfjk.m6177a(8, this.f17603h);
        }
        if (this.f17604i != null) {
            com_google_android_gms_internal_zzfjk.m6181b(9, this.f17604i.longValue());
        }
        if (this.f17605j != null) {
            com_google_android_gms_internal_zzfjk.m6177a(10, this.f17605j);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
