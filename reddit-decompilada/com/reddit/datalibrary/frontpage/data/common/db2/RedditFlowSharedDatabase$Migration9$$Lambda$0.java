package com.reddit.datalibrary.frontpage.data.common.db2;

import com.reddit.frontpage.FrontpageApplication;

final /* synthetic */ class RedditFlowSharedDatabase$Migration9$$Lambda$0 implements Runnable {
    static final Runnable f10310a = new RedditFlowSharedDatabase$Migration9$$Lambda$0();

    private RedditFlowSharedDatabase$Migration9$$Lambda$0() {
    }

    public final void run() {
        MigrateEventsTableService.m15815a(FrontpageApplication.a);
    }
}
