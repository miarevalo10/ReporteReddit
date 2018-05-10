package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentEditResponse;
import de.greenrobot.event.EventBus;

public class EditCommentJob extends BaseRedditJob {
    private final String f18781m;
    private final String f18782n;
    private final String f18783o;

    public static class CancelEvent extends BaseEvent {
        public String f16277a;

        public CancelEvent(String str) {
            this.f16277a = str;
        }
    }

    public static class ResultEvent extends BaseEvent {
        public String f16278a;
        public CommentEditResponse f16279b;

        public ResultEvent(String str, CommentEditResponse commentEditResponse) {
            this.f16278a = str;
            this.f16279b = commentEditResponse;
        }
    }

    public EditCommentJob(String str, String str2, String str3) {
        Params a = new Params(500).m2535a();
        super(a);
        this.f18781m = str;
        this.f18782n = str2;
        this.f18783o = str3;
    }

    protected final void mo3018a(int i, Throwable th) {
        super.mo3018a(i, th);
        EventBus.getDefault().post(new CancelEvent(this.f18783o));
    }

    public final void mo3019b() throws Throwable {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        EventBus.getDefault().post(new ResultEvent(this.f18783o, (CommentEditResponse) RemoteRedditApiDataSource.m8930h(this.f18781m, this.f18782n).blockingGet()));
        super.mo3019b();
    }
}
