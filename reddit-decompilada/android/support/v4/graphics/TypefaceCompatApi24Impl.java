package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi(24)
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final Class f16497a;
    private static final Constructor f16498b;
    private static final Method f16499c;
    private static final Method f16500d;

    TypefaceCompatApi24Impl() {
    }

    static {
        Class cls;
        Method method;
        Method method2;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (Throwable e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = cls;
            method = method2;
        }
        f16498b = constructor;
        f16497a = cls;
        f16499c = method;
        f16500d = method2;
    }

    public static boolean m16630a() {
        if (f16499c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f16499c != null;
    }

    private static Object m16632b() {
        try {
            return f16498b.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean m16631a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f16499c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static Typeface m16629a(Object obj) {
        try {
            Array.set(Array.newInstance(f16497a, 1), 0, obj);
            return (Typeface) f16500d.invoke(null, new Object[]{r0});
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    public final Typeface mo271a(Context context, FontInfo[] fontInfoArr, int i) {
        Object b = m16632b();
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontInfo fontInfo : fontInfoArr) {
            Uri uri = fontInfo.f1332a;
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.m824a(context, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (!m16631a(b, byteBuffer, fontInfo.f1333b, fontInfo.f1334c, fontInfo.f1335d)) {
                return null;
            }
        }
        return Typeface.create(m16629a(b), i);
    }

    public final Typeface mo270a(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        i = m16632b();
        for (FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.f11416a) {
            ByteBuffer a = TypefaceCompatUtil.m823a(context, resources, fontFileResourceEntry.f1234d);
            if (a == null || !m16631a(i, a, 0, fontFileResourceEntry.f1232b, fontFileResourceEntry.f1233c)) {
                return null;
            }
        }
        return m16629a(i);
    }
}
