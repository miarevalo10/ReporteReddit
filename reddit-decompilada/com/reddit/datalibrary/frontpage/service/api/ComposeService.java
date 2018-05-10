package com.reddit.datalibrary.frontpage.service.api;

import android.app.IntentService;
import android.content.Intent;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.GenericResponse;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import timber.log.Timber;

public class ComposeService extends IntentService {
    public static final String EXTRA_SUBJECT = "com.reddit.extra.subject";
    public static final String EXTRA_TEXT = "com.reddit.extra.text";
    public static final String EXTRA_TO = "com.reddit.extra.to";
    private static final String TAG = "ComposeService";
    @Inject
    RemoteRedditApiDataSource remoteRedditApiDataSource;

    public static class ComposeResultEvent extends BaseEvent {
        public final String requestId;
        public final GenericResponse response;

        public ComposeResultEvent(String str, GenericResponse genericResponse) {
            this.requestId = str;
            this.response = genericResponse;
        }
    }

    public static class ComposeErrorEvent extends ErrorEvent {
        public final String requestId;

        public ComposeErrorEvent(Exception exception, String str) {
            super(exception);
            this.requestId = str;
        }
    }

    public ComposeService() {
        this(TAG);
        FrontpageApplication.m28877m().mo4599a(this);
    }

    public ComposeService(String str) {
        super(str);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("request_id");
        try {
            GenericResponse genericResponse = (GenericResponse) RemoteRedditApiDataSource.c(intent.getStringExtra(EXTRA_SUBJECT), intent.getStringExtra(EXTRA_TEXT), intent.getStringExtra(EXTRA_TO)).blockingGet();
            if (!genericResponse.a()) {
                EventBus.getDefault().post(MessageEvent.a(Util.m24027f((int) C1761R.string.success_message_send)));
            }
            EventBus.getDefault().post(new ComposeResultEvent(stringExtra, genericResponse));
        } catch (Intent intent2) {
            EventBus.getDefault().post(new ComposeErrorEvent(intent2, stringExtra));
            Timber.c(intent2, "Error composing message", new Object[0]);
        }
    }
}
