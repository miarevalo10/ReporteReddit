package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

public class GiveGoldJob extends BaseRedditJob {
    protected Session f18788m;
    protected final String f18789n;

    public GiveGoldJob(Session session, String str) {
        Params a = new Params(500).m2535a();
        super(a);
        this.f18788m = session;
        this.f18789n = str;
    }

    public final void mo3019b() throws Throwable {
        this.f18788m = SessionManager.m9191b().m9201b(this.f18788m);
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        RemoteRedditApiDataSource.m8945v(this.f18789n).blockingGet();
        super.mo3019b();
    }

    protected final String mo3805h() {
        return Util.f(C1761R.string.label_gold_sent);
    }
}
