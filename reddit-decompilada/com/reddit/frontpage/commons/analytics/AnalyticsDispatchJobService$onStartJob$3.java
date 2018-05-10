package com.reddit.frontpage.commons.analytics;

import com.firebase.jobdispatcher.JobParameters;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: AnalyticsDispatchJobService.kt */
final class AnalyticsDispatchJobService$onStartJob$3<T> implements Consumer<Boolean> {
    final /* synthetic */ AnalyticsDispatchJobService f27434a;
    final /* synthetic */ JobParameters f27435b;

    AnalyticsDispatchJobService$onStartJob$3(AnalyticsDispatchJobService analyticsDispatchJobService, JobParameters jobParameters) {
        this.f27434a = analyticsDispatchJobService;
        this.f27435b = jobParameters;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.a("Analytics: job finished, result (%s)", new Object[]{(Boolean) obj});
        this.f27434a.a(this.f27435b, r5.booleanValue() ^ 1);
    }
}
