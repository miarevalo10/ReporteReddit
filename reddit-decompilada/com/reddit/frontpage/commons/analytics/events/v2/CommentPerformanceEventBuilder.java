package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.Timer;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Platform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder;", "", "()V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "noun", "", "source", "timerBuilder", "Lcom/reddit/data/events/models/components/Timer$Builder;", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Action;", "correlationId", "Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Noun;", "send", "", "Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Source;", "time", "elapsedTime", "", "Action", "Noun", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommentPerformanceEventBuilder.kt */
public final class CommentPerformanceEventBuilder {
    private final Builder builder = new Builder();
    private String noun = "";
    private String source = "";
    private final Timer.Builder timerBuilder = new Timer.Builder();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ShowLoadingIndicator", "InitiateTruncatedRequest", "ReceiveTruncatedResponse", "TruncatedResponseProcessingComplete", "TruncatedRenderingComplete", "HideLoadingIndicator", "InitiateFullRequest", "ReceiveFullResponse", "FullResponseProcessingComplete", "FullRenderingComplete", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommentPerformanceEventBuilder.kt */
    public enum Action {
        ;
        
        final String value;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Comments", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommentPerformanceEventBuilder.kt */
    public enum Noun {
        ;
        
        final String value;

        private Noun() {
            Intrinsics.m26847b(r3, "value");
            this.value = r3;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/CommentPerformanceEventBuilder$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PostDetail", "DetailHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommentPerformanceEventBuilder.kt */
    public enum Source {
        ;
        
        final String value;

        private Source(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    public final CommentPerformanceEventBuilder m21910a(Source source) {
        Intrinsics.m26847b(source, "source");
        this.builder.source(source.value);
        this.source = source.value;
        return this;
    }

    public final CommentPerformanceEventBuilder m21908a(Action action) {
        Intrinsics.m26847b(action, "action");
        this.builder.action(action.value);
        return this;
    }

    public final CommentPerformanceEventBuilder m21909a(Noun noun) {
        Intrinsics.m26847b(noun, "noun");
        this.builder.noun(noun.value);
        this.noun = noun.value;
        return this;
    }

    public final CommentPerformanceEventBuilder m21911a(String str) {
        Intrinsics.m26847b(str, "correlationId");
        this.builder.correlation_id(str);
        return this;
    }

    public final CommentPerformanceEventBuilder m21907a(long j) {
        this.timerBuilder.millis(Long.valueOf(j));
        return this;
    }

    public final void m21912a() {
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
