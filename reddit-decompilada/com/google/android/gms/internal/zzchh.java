package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzd;
import java.math.BigInteger;
import java.util.Locale;

public final class zzchh extends zzcjl {
    private String f17802a;
    private String f17803b;
    private int f17804c;
    private String f17805d;
    private String f17806e;
    private long f17807f;
    private long f17808g;
    private int f17809h;
    private String f17810i;

    zzchh(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    final String m18056A() {
        m13545L();
        return this.f17810i;
    }

    final int m18057B() {
        m13545L();
        return this.f17804c;
    }

    final int m18058C() {
        m13545L();
        return this.f17809h;
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    public final /* bridge */ /* synthetic */ void mo1811c() {
        super.mo1811c();
    }

    public final /* bridge */ /* synthetic */ zzcgd mo1812d() {
        return super.mo1812d();
    }

    public final /* bridge */ /* synthetic */ zzcgk mo1813e() {
        return super.mo1813e();
    }

    public final /* bridge */ /* synthetic */ zzcjn mo1814f() {
        return super.mo1814f();
    }

    public final /* bridge */ /* synthetic */ zzchh mo1815g() {
        return super.mo1815g();
    }

    public final /* bridge */ /* synthetic */ zzcgu mo1816h() {
        return super.mo1816h();
    }

    public final /* bridge */ /* synthetic */ zzckg mo1817i() {
        return super.mo1817i();
    }

    public final /* bridge */ /* synthetic */ zzckc mo1818j() {
        return super.mo1818j();
    }

    public final /* bridge */ /* synthetic */ zzd mo1819k() {
        return super.mo1819k();
    }

    public final /* bridge */ /* synthetic */ Context mo1820l() {
        return super.mo1820l();
    }

    public final /* bridge */ /* synthetic */ zzchi mo1821m() {
        return super.mo1821m();
    }

    public final /* bridge */ /* synthetic */ zzcgo mo1822n() {
        return super.mo1822n();
    }

    public final /* bridge */ /* synthetic */ zzchk mo1823o() {
        return super.mo1823o();
    }

    public final /* bridge */ /* synthetic */ zzclq mo1824p() {
        return super.mo1824p();
    }

    public final /* bridge */ /* synthetic */ zzcig mo1825q() {
        return super.mo1825q();
    }

    public final /* bridge */ /* synthetic */ zzclf mo1826r() {
        return super.mo1826r();
    }

    public final /* bridge */ /* synthetic */ zzcih mo1827s() {
        return super.mo1827s();
    }

    public final /* bridge */ /* synthetic */ zzchm mo1828t() {
        return super.mo1828t();
    }

    public final /* bridge */ /* synthetic */ zzchx mo1829u() {
        return super.mo1829u();
    }

    public final /* bridge */ /* synthetic */ zzcgn mo1830v() {
        return super.mo1830v();
    }

    protected final boolean mo3490w() {
        return true;
    }

    final String m18083y() {
        mo1824p().m18584z().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final String m18084z() {
        m13545L();
        return this.f17802a;
    }

    protected final void l_() {
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
        r10 = this;
        r0 = "unknown";
        r1 = "Unknown";
        r2 = "Unknown";
        r3 = r10.mo1820l();
        r3 = r3.getPackageName();
        r4 = r10.mo1820l();
        r4 = r4.getPackageManager();
        r5 = 0;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 != 0) goto L_0x002b;
    L_0x001b:
        r4 = r10.mo1828t();
        r4 = r4.f17816a;
        r7 = "PackageManager is null, app identity information might be inaccurate. appId";
        r8 = com.google.android.gms.internal.zzchm.m18154a(r3);
        r4.m5694a(r7, r8);
        goto L_0x0085;
    L_0x002b:
        r7 = r4.getInstallerPackageName(r3);	 Catch:{ IllegalArgumentException -> 0x0031 }
        r0 = r7;
        goto L_0x0040;
    L_0x0031:
        r7 = r10.mo1828t();
        r7 = r7.f17816a;
        r8 = "Error retrieving app installer package name. appId";
        r9 = com.google.android.gms.internal.zzchm.m18154a(r3);
        r7.m5694a(r8, r9);
    L_0x0040:
        if (r0 != 0) goto L_0x0045;
    L_0x0042:
        r0 = "manual_install";
        goto L_0x004f;
    L_0x0045:
        r7 = "com.android.vending";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x004f;
    L_0x004d:
        r0 = "";
    L_0x004f:
        r7 = r10.mo1820l();	 Catch:{ NameNotFoundException -> 0x0076 }
        r7 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x0076 }
        r7 = r4.getPackageInfo(r7, r5);	 Catch:{ NameNotFoundException -> 0x0076 }
        if (r7 == 0) goto L_0x0085;	 Catch:{ NameNotFoundException -> 0x0076 }
    L_0x005d:
        r8 = r7.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0076 }
        r4 = r4.getApplicationLabel(r8);	 Catch:{ NameNotFoundException -> 0x0076 }
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ NameNotFoundException -> 0x0076 }
        if (r8 != 0) goto L_0x006e;	 Catch:{ NameNotFoundException -> 0x0076 }
    L_0x0069:
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x0076 }
        r2 = r4;	 Catch:{ NameNotFoundException -> 0x0076 }
    L_0x006e:
        r4 = r7.versionName;	 Catch:{ NameNotFoundException -> 0x0076 }
        r1 = r7.versionCode;	 Catch:{ NameNotFoundException -> 0x0075 }
        r6 = r1;
        r1 = r4;
        goto L_0x0085;
    L_0x0075:
        r1 = r4;
    L_0x0076:
        r4 = r10.mo1828t();
        r4 = r4.f17816a;
        r7 = "Error retrieving package info. appId, appName";
        r8 = com.google.android.gms.internal.zzchm.m18154a(r3);
        r4.m5695a(r7, r8, r2);
    L_0x0085:
        r10.f17802a = r3;
        r10.f17805d = r0;
        r10.f17803b = r1;
        r10.f17804c = r6;
        r10.f17806e = r2;
        r0 = 0;
        r10.f17807f = r0;
        r2 = r10.mo1820l();
        r2 = com.google.android.gms.common.api.internal.zzbz.m4734a(r2);
        r4 = 1;
        if (r2 == 0) goto L_0x00a6;
    L_0x009e:
        r6 = r2.m17588b();
        if (r6 == 0) goto L_0x00a6;
    L_0x00a4:
        r6 = r4;
        goto L_0x00a7;
    L_0x00a6:
        r6 = r5;
    L_0x00a7:
        if (r6 != 0) goto L_0x00ca;
    L_0x00a9:
        if (r2 != 0) goto L_0x00b7;
    L_0x00ab:
        r2 = r10.mo1828t();
        r2 = r2.f17816a;
        r7 = "GoogleService failed to initialize (no status)";
        r2.m5693a(r7);
        goto L_0x00ca;
    L_0x00b7:
        r7 = r10.mo1828t();
        r7 = r7.f17816a;
        r8 = "GoogleService failed to initialize, status";
        r9 = r2.f17270g;
        r9 = java.lang.Integer.valueOf(r9);
        r2 = r2.f17271h;
        r7.m5695a(r8, r9, r2);
    L_0x00ca:
        if (r6 == 0) goto L_0x0120;
    L_0x00cc:
        r2 = r10.mo1830v();
        r6 = "firebase_analytics_collection_enabled";
        r2 = r2.m13492b(r6);
        r6 = r10.mo1830v();
        r6 = r6.m13516x();
        if (r6 == 0) goto L_0x00ec;
    L_0x00e0:
        r2 = r10.mo1828t();
        r2 = r2.f17820e;
        r4 = "Collection disabled with firebase_analytics_collection_deactivated=1";
        r2.m5693a(r4);
        goto L_0x0120;
    L_0x00ec:
        if (r2 == 0) goto L_0x0100;
    L_0x00ee:
        r6 = r2.booleanValue();
        if (r6 != 0) goto L_0x0100;
    L_0x00f4:
        r2 = r10.mo1828t();
        r2 = r2.f17820e;
        r4 = "Collection disabled with firebase_analytics_collection_enabled=0";
        r2.m5693a(r4);
        goto L_0x0120;
    L_0x0100:
        if (r2 != 0) goto L_0x0114;
    L_0x0102:
        r2 = com.google.android.gms.common.api.internal.zzbz.m4737b();
        if (r2 == 0) goto L_0x0114;
    L_0x0108:
        r2 = r10.mo1828t();
        r2 = r2.f17820e;
        r4 = "Collection disabled with google_app_measurement_enable=0";
        r2.m5693a(r4);
        goto L_0x0120;
    L_0x0114:
        r2 = r10.mo1828t();
        r2 = r2.f17822g;
        r6 = "Collection enabled";
        r2.m5693a(r6);
        goto L_0x0121;
    L_0x0120:
        r4 = r5;
    L_0x0121:
        r2 = "";
        r10.f17810i = r2;
        r10.f17808g = r0;
        r0 = com.google.android.gms.common.api.internal.zzbz.m4736a();	 Catch:{ IllegalStateException -> 0x0147 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IllegalStateException -> 0x0147 }
        if (r1 == 0) goto L_0x0133;	 Catch:{ IllegalStateException -> 0x0147 }
    L_0x0131:
        r0 = "";	 Catch:{ IllegalStateException -> 0x0147 }
    L_0x0133:
        r10.f17810i = r0;	 Catch:{ IllegalStateException -> 0x0147 }
        if (r4 == 0) goto L_0x0157;	 Catch:{ IllegalStateException -> 0x0147 }
    L_0x0137:
        r0 = r10.mo1828t();	 Catch:{ IllegalStateException -> 0x0147 }
        r0 = r0.f17822g;	 Catch:{ IllegalStateException -> 0x0147 }
        r1 = "App package, google app id";	 Catch:{ IllegalStateException -> 0x0147 }
        r2 = r10.f17802a;	 Catch:{ IllegalStateException -> 0x0147 }
        r4 = r10.f17810i;	 Catch:{ IllegalStateException -> 0x0147 }
        r0.m5695a(r1, r2, r4);	 Catch:{ IllegalStateException -> 0x0147 }
        goto L_0x0157;
    L_0x0147:
        r0 = move-exception;
        r1 = r10.mo1828t();
        r1 = r1.f17816a;
        r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId";
        r3 = com.google.android.gms.internal.zzchm.m18154a(r3);
        r1.m5695a(r2, r3, r0);
    L_0x0157:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x0168;
    L_0x015d:
        r0 = r10.mo1820l();
        r0 = com.google.android.gms.internal.zzbhd.m5567a(r0);
        r10.f17809h = r0;
        return;
    L_0x0168:
        r10.f17809h = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchh.l_():void");
    }

    final zzcgi m18059a(String str) {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        mo1811c();
        String z4 = m18084z();
        String A = m18056A();
        m13545L();
        String str2 = this.f17803b;
        long B = (long) m18057B();
        m13545L();
        String str3 = this.f17805d;
        m13545L();
        mo1811c();
        if (this.f17807f == 0) {
            r0.f17807f = r0.s.m5758i().m18551b(mo1820l(), mo1820l().getPackageName());
        }
        long j2 = r0.f17807f;
        boolean s = r0.s.m5768s();
        boolean z5 = mo1829u().f17845r ^ 1;
        String D = m18055D();
        m13545L();
        zzcim com_google_android_gms_internal_zzcim = r0.s;
        Long valueOf = Long.valueOf(com_google_android_gms_internal_zzcim.m5753d().f17835h.m5702a());
        if (valueOf.longValue() == 0) {
            j = com_google_android_gms_internal_zzcim.f6985l;
            z = s;
            z2 = z5;
        } else {
            z = s;
            z2 = z5;
            j = Math.min(com_google_android_gms_internal_zzcim.f6985l, valueOf.longValue());
        }
        int C = m18058C();
        Boolean b = mo1830v().m13492b("google_analytics_adid_collection_enabled");
        if (b != null) {
            if (!b.booleanValue()) {
                z3 = false;
                return new zzcgi(z4, A, str2, B, str3, 11910, j2, str, z, z2, D, 0, j, C, Boolean.valueOf(z3).booleanValue());
            }
        }
        z3 = true;
        return new zzcgi(z4, A, str2, B, str3, 11910, j2, str, z, z2, D, 0, j, C, Boolean.valueOf(z3).booleanValue());
    }

    private final java.lang.String m18055D() {
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
        r2 = this;
        r2.mo1811c();
        r0 = com.google.firebase.iid.FirebaseInstanceId.m7356a();	 Catch:{ IllegalStateException -> 0x000c }
        r0 = r0.m7364c();	 Catch:{ IllegalStateException -> 0x000c }
        return r0;
    L_0x000c:
        r0 = r2.mo1828t();
        r0 = r0.f17818c;
        r1 = "Failed to retrieve Firebase Instance Id";
        r0.m5693a(r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchh.D():java.lang.String");
    }
}
