package com.reddit.frontpage.presentation.common.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/CenterLinearLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "itemWidth", "", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "itemSize", "(Landroid/content/Context;IZI)V", "scrollToPosition", "", "position", "smoothScrollToPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "CenterSmoothScroller", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CenterLinearLayoutManager.kt */
public final class CenterLinearLayoutManager extends LinearLayoutManager {
    private final int f33790a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/CenterLinearLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CenterLinearLayoutManager.kt */
    private static final class CenterSmoothScroller extends LinearSmoothScroller {
        public CenterSmoothScroller(Context context) {
            Intrinsics.m26847b(context, "context");
            super(context);
        }

        public final int m34595a(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }
    }

    public CenterLinearLayoutManager(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        this(context, 0, false, i);
    }

    public CenterLinearLayoutManager(Context context, int i, boolean z, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, i, z);
        this.f33790a = i2;
    }

    public final void m34597c(int i) {
        if (r() > 0) {
            int r;
            if (g() == 0) {
                r = (r() / 2) - (this.f33790a / 2);
            } else {
                r = (s() / 2) - (this.f33790a / 2);
            }
            e(i, r);
            return;
        }
        super.c(i);
    }

    public final void m34596a(RecyclerView recyclerView, int i) {
        Intrinsics.m26847b(recyclerView, "recyclerView");
        Object context = recyclerView.getContext();
        Intrinsics.m26843a(context, "recyclerView.context");
        CenterSmoothScroller centerSmoothScroller = new CenterSmoothScroller(context);
        centerSmoothScroller.d(i);
        a(centerSmoothScroller);
    }
}
