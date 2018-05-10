package com.reddit.frontpage.commons.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.cookpad.puree.JsonConvertible;
import com.cookpad.puree.Key;
import com.cookpad.puree.Puree;
import com.cookpad.puree.PureeConfiguration;
import com.cookpad.puree.PureeConfiguration.Builder;
import com.cookpad.puree.PureeFilter;
import com.cookpad.puree.Source;
import com.cookpad.puree.outputs.PureeOutput;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Trigger;
import com.google.android.gms.common.GoogleApiAvailability;
import com.reddit.data.events.Analytics;
import com.reddit.data.events.datasource.local.LocalEventDataSource;
import com.reddit.data.events.models.Event;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration$.Lambda.0;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Bucket;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ProfileSettingsEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.AdImpressionEvent;
import com.reddit.frontpage.commons.analytics.events.v1.AdRequestEvent;
import com.reddit.frontpage.commons.analytics.events.v1.AlertEvent;
import com.reddit.frontpage.commons.analytics.events.v1.AlertEvent.AlertPayload;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.BasePayload;
import com.reddit.frontpage.commons.analytics.events.v1.BucketConfigReceivedEvent;
import com.reddit.frontpage.commons.analytics.events.v1.BucketExposureEvent;
import com.reddit.frontpage.commons.analytics.events.v1.BucketExposureEvent.BucketExposurePayload;
import com.reddit.frontpage.commons.analytics.events.v1.CarouselEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ClickEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ClickEvent.ClickPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ControlTabEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ControlTabEvent.ControlTabEventPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ImageUploadEvent;
import com.reddit.frontpage.commons.analytics.events.v1.InstallEvent;
import com.reddit.frontpage.commons.analytics.events.v1.NewUserPromptEvent;
import com.reddit.frontpage.commons.analytics.events.v1.NewUserPromptEvent.PromptResponsePayload;
import com.reddit.frontpage.commons.analytics.events.v1.NotificationClickEvent;
import com.reddit.frontpage.commons.analytics.events.v1.NotificationClickEvent.NotificationClickPayload;
import com.reddit.frontpage.commons.analytics.events.v1.PushNotificationEvent;
import com.reddit.frontpage.commons.analytics.events.v1.PushNotificationEvent.PushNotificationPayload;
import com.reddit.frontpage.commons.analytics.events.v1.PushNotificationSuppressedEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewHeartbeatEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent;
import com.reddit.frontpage.commons.analytics.events.v1.SessionStartEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent.SharePayload;
import com.reddit.frontpage.commons.analytics.events.v1.SubscribeEvent;
import com.reddit.frontpage.commons.analytics.events.v1.SubscribeEvent.SubscribePayload;
import com.reddit.frontpage.commons.analytics.events.v1.ToastEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ToastEvent.ToastPayload;
import com.reddit.frontpage.commons.analytics.events.v1.TopSubredditClickEvent;
import com.reddit.frontpage.commons.analytics.events.v1.UnsubscribeEvent;
import com.reddit.frontpage.commons.analytics.events.v1.UnsubscribeEvent.UnsubscribePayload;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.DummyEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.HeartbeatEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ListingPerformanceEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OutboundLinkEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerChangePageTypeEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerFullScreenEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerMuteEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerOverflowEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerPauseEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerPlayEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerReplayEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerRotateFullScreenEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerSaveEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollActivatedEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollAutoPlayEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollPauseClosedEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerScrollPauseEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerSeekEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerServedVideoEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerUnmuteEvent;
import com.reddit.frontpage.commons.analytics.events.v2.VideoUploadEvent;
import com.reddit.frontpage.commons.analytics.output.BufferedOutput;
import com.reddit.frontpage.commons.analytics.output.LoggingOutput;
import com.reddit.frontpage.commons.analytics.output.PureeOldEventsFilter;
import com.reddit.frontpage.commons.analytics.output.ThriftOutput;
import com.reddit.frontpage.domain.model.AnalyticsPostType;
import com.reddit.frontpage.util.BoundedLinkedList;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import timber.log.Timber;

public class AppAnalytics {
    private static ScheduledExecutorService f20006a;
    private static LoggingOutput f20007b;
    private static ThriftOutput f20008c;
    private static FirebaseJobDispatcher f20009d;
    private static final Set<Class<? extends JsonConvertible>> f20010e = new C17721();

