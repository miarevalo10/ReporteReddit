package com.reddit.datalibrary.frontpage.requests.models.config;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnitExperimentManager;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.Surface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppConfiguration {
    private static final String PROVIDER_DFP = "dfp";
    private AdsConfiguration adsConfiguration;
    public Map<String, Bucket> bucketMap;
    public final Bucket[] buckets;
    public DiscoveryUnitExperimentManager discoveryUnitExperimentManager;
    public final Experiments experiments;
    public final Global global;

    public static class Ads {
        public final boolean active;
        public final String experiment_token;
    }

    public class AdsConfiguration {
        private static final String DEBUG_BASE_AD_UNIT_ID = "/6499/example/native";

        public final boolean m9354a() {
            return (AppConfiguration.this == null || AppConfiguration.this.global == null || AppConfiguration.this.global.ads == null || AppConfiguration.this.global.ads.dfp == null || AppConfiguration.this.global.ads.dfp.ad_interval <= 0 || !AppConfiguration.PROVIDER_DFP.equalsIgnoreCase(AppConfiguration.this.global.ads.provider)) ? false : true;
        }

        public final int m9355b() {
            return m9351d() ? m9352e().ad_position : RedditJobManager.f10810d;
        }

        public final int m9356c() {
            return m9351d() ? m9352e().ad_interval : RedditJobManager.f10810d;
        }

        public final String m9353a(String str) {
            if (!m9351d()) {
                return null;
            }
            String str2 = m9352e().prod_base_id;
            if (str == null) {
                return str2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(str);
            return stringBuilder.toString();
        }

        private boolean m9351d() {
            return m9352e() != null;
        }

        private Dfp m9352e() {
            return (AppConfiguration.this == null || AppConfiguration.this.global == null || AppConfiguration.this.global.ads == null) ? null : AppConfiguration.this.global.ads.dfp;
        }
    }

    public static class AppVersionCheck {
        public final int min_version;
        public final String popup_content;
        public final String update_url;
    }

    public static class Assets {
        public final Categories categories;
        public final String experiment_token;
    }

    public static class BasicExperiment {
        public final boolean active;
        public final String experiment_token;

        private BasicExperiment(boolean z, String str) {
            this.active = z;
            this.experiment_token = str;
        }
    }

    public static class BestOfCommunity {
        public static final String NAME = "best_of_community_carousel_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class Bucket {
        public final int experiment_id;
        public final String experiment_name;
        public final String variant_name;
    }

    public static class Categories {
        public final String etag;
        public final Long size;
        public final String url;
    }

    public static class ContentType {
        public final Map<String, String> image_type;
        public final Map<String, String> image_type_exception;
        public final Map<String, String> link_type;
        public final Map<String, String> link_type_exception;
        public final Map<String, String> video_type;
        public final Map<String, String> video_type_exception;
    }

    public static class Dfp {
        public final int ad_interval;
        public final int ad_position;
        public final String debug_base_id;
        public final String prod_base_id;
    }

    public static class DiscoveryUnits {
        public final List<Surface> discovery_surfaces;
        public final List<DiscoveryUnit> discovery_units;
    }

    public static class DomainName {
        public final Map<String, String> domain_aliases;
        public final String experiment_token;
    }

    public static class Experiments {
        private final Ads ads;
        private final Onboarding android_onboarding_v2;
        public final Assets assets;
        public BestOfCommunity best_of_community_carousel_android;
        public final ContentType content_type;
        public final DomainName domain_name;
        public RateOrShare enjoy_reddit_toast;
        public FavoriteSubreddits favorite_subreddits_carousel_android;
        public FreshContentPill fresh_content_pill;
        public final IngestionRollout ingested_gif_playback;
        private final LiveCommentsRollout live_comments_rollout;
        public LoginEnhancements login_enhancements;
        public MvpHomePageAndroid mvp_homepage_android;
        private NativeLive native_live_rollout;
        public NewInSubscriptions new_in_your_subscriptions_carousel_android;
        public final NewUserAlert new_user_alert;
        public PerformanceAnalyticsAndroid performance_analytics_android;
        public final PushNotification push_notification;
        public RecentlyVisited recently_visited_carousel_android;
        public RecommendedLinks recommended_posts_carousel_android;
        public SharePiggyback share_copy_link;
        public UpvoteShimmer share_shimmer;
        public SubredditRecommendations subreddit_recommendation_android;
        public LoggedOutInbox trending_pn_logged_out;
        public TrendingUsers trending_users_carousel_android;
        public ShareOnUpvote upvote_toast;

        public final NativeLive m9358a() {
            if (this.native_live_rollout == null) {
                this.native_live_rollout = NativeLive.m9361a();
            }
            return this.native_live_rollout;
        }

        public final Onboarding m9359b() {
            return this.android_onboarding_v2 != null ? this.android_onboarding_v2 : Onboarding.m16407a();
        }
    }

    public static class FavoriteSubreddits {
        public static final String NAME = "favorite_subreddits_carousel_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class FeaturedCarousel {
        public final boolean active;
    }

    public static class Global {
        public final GlobalAds ads = null;
        public final AppVersionCheck app_version_check = null;
        public final DiscoveryUnits discovery_config_v1 = null;
        public final InfoUrl info_url = null;
        public final PerformanceAnalyticsEvents performance_analytics_events = null;
        public final PushNotificationPrefs push_notifications = null;
        public final Upload upload = null;
    }

    public static class GlobalAds {
        public final Dfp dfp;
        public final String provider;
    }

    public static class InfoUrl {
        public final String acknowledgements;
        public final String content_policy;
        public final String privacy_policy;
        public final String user_agreement;
    }

    public static class LiveCommentsRollout {
        public final boolean active;
    }

    public static class LoginEnhancements {
        public final String experiment_token = null;
        public final boolean show_fb = false;
        public final boolean show_google = false;
        public final boolean show_skip = true;

        private LoginEnhancements() {
        }

        public static LoginEnhancements m9360a() {
            return new LoginEnhancements();
        }
    }

    public static class MainfeedCarousel {
        public final boolean active;
    }

    public static class MvpHomePageAndroid {
        public static final String NAME = "mvp_homepage_android";
        public final boolean active_frontpage_listing;
        public final boolean active_popular_listing;
        public final String experiment_token;
    }

    public static class NativeLive {
        public final boolean active = true;
        public final String experiment_token = null;

        private NativeLive() {
        }

        static NativeLive m9361a() {
            return new NativeLive();
        }
    }

    public static class NewInSubscriptions {
        public static final String NAME = "new_in_your_subscriptions_carousel_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class NewUserAlert {
        public final boolean active;
    }

    public static class PerformanceAnalyticsAndroid {
        public static final String NAME = "performance_analytics_android";
        public final boolean active_performance_analytics_comments;
        public final boolean active_performance_analytics_listings;
        public final String experiment_token;
    }

    public static class PerformanceAnalyticsEvents {
        public final boolean active;
    }

    public static class PushNotification {
        public final int cadence;
        public final String experiment_token;
    }

    public static class PushNotificationPrefs {
        public final String preferences_url;
    }

    public static class RecentlyVisited {
        public static final String NAME = "recently_visited_carousel_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class RecommendedLinks {
        public static final String NAME = "recommended_posts_carousel_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class SubredditRecommendations {
        public static final String NAME = "subreddit_recommendation_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class TrendingUsers {
        public static final String NAME = "trending_users_carousel_android";
        public final List<DiscoveryUnit> discovery_units;
        public final String experiment_token;
    }

    public static class Upload {
        public final boolean active;
        public final boolean add_reddit_token;
        public final String client_id;
        public final String disclaimer;
        public final String image_url;
    }

    private static class BasicCopyLinkExperiment extends BasicExperiment {
        public final String copy;
        public final String link;

        private BasicCopyLinkExperiment(boolean z, String str, String str2, String str3) {
            super(z, str3);
            this.copy = str;
            this.link = str2;
        }
    }

    public static class FreshContentPill extends BasicExperiment {
        public static final long FREQUENCY = 30;
        public static final String NAME = "fresh_content_pill";
    }

    public static class IngestionRollout extends BasicExperiment {
        public static final String NAME = "ingested_gif_playback";
    }

    public static class LoggedOutInbox extends BasicExperiment {
        public static final String NAME = "trending_pn_logged_out";
    }

    public static class Onboarding extends BasicExperiment {
        public static final String NAME = "android_onboarding_v2";

        private Onboarding() {
            super(false, null);
        }

        public static Onboarding m16407a() {
            return new Onboarding();
        }
    }

    public static class UpvoteShimmer extends BasicExperiment {
        public UpvoteShimmer(boolean z, String str) {
            super(z, str);
        }
    }

    public static class RateOrShare extends BasicCopyLinkExperiment {
        public RateOrShare(boolean z, String str, String str2, String str3) {
            super(z, str, str2, str3);
        }
    }

    public static class ShareOnUpvote extends BasicCopyLinkExperiment {
        public final int frequency = true;
        public final String link_copy;

        public ShareOnUpvote(boolean z, String str, String str2, String str3, String str4) {
            super(z, str, str2, str3);
            this.link_copy = str4;
        }
    }

    public static class SharePiggyback extends BasicCopyLinkExperiment {
        public SharePiggyback(boolean z, String str, String str2, String str3) {
            super(z, str, str2, str3);
        }
    }

    public final AdsConfiguration m9367a() {
        if (this.adsConfiguration == null) {
            this.adsConfiguration = new AdsConfiguration();
        }
        return this.adsConfiguration;
    }

    public final boolean m9369b() {
        String username = SessionManager.m9191b().f10840c.getUsername();
        InternalSettings a = InternalSettings.m9061a();
        if (!FrontpageSettings.m9011a().m9051l(username)) {
            if (!a.m9084o()) {
                if (this.experiments != null) {
                    if (this.experiments.live_comments_rollout != null) {
                        return this.experiments.live_comments_rollout.active;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean m9370c() {
        if (InternalSettings.m9061a().m9084o()) {
            return true;
        }
        if (this.experiments == null || this.experiments.ingested_gif_playback == null || !this.experiments.ingested_gif_playback.active) {
            return false;
        }
        return true;
    }

    public final boolean m9371d() {
        if (this.experiments != null) {
            if (this.experiments.share_shimmer != null) {
                return this.experiments.share_shimmer.active;
            }
        }
        return false;
    }

    public final boolean m9372e() {
        if (this.experiments != null) {
            if (this.experiments.enjoy_reddit_toast != null) {
                return this.experiments.enjoy_reddit_toast.active;
            }
        }
        return false;
    }

    public final boolean m9373f() {
        if (this.experiments != null) {
            if (this.experiments.upvote_toast != null) {
                return this.experiments.upvote_toast.active;
            }
        }
        return false;
    }

    public final boolean m9374g() {
        if (this.experiments != null) {
            if (this.experiments.share_copy_link != null) {
                return this.experiments.share_copy_link.active;
            }
        }
        return false;
    }

    public final boolean m9375h() {
        return this.global.performance_analytics_events != null ? this.global.performance_analytics_events.active : false;
    }

    public final boolean m9376i() {
        return !m9368a(AppConfiguration$$Lambda$1.$instance) && this.experiments.mvp_homepage_android.active_frontpage_listing;
    }

    public final boolean m9377j() {
        return !m9368a(AppConfiguration$$Lambda$2.$instance) && this.experiments.mvp_homepage_android.active_popular_listing;
    }

    public final boolean m9378k() {
        return !m9368a(AppConfiguration$$Lambda$4.$instance) && this.experiments.performance_analytics_android.active_performance_analytics_comments;
    }

    public final boolean m9379l() {
        return !m9368a(AppConfiguration$$Lambda$5.$instance) && this.experiments.performance_analytics_android.active_performance_analytics_listings;
    }

    public final boolean m9368a(Function<Experiments, Object> function) {
        if (this.experiments != null) {
            if (function.apply(this.experiments) != null) {
                return null;
            }
        }
        return true;
    }

    public final List<DiscoveryUnit> m9380m() {
        if (this.global.discovery_config_v1 != null) {
            if (this.global.discovery_config_v1.discovery_units != null) {
                return this.global.discovery_config_v1.discovery_units;
            }
        }
        return new ArrayList();
    }
}
