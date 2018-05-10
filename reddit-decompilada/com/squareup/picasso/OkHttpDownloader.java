package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Downloader.Response;
import com.squareup.picasso.Downloader.ResponseException;
import java.io.File;
import java.io.IOException;

public class OkHttpDownloader implements Downloader {
    private final OkHttpClient f30670a;

    public OkHttpDownloader(Context context) {
        this(Utils.m25828b(context));
    }

    private OkHttpDownloader(File file) {
        this(file, Utils.m25814a(file));
    }

    private OkHttpDownloader(OkHttpClient okHttpClient) {
        this.f30670a = okHttpClient;
    }

    public final Response mo5459a(Uri uri, int i) throws IOException {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.m25772c(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            Builder builder = new Builder();
            if (!NetworkPolicy.m25770a(i)) {
                builder.noCache();
            }
            if (!NetworkPolicy.m25771b(i)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        uri = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            uri.cacheControl(cacheControl);
        }
        uri = this.f30670a.newCall(uri.build()).execute();
        int code = uri.code();
        if (code >= 300) {
            uri.body().close();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(code);
            stringBuilder.append(" ");
            stringBuilder.append(uri.message());
            throw new ResponseException(stringBuilder.toString(), i, code);
        }
        i = uri.cacheResponse() != 0 ? 1 : 0;
        uri = uri.body();
        return new Response(uri.byteStream(), i, uri.contentLength());
    }

    private OkHttpDownloader(java.io.File r5, long r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new com.squareup.okhttp.OkHttpClient;
        r0.<init>();
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r0.setConnectTimeout(r2, r1);
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0.setReadTimeout(r2, r1);
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r0.setWriteTimeout(r2, r1);
        r4.<init>(r0);
        r0 = r4.f30670a;	 Catch:{ IOException -> 0x0026 }
        r1 = new com.squareup.okhttp.Cache;	 Catch:{ IOException -> 0x0026 }
        r1.<init>(r5, r6);	 Catch:{ IOException -> 0x0026 }
        r0.setCache(r1);	 Catch:{ IOException -> 0x0026 }
        return;
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.OkHttpDownloader.<init>(java.io.File, long):void");
    }
}
