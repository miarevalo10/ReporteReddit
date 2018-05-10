package com.reddit.datalibrary.frontpage.service.api;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.IOUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import java.io.Closeable;
import java.io.InputStream;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import timber.log.Timber;

public class UploadService extends IntentService {
    public static final String DEFAULT_IMG_HOSTING_ENDPOINT = "https://imgless.reddituploads.com/1/image";
    public static final String EXTRA_PATH = "com.reddit.path";
    public static final String EXTRA_REQUEST_ID = "com.reddit.request_id";
    public static final String IMG_CLIENT_ID = "OGZmZWQ0Yzc4Y2";
    private static final String TAG = "UploadService";
    @Inject
    RemoteRedditApiDataSource remoteRedditApiDataSource;

    public static class UploadSuccessEvent extends BaseEvent {
        public final String url;

        UploadSuccessEvent(String str, String str2) {
            this.requestId = str;
            this.url = str2;
        }
    }

    public static class UploadErrorEvent extends ErrorEvent {
        UploadErrorEvent(String str, Exception exception) {
            super(str, exception);
        }
    }

    public UploadService() {
        this(TAG);
    }

    public UploadService(String str) {
        super(str);
        FrontpageApplication.m28877m().mo4602a(this);
    }

    protected void onHandleIntent(Intent intent) {
        if (!SessionManager.b().c.isAnonymous()) {
            String stringExtra = intent.getStringExtra(EXTRA_REQUEST_ID);
            Uri uri = (Uri) intent.getParcelableExtra(EXTRA_PATH);
            try {
                Closeable openInputStream = getContentResolver().openInputStream(uri);
                try {
                    uploadImage(openInputStream, uri, stringExtra, (FileUploadLease) getFileUploadLease(uri.getLastPathSegment(), "image/*").call());
                } catch (Intent intent2) {
                    Timber.c(intent2, "file upload failed", new Object[0]);
                    EventBus.getDefault().post(new UploadErrorEvent(stringExtra, intent2));
                } finally {
                    IOUtil.m23719a(openInputStream);
                }
            } catch (Throwable e) {
                Timber.c(e, "Failed creating stream from path: %s", new Object[]{uri});
                EventBus.getDefault().post(new UploadErrorEvent(stringExtra, e));
            }
        }
    }

    private void uploadImage(InputStream inputStream, Uri uri, String str, FileUploadLease fileUploadLease) {
        StringBuilder stringBuilder = new StringBuilder("https:");
        stringBuilder.append(fileUploadLease.action);
        inputStream = RemoteRedditApiDataSource.a(stringBuilder.toString(), inputStream, uri.getLastPathSegment(), fileUploadLease.fields);
        if (inputStream.success != null) {
            EventBus.getDefault().post(new UploadSuccessEvent(str, inputStream.fileUrl));
        } else {
            EventBus.getDefault().post(new UploadErrorEvent(str, new Exception(Util.m24027f((int) C1761R.string.error_unable_to_upload))));
        }
    }

    private Callable<FileUploadLease> getFileUploadLease(String str, String str2) {
        return new UploadService$$Lambda$0(this, str, str2);
    }

    final /* synthetic */ FileUploadLease lambda$getFileUploadLease$0$UploadService(String str, String str2) throws Exception {
        return (FileUploadLease) RemoteRedditApiDataSource.e(str, str2).blockingGet();
    }
}
