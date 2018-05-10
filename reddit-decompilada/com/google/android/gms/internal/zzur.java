package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzzv
public final class zzur implements zzug {
    private final zzaat f14658a;
    private final zzux f14659b;
    private final Context f14660c;
    private final zzui f14661d;
    private final boolean f14662e;
    private final long f14663f;
    private final long f14664g;
    private final int f14665h;
    private final Object f14666i = new Object();
    private boolean f14667j = false;
    private final Map<zzakv<zzuo>, zzul> f14668k = new HashMap();
    private final boolean f14669l;
    private final String f14670m;
    private List<zzuo> f14671n = new ArrayList();
    private final boolean f14672o;

    public zzur(Context context, zzaat com_google_android_gms_internal_zzaat, zzux com_google_android_gms_internal_zzux, zzui com_google_android_gms_internal_zzui, boolean z, boolean z2, String str, long j, long j2, boolean z3) {
        this.f14660c = context;
        this.f14658a = com_google_android_gms_internal_zzaat;
        this.f14659b = com_google_android_gms_internal_zzux;
        this.f14661d = com_google_android_gms_internal_zzui;
        this.f14662e = z;
        this.f14669l = z2;
        this.f14670m = str;
        this.f14663f = j;
        this.f14664g = j2;
        this.f14665h = 2;
        this.f14672o = z3;
    }

