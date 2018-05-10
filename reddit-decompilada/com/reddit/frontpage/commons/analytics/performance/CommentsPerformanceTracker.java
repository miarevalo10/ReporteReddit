package com.reddit.frontpage.commons.analytics.performance;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder.Source;
import com.reddit.frontpage.util.TimingUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\t\u001a\u00020\nH\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0006H\u0003J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/performance/CommentsPerformanceTracker;", "", "()V", "sourceMap", "", "", "Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Source;", "initTracker", "source", "performanceAnalyticsIsActive", "", "trackCommentsLoadComplete", "", "correlationId", "trackFullCommentsResponseProcessingComplete", "trackFullCommentsResponseReceived", "trackInitiateFullCommentsRequest", "trackInitiateTruncatedCommentsRequest", "trackTruncatedCommentsResponseProcessingComplete", "trackTruncatedCommentsResponseReceived", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommentsPerformanceTracker.kt */
public final class CommentsPerformanceTracker {
    public static final CommentsPerformanceTracker f20091a = new CommentsPerformanceTracker();
    private static final Map<String, Source> f20092b = new LinkedHashMap();

    private CommentsPerformanceTracker() {
    }

    private static final boolean m21955a() {
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a = a.t();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance().appConfig");
        return a.k();
    }

    public static final String m21953a(Source source) {
        if (!m21955a() || source == null) {
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.m26843a((Object) uuid, "correlationId");
        if (m21955a()) {
            TimingUtil.m23939b(uuid);
            long c = TimingUtil.m23940c(uuid);
            if (c == -1) {
                source = new StringBuilder("Error: trackInitiateTruncatedCommentsRequest(). Time missing for correlationId: ");
                source.append(uuid);
                Timber.b(source.toString(), new Object[0]);
            } else {
                f20092b.put(uuid, source);
                AppAnalytics.m21882s().m21910a(source).m21908a(Action.InitiateTruncatedRequest).m21909a(Noun.Comments).m21911a(uuid).m21907a(c).m21912a();
            }
        }
        return uuid;
    }

    public static final void m21954a(String str) {
        if (m21955a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                StringBuilder stringBuilder;
                if (c == -1) {
                    stringBuilder = new StringBuilder("Error: trackTruncatedCommentsResponseReceived(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                Source source = (Source) f20092b.get(str);
                if (source == null) {
                    stringBuilder = new StringBuilder("Error: trackTruncatedCommentsResponseReceived(). source is unknown: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21882s().m21910a(source).m21908a(Action.ReceiveTruncatedResponse).m21909a(Noun.Comments).m21911a(str).m21907a(c).m21912a();
            }
        }
    }

    public static final void m21956b(String str) {
        if (m21955a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                StringBuilder stringBuilder;
                if (c == -1) {
                    stringBuilder = new StringBuilder("Error: trackTruncatedCommentsResponseProcessingComplete(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                Source source = (Source) f20092b.get(str);
                if (source == null) {
                    stringBuilder = new StringBuilder("Error: trackTruncatedCommentsResponseProcessingComplete(). source is unknown: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21882s().m21910a(source).m21908a(Action.TruncatedResponseProcessingComplete).m21909a(Noun.Comments).m21911a(str).m21907a(c).m21912a();
            }
        }
    }

    public static final void m21957c(String str) {
        if (m21955a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                StringBuilder stringBuilder;
                if (c == -1) {
                    stringBuilder = new StringBuilder("Error: trackInitiateFullCommentsRequest(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                Source source = (Source) f20092b.get(str);
                if (source == null) {
                    stringBuilder = new StringBuilder("Error: trackInitiateFullCommentsRequest(). source is unknown: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21882s().m21910a(source).m21908a(Action.InitiateFullRequest).m21909a(Noun.Comments).m21911a(str).m21907a(c).m21912a();
            }
        }
    }

    public static final void m21958d(String str) {
        if (m21955a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                StringBuilder stringBuilder;
                if (c == -1) {
                    stringBuilder = new StringBuilder("Error: trackFullCommentsResponseReceived(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                Source source = (Source) f20092b.get(str);
                if (source == null) {
                    stringBuilder = new StringBuilder("Error: trackFullCommentsResponseReceived(). source is unknown: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21882s().m21910a(source).m21908a(Action.ReceiveFullResponse).m21909a(Noun.Comments).m21911a(str).m21907a(c).m21912a();
            }
        }
    }

    public static final void m21959e(String str) {
        if (m21955a()) {
            if (str != null) {
                long c = TimingUtil.m23940c(str);
                StringBuilder stringBuilder;
                if (c == -1) {
                    stringBuilder = new StringBuilder("Error: trackFullCommentsResponseProcessingComplete(). Time missing for correlationId: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                Source source = (Source) f20092b.get(str);
                if (source == null) {
                    stringBuilder = new StringBuilder("Error: trackFullCommentsResponseProcessingComplete(). source is unknown: ");
                    stringBuilder.append(str);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return;
                }
                AppAnalytics.m21882s().m21910a(source).m21908a(Action.FullResponseProcessingComplete).m21909a(Noun.Comments).m21911a(str).m21907a(c).m21912a();
            }
        }
    }

    public static final void m21960f(String str) {
        if (m21955a()) {
            if (str != null) {
                TimingUtil.m23941d(str);
                f20092b.remove(str);
            }
        }
    }
}
