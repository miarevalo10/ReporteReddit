package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.v4.graphics.TypefaceCompat;
import android.util.Log;
import android.util.TypedValue;

public final class ResourcesCompat {

    public static abstract class FontCallback {
        public abstract void mo589a(Typeface typeface);

        public final void m769a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable(this) {
                final /* synthetic */ FontCallback f1236b;

                public void run() {
                    this.f1236b.mo589a(typeface);
                }
            });
        }

        public final void m767a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable(this) {
                final /* synthetic */ FontCallback f1238b;

                public void run() {
                }
            });
        }
    }

    public static Drawable m774a(Resources resources, int i, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    public static Typeface m770a(Context context, int i) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m772a(context, i, new TypedValue(), 0, null, false);
    }

    public static Typeface m771a(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m772a(context, i, typedValue, i2, fontCallback, true);
    }

    private static Typeface m772a(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        context = m773a(context, resources, typedValue, i, i2, fontCallback, z);
        if (context != null || fontCallback != null) {
            return context;
        }
        typedValue = new StringBuilder("Font resource ID #0x");
        typedValue.append(Integer.toHexString(i));
        typedValue.append(" could not be retrieved.");
        throw new NotFoundException(typedValue.toString());
    }

    private static Typeface m773a(Context context, Resources resources, TypedValue typedValue, int i, int i2, FontCallback fontCallback, boolean z) {
        Throwable th;
        StringBuilder stringBuilder;
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i3 = i;
        int i4 = i2;
        FontCallback fontCallback2 = fontCallback;
        if (typedValue2.string == null) {
            StringBuilder stringBuilder2 = new StringBuilder("Resource \"");
            stringBuilder2.append(resources2.getResourceName(i3));
            stringBuilder2.append("\" (");
            stringBuilder2.append(Integer.toHexString(i3));
            stringBuilder2.append(") is not a Font: ");
            stringBuilder2.append(typedValue2);
            throw new NotFoundException(stringBuilder2.toString());
        }
        String charSequence = typedValue2.string.toString();
        if (charSequence.startsWith("res/")) {
            Typeface a = TypefaceCompat.m818a(resources2, i3, i4);
            if (a != null) {
                if (fontCallback2 != null) {
                    fontCallback2.m769a(a, null);
                }
                return a;
            }
            try {
                if (charSequence.toLowerCase().endsWith(".xml")) {
                    FamilyResourceEntry a2 = FontResourcesParserCompat.m761a(resources2.getXml(i3), resources2);
                    if (a2 != null) {
                        return TypefaceCompat.m816a(context, a2, resources2, i3, i4, fontCallback2, z);
                    }
                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                    if (fontCallback2 != null) {
                        fontCallback2.m767a(-3, null);
                    }
                    return null;
                }
                a = TypefaceCompat.m815a(context, resources2, i3, charSequence, i4);
                if (fontCallback2 != null) {
                    if (a != null) {
                        fontCallback2.m769a(a, null);
                    } else {
                        fontCallback2.m767a(-3, null);
                    }
                }
                return a;
            } catch (Throwable e) {
                th = e;
                stringBuilder = new StringBuilder("Failed to parse xml resource ");
                stringBuilder.append(charSequence);
                Log.e("ResourcesCompat", stringBuilder.toString(), th);
                if (fontCallback2 != null) {
                    fontCallback2.m767a(-3, null);
                }
                return null;
            } catch (Throwable e2) {
                th = e2;
                stringBuilder = new StringBuilder("Failed to read xml resource ");
                stringBuilder.append(charSequence);
                Log.e("ResourcesCompat", stringBuilder.toString(), th);
                if (fontCallback2 != null) {
                    fontCallback2.m767a(-3, null);
                }
                return null;
            }
        }
        if (fontCallback2 != null) {
            fontCallback2.m767a(-3, null);
        }
        return null;
    }
}
