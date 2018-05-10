package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {
    private final Factory f12302a;
    private final GlideUrl f12303b;
    private InputStream f12304c;
    private ResponseBody f12305d;
    private DataCallback<? super InputStream> f12306e;
    private volatile Call f12307f;

    public OkHttpStreamFetcher(Factory factory, GlideUrl glideUrl) {
        this.f12302a = factory;
        this.f12303b = glideUrl;
    }

    public final void mo885a(Priority priority, DataCallback<? super InputStream> dataCallback) {
        priority = new Builder().url(this.f12303b.m11489a());
        for (Entry entry : this.f12303b.m11491b().entrySet()) {
            priority.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        priority = priority.build();
        this.f12306e = dataCallback;
        this.f12307f = this.f12302a.newCall(priority);
        this.f12307f.enqueue(this);
    }

    public void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3) != null) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f12306e.mo902a((Exception) iOException);
    }

    public void onResponse(Call call, Response response) {
        this.f12305d = response.body();
        if (response.isSuccessful() != null) {
            this.f12304c = ContentLengthInputStream.m3209a(this.f12305d.byteStream(), ((ResponseBody) Preconditions.m3217a(this.f12305d)).contentLength());
            this.f12306e.mo903a(this.f12304c);
            return;
        }
        this.f12306e.mo902a(new HttpException(response.message(), response.code()));
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
        r0 = r1.f12304c;	 Catch:{ IOException -> 0x0009 }
        if (r0 == 0) goto L_0x0009;	 Catch:{ IOException -> 0x0009 }
    L_0x0004:
        r0 = r1.f12304c;	 Catch:{ IOException -> 0x0009 }
        r0.close();	 Catch:{ IOException -> 0x0009 }
    L_0x0009:
        r0 = r1.f12305d;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r1.f12305d;
        r0.close();
    L_0x0012:
        r0 = 0;
        r1.f12306e = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.okhttp3.OkHttpStreamFetcher.a():void");
    }

    public final void mo886b() {
        Call call = this.f12307f;
        if (call != null) {
            call.cancel();
        }
    }

    public final Class<InputStream> mo887c() {
        return InputStream.class;
    }

    public final DataSource mo888d() {
        return DataSource.REMOTE;
    }
}
