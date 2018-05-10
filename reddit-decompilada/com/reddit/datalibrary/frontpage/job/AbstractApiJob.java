package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import io.reactivex.Completable;
import timber.log.Timber;

public abstract class AbstractApiJob extends BaseRedditJob {
    protected Session f18777m;

    protected abstract Completable mo4208f();

    public AbstractApiJob(Session session, Params params) {
        super(params);
        this.f18777m = session;
    }

    public final void mo3019b() throws Throwable {
        Timber.b("Job is being run.", new Object[0]);
        if (this.f18777m != null) {
            this.f18777m = SessionManager.m9191b().m9201b(this.f18777m);
        }
        mo4208f().blockingGet();
        super.mo3019b();
    }
}
