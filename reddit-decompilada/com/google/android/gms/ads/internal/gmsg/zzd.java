package com.google.android.gms.ads.internal.gmsg;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.js.zza;
import com.google.android.gms.internal.zzajh;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzamp;
import com.google.android.gms.internal.zzamv;
import com.google.android.gms.internal.zzamw;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzaog;
import com.google.android.gms.internal.zzaox;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;
import java.util.Map;

@zzzv
public final class zzd {
    public static final zzt<zzanh> f5426a = zze.f13731a;
    public static final zzt<zzanh> f5427b = zzf.f13732a;
    public static final zzt<zzanh> f5428c = zzg.f13733a;
    public static final zzt<zzanh> f5429d = new zzl();
    public static final zzt<zzanh> f5430e = new zzm();
    public static final zzt<zzanh> f5431f = zzh.f13734a;
    public static final zzt<Object> f5432g = new zzn();
    public static final zzt<zzanh> f5433h = new zzo();
    public static final zzt<zzanh> f5434i = zzi.f13735a;
    public static final zzt<zzanh> f5435j = new zzp();
    public static final zzt<zzanh> f5436k = new zzq();
    public static final zzt<zzamp> f5437l = new zzamv();
    public static final zzt<zzamp> f5438m = new zzamw();
    public static final zzt<zzanh> f5439n = new zzc();
    public static final zzad f5440o = new zzad();
    public static final zzt<zzanh> f5441p = new zzr();
    public static final zzt<zzanh> f5442q = new zzs();
    public static final zzt<zzanh> f5443r = new zzk();
    private static zzt<Object> f5444s = new zzj();

    static final /* synthetic */ void m4425a(com.google.android.gms.ads.internal.js.zza r5, java.util.Map r6) {
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
        r0 = "u";
        r6 = r6.get(r0);
        r6 = (java.lang.String) r6;
        if (r6 != 0) goto L_0x0010;
    L_0x000a:
        r5 = "URL missing from click GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r5);
        return;
    L_0x0010:
        r0 = android.net.Uri.parse(r6);
        r1 = r5;	 Catch:{ zzcw -> 0x0040 }
        r1 = (com.google.android.gms.internal.zzaow) r1;	 Catch:{ zzcw -> 0x0040 }
        r1 = r1.mo3475y();	 Catch:{ zzcw -> 0x0040 }
        if (r1 == 0) goto L_0x0059;	 Catch:{ zzcw -> 0x0040 }
    L_0x001d:
        r2 = r1.m5821a(r0);	 Catch:{ zzcw -> 0x0040 }
        if (r2 == 0) goto L_0x0059;	 Catch:{ zzcw -> 0x0040 }
    L_0x0023:
        r2 = r5;	 Catch:{ zzcw -> 0x0040 }
        r2 = (com.google.android.gms.internal.zzaog) r2;	 Catch:{ zzcw -> 0x0040 }
        r2 = r2.getContext();	 Catch:{ zzcw -> 0x0040 }
        r3 = r5;	 Catch:{ zzcw -> 0x0040 }
        r3 = (com.google.android.gms.internal.zzaoy) r3;	 Catch:{ zzcw -> 0x0040 }
        if (r3 != 0) goto L_0x0031;	 Catch:{ zzcw -> 0x0040 }
    L_0x002f:
        r1 = 0;	 Catch:{ zzcw -> 0x0040 }
        throw r1;	 Catch:{ zzcw -> 0x0040 }
    L_0x0031:
        r3 = (android.view.View) r3;	 Catch:{ zzcw -> 0x0040 }
        r4 = r5;	 Catch:{ zzcw -> 0x0040 }
        r4 = (com.google.android.gms.internal.zzaog) r4;	 Catch:{ zzcw -> 0x0040 }
        r4 = r4.mo3467d();	 Catch:{ zzcw -> 0x0040 }
        r1 = r1.m5818a(r0, r2, r3, r4);	 Catch:{ zzcw -> 0x0040 }
        r0 = r1;
        goto L_0x0059;
    L_0x0040:
        r1 = "Unable to append parameter to URL: ";
        r6 = java.lang.String.valueOf(r6);
        r2 = r6.length();
        if (r2 == 0) goto L_0x0051;
    L_0x004c:
        r6 = r1.concat(r6);
        goto L_0x0056;
    L_0x0051:
        r6 = new java.lang.String;
        r6.<init>(r1);
    L_0x0056:
        com.google.android.gms.internal.zzakb.m5371e(r6);
    L_0x0059:
        r6 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r1 = r5;
        r1 = (com.google.android.gms.internal.zzaog) r1;
        r2 = r1.getContext();
        r3 = com.google.android.gms.internal.zznh.am;
        r4 = com.google.android.gms.internal.zzkb.m6350f();
        r3 = r4.m6488a(r3);
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x007e;
    L_0x0076:
        r6 = r6.m5090a(r2);
        if (r6 == 0) goto L_0x007e;
    L_0x007c:
        r6 = 1;
        goto L_0x007f;
    L_0x007e:
        r6 = 0;
    L_0x007f:
        if (r6 == 0) goto L_0x00b1;
    L_0x0081:
        r6 = "fbs_aeid";
        r6 = r0.getQueryParameter(r6);
        r6 = android.text.TextUtils.isEmpty(r6);
        if (r6 == 0) goto L_0x00b1;
    L_0x008d:
        r6 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r2 = r1.getContext();
        r6 = r6.m5104i(r2);
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r2 = "fbs_aeid";
        r0 = r0.toString();
        r0 = com.google.android.gms.internal.zzahn.m5152a(r0, r2, r6);
        r2 = com.google.android.gms.ads.internal.zzbs.m4507z();
        r3 = r1.getContext();
        r2.m5087a(r3, r6);
    L_0x00b1:
        r6 = r0.toString();
        r0 = new com.google.android.gms.internal.zzajh;
        r1 = r1.getContext();
        r5 = (com.google.android.gms.internal.zzaox) r5;
        r5 = r5.mo3472k();
        r5 = r5.f17551a;
        r0.<init>(r1, r5, r6);
        r0.m13277h();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzd.a(com.google.android.gms.ads.internal.js.zza, java.util.Map):void");
    }

