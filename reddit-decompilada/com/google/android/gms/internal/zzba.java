package com.google.android.gms.internal;

import java.io.IOException;

public final class zzba extends zzfjm<zzba> {
    private static volatile zzba[] f17667v;
    public Long f17668a;
    public Long f17669b;
    public Long f17670c;
    public Long f17671d;
    public Long f17672e;
    public Long f17673f;
    public Integer f17674g;
    public Long f17675h;
    public Long f17676i;
    public Long f17677j;
    public Integer f17678k;
    public Long f17679l;
    public Long f17680m;
    public Long f17681n;
    public Long f17682o;
    public Long f17683p;
    public Long f17684q;
    public Long f17685r;
    public Long f17686s;
    public Long f17687t;
    public Long f17688u;

    public zzba() {
        this.f17668a = null;
        this.f17669b = null;
        this.f17670c = null;
        this.f17671d = null;
        this.f17672e = null;
        this.f17673f = null;
        this.f17675h = null;
        this.f17676i = null;
        this.f17677j = null;
        this.f17679l = null;
        this.f17680m = null;
        this.f17681n = null;
        this.f17682o = null;
        this.f17683p = null;
        this.f17684q = null;
        this.f17685r = null;
        this.f17686s = null;
        this.f17687t = null;
        this.f17688u = null;
        this.Y = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.zzba m17917b(com.google.android.gms.internal.zzfjj r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r4.m6134a();
        switch(r0) {
            case 0: goto L_0x0118;
            case 8: goto L_0x010c;
            case 16: goto L_0x0100;
            case 24: goto L_0x00f4;
            case 32: goto L_0x00e8;
            case 40: goto L_0x00dc;
            case 48: goto L_0x00d0;
            case 56: goto L_0x00b4;
            case 64: goto L_0x00a8;
            case 72: goto L_0x009c;
            case 80: goto L_0x0090;
            case 88: goto L_0x007c;
            case 96: goto L_0x0071;
            case 104: goto L_0x0066;
            case 112: goto L_0x005b;
            case 120: goto L_0x0050;
            case 128: goto L_0x0045;
            case 136: goto L_0x003a;
            case 144: goto L_0x002f;
            case 152: goto L_0x0024;
            case 160: goto L_0x0019;
            case 168: goto L_0x000e;
            default: goto L_0x0007;
        };
    L_0x0007:
        r0 = super.m13900a(r4, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000d:
        return r3;
    L_0x000e:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17688u = r0;
        goto L_0x0000;
    L_0x0019:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17687t = r0;
        goto L_0x0000;
    L_0x0024:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17686s = r0;
        goto L_0x0000;
    L_0x002f:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17685r = r0;
        goto L_0x0000;
    L_0x003a:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17684q = r0;
        goto L_0x0000;
    L_0x0045:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17683p = r0;
        goto L_0x0000;
    L_0x0050:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17682o = r0;
        goto L_0x0000;
    L_0x005b:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17681n = r0;
        goto L_0x0000;
    L_0x0066:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17680m = r0;
        goto L_0x0000;
    L_0x0071:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17679l = r0;
        goto L_0x0000;
    L_0x007c:
        r1 = r4.m6151k();
        r2 = r4.m6146f();	 Catch:{ IllegalArgumentException -> 0x00c8 }
        r2 = com.google.android.gms.internal.zzay.m5503a(r2);	 Catch:{ IllegalArgumentException -> 0x00c8 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00c8 }
        r3.f17678k = r2;	 Catch:{ IllegalArgumentException -> 0x00c8 }
        goto L_0x0000;
    L_0x0090:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17677j = r0;
        goto L_0x0000;
    L_0x009c:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17676i = r0;
        goto L_0x0000;
    L_0x00a8:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17675h = r0;
        goto L_0x0000;
    L_0x00b4:
        r1 = r4.m6151k();
        r2 = r4.m6146f();	 Catch:{ IllegalArgumentException -> 0x00c8 }
        r2 = com.google.android.gms.internal.zzay.m5503a(r2);	 Catch:{ IllegalArgumentException -> 0x00c8 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00c8 }
        r3.f17674g = r2;	 Catch:{ IllegalArgumentException -> 0x00c8 }
        goto L_0x0000;
    L_0x00c8:
        r4.m6144e(r1);
        r3.m13900a(r4, r0);
        goto L_0x0000;
    L_0x00d0:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17673f = r0;
        goto L_0x0000;
    L_0x00dc:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17672e = r0;
        goto L_0x0000;
    L_0x00e8:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17671d = r0;
        goto L_0x0000;
    L_0x00f4:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17670c = r0;
        goto L_0x0000;
    L_0x0100:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17669b = r0;
        goto L_0x0000;
    L_0x010c:
        r0 = r4.m6147g();
        r0 = java.lang.Long.valueOf(r0);
        r3.f17668a = r0;
        goto L_0x0000;
    L_0x0118:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzba.b(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzba");
    }

    public static zzba[] m17918b() {
        if (f17667v == null) {
            synchronized (zzfjq.f7554b) {
                if (f17667v == null) {
                    f17667v = new zzba[0];
                }
            }
        }
        return f17667v;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17668a != null) {
            a += zzfjk.m6168c(1, this.f17668a.longValue());
        }
        if (this.f17669b != null) {
            a += zzfjk.m6168c(2, this.f17669b.longValue());
        }
        if (this.f17670c != null) {
            a += zzfjk.m6168c(3, this.f17670c.longValue());
        }
        if (this.f17671d != null) {
            a += zzfjk.m6168c(4, this.f17671d.longValue());
        }
        if (this.f17672e != null) {
            a += zzfjk.m6168c(5, this.f17672e.longValue());
        }
        if (this.f17673f != null) {
            a += zzfjk.m6168c(6, this.f17673f.longValue());
        }
        if (this.f17674g != null) {
            a += zzfjk.m6161b(7, this.f17674g.intValue());
        }
        if (this.f17675h != null) {
            a += zzfjk.m6168c(8, this.f17675h.longValue());
        }
        if (this.f17676i != null) {
            a += zzfjk.m6168c(9, this.f17676i.longValue());
        }
        if (this.f17677j != null) {
            a += zzfjk.m6168c(10, this.f17677j.longValue());
        }
        if (this.f17678k != null) {
            a += zzfjk.m6161b(11, this.f17678k.intValue());
        }
        if (this.f17679l != null) {
            a += zzfjk.m6168c(12, this.f17679l.longValue());
        }
        if (this.f17680m != null) {
            a += zzfjk.m6168c(13, this.f17680m.longValue());
        }
        if (this.f17681n != null) {
            a += zzfjk.m6168c(14, this.f17681n.longValue());
        }
        if (this.f17682o != null) {
            a += zzfjk.m6168c(15, this.f17682o.longValue());
        }
        if (this.f17683p != null) {
            a += zzfjk.m6168c(16, this.f17683p.longValue());
        }
        if (this.f17684q != null) {
            a += zzfjk.m6168c(17, this.f17684q.longValue());
        }
        if (this.f17685r != null) {
            a += zzfjk.m6168c(18, this.f17685r.longValue());
        }
        if (this.f17686s != null) {
            a += zzfjk.m6168c(19, this.f17686s.longValue());
        }
        if (this.f17687t != null) {
            a += zzfjk.m6168c(20, this.f17687t.longValue());
        }
        return this.f17688u != null ? a + zzfjk.m6168c(21, this.f17688u.longValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return m17917b(com_google_android_gms_internal_zzfjj);
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17668a != null) {
            com_google_android_gms_internal_zzfjk.m6181b(1, this.f17668a.longValue());
        }
        if (this.f17669b != null) {
            com_google_android_gms_internal_zzfjk.m6181b(2, this.f17669b.longValue());
        }
        if (this.f17670c != null) {
            com_google_android_gms_internal_zzfjk.m6181b(3, this.f17670c.longValue());
        }
        if (this.f17671d != null) {
            com_google_android_gms_internal_zzfjk.m6181b(4, this.f17671d.longValue());
        }
        if (this.f17672e != null) {
            com_google_android_gms_internal_zzfjk.m6181b(5, this.f17672e.longValue());
        }
        if (this.f17673f != null) {
            com_google_android_gms_internal_zzfjk.m6181b(6, this.f17673f.longValue());
        }
        if (this.f17674g != null) {
            com_google_android_gms_internal_zzfjk.m6174a(7, this.f17674g.intValue());
        }
        if (this.f17675h != null) {
            com_google_android_gms_internal_zzfjk.m6181b(8, this.f17675h.longValue());
        }
        if (this.f17676i != null) {
            com_google_android_gms_internal_zzfjk.m6181b(9, this.f17676i.longValue());
        }
        if (this.f17677j != null) {
            com_google_android_gms_internal_zzfjk.m6181b(10, this.f17677j.longValue());
        }
        if (this.f17678k != null) {
            com_google_android_gms_internal_zzfjk.m6174a(11, this.f17678k.intValue());
        }
        if (this.f17679l != null) {
            com_google_android_gms_internal_zzfjk.m6181b(12, this.f17679l.longValue());
        }
        if (this.f17680m != null) {
            com_google_android_gms_internal_zzfjk.m6181b(13, this.f17680m.longValue());
        }
        if (this.f17681n != null) {
            com_google_android_gms_internal_zzfjk.m6181b(14, this.f17681n.longValue());
        }
        if (this.f17682o != null) {
            com_google_android_gms_internal_zzfjk.m6181b(15, this.f17682o.longValue());
        }
        if (this.f17683p != null) {
            com_google_android_gms_internal_zzfjk.m6181b(16, this.f17683p.longValue());
        }
        if (this.f17684q != null) {
            com_google_android_gms_internal_zzfjk.m6181b(17, this.f17684q.longValue());
        }
        if (this.f17685r != null) {
            com_google_android_gms_internal_zzfjk.m6181b(18, this.f17685r.longValue());
        }
        if (this.f17686s != null) {
            com_google_android_gms_internal_zzfjk.m6181b(19, this.f17686s.longValue());
        }
        if (this.f17687t != null) {
            com_google_android_gms_internal_zzfjk.m6181b(20, this.f17687t.longValue());
        }
        if (this.f17688u != null) {
            com_google_android_gms_internal_zzfjk.m6181b(21, this.f17688u.longValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
