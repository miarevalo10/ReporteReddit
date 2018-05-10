package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zzacl {
    boolean f6113A = false;
    String f6114B;
    List<String> f6115C;
    boolean f6116D;
    String f6117E;
    zzaey f6118F;
    boolean f6119G;
    boolean f6120H;
    final zzaat f6121I;
    private final long f6122J = -1;
    String f6123a;
    String f6124b;
    String f6125c;
    List<String> f6126d;
    String f6127e;
    String f6128f;
    String f6129g;
    List<String> f6130h;
    long f6131i = -1;
    boolean f6132j = false;
    List<String> f6133k;
    long f6134l = -1;
    int f6135m = -1;
    boolean f6136n = false;
    boolean f6137o = false;
    boolean f6138p = false;
    boolean f6139q = true;
    boolean f6140r = true;
    String f6141s = "";
    boolean f6142t = false;
    boolean f6143u = false;
    zzaeq f6144v;
    List<String> f6145w;
    List<String> f6146x;
    boolean f6147y = false;
    zzaaz f6148z;

    public zzacl(zzaat com_google_android_gms_internal_zzaat, String str) {
        this.f6124b = str;
        this.f6121I = com_google_android_gms_internal_zzaat;
    }

    private static String m4999a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static long m5000b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2, java.lang.String r3) {
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
        r2 = r2.get(r3);
        r2 = (java.util.List) r2;
        if (r2 == 0) goto L_0x004e;
    L_0x0008:
        r0 = r2.isEmpty();
        if (r0 != 0) goto L_0x004e;
    L_0x000e:
        r0 = 0;
        r2 = r2.get(r0);
        r2 = (java.lang.String) r2;
        r0 = java.lang.Float.parseFloat(r2);	 Catch:{ NumberFormatException -> 0x001e }
        r2 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r0 = r0 * r2;
        r2 = (long) r0;
        return r2;
    L_0x001e:
        r0 = 36;
        r1 = java.lang.String.valueOf(r3);
        r1 = r1.length();
        r0 = r0 + r1;
        r1 = java.lang.String.valueOf(r2);
        r1 = r1.length();
        r0 = r0 + r1;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Could not parse float from ";
        r1.append(r0);
        r1.append(r3);
        r3 = " header: ";
        r1.append(r3);
        r1.append(r2);
        r2 = r1.toString();
        com.google.android.gms.internal.zzakb.m5371e(r2);
    L_0x004e:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacl.b(java.util.Map, java.lang.String):long");
    }

    private static List<String> m5001c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private static boolean m5002d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? false : Boolean.valueOf((String) list.get(0)).booleanValue();
    }

    public final void m5003a(Map<String, List<String>> map) {
        String str;
        this.f6123a = m4999a(map, "X-Afma-Ad-Size");
        this.f6117E = m4999a(map, "X-Afma-Ad-Slot-Size");
        List c = m5001c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f6126d = c;
        }
        this.f6127e = m4999a(map, "X-Afma-Debug-Signals");
        c = (List) map.get("X-Afma-Debug-Dialog");
        if (!(c == null || c.isEmpty())) {
            this.f6128f = (String) c.get(0);
        }
        c = m5001c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f6130h = c;
        }
        long b = m5000b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f6131i = b;
        }
        this.f6132j |= m5002d(map, "X-Afma-Mediation");
        c = m5001c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f6133k = c;
        }
        b = m5000b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f6134l = b;
        }
        c = (List) map.get("X-Afma-Orientation");
        if (!(c == null || c.isEmpty())) {
            int b2;
            str = (String) c.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                b2 = zzbs.m4488g().mo1722b();
            } else if ("landscape".equalsIgnoreCase(str)) {
                b2 = zzbs.m4488g().mo1720a();
            }
            this.f6135m = b2;
        }
        this.f6129g = m4999a(map, "X-Afma-ActiveView");
        c = (List) map.get("X-Afma-Use-HTTPS");
        if (!(c == null || c.isEmpty())) {
            this.f6138p = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        this.f6136n |= m5002d(map, "X-Afma-Custom-Rendering-Allowed");
        this.f6137o = "native".equals(m4999a(map, "X-Afma-Ad-Format"));
        c = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (!(c == null || c.isEmpty())) {
            this.f6139q = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        c = (List) map.get("X-Afma-Content-Vertical-Opted-Out");
        if (!(c == null || c.isEmpty())) {
            this.f6140r = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        c = (List) map.get("X-Afma-Gws-Query-Id");
        if (!(c == null || c.isEmpty())) {
            this.f6141s = (String) c.get(0);
        }
        str = m4999a(map, "X-Afma-Fluid");
        if (str != null && str.equals("height")) {
            this.f6142t = true;
        }
        this.f6143u = "native_express".equals(m4999a(map, "X-Afma-Ad-Format"));
        this.f6144v = zzaeq.m17777a(m4999a(map, "X-Afma-Rewards"));
        if (this.f6145w == null) {
            this.f6145w = m5001c(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.f6146x == null) {
            this.f6146x = m5001c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.f6147y |= m5002d(map, "X-Afma-Use-Displayed-Impression");
        this.f6113A |= m5002d(map, "X-Afma-Auto-Collect-Location");
        this.f6114B = m4999a(map, "Set-Cookie");
        Object a = m4999a(map, "X-Afma-Auto-Protection-Configuration");
        if (a != null) {
            if (!TextUtils.isEmpty(a)) {
                try {
                    this.f6148z = zzaaz.m17702a(new JSONObject(a));
                } catch (Throwable e) {
                    zzakb.m5369c("Error parsing configuration JSON", e);
                    this.f6148z = new zzaaz();
                }
                c = m5001c(map, "X-Afma-Remote-Ping-Urls");
                if (c != null) {
                    this.f6115C = c;
                }
                a = m4999a(map, "X-Afma-Safe-Browsing");
                if (!TextUtils.isEmpty(a)) {
                    try {
                        this.f6118F = zzaey.m17779a(new JSONObject(a));
                    } catch (Throwable e2) {
                        zzakb.m5369c("Error parsing safe browsing header", e2);
                    }
                }
                this.f6116D |= m5002d(map, "X-Afma-Render-In-Browser");
                a = m4999a(map, "X-Afma-Pool");
                if (!TextUtils.isEmpty(a)) {
                    try {
                        this.f6119G = new JSONObject(a).getBoolean("never_pool");
                    } catch (Throwable e22) {
                        zzakb.m5369c("Error parsing interstitial pool header", e22);
                    }
                }
                this.f6120H = m5002d(map, "X-Afma-Custom-Close-Blocked");
            }
        }
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
        buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
        if (!TextUtils.isEmpty(this.f6128f)) {
            buildUpon.appendQueryParameter("debugDialog", this.f6128f);
        }
        boolean booleanValue = ((Boolean) zzkb.m6350f().m6488a(zznh.f7896e)).booleanValue();
        String[] strArr = new String[1];
        str = buildUpon.toString();
        String str2 = "navigationURL";
        StringBuilder stringBuilder = new StringBuilder((18 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(str2);
        stringBuilder.append("={NAVIGATION_URL}");
        strArr[0] = stringBuilder.toString();
        this.f6148z = new zzaaz(booleanValue, Arrays.asList(strArr));
        c = m5001c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.f6115C = c;
        }
        a = m4999a(map, "X-Afma-Safe-Browsing");
        if (TextUtils.isEmpty(a)) {
            this.f6118F = zzaey.m17779a(new JSONObject(a));
        }
        this.f6116D |= m5002d(map, "X-Afma-Render-In-Browser");
        a = m4999a(map, "X-Afma-Pool");
        if (TextUtils.isEmpty(a)) {
            this.f6119G = new JSONObject(a).getBoolean("never_pool");
        }
        this.f6120H = m5002d(map, "X-Afma-Custom-Close-Blocked");
    }
}
