package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.graphics.drawable.Drawable;

public final class DrawableDecoderCompat {
    private static volatile boolean f3554a = true;

    public static Drawable m3065a(Context context, int i) {
        return m3066a(context, i, null);
    }

    public static android.graphics.drawable.Drawable m3066a(android.content.Context r1, int r2, android.content.res.Resources.Theme r3) {
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
        r0 = f3554a;	 Catch:{ NoClassDefFoundError -> 0x0009, NotFoundException -> 0x000c }
        if (r0 == 0) goto L_0x000c;	 Catch:{ NoClassDefFoundError -> 0x0009, NotFoundException -> 0x000c }
    L_0x0004:
        r0 = android.support.v7.content.res.AppCompatResources.m1570b(r1, r2);	 Catch:{ NoClassDefFoundError -> 0x0009, NotFoundException -> 0x000c }
        return r0;
    L_0x0009:
        r0 = 0;
        f3554a = r0;
    L_0x000c:
        if (r3 == 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0013;
    L_0x000f:
        r3 = r1.getTheme();
    L_0x0013:
        r1 = r1.getResources();
        r1 = android.support.v4.content.res.ResourcesCompat.m774a(r1, r2, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.a(android.content.Context, int, android.content.res.Resources$Theme):android.graphics.drawable.Drawable");
    }
}
