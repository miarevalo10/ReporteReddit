package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

public class StringRequest extends Request<String> {
    private Listener<String> mListener;

    public StringRequest(int i, String str, Listener<String> listener, ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
    }

    public StringRequest(String str, Listener<String> listener, ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    protected void onFinish() {
        super.onFinish();
        this.mListener = null;
    }

    protected void deliverResponse(String str) {
        if (this.mListener != null) {
            this.mListener.mo794a(str);
        }
    }

    protected com.android.volley.Response<java.lang.String> parseNetworkResponse(com.android.volley.NetworkResponse r4) {
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
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r1 = r4.f2778b;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = r4.f2779c;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = com.android.volley.toolbox.HttpHeaderParser.m2468a(r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        goto L_0x0015;
    L_0x000e:
        r0 = new java.lang.String;
        r1 = r4.f2778b;
        r0.<init>(r1);
    L_0x0015:
        r4 = com.android.volley.toolbox.HttpHeaderParser.m2467a(r4);
        r4 = com.android.volley.Response.m2445a(r0, r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.StringRequest.parseNetworkResponse(com.android.volley.NetworkResponse):com.android.volley.Response<java.lang.String>");
    }
}
