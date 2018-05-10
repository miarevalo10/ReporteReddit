package com.reddit.frontpage.util;

public class CryptoUtil {
    public static java.lang.String m23678a(java.lang.String r5, byte[] r6) {
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
        r0 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r1 = "HmacSHA256";	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r0.<init>(r6, r1);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r6 = "HmacSHA256";	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r6 = javax.crypto.Mac.getInstance(r6);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r6.init(r0);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r5 = r5.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r5 = r6.doFinal(r5);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r6.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r0 = r5.length;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r1 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
    L_0x0021:
        if (r1 >= r0) goto L_0x003e;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
    L_0x0023:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r3 = r5[r1];	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r2 = r2 & r3;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r2 = java.lang.Integer.toHexString(r2);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r3 = r2.length();	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r4 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        if (r3 != r4) goto L_0x0038;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
    L_0x0033:
        r3 = 48;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r6.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
    L_0x0038:
        r6.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        r1 = r1 + 1;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        goto L_0x0021;	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
    L_0x003e:
        r5 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043, UnsupportedEncodingException -> 0x0043 }
        return r5;
    L_0x0043:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.CryptoUtil.a(java.lang.String, byte[]):java.lang.String");
    }

    public static java.lang.String m23679a(byte[] r5, byte[] r6) {
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
        r0 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r1 = "HmacSHA256";	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r0.<init>(r6, r1);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r6 = "HmacSHA256";	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r6 = javax.crypto.Mac.getInstance(r6);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r6.init(r0);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r5 = r6.doFinal(r5);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r6 = new java.lang.StringBuilder;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r6.<init>();	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r0 = r5.length;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r1 = 0;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
    L_0x001b:
        if (r1 >= r0) goto L_0x0038;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
    L_0x001d:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r3 = r5[r1];	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r2 = r2 & r3;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r2 = java.lang.Integer.toHexString(r2);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r3 = r2.length();	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r4 = 1;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        if (r3 != r4) goto L_0x0032;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
    L_0x002d:
        r3 = 48;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r6.append(r3);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
    L_0x0032:
        r6.append(r2);	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        r1 = r1 + 1;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        goto L_0x001b;	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
    L_0x0038:
        r5 = r6.toString();	 Catch:{ InvalidKeyException -> 0x003d, InvalidKeyException -> 0x003d }
        return r5;
    L_0x003d:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.CryptoUtil.a(byte[], byte[]):java.lang.String");
    }
}
