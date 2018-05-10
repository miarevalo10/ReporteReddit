package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;

public interface SessionDependent {
    void updateSessionInfo(Session session);
}
