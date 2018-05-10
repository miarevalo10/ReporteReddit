package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public abstract class SpoilerJobs extends AbstractApiJob {
    protected String f19457n;

    public static final class Mark extends SpoilerJobs {
        public Mark(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_mark_spoiler_failure);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8936m(this.n);
        }
    }

    public static final class Unmark extends SpoilerJobs {
        public Unmark(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_unmark_spoiler_failure);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8937n(this.n);
        }
    }

    private SpoilerJobs(Session session, String str) {
        Params a = new Params(500).m2535a();
        a.f2940b = "link_spoiler";
        StringBuilder stringBuilder = new StringBuilder("link_spoiler");
        stringBuilder.append(str);
        a.f2941c = stringBuilder.toString();
        a.f2942d = true;
        super(session, a);
        this.m = session;
        this.f19457n = str;
    }
}
