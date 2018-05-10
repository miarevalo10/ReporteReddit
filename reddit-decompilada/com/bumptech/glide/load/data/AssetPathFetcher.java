package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private final String f12312a;
    private final AssetManager f12313b;
    private T f12314c;

    protected abstract T mo3263a(AssetManager assetManager, String str) throws IOException;

    protected abstract void mo3264a(T t) throws IOException;

    public final void mo886b() {
    }

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f12313b = assetManager;
        this.f12312a = str;
    }

    public final void mo885a(Priority priority, DataCallback<? super T> dataCallback) {
        try {
            this.f12314c = mo3263a(this.f12313b, this.f12312a);
            dataCallback.mo903a(this.f12314c);
        } catch (Exception e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.mo902a(e);
        }
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
        r0 = r1.f12314c;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r1.f12314c;	 Catch:{ IOException -> 0x000b }
        r1.mo3264a(r0);	 Catch:{ IOException -> 0x000b }
        return;
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.AssetPathFetcher.a():void");
    }

    public final DataSource mo888d() {
        return DataSource.LOCAL;
    }
}
