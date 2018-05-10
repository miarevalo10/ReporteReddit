package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.listing.UserCommentsListingScreen.CommentViewHolder;

final /* synthetic */ class UserCommentsListingScreen$CommentViewHolder$$Lambda$0 implements OnClickListener {
    private final CommentViewHolder f21321a;
    private final Comment f21322b;

    UserCommentsListingScreen$CommentViewHolder$$Lambda$0(CommentViewHolder commentViewHolder, Comment comment) {
        this.f21321a = commentViewHolder;
        this.f21322b = comment;
    }

    public final void onClick(View view) {
        view = this.f21321a;
        Comment comment = this.f21322b;
        Routing.m22623a((Screen) view.f29071a, Nav.m22557a(comment.link_id.substring(3), comment.getId(), "3"));
    }
}