    private final void m14303a(zzakv<zzuo> com_google_android_gms_internal_zzakv_com_google_android_gms_internal_zzuo) {
        zzahn.f6379a.post(new zzut(this, com_google_android_gms_internal_zzakv_com_google_android_gms_internal_zzuo));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.zzuo m14304b(java.util.List<com.google.android.gms.internal.zzakv<com.google.android.gms.internal.zzuo>> r4) {
        /*
        r3 = this;
        r0 = r3.f14666i;
        monitor-enter(r0);
        r1 = r3.f14667j;	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r4 = new com.google.android.gms.internal.zzuo;	 Catch:{ all -> 0x0047 }
        r1 = -1;
        r4.<init>(r1);	 Catch:{ all -> 0x0047 }
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        return r4;
    L_0x000f:
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        r4 = r4.iterator();
    L_0x0014:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x003c;
    L_0x001a:
        r0 = r4.next();
        r0 = (com.google.android.gms.internal.zzakv) r0;
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        r1 = (com.google.android.gms.internal.zzuo) r1;	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        r2 = r3.f14671n;	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        r2.add(r1);	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        if (r1 == 0) goto L_0x0014;
    L_0x002d:
        r2 = r1.f8086a;	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        if (r2 != 0) goto L_0x0014;
    L_0x0031:
        r3.m14303a(r0);	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        return r1;
    L_0x0035:
        r0 = move-exception;
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.zzakb.m5369c(r1, r0);
        goto L_0x0014;
    L_0x003c:
        r4 = 0;
        r3.m14303a(r4);
        r4 = new com.google.android.gms.internal.zzuo;
        r0 = 1;
        r4.<init>(r0);
        return r4;
    L_0x0047:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzur.b(java.util.List):com.google.android.gms.internal.zzuo");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.zzuo m14307c(java.util.List<com.google.android.gms.internal.zzakv<com.google.android.gms.internal.zzuo>> r14) {
        /*
        r13 = this;
        r0 = r13.f14666i;
        monitor-enter(r0);
        r1 = r13.f14667j;	 Catch:{ all -> 0x00a7 }
        r2 = -1;
        if (r1 == 0) goto L_0x000f;
    L_0x0008:
        r14 = new com.google.android.gms.internal.zzuo;	 Catch:{ all -> 0x00a7 }
        r14.<init>(r2);	 Catch:{ all -> 0x00a7 }
        monitor-exit(r0);	 Catch:{ all -> 0x00a7 }
        return r14;
    L_0x000f:
        monitor-exit(r0);	 Catch:{ all -> 0x00a7 }
        r0 = r13.f14661d;
        r0 = r0.f8077m;
        r3 = -1;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        r0 = r13.f14661d;
        r0 = r0.f8077m;
        goto L_0x0021;
    L_0x001f:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
    L_0x0021:
        r14 = r14.iterator();
        r3 = 0;
        r4 = r2;
        r1 = r0;
        r0 = r3;
    L_0x0029:
        r5 = r14.hasNext();
        if (r5 == 0) goto L_0x009a;
    L_0x002f:
        r5 = r14.next();
        r5 = (com.google.android.gms.internal.zzakv) r5;
        r6 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r6 = r6.mo1632a();
        r8 = 0;
        r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r10 != 0) goto L_0x0054;
    L_0x0043:
        r10 = r5.isDone();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r10 == 0) goto L_0x0054;
    L_0x0049:
        r10 = r5.get();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
    L_0x004d:
        r10 = (com.google.android.gms.internal.zzuo) r10;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        goto L_0x005b;
    L_0x0050:
        r14 = move-exception;
        goto L_0x008c;
    L_0x0052:
        r5 = move-exception;
        goto L_0x0078;
    L_0x0054:
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        r10 = r5.get(r1, r10);	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        goto L_0x004d;
    L_0x005b:
        r11 = r13.f14671n;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        r11.add(r10);	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r10 == 0) goto L_0x007d;
    L_0x0062:
        r11 = r10.f8086a;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r11 != 0) goto L_0x007d;
    L_0x0066:
        r11 = r10.f8091f;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r11 == 0) goto L_0x007d;
    L_0x006a:
        r12 = r11.mo2207a();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r12 <= r4) goto L_0x007d;
    L_0x0070:
        r11 = r11.mo2207a();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        r3 = r5;
        r0 = r10;
        r4 = r11;
        goto L_0x007d;
    L_0x0078:
        r10 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.zzakb.m5369c(r10, r5);	 Catch:{ all -> 0x0050 }
    L_0x007d:
        r5 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r10 = r5.mo1632a();
        r10 = r10 - r6;
        r1 = r1 - r10;
        r1 = java.lang.Math.max(r1, r8);
        goto L_0x0029;
    L_0x008c:
        r0 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r3 = r0.mo1632a();
        r3 = r3 - r6;
        r1 = r1 - r3;
        java.lang.Math.max(r1, r8);
        throw r14;
    L_0x009a:
        r13.m14303a(r3);
        if (r0 != 0) goto L_0x00a6;
    L_0x009f:
        r14 = new com.google.android.gms.internal.zzuo;
        r0 = 1;
        r14.<init>(r0);
        return r14;
    L_0x00a6:
        return r0;
    L_0x00a7:
        r14 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00a7 }
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzur.c(java.util.List):com.google.android.gms.internal.zzuo");
    }

    public final zzuo mo2165a(List<zzuh> list) {
        zzakb.m5366b("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        zzjn com_google_android_gms_internal_zzjn = this.f14658a.f17397d;
        int[] iArr = new int[2];
        if (com_google_android_gms_internal_zzjn.f18158g != null) {
            zzbs.m4503v();
            if (zzuq.m6688a(r0.f14670m, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                zzjn[] com_google_android_gms_internal_zzjnArr = com_google_android_gms_internal_zzjn.f18158g;
                int length = com_google_android_gms_internal_zzjnArr.length;
                while (i < length) {
                    zzjn com_google_android_gms_internal_zzjn2 = com_google_android_gms_internal_zzjnArr[i];
                    if (i2 == com_google_android_gms_internal_zzjn2.f18156e && i3 == com_google_android_gms_internal_zzjn2.f18153b) {
                        com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzuh com_google_android_gms_internal_zzuh = (zzuh) it.next();
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzuh.f8047b);
            zzakb.m5370d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            Iterator it2 = com_google_android_gms_internal_zzuh.f8048c.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                Context context = r0.f14660c;
                zzux com_google_android_gms_internal_zzux = r0.f14659b;
                zzui com_google_android_gms_internal_zzui = r0.f14661d;
                zzjj com_google_android_gms_internal_zzjj = r0.f14658a.f17396c;
                zzakd com_google_android_gms_internal_zzakd = r0.f14658a.f17404k;
                boolean z = r0.f14662e;
                boolean z2 = r0.f14669l;
                Iterator it3 = it;
                zzpe com_google_android_gms_internal_zzpe = r0.f14658a.f17418y;
                Iterator it4 = it2;
                ArrayList arrayList2 = arrayList;
                zzakd com_google_android_gms_internal_zzakd2 = com_google_android_gms_internal_zzakd;
                zzuh com_google_android_gms_internal_zzuh2 = com_google_android_gms_internal_zzuh;
                zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
                zzjn com_google_android_gms_internal_zzjn3 = com_google_android_gms_internal_zzjn;
                zzul com_google_android_gms_internal_zzul = new zzul(context, str2, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzui, com_google_android_gms_internal_zzuh2, com_google_android_gms_internal_zzjj2, com_google_android_gms_internal_zzjn3, com_google_android_gms_internal_zzakd2, z, z2, com_google_android_gms_internal_zzpe, r0.f14658a.f17407n, r0.f14658a.f17419z, r0.f14658a.f17391X, r0.f14672o);
                zzakv a = zzahh.m5149a(newCachedThreadPool, new zzus(r0, com_google_android_gms_internal_zzul));
                r0.f14668k.put(a, com_google_android_gms_internal_zzul);
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(a);
                arrayList = arrayList3;
                it = it3;
                it2 = it4;
            }
        }
        List list2 = arrayList;
        return r0.f14665h != 2 ? m14304b(list2) : m14307c(list2);
    }

    public final void mo2166a() {
        synchronized (this.f14666i) {
            this.f14667j = true;
            for (zzul a : this.f14668k.values()) {
                a.m14299a();
            }
        }
    }

    public final List<zzuo> mo2167b() {
        return this.f14671n;
    }
}
