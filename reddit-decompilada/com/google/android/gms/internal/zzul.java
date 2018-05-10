package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@zzzv
public final class zzul implements zzup {
    private final String f14638a;
    private final zzux f14639b;
    private final long f14640c;
    private final zzui f14641d;
    private final zzuh f14642e;
    private zzjj f14643f;
    private final zzjn f14644g;
    private final Context f14645h;
    private final Object f14646i = new Object();
    private final zzakd f14647j;
    private final boolean f14648k;
    private final zzpe f14649l;
    private final List<String> f14650m;
    private final List<String> f14651n;
    private final List<String> f14652o;
    private final boolean f14653p;
    private final boolean f14654q;
    private zzva f14655r;
    private int f14656s = -2;
    private zzvg f14657t;

    public zzul(Context context, String str, zzux com_google_android_gms_internal_zzux, zzui com_google_android_gms_internal_zzui, zzuh com_google_android_gms_internal_zzuh, zzjj com_google_android_gms_internal_zzjj, zzjn com_google_android_gms_internal_zzjn, zzakd com_google_android_gms_internal_zzakd, boolean z, boolean z2, zzpe com_google_android_gms_internal_zzpe, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        String str2 = str;
        zzui com_google_android_gms_internal_zzui2 = com_google_android_gms_internal_zzui;
        zzuh com_google_android_gms_internal_zzuh2 = com_google_android_gms_internal_zzuh;
        this.f14645h = context;
        this.f14639b = com_google_android_gms_internal_zzux;
        this.f14642e = com_google_android_gms_internal_zzuh2;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
            str2 = m14287b();
        }
        r0.f14638a = str2;
        r0.f14641d = com_google_android_gms_internal_zzui2;
        long j = com_google_android_gms_internal_zzuh2.f8063r != -1 ? com_google_android_gms_internal_zzuh2.f8063r : com_google_android_gms_internal_zzui2.f8066b != -1 ? com_google_android_gms_internal_zzui2.f8066b : 10000;
        r0.f14640c = j;
        r0.f14643f = com_google_android_gms_internal_zzjj;
        r0.f14644g = com_google_android_gms_internal_zzjn;
        r0.f14647j = com_google_android_gms_internal_zzakd;
        r0.f14648k = z;
        r0.f14653p = z2;
        r0.f14649l = com_google_android_gms_internal_zzpe;
        r0.f14650m = list;
        r0.f14651n = list2;
        r0.f14652o = list3;
        r0.f14654q = z3;
    }

    private static zzva m14280a(MediationAdapter mediationAdapter) {
        return new zzvr(mediationAdapter);
    }

    private final java.lang.String m14283a(java.lang.String r3) {
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
        if (r3 == 0) goto L_0x0024;
    L_0x0002:
        r0 = r2.m14293e();
        if (r0 == 0) goto L_0x0024;
    L_0x0008:
        r0 = 2;
        r0 = r2.m14288b(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r3;
    L_0x0010:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001f }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x001f }
        r1 = "cpm_floor_cents";	 Catch:{ JSONException -> 0x001f }
        r0.remove(r1);	 Catch:{ JSONException -> 0x001f }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x001f }
        return r0;
    L_0x001f:
        r0 = "Could not remove field. Returning the original value";
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x0024:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzul.a(java.lang.String):java.lang.String");
    }

    private final java.lang.String m14287b() {
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
        r0 = r2.f14642e;	 Catch:{ RemoteException -> 0x001c }
        r0 = r0.f8050e;	 Catch:{ RemoteException -> 0x001c }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ RemoteException -> 0x001c }
        if (r0 != 0) goto L_0x0021;	 Catch:{ RemoteException -> 0x001c }
    L_0x000a:
        r0 = r2.f14639b;	 Catch:{ RemoteException -> 0x001c }
        r1 = r2.f14642e;	 Catch:{ RemoteException -> 0x001c }
        r1 = r1.f8050e;	 Catch:{ RemoteException -> 0x001c }
        r0 = r0.mo2169b(r1);	 Catch:{ RemoteException -> 0x001c }
        if (r0 == 0) goto L_0x0019;	 Catch:{ RemoteException -> 0x001c }
    L_0x0016:
        r0 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";	 Catch:{ RemoteException -> 0x001c }
        return r0;	 Catch:{ RemoteException -> 0x001c }
    L_0x0019:
        r0 = "com.google.ads.mediation.customevent.CustomEventAdapter";	 Catch:{ RemoteException -> 0x001c }
        return r0;
    L_0x001c:
        r0 = "Fail to determine the custom event's version, assuming the old one.";
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x0021:
        r0 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzul.b():java.lang.String");
    }

    private final boolean m14288b(int r4) {
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
        r0 = 0;
        r1 = r3.f14648k;	 Catch:{ RemoteException -> 0x002d }
        if (r1 == 0) goto L_0x000c;	 Catch:{ RemoteException -> 0x002d }
    L_0x0005:
        r1 = r3.f14655r;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.mo2192l();	 Catch:{ RemoteException -> 0x002d }
        goto L_0x001f;	 Catch:{ RemoteException -> 0x002d }
    L_0x000c:
        r1 = r3.f14644g;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.f18155d;	 Catch:{ RemoteException -> 0x002d }
        if (r1 == 0) goto L_0x0019;	 Catch:{ RemoteException -> 0x002d }
    L_0x0012:
        r1 = r3.f14655r;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.mo2191k();	 Catch:{ RemoteException -> 0x002d }
        goto L_0x001f;	 Catch:{ RemoteException -> 0x002d }
    L_0x0019:
        r1 = r3.f14655r;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.mo2190j();	 Catch:{ RemoteException -> 0x002d }
    L_0x001f:
        if (r1 == 0) goto L_0x002c;
    L_0x0021:
        r2 = "capabilities";
        r1 = r1.getInt(r2, r0);
        r1 = r1 & r4;
        if (r1 != r4) goto L_0x002c;
    L_0x002a:
        r4 = 1;
        return r4;
    L_0x002c:
        return r0;
    L_0x002d:
        r4 = "Could not get adapter info. Returning false";
        com.google.android.gms.internal.zzakb.m5371e(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzul.b(int):boolean");
    }

    private final com.google.android.gms.internal.zzvg m14290c() {
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
        r0 = r2.f14656s;
        if (r0 != 0) goto L_0x0030;
    L_0x0004:
        r0 = r2.m14293e();
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        goto L_0x0030;
    L_0x000b:
        r0 = 4;
        r0 = r2.m14288b(r0);	 Catch:{ RemoteException -> 0x0021 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0021 }
    L_0x0012:
        r0 = r2.f14657t;	 Catch:{ RemoteException -> 0x0021 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0021 }
    L_0x0016:
        r0 = r2.f14657t;	 Catch:{ RemoteException -> 0x0021 }
        r0 = r0.mo2207a();	 Catch:{ RemoteException -> 0x0021 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0021 }
    L_0x001e:
        r0 = r2.f14657t;	 Catch:{ RemoteException -> 0x0021 }
        return r0;
    L_0x0021:
        r0 = "Could not get cpm value from MediationResponseMetadata";
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x0026:
        r0 = r2.m14295f();
        r1 = new com.google.android.gms.internal.zzun;
        r1.<init>(r0);
        return r1;
    L_0x0030:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzul.c():com.google.android.gms.internal.zzvg");
    }

    private final zzva m14291d() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.f14638a);
        zzakb.m5370d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!(this.f14648k || this.f14642e.m6671b())) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bi)).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f14638a)) {
                return m14280a(new AdMobAdapter());
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bj)).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f14638a)) {
                return m14280a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f14638a)) {
                return new zzvr(new zzwl());
            }
        }
        try {
            return this.f14639b.mo2168a(this.f14638a);
        } catch (Throwable e) {
            valueOf = "Could not instantiate mediation adapter: ";
            String valueOf2 = String.valueOf(this.f14638a);
            zzakb.m5364a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), e);
            return null;
        }
    }

    private final boolean m14293e() {
        return this.f14641d.f8076l != -1;
    }

    private final int m14295f() {
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
        r4 = this;
        r0 = r4.f14642e;
        r0 = r0.f8055j;
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003a }
        r2 = r4.f14642e;	 Catch:{ JSONException -> 0x003a }
        r2 = r2.f8055j;	 Catch:{ JSONException -> 0x003a }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x003a }
        r2 = "com.google.ads.mediation.admob.AdMobAdapter";
        r3 = r4.f14638a;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0022;
    L_0x001b:
        r2 = "cpm_cents";
        r0 = r0.optInt(r2, r1);
        return r0;
    L_0x0022:
        r2 = 2;
        r2 = r4.m14288b(r2);
        if (r2 == 0) goto L_0x0030;
    L_0x0029:
        r2 = "cpm_floor_cents";
        r2 = r0.optInt(r2, r1);
        goto L_0x0031;
    L_0x0030:
        r2 = r1;
    L_0x0031:
        if (r2 != 0) goto L_0x0039;
    L_0x0033:
        r2 = "penalized_average_cpm_cents";
        r2 = r0.optInt(r2, r1);
    L_0x0039:
        return r2;
    L_0x003a:
        r0 = "Could not convert to json. Returning 0";
        com.google.android.gms.internal.zzakb.m5371e(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzul.f():int");
    }

    public final com.google.android.gms.internal.zzuo m14298a(long r20, long r22) {
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
        r19 = this;
        r1 = r19;
        r2 = r1.f14646i;
        monitor-enter(r2);
        r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0071 }
        r9 = new com.google.android.gms.internal.zzuk;	 Catch:{ all -> 0x0071 }
        r9.<init>();	 Catch:{ all -> 0x0071 }
        r5 = com.google.android.gms.internal.zzahn.f6379a;	 Catch:{ all -> 0x0071 }
        r6 = new com.google.android.gms.internal.zzum;	 Catch:{ all -> 0x0071 }
        r6.<init>(r1, r9);	 Catch:{ all -> 0x0071 }
        r5.post(r6);	 Catch:{ all -> 0x0071 }
        r5 = r1.f14640c;	 Catch:{ all -> 0x0071 }
    L_0x001a:
        r7 = r1.f14656s;	 Catch:{ all -> 0x0071 }
        r8 = -2;	 Catch:{ all -> 0x0071 }
        if (r7 == r8) goto L_0x003d;	 Catch:{ all -> 0x0071 }
    L_0x001f:
        r5 = com.google.android.gms.ads.internal.zzbs.m4492k();	 Catch:{ all -> 0x0071 }
        r5 = r5.mo1633b();	 Catch:{ all -> 0x0071 }
        r12 = r5 - r3;	 Catch:{ all -> 0x0071 }
        r3 = new com.google.android.gms.internal.zzuo;	 Catch:{ all -> 0x0071 }
        r6 = r1.f14642e;	 Catch:{ all -> 0x0071 }
        r7 = r1.f14655r;	 Catch:{ all -> 0x0071 }
        r8 = r1.f14638a;	 Catch:{ all -> 0x0071 }
        r10 = r1.f14656s;	 Catch:{ all -> 0x0071 }
        r11 = r19.m14290c();	 Catch:{ all -> 0x0071 }
        r5 = r3;	 Catch:{ all -> 0x0071 }
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0071 }
        monitor-exit(r2);	 Catch:{ all -> 0x0071 }
        return r3;	 Catch:{ all -> 0x0071 }
    L_0x003d:
        r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0071 }
        r10 = r7 - r3;
        r10 = r5 - r10;
        r7 = r7 - r20;
        r7 = r22 - r7;
        r14 = 0;
        r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r16 <= 0) goto L_0x0064;
    L_0x004f:
        r14 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1));
        if (r14 > 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0064;
    L_0x0054:
        r17 = r3;
        r3 = r1.f14646i;	 Catch:{ InterruptedException -> 0x0060 }
        r7 = java.lang.Math.min(r10, r7);	 Catch:{ InterruptedException -> 0x0060 }
        r3.wait(r7);	 Catch:{ InterruptedException -> 0x0060 }
        goto L_0x006e;
    L_0x0060:
        r3 = 5;
        r1.f14656s = r3;	 Catch:{ all -> 0x0071 }
        goto L_0x006e;	 Catch:{ all -> 0x0071 }
    L_0x0064:
        r17 = r3;	 Catch:{ all -> 0x0071 }
        r3 = "Timed out waiting for adapter.";	 Catch:{ all -> 0x0071 }
        com.google.android.gms.internal.zzakb.m5370d(r3);	 Catch:{ all -> 0x0071 }
        r3 = 3;	 Catch:{ all -> 0x0071 }
        r1.f14656s = r3;	 Catch:{ all -> 0x0071 }
    L_0x006e:
        r3 = r17;	 Catch:{ all -> 0x0071 }
        goto L_0x001a;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r0 = move-exception;	 Catch:{ all -> 0x0071 }
        r3 = r0;	 Catch:{ all -> 0x0071 }
        monitor-exit(r2);	 Catch:{ all -> 0x0071 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzul.a(long, long):com.google.android.gms.internal.zzuo");
    }

    public final void m14299a() {
        synchronized (this.f14646i) {
            try {
                if (this.f14655r != null) {
                    this.f14655r.mo2183c();
                }
            } catch (Throwable e) {
                zzakb.m5369c("Could not destroy mediation adapter.", e);
            }
            this.f14656s = -1;
            this.f14646i.notify();
        }
    }

    public final void mo2163a(int i) {
        synchronized (this.f14646i) {
            this.f14656s = i;
            this.f14646i.notify();
        }
    }

    public final void mo2164a(zzvg com_google_android_gms_internal_zzvg) {
        synchronized (this.f14646i) {
            this.f14656s = 0;
            this.f14657t = com_google_android_gms_internal_zzvg;
            this.f14646i.notify();
        }
    }

    private static NativeAdOptions m14286b(String str) {
        Builder builder = new Builder();
        if (str == null) {
            return builder.m4406c();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            builder.f5397c = jSONObject.optBoolean("multiple_images", false);
            builder.f5395a = jSONObject.optBoolean("only_urls", false);
            str = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(str)) {
                i = 2;
            } else if ("portrait".equals(str)) {
                i = 1;
            } else if ("any".equals(str) == null) {
                i = -1;
            }
            builder.f5396b = i;
        } catch (String str2) {
            zzakb.m5369c("Exception occurred when creating native ad options", str2);
        }
        return builder.m4406c();
    }

    static /* synthetic */ void m14284a(zzul com_google_android_gms_internal_zzul, zzuk com_google_android_gms_internal_zzuk) {
        String a = com_google_android_gms_internal_zzul.m14283a(com_google_android_gms_internal_zzul.f14642e.f8055j);
        try {
            if (com_google_android_gms_internal_zzul.f14647j.f17553c >= 4100000) {
                if (!com_google_android_gms_internal_zzul.f14648k) {
                    if (!com_google_android_gms_internal_zzul.f14642e.m6671b()) {
                        if (com_google_android_gms_internal_zzul.f14644g.f18155d) {
                            com_google_android_gms_internal_zzul.f14655r.mo2175a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14643f, a, com_google_android_gms_internal_zzul.f14642e.f8046a, (zzvd) com_google_android_gms_internal_zzuk);
                            return;
                        } else if (!com_google_android_gms_internal_zzul.f14653p) {
                            com_google_android_gms_internal_zzul.f14655r.mo2178a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14644g, com_google_android_gms_internal_zzul.f14643f, a, com_google_android_gms_internal_zzul.f14642e.f8046a, com_google_android_gms_internal_zzuk);
                            return;
                        } else if (com_google_android_gms_internal_zzul.f14642e.f8058m != null) {
                            com_google_android_gms_internal_zzul.f14655r.mo2176a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14643f, a, com_google_android_gms_internal_zzul.f14642e.f8046a, com_google_android_gms_internal_zzuk, new zzpe(m14286b(com_google_android_gms_internal_zzul.f14642e.f8062q)), com_google_android_gms_internal_zzul.f14642e.f8061p);
                            return;
                        } else {
                            com_google_android_gms_internal_zzul.f14655r.mo2178a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14644g, com_google_android_gms_internal_zzul.f14643f, a, com_google_android_gms_internal_zzul.f14642e.f8046a, com_google_android_gms_internal_zzuk);
                            return;
                        }
                    }
                }
                List arrayList = new ArrayList(com_google_android_gms_internal_zzul.f14650m);
                if (com_google_android_gms_internal_zzul.f14651n != null) {
                    for (String str : com_google_android_gms_internal_zzul.f14651n) {
                        String str2 = ":false";
                        if (com_google_android_gms_internal_zzul.f14652o != null && com_google_android_gms_internal_zzul.f14652o.contains(str)) {
                            str2 = ":true";
                        }
                        StringBuilder stringBuilder = new StringBuilder((7 + String.valueOf(str).length()) + String.valueOf(str2).length());
                        stringBuilder.append("custom:");
                        stringBuilder.append(str);
                        stringBuilder.append(str2);
                        arrayList.add(stringBuilder.toString());
                    }
                }
                com_google_android_gms_internal_zzul.f14655r.mo2176a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14643f, a, com_google_android_gms_internal_zzul.f14642e.f8046a, com_google_android_gms_internal_zzuk, com_google_android_gms_internal_zzul.f14649l, arrayList);
            } else if (com_google_android_gms_internal_zzul.f14644g.f18155d) {
                com_google_android_gms_internal_zzul.f14655r.mo2174a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14643f, a, com_google_android_gms_internal_zzuk);
            } else {
                com_google_android_gms_internal_zzul.f14655r.mo2177a(zzn.m17692a(com_google_android_gms_internal_zzul.f14645h), com_google_android_gms_internal_zzul.f14644g, com_google_android_gms_internal_zzul.f14643f, a, (zzvd) com_google_android_gms_internal_zzuk);
            }
        } catch (zzuk com_google_android_gms_internal_zzuk2) {
            zzakb.m5369c("Could not request ad from mediation adapter.", com_google_android_gms_internal_zzuk2);
            com_google_android_gms_internal_zzul.mo2163a(5);
        }
    }
}
