package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.LinearLayoutManager;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.ui.listener.OnPercentScrollListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LoadMoreOnScrollListener;", "Lcom/reddit/frontpage/ui/listener/OnPercentScrollListener;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "adapter", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "onLoadMore", "Lkotlin/Function0;", "", "(Landroid/support/v7/widget/LinearLayoutManager;Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;Lkotlin/jvm/functions/Function0;)V", "onPercentScrolled", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "currentDy", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadMoreOnScrollListener.kt */
public final class LoadMoreOnScrollListener extends OnPercentScrollListener {
    private final LinearLayoutManager f33881a;
    private final LoadMoreListingAdapter f33882b;
    private final Function0<Unit> f33883c;

    public LoadMoreOnScrollListener(LinearLayoutManager linearLayoutManager, LoadMoreListingAdapter loadMoreListingAdapter, Function0<Unit> function0) {
        Intrinsics.m26847b(linearLayoutManager, "layoutManager");
        Intrinsics.m26847b(loadMoreListingAdapter, "adapter");
        Intrinsics.m26847b(function0, "onLoadMore");
        this.f33881a = linearLayoutManager;
        this.f33882b = loadMoreListingAdapter;
        this.f33883c = function0;
    }

    protected final void mo6462a() {
        int m = this.f33881a.m();
        if (!(m == this.f33882b.mo4926b() && Intrinsics.m26845a(this.f33882b.F_(), FooterState.ERROR)) && m >= this.f33882b.mo4927j() - 5) {
            this.f33883c.invoke();
        }
    }
}
