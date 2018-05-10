package com.reddit.data.events;

import android.content.Context;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.data.events.ThingUtil.ThingType;
import com.reddit.data.events.models.AnalyticsPlatform;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.App;
import com.reddit.data.events.models.components.Platform;
import com.reddit.data.events.models.components.Request;
import com.reddit.data.events.models.components.Screen;
import com.reddit.data.events.models.components.User;
import com.reddit.data.events.models.components.UserPreferences;
import com.reddit.events.R;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/reddit/data/events/Analytics;", "", "()V", "EVENT_PLATFORM_NAME", "", "PROFILE_TYPE_DEFAULT", "PROFILE_TYPE_LEGACY", "output", "Lcom/reddit/data/events/Output;", "init", "", "populateApp", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "eventType", "Lcom/reddit/data/events/Analytics$EventType;", "platform", "Lcom/reddit/data/events/models/AnalyticsPlatform;", "populateBaseFields", "populateCommonFields", "session", "Lcom/reddit/data/events/models/AnalyticsSession;", "populatePlatform", "populateRequest", "populateScreen", "populateSession", "populateUser", "populateUserPreferences", "sendCustomV2", "event", "Lcom/reddit/data/events/models/Event;", "sendV2", "eventBuilder", "EventType", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: Analytics.kt */
public final class Analytics {
    public static final Analytics f10281a = new Analytics();
    private static Output f10282b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/data/events/Analytics$EventType;", "", "(Ljava/lang/String;I)V", "NORMAL", "HEARTBEAT", "events_release"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Analytics.kt */
    public enum EventType {
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f10278a;
        public static final /* synthetic */ int[] f10279b;
        public static final /* synthetic */ int[] f10280c;

        static {
            int[] iArr = new int[EventType.values().length];
            f10278a = iArr;
            iArr[EventType.f10275a.ordinal()] = 1;
            iArr = new int[EventType.values().length];
            f10279b = iArr;
            iArr[EventType.f10275a.ordinal()] = 1;
            iArr = new int[EventType.values().length];
            f10280c = iArr;
            iArr[EventType.f10275a.ordinal()] = 1;
        }
    }

    private Analytics() {
    }

    public static final void m8730a(Output output) {
        Intrinsics.b(output, "output");
        f10282b = output;
    }

    public static void m8735a(Event event) {
        Intrinsics.b(event, "event");
        AnalyticsValidator.m8742a(event);
        Output output = f10282b;
        if (output == null) {
            Intrinsics.a("output");
        }
        output.m8743a(event);
    }

    public static void m8733a(Builder builder, AnalyticsPlatform analyticsPlatform) {
        Intrinsics.b(builder, "builder");
        Intrinsics.b(analyticsPlatform, "platform");
        Intrinsics.b(builder, "builder");
        Intrinsics.b(analyticsPlatform, "platform");
        builder.platform(new Platform.Builder().name(analyticsPlatform.getPlatformName()).device_id(analyticsPlatform.getDeviceId()).device_name(analyticsPlatform.getDeviceName()).browser_name(analyticsPlatform.getBrowserName()).os_name(analyticsPlatform.getOsName()).os_version(analyticsPlatform.getOsVersion()).build());
        builder.uuid(UUID.randomUUID().toString()).client_timestamp(Long.valueOf(System.currentTimeMillis())).utc_offset(Double.valueOf((double) TimeUnit.HOURS.convert((long) TimeZone.getDefault().getOffset(System.currentTimeMillis()), TimeUnit.MILLISECONDS)));
    }

    public static void m8732a(Builder builder, EventType eventType, AnalyticsSession analyticsSession) {
        Intrinsics.b(builder, "builder");
        Intrinsics.b(eventType, "eventType");
        Intrinsics.b(analyticsSession, Session.TYPE_SESSION);
        User.Builder builder2 = new User.Builder();
        boolean z = true;
        if (analyticsSession.isAnonymous()) {
            eventType = analyticsSession.getLoId();
            CharSequence charSequence = (CharSequence) eventType;
            if (charSequence != null) {
                if (charSequence.length() != null) {
                    z = false;
                }
            }
            if (!z) {
                if (eventType == null) {
                    Intrinsics.a();
                }
                eventType = new Regex("^0+(?!$)").b((CharSequence) CollectionsKt.d(AnalyticsUtilKt.m8741b(eventType)), "");
                analyticsSession = ThingUtil.f10296a;
                analyticsSession = ThingType.f10290b;
                Intrinsics.b(eventType, "id");
                Intrinsics.b(analyticsSession, "type");
                analyticsSession = ThingUtil.m8744a(analyticsSession);
                if (!StringsKt.a(eventType, analyticsSession)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(analyticsSession);
                    stringBuilder.append(eventType);
                    eventType = stringBuilder.toString();
                }
                builder2.id(eventType);
                builder2.logged_in(Boolean.valueOf(false));
            }
        } else {
            String accountId = analyticsSession.getAccountId();
            if (accountId != null) {
                builder2.id(AnalyticsUtilKt.m8739a(accountId)).logged_in(Boolean.valueOf(true));
                if (WhenMappings.f10278a[eventType.ordinal()] == 1) {
                    eventType = analyticsSession.getAccountCreatedUtc();
                    if (eventType == null) {
                        Intrinsics.a();
                    }
                    builder2.created_timestamp(Long.valueOf(AnalyticsUtilKt.m8737a(eventType.longValue())));
                }
            }
        }
        try {
            builder.user(builder2.build());
        } catch (Builder builder3) {
            Timber.c((Throwable) builder3, "Analytics: unable to populate User for v2 event", new Object[0]);
        }
    }

