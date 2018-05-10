package com.reddit.frontpage.commons.analytics.listener;

import android.content.Context;
import android.os.Build.VERSION;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.NotificationSettings;
import com.reddit.frontpage.commons.analytics.events.v2.NotificationSettingsEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.NotificationSettingsEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.NotificationSettingsEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.NotificationSettingsEventBuilder.Source;
import com.reddit.frontpage.util.NotificationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\u001f\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/listener/NotificationSettingsListener;", "", "()V", "checkNotificationSettings", "", "context", "Landroid/content/Context;", "currentSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/NotificationSettings;", "currentSettingsFromChannel", "loadNotificationSettings", "sendAnalytics", "newSettings", "lastSettings", "sendEnabledDisabled", "prop", "", "noun", "Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Noun;", "(Ljava/lang/Boolean;Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Noun;)V", "sendEvent", "source", "Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Source;", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/NotificationSettingsEventBuilder$Action;", "storeNotificationSettings", "settings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NotificationSettingsListener.kt */
public final class NotificationSettingsListener {
    public static final NotificationSettingsListener f20088a = new NotificationSettingsListener();

    private NotificationSettingsListener() {
    }

    private static void m21949a(Boolean bool, Noun noun) {
        if (bool != null) {
            Source source = Source.NOTIFICATIONS;
            bool = bool.booleanValue() != null ? Action.ENABLED : Action.DISABLED;
            NotificationSettingsEventBuilder notificationSettingsEventBuilder = new NotificationSettingsEventBuilder();
            Intrinsics.m26847b(source, "source");
            notificationSettingsEventBuilder = notificationSettingsEventBuilder;
            notificationSettingsEventBuilder.m21888a(source.value);
            Intrinsics.m26847b(bool, "action");
            notificationSettingsEventBuilder.m21892b(bool.value);
            Intrinsics.m26847b(noun, "noun");
            notificationSettingsEventBuilder.m21895c(noun.value);
            notificationSettingsEventBuilder.m21891a();
        }
    }

    public static final void m21948a(Context context) {
        Object c;
        Object notificationSettings;
        Intrinsics.m26847b(context, "context");
        Object a = InternalSettings.a();
        Intrinsics.m26843a(a, "InternalSettings.getInstance()");
        a = a.r();
        if (VERSION.SDK_INT >= 26) {
            c = NotificationUtil.m23858c(context);
            boolean z = false;
            if (NotificationUtil.m23855a(context) != null) {
                Intrinsics.m26843a(c, "channel");
                if (c.getImportance() != null) {
                    context = 1;
                    Intrinsics.m26843a(c, "channel");
                    if (c.getImportance() >= 3 && c.getSound() != null) {
                        z = true;
                    }
                    notificationSettings = new NotificationSettings(context, Boolean.valueOf(z), Boolean.valueOf(c.canShowBadge()), Boolean.valueOf(c.canBypassDnd()));
                }
            }
            context = null;
            Intrinsics.m26843a(c, "channel");
            z = true;
            notificationSettings = new NotificationSettings(context, Boolean.valueOf(z), Boolean.valueOf(c.canShowBadge()), Boolean.valueOf(c.canBypassDnd()));
        } else {
            notificationSettings = new NotificationSettings(NotificationUtil.m23855a(context));
        }
        if ((Intrinsics.m26845a(a, notificationSettings) ^ 1) != null) {
            if (a == null || a.a != notificationSettings.a) {
                m21949a(Boolean.valueOf(notificationSettings.a), Noun.NOTIFICATIONS);
            }
            Object obj = null;
            if (a != null) {
                c = a.b;
            } else {
                c = null;
            }
            if ((Intrinsics.m26845a(c, notificationSettings.b) ^ 1) != 0) {
                m21949a(notificationSettings.b, Noun.SOUNDS);
            }
            if (a != null) {
                c = a.c;
            } else {
                c = null;
            }
            if ((Intrinsics.m26845a(c, notificationSettings.c) ^ 1) != 0) {
                m21949a(notificationSettings.c, Noun.BADGE);
            }
            if (a != null) {
                obj = a.d;
            }
            if ((Intrinsics.m26845a(obj, notificationSettings.d) ^ 1) != null) {
                m21949a(notificationSettings.d, Noun.OVERRIDE_DND);
            }
            obj = InternalSettings.a();
            Intrinsics.m26843a(obj, "InternalSettings.getInstance()");
            obj.a(notificationSettings);
        }
    }
}
