package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzuq {
    private static String m6684a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public static List<String> m6685a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void m6686a(Context context, String str, zzafo com_google_android_gms_internal_zzafo, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String a : list) {
                String a2 = m6684a(m6684a(m6684a(m6684a(m6684a(m6684a(m6684a(a2, "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", com_google_android_gms_internal_zzafo.f6304q.f8072h), "@gw_sdkver@", str), "@gw_sessid@", zzkb.m6347c()), "@gw_seqnum@", com_google_android_gms_internal_zzafo.f6296i), "@gw_adnetstatus@", com_google_android_gms_internal_zzafo.f6306s);
                if (com_google_android_gms_internal_zzafo.f6301n != null) {
                    a2 = m6684a(m6684a(a2, "@gw_adnetid@", com_google_android_gms_internal_zzafo.f6301n.f8047b), "@gw_allocid@", com_google_android_gms_internal_zzafo.f6301n.f8049d);
                }
                a2 = zzafi.m5105a(a2, context);
                zzbs.m4486e();
                zzahn.m5192b(context, str, a2);
            }
        }
    }

    public static void m6687a(Context context, String str, List<String> list, String str2, zzaeq com_google_android_gms_internal_zzaeq) {
        if (list != null && !list.isEmpty()) {
            long a = zzbs.m4492k().mo1632a();
            for (String a2 : list) {
                String a22 = m6684a(m6684a(a22, "@gw_rwd_userid@", str2), "@gw_tmstmp@", Long.toString(a));
                if (com_google_android_gms_internal_zzaeq != null) {
                    a22 = m6684a(m6684a(a22, "@gw_rwd_itm@", com_google_android_gms_internal_zzaeq.f17534a), "@gw_rwd_amt@", Integer.toString(com_google_android_gms_internal_zzaeq.f17535b));
                }
                zzbs.m4486e();
                zzahn.m5192b(context, str, a22);
            }
        }
    }

    public static boolean m6688a(java.lang.String r3, int[] r4) {
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
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "x";
        r3 = r3.split(r0);
        r0 = r3.length;
        r2 = 2;
        if (r0 == r2) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r0 = r3[r1];	 Catch:{ NumberFormatException -> 0x0025 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0025 }
        r4[r1] = r0;	 Catch:{ NumberFormatException -> 0x0025 }
        r0 = 1;	 Catch:{ NumberFormatException -> 0x0025 }
        r3 = r3[r0];	 Catch:{ NumberFormatException -> 0x0025 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0025 }
        r4[r0] = r3;	 Catch:{ NumberFormatException -> 0x0025 }
        return r0;
    L_0x0025:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzuq.a(java.lang.String, int[]):boolean");
    }
}
