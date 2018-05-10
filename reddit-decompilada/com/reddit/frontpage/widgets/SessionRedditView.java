package com.reddit.frontpage.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;

public abstract class SessionRedditView extends RedditView {
    private Session f29486b;

    public SessionRedditView(Context context) {
        super(context);
    }

    public SessionRedditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SessionRedditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SessionRedditView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void mo6542a(Session session) {
        this.f29486b = session;
    }

    public Session getSession() {
        return this.f29486b;
    }
}
