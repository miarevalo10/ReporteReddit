package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzs;
import java.lang.reflect.InvocationTargetException;

public final class zzcgn extends zzcjk {
    private Boolean f14230a;

    zzcgn(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    public final int m13488a(String str) {
        return m13491b(str, zzchc.f6883q);
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

    public final boolean m13495c(String str) {
        return "1".equals(mo1825q().m18230a(str, "gaia_collection_enabled"));
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

    public final boolean m13516x() {
        Boolean b = m13492b("firebase_analytics_collection_deactivated");
        return b != null && b.booleanValue();
    }

    public final boolean m13515w() {
        if (this.f14230a == null) {
            synchronized (this) {
                if (this.f14230a == null) {
                    ApplicationInfo applicationInfo = mo1820l().getApplicationInfo();
                    String a = zzs.m4919a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f14230a = Boolean.valueOf(z);
                    }
                    if (this.f14230a == null) {
                        this.f14230a = Boolean.TRUE;
                        mo1828t().f17816a.m5693a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f14230a.booleanValue();
    }

    public final long m13489a(java.lang.String r3, com.google.android.gms.internal.zzchd<java.lang.Long> r4) {
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
        if (r3 != 0) goto L_0x000b;
    L_0x0002:
        r3 = r4.f6893a;
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
    L_0x000b:
        r0 = r2.mo1825q();
        r1 = r4.f6894b;
        r3 = r0.m18230a(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r4.f6893a;
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
    L_0x0024:
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ NumberFormatException -> 0x003b }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x003b }
        r3 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x003b }
        r3 = r4.m5676a(r3);	 Catch:{ NumberFormatException -> 0x003b }
        r3 = (java.lang.Long) r3;	 Catch:{ NumberFormatException -> 0x003b }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x003b }
        return r0;
    L_0x003b:
        r3 = r4.f6893a;
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgn.a(java.lang.String, com.google.android.gms.internal.zzchd):long");
    }

    public final int m13491b(java.lang.String r3, com.google.android.gms.internal.zzchd<java.lang.Integer> r4) {
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
        if (r3 != 0) goto L_0x000b;
    L_0x0002:
        r3 = r4.f6893a;
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        return r3;
    L_0x000b:
        r0 = r2.mo1825q();
        r1 = r4.f6894b;
        r3 = r0.m18230a(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r4.f6893a;
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        return r3;
    L_0x0024:
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x003b }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x003b }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x003b }
        r3 = r4.m5676a(r3);	 Catch:{ NumberFormatException -> 0x003b }
        r3 = (java.lang.Integer) r3;	 Catch:{ NumberFormatException -> 0x003b }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x003b }
        return r3;
    L_0x003b:
        r3 = r4.f6893a;
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgn.b(java.lang.String, com.google.android.gms.internal.zzchd):int");
    }

    final Boolean m13492b(String str) {
        zzbq.m4810a(str);
        try {
            if (mo1820l().getPackageManager() == null) {
                mo1828t().f17816a.m5693a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a = zzbhf.m5574a(mo1820l()).m5569a(mo1820l().getPackageName(), 128);
            if (a == null) {
                mo1828t().f17816a.m5693a("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (a.metaData == null) {
                mo1828t().f17816a.m5693a("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (a.metaData.containsKey(str)) {
                return Boolean.valueOf(a.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (String str2) {
            mo1828t().f17816a.m5694a("Failed to load metadata: Package name not found", str2);
            return null;
        }
    }

    public static long m13485y() {
        return ((Long) zzchc.f6857F.f6893a).longValue();
    }

    public static long m13486z() {
        return ((Long) zzchc.f6872f.f6893a).longValue();
    }

    public final String m13487A() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            mo1828t().f17816a.m5694a("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            mo1828t().f17816a.m5694a("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            mo1828t().f17816a.m5694a("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            mo1828t().f17816a.m5694a("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static boolean m13484B() {
        return ((Boolean) zzchc.f6867a.f6893a).booleanValue();
    }
}
