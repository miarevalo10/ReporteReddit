package com.reddit.frontpage.presentation.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.TypedValue;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u0004H\u0007J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0013\u001a\u00020\u0004H\u0007J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J$\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0004H\u0007J\"\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u001a\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u001a\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u001a\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u0004H\u0007J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u001a\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\"\u0010#\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0001\u0010$\u001a\u00020\u0004H\u0007J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0007J$\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u0004H\u0007J$\u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J$\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010)\u001a\u00020\u0004H\u0007¨\u0006*"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ResourcesUtil;", "", "()V", "applyAlphaToColor", "", "color", "alpha", "", "getActionIconDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawable", "drawableResId", "getColorFromAttr", "attrId", "getColorStateListFromAttr", "Landroid/content/res/ColorStateList;", "getDrawableAttr", "drawableAttrId", "getDrawableRes", "getDrawableResWithTintListAttr", "colorStateAttrId", "getDrawableWithTintListAttr", "getFloatValue", "attr", "getIndIcon", "icon", "getLightIconDrawable", "getMediumActionIcon", "getMediumIcon", "getNavIconDrawable", "getResId", "getSmallActionIcon", "getSmallIcon", "tintDrawable", "colorAttrId", "colorId", "tintDrawableRes", "tintDrawableResWithColor", "tintDrawableResWithColorRes", "colorResId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ResourcesUtil.kt */
public final class ResourcesUtil {
    public static final ResourcesUtil f20384a = new ResourcesUtil();

    private ResourcesUtil() {
    }

    public static final Drawable m22718a(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        context = ContextCompat.a(context, i);
        if (context == null) {
            Intrinsics.m26842a();
        }
        Object g = DrawableCompat.g(context);
        Intrinsics.m26843a(g, "DrawableCompat.wrap(Cont…ontext, drawableResId)!!)");
        return g;
    }

    public static final Drawable m22723b(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        context = ContextCompat.a(context, m22741j(context, i));
        if (context == null) {
            Intrinsics.m26842a();
        }
        Object g = DrawableCompat.g(context);
        Intrinsics.m26843a(g, "DrawableCompat.wrap(Cont…text, drawableAttrId))!!)");
        return g;
    }

    public static final Drawable m22719a(Context context, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        i = ContextCompat.a(context, i);
        if (i == 0) {
            Intrinsics.m26842a();
        }
        Object mutate = DrawableCompat.g(i).mutate();
        DrawableCompat.a(mutate, m22738h(context, i2));
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22720a(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "drawable");
        Object mutate = DrawableCompat.g(drawable).mutate();
        DrawableCompat.a(mutate, m22738h(context, (int) C1761R.attr.rdt_icon_color_selector));
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22724b(Context context, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        i = ContextCompat.a(context, i);
        if (i == 0) {
            Intrinsics.m26842a();
        }
        Object mutate = DrawableCompat.g(i).mutate();
        DrawableCompat.a(mutate, m22740i(context, i2));
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22721a(Context context, Drawable drawable, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "drawable");
        Object mutate = DrawableCompat.g(drawable).mutate();
        DrawableCompat.a(mutate, m22740i(context, i));
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22727c(Context context, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        i = ContextCompat.a(context, i);
        if (i == 0) {
            Intrinsics.m26842a();
        }
        Object mutate = DrawableCompat.g(i).mutate();
        DrawableCompat.a(mutate, ContextCompat.c(context, i2));
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22730d(Context context, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        context = ContextCompat.a(context, i);
        if (context == null) {
            Intrinsics.m26842a();
        }
        Object mutate = DrawableCompat.g(context).mutate();
        DrawableCompat.a(mutate, i2);
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22722a(Drawable drawable, int i) {
        Intrinsics.m26847b(drawable, "drawable");
        Object mutate = DrawableCompat.g(drawable).mutate();
        DrawableCompat.a(mutate, i);
        Intrinsics.m26843a(mutate, "result");
        return mutate;
    }

    public static final Drawable m22725b(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "icon");
        context = context.getResources().getDimensionPixelSize(C1761R.dimen.icon_ind_size);
        drawable.setBounds(new Rect(0, 0, context, context));
        return drawable;
    }

    private static Drawable m22739h(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "icon");
        context = context.getResources().getDimensionPixelSize(C1761R.dimen.icon_size_small);
        drawable.setBounds(new Rect(0, 0, context, context));
        return drawable;
    }

    public static final Drawable m22728c(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "icon");
        context = context.getResources().getDimensionPixelSize(C1761R.dimen.icon_size_medium);
        drawable.setBounds(new Rect(0, 0, context, context));
        return drawable;
    }

    public static final Drawable m22731d(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "drawable");
        return m22739h(context, m22721a(context, drawable, (int) C1761R.attr.rdt_action_icon_color));
    }

    public static final Drawable m22726c(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return m22739h(context, m22724b(context, i, C1761R.attr.rdt_action_icon_color));
    }

    public static final Drawable m22729d(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return m22728c(context, m22724b(context, i, C1761R.attr.rdt_action_icon_color));
    }

    public static final Drawable m22732e(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return m22724b(context, i, C1761R.attr.rdt_action_icon_color);
    }

    public static final Drawable m22733e(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "drawable");
        return m22721a(context, drawable, (int) C1761R.attr.rdt_action_icon_color);
    }

    public static final Drawable m22735f(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "drawable");
        return m22721a(context, drawable, (int) C1761R.attr.rdt_nav_icon_color);
    }

    public static final Drawable m22734f(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return m22724b(context, i, C1761R.attr.rdt_nav_icon_color);
    }

    public static final Drawable m22737g(Context context, Drawable drawable) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(drawable, "drawable");
        return m22721a(context, drawable, (int) C1761R.attr.rdt_light_text_color);
    }

    public static final Drawable m22736g(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return m22724b(context, i, C1761R.attr.rdt_light_text_color);
    }

    public static final ColorStateList m22738h(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return ContextCompat.b(context, m22741j(context, i));
    }

    public static final int m22740i(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        return ContextCompat.c(context, m22741j(context, i));
    }

    private static int m22741j(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        Object obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        Intrinsics.m26843a(obtainStyledAttributes, "context.theme.obtainStyl…ributes(intArrayOf(attr))");
        i = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return i;
    }

    public static final float m22716a(Context context) {
        Intrinsics.m26847b(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(C1761R.dimen.rdt_button_disabled_alpha, typedValue, false);
        context = Unit.f25273a;
        return typedValue.getFloat();
    }

    public static final int m22717a(int i, float f) {
        return ColorUtils.b(i, (int) (255.0f * f));
    }
}
