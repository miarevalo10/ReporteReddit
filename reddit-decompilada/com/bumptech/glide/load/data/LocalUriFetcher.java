package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private final Uri f12325a;
    private final ContentResolver f12326b;
    private T f12327c;

    protected abstract T mo3261a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    protected abstract void mo3262a(T t) throws IOException;

    public final void mo886b() {
    }

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f12326b = contentResolver;
        this.f12325a = uri;
    }

    public final void mo885a(Priority priority, DataCallback<? super T> dataCallback) {
        try {
            this.f12327c = mo3261a(this.f12325a, this.f12326b);
            dataCallback.mo903a(this.f12327c);
        } catch (Exception e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
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
        r0 = r1.f12327c;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.f12327c;	 Catch:{ IOException -> 0x000a }
        r1.mo3262a(r0);	 Catch:{ IOException -> 0x000a }
        return;
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.LocalUriFetcher.a():void");
    }

    public final DataSource mo888d() {
        return DataSource.LOCAL;
    }
}
