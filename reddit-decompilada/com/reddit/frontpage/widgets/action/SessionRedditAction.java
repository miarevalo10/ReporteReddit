package com.reddit.frontpage.widgets.action;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;

public abstract class SessionRedditAction implements RedditAction {
    public Session f29496a;

    public abstract void mo6541c();

    public SessionRedditAction(Session session) {
        this.f29496a = session;
    }

    public final boolean mo5065a() {
        if (!this.f29496a.isAnonymous()) {
            return true;
        }
        mo6541c();
        return false;
    }
}
