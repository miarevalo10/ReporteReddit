package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.data.events.models.Event.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J \u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/HeartbeatEventBuilder;", "", "()V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "pageType", "", "profile", "id", "name", "hasSubreddit", "", "screenInFocus", "inFocus", "send", "", "subreddit", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HeartbeatEventBuilder.kt */
public final class HeartbeatEventBuilder {
    private static final String ACTION = "heartbeat";
    public static final Companion Companion = new Companion();
    private static final String NOUN = "timing";
    private static final String SOURCE = "global";
    public final Builder builder;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/HeartbeatEventBuilder$Companion;", "", "()V", "ACTION", "", "NOUN", "SOURCE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: HeartbeatEventBuilder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public HeartbeatEventBuilder() {
        Object noun = new Builder().source(SOURCE).action(ACTION).noun(NOUN);
        Intrinsics.m26843a(noun, "Event.Builder()\n      .s…ACTION)\n      .noun(NOUN)");
        this.builder = noun;
    }
}
