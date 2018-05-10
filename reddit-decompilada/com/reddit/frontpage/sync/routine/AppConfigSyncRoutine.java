package com.reddit.frontpage.sync.routine;

import android.accounts.Account;
import android.content.Context;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.BestOfCommunity;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Bucket;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Experiments;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.FavoriteSubreddits;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.FreshContentPill;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.IngestionRollout;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.LoggedOutInbox;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.MvpHomePageAndroid;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.NewInSubscriptions;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Onboarding;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.PerformanceAnalyticsAndroid;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.RecentlyVisited;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.RecommendedLinks;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.SubredditRecommendations;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.TrendingUsers;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.BucketConfigReceivedEvent;
import com.reddit.frontpage.commons.analytics.events.v1.BucketConfigReceivedEvent.BucketConfigReceivedPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.presentation.common.ContentTypeUtil;
import com.reddit.frontpage.util.PushUtil;
import com.reddit.frontpage.util.UpgradeUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/sync/routine/AppConfigSyncRoutine;", "Lcom/reddit/frontpage/sync/routine/SyncRoutine;", "()V", "remoteGatewayDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteGatewayDataSource;", "getRemoteGatewayDataSource", "()Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteGatewayDataSource;", "setRemoteGatewayDataSource", "(Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteGatewayDataSource;)V", "buildHeaderMap", "", "", "sync", "", "account", "Landroid/accounts/Account;", "context", "Landroid/content/Context;", "AppConfigurationUpdatedEvent", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AppConfigSyncRoutine.kt */
public final class AppConfigSyncRoutine extends SyncRoutine {
    public static final String f28850b = ArraysKt___ArraysKt.m36083a((Object[]) new String[]{"ads", "assets", "content_type", "domain_name", "enjoy_reddit_toast", "featured_content_carousel", "login_enhancements", "mainfeed_content_carousel", "native_live_rollout", "new_user_alert", "push_notification", "share_copy_link", "share_shimmer", ShareEvent.SOURCE_UPVOTE_TOAST, FreshContentPill.NAME, SubredditRecommendations.NAME, FavoriteSubreddits.NAME, TrendingUsers.NAME, RecommendedLinks.NAME, NewInSubscriptions.NAME, IngestionRollout.NAME, BestOfCommunity.NAME, RecentlyVisited.NAME, MvpHomePageAndroid.NAME, Onboarding.NAME, LoggedOutInbox.NAME, PerformanceAnalyticsAndroid.NAME}, (CharSequence) ", ", null, null, 0, null, null, 62);
    public static final String f28851c = "google";
    public static final String f28852d = "amazon";
    public static final int f28853e = 2;
    public static final Companion f28854f = new Companion();
    private static final String f28855j = "AppConfigSyncRoutine";
    @Inject
    public RemoteGatewayDataSource f28856a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006XD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/sync/routine/AppConfigSyncRoutine$Companion;", "", "()V", "AMAZON_STORE", "", "EXPERIMENTS", "GOOGLE_STORE", "SYNC_ID", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "sendBucketingEvents", "", "buckets", "", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration$Bucket;", "([Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration$Bucket;)V", "storeContentTypePatterns", "config", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AppConfigSyncRoutine.kt */
    public static final class Companion {
        private Companion() {
        }

