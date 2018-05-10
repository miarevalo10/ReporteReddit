package com.reddit.frontpage.presentation.modtools.adapter;

import android.support.v7.widget.LinearLayoutManager;
import com.reddit.frontpage.ui.listener.OnPercentScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0014R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/adapter/LoadMoreModUsersOnScrollListener;", "Lcom/reddit/frontpage/ui/listener/OnPercentScrollListener;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "adapter", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter;", "loadMoreScrollEvent", "Lcom/reddit/frontpage/presentation/modtools/adapter/LoadMoreScrollEvent;", "(Landroid/support/v7/widget/LinearLayoutManager;Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter;Lcom/reddit/frontpage/presentation/modtools/adapter/LoadMoreScrollEvent;)V", "LOAD_MORE_RANGE", "", "onPercentScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "currentDy", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadMoreModUsersOnScrollListener.kt */
public final class LoadMoreModUsersOnScrollListener extends OnPercentScrollListener {
    private final int f34057a = 5;
    private final LinearLayoutManager f34058b;
    private final ModUsersAdapter f34059c;
    private final LoadMoreScrollEvent f34060d;

    public LoadMoreModUsersOnScrollListener(LinearLayoutManager linearLayoutManager, ModUsersAdapter modUsersAdapter, LoadMoreScrollEvent loadMoreScrollEvent) {
        Intrinsics.m26847b(linearLayoutManager, "layoutManager");
        Intrinsics.m26847b(modUsersAdapter, "adapter");
        Intrinsics.m26847b(loadMoreScrollEvent, "loadMoreScrollEvent");
        this.f34058b = linearLayoutManager;
        this.f34059c = modUsersAdapter;
        this.f34060d = loadMoreScrollEvent;
    }

    protected final void mo6462a() {
        if (this.f34058b.m() >= this.f34059c.m29738a() - this.f34057a) {
            this.f34060d.mo4910a();
        }
    }
}
