package com.coremedia.iso;

public final class Utf8 {
    public static byte[] m3308a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (String str2) {
            throw new Error(str2);
        }
    }

    public static String m3307a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (byte[] bArr2) {
            throw new Error(bArr2);
        }
    }

    public static int m3309b(java.lang.String r1) {
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
        if (r1 == 0) goto L_0x0010;
    L_0x0002:
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r1 = r1.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r1 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = new java.lang.RuntimeException;
        r1.<init>();
        throw r1;
    L_0x0010:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coremedia.iso.Utf8.b(java.lang.String):int");
    }
}
