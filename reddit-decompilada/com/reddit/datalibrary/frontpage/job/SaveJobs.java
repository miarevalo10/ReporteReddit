package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public abstract class SaveJobs extends AbstractApiJob {
    protected final String f19456n;

    public static class Save extends SaveJobs {
        public Save(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_save_post_failure);
        }

        protected final String mo3805h() {
            if (Util.j(this.n).equals(Kind.COMMENT)) {
                return Util.f(C1761R.string.success_comment_save);
            }
            return Util.f(C1761R.string.success_post_save);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8927g(this.n);
        }
    }

    public static class Unsave extends SaveJobs {
        public Unsave(Session session, String str) {
            super(session, str);
        }

        protected final String mo4209g() {
            return Util.f(C1761R.string.error_unsave_post_failure);
        }

        protected final String mo3805h() {
            if (Util.j(this.n).equals(Kind.COMMENT)) {
                return Util.f(C1761R.string.success_comment_unsave);
            }
            return Util.f(C1761R.string.success_post_unsave);
        }

        protected final Completable mo4208f() {
            RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
            return RemoteRedditApiDataSource.m8929h(this.n);
        }
    }

    public SaveJobs(Session session, String str) {
        Params params = new Params(500);
        params.f2940b = "post_save";
        StringBuilder stringBuilder = new StringBuilder("post_save");
        stringBuilder.append(str);
        params.f2941c = stringBuilder.toString();
        params = params.m2535a();
        super(session, params);
        this.f19456n = str;
    }
}
