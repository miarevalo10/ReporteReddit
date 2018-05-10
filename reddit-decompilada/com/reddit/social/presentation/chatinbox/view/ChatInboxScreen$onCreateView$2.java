package com.reddit.social.presentation.chatinbox.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/social/presentation/chatinbox/view/ChatInboxScreen$onCreateView$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen;Landroid/support/v7/widget/LinearLayoutManager;)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxScreen.kt */
public final class ChatInboxScreen$onCreateView$2 extends OnScrollListener {
    final /* synthetic */ ChatInboxScreen f29627a;
    final /* synthetic */ LinearLayoutManager f29628b;

    ChatInboxScreen$onCreateView$2(ChatInboxScreen chatInboxScreen, LinearLayoutManager linearLayoutManager) {
        this.f29627a = chatInboxScreen;
        this.f29628b = linearLayoutManager;
    }

    public final void m30654a(RecyclerView recyclerView, int i) {
        if (this.f29628b.l() != null && this.f29628b.m() == ChatInboxScreen.m41160a(this.f29627a).m30647a() - 1) {
            this.f29627a.m41184w().mo5106a();
        }
    }
}
