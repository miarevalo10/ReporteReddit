package com.reddit.datalibrary.frontpage.service.api;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Xml;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitVideoResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease.Field;
import com.reddit.datalibrary.frontpage.service.api.SubmitService.SubmitErrorEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.VideoUploadEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoUploadEvent.VideoUploadPayload;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.util.FileUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.XmlUtils;
import com.reddit.frontpage.util.XmlUtils.XMLObject;
import de.greenrobot.event.EventBus;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.parceler.Parcel;
import org.parceler.Parcels;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import retrofit2.Call;
import timber.log.Timber;

public class VideoUploadService extends Service {
    private static final int BUFFER_SIZE = 65536;
    private static final String CANCEL_UPLOAD_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.CANCEL_UPLOAD_ACTION";
    private static final int CANCEL_UPLOAD_REQUEST_CODE = 1;
    private static final int CORE_POOL_THREADS = 1;
    private static final String ERROR_XML_KEY = "Error";
    private static final String FILE_PATH_TAG = "file_path";
    private static final String FILE_PROPERTY_NAME = "file";
    private static final int INITIAL_EXECUTOR_QUEUE_SIZE = 10;
    private static final String IS_GIV_TAG = "is_gif";
    private static final String KEY_XML_KEY = "Key";
    private static final String KIND_GIF = "videogif";
    private static final String KIND_VIDEO = "video";
    private static final String LOCATION_XML_KEY = "Location";
    private static final int MAX_POOL_THREADS = 1;
    private static final int MAX_UPLOAD_ATTEMPTS = 1;
    private static final String MESSAGE_XML_KEY = "Message";
    private static final String NOTIFICATION_ID_TAG = "notification_id";
    private static final String PNG_MIME_TYPE = "image/png";
    private static final String PUBLISH_POST_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.PUBLISH_POST_ACTION";
    private static final String REQUEST_ID_TAG = "request_id";
    private static final String RESUME_UPLOADS_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.RESUME_UPLOADS_ACTION";
    private static final int RETRY_POST_REQUEST_CODE = 3;
    private static final String RETRY_PUBLISH_POST_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.RETRY_PUBLISH_POST_ACTION";
    private static final String RETRY_UPLOAD_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.RETRY_UPLOAD_ACTION";
    private static final int RETRY_UPLOAD_REQUEST_CODE = 2;
    private static final long SERVICE_SHUTDOWN_DELAY_MILLIS = 60000;
    private static final String TRANSCODING_COMPLETE_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.TRANSCODING_COMPLETE_ACTION";
    private static final String TRANSCODING_LIST_TAG = "transcoding_list";
    private static final Subject<String> UPLOAD_FAILED_BUS = PublishSubject.create();
    private static final String UPLOAD_FILE_ACTION = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UPLOAD_ACTION";
    private static final Subject<UploadProgress> UPLOAD_PROGRESS_BUS = PublishSubject.create();
    private static final Subject<String> VIDEO_DELETED_BUS = PublishSubject.create();
    private static final String VIDEO_MIME_TYPE = "video/mp4";
    public static final int VIDEO_POST_FAILED = 7;
    public static final int VIDEO_POST_PUBLISHED = 5;
    public static final int VIDEO_POST_QUEUED = 4;
    private static final Subject<VideoState> VIDEO_STATE_BUS = BehaviorSubject.m38175a();
    public static final int VIDEO_UPLOAD_COMPLETE = 3;
    public static final int VIDEO_UPLOAD_FAILED = 6;
    public static final int VIDEO_UPLOAD_IN_PROGRESS = 2;
    public static final int VIDEO_UPLOAD_NOT_STARTED = 0;
    public static final int VIDEO_UPLOAD_QUEUED = 1;
    private static final AtomicInteger notificationIndex = new AtomicInteger(100);
    private final ThreadPoolExecutor backgroundExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(10, new PriorityFutureComparator())) {
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new PriorityFuture(super.newTaskFor(runnable, t), ((PriorityTask) runnable).getPriority());
        }
    };
    private volatile Call<String> currentUploadRequest;
    private final Handler handler = new Handler();
    private NotificationManager notificationManager;
    private final SimpleArrayMap<String, Integer> notificationMap = new SimpleArrayMap();
    private Builder progressBuilder;
    @Inject
    RemoteRedditApiDataSource remoteRedditApiDataSource;
    private volatile String requestInProgressId;
    private final AtomicBoolean serverBusy = new AtomicBoolean(false);
    private final Runnable shutdownRunnable = new VideoUploadService$$Lambda$0(this);
    private Disposable stateDisposable;
    private final SimpleArrayMap<String, Future<?>> uploadFutures = new SimpleArrayMap();
    private long uploadStartMillis;
    private int videoHeight;
    private int videoWidth;

    private abstract class BackgroundTask implements Runnable {
        public abstract void execute() throws Exception;

        public void onError(Throwable th) {
        }

        public void onPostExecute(boolean z) {
        }

        private BackgroundTask() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r0 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r0 = r0.serverBusy;
            r1 = 1;
            r0.set(r1);
            r0 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r0.cancelShutdownRequest();
            r0 = 0;
            r6.execute();	 Catch:{ Throwable -> 0x0048, all -> 0x0045 }
            r6.onPostExecute(r0);	 Catch:{ Throwable -> 0x0017 }
            goto L_0x001f;
        L_0x0017:
            r1 = move-exception;
            r2 = "onPostExecute failed";
            r3 = new java.lang.Object[r0];
            timber.log.Timber.c(r1, r2, r3);
        L_0x001f:
            r1 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r1 = r1.backgroundExecutor;
            r1 = r1.getQueue();
            r1 = r1.isEmpty();
            if (r1 == 0) goto L_0x003b;
        L_0x002f:
            r1 = "No further tasks in queue, scheduling service shutdown";
            r2 = new java.lang.Object[r0];
            timber.log.Timber.b(r1, r2);
            r1 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r1.scheduleServiceShutdown();
        L_0x003b:
            r1 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r1 = r1.serverBusy;
            r1.set(r0);
            return;
        L_0x0045:
            r1 = move-exception;
            r2 = r0;
            goto L_0x006d;
        L_0x0048:
            r2 = move-exception;
            r6.onError(r2);	 Catch:{ all -> 0x0069 }
            r6.onPostExecute(r1);	 Catch:{ Throwable -> 0x0050 }
            goto L_0x0058;
        L_0x0050:
            r1 = move-exception;
            r2 = "onPostExecute failed";
            r3 = new java.lang.Object[r0];
            timber.log.Timber.c(r1, r2, r3);
        L_0x0058:
            r1 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r1 = r1.backgroundExecutor;
            r1 = r1.getQueue();
            r1 = r1.isEmpty();
            if (r1 == 0) goto L_0x003b;
        L_0x0068:
            goto L_0x002f;
        L_0x0069:
            r2 = move-exception;
            r5 = r2;
            r2 = r1;
            r1 = r5;
        L_0x006d:
            r6.onPostExecute(r2);	 Catch:{ Throwable -> 0x0071 }
            goto L_0x0079;
        L_0x0071:
            r2 = move-exception;
            r3 = "onPostExecute failed";
            r4 = new java.lang.Object[r0];
            timber.log.Timber.c(r2, r3, r4);
        L_0x0079:
            r2 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r2 = r2.backgroundExecutor;
            r2 = r2.getQueue();
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x0095;
        L_0x0089:
            r2 = "No further tasks in queue, scheduling service shutdown";
            r3 = new java.lang.Object[r0];
            timber.log.Timber.b(r2, r3);
            r2 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r2.scheduleServiceShutdown();
        L_0x0095:
            r2 = com.reddit.datalibrary.frontpage.service.api.VideoUploadService.this;
            r2 = r2.serverBusy;
            r2.set(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.service.api.VideoUploadService.BackgroundTask.run():void");
        }
    }

    private static class PriorityFutureComparator implements Comparator<Runnable> {
        private PriorityFutureComparator() {
        }

        public int compare(Runnable runnable, Runnable runnable2) {
            if (runnable == null && runnable2 == null) {
                return 0;
            }
            if (runnable == null) {
                return 1;
            }
            if (runnable2 == null) {
                return -1;
            }
            runnable = ((PriorityFuture) runnable).getPriority();
            runnable2 = ((PriorityFuture) runnable2).getPriority();
            if (runnable > runnable2) {
                return -1;
            }
            return runnable == runnable2 ? 0 : 1;
        }
    }

    private static final class SubmitException extends IOException {
        SubmitException() {
            super("Submit video failed");
        }

        SubmitException(String str) {
            super(str);
        }
    }

    @Parcel
    public static final class TranscodingCompleteEvent {
        public final String key;
        public final boolean success;

        public TranscodingCompleteEvent(String str, boolean z) {
            this.key = str;
            this.success = z;
        }
    }

    private static final class UploadCancelledException extends IOException {
        UploadCancelledException() {
            super("Upload cancelled");
        }
    }

    private static final class UploadException extends IOException {
        UploadException() {
            super("Upload failed");
        }

        UploadException(String str) {
            super(str);
        }
    }

    public static final class UploadProgress {
        public final float progress;
        public final String requestId;

        public UploadProgress(String str, float f) {
            this.requestId = str;
            this.progress = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    UploadProgress uploadProgress = (UploadProgress) obj;
                    return Float.compare(uploadProgress.progress, this.progress) == 0 && this.requestId.equals(uploadProgress.requestId) != null;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * this.requestId.hashCode()) + (this.progress != 0.0f ? Float.floatToIntBits(this.progress) : 0);
        }
    }

    private static final class UploadResponsePayload {
        final String imageUploadUrl;
        final String videoKey;
        final String videoUploadUrl;

        UploadResponsePayload(String str, String str2, String str3) {
            this.videoUploadUrl = str;
            this.imageUploadUrl = str2;
            this.videoKey = str3;
        }
    }

    private static final class VideoImages {
        final String cover;
        final String thumbnail;

        VideoImages(String str, String str2) {
            this.cover = str;
            this.thumbnail = str2;
        }

        final void deleteCoverImageIfUnique() {
            if (!this.cover.equals(this.thumbnail)) {
                new File(this.cover).delete();
            }
        }
    }

    public static final class VideoState {
        public final String requestId;
        public final int state;

        public VideoState(String str, int i) {
            this.requestId = str;
            this.state = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    VideoState videoState = (VideoState) obj;
                    return this.state == videoState.state && this.requestId.equals(videoState.requestId) != null;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * this.requestId.hashCode()) + this.state;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoUploadState {
    }

    private abstract class PriorityTask extends BackgroundTask {
        private final int priority;

        PriorityTask(int i) {
            super();
            this.priority = i;
        }

        public int getPriority() {
            return this.priority;
        }
    }

    public static class SubmitVideoResultEvent extends BaseEvent {
        public final String requestId;

        public SubmitVideoResultEvent(String str) {
            this.requestId = str;
        }
    }

    private abstract class VideoTask extends PriorityTask {
        protected final String requestId;

        VideoTask(int i, String str) {
            super(i);
            this.requestId = str;
        }

        VideoUpload getVideoUpload() {
            return VideoUploadService.this.getVideoUploadWithRequestId(this.requestId);
        }

        VideoUpload getVideoUploadOrThrow() throws IOException {
            VideoUpload videoUpload = getVideoUpload();
            if (videoUpload != null) {
                return videoUpload;
            }
            throw new IOException("Video entry in DB was deleted after upload was scheduled");
        }

        void transitionToState(int i) {
            VideoUploadService.this.updateVideoUploadStateWithRequestId(this.requestId, i);
            VideoUploadService.VIDEO_STATE_BUS.onNext(new VideoState(this.requestId, i));
        }
    }

    private final class SubmitPostTask extends VideoTask {
        SubmitPostTask(String str) {
            super(100, str);
        }

        public final void execute() throws Exception {
            Timber.b("submitPost, request [%s]", new Object[]{this.requestId});
            parseSubmitResponse(submitVideoPost(getVideoUploadOrThrow()));
        }

        public final void onError(Throwable th) {
            Timber.c(th, "Post submission failed", new Object[0]);
            transitionToState(7);
            VideoUpload videoUpload = getVideoUpload();
            if (videoUpload != null) {
                VideoUploadService.this.showUploadFailedNotification(videoUpload);
                VideoUploadService.this.sendUploadAnalytics(videoUpload);
            }
            String string = VideoUploadService.this.getString(C1761R.string.error_video_submission);
            if (th.getMessage().equals("Submit video failed") != null) {
                string = VideoUploadService.this.getString(C1761R.string.error_video_not_allowed);
            }
            EventBus.getDefault().post(new SubmitErrorEvent(this.requestId, new Exception(string)));
        }

        public final void onPostExecute(boolean z) {
            VideoUpload videoUpload = getVideoUpload();
            if (videoUpload != null) {
                VideoUploadService.this.sendUploadAnalytics(videoUpload);
            }
            if (!z) {
                EventBus.getDefault().postSticky(new SubmitVideoResultEvent(this.requestId));
            }
        }

        private SubmitVideoResponse submitVideoPost(VideoUpload videoUpload) throws ExecutionException, InterruptedException {
            try {
                RemoteRedditApiDataSource remoteRedditApiDataSource = VideoUploadService.this.remoteRedditApiDataSource;
                return (SubmitVideoResponse) RemoteRedditApiDataSource.b(videoUpload.getSubreddit(), videoUpload.getTitle(), VideoUploadService.this.getNameFromPath(videoUpload.getFilePath()), videoUpload.getUploadUrl(), videoUpload.getPosterUrl(), videoUpload.isGif() != null ? VideoUploadService.KIND_GIF : "video").blockingGet();
            } catch (VideoUpload videoUpload2) {
                Timber.c(videoUpload2, "", new Object[0]);
                return null;
            }
        }

        private void parseSubmitResponse(SubmitVideoResponse submitVideoResponse) throws SubmitException {
            if (submitVideoResponse.a()) {
                submitVideoResponse = submitVideoResponse.b();
                if (!TextUtils.isEmpty(submitVideoResponse)) {
                    VideoUpload videoUpload = getVideoUpload();
                    if (videoUpload != null) {
                        videoUpload.setUploadError(submitVideoResponse);
                        videoUpload.save();
                    }
                }
                throw new SubmitException();
            }
            transitionToState(5);
        }
    }

    private final class UploadFileTask extends VideoTask {
        private static final int MAX_THUMB_DIMENSION = 640;
        private static final String PNG_FILE_EXTENSION = ".png";
        private Disposable disposable = null;
        private InputStream inputStream = null;
        private int progressNotificationId;
        private String uploadError;
        private String videoUploadUrl;

        UploadFileTask(String str) {
            super(0, str);
        }

        public final void execute() throws Exception {
            Timber.b("Upload executor: starting upload for request [%s]", new Object[]{this.requestId});
            VideoUploadService.this.uploadStartMillis = System.currentTimeMillis();
            transitionToInProgress();
            String videoFilePath = getVideoFilePath();
            String uploadCoverImage = uploadCoverImage(videoFilePath);
            FileUploadResponse uploadVideo = uploadVideo(videoFilePath);
            checkForCancelledRequest();
            validateUploadResponse(uploadVideo);
            transitionToUploadComplete(new UploadResponsePayload(this.videoUploadUrl, uploadCoverImage, getVideoUploadKey(uploadVideo)));
            VideoUploadService.this.schedulePublishPostTask(this.requestId);
        }

        public final void onError(Throwable th) {
            Timber.c(th, "Upload executor: Upload failed", new Object[0]);
            this.uploadError = th.getMessage();
            Future future = (Future) VideoUploadService.this.uploadFutures.get(this.requestId);
            VideoUpload videoUpload = getVideoUpload();
            if ((th instanceof UploadCancelledException) == null) {
                if (future == null || future.isCancelled() == null) {
                    onRequestFailed(videoUpload);
                    return;
                }
            }
            onRequestCancelled(videoUpload);
        }

        public final void onPostExecute(boolean z) {
            Timber.b("Upload executor: on post execute, failed [%s]", new Object[]{String.valueOf(z)});
            VideoUploadService.this.currentUploadRequest = null;
            Util.m23989a(this.inputStream);
            this.inputStream = null;
            if (this.disposable != null) {
                this.disposable.mo5626a();
            }
            cancelProgressNotification();
            VideoUploadService.this.scheduleNextUpload();
            VideoUploadService.this.uploadFutures.remove(this.requestId);
            VideoUploadService.this.requestInProgressId = null;
            VideoUpload videoUpload = getVideoUpload();
            if (videoUpload != null) {
                VideoUploadService.this.updateVideoUploadWithUploadResult(videoUpload, this.uploadError);
                if (z) {
                    VideoUploadService.this.sendUploadAnalytics(getVideoUpload());
                }
            }
        }

        private String getVideoFilePath() throws Exception {
            return getVideoUploadOrThrow().getFilePath();
        }

        private void transitionToInProgress() {
            VideoUploadService.this.requestInProgressId = this.requestId;
            this.progressNotificationId = -1;
            transitionToState(2);
        }

        private String uploadCoverImage(String str) throws IOException, ExecutionException, InterruptedException {
            String access$1700 = VideoUploadService.this.getNameFromPath(str);
            str = extractCoverAndThumbnail(str);
            access$1700 = uploadCoverImage(access$1700, str.cover);
            str.deleteCoverImageIfUnique();
            return access$1700;
        }

        private void checkForCancelledRequest() throws UploadCancelledException {
            if (VideoUploadService.this.currentUploadRequest != null && VideoUploadService.this.currentUploadRequest.c()) {
                Timber.b("Upload executor: Upload cancelled", new Object[0]);
                throw new UploadCancelledException();
            }
        }

        private void validateUploadResponse(FileUploadResponse fileUploadResponse) throws UploadException {
            if (fileUploadResponse.success != null) {
                Timber.b("Upload executor: Upload successful", new Object[0]);
            } else {
                Timber.e("Upload executor: Video upload failed", new Object[0]);
                throw new UploadException("Upload executor: Upload failed");
            }
        }

        private String getVideoUploadKey(FileUploadResponse fileUploadResponse) {
            fileUploadResponse = fileUploadResponse.fileKey;
            int lastIndexOf = fileUploadResponse != null ? fileUploadResponse.lastIndexOf(47) : -1;
            if (lastIndexOf >= 0) {
                fileUploadResponse = fileUploadResponse.substring(lastIndexOf + 1);
            }
            Timber.b("Video upload key [%s]", new Object[]{fileUploadResponse});
            return fileUploadResponse;
        }

        private void transitionToUploadComplete(UploadResponsePayload uploadResponsePayload) {
            SQLite.update(VideoUpload.class).set(new SQLOperator[]{VideoUpload_Table.status.eq(Integer.valueOf(3)), VideoUpload_Table.uploadUrl.eq(uploadResponsePayload.videoUploadUrl), VideoUpload_Table.posterUrl.eq(uploadResponsePayload.imageUploadUrl), VideoUpload_Table.videoKey.eq(uploadResponsePayload.videoKey)}).where(new SQLOperator[]{VideoUpload_Table.requestId.is(this.requestId)}).execute();
            VideoUploadService.VIDEO_STATE_BUS.onNext(new VideoState(this.requestId, 3));
        }

        private VideoImages extractCoverAndThumbnail(String str) throws IOException {
            Bitmap halfMarkBitmap = getHalfMarkBitmap(str);
            storeVideoDimensions(halfMarkBitmap);
            String saveBitmap = saveBitmap(halfMarkBitmap);
            Bitmap scaledBitmap = getScaledBitmap(halfMarkBitmap);
            SQLite.update(VideoUpload.class).set(new SQLOperator[]{VideoUpload_Table.thumbnail.eq(scaledBitmap != halfMarkBitmap ? saveBitmap(scaledBitmap) : saveBitmap)}).where(new SQLOperator[]{VideoUpload_Table.requestId.is(this.requestId)}).execute();
            return new VideoImages(saveBitmap, scaledBitmap != halfMarkBitmap ? saveBitmap(scaledBitmap) : saveBitmap);
        }

        private Bitmap getHalfMarkBitmap(String str) throws IOException {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(VideoUploadService.this, Uri.parse(str));
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime((1000 * Long.parseLong(mediaMetadataRetriever.extractMetadata(9))) / 2, 2);
            if (frameAtTime != null) {
                return frameAtTime;
            }
            StringBuilder stringBuilder = new StringBuilder("Failed to extract bitmap for cover image from [");
            stringBuilder.append(str);
            stringBuilder.append("]");
            throw new IOException(stringBuilder.toString());
        }

        private Bitmap getScaledBitmap(Bitmap bitmap) throws IOException {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= MAX_THUMB_DIMENSION) {
                if (height <= MAX_THUMB_DIMENSION) {
                    return bitmap;
                }
            }
            float f = 640.0f / ((float) (width > height ? width : height));
            return Bitmap.createScaledBitmap(bitmap, (int) ((((float) width) * f) + 0.5f), (int) ((((float) height) * f) + 0.5f), false);
        }

        private void storeVideoDimensions(Bitmap bitmap) {
            if (bitmap != null) {
                VideoUploadService.this.videoWidth = bitmap.getWidth();
                VideoUploadService.this.videoHeight = bitmap.getHeight();
                return;
            }
            VideoUploadService.this.videoWidth = 0;
            VideoUploadService.this.videoHeight = 0;
        }

        private String saveBitmap(Bitmap bitmap) throws IOException {
            File a = FileUtil.m23691a(PNG_FILE_EXTENSION);
            Closeable closeable = null;
            try {
                Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a), VideoUploadService.BUFFER_SIZE);
                try {
                    bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
                    bitmap = a.getAbsolutePath();
                    Util.m23989a(bufferedOutputStream);
                    return bitmap;
                } catch (Throwable th) {
                    bitmap = th;
                    closeable = bufferedOutputStream;
                    Util.m23989a(closeable);
                    throw bitmap;
                }
            } catch (Throwable th2) {
                bitmap = th2;
                Util.m23989a(closeable);
                throw bitmap;
            }
        }

        private String uploadCoverImage(String str, String str2) throws ExecutionException, InterruptedException, IOException {
            try {
                RemoteRedditApiDataSource remoteRedditApiDataSource = VideoUploadService.this.remoteRedditApiDataSource;
                FileUploadLease fileUploadLease = (FileUploadLease) RemoteRedditApiDataSource.e(str, VideoUploadService.PNG_MIME_TYPE).blockingGet();
                getInputStream(str2);
                Timber.b("Upload cover URL [%s]", new Object[]{getUploadUrl(fileUploadLease)});
                RemoteRedditApiDataSource remoteRedditApiDataSource2 = VideoUploadService.this.remoteRedditApiDataSource;
                str = getImageUploadUrl(RemoteRedditApiDataSource.a(str2, this.inputStream, str, fileUploadLease.fields));
            } catch (String str3) {
                Timber.c(str3, "VideoUploadService.uploadCoverImage", new Object[0]);
                return null;
            } finally {
                Util.m23989a(this.inputStream);
                this.inputStream = null;
            }
            return str3;
        }

        private String getImageUploadUrl(FileUploadResponse fileUploadResponse) throws UploadException {
            if (!fileUploadResponse.success || TextUtils.isEmpty(fileUploadResponse.fileUrl)) {
                Timber.e("Cover image upload failed", new Object[0]);
                throw new UploadException("Image upload failed");
            }
            Timber.b("Cover image upload successful, url [%s]", new Object[]{fileUploadResponse.fileUrl});
            return fileUploadResponse.fileUrl;
        }

        private FileUploadResponse uploadVideo(String str) throws IOException, ExecutionException, InterruptedException, XmlPullParserException {
            String access$1700 = VideoUploadService.this.getNameFromPath(str);
            VideoUpload videoUpload = getVideoUpload();
            if (videoUpload != null && videoUpload.hasPostData()) {
                this.progressNotificationId = VideoUploadService.this.buildAndShowProgressNotification(this.requestId, access$1700);
            }
            setupProgressListener(access$1700);
            getInputStream(str);
            FileUploadLease fileUploadLease = getFileUploadLease(access$1700);
            return parseUploadResponse(uploadFile(getUploadUrl(fileUploadLease), str, getPartParameters(fileUploadLease)));
        }

        private void getInputStream(String str) throws IOException {
            InputStream openInputStream = VideoUploadService.this.getContentResolver().openInputStream(Uri.fromFile(new File(str)));
            if (openInputStream == null) {
                StringBuilder stringBuilder = new StringBuilder("Failed to open input stream for ");
                stringBuilder.append(str);
                throw new IOException(stringBuilder.toString());
            }
            this.inputStream = new BufferedInputStream(openInputStream, VideoUploadService.BUFFER_SIZE);
        }

        private FileUploadLease getFileUploadLease(String str) throws ExecutionException, InterruptedException {
            RemoteRedditApiDataSource remoteRedditApiDataSource = VideoUploadService.this.remoteRedditApiDataSource;
            return (FileUploadLease) RemoteRedditApiDataSource.f(str, VideoUploadService.VIDEO_MIME_TYPE).blockingGet();
        }

        private String getUploadUrl(FileUploadLease fileUploadLease) {
            StringBuilder stringBuilder = new StringBuilder("https:");
            stringBuilder.append(fileUploadLease.action);
            Timber.b("Upload URL [%s]", new Object[]{stringBuilder.toString()});
            return stringBuilder.toString();
        }

        private Map<String, String> getPartParameters(FileUploadLease fileUploadLease) {
            Map<String, String> arrayMap = new ArrayMap(fileUploadLease.fields.size());
            for (Field field : fileUploadLease.fields) {
                if (field.value != null) {
                    arrayMap.put(field.name, field.value);
                } else {
                    Timber.d("Null value for key [%s]", new Object[]{field.name});
                }
            }
            return arrayMap;
        }

        private void setupProgressListener(String str) {
            this.disposable = VideoUploadService.UPLOAD_PROGRESS_BUS.filter(new VideoUploadService$UploadFileTask$$Lambda$0(this)).throttleLast(500, TimeUnit.MILLISECONDS).distinctUntilChanged().subscribe(new VideoUploadService$UploadFileTask$$Lambda$1(this, str));
        }

        final /* synthetic */ boolean lambda$setupProgressListener$0$VideoUploadService$UploadFileTask(UploadProgress uploadProgress) throws Exception {
            return uploadProgress.requestId.equals(this.requestId);
        }

        final /* synthetic */ void lambda$setupProgressListener$1$VideoUploadService$UploadFileTask(String str, UploadProgress uploadProgress) throws Exception {
            onUploadProgress(str, uploadProgress);
        }

        private void onUploadProgress(String str, UploadProgress uploadProgress) {
            Timber.a("Upload progress [%d]", new Object[]{Integer.valueOf((int) ((uploadProgress.progress * 100.0f) + 0.5f))});
            if (this.progressNotificationId >= 0) {
                VideoUploadService.this.updateProgressNotification(this.progressNotificationId, uploadProgress.progress);
                return;
            }
            VideoUpload videoUpload = getVideoUpload();
            if (videoUpload != null && videoUpload.hasPostData()) {
                this.progressNotificationId = VideoUploadService.this.buildAndShowProgressNotification(videoUpload.getRequestId(), str);
                VideoUploadService.this.updateProgressNotification(this.progressNotificationId, uploadProgress.progress);
            }
        }

        private String uploadFile(String str, String str2, Map<String, String> map) throws IOException {
            RequestBody videoUploadRequestBody = new VideoUploadRequestBody(new File(str2), VideoUploadService.VIDEO_MIME_TYPE, this.requestId, VideoUploadService$UploadFileTask$$Lambda$2.$instance);
            str2 = Part.createFormData(VideoUploadService.FILE_PROPERTY_NAME, VideoUploadService.this.getNameFromPath(str2), videoUploadRequestBody);
            VideoUploadService.this.currentUploadRequest = FrontpageApplication.m28870f().mo4701b().uploadFile(str, map, str2);
            return VideoUploadService.this.currentUploadRequest.a().b;
        }

        private FileUploadResponse parseUploadResponse(String str) throws XmlPullParserException, IOException {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(new StringReader(str));
            str = XmlUtils.m24069a(newPullParser);
            validateSuccessfulUploadResponse(str);
            this.videoUploadUrl = getXmlValueOrThrow(str, "Location");
            return new FileUploadResponse(this.videoUploadUrl, getXmlValueOrThrow(str, VideoUploadService.KEY_XML_KEY), true);
        }

        private String getXmlValueOrThrow(XMLObject xMLObject, String str) throws UploadException {
            xMLObject = xMLObject.m24067a(str);
            if (xMLObject != null) {
                return xMLObject.f21823c;
            }
            StringBuilder stringBuilder = new StringBuilder("Key [");
            stringBuilder.append(str);
            stringBuilder.append("] missing in upload response");
            throw new UploadException(stringBuilder.toString());
        }

        private void onRequestCancelled(VideoUpload videoUpload) {
            Timber.b("Interrupted due to upload cancel request, deleting data from database", new Object[0]);
            if (videoUpload != null) {
                String thumbnail = videoUpload.getThumbnail();
                if (thumbnail != null) {
                    new File(thumbnail).delete();
                }
                videoUpload.delete();
            }
            VideoUploadService.VIDEO_DELETED_BUS.onNext(this.requestId);
        }

        private void onRequestFailed(VideoUpload videoUpload) {
            if (videoUpload != null) {
                VideoUploadService.VIDEO_STATE_BUS.onNext(new VideoState(this.requestId, increaseFailedAttempts(videoUpload)));
                if (videoUpload.hasPostData()) {
                    VideoUploadService.this.showUploadFailedNotification(videoUpload);
                }
            }
            VideoUploadService.UPLOAD_FAILED_BUS.onNext(this.requestId);
        }

        private int increaseFailedAttempts(VideoUpload videoUpload) {
            int i = videoUpload.getAttempts() + 1 <= 0 ? 0 : 6;
            videoUpload.setStatus(i);
            SQLite.update(VideoUpload.class).set(new SQLOperator[]{VideoUpload_Table.attempts.eq(Integer.valueOf(r0)), VideoUpload_Table.status.eq(Integer.valueOf(i))}).where(new SQLOperator[]{VideoUpload_Table.requestId.is(this.requestId)}).execute();
            return i;
        }

        private void cancelProgressNotification() {
            if (this.progressNotificationId >= 0) {
                VideoUploadService.this.stopForeground(true);
                this.progressNotificationId = -1;
            }
        }

        private void validateSuccessfulUploadResponse(XMLObject xMLObject) throws UploadException {
            if (xMLObject.f21824d.equalsIgnoreCase(VideoUploadService.ERROR_XML_KEY)) {
                xMLObject = xMLObject.m24067a(VideoUploadService.MESSAGE_XML_KEY);
                if (xMLObject != null) {
                    xMLObject = xMLObject.f21823c;
                } else {
                    xMLObject = null;
                }
                if (xMLObject == null) {
                    xMLObject = "Server error on upload request";
                }
                throw new UploadException(xMLObject);
            }
        }
    }

    static final /* synthetic */ Iterable lambda$getInterruptedUploads$20$VideoUploadService(List list) throws Exception {
        return list;
    }

    final /* synthetic */ boolean bridge$lambda$0$VideoUploadService() {
        return scheduleNextUpload();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public VideoUploadService() {
        FrontpageApplication.m28877m().mo4603a(this);
    }

    public static Intent getUploadFileIntent(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.setAction(UPLOAD_FILE_ACTION);
        intent.putExtra(FILE_PATH_TAG, str);
        intent.putExtra(REQUEST_ID_TAG, str2);
        intent.putExtra(IS_GIV_TAG, z);
        return intent;
    }

    public static Intent getSubmitPostIntent(Context context, String str) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.setAction(PUBLISH_POST_ACTION);
        intent.putExtra(REQUEST_ID_TAG, str);
        return intent;
    }

    public static Intent getCancelUploadIntent(Context context, String str) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.setAction(CANCEL_UPLOAD_ACTION);
        intent.putExtra(REQUEST_ID_TAG, str);
        return intent;
    }

    public static Intent getRetryUploadIntent(Context context, String str) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.setAction(RETRY_UPLOAD_ACTION);
        intent.putExtra(REQUEST_ID_TAG, str);
        return intent;
    }

    public static Intent getResumeUploadsIntent(Context context) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.setAction(RESUME_UPLOADS_ACTION);
        return intent;
    }

    public static Intent getVideoTranscodingFinishedIntent(Context context, String str, boolean z) {
        List arrayList = new ArrayList(1);
        arrayList.add(new TranscodingCompleteEvent(str, z));
        return getVideoTranscodingFinishedIntent(context, arrayList);
    }

    public static Intent getVideoTranscodingFinishedIntent(Context context, List<TranscodingCompleteEvent> list) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.setAction(TRANSCODING_COMPLETE_ACTION);
        intent.putExtra(TRANSCODING_LIST_TAG, Parcels.m28672a((Object) list));
        return intent;
    }

    public static String getVideoStateName(VideoUpload videoUpload) {
        return getVideoStateName(videoUpload.getStatus());
    }

    public static String getVideoStateName(int i) {
        switch (i) {
            case 0:
                return "VIDEO_UPLOAD_NOT_STARTED";
            case 1:
                return "VIDEO_UPLOAD_QUEUED";
            case 2:
                return "VIDEO_UPLOAD_IN_PROGRESS";
            case 3:
                return "VIDEO_UPLOAD_COMPLETE";
            case 4:
                return "VIDEO_POST_QUEUED";
            case 5:
                return "VIDEO_POST_PUBLISHED";
            case 6:
                return "VIDEO_UPLOAD_FAILED";
            case 7:
                return "VIDEO_POST_FAILED";
            default:
                StringBuilder stringBuilder = new StringBuilder("INVALID STATE: ");
                stringBuilder.append(i);
                return stringBuilder.toString();
        }
    }

    public static Observable<UploadProgress> getProgressObservable() {
        return UPLOAD_PROGRESS_BUS;
    }

    public static Observable<VideoState> getVideoStateObservable() {
        return VIDEO_STATE_BUS;
    }

    public static Observable<String> getUploadFailedObservable() {
        return UPLOAD_FAILED_BUS;
    }

    public static Observable<String> getVideoDeletedObservable() {
        return VIDEO_DELETED_BUS;
    }

    final /* synthetic */ void lambda$new$0$VideoUploadService() {
        if (!this.backgroundExecutor.getQueue().isEmpty() || this.serverBusy.get()) {
            Timber.d("Service shutdown was scheduled while tasks in queue or server busy,ignoring shutdown request", new Object[0]);
            return;
        }
        Timber.b("VideoUploadService shutting down", new Object[0]);
        this.backgroundExecutor.shutdown();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        this.notificationManager = (NotificationManager) getSystemService("notification");
    }

    public void onDestroy() {
        if (this.stateDisposable != null) {
            this.stateDisposable.mo5626a();
            this.stateDisposable = null;
        }
        super.onDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r10, int r11, int r12) {
        /*
        r9 = this;
        r11 = "onStartCommand";
        r12 = 0;
        r0 = new java.lang.Object[r12];
        timber.log.Timber.a(r11, r0);
        r11 = 1;
        if (r10 == 0) goto L_0x0145;
    L_0x000b:
        r0 = r10.getAction();
        if (r0 == 0) goto L_0x0145;
    L_0x0011:
        r0 = r10.getAction();
        r1 = "request_id";
        r1 = r10.getStringExtra(r1);
        r2 = "notification_id";
        r3 = -1;
        r2 = r10.getIntExtra(r2, r3);
        r4 = "onStartCommand, action [%s], request ID [%s], notification ID [%d]";
        r5 = 3;
        r6 = new java.lang.Object[r5];
        r6[r12] = r0;
        r6[r11] = r1;
        r7 = java.lang.Integer.valueOf(r2);
        r8 = 2;
        r6[r8] = r7;
        timber.log.Timber.b(r4, r6);
        r4 = "onStartCommand, server busy [%s], task queue depth [%d]";
        r6 = new java.lang.Object[r8];
        r7 = r9.serverBusy;
        r7 = r7.get();
        r7 = java.lang.String.valueOf(r7);
        r6[r12] = r7;
        r7 = r9.backgroundExecutor;
        r7 = r7.getQueue();
        r7 = r7.size();
        r7 = java.lang.Integer.valueOf(r7);
        r6[r11] = r7;
        timber.log.Timber.b(r4, r6);
        r4 = r0.hashCode();
        switch(r4) {
            case -2015910493: goto L_0x009c;
            case -1408176414: goto L_0x0092;
            case -813951523: goto L_0x0088;
            case 574563051: goto L_0x007e;
            case 1002855827: goto L_0x0074;
            case 1893850305: goto L_0x006a;
            case 2006296284: goto L_0x0060;
            default: goto L_0x005f;
        };
    L_0x005f:
        goto L_0x00a6;
    L_0x0060:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.RETRY_PUBLISH_POST_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x0068:
        r0 = r8;
        goto L_0x00a7;
    L_0x006a:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.CANCEL_UPLOAD_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x0072:
        r0 = r5;
        goto L_0x00a7;
    L_0x0074:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.PUBLISH_POST_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x007c:
        r0 = r11;
        goto L_0x00a7;
    L_0x007e:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.RETRY_UPLOAD_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x0086:
        r0 = 4;
        goto L_0x00a7;
    L_0x0088:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.TRANSCODING_COMPLETE_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x0090:
        r0 = 6;
        goto L_0x00a7;
    L_0x0092:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UPLOAD_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x009a:
        r0 = r12;
        goto L_0x00a7;
    L_0x009c:
        r4 = "com.reddit.datalibrary.frontpage.service.api.VideoUploadService.RESUME_UPLOADS_ACTION";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00a6;
    L_0x00a4:
        r0 = 5;
        goto L_0x00a7;
    L_0x00a6:
        r0 = r3;
    L_0x00a7:
        switch(r0) {
            case 0: goto L_0x0121;
            case 1: goto L_0x0116;
            case 2: goto L_0x0116;
            case 3: goto L_0x00f1;
            case 4: goto L_0x00d3;
            case 5: goto L_0x00ce;
            case 6: goto L_0x00ac;
            default: goto L_0x00aa;
        };
    L_0x00aa:
        goto L_0x0145;
    L_0x00ac:
        r0 = "transcoding_list";
        r10 = r10.getParcelableExtra(r0);
        r10 = org.parceler.Parcels.m28673a(r10);
        r10 = (java.util.List) r10;
        if (r10 == 0) goto L_0x00c5;
    L_0x00ba:
        r0 = r10.isEmpty();
        if (r0 != 0) goto L_0x00c5;
    L_0x00c0:
        r9.onTranscodingComplete(r10);
        goto L_0x0145;
    L_0x00c5:
        r10 = "Invalid argument, no video key provided";
        r12 = new java.lang.Object[r12];
        timber.log.Timber.e(r10, r12);
        goto L_0x0145;
    L_0x00ce:
        r9.resumeInterruptedUploads();
        goto L_0x0145;
    L_0x00d3:
        if (r2 < 0) goto L_0x00da;
    L_0x00d5:
        r10 = r9.notificationManager;
        r10.cancel(r2);
    L_0x00da:
        r10 = r9.notificationMap;
        r10 = r10.remove(r1);
        r10 = (java.lang.Integer) r10;
        if (r10 == 0) goto L_0x00ed;
    L_0x00e4:
        r12 = r9.notificationManager;
        r10 = r10.intValue();
        r12.cancel(r10);
    L_0x00ed:
        r9.retryUpload(r1);
        goto L_0x0145;
    L_0x00f1:
        r10 = android.text.TextUtils.isEmpty(r1);
        if (r10 != 0) goto L_0x00fb;
    L_0x00f7:
        r9.cancelUploadRequest(r1);
        goto L_0x0102;
    L_0x00fb:
        r10 = "Invalid arguments, no request id provided";
        r12 = new java.lang.Object[r12];
        timber.log.Timber.e(r10, r12);
    L_0x0102:
        r10 = r9.notificationMap;
        r10 = r10.remove(r1);
        r10 = (java.lang.Integer) r10;
        if (r10 == 0) goto L_0x0145;
    L_0x010c:
        r12 = r9.notificationManager;
        r10 = r10.intValue();
        r12.cancel(r10);
        goto L_0x0145;
    L_0x0116:
        if (r2 < 0) goto L_0x011d;
    L_0x0118:
        r10 = r9.notificationManager;
        r10.cancel(r2);
    L_0x011d:
        r9.publishPost(r1);
        goto L_0x0145;
    L_0x0121:
        r0 = "file_path";
        r0 = r10.getStringExtra(r0);
        r2 = "is_gif";
        r10 = r10.getBooleanExtra(r2, r12);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x013e;
    L_0x0133:
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 == 0) goto L_0x013a;
    L_0x0139:
        goto L_0x013e;
    L_0x013a:
        r9.uploadVideoFile(r1, r0, r10);
        goto L_0x0145;
    L_0x013e:
        r10 = "Invalid arguments, no request id or file path provided";
        r12 = new java.lang.Object[r12];
        timber.log.Timber.e(r10, r12);
    L_0x0145:
        r10 = r9.backgroundExecutor;
        r10 = r10.getQueue();
        r10 = r10.isEmpty();
        if (r10 == 0) goto L_0x0154;
    L_0x0151:
        r9.cancelShutdownRequest();
    L_0x0154:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.service.api.VideoUploadService.onStartCommand(android.content.Intent, int, int):int");
    }

    private void uploadVideoFile(String str, String str2, boolean z) {
        Observable.fromCallable(new VideoUploadService$$Lambda$1(this, str, str2, z)).ignoreElements().subscribeOn(SchedulerProvider.m23886b()).subscribe();
    }

    final /* synthetic */ Boolean lambda$uploadVideoFile$2$VideoUploadService(String str, String str2, boolean z) throws Exception {
        Timber.b("uploadVideoFile: storing data for request [%s], file [%s]", new Object[]{str, str2});
        if (getVideoUploadWithRequestId(str) == null) {
            VideoUpload videoUpload = new VideoUpload();
            videoUpload.setStatus(0);
            videoUpload.setFilePath(str2);
            videoUpload.setRequestId(str);
            videoUpload.setTimestamp(System.currentTimeMillis());
            videoUpload.setGif(z);
            videoUpload.setAttempts(0);
            videoUpload.save();
        }
        VIDEO_STATE_BUS.onNext(new VideoState(str, 0));
        scheduleNextUpload();
        return Boolean.valueOf(true);
    }

    private void publishPost(String str) {
        Timber.b("Publish request for [%s]", new Object[]{str});
        Observable.fromCallable(new VideoUploadService$$Lambda$2(this, str)).ignoreElements().subscribeOn(SchedulerProvider.m23886b()).subscribe();
    }

    final /* synthetic */ Boolean lambda$publishPost$3$VideoUploadService(String str) throws Exception {
        return Boolean.valueOf(schedulePublishPostTask(str));
    }

    private boolean schedulePublishPostTask(String str) {
        VideoUpload videoUploadWithRequestId = getVideoUploadWithRequestId(str);
        return (videoUploadWithRequestId == null || schedulePublishPostTask(videoUploadWithRequestId) == null) ? null : true;
    }

    private boolean schedulePublishPostTask(VideoUpload videoUpload) {
        if ((videoUpload.getStatus() == 3 || videoUpload.getStatus() == 7) && videoUpload.hasPostData()) {
            updateVideoUploadStateWithRequestId(videoUpload.getRequestId(), 4);
            VIDEO_STATE_BUS.onNext(new VideoState(videoUpload.getRequestId(), 4));
            Timber.b("Queue publish request for [%s]", new Object[]{videoUpload.getRequestId()});
            this.backgroundExecutor.submit(new SubmitPostTask(videoUpload.getRequestId()));
            return true;
        }
        Timber.d("Not queueing post because video instance is in state [%s]", new Object[]{getVideoStateName(videoUpload)});
        return false;
    }

    private void retryUpload(String str) {
        Maybe.fromCallable(new VideoUploadService$$Lambda$3(this, str)).filter(VideoUploadService$$Lambda$4.$instance).map(new VideoUploadService$$Lambda$5(this, str)).subscribeOn(SchedulerProvider.m23886b()).subscribe();
    }

    final /* synthetic */ VideoUpload lambda$retryUpload$4$VideoUploadService(String str) throws Exception {
        return getVideoUploadWithRequestId(str);
    }

    static final /* synthetic */ boolean lambda$retryUpload$5$VideoUploadService(VideoUpload videoUpload) throws Exception {
        if (videoUpload.getStatus() != 6) {
            if (videoUpload.getStatus() != 7) {
                return null;
            }
        }
        return true;
    }

    final /* synthetic */ VideoUpload lambda$retryUpload$6$VideoUploadService(String str, VideoUpload videoUpload) throws Exception {
        if (videoUpload.getStatus() == 6) {
            updateVideoUploadStateWithRequestId(str, 0);
            VIDEO_STATE_BUS.onNext(new VideoState(videoUpload.getRequestId(), 0));
            Timber.b("Retry upload, schedule next upload", new Object[0]);
            scheduleNextUpload();
        } else {
            Timber.b("Retry post, schedule next post", new Object[0]);
            schedulePublishPostTask(videoUpload);
        }
        return videoUpload;
    }

    private VideoUpload getVideoUploadWithRequestId(String str) {
        return (VideoUpload) SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.requestId.eq(str)}).querySingle();
    }

    private void onTranscodingComplete(List<TranscodingCompleteEvent> list) {
        Observable.fromIterable(list).flatMap(new VideoUploadService$$Lambda$6(this, new VideoUpload())).ignoreElements().subscribeOn(SchedulerProvider.m23886b()).subscribe();
    }

    final /* synthetic */ ObservableSource lambda$onTranscodingComplete$9$VideoUploadService(VideoUpload videoUpload, TranscodingCompleteEvent transcodingCompleteEvent) throws Exception {
        return Observable.zip(Observable.fromCallable(new VideoUploadService$$Lambda$20(this, transcodingCompleteEvent, videoUpload)), Observable.just(Boolean.valueOf(transcodingCompleteEvent.success)), new VideoUploadService$$Lambda$21(this, videoUpload));
    }

    final /* synthetic */ VideoUpload lambda$null$7$VideoUploadService(TranscodingCompleteEvent transcodingCompleteEvent, VideoUpload videoUpload) throws Exception {
        transcodingCompleteEvent = getVideoUploadWithKey(transcodingCompleteEvent.key);
        return transcodingCompleteEvent != null ? transcodingCompleteEvent : videoUpload;
    }

    final /* synthetic */ VideoUpload lambda$null$8$VideoUploadService(VideoUpload videoUpload, VideoUpload videoUpload2, Boolean bool) throws Exception {
        if (videoUpload2 != videoUpload) {
            if (bool.booleanValue() != null) {
                onSuccessfulTranscoding(videoUpload2);
            } else {
                onFailedTranscoding(videoUpload2);
            }
        }
        return videoUpload2;
    }

    private void onSuccessfulTranscoding(VideoUpload videoUpload) {
        Timber.b("Transcoding complete for video request [%s], title [%s]", new Object[]{videoUpload.getRequestId(), videoUpload.getTitle()});
        String thumbnail = videoUpload.getThumbnail();
        if (thumbnail != null) {
            new File(thumbnail).delete();
        }
        videoUpload.delete();
        VIDEO_DELETED_BUS.onNext(videoUpload.getRequestId());
    }

    private void onFailedTranscoding(VideoUpload videoUpload) {
        Timber.b("Transcoding failed for video request [%s], title [%s]", new Object[]{videoUpload.getRequestId(), videoUpload.getTitle()});
        updateVideoUploadStateWithRequestId(videoUpload.getRequestId(), 6);
        VIDEO_STATE_BUS.onNext(new VideoState(videoUpload.getRequestId(), 6));
        showUploadFailedNotification(videoUpload);
    }

    private void updateVideoUploadStateWithRequestId(String str, int i) {
        SQLite.update(VideoUpload.class).set(new SQLOperator[]{VideoUpload_Table.status.eq(Integer.valueOf(i))}).where(new SQLOperator[]{VideoUpload_Table.requestId.is(str)}).execute();
    }

    private VideoUpload getVideoUploadWithKey(String str) {
        return (VideoUpload) SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.videoKey.eq(str)}).querySingle();
    }

    private void cancelUploadRequest(String str) {
        Timber.b("Cancel upload for request [%s]", new Object[]{str});
        if (str.equals(this.requestInProgressId)) {
            if (this.currentUploadRequest != null) {
                this.currentUploadRequest.b();
            }
            stopForeground(true);
        } else {
            Maybe.fromCallable(new VideoUploadService$$Lambda$7(this, str)).map(VideoUploadService$$Lambda$8.$instance).subscribeOn(SchedulerProvider.m23886b()).subscribe();
        }
        Future future = (Future) this.uploadFutures.get(str);
        if (future != null) {
            future.cancel(true);
        }
    }

    final /* synthetic */ VideoUpload lambda$cancelUploadRequest$10$VideoUploadService(String str) throws Exception {
        return getVideoUploadWithRequestId(str);
    }

    static final /* synthetic */ VideoUpload lambda$cancelUploadRequest$11$VideoUploadService(VideoUpload videoUpload) throws Exception {
        String thumbnail = videoUpload.getThumbnail();
        if (thumbnail != null) {
            new File(thumbnail).delete();
        }
        videoUpload.delete();
        VIDEO_DELETED_BUS.onNext(videoUpload.getRequestId());
        return videoUpload;
    }

    private boolean scheduleNextUpload() {
        VideoUpload videoUpload = (VideoUpload) SQLite.select(new IProperty[0]).from(VideoUpload.class).where(new SQLOperator[]{VideoUpload_Table.status.eq(Integer.valueOf(0))}).querySingle();
        if (videoUpload != null) {
            updateVideoUploadStateWithRequestId(videoUpload.getRequestId(), 1);
            VIDEO_STATE_BUS.onNext(new VideoState(videoUpload.getRequestId(), 1));
            Timber.b("Scheduling upload for request [%s]", new Object[]{videoUpload.getRequestId()});
            this.uploadFutures.put(videoUpload.getRequestId(), this.backgroundExecutor.submit(new UploadFileTask(videoUpload.getRequestId())));
            return true;
        }
        Timber.b("No videos ready for upload", new Object[0]);
        return false;
    }

    private void resumeInterruptedUploads() {
        Observable a = RxJavaPlugins.m26742a(new ObservableAutoConnect(getInterruptedUploads().publish(), Functions.m26556b()));
        Observable.merge(a.filter(VideoUploadService$$Lambda$9.$instance).map(VideoUploadService$$Lambda$10.$instance), a.filter(VideoUploadService$$Lambda$11.$instance).map(new VideoUploadService$$Lambda$12(this))).filter(VideoUploadService$$Lambda$13.$instance).firstElement().subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new VideoUploadService$$Lambda$14(this), VideoUploadService$$Lambda$15.$instance, new VideoUploadService$$Lambda$16(this));
    }

    static final /* synthetic */ boolean lambda$resumeInterruptedUploads$12$VideoUploadService(VideoUpload videoUpload) throws Exception {
        if (videoUpload.getStatus() != 2) {
            if (videoUpload.getStatus() != 1) {
                return null;
            }
        }
        return true;
    }

    static final /* synthetic */ VideoUpload lambda$resumeInterruptedUploads$13$VideoUploadService(VideoUpload videoUpload) throws Exception {
        videoUpload.setStatus(0);
        videoUpload.update();
        return videoUpload;
    }

    static final /* synthetic */ boolean lambda$resumeInterruptedUploads$14$VideoUploadService(VideoUpload videoUpload) throws Exception {
        if (videoUpload.getStatus() != 3) {
            if (videoUpload.getStatus() != 4) {
                return null;
            }
        }
        return true;
    }

    final /* synthetic */ VideoUpload lambda$resumeInterruptedUploads$15$VideoUploadService(VideoUpload videoUpload) throws Exception {
        if (videoUpload.hasPostData()) {
            videoUpload.setStatus(3);
            videoUpload.update();
            schedulePublishPostTask(videoUpload);
        }
        return videoUpload;
    }

    static final /* synthetic */ boolean lambda$resumeInterruptedUploads$16$VideoUploadService(VideoUpload videoUpload) throws Exception {
        return videoUpload.hasPostData() == null ? true : null;
    }

    final /* synthetic */ void lambda$resumeInterruptedUploads$17$VideoUploadService(VideoUpload videoUpload) throws Exception {
        Timber.b("Found an incomplete upload, redirecting user to submit screen", new Object[0]);
        videoUpload = MainActivity.m42701a(this, videoUpload.getRequestId());
        videoUpload.addFlags(268435456);
        startActivity(videoUpload);
    }

    private Observable<VideoUpload> getInterruptedUploads() {
        return Observable.fromCallable(VideoUploadService$$Lambda$17.$instance).flatMapIterable(VideoUploadService$$Lambda$18.$instance).filter(VideoUploadService$$Lambda$19.$instance);
    }

    static final /* synthetic */ boolean lambda$getInterruptedUploads$21$VideoUploadService(VideoUpload videoUpload) throws Exception {
        if (new File(videoUpload.getFilePath()).exists()) {
            return true;
        }
        Timber.d("Discarding orphaned database entry [%s] for post [%s]", new Object[]{videoUpload.getFilePath(), videoUpload.getTitle()});
        videoUpload.delete();
        return false;
    }

    private int buildAndShowProgressNotification(String str, String str2) {
        int incrementAndGet = notificationIndex.incrementAndGet();
        Timber.b("Posting progress notification for notification [%d]", new Object[]{Integer.valueOf(incrementAndGet)});
        showProgressNotification(incrementAndGet, getStartSubmitActivityPendingIntent(), new Action.Builder(C1761R.drawable.ic_icon_close, getString(C1761R.string.action_cancel), getCancelUploadPendingIntent(str, incrementAndGet)).a(), str2);
        return incrementAndGet;
    }

    private void showProgressNotification(int i, PendingIntent pendingIntent, Action action, String str) {
        str = new Builder(this, "notifications").a(C1761R.drawable.nav_snoo).a(getString(C1761R.string.uploading_video_file, new Object[]{str}));
        str.z = "progress";
        str.k = 0;
        str.a(2, true);
        str.e = pendingIntent;
        this.progressBuilder = str.a(action);
        this.progressBuilder.a(0, 100, true);
        startForeground(i, this.progressBuilder.a());
    }

    private void updateProgressNotification(int i, float f) {
        Timber.b("Updating progress notification for notification [%d] to [%f]", new Object[]{Integer.valueOf(i), Float.valueOf(f)});
        if (this.progressBuilder != null) {
            this.progressBuilder.a(100, (int) (100.0f * f), false);
            this.notificationManager.notify(i, this.progressBuilder.a());
        }
    }

    private void showUploadFailedNotification(VideoUpload videoUpload) {
        int incrementAndGet = notificationIndex.incrementAndGet();
        PendingIntent startSubmitActivityPendingIntent = getStartSubmitActivityPendingIntent();
        Action cancelAction = getCancelAction(videoUpload, incrementAndGet);
        Action retryAction = getRetryAction(videoUpload, incrementAndGet);
        Builder b = new Builder(this, "notifications").a(C1761R.drawable.nav_snoo).a(getString(C1761R.string.video_upload_failed)).b(getString(C1761R.string.video_upload_failed_details, new Object[]{getNameFromPath(videoUpload.getFilePath())}));
        b.z = "err";
        b.k = 0;
        Builder a = b.a(true).a(retryAction).a(cancelAction);
        a.e = startSubmitActivityPendingIntent;
        this.notificationMap.put(videoUpload.getRequestId(), Integer.valueOf(incrementAndGet));
        this.notificationManager.notify(incrementAndGet, a.a());
    }

    private Action getCancelAction(VideoUpload videoUpload, int i) {
        return new Action.Builder(C1761R.drawable.ic_icon_close, getString(C1761R.string.action_cancel), getCancelUploadPendingIntent(videoUpload.getRequestId(), i)).a();
    }

    private Action getRetryAction(VideoUpload videoUpload, int i) {
        return new Action.Builder(C1761R.drawable.ic_icon_undo, getString(C1761R.string.action_retry), getRetryUploadPendingIntent(videoUpload, i)).a();
    }

    private PendingIntent getStartSubmitActivityPendingIntent() {
        Intent a = MainActivity.m42700a((Context) this);
        a.addFlags(268435456);
        return PendingIntent.getActivity(this, 0, a, 268435456);
    }

    private PendingIntent getCancelUploadPendingIntent(String str, int i) {
        Intent intent = new Intent(this, VideoUploadService.class);
        intent.setAction(CANCEL_UPLOAD_ACTION);
        intent.putExtra(REQUEST_ID_TAG, str);
        intent.putExtra(NOTIFICATION_ID_TAG, i);
        return PendingIntent.getService(this, 1, intent, 268435456);
    }

    private PendingIntent getRetryUploadPendingIntent(VideoUpload videoUpload, int i) {
        Intent intent = new Intent(this, VideoUploadService.class);
        intent.setAction(videoUpload.getStatus() == 6 ? RETRY_UPLOAD_ACTION : RETRY_PUBLISH_POST_ACTION);
        intent.putExtra(NOTIFICATION_ID_TAG, i);
        intent.putExtra(REQUEST_ID_TAG, videoUpload.getRequestId());
        return PendingIntent.getService(this, videoUpload.getStatus() == 6 ? 2 : 3, intent, 268435456);
    }

    private String getNameFromPath(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) ? str : str.substring(lastIndexOf + 1);
    }

    private void cancelShutdownRequest() {
        this.handler.removeCallbacks(this.shutdownRunnable);
    }

    private void scheduleServiceShutdown() {
        cancelShutdownRequest();
        this.handler.postDelayed(this.shutdownRunnable, SERVICE_SHUTDOWN_DELAY_MILLIS);
    }

    private void updateVideoUploadWithUploadResult(VideoUpload videoUpload, String str) {
        SQLite.update(VideoUpload.class).set(new SQLOperator[]{VideoUpload_Table.uploadDuration.eq(Long.valueOf(System.currentTimeMillis() - this.uploadStartMillis)), VideoUpload_Table.uploadError.eq(str), VideoUpload_Table.videoWidth.eq(Integer.valueOf(this.videoWidth)), VideoUpload_Table.videoHeight.eq(Integer.valueOf(this.videoHeight))}).where(new SQLOperator[]{VideoUpload_Table.id.is(Integer.valueOf(videoUpload.getId()))}).execute();
    }

    private void sendUploadAnalytics(VideoUpload videoUpload) {
        try {
            Session session = SessionManager.b().c;
            Subreddit subreddit = getSubreddit(session, videoUpload.getSubreddit());
            if (subreddit != null) {
                com.reddit.frontpage.commons.analytics.events.v2.BaseEvent videoUploadEvent = new VideoUploadEvent();
                VideoUploadPayload videoUploadPayload = (VideoUploadPayload) videoUploadEvent.payload;
                videoUploadPayload.base_url = "/r/videos/submit";
                videoUploadPayload.is_retry = false;
                videoUploadPayload.original_duration = videoUpload.getOriginalDuration();
                if (!TextUtils.isEmpty(videoUpload.getUploadError())) {
                    videoUploadPayload.process_notes = videoUpload.getUploadError();
                }
                videoUploadPayload.sr_id = Util.m24024f(subreddit.getId());
                videoUploadPayload.sr_fullname = subreddit.getKindWithId();
                videoUploadPayload.sr_name = subreddit.getDisplayName();
                videoUploadPayload.trimmed = videoUpload.getOriginalDuration() != videoUpload.getDuration();
                videoUploadPayload.upload_duration = videoUpload.getUploadDuration();
                Object obj = null;
                if (!session.isAnonymous()) {
                    videoUploadPayload.user_name = SessionManager.b().c.getUsername();
                    Account account = (Account) AccountStorage.b.a(videoUploadPayload.user_name);
                    if (account != null) {
                        obj = account.getId();
                    }
                }
                if (!TextUtils.isEmpty(obj)) {
                    videoUploadPayload.user_id = new BigInteger(obj, 36).longValue();
                }
                videoUploadPayload.successful = TextUtils.isEmpty(videoUpload.getUploadError());
                videoUploadPayload.video_duration = videoUpload.getDuration();
                videoUploadPayload.video_height = videoUpload.getVideoHeight();
                videoUploadPayload.video_size = (int) new File(videoUpload.getFilePath()).length();
                videoUploadPayload.video_source = videoUpload.getSource();
                videoUploadPayload.video_to_gif = videoUpload.isGif();
                videoUploadPayload.video_url = videoUpload.getUploadUrl();
                videoUploadPayload.video_width = videoUpload.getVideoWidth();
                Timber.a("Video Upload Analytics %s", new Object[]{videoUploadPayload});
                AppAnalytics.m21854a(videoUploadEvent);
            }
        } catch (VideoUpload videoUpload2) {
            Timber.c(videoUpload2, "Failed to send video upload analytics", new Object[0]);
        }
    }

    private Subreddit getSubreddit(Session session, String str) {
        SubredditUtil.m23912a(str);
        return (Subreddit) FrontpageApplication.m28875k().mo4635w().m22493a(str).blockingGet();
    }
}
