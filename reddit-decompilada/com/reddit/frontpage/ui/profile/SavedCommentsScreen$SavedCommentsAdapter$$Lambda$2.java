package com.reddit.frontpage.ui.profile;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnDeleteListener;
import com.reddit.frontpage.util.CommentUtil;

final /* synthetic */ class SavedCommentsScreen$SavedCommentsAdapter$$Lambda$2 implements OnDeleteListener {
    private final SavedCommentsAdapter f29233a;

    SavedCommentsScreen$SavedCommentsAdapter$$Lambda$2(SavedCommentsAdapter savedCommentsAdapter) {
        this.f29233a = savedCommentsAdapter;
    }

    public final void mo4968a(int i, Comment comment) {
        i = this.f29233a;
        CommentUtil.m23672c(SessionManager.b().c, comment);
        i.f29234a.w.a(true, null);
    }
}
