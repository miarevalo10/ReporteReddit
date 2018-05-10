package com.reddit.frontpage.ui.detail.comments;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import kotlin.jvm.functions.Function2;

final /* synthetic */ class LegacyCommentViewHolder$CommentMenuItemClickListener$$Lambda$1 implements Function2 {
    private final CommentMenuItemClickListener f34242a;
    private final Session f34243b;

    LegacyCommentViewHolder$CommentMenuItemClickListener$$Lambda$1(CommentMenuItemClickListener commentMenuItemClickListener, Session session) {
        this.f34242a = commentMenuItemClickListener;
        this.f34243b = session;
    }

    public final Object mo6497a(Object obj, Object obj2) {
        return this.f34242a.m30025a(this.f34243b);
    }
}