    static class C17721 extends HashSet<Class<? extends JsonConvertible>> {
        C17721() {
            add(ScreenViewEvent.class);
            add(ClickEvent.class);
            add(ShareEvent.class);
            add(ScrollEvent.class);
            add(BucketExposureEvent.class);
            add(BucketConfigReceivedEvent.class);
            add(AdRequestEvent.class);
            add(ImageUploadEvent.class);
            add(AdImpressionEvent.class);
            add(PushNotificationEvent.class);
            add(PushNotificationSuppressedEvent.class);
            add(NotificationClickEvent.class);
            add(ScreenViewHeartbeatEvent.class);
            add(InstallEvent.class);
            add(CarouselEvent.class);
            add(SubscribeEvent.class);
            add(UnsubscribeEvent.class);
            add(ControlTabEvent.class);
            add(TopSubredditClickEvent.class);
            add(NewUserPromptEvent.class);
            add(ToastEvent.class);
            add(SessionStartEvent.class);
            add(AlertEvent.class);
            add(VideoUploadEvent.class);
            add(VideoPlayerFullScreenEvent.class);
            add(VideoPlayerMuteEvent.class);
            add(VideoPlayerOverflowEvent.class);
            add(VideoPlayerPauseEvent.class);
            add(VideoPlayerPlayEvent.class);
            add(VideoPlayerReplayEvent.class);
            add(VideoPlayerRotateFullScreenEvent.class);
            add(VideoPlayerSaveEvent.class);
            add(VideoPlayerScrollAutoPlayEvent.class);
            add(VideoPlayerScrollPauseEvent.class);
            add(VideoPlayerSeekEvent.class);
            add(VideoPlayerUnmuteEvent.class);
            add(VideoPlayerChangePageTypeEvent.class);
            add(VideoPlayerServedVideoEvent.class);
            add(VideoPlayerScrollActivatedEvent.class);
            add(VideoPlayerScrollPauseClosedEvent.class);
        }
    }

    public static class AlertEventBuilder {
        private String f19949a;
        private String f19950b;

        public final AlertEventBuilder m21816a(String str) {
            this.f19949a = str;
            return this;
        }

        public final AlertEventBuilder m21818b(String str) {
            this.f19950b = str;
            return this;
        }

        public final void m21817a() {
            int i;
            BaseEvent alertEvent;
            AlertPayload alertPayload;
            if (!TextUtils.isEmpty(this.f19950b)) {
                if (!TextUtils.isEmpty(this.f19949a)) {
                    i = 0;
                    if (i != 0) {
                        Timber.e(String.format("Invalid alert event: alert_name(%s), screen_name(%s)", new Object[]{this.f19950b, this.f19949a}), new Object[0]);
                    }
                    alertEvent = new AlertEvent();
                    alertPayload = (AlertPayload) alertEvent.payload;
                    alertPayload.screen_name = this.f19949a;
                    alertPayload.alert_name = this.f19950b;
                    AppAnalytics.m21852a(alertEvent);
                }
            }
            i = 1;
            if (i != 0) {
                Timber.e(String.format("Invalid alert event: alert_name(%s), screen_name(%s)", new Object[]{this.f19950b, this.f19949a}), new Object[0]);
            }
            alertEvent = new AlertEvent();
            alertPayload = (AlertPayload) alertEvent.payload;
            alertPayload.screen_name = this.f19949a;
            alertPayload.alert_name = this.f19950b;
            AppAnalytics.m21852a(alertEvent);
        }
    }

    public static abstract class BaseSubscribeEventBuilder {
        protected String f19951a;
        protected String f19952b;
        protected String f19953c;

        public abstract void mo4571a();

        public final BaseSubscribeEventBuilder m21819a(String str) {
            this.f19951a = str;
            return this;
        }

        public final BaseSubscribeEventBuilder m21821b(String str) {
            this.f19952b = str;
            return this;
        }

        public final BaseSubscribeEventBuilder m21822c(String str) {
            this.f19953c = str;
            return this;
        }
    }

