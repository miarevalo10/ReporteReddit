package com.reddit.frontpage.commons.analytics.output;

import android.os.Bundle;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Job.Builder;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import com.google.android.gms.common.GoogleApiAvailability;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.data.events.Output;
import com.reddit.data.events.datasource.local.LocalEventDataSource;
import com.reddit.data.events.models.Event;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AnalyticsDispatchJobService;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B'\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001bH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/commons/analytics/output/ThriftOutput;", "Lcom/reddit/data/events/Output;", "jobDispatcher", "Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;", "localDataSource", "Lcom/reddit/data/events/datasource/local/LocalEventDataSource;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "batchSize", "", "(Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;Lcom/reddit/data/events/datasource/local/LocalEventDataSource;Lcom/reddit/common/rx/BackgroundThread;I)V", "(I)V", "getBackgroundThread", "()Lcom/reddit/common/rx/BackgroundThread;", "setBackgroundThread", "(Lcom/reddit/common/rx/BackgroundThread;)V", "getJobDispatcher", "()Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;", "setJobDispatcher", "(Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;)V", "getLocalDataSource", "()Lcom/reddit/data/events/datasource/local/LocalEventDataSource;", "setLocalDataSource", "(Lcom/reddit/data/events/datasource/local/LocalEventDataSource;)V", "getEvents", "Lio/reactivex/Maybe;", "", "Lcom/reddit/data/events/models/Event;", "size", "scheduleThriftDispatchJob", "", "send", "newEvent", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThriftOutput.kt */
public final class ThriftOutput implements Output {
    public static final Companion f27471d = new Companion();
    @Inject
    public FirebaseJobDispatcher f27472a;
    @Inject
    public LocalEventDataSource f27473b;
    @Inject
    public BackgroundThread f27474c;
    private final int f27475e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/output/ThriftOutput$Companion;", "", "()V", "BATCH_SIZE_KEY", "", "DEFAULT_BATCH_SIZE", "", "JOB_WINDOW_END", "JOB_WINDOW_START", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ThriftOutput.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ThriftOutput(char c) {
        this();
    }

    private ThriftOutput() {
        this.f27475e = 20;
        FrontpageApplication.m28876l().mo4745a(this);
        Timber.b("Analytics: scheduling AnalyticsDispatchJobService", new Object[0]);
        if (GoogleApiAvailability.a().a(FrontpageApplication.f27402a) == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("batch_size", this.f27475e);
            FirebaseJobDispatcher firebaseJobDispatcher = this.f27472a;
            if (firebaseJobDispatcher == null) {
                Intrinsics.m26844a("jobDispatcher");
            }
            Builder a = firebaseJobDispatcher.a().a(AnalyticsDispatchJobService.class);
            com.reddit.frontpage.commons.analytics.AnalyticsDispatchJobService.Companion companion = AnalyticsDispatchJobService.f27436e;
            Job k = a.a(com.reddit.frontpage.commons.analytics.AnalyticsDispatchJobService.Companion.m21814a()).m().l().a(Trigger.a(0, 60)).j().a(RetryStrategy.a).a(new int[]{1}).a(bundle).k();
            FirebaseJobDispatcher firebaseJobDispatcher2 = this.f27472a;
            if (firebaseJobDispatcher2 == null) {
                Intrinsics.m26844a("jobDispatcher");
            }
            firebaseJobDispatcher2.b(k);
        }
    }

    public final void m28974a(Event event) {
        Intrinsics.m26847b(event, "newEvent");
        Timber.a("Analytics: saving event %s", new Object[]{event});
        LocalEventDataSource localEventDataSource = this.f27473b;
        if (localEventDataSource == null) {
            Intrinsics.m26844a("localDataSource");
        }
        event = localEventDataSource.a(event);
        BackgroundThread backgroundThread = this.f27474c;
        if (backgroundThread == null) {
            Intrinsics.m26844a("backgroundThread");
        }
        SinglesKt.m24093a(event, backgroundThread).subscribe();
    }
}
