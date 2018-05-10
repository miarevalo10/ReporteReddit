package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Integer> f16731a = Option.m2851a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
    public static final Option<CompressFormat> f16732b = Option.m2850a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    private static boolean m17016a(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r7, java.io.File r8, com.bumptech.glide.load.Options r9) {
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
        r7 = r7.mo926b();
        r7 = (android.graphics.Bitmap) r7;
        r0 = f16732b;
        r0 = r9.m11235a(r0);
        r0 = (android.graphics.Bitmap.CompressFormat) r0;
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        goto L_0x001c;
    L_0x0011:
        r0 = r7.hasAlpha();
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0 = android.graphics.Bitmap.CompressFormat.PNG;
        goto L_0x001c;
    L_0x001a:
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;
    L_0x001c:
        r1 = new java.lang.StringBuilder;
        r2 = "encode: [";
        r1.<init>(r2);
        r2 = r7.getWidth();
        r1.append(r2);
        r2 = "x";
        r1.append(r2);
        r2 = r7.getHeight();
        r1.append(r2);
        r2 = "] ";
        r1.append(r2);
        r1.append(r0);
        r1 = r1.toString();
        android.support.v4.os.TraceCompat.m975a(r1);
        r1 = com.bumptech.glide.util.LogTime.m3213a();	 Catch:{ all -> 0x00dd }
        r3 = f16731a;	 Catch:{ all -> 0x00dd }
        r3 = r9.m11235a(r3);	 Catch:{ all -> 0x00dd }
        r3 = (java.lang.Integer) r3;	 Catch:{ all -> 0x00dd }
        r3 = r3.intValue();	 Catch:{ all -> 0x00dd }
        r4 = 0;
        r5 = 0;
        r6 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x006f }
        r6.<init>(r8);	 Catch:{ IOException -> 0x006f }
        r7.compress(r0, r3, r6);	 Catch:{ IOException -> 0x006a, all -> 0x0067 }
        r6.close();	 Catch:{ IOException -> 0x006a, all -> 0x0067 }
        r4 = 1;
        r6.close();	 Catch:{ IOException -> 0x0085 }
        goto L_0x0085;
    L_0x0067:
        r7 = move-exception;
        r5 = r6;
        goto L_0x00d7;
    L_0x006a:
        r8 = move-exception;
        r5 = r6;
        goto L_0x0070;
    L_0x006d:
        r7 = move-exception;
        goto L_0x00d7;
    L_0x006f:
        r8 = move-exception;
    L_0x0070:
        r3 = "BitmapEncoder";	 Catch:{ all -> 0x006d }
        r6 = 3;	 Catch:{ all -> 0x006d }
        r3 = android.util.Log.isLoggable(r3, r6);	 Catch:{ all -> 0x006d }
        if (r3 == 0) goto L_0x0080;	 Catch:{ all -> 0x006d }
    L_0x0079:
        r3 = "BitmapEncoder";	 Catch:{ all -> 0x006d }
        r6 = "Failed to encode Bitmap";	 Catch:{ all -> 0x006d }
        android.util.Log.d(r3, r6, r8);	 Catch:{ all -> 0x006d }
    L_0x0080:
        if (r5 == 0) goto L_0x0085;
    L_0x0082:
        r5.close();	 Catch:{ IOException -> 0x0085 }
    L_0x0085:
        r8 = "BitmapEncoder";	 Catch:{ all -> 0x00dd }
        r3 = 2;	 Catch:{ all -> 0x00dd }
        r8 = android.util.Log.isLoggable(r8, r3);	 Catch:{ all -> 0x00dd }
        if (r8 == 0) goto L_0x00d3;	 Catch:{ all -> 0x00dd }
    L_0x008e:
        r8 = "BitmapEncoder";	 Catch:{ all -> 0x00dd }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dd }
        r5 = "Compressed with type: ";	 Catch:{ all -> 0x00dd }
        r3.<init>(r5);	 Catch:{ all -> 0x00dd }
        r3.append(r0);	 Catch:{ all -> 0x00dd }
        r0 = " of size ";	 Catch:{ all -> 0x00dd }
        r3.append(r0);	 Catch:{ all -> 0x00dd }
        r0 = com.bumptech.glide.util.Util.m3224a(r7);	 Catch:{ all -> 0x00dd }
        r3.append(r0);	 Catch:{ all -> 0x00dd }
        r0 = " in ";	 Catch:{ all -> 0x00dd }
        r3.append(r0);	 Catch:{ all -> 0x00dd }
        r0 = com.bumptech.glide.util.LogTime.m3212a(r1);	 Catch:{ all -> 0x00dd }
        r3.append(r0);	 Catch:{ all -> 0x00dd }
        r0 = ", options format: ";	 Catch:{ all -> 0x00dd }
        r3.append(r0);	 Catch:{ all -> 0x00dd }
        r0 = f16732b;	 Catch:{ all -> 0x00dd }
        r9 = r9.m11235a(r0);	 Catch:{ all -> 0x00dd }
        r3.append(r9);	 Catch:{ all -> 0x00dd }
        r9 = ", hasAlpha: ";	 Catch:{ all -> 0x00dd }
        r3.append(r9);	 Catch:{ all -> 0x00dd }
        r7 = r7.hasAlpha();	 Catch:{ all -> 0x00dd }
        r3.append(r7);	 Catch:{ all -> 0x00dd }
        r7 = r3.toString();	 Catch:{ all -> 0x00dd }
        android.util.Log.v(r8, r7);	 Catch:{ all -> 0x00dd }
    L_0x00d3:
        android.support.v4.os.TraceCompat.m974a();
        return r4;
    L_0x00d7:
        if (r5 == 0) goto L_0x00dc;
    L_0x00d9:
        r5.close();	 Catch:{ IOException -> 0x00dc }
    L_0x00dc:
        throw r7;	 Catch:{ all -> 0x00dd }
    L_0x00dd:
        r7 = move-exception;
        android.support.v4.os.TraceCompat.m974a();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.a(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    public final EncodeStrategy mo3265a(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