    public static class ClickEventBuilder {
        public String f19954a;
        public String f19955b;
        public String f19956c;
        public String f19957d;
        public String f19958e;
        public String f19959f;
        public String f19960g;
        private String f19961h;
        private int f19962i;
        private String f19963j;
        private int f19964k;
        private String f19965l;
        private String f19966m;
        private String f19967n;

        public final void m21825a() {
            int i;
            BaseEvent clickEvent;
            ClickPayload clickPayload;
            if (TextUtils.isEmpty(this.f19954a)) {
                this.f19954a = this.f19961h;
            }
            if (!TextUtils.isEmpty(this.f19954a)) {
                if (!TextUtils.isEmpty(this.f19955b)) {
                    i = 0;
                    if (i != 0) {
                        Timber.e(String.format("Invalid click event: screenName(%s) controlName(%s)", new Object[]{this.f19954a, this.f19955b}), new Object[0]);
                    }
                    clickEvent = new ClickEvent(this.f19954a);
                    clickPayload = (ClickPayload) clickEvent.payload;
                    clickPayload.screen_name = this.f19954a;
                    clickPayload.control_name = this.f19955b;
                    clickPayload.position = this.f19962i;
                    clickPayload.target_name = this.f19963j;
                    clickPayload.target_position = this.f19964k;
                    clickPayload.target_url = this.f19956c;
                    clickPayload.target_fullname = this.f19957d;
                    clickPayload.target_type = this.f19965l;
                    clickPayload.live_thread_id = this.f19958e;
                    clickPayload.target_url_domain = this.f19959f;
                    clickPayload.swap_with = this.f19966m;
                    clickPayload.query = this.f19960g;
                    clickPayload.location_name = this.f19967n;
                    AppAnalytics.m21852a(clickEvent);
                }
            }
            i = 1;
            if (i != 0) {
                Timber.e(String.format("Invalid click event: screenName(%s) controlName(%s)", new Object[]{this.f19954a, this.f19955b}), new Object[0]);
            }
            clickEvent = new ClickEvent(this.f19954a);
            clickPayload = (ClickPayload) clickEvent.payload;
            clickPayload.screen_name = this.f19954a;
            clickPayload.control_name = this.f19955b;
            clickPayload.position = this.f19962i;
            clickPayload.target_name = this.f19963j;
            clickPayload.target_position = this.f19964k;
            clickPayload.target_url = this.f19956c;
            clickPayload.target_fullname = this.f19957d;
            clickPayload.target_type = this.f19965l;
            clickPayload.live_thread_id = this.f19958e;
            clickPayload.target_url_domain = this.f19959f;
            clickPayload.swap_with = this.f19966m;
            clickPayload.query = this.f19960g;
            clickPayload.location_name = this.f19967n;
            AppAnalytics.m21852a(clickEvent);
        }

        public final ClickEventBuilder m21823a(View view) {
            this.f19961h = AppAnalytics.m21849a(view);
            return this;
        }

        public final ClickEventBuilder m21824a(String str) {
            this.f19954a = str;
            return this;
        }

        public final ClickEventBuilder m21826b(String str) {
            this.f19955b = str;
            return this;
        }

        public final ClickEventBuilder m21827c(String str) {
            this.f19956c = str;
            return this;
        }

        public final ClickEventBuilder m21828d(String str) {
            this.f19957d = str;
            return this;
        }

        public final ClickEventBuilder m21829e(String str) {
            this.f19965l = str;
            return this;
        }

        public final ClickEventBuilder m21830f(String str) {
            this.f19959f = str;
            return this;
        }

        public final ClickEventBuilder m21831g(String str) {
            this.f19967n = str;
            return this;
        }
    }

    public static class ControlTabEventBuilder {
        public String f19968a;
        public String f19969b;
        public String f19970c;

