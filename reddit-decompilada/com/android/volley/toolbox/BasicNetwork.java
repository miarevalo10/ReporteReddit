package com.android.volley.toolbox;

import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;

public class BasicNetwork implements Network {
    protected static final boolean f12123a = VolleyLog.f2814b;
    private static int f12124d = 3000;
    private static int f12125e = 4096;
    protected final HttpStack f12126b;
    protected final ByteArrayPool f12127c;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(f12125e));
    }

    private BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.f12126b = httpStack;
        this.f12127c = byteArrayPool;
    }

    public com.android.volley.NetworkResponse mo777a(com.android.volley.Request<?> r28) throws com.android.volley.VolleyError {
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
        r27 = this;
        r1 = r27;
        r2 = r28;
        r3 = android.os.SystemClock.elapsedRealtime();
    L_0x0008:
        r5 = java.util.Collections.emptyMap();
        r9 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r10 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        r11 = 0;
        r12 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r12.<init>();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r13 = r28.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        if (r13 == 0) goto L_0x003f;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
    L_0x001c:
        r14 = r13.f2751b;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        if (r14 == 0) goto L_0x0027;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
    L_0x0020:
        r14 = "If-None-Match";	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r15 = r13.f2751b;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r12.put(r14, r15);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
    L_0x0027:
        r14 = r13.f2753d;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r16 = 0;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        if (r14 <= 0) goto L_0x003f;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
    L_0x002f:
        r14 = new java.util.Date;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r6 = r13.f2753d;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r14.<init>(r6);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r6 = "If-Modified-Since";	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r7 = org.apache.http.impl.cookie.DateUtils.formatDate(r14);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r12.put(r6, r7);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
    L_0x003f:
        r6 = r1.f12126b;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r6 = r6.mo3041a(r2, r12);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012e }
        r7 = r6.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012b }
        r12 = r7.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012b }
        r13 = r6.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012b }
        r13 = m10982a(r13);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x012b }
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r12 != r5) goto L_0x009a;
    L_0x0059:
        r5 = r28.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        if (r5 != 0) goto L_0x0075;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x005f:
        r5 = new com.android.volley.NetworkResponse;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r21 = 0;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r23 = 1;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r14 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r24 = r14 - r3;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r19 = r5;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r22 = r13;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r19.<init>(r20, r21, r22, r23, r24);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        return r5;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x0075:
        r7 = r5.f2756g;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r7.putAll(r13);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r7 = new com.android.volley.NetworkResponse;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r12 = r5.f2750a;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r5 = r5.f2756g;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r23 = 1;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r14 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r24 = r14 - r3;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r19 = r7;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r21 = r12;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r22 = r5;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r19.<init>(r20, r21, r22, r23, r24);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        return r7;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x0094:
        r0 = move-exception;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r5 = r0;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r15 = r13;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        goto L_0x0133;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x009a:
        if (r12 == r10) goto L_0x009e;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x009c:
        if (r12 != r9) goto L_0x00a9;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x009e:
        r5 = "Location";	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r5 = r13.get(r5);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r5 = (java.lang.String) r5;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r2.setRedirectUrl(r5);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x00a9:
        r5 = r6.getEntity();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        if (r5 == 0) goto L_0x00b8;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x00af:
        r5 = r6.getEntity();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        r5 = r1.m10984a(r5);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
        goto L_0x00ba;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x00b8:
        r5 = new byte[r11];	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0094 }
    L_0x00ba:
        r14 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = r14 - r3;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r16 = f12123a;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        if (r16 != 0) goto L_0x00ca;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x00c3:
        r9 = f12124d;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r8 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r8 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        if (r8 <= 0) goto L_0x0102;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x00ca:
        r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9 = 5;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9 = new java.lang.Object[r9];	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9[r11] = r2;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = java.lang.Long.valueOf(r14);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r15 = 1;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9[r15] = r14;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        if (r5 == 0) goto L_0x00e0;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x00da:
        r14 = r5.length;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        goto L_0x00e2;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x00e0:
        r14 = "null";	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x00e2:
        r15 = 2;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9[r15] = r14;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = 3;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r7 = r7.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9[r14] = r7;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r7 = 4;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = r28.getRetryPolicy();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = r14.mo773b();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r9[r7] = r14;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        com.android.volley.VolleyLog.m2456b(r8, r9);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x0102:
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        if (r12 < r7) goto L_0x0121;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x0106:
        r7 = 299; // 0x12b float:4.19E-43 double:1.477E-321;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        if (r12 <= r7) goto L_0x010b;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x010a:
        goto L_0x0121;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x010b:
        r7 = new com.android.volley.NetworkResponse;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r23 = 0;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r24 = r8 - r3;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r19 = r7;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r20 = r12;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r21 = r5;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r22 = r13;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r19.<init>(r20, r21, r22, r23, r24);	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        return r7;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x0121:
        r7 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        r7.<init>();	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
        throw r7;	 Catch:{ SocketTimeoutException -> 0x01e0, ConnectTimeoutException -> 0x01d4, MalformedURLException -> 0x01ba, IOException -> 0x0127 }
    L_0x0127:
        r0 = move-exception;
        r14 = r5;
        r15 = r13;
        goto L_0x0132;
    L_0x012b:
        r0 = move-exception;
        r15 = r5;
        goto L_0x0131;
    L_0x012e:
        r0 = move-exception;
        r15 = r5;
        r6 = 0;
    L_0x0131:
        r14 = 0;
    L_0x0132:
        r5 = r0;
    L_0x0133:
        if (r6 == 0) goto L_0x01b4;
    L_0x0135:
        r6 = r6.getStatusLine();
        r6 = r6.getStatusCode();
        if (r6 == r10) goto L_0x015a;
    L_0x013f:
        r7 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r6 != r7) goto L_0x0144;
    L_0x0143:
        goto L_0x015a;
    L_0x0144:
        r7 = "Unexpected response code %d for %s";
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = java.lang.Integer.valueOf(r6);
        r8[r11] = r9;
        r9 = r28.getUrl();
        r12 = 1;
        r8[r12] = r9;
        com.android.volley.VolleyLog.m2457c(r7, r8);
        goto L_0x016f;
    L_0x015a:
        r8 = 2;
        r12 = 1;
        r7 = "Request at %s has been redirected to %s";
        r8 = new java.lang.Object[r8];
        r9 = r28.getOriginUrl();
        r8[r11] = r9;
        r9 = r28.getUrl();
        r8[r12] = r9;
        com.android.volley.VolleyLog.m2457c(r7, r8);
    L_0x016f:
        if (r14 == 0) goto L_0x01ae;
    L_0x0171:
        r5 = new com.android.volley.NetworkResponse;
        r16 = 0;
        r7 = android.os.SystemClock.elapsedRealtime();
        r17 = r7 - r3;
        r12 = r5;
        r13 = r6;
        r12.<init>(r13, r14, r15, r16, r17);
        r7 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r6 == r7) goto L_0x01a2;
    L_0x0184:
        r7 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r6 != r7) goto L_0x0189;
    L_0x0188:
        goto L_0x01a2;
    L_0x0189:
        if (r6 == r10) goto L_0x0196;
    L_0x018b:
        r7 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r6 != r7) goto L_0x0190;
    L_0x018f:
        goto L_0x0196;
    L_0x0190:
        r2 = new com.android.volley.ServerError;
        r2.<init>(r5);
        throw r2;
    L_0x0196:
        r6 = "redirect";
        r7 = new com.android.volley.RedirectError;
        r7.<init>(r5);
        m10983a(r6, r2, r7);
        goto L_0x0008;
    L_0x01a2:
        r6 = "auth";
        r7 = new com.android.volley.AuthFailureError;
        r7.<init>(r5);
        m10983a(r6, r2, r7);
        goto L_0x0008;
    L_0x01ae:
        r2 = new com.android.volley.NetworkError;
        r2.<init>(r5);
        throw r2;
    L_0x01b4:
        r2 = new com.android.volley.NoConnectionError;
        r2.<init>(r5);
        throw r2;
    L_0x01ba:
        r0 = move-exception;
        r3 = r0;
        r4 = new java.lang.RuntimeException;
        r5 = new java.lang.StringBuilder;
        r6 = "Bad URL ";
        r5.<init>(r6);
        r2 = r28.getUrl();
        r5.append(r2);
        r2 = r5.toString();
        r4.<init>(r2, r3);
        throw r4;
    L_0x01d4:
        r5 = "connection";
        r6 = new com.android.volley.TimeoutError;
        r6.<init>();
        m10983a(r5, r2, r6);
        goto L_0x0008;
    L_0x01e0:
        r5 = "socket";
        r6 = new com.android.volley.TimeoutError;
        r6.<init>();
        m10983a(r5, r2, r6);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.a(com.android.volley.Request):com.android.volley.NetworkResponse");
    }

    private static void m10983a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.mo772a(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
        } catch (VolleyError volleyError2) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
            throw volleyError2;
        }
    }

    private byte[] m10984a(org.apache.http.HttpEntity r7) throws java.io.IOException, com.android.volley.ServerError {
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
        r6 = this;
        r0 = new com.android.volley.toolbox.PoolingByteArrayOutputStream;
        r1 = r6.f12127c;
        r2 = r7.getContentLength();
        r2 = (int) r2;
        r0.<init>(r1, r2);
        r1 = 0;
        r2 = 0;
        r3 = r7.getContent();	 Catch:{ all -> 0x0048 }
        if (r3 != 0) goto L_0x001a;	 Catch:{ all -> 0x0048 }
    L_0x0014:
        r3 = new com.android.volley.ServerError;	 Catch:{ all -> 0x0048 }
        r3.<init>();	 Catch:{ all -> 0x0048 }
        throw r3;	 Catch:{ all -> 0x0048 }
    L_0x001a:
        r4 = r6.f12127c;	 Catch:{ all -> 0x0048 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0048 }
        r4 = r4.m2462a(r5);	 Catch:{ all -> 0x0048 }
    L_0x0022:
        r2 = r3.read(r4);	 Catch:{ all -> 0x0045 }
        r5 = -1;	 Catch:{ all -> 0x0045 }
        if (r2 == r5) goto L_0x002d;	 Catch:{ all -> 0x0045 }
    L_0x0029:
        r0.write(r4, r1, r2);	 Catch:{ all -> 0x0045 }
        goto L_0x0022;	 Catch:{ all -> 0x0045 }
    L_0x002d:
        r2 = r0.toByteArray();	 Catch:{ all -> 0x0045 }
        r7.consumeContent();	 Catch:{ IOException -> 0x0035 }
        goto L_0x003c;
    L_0x0035:
        r7 = "Error occured when calling consumingContent";
        r1 = new java.lang.Object[r1];
        com.android.volley.VolleyLog.m2454a(r7, r1);
    L_0x003c:
        r7 = r6.f12127c;
        r7.m2461a(r4);
        r0.close();
        return r2;
    L_0x0045:
        r3 = move-exception;
        r2 = r4;
        goto L_0x0049;
    L_0x0048:
        r3 = move-exception;
    L_0x0049:
        r7.consumeContent();	 Catch:{ IOException -> 0x004d }
        goto L_0x0054;
    L_0x004d:
        r7 = "Error occured when calling consumingContent";
        r1 = new java.lang.Object[r1];
        com.android.volley.VolleyLog.m2454a(r7, r1);
    L_0x0054:
        r7 = r6.f12127c;
        r7.m2461a(r2);
        r0.close();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.a(org.apache.http.HttpEntity):byte[]");
    }

    private static Map<String, String> m10982a(Header[] headerArr) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }
}
