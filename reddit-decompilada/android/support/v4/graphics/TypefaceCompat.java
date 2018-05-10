package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.support.v4.util.LruCache;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public class TypefaceCompat {
    private static final TypefaceCompatImpl f1244a;
    private static final LruCache<String, Typeface> f1245b = new LruCache(16);

    interface TypefaceCompatImpl {
        Typeface mo269a(Context context, Resources resources, int i, String str, int i2);

        Typeface mo270a(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i);

        Typeface mo271a(Context context, FontInfo[] fontInfoArr, int i);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1244a = new TypefaceCompatApi26Impl();
        } else if (VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.m16630a()) {
            f1244a = new TypefaceCompatApi24Impl();
        } else if (VERSION.SDK_INT >= 21) {
            f1244a = new TypefaceCompatApi21Impl();
        } else {
            f1244a = new TypefaceCompatBaseImpl();
        }
    }

    public static Typeface m818a(Resources resources, int i, int i2) {
        return (Typeface) f1245b.get(m819b(resources, i, i2));
    }

    private static String m819b(Resources resources, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(i));
        stringBuilder.append(Operation.MINUS);
        stringBuilder.append(i);
        stringBuilder.append(Operation.MINUS);
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface m816a(android.content.Context r9, android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry r10, android.content.res.Resources r11, int r12, int r13, android.support.v4.content.res.ResourcesCompat.FontCallback r14, boolean r15) {
        /*
        r0 = r10 instanceof android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry;
        if (r0 == 0) goto L_0x0027;
    L_0x0004:
        r10 = (android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry) r10;
        r0 = 0;
        r1 = 1;
        if (r15 == 0) goto L_0x0012;
    L_0x000a:
        r2 = r10.f11419c;
        if (r2 != 0) goto L_0x0010;
    L_0x000e:
        r6 = r1;
        goto L_0x0015;
    L_0x0010:
        r6 = r0;
        goto L_0x0015;
    L_0x0012:
        if (r14 != 0) goto L_0x0010;
    L_0x0014:
        goto L_0x000e;
    L_0x0015:
        if (r15 == 0) goto L_0x001b;
    L_0x0017:
        r15 = r10.f11418b;
    L_0x0019:
        r7 = r15;
        goto L_0x001d;
    L_0x001b:
        r15 = -1;
        goto L_0x0019;
    L_0x001d:
        r4 = r10.f11417a;
        r3 = r9;
        r5 = r14;
        r8 = r13;
        r9 = android.support.v4.provider.FontsContractCompat.m976a(r3, r4, r5, r6, r7, r8);
        goto L_0x003c;
    L_0x0027:
        r15 = f1244a;
        r10 = (android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry) r10;
        r9 = r15.mo270a(r9, r10, r11, r13);
        if (r14 == 0) goto L_0x003c;
    L_0x0031:
        r10 = 0;
        if (r9 == 0) goto L_0x0038;
    L_0x0034:
        r14.m769a(r9, r10);
        goto L_0x003c;
    L_0x0038:
        r15 = -3;
        r14.m767a(r15, r10);
    L_0x003c:
        if (r9 == 0) goto L_0x0047;
    L_0x003e:
        r10 = f1245b;
        r11 = m819b(r11, r12, r13);
        r10.put(r11, r9);
    L_0x0047:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompat.a(android.content.Context, android.support.v4.content.res.FontResourcesParserCompat$FamilyResourceEntry, android.content.res.Resources, int, int, android.support.v4.content.res.ResourcesCompat$FontCallback, boolean):android.graphics.Typeface");
    }

    public static Typeface m815a(Context context, Resources resources, int i, String str, int i2) {
        context = f1244a.mo269a(context, resources, i, str, i2);
        if (context != null) {
            f1245b.put(m819b(resources, i, i2), context);
        }
        return context;
    }

    public static Typeface m817a(Context context, FontInfo[] fontInfoArr, int i) {
        return f1244a.mo271a(context, fontInfoArr, i);
    }
}