    public static void m8731a(Builder builder, EventType eventType, AnalyticsPlatform analyticsPlatform) {
        Intrinsics.b(builder, "builder");
        Intrinsics.b(eventType, "eventType");
        Intrinsics.b(analyticsPlatform, "platform");
        App.Builder name = new App.Builder().name("android");
        Context a = AnalyticsUtilKt.m8738a();
        if (a == null) {
            Intrinsics.a();
        }
        name = name.version(a.getString(R.string.fmt_build_version, new Object[]{analyticsPlatform.getAppVersionName(), Integer.valueOf(analyticsPlatform.getAppVersionCode())}));
        if (WhenMappings.f10279b[eventType.ordinal()] == 1) {
            name.install_timestamp(analyticsPlatform.getAppInstallTime());
        }
        builder.app(name.build());
    }

    public static void m8736b(Builder builder, EventType eventType, AnalyticsSession analyticsSession) {
        Intrinsics.b(builder, "builder");
        Intrinsics.b(eventType, "eventType");
        Intrinsics.b(analyticsSession, Session.TYPE_SESSION);
        String sessionId = analyticsSession.getSessionId();
        if (sessionId != null) {
            com.reddit.data.events.models.components.Session.Builder id = new com.reddit.data.events.models.components.Session.Builder().id(sessionId);
            if (WhenMappings.f10280c[eventType.ordinal()] == 1) {
                id.created_timestamp(analyticsSession.getSessionCreatedTimestamp());
            }
            builder.session(id.build());
            return;
        }
        Timber.b("Analytics: sessionId was null", new Object[null]);
    }

    public static void m8734a(Builder builder, AnalyticsSession analyticsSession, AnalyticsPlatform analyticsPlatform) {
        Intrinsics.b(builder, "eventBuilder");
        Intrinsics.b(analyticsSession, Session.TYPE_SESSION);
        Intrinsics.b(analyticsPlatform, "platform");
        m8733a(builder, analyticsPlatform);
        m8732a(builder, EventType.f10275a, analyticsSession);
        m8731a(builder, EventType.f10275a, analyticsPlatform);
        m8736b(builder, EventType.f10275a, analyticsSession);
        analyticsPlatform = new UserPreferences.Builder();
        Locale locale = Locale.getDefault();
        Intrinsics.a(locale, "Locale.getDefault()");
        analyticsPlatform = analyticsPlatform.language(locale.getLanguage());
        analyticsPlatform.in_beta(Boolean.valueOf(analyticsSession.isBetaTester()));
        builder.user_preferences(analyticsPlatform.build());
        builder.screen(new Screen.Builder().theme(analyticsSession.getThemeName()).view_type(analyticsSession.getListingViewType()).build());
        CharSequence redditAdId = analyticsSession.getRedditAdId();
        if (redditAdId != null) {
            if (redditAdId.length() != null) {
                analyticsPlatform = null;
                if (analyticsPlatform == null) {
                    builder.request(new Request.Builder().reddaid(analyticsSession.getRedditAdId()).build());
                }
                builder = builder.build();
                Intrinsics.a(builder, "event");
                AnalyticsValidator.m8742a(builder);
                analyticsSession = f10282b;
                if (analyticsSession == null) {
                    Intrinsics.a("output");
                }
                analyticsSession.m8743a(builder);
            }
        }
        analyticsPlatform = true;
        if (analyticsPlatform == null) {
            builder.request(new Request.Builder().reddaid(analyticsSession.getRedditAdId()).build());
        }
        builder = builder.build();
        Intrinsics.a(builder, "event");
        AnalyticsValidator.m8742a(builder);
        analyticsSession = f10282b;
        if (analyticsSession == null) {
            Intrinsics.a("output");
        }
        analyticsSession.m8743a(builder);
    }
}
