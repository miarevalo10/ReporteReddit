package com.reddit.frontpage.ui.detail;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import kotlin.jvm.functions.Function2;

final /* synthetic */ class BaseDetailScreen$$Lambda$24 implements Function2 {
    private final BaseDetailScreen f34235a;
    private final Link f34236b;
    private final Session f34237c;

    BaseDetailScreen$$Lambda$24(BaseDetailScreen baseDetailScreen, Link link, Session session) {
        this.f34235a = baseDetailScreen;
        this.f34236b = link;
        this.f34237c = session;
    }

    public final Object mo6497a(Object obj, Object obj2) {
        return this.f34235a.m39106a(this.f34236b, this.f34237c);
    }
}
