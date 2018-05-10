package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.internal.zzbs;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

@zzzv
public final class zztg {
    final Map<zzth, zzti> f8003a = new HashMap();
    final LinkedList<zzth> f8004b = new LinkedList();
    zzsd f8005c;

    static Set<String> m6640a(zzjj com_google_android_gms_internal_zzjj) {
        Set<String> hashSet = new HashSet();
        hashSet.addAll(com_google_android_gms_internal_zzjj.f18136c.keySet());
        Bundle bundle = com_google_android_gms_internal_zzjj.f18146m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    private static void m6641a(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split(Operation.DIVISION, 2);
            if (split.length != 0) {
                String str2 = split[0];
                if (split.length == 1) {
                    bundle.remove(str2);
                    return;
                }
                bundle = bundle.getBundle(str2);
                if (bundle != null) {
                    str = split[1];
                } else {
                    return;
                }
            }
            return;
        }
    }

    static void m6642a(String str, zzth com_google_android_gms_internal_zzth) {
        if (zzakb.m5365a(2)) {
            zzagf.m13278a(String.format(str, new Object[]{com_google_android_gms_internal_zzth}));
        }
    }

    static java.lang.String[] m6643a(java.lang.String r5) {
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
        r0 = 0;
        r1 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r5 = r5.split(r1);	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r1 = r0;	 Catch:{ UnsupportedEncodingException -> 0x001e }
    L_0x0008:
        r2 = r5.length;	 Catch:{ UnsupportedEncodingException -> 0x001e }
        if (r1 >= r2) goto L_0x001d;	 Catch:{ UnsupportedEncodingException -> 0x001e }
    L_0x000b:
        r2 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r3 = r5[r1];	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r3 = android.util.Base64.decode(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r4 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r2.<init>(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r5[r1] = r2;	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r1 = r1 + 1;
        goto L_0x0008;
    L_0x001d:
        return r5;
    L_0x001e:
        r5 = new java.lang.String[r0];
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztg.a(java.lang.String):java.lang.String[]");
    }

    static zzjj m6644b(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj = m6649d(com_google_android_gms_internal_zzjj);
        String str = "_skipMediation";
        Bundle bundle = com_google_android_gms_internal_zzjj.f18146m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean(str, true);
        }
        com_google_android_gms_internal_zzjj.f18136c.putBoolean(str, true);
        return com_google_android_gms_internal_zzjj;
    }

    private final java.lang.String m6645b() {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r1 = r4.f8004b;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r1 = r1.iterator();	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x000b:
        r2 = r1.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        if (r2 == 0) goto L_0x0035;	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x0011:
        r2 = r1.next();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = (com.google.android.gms.internal.zzth) r2;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r3 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = r2.getBytes(r3);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r3 = 0;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = android.util.Base64.encodeToString(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r0.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = r1.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        if (r2 == 0) goto L_0x000b;	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x002f:
        r2 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r0.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        goto L_0x000b;	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x0035:
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        return r0;
    L_0x003a:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztg.b():java.lang.String");
    }

    static boolean m6646b(String str) {
        try {
            return Pattern.matches((String) zzkb.m6350f().m6488a(zznh.aM), str);
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    static zzjj m6647c(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj = m6649d(com_google_android_gms_internal_zzjj);
        for (String str : ((String) zzkb.m6350f().m6488a(zznh.aI)).split(",")) {
            m6641a(com_google_android_gms_internal_zzjj.f18146m, str);
            String str2 = "com.google.ads.mediation.admob.AdMobAdapter/";
            if (str.startsWith(str2)) {
                m6641a(com_google_android_gms_internal_zzjj.f18136c, str.replaceFirst(str2, ""));
            }
        }
        return com_google_android_gms_internal_zzjj;
    }

    static java.lang.String m6648c(java.lang.String r2) {
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
        r0 = "([^/]+/[0-9]+).*";	 Catch:{ RuntimeException -> 0x0016 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ RuntimeException -> 0x0016 }
        r0 = r0.matcher(r2);	 Catch:{ RuntimeException -> 0x0016 }
        r1 = r0.matches();	 Catch:{ RuntimeException -> 0x0016 }
        if (r1 == 0) goto L_0x0016;	 Catch:{ RuntimeException -> 0x0016 }
    L_0x0010:
        r1 = 1;	 Catch:{ RuntimeException -> 0x0016 }
        r0 = r0.group(r1);	 Catch:{ RuntimeException -> 0x0016 }
        return r0;
    L_0x0016:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztg.c(java.lang.String):java.lang.String");
    }

    private static zzjj m6649d(zzjj com_google_android_gms_internal_zzjj) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzjj.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        com_google_android_gms_internal_zzjj = (zzjj) zzjj.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (((Boolean) zzkb.m6350f().m6488a(zznh.aB)).booleanValue()) {
            zzjj.m18774a(com_google_android_gms_internal_zzjj);
        }
        return com_google_android_gms_internal_zzjj;
    }

    final void m6650a() {
        if (this.f8005c != null) {
            zzth com_google_android_gms_internal_zzth;
            for (Entry entry : this.f8003a.entrySet()) {
                int size;
                com_google_android_gms_internal_zzth = (zzth) entry.getKey();
                zzti com_google_android_gms_internal_zzti = (zzti) entry.getValue();
                if (zzakb.m5365a(2)) {
                    size = com_google_android_gms_internal_zzti.f8007a.size();
                    Iterator it = com_google_android_gms_internal_zzti.f8007a.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        if (((zztj) it.next()).f8016e) {
                            i++;
                        }
                    }
                    if (i < size) {
                        zzagf.m13278a(String.format("Loading %s/%s pooled interstitials for %s.", new Object[]{Integer.valueOf(size - i), Integer.valueOf(size), com_google_android_gms_internal_zzth}));
                    }
                }
                Iterator it2 = com_google_android_gms_internal_zzti.f8007a.iterator();
                size = 0;
                while (it2.hasNext()) {
                    if (((zztj) it2.next()).m6654a()) {
                        size++;
                    }
                }
                int i2 = 0 + size;
                while (true) {
                    if (com_google_android_gms_internal_zzti.f8007a.size() >= ((Integer) zzkb.m6350f().m6488a(zznh.aK)).intValue()) {
                        break;
                    }
                    m6642a("Pooling and loading one new interstitial for %s.", com_google_android_gms_internal_zzth);
                    zztj com_google_android_gms_internal_zztj = new zztj(com_google_android_gms_internal_zzti, this.f8005c);
                    com_google_android_gms_internal_zzti.f8007a.add(com_google_android_gms_internal_zztj);
                    if (com_google_android_gms_internal_zztj.m6654a()) {
                        i2++;
                    }
                }
                zztk a = zztk.m6655a();
                a.f8020a += i2;
            }
            if (this.f8005c != null) {
                Editor edit = this.f8005c.f7990a.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
                edit.clear();
                for (Entry entry2 : this.f8003a.entrySet()) {
                    com_google_android_gms_internal_zzth = (zzth) entryg2.getKey();
                    zzti com_google_android_gms_internal_zzti2 = (zzti) entry2.getValue();
                    if (com_google_android_gms_internal_zzti2.f8011e) {
                        edit.putString(com_google_android_gms_internal_zzth.toString(), new zztm(com_google_android_gms_internal_zzti2).m6658a());
                        m6642a("Saved interstitial queue for %s.", com_google_android_gms_internal_zzth);
                    }
                }
                edit.putString("PoolKeys", m6645b());
                edit.apply();
            }
        }
    }
}
