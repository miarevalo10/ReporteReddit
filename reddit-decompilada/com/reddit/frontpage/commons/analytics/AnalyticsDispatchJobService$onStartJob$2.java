package com.reddit.frontpage.commons.analytics;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: AnalyticsDispatchJobService.kt */
final class AnalyticsDispatchJobService$onStartJob$2<T, R> implements Function<Throwable, Boolean> {
    public static final AnalyticsDispatchJobService$onStartJob$2 f27433a = new AnalyticsDispatchJobService$onStartJob$2();

    AnalyticsDispatchJobService$onStartJob$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "e");
        Timber.c(th, "Analytics: error while trying to send analytics events", new Object[0]);
        return Boolean.valueOf(false);
    }
}
