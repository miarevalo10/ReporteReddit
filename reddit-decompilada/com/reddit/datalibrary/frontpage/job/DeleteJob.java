package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import de.greenrobot.event.EventBus;

public abstract class DeleteJob extends BaseRedditJob {
    protected Session f18778m;
    protected final String f18779n;
    protected Comment f18780o;

    public static class DeleteComment extends BaseEvent {
        public final Comment f16275a;

        public DeleteComment(Comment comment) {
            this.f16275a = comment;
        }
    }

    public DeleteJob(Session session, String str) {
        Params a = new Params(500).m2535a();
        super(a);
        this.f18778m = session;
        this.f18779n = str;
    }

    public DeleteJob(Session session, Comment comment) {
        Params a = new Params(500).m2535a();
        super(a);
        this.f18778m = session;
        this.f18779n = comment.getName();
        this.f18780o = comment;
    }

    public final void mo3019b() throws Throwable {
        this.f18778m = SessionManager.m9191b().m9201b(this.f18778m);
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        RemoteRedditApiDataSource.m8944u(this.f18779n).blockingGet();
        if (this.f18780o != null) {
            EventBus.getDefault().post(new DeleteComment(this.f18780o));
        }
        super.mo3019b();
    }
}
