package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;

@RequiresApi(14)
class TypefaceCompatBaseImpl implements TypefaceCompatImpl {

    private interface StyleExtractor<T> {
        boolean mo267a(T t);

        int mo268b(T t);
    }

    class C10021 implements StyleExtractor<FontInfo> {
        final /* synthetic */ TypefaceCompatBaseImpl f11420a;

        C10021(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
            this.f11420a = typefaceCompatBaseImpl;
        }

        public final /* bridge */ /* synthetic */ boolean mo267a(Object obj) {
            return ((FontInfo) obj).f1335d;
        }

        public final /* bridge */ /* synthetic */ int mo268b(Object obj) {
            return ((FontInfo) obj).f1334c;
        }
    }

    class C10032 implements StyleExtractor<FontFileResourceEntry> {
        final /* synthetic */ TypefaceCompatBaseImpl f11421a;

        C10032(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
            this.f11421a = typefaceCompatBaseImpl;
        }

        public final /* bridge */ /* synthetic */ boolean mo267a(Object obj) {
            return ((FontFileResourceEntry) obj).f1233c;
        }

        public final /* bridge */ /* synthetic */ int mo268b(Object obj) {
            return ((FontFileResourceEntry) obj).f1232b;
        }
    }

    TypefaceCompatBaseImpl() {
    }

    private static <T> T m10023a(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.mo268b(t2) - i2) * 2) + (styleExtractor.mo267a(t2) == z ? 0 : 1);
            if (t == null || r6 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    protected final FontInfo m10027a(FontInfo[] fontInfoArr, int i) {
        return (FontInfo) m10023a((Object[]) fontInfoArr, i, new C10021(this));
    }

    protected static android.graphics.Typeface m10022a(android.content.Context r1, java.io.InputStream r2) {
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
        r1 = android.support.v4.graphics.TypefaceCompatUtil.m822a(r1);
        r0 = 0;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r2 = android.support.v4.graphics.TypefaceCompatUtil.m828a(r1, r2);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        if (r2 != 0) goto L_0x0012;
    L_0x000e:
        r1.delete();
        return r0;
    L_0x0012:
        r2 = r1.getPath();	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r2 = android.graphics.Typeface.createFromFile(r2);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r1.delete();
        return r2;
    L_0x001e:
        r2 = move-exception;
        r1.delete();
        throw r2;
    L_0x0023:
        r1.delete();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatBaseImpl.a(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    public android.graphics.Typeface mo271a(android.content.Context r3, android.support.v4.provider.FontsContractCompat.FontInfo[] r4, int r5) {
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
        r2 = this;
        r0 = 0;
        r1 = r4.length;
        if (r1 > 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r4 = r2.m10027a(r4, r5);
        r5 = r3.getContentResolver();	 Catch:{ IOException -> 0x0023, all -> 0x001e }
        r4 = r4.f1332a;	 Catch:{ IOException -> 0x0023, all -> 0x001e }
        r4 = r5.openInputStream(r4);	 Catch:{ IOException -> 0x0023, all -> 0x001e }
        r3 = m10022a(r3, r4);	 Catch:{ IOException -> 0x0024, all -> 0x001b }
        android.support.v4.graphics.TypefaceCompatUtil.m826a(r4);
        return r3;
    L_0x001b:
        r3 = move-exception;
        r0 = r4;
        goto L_0x001f;
    L_0x001e:
        r3 = move-exception;
    L_0x001f:
        android.support.v4.graphics.TypefaceCompatUtil.m826a(r0);
        throw r3;
    L_0x0023:
        r4 = r0;
    L_0x0024:
        android.support.v4.graphics.TypefaceCompatUtil.m826a(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatBaseImpl.a(android.content.Context, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public android.graphics.Typeface mo269a(android.content.Context r1, android.content.res.Resources r2, int r3, java.lang.String r4, int r5) {
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
        r0 = this;
        r1 = android.support.v4.graphics.TypefaceCompatUtil.m822a(r1);
        r4 = 0;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r4;
    L_0x0008:
        r2 = android.support.v4.graphics.TypefaceCompatUtil.m827a(r1, r2, r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        if (r2 != 0) goto L_0x0012;
    L_0x000e:
        r1.delete();
        return r4;
    L_0x0012:
        r2 = r1.getPath();	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r2 = android.graphics.Typeface.createFromFile(r2);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r1.delete();
        return r2;
    L_0x001e:
        r2 = move-exception;
        r1.delete();
        throw r2;
    L_0x0023:
        r1.delete();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatBaseImpl.a(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }

    public Typeface mo270a(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontFileResourceEntry fontFileResourceEntry = (FontFileResourceEntry) m10023a(fontFamilyFilesResourceEntry.f11416a, i, new C10032(this));
        if (fontFileResourceEntry == null) {
            return null;
        }
        return TypefaceCompat.m815a(context, resources, fontFileResourceEntry.f1234d, fontFileResourceEntry.f1231a, i);
    }
}
