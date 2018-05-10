package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkEditResponse;
import de.greenrobot.event.EventBus;

public class EditLinkJob extends BaseRedditJob {
    private Session f18784m;
    private final String f18785n;
    private final String f18786o;
    private final String f18787p;

    public static class CancelEvent extends BaseEvent {
        public String f16280a;

        public CancelEvent(String str) {
            this.f16280a = str;
        }
    }

    public static class ResultEvent extends BaseEvent {
        public String f16281a;
        public LinkEditResponse f16282b;

        public ResultEvent(String str, LinkEditResponse linkEditResponse) {
            this.f16281a = str;
            this.f16282b = linkEditResponse;
        }
    }

    public EditLinkJob(Session session, String str, String str2, String str3) {
        Params a = new Params(500).m2535a();
        super(a);
        this.f18784m = session;
        this.f18785n = str;
        this.f18786o = str2;
        this.f18787p = str3;
    }

    protected final void mo3018a(int i, Throwable th) {
        super.mo3018a(i, th);
        EventBus.getDefault().post(new CancelEvent(this.f18787p));
    }

    public final void mo3019b() throws Throwable {
        this.f18784m = SessionManager.m9191b().m9201b(this.f18784m);
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        EventBus.getDefault().post(new ResultEvent(this.f18787p, (LinkEditResponse) RemoteRedditApiDataSource.m8932i(this.f18785n, this.f18786o).blockingGet()));
        super.mo3019b();
    }
}
