package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.frontpage.FrontpageApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0017R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/job/UpdatePostFlairJob;", "Lcom/reddit/datalibrary/frontpage/job/BaseRedditJob;", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "linkFlair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "editedText", "", "postFullname", "(Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;Ljava/lang/String;Ljava/lang/String;)V", "onRun", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UpdatePostFlairJob.kt */
public final class UpdatePostFlairJob extends BaseRedditJob {
    private Session f18795m;
    private final LinkFlair f18796n;
    private final String f18797o;
    private final String f18798p;

    public UpdatePostFlairJob(Session session, LinkFlair linkFlair, String str, String str2) {
        Intrinsics.b(session, SDKCoreEvent.Session.TYPE_SESSION);
        Intrinsics.b(str2, "postFullname");
        super(new Params(RedditJobManager.f10808b).m2535a().m2537b());
        this.f18795m = session;
        this.f18796n = linkFlair;
        this.f18797o = str;
        this.f18798p = str2;
        FrontpageApplication.m();
    }

    public final void mo3019b() throws Throwable {
        Session b = SessionManager.m9191b().m9201b(this.f18795m);
        Intrinsics.a(b, "SessionManager.getInstance().refresh(session)");
        this.f18795m = b;
        BaseRedditJob.m16297i();
        RemoteRedditApiDataSource.m8878a(this.f18796n, this.f18797o, this.f18798p).blockingGet();
        super.mo3019b();
    }
}
