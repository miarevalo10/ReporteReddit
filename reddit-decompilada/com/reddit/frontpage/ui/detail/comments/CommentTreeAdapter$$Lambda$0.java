package com.reddit.frontpage.ui.detail.comments;

import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnDeleteListener;

final /* synthetic */ class CommentTreeAdapter$$Lambda$0 implements OnDeleteListener {
    private final CommentTreeAdapter f28952a;

    CommentTreeAdapter$$Lambda$0(CommentTreeAdapter commentTreeAdapter) {
        this.f28952a = commentTreeAdapter;
    }

    public final void mo4968a(int i, Comment comment) {
        CommentTreeAdapter commentTreeAdapter = this.f28952a;
        if (i >= 0 && comment != null) {
            commentTreeAdapter.f28957c.mo4964a(comment);
            commentTreeAdapter.f(i);
        }
    }
}
