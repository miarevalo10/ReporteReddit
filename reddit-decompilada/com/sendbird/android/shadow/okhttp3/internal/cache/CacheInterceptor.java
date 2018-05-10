package com.sendbird.android.shadow.okhttp3.internal.cache;

import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.Headers.Builder;
import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import io.fabric.sdk.android.services.network.HttpRequest;

public final class CacheInterceptor implements Interceptor {
    final InternalCache f30387a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f30387a = internalCache;
    }

    public final com.sendbird.android.shadow.okhttp3.Response mo5325a(com.sendbird.android.shadow.okhttp3.Interceptor.Chain r21) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r20 = this;
        r1 = r20;
        r2 = r1.f30387a;
        r3 = 0;
        if (r2 == 0) goto L_0x0012;
    L_0x0007:
        r2 = r1.f30387a;
        r4 = r21.mo5329a();
        r2 = r2.get(r4);
        goto L_0x0013;
    L_0x0012:
        r2 = r3;
    L_0x0013:
        r4 = java.lang.System.currentTimeMillis();
        r6 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy$Factory;
        r7 = r21.mo5329a();
        r6.<init>(r4, r7, r2);
        r4 = r6.f23354c;
        if (r4 != 0) goto L_0x002e;
    L_0x0024:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r5 = r6.f23353b;
        r4.<init>(r5, r3);
    L_0x002b:
        r5 = r3;
        goto L_0x020d;
    L_0x002e:
        r4 = r6.f23353b;
        r4 = r4.isHttps();
        if (r4 == 0) goto L_0x0044;
    L_0x0036:
        r4 = r6.f23354c;
        r4 = r4.f23312e;
        if (r4 != 0) goto L_0x0044;
    L_0x003c:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r5 = r6.f23353b;
        r4.<init>(r5, r3);
        goto L_0x002b;
    L_0x0044:
        r4 = r6.f23354c;
        r5 = r6.f23353b;
        r4 = com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy.m25383a(r4, r5);
        if (r4 != 0) goto L_0x0056;
    L_0x004e:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r5 = r6.f23353b;
        r4.<init>(r5, r3);
        goto L_0x002b;
    L_0x0056:
        r4 = r6.f23353b;
        r4 = r4.cacheControl();
        r5 = r4.f23075c;
        if (r5 != 0) goto L_0x0205;
    L_0x0060:
        r5 = r6.f23353b;
        r5 = com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy.Factory.m25382a(r5);
        if (r5 == 0) goto L_0x006a;
    L_0x0068:
        goto L_0x0205;
    L_0x006a:
        r5 = r6.f23354c;
        r5 = r5.m25334b();
        r7 = r5.f23084l;
        if (r7 == 0) goto L_0x007c;
    L_0x0074:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r5 = r6.f23354c;
        r4.<init>(r3, r5);
        goto L_0x002b;
    L_0x007c:
        r7 = r6.f23355d;
        r8 = 0;
        if (r7 == 0) goto L_0x0090;
    L_0x0082:
        r10 = r6.f23361j;
        r7 = r6.f23355d;
        r12 = r7.getTime();
        r10 = r10 - r12;
        r10 = java.lang.Math.max(r8, r10);
        goto L_0x0091;
    L_0x0090:
        r10 = r8;
    L_0x0091:
        r7 = r6.f23363l;
        r12 = -1;
        if (r7 == r12) goto L_0x00a3;
    L_0x0096:
        r7 = java.util.concurrent.TimeUnit.SECONDS;
        r13 = r6.f23363l;
        r13 = (long) r13;
        r13 = r7.toMillis(r13);
        r10 = java.lang.Math.max(r10, r13);
    L_0x00a3:
        r13 = r6.f23361j;
        r15 = r4;
        r3 = r6.f23360i;
        r13 = r13 - r3;
        r3 = r6.f23352a;
        r8 = r6.f23361j;
        r3 = r3 - r8;
        r10 = r10 + r13;
        r10 = r10 + r3;
        r3 = r6.f23354c;
        r3 = r3.m25334b();
        r4 = r3.f23077e;
        if (r4 == r12) goto L_0x00c9;
    L_0x00ba:
        r4 = java.util.concurrent.TimeUnit.SECONDS;
        r3 = r3.f23077e;
        r7 = (long) r3;
        r8 = r4.toMillis(r7);
    L_0x00c3:
        r13 = r8;
        r3 = r15;
        r8 = 0;
        goto L_0x0134;
    L_0x00c9:
        r3 = r6.f23359h;
        if (r3 == 0) goto L_0x00ef;
    L_0x00cd:
        r3 = r6.f23355d;
        if (r3 == 0) goto L_0x00d8;
    L_0x00d1:
        r3 = r6.f23355d;
        r3 = r3.getTime();
        goto L_0x00da;
    L_0x00d8:
        r3 = r6.f23361j;
    L_0x00da:
        r7 = r6.f23359h;
        r7 = r7.getTime();
        r8 = r7 - r3;
        r3 = 0;
        r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
        if (r7 <= 0) goto L_0x00e9;
    L_0x00e8:
        goto L_0x00c3;
    L_0x00e9:
        r3 = r15;
        r8 = 0;
        r13 = 0;
        goto L_0x0134;
    L_0x00ef:
        r3 = r6.f23357f;
        if (r3 == 0) goto L_0x0130;
    L_0x00f3:
        r3 = r6.f23354c;
        r3 = r3.f23308a;
        r3 = r3.url();
        r4 = r3.f23217d;
        if (r4 != 0) goto L_0x0101;
    L_0x00ff:
        r3 = 0;
        goto L_0x010f;
    L_0x0101:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r3 = r3.f23217d;
        com.sendbird.android.shadow.okhttp3.HttpUrl.m25289b(r4, r3);
        r3 = r4.toString();
    L_0x010f:
        if (r3 != 0) goto L_0x0130;
    L_0x0111:
        r3 = r6.f23355d;
        if (r3 == 0) goto L_0x011c;
    L_0x0115:
        r3 = r6.f23355d;
        r3 = r3.getTime();
        goto L_0x011e;
    L_0x011c:
        r3 = r6.f23360i;
    L_0x011e:
        r7 = r6.f23357f;
        r7 = r7.getTime();
        r3 = r3 - r7;
        r8 = 0;
        r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r7 <= 0) goto L_0x0132;
    L_0x012b:
        r13 = 10;
        r3 = r3 / r13;
        r13 = r3;
        goto L_0x0133;
    L_0x0130:
        r8 = 0;
    L_0x0132:
        r13 = r8;
    L_0x0133:
        r3 = r15;
    L_0x0134:
        r4 = r3.f23077e;
        if (r4 == r12) goto L_0x0145;
    L_0x0138:
        r4 = java.util.concurrent.TimeUnit.SECONDS;
        r7 = r3.f23077e;
        r8 = (long) r7;
        r7 = r4.toMillis(r8);
        r13 = java.lang.Math.min(r13, r7);
    L_0x0145:
        r4 = r3.f23082j;
        if (r4 == r12) goto L_0x0153;
    L_0x0149:
        r4 = java.util.concurrent.TimeUnit.SECONDS;
        r7 = r3.f23082j;
        r7 = (long) r7;
        r8 = r4.toMillis(r7);
        goto L_0x0155;
    L_0x0153:
        r8 = 0;
    L_0x0155:
        r4 = r5.f23080h;
        if (r4 != 0) goto L_0x016b;
    L_0x0159:
        r4 = r3.f23081i;
        if (r4 == r12) goto L_0x016b;
    L_0x015d:
        r4 = java.util.concurrent.TimeUnit.SECONDS;
        r3 = r3.f23081i;
        r18 = r13;
        r12 = (long) r3;
        r3 = r4.toMillis(r12);
        r16 = r3;
        goto L_0x016f;
    L_0x016b:
        r18 = r13;
        r16 = 0;
    L_0x016f:
        r3 = r5.f23075c;
        if (r3 != 0) goto L_0x01b8;
    L_0x0173:
        r8 = r8 + r10;
        r13 = r18 + r16;
        r3 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1));
        if (r3 >= 0) goto L_0x01b8;
    L_0x017a:
        r3 = r6.f23354c;
        r3 = r3.m25332a();
        r4 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1));
        if (r4 < 0) goto L_0x018b;
    L_0x0184:
        r4 = "Warning";
        r5 = "110 HttpURLConnection \"Response is stale\"";
        r3.m25329a(r4, r5);
    L_0x018b:
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x01ad;
    L_0x0192:
        r4 = r6.f23354c;
        r4 = r4.m25334b();
        r4 = r4.f23077e;
        r5 = -1;
        if (r4 != r5) goto L_0x01a3;
    L_0x019d:
        r4 = r6.f23359h;
        if (r4 != 0) goto L_0x01a3;
    L_0x01a1:
        r4 = 1;
        goto L_0x01a4;
    L_0x01a3:
        r4 = 0;
    L_0x01a4:
        if (r4 == 0) goto L_0x01ad;
    L_0x01a6:
        r4 = "Warning";
        r5 = "113 HttpURLConnection \"Heuristic expiration\"";
        r3.m25329a(r4, r5);
    L_0x01ad:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r3 = r3.m25330a();
        r5 = 0;
        r4.<init>(r5, r3);
        goto L_0x020d;
    L_0x01b8:
        r3 = r6.f23362k;
        if (r3 == 0) goto L_0x01c1;
    L_0x01bc:
        r3 = "If-None-Match";
        r4 = r6.f23362k;
        goto L_0x01d2;
    L_0x01c1:
        r3 = r6.f23357f;
        if (r3 == 0) goto L_0x01ca;
    L_0x01c5:
        r3 = "If-Modified-Since";
        r4 = r6.f23358g;
        goto L_0x01d2;
    L_0x01ca:
        r3 = r6.f23355d;
        if (r3 == 0) goto L_0x01fc;
    L_0x01ce:
        r3 = "If-Modified-Since";
        r4 = r6.f23356e;
    L_0x01d2:
        r5 = r6.f23353b;
        r5 = r5.headers();
        r5 = r5.m25267a();
        r7 = com.sendbird.android.shadow.okhttp3.internal.Internal.instance;
        r7.addLenient(r5, r3, r4);
        r3 = r6.f23353b;
        r3 = r3.newBuilder();
        r4 = r5.m25262a();
        r3 = r3.m25313a(r4);
        r3 = r3.m25318a();
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r5 = r6.f23354c;
        r4.<init>(r3, r5);
        r5 = 0;
        goto L_0x020d;
    L_0x01fc:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r3 = r6.f23353b;
        r5 = 0;
        r4.<init>(r3, r5);
        goto L_0x020d;
    L_0x0205:
        r5 = r3;
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r3 = r6.f23353b;
        r4.<init>(r3, r5);
    L_0x020d:
        r3 = r4.f23364a;
        if (r3 == 0) goto L_0x0220;
    L_0x0211:
        r3 = r6.f23353b;
        r3 = r3.cacheControl();
        r3 = r3.f23083k;
        if (r3 == 0) goto L_0x0220;
    L_0x021b:
        r4 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
        r4.<init>(r5, r5);
    L_0x0220:
        r3 = r4.f23364a;
        r5 = r4.f23365b;
        r6 = r1.f30387a;
        if (r6 == 0) goto L_0x022d;
    L_0x0228:
        r6 = r1.f30387a;
        r6.trackResponse(r4);
    L_0x022d:
        if (r2 == 0) goto L_0x0236;
    L_0x022f:
        if (r5 != 0) goto L_0x0236;
    L_0x0231:
        r4 = r2.f23314g;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r4);
    L_0x0236:
        if (r3 != 0) goto L_0x0264;
    L_0x0238:
        if (r5 != 0) goto L_0x0264;
    L_0x023a:
        r2 = new com.sendbird.android.shadow.okhttp3.Response$Builder;
        r2.<init>();
        r3 = r21.mo5329a();
        r2.f23296a = r3;
        r3 = com.sendbird.android.shadow.okhttp3.Protocol.HTTP_1_1;
        r2.f23297b = r3;
        r3 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        r2.f23298c = r3;
        r3 = "Unsatisfiable Request (only-if-cached)";
        r2.f23299d = r3;
        r3 = com.sendbird.android.shadow.okhttp3.internal.Util.f23336c;
        r2.f23302g = r3;
        r3 = -1;
        r2.f23306k = r3;
        r3 = java.lang.System.currentTimeMillis();
        r2.f23307l = r3;
        r2 = r2.m25330a();
        return r2;
    L_0x0264:
        if (r3 != 0) goto L_0x0277;
    L_0x0266:
        r2 = r5.m25332a();
        r3 = m31355a(r5);
        r2 = r2.m25331b(r3);
        r2 = r2.m25330a();
        return r2;
    L_0x0277:
        r4 = r21;
        r4 = r4.mo5330a(r3);	 Catch:{ all -> 0x0346 }
        if (r4 != 0) goto L_0x0286;
    L_0x027f:
        if (r2 == 0) goto L_0x0286;
    L_0x0281:
        r2 = r2.f23314g;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r2);
    L_0x0286:
        if (r5 == 0) goto L_0x02cf;
    L_0x0288:
        r2 = r4.f23310c;
        r6 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r2 != r6) goto L_0x02ca;
    L_0x028e:
        r2 = r5.m25332a();
        r3 = r5.f23313f;
        r6 = r4.f23313f;
        r3 = m31354a(r3, r6);
        r2 = r2.m25327a(r3);
        r6 = r4.f23318k;
        r2.f23306k = r6;
        r6 = r4.f23319l;
        r2.f23307l = r6;
        r3 = m31355a(r5);
        r2 = r2.m25331b(r3);
        r3 = m31355a(r4);
        r2 = r2.m25328a(r3);
        r2 = r2.m25330a();
        r3 = r4.f23314g;
        r3.close();
        r3 = r1.f30387a;
        r3.trackConditionalCacheHit();
        r3 = r1.f30387a;
        r3.update(r5, r2);
        return r2;
    L_0x02ca:
        r2 = r5.f23314g;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r2);
    L_0x02cf:
        r2 = r4.m25332a();
        r5 = m31355a(r5);
        r2 = r2.m25331b(r5);
        r4 = m31355a(r4);
        r2 = r2.m25328a(r4);
        r2 = r2.m25330a();
        r4 = r1.f30387a;
        if (r4 == 0) goto L_0x0345;
    L_0x02eb:
        r4 = com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders.m25435d(r2);
        if (r4 == 0) goto L_0x0336;
    L_0x02f1:
        r4 = com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy.m25383a(r2, r3);
        if (r4 == 0) goto L_0x0336;
    L_0x02f7:
        r3 = r1.f30387a;
        r3 = r3.put(r2);
        if (r3 != 0) goto L_0x0300;
    L_0x02ff:
        return r2;
    L_0x0300:
        r4 = r3.body();
        if (r4 != 0) goto L_0x0307;
    L_0x0306:
        return r2;
    L_0x0307:
        r5 = r2.f23314g;
        r5 = r5.mo5298c();
        r4 = com.sendbird.android.shadow.okio.Okio.m25614a(r4);
        r6 = new com.sendbird.android.shadow.okhttp3.internal.cache.CacheInterceptor$1;
        r6.<init>(r1, r5, r3, r4);
        r3 = "Content-Type";
        r3 = r2.m25333a(r3);
        r4 = r2.f23314g;
        r4 = r4.mo5297b();
        r2 = r2.m25332a();
        r7 = new com.sendbird.android.shadow.okhttp3.internal.http.RealResponseBody;
        r6 = com.sendbird.android.shadow.okio.Okio.m25615a(r6);
        r7.<init>(r3, r4, r6);
        r2.f23302g = r7;
        r2 = r2.m25330a();
        return r2;
    L_0x0336:
        r4 = r3.method();
        r4 = com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod.m25436a(r4);
        if (r4 == 0) goto L_0x0345;
    L_0x0340:
        r4 = r1.f30387a;	 Catch:{ IOException -> 0x0345 }
        r4.remove(r3);	 Catch:{ IOException -> 0x0345 }
    L_0x0345:
        return r2;
    L_0x0346:
        r0 = move-exception;
        if (r2 == 0) goto L_0x034e;
    L_0x0349:
        r2 = r2.f23314g;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r2);
    L_0x034e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.CacheInterceptor.a(com.sendbird.android.shadow.okhttp3.Interceptor$Chain):com.sendbird.android.shadow.okhttp3.Response");
    }

    private static Headers m31354a(Headers headers, Headers headers2) {
        Builder builder = new Builder();
        int i = 0;
        int length = headers.f23197a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            String a = headers.m25268a(i2);
            String b = headers.m25270b(i2);
            if (!("Warning".equalsIgnoreCase(a) && b.startsWith("1")) && (!m31356a(a) || headers2.m25269a(a) == null)) {
                Internal.instance.addLenient(builder, a, b);
            }
        }
        headers = headers2.f23197a.length / 2;
        while (i < headers) {
            String a2 = headers2.m25268a(i);
            if (!"Content-Length".equalsIgnoreCase(a2) && m31356a(a2)) {
                Internal.instance.addLenient(builder, a2, headers2.m25270b(i));
            }
            i++;
        }
        return builder.m25262a();
    }

    private static boolean m31356a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpRequest.HEADER_PROXY_AUTHORIZATION.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str) != null) ? null : true;
    }

    private static Response m31355a(Response response) {
        if (response == null || response.f23314g == null) {
            return response;
        }
        response = response.m25332a();
        response.f23302g = null;
        return response.m25330a();
    }
}
