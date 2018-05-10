package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public abstract class NsfwJobs extends AbstractApiJob {
    protected String f19450n;

    public static class Mark extends NsfwJobs {
        public Mark(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_mark_nsfw_failure);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8934k(this.n);
        }
    }

    public static class Unmark extends NsfwJobs {
        public Unmark(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_unmark_nsfw_failure);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8935l(this.n);
        }
    }

    private NsfwJobs(Session session, String str) {
        Params a = new Params(500).m2535a();
        a.f2940b = "link_nsfw";
        StringBuilder stringBuilder = new StringBuilder("link_nsfw");
        stringBuilder.append(str);
        a.f2941c = stringBuilder.toString();
        a.f2942d = true;
        super(session, a);
        this.f19450n = str;
    }
}
