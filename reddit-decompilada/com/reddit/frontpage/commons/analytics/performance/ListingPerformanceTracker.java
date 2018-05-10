package com.reddit.frontpage.commons.analytics.performance;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Noun;
import com.reddit.frontpage.util.TimingUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\b\u001a\u00020\tH\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0003J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/performance/ListingPerformanceTracker;", "", "()V", "screenMap", "", "", "initTracker", "screenName", "performanceAnalyticsIsActive", "", "screenNameToSource", "startTracking", "", "correlationId", "source", "trackFetched", "trackLoadComplete", "trackResponseProcessingComplete", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingPerformanceTracker.kt */
public final class ListingPerformanceTracker {
    public static final ListingPerformanceTracker f20093a = new ListingPerformanceTracker();
    private static final Map<String, String> f20094b = new LinkedHashMap();

    private ListingPerformanceTracker() {
    }

    private static final boolean m21962a() {
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a = a.t();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance().appConfig");
        return a.l();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String m21961a(java.lang.String r6) {
        /*
        r0 = m21962a();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        if (r6 != 0) goto L_0x000c;
    L_0x000a:
        goto L_0x007d;
    L_0x000c:
        r0 = r6.hashCode();
        switch(r0) {
            case -2050005549: goto L_0x0070;
            case -393940263: goto L_0x0063;
            case 3208415: goto L_0x0056;
            case 243697872: goto L_0x0049;
            case 841698619: goto L_0x003c;
            case 1952361724: goto L_0x002f;
            case 2002727993: goto L_0x0022;
            case 2002962796: goto L_0x0015;
            default: goto L_0x0013;
        };
    L_0x0013:
        goto L_0x007d;
    L_0x0015:
        r0 = "post_text";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x001d:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.PostTextPerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x0022:
        r0 = "post_link";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x002a:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.PostLinkPerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x002f:
        r0 = "post_image";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x0037:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.PostImagePerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x003c:
        r0 = "community_view";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x0044:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.CommunityViewPerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x0049:
        r0 = "post_detail";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x0051:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.PostDetailPerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x0056:
        r0 = "home";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x005e:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.HomePerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x0063:
        r0 = "popular";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x006b:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.PopularPerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x0070:
        r0 = "detail_view";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x007d;
    L_0x0078:
        r6 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Source.DetailViewPerformance;
        r6 = r6.value;
        goto L_0x007e;
    L_0x007d:
        r6 = r1;
    L_0x007e:
        r0 = 0;
        if (r6 != 0) goto L_0x0089;
    L_0x0081:
        r6 = "Error: initTracker(). Source is null";
        r0 = new java.lang.Object[r0];
        timber.log.Timber.b(r6, r0);
        return r1;
    L_0x0089:
        r1 = java.util.UUID.randomUUID();
        r1 = r1.toString();
        r2 = "correlationId";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r2);
        r2 = m21962a();
        if (r2 == 0) goto L_0x00e9;
    L_0x009c:
        com.reddit.frontpage.util.TimingUtil.m23939b(r1);
        r2 = com.reddit.frontpage.util.TimingUtil.m23940c(r1);
        r4 = -1;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x00c5;
    L_0x00a9:
        r2 = new java.lang.StringBuilder;
        r3 = "Error: startTracking(). Time missing for correlationId: ";
        r2.<init>(r3);
        r2.append(r1);
        r3 = ", source: ";
        r2.append(r3);
        r2.append(r6);
        r6 = r2.toString();
        r0 = new java.lang.Object[r0];
        timber.log.Timber.b(r6, r0);
        goto L_0x00e9;
    L_0x00c5:
        r0 = f20094b;
        r0.put(r1, r6);
        r0 = com.reddit.frontpage.commons.analytics.AppAnalytics.m21883t();
        r6 = r0.m21916a(r6);
        r0 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Action.InitiateRequestListing;
        r6 = r6.m21914a(r0);
        r0 = com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder.Noun.Listing;
        r6 = r6.m21915a(r0);
        r6 = r6.m21918b(r1);
        r6 = r6.m21913a(r2);
        r6.m21917a();
    L_0x00e9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker.a(java.lang.String):java.lang.String");
    }

    public static final void m21963b(String str) {
        if (m21962a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                if (c == -1) {
                    String str2 = (String) f20094b.get(str);
                    if (str2 == null) {
                        str2 = "unknown_source";
                    }
                    StringBuilder stringBuilder = new StringBuilder("Error: trackFetched(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    stringBuilder.append(", source: ");
                    stringBuilder.append(str2);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                String str3 = (String) f20094b.get(str);
                if (str3 == null) {
                    StringBuilder stringBuilder2 = new StringBuilder("Error: trackFetched(). source is unknown: ");
                    stringBuilder2.append(str);
                    Timber.b(stringBuilder2.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21883t().m21916a(str3).m21914a(Action.ReceiveResponseListing).m21915a(Noun.Listing).m21918b(str).m21913a(c).m21917a();
            }
        }
    }

    public static final void m21964c(String str) {
        if (m21962a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                if (c == -1) {
                    String str2 = (String) f20094b.get(str);
                    if (str2 == null) {
                        str2 = "unknown_source";
                    }
                    StringBuilder stringBuilder = new StringBuilder("Error: trackResponseProcessingComplete(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    stringBuilder.append(", source: ");
                    stringBuilder.append(str2);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                String str3 = (String) f20094b.get(str);
                if (str3 == null) {
                    StringBuilder stringBuilder2 = new StringBuilder("Error: trackResponseProcessingComplete(). source is unknown: ");
                    stringBuilder2.append(str);
                    Timber.b(stringBuilder2.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21883t().m21916a(str3).m21914a(Action.ResponseProcessingComplete).m21915a(Noun.Listing).m21918b(str).m21913a(c).m21917a();
            }
        }
    }

    public static final void m21965d(String str) {
        if (m21962a()) {
            if (str != null) {
                TimingUtil.m23941d(str);
                f20094b.remove(str);
            }
        }
    }
}
