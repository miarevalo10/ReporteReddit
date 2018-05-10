package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbha;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.jcodec.codecs.common.biari.MQEncoder;

public final class zzaa implements zzcc {
    private final Map<zzc<?>, zzz<?>> f13829a = new HashMap();
    private final Map<zzc<?>, zzz<?>> f13830b = new HashMap();
    private final Map<Api<?>, Boolean> f13831c;
    private final zzbm f13832d;
    private final zzba f13833e;
    private final Lock f13834f;
    private final Looper f13835g;
    private final zzf f13836h;
    private final Condition f13837i;
    private final zzr f13838j;
    private final boolean f13839k;
    private final boolean f13840l;
    private final Queue<zzm<?, ?>> f13841m = new LinkedList();
    private boolean f13842n;
    private Map<zzh<?>, ConnectionResult> f13843o;
    private Map<zzh<?>, ConnectionResult> f13844p;
    private zzad f13845q;
    private ConnectionResult f13846r;

    public zzaa(Context context, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, ArrayList<zzt> arrayList, zzba com_google_android_gms_common_api_internal_zzba, boolean z) {
        this.f13834f = lock;
        Looper looper2 = looper;
        this.f13835g = looper2;
        this.f13837i = lock.newCondition();
        this.f13836h = com_google_android_gms_common_zzf;
        this.f13833e = com_google_android_gms_common_api_internal_zzba;
        this.f13831c = map2;
        zzr com_google_android_gms_common_internal_zzr2 = com_google_android_gms_common_internal_zzr;
        this.f13838j = com_google_android_gms_common_internal_zzr2;
        this.f13839k = z;
        Map hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.zzagf(), api);
        }
        Map hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzt com_google_android_gms_common_api_internal_zzt = (zzt) obj;
            hashMap2.put(com_google_android_gms_common_api_internal_zzt.f13970a, com_google_android_gms_common_api_internal_zzt);
        }
        for (Entry entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            zze com_google_android_gms_common_api_Api_zze = (zze) entry.getValue();
            ((Boolean) r0.f13831c.get(api2)).booleanValue();
            zzz com_google_android_gms_common_api_internal_zzz = r1;
            zze com_google_android_gms_common_api_Api_zze2 = com_google_android_gms_common_api_Api_zze;
            zzz com_google_android_gms_common_api_internal_zzz2 = new zzz(context, api2, looper2, com_google_android_gms_common_api_Api_zze, (zzt) hashMap2.get(api2), com_google_android_gms_common_internal_zzr2, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe);
            r0.f13829a.put((zzc) entry.getKey(), com_google_android_gms_common_api_internal_zzz);
            if (com_google_android_gms_common_api_Api_zze2.mo4023h()) {
                r0.f13830b.put((zzc) entry.getKey(), com_google_android_gms_common_api_internal_zzz);
            }
            looper2 = looper;
        }
        r0.f13840l = false;
        r0.f13832d = zzbm.m4710a();
    }

    private final ConnectionResult m12836a(zzc<?> com_google_android_gms_common_api_Api_zzc_) {
        this.f13834f.lock();
        try {
            zzz com_google_android_gms_common_api_internal_zzz = (zzz) this.f13829a.get(com_google_android_gms_common_api_Api_zzc_);
            if (this.f13843o == null || com_google_android_gms_common_api_internal_zzz == null) {
                this.f13834f.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.f13843o.get(com_google_android_gms_common_api_internal_zzz.zzagn());
            return connectionResult;
        } finally {
            this.f13834f.unlock();
        }
    }

    private final boolean m12850h() {
        this.f13834f.lock();
        try {
            if (this.f13842n) {
                if (this.f13839k) {
                    for (zzc a : this.f13830b.keySet()) {
                        ConnectionResult a2 = m12836a(a);
                        if (a2 != null) {
                            if (!a2.m17584b()) {
                            }
                        }
                    }
                    this.f13834f.unlock();
                    return true;
                }
            }
            this.f13834f.unlock();
            return false;
        } catch (Throwable th) {
            this.f13834f.unlock();
        }
    }

    public final void mo1548a() {
        this.f13834f.lock();
        try {
            if (!this.f13842n) {
                this.f13842n = true;
                this.f13843o = null;
                this.f13844p = null;
                this.f13845q = null;
                this.f13846r = null;
                this.f13832d.m4731c();
                this.f13832d.m4726a(this.f13829a.values()).mo2307a(new zzbha(this.f13835g), new zzac());
            }
            this.f13834f.unlock();
        } catch (Throwable th) {
            this.f13834f.unlock();
        }
    }

    public final void mo1549a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final boolean mo1550a(zzcu com_google_android_gms_common_api_internal_zzcu) {
        this.f13834f.lock();
        try {
            if (!this.f13842n || m12850h()) {
                this.f13834f.unlock();
                return false;
            }
            this.f13832d.m4731c();
            this.f13845q = new zzad(this, com_google_android_gms_common_api_internal_zzcu);
            this.f13832d.m4726a(this.f13830b.values()).mo2307a(new zzbha(this.f13835g), this.f13845q);
            return true;
        } finally {
            this.f13834f.unlock();
        }
    }

    public final com.google.android.gms.common.ConnectionResult mo1551b() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r3.mo1548a();
    L_0x0003:
        r0 = r3.mo1555e();
        r1 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x000a:
        r0 = r3.f13837i;	 Catch:{ InterruptedException -> 0x0010 }
        r0.await();	 Catch:{ InterruptedException -> 0x0010 }
        goto L_0x0003;
    L_0x0010:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 15;
        r0.<init>(r2, r1);
        return r0;
    L_0x001f:
        r0 = r3.mo1554d();
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0 = com.google.android.gms.common.ConnectionResult.f17256a;
        return r0;
    L_0x0028:
        r0 = r3.f13846r;
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0 = r3.f13846r;
        return r0;
    L_0x002f:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.b():com.google.android.gms.common.ConnectionResult");
    }

    public final void mo1553c() {
        this.f13834f.lock();
        try {
            this.f13842n = false;
            this.f13843o = null;
            this.f13844p = null;
            if (this.f13845q != null) {
                this.f13845q.m12869a();
                this.f13845q = null;
            }
            this.f13846r = null;
            while (!this.f13841m.isEmpty()) {
                zzm com_google_android_gms_common_api_internal_zzm = (zzm) this.f13841m.remove();
                com_google_android_gms_common_api_internal_zzm.m12828a(null);
                com_google_android_gms_common_api_internal_zzm.mo1544c();
            }
            this.f13837i.signalAll();
        } finally {
            this.f13834f.unlock();
        }
    }

    public final boolean mo1554d() {
        this.f13834f.lock();
        try {
            boolean z = this.f13843o != null && this.f13846r == null;
            this.f13834f.unlock();
            return z;
        } catch (Throwable th) {
            this.f13834f.unlock();
        }
    }

    public final boolean mo1555e() {
        this.f13834f.lock();
        try {
            boolean z = this.f13843o == null && this.f13842n;
            this.f13834f.unlock();
            return z;
        } catch (Throwable th) {
            this.f13834f.unlock();
        }
    }

    public final void mo1557g() {
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1547a(T t) {
        if (this.f13839k && m12844c((zzm) t)) {
            return t;
        }
        if (mo1554d()) {
            this.f13833e.f13899e.m4764a(t);
            return ((zzz) this.f13829a.get(t.f17313d)).zza((zzm) t);
        }
        this.f13841m.add(t);
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1552b(T t) {
        zzc com_google_android_gms_common_api_Api_zzc = t.f17313d;
        if (this.f13839k && m12844c((zzm) t)) {
            return t;
        }
        this.f13833e.f13899e.m4764a(t);
        return ((zzz) this.f13829a.get(com_google_android_gms_common_api_Api_zzc)).zzb((zzm) t);
    }

    private final <T extends zzm<? extends Result, ? extends zzb>> boolean m12844c(T t) {
        zzc com_google_android_gms_common_api_Api_zzc = t.f17313d;
        ConnectionResult a = m12836a(com_google_android_gms_common_api_Api_zzc);
        if (a == null || a.f17257b != 4) {
            return null;
        }
        PendingIntent activity;
        zzbm com_google_android_gms_common_api_internal_zzbm = this.f13832d;
        zzh zzagn = ((zzz) this.f13829a.get(com_google_android_gms_common_api_Api_zzc)).zzagn();
        int identityHashCode = System.identityHashCode(this.f13833e);
        zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) com_google_android_gms_common_api_internal_zzbm.f5781f.get(zzagn);
        if (com_google_android_gms_common_api_internal_zzbo != null) {
            zzcxd com_google_android_gms_internal_zzcxd = com_google_android_gms_common_api_internal_zzbo.f17296f == null ? null : com_google_android_gms_common_api_internal_zzbo.f17296f.f19114f;
            if (com_google_android_gms_internal_zzcxd != null) {
                activity = PendingIntent.getActivity(com_google_android_gms_common_api_internal_zzbm.f5778c, identityHashCode, com_google_android_gms_internal_zzcxd.mo3958d(), MQEncoder.CARRY_MASK);
                t.m17674c(new Status(4, null, activity));
                return true;
            }
        }
        activity = null;
        t.m17674c(new Status(4, null, activity));
        return true;
    }

    public final void mo1556f() {
        this.f13834f.lock();
        try {
            zzbm com_google_android_gms_common_api_internal_zzbm = this.f13832d;
            com_google_android_gms_common_api_internal_zzbm.f5780e.incrementAndGet();
            com_google_android_gms_common_api_internal_zzbm.f5784i.sendMessage(com_google_android_gms_common_api_internal_zzbm.f5784i.obtainMessage(10));
            if (this.f13845q != null) {
                this.f13845q.m12869a();
                this.f13845q = null;
            }
            if (this.f13844p == null) {
                this.f13844p = new ArrayMap(this.f13830b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzz zzagn : this.f13830b.values()) {
                this.f13844p.put(zzagn.zzagn(), connectionResult);
            }
            if (this.f13843o != null) {
                this.f13843o.putAll(this.f13844p);
            }
            this.f13834f.unlock();
        } catch (Throwable th) {
            this.f13834f.unlock();
        }
    }

    static /* synthetic */ boolean m12840a(zzaa com_google_android_gms_common_api_internal_zzaa, zzz com_google_android_gms_common_api_internal_zzz, ConnectionResult connectionResult) {
        return (connectionResult.m17584b() || connectionResult.m17583a() || ((Boolean) com_google_android_gms_common_api_internal_zzaa.f13831c.get(com_google_android_gms_common_api_internal_zzz.zzagl())).booleanValue() == null || com_google_android_gms_common_api_internal_zzaa.f13836h.mo1539a(connectionResult.f17257b) == null) ? null : true;
    }

    static /* synthetic */ ConnectionResult m12847f(zzaa com_google_android_gms_common_api_internal_zzaa) {
        ConnectionResult connectionResult = null;
        Object obj = null;
        Object obj2 = obj;
        ConnectionResult connectionResult2 = null;
        for (zzz com_google_android_gms_common_api_internal_zzz : com_google_android_gms_common_api_internal_zzaa.f13829a.values()) {
            Api zzagl = com_google_android_gms_common_api_internal_zzz.zzagl();
            ConnectionResult connectionResult3 = (ConnectionResult) com_google_android_gms_common_api_internal_zzaa.f13843o.get(com_google_android_gms_common_api_internal_zzz.zzagn());
            if (!connectionResult3.m17584b() && (!((Boolean) com_google_android_gms_common_api_internal_zzaa.f13831c.get(zzagl)).booleanValue() || connectionResult3.m17583a() || com_google_android_gms_common_api_internal_zzaa.f13836h.mo1539a(connectionResult3.f17257b))) {
                if (connectionResult3.f17257b == 4 && com_google_android_gms_common_api_internal_zzaa.f13839k) {
                    zzagl.zzagd();
                    if (connectionResult2 == null || obj2 > 2147483647) {
                        obj2 = Integer.MAX_VALUE;
                        connectionResult2 = connectionResult3;
                    }
                } else {
                    zzagl.zzagd();
                    if (connectionResult == null || obj > 2147483647) {
                        obj = Integer.MAX_VALUE;
                        connectionResult = connectionResult3;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || obj <= obj2) ? connectionResult : connectionResult2;
    }

    static /* synthetic */ void m12851i(zzaa com_google_android_gms_common_api_internal_zzaa) {
        Set emptySet;
        if (com_google_android_gms_common_api_internal_zzaa.f13838j == null) {
            com_google_android_gms_common_api_internal_zzaa = com_google_android_gms_common_api_internal_zzaa.f13833e;
            emptySet = Collections.emptySet();
        } else {
            emptySet = new HashSet(com_google_android_gms_common_api_internal_zzaa.f13838j.f5942b);
            Map map = com_google_android_gms_common_api_internal_zzaa.f13838j.f5944d;
            for (Api api : map.keySet()) {
                ConnectionResult a = com_google_android_gms_common_api_internal_zzaa.m12836a(api.zzagf());
                if (a != null && a.m17584b()) {
                    emptySet.addAll(((zzt) map.get(api)).f5957a);
                }
            }
            com_google_android_gms_common_api_internal_zzaa = com_google_android_gms_common_api_internal_zzaa.f13833e;
        }
        com_google_android_gms_common_api_internal_zzaa.f13897c = emptySet;
    }

    static /* synthetic */ void m12852j(zzaa com_google_android_gms_common_api_internal_zzaa) {
        while (!com_google_android_gms_common_api_internal_zzaa.f13841m.isEmpty()) {
            com_google_android_gms_common_api_internal_zzaa.mo1552b((zzm) com_google_android_gms_common_api_internal_zzaa.f13841m.remove());
        }
        com_google_android_gms_common_api_internal_zzaa.f13833e.mo1591a(null);
    }
}
