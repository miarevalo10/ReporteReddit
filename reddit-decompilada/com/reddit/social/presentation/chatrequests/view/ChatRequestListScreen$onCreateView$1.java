package com.reddit.social.presentation.chatrequests.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/social/presentation/chatrequests/view/ChatRequestListScreen$onCreateView$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/reddit/social/presentation/chatrequests/view/ChatRequestListScreen;Landroid/support/v7/widget/LinearLayoutManager;)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestListScreen.kt */
public final class ChatRequestListScreen$onCreateView$1 extends OnScrollListener {
    final /* synthetic */ ChatRequestListScreen f29669a;
    final /* synthetic */ LinearLayoutManager f29670b;

    ChatRequestListScreen$onCreateView$1(ChatRequestListScreen chatRequestListScreen, LinearLayoutManager linearLayoutManager) {
        this.f29669a = chatRequestListScreen;
        this.f29670b = linearLayoutManager;
    }

    public final void m30697a(RecyclerView recyclerView, int i) {
        if (this.f29670b.m() == CollectionsKt__CollectionsKt.m26787a((List) ChatRequestListScreen.m41185a(this.f29669a).f29623a)) {
            this.f29669a.m41199w().mo5116a();
        }
    }
}
