package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import io.reactivex.Completable;

public class VoteJob extends AbstractApiJob {
    private final String f19460n;
    private final int f19461o;

    public VoteJob(Session session, String str, int i) {
        Params a = new Params(500).m2535a();
        a.f2940b = "post_vote";
        StringBuilder stringBuilder = new StringBuilder("post_vote");
        stringBuilder.append(str);
        a.f2941c = stringBuilder.toString();
        super(session, a);
        this.f19460n = str;
        this.f19461o = i;
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8880a(this.f19460n, this.f19461o);
    }
}
