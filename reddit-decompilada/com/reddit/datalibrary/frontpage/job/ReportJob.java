package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

public class ReportJob extends BaseRedditJob {
    private final String f18790m;
    private final String f18791n;
    private final String f18792o;

    public ReportJob(String str, String str2, String str3) {
        Params a = new Params(1).m2535a();
        super(a);
        this.f18790m = str;
        this.f18791n = str2;
        this.f18792o = str3;
    }

    protected final String mo3805h() {
        if (Util.j(this.f18790m).equals(Kind.COMMENT)) {
            return Util.f(C1761R.string.success_comment_report);
        }
        return Util.f(C1761R.string.success_post_report);
    }

    public final void mo3019b() throws Throwable {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        RemoteRedditApiDataSource.m8918d(this.f18790m, this.f18791n, this.f18792o).blockingGet();
        super.mo3019b();
    }
}
