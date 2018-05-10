package com.instabug.library.okhttplogger;

import com.instabug.library.model.NetworkLog;
import java.nio.charset.Charset;
import okhttp3.Interceptor;

public class InstabugOkhttpInterceptor implements Interceptor {
    private static final Charset f15541a = Charset.forName("UTF-8");

    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.io.IOException {
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
        r13 = this;
        r0 = new com.instabug.library.model.NetworkLog;
        r0.<init>();
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = r14.request();
        r3 = r2.body();
        r4 = 0;
        r5 = 1;
        if (r3 == 0) goto L_0x0018;
    L_0x0016:
        r6 = r5;
        goto L_0x0019;
    L_0x0018:
        r6 = r4;
    L_0x0019:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = java.lang.System.currentTimeMillis();
        r7.append(r8);
        r7 = r7.toString();
        r0.setDate(r7);
        r7 = r2.method();
        r0.setMethod(r7);
        r7 = r2.url();
        r7 = r7.toString();
        r0.setUrl(r7);
        if (r6 == 0) goto L_0x007e;
    L_0x0040:
        r7 = r3.contentType();
        if (r7 == 0) goto L_0x0064;
    L_0x0046:
        r7 = r3.contentType();	 Catch:{ JSONException -> 0x005e }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x005e }
        r7 = m15449a(r7);	 Catch:{ JSONException -> 0x005e }
        r8 = "Content-Type";	 Catch:{ JSONException -> 0x005c }
        r9 = r3.contentType();	 Catch:{ JSONException -> 0x005c }
        r1.put(r8, r9);	 Catch:{ JSONException -> 0x005c }
        goto L_0x0065;
    L_0x005c:
        r8 = move-exception;
        goto L_0x0060;
    L_0x005e:
        r8 = move-exception;
        r7 = r5;
    L_0x0060:
        r8.printStackTrace();
        goto L_0x0065;
    L_0x0064:
        r7 = r5;
    L_0x0065:
        r8 = r3.contentLength();
        r10 = -1;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 == 0) goto L_0x007f;
    L_0x006f:
        r8 = "Content-Length";	 Catch:{ JSONException -> 0x0079 }
        r9 = r3.contentLength();	 Catch:{ JSONException -> 0x0079 }
        r1.put(r8, r9);	 Catch:{ JSONException -> 0x0079 }
        goto L_0x007f;
    L_0x0079:
        r8 = move-exception;
        r8.printStackTrace();
        goto L_0x007f;
    L_0x007e:
        r7 = r5;
    L_0x007f:
        r8 = r2.headers();
        r9 = r8.size();
        r10 = r4;
    L_0x0088:
        if (r10 >= r9) goto L_0x00ad;
    L_0x008a:
        r11 = r8.name(r10);
        r12 = "Content-Type";
        r12 = r12.equalsIgnoreCase(r11);
        if (r12 != 0) goto L_0x00aa;
    L_0x0096:
        r12 = "Content-Length";
        r12 = r12.equalsIgnoreCase(r11);
        if (r12 != 0) goto L_0x00aa;
    L_0x009e:
        r12 = r8.value(r10);	 Catch:{ JSONException -> 0x00a6 }
        r1.put(r11, r12);	 Catch:{ JSONException -> 0x00a6 }
        goto L_0x00aa;
    L_0x00a6:
        r11 = move-exception;
        r11.printStackTrace();
    L_0x00aa:
        r10 = r10 + 1;
        goto L_0x0088;
    L_0x00ad:
        if (r6 == 0) goto L_0x00d6;
    L_0x00af:
        r6 = new okio.Buffer;
        r6.<init>();
        r3.writeTo(r6);
        r8 = f15541a;
        r3 = r3.contentType();
        if (r3 == 0) goto L_0x00c5;
    L_0x00bf:
        r8 = f15541a;
        r8 = r3.charset(r8);
    L_0x00c5:
        r3 = m15450a(r6);
        if (r3 == 0) goto L_0x00d6;
    L_0x00cb:
        r3 = r6.a(r8);
        r3 = m15451b(r3);
        r0.setRequest(r3);
    L_0x00d6:
        r8 = java.lang.System.nanoTime();
        r14 = r14.proceed(r2);	 Catch:{ Exception -> 0x0195 }
        r2 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r10 = java.lang.System.nanoTime();
        r10 = r10 - r8;
        r2 = r2.toMillis(r10);
        r0.setTotalDuration(r2);
        r2 = r14.body();
        r8 = r2.contentLength();
        r3 = r14.code();
        r0.setResponseCode(r3);
        r3 = r14.headers();
        r6 = r3.size();
        r10 = r7;
        r7 = r4;
    L_0x0105:
        if (r7 >= r6) goto L_0x012f;
    L_0x0107:
        r11 = r3.name(r7);	 Catch:{ JSONException -> 0x0128 }
        r12 = "content-type";	 Catch:{ JSONException -> 0x0128 }
        r11 = r11.equalsIgnoreCase(r12);	 Catch:{ JSONException -> 0x0128 }
        if (r11 == 0) goto L_0x011c;	 Catch:{ JSONException -> 0x0128 }
    L_0x0113:
        r11 = r3.value(r7);	 Catch:{ JSONException -> 0x0128 }
        r11 = m15449a(r11);	 Catch:{ JSONException -> 0x0128 }
        r10 = r11;	 Catch:{ JSONException -> 0x0128 }
    L_0x011c:
        r11 = r3.name(r7);	 Catch:{ JSONException -> 0x0128 }
        r12 = r3.value(r7);	 Catch:{ JSONException -> 0x0128 }
        r1.put(r11, r12);	 Catch:{ JSONException -> 0x0128 }
        goto L_0x012c;
    L_0x0128:
        r11 = move-exception;
        r11.printStackTrace();
    L_0x012c:
        r7 = r7 + 1;
        goto L_0x0105;
    L_0x012f:
        r1 = r1.toString();
        r0.setHeaders(r1);
        r1 = okhttp3.internal.http.HttpHeaders.hasBody(r14);
        if (r1 == 0) goto L_0x018f;
    L_0x013c:
        r1 = r14.headers();
        r3 = "Content-Encoding";
        r1 = r1.get(r3);
        if (r1 == 0) goto L_0x0151;
    L_0x0148:
        r3 = "identity";
        r1 = r1.equalsIgnoreCase(r3);
        if (r1 != 0) goto L_0x0151;
    L_0x0150:
        r4 = r5;
    L_0x0151:
        if (r4 != 0) goto L_0x018f;
    L_0x0153:
        r1 = r2.source();
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r1.b(r3);
        r1 = r1.a();
        r3 = f15541a;
        r2 = r2.contentType();
        if (r2 == 0) goto L_0x0173;
    L_0x016b:
        r3 = f15541a;	 Catch:{ UnsupportedCharsetException -> 0x0172 }
        r3 = r2.charset(r3);	 Catch:{ UnsupportedCharsetException -> 0x0172 }
        goto L_0x0173;
    L_0x0172:
        return r14;
    L_0x0173:
        r2 = m15450a(r1);
        if (r2 != 0) goto L_0x017a;
    L_0x0179:
        return r14;
    L_0x017a:
        r4 = 0;
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x018f;
    L_0x0180:
        r1 = r1.v();
        r1 = r1.a(r3);
        r1 = m15451b(r1);
        r0.setResponse(r1);
    L_0x018f:
        if (r10 != 0) goto L_0x0194;
    L_0x0191:
        r0.insert();
    L_0x0194:
        return r14;
    L_0x0195:
        r14 = move-exception;
        r1 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r2 = java.lang.System.nanoTime();
        r2 = r2 - r8;
        r1 = r1.toMillis(r2);
        r0.setTotalDuration(r1);
        r1 = r14.getMessage();
        if (r1 == 0) goto L_0x01ab;
    L_0x01aa:
        goto L_0x01b3;
    L_0x01ab:
        r1 = r14.getClass();
        r1 = r1.getSimpleName();
    L_0x01b3:
        r0.setResponse(r1);
        r0.setResponseCode(r4);
        r0.insert();
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.okhttplogger.InstabugOkhttpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private static boolean m15449a(String str) {
        return (str.contains("application/json") || str.contains(NetworkLog.XML_1) || str.contains(NetworkLog.XML_2) || str.contains(NetworkLog.HTML) || str.contains(NetworkLog.PLAIN_TEXT) != null) ? null : true;
    }

    private static String m15451b(String str) {
        return ((long) str.getBytes().length) > 1000000 ? NetworkLog.LIMIT_ERROR : str;
    }

    private static boolean m15450a(okio.Buffer r8) {
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
        r0 = 0;
        r7 = new okio.Buffer;	 Catch:{ EOFException -> 0x003b }
        r7.<init>();	 Catch:{ EOFException -> 0x003b }
        r1 = r8.b;	 Catch:{ EOFException -> 0x003b }
        r3 = 64;	 Catch:{ EOFException -> 0x003b }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ EOFException -> 0x003b }
        if (r1 >= 0) goto L_0x0012;	 Catch:{ EOFException -> 0x003b }
    L_0x000e:
        r1 = r8.b;	 Catch:{ EOFException -> 0x003b }
        r5 = r1;	 Catch:{ EOFException -> 0x003b }
        goto L_0x0013;	 Catch:{ EOFException -> 0x003b }
    L_0x0012:
        r5 = r3;	 Catch:{ EOFException -> 0x003b }
    L_0x0013:
        r3 = 0;	 Catch:{ EOFException -> 0x003b }
        r1 = r8;	 Catch:{ EOFException -> 0x003b }
        r2 = r7;	 Catch:{ EOFException -> 0x003b }
        r1.a(r2, r3, r5);	 Catch:{ EOFException -> 0x003b }
        r8 = r0;	 Catch:{ EOFException -> 0x003b }
    L_0x001b:
        r1 = 16;	 Catch:{ EOFException -> 0x003b }
        if (r8 >= r1) goto L_0x0039;	 Catch:{ EOFException -> 0x003b }
    L_0x001f:
        r1 = r7.d();	 Catch:{ EOFException -> 0x003b }
        if (r1 != 0) goto L_0x0039;	 Catch:{ EOFException -> 0x003b }
    L_0x0025:
        r1 = r7.r();	 Catch:{ EOFException -> 0x003b }
        r2 = java.lang.Character.isISOControl(r1);	 Catch:{ EOFException -> 0x003b }
        if (r2 == 0) goto L_0x0036;	 Catch:{ EOFException -> 0x003b }
    L_0x002f:
        r1 = java.lang.Character.isWhitespace(r1);	 Catch:{ EOFException -> 0x003b }
        if (r1 != 0) goto L_0x0036;
    L_0x0035:
        return r0;
    L_0x0036:
        r8 = r8 + 1;
        goto L_0x001b;
    L_0x0039:
        r8 = 1;
        return r8;
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.okhttplogger.InstabugOkhttpInterceptor.a(okio.Buffer):boolean");
    }
}
