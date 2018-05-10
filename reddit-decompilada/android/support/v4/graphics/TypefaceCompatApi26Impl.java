package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final Class f18846a;
    private static final Constructor f18847b;
    private static final Method f18848c;
    private static final Method f18849d;
    private static final Method f18850e;
    private static final Method f18851f;
    private static final Method f18852g;

    static {
        Class cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method declaredMethod;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method2 = cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method3 = cls.getMethod("freeze", new Class[0]);
            method4 = cls.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
            declaredMethod.setAccessible(true);
            constructor = constructor2;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Unable to collect necessary methods for class ");
            stringBuilder.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", stringBuilder.toString(), e);
            cls = null;
            declaredMethod = cls;
            method = declaredMethod;
            method2 = method;
            method3 = method2;
            method4 = method3;
        }
        f18847b = constructor;
        f18846a = cls;
        f18848c = method;
        f18849d = method2;
        f18850e = method3;
        f18851f = method4;
        f18852g = declaredMethod;
    }

    private static boolean m19912a() {
        if (f18848c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return f18848c != null;
    }

    private static Object m19915b() {
        try {
            return f18847b.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean m19913a(Context context, Object obj, String str, int i, int i2) {
        try {
            return ((Boolean) f18848c.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), null})).booleanValue();
        } catch (Context context2) {
            throw new RuntimeException(context2);
        }
    }

    private static boolean m19914a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) f18849d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static Typeface m19911a(Object obj) {
        try {
            Array.set(Array.newInstance(f18846a, 1), 0, obj);
            return (Typeface) f18852g.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static boolean m19916b(Object obj) {
        try {
            return ((Boolean) f18850e.invoke(obj, new Object[0])).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static void m19917c(Object obj) {
        try {
            f18851f.invoke(obj, new Object[0]);
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    public final Typeface mo270a(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!m19912a()) {
            return super.mo270a(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object b = m19915b();
        fontFamilyFilesResourceEntry = fontFamilyFilesResourceEntry.f11416a;
        i = fontFamilyFilesResourceEntry.length;
        int i2 = 0;
        while (i2 < i) {
            FontFileResourceEntry fontFileResourceEntry = fontFamilyFilesResourceEntry[i2];
            if (m19913a(context, b, fontFileResourceEntry.f1231a, fontFileResourceEntry.f1232b, fontFileResourceEntry.f1233c)) {
                i2++;
            } else {
                m19917c(b);
                return null;
            }
        }
        if (m19916b(b) == null) {
            return null;
        }
        return m19911a(b);
    }

    public final android.graphics.Typeface mo271a(android.content.Context r10, android.support.v4.provider.FontsContractCompat.FontInfo[] r11, int r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = 0;
        r1 = r11.length;
        if (r1 > 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = m19912a();
        if (r1 != 0) goto L_0x0055;
    L_0x000b:
        r11 = r9.m10027a(r11, r12);
        r10 = r10.getContentResolver();
        r12 = r11.f1332a;	 Catch:{ IOException -> 0x0054 }
        r1 = "r";	 Catch:{ IOException -> 0x0054 }
        r10 = r10.openFileDescriptor(r12, r1, r0);	 Catch:{ IOException -> 0x0054 }
        r12 = new android.graphics.Typeface$Builder;	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r1 = r10.getFileDescriptor();	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r12.<init>(r1);	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r1 = r11.f1334c;	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r12 = r12.setWeight(r1);	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r11 = r11.f1335d;	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r11 = r12.setItalic(r11);	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r11 = r11.build();	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        if (r10 == 0) goto L_0x0039;
    L_0x0036:
        r10.close();	 Catch:{ IOException -> 0x0054 }
    L_0x0039:
        return r11;
    L_0x003a:
        r11 = move-exception;
        r12 = r0;
        goto L_0x0043;
    L_0x003d:
        r11 = move-exception;
        throw r11;	 Catch:{ all -> 0x003f }
    L_0x003f:
        r12 = move-exception;
        r8 = r12;
        r12 = r11;
        r11 = r8;
    L_0x0043:
        if (r10 == 0) goto L_0x0053;
    L_0x0045:
        if (r12 == 0) goto L_0x0050;
    L_0x0047:
        r10.close();	 Catch:{ Throwable -> 0x004b }
        goto L_0x0053;
    L_0x004b:
        r10 = move-exception;
        r12.addSuppressed(r10);	 Catch:{ IOException -> 0x0054 }
        goto L_0x0053;	 Catch:{ IOException -> 0x0054 }
    L_0x0050:
        r10.close();	 Catch:{ IOException -> 0x0054 }
    L_0x0053:
        throw r11;	 Catch:{ IOException -> 0x0054 }
    L_0x0054:
        return r0;
    L_0x0055:
        r10 = android.support.v4.provider.FontsContractCompat.m980a(r10, r11);
        r1 = m19915b();
        r2 = 0;
        r3 = r11.length;
        r4 = r2;
    L_0x0060:
        if (r2 >= r3) goto L_0x0082;
    L_0x0062:
        r5 = r11[r2];
        r6 = r5.f1332a;
        r6 = r10.get(r6);
        r6 = (java.nio.ByteBuffer) r6;
        if (r6 == 0) goto L_0x007f;
    L_0x006e:
        r4 = r5.f1333b;
        r7 = r5.f1334c;
        r5 = r5.f1335d;
        r4 = m19914a(r1, r6, r4, r7, r5);
        if (r4 != 0) goto L_0x007e;
    L_0x007a:
        m19917c(r1);
        return r0;
    L_0x007e:
        r4 = 1;
    L_0x007f:
        r2 = r2 + 1;
        goto L_0x0060;
    L_0x0082:
        if (r4 != 0) goto L_0x0088;
    L_0x0084:
        m19917c(r1);
        return r0;
    L_0x0088:
        r10 = m19916b(r1);
        if (r10 != 0) goto L_0x008f;
    L_0x008e:
        return r0;
    L_0x008f:
        r10 = m19911a(r1);
        r10 = android.graphics.Typeface.create(r10, r12);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.a(android.content.Context, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public final Typeface mo269a(Context context, Resources resources, int i, String str, int i2) {
        if (!m19912a()) {
            return super.mo269a(context, resources, i, str, i2);
        }
        Object b = m19915b();
        if (m19913a(context, b, str, -1, -1) == null) {
            m19917c(b);
            return null;
        } else if (m19916b(b) == null) {
            return null;
        } else {
            return m19911a(b);
        }
    }
}
