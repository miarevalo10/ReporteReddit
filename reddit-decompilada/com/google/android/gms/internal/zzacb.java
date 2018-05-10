package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@zzzv
public final class zzacb extends zzabc {
    private static final Object f17495a = new Object();
    private static zzacb f17496b;
    private final Context f17497c;
    private final zzaca f17498d;
    private final ScheduledExecutorService f17499e = Executors.newSingleThreadScheduledExecutor();

    private zzacb(Context context, zzaca com_google_android_gms_internal_zzaca) {
        this.f17497c = context;
        this.f17498d = com_google_android_gms_internal_zzaca;
    }

    public static zzacb m17719a(Context context, zzaca com_google_android_gms_internal_zzaca) {
        zzacb com_google_android_gms_internal_zzacb;
        synchronized (f17495a) {
            if (f17496b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zznh.m6490a(context);
                f17496b = new zzacb(context, com_google_android_gms_internal_zzaca);
                if (context.getApplicationContext() != null) {
                    zzbs.m4486e().m5229b(context);
                }
                zzagd.m5122a(context);
            }
            com_google_android_gms_internal_zzacb = f17496b;
        }
        return com_google_android_gms_internal_zzacb;
    }

    private static void m17721a(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzakb.m5365a(2)) {
            StringBuilder stringBuilder = new StringBuilder(39 + String.valueOf(str).length());
            stringBuilder.append("Http Response: {\n  URL:\n    ");
            stringBuilder.append(str);
            stringBuilder.append("\n  Headers:");
            zzagf.m13278a(stringBuilder.toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    StringBuilder stringBuilder2 = new StringBuilder(5 + String.valueOf(str3).length());
                    stringBuilder2.append("    ");
                    stringBuilder2.append(str3);
                    stringBuilder2.append(":");
                    zzagf.m13278a(stringBuilder2.toString());
                    for (String valueOf : (List) map.get(str3)) {
                        String str4 = "      ";
                        String valueOf2 = String.valueOf(valueOf2);
                        zzagf.m13278a(valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
                    }
                }
            }
            zzagf.m13278a("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    zzagf.m13278a(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                zzagf.m13278a("    null");
            }
            StringBuilder stringBuilder3 = new StringBuilder(34);
            stringBuilder3.append("  Response Code:\n    ");
            stringBuilder3.append(i);
            stringBuilder3.append("\n}");
            zzagf.m13278a(stringBuilder3.toString());
        }
    }

    public final zzaax mo1650a(zzaat com_google_android_gms_internal_zzaat) {
        return m17717a(this.f17497c, this.f17498d, com_google_android_gms_internal_zzaat, this.f17499e);
    }

    public final void mo1652a(zzabm com_google_android_gms_internal_zzabm, zzabh com_google_android_gms_internal_zzabh) {
        zzagf.m13278a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    private static com.google.android.gms.internal.zzaax m17717a(android.content.Context r19, com.google.android.gms.internal.zzaca r20, com.google.android.gms.internal.zzaat r21, java.util.concurrent.ScheduledExecutorService r22) {
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
        r1 = r19;
        r7 = r20;
        r0 = r21;
        r2 = r22;
        r3 = "Starting ad request from service using: google.afma.request.getAdDictionary";
        com.google.android.gms.internal.zzakb.m5366b(r3);
        r8 = new com.google.android.gms.internal.zznu;
        r3 = com.google.android.gms.internal.zznh.f7872H;
        r4 = com.google.android.gms.internal.zzkb.m6350f();
        r3 = r4.m6488a(r3);
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        r4 = "load_ad";
        r5 = r0.f17397d;
        r5 = r5.f18152a;
        r8.<init>(r3, r4, r5);
        r3 = r0.f17394a;
        r4 = 10;
        if (r3 <= r4) goto L_0x0045;
    L_0x002e:
        r3 = r0.f17368A;
        r5 = -1;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 == 0) goto L_0x0045;
    L_0x0036:
        r3 = r0.f17368A;
        r3 = r8.m6503a(r3);
        r4 = "cts";
        r4 = new java.lang.String[]{r4};
        r8.m6506a(r3, r4);
    L_0x0045:
        r9 = r8.m6502a();
        r3 = r7.f6095h;
        r3 = r3.mo2291a();
        r4 = com.google.android.gms.internal.zznh.ck;
        r5 = com.google.android.gms.internal.zzkb.m6350f();
        r4 = r5.m6488a(r4);
        r4 = (java.lang.Long) r4;
        r4 = r4.longValue();
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r3 = com.google.android.gms.internal.zzakl.m5378a(r3, r4, r6, r2);
        r4 = r7.f6094g;
        r4 = r4.mo1656a();
        r5 = com.google.android.gms.internal.zznh.bh;
        r6 = com.google.android.gms.internal.zzkb.m6350f();
        r5 = r6.m6488a(r5);
        r5 = (java.lang.Long) r5;
        r5 = r5.longValue();
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r4 = com.google.android.gms.internal.zzakl.m5378a(r4, r5, r10, r2);
        r5 = r7.f6090c;
        r6 = r0.f17400g;
        r6 = r6.packageName;
        r5 = r5.mo1712a();
        r6 = r7.f6096i;
        r10 = r0.f17401h;
        r11 = r0.f17400g;
        r6 = r6.mo1714a(r10);
        r10 = com.google.android.gms.ads.internal.zzbs.m4496o();
        r10 = r10.m5014a(r1);
        r11 = 0;
        r12 = com.google.android.gms.internal.zzakl.m5377a(r11);
        r13 = r0.f17396c;
        r13 = r13.f18136c;
        if (r13 == 0) goto L_0x00b2;
    L_0x00a8:
        r15 = "_ad";
        r13 = r13.getString(r15);
        if (r13 == 0) goto L_0x00b2;
    L_0x00b0:
        r13 = 1;
        goto L_0x00b3;
    L_0x00b2:
        r13 = 0;
    L_0x00b3:
        r15 = r0.f17374G;
        if (r15 == 0) goto L_0x00c1;
    L_0x00b7:
        if (r13 != 0) goto L_0x00c1;
    L_0x00b9:
        r12 = r7.f6093f;
        r13 = r0.f17399f;
        r12 = r12.mo2162a();
    L_0x00c1:
        r13 = com.google.android.gms.internal.zznh.cb;
        r15 = com.google.android.gms.internal.zzkb.m6350f();
        r13 = r15.m6488a(r13);
        r13 = (java.lang.Long) r13;
        r14 = r13.longValue();
        r13 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r12 = com.google.android.gms.internal.zzakl.m5378a(r12, r14, r13, r2);
        r13 = com.google.android.gms.internal.zzakl.m5377a(r11);
        r14 = com.google.android.gms.internal.zznh.ax;
        r15 = com.google.android.gms.internal.zzkb.m6350f();
        r14 = r15.m6488a(r14);
        r14 = (java.lang.Boolean) r14;
        r14 = r14.booleanValue();
        if (r14 == 0) goto L_0x0109;
    L_0x00ed:
        r13 = r7.f6096i;
        r13 = r13.mo1713a(r1);
        r14 = com.google.android.gms.internal.zznh.ay;
        r15 = com.google.android.gms.internal.zzkb.m6350f();
        r14 = r15.m6488a(r14);
        r14 = (java.lang.Long) r14;
        r14 = r14.longValue();
        r11 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r13 = com.google.android.gms.internal.zzakl.m5378a(r13, r14, r11, r2);
    L_0x0109:
        r11 = r0.f17394a;
        r14 = 4;
        if (r11 < r14) goto L_0x0115;
    L_0x010e:
        r11 = r0.f17408o;
        if (r11 == 0) goto L_0x0115;
    L_0x0112:
        r11 = r0.f17408o;
        goto L_0x0116;
    L_0x0115:
        r11 = 0;
    L_0x0116:
        r14 = com.google.android.gms.internal.zznh.f7888X;
        r15 = com.google.android.gms.internal.zzkb.m6350f();
        r14 = r15.m6488a(r14);
        r14 = (java.lang.Boolean) r14;
        r14.booleanValue();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r14 = r19.getPackageName();
        r15 = "android.permission.ACCESS_NETWORK_STATE";
        r14 = com.google.android.gms.internal.zzahn.m5179a(r1, r14, r15);
        if (r14 == 0) goto L_0x0147;
    L_0x0134:
        r14 = "connectivity";
        r14 = r1.getSystemService(r14);
        r14 = (android.net.ConnectivityManager) r14;
        r14 = r14.getActiveNetworkInfo();
        if (r14 != 0) goto L_0x0147;
    L_0x0142:
        r14 = "Device is offline.";
        com.google.android.gms.internal.zzakb.m5366b(r14);
    L_0x0147:
        r14 = r0.f17394a;
        r15 = 7;
        if (r14 < r15) goto L_0x014f;
    L_0x014c:
        r14 = r0.f17415v;
        goto L_0x0157;
    L_0x014f:
        r14 = java.util.UUID.randomUUID();
        r14 = r14.toString();
    L_0x0157:
        r15 = new com.google.android.gms.internal.zzach;
        r2 = r0.f17399f;
        r2 = r2.packageName;
        r15.<init>(r1, r14, r2);
        r2 = r0.f17396c;
        r2 = r2.f18136c;
        if (r2 == 0) goto L_0x0177;
    L_0x0166:
        r2 = r0.f17396c;
        r2 = r2.f18136c;
        r15 = "_ad";
        r2 = r2.getString(r15);
        if (r2 == 0) goto L_0x0177;
    L_0x0172:
        r0 = com.google.android.gms.internal.zzacg.m4987a(r1, r0, r2);
        return r0;
    L_0x0177:
        r2 = r7.f6091d;
        r15 = r0.f17416w;
        r2 = r2.mo2055a(r15);
        r15 = com.google.android.gms.internal.zznh.ck;
        r16 = r8;
        r8 = com.google.android.gms.internal.zzkb.m6350f();
        r8 = r8.m6488a(r15);
        r8 = (java.lang.Long) r8;
        r17 = r9;
        r8 = r8.longValue();
        r15 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r18 = r14;
        r14 = 0;
        r3 = com.google.android.gms.internal.zzakl.m5383a(r3, r14, r8, r15);
        r3 = (android.os.Bundle) r3;
        r4 = com.google.android.gms.internal.zzakl.m5382a(r4, r14);
        r4 = (com.google.android.gms.internal.zzacy) r4;
        r8 = com.google.android.gms.internal.zzakl.m5382a(r12, r14);
        r8 = (android.location.Location) r8;
        r9 = com.google.android.gms.internal.zzakl.m5382a(r13, r14);
        r9 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r9;
        r6 = com.google.android.gms.internal.zzakl.m5382a(r6, r14);
        r6 = (java.lang.String) r6;
        r5 = com.google.android.gms.internal.zzakl.m5382a(r5, r14);
        r5 = (java.lang.String) r5;
        r10 = com.google.android.gms.internal.zzakl.m5382a(r10, r14);
        r10 = (com.google.android.gms.internal.zzaco) r10;
        if (r10 != 0) goto L_0x01d0;
    L_0x01c4:
        r0 = "Error fetching device info. This is not recoverable.";
        com.google.android.gms.internal.zzakb.m5371e(r0);
        r0 = new com.google.android.gms.internal.zzaax;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    L_0x01d0:
        r12 = new com.google.android.gms.internal.zzabz;
        r12.<init>();
        r12.f6084i = r0;
        r12.f6085j = r10;
        r12.f6080e = r4;
        r12.f6079d = r8;
        r12.f6077b = r3;
        r12.f6082g = r6;
        r12.f6083h = r9;
        if (r2 != 0) goto L_0x01ea;
    L_0x01e5:
        r3 = r12.f6078c;
        r3.clear();
    L_0x01ea:
        r12.f6078c = r2;
        r12.f6076a = r11;
        r12.f6081f = r5;
        r2 = r7.f6089b;
        r2 = r2.mo1958a();
        r12.f6086k = r2;
        r2 = r7.f6097j;
        r12.f6087l = r2;
        r2 = com.google.android.gms.internal.zzacg.m4991a(r1, r12);
        if (r2 != 0) goto L_0x0209;
    L_0x0202:
        r0 = new com.google.android.gms.internal.zzaax;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    L_0x0209:
        r3 = r0.f17394a;
        r4 = 7;
        if (r3 >= r4) goto L_0x0215;
    L_0x020e:
        r3 = "request_id";	 Catch:{ JSONException -> 0x0215 }
        r14 = r18;	 Catch:{ JSONException -> 0x0215 }
        r2.put(r3, r14);	 Catch:{ JSONException -> 0x0215 }
    L_0x0215:
        r2.toString();
        r3 = "arc";
        r3 = new java.lang.String[]{r3};
        r8 = r16;
        r9 = r17;
        r8.m6506a(r9, r3);
        r8.m6502a();
        r3 = r7.f6098k;
        r3 = r3.mo1657a();
        r2 = r3.mo3566b(r2);
        r3 = com.google.android.gms.internal.zzacc.f14036a;
        r4 = r22;
        r2 = com.google.android.gms.internal.zzakl.m5379a(r2, r3, r4);
        r10 = 10;
        r3 = java.util.concurrent.TimeUnit.SECONDS;
        r2 = com.google.android.gms.internal.zzakl.m5378a(r2, r10, r3, r4);
        r3 = r7.f6092e;
        r3 = r3.mo1654a();
        if (r3 == 0) goto L_0x024f;
    L_0x024a:
        r4 = "AdRequestServiceImpl.loadAd.flags";
        com.google.android.gms.internal.zzakj.m5376a(r3, r4);
    L_0x024f:
        r14 = 0;
        r2 = com.google.android.gms.internal.zzakl.m5382a(r2, r14);
        r6 = r2;
        r6 = (com.google.android.gms.internal.zzacn) r6;
        if (r6 != 0) goto L_0x0260;
    L_0x0259:
        r0 = new com.google.android.gms.internal.zzaax;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    L_0x0260:
        r2 = r6.f6157i;
        r3 = -2;
        if (r2 == r3) goto L_0x026d;
    L_0x0265:
        r0 = new com.google.android.gms.internal.zzaax;
        r1 = r6.f6157i;
        r0.<init>(r1);
        return r0;
    L_0x026d:
        r8.m6509d();
        r2 = r6.f6155g;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x027f;
    L_0x0278:
        r2 = r6.f6155g;
        r11 = com.google.android.gms.internal.zzacg.m4987a(r1, r0, r2);
        goto L_0x0280;
    L_0x027f:
        r11 = r14;
    L_0x0280:
        if (r11 != 0) goto L_0x0297;
    L_0x0282:
        r2 = r6.f6156h;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0297;
    L_0x028a:
        r2 = r0.f17404k;
        r2 = r2.f17551a;
        r3 = r6.f6156h;
        r4 = r5;
        r5 = r6;
        r6 = r8;
        r11 = m17718a(r0, r1, r2, r3, r4, r5, r6, r7);
    L_0x0297:
        if (r11 != 0) goto L_0x029f;
    L_0x0299:
        r11 = new com.google.android.gms.internal.zzaax;
        r0 = 0;
        r11.<init>(r0);
    L_0x029f:
        r0 = "tts";
        r0 = new java.lang.String[]{r0};
        r8.m6506a(r9, r0);
        r0 = r8.m6507b();
        r11.f17463w = r0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacb.a(android.content.Context, com.google.android.gms.internal.zzaca, com.google.android.gms.internal.zzaat, java.util.concurrent.ScheduledExecutorService):com.google.android.gms.internal.zzaax");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzaax m17718a(com.google.android.gms.internal.zzaat r77, android.content.Context r78, java.lang.String r79, java.lang.String r80, java.lang.String r81, com.google.android.gms.internal.zzacn r82, com.google.android.gms.internal.zznu r83, com.google.android.gms.internal.zzaca r84) {
        /*
        r1 = r77;
        r2 = r82;
        r3 = r83;
        if (r3 == 0) goto L_0x000d;
    L_0x0008:
        r5 = r83.m6502a();
        goto L_0x000e;
    L_0x000d:
        r5 = 0;
    L_0x000e:
        r7 = new com.google.android.gms.internal.zzacl;	 Catch:{ IOException -> 0x025a }
        r8 = r2.f6150b;	 Catch:{ IOException -> 0x025a }
        r7.<init>(r1, r8);	 Catch:{ IOException -> 0x025a }
        r8 = "AdRequestServiceImpl: Sending request: ";
        r9 = java.lang.String.valueOf(r80);	 Catch:{ IOException -> 0x025a }
        r10 = r9.length();	 Catch:{ IOException -> 0x025a }
        if (r10 == 0) goto L_0x0026;
    L_0x0021:
        r8 = r8.concat(r9);	 Catch:{ IOException -> 0x025a }
        goto L_0x002c;
    L_0x0026:
        r9 = new java.lang.String;	 Catch:{ IOException -> 0x025a }
        r9.<init>(r8);	 Catch:{ IOException -> 0x025a }
        r8 = r9;
    L_0x002c:
        com.google.android.gms.internal.zzakb.m5366b(r8);	 Catch:{ IOException -> 0x025a }
        r8 = new java.net.URL;	 Catch:{ IOException -> 0x025a }
        r9 = r80;
        r8.<init>(r9);	 Catch:{ IOException -> 0x025a }
        r9 = com.google.android.gms.ads.internal.zzbs.m4492k();	 Catch:{ IOException -> 0x025a }
        r24 = r9.mo1633b();	 Catch:{ IOException -> 0x025a }
        r10 = 0;
    L_0x003f:
        r11 = r8.openConnection();	 Catch:{ IOException -> 0x025a }
        r15 = r11;
        r15 = (java.net.HttpURLConnection) r15;	 Catch:{ IOException -> 0x025a }
        r11 = com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0253 }
        r12 = r78;
        r13 = r79;
        r11.m5228a(r12, r13, r15);	 Catch:{ all -> 0x0253 }
        r11 = android.text.TextUtils.isEmpty(r81);	 Catch:{ all -> 0x0253 }
        if (r11 != 0) goto L_0x0068;
    L_0x0057:
        r11 = r2.f6153e;	 Catch:{ all -> 0x0063 }
        if (r11 == 0) goto L_0x0068;
    L_0x005b:
        r11 = "x-afma-drt-cookie";
        r14 = r81;
        r15.addRequestProperty(r11, r14);	 Catch:{ all -> 0x0063 }
        goto L_0x006a;
    L_0x0063:
        r0 = move-exception;
        r1 = r0;
        r2 = r15;
        goto L_0x0256;
    L_0x0068:
        r14 = r81;
    L_0x006a:
        r11 = r1.f17375H;	 Catch:{ all -> 0x0253 }
        r16 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0253 }
        if (r16 != 0) goto L_0x007c;
    L_0x0072:
        r6 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.zzakb.m5366b(r6);	 Catch:{ all -> 0x0063 }
        r6 = "Cookie";
        r15.addRequestProperty(r6, r11);	 Catch:{ all -> 0x0063 }
    L_0x007c:
        r6 = 1;
        if (r2 == 0) goto L_0x00af;
    L_0x007f:
        r11 = r2.f6151c;	 Catch:{ all -> 0x0063 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0063 }
        if (r11 != 0) goto L_0x00af;
    L_0x0087:
        r15.setDoOutput(r6);	 Catch:{ all -> 0x0063 }
        r11 = r2.f6151c;	 Catch:{ all -> 0x0063 }
        r11 = r11.getBytes();	 Catch:{ all -> 0x0063 }
        r6 = r11.length;	 Catch:{ all -> 0x0063 }
        r15.setFixedLengthStreamingMode(r6);	 Catch:{ all -> 0x0063 }
        r6 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x00a8 }
        r9 = r15.getOutputStream();	 Catch:{ all -> 0x00a8 }
        r6.<init>(r9);	 Catch:{ all -> 0x00a8 }
        r6.write(r11);	 Catch:{ all -> 0x00a4 }
        com.google.android.gms.common.util.zzn.m4907a(r6);	 Catch:{ all -> 0x0063 }
        goto L_0x00b0;
    L_0x00a4:
        r0 = move-exception;
        r1 = r0;
        r4 = r6;
        goto L_0x00ab;
    L_0x00a8:
        r0 = move-exception;
        r1 = r0;
        r4 = 0;
    L_0x00ab:
        com.google.android.gms.common.util.zzn.m4907a(r4);	 Catch:{ all -> 0x0063 }
        throw r1;	 Catch:{ all -> 0x0063 }
    L_0x00af:
        r11 = 0;
    L_0x00b0:
        r6 = new com.google.android.gms.internal.zzajv;	 Catch:{ all -> 0x0253 }
        r9 = r1.f17415v;	 Catch:{ all -> 0x0253 }
        r6.<init>(r9);	 Catch:{ all -> 0x0253 }
        r6.m5359a(r15, r11);	 Catch:{ all -> 0x0253 }
        r9 = r15.getResponseCode();	 Catch:{ all -> 0x0253 }
        r11 = r15.getHeaderFields();	 Catch:{ all -> 0x0253 }
        r6.m5358a(r15, r9);	 Catch:{ all -> 0x0253 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x01d3;
    L_0x00cb:
        if (r9 >= r1) goto L_0x01d3;
    L_0x00cd:
        r1 = r8.toString();	 Catch:{ all -> 0x0253 }
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x01cb }
        r8 = r15.getInputStream();	 Catch:{ all -> 0x01cb }
        r4.<init>(r8);	 Catch:{ all -> 0x01cb }
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x01c7 }
        r8 = com.google.android.gms.internal.zzahn.m5161a(r4);	 Catch:{ all -> 0x01c7 }
        com.google.android.gms.common.util.zzn.m4907a(r4);	 Catch:{ all -> 0x0253 }
        r6.m5356a(r8);	 Catch:{ all -> 0x0253 }
        m17721a(r1, r11, r8, r9);	 Catch:{ all -> 0x0253 }
        r7.f6125c = r8;	 Catch:{ all -> 0x0253 }
        r7.m5003a(r11);	 Catch:{ all -> 0x0253 }
        if (r3 == 0) goto L_0x00fa;
    L_0x00f1:
        r1 = "ufe";
        r1 = new java.lang.String[]{r1};	 Catch:{ all -> 0x0063 }
        r3.m6506a(r5, r1);	 Catch:{ all -> 0x0063 }
    L_0x00fa:
        r1 = r2.f6158j;	 Catch:{ all -> 0x0253 }
        r2 = new com.google.android.gms.internal.zzaax;	 Catch:{ all -> 0x0253 }
        r11 = r7.f6121I;	 Catch:{ all -> 0x0253 }
        r12 = r7.f6124b;	 Catch:{ all -> 0x0253 }
        r13 = r7.f6125c;	 Catch:{ all -> 0x0253 }
        r14 = r7.f6126d;	 Catch:{ all -> 0x0253 }
        r3 = r7.f6130h;	 Catch:{ all -> 0x0253 }
        r4 = r7.f6131i;	 Catch:{ all -> 0x0253 }
        r6 = r7.f6132j;	 Catch:{ all -> 0x0253 }
        r8 = r7.f6133k;	 Catch:{ all -> 0x0253 }
        r9 = r7.f6134l;	 Catch:{ all -> 0x0253 }
        r51 = r9;
        r9 = r7.f6135m;	 Catch:{ all -> 0x0253 }
        r10 = r7.f6123a;	 Catch:{ all -> 0x0253 }
        r53 = r9;
        r9 = r7.f6128f;	 Catch:{ all -> 0x0253 }
        r54 = r9;
        r9 = r7.f6129g;	 Catch:{ all -> 0x0253 }
        r55 = r9;
        r9 = r7.f6136n;	 Catch:{ all -> 0x0253 }
        r56 = r9;
        r9 = r7.f6137o;	 Catch:{ all -> 0x0253 }
        r57 = r9;
        r9 = r7.f6138p;	 Catch:{ all -> 0x0253 }
        r58 = r9;
        r9 = r7.f6139q;	 Catch:{ all -> 0x0253 }
        r59 = r9;
        r9 = r7.f6141s;	 Catch:{ all -> 0x0253 }
        r60 = r9;
        r9 = r7.f6142t;	 Catch:{ all -> 0x0253 }
        r61 = r9;
        r9 = r7.f6143u;	 Catch:{ all -> 0x0253 }
        r62 = r9;
        r9 = r7.f6144v;	 Catch:{ all -> 0x0253 }
        r63 = r9;
        r9 = r7.f6145w;	 Catch:{ all -> 0x0253 }
        r64 = r9;
        r9 = r7.f6146x;	 Catch:{ all -> 0x0253 }
        r65 = r9;
        r9 = r7.f6147y;	 Catch:{ all -> 0x0253 }
        r66 = r9;
        r9 = r7.f6148z;	 Catch:{ all -> 0x0253 }
        r67 = r9;
        r9 = r7.f6113A;	 Catch:{ all -> 0x0253 }
        r68 = r9;
        r9 = r7.f6114B;	 Catch:{ all -> 0x0253 }
        r69 = r9;
        r9 = r7.f6115C;	 Catch:{ all -> 0x0253 }
        r70 = r9;
        r9 = r7.f6116D;	 Catch:{ all -> 0x0253 }
        r71 = r9;
        r9 = r7.f6117E;	 Catch:{ all -> 0x0253 }
        r72 = r9;
        r9 = r7.f6118F;	 Catch:{ all -> 0x0253 }
        r73 = r9;
        r9 = r7.f6127e;	 Catch:{ all -> 0x0253 }
        r74 = r9;
        r9 = r7.f6140r;	 Catch:{ all -> 0x0253 }
        r75 = r9;
        r9 = r7.f6119G;	 Catch:{ all -> 0x0253 }
        r7 = r7.f6120H;	 Catch:{ all -> 0x0253 }
        if (r1 == 0) goto L_0x017c;
    L_0x0176:
        r1 = r10;
        r20 = r51;
        r50 = 2;
        goto L_0x0181;
    L_0x017c:
        r1 = r10;
        r20 = r51;
        r50 = 1;
    L_0x0181:
        r10 = r2;
        r76 = r2;
        r2 = r15;
        r15 = r3;
        r16 = r4;
        r18 = r6;
        r19 = r8;
        r22 = r53;
        r23 = r1;
        r26 = r54;
        r27 = r55;
        r28 = r56;
        r29 = r57;
        r30 = r58;
        r31 = r59;
        r32 = r60;
        r33 = r61;
        r34 = r62;
        r35 = r63;
        r36 = r64;
        r37 = r65;
        r38 = r66;
        r39 = r67;
        r40 = r68;
        r41 = r69;
        r42 = r70;
        r43 = r71;
        r44 = r72;
        r45 = r73;
        r46 = r74;
        r47 = r75;
        r48 = r9;
        r49 = r7;
        r10.<init>(r11, r12, r13, r14, r15, r16, r18, r19, r20, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50);	 Catch:{ all -> 0x0251 }
        r2.disconnect();	 Catch:{ IOException -> 0x025a }
        return r76;
    L_0x01c7:
        r0 = move-exception;
        r2 = r15;
        r1 = r0;
        goto L_0x01cf;
    L_0x01cb:
        r0 = move-exception;
        r2 = r15;
        r1 = r0;
        r4 = 0;
    L_0x01cf:
        com.google.android.gms.common.util.zzn.m4907a(r4);	 Catch:{ all -> 0x0251 }
        throw r1;	 Catch:{ all -> 0x0251 }
    L_0x01d3:
        r2 = r15;
        r4 = r8.toString();	 Catch:{ all -> 0x0251 }
        r6 = 0;
        m17721a(r4, r11, r6, r9);	 Catch:{ all -> 0x0251 }
        if (r9 < r1) goto L_0x0231;
    L_0x01de:
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r1) goto L_0x0231;
    L_0x01e2:
        r1 = "Location";
        r1 = r2.getHeaderField(r1);	 Catch:{ all -> 0x0251 }
        r4 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0251 }
        if (r4 == 0) goto L_0x01fd;
    L_0x01ee:
        r1 = "No location header to follow redirect.";
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ all -> 0x0251 }
        r1 = new com.google.android.gms.internal.zzaax;	 Catch:{ all -> 0x0251 }
        r3 = 0;
        r1.<init>(r3);	 Catch:{ all -> 0x0251 }
        r2.disconnect();	 Catch:{ IOException -> 0x025a }
        return r1;
    L_0x01fd:
        r8 = new java.net.URL;	 Catch:{ all -> 0x0251 }
        r8.<init>(r1);	 Catch:{ all -> 0x0251 }
        r1 = 1;
        r10 = r10 + r1;
        r1 = com.google.android.gms.internal.zznh.cL;	 Catch:{ all -> 0x0251 }
        r4 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0251 }
        r1 = r4.m6488a(r1);	 Catch:{ all -> 0x0251 }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x0251 }
        r1 = r1.intValue();	 Catch:{ all -> 0x0251 }
        if (r10 <= r1) goto L_0x0225;
    L_0x0216:
        r1 = "Too many redirects.";
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ all -> 0x0251 }
        r1 = new com.google.android.gms.internal.zzaax;	 Catch:{ all -> 0x0251 }
        r3 = 0;
        r1.<init>(r3);	 Catch:{ all -> 0x0251 }
        r2.disconnect();	 Catch:{ IOException -> 0x025a }
        return r1;
    L_0x0225:
        r7.m5003a(r11);	 Catch:{ all -> 0x0251 }
        r2.disconnect();	 Catch:{ IOException -> 0x025a }
        r2 = r82;
        r1 = r77;
        goto L_0x003f;
    L_0x0231:
        r1 = 46;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0251 }
        r3.<init>(r1);	 Catch:{ all -> 0x0251 }
        r1 = "Received error HTTP response code: ";
        r3.append(r1);	 Catch:{ all -> 0x0251 }
        r3.append(r9);	 Catch:{ all -> 0x0251 }
        r1 = r3.toString();	 Catch:{ all -> 0x0251 }
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ all -> 0x0251 }
        r1 = new com.google.android.gms.internal.zzaax;	 Catch:{ all -> 0x0251 }
        r3 = 0;
        r1.<init>(r3);	 Catch:{ all -> 0x0251 }
        r2.disconnect();	 Catch:{ IOException -> 0x025a }
        return r1;
    L_0x0251:
        r0 = move-exception;
        goto L_0x0255;
    L_0x0253:
        r0 = move-exception;
        r2 = r15;
    L_0x0255:
        r1 = r0;
    L_0x0256:
        r2.disconnect();	 Catch:{ IOException -> 0x025a }
        throw r1;	 Catch:{ IOException -> 0x025a }
    L_0x025a:
        r0 = move-exception;
        r1 = r0;
        r2 = "Error while connecting to ad server: ";
        r1 = r1.getMessage();
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0271;
    L_0x026c:
        r1 = r2.concat(r1);
        goto L_0x0276;
    L_0x0271:
        r1 = new java.lang.String;
        r1.<init>(r2);
    L_0x0276:
        com.google.android.gms.internal.zzakb.m5371e(r1);
        r1 = new com.google.android.gms.internal.zzaax;
        r2 = 2;
        r1.<init>(r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacb.a(com.google.android.gms.internal.zzaat, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzacn, com.google.android.gms.internal.zznu, com.google.android.gms.internal.zzaca):com.google.android.gms.internal.zzaax");
    }

    public final void mo1651a(zzaat com_google_android_gms_internal_zzaat, zzabe com_google_android_gms_internal_zzabe) {
        zzbs.m4490i().m13243a(this.f17497c, com_google_android_gms_internal_zzaat.f17404k);
        com_google_android_gms_internal_zzaat = zzahh.m5148a(new zzacd(this, com_google_android_gms_internal_zzaat, com_google_android_gms_internal_zzabe));
        zzbs.m4500s().m5300a();
        zzbs.m4500s().f6443a.postDelayed(new zzace(com_google_android_gms_internal_zzaat), 60000);
    }
}
