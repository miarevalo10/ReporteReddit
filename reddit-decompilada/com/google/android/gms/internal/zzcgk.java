package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

final class zzcgk extends zzcjl {
    zzcgk(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private static java.lang.Boolean m17959a(double r1, com.google.android.gms.internal.zzclu r3) {
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
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x000e }
        r0.<init>(r1);	 Catch:{ NumberFormatException -> 0x000e }
        r1 = java.lang.Math.ulp(r1);	 Catch:{ NumberFormatException -> 0x000e }
        r1 = m17966a(r0, r3, r1);	 Catch:{ NumberFormatException -> 0x000e }
        return r1;
    L_0x000e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgk.a(double, com.google.android.gms.internal.zzclu):java.lang.Boolean");
    }

    private static java.lang.Boolean m17960a(long r1, com.google.android.gms.internal.zzclu r3) {
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
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x000c }
        r0.<init>(r1);	 Catch:{ NumberFormatException -> 0x000c }
        r1 = 0;	 Catch:{ NumberFormatException -> 0x000c }
        r1 = m17966a(r0, r3, r1);	 Catch:{ NumberFormatException -> 0x000c }
        return r1;
    L_0x000c:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgk.a(long, com.google.android.gms.internal.zzclu):java.lang.Boolean");
    }

    private static Boolean m17962a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private static java.lang.Boolean m17964a(java.lang.String r4, com.google.android.gms.internal.zzclu r5) {
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
        r0 = com.google.android.gms.internal.zzclq.m18528j(r4);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0014 }
        r0.<init>(r4);	 Catch:{ NumberFormatException -> 0x0014 }
        r2 = 0;	 Catch:{ NumberFormatException -> 0x0014 }
        r4 = m17966a(r0, r5, r2);	 Catch:{ NumberFormatException -> 0x0014 }
        return r4;
    L_0x0014:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgk.a(java.lang.String, com.google.android.gms.internal.zzclu):java.lang.Boolean");
    }

    private final Boolean m17965a(String str, zzclw com_google_android_gms_internal_zzclw) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzclw);
        if (str == null || com_google_android_gms_internal_zzclw.f17936a == null || com_google_android_gms_internal_zzclw.f17936a.intValue() == 0) {
            return null;
        }
        String toUpperCase;
        String str2;
        List list;
        String[] strArr;
        List arrayList;
        int length;
        if (com_google_android_gms_internal_zzclw.f17936a.intValue() == 6) {
            if (com_google_android_gms_internal_zzclw.f17939d == null || com_google_android_gms_internal_zzclw.f17939d.length == 0) {
                return null;
            }
        } else if (com_google_android_gms_internal_zzclw.f17937b == null) {
            return null;
        }
        int intValue = com_google_android_gms_internal_zzclw.f17936a.intValue();
        int i = 0;
        boolean z = com_google_android_gms_internal_zzclw.f17938c != null && com_google_android_gms_internal_zzclw.f17938c.booleanValue();
        if (!(z || intValue == 1)) {
            if (intValue != 6) {
                toUpperCase = com_google_android_gms_internal_zzclw.f17937b.toUpperCase(Locale.ENGLISH);
                str2 = toUpperCase;
                if (com_google_android_gms_internal_zzclw.f17939d != null) {
                    list = null;
                } else {
                    strArr = com_google_android_gms_internal_zzclw.f17939d;
                    if (z) {
                        arrayList = new ArrayList();
                        length = strArr.length;
                        while (i < length) {
                            arrayList.add(strArr[i].toUpperCase(Locale.ENGLISH));
                            i++;
                        }
                        list = arrayList;
                    } else {
                        list = Arrays.asList(strArr);
                    }
                }
                return m17963a(str, intValue, z, str2, list, intValue != 1 ? str2 : null);
            }
        }
        toUpperCase = com_google_android_gms_internal_zzclw.f17937b;
        str2 = toUpperCase;
        if (com_google_android_gms_internal_zzclw.f17939d != null) {
            strArr = com_google_android_gms_internal_zzclw.f17939d;
            if (z) {
                arrayList = new ArrayList();
                length = strArr.length;
                while (i < length) {
                    arrayList.add(strArr[i].toUpperCase(Locale.ENGLISH));
                    i++;
                }
                list = arrayList;
            } else {
                list = Arrays.asList(strArr);
            }
        } else {
            list = null;
        }
        if (intValue != 1) {
        }
        return m17963a(str, intValue, z, str2, list, intValue != 1 ? str2 : null);
    }

    private static java.lang.Boolean m17966a(java.math.BigDecimal r7, com.google.android.gms.internal.zzclu r8, double r9) {
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
        com.google.android.gms.common.internal.zzbq.m4808a(r8);
        r0 = r8.f17927a;
        r1 = 0;
        if (r0 == 0) goto L_0x00ec;
    L_0x0008:
        r0 = r8.f17927a;
        r0 = r0.intValue();
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = r8.f17927a;
        r0 = r0.intValue();
        r2 = 4;
        if (r0 != r2) goto L_0x0023;
    L_0x001a:
        r0 = r8.f17930d;
        if (r0 == 0) goto L_0x0022;
    L_0x001e:
        r0 = r8.f17931e;
        if (r0 != 0) goto L_0x0028;
    L_0x0022:
        return r1;
    L_0x0023:
        r0 = r8.f17929c;
        if (r0 != 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r0 = r8.f17927a;
        r0 = r0.intValue();
        r3 = r8.f17927a;
        r3 = r3.intValue();
        if (r3 != r2) goto L_0x0059;
    L_0x0036:
        r3 = r8.f17930d;
        r3 = com.google.android.gms.internal.zzclq.m18528j(r3);
        if (r3 == 0) goto L_0x0058;
    L_0x003e:
        r3 = r8.f17931e;
        r3 = com.google.android.gms.internal.zzclq.m18528j(r3);
        if (r3 != 0) goto L_0x0047;
    L_0x0046:
        return r1;
    L_0x0047:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0058 }
        r4 = r8.f17930d;	 Catch:{ NumberFormatException -> 0x0058 }
        r3.<init>(r4);	 Catch:{ NumberFormatException -> 0x0058 }
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0058 }
        r8 = r8.f17931e;	 Catch:{ NumberFormatException -> 0x0058 }
        r4.<init>(r8);	 Catch:{ NumberFormatException -> 0x0058 }
        r8 = r3;
        r3 = r1;
        goto L_0x006b;
    L_0x0058:
        return r1;
    L_0x0059:
        r3 = r8.f17929c;
        r3 = com.google.android.gms.internal.zzclq.m18528j(r3);
        if (r3 != 0) goto L_0x0062;
    L_0x0061:
        return r1;
    L_0x0062:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x00ec }
        r8 = r8.f17929c;	 Catch:{ NumberFormatException -> 0x00ec }
        r3.<init>(r8);	 Catch:{ NumberFormatException -> 0x00ec }
        r8 = r1;
        r4 = r8;
    L_0x006b:
        if (r0 != r2) goto L_0x0070;
    L_0x006d:
        if (r8 != 0) goto L_0x0072;
    L_0x006f:
        return r1;
    L_0x0070:
        if (r3 == 0) goto L_0x00ec;
    L_0x0072:
        r2 = -1;
        r5 = 0;
        r6 = 1;
        switch(r0) {
            case 1: goto L_0x00e0;
            case 2: goto L_0x00d4;
            case 3: goto L_0x008b;
            case 4: goto L_0x0079;
            default: goto L_0x0078;
        };
    L_0x0078:
        return r1;
    L_0x0079:
        r8 = r7.compareTo(r8);
        if (r8 == r2) goto L_0x0086;
    L_0x007f:
        r7 = r7.compareTo(r4);
        if (r7 == r6) goto L_0x0086;
    L_0x0085:
        r5 = r6;
    L_0x0086:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x008b:
        r0 = 0;
        r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r8 == 0) goto L_0x00c8;
    L_0x0091:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r0 = new java.math.BigDecimal;
        r1 = 2;
        r0.<init>(r1);
        r8 = r8.multiply(r0);
        r8 = r3.subtract(r8);
        r8 = r7.compareTo(r8);
        if (r8 != r6) goto L_0x00c3;
    L_0x00aa:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r9 = new java.math.BigDecimal;
        r9.<init>(r1);
        r8 = r8.multiply(r9);
        r8 = r3.add(r8);
        r7 = r7.compareTo(r8);
        if (r7 != r2) goto L_0x00c3;
    L_0x00c2:
        r5 = r6;
    L_0x00c3:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00c8:
        r7 = r7.compareTo(r3);
        if (r7 != 0) goto L_0x00cf;
    L_0x00ce:
        r5 = r6;
    L_0x00cf:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00d4:
        r7 = r7.compareTo(r3);
        if (r7 != r6) goto L_0x00db;
    L_0x00da:
        r5 = r6;
    L_0x00db:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00e0:
        r7 = r7.compareTo(r3);
        if (r7 != r2) goto L_0x00e7;
    L_0x00e6:
        r5 = r6;
    L_0x00e7:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00ec:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgk.a(java.math.BigDecimal, com.google.android.gms.internal.zzclu, double):java.lang.Boolean");
    }

    protected final boolean mo3490w() {
        return false;
    }

    final zzcma[] m17967a(String str, zzcmb[] com_google_android_gms_internal_zzcmbArr, zzcmg[] com_google_android_gms_internal_zzcmgArr) {
        int intValue;
        int i;
        Map map;
        Map map2;
        int length;
        int i2;
        int intValue2;
        Map map3;
        Map map4;
        Map map5;
        String str2;
        int length2;
        Map map6;
        Map map7;
        SQLiteException e;
        zzcgk com_google_android_gms_internal_zzcgk = this;
        String str3 = str;
        zzcmb[] com_google_android_gms_internal_zzcmbArr2 = com_google_android_gms_internal_zzcmbArr;
        zzcmg[] com_google_android_gms_internal_zzcmgArr2 = com_google_android_gms_internal_zzcmgArr;
        zzbq.m4810a(str);
        Set hashSet = new HashSet();
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        Map arrayMap3 = new ArrayMap();
        Map e2 = mo1822n().m18017e(str3);
        if (e2 != null) {
            Iterator it = e2.keySet().iterator();
            while (it.hasNext()) {
                Iterator it2;
                intValue = ((Integer) it.next()).intValue();
                zzcmf com_google_android_gms_internal_zzcmf = (zzcmf) e2.get(Integer.valueOf(intValue));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue), bitSet2);
                }
                Map map8 = e2;
                i = 0;
                while (i < (com_google_android_gms_internal_zzcmf.f18008a.length << 6)) {
                    if (zzclq.m18515a(com_google_android_gms_internal_zzcmf.f18008a, i)) {
                        it2 = it;
                        map = arrayMap2;
                        map2 = arrayMap3;
                        mo1828t().f17822g.m5695a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzclq.m18515a(com_google_android_gms_internal_zzcmf.f18009b, i)) {
                            bitSet.set(i);
                        }
                    } else {
                        it2 = it;
                        map = arrayMap2;
                        map2 = arrayMap3;
                    }
                    i++;
                    it = it2;
                    arrayMap2 = map;
                    arrayMap3 = map2;
                }
                it2 = it;
                map = arrayMap2;
                map2 = arrayMap3;
                zzcma com_google_android_gms_internal_zzcma = new zzcma();
                arrayMap.put(Integer.valueOf(intValue), com_google_android_gms_internal_zzcma);
                com_google_android_gms_internal_zzcma.f17958d = Boolean.valueOf(false);
                com_google_android_gms_internal_zzcma.f17957c = com_google_android_gms_internal_zzcmf;
                com_google_android_gms_internal_zzcma.f17956b = new zzcmf();
                com_google_android_gms_internal_zzcma.f17956b.f18009b = zzclq.m18517a(bitSet);
                com_google_android_gms_internal_zzcma.f17956b.f18008a = zzclq.m18517a(bitSet2);
                e2 = map8;
                it = it2;
            }
        }
        map = arrayMap2;
        map2 = arrayMap3;
        i = 0;
        if (com_google_android_gms_internal_zzcmbArr2 != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            length = com_google_android_gms_internal_zzcmbArr2.length;
            intValue = 0;
            while (intValue < length) {
                int i3;
                int i4;
                ArrayMap arrayMap5;
                zzcmb com_google_android_gms_internal_zzcmb;
                Map map9;
                Map map10;
                Set set;
                Map map11;
                String str4;
                Map map12;
                zzcmb com_google_android_gms_internal_zzcmb2 = com_google_android_gms_internal_zzcmbArr2[intValue];
                zzcgw a = mo1822n().m17995a(str3, com_google_android_gms_internal_zzcmb2.f17961b);
                if (a == null) {
                    mo1828t().f17818c.m5695a("Event aggregate wasn't created during raw event logging. appId, event", zzchm.m18154a(str), mo1823o().m18128a(com_google_android_gms_internal_zzcmb2.f17961b));
                    i3 = intValue;
                    i4 = length;
                    i2 = 0;
                    arrayMap5 = arrayMap4;
                    com_google_android_gms_internal_zzcmb = com_google_android_gms_internal_zzcmb2;
                    map9 = map;
                    map10 = map2;
                    set = hashSet;
                    map11 = arrayMap;
                    a = new zzcgw(str3, com_google_android_gms_internal_zzcmb2.f17961b, 1, 1, com_google_android_gms_internal_zzcmb2.f17962c.longValue(), 0, null, null, null);
                } else {
                    com_google_android_gms_internal_zzcmb = com_google_android_gms_internal_zzcmb2;
                    i3 = intValue;
                    arrayMap5 = arrayMap4;
                    i4 = length;
                    set = hashSet;
                    map11 = arrayMap;
                    map9 = map;
                    map10 = map2;
                    i2 = 0;
                    a = a.m5668a();
                }
                mo1822n().m18001a(a);
                long j = a.f6843c;
                zzcmb com_google_android_gms_internal_zzcmb3 = com_google_android_gms_internal_zzcmb;
                Map map13 = arrayMap5;
                Map map14 = (Map) map13.get(com_google_android_gms_internal_zzcmb3.f17961b);
                if (map14 == null) {
                    str4 = str;
                    map14 = mo1822n().m18018f(str4, com_google_android_gms_internal_zzcmb3.f17961b);
                    if (map14 == null) {
                        map14 = new ArrayMap();
                    }
                    map13.put(com_google_android_gms_internal_zzcmb3.f17961b, map14);
                } else {
                    str4 = str;
                }
                Iterator it3 = map14.keySet().iterator();
                while (it3.hasNext()) {
                    intValue2 = ((Integer) it3.next()).intValue();
                    hashSet = set;
                    if (hashSet.contains(Integer.valueOf(intValue2))) {
                        mo1828t().f17822g.m5694a("Skipping failed audience ID", Integer.valueOf(intValue2));
                        set = hashSet;
                    } else {
                        Iterator it4;
                        arrayMap = map11;
                        Map map15 = map9;
                        BitSet bitSet3 = (BitSet) map15.get(Integer.valueOf(intValue2));
                        map12 = map13;
                        map13 = map10;
                        BitSet bitSet4 = (BitSet) map13.get(Integer.valueOf(intValue2));
                        if (((zzcma) arrayMap.get(Integer.valueOf(intValue2))) == null) {
                            zzcma com_google_android_gms_internal_zzcma2 = new zzcma();
                            arrayMap.put(Integer.valueOf(intValue2), com_google_android_gms_internal_zzcma2);
                            com_google_android_gms_internal_zzcma2.f17958d = Boolean.valueOf(true);
                            BitSet bitSet5 = new BitSet();
                            map15.put(Integer.valueOf(intValue2), bitSet5);
                            bitSet4 = new BitSet();
                            map13.put(Integer.valueOf(intValue2), bitSet4);
                            bitSet3 = bitSet5;
                        }
                        Iterator it5 = ((List) map14.get(Integer.valueOf(intValue2))).iterator();
                        while (it5.hasNext()) {
                            Map map16 = map14;
                            zzcls com_google_android_gms_internal_zzcls = (zzcls) it5.next();
                            it4 = it3;
                            Iterator it6 = it5;
                            if (mo1828t().m18161a(2)) {
                                map3 = map13;
                                map4 = map15;
                                map5 = arrayMap;
                                mo1828t().f17822g.m5696a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_zzcls.f17917a, mo1823o().m18128a(com_google_android_gms_internal_zzcls.f17918b));
                                mo1828t().f17822g.m5694a("Filter definition", mo1823o().m18125a(com_google_android_gms_internal_zzcls));
                            } else {
                                map3 = map13;
                                map5 = arrayMap;
                                map4 = map15;
                            }
                            if (com_google_android_gms_internal_zzcls.f17917a != null) {
                                if (com_google_android_gms_internal_zzcls.f17917a.intValue() <= 256) {
                                    if (bitSet3.get(com_google_android_gms_internal_zzcls.f17917a.intValue())) {
                                        mo1828t().f17822g.m5695a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_zzcls.f17917a);
                                    } else {
                                        Boolean a2 = m17961a(com_google_android_gms_internal_zzcls, com_google_android_gms_internal_zzcmb3, j);
                                        mo1828t().f17822g.m5694a("Event filter result", a2 == null ? "null" : a2);
                                        if (a2 == null) {
                                            hashSet.add(Integer.valueOf(intValue2));
                                        } else {
                                            bitSet4.set(com_google_android_gms_internal_zzcls.f17917a.intValue());
                                            if (a2.booleanValue()) {
                                                bitSet3.set(com_google_android_gms_internal_zzcls.f17917a.intValue());
                                            }
                                        }
                                    }
                                    map14 = map16;
                                    it3 = it4;
                                    it5 = it6;
                                    map13 = map3;
                                    map15 = map4;
                                    arrayMap = map5;
                                    str4 = str;
                                }
                            }
                            str2 = str;
                            mo1828t().f17818c.m5695a("Invalid event filter ID. appId, id", zzchm.m18154a(str), String.valueOf(com_google_android_gms_internal_zzcls.f17917a));
                            str4 = str2;
                            map14 = map16;
                            it3 = it4;
                            it5 = it6;
                            map13 = map3;
                            map15 = map4;
                            arrayMap = map5;
                        }
                        it4 = it3;
                        map10 = map13;
                        set = hashSet;
                        map11 = arrayMap;
                        map9 = map15;
                        map13 = map12;
                    }
                }
                map12 = map13;
                hashSet = set;
                intValue = i3 + 1;
                com_google_android_gms_internal_zzcmbArr2 = com_google_android_gms_internal_zzcmbArr;
                str3 = str4;
                i = i2;
                length = i4;
                map14 = map12;
                map2 = map10;
                map = map9;
                arrayMap = map11;
                com_google_android_gms_internal_zzcmgArr2 = com_google_android_gms_internal_zzcmgArr;
            }
        }
        i2 = i;
        map5 = arrayMap;
        str2 = str3;
        map4 = map;
        map3 = map2;
        zzcmg[] com_google_android_gms_internal_zzcmgArr3 = com_google_android_gms_internal_zzcmgArr;
        if (com_google_android_gms_internal_zzcmgArr3 != null) {
            Map arrayMap6 = new ArrayMap();
            length2 = com_google_android_gms_internal_zzcmgArr3.length;
            length = i2;
            while (length < length2) {
                Map map17;
                int i5;
                Map map18;
                zzcmg com_google_android_gms_internal_zzcmg = com_google_android_gms_internal_zzcmgArr3[length];
                arrayMap2 = (Map) arrayMap6.get(com_google_android_gms_internal_zzcmg.f18012b);
                if (arrayMap2 == null) {
                    arrayMap2 = mo1822n().m18019g(str2, com_google_android_gms_internal_zzcmg.f18012b);
                    if (arrayMap2 == null) {
                        arrayMap2 = new ArrayMap();
                    }
                    arrayMap6.put(com_google_android_gms_internal_zzcmg.f18012b, arrayMap2);
                }
                Iterator it7 = arrayMap2.keySet().iterator();
                while (it7.hasNext()) {
                    int intValue3 = ((Integer) it7.next()).intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        mo1828t().f17822g.m5694a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        BitSet bitSet6;
                        Map map19 = map5;
                        Map map20 = map4;
                        BitSet bitSet7 = (BitSet) map20.get(Integer.valueOf(intValue3));
                        Map map21 = map3;
                        BitSet bitSet8 = (BitSet) map21.get(Integer.valueOf(intValue3));
                        if (((zzcma) map19.get(Integer.valueOf(intValue3))) == null) {
                            com_google_android_gms_internal_zzcma = new zzcma();
                            map19.put(Integer.valueOf(intValue3), com_google_android_gms_internal_zzcma);
                            map17 = arrayMap6;
                            com_google_android_gms_internal_zzcma.f17958d = Boolean.valueOf(true);
                            bitSet8 = new BitSet();
                            map20.put(Integer.valueOf(intValue3), bitSet8);
                            bitSet6 = new BitSet();
                            map21.put(Integer.valueOf(intValue3), bitSet6);
                        } else {
                            map17 = arrayMap6;
                            bitSet6 = bitSet8;
                            bitSet8 = bitSet7;
                        }
                        Iterator it8 = ((List) arrayMap2.get(Integer.valueOf(intValue3))).iterator();
                        while (it8.hasNext()) {
                            Iterator it9;
                            i5 = length2;
                            zzclv com_google_android_gms_internal_zzclv = (zzclv) it8.next();
                            Map map22 = arrayMap2;
                            Iterator it10 = it7;
                            if (mo1828t().m18161a(2)) {
                                it9 = it8;
                                map6 = map21;
                                map7 = map19;
                                map18 = map20;
                                mo1828t().f17822g.m5696a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue3), com_google_android_gms_internal_zzclv.f17933a, mo1823o().m18132c(com_google_android_gms_internal_zzclv.f17934b));
                                mo1828t().f17822g.m5694a("Filter definition", mo1823o().m18126a(com_google_android_gms_internal_zzclv));
                            } else {
                                map6 = map21;
                                map18 = map20;
                                it9 = it8;
                                map7 = map19;
                            }
                            if (com_google_android_gms_internal_zzclv.f17933a != null) {
                                if (com_google_android_gms_internal_zzclv.f17933a.intValue() <= 256) {
                                    if (bitSet8.get(com_google_android_gms_internal_zzclv.f17933a.intValue())) {
                                        mo1828t().f17822g.m5695a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), com_google_android_gms_internal_zzclv.f17933a);
                                    } else {
                                        Boolean a3;
                                        zzclt com_google_android_gms_internal_zzclt = com_google_android_gms_internal_zzclv.f17935c;
                                        if (com_google_android_gms_internal_zzclt == null) {
                                            mo1828t().f17818c.m5694a("Missing property filter. property", mo1823o().m18132c(com_google_android_gms_internal_zzcmg.f18012b));
                                        } else {
                                            boolean equals = Boolean.TRUE.equals(com_google_android_gms_internal_zzclt.f17925c);
                                            if (com_google_android_gms_internal_zzcmg.f18014d != null) {
                                                if (com_google_android_gms_internal_zzclt.f17924b == null) {
                                                    mo1828t().f17818c.m5694a("No number filter for long property. property", mo1823o().m18132c(com_google_android_gms_internal_zzcmg.f18012b));
                                                } else {
                                                    a3 = m17962a(m17960a(com_google_android_gms_internal_zzcmg.f18014d.longValue(), com_google_android_gms_internal_zzclt.f17924b), equals);
                                                    mo1828t().f17822g.m5694a("Property filter result", a3 != null ? "null" : a3);
                                                    if (a3 != null) {
                                                        hashSet.add(Integer.valueOf(intValue3));
                                                    } else {
                                                        bitSet6.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                                        if (!a3.booleanValue()) {
                                                            bitSet8.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                                        }
                                                    }
                                                }
                                            } else if (com_google_android_gms_internal_zzcmg.f18015e != null) {
                                                if (com_google_android_gms_internal_zzclt.f17924b == null) {
                                                    mo1828t().f17818c.m5694a("No number filter for double property. property", mo1823o().m18132c(com_google_android_gms_internal_zzcmg.f18012b));
                                                } else {
                                                    a3 = m17962a(m17959a(com_google_android_gms_internal_zzcmg.f18015e.doubleValue(), com_google_android_gms_internal_zzclt.f17924b), equals);
                                                    if (a3 != null) {
                                                    }
                                                    mo1828t().f17822g.m5694a("Property filter result", a3 != null ? "null" : a3);
                                                    if (a3 != null) {
                                                        bitSet6.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                                        if (!a3.booleanValue()) {
                                                            bitSet8.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                                        }
                                                    } else {
                                                        hashSet.add(Integer.valueOf(intValue3));
                                                    }
                                                }
                                            } else if (com_google_android_gms_internal_zzcmg.f18013c != null) {
                                                if (com_google_android_gms_internal_zzclt.f17923a != null) {
                                                    a3 = m17962a(m17965a(com_google_android_gms_internal_zzcmg.f18013c, com_google_android_gms_internal_zzclt.f17923a), equals);
                                                } else if (com_google_android_gms_internal_zzclt.f17924b == null) {
                                                    mo1828t().f17818c.m5694a("No string or number filter defined. property", mo1823o().m18132c(com_google_android_gms_internal_zzcmg.f18012b));
                                                } else if (zzclq.m18528j(com_google_android_gms_internal_zzcmg.f18013c)) {
                                                    a3 = m17962a(m17964a(com_google_android_gms_internal_zzcmg.f18013c, com_google_android_gms_internal_zzclt.f17924b), equals);
                                                } else {
                                                    mo1828t().f17818c.m5695a("Invalid user property value for Numeric number filter. property, value", mo1823o().m18132c(com_google_android_gms_internal_zzcmg.f18012b), com_google_android_gms_internal_zzcmg.f18013c);
                                                }
                                                if (a3 != null) {
                                                }
                                                mo1828t().f17822g.m5694a("Property filter result", a3 != null ? "null" : a3);
                                                if (a3 != null) {
                                                    hashSet.add(Integer.valueOf(intValue3));
                                                } else {
                                                    bitSet6.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                                    if (!a3.booleanValue()) {
                                                        bitSet8.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                                    }
                                                }
                                            } else {
                                                mo1828t().f17818c.m5694a("User property has no value, property", mo1823o().m18132c(com_google_android_gms_internal_zzcmg.f18012b));
                                            }
                                        }
                                        a3 = null;
                                        if (a3 != null) {
                                        }
                                        mo1828t().f17822g.m5694a("Property filter result", a3 != null ? "null" : a3);
                                        if (a3 != null) {
                                            bitSet6.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                            if (!a3.booleanValue()) {
                                                bitSet8.set(com_google_android_gms_internal_zzclv.f17933a.intValue());
                                            }
                                        } else {
                                            hashSet.add(Integer.valueOf(intValue3));
                                        }
                                    }
                                    length2 = i5;
                                    arrayMap2 = map22;
                                    it7 = it10;
                                    it8 = it9;
                                    map21 = map6;
                                    map19 = map7;
                                    map20 = map18;
                                }
                            }
                            mo1828t().f17818c.m5695a("Invalid property filter ID. appId, id", zzchm.m18154a(str), String.valueOf(com_google_android_gms_internal_zzclv.f17933a));
                            hashSet.add(Integer.valueOf(intValue3));
                            arrayMap6 = map17;
                            length2 = i5;
                            arrayMap2 = map22;
                            it7 = it10;
                            map3 = map6;
                            map5 = map7;
                            map4 = map18;
                            com_google_android_gms_internal_zzcmgArr3 = com_google_android_gms_internal_zzcmgArr;
                        }
                        map3 = map21;
                        map5 = map19;
                        arrayMap6 = map17;
                        map4 = map20;
                        com_google_android_gms_internal_zzcmgArr3 = com_google_android_gms_internal_zzcmgArr;
                    }
                }
                map17 = arrayMap6;
                i5 = length2;
                map6 = map3;
                map18 = map4;
                map7 = map5;
                length++;
                com_google_android_gms_internal_zzcmgArr3 = com_google_android_gms_internal_zzcmgArr;
            }
        }
        map6 = map3;
        map7 = map5;
        e2 = map4;
        zzcma[] com_google_android_gms_internal_zzcmaArr = new zzcma[e2.size()];
        i = i2;
        for (Integer intValue4 : e2.keySet()) {
            length2 = intValue4.intValue();
            if (!hashSet.contains(Integer.valueOf(length2))) {
                Map map23 = map7;
                zzcma com_google_android_gms_internal_zzcma3 = (zzcma) map23.get(Integer.valueOf(length2));
                if (com_google_android_gms_internal_zzcma3 == null) {
                    com_google_android_gms_internal_zzcma3 = new zzcma();
                }
                intValue2 = i + 1;
                com_google_android_gms_internal_zzcmaArr[i] = com_google_android_gms_internal_zzcma3;
                com_google_android_gms_internal_zzcma3.f17955a = Integer.valueOf(length2);
                com_google_android_gms_internal_zzcma3.f17956b = new zzcmf();
                com_google_android_gms_internal_zzcma3.f17956b.f18009b = zzclq.m18517a((BitSet) e2.get(Integer.valueOf(length2)));
                Map map24 = map6;
                com_google_android_gms_internal_zzcma3.f17956b.f18008a = zzclq.m18517a((BitSet) map24.get(Integer.valueOf(length2)));
                zzcjk n = mo1822n();
                Object obj = com_google_android_gms_internal_zzcma3.f17956b;
                n.m13545L();
                n.mo1811c();
                zzbq.m4810a(str);
                zzbq.m4808a(obj);
                try {
                    byte[] bArr = new byte[obj.m6211e()];
                    zzfjk a4 = zzfjk.m6158a(bArr, bArr.length);
                    obj.mo1928a(a4);
                    a4.m6171a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str2);
                    contentValues.put("audience_id", Integer.valueOf(length2));
                    contentValues.put("current_results", bArr);
                    try {
                        try {
                            if (n.m17987A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                n.mo1828t().f17816a.m5694a("Failed to insert filter results (got -1). appId", zzchm.m18154a(str));
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            n.mo1828t().f17816a.m5695a("Error storing filter results. appId", zzchm.m18154a(str), e);
                            map7 = map23;
                            i = intValue2;
                            map6 = map24;
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        n.mo1828t().f17816a.m5695a("Error storing filter results. appId", zzchm.m18154a(str), e);
                        map7 = map23;
                        i = intValue2;
                        map6 = map24;
                    }
                } catch (IOException e5) {
                    n.mo1828t().f17816a.m5695a("Configuration loss. Failed to serialize filter results. appId", zzchm.m18154a(str), e5);
                }
                map7 = map23;
                i = intValue2;
                map6 = map24;
            }
        }
        return (zzcma[]) Arrays.copyOf(com_google_android_gms_internal_zzcmaArr, i);
    }

    private final Boolean m17961a(zzcls com_google_android_gms_internal_zzcls, zzcmb com_google_android_gms_internal_zzcmb, long j) {
        if (com_google_android_gms_internal_zzcls.f17920d != null) {
            j = m17960a(j, com_google_android_gms_internal_zzcls.f17920d);
            if (j == null) {
                return null;
            }
            if (j.booleanValue() == null) {
                return Boolean.valueOf(false);
            }
        }
        j = new HashSet();
        for (zzclt com_google_android_gms_internal_zzclt : com_google_android_gms_internal_zzcls.f17919c) {
            if (TextUtils.isEmpty(com_google_android_gms_internal_zzclt.f17926d)) {
                mo1828t().f17818c.m5694a("null or empty param name in filter. event", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b));
                return null;
            }
            j.add(com_google_android_gms_internal_zzclt.f17926d);
        }
        Map arrayMap = new ArrayMap();
        for (zzcmc com_google_android_gms_internal_zzcmc : com_google_android_gms_internal_zzcmb.f17960a) {
            if (j.contains(com_google_android_gms_internal_zzcmc.f17966a)) {
                Object obj;
                Object obj2;
                if (com_google_android_gms_internal_zzcmc.f17968c != null) {
                    obj = com_google_android_gms_internal_zzcmc.f17966a;
                    obj2 = com_google_android_gms_internal_zzcmc.f17968c;
                } else if (com_google_android_gms_internal_zzcmc.f17969d != null) {
                    obj = com_google_android_gms_internal_zzcmc.f17966a;
                    obj2 = com_google_android_gms_internal_zzcmc.f17969d;
                } else if (com_google_android_gms_internal_zzcmc.f17967b != null) {
                    obj = com_google_android_gms_internal_zzcmc.f17966a;
                    obj2 = com_google_android_gms_internal_zzcmc.f17967b;
                } else {
                    mo1828t().f17818c.m5695a("Unknown value for param. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(com_google_android_gms_internal_zzcmc.f17966a));
                    return null;
                }
                arrayMap.put(obj, obj2);
            }
        }
        for (zzclt com_google_android_gms_internal_zzclt2 : com_google_android_gms_internal_zzcls.f17919c) {
            boolean equals = Boolean.TRUE.equals(com_google_android_gms_internal_zzclt2.f17925c);
            String str = com_google_android_gms_internal_zzclt2.f17926d;
            if (TextUtils.isEmpty(str)) {
                mo1828t().f17818c.m5694a("Event has empty param name. event", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b));
                return null;
            }
            Object obj3 = arrayMap.get(str);
            Boolean a;
            if (obj3 instanceof Long) {
                if (com_google_android_gms_internal_zzclt2.f17924b == null) {
                    mo1828t().f17818c.m5695a("No number filter for long param. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(str));
                    return null;
                }
                a = m17960a(((Long) obj3).longValue(), com_google_android_gms_internal_zzclt2.f17924b);
                if (a == null) {
                    return null;
                }
                if (((1 ^ a.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 instanceof Double) {
                if (com_google_android_gms_internal_zzclt2.f17924b == null) {
                    mo1828t().f17818c.m5695a("No number filter for double param. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(str));
                    return null;
                }
                a = m17959a(((Double) obj3).doubleValue(), com_google_android_gms_internal_zzclt2.f17924b);
                if (a == null) {
                    return null;
                }
                if (((1 ^ a.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 instanceof String) {
                if (com_google_android_gms_internal_zzclt2.f17923a != null) {
                    a = m17965a((String) obj3, com_google_android_gms_internal_zzclt2.f17923a);
                } else if (com_google_android_gms_internal_zzclt2.f17924b != null) {
                    String str2 = (String) obj3;
                    if (zzclq.m18528j(str2)) {
                        a = m17964a(str2, com_google_android_gms_internal_zzclt2.f17924b);
                    } else {
                        mo1828t().f17818c.m5695a("Invalid param value for number filter. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(str));
                        return null;
                    }
                } else {
                    mo1828t().f17818c.m5695a("No filter for String param. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(str));
                    return null;
                }
                if (a == null) {
                    return null;
                }
                if (((1 ^ a.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 == null) {
                mo1828t().f17822g.m5695a("Missing param for filter. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(str));
                return Boolean.valueOf(false);
            } else {
                mo1828t().f17818c.m5695a("Unknown param type. event, param", mo1823o().m18128a(com_google_android_gms_internal_zzcmb.f17961b), mo1823o().m18130b(str));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private final java.lang.Boolean m17963a(java.lang.String r3, int r4, boolean r5, java.lang.String r6, java.util.List<java.lang.String> r7, java.lang.String r8) {
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
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 6;
        if (r4 != r1) goto L_0x0010;
    L_0x0007:
        if (r7 == 0) goto L_0x000f;
    L_0x0009:
        r1 = r7.size();
        if (r1 != 0) goto L_0x0013;
    L_0x000f:
        return r0;
    L_0x0010:
        if (r6 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        if (r5 != 0) goto L_0x001f;
    L_0x0015:
        r1 = 1;
        if (r4 != r1) goto L_0x0019;
    L_0x0018:
        goto L_0x001f;
    L_0x0019:
        r1 = java.util.Locale.ENGLISH;
        r3 = r3.toUpperCase(r1);
    L_0x001f:
        switch(r4) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003b;
            case 3: goto L_0x0036;
            case 4: goto L_0x0031;
            case 5: goto L_0x002c;
            case 6: goto L_0x0023;
            default: goto L_0x0022;
        };
    L_0x0022:
        return r0;
    L_0x0023:
        r3 = r7.contains(r3);
    L_0x0027:
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x002c:
        r3 = r3.equals(r6);
        goto L_0x0027;
    L_0x0031:
        r3 = r3.contains(r6);
        goto L_0x0027;
    L_0x0036:
        r3 = r3.endsWith(r6);
        goto L_0x0027;
    L_0x003b:
        r3 = r3.startsWith(r6);
        goto L_0x0027;
    L_0x0040:
        if (r5 == 0) goto L_0x0044;
    L_0x0042:
        r4 = 0;
        goto L_0x0046;
    L_0x0044:
        r4 = 66;
    L_0x0046:
        r4 = java.util.regex.Pattern.compile(r8, r4);	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = r4.matcher(r3);	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = r3.matches();	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ PatternSyntaxException -> 0x0057 }
        return r3;
    L_0x0057:
        r3 = r2.mo1828t();
        r3 = r3.f17818c;
        r4 = "Invalid regular expression in REGEXP audience filter. expression";
        r3.m5694a(r4, r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgk.a(java.lang.String, int, boolean, java.lang.String, java.util.List, java.lang.String):java.lang.Boolean");
    }
}
