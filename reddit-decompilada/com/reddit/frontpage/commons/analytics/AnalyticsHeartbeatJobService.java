package com.reddit.frontpage.commons.analytics;

import android.content.Context;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.data.events.Analytics;
import com.reddit.data.events.Analytics.EventType;
import com.reddit.data.events.models.AnalyticsPlatform;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.components.ActionInfo;
import com.reddit.data.events.models.components.Profile;
import com.reddit.data.events.models.components.Screen;
import com.reddit.data.events.models.components.Subreddit.Builder;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.HeartbeatEventBuilder;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Routing.NavigationAware;
import com.reddit.frontpage.util.Platform;
import com.reddit.frontpage.util.SubredditUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/AnalyticsHeartbeatJobService;", "Lcom/firebase/jobdispatcher/JobService;", "()V", "onStartJob", "", "job", "Lcom/firebase/jobdispatcher/JobParameters;", "onStopJob", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsHeartbeatJobService.kt */
public final class AnalyticsHeartbeatJobService extends JobService {
    public static final Companion f27444b = new Companion();
    private static final String f27445c = "AnalyticsHeartbeatJobService";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/AnalyticsHeartbeatJobService$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AnalyticsHeartbeatJobService.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean m28911a(JobParameters jobParameters) {
        Intrinsics.m26847b(jobParameters, "job");
        Timber.a("Heartbeat: job started", new Object[0]);
        Object obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        jobParameters = obj.m28883c();
        if (jobParameters == null) {
            Timber.a("Heartbeat: skipping null activity", new Object[0]);
            return false;
        } else if (!(jobParameters instanceof NavigationAware)) {
            Timber.a("Heartbeat: skipping activity that is not navigation aware", new Object[0]);
            return false;
        } else if (((NavigationAware) jobParameters).mo7779h() == null) {
            Timber.a("Heartbeat: skipping activity with null router", new Object[0]);
            return false;
        } else {
            jobParameters = Routing.m22617a((Context) jobParameters);
            if (jobParameters == null) {
                Timber.a("Heartbeat: skipping null screen", new Object[0]);
                return false;
            } else if (jobParameters instanceof AnalyticsTrackable) {
                AnalyticsHeartbeatParams analyticsHeartbeatParams = ((AnalyticsTrackable) jobParameters).getAnalyticsHeartbeatParams();
                if (analyticsHeartbeatParams.inFocus) {
                    boolean z;
                    int i;
                    String str;
                    String str2;
                    StringBuilder stringBuilder;
                    Builder id;
                    Object a;
                    Profile.Builder id2;
                    Platform platform;
                    Analytics analytics;
                    AnalyticsPlatform analyticsPlatform;
                    Event.Builder builder;
                    EventType eventType;
                    AnalyticsSession analyticsSession;
                    Analytics analytics2;
                    HeartbeatEventBuilder m = AppAnalytics.m21876m();
                    m.builder.screen(new Screen.Builder().in_focus(Boolean.valueOf(analyticsHeartbeatParams.inFocus)).build());
                    String str3 = analyticsHeartbeatParams.pageType;
                    CharSequence charSequence = str3;
                    if (charSequence != null) {
                        if (charSequence.length() != 0) {
                            z = false;
                            if (z) {
                                Timber.e("Analytics: no page_type for heartbeat event", new Object[0]);
                            }
                            m.builder.action_info(new ActionInfo.Builder().page_type(str3).build());
                            i = (analyticsHeartbeatParams.subredditId != null || analyticsHeartbeatParams.subredditName == null) ? false : 1;
                            if (i != 0) {
                                str = analyticsHeartbeatParams.subredditId;
                                if (str == null) {
                                    Intrinsics.m26842a();
                                }
                                str2 = analyticsHeartbeatParams.subredditName;
                                if (str2 == null) {
                                    Intrinsics.m26842a();
                                }
                                Intrinsics.m26847b(str, "id");
                                Intrinsics.m26847b(str2, "name");
                                if ((((CharSequence) ThingUtil.b(str)).length() != 0 ? 1 : false) == 0) {
                                    stringBuilder = new StringBuilder("Analytics: invalid subreddit kindWithId for heartbeat event, subredditName: ");
                                    stringBuilder.append(str2);
                                    Timber.e(stringBuilder.toString(), new Object[0]);
                                } else {
                                    id = new Builder().id(ThingUtil.a(str, ThingType.d));
                                    a = SubredditUtil.m23912a(str2);
                                    Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
                                    if (a != null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    a = a.toLowerCase();
                                    Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
                                    m.builder.subreddit(id.name(a).build());
                                }
                            }
                            if (!(analyticsHeartbeatParams.userId == null || analyticsHeartbeatParams.userName == null)) {
                                str = analyticsHeartbeatParams.userId;
                                if (str == null) {
                                    Intrinsics.m26842a();
                                }
                                str2 = analyticsHeartbeatParams.userName;
                                if (str2 == null) {
                                    Intrinsics.m26842a();
                                }
                                Intrinsics.m26847b(str, "id");
                                Intrinsics.m26847b(str2, "name");
                                id2 = new Profile.Builder().id(ThingUtil.a(str, ThingType.b));
                                a = SubredditUtil.m23912a(str2);
                                Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
                                if (a != null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                a = a.toLowerCase();
                                Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
                                m.builder.profile(id2.name(a).type(i == 0 ? "default" : "legacy").build());
                            }
                            Timber.a("Heartbeat: sending heartbeat for screen [%s], pageType [%s]", new Object[]{jobParameters.getClass().getSimpleName(), analyticsHeartbeatParams.pageType});
                            obj = SessionManager.b();
                            Intrinsics.m26843a(obj, "SessionManager.getInstance()");
                            obj = obj.c();
                            platform = Platform.f29397a;
                            analytics = Analytics.a;
                            analyticsPlatform = platform;
                            Analytics.a(m.builder, analyticsPlatform);
                            analytics = Analytics.a;
                            builder = m.builder;
                            eventType = EventType.b;
                            Intrinsics.m26843a(obj, Session.TYPE_SESSION);
                            analyticsSession = (AnalyticsSession) obj;
                            Analytics.a(builder, eventType, analyticsSession);
                            analytics = Analytics.a;
                            Analytics.a(m.builder, EventType.b, analyticsPlatform);
                            analytics2 = Analytics.a;
                            Analytics.b(m.builder, EventType.b, analyticsSession);
                            jobParameters = Analytics.a;
                            obj = m.builder.build();
                            Intrinsics.m26843a(obj, "builder.build()");
                            Analytics.a(obj);
                            return false;
                        }
                    }
                    z = true;
                    if (z) {
                        Timber.e("Analytics: no page_type for heartbeat event", new Object[0]);
                    }
                    m.builder.action_info(new ActionInfo.Builder().page_type(str3).build());
                    if (analyticsHeartbeatParams.subredditId != null) {
                    }
                    if (i != 0) {
                        str = analyticsHeartbeatParams.subredditId;
                        if (str == null) {
                            Intrinsics.m26842a();
                        }
                        str2 = analyticsHeartbeatParams.subredditName;
                        if (str2 == null) {
                            Intrinsics.m26842a();
                        }
                        Intrinsics.m26847b(str, "id");
                        Intrinsics.m26847b(str2, "name");
                        if (((CharSequence) ThingUtil.b(str)).length() != 0) {
                        }
                        if ((((CharSequence) ThingUtil.b(str)).length() != 0 ? 1 : false) == 0) {
                            id = new Builder().id(ThingUtil.a(str, ThingType.d));
                            a = SubredditUtil.m23912a(str2);
                            Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
                            if (a != null) {
                                a = a.toLowerCase();
                                Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
                                m.builder.subreddit(id.name(a).build());
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        stringBuilder = new StringBuilder("Analytics: invalid subreddit kindWithId for heartbeat event, subredditName: ");
                        stringBuilder.append(str2);
                        Timber.e(stringBuilder.toString(), new Object[0]);
                    }
                    str = analyticsHeartbeatParams.userId;
                    if (str == null) {
                        Intrinsics.m26842a();
                    }
                    str2 = analyticsHeartbeatParams.userName;
                    if (str2 == null) {
                        Intrinsics.m26842a();
                    }
                    Intrinsics.m26847b(str, "id");
                    Intrinsics.m26847b(str2, "name");
                    id2 = new Profile.Builder().id(ThingUtil.a(str, ThingType.b));
                    a = SubredditUtil.m23912a(str2);
                    Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
                    if (a != null) {
                        a = a.toLowerCase();
                        Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
                        if (i == 0) {
                        }
                        m.builder.profile(id2.name(a).type(i == 0 ? "default" : "legacy").build());
                        Timber.a("Heartbeat: sending heartbeat for screen [%s], pageType [%s]", new Object[]{jobParameters.getClass().getSimpleName(), analyticsHeartbeatParams.pageType});
                        obj = SessionManager.b();
                        Intrinsics.m26843a(obj, "SessionManager.getInstance()");
                        obj = obj.c();
                        platform = Platform.f29397a;
                        analytics = Analytics.a;
                        analyticsPlatform = platform;
                        Analytics.a(m.builder, analyticsPlatform);
                        analytics = Analytics.a;
                        builder = m.builder;
                        eventType = EventType.b;
                        Intrinsics.m26843a(obj, Session.TYPE_SESSION);
                        analyticsSession = (AnalyticsSession) obj;
                        Analytics.a(builder, eventType, analyticsSession);
                        analytics = Analytics.a;
                        Analytics.a(m.builder, EventType.b, analyticsPlatform);
                        analytics2 = Analytics.a;
                        Analytics.b(m.builder, EventType.b, analyticsSession);
                        jobParameters = Analytics.a;
                        obj = m.builder.build();
                        Intrinsics.m26843a(obj, "builder.build()");
                        Analytics.a(obj);
                        return false;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                Timber.a("Heartbeat: skipping event because screen is out of focus.", new Object[0]);
                return false;
            } else {
                Timber.a("Heartbeat: skipping untracked screen: %s", new Object[]{jobParameters.getClass().getSimpleName()});
                return false;
            }
        }
    }

    public final boolean m28912b(JobParameters jobParameters) {
        Intrinsics.m26847b(jobParameters, "job");
        Timber.a("Heartbeat: job stopped", new Object[0]);
        return true;
    }

    static {
        Intrinsics.m26843a(AnalyticsHeartbeatJobService.class.getSimpleName(), "AnalyticsHeartbeatJobSer…ce::class.java.simpleName");
    }
}
