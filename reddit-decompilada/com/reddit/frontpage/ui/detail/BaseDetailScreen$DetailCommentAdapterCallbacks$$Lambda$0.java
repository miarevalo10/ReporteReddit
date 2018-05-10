package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.ui.detail.BaseDetailScreen.DetailCommentAdapterCallbacks;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;

final /* synthetic */ class BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$0 implements OnClickListener {
    private final DetailCommentAdapterCallbacks f21159a;
    private final ReplyableTreeNode f21160b;

    BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$0(DetailCommentAdapterCallbacks detailCommentAdapterCallbacks, ReplyableTreeNode replyableTreeNode) {
        this.f21159a = detailCommentAdapterCallbacks;
        this.f21160b = replyableTreeNode;
    }

    public final void onClick(View view) {
        view = this.f21159a;
        ReplyableTreeNode replyableTreeNode = this.f21160b;
        if (!replyableTreeNode.f21184c) {
            view.f28947b.f39155H.b(replyableTreeNode);
        }
    }
}
