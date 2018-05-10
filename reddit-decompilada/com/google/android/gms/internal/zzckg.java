package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzckg extends zzcjl {
    volatile Boolean f17886a;
    private final zzcku f17887b;
    private zzche f17888c;
    private final zzcgs f17889d;
    private final zzclk f17890e;
    private final List<Runnable> f17891f = new ArrayList();
    private final zzcgs f17892g;

    private final zzcgi m18397a(boolean z) {
        return mo1815g().m18059a(z ? mo1828t().m18184y() : null);
    }

    protected final void m18407B() {
        mo1811c();
        m13545L();
        m18400a(new zzckk(this, m18397a(true)));
    }

    public final void m18409D() {
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
        r2.m13545L();
        com.google.android.gms.common.stats.zza.m4889a();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0 = r2.mo1820l();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r1 = r2.f17887b;	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0.unbindService(r1);	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
    L_0x0012:
        r0 = 0;
        r2.f17888c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckg.D():void");
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    protected final void m18413a(zzche com_google_android_gms_internal_zzche) {
        mo1811c();
        zzbq.m4808a((Object) com_google_android_gms_internal_zzche);
        this.f17888c = com_google_android_gms_internal_zzche;
        m18395E();
        m18396F();
    }

    protected final void m18416a(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        mo1811c();
        m13545L();
        m18400a(new zzckl(this, com_google_android_gms_measurement_AppMeasurement_zzb));
    }

    public final void m18417a(AtomicReference<String> atomicReference) {
        mo1811c();
        m13545L();
        m18400a(new zzckj(this, atomicReference, m18397a(false)));
    }

    protected final void m18418a(AtomicReference<List<zzcgl>> atomicReference, String str, String str2, String str3) {
        mo1811c();
        m13545L();
        m18400a(new zzckq(this, atomicReference, str, str2, str3, m18397a(false)));
    }

    protected final void m18419a(AtomicReference<List<zzcln>> atomicReference, String str, String str2, String str3, boolean z) {
        mo1811c();
        m13545L();
        m18400a(new zzckr(this, atomicReference, str, str2, str3, z, m18397a(false)));
    }

    protected final void m18420a(AtomicReference<List<zzcln>> atomicReference, boolean z) {
        mo1811c();
        m13545L();
        m18400a(new zzckt(this, atomicReference, m18397a(false), z));
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
        return false;
    }

    public final boolean m18443y() {
        mo1811c();
        m13545L();
        return this.f17888c != null;
    }

    protected final void m18444z() {
        mo1811c();
        m13545L();
        m18400a(new zzckn(this, m18397a(true)));
    }

    protected zzckg(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
        this.f17890e = new zzclk(com_google_android_gms_internal_zzcim.f6982i);
        this.f17887b = new zzcku(this);
        this.f17889d = new zzckh(this, com_google_android_gms_internal_zzcim);
        this.f17892g = new zzckm(this, com_google_android_gms_internal_zzcim);
    }

    final void m18414a(zzche com_google_android_gms_internal_zzche, zzbfm com_google_android_gms_internal_zzbfm, zzcgi com_google_android_gms_internal_zzcgi) {
        mo1811c();
        m13545L();
        int i = 0;
        int i2 = 100;
        while (i < CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT && r3 == 100) {
            int size;
            List arrayList = new ArrayList();
            Object y = mo1821m().m18109y();
            if (y != null) {
                arrayList.addAll(y);
                size = y.size();
            } else {
                size = 0;
            }
            if (com_google_android_gms_internal_zzbfm != null && size < 100) {
                arrayList.add(com_google_android_gms_internal_zzbfm);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList2.get(i3);
                i3++;
                zzbfm com_google_android_gms_internal_zzbfm2 = (zzbfm) obj;
                if (com_google_android_gms_internal_zzbfm2 instanceof zzcha) {
                    try {
                        com_google_android_gms_internal_zzche.mo1840a((zzcha) com_google_android_gms_internal_zzbfm2, com_google_android_gms_internal_zzcgi);
                    } catch (RemoteException e) {
                        mo1828t().f17816a.m5694a("Failed to send event to the service", e);
                    }
                } else if (com_google_android_gms_internal_zzbfm2 instanceof zzcln) {
                    try {
                        com_google_android_gms_internal_zzche.mo1842a((zzcln) com_google_android_gms_internal_zzbfm2, com_google_android_gms_internal_zzcgi);
                    } catch (RemoteException e2) {
                        mo1828t().f17816a.m5694a("Failed to send attribute to the service", e2);
                    }
                } else if (com_google_android_gms_internal_zzbfm2 instanceof zzcgl) {
                    try {
                        com_google_android_gms_internal_zzche.mo1839a((zzcgl) com_google_android_gms_internal_zzbfm2, com_google_android_gms_internal_zzcgi);
                    } catch (RemoteException e22) {
                        mo1828t().f17816a.m5694a("Failed to send conditional property to the service", e22);
                    }
                } else {
                    mo1828t().f17816a.m5693a("Discarding data. Unrecognized parcel type.");
                }
            }
            i++;
            i2 = size;
        }
    }

    protected final void m18412a(zzcha com_google_android_gms_internal_zzcha, String str) {
        boolean z;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcha);
        mo1811c();
        m13545L();
        zzcjk m = mo1821m();
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzcha.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            m.mo1828t().f17818c.m5693a("Event is too long for local database. Sending event directly to service");
            z = false;
        } else {
            z = m.m18086a(0, marshall);
        }
        m18400a(new zzcko(this, z, com_google_android_gms_internal_zzcha, m18397a(true), str));
    }

    protected final void m18411a(zzcgl com_google_android_gms_internal_zzcgl) {
        boolean z;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        mo1811c();
        m13545L();
        zzcjk m = mo1821m();
        m.mo1824p();
        byte[] a = zzclq.m18516a((Parcelable) com_google_android_gms_internal_zzcgl);
        if (a.length > 131072) {
            m.mo1828t().f17818c.m5693a("Conditional user property too long for local database. Sending directly to service");
            z = false;
        } else {
            z = m.m18086a(2, a);
        }
        m18400a(new zzckp(this, z, new zzcgl(com_google_android_gms_internal_zzcgl), m18397a(true), com_google_android_gms_internal_zzcgl));
    }

    protected final void m18415a(zzcln com_google_android_gms_internal_zzcln) {
        boolean z;
        mo1811c();
        m13545L();
        zzcjk m = mo1821m();
        Parcel obtain = Parcel.obtain();
        boolean z2 = false;
        com_google_android_gms_internal_zzcln.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            m.mo1828t().f17818c.m5693a("User property too long for local database. Sending directly to service");
            z = false;
        } else {
            z = m.m18086a(1, marshall);
        }
        if (z) {
            z2 = true;
        }
        m18400a(new zzcks(this, z2, com_google_android_gms_internal_zzcln, m18397a(true)));
    }

    protected final void m18406A() {
        mo1811c();
        m13545L();
        zzcgi a = m18397a(false);
        zzcjk m = mo1821m();
        m.mo1811c();
        try {
            int delete = 0 + m.m18110z().delete("messages", null, null);
            if (delete > 0) {
                m.mo1828t().f17822g.m5694a("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            m.mo1828t().f17816a.m5694a("Error resetting local analytics data. error", e);
        }
        m18400a(new zzcki(this, a));
    }

    private final void m18395E() {
        mo1811c();
        this.f17890e.m5805a();
        this.f17889d.m5664a(((Long) zzchc.f6860I.f6893a).longValue());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m18408C() {
        /*
        r6 = this;
        r6.mo1811c();
        r6.m13545L();
        r0 = r6.m18443y();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.f17886a;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x00f6;
    L_0x0013:
        r6.mo1811c();
        r6.m13545L();
        r0 = r6.mo1829u();
        r0 = r0.m18213A();
        if (r0 == 0) goto L_0x002c;
    L_0x0023:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r3 = r2;
        goto L_0x00f0;
    L_0x002c:
        r0 = r6.mo1815g();
        r0 = r0.m18058C();
        if (r0 != r2) goto L_0x003a;
    L_0x0036:
        r0 = r2;
    L_0x0037:
        r3 = r0;
        goto L_0x00e7;
    L_0x003a:
        r0 = r6.mo1828t();
        r0 = r0.f17822g;
        r3 = "Checking service availability";
        r0.m5693a(r3);
        r0 = r6.mo1824p();
        r3 = com.google.android.gms.common.zzf.m4930b();
        r0 = r0.mo1820l();
        r0 = r3.mo1537a(r0);
        r3 = 9;
        if (r0 == r3) goto L_0x00db;
    L_0x0059:
        r3 = 18;
        if (r0 == r3) goto L_0x00ce;
    L_0x005d:
        switch(r0) {
            case 0: goto L_0x00c1;
            case 1: goto L_0x00b3;
            case 2: goto L_0x007d;
            case 3: goto L_0x0071;
            default: goto L_0x0060;
        };
    L_0x0060:
        r3 = r6.mo1828t();
        r3 = r3.f17818c;
        r4 = "Unexpected service status";
        r0 = java.lang.Integer.valueOf(r0);
        r3.m5694a(r4, r0);
    L_0x006f:
        r0 = r1;
        goto L_0x0037;
    L_0x0071:
        r0 = r6.mo1828t();
        r0 = r0.f17818c;
        r3 = "Service disabled";
        r0.m5693a(r3);
        goto L_0x006f;
    L_0x007d:
        r0 = r6.mo1828t();
        r0 = r0.f17821f;
        r3 = "Service container out of date";
        r0.m5693a(r3);
        r0 = r6.mo1824p();
        com.google.android.gms.common.zzf.m4930b();
        r0 = r0.mo1820l();
        r0 = com.google.android.gms.common.zzf.m4934d(r0);
        r3 = 11400; // 0x2c88 float:1.5975E-41 double:5.6323E-320;
        if (r0 >= r3) goto L_0x009c;
    L_0x009b:
        goto L_0x00be;
    L_0x009c:
        r0 = r6.mo1829u();
        r0 = r0.m18213A();
        if (r0 == 0) goto L_0x00af;
    L_0x00a6:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00ad;
    L_0x00ac:
        goto L_0x00af;
    L_0x00ad:
        r0 = r1;
        goto L_0x00b0;
    L_0x00af:
        r0 = r2;
    L_0x00b0:
        r3 = r0;
        r0 = r1;
        goto L_0x00e7;
    L_0x00b3:
        r0 = r6.mo1828t();
        r0 = r0.f17822g;
        r3 = "Service missing";
        r0.m5693a(r3);
    L_0x00be:
        r3 = r1;
        r0 = r2;
        goto L_0x00e7;
    L_0x00c1:
        r0 = r6.mo1828t();
        r0 = r0.f17822g;
        r3 = "Service available";
        r0.m5693a(r3);
        goto L_0x0036;
    L_0x00ce:
        r0 = r6.mo1828t();
        r0 = r0.f17818c;
        r3 = "Service updating";
        r0.m5693a(r3);
        goto L_0x0036;
    L_0x00db:
        r0 = r6.mo1828t();
        r0 = r0.f17818c;
        r3 = "Service invalid";
        r0.m5693a(r3);
        goto L_0x006f;
    L_0x00e7:
        if (r0 == 0) goto L_0x00f0;
    L_0x00e9:
        r0 = r6.mo1829u();
        r0.m18217a(r3);
    L_0x00f0:
        r0 = java.lang.Boolean.valueOf(r3);
        r6.f17886a = r0;
    L_0x00f6:
        r0 = r6.f17886a;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0156;
    L_0x00fe:
        r0 = r6.f17887b;
        r1 = r0.f14248c;
        r1.mo1811c();
        r1 = r0.f14248c;
        r1 = r1.mo1820l();
        monitor-enter(r0);
        r3 = r0.f14246a;	 Catch:{ all -> 0x0153 }
        if (r3 == 0) goto L_0x011f;
    L_0x0110:
        r1 = r0.f14248c;	 Catch:{ all -> 0x0153 }
        r1 = r1.mo1828t();	 Catch:{ all -> 0x0153 }
        r1 = r1.f17822g;	 Catch:{ all -> 0x0153 }
        r2 = "Connection attempt already in progress";
        r1.m5693a(r2);	 Catch:{ all -> 0x0153 }
        monitor-exit(r0);	 Catch:{ all -> 0x0153 }
        return;
    L_0x011f:
        r3 = r0.f14247b;	 Catch:{ all -> 0x0153 }
        if (r3 == 0) goto L_0x0132;
    L_0x0123:
        r1 = r0.f14248c;	 Catch:{ all -> 0x0153 }
        r1 = r1.mo1828t();	 Catch:{ all -> 0x0153 }
        r1 = r1.f17822g;	 Catch:{ all -> 0x0153 }
        r2 = "Already awaiting connection attempt";
        r1.m5693a(r2);	 Catch:{ all -> 0x0153 }
        monitor-exit(r0);	 Catch:{ all -> 0x0153 }
        return;
    L_0x0132:
        r3 = new com.google.android.gms.internal.zzchl;	 Catch:{ all -> 0x0153 }
        r4 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0153 }
        r3.<init>(r1, r4, r0, r0);	 Catch:{ all -> 0x0153 }
        r0.f14247b = r3;	 Catch:{ all -> 0x0153 }
        r1 = r0.f14248c;	 Catch:{ all -> 0x0153 }
        r1 = r1.mo1828t();	 Catch:{ all -> 0x0153 }
        r1 = r1.f17822g;	 Catch:{ all -> 0x0153 }
        r3 = "Connecting to remote service";
        r1.m5693a(r3);	 Catch:{ all -> 0x0153 }
        r0.f14246a = r2;	 Catch:{ all -> 0x0153 }
        r1 = r0.f14247b;	 Catch:{ all -> 0x0153 }
        r1.m4860o();	 Catch:{ all -> 0x0153 }
        monitor-exit(r0);	 Catch:{ all -> 0x0153 }
        return;
    L_0x0153:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0153 }
        throw r1;
    L_0x0156:
        r0 = r6.mo1820l();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = r6.mo1820l();
        r5 = "com.google.android.gms.measurement.AppMeasurementService";
        r3 = r3.setClassName(r4, r5);
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.queryIntentServices(r3, r4);
        if (r0 == 0) goto L_0x017c;
    L_0x0175:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x017c;
    L_0x017b:
        r1 = r2;
    L_0x017c:
        if (r1 == 0) goto L_0x01d4;
    L_0x017e:
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.measurement.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r3 = r6.mo1820l();
        r4 = "com.google.android.gms.measurement.AppMeasurementService";
        r1.<init>(r3, r4);
        r0.setComponent(r1);
        r1 = r6.f17887b;
        r3 = r1.f14248c;
        r3.mo1811c();
        r3 = r1.f14248c;
        r3 = r3.mo1820l();
        com.google.android.gms.common.stats.zza.m4889a();
        monitor-enter(r1);
        r4 = r1.f14246a;	 Catch:{ all -> 0x01d1 }
        if (r4 == 0) goto L_0x01b7;
    L_0x01a8:
        r0 = r1.f14248c;	 Catch:{ all -> 0x01d1 }
        r0 = r0.mo1828t();	 Catch:{ all -> 0x01d1 }
        r0 = r0.f17822g;	 Catch:{ all -> 0x01d1 }
        r2 = "Connection attempt already in progress";
        r0.m5693a(r2);	 Catch:{ all -> 0x01d1 }
        monitor-exit(r1);	 Catch:{ all -> 0x01d1 }
        return;
    L_0x01b7:
        r4 = r1.f14248c;	 Catch:{ all -> 0x01d1 }
        r4 = r4.mo1828t();	 Catch:{ all -> 0x01d1 }
        r4 = r4.f17822g;	 Catch:{ all -> 0x01d1 }
        r5 = "Using local app measurement service";
        r4.m5693a(r5);	 Catch:{ all -> 0x01d1 }
        r1.f14246a = r2;	 Catch:{ all -> 0x01d1 }
        r2 = r1.f14248c;	 Catch:{ all -> 0x01d1 }
        r2 = r2.f17887b;	 Catch:{ all -> 0x01d1 }
        r4 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        com.google.android.gms.common.stats.zza.m4891b(r3, r0, r2, r4);	 Catch:{ all -> 0x01d1 }
        monitor-exit(r1);	 Catch:{ all -> 0x01d1 }
        return;
    L_0x01d1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01d1 }
        throw r0;
    L_0x01d4:
        r0 = r6.mo1828t();
        r0 = r0.f17816a;
        r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
        r0.m5693a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckg.C():void");
    }

    private final void m18400a(Runnable runnable) throws IllegalStateException {
        mo1811c();
        if (m18443y()) {
            runnable.run();
        } else if (((long) this.f17891f.size()) >= 1000) {
            mo1828t().f17816a.m5693a("Discarding data. Max runnable queue size reached");
        } else {
            this.f17891f.add(runnable);
            this.f17892g.m5664a(60000);
            m18408C();
        }
    }

    private final void m18396F() {
        mo1811c();
        mo1828t().f17822g.m5694a("Processing queued up service tasks", Integer.valueOf(this.f17891f.size()));
        for (Runnable run : this.f17891f) {
            try {
                run.run();
            } catch (Throwable th) {
                mo1828t().f17816a.m5694a("Task exception while flushing queue", th);
            }
        }
        this.f17891f.clear();
        this.f17892g.m5666c();
    }

    static /* synthetic */ void m18399a(zzckg com_google_android_gms_internal_zzckg, ComponentName componentName) {
        com_google_android_gms_internal_zzckg.mo1811c();
        if (com_google_android_gms_internal_zzckg.f17888c != null) {
            com_google_android_gms_internal_zzckg.f17888c = null;
            com_google_android_gms_internal_zzckg.mo1828t().f17822g.m5694a("Disconnected from device MeasurementService", componentName);
            com_google_android_gms_internal_zzckg.mo1811c();
            com_google_android_gms_internal_zzckg.m18408C();
        }
    }

    static /* synthetic */ void m18403d(zzckg com_google_android_gms_internal_zzckg) {
        com_google_android_gms_internal_zzckg.mo1811c();
        if (com_google_android_gms_internal_zzckg.m18443y()) {
            com_google_android_gms_internal_zzckg.mo1828t().f17822g.m5693a("Inactivity, disconnecting from the service");
            com_google_android_gms_internal_zzckg.m18409D();
        }
    }
}
