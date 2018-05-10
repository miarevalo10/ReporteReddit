package io.branch.indexing;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentDiscoveryManifest {
    private static ContentDiscoveryManifest f24461i;
    public JSONObject f24462a;
    public String f24463b;
    public int f24464c = 0;
    public int f24465d = 1;
    public int f24466e = 0;
    public boolean f24467f = false;
    public JSONArray f24468g;
    public SharedPreferences f24469h;
    private final String f24470j = "BNC_CD_MANIFEST";

    class CDPathProperties {
        final JSONObject f24456a;
        boolean f24457b;
        int f24458c;
        int f24459d = 15;
        final /* synthetic */ ContentDiscoveryManifest f24460e;

        CDPathProperties(ContentDiscoveryManifest contentDiscoveryManifest, JSONObject jSONObject) {
            this.f24460e = contentDiscoveryManifest;
            this.f24456a = jSONObject;
            if (jSONObject.has("h") != null) {
                try {
                    this.f24457b = jSONObject.getBoolean("h") ^ 1;
                } catch (ContentDiscoveryManifest contentDiscoveryManifest2) {
                    contentDiscoveryManifest2.printStackTrace();
                }
            }
            try {
                if (jSONObject.has("dri") != null) {
                    this.f24458c = jSONObject.getInt("dri");
                }
                if (jSONObject.has("mdr") != null) {
                    this.f24459d = jSONObject.getInt("mdr");
                }
            } catch (ContentDiscoveryManifest contentDiscoveryManifest22) {
                contentDiscoveryManifest22.printStackTrace();
            }
        }

        final JSONArray m26088a() {
            if (this.f24456a.has("ck")) {
                try {
                    return this.f24456a.getJSONArray("ck");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    private ContentDiscoveryManifest(android.content.Context r3) {
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
        r2 = this;
        r2.<init>();
        r0 = 0;
        r2.f24464c = r0;
        r1 = 1;
        r2.f24465d = r1;
        r2.f24466e = r0;
        r2.f24467f = r0;
        r1 = "BNC_CD_MANIFEST";
        r2.f24470j = r1;
        r1 = "bnc_content_discovery_manifest_storage";
        r3 = r3.getSharedPreferences(r1, r0);
        r2.f24469h = r3;
        r3 = r2.f24469h;
        r0 = "BNC_CD_MANIFEST";
        r1 = 0;
        r3 = r3.getString(r0, r1);
        if (r3 == 0) goto L_0x005c;
    L_0x0024:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0054 }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x0054 }
        r2.f24462a = r0;	 Catch:{ JSONException -> 0x0054 }
        r3 = r2.f24462a;	 Catch:{ JSONException -> 0x0054 }
        r0 = "mv";	 Catch:{ JSONException -> 0x0054 }
        r3 = r3.has(r0);	 Catch:{ JSONException -> 0x0054 }
        if (r3 == 0) goto L_0x003f;	 Catch:{ JSONException -> 0x0054 }
    L_0x0035:
        r3 = r2.f24462a;	 Catch:{ JSONException -> 0x0054 }
        r0 = "mv";	 Catch:{ JSONException -> 0x0054 }
        r3 = r3.getString(r0);	 Catch:{ JSONException -> 0x0054 }
        r2.f24463b = r3;	 Catch:{ JSONException -> 0x0054 }
    L_0x003f:
        r3 = r2.f24462a;	 Catch:{ JSONException -> 0x0054 }
        r0 = "m";	 Catch:{ JSONException -> 0x0054 }
        r3 = r3.has(r0);	 Catch:{ JSONException -> 0x0054 }
        if (r3 == 0) goto L_0x0053;	 Catch:{ JSONException -> 0x0054 }
    L_0x0049:
        r3 = r2.f24462a;	 Catch:{ JSONException -> 0x0054 }
        r0 = "m";	 Catch:{ JSONException -> 0x0054 }
        r3 = r3.getJSONArray(r0);	 Catch:{ JSONException -> 0x0054 }
        r2.f24468g = r3;	 Catch:{ JSONException -> 0x0054 }
    L_0x0053:
        return;
    L_0x0054:
        r3 = new org.json.JSONObject;
        r3.<init>();
        r2.f24462a = r3;
        return;
    L_0x005c:
        r3 = new org.json.JSONObject;
        r3.<init>();
        r2.f24462a = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.ContentDiscoveryManifest.<init>(android.content.Context):void");
    }

    public static ContentDiscoveryManifest m26089a(Context context) {
        if (f24461i == null) {
            f24461i = new ContentDiscoveryManifest(context);
        }
        return f24461i;
    }

    final io.branch.indexing.ContentDiscoveryManifest.CDPathProperties m26090a(android.app.Activity r4) {
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
        r3 = this;
        r0 = r3.f24468g;
        if (r0 == 0) goto L_0x0046;
    L_0x0004:
        r0 = new java.lang.StringBuilder;
        r1 = "/";
        r0.<init>(r1);
        r4 = r4.getClass();
        r4 = r4.getSimpleName();
        r0.append(r4);
        r4 = r0.toString();
        r0 = 0;
    L_0x001b:
        r1 = r3.f24468g;	 Catch:{ JSONException -> 0x0046 }
        r1 = r1.length();	 Catch:{ JSONException -> 0x0046 }
        if (r0 >= r1) goto L_0x0046;	 Catch:{ JSONException -> 0x0046 }
    L_0x0023:
        r1 = r3.f24468g;	 Catch:{ JSONException -> 0x0046 }
        r1 = r1.getJSONObject(r0);	 Catch:{ JSONException -> 0x0046 }
        r2 = "p";	 Catch:{ JSONException -> 0x0046 }
        r2 = r1.has(r2);	 Catch:{ JSONException -> 0x0046 }
        if (r2 == 0) goto L_0x0043;	 Catch:{ JSONException -> 0x0046 }
    L_0x0031:
        r2 = "p";	 Catch:{ JSONException -> 0x0046 }
        r2 = r1.getString(r2);	 Catch:{ JSONException -> 0x0046 }
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x0046 }
        if (r2 == 0) goto L_0x0043;	 Catch:{ JSONException -> 0x0046 }
    L_0x003d:
        r4 = new io.branch.indexing.ContentDiscoveryManifest$CDPathProperties;	 Catch:{ JSONException -> 0x0046 }
        r4.<init>(r3, r1);	 Catch:{ JSONException -> 0x0046 }
        goto L_0x0047;
    L_0x0043:
        r0 = r0 + 1;
        goto L_0x001b;
    L_0x0046:
        r4 = 0;
    L_0x0047:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.ContentDiscoveryManifest.a(android.app.Activity):io.branch.indexing.ContentDiscoveryManifest$CDPathProperties");
    }

    public final String m26091a() {
        if (TextUtils.isEmpty(this.f24463b)) {
            return "-1";
        }
        return this.f24463b;
    }
}
