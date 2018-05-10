package com.reddit.frontpage.util.kotlin;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\n\u0010\u0000\u001a\u00060\u0001j\u0002`\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n*\u00020\u0003\u001a\u0012\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r*\u00020\u0003\u001a\u0012\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f*\u00020\u0003\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0003*\n\u0010\u0012\"\u00020\u00012\u00020\u0001*\n\u0010\u0013\"\u00020\u00012\u00020\u0001*\n\u0010\u0014\"\u00020\u00012\u00020\u0001*\n\u0010\u0015\"\u00020\u00012\u00020\u0001¨\u0006\u0016"}, d2 = {"attr", "", "Lcom/reddit/frontpage/util/kotlin/ResId;", "Landroid/content/Context;", "Lcom/reddit/frontpage/util/kotlin/AttrRes;", "getColorCompat", "id", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "toActivity", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "toBaseActivity", "Lcom/reddit/frontpage/BaseActivity;", "toFragmentActivity", "Landroid/support/v4/app/FragmentActivity;", "wrappedTheme", "Landroid/view/ContextThemeWrapper;", "AttrRes", "ColorInt", "ColorRes", "ResId", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Contexts.kt */
public final class ContextsKt {
    public static final int m24075a(Context context, int i) {
        Intrinsics.m26847b(context, "$receiver");
        return ContextCompat.c(context, i);
    }

    public static final ContextThemeWrapper m24076a(Context context) {
        Intrinsics.m26847b(context, "$receiver");
        if (VERSION.SDK_INT >= 23) {
            return new ContextThemeWrapper(context, context.getTheme());
        }
        return new ContextThemeWrapper(context, C1761R.style.AppTheme);
    }

    public static final Drawable m24078b(Context context) {
        Intrinsics.m26847b(context, "$receiver");
        if (VERSION.SDK_INT < 21 || context.getTheme() != null) {
            Object drawable = context.getResources().getDrawable(C1761R.drawable.ic_icon_upvote);
            Intrinsics.m26843a(drawable, "resources.getDrawable(id)");
            return drawable;
        }
        drawable = context.getDrawable(C1761R.drawable.ic_icon_upvote);
        Intrinsics.m26843a(drawable, "getDrawable(id)");
        return drawable;
    }

    public static final int m24077b(Context context, int i) {
        Intrinsics.m26847b(context, "$receiver");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public static final Activity m24079c(Context context) {
        Intrinsics.m26847b(context, "$receiver");
        return Util.m24014d(context);
    }

    public static final FragmentActivity m24080d(Context context) {
        Intrinsics.m26847b(context, "$receiver");
        return Util.m24019e(context);
    }
}
