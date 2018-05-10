package com.reddit.frontpage.util.kotlin;

import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0003\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0003\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0003\u001a\u001a\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u000e*\u00020\u0003\u001a\u0012\u0010\u0014\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0001\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"value", "", "isVisible", "Landroid/view/View;", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "color", "", "Lcom/reddit/frontpage/util/kotlin/ColorInt;", "Lcom/reddit/frontpage/util/kotlin/ColorRes;", "getPosition", "Landroid/graphics/Point;", "hide", "", "invisible", "onLayout", "callback", "Lkotlin/Function0;", "show", "visibleOrGone", "visible", "visibleOrInvisible", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Views.kt */
public final class ViewsKt {
    public static final boolean m24104a(View view) {
        Intrinsics.m26847b(view, "$receiver");
        return view.getVisibility() == null ? true : null;
    }

    public static final void m24103a(View view, boolean z) {
        Intrinsics.m26847b(view, "$receiver");
        view.setVisibility(z ? false : true);
    }

    public static final void m24105b(View view) {
        Intrinsics.m26847b(view, "$receiver");
        view.setVisibility(4);
    }

    public static final void m24107c(View view) {
        Intrinsics.m26847b(view, "$receiver");
        view.setVisibility(0);
    }

    public static final void m24109d(View view) {
        Intrinsics.m26847b(view, "$receiver");
        view.setVisibility(8);
    }

    public static final void m24106b(View view, boolean z) {
        Intrinsics.m26847b(view, "$receiver");
        if (z) {
            view.setVisibility(false);
        } else {
            view.setVisibility(true);
        }
    }

    public static final void m24108c(View view, boolean z) {
        Intrinsics.m26847b(view, "$receiver");
        if (z) {
            view.setVisibility(false);
        } else {
            view.setVisibility(true);
        }
    }

    public static final int m24101a(View view, int i) {
        Intrinsics.m26847b(view, "$receiver");
        Object context = view.getContext();
        Intrinsics.m26843a(context, "context");
        return ContextsKt.m24075a(context, i);
    }

    public static final Point m24110e(View view) {
        Intrinsics.m26847b(view, "$receiver");
        if (!view.isShown()) {
            return new Point(-1, -1);
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static final void m24102a(View view, Function0<Unit> function0) {
        Intrinsics.m26847b(view, "$receiver");
        Intrinsics.m26847b(function0, "callback");
        if (ViewCompat.G(view)) {
            function0.invoke();
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewsKt$onLayout$1(view, function0));
        }
    }
}
