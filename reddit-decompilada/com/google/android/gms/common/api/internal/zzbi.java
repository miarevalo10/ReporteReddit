package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbi implements zzcc, zzu {
    final Lock f17276a;
    final Condition f17277b;
    final Context f17278c;
    final zzf f17279d;
    final zzbk f17280e;
    final Map<zzc<?>, zze> f17281f;
    final Map<zzc<?>, ConnectionResult> f17282g = new HashMap();
    zzr f17283h;
    Map<Api<?>, Boolean> f17284i;
    zza<? extends zzcxd, zzcxe> f17285j;
    volatile zzbh f17286k;
    int f17287l;
    final zzba f17288m;
    final zzcd f17289n;
    private ConnectionResult f17290o = null;

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1547a(T t) {
        t.m12835f();
        return this.f17286k.mo1570a((zzm) t);
    }

    public final void mo1548a() {
        this.f17286k.mo1577c();
    }

    public final void mo1581a(int i) {
        this.f17276a.lock();
        try {
            this.f17286k.mo1572a(i);
        } finally {
            this.f17276a.unlock();
        }
    }

    public final void mo1582a(Bundle bundle) {
        this.f17276a.lock();
        try {
            this.f17286k.mo1573a(bundle);
        } finally {
            this.f17276a.unlock();
        }
    }

    final void m17602a(ConnectionResult connectionResult) {
        this.f17276a.lock();
        try {
            this.f17290o = connectionResult;
            this.f17286k = new zzaz(this);
            this.f17286k.mo1571a();
            this.f17277b.signalAll();
        } finally {
            this.f17276a.unlock();
        }
    }

    public final void mo3413a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.f17276a.lock();
        try {
            this.f17286k.mo1574a(connectionResult, api, z);
        } finally {
            this.f17276a.unlock();
        }
    }

    final void m17604a(zzbj com_google_android_gms_common_api_internal_zzbj) {
        this.f17280e.sendMessage(this.f17280e.obtainMessage(1, com_google_android_gms_common_api_internal_zzbj));
    }

    public final void mo1549a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f17286k);
        for (Api api : this.f17284i.keySet()) {
            printWriter.append(str).append(api.getName()).println(":");
            ((zze) this.f17281f.get(api.zzagf())).m12808a(concat, printWriter);
        }
    }

    public final boolean mo1550a(zzcu com_google_android_gms_common_api_internal_zzcu) {
        return false;
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
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
        r0 = r3.f17277b;	 Catch:{ InterruptedException -> 0x0010 }
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
        r0 = r3.f17290o;
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0 = r3.f17290o;
        return r0;
    L_0x002f:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbi.b():com.google.android.gms.common.ConnectionResult");
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1552b(T t) {
        t.m12835f();
        return this.f17286k.mo1575b(t);
    }

    public final void mo1553c() {
        if (this.f17286k.mo1576b()) {
            this.f17282g.clear();
        }
    }

    public final boolean mo1554d() {
        return this.f17286k instanceof zzal;
    }

    public final boolean mo1555e() {
        return this.f17286k instanceof zzao;
    }

    public final void mo1556f() {
    }

    public zzbi(Context context, zzba com_google_android_gms_common_api_internal_zzba, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, ArrayList<zzt> arrayList, zzcd com_google_android_gms_common_api_internal_zzcd) {
        this.f17278c = context;
        this.f17276a = lock;
        this.f17279d = com_google_android_gms_common_zzf;
        this.f17281f = map;
        this.f17283h = com_google_android_gms_common_internal_zzr;
        this.f17284i = map2;
        this.f17285j = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
        this.f17288m = com_google_android_gms_common_api_internal_zzba;
        this.f17289n = com_google_android_gms_common_api_internal_zzcd;
        arrayList = arrayList;
        zzba size = arrayList.size();
        com_google_android_gms_common_api_internal_zzba = null;
        while (com_google_android_gms_common_api_internal_zzba < size) {
            com_google_android_gms_common_zzf = arrayList.get(com_google_android_gms_common_api_internal_zzba);
            com_google_android_gms_common_api_internal_zzba++;
            ((zzt) com_google_android_gms_common_zzf).f13971b = this;
        }
        this.f17280e = new zzbk(this, looper);
        this.f17277b = lock.newCondition();
        this.f17286k = new zzaz(this);
    }

    public final void mo1557g() {
        if (mo1554d()) {
            zzal com_google_android_gms_common_api_internal_zzal = (zzal) this.f17286k;
            if (com_google_android_gms_common_api_internal_zzal.f13856b) {
                com_google_android_gms_common_api_internal_zzal.f13856b = false;
                com_google_android_gms_common_api_internal_zzal.f13855a.f17288m.f13899e.m4763a();
                com_google_android_gms_common_api_internal_zzal.mo1576b();
            }
        }
    }
}
