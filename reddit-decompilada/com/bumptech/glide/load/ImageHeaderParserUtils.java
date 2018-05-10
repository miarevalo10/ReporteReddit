package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
    public static com.bumptech.glide.load.ImageHeaderParser.ImageType m2845a(java.util.List<com.bumptech.glide.load.ImageHeaderParser> r3, java.io.InputStream r4, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        if (r4 != 0) goto L_0x0005;
    L_0x0002:
        r3 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
        return r3;
    L_0x0005:
        r0 = r4.markSupported();
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r0 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
        r0.<init>(r4, r5);
        r4 = r0;
    L_0x0011:
        r5 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r4.mark(r5);
        r5 = 0;
        r0 = r3.size();
    L_0x001b:
        if (r5 >= r0) goto L_0x003a;
    L_0x001d:
        r1 = r3.get(r5);
        r1 = (com.bumptech.glide.load.ImageHeaderParser) r1;
        r1 = r1.mo988a(r4);	 Catch:{ all -> 0x0035 }
        r2 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;	 Catch:{ all -> 0x0035 }
        if (r1 == r2) goto L_0x002f;
    L_0x002b:
        r4.reset();
        return r1;
    L_0x002f:
        r4.reset();
        r5 = r5 + 1;
        goto L_0x001b;
    L_0x0035:
        r3 = move-exception;
        r4.reset();
        throw r3;
    L_0x003a:
        r3 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils.a(java.util.List, java.io.InputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public static int m2847b(java.util.List<com.bumptech.glide.load.ImageHeaderParser> r4, java.io.InputStream r5, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = -1;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5.markSupported();
        if (r1 != 0) goto L_0x0010;
    L_0x000a:
        r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
        r1.<init>(r5, r6);
        r5 = r1;
    L_0x0010:
        r1 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r5.mark(r1);
        r1 = 0;
        r2 = r4.size();
    L_0x001a:
        if (r1 >= r2) goto L_0x0037;
    L_0x001c:
        r3 = r4.get(r1);
        r3 = (com.bumptech.glide.load.ImageHeaderParser) r3;
        r3 = r3.mo987a(r5, r6);	 Catch:{ all -> 0x0032 }
        if (r3 == r0) goto L_0x002c;
    L_0x0028:
        r5.reset();
        return r3;
    L_0x002c:
        r5.reset();
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x0032:
        r4 = move-exception;
        r5.reset();
        throw r4;
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils.b(java.util.List, java.io.InputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool):int");
    }

    public static ImageType m2846a(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageType a = ((ImageHeaderParser) list.get(i)).mo989a(byteBuffer);
            if (a != ImageType.UNKNOWN) {
                return a;
            }
        }
        return ImageType.UNKNOWN;
    }
}
