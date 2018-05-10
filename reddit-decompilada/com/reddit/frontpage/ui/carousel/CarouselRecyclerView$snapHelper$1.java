package com.reddit.frontpage.ui.carousel;

import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView.LayoutManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/ui/carousel/CarouselRecyclerView$snapHelper$1", "Landroid/support/v7/widget/PagerSnapHelper;", "(Lcom/reddit/frontpage/ui/carousel/CarouselRecyclerView;)V", "findTargetSnapPosition", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "velocityX", "velocityY", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselRecyclerView.kt */
public final class CarouselRecyclerView$snapHelper$1 extends PagerSnapHelper {
    final /* synthetic */ CarouselRecyclerView f37168c;

    CarouselRecyclerView$snapHelper$1(CarouselRecyclerView carouselRecyclerView) {
        this.f37168c = carouselRecyclerView;
    }

    public final int m37550a(LayoutManager layoutManager, int i, int i2) {
        layoutManager = super.a(layoutManager, i, i2);
        i = this.f37168c.getSnapListener();
        if (i != 0) {
            i.mo6492a(Integer.valueOf(layoutManager));
        }
        return layoutManager;
    }
}
