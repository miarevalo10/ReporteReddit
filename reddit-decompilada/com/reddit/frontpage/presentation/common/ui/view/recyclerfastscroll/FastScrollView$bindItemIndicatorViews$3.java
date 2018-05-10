package com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll;

import android.support.v7.widget.AppCompatImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Icon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"createIconView", "Landroid/support/v7/widget/AppCompatImageView;", "itemIndicator", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Icon;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FastScrollView.kt */
final class FastScrollView$bindItemIndicatorViews$3 extends Lambda implements Function1<Icon, AppCompatImageView> {
    final /* synthetic */ FastScrollView f36404a;

    FastScrollView$bindItemIndicatorViews$3(FastScrollView fastScrollView) {
        this.f36404a = fastScrollView;
        super(1);
    }

    public final AppCompatImageView m36788a(Icon icon) {
        Intrinsics.m26847b(icon, "itemIndicator");
        AppCompatImageView appCompatImageView = new AppCompatImageView(this.f36404a.getContext());
        Sdk21PropertiesKt.m28410a((ImageView) appCompatImageView, icon.f28090a);
        appCompatImageView.setScaleType(ScaleType.CENTER_INSIDE);
        appCompatImageView.setImageTintList(this.f36404a.f20427e);
        icon = this.f36404a.generateDefaultLayoutParams();
        int a = DimensionsKt.m28408a(appCompatImageView.getContext(), C1761R.dimen.recycler_fast_scroll_icon_size);
        icon.width = a;
        icon.height = a;
        appCompatImageView.setLayoutParams((LayoutParams) icon);
        return appCompatImageView;
    }
}
