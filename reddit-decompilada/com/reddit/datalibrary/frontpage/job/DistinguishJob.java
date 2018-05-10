package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public class DistinguishJob extends AbstractApiJob {
    protected final String f19444n;
    protected boolean f19445o;
    protected boolean f19446p;

    public DistinguishJob(Session session, String str, boolean z) {
        this(session, str, z, false);
    }

    public DistinguishJob(Session session, String str, boolean z, boolean z2) {
        Params params = new Params(500);
        params.f2940b = "thing_distinguish";
        StringBuilder stringBuilder = new StringBuilder("thing_distinguish");
        stringBuilder.append(str);
        params.f2941c = stringBuilder.toString();
        params = params.m2535a();
        params.f2942d = true;
        super(session, params);
        this.f19444n = str;
        this.f19445o = z;
        this.f19446p = z2;
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource;
        if (!this.f19445o) {
            remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8943t(this.f19444n);
        } else if (this.f19446p) {
            remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8942s(this.f19444n);
        } else {
            remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8941r(this.f19444n);
        }
    }

    protected final String mo4209g() {
        if (this.f19445o) {
            return Util.f(C1761R.string.error_distinguish_post_failure);
        }
        return Util.f(C1761R.string.error_undistinguish_post_failure);
    }
}