        public final void m21832a() {
            int i;
            BaseEvent controlTabEvent;
            if (!TextUtils.isEmpty(this.f19968a)) {
                if (!TextUtils.isEmpty(this.f19970c)) {
                    i = 0;
                    if (i != 0) {
                        Timber.e(String.format("Invalid control tab event: control_name(%s), screen_name(%s)", new Object[]{this.f19968a, this.f19970c}), new Object[0]);
                    }
                    controlTabEvent = new ControlTabEvent(this.f19970c);
                    ((ControlTabEventPayload) controlTabEvent.payload).control_name = this.f19968a;
                    ((ControlTabEventPayload) controlTabEvent.payload).base_url = this.f19969b;
                    AppAnalytics.m21852a(controlTabEvent);
                }
            }
            i = 1;
            if (i != 0) {
                Timber.e(String.format("Invalid control tab event: control_name(%s), screen_name(%s)", new Object[]{this.f19968a, this.f19970c}), new Object[0]);
            }
            controlTabEvent = new ControlTabEvent(this.f19970c);
            ((ControlTabEventPayload) controlTabEvent.payload).control_name = this.f19968a;
            ((ControlTabEventPayload) controlTabEvent.payload).base_url = this.f19969b;
            AppAnalytics.m21852a(controlTabEvent);
        }
    }

    public static class FocusListenerBuilder {
        public String f19972a;
        public String f19973b;

        public final OnFocusChangeListener m21833a() {
            return new AppAnalytics$FocusListenerBuilder$$Lambda$0(this);
        }
    }

    private static class ScreenViewHeartbeatRunnable implements Runnable {
        private final String f19974a;
        private final long f19975b;
        private final String f19976c;

        ScreenViewHeartbeatRunnable(String str, long j, String str2) {
            this.f19974a = str;
            this.f19975b = j;
            this.f19976c = str2;
        }

        public void run() {
            BaseEvent screenViewHeartbeatEvent = new ScreenViewHeartbeatEvent(this.f19974a);
            AppAnalytics.m21861b(screenViewHeartbeatEvent.payload);
            ((ScreenViewPayload) screenViewHeartbeatEvent.payload).time_on_page = System.currentTimeMillis() - this.f19975b;
            ((ScreenViewPayload) screenViewHeartbeatEvent.payload).live_thread_id = this.f19976c;
            AppAnalytics.m21852a(screenViewHeartbeatEvent);
        }
    }

    public static class ScrollEventBuilder {
        public String f19977a;
        public String f19978b;
        public float f19979c;
        public int f19980d;
        public int f19981e;
        public int f19982f;
        public List<String> f19983g;
        public List<Long> f19984h;
        public List<Long> f19985i;
        public long f19986j;
        public String f19987k;
        public String f19988l;
        public String f19989m;
        public String f19990n;
    }

    public static class ShareEventBuilder {
        String f19991a;
        public String f19992b;
        public boolean f19993c = FrontpageSettings.a().c();
        public boolean f19994d = FrontpageSettings.a().d();
        public String f19995e;
        public String f19996f;
        public String f19997g;
        public String f19998h;
        public String f19999i;
        public String f20000j;
        public String f20001k;
        public String f20002l;
        private String f20003m;

        public final void m21837a() {
            ShareEvent shareEvent = new ShareEvent(this.f19992b);
            SharePayload sharePayload = (SharePayload) shareEvent.payload;
            sharePayload.action = this.f19991a;
            if (TextUtils.isEmpty(this.f19992b)) {
                this.f19992b = this.f20003m;
            }
            sharePayload.screen_name = this.f19992b;
            sharePayload.compact_view = this.f19993c;
            sharePayload.nightmode = this.f19994d;
            sharePayload.target_url = this.f19995e;
            sharePayload.target_fullname = this.f19996f;
            sharePayload.target_type = this.f19997g;
            sharePayload.target_url_domain = this.f19998h;
            sharePayload.target_title = this.f19999i;
            sharePayload.sr_name = this.f20000j;
            sharePayload.sr_id = this.f20001k;
            sharePayload.source = this.f20002l;
            InternalSettings.a().a("com.reddit.frontpage.share_event", shareEvent);
        }

        public final ShareEventBuilder m21835a(String str) {
            this.f19992b = str;
            return this;
        }

        public final ShareEventBuilder m21836a(boolean z) {
            this.f19993c = z;
            return this;
        }

        public final ShareEventBuilder m21839b(boolean z) {
            this.f19994d = z;
            return this;
        }

        public final ShareEventBuilder m21838b(String str) {
            this.f19995e = str;
            return this;
        }

        public final ShareEventBuilder m21840c(String str) {
            this.f19996f = str;
            return this;
        }

