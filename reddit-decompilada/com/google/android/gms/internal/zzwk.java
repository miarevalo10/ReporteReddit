package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;

final /* synthetic */ class zzwk {
    static final /* synthetic */ int[] f8116a = new int[ErrorCode.values().length];
    private static /* synthetic */ int[] f8117b = new int[Gender.values().length];

    static {
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
        r0 = com.google.ads.AdRequest.ErrorCode.values();
        r0 = r0.length;
        r0 = new int[r0];
        f8116a = r0;
        r0 = 1;
        r1 = f8116a;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
    L_0x0014:
        r1 = 2;
        r2 = f8116a;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
        r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
    L_0x001f:
        r2 = 3;
        r3 = f8116a;	 Catch:{ NoSuchFieldError -> 0x002a }
        r4 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR;	 Catch:{ NoSuchFieldError -> 0x002a }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
        r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
    L_0x002a:
        r3 = f8116a;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r4 = com.google.ads.AdRequest.ErrorCode.NO_FILL;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
        r5 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r3[r4] = r5;	 Catch:{ NoSuchFieldError -> 0x0035 }
    L_0x0035:
        r3 = com.google.ads.AdRequest.Gender.values();
        r3 = r3.length;
        r3 = new int[r3];
        f8117b = r3;
        r3 = f8117b;	 Catch:{ NoSuchFieldError -> 0x0048 }
        r4 = com.google.ads.AdRequest.Gender.FEMALE;	 Catch:{ NoSuchFieldError -> 0x0048 }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0048 }
        r3[r4] = r0;	 Catch:{ NoSuchFieldError -> 0x0048 }
    L_0x0048:
        r0 = f8117b;	 Catch:{ NoSuchFieldError -> 0x0052 }
        r3 = com.google.ads.AdRequest.Gender.MALE;	 Catch:{ NoSuchFieldError -> 0x0052 }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0052 }
        r0[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x0052 }
    L_0x0052:
        r0 = f8117b;	 Catch:{ NoSuchFieldError -> 0x005c }
        r1 = com.google.ads.AdRequest.Gender.UNKNOWN;	 Catch:{ NoSuchFieldError -> 0x005c }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x005c }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x005c }
    L_0x005c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwk.<clinit>():void");
    }
}
