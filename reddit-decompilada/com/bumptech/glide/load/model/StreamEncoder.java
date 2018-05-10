package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private final ArrayPool f12566a;

    public final /* bridge */ /* synthetic */ boolean mo969a(Object obj, File file, Options options) {
        return m11523a((InputStream) obj, file);
    }

    public StreamEncoder(ArrayPool arrayPool) {
        this.f12566a = arrayPool;
    }

    private boolean m11523a(java.io.InputStream r5, java.io.File r6) {
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
        r4 = this;
        r0 = r4.f12566a;
        r1 = byte[].class;
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.mo946a(r2, r1);
        r0 = (byte[]) r0;
        r1 = 0;
        r2 = 0;
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x002e }
        r3.<init>(r6);	 Catch:{ IOException -> 0x002e }
    L_0x0013:
        r6 = r5.read(r0);	 Catch:{ IOException -> 0x0029, all -> 0x0026 }
        r2 = -1;	 Catch:{ IOException -> 0x0029, all -> 0x0026 }
        if (r6 == r2) goto L_0x001e;	 Catch:{ IOException -> 0x0029, all -> 0x0026 }
    L_0x001a:
        r3.write(r0, r1, r6);	 Catch:{ IOException -> 0x0029, all -> 0x0026 }
        goto L_0x0013;	 Catch:{ IOException -> 0x0029, all -> 0x0026 }
    L_0x001e:
        r3.close();	 Catch:{ IOException -> 0x0029, all -> 0x0026 }
        r1 = 1;
        r3.close();	 Catch:{ IOException -> 0x0044 }
        goto L_0x0044;
    L_0x0026:
        r5 = move-exception;
        r2 = r3;
        goto L_0x004a;
    L_0x0029:
        r5 = move-exception;
        r2 = r3;
        goto L_0x002f;
    L_0x002c:
        r5 = move-exception;
        goto L_0x004a;
    L_0x002e:
        r5 = move-exception;
    L_0x002f:
        r6 = "StreamEncoder";	 Catch:{ all -> 0x002c }
        r3 = 3;	 Catch:{ all -> 0x002c }
        r6 = android.util.Log.isLoggable(r6, r3);	 Catch:{ all -> 0x002c }
        if (r6 == 0) goto L_0x003f;	 Catch:{ all -> 0x002c }
    L_0x0038:
        r6 = "StreamEncoder";	 Catch:{ all -> 0x002c }
        r3 = "Failed to encode data onto the OutputStream";	 Catch:{ all -> 0x002c }
        android.util.Log.d(r6, r3, r5);	 Catch:{ all -> 0x002c }
    L_0x003f:
        if (r2 == 0) goto L_0x0044;
    L_0x0041:
        r2.close();	 Catch:{ IOException -> 0x0044 }
    L_0x0044:
        r5 = r4.f12566a;
        r5.mo950a(r0);
        return r1;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();	 Catch:{ IOException -> 0x004f }
    L_0x004f:
        r6 = r4.f12566a;
        r6.mo950a(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.StreamEncoder.a(java.io.InputStream, java.io.File):boolean");
    }
}
