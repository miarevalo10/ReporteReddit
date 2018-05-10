package com.reddit.frontpage.widgets.bottomnav;

import android.graphics.Outline;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/widgets/bottomnav/BottomNavPostItemViewHolder$1$1", "Landroid/view/ViewOutlineProvider;", "(Lcom/reddit/frontpage/widgets/bottomnav/BottomNavPostItemViewHolder$1;)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BottomNavPostItemViewHolder.kt */
public final class BottomNavPostItemViewHolder$$special$$inlined$apply$lambda$1 extends ViewOutlineProvider {
    final /* synthetic */ BottomNavPostItemViewHolder f21961a;
    final /* synthetic */ LayerDrawable f21962b;

    BottomNavPostItemViewHolder$$special$$inlined$apply$lambda$1(BottomNavPostItemViewHolder bottomNavPostItemViewHolder, LayerDrawable layerDrawable) {
        this.f21961a = bottomNavPostItemViewHolder;
        this.f21962b = layerDrawable;
    }

    public final void getOutline(View view, Outline outline) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(outline, "outline");
        int width = (view.getWidth() - this.f21961a.f21969e) / 2;
        view = (view.getHeight() - this.f21961a.f21969e) / 2;
        outline.setOval(width, view, this.f21961a.f21969e + width, this.f21961a.f21969e + view);
    }
}
