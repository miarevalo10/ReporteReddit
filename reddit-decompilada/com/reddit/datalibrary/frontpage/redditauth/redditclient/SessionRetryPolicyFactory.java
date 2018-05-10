package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.android.volley.RetryPolicy;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;

public class SessionRetryPolicyFactory implements RetryPolicyFactory {
    private final Session f16320a;

    public SessionRetryPolicyFactory(Session session) {
        this.f16320a = session;
    }

    public final RetryPolicy mo3039a() {
        return new SessionRetryPolicy(this.f16320a);
    }
}
