package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import io.reactivex.Completable;

public class ReportLogoutJob extends AbstractApiJob {
    private String f19453n;
    private String f19454o;
    private String f19455p;

    public ReportLogoutJob(Session session) {
        Params params = new Params(500);
        params.f2940b = "report_logout";
        params = params.m2535a();
        super(null, params);
        this.f19453n = session.getUsername();
        this.f19454o = session.f16288a.f10835b;
        this.f19455p = session.f16289b;
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8922e(this.f19453n, this.f19454o, this.f19455p);
    }
}