        public static void m23265a(AppConfiguration appConfiguration) {
            Intrinsics.m26847b(appConfiguration, "config");
            Experiments experiments = appConfiguration.experiments;
            if ((experiments != null ? experiments.content_type : null) == null) {
                appConfiguration = FrontpageSettings.u().experiments.content_type;
            } else {
                appConfiguration = appConfiguration.experiments.content_type;
            }
            ContentTypeUtil contentTypeUtil = ContentTypeUtil.f20363a;
            contentTypeUtil = ContentTypeUtil.f20363a;
            ContentTypeUtil.m22693a(ContentTypeUtil.m22692a(appConfiguration.image_type));
            contentTypeUtil = ContentTypeUtil.f20363a;
            contentTypeUtil = ContentTypeUtil.f20363a;
            ContentTypeUtil.m22697b(ContentTypeUtil.m22692a(appConfiguration.image_type_exception));
            contentTypeUtil = ContentTypeUtil.f20363a;
            contentTypeUtil = ContentTypeUtil.f20363a;
            ContentTypeUtil.m22700c(ContentTypeUtil.m22692a(appConfiguration.video_type));
            contentTypeUtil = ContentTypeUtil.f20363a;
            contentTypeUtil = ContentTypeUtil.f20363a;
            ContentTypeUtil.m22702d(ContentTypeUtil.m22692a(appConfiguration.video_type_exception));
            appConfiguration = ContentTypeUtil.f20363a;
            Util.f21809a = ContentTypeUtil.m22691a();
            appConfiguration = ContentTypeUtil.f20363a;
            Util.f21810b = ContentTypeUtil.m22696b();
            appConfiguration = ContentTypeUtil.f20363a;
            Util.f21811c = ContentTypeUtil.m22699c();
            appConfiguration = ContentTypeUtil.f20363a;
            Util.f21812d = ContentTypeUtil.m22701d();
        }

