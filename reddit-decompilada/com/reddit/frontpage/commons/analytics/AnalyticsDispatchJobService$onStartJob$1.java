package com.reddit.frontpage.commons.analytics;

import com.reddit.data.events.models.EventsResult;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lcom/reddit/data/events/models/EventsResult;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: AnalyticsDispatchJobService.kt */
final class AnalyticsDispatchJobService$onStartJob$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ AnalyticsDispatchJobService f27432a;

    AnalyticsDispatchJobService$onStartJob$1(AnalyticsDispatchJobService analyticsDispatchJobService) {
        this.f27432a = analyticsDispatchJobService;
    }

    public final /* synthetic */ Object apply(Object obj) {
        EventsResult eventsResult = (EventsResult) obj;
        Intrinsics.m26847b(eventsResult, "<name for destructuring parameter 0>");
        final List component1 = eventsResult.component1();
        List component2 = eventsResult.component2();
        if (component2.isEmpty()) {
            Timber.a("Analytics: no events to send", new Object[0]);
            return Single.just(Boolean.valueOf(true));
        }
        byte[] a = AnalyticsDispatchJobService.m28903b(component2);
        Timber.a("Analytics: sending batch to server %s", new Object[]{component2});
        return this.f27432a.m28899a(a).flatMap(new Function<T, SingleSource<? extends R>>() {
            public final /* synthetic */ Object apply(Object obj) {
                Response response = (Response) obj;
                Intrinsics.m26847b(response, "response");
                if (response.b()) {
                    Timber.a("Analytics: marking events dispatched", new Object[0]);
                    obj = this.f27432a.f27440c;
                    if (obj == null) {
                        Intrinsics.m26844a("localDataSource");
                    }
                    return obj.a(component1);
                }
                obj = response.a();
                StringBuilder stringBuilder = new StringBuilder("Analytics: got failure response code ");
                stringBuilder.append(obj);
                Timber.e(stringBuilder.toString(), new Object[0]);
                return Single.just(Boolean.valueOf(false));
            }
        });
    }
}
