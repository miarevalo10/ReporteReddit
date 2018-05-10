package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class zzbo<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zzu {
    final zze f17291a;
    final zzae f17292b;
    final Set<zzj> f17293c = new HashSet();
    final Map<zzck<?>, zzcr> f17294d = new HashMap();
    final int f17295e;
    final zzcv f17296f;
    boolean f17297g;
    final /* synthetic */ zzbm f17298h;
    private final Queue<zza> f17299i = new LinkedList();
    private final zzb f17300j;
    private final zzh<O> f17301k;
    private ConnectionResult f17302l = null;

    public zzbo(zzbm com_google_android_gms_common_api_internal_zzbm, GoogleApi<O> googleApi) {
        this.f17298h = com_google_android_gms_common_api_internal_zzbm;
        this.f17291a = googleApi.zza(com_google_android_gms_common_api_internal_zzbm.f5784i.getLooper(), this);
        this.f17300j = this.f17291a instanceof zzbz ? zzbz.m20203n() : this.f17291a;
        this.f17301k = googleApi.zzagn();
        this.f17292b = new zzae();
        this.f17295e = googleApi.getInstanceId();
        if (this.f17291a.mo4023h()) {
            this.f17296f = googleApi.zza(com_google_android_gms_common_api_internal_zzbm.f5778c, com_google_android_gms_common_api_internal_zzbm.f5784i);
        } else {
            this.f17296f = null;
        }
    }

    private final void m17615b(ConnectionResult connectionResult) {
        for (zzj com_google_android_gms_common_api_internal_zzj : this.f17293c) {
            String str = null;
            if (connectionResult == ConnectionResult.f17256a) {
                str = this.f17291a.m12816j();
            }
            com_google_android_gms_common_api_internal_zzj.m4768a(this.f17301k, connectionResult, str);
        }
        this.f17293c.clear();
    }

    private final void m17616b(com.google.android.gms.common.api.internal.zza r3) {
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
        r0 = r2.f17292b;
        r1 = r2.m17634h();
        r3.mo1585a(r0, r1);
        r3.mo1586a(r2);	 Catch:{ DeadObjectException -> 0x000d }
        return;
    L_0x000d:
        r3 = 1;
        r2.mo1581a(r3);
        r3 = r2.f17291a;
        r3.mo4292e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.b(com.google.android.gms.common.api.internal.zza):void");
    }

    private final void m17619i() {
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
        r2.m17628b();
        r0 = com.google.android.gms.common.ConnectionResult.f17256a;
        r2.m17615b(r0);
        r2.m17630d();
        r0 = r2.f17294d;
        r0 = r0.values();
        r0 = r0.iterator();
    L_0x0015:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x002d;
    L_0x001b:
        r0.next();
        r1 = new com.google.android.gms.tasks.TaskCompletionSource;	 Catch:{ DeadObjectException -> 0x0024, RemoteException -> 0x0015 }
        r1.<init>();	 Catch:{ DeadObjectException -> 0x0024, RemoteException -> 0x0015 }
        goto L_0x0015;
    L_0x0024:
        r0 = 1;
        r2.mo1581a(r0);
        r0 = r2.f17291a;
        r0.mo4292e();
    L_0x002d:
        r0 = r2.f17291a;
        r0 = r0.m12812f();
        if (r0 == 0) goto L_0x0049;
    L_0x0035:
        r0 = r2.f17299i;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0049;
    L_0x003d:
        r0 = r2.f17299i;
        r0 = r0.remove();
        r0 = (com.google.android.gms.common.api.internal.zza) r0;
        r2.m17616b(r0);
        goto L_0x002d;
    L_0x0049:
        r2.m17631e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.i():void");
    }

    public final void mo1581a(int i) {
        if (Looper.myLooper() == this.f17298h.f5784i.getLooper()) {
            m17620j();
        } else {
            this.f17298h.f5784i.post(new zzbq(this));
        }
    }

    public final void mo1582a(Bundle bundle) {
        if (Looper.myLooper() == this.f17298h.f5784i.getLooper()) {
            m17619i();
        } else {
            this.f17298h.f5784i.post(new zzbp(this));
        }
    }

    public final void mo3413a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (Looper.myLooper() == this.f17298h.f5784i.getLooper()) {
            mo1583a(connectionResult);
        } else {
            this.f17298h.f5784i.post(new zzbr(this, connectionResult));
        }
    }

    public final void m17626a(Status status) {
        zzbq.m4812a(this.f17298h.f5784i);
        for (zza a : this.f17299i) {
            a.mo1584a(status);
        }
        this.f17299i.clear();
    }

    public final void m17627a(zza com_google_android_gms_common_api_internal_zza) {
        zzbq.m4812a(this.f17298h.f5784i);
        if (this.f17291a.m12812f()) {
            m17616b(com_google_android_gms_common_api_internal_zza);
            m17631e();
            return;
        }
        this.f17299i.add(com_google_android_gms_common_api_internal_zza);
        if (this.f17302l == null || !this.f17302l.m17583a()) {
            m17632f();
        } else {
            mo1583a(this.f17302l);
        }
    }

    public final void m17628b() {
        zzbq.m4812a(this.f17298h.f5784i);
        this.f17302l = null;
    }

    public final ConnectionResult m17629c() {
        zzbq.m4812a(this.f17298h.f5784i);
        return this.f17302l;
    }

    final void m17630d() {
        if (this.f17297g) {
            this.f17298h.f5784i.removeMessages(11, this.f17301k);
            this.f17298h.f5784i.removeMessages(9, this.f17301k);
            this.f17297g = false;
        }
    }

    final void m17631e() {
        this.f17298h.f5784i.removeMessages(12, this.f17301k);
        this.f17298h.f5784i.sendMessageDelayed(this.f17298h.f5784i.obtainMessage(12, this.f17301k), this.f17298h.f5787m);
    }

    final boolean m17633g() {
        return this.f17291a.m12812f();
    }

    public final boolean m17634h() {
        return this.f17291a.mo4023h();
    }

    private final void m17620j() {
        m17628b();
        this.f17297g = true;
        this.f17292b.m4695a(true, zzdj.f5833a);
        this.f17298h.f5784i.sendMessageDelayed(Message.obtain(this.f17298h.f5784i, 9, this.f17301k), this.f17298h.f5785k);
        this.f17298h.f5784i.sendMessageDelayed(Message.obtain(this.f17298h.f5784i, 11, this.f17301k), this.f17298h.f5786l);
        this.f17298h.f5789p = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1583a(com.google.android.gms.common.ConnectionResult r5) {
        /*
        r4 = this;
        r0 = r4.f17298h;
        r0 = r0.f5784i;
        com.google.android.gms.common.internal.zzbq.m4812a(r0);
        r0 = r4.f17296f;
        if (r0 == 0) goto L_0x0018;
    L_0x000d:
        r0 = r4.f17296f;
        r1 = r0.f19114f;
        if (r1 == 0) goto L_0x0018;
    L_0x0013:
        r0 = r0.f19114f;
        r0.mo4292e();
    L_0x0018:
        r4.m17628b();
        r0 = r4.f17298h;
        r1 = -1;
        r0.f5789p = r1;
        r4.m17615b(r5);
        r0 = r5.f17257b;
        r1 = 4;
        if (r0 != r1) goto L_0x0031;
    L_0x0029:
        r5 = com.google.android.gms.common.api.internal.zzbm.f5776j;
        r4.m17626a(r5);
        return;
    L_0x0031:
        r0 = r4.f17299i;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x003c;
    L_0x0039:
        r4.f17302l = r5;
        return;
    L_0x003c:
        r0 = com.google.android.gms.common.api.internal.zzbm.f5775b;
        monitor-enter(r0);
        r1 = r4.f17298h;	 Catch:{ all -> 0x00ce }
        r1 = r1.f5782g;	 Catch:{ all -> 0x00ce }
        if (r1 == 0) goto L_0x0064;
    L_0x0049:
        r1 = r4.f17298h;	 Catch:{ all -> 0x00ce }
        r1 = r1.f5783h;	 Catch:{ all -> 0x00ce }
        r2 = r4.f17301k;	 Catch:{ all -> 0x00ce }
        r1 = r1.contains(r2);	 Catch:{ all -> 0x00ce }
        if (r1 == 0) goto L_0x0064;
    L_0x0057:
        r1 = r4.f17298h;	 Catch:{ all -> 0x00ce }
        r1 = r1.f5782g;	 Catch:{ all -> 0x00ce }
        r2 = r4.f17295e;	 Catch:{ all -> 0x00ce }
        r1.m13042b(r5, r2);	 Catch:{ all -> 0x00ce }
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        return;
    L_0x0064:
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        r0 = r4.f17298h;
        r1 = r4.f17295e;
        r0 = r0.m4729a(r5, r1);
        if (r0 != 0) goto L_0x00cd;
    L_0x006f:
        r5 = r5.f17257b;
        r0 = 18;
        if (r5 != r0) goto L_0x0078;
    L_0x0075:
        r5 = 1;
        r4.f17297g = r5;
    L_0x0078:
        r5 = r4.f17297g;
        if (r5 == 0) goto L_0x009a;
    L_0x007c:
        r5 = r4.f17298h;
        r5 = r5.f5784i;
        r0 = r4.f17298h;
        r0 = r0.f5784i;
        r1 = 9;
        r2 = r4.f17301k;
        r0 = android.os.Message.obtain(r0, r1, r2);
        r1 = r4.f17298h;
        r1 = r1.f5785k;
        r5.sendMessageDelayed(r0, r1);
        return;
    L_0x009a:
        r5 = new com.google.android.gms.common.api.Status;
        r0 = 17;
        r1 = r4.f17301k;
        r1 = r1.f5839a;
        r1 = r1.getName();
        r2 = 38;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "API: ";
        r3.append(r2);
        r3.append(r1);
        r1 = " is not available on this device.";
        r3.append(r1);
        r1 = r3.toString();
        r5.<init>(r0, r1);
        r4.m17626a(r5);
    L_0x00cd:
        return;
    L_0x00ce:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void m17621a() {
        zzbq.m4812a(this.f17298h.f5784i);
        m17626a(zzbm.f5774a);
        int i = 0;
        this.f17292b.m4695a(false, zzbm.f5774a);
        zzck[] com_google_android_gms_common_api_internal_zzckArr = (zzck[]) this.f17294d.keySet().toArray(new zzck[this.f17294d.size()]);
        int length = com_google_android_gms_common_api_internal_zzckArr.length;
        while (i < length) {
            m17627a(new zzf(com_google_android_gms_common_api_internal_zzckArr[i], new TaskCompletionSource()));
            i++;
        }
        m17615b(new ConnectionResult(4));
        if (this.f17291a.m12812f()) {
            this.f17291a.m12807a(new zzbs(this));
        }
    }

    public final void m17632f() {
        zzbq.m4812a(this.f17298h.f5784i);
        if (!this.f17291a.m12812f() && !this.f17291a.m12813g()) {
            if (this.f17298h.f5789p != 0) {
                this.f17298h.f5789p = this.f17298h.f5788o.mo1537a(this.f17298h.f5778c);
                if (this.f17298h.f5789p != 0) {
                    mo1583a(new ConnectionResult(this.f17298h.f5789p, null));
                    return;
                }
            }
            zzj com_google_android_gms_common_api_internal_zzbu = new zzbu(this.f17298h, this.f17291a, this.f17301k);
            if (this.f17291a.mo4023h()) {
                zzcv com_google_android_gms_common_api_internal_zzcv = this.f17296f;
                if (com_google_android_gms_common_api_internal_zzcv.f19114f != null) {
                    com_google_android_gms_common_api_internal_zzcv.f19114f.mo4292e();
                }
                com_google_android_gms_common_api_internal_zzcv.f19113e.f5948h = Integer.valueOf(System.identityHashCode(com_google_android_gms_common_api_internal_zzcv));
                com_google_android_gms_common_api_internal_zzcv.f19114f = (zzcxd) com_google_android_gms_common_api_internal_zzcv.f19111c.mo3407a(com_google_android_gms_common_api_internal_zzcv.f19109a, com_google_android_gms_common_api_internal_zzcv.f19110b.getLooper(), com_google_android_gms_common_api_internal_zzcv.f19113e, com_google_android_gms_common_api_internal_zzcv.f19113e.f5947g, com_google_android_gms_common_api_internal_zzcv, com_google_android_gms_common_api_internal_zzcv);
                com_google_android_gms_common_api_internal_zzcv.f19115g = com_google_android_gms_common_api_internal_zzbu;
                if (com_google_android_gms_common_api_internal_zzcv.f19112d != null) {
                    if (!com_google_android_gms_common_api_internal_zzcv.f19112d.isEmpty()) {
                        com_google_android_gms_common_api_internal_zzcv.f19114f.mo4027l();
                    }
                }
                com_google_android_gms_common_api_internal_zzcv.f19110b.post(new zzcw(com_google_android_gms_common_api_internal_zzcv));
            }
            this.f17291a.m12806a(com_google_android_gms_common_api_internal_zzbu);
        }
    }
}