        public static final /* synthetic */ void m23266a(Bucket[] bucketArr) {
            Object[] objArr = (Object[]) bucketArr;
            int i = 0;
            if ((objArr.length == 0 ? 1 : 0) == 0) {
                int length = objArr.length;
                while (i < length) {
                    Bucket bucket = (Bucket) objArr[i];
                    BucketConfigReceivedEvent bucketConfigReceivedEvent = new BucketConfigReceivedEvent();
                    BucketConfigReceivedPayload bucketConfigReceivedPayload = (BucketConfigReceivedPayload) bucketConfigReceivedEvent.payload;
                    bucketConfigReceivedPayload.experiment_id = bucket.experiment_id;
                    bucketConfigReceivedPayload.experiment_name = bucket.experiment_name;
                    bucketConfigReceivedPayload.variant = bucket.variant_name;
                    AppAnalytics.m21852a((BaseEvent) bucketConfigReceivedEvent);
                    i++;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/sync/routine/AppConfigSyncRoutine$AppConfigurationUpdatedEvent;", "Lcom/reddit/datalibrary/frontpage/data/common/busevents/BaseEvent;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AppConfigSyncRoutine.kt */
    public static final class AppConfigurationUpdatedEvent extends com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent {
    }

    public static final void m29921a(AppConfiguration appConfiguration) {
        Companion.m23265a(appConfiguration);
    }

    public AppConfigSyncRoutine() {
        super(f28853e);
        FrontpageApplication.m28877m().mo4605a(this);
    }

    public final boolean mo4941a(Account account, Context context) {
        Intrinsics.m26847b(account, "account");
        Intrinsics.m26847b(context, "context");
        Timber.b("App config sync starting", new Object[0]);
        context = true;
        if (AccountUtil.a(account) == null) {
            Timber.b("Aborting App config sync, this is not the default user.", new Object[0]);
            return true;
        }
        String str;
        String id;
        RemoteGatewayDataSource remoteGatewayDataSource;
        CharSequence charSequence;
        boolean z;
        Object b;
        String str2;
        StringBuilder stringBuilder;
        Map map;
        Object obj;
        AppConfiguration appConfiguration;
        Bucket[] bucketArr;
        Object b2 = SessionManager.b();
        Intrinsics.m26843a(b2, "SessionManager.getInstance()");
        account = b2.c();
        if (UpgradeUtil.m23945b()) {
            str = f28851c;
        } else {
            str = f28852d;
        }
        String str3 = str;
        if (!(account == null || account.isAnonymous())) {
            com.reddit.datalibrary.frontpage.requests.models.v1.Account account2 = (com.reddit.datalibrary.frontpage.requests.models.v1.Account) AccountStorage.b.a(account.getUsername());
            if (account2 != null) {
                id = account2.getId();
                remoteGatewayDataSource = this.f28856a;
                if (remoteGatewayDataSource == null) {
                    Intrinsics.m26844a("remoteGatewayDataSource");
                }
                account = new HashMap();
                account.put("Client-Vendor-ID", Config.g);
                account.put("x-reddit-device-id", Config.g);
                account.put("User-Agent", Config.b);
                charSequence = Config.f;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        z = false;
                        if (!z) {
                            account.put("x-reddit-session", Config.f);
                        }
                        charSequence = Config.h;
                        if (charSequence != null) {
                            if (charSequence.length() != 0) {
                                z = false;
                                if (!z) {
                                    account.put("x-reddit-loid", Config.h);
                                }
                                b = SessionManager.b();
                                Intrinsics.m26843a(b, "SessionManager.getInstance()");
                                b = b.c();
                                str2 = HttpRequest.HEADER_AUTHORIZATION;
                                stringBuilder = new StringBuilder("Bearer ");
                                Intrinsics.m26843a(b, Session.TYPE_SESSION);
                                stringBuilder.append(b.b());
                                account.put(str2, stringBuilder.toString());
                                map = (Map) account;
                                obj = Config.g;
                                Intrinsics.m26843a(obj, "Config.deviceId");
                                appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                                if (!(appConfiguration == null || appConfiguration.global == null)) {
                                    if (appConfiguration.experiments == null) {
                                        FrontpageSettings.a().a(appConfiguration);
                                        bucketArr = appConfiguration.buckets;
                                        if (bucketArr != null) {
                                            Companion.m23266a(bucketArr);
                                        }
                                        Companion.m23265a(appConfiguration);
                                        EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                                        Timber.b("App config sync complete", new Object[0]);
                                        return context;
                                    }
                                }
                                Timber.e("Failed to get application configuration!", new Object[0]);
                                return false;
                            }
                        }
                        z = true;
                        if (z) {
                            account.put("x-reddit-loid", Config.h);
                        }
                        b = SessionManager.b();
                        Intrinsics.m26843a(b, "SessionManager.getInstance()");
                        b = b.c();
                        str2 = HttpRequest.HEADER_AUTHORIZATION;
                        stringBuilder = new StringBuilder("Bearer ");
                        Intrinsics.m26843a(b, Session.TYPE_SESSION);
                        stringBuilder.append(b.b());
                        account.put(str2, stringBuilder.toString());
                        map = (Map) account;
                        obj = Config.g;
                        Intrinsics.m26843a(obj, "Config.deviceId");
                        appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                        if (appConfiguration.experiments == null) {
                            FrontpageSettings.a().a(appConfiguration);
                            bucketArr = appConfiguration.buckets;
                            if (bucketArr != null) {
                                Companion.m23266a(bucketArr);
                            }
                            Companion.m23265a(appConfiguration);
                            EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                            Timber.b("App config sync complete", new Object[0]);
                            return context;
                        }
                        Timber.e("Failed to get application configuration!", new Object[0]);
                        return false;
                    }
                }
                z = true;
                if (z) {
                    account.put("x-reddit-session", Config.f);
                }
                charSequence = Config.h;
                if (charSequence != null) {
                    if (charSequence.length() != 0) {
                        z = false;
                        if (z) {
                            account.put("x-reddit-loid", Config.h);
                        }
                        b = SessionManager.b();
                        Intrinsics.m26843a(b, "SessionManager.getInstance()");
                        b = b.c();
                        str2 = HttpRequest.HEADER_AUTHORIZATION;
                        stringBuilder = new StringBuilder("Bearer ");
                        Intrinsics.m26843a(b, Session.TYPE_SESSION);
                        stringBuilder.append(b.b());
                        account.put(str2, stringBuilder.toString());
                        map = (Map) account;
                        obj = Config.g;
                        Intrinsics.m26843a(obj, "Config.deviceId");
                        appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                        if (appConfiguration.experiments == null) {
                            Timber.e("Failed to get application configuration!", new Object[0]);
                            return false;
                        }
                        FrontpageSettings.a().a(appConfiguration);
                        bucketArr = appConfiguration.buckets;
                        if (bucketArr != null) {
                            Companion.m23266a(bucketArr);
                        }
                        Companion.m23265a(appConfiguration);
                        EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                        Timber.b("App config sync complete", new Object[0]);
                        return context;
                    }
                }
                z = true;
                if (z) {
                    account.put("x-reddit-loid", Config.h);
                }
                b = SessionManager.b();
                Intrinsics.m26843a(b, "SessionManager.getInstance()");
                b = b.c();
                str2 = HttpRequest.HEADER_AUTHORIZATION;
                stringBuilder = new StringBuilder("Bearer ");
                Intrinsics.m26843a(b, Session.TYPE_SESSION);
                stringBuilder.append(b.b());
                account.put(str2, stringBuilder.toString());
                map = (Map) account;
                obj = Config.g;
                Intrinsics.m26843a(obj, "Config.deviceId");
                appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                if (appConfiguration.experiments == null) {
                    FrontpageSettings.a().a(appConfiguration);
                    bucketArr = appConfiguration.buckets;
                    if (bucketArr != null) {
                        Companion.m23266a(bucketArr);
                    }
                    Companion.m23265a(appConfiguration);
                    EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                    Timber.b("App config sync complete", new Object[0]);
                    return context;
                }
                Timber.e("Failed to get application configuration!", new Object[0]);
                return false;
            }
        }
        id = null;
        try {
            remoteGatewayDataSource = this.f28856a;
            if (remoteGatewayDataSource == null) {
                Intrinsics.m26844a("remoteGatewayDataSource");
            }
            account = new HashMap();
            account.put("Client-Vendor-ID", Config.g);
            account.put("x-reddit-device-id", Config.g);
            account.put("User-Agent", Config.b);
            charSequence = Config.f;
            if (charSequence != null) {
                if (charSequence.length() == 0) {
                    z = false;
                    if (z) {
                        account.put("x-reddit-session", Config.f);
                    }
                    charSequence = Config.h;
                    if (charSequence != null) {
                        if (charSequence.length() != 0) {
                            z = false;
                            if (z) {
                                account.put("x-reddit-loid", Config.h);
                            }
                            b = SessionManager.b();
                            Intrinsics.m26843a(b, "SessionManager.getInstance()");
                            b = b.c();
                            str2 = HttpRequest.HEADER_AUTHORIZATION;
                            stringBuilder = new StringBuilder("Bearer ");
                            Intrinsics.m26843a(b, Session.TYPE_SESSION);
                            stringBuilder.append(b.b());
                            account.put(str2, stringBuilder.toString());
                            map = (Map) account;
                            obj = Config.g;
                            Intrinsics.m26843a(obj, "Config.deviceId");
                            appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                            if (appConfiguration.experiments == null) {
                                Timber.e("Failed to get application configuration!", new Object[0]);
                                return false;
                            }
                            FrontpageSettings.a().a(appConfiguration);
                            bucketArr = appConfiguration.buckets;
                            if (bucketArr != null) {
                                Companion.m23266a(bucketArr);
                            }
                            Companion.m23265a(appConfiguration);
                            EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                            Timber.b("App config sync complete", new Object[0]);
                            return context;
                        }
                    }
                    z = true;
                    if (z) {
                        account.put("x-reddit-loid", Config.h);
                    }
                    b = SessionManager.b();
                    Intrinsics.m26843a(b, "SessionManager.getInstance()");
                    b = b.c();
                    str2 = HttpRequest.HEADER_AUTHORIZATION;
                    stringBuilder = new StringBuilder("Bearer ");
                    Intrinsics.m26843a(b, Session.TYPE_SESSION);
                    stringBuilder.append(b.b());
                    account.put(str2, stringBuilder.toString());
                    map = (Map) account;
                    obj = Config.g;
                    Intrinsics.m26843a(obj, "Config.deviceId");
                    appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                    if (appConfiguration.experiments == null) {
                        FrontpageSettings.a().a(appConfiguration);
                        bucketArr = appConfiguration.buckets;
                        if (bucketArr != null) {
                            Companion.m23266a(bucketArr);
                        }
                        Companion.m23265a(appConfiguration);
                        EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                        Timber.b("App config sync complete", new Object[0]);
                        return context;
                    }
                    Timber.e("Failed to get application configuration!", new Object[0]);
                    return false;
                }
            }
            z = true;
            if (z) {
                account.put("x-reddit-session", Config.f);
            }
            charSequence = Config.h;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    z = false;
                    if (z) {
                        account.put("x-reddit-loid", Config.h);
                    }
                    b = SessionManager.b();
                    Intrinsics.m26843a(b, "SessionManager.getInstance()");
                    b = b.c();
                    str2 = HttpRequest.HEADER_AUTHORIZATION;
                    stringBuilder = new StringBuilder("Bearer ");
                    Intrinsics.m26843a(b, Session.TYPE_SESSION);
                    stringBuilder.append(b.b());
                    account.put(str2, stringBuilder.toString());
                    map = (Map) account;
                    obj = Config.g;
                    Intrinsics.m26843a(obj, "Config.deviceId");
                    appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
                    if (appConfiguration.experiments == null) {
                        Timber.e("Failed to get application configuration!", new Object[0]);
                        return false;
                    }
                    FrontpageSettings.a().a(appConfiguration);
                    bucketArr = appConfiguration.buckets;
                    if (bucketArr != null) {
                        Companion.m23266a(bucketArr);
                    }
                    Companion.m23265a(appConfiguration);
                    EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                    Timber.b("App config sync complete", new Object[0]);
                    return context;
                }
            }
            z = true;
            if (z) {
                account.put("x-reddit-loid", Config.h);
            }
            b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            b = b.c();
            str2 = HttpRequest.HEADER_AUTHORIZATION;
            stringBuilder = new StringBuilder("Bearer ");
            Intrinsics.m26843a(b, Session.TYPE_SESSION);
            stringBuilder.append(b.b());
            account.put(str2, stringBuilder.toString());
            map = (Map) account;
            obj = Config.g;
            Intrinsics.m26843a(obj, "Config.deviceId");
            appConfiguration = (AppConfiguration) remoteGatewayDataSource.appConfig(map, obj, str3, f28850b, id).blockingGet();
            if (appConfiguration.experiments == null) {
                FrontpageSettings.a().a(appConfiguration);
                bucketArr = appConfiguration.buckets;
                if (bucketArr != null) {
                    Companion.m23266a(bucketArr);
                }
                Companion.m23265a(appConfiguration);
                EventBus.getDefault().post(new AppConfigurationUpdatedEvent());
                Timber.b("App config sync complete", new Object[0]);
                return context;
            }
            Timber.e("Failed to get application configuration!", new Object[0]);
            return false;
        } catch (Account account3) {
            appConfiguration = (Throwable) account3;
            context = f28855j;
            Timber.c(appConfiguration, context, new Object[0]);
            return false;
        } catch (Account account32) {
            appConfiguration = (Throwable) account32;
            context = f28855j;
            Timber.c(appConfiguration, context, new Object[0]);
            return false;
        } catch (Account account322) {
            appConfiguration = (Throwable) account322;
            context = f28855j;
            Timber.c(appConfiguration, context, new Object[0]);
            return false;
        } finally {
            PushUtil.m23876c();
        }
    }
}
