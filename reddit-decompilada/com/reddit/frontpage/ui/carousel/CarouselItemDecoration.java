package com.reddit.frontpage.ui.carousel;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.reddit.frontpage.util.kotlin.ItemDecorationsKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/CarouselItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "horizontalPadding", "", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselItemDecoration.kt */
public final class CarouselItemDecoration extends ItemDecoration {
    private final int f28906a;

    public CarouselItemDecoration(int i) {
        this.f28906a = i;
    }

    public final void m29957a(Rect rect, View view, RecyclerView recyclerView, State state) {
        if (!(rect == null || view == null || recyclerView == null)) {
            if (state != null) {
                int i = 0;
                rect.left = ItemDecorationsKt.m24082a(this, view, recyclerView) ? this.f28906a : 0;
                if (ItemDecorationsKt.m24083a(this, view, recyclerView, state) != null) {
                    i = this.f28906a;
                }
                rect.right = i;
            }
        }
    }
}
