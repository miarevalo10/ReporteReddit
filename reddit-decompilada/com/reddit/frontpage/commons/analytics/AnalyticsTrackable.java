package com.reddit.frontpage.commons.analytics;

import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/AnalyticsTrackable;", "", "getAnalyticsHeartbeatParams", "Lcom/reddit/frontpage/commons/analytics/events/v2/AnalyticsHeartbeatParams;", "getAnalyticsPageType", "", "getAnalyticsScreenName", "getAnalyticsScreenviewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsTrackable.kt */
public interface AnalyticsTrackable {
    AnalyticsHeartbeatParams getAnalyticsHeartbeatParams();

    String getAnalyticsPageType();

    String getAnalyticsScreenName();

    ScreenviewEventBuilder getAnalyticsScreenviewEvent();
}
