package com.google.android.gms.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

public final class zzao {
    private static long m5465a(String str) {
        try {
            return m5469a().parse(str).getTime();
        } catch (Throwable e) {
            zzae.m5042a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static com.google.android.gms.internal.zzc m5466a(com.google.android.gms.internal.zzp r18) {
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
        r0 = r18;
        r1 = java.lang.System.currentTimeMillis();
        r3 = r0.f7958c;
        r4 = "Date";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r7 = m5465a(r4);
        goto L_0x0019;
    L_0x0017:
        r7 = 0;
    L_0x0019:
        r4 = "Cache-Control";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        r10 = 0;
        if (r4 == 0) goto L_0x008a;
    L_0x0024:
        r11 = ",";
        r4 = r4.split(r11);
        r13 = r10;
        r11 = 0;
        r14 = 0;
    L_0x002f:
        r9 = r4.length;
        if (r10 >= r9) goto L_0x0087;
    L_0x0032:
        r9 = r4[r10];
        r9 = r9.trim();
        r5 = "no-cache";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0085;
    L_0x0040:
        r5 = "no-store";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0049;
    L_0x0048:
        goto L_0x0085;
    L_0x0049:
        r5 = "max-age=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x005d;
    L_0x0051:
        r5 = 8;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0082 }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0082 }
        r11 = r5;
        goto L_0x0082;
    L_0x005d:
        r5 = "stale-while-revalidate=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x0071;
    L_0x0065:
        r5 = 23;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0082 }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0082 }
        r14 = r5;
        goto L_0x0082;
    L_0x0071:
        r5 = "must-revalidate";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0081;
    L_0x0079:
        r5 = "proxy-revalidate";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0082;
    L_0x0081:
        r13 = 1;
    L_0x0082:
        r10 = r10 + 1;
        goto L_0x002f;
    L_0x0085:
        r0 = 0;
        return r0;
    L_0x0087:
        r16 = 1;
        goto L_0x0091;
    L_0x008a:
        r13 = r10;
        r16 = r13;
        r11 = 0;
        r14 = 0;
    L_0x0091:
        r4 = "Expires";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00a0;
    L_0x009b:
        r5 = m5465a(r4);
        goto L_0x00a2;
    L_0x00a0:
        r5 = 0;
    L_0x00a2:
        r4 = "Last-Modified";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00b1;
    L_0x00ac:
        r9 = m5465a(r4);
        goto L_0x00b3;
    L_0x00b1:
        r9 = 0;
    L_0x00b3:
        r4 = "ETag";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r16 == 0) goto L_0x00c8;
    L_0x00bd:
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r5;
        r1 = r1 + r11;
        if (r13 == 0) goto L_0x00c4;
    L_0x00c3:
        goto L_0x00d7;
    L_0x00c4:
        r14 = r14 * r5;
        r14 = r14 + r1;
        r5 = r14;
        goto L_0x00d8;
    L_0x00c8:
        r11 = 0;
        r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r13 <= 0) goto L_0x00d6;
    L_0x00ce:
        r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r13 < 0) goto L_0x00d6;
    L_0x00d2:
        r5 = r5 - r7;
        r5 = r5 + r1;
        r1 = r5;
        goto L_0x00d8;
    L_0x00d6:
        r1 = r11;
    L_0x00d7:
        r5 = r1;
    L_0x00d8:
        r11 = new com.google.android.gms.internal.zzc;
        r11.<init>();
        r12 = r0.f7957b;
        r11.f6721a = r12;
        r11.f6722b = r4;
        r11.f6726f = r1;
        r11.f6725e = r5;
        r11.f6723c = r7;
        r11.f6724d = r9;
        r11.f6727g = r3;
        r0 = r0.f7959d;
        r11.f6728h = r0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzao.a(com.google.android.gms.internal.zzp):com.google.android.gms.internal.zzc");
    }

    static String m5467a(long j) {
        return m5469a().format(new Date(j));
    }

    public static String m5468a(Map<String, String> map) {
        String str = "ISO-8859-1";
        String str2 = (String) map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(Operation.EQUALS);
                if (split2.length == 2 && split2[0].equals(HttpRequest.PARAM_CHARSET)) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    private static SimpleDateFormat m5469a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    static List<zzl> m5471b(Map<String, String> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    static Map<String, String> m5470a(List<zzl> list) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (zzl com_google_android_gms_internal_zzl : list) {
            treeMap.put(com_google_android_gms_internal_zzl.f7777a, com_google_android_gms_internal_zzl.f7778b);
        }
        return treeMap;
    }
}
