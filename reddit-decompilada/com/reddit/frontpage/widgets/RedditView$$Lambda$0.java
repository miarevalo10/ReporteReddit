package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.action.RedditAction;

public final /* synthetic */ class RedditView$$Lambda$0 implements OnClickListener {
    private final RedditAction f21939a;

    public RedditView$$Lambda$0(RedditAction redditAction) {
        this.f21939a = redditAction;
    }

    public final void onClick(View view) {
        RedditView.m24190a(this.f21939a);
    }
}
