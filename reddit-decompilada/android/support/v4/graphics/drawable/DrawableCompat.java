package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    private static Method f1246a;
    private static boolean f1247b;
    private static Method f1248c;
    private static boolean f1249d;

    @Deprecated
    public static void m829a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void m837a(Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static boolean m838b(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.isAutoMirrored() : null;
    }

    public static void m830a(Drawable drawable, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static void m832a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public static void m831a(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
            return;
        }
        if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTint(i);
        }
    }

    public static void m833a(Drawable drawable, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
            return;
        }
        if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    public static void m836a(Drawable drawable, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
            return;
        }
        if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    public static int m840c(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.getAlpha() : null;
    }

    public static void m834a(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean m841d(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.canApplyTheme() : null;
    }

    public static ColorFilter m842e(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.getColorFilter() : null;
    }

    public static void m843f(Drawable drawable) {
        while (VERSION.SDK_INT < 23 && VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                drawable = ((InsetDrawable) drawable).getDrawable();
            } else if (drawable instanceof DrawableWrapper) {
                drawable = ((DrawableWrapper) drawable).mo273a();
            } else {
                if (drawable instanceof DrawableContainer) {
                    DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                    if (drawableContainerState != null) {
                        int childCount = drawableContainerState.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            Drawable child = drawableContainerState.getChild(i);
                            if (child != null) {
                                m843f(child);
                            }
                        }
                    }
                    return;
                }
            }
        }
        drawable.clearColorFilter();
    }

    public static void m835a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static Drawable m844g(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable;
        }
        return VERSION.SDK_INT >= 21 ? !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperApi21(drawable) : drawable : VERSION.SDK_INT >= 19 ? !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperApi19(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperApi14(drawable) : drawable;
    }

    public static <T extends Drawable> T m845h(Drawable drawable) {
        return drawable instanceof DrawableWrapper ? ((DrawableWrapper) drawable).mo273a() : drawable;
    }

    public static boolean m839b(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!f1247b) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f1246a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f1247b = true;
        }
        if (f1246a != null) {
            try {
                f1246a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Drawable drawable2) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", drawable2);
                f1246a = null;
            }
        }
        return false;
    }

    public static int m846i(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (VERSION.SDK_INT < 17) {
            return 0;
        }
        if (!f1249d) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f1248c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
            }
            f1249d = true;
        }
        if (f1248c != null) {
            try {
                return ((Integer) f1248c.invoke(drawable, new Object[0])).intValue();
            } catch (Drawable drawable2) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", drawable2);
                f1248c = null;
            }
        }
        return 0;
    }
}
