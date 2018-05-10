package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.ui.detail.BaseDetailScreen.DetailCommentAdapterCallbacks;
import com.reddit.frontpage.ui.detail.comments.CommentTreeAdapter.MoreViewHolder;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;

final /* synthetic */ class BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$2 implements OnClickListener {
    private final DetailCommentAdapterCallbacks f21163a;
    private final ReplyableTreeNode f21164b;
    private final MoreViewHolder f21165c;

    BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$2(DetailCommentAdapterCallbacks detailCommentAdapterCallbacks, ReplyableTreeNode replyableTreeNode, MoreViewHolder moreViewHolder) {
        this.f21163a = detailCommentAdapterCallbacks;
        this.f21164b = replyableTreeNode;
        this.f21165c = moreViewHolder;
    }

    public final void onClick(View view) {
        this.f21163a.m30006a(this.f21164b, this.f21165c);
    }
}
