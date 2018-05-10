package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public class StickyJob extends AbstractApiJob {
    protected final String f19458n;
    protected boolean f19459o;

    public StickyJob(Session session, String str, boolean z) {
        Params params = new Params(500);
        params.f2940b = "post_sticky";
        StringBuilder stringBuilder = new StringBuilder("post_sticky");
        stringBuilder.append(str);
        params.f2941c = stringBuilder.toString();
        params = params.m2535a();
        super(session, params);
        this.f19458n = str;
        this.f19459o = z;
    }

    protected final String mo4209g() {
        if (this.f19459o) {
            return Util.f(C1761R.string.error_sticky_post_failure);
        }
        return Util.f(C1761R.string.error_unsticky_post_failure);
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8900b(this.f19458n, this.f19459o);
    }
}
