package com.reddit.social.presentation.groupchat.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/social/presentation/groupchat/view/GroupMessagingScreen$onCreateView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen;)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
public final class GroupMessagingScreen$onCreateView$3 extends OnScrollListener {
    final /* synthetic */ GroupMessagingScreen f29854a;

    GroupMessagingScreen$onCreateView$3(GroupMessagingScreen groupMessagingScreen) {
        this.f29854a = groupMessagingScreen;
    }

    public final void m30858a(RecyclerView recyclerView, int i) {
        if (GroupMessagingScreen.m41291c(this.f29854a).l() != null && GroupMessagingScreen.m41291c(this.f29854a).m() == GroupMessagingScreen.m41285a(this.f29854a).m30868a() - 1 && this.f29854a.f40216B == null) {
            GroupMessagingScreen.m41292d(this.f29854a);
        }
    }
}