        public final ShareEventBuilder m21841d(String str) {
            this.f19997g = str;
            return this;
        }

        public final ShareEventBuilder m21842e(String str) {
            this.f19998h = str;
            return this;
        }

        public final ShareEventBuilder m21843f(String str) {
            this.f19999i = str;
            return this;
        }

        public final ShareEventBuilder m21844g(String str) {
            this.f20000j = str;
            return this;
        }

        public final ShareEventBuilder m21845h(String str) {
            this.f20001k = str;
            return this;
        }

        public final ShareEventBuilder m21834a(View view) {
            this.f20003m = AppAnalytics.m21849a(view);
            return this;
        }
    }

    public static class ToastEventBuilder {
        public String f20004a;
        public String f20005b;

        public final void m21846a() {
            if (TextUtils.isEmpty(this.f20004a)) {
                Timber.e(String.format("Invalid toast event: toast_name(%s)", new Object[]{this.f20004a}), new Object[0]);
            }
            BaseEvent toastEvent = new ToastEvent();
            ToastPayload toastPayload = (ToastPayload) toastEvent.payload;
            toastPayload.toast_name = this.f20004a;
            toastPayload.target_name = this.f20005b;
            AppAnalytics.m21852a(toastEvent);
        }
    }

    public static class SubscribeEventBuilder extends BaseSubscribeEventBuilder {
        public final void mo4571a() {
            BaseEvent subscribeEvent = new SubscribeEvent();
            SubscribePayload subscribePayload = (SubscribePayload) subscribeEvent.payload;
            subscribePayload.sr_name = this.a;
            subscribePayload.base_url = this.b;
            subscribePayload.screen_name = this.c;
            AppAnalytics.m21852a(subscribeEvent);
        }
    }

    public static class UnsubscribeEventBuilder extends BaseSubscribeEventBuilder {
        public final void mo4571a() {
            BaseEvent unsubscribeEvent = new UnsubscribeEvent();
            UnsubscribePayload unsubscribePayload = (UnsubscribePayload) unsubscribeEvent.payload;
            unsubscribePayload.sr_name = this.a;
            unsubscribePayload.base_url = this.b;
            unsubscribePayload.screen_name = this.c;
            AppAnalytics.m21852a(unsubscribeEvent);
        }
    }

    public static ClickEventBuilder m21858b() {
        return new ClickEventBuilder();
    }

    public static ToastEventBuilder m21864c() {
        return new ToastEventBuilder();
    }

    public static FocusListenerBuilder m21867d() {
        return new FocusListenerBuilder();
    }

    public static ShareEventBuilder m21868e() {
        return new ShareEventBuilder();
    }

    public static SubscribeEventBuilder m21869f() {
        return new SubscribeEventBuilder();
    }

    public static UnsubscribeEventBuilder m21870g() {
        return new UnsubscribeEventBuilder();
    }

    public static ControlTabEventBuilder m21871h() {
        return new ControlTabEventBuilder();
    }

    public static ScrollEventBuilder m21872i() {
        return new ScrollEventBuilder();
    }

    public static AlertEventBuilder m21873j() {
        return new AlertEventBuilder();
    }

