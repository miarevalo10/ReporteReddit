package com.reddit.frontpage.commons.analytics;

import android.os.Bundle;
import android.util.Base64;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.microsoft.thrifty.protocol.BinaryProtocol;
import com.microsoft.thrifty.transport.BufferTransport;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.data.events.datasource.local.LocalEventDataSource;
import com.reddit.data.events.datasource.remote.RemoteEventDataSource;
import com.reddit.data.events.datasource.remote.RemoteEventDataSource.DefaultImpls;
import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.EventBatch.Builder;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.CryptoUtil;
import com.reddit.frontpage.util.kotlin.MaybesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Response;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010(\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/AnalyticsDispatchJobService;", "Lcom/firebase/jobdispatcher/JobService;", "remoteDataSource", "Lcom/reddit/data/events/datasource/remote/RemoteEventDataSource;", "localDataSource", "Lcom/reddit/data/events/datasource/local/LocalEventDataSource;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "(Lcom/reddit/data/events/datasource/remote/RemoteEventDataSource;Lcom/reddit/data/events/datasource/local/LocalEventDataSource;Lcom/reddit/common/rx/BackgroundThread;)V", "()V", "getBackgroundThread", "()Lcom/reddit/common/rx/BackgroundThread;", "setBackgroundThread", "(Lcom/reddit/common/rx/BackgroundThread;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "getLocalDataSource", "()Lcom/reddit/data/events/datasource/local/LocalEventDataSource;", "setLocalDataSource", "(Lcom/reddit/data/events/datasource/local/LocalEventDataSource;)V", "getRemoteDataSource", "()Lcom/reddit/data/events/datasource/remote/RemoteEventDataSource;", "setRemoteDataSource", "(Lcom/reddit/data/events/datasource/remote/RemoteEventDataSource;)V", "buildSignature", "", "computedMac", "dispatch", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "content", "", "onCreate", "", "onStartJob", "", "job", "Lcom/firebase/jobdispatcher/JobParameters;", "onStopJob", "serializeEventBatch", "events", "", "Lcom/reddit/data/events/models/Event;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsDispatchJobService.kt */
public final class AnalyticsDispatchJobService extends JobService {
    public static final Companion f27436e = new Companion();
    private static final String f27437g = "AnalyticsDispatchJobService";
    private static final String f27438h = "S31lkhGaiHF7h4NgNROreE5/1GwY16/GbYLXF7/YTGU=";
    @Inject
    public BackgroundThread f27439b;
    @Inject
    public LocalEventDataSource f27440c;
    @Inject
    public RemoteEventDataSource f27441d;
    private Disposable f27442f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/AnalyticsDispatchJobService$Companion;", "", "()V", "APP_KEY", "", "DEBUG_SECRET", "RELEASE_SECRET", "SECRET", "getSECRET", "()Ljava/lang/String;", "TAG", "getTAG", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AnalyticsDispatchJobService.kt */
    public static final class Companion {
        private Companion() {
        }

        public static String m21814a() {
            return AnalyticsDispatchJobService.f27437g;
        }
    }

    public final boolean m28904a(JobParameters jobParameters) {
        Intrinsics.m26847b(jobParameters, "job");
        Timber.a("Analytics: job started", new Object[0]);
        Bundle b = jobParameters.b();
        int i = b != null ? b.getInt("batch_size") : 20;
        LocalEventDataSource localEventDataSource = this.f27440c;
        if (localEventDataSource == null) {
            Intrinsics.m26844a("localDataSource");
        }
        Maybe a = localEventDataSource.a(i);
        BackgroundThread backgroundThread = this.f27439b;
        if (backgroundThread == null) {
            Intrinsics.m26844a("backgroundThread");
        }
        this.f27442f = MaybesKt.m24087a(a, backgroundThread).flatMapSingle(new AnalyticsDispatchJobService$onStartJob$1(this)).onErrorReturn(AnalyticsDispatchJobService$onStartJob$2.f27433a).subscribe((Consumer) new AnalyticsDispatchJobService$onStartJob$3(this, jobParameters));
        Timber.a("Analytics: deleting events older than 24 hours", new Object[0]);
        jobParameters = this.f27440c;
        if (jobParameters == null) {
            Intrinsics.m26844a("localDataSource");
        }
        jobParameters = jobParameters.a(System.currentTimeMillis() - 86400000);
        BackgroundThread backgroundThread2 = this.f27439b;
        if (backgroundThread2 == null) {
            Intrinsics.m26844a("backgroundThread");
        }
        SinglesKt.m24093a(jobParameters, backgroundThread2).subscribe();
        return true;
    }

    public final boolean m28905b(JobParameters jobParameters) {
        Intrinsics.m26847b(jobParameters, "job");
        Timber.a("Analytics: job stopped", new Object[0]);
        jobParameters = this.f27442f;
        if (jobParameters != null) {
            jobParameters.mo5626a();
        }
        this.f27442f = null;
        return true;
    }

    public final void onCreate() {
        super.onCreate();
        FrontpageApplication.m28876l().mo4744a(this);
    }

    private static byte[] m28903b(List<Event> list) {
        list = new Builder().events(list).build();
        Buffer buffer = new Buffer();
        try {
            list.write(new BinaryProtocol(new BufferTransport(buffer)));
            Object s = buffer.mo6789s();
            buffer.m36539t();
            Intrinsics.m26843a(s, "serializedBytes");
            return s;
        } catch (List<Event> list2) {
            throw new RuntimeException("Analytics: Failed to serialize thrift event batch", (Throwable) list2);
        }
    }

    private final Single<Response<ResponseBody>> m28899a(byte[] bArr) {
        try {
            String b = f27438h;
            Object forName = Charset.forName("UTF-8");
            Intrinsics.m26843a(forName, "Charset.forName(charsetName)");
            if (b == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object bytes = b.getBytes(forName);
            Intrinsics.m26843a(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] decode = Base64.decode(bytes, 0);
            Intrinsics.m26843a((Object) decode, "Base64.decode(SECRET.toB…UTF-8\")), Base64.DEFAULT)");
            Intrinsics.m26843a(CryptoUtil.m23679a(bArr, decode), "CryptoUtil.generateHmacD…t(content, decodedSecret)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
            Object format = String.format("key=%s, mac=%s", Arrays.copyOf(new Object[]{"RedditAppAndroid1", bytes}, 2));
            Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
            Object create = RequestBody.create(MediaType.parse("application/octet-stream"), bArr);
            Object obj = Config.b;
            Timber.a("Analytics: posting events to prod", new Object[0]);
            RemoteEventDataSource remoteEventDataSource = this.f27441d;
            if (remoteEventDataSource == null) {
                Intrinsics.m26844a("remoteDataSource");
            }
            Intrinsics.m26843a(obj, "userAgent");
            Intrinsics.m26843a(create, "requestBody");
            return DefaultImpls.postEventBatch$default(remoteEventDataSource, obj, null, format, create, 2, null);
        } catch (byte[] bArr2) {
            Object error = Single.error((Throwable) bArr2);
            Intrinsics.m26843a(error, "Single.error(e)");
            return error;
        }
    }

    public AnalyticsDispatchJobService(RemoteEventDataSource remoteEventDataSource, LocalEventDataSource localEventDataSource, BackgroundThread backgroundThread) {
        Intrinsics.m26847b(remoteEventDataSource, "remoteDataSource");
        Intrinsics.m26847b(localEventDataSource, "localDataSource");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        this();
        this.f27441d = remoteEventDataSource;
        this.f27440c = localEventDataSource;
        this.f27439b = backgroundThread;
    }

    static {
        Intrinsics.m26843a(AnalyticsDispatchJobService.class.getSimpleName(), "AnalyticsDispatchJobService::class.java.simpleName");
    }
}
