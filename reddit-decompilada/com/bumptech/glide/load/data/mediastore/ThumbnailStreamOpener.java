package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    private static final FileService f3348a = new FileService();
    private final FileService f3349b;
    private final ThumbnailQuery f3350c;
    private final ArrayPool f3351d;
    private final ContentResolver f3352e;
    private final List<ImageHeaderParser> f3353f;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f3348a, thumbnailQuery, arrayPool, contentResolver);
    }

    private ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f3349b = fileService;
        this.f3350c = thumbnailQuery;
        this.f3351d = arrayPool;
        this.f3352e = contentResolver;
        this.f3353f = list;
    }

    final int m2879a(android.net.Uri r7) {
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
        r6 = this;
        r0 = 0;
        r1 = r6.f3352e;	 Catch:{ IOException -> 0x001a, IOException -> 0x001a, all -> 0x0017 }
        r1 = r1.openInputStream(r7);	 Catch:{ IOException -> 0x001a, IOException -> 0x001a, all -> 0x0017 }
        r0 = r6.f3353f;	 Catch:{ IOException -> 0x0015, IOException -> 0x0015 }
        r2 = r6.f3351d;	 Catch:{ IOException -> 0x0015, IOException -> 0x0015 }
        r0 = com.bumptech.glide.load.ImageHeaderParserUtils.m2847b(r0, r1, r2);	 Catch:{ IOException -> 0x0015, IOException -> 0x0015 }
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.close();	 Catch:{ IOException -> 0x0014 }
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = move-exception;
        goto L_0x001e;
    L_0x0017:
        r7 = move-exception;
        r1 = r0;
        goto L_0x0042;
    L_0x001a:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x001e:
        r2 = "ThumbStreamOpener";	 Catch:{ all -> 0x0041 }
        r3 = 3;	 Catch:{ all -> 0x0041 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x003a;	 Catch:{ all -> 0x0041 }
    L_0x0027:
        r2 = "ThumbStreamOpener";	 Catch:{ all -> 0x0041 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r4 = "Failed to open uri: ";	 Catch:{ all -> 0x0041 }
        r3.<init>(r4);	 Catch:{ all -> 0x0041 }
        r3.append(r7);	 Catch:{ all -> 0x0041 }
        r7 = r3.toString();	 Catch:{ all -> 0x0041 }
        android.util.Log.d(r2, r7, r0);	 Catch:{ all -> 0x0041 }
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();	 Catch:{ IOException -> 0x003f }
    L_0x003f:
        r7 = -1;
        return r7;
    L_0x0041:
        r7 = move-exception;
    L_0x0042:
        if (r1 == 0) goto L_0x0047;
    L_0x0044:
        r1.close();	 Catch:{ IOException -> 0x0047 }
    L_0x0047:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.a(android.net.Uri):int");
    }

    public final InputStream m2880b(Uri uri) throws FileNotFoundException {
        String c = m2878c(uri);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        File a = FileService.m2869a(c);
        Object obj = (!FileService.m2870a(a) || 0 >= FileService.m2871b(a)) ? null : 1;
        if (obj == null) {
            return null;
        }
        Uri fromFile = Uri.fromFile(a);
        try {
            return this.f3352e.openInputStream(fromFile);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("NPE opening uri: ");
            stringBuilder.append(uri);
            stringBuilder.append(" -> ");
            stringBuilder.append(fromFile);
            throw ((FileNotFoundException) new FileNotFoundException(stringBuilder.toString()).initCause(e));
        }
    }

    private String m2878c(Uri uri) {
        uri = this.f3350c.mo901a(uri);
        if (uri != null) {
            try {
                if (uri.moveToFirst()) {
                    String string = uri.getString(0);
                    return string;
                }
            } finally {
                if (uri != null) {
                    uri.close();
                }
            }
        }
        if (uri != null) {
            uri.close();
        }
        return null;
    }
}
