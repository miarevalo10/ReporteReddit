package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Platform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/TheaterModeEventBuilder;", "", "()V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "event", "action", "", "noun", "send", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TheaterModeEventBuilder.kt */
public final class TheaterModeEventBuilder {
    public static final Companion Companion = new Companion();
    final Builder builder;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/TheaterModeEventBuilder$Companion;", "", "()V", "sendEvent", "", "action", "", "noun", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: TheaterModeEventBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static void m21946a(String str, String str2) {
            Intrinsics.m26847b(str, "action");
            Intrinsics.m26847b(str2, "noun");
            TheaterModeEventBuilder theaterModeEventBuilder = new TheaterModeEventBuilder();
            Intrinsics.m26847b(str, "action");
            Intrinsics.m26847b(str2, "noun");
            theaterModeEventBuilder.builder.action(str).noun(str2);
            str = Analytics.a;
            str = theaterModeEventBuilder.builder;
            Object b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            b = b.c();
            Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
            Analytics.a(str, (AnalyticsSession) b, Platform.f29397a);
        }
    }

    public static final void m21947a(String str, String str2) {
        Companion.m21946a(str, str2);
    }

    public TheaterModeEventBuilder() {
        Object source = new Builder().source(TheaterModeEvents.SOURCE);
        Intrinsics.m26843a(source, "Event.Builder().source(TheaterModeEvents.SOURCE)");
        this.builder = source;
    }
}
