package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcjn extends zzcjl {
    protected zzckb f17872a;
    public EventInterceptor f17873b;
    public final AtomicReference<String> f17874c = new AtomicReference();
    private final Set<OnEventListener> f17875d = new CopyOnWriteArraySet();
    private boolean f17876e;

    protected zzcjn(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final void m18320a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String str3 : bundle4.keySet()) {
                Object obj = bundle4.get(str3);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(str3, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        mo1827s().m18271a(new zzcjv(this, str, str2, j, bundle2, z, z2, z3));
    }

    private final void m18321a(String str, String str2, long j, Object obj) {
        mo1827s().m18271a(new zzcjw(this, str, str2, obj, j));
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final void m18329a(EventInterceptor eventInterceptor) {
        mo1811c();
        m13545L();
        if (!(eventInterceptor == null || eventInterceptor == this.f17873b)) {
            zzbq.m4814a(this.f17873b == null, (Object) "EventInterceptor already set.");
        }
        this.f17873b = eventInterceptor;
    }

    final void m18331a(String str) {
        this.f17874c.set(str);
    }

    public final void m18332a(String str, String str2, Bundle bundle) {
        boolean z;
        if (this.f17873b != null) {
            if (!zzclq.m18527h(str2)) {
                z = false;
                m18334a(str, str2, bundle, z, false);
            }
        }
        z = true;
        m18334a(str, str2, bundle, z, false);
    }

    public final void m18333a(String str, String str2, Bundle bundle, long j) {
        m18320a(str, str2, j, bundle, false, true, true);
    }

    public final void m18334a(String str, String str2, Bundle bundle, boolean z, boolean z2) {
        m18320a(str, str2, mo1819k().mo1632a(), bundle, true, z, z2);
    }

    public final void m18335a(String str, String str2, Object obj) {
        zzbq.m4810a(str);
        long a = mo1819k().mo1632a();
        int d = mo1824p().m18557d(str2);
        int i = 0;
        if (d != 0) {
            mo1824p();
            str = zzclq.m18506a(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.s.m5758i().m18539a(d, "_ev", str, i);
        } else if (obj != null) {
            d = mo1824p().m18550b(str2, obj);
            if (d != 0) {
                mo1824p();
                str = zzclq.m18506a(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.s.m5758i().m18539a(d, "_ev", str, i);
                return;
            }
            mo1824p();
            Object c = zzclq.m18523c(str2, obj);
            if (c != null) {
                m18321a(str, str2, a, c);
            }
        } else {
            m18321a(str, str2, a, null);
        }
    }

    public final void m18336a(String str, String str2, String str3, Bundle bundle) {
        long a = mo1819k().mo1632a();
        zzbq.m4810a(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = a;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        mo1827s().m18271a(new zzcjq(this, conditionalUserProperty));
    }

    public final void m18337a(boolean z) {
        m13545L();
        mo1827s().m18271a(new zzcjo(this, z));
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    public final void m18340b(ConditionalUserProperty conditionalUserProperty) {
        zzbq.m4808a((Object) conditionalUserProperty);
        zzbq.m4810a(conditionalUserProperty.mAppId);
        mo1809a();
        m18323c(new ConditionalUserProperty(conditionalUserProperty));
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

    public final List<zzcln> m18338b(boolean z) {
        m13545L();
        mo1828t().f17821f.m5693a("Fetching user attributes (FE)");
        if (mo1827s().m18296z()) {
            mo1828t().f17816a.m5693a("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        mo1827s();
        if (zzcih.m18267y()) {
            mo1828t().f17816a.m5693a("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.s.m5755f().m18271a(new zzcjx(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (boolean z2) {
                mo1828t().f17818c.m5694a("Interrupted waiting for get user properties", z2);
            }
        }
        z2 = (List) atomicReference.get();
        if (z2 == null) {
            mo1828t().f17818c.m5693a("Timed out waiting for get user properties");
            z2 = Collections.emptyList();
        }
        return z2;
    }

    public final Task<String> m18363y() {
        try {
            Object z = mo1829u().m18224z();
            return z != null ? Tasks.m6862a(z) : Tasks.m6863a(mo1827s().m18268A(), new zzcjy(this));
        } catch (Exception e) {
            mo1828t().f17818c.m5693a("Failed to schedule task for getAppInstanceId");
            return Tasks.m6861a(e);
        }
    }

    final java.lang.String m18324a(long r4) {
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
        r0 = new java.util.concurrent.atomic.AtomicReference;
        r0.<init>();
        monitor-enter(r0);
        r1 = r3.mo1827s();	 Catch:{ all -> 0x002b }
        r2 = new com.google.android.gms.internal.zzcjz;	 Catch:{ all -> 0x002b }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x002b }
        r1.m18271a(r2);	 Catch:{ all -> 0x002b }
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x002b }
        r4 = r0.get();
        r4 = (java.lang.String) r4;
        return r4;
    L_0x001d:
        r4 = r3.mo1828t();	 Catch:{ all -> 0x002b }
        r4 = r4.f17818c;	 Catch:{ all -> 0x002b }
        r5 = "Interrupted waiting for app instance id";	 Catch:{ all -> 0x002b }
        r4.m5693a(r5);	 Catch:{ all -> 0x002b }
        r4 = 0;	 Catch:{ all -> 0x002b }
        monitor-exit(r0);	 Catch:{ all -> 0x002b }
        return r4;	 Catch:{ all -> 0x002b }
    L_0x002b:
        r4 = move-exception;	 Catch:{ all -> 0x002b }
        monitor-exit(r0);	 Catch:{ all -> 0x002b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.a(long):java.lang.String");
    }

    public final void m18330a(OnEventListener onEventListener) {
        m13545L();
        zzbq.m4808a((Object) onEventListener);
        if (this.f17875d.add(onEventListener) == null) {
            mo1828t().f17818c.m5693a("OnEventListener already registered");
        }
    }

    public final void m18341b(OnEventListener onEventListener) {
        m13545L();
        zzbq.m4808a((Object) onEventListener);
        if (this.f17875d.remove(onEventListener) == null) {
            mo1828t().f17818c.m5693a("OnEventListener had not been registered");
        }
    }

    public final void m18328a(ConditionalUserProperty conditionalUserProperty) {
        zzbq.m4808a((Object) conditionalUserProperty);
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (TextUtils.isEmpty(conditionalUserProperty2.mAppId) == null) {
            mo1828t().f17818c.m5693a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        m18323c(conditionalUserProperty2);
    }

    private final void m18323c(ConditionalUserProperty conditionalUserProperty) {
        long a = mo1819k().mo1632a();
        zzbq.m4808a((Object) conditionalUserProperty);
        zzbq.m4810a(conditionalUserProperty.mName);
        zzbq.m4810a(conditionalUserProperty.mOrigin);
        zzbq.m4808a(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = a;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (mo1824p().m18557d(str) != 0) {
            mo1828t().f17816a.m5694a("Invalid conditional user property name", mo1823o().m18132c(str));
        } else if (mo1824p().m18550b(str, obj) != 0) {
            mo1828t().f17816a.m5695a("Invalid conditional user property value", mo1823o().m18132c(str), obj);
        } else {
            mo1824p();
            Object c = zzclq.m18523c(str, obj);
            if (c == null) {
                mo1828t().f17816a.m5695a("Unable to normalize conditional user property value", mo1823o().m18132c(str), obj);
                return;
            }
            conditionalUserProperty.mValue = c;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j <= 15552000000L) {
                    if (j >= 1) {
                        mo1827s().m18271a(new zzcjp(this, conditionalUserProperty));
                        return;
                    }
                }
                mo1828t().f17816a.m5695a("Invalid conditional user property time to live", mo1823o().m18132c(str), Long.valueOf(j));
                return;
            }
            mo1828t().f17816a.m5695a("Invalid conditional user property timeout", mo1823o().m18132c(str), Long.valueOf(j));
        }
    }

    public final List<ConditionalUserProperty> m18325a(String str, String str2, String str3) {
        if (mo1827s().m18296z()) {
            mo1828t().f17816a.m5693a("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        mo1827s();
        if (zzcih.m18267y()) {
            mo1828t().f17816a.m5693a("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.s.m5755f().m18271a(new zzcjr(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (String str32) {
                mo1828t().f17818c.m5695a("Interrupted waiting for get conditional user properties", str, str32);
            }
        }
        List<zzcgl> list = (List) atomicReference.get();
        if (list == null) {
            mo1828t().f17818c.m5694a("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
        for (zzcgl com_google_android_gms_internal_zzcgl : list) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = com_google_android_gms_internal_zzcgl.f17777d;
            conditionalUserProperty.mName = com_google_android_gms_internal_zzcgl.f17776c.f17900a;
            conditionalUserProperty.mValue = com_google_android_gms_internal_zzcgl.f17776c.m18501a();
            conditionalUserProperty.mActive = com_google_android_gms_internal_zzcgl.f17778e;
            conditionalUserProperty.mTriggerEventName = com_google_android_gms_internal_zzcgl.f17779f;
            if (com_google_android_gms_internal_zzcgl.f17780g != null) {
                conditionalUserProperty.mTimedOutEventName = com_google_android_gms_internal_zzcgl.f17780g.f17798a;
                if (com_google_android_gms_internal_zzcgl.f17780g.f17799b != null) {
                    conditionalUserProperty.mTimedOutEventParams = com_google_android_gms_internal_zzcgl.f17780g.f17799b.m18052a();
                }
            }
            conditionalUserProperty.mTriggerTimeout = com_google_android_gms_internal_zzcgl.f17781h;
            if (com_google_android_gms_internal_zzcgl.f17782i != null) {
                conditionalUserProperty.mTriggeredEventName = com_google_android_gms_internal_zzcgl.f17782i.f17798a;
                if (com_google_android_gms_internal_zzcgl.f17782i.f17799b != null) {
                    conditionalUserProperty.mTriggeredEventParams = com_google_android_gms_internal_zzcgl.f17782i.f17799b.m18052a();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = com_google_android_gms_internal_zzcgl.f17776c.f17901b;
            conditionalUserProperty.mTimeToLive = com_google_android_gms_internal_zzcgl.f17783j;
            if (com_google_android_gms_internal_zzcgl.f17784k != null) {
                conditionalUserProperty.mExpiredEventName = com_google_android_gms_internal_zzcgl.f17784k.f17798a;
                if (com_google_android_gms_internal_zzcgl.f17784k.f17799b != null) {
                    conditionalUserProperty.mExpiredEventParams = com_google_android_gms_internal_zzcgl.f17784k.f17799b.m18052a();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public final Map<String, Object> m18326a(String str, String str2, String str3, boolean z) {
        if (mo1827s().m18296z()) {
            mo1828t().f17816a.m5693a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        mo1827s();
        if (zzcih.m18267y()) {
            mo1828t().f17816a.m5693a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.s.m5755f().m18271a(new zzcjs(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (String str4) {
                mo1828t().f17818c.m5694a("Interrupted waiting for get user properties", str4);
            }
        }
        List<zzcln> list = (List) atomicReference.get();
        if (list == null) {
            mo1828t().f17818c.m5693a("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        str2 = new ArrayMap(list.size());
        for (zzcln com_google_android_gms_internal_zzcln : list) {
            str2.put(com_google_android_gms_internal_zzcln.f17900a, com_google_android_gms_internal_zzcln.m18501a());
        }
        return str2;
    }

    static /* synthetic */ void m18319a(zzcjn com_google_android_gms_internal_zzcjn, boolean z) {
        com_google_android_gms_internal_zzcjn.mo1811c();
        com_google_android_gms_internal_zzcjn.m13545L();
        com_google_android_gms_internal_zzcjn.mo1828t().f17821f.m5694a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        com_google_android_gms_internal_zzcjn.mo1829u().m18219b(z);
        com_google_android_gms_internal_zzcjn.mo1817i().m18444z();
    }

    static /* synthetic */ void m18317a(com.google.android.gms.internal.zzcjn r24, java.lang.String r25, java.lang.String r26, long r27, android.os.Bundle r29, boolean r30, boolean r31, boolean r32, java.lang.String r33) {
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
        r1 = r24;
        r8 = r25;
        r9 = r26;
        com.google.android.gms.common.internal.zzbq.m4810a(r25);
        com.google.android.gms.common.internal.zzbq.m4810a(r26);
        com.google.android.gms.common.internal.zzbq.m4808a(r29);
        r24.mo1811c();
        r24.m13545L();
        r2 = r1.s;
        r2 = r2.m5768s();
        if (r2 != 0) goto L_0x0029;
    L_0x001d:
        r1 = r24.mo1828t();
        r1 = r1.f17821f;
        r2 = "Event not sent since app measurement is disabled";
        r1.m5693a(r2);
        return;
    L_0x0029:
        r2 = r1.f17876e;
        r10 = 0;
        r11 = 1;
        if (r2 != 0) goto L_0x0069;
    L_0x002f:
        r1.f17876e = r11;
        r2 = "com.google.android.gms.tagmanager.TagManagerService";	 Catch:{ ClassNotFoundException -> 0x005e }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = "initialize";	 Catch:{ Exception -> 0x0050 }
        r4 = new java.lang.Class[r11];	 Catch:{ Exception -> 0x0050 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0050 }
        r4[r10] = r5;	 Catch:{ Exception -> 0x0050 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0050 }
        r3 = 0;	 Catch:{ Exception -> 0x0050 }
        r4 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x0050 }
        r5 = r24.mo1820l();	 Catch:{ Exception -> 0x0050 }
        r4[r10] = r5;	 Catch:{ Exception -> 0x0050 }
        r2.invoke(r3, r4);	 Catch:{ Exception -> 0x0050 }
        goto L_0x0069;
    L_0x0050:
        r0 = move-exception;
        r2 = r0;
        r3 = r24.mo1828t();	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = r3.f17818c;	 Catch:{ ClassNotFoundException -> 0x005e }
        r4 = "Failed to invoke Tag Manager's initialize() method";	 Catch:{ ClassNotFoundException -> 0x005e }
        r3.m5694a(r4, r2);	 Catch:{ ClassNotFoundException -> 0x005e }
        goto L_0x0069;
    L_0x005e:
        r2 = r24.mo1828t();
        r2 = r2.f17820e;
        r3 = "Tag Manager is not found and thus will not be used";
        r2.m5693a(r3);
    L_0x0069:
        r2 = "am";
        r12 = r2.equals(r8);
        r2 = com.google.android.gms.internal.zzclq.m18527h(r26);
        if (r30 == 0) goto L_0x009b;
    L_0x0075:
        r3 = r1.f17873b;
        if (r3 == 0) goto L_0x009b;
    L_0x0079:
        if (r2 != 0) goto L_0x009b;
    L_0x007b:
        if (r12 != 0) goto L_0x009b;
    L_0x007d:
        r2 = r24.mo1828t();
        r2 = r2.f17821f;
        r3 = "Passing event to registered event handler (FE)";
        r4 = r24.mo1823o();
        r4 = r4.m18128a(r9);
        r1 = r24.mo1823o();
        r13 = r29;
        r1 = r1.m18122a(r13);
        r2.m5695a(r3, r4, r1);
        return;
    L_0x009b:
        r13 = r29;
        r2 = r1.s;
        r2 = r2.m5749b();
        if (r2 == 0) goto L_0x024a;
    L_0x00a5:
        r2 = r24.mo1824p();
        r2 = r2.m18555c(r9);
        if (r2 == 0) goto L_0x00ca;
    L_0x00af:
        r24.mo1824p();
        r3 = 40;
        r3 = com.google.android.gms.internal.zzclq.m18506a(r9, r3, r11);
        if (r9 == 0) goto L_0x00be;
    L_0x00ba:
        r10 = r26.length();
    L_0x00be:
        r1 = r1.s;
        r1 = r1.m5758i();
        r4 = "_ev";
        r1.m18553b(r2, r4, r3, r10);
        return;
    L_0x00ca:
        r2 = "_o";
        r19 = java.util.Collections.singletonList(r2);
        r2 = r24.mo1824p();
        r7 = 1;
        r3 = r9;
        r4 = r13;
        r5 = r19;
        r6 = r32;
        r2 = r2.m18535a(r3, r4, r5, r6, r7);
        r6 = new java.util.ArrayList;
        r6.<init>();
        r6.add(r2);
        r3 = r24.mo1824p();
        r3 = r3.m18584z();
        r3 = r3.nextLong();
        r5 = r2.keySet();
        r7 = r29.size();
        r7 = new java.lang.String[r7];
        r5 = r5.toArray(r7);
        r5 = (java.lang.String[]) r5;
        java.util.Arrays.sort(r5);
        r7 = r5.length;
        r14 = r10;
        r15 = r14;
    L_0x0109:
        if (r15 >= r7) goto L_0x018b;
    L_0x010b:
        r13 = r5[r15];
        r10 = r2.get(r13);
        r24.mo1824p();
        r10 = com.google.android.gms.internal.zzclq.m18518a(r10);
        if (r10 == 0) goto L_0x0176;
    L_0x011a:
        r11 = r10.length;
        r2.putInt(r13, r11);
        r20 = r5;
        r11 = 0;
    L_0x0121:
        r5 = r10.length;
        if (r11 >= r5) goto L_0x016b;
    L_0x0124:
        r5 = r10[r11];
        r16 = r24.mo1824p();
        r17 = "_ep";
        r18 = 0;
        r21 = r7;
        r7 = r13;
        r13 = r16;
        r22 = r12;
        r12 = r14;
        r14 = r17;
        r23 = r15;
        r15 = r5;
        r16 = r19;
        r17 = r32;
        r5 = r13.m18535a(r14, r15, r16, r17, r18);
        r13 = "_en";
        r5.putString(r13, r9);
        r13 = "_eid";
        r5.putLong(r13, r3);
        r13 = "_gn";
        r5.putString(r13, r7);
        r13 = "_ll";
        r14 = r10.length;
        r5.putInt(r13, r14);
        r13 = "_i";
        r5.putInt(r13, r11);
        r6.add(r5);
        r11 = r11 + 1;
        r13 = r7;
        r14 = r12;
        r7 = r21;
        r12 = r22;
        r15 = r23;
        goto L_0x0121;
    L_0x016b:
        r21 = r7;
        r22 = r12;
        r12 = r14;
        r23 = r15;
        r5 = r10.length;
        r14 = r12 + r5;
        goto L_0x017f;
    L_0x0176:
        r20 = r5;
        r21 = r7;
        r22 = r12;
        r12 = r14;
        r23 = r15;
    L_0x017f:
        r15 = r23 + 1;
        r5 = r20;
        r7 = r21;
        r12 = r22;
        r10 = 0;
        r11 = 1;
        goto L_0x0109;
    L_0x018b:
        r22 = r12;
        r12 = r14;
        if (r12 == 0) goto L_0x019a;
    L_0x0190:
        r5 = "_eid";
        r2.putLong(r5, r3);
        r3 = "_epc";
        r2.putInt(r3, r12);
    L_0x019a:
        r3 = r24.mo1818j();
        r10 = r3.m18393y();
        if (r10 == 0) goto L_0x01af;
    L_0x01a4:
        r3 = "_sc";
        r2 = r2.containsKey(r3);
        if (r2 != 0) goto L_0x01af;
    L_0x01ac:
        r2 = 1;
        r10.f14243a = r2;
    L_0x01af:
        r11 = 0;
    L_0x01b0:
        r2 = r6.size();
        if (r11 >= r2) goto L_0x0230;
    L_0x01b6:
        r2 = r6.get(r11);
        r2 = (android.os.Bundle) r2;
        if (r11 == 0) goto L_0x01c0;
    L_0x01be:
        r3 = 1;
        goto L_0x01c1;
    L_0x01c0:
        r3 = 0;
    L_0x01c1:
        if (r3 == 0) goto L_0x01c6;
    L_0x01c3:
        r3 = "_ep";
        goto L_0x01c7;
    L_0x01c6:
        r3 = r9;
    L_0x01c7:
        r4 = "_o";
        r2.putString(r4, r8);
        r4 = "_sc";
        r4 = r2.containsKey(r4);
        if (r4 != 0) goto L_0x01d7;
    L_0x01d4:
        com.google.android.gms.internal.zzckc.m18366a(r10, r2);
    L_0x01d7:
        if (r31 == 0) goto L_0x01e1;
    L_0x01d9:
        r4 = r24.mo1824p();
        r2 = r4.m18534a(r2);
    L_0x01e1:
        r13 = r2;
        r2 = r24.mo1828t();
        r2 = r2.f17821f;
        r4 = "Logging event (FE)";
        r5 = r24.mo1823o();
        r5 = r5.m18128a(r9);
        r7 = r24.mo1823o();
        r7 = r7.m18122a(r13);
        r2.m5695a(r4, r5, r7);
        r14 = new com.google.android.gms.internal.zzcha;
        r4 = new com.google.android.gms.internal.zzcgx;
        r4.<init>(r13);
        r2 = r14;
        r5 = r8;
        r15 = r6;
        r6 = r27;
        r2.<init>(r3, r4, r5, r6);
        r2 = r24.mo1817i();
        r3 = r33;
        r2.m18412a(r14, r3);
        if (r22 != 0) goto L_0x022c;
    L_0x0217:
        r2 = r1.f17875d;
        r2 = r2.iterator();
    L_0x021d:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x022c;
    L_0x0223:
        r2.next();
        r4 = new android.os.Bundle;
        r4.<init>(r13);
        goto L_0x021d;
    L_0x022c:
        r11 = r11 + 1;
        r6 = r15;
        goto L_0x01b0;
    L_0x0230:
        r2 = r24.mo1818j();
        r2 = r2.m18393y();
        if (r2 == 0) goto L_0x024a;
    L_0x023a:
        r2 = "_ae";
        r2 = r2.equals(r9);
        if (r2 == 0) goto L_0x024a;
    L_0x0242:
        r1 = r24.mo1826r();
        r2 = 1;
        r1.m18450a(r2);
    L_0x024a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.a(com.google.android.gms.internal.zzcjn, java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    static /* synthetic */ void m18318a(zzcjn com_google_android_gms_internal_zzcjn, String str, String str2, Object obj, long j) {
        zzbq.m4810a(str);
        zzbq.m4810a(str2);
        com_google_android_gms_internal_zzcjn.mo1811c();
        com_google_android_gms_internal_zzcjn.m13545L();
        if (com_google_android_gms_internal_zzcjn.s.m5768s()) {
            if (com_google_android_gms_internal_zzcjn.s.m5749b()) {
                com_google_android_gms_internal_zzcjn.mo1828t().f17821f.m5695a("Setting user property (FE)", com_google_android_gms_internal_zzcjn.mo1823o().m18128a(str2), obj);
                com_google_android_gms_internal_zzcjn.mo1817i().m18415a(new zzcln(str2, j, obj, str));
            }
            return;
        }
        com_google_android_gms_internal_zzcjn.mo1828t().f17821f.m5693a("User property not set since app measurement is disabled");
    }

    static /* synthetic */ void m18316a(com.google.android.gms.internal.zzcjn r21, com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r22) {
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
        r0 = r22;
        r21.mo1811c();
        r21.m13545L();
        com.google.android.gms.common.internal.zzbq.m4808a(r22);
        r1 = r0.mName;
        com.google.android.gms.common.internal.zzbq.m4810a(r1);
        r1 = r0.mOrigin;
        com.google.android.gms.common.internal.zzbq.m4810a(r1);
        r1 = r0.mValue;
        com.google.android.gms.common.internal.zzbq.m4808a(r1);
        r1 = r21;
        r2 = r1.s;
        r2 = r2.m5768s();
        if (r2 != 0) goto L_0x0030;
    L_0x0024:
        r0 = r21.mo1828t();
        r0 = r0.f17821f;
        r1 = "Conditional property not sent since Firebase Analytics is disabled";
        r0.m5693a(r1);
        return;
    L_0x0030:
        r8 = new com.google.android.gms.internal.zzcln;
        r3 = r0.mName;
        r4 = r0.mTriggeredTimestamp;
        r6 = r0.mValue;
        r7 = r0.mOrigin;
        r2 = r8;
        r2.<init>(r3, r4, r6, r7);
        r9 = r21.mo1824p();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r10 = r0.mTriggeredEventName;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r11 = r0.mTriggeredEventParams;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r12 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r13 = 0;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r13 = r9.m18537a(r10, r11, r12, r13);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r2 = r21.mo1824p();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r3 = r0.mTimedOutEventName;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4 = r0.mTimedOutEventParams;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r6 = 0;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r10 = r2.m18537a(r3, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r2 = r21.mo1824p();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r3 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r6 = 0;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r16 = r2.m18537a(r3, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r14 = new com.google.android.gms.internal.zzcgl;
        r3 = r0.mAppId;
        r4 = r0.mOrigin;
        r6 = r0.mCreationTimestamp;
        r11 = r0.mTriggerEventName;
        r17 = r10;
        r9 = r0.mTriggerTimeout;
        r0 = r0.mTimeToLive;
        r2 = r14;
        r5 = r8;
        r8 = 0;
        r18 = r9;
        r9 = r11;
        r10 = r17;
        r11 = r18;
        r20 = r14;
        r14 = r0;
        r2.<init>(r3, r4, r5, r6, r8, r9, r10, r11, r13, r14, r16);
        r0 = r21.mo1817i();
        r1 = r20;
        r0.m18411a(r1);
    L_0x0097:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.a(com.google.android.gms.internal.zzcjn, com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    static /* synthetic */ void m18322b(com.google.android.gms.internal.zzcjn r21, com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r22) {
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
        r0 = r22;
        r21.mo1811c();
        r21.m13545L();
        com.google.android.gms.common.internal.zzbq.m4808a(r22);
        r1 = r0.mName;
        com.google.android.gms.common.internal.zzbq.m4810a(r1);
        r1 = r21;
        r2 = r1.s;
        r2 = r2.m5768s();
        if (r2 != 0) goto L_0x0026;
    L_0x001a:
        r0 = r21.mo1828t();
        r0 = r0.f17821f;
        r1 = "Conditional property not cleared since Firebase Analytics is disabled";
        r0.m5693a(r1);
        return;
    L_0x0026:
        r8 = new com.google.android.gms.internal.zzcln;
        r3 = r0.mName;
        r4 = 0;
        r6 = 0;
        r7 = 0;
        r2 = r8;
        r2.<init>(r3, r4, r6, r7);
        r9 = r21.mo1824p();	 Catch:{ IllegalArgumentException -> 0x006d }
        r10 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x006d }
        r11 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x006d }
        r12 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x006d }
        r13 = r0.mCreationTimestamp;	 Catch:{ IllegalArgumentException -> 0x006d }
        r16 = r9.m18537a(r10, r11, r12, r13);	 Catch:{ IllegalArgumentException -> 0x006d }
        r14 = new com.google.android.gms.internal.zzcgl;
        r3 = r0.mAppId;
        r4 = r0.mOrigin;
        r6 = r0.mCreationTimestamp;
        r9 = r0.mActive;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r15 = 0;
        r17 = r12;
        r11 = r0.mTimeToLive;
        r2 = r14;
        r5 = r8;
        r8 = r9;
        r9 = r10;
        r0 = 0;
        r10 = r0;
        r19 = r11;
        r11 = r17;
        r13 = r15;
        r0 = r14;
        r14 = r19;
        r2.<init>(r3, r4, r5, r6, r8, r9, r10, r11, r13, r14, r16);
        r1 = r21.mo1817i();
        r1.m18411a(r0);
    L_0x006d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.b(com.google.android.gms.internal.zzcjn, com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }
}
