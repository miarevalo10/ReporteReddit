package com.sendbird.android.shadow.okhttp3.internal.http;

import com.facebook.stetho.server.http.HttpStatus;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.sendbird.android.shadow.okhttp3.Cookie;
import com.sendbird.android.shadow.okhttp3.CookieJar;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.Headers.Builder;
import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public final class HttpHeaders {
    private static final Pattern f23424a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    private static long m25428a(java.lang.String r4) {
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
        r0 = -1;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x000a }
        return r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders.a(java.lang.String):long");
    }

    private static Set<String> m25429a(Headers headers) {
        int length = headers.f23197a.length / 2;
        Set<String> emptySet = Collections.emptySet();
        for (int i = 0; i < length; i++) {
            if ("Vary".equalsIgnoreCase(headers.m25268a(i))) {
                String b = headers.m25270b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static void m25430a(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.f23182a && Cookie.m25224a(httpUrl, headers).isEmpty() == null) {
            cookieJar.mo5299a();
        }
    }

    public static int m25426a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int m25425a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                break;
            }
            i++;
        }
        return i;
    }

    public static int m25432b(java.lang.String r2, int r3) {
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
        r0 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0019 }
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x000f;
    L_0x000b:
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        return r2;
    L_0x000f:
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0017;
    L_0x0015:
        r2 = 0;
        return r2;
    L_0x0017:
        r2 = (int) r0;
        return r2;
    L_0x0019:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders.b(java.lang.String, int):int");
    }

    public static long m25427a(Response response) {
        return m25428a(response.f23313f.m25269a("Content-Length"));
    }

    public static boolean m25431a(Response response, Headers headers, Request request) {
        for (String str : m25429a(response.f23313f)) {
            if (!Util.m25371a(headers.m25271b(str), request.headers(str))) {
                return null;
            }
        }
        return true;
    }

    public static boolean m25433b(Response response) {
        return m25429a(response.f23313f).contains(Operation.MULTIPLY);
    }

    public static Headers m25434c(Response response) {
        Headers headers = response.f23315h.f23308a.headers();
        response = m25429a(response.f23313f);
        if (response.isEmpty()) {
            return new Builder().m25262a();
        }
        Builder builder = new Builder();
        int length = headers.f23197a.length / 2;
        for (int i = 0; i < length; i++) {
            String a = headers.m25268a(i);
            if (response.contains(a)) {
                builder.m25261a(a, headers.m25270b(i));
            }
        }
        return builder.m25262a();
    }

    public static boolean m25435d(Response response) {
        if (response.f23308a.method().equals(HttpRequest.METHOD_HEAD)) {
            return false;
        }
        int i = response.f23310c;
        if (((i >= 100 && i < HttpStatus.HTTP_OK) || i == 204 || i == 304) && m25427a(response) == -1) {
            if ("chunked".equalsIgnoreCase(response.m25333a("Transfer-Encoding")) == null) {
                return false;
            }
        }
        return true;
    }
}
