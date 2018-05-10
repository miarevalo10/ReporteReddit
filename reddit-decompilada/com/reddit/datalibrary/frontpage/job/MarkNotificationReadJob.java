package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import io.reactivex.Completable;

public class MarkNotificationReadJob extends AbstractApiJob {
    private final String f19448n;

    public MarkNotificationReadJob(Session session, String str) {
        Params a = new Params(500).m2535a();
        super(session, a);
        this.f19448n = str;
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8925f(this.f19448n);
    }
}
