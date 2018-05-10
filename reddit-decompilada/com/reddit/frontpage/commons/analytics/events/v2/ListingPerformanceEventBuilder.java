package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.Timer;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Platform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ListingPerformanceEventBuilder;", "", "()V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "noun", "", "source", "timerBuilder", "Lcom/reddit/data/events/models/components/Timer$Builder;", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/ListingPerformanceEventBuilder$Action;", "correlationId", "Lcom/reddit/frontpage/commons/analytics/events/v2/ListingPerformanceEventBuilder$Noun;", "send", "", "time", "elapsedTime", "", "Action", "Noun", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingPerformanceEventBuilder.kt */
public final class ListingPerformanceEventBuilder {
    private final Builder builder = new Builder();
    private String noun = "";
    private String source = "";
    private final Timer.Builder timerBuilder = new Timer.Builder();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ListingPerformanceEventBuilder$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "InitiatePageTransition", "ShowLoadingIndicator", "HideLoadingIndicator", "InitiateRequestListing", "ReceiveResponseListing", "ResponseProcessingComplete", "ListingRenderingComplete", "ListingLoadComplete", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingPerformanceEventBuilder.kt */
    public enum Action {
        ;
        
        final String value;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ListingPerformanceEventBuilder$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Listing", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingPerformanceEventBuilder.kt */
    public enum Noun {
        ;
        
        final String value;

        private Noun() {
            Intrinsics.m26847b(r3, "value");
            this.value = r3;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ListingPerformanceEventBuilder$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CommunityViewPerformance", "DetailViewPerformance", "HomePerformance", "PopularPerformance", "PostDetailPerformance", "PostImagePerformance", "PostLinkPerformance", "PostTextPerformance", "PostVideoPerformance", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingPerformanceEventBuilder.kt */
    public enum Source {
        ;
        
        public final String value;

        private Source(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    public final ListingPerformanceEventBuilder m21916a(String str) {
        Intrinsics.m26847b(str, "source");
        this.builder.source(str);
        this.source = str;
        return this;
    }

    public final ListingPerformanceEventBuilder m21914a(Action action) {
        Intrinsics.m26847b(action, "action");
        this.builder.action(action.value);
        return this;
    }

    public final ListingPerformanceEventBuilder m21915a(Noun noun) {
        Intrinsics.m26847b(noun, "noun");
        this.builder.noun(noun.value);
        this.noun = noun.value;
        return this;
    }

    public final ListingPerformanceEventBuilder m21918b(String str) {
        Intrinsics.m26847b(str, "correlationId");
        this.builder.correlation_id(str);
        return this;
    }

    public final ListingPerformanceEventBuilder m21913a(long j) {
        this.timerBuilder.millis(Long.valueOf(j));
        return this;
    }

    public final void m21917a() {
        Timer.Builder builder = this.timerBuilder;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.source);
        stringBuilder.append('_');
        stringBuilder.append(this.noun);
        builder.type(stringBuilder.toString());
        this.builder.timer(this.timerBuilder.build());
        Analytics analytics = Analytics.a;
        Builder builder2 = this.builder;
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b = b.c();
        Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
        Analytics.a(builder2, (AnalyticsSession) b, Platform.f29397a);
    }
}
