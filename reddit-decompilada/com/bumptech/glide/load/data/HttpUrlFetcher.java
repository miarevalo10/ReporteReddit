package com.bumptech.glide.load.data;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    static final HttpUrlConnectionFactory f12316a = new DefaultHttpUrlConnectionFactory();
    private final GlideUrl f12317b;
    private final int f12318c;
    private final HttpUrlConnectionFactory f12319d;
    private HttpURLConnection f12320e;
    private InputStream f12321f;
    private volatile boolean f12322g;

    interface HttpUrlConnectionFactory {
        HttpURLConnection mo900a(URL url) throws IOException;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        public final HttpURLConnection mo900a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, f12316a);
    }

    private HttpUrlFetcher(GlideUrl glideUrl, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.f12317b = glideUrl;
        this.f12318c = i;
        this.f12319d = httpUrlConnectionFactory;
    }

    public final void mo885a(Priority priority, DataCallback<? super InputStream> dataCallback) {
        long a = LogTime.m3213a();
        try {
            GlideUrl glideUrl = this.f12317b;
            if (glideUrl.f12536b == null) {
                glideUrl.f12536b = new URL(glideUrl.m11489a());
            }
            dataCallback.mo903a(m11251a(glideUrl.f12536b, 0, null, this.f12317b.m11491b()));
            if (Log.isLoggable("HttpUrlFetcher", 2) != null) {
                priority = "HttpUrlFetcher";
                dataCallback = new StringBuilder("Finished http url fetcher fetch in ");
                dataCallback.append(LogTime.m3212a(a));
                Log.v(priority, dataCallback.toString());
            }
        } catch (Exception e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e);
            }
            dataCallback.mo902a(e);
            if (Log.isLoggable("HttpUrlFetcher", 2) != null) {
                priority = "HttpUrlFetcher";
                dataCallback = new StringBuilder("Finished http url fetcher fetch in ");
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2) != null) {
                StringBuilder stringBuilder = new StringBuilder("Finished http url fetcher fetch in ");
                stringBuilder.append(LogTime.m3212a(a));
                Log.v("HttpUrlFetcher", stringBuilder.toString());
            }
        }
    }

    private java.io.InputStream m11251a(java.net.URL r6, int r7, java.net.URL r8, java.util.Map<java.lang.String, java.lang.String> r9) throws java.io.IOException {
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
        r5 = this;
    L_0x0000:
        r0 = 5;
        if (r7 < r0) goto L_0x000b;
    L_0x0003:
        r6 = new com.bumptech.glide.load.HttpException;
        r7 = "Too many (> 5) redirects!";
        r6.<init>(r7);
        throw r6;
    L_0x000b:
        if (r8 == 0) goto L_0x0023;
    L_0x000d:
        r0 = r6.toURI();	 Catch:{ URISyntaxException -> 0x0023 }
        r8 = r8.toURI();	 Catch:{ URISyntaxException -> 0x0023 }
        r8 = r0.equals(r8);	 Catch:{ URISyntaxException -> 0x0023 }
        if (r8 == 0) goto L_0x0023;	 Catch:{ URISyntaxException -> 0x0023 }
    L_0x001b:
        r8 = new com.bumptech.glide.load.HttpException;	 Catch:{ URISyntaxException -> 0x0023 }
        r0 = "In re-direct loop";	 Catch:{ URISyntaxException -> 0x0023 }
        r8.<init>(r0);	 Catch:{ URISyntaxException -> 0x0023 }
        throw r8;	 Catch:{ URISyntaxException -> 0x0023 }
    L_0x0023:
        r8 = r5.f12319d;
        r8 = r8.mo900a(r6);
        r5.f12320e = r8;
        r8 = r9.entrySet();
        r8 = r8.iterator();
    L_0x0033:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0051;
    L_0x0039:
        r0 = r8.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r5.f12320e;
        r2 = r0.getKey();
        r2 = (java.lang.String) r2;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r1.addRequestProperty(r2, r0);
        goto L_0x0033;
    L_0x0051:
        r8 = r5.f12320e;
        r0 = r5.f12318c;
        r8.setConnectTimeout(r0);
        r8 = r5.f12320e;
        r0 = r5.f12318c;
        r8.setReadTimeout(r0);
        r8 = r5.f12320e;
        r0 = 0;
        r8.setUseCaches(r0);
        r8 = r5.f12320e;
        r1 = 1;
        r8.setDoInput(r1);
        r8 = r5.f12320e;
        r8.setInstanceFollowRedirects(r0);
        r8 = r5.f12320e;
        r8.connect();
        r8 = r5.f12320e;
        r8 = r8.getInputStream();
        r5.f12321f = r8;
        r8 = r5.f12322g;
        if (r8 == 0) goto L_0x0083;
    L_0x0081:
        r6 = 0;
        return r6;
    L_0x0083:
        r8 = r5.f12320e;
        r8 = r8.getResponseCode();
        r2 = r8 / 100;
        r3 = 2;
        if (r2 != r3) goto L_0x0090;
    L_0x008e:
        r3 = r1;
        goto L_0x0091;
    L_0x0090:
        r3 = r0;
    L_0x0091:
        r4 = 3;
        if (r3 == 0) goto L_0x00d8;
    L_0x0094:
        r6 = r5.f12320e;
        r7 = r6.getContentEncoding();
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x00b0;
    L_0x00a0:
        r7 = r6.getContentLength();
        r6 = r6.getInputStream();
        r7 = (long) r7;
        r6 = com.bumptech.glide.util.ContentLengthInputStream.m3209a(r6, r7);
        r5.f12321f = r6;
        goto L_0x00d5;
    L_0x00b0:
        r7 = "HttpUrlFetcher";
        r7 = android.util.Log.isLoggable(r7, r4);
        if (r7 == 0) goto L_0x00cf;
    L_0x00b8:
        r7 = "HttpUrlFetcher";
        r8 = new java.lang.StringBuilder;
        r9 = "Got non empty content encoding: ";
        r8.<init>(r9);
        r9 = r6.getContentEncoding();
        r8.append(r9);
        r8 = r8.toString();
        android.util.Log.d(r7, r8);
    L_0x00cf:
        r6 = r6.getInputStream();
        r5.f12321f = r6;
    L_0x00d5:
        r6 = r5.f12321f;
        return r6;
    L_0x00d8:
        if (r2 != r4) goto L_0x00db;
    L_0x00da:
        r0 = r1;
    L_0x00db:
        if (r0 == 0) goto L_0x0101;
    L_0x00dd:
        r8 = r5.f12320e;
        r0 = "Location";
        r8 = r8.getHeaderField(r0);
        r0 = android.text.TextUtils.isEmpty(r8);
        if (r0 == 0) goto L_0x00f3;
    L_0x00eb:
        r6 = new com.bumptech.glide.load.HttpException;
        r7 = "Received empty or null redirect url";
        r6.<init>(r7);
        throw r6;
    L_0x00f3:
        r0 = new java.net.URL;
        r0.<init>(r6, r8);
        r5.mo884a();
        r7 = r7 + 1;
        r8 = r6;
        r6 = r0;
        goto L_0x0000;
    L_0x0101:
        r6 = -1;
        if (r8 != r6) goto L_0x010a;
    L_0x0104:
        r6 = new com.bumptech.glide.load.HttpException;
        r6.<init>(r8);
        throw r6;
    L_0x010a:
        r6 = new com.bumptech.glide.load.HttpException;
        r7 = r5.f12320e;
        r7 = r7.getResponseMessage();
        r6.<init>(r7, r8);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.HttpUrlFetcher.a(java.net.URL, int, java.net.URL, java.util.Map):java.io.InputStream");
    }

    public final void mo884a() {
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
        r0 = r1.f12321f;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.f12321f;	 Catch:{ IOException -> 0x0009 }
        r0.close();	 Catch:{ IOException -> 0x0009 }
    L_0x0009:
        r0 = r1.f12320e;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r1.f12320e;
        r0.disconnect();
    L_0x0012:
        r0 = 0;
        r1.f12320e = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.HttpUrlFetcher.a():void");
    }

    public final void mo886b() {
        this.f12322g = true;
    }

    public final Class<InputStream> mo887c() {
        return InputStream.class;
    }

    public final DataSource mo888d() {
        return DataSource.REMOTE;
    }
}
