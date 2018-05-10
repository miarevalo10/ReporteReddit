package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public abstract class LockJobs extends AbstractApiJob {
    protected String f19447n;

    public static final class Lock extends LockJobs {
        public Lock(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_lock_comments_failure);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8938o(this.n);
        }
    }

    public static final class Unlock extends LockJobs {
        public Unlock(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_unlock_comments_failure);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8939p(this.n);
        }
    }

    private LockJobs(Session session, String str) {
        Params a = new Params(500).m2535a();
        a.f2940b = "link_lock";
        StringBuilder stringBuilder = new StringBuilder("link_lock");
        stringBuilder.append(str);
        a.f2941c = stringBuilder.toString();
        a.f2942d = true;
        super(session, a);
        this.m = session;
        this.f19447n = str;
    }
}
