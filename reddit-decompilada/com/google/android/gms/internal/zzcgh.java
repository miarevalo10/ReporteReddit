package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

final class zzcgh {
    private long f6796A;
    final zzcim f6797a;
    long f6798b;
    long f6799c;
    long f6800d;
    long f6801e;
    long f6802f;
    long f6803g;
    String f6804h;
    boolean f6805i;
    private final String f6806j;
    private String f6807k;
    private String f6808l;
    private String f6809m;
    private String f6810n;
    private long f6811o;
    private long f6812p;
    private long f6813q;
    private String f6814r;
    private long f6815s;
    private String f6816t;
    private long f6817u;
    private long f6818v;
    private boolean f6819w;
    private long f6820x;
    private boolean f6821y;
    private long f6822z;

    zzcgh(zzcim com_google_android_gms_internal_zzcim, String str) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcim);
        zzbq.m4810a(str);
        this.f6797a = com_google_android_gms_internal_zzcim;
        this.f6806j = str;
        this.f6797a.m5755f().mo1811c();
    }

    public final String m5619a() {
        this.f6797a.m5755f().mo1811c();
        return this.f6806j;
    }

    public final void m5620a(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6812p != j ? 1 : 0;
        this.f6812p = j;
    }

    public final void m5621a(String str) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= zzclq.m18521b(this.f6807k, str) ^ 1;
        this.f6807k = str;
    }

    public final void m5622a(boolean z) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6819w != z ? 1 : 0;
        this.f6819w = z;
    }

    public final String m5623b() {
        this.f6797a.m5755f().mo1811c();
        return this.f6807k;
    }

    public final void m5624b(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6813q != j ? 1 : 0;
        this.f6813q = j;
    }

    public final void m5625b(String str) {
        this.f6797a.m5755f().mo1811c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f6805i |= zzclq.m18521b(this.f6808l, str) ^ 1;
        this.f6808l = str;
    }

    public final void m5626b(boolean z) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i = this.f6821y != z;
        this.f6821y = z;
    }

    public final String m5627c() {
        this.f6797a.m5755f().mo1811c();
        return this.f6808l;
    }

    public final void m5628c(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6815s != j ? 1 : 0;
        this.f6815s = j;
    }

    public final void m5629c(String str) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= zzclq.m18521b(this.f6809m, str) ^ 1;
        this.f6809m = str;
    }

    public final String m5630d() {
        this.f6797a.m5755f().mo1811c();
        return this.f6809m;
    }

    public final void m5631d(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6817u != j ? 1 : 0;
        this.f6817u = j;
    }

    public final void m5632d(String str) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= zzclq.m18521b(this.f6810n, str) ^ 1;
        this.f6810n = str;
    }

    public final String m5633e() {
        this.f6797a.m5755f().mo1811c();
        return this.f6810n;
    }

    public final void m5634e(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6818v != j ? 1 : 0;
        this.f6818v = j;
    }

    public final void m5635e(String str) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= zzclq.m18521b(this.f6814r, str) ^ 1;
        this.f6814r = str;
    }

    public final long m5636f() {
        this.f6797a.m5755f().mo1811c();
        return this.f6812p;
    }

    public final void m5637f(long j) {
        int i = 0;
        zzbq.m4817b(j >= 0);
        this.f6797a.m5755f().mo1811c();
        boolean z = this.f6805i;
        if (this.f6811o != j) {
            i = 1;
        }
        this.f6805i = z | i;
        this.f6811o = j;
    }

    public final void m5638f(String str) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= zzclq.m18521b(this.f6816t, str) ^ 1;
        this.f6816t = str;
    }

    public final long m5639g() {
        this.f6797a.m5755f().mo1811c();
        return this.f6813q;
    }

    public final void m5640g(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6822z != j ? 1 : 0;
        this.f6822z = j;
    }

    public final void m5641g(String str) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= zzclq.m18521b(this.f6804h, str) ^ 1;
        this.f6804h = str;
    }

    public final String m5642h() {
        this.f6797a.m5755f().mo1811c();
        return this.f6814r;
    }

    public final void m5643h(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6796A != j ? 1 : 0;
        this.f6796A = j;
    }

    public final long m5644i() {
        this.f6797a.m5755f().mo1811c();
        return this.f6815s;
    }

    public final void m5645i(long j) {
        this.f6797a.m5755f().mo1811c();
        this.f6805i |= this.f6820x != j ? 1 : 0;
        this.f6820x = j;
    }

    public final String m5646j() {
        this.f6797a.m5755f().mo1811c();
        return this.f6816t;
    }

    public final long m5647k() {
        this.f6797a.m5755f().mo1811c();
        return this.f6817u;
    }

    public final long m5648l() {
        this.f6797a.m5755f().mo1811c();
        return this.f6818v;
    }

    public final boolean m5649m() {
        this.f6797a.m5755f().mo1811c();
        return this.f6819w;
    }

    public final long m5650n() {
        this.f6797a.m5755f().mo1811c();
        return this.f6811o;
    }

    public final long m5651o() {
        this.f6797a.m5755f().mo1811c();
        return this.f6822z;
    }

    public final long m5652p() {
        this.f6797a.m5755f().mo1811c();
        return this.f6796A;
    }

    public final String m5654r() {
        this.f6797a.m5755f().mo1811c();
        return this.f6804h;
    }

    public final long m5655s() {
        this.f6797a.m5755f().mo1811c();
        return this.f6820x;
    }

    public final boolean m5656t() {
        this.f6797a.m5755f().mo1811c();
        return this.f6821y;
    }

    public final void m5653q() {
        this.f6797a.m5755f().mo1811c();
        long j = this.f6811o + 1;
        if (j > 2147483647L) {
            this.f6797a.m5754e().f17818c.m5694a("Bundle index overflow. appId", zzchm.m18154a(this.f6806j));
            j = 0;
        }
        this.f6805i = true;
        this.f6811o = j;
    }
}
