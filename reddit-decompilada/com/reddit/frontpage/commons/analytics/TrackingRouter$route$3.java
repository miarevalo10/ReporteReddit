package com.reddit.frontpage.commons.analytics;

import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: TrackingRouter.kt */
final class TrackingRouter$route$3 implements Runnable {
    final /* synthetic */ String f20013a;

    TrackingRouter$route$3(String str) {
        this.f20013a = str;
    }

    public final void run() {
        ListingPerformanceTracker.m21963b(this.f20013a);
    }
}
