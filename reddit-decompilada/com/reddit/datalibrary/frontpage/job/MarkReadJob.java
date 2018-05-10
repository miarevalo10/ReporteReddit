package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import io.reactivex.Completable;
import java.util.ArrayList;

public class MarkReadJob extends AbstractApiJob {
    private final ArrayList<String> f19449n;

    public MarkReadJob(Session session, ArrayList<String> arrayList) {
        Params a = new Params(500).m2535a();
        super(session, a);
        this.f19449n = arrayList;
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8911c(this.f19449n);
    }
}