    public static ScrollEvent m21847a(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            str = m21849a(view);
        }
        return new ScrollEvent(str);
    }

    public static void m21860b(View view, String str) {
        view.setTag(538314769, str);
    }

    public static void m21856a(String str, String str2) {
        AppConfiguration t = FrontpageSettings.a().t();
        if (t.bucketMap == null) {
            t.bucketMap = new HashMap(t.buckets.length);
            Observable.fromArray(t.buckets).blockingForEach(new 0(t));
        }
        Bucket bucket = (Bucket) t.bucketMap.get(str);
        if (bucket != null) {
            BaseEvent bucketExposureEvent = new BucketExposureEvent(str2);
            ((BucketExposurePayload) bucketExposureEvent.payload).experiment_id = bucket.experiment_id;
            ((BucketExposurePayload) bucketExposureEvent.payload).experiment_name = bucket.experiment_name;
            ((BucketExposurePayload) bucketExposureEvent.payload).variant = bucket.variant_name;
            m21852a(bucketExposureEvent);
        }
    }

    public static void m21855a(String str) {
        m21852a(new AdRequestEvent(str));
    }

    public static void m21857a(String str, String str2, String str3) {
        BaseEvent pushNotificationEvent = new PushNotificationEvent();
        ((PushNotificationPayload) pushNotificationEvent.payload).notification_id = str;
        ((PushNotificationPayload) pushNotificationEvent.payload).notification_type = str2;
        ((PushNotificationPayload) pushNotificationEvent.payload).notification_extras = str3;
        m21852a(pushNotificationEvent);
        Puree.a();
    }

    public static void m21863b(String str, String str2, String str3) {
        BaseEvent pushNotificationSuppressedEvent = new PushNotificationSuppressedEvent();
        ((PushNotificationPayload) pushNotificationSuppressedEvent.payload).notification_id = str;
        ((PushNotificationPayload) pushNotificationSuppressedEvent.payload).notification_type = str2;
        ((PushNotificationPayload) pushNotificationSuppressedEvent.payload).notification_extras = str3;
        m21852a(pushNotificationSuppressedEvent);
        Puree.a();
    }

    public static void m21866c(String str, String str2, String str3) {
        BaseEvent notificationClickEvent = new NotificationClickEvent();
        ((NotificationClickPayload) notificationClickEvent.payload).notification_id = str;
        ((NotificationClickPayload) notificationClickEvent.payload).notification_type = str2;
        ((NotificationClickPayload) notificationClickEvent.payload).notification_extras = str3;
        m21852a(notificationClickEvent);
        Puree.a();
    }

    public static void m21862b(String str) {
        BaseEvent newUserPromptEvent = new NewUserPromptEvent();
        ((PromptResponsePayload) newUserPromptEvent.payload).promptResponse = str;
        m21852a(newUserPromptEvent);
    }

    private static void m21851a(Builder builder, PureeOutput pureeOutput, PureeFilter pureeFilter) {
        for (Class a : f20010e) {
            Source source = new Source(builder, Key.a(a));
            source.c.add(pureeFilter);
            Builder builder2 = source.a;
            Key key = source.b;
            List<PureeFilter> list = source.c;
            if (list != null) {
                for (PureeFilter a2 : list) {
                    pureeOutput.a(a2);
                }
            }
            List list2 = (List) builder2.c.get(key);
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.add(pureeOutput);
            builder2.c.put(key, list2);
        }
    }

    private static void m21861b(BasePayload basePayload) {
        if (!SessionManager.b().c.isAnonymous()) {
            basePayload.user_name = SessionManager.b().c.getUsername();
            Account account = (Account) AccountStorage.b.a(basePayload.user_name);
            if (account != null) {
                basePayload.user_id36 = account.getId();
            }
        }
    }

    public static ScheduledFuture<?> m21859b(String str, String str2) {
        if (f20006a == null) {
            f20006a = Executors.newScheduledThreadPool(5);
        }
        return f20006a.scheduleAtFixedRate(new ScreenViewHeartbeatRunnable(str, System.currentTimeMillis(), str2), 30, 30, TimeUnit.SECONDS);
    }

    public static Maybe<BoundedLinkedList<JSONObject>> m21874k() {
        if (f20007b != null) {
            return Maybe.just(f20007b.f27470d);
        }
        return Maybe.just(new BoundedLinkedList());
    }

    public static DummyEventBuilder m21875l() {
        return new DummyEventBuilder();
    }

    public static HeartbeatEventBuilder m21876m() {
        return new HeartbeatEventBuilder();
    }

    public static ScreenviewEventBuilder m21877n() {
        return new ScreenviewEventBuilder();
    }

    @Deprecated
    public static AnalyticsPostType m21848a(int i) {
        switch (i) {
            case 1:
                return AnalyticsPostType.LINK;
            case 2:
                return AnalyticsPostType.TEXT;
            case 3:
            case 4:
                return AnalyticsPostType.IMAGE;
            case 5:
            case 9:
                return AnalyticsPostType.VIDEO;
            case 10:
                return AnalyticsPostType.CROSSPOST;
            default:
                return AnalyticsPostType.UNKNOWN;
        }
    }

    public static Maybe<List<Event>> m21878o() {
        LocalEventDataSource localEventDataSource = f20008c.f27473b;
        if (localEventDataSource == null) {
            Intrinsics.m26844a("localDataSource");
        }
        return localEventDataSource.a();
    }

    public static void m21865c(View view, String str) {
        view.setTag(538380565, str);
    }

    public static ChatEventBuilder m21879p() {
        return new ChatEventBuilder();
    }

    public static ModEventBuilder m21880q() {
        return new ModEventBuilder();
    }

    public static CustomReportEventBuilder m21881r() {
        return new CustomReportEventBuilder();
    }

    public static CommentPerformanceEventBuilder m21882s() {
        return new CommentPerformanceEventBuilder();
    }

    public static ListingPerformanceEventBuilder m21883t() {
        return new ListingPerformanceEventBuilder();
    }

    public static ProfileSettingsEventBuilder m21884u() {
        return new ProfileSettingsEventBuilder();
    }

    public static OutboundLinkEventBuilder m21885v() {
        return new OutboundLinkEventBuilder();
    }

    public static void m21850a() {
        PureeOutput bufferedOutput = new BufferedOutput();
        Builder builder = new Builder(FrontpageApplication.f27402a);
        PureeFilter pureeOldEventsFilter = new PureeOldEventsFilter();
        m21851a(builder, bufferedOutput, pureeOldEventsFilter);
        if (InternalSettings.a().o()) {
            f20007b = new LoggingOutput();
            m21851a(builder, f20007b, pureeOldEventsFilter);
        }
        Puree.a(new PureeConfiguration(builder.a, builder.b, builder.c));
        Context context = FrontpageApplication.f27402a;
        if (GoogleApiAvailability.a().a(context) == 0) {
            FirebaseJobDispatcher firebaseJobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));
            Job.Builder a = firebaseJobDispatcher.a().a(AnalyticsFlushJobService.class);
            a.a = AnalyticsFlushJobService.f27443b;
            a.f = true;
            a.c = 2;
            a.b = Trigger.a(14400, 86400);
            a.e = false;
            a.d = new int[]{4};
            firebaseJobDispatcher.a(a.k());
        }
        f20008c = new ThriftOutput('\u0000');
        f20009d = new FirebaseJobDispatcher(new GooglePlayDriver(FrontpageApplication.f27402a.getApplicationContext()));
        if (GoogleApiAvailability.a().a(FrontpageApplication.f27402a) == 0) {
            a = f20009d.a().a(AnalyticsHeartbeatJobService.class);
            a.a = AnalyticsHeartbeatJobService.class.getSimpleName();
            a.f = true;
            a.c = 2;
            a.b = Trigger.a(30, 30);
            a.e = true;
            a.d = new int[]{2};
            a.k();
        }
        Analytics.a(f20008c);
    }

    public static <T extends BasePayload> void m21852a(BaseEvent<T> baseEvent) {
        if (baseEvent != null) {
            m21861b(baseEvent.payload);
            BasePayload basePayload = baseEvent.payload;
            FrontpageSettings a = FrontpageSettings.a();
            basePayload.compact_view = a.c();
            basePayload.nightmode = a.d();
            Puree.a(baseEvent);
        }
    }

    public static <T extends com.reddit.frontpage.commons.analytics.events.v2.BasePayload> void m21854a(com.reddit.frontpage.commons.analytics.events.v2.BaseEvent<T> baseEvent) {
        com.reddit.frontpage.commons.analytics.events.v2.BasePayload basePayload = baseEvent.payload;
        if (!SessionManager.b().c.isAnonymous()) {
            basePayload.user_name = SessionManager.b().c.getUsername();
            Account account = (Account) AccountStorage.b.a(basePayload.user_name);
            if (account != null) {
                basePayload.user_id36 = account.getId();
            }
        }
        basePayload = baseEvent.payload;
        FrontpageSettings a = FrontpageSettings.a();
        basePayload.compact_view = a.c();
        basePayload.nightmode = a.d();
        Puree.a(baseEvent);
    }

    public static String m21849a(View view) {
        String str = null;
        while (view != null) {
            str = (String) view.getTag(538314769);
            if (str != null) {
                break;
            }
            view = view.getParent() instanceof View ? (View) view.getParent() : null;
        }
        return str;
    }
}
