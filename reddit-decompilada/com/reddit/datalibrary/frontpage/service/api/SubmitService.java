package com.reddit.datalibrary.frontpage.service.api;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient.WebSocketConnection;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitImageResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitImageResponse.WebsocketLinkResult;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitResponse;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.RedirectUpdater;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import timber.log.Timber;

public class SubmitService extends IntentService {
    public static final String EXTRA_FLAIR_ID = "submit_flair_id";
    public static final String EXTRA_FLAIR_TEXT = "submit_flair_text";
    public static final String EXTRA_IMAGE = "submit_image";
    public static final String EXTRA_LATITUDE = "submit_latitude";
    public static final String EXTRA_LOCATION = "submit_location";
    public static final String EXTRA_LONGITUDE = "submit_longitude";
    public static final String EXTRA_REQUEST_ID = "submit_request_id";
    public static final String EXTRA_SUBREDDIT = "submit_subreddit";
    public static final String EXTRA_TEXT = "submit_self";
    public static final String EXTRA_TITLE = "submit_title";
    public static final String EXTRA_URL = "submit_link";
    private static final String TAG = "SubmitService";
    private static final int WS_RESPONSE_TIMEOUT = 7500;
    @Inject
    RemoteRedditApiDataSource remoteRedditApiDataSource;
    @Inject
    RemoteWebSocketDataSource remoteWebSocketDataSource;
    WebSocketConnection wsCon;

    public static class SubmitDeepLinkEvent extends BaseEvent {
        public final String deepLink;
        public final String requestId;

        public SubmitDeepLinkEvent(String str, String str2) {
            this.requestId = str;
            this.deepLink = str2;
        }
    }

    public static class SubmitImageResultEvent extends BaseEvent {
        public final String linkId;
        public final String requestId;

        public SubmitImageResultEvent(String str, String str2) {
            this.requestId = str;
            this.linkId = str2;
        }

        public boolean hasLink() {
            return !TextUtils.isEmpty(this.linkId);
        }
    }

    public static class SubmitResultEvent extends BaseEvent {
        public final String requestId;
        public final SubmitResponse response;
        public final String subreddit;

        public SubmitResultEvent(String str, SubmitResponse submitResponse, String str2) {
            this.requestId = str;
            this.response = submitResponse;
            this.subreddit = str2;
        }
    }

    public static class SubmitErrorEvent extends ErrorEvent {
        public final String requestId;

        public SubmitErrorEvent(String str, Exception exception) {
            super(exception);
            this.requestId = str;
        }
    }

    public SubmitService() {
        super(TAG);
        FrontpageApplication.m28877m().mo4601a(this);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_REQUEST_ID);
        String stringExtra2 = intent.getStringExtra(EXTRA_SUBREDDIT);
        Object stringExtra3 = intent.getStringExtra(EXTRA_URL);
        String stringExtra4 = intent.getStringExtra(EXTRA_TEXT);
        String stringExtra5 = intent.getStringExtra(EXTRA_TITLE);
        CharSequence stringExtra6 = intent.getStringExtra(EXTRA_IMAGE);
        String stringExtra7 = intent.getStringExtra(EXTRA_LOCATION);
        String stringExtra8 = intent.getStringExtra(EXTRA_LATITUDE);
        String stringExtra9 = intent.getStringExtra(EXTRA_LONGITUDE);
        String stringExtra10 = intent.getStringExtra(EXTRA_FLAIR_TEXT);
        intent = intent.getStringExtra(EXTRA_FLAIR_ID);
        try {
            if (!TextUtils.isEmpty(stringExtra3)) {
                intent = submitLink(stringExtra2, stringExtra3, stringExtra5, stringExtra7, stringExtra8, stringExtra9, stringExtra10, intent);
            } else if (TextUtils.isEmpty(stringExtra6)) {
                intent = submitText(stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra8, stringExtra9, stringExtra10, intent);
            } else {
                intent = submitImage(stringExtra2, stringExtra6, stringExtra5, stringExtra7, stringExtra8, stringExtra9, stringExtra10, intent);
            }
            if (intent == null) {
                EventBus.getDefault().post(new SubmitErrorEvent(stringExtra, new Exception("Response is null")));
            } else if (intent.a()) {
                EventBus.getDefault().post(new SubmitErrorEvent(stringExtra, new Exception(intent.b())));
            } else if (intent instanceof SubmitImageResponse) {
                awaitImageResponse(stringExtra, ((WebsocketLinkResult) ((SubmitImageResponse) intent).json.data).websocket_url, stringExtra2);
            } else {
                if (intent instanceof SubmitResponse) {
                    EventBus.getDefault().post(new SubmitResultEvent(stringExtra, (SubmitResponse) intent, null));
                }
            }
        } catch (Intent intent2) {
            EventBus.getDefault().post(new SubmitErrorEvent(stringExtra, intent2));
        }
    }

    private void awaitImageResponse(final String str, String str2, final String str3) {
        final HandlerThread handlerThread = new HandlerThread("imageUpload", 1);
        handlerThread.start();
        this.wsCon = RemoteWebSocketDataSource.a(Uri.parse(str2), new RedirectUpdater() {
            public void onRedirect(String str) {
                if (!TextUtils.isEmpty(str)) {
                    EventBus.getDefault().post(new SubmitDeepLinkEvent(str, str));
                    handlerThread.quit();
                }
                EventBus.getDefault().post(new SubmitResultEvent(str, null, str3));
                SubmitService.this.wsCon.a();
            }

            public void onFailure(Throwable th, String str) {
                EventBus.getDefault().post(new SubmitErrorEvent(str, new Exception(str)));
            }
        });
        new Handler(handlerThread.getLooper()).postDelayed(new SubmitService$$Lambda$0(this, str, str3, handlerThread), 7500);
    }

    final /* synthetic */ void lambda$awaitImageResponse$0$SubmitService(String str, String str2, HandlerThread handlerThread) {
        if (this.wsCon != null) {
            this.wsCon.a();
        }
        EventBus.getDefault().post(new SubmitResultEvent(str, null, str2));
        handlerThread.quit();
    }

    private SubmitImageResponse submitImage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws ExecutionException, InterruptedException {
        try {
            return (SubmitImageResponse) RemoteRedditApiDataSource.b(str, str3, str2, str4, str5, str6, str7, str8).blockingGet();
        } catch (Throwable e) {
            Timber.c(e, "SubmitService.submitImage", new Object[0]);
            return null;
        }
    }

    private SubmitResponse submitLink(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws ExecutionException, InterruptedException {
        try {
            return (SubmitResponse) RemoteRedditApiDataSource.a(str, str3, str2, str4, str5, str6, str7, str8).blockingGet();
        } catch (Throwable e) {
            Timber.c(e, "SubmitService.submitLink", new Object[0]);
            return null;
        }
    }

    private SubmitResponse submitText(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws ExecutionException, InterruptedException {
        try {
            return (SubmitResponse) RemoteRedditApiDataSource.c(str, str3, str2, str4, str5, str6, str7, str8).blockingGet();
        } catch (Throwable e) {
            Timber.c(e, "SubmitService.submitText", new Object[0]);
            return null;
        }
    }
}
