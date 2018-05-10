package com.reddit.frontpage.ui.listing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy.Defaults;
import kotlin.jvm.functions.Function1;

public class DividerItemDecoration extends ItemDecoration {
    private final Drawable f29040a;
    private final DecorationInclusionStrategy f29041b;
    private int f29042c;

    public static DividerItemDecoration m30093a(Context context, int i, DecorationInclusionStrategy decorationInclusionStrategy) {
        return new DividerItemDecoration(ResourcesUtil.m22723b(context, i == 0 ? C1761R.attr.rdt_horizontal_divider_listing_large_drawable : C1761R.attr.rdt_horizontal_divider_listing_drawable), decorationInclusionStrategy);
    }

    public static DecorationInclusionStrategy m30091a() {
        Defaults defaults = DecorationInclusionStrategy.f21272b;
        return Defaults.m23387a();
    }

    private DividerItemDecoration(Drawable drawable, DecorationInclusionStrategy decorationInclusionStrategy) {
        this.f29040a = drawable;
        this.f29041b = decorationInclusionStrategy;
    }

    public final void m30095b(Canvas canvas, RecyclerView recyclerView) {
        int i = 0;
        int paddingTop;
        int height;
        int childCount;
        if (this.f29042c == 0) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            childCount = recyclerView.getChildCount();
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                int left = childAt.getLeft() + ((LayoutParams) childAt.getLayoutParams()).leftMargin;
                this.f29040a.setBounds(left, paddingTop, left - this.f29040a.getIntrinsicWidth(), height);
                this.f29040a.draw(canvas);
                i++;
            }
            return;
        }
        if (this.f29042c == 1) {
            paddingTop = recyclerView.getPaddingLeft();
            height = recyclerView.getWidth() - recyclerView.getPaddingRight();
            childCount = recyclerView.getChildCount();
            while (i < childCount) {
                childAt = recyclerView.getChildAt(i);
                left = childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin;
                this.f29040a.setBounds(paddingTop, left - this.f29040a.getIntrinsicHeight(), height, left);
                this.f29040a.draw(canvas);
                i++;
            }
        }
    }

    public final void m30094a(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.a(rect, view, recyclerView, state);
        state = this.f29041b;
        view = recyclerView.getChildAdapterPosition(view);
        loop0:
        while (true) {
            Object obj = 1;
            for (Function1 function1 : (Iterable) state.f21273a) {
                if (obj == null || !((Boolean) function1.mo6492a(Integer.valueOf(view))).booleanValue()) {
                    obj = null;
                }
            }
            break loop0;
        }
        if (obj != null) {
            this.f29042c = ((LinearLayoutManager) recyclerView.getLayoutManager()).i;
            if (this.f29042c == null) {
                rect.left = this.f29040a.getIntrinsicWidth();
                return;
            }
            if (this.f29042c == 1) {
                rect.top = this.f29040a.getIntrinsicHeight();
            }
        }
    }

    public static DividerItemDecoration m30092a(Context context, int i) {
        Defaults defaults = DecorationInclusionStrategy.f21272b;
        return m30093a(context, i, Defaults.m23388b());
    }
}
