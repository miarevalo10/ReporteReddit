package com.reddit.datalibrary.frontpage.requests.images;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpProgressStreamFetcher implements DataFetcher<InputStream> {
    InputStream f16340a;
    ResponseBody f16341b;
    private final Factory f16342c;
    private final GlideUrl f16343d;
    private volatile Call f16344e;

    public OkHttpProgressStreamFetcher(Factory factory, GlideUrl glideUrl) {
        this.f16343d = glideUrl;
        this.f16342c = factory;
    }

    public final void mo885a(Priority priority, final DataCallback<? super InputStream> dataCallback) {
        priority = new Builder().url(this.f16343d.m11489a());
        priority.tag(TAG.f10925a);

        for (Entry entry : this.f16343d.m11491b().entrySet()) {
            priority.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        this.f16344e = this.f16342c.newCall(priority.build());
        this.f16344e.enqueue(new Callback(this) {
            final /* synthetic */ OkHttpProgressStreamFetcher f16339b;

            public void onFailure(Call call, IOException iOException) {
                if (Log.isLoggable("OkHttpPSFetcher", 3) != null) {
                    Log.d("OkHttpPSFetcher", "OkHttp failed to obtain result", iOException);
                }
                dataCallback.mo902a((Exception) iOException);
            }

            public void onResponse(Call call, Response response) throws IOException {
                this.f16339b.f16341b = response.body();
                if (response.isSuccessful() != null) {
                    call = this.f16339b.f16341b.contentLength();
                    this.f16339b.f16340a = ContentLengthInputStream.m3209a(this.f16339b.f16341b.byteStream(), call);
                    dataCallback.mo903a(this.f16339b.f16340a);
                    return;
                }
                dataCallback.mo902a(new HttpException(response.message(), response.code()));
            }
        });
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
        r0 = r1.f16340a;	 Catch:{ IOException -> 0x0009 }
        if (r0 == 0) goto L_0x0009;	 Catch:{ IOException -> 0x0009 }
    L_0x0004:
        r0 = r1.f16340a;	 Catch:{ IOException -> 0x0009 }
        r0.close();	 Catch:{ IOException -> 0x0009 }
    L_0x0009:
        r0 = r1.f16341b;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r1.f16341b;
        r0.close();
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.images.OkHttpProgressStreamFetcher.a():void");
    }

    public final void mo886b() {
        if (this.f16344e != null) {
            this.f16344e.cancel();
        }
    }

    public final Class<InputStream> mo887c() {
        return InputStream.class;
    }

    public final DataSource mo888d() {
        return DataSource.REMOTE;
    }
}
