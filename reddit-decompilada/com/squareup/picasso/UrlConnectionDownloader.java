package com.squareup.picasso;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.File;
import java.io.IOException;

public class UrlConnectionDownloader implements Downloader {
    static volatile Object f30672a;
    private static final Object f30673b = new Object();
    private static final ThreadLocal<StringBuilder> f30674c = new C20581();
    private final Context f30675d;

    static class C20581 extends ThreadLocal<StringBuilder> {
        C20581() {
        }

        protected final /* synthetic */ Object initialValue() {
            return new StringBuilder();
        }
    }

    private static class ResponseCacheIcs {
        static Object m25808a(Context context) throws IOException {
            File b = Utils.m25828b(context);
            Object installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(b, Utils.m25814a(b)) : installed;
        }
    }

    public UrlConnectionDownloader(Context context) {
        this.f30675d = context.getApplicationContext();
    }

    public final com.squareup.picasso.Downloader.Response mo5459a(android.net.Uri r5, int r6) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 14;
        if (r0 < r1) goto L_0x001e;
    L_0x0006:
        r0 = r4.f30675d;
        r1 = f30672a;
        if (r1 != 0) goto L_0x001e;
    L_0x000c:
        r1 = f30673b;	 Catch:{ IOException -> 0x001e }
        monitor-enter(r1);	 Catch:{ IOException -> 0x001e }
        r2 = f30672a;	 Catch:{ all -> 0x001b }
        if (r2 != 0) goto L_0x0019;	 Catch:{ all -> 0x001b }
    L_0x0013:
        r0 = com.squareup.picasso.UrlConnectionDownloader.ResponseCacheIcs.m25808a(r0);	 Catch:{ all -> 0x001b }
        f30672a = r0;	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x001e;	 Catch:{ all -> 0x001b }
    L_0x001b:
        r0 = move-exception;	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;	 Catch:{ IOException -> 0x001e }
    L_0x001e:
        r0 = new java.net.URL;
        r5 = r5.toString();
        r0.<init>(r5);
        r5 = r0.openConnection();
        r5 = (java.net.HttpURLConnection) r5;
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r5.setConnectTimeout(r0);
        r0 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r5.setReadTimeout(r0);
        r0 = 1;
        r5.setUseCaches(r0);
        if (r6 == 0) goto L_0x007c;
    L_0x003d:
        r0 = com.squareup.picasso.NetworkPolicy.m25772c(r6);
        if (r0 == 0) goto L_0x0046;
    L_0x0043:
        r0 = "only-if-cached,max-age=2147483647";
        goto L_0x0077;
    L_0x0046:
        r0 = f30674c;
        r0 = r0.get();
        r0 = (java.lang.StringBuilder) r0;
        r1 = 0;
        r0.setLength(r1);
        r1 = com.squareup.picasso.NetworkPolicy.m25770a(r6);
        if (r1 != 0) goto L_0x005d;
    L_0x0058:
        r1 = "no-cache";
        r0.append(r1);
    L_0x005d:
        r1 = com.squareup.picasso.NetworkPolicy.m25771b(r6);
        if (r1 != 0) goto L_0x0073;
    L_0x0063:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x006e;
    L_0x0069:
        r1 = 44;
        r0.append(r1);
    L_0x006e:
        r1 = "no-store";
        r0.append(r1);
    L_0x0073:
        r0 = r0.toString();
    L_0x0077:
        r1 = "Cache-Control";
        r5.setRequestProperty(r1, r0);
    L_0x007c:
        r0 = r5.getResponseCode();
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r0 < r1) goto L_0x00a5;
    L_0x0084:
        r5.disconnect();
        r1 = new com.squareup.picasso.Downloader$ResponseException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r3 = " ";
        r2.append(r3);
        r5 = r5.getResponseMessage();
        r2.append(r5);
        r5 = r2.toString();
        r1.<init>(r5, r6, r0);
        throw r1;
    L_0x00a5:
        r6 = "Content-Length";
        r0 = -1;
        r6 = r5.getHeaderFieldInt(r6, r0);
        r0 = (long) r6;
        r6 = "X-Android-Response-Source";
        r6 = r5.getHeaderField(r6);
        r6 = com.squareup.picasso.Utils.m25827a(r6);
        r2 = new com.squareup.picasso.Downloader$Response;
        r5 = r5.getInputStream();
        r2.<init>(r5, r6, r0);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.UrlConnectionDownloader.a(android.net.Uri, int):com.squareup.picasso.Downloader$Response");
    }
}