    static final /* synthetic */ void m4426a(zzaog com_google_android_gms_internal_zzaog, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzakb.m5371e("URL missing from httpTrack GMSG.");
        } else {
            new zzajh(com_google_android_gms_internal_zzaog.getContext(), ((zzaox) com_google_android_gms_internal_zzaog).mo3472k().f17551a, str).m13277h();
        }
    }

    static final /* synthetic */ void m4428b(com.google.android.gms.internal.zzaog r17, java.util.Map r18) {
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
        r2 = r17.getContext();
        r2 = r2.getPackageManager();
        r3 = "data";
        r4 = r18;
        r3 = r4.get(r3);
        r3 = (java.lang.String) r3;
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x010a }
        r4.<init>(r3);	 Catch:{ JSONException -> 0x010a }
        r3 = "intents";	 Catch:{ JSONException -> 0x00fb }
        r3 = r4.getJSONArray(r3);	 Catch:{ JSONException -> 0x00fb }
        r4 = new org.json.JSONObject;
        r4.<init>();
        r5 = 0;
        r6 = r5;
    L_0x0024:
        r7 = r3.length();
        if (r6 >= r7) goto L_0x00f1;
    L_0x002a:
        r7 = r3.getJSONObject(r6);	 Catch:{ JSONException -> 0x00e7 }
        r8 = "id";
        r8 = r7.optString(r8);
        r9 = "u";
        r9 = r7.optString(r9);
        r10 = "i";
        r10 = r7.optString(r10);
        r11 = "m";
        r11 = r7.optString(r11);
        r12 = "p";
        r12 = r7.optString(r12);
        r13 = "c";
        r13 = r7.optString(r13);
        r14 = "f";
        r7.optString(r14);
        r14 = "e";
        r7.optString(r14);
        r14 = "intent_url";
        r7 = r7.optString(r14);
        r14 = 0;
        r15 = android.text.TextUtils.isEmpty(r7);
        if (r15 != 0) goto L_0x0089;
    L_0x0069:
        r15 = android.content.Intent.parseUri(r7, r5);	 Catch:{ URISyntaxException -> 0x006f }
        r14 = r15;
        goto L_0x0089;
    L_0x006f:
        r0 = move-exception;
        r15 = "Error parsing the url: ";
        r7 = java.lang.String.valueOf(r7);
        r16 = r7.length();
        if (r16 == 0) goto L_0x0081;
    L_0x007c:
        r7 = r15.concat(r7);
        goto L_0x0086;
    L_0x0081:
        r7 = new java.lang.String;
        r7.<init>(r15);
    L_0x0086:
        com.google.android.gms.internal.zzakb.m5367b(r7, r0);
    L_0x0089:
        r7 = 1;
        if (r14 != 0) goto L_0x00d5;
    L_0x008c:
        r14 = new android.content.Intent;
        r14.<init>();
        r15 = android.text.TextUtils.isEmpty(r9);
        if (r15 != 0) goto L_0x009e;
    L_0x0097:
        r9 = android.net.Uri.parse(r9);
        r14.setData(r9);
    L_0x009e:
        r9 = android.text.TextUtils.isEmpty(r10);
        if (r9 != 0) goto L_0x00a7;
    L_0x00a4:
        r14.setAction(r10);
    L_0x00a7:
        r9 = android.text.TextUtils.isEmpty(r11);
        if (r9 != 0) goto L_0x00b0;
    L_0x00ad:
        r14.setType(r11);
    L_0x00b0:
        r9 = android.text.TextUtils.isEmpty(r12);
        if (r9 != 0) goto L_0x00b9;
    L_0x00b6:
        r14.setPackage(r12);
    L_0x00b9:
        r9 = android.text.TextUtils.isEmpty(r13);
        if (r9 != 0) goto L_0x00d5;
    L_0x00bf:
        r9 = "/";
        r10 = 2;
        r9 = r13.split(r9, r10);
        r11 = r9.length;
        if (r11 != r10) goto L_0x00d5;
    L_0x00c9:
        r10 = new android.content.ComponentName;
        r11 = r9[r5];
        r9 = r9[r7];
        r10.<init>(r11, r9);
        r14.setComponent(r10);
    L_0x00d5:
        r9 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r9 = r2.resolveActivity(r14, r9);
        if (r9 == 0) goto L_0x00de;
    L_0x00dd:
        goto L_0x00df;
    L_0x00de:
        r7 = r5;
    L_0x00df:
        r4.put(r8, r7);	 Catch:{ JSONException -> 0x00e3 }
        goto L_0x00ed;
    L_0x00e3:
        r0 = move-exception;
        r7 = "Error constructing openable urls response.";
        goto L_0x00ea;
    L_0x00e7:
        r0 = move-exception;
        r7 = "Error parsing the intent data.";
    L_0x00ea:
        com.google.android.gms.internal.zzakb.m5367b(r7, r0);
    L_0x00ed:
        r6 = r6 + 1;
        goto L_0x0024;
    L_0x00f1:
        r1 = r17;
        r1 = (com.google.android.gms.ads.internal.js.zza) r1;
        r2 = "openableIntents";
        r1.mo3463a(r2, r4);
        return;
    L_0x00fb:
        r1 = r17;
        r1 = (com.google.android.gms.ads.internal.js.zza) r1;
        r2 = "openableIntents";
        r3 = new org.json.JSONObject;
        r3.<init>();
        r1.mo3463a(r2, r3);
        return;
    L_0x010a:
        r1 = r17;
        r1 = (com.google.android.gms.ads.internal.js.zza) r1;
        r2 = "openableIntents";
        r3 = new org.json.JSONObject;
        r3.<init>();
        r1.mo3463a(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzd.b(com.google.android.gms.internal.zzaog, java.util.Map):void");
    }

    static final /* synthetic */ void m4429c(zzaog com_google_android_gms_internal_zzaog, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzakb.m5371e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        Map hashMap = new HashMap();
        PackageManager packageManager = com_google_android_gms_internal_zzaog.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zza) com_google_android_gms_internal_zzaog).mo3462a("openableURLs", hashMap);
    }

    static final /* synthetic */ void m4427a(com.google.android.gms.internal.zzaow r3, java.util.Map r4) {
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
        r0 = "tx";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r1 = "ty";
        r1 = r4.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "td";
        r4 = r4.get(r2);
        r4 = (java.lang.String) r4;
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0030 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x0030 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0030 }
        r3 = r3.mo3475y();	 Catch:{ NumberFormatException -> 0x0030 }
        if (r3 == 0) goto L_0x002f;	 Catch:{ NumberFormatException -> 0x0030 }
    L_0x002a:
        r3 = r3.f7187b;	 Catch:{ NumberFormatException -> 0x0030 }
        r3.mo1520a(r0, r1, r4);	 Catch:{ NumberFormatException -> 0x0030 }
    L_0x002f:
        return;
    L_0x0030:
        r3 = "Could not parse touch parameters from gmsg.";
        com.google.android.gms.internal.zzakb.m5371e(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzd.a(com.google.android.gms.internal.zzaow, java.util.Map):void");
    }
}
