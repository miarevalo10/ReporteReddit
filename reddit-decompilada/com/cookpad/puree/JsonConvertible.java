package com.cookpad.puree;

public abstract class JsonConvertible {
    public org.json.JSONObject m3250a(com.google.gson.Gson r2) {
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
        r1 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000a }
        r2 = r2.m7487b(r1);	 Catch:{ JSONException -> 0x000a }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x000a }
        return r0;
    L_0x000a:
        r2 = new org.json.JSONObject;
        r2.<init>();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cookpad.puree.JsonConvertible.a(com.google.gson.Gson):org.json.JSONObject");
    }
}
