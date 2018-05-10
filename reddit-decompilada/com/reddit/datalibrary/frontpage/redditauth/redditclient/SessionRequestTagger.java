package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.android.volley.Request;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;

public class SessionRequestTagger implements RequestTagger {
    private final Session f16313a;

    public SessionRequestTagger(Session session) {
        this.f16313a = session;
    }

    public final void mo3038a(Request<?> request) {
        request.setTag(this.f16313a);
    }
}
