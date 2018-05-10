package io.branch.referral;

import org.json.JSONObject;

public class ServerResponse {
    int f24664a;
    public Object f24665b;
    private String f24666c;

    public ServerResponse(String str, int i) {
        this.f24666c = str;
        this.f24664a = i;
    }

    public final JSONObject m26198a() {
        if (this.f24665b instanceof JSONObject) {
            return (JSONObject) this.f24665b;
        }
        return new JSONObject();
    }

    public final java.lang.String m26199b() {
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
        r4 = this;
        r0 = "";
        r1 = r4.m26198a();	 Catch:{ Exception -> 0x0049 }
        if (r1 == 0) goto L_0x0049;	 Catch:{ Exception -> 0x0049 }
    L_0x0008:
        r2 = "error";	 Catch:{ Exception -> 0x0049 }
        r2 = r1.has(r2);	 Catch:{ Exception -> 0x0049 }
        if (r2 == 0) goto L_0x0049;	 Catch:{ Exception -> 0x0049 }
    L_0x0010:
        r2 = "error";	 Catch:{ Exception -> 0x0049 }
        r2 = r1.getJSONObject(r2);	 Catch:{ Exception -> 0x0049 }
        r3 = "message";	 Catch:{ Exception -> 0x0049 }
        r2 = r2.has(r3);	 Catch:{ Exception -> 0x0049 }
        if (r2 == 0) goto L_0x0049;	 Catch:{ Exception -> 0x0049 }
    L_0x001e:
        r2 = "error";	 Catch:{ Exception -> 0x0049 }
        r1 = r1.getJSONObject(r2);	 Catch:{ Exception -> 0x0049 }
        r2 = "message";	 Catch:{ Exception -> 0x0049 }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0049 }
        if (r1 == 0) goto L_0x0048;
    L_0x002c:
        r0 = r1.trim();	 Catch:{ Exception -> 0x0048 }
        r0 = r0.length();	 Catch:{ Exception -> 0x0048 }
        if (r0 <= 0) goto L_0x0048;	 Catch:{ Exception -> 0x0048 }
    L_0x0036:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0048 }
        r0.<init>();	 Catch:{ Exception -> 0x0048 }
        r0.append(r1);	 Catch:{ Exception -> 0x0048 }
        r2 = ".";	 Catch:{ Exception -> 0x0048 }
        r0.append(r2);	 Catch:{ Exception -> 0x0048 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0048 }
        goto L_0x0049;
    L_0x0048:
        r0 = r1;
    L_0x0049:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerResponse.b():java.lang.String");
    }
}
