package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.frontpage.commons.analytics.builders.BaseEventBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder;", "Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "()V", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Action;", "noun", "Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Noun;", "prepareAnalytics", "", "source", "Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Source;", "Action", "Noun", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NotificationSettingsEventBuilder.kt */
public final class NotificationSettingsEventBuilder extends BaseEventBuilder<NotificationSettingsEventBuilder> {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ENABLED", "DISABLED", "SHOW_ON_LOCK_SCREEN", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: NotificationSettingsEventBuilder.kt */
    public enum Action {
        ;
        
        public final String value;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NOTIFICATIONS", "SOUNDS", "BADGE", "OVERRIDE_DND", "HISTORY", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: NotificationSettingsEventBuilder.kt */
    public enum Noun {
        ;
        
        public final String value;

        private Noun(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NOTIFICATIONS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: NotificationSettingsEventBuilder.kt */
    public enum Source {
        ;
        
        public final String value;

        private Source() {
            Intrinsics.m26847b(r3, "value");
            this.value = r3;
        }
    }

    public final void mo4573b() {
    }
}
