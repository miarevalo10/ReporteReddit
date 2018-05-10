package com.reddit.datalibrary.frontpage.service.api;

import android.app.IntentService;
import android.content.Intent;
import com.crashlytics.android.Crashlytics;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentReplyResponse;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;

public class ReplyService extends IntentService {
    private static final String TAG = "ReplyService";
    @Inject
    RemoteRedditApiDataSource remoteRedditApiDataSource;

    public static class ReplyResultEvent extends BaseEvent {
        public final String replyIdentifier;
        public final CommentReplyResponse response;

        public ReplyResultEvent(String str, CommentReplyResponse commentReplyResponse) {
            this.replyIdentifier = str;
            this.response = commentReplyResponse;
        }
    }

    public static class ReplyErrorEvent extends ErrorEvent {
        public final String replyIdentifier;

        public ReplyErrorEvent(String str, Exception exception) {
            super(exception);
            this.replyIdentifier = str;
        }
    }

    public ReplyService() {
        this(TAG);
    }

    public ReplyService(String str) {
        super(str);
        FrontpageApplication.m28877m().mo4600a(this);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("thing_name");
        String stringExtra2 = intent.getStringExtra("reply_text");
        intent = intent.getStringExtra("reply_identifier");
        try {
            EventBus.getDefault().post(new ReplyResultEvent(intent, (CommentReplyResponse) RemoteRedditApiDataSource.g(stringExtra, stringExtra2).blockingGet()));
        } catch (Throwable e) {
            Crashlytics.logException(e);
            EventBus.getDefault().post(new ReplyErrorEvent(intent, e));
        }
    }
}
