package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.reddit.frontpage.ui.detail.BaseDetailScreen.DetailCommentAdapterCallbacks;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;

final /* synthetic */ class BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$1 implements OnLongClickListener {
    private final DetailCommentAdapterCallbacks f21161a;
    private final ReplyableTreeNode f21162b;

    BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$1(DetailCommentAdapterCallbacks detailCommentAdapterCallbacks, ReplyableTreeNode replyableTreeNode) {
        this.f21161a = detailCommentAdapterCallbacks;
        this.f21162b = replyableTreeNode;
    }

    public final boolean onLongClick(View view) {
        view = this.f21161a;
        ReplyableTreeNode replyableTreeNode = this.f21162b;
        if (replyableTreeNode.f21184c) {
            view = view.f28947b.f39155H;
            view.a(view.a.m23359a(replyableTreeNode), view.a.m23366c(replyableTreeNode));
        } else {
            view.f28947b.f39155H.b(replyableTreeNode);
        }
        return true;
    }
}
