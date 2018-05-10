package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    private final Context f12618a;

    public final /* bridge */ /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        return m11653a((Uri) obj);
    }

    public final /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return ((Uri) obj).getScheme().equals("android.resource");
    }

    public ResourceDrawableDecoder(Context context) {
        this.f12618a = context.getApplicationContext();
    }

    public final Resource<Drawable> m11653a(Uri uri) {
        int b = m11652b(uri);
        String authority = uri.getAuthority();
        return NonOwnedDrawableResource.m17024a(DrawableDecoderCompat.m3065a(authority.equals(this.f12618a.getPackageName()) ? this.f12618a : m11651a(uri, authority), b));
    }

    private Context m11651a(Uri uri, String str) {
        try {
            return this.f12618a.createPackageContext(str, 0);
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder("Failed to obtain context or unrecognized Uri format for: ");
            stringBuilder.append(uri);
            throw new IllegalArgumentException(stringBuilder.toString(), str2);
        }
    }

    private int m11652b(android.net.Uri r6) {
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
        r5 = this;
        r0 = r6.getPathSegments();
        r1 = r0.size();
        r2 = 1;
        r3 = 0;
        r4 = 2;
        if (r1 != r4) goto L_0x002c;
    L_0x000d:
        r1 = r6.getAuthority();
        r3 = r0.get(r3);
        r3 = (java.lang.String) r3;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = r5.f12618a;
        r2 = r2.getResources();
        r0 = r2.getIdentifier(r0, r3, r1);
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x003e;
    L_0x002c:
        r1 = r0.size();
        if (r1 != r2) goto L_0x003d;
    L_0x0032:
        r0 = r0.get(r3);	 Catch:{ NumberFormatException -> 0x003d }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x003d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x003d }
        goto L_0x003e;
    L_0x003d:
        r0 = 0;
    L_0x003e:
        if (r0 != 0) goto L_0x0054;
    L_0x0040:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unrecognized Uri format: ";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x0054:
        r1 = r0.intValue();
        if (r1 != 0) goto L_0x006e;
    L_0x005a:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Failed to obtain resource id for: ";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x006e:
        r6 = r0.intValue();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder.b(android.net.Uri):int");
    }
}
