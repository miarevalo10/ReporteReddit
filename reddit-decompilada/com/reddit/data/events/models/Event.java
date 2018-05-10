package com.reddit.data.events.models;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import com.reddit.data.events.models.components.ActionInfo;
import com.reddit.data.events.models.components.Admin;
import com.reddit.data.events.models.components.Api;
import com.reddit.data.events.models.components.ApiResponse;
import com.reddit.data.events.models.components.App;
import com.reddit.data.events.models.components.Chat;
import com.reddit.data.events.models.components.Comment;
import com.reddit.data.events.models.components.CommentComposer;
import com.reddit.data.events.models.components.ContentMetadata;
import com.reddit.data.events.models.components.DOMTimers;
import com.reddit.data.events.models.components.DiscoveryUnit;
import com.reddit.data.events.models.components.Expand;
import com.reddit.data.events.models.components.Experiment;
import com.reddit.data.events.models.components.Geo;
import com.reddit.data.events.models.components.GoldPurchase;
import com.reddit.data.events.models.components.Inferred;
import com.reddit.data.events.models.components.LinkSharing;
import com.reddit.data.events.models.components.Listing;
import com.reddit.data.events.models.components.MailroomRequest;
import com.reddit.data.events.models.components.Media;
import com.reddit.data.events.models.components.Message;
import com.reddit.data.events.models.components.News;
import com.reddit.data.events.models.components.Notification;
import com.reddit.data.events.models.components.NotificationRequest;
import com.reddit.data.events.models.components.Oauth;
import com.reddit.data.events.models.components.Onboarding;
import com.reddit.data.events.models.components.Outbound;
import com.reddit.data.events.models.components.Payment;
import com.reddit.data.events.models.components.Platform;
import com.reddit.data.events.models.components.Post;
import com.reddit.data.events.models.components.PostComposer;
import com.reddit.data.events.models.components.Profile;
import com.reddit.data.events.models.components.Referrer;
import com.reddit.data.events.models.components.Request;
import com.reddit.data.events.models.components.Screen;
import com.reddit.data.events.models.components.Search;
import com.reddit.data.events.models.components.Session;
import com.reddit.data.events.models.components.Share;
import com.reddit.data.events.models.components.Subreddit;
import com.reddit.data.events.models.components.Ticket;
import com.reddit.data.events.models.components.Timer;
import com.reddit.data.events.models.components.TwoFactorAuth;
import com.reddit.data.events.models.components.UrlParsed;
import com.reddit.data.events.models.components.User;
import com.reddit.data.events.models.components.UserPreferences;
import com.reddit.data.events.models.components.UserSubreddit;
import com.reddit.data.events.models.components.Widget;
import java.io.IOException;

public final class Event {
    public static final Adapter<Event, Builder> ADAPTER = new EventAdapter();
    public final String action;
    public final ActionInfo action_info;
    public final Admin admin;
    public final Api api;
    public final ApiResponse api_response;
    public final App app;
    public final Chat chat;
    public final Long client_timestamp;
    public final Comment comment;
    public final CommentComposer comment_composer;
    public final ContentMetadata content_metadata;
    public final String correlation_id;
    public final Long create_request_timestamp;
    public final DiscoveryUnit discovery_unit;
    public final DOMTimers dom_timer;
    public final Long endpoint_timestamp;
    public final Expand expand;
    public final Experiment experiment;
    public final Geo geo;
    public final GoldPurchase gold_purchase;
    public final Inferred inferred;
    public final LinkSharing link_sharing;
    public final Listing listing;
    public final MailroomRequest mailroom_request;
    public final Media media;
    public final Message message;
    public final News news;
    public final Notification notification;
    public final NotificationRequest notification_request;
    public final String noun;
    public final Oauth oauth;
    public final Onboarding onboarding;
    public final Outbound outbound;
    public final Payment payment;
    public final Platform platform;
    public final Post post;
    public final PostComposer post_composer;
    public final Profile profile;
    public final Referrer referrer;
    public final Request request;
    public final Screen screen;
    public final Search search;
    public final Session session;
    public final Share share;
    public final String source;
    public final Subreddit subreddit;
    public final TwoFactorAuth tfa;
    public final Ticket ticket;
    public final Timer timer;
    public final UrlParsed url_parsed;
    public final User user;
    public final String user_legacy_id;
    public final UserPreferences user_preferences;
    public final UserSubreddit user_subreddit;
    public final Double utc_offset;
    public final String uuid;
    public final Widget widget;

    public static final class Builder implements StructBuilder<Event> {
        private String action;
        private ActionInfo action_info;
        private Admin admin;
        private Api api;
        private ApiResponse api_response;
        private App app;
        private Chat chat;
        private Long client_timestamp;
        private Comment comment;
        private CommentComposer comment_composer;
        private ContentMetadata content_metadata;
        private String correlation_id;
        private Long create_request_timestamp;
        private DiscoveryUnit discovery_unit;
        private DOMTimers dom_timer;
        private Long endpoint_timestamp;
        private Expand expand;
        private Experiment experiment;
        private Geo geo;
        private GoldPurchase gold_purchase;
        private Inferred inferred;
        private LinkSharing link_sharing;
        private Listing listing;
        private MailroomRequest mailroom_request;
        private Media media;
        private Message message;
        private News news;
        private Notification notification;
        private NotificationRequest notification_request;
        private String noun;
        private Oauth oauth;
        private Onboarding onboarding;
        private Outbound outbound;
        private Payment payment;
        private Platform platform;
        private Post post;
        private PostComposer post_composer;
        private Profile profile;
        private Referrer referrer;
        private Request request;
        private Screen screen;
        private Search search;
        private Session session;
        private Share share;
        private String source;
        private Subreddit subreddit;
        private TwoFactorAuth tfa;
        private Ticket ticket;
        private Timer timer;
        private UrlParsed url_parsed;
        private User user;
        private String user_legacy_id;
        private UserPreferences user_preferences;
        private UserSubreddit user_subreddit;
        private Double utc_offset;
        private String uuid;
        private Widget widget;

        public Builder(Event event) {
            this.source = event.source;
            this.action = event.action;
            this.noun = event.noun;
            this.endpoint_timestamp = event.endpoint_timestamp;
            this.client_timestamp = event.client_timestamp;
            this.uuid = event.uuid;
            this.utc_offset = event.utc_offset;
            this.correlation_id = event.correlation_id;
            this.post = event.post;
            this.listing = event.listing;
            this.comment = event.comment;
            this.notification = event.notification;
            this.oauth = event.oauth;
            this.screen = event.screen;
            this.app = event.app;
            this.platform = event.platform;
            this.request = event.request;
            this.referrer = event.referrer;
            this.dom_timer = event.dom_timer;
            this.user = event.user;
            this.user_preferences = event.user_preferences;
            this.subreddit = event.subreddit;
            this.session = event.session;
            this.action_info = event.action_info;
            this.expand = event.expand;
            this.media = event.media;
            this.chat = event.chat;
            this.post_composer = event.post_composer;
            this.widget = event.widget;
            this.profile = event.profile;
            this.onboarding = event.onboarding;
            this.timer = event.timer;
            this.tfa = event.tfa;
            this.api_response = event.api_response;
            this.api = event.api;
            this.discovery_unit = event.discovery_unit;
            this.experiment = event.experiment;
            this.share = event.share;
            this.user_subreddit = event.user_subreddit;
            this.notification_request = event.notification_request;
            this.search = event.search;
            this.message = event.message;
            this.admin = event.admin;
            this.ticket = event.ticket;
            this.mailroom_request = event.mailroom_request;
            this.comment_composer = event.comment_composer;
            this.gold_purchase = event.gold_purchase;
            this.payment = event.payment;
            this.news = event.news;
            this.outbound = event.outbound;
            this.geo = event.geo;
            this.user_legacy_id = event.user_legacy_id;
            this.content_metadata = event.content_metadata;
            this.url_parsed = event.url_parsed;
            this.link_sharing = event.link_sharing;
            this.create_request_timestamp = event.create_request_timestamp;
            this.inferred = event.inferred;
        }

        public final Builder source(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'source' cannot be null");
            }
            this.source = str;
            return this;
        }

        public final Builder action(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'action' cannot be null");
            }
            this.action = str;
            return this;
        }

        public final Builder noun(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'noun' cannot be null");
            }
            this.noun = str;
            return this;
        }

        public final Builder endpoint_timestamp(Long l) {
            this.endpoint_timestamp = l;
            return this;
        }

        public final Builder client_timestamp(Long l) {
            if (l == null) {
                throw new NullPointerException("Required field 'client_timestamp' cannot be null");
            }
            this.client_timestamp = l;
            return this;
        }

        public final Builder uuid(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'uuid' cannot be null");
            }
            this.uuid = str;
            return this;
        }

        public final Builder utc_offset(Double d) {
            this.utc_offset = d;
            return this;
        }

        public final Builder correlation_id(String str) {
            this.correlation_id = str;
            return this;
        }

        public final Builder post(Post post) {
            this.post = post;
            return this;
        }

        public final Builder listing(Listing listing) {
            this.listing = listing;
            return this;
        }

        public final Builder comment(Comment comment) {
            this.comment = comment;
            return this;
        }

        public final Builder notification(Notification notification) {
            this.notification = notification;
            return this;
        }

        public final Builder oauth(Oauth oauth) {
            this.oauth = oauth;
            return this;
        }

        public final Builder screen(Screen screen) {
            this.screen = screen;
            return this;
        }

        public final Builder app(App app) {
            this.app = app;
            return this;
        }

        public final Builder platform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public final Builder request(Request request) {
            this.request = request;
            return this;
        }

        public final Builder referrer(Referrer referrer) {
            this.referrer = referrer;
            return this;
        }

        public final Builder dom_timer(DOMTimers dOMTimers) {
            this.dom_timer = dOMTimers;
            return this;
        }

        public final Builder user(User user) {
            this.user = user;
            return this;
        }

        public final Builder user_preferences(UserPreferences userPreferences) {
            this.user_preferences = userPreferences;
            return this;
        }

        public final Builder subreddit(Subreddit subreddit) {
            this.subreddit = subreddit;
            return this;
        }

        public final Builder session(Session session) {
            this.session = session;
            return this;
        }

        public final Builder action_info(ActionInfo actionInfo) {
            this.action_info = actionInfo;
            return this;
        }

        public final Builder expand(Expand expand) {
            this.expand = expand;
            return this;
        }

        public final Builder media(Media media) {
            this.media = media;
            return this;
        }

        public final Builder chat(Chat chat) {
            this.chat = chat;
            return this;
        }

        public final Builder post_composer(PostComposer postComposer) {
            this.post_composer = postComposer;
            return this;
        }

        public final Builder widget(Widget widget) {
            this.widget = widget;
            return this;
        }

        public final Builder profile(Profile profile) {
            this.profile = profile;
            return this;
        }

        public final Builder onboarding(Onboarding onboarding) {
            this.onboarding = onboarding;
            return this;
        }

        public final Builder timer(Timer timer) {
            this.timer = timer;
            return this;
        }

        public final Builder tfa(TwoFactorAuth twoFactorAuth) {
            this.tfa = twoFactorAuth;
            return this;
        }

        public final Builder api_response(ApiResponse apiResponse) {
            this.api_response = apiResponse;
            return this;
        }

        public final Builder api(Api api) {
            this.api = api;
            return this;
        }

        public final Builder discovery_unit(DiscoveryUnit discoveryUnit) {
            this.discovery_unit = discoveryUnit;
            return this;
        }

        public final Builder experiment(Experiment experiment) {
            this.experiment = experiment;
            return this;
        }

        public final Builder share(Share share) {
            this.share = share;
            return this;
        }

        public final Builder user_subreddit(UserSubreddit userSubreddit) {
            this.user_subreddit = userSubreddit;
            return this;
        }

        public final Builder notification_request(NotificationRequest notificationRequest) {
            this.notification_request = notificationRequest;
            return this;
        }

        public final Builder search(Search search) {
            this.search = search;
            return this;
        }

        public final Builder message(Message message) {
            this.message = message;
            return this;
        }

        public final Builder admin(Admin admin) {
            this.admin = admin;
            return this;
        }

        public final Builder ticket(Ticket ticket) {
            this.ticket = ticket;
            return this;
        }

        public final Builder mailroom_request(MailroomRequest mailroomRequest) {
            this.mailroom_request = mailroomRequest;
            return this;
        }

        public final Builder comment_composer(CommentComposer commentComposer) {
            this.comment_composer = commentComposer;
            return this;
        }

        public final Builder gold_purchase(GoldPurchase goldPurchase) {
            this.gold_purchase = goldPurchase;
            return this;
        }

        public final Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public final Builder news(News news) {
            this.news = news;
            return this;
        }

        public final Builder outbound(Outbound outbound) {
            this.outbound = outbound;
            return this;
        }

        public final Builder geo(Geo geo) {
            this.geo = geo;
            return this;
        }

        public final Builder user_legacy_id(String str) {
            this.user_legacy_id = str;
            return this;
        }

        public final Builder content_metadata(ContentMetadata contentMetadata) {
            this.content_metadata = contentMetadata;
            return this;
        }

        public final Builder url_parsed(UrlParsed urlParsed) {
            this.url_parsed = urlParsed;
            return this;
        }

        public final Builder link_sharing(LinkSharing linkSharing) {
            this.link_sharing = linkSharing;
            return this;
        }

        public final Builder create_request_timestamp(Long l) {
            this.create_request_timestamp = l;
            return this;
        }

        public final Builder inferred(Inferred inferred) {
            this.inferred = inferred;
            return this;
        }

        public final Event build() {
            if (this.source == null) {
                throw new IllegalStateException("Required field 'source' is missing");
            } else if (this.action == null) {
                throw new IllegalStateException("Required field 'action' is missing");
            } else if (this.noun == null) {
                throw new IllegalStateException("Required field 'noun' is missing");
            } else if (this.client_timestamp == null) {
                throw new IllegalStateException("Required field 'client_timestamp' is missing");
            } else if (this.uuid != null) {
                return new Event();
            } else {
                throw new IllegalStateException("Required field 'uuid' is missing");
            }
        }

        public final void reset() {
            this.source = null;
            this.action = null;
            this.noun = null;
            this.endpoint_timestamp = null;
            this.client_timestamp = null;
            this.uuid = null;
            this.utc_offset = null;
            this.correlation_id = null;
            this.post = null;
            this.listing = null;
            this.comment = null;
            this.notification = null;
            this.oauth = null;
            this.screen = null;
            this.app = null;
            this.platform = null;
            this.request = null;
            this.referrer = null;
            this.dom_timer = null;
            this.user = null;
            this.user_preferences = null;
            this.subreddit = null;
            this.session = null;
            this.action_info = null;
            this.expand = null;
            this.media = null;
            this.chat = null;
            this.post_composer = null;
            this.widget = null;
            this.profile = null;
            this.onboarding = null;
            this.timer = null;
            this.tfa = null;
            this.api_response = null;
            this.api = null;
            this.discovery_unit = null;
            this.experiment = null;
            this.share = null;
            this.user_subreddit = null;
            this.notification_request = null;
            this.search = null;
            this.message = null;
            this.admin = null;
            this.ticket = null;
            this.mailroom_request = null;
            this.comment_composer = null;
            this.gold_purchase = null;
            this.payment = null;
            this.news = null;
            this.outbound = null;
            this.geo = null;
            this.user_legacy_id = null;
            this.content_metadata = null;
            this.url_parsed = null;
            this.link_sharing = null;
            this.create_request_timestamp = null;
            this.inferred = null;
        }
    }

    private static final class EventAdapter implements Adapter<Event, Builder> {
        private EventAdapter() {
        }

        public final void write(Protocol protocol, Event event) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(event.source);
            protocol.mo2638a(2, (byte) 11);
            protocol.mo2640a(event.action);
            protocol.mo2638a(3, (byte) 11);
            protocol.mo2640a(event.noun);
            if (event.endpoint_timestamp != null) {
                protocol.mo2638a(4, (byte) 10);
                protocol.mo2639a(event.endpoint_timestamp.longValue());
            }
            protocol.mo2638a(5, (byte) 10);
            protocol.mo2639a(event.client_timestamp.longValue());
            protocol.mo2638a(6, (byte) 11);
            protocol.mo2640a(event.uuid);
            if (event.utc_offset != null) {
                protocol.mo2638a(7, (byte) 4);
                protocol.mo2636a(event.utc_offset.doubleValue());
            }
            if (event.correlation_id != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(event.correlation_id);
            }
            if (event.post != null) {
                protocol.mo2638a(100, (byte) 12);
                Post.ADAPTER.write(protocol, event.post);
            }
            if (event.listing != null) {
                protocol.mo2638a(101, (byte) 12);
                Listing.ADAPTER.write(protocol, event.listing);
            }
            if (event.comment != null) {
                protocol.mo2638a(102, (byte) 12);
                Comment.ADAPTER.write(protocol, event.comment);
            }
            if (event.notification != null) {
                protocol.mo2638a(103, (byte) 12);
                Notification.ADAPTER.write(protocol, event.notification);
            }
            if (event.oauth != null) {
                protocol.mo2638a(104, (byte) 12);
                Oauth.ADAPTER.write(protocol, event.oauth);
            }
            if (event.screen != null) {
                protocol.mo2638a(106, (byte) 12);
                Screen.ADAPTER.write(protocol, event.screen);
            }
            if (event.app != null) {
                protocol.mo2638a(107, (byte) 12);
                App.ADAPTER.write(protocol, event.app);
            }
            if (event.platform != null) {
                protocol.mo2638a(108, (byte) 12);
                Platform.ADAPTER.write(protocol, event.platform);
            }
            if (event.request != null) {
                protocol.mo2638a(109, (byte) 12);
                Request.ADAPTER.write(protocol, event.request);
            }
            if (event.referrer != null) {
                protocol.mo2638a(110, (byte) 12);
                Referrer.ADAPTER.write(protocol, event.referrer);
            }
            if (event.dom_timer != null) {
                protocol.mo2638a(111, (byte) 12);
                DOMTimers.ADAPTER.write(protocol, event.dom_timer);
            }
            if (event.user != null) {
                protocol.mo2638a(112, (byte) 12);
                User.ADAPTER.write(protocol, event.user);
            }
            if (event.user_preferences != null) {
                protocol.mo2638a(113, (byte) 12);
                UserPreferences.ADAPTER.write(protocol, event.user_preferences);
            }
            if (event.subreddit != null) {
                protocol.mo2638a(114, (byte) 12);
                Subreddit.ADAPTER.write(protocol, event.subreddit);
            }
            if (event.session != null) {
                protocol.mo2638a(115, (byte) 12);
                Session.ADAPTER.write(protocol, event.session);
            }
            if (event.action_info != null) {
                protocol.mo2638a(116, (byte) 12);
                ActionInfo.ADAPTER.write(protocol, event.action_info);
            }
            if (event.expand != null) {
                protocol.mo2638a(117, (byte) 12);
                Expand.ADAPTER.write(protocol, event.expand);
            }
            if (event.media != null) {
                protocol.mo2638a(118, (byte) 12);
                Media.ADAPTER.write(protocol, event.media);
            }
            if (event.chat != null) {
                protocol.mo2638a(119, (byte) 12);
                Chat.ADAPTER.write(protocol, event.chat);
            }
            if (event.post_composer != null) {
                protocol.mo2638a(120, (byte) 12);
                PostComposer.ADAPTER.write(protocol, event.post_composer);
            }
            if (event.widget != null) {
                protocol.mo2638a(121, (byte) 12);
                Widget.ADAPTER.write(protocol, event.widget);
            }
            if (event.profile != null) {
                protocol.mo2638a(122, (byte) 12);
                Profile.ADAPTER.write(protocol, event.profile);
            }
            if (event.onboarding != null) {
                protocol.mo2638a(123, (byte) 12);
                Onboarding.ADAPTER.write(protocol, event.onboarding);
            }
            if (event.timer != null) {
                protocol.mo2638a(124, (byte) 12);
                Timer.ADAPTER.write(protocol, event.timer);
            }
            if (event.tfa != null) {
                protocol.mo2638a(125, (byte) 12);
                TwoFactorAuth.ADAPTER.write(protocol, event.tfa);
            }
            if (event.api_response != null) {
                protocol.mo2638a(126, (byte) 12);
                ApiResponse.ADAPTER.write(protocol, event.api_response);
            }
            if (event.api != null) {
                protocol.mo2638a(127, (byte) 12);
                Api.ADAPTER.write(protocol, event.api);
            }
            if (event.discovery_unit != null) {
                protocol.mo2638a(128, (byte) 12);
                DiscoveryUnit.ADAPTER.write(protocol, event.discovery_unit);
            }
            if (event.experiment != null) {
                protocol.mo2638a(129, (byte) 12);
                Experiment.ADAPTER.write(protocol, event.experiment);
            }
            if (event.share != null) {
                protocol.mo2638a(130, (byte) 12);
                Share.ADAPTER.write(protocol, event.share);
            }
            if (event.user_subreddit != null) {
                protocol.mo2638a(131, (byte) 12);
                UserSubreddit.ADAPTER.write(protocol, event.user_subreddit);
            }
            if (event.notification_request != null) {
                protocol.mo2638a(132, (byte) 12);
                NotificationRequest.ADAPTER.write(protocol, event.notification_request);
            }
            if (event.search != null) {
                protocol.mo2638a(133, (byte) 12);
                Search.ADAPTER.write(protocol, event.search);
            }
            if (event.message != null) {
                protocol.mo2638a(134, (byte) 12);
                Message.ADAPTER.write(protocol, event.message);
            }
            if (event.admin != null) {
                protocol.mo2638a(135, (byte) 12);
                Admin.ADAPTER.write(protocol, event.admin);
            }
            if (event.ticket != null) {
                protocol.mo2638a(136, (byte) 12);
                Ticket.ADAPTER.write(protocol, event.ticket);
            }
            if (event.mailroom_request != null) {
                protocol.mo2638a(137, (byte) 12);
                MailroomRequest.ADAPTER.write(protocol, event.mailroom_request);
            }
            if (event.comment_composer != null) {
                protocol.mo2638a(138, (byte) 12);
                CommentComposer.ADAPTER.write(protocol, event.comment_composer);
            }
            if (event.gold_purchase != null) {
                protocol.mo2638a(139, (byte) 12);
                GoldPurchase.ADAPTER.write(protocol, event.gold_purchase);
            }
            if (event.payment != null) {
                protocol.mo2638a(140, (byte) 12);
                Payment.ADAPTER.write(protocol, event.payment);
            }
            if (event.news != null) {
                protocol.mo2638a(141, (byte) 12);
                News.ADAPTER.write(protocol, event.news);
            }
            if (event.outbound != null) {
                protocol.mo2638a(142, (byte) 12);
                Outbound.ADAPTER.write(protocol, event.outbound);
            }
            if (event.geo != null) {
                protocol.mo2638a(500, (byte) 12);
                Geo.ADAPTER.write(protocol, event.geo);
            }
            if (event.user_legacy_id != null) {
                protocol.mo2638a(502, (byte) 11);
                protocol.mo2640a(event.user_legacy_id);
            }
            if (event.content_metadata != null) {
                protocol.mo2638a(503, (byte) 12);
                ContentMetadata.ADAPTER.write(protocol, event.content_metadata);
            }
            if (event.url_parsed != null) {
                protocol.mo2638a(504, (byte) 12);
                UrlParsed.ADAPTER.write(protocol, event.url_parsed);
            }
            if (event.link_sharing != null) {
                protocol.mo2638a(505, (byte) 12);
                LinkSharing.ADAPTER.write(protocol, event.link_sharing);
            }
            if (event.create_request_timestamp != null) {
                protocol.mo2638a(506, (byte) 10);
                protocol.mo2639a(event.create_request_timestamp.longValue());
            }
            if (event.inferred != null) {
                protocol.mo2638a(507, (byte) 12);
                Inferred.ADAPTER.write(protocol, event.inferred);
            }
            protocol.mo2634a();
        }

        public final Event read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                short s = b.f10037c;
                if (s != (short) 500) {
                    switch (s) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.source(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.action(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.noun(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.endpoint_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.client_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.uuid(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 4) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.utc_offset(Double.valueOf(protocol.mo2651k()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.correlation_id(protocol.mo2652l());
                            break;
                        default:
                            switch (s) {
                                case (short) 100:
                                    if (b.f10036b != (byte) 12) {
                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                        break;
                                    }
                                    builder.post((Post) Post.ADAPTER.read(protocol));
                                    break;
                                case (short) 101:
                                    if (b.f10036b != (byte) 12) {
                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                        break;
                                    }
                                    builder.listing((Listing) Listing.ADAPTER.read(protocol));
                                    break;
                                case (short) 102:
                                    if (b.f10036b != (byte) 12) {
                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                        break;
                                    }
                                    builder.comment((Comment) Comment.ADAPTER.read(protocol));
                                    break;
                                case (short) 103:
                                    if (b.f10036b != (byte) 12) {
                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                        break;
                                    }
                                    builder.notification((Notification) Notification.ADAPTER.read(protocol));
                                    break;
                                case (short) 104:
                                    if (b.f10036b != (byte) 12) {
                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                        break;
                                    }
                                    builder.oauth((Oauth) Oauth.ADAPTER.read(protocol));
                                    break;
                                default:
                                    switch (s) {
                                        case (short) 106:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.screen((Screen) Screen.ADAPTER.read(protocol));
                                            break;
                                        case (short) 107:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.app((App) App.ADAPTER.read(protocol));
                                            break;
                                        case (short) 108:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.platform((Platform) Platform.ADAPTER.read(protocol));
                                            break;
                                        case (short) 109:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.request((Request) Request.ADAPTER.read(protocol));
                                            break;
                                        case (short) 110:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.referrer((Referrer) Referrer.ADAPTER.read(protocol));
                                            break;
                                        case (short) 111:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.dom_timer((DOMTimers) DOMTimers.ADAPTER.read(protocol));
                                            break;
                                        case (short) 112:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.user((User) User.ADAPTER.read(protocol));
                                            break;
                                        case (short) 113:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.user_preferences((UserPreferences) UserPreferences.ADAPTER.read(protocol));
                                            break;
                                        case (short) 114:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.subreddit((Subreddit) Subreddit.ADAPTER.read(protocol));
                                            break;
                                        case (short) 115:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.session((Session) Session.ADAPTER.read(protocol));
                                            break;
                                        case (short) 116:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.action_info((ActionInfo) ActionInfo.ADAPTER.read(protocol));
                                            break;
                                        case (short) 117:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.expand((Expand) Expand.ADAPTER.read(protocol));
                                            break;
                                        case (short) 118:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.media((Media) Media.ADAPTER.read(protocol));
                                            break;
                                        case (short) 119:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.chat((Chat) Chat.ADAPTER.read(protocol));
                                            break;
                                        case (short) 120:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.post_composer((PostComposer) PostComposer.ADAPTER.read(protocol));
                                            break;
                                        case (short) 121:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.widget((Widget) Widget.ADAPTER.read(protocol));
                                            break;
                                        case (short) 122:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.profile((Profile) Profile.ADAPTER.read(protocol));
                                            break;
                                        case (short) 123:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.onboarding((Onboarding) Onboarding.ADAPTER.read(protocol));
                                            break;
                                        case (short) 124:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.timer((Timer) Timer.ADAPTER.read(protocol));
                                            break;
                                        case (short) 125:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.tfa((TwoFactorAuth) TwoFactorAuth.ADAPTER.read(protocol));
                                            break;
                                        case (short) 126:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.api_response((ApiResponse) ApiResponse.ADAPTER.read(protocol));
                                            break;
                                        case (short) 127:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.api((Api) Api.ADAPTER.read(protocol));
                                            break;
                                        case (short) 128:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.discovery_unit((DiscoveryUnit) DiscoveryUnit.ADAPTER.read(protocol));
                                            break;
                                        case (short) 129:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.experiment((Experiment) Experiment.ADAPTER.read(protocol));
                                            break;
                                        case (short) 130:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.share((Share) Share.ADAPTER.read(protocol));
                                            break;
                                        case (short) 131:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.user_subreddit((UserSubreddit) UserSubreddit.ADAPTER.read(protocol));
                                            break;
                                        case (short) 132:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.notification_request((NotificationRequest) NotificationRequest.ADAPTER.read(protocol));
                                            break;
                                        case (short) 133:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.search((Search) Search.ADAPTER.read(protocol));
                                            break;
                                        case (short) 134:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.message((Message) Message.ADAPTER.read(protocol));
                                            break;
                                        case (short) 135:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.admin((Admin) Admin.ADAPTER.read(protocol));
                                            break;
                                        case (short) 136:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.ticket((Ticket) Ticket.ADAPTER.read(protocol));
                                            break;
                                        case (short) 137:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.mailroom_request((MailroomRequest) MailroomRequest.ADAPTER.read(protocol));
                                            break;
                                        case (short) 138:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.comment_composer((CommentComposer) CommentComposer.ADAPTER.read(protocol));
                                            break;
                                        case (short) 139:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.gold_purchase((GoldPurchase) GoldPurchase.ADAPTER.read(protocol));
                                            break;
                                        case (short) 140:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.payment((Payment) Payment.ADAPTER.read(protocol));
                                            break;
                                        case (short) 141:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.news((News) News.ADAPTER.read(protocol));
                                            break;
                                        case (short) 142:
                                            if (b.f10036b != (byte) 12) {
                                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                                break;
                                            }
                                            builder.outbound((Outbound) Outbound.ADAPTER.read(protocol));
                                            break;
                                        default:
                                            switch (s) {
                                                case (short) 502:
                                                    if (b.f10036b != (byte) 11) {
                                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                                        break;
                                                    }
                                                    builder.user_legacy_id(protocol.mo2652l());
                                                    break;
                                                case (short) 503:
                                                    if (b.f10036b != (byte) 12) {
                                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                                        break;
                                                    }
                                                    builder.content_metadata((ContentMetadata) ContentMetadata.ADAPTER.read(protocol));
                                                    break;
                                                case (short) 504:
                                                    if (b.f10036b != (byte) 12) {
                                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                                        break;
                                                    }
                                                    builder.url_parsed((UrlParsed) UrlParsed.ADAPTER.read(protocol));
                                                    break;
                                                case (short) 505:
                                                    if (b.f10036b != (byte) 12) {
                                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                                        break;
                                                    }
                                                    builder.link_sharing((LinkSharing) LinkSharing.ADAPTER.read(protocol));
                                                    break;
                                                case (short) 506:
                                                    if (b.f10036b != (byte) 10) {
                                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                                        break;
                                                    }
                                                    builder.create_request_timestamp(Long.valueOf(protocol.mo2650j()));
                                                    break;
                                                case (short) 507:
                                                    if (b.f10036b != (byte) 12) {
                                                        ProtocolUtil.m8514a(protocol, b.f10036b);
                                                        break;
                                                    }
                                                    builder.inferred((Inferred) Inferred.ADAPTER.read(protocol));
                                                    break;
                                                default:
                                                    ProtocolUtil.m8514a(protocol, b.f10036b);
                                                    break;
                                            }
                                    }
                            }
                    }
                } else if (b.f10036b == (byte) 12) {
                    builder.geo((Geo) Geo.ADAPTER.read(protocol));
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Event read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Event(Builder builder) {
        this.source = builder.source;
        this.action = builder.action;
        this.noun = builder.noun;
        this.endpoint_timestamp = builder.endpoint_timestamp;
        this.client_timestamp = builder.client_timestamp;
        this.uuid = builder.uuid;
        this.utc_offset = builder.utc_offset;
        this.correlation_id = builder.correlation_id;
        this.post = builder.post;
        this.listing = builder.listing;
        this.comment = builder.comment;
        this.notification = builder.notification;
        this.oauth = builder.oauth;
        this.screen = builder.screen;
        this.app = builder.app;
        this.platform = builder.platform;
        this.request = builder.request;
        this.referrer = builder.referrer;
        this.dom_timer = builder.dom_timer;
        this.user = builder.user;
        this.user_preferences = builder.user_preferences;
        this.subreddit = builder.subreddit;
        this.session = builder.session;
        this.action_info = builder.action_info;
        this.expand = builder.expand;
        this.media = builder.media;
        this.chat = builder.chat;
        this.post_composer = builder.post_composer;
        this.widget = builder.widget;
        this.profile = builder.profile;
        this.onboarding = builder.onboarding;
        this.timer = builder.timer;
        this.tfa = builder.tfa;
        this.api_response = builder.api_response;
        this.api = builder.api;
        this.discovery_unit = builder.discovery_unit;
        this.experiment = builder.experiment;
        this.share = builder.share;
        this.user_subreddit = builder.user_subreddit;
        this.notification_request = builder.notification_request;
        this.search = builder.search;
        this.message = builder.message;
        this.admin = builder.admin;
        this.ticket = builder.ticket;
        this.mailroom_request = builder.mailroom_request;
        this.comment_composer = builder.comment_composer;
        this.gold_purchase = builder.gold_purchase;
        this.payment = builder.payment;
        this.news = builder.news;
        this.outbound = builder.outbound;
        this.geo = builder.geo;
        this.user_legacy_id = builder.user_legacy_id;
        this.content_metadata = builder.content_metadata;
        this.url_parsed = builder.url_parsed;
        this.link_sharing = builder.link_sharing;
        this.create_request_timestamp = builder.create_request_timestamp;
        this.inferred = builder.inferred;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if ((this.source == event.source || this.source.equals(event.source)) && ((this.action == event.action || this.action.equals(event.action)) && ((this.noun == event.noun || this.noun.equals(event.noun)) && ((this.endpoint_timestamp == event.endpoint_timestamp || (this.endpoint_timestamp != null && this.endpoint_timestamp.equals(event.endpoint_timestamp))) && ((this.client_timestamp == event.client_timestamp || this.client_timestamp.equals(event.client_timestamp)) && ((this.uuid == event.uuid || this.uuid.equals(event.uuid)) && ((this.utc_offset == event.utc_offset || (this.utc_offset != null && this.utc_offset.equals(event.utc_offset))) && ((this.correlation_id == event.correlation_id || (this.correlation_id != null && this.correlation_id.equals(event.correlation_id))) && ((this.post == event.post || (this.post != null && this.post.equals(event.post))) && ((this.listing == event.listing || (this.listing != null && this.listing.equals(event.listing))) && ((this.comment == event.comment || (this.comment != null && this.comment.equals(event.comment))) && ((this.notification == event.notification || (this.notification != null && this.notification.equals(event.notification))) && ((this.oauth == event.oauth || (this.oauth != null && this.oauth.equals(event.oauth))) && ((this.screen == event.screen || (this.screen != null && this.screen.equals(event.screen))) && ((this.app == event.app || (this.app != null && this.app.equals(event.app))) && ((this.platform == event.platform || (this.platform != null && this.platform.equals(event.platform))) && ((this.request == event.request || (this.request != null && this.request.equals(event.request))) && ((this.referrer == event.referrer || (this.referrer != null && this.referrer.equals(event.referrer))) && ((this.dom_timer == event.dom_timer || (this.dom_timer != null && this.dom_timer.equals(event.dom_timer))) && ((this.user == event.user || (this.user != null && this.user.equals(event.user))) && ((this.user_preferences == event.user_preferences || (this.user_preferences != null && this.user_preferences.equals(event.user_preferences))) && ((this.subreddit == event.subreddit || (this.subreddit != null && this.subreddit.equals(event.subreddit))) && ((this.session == event.session || (this.session != null && this.session.equals(event.session))) && ((this.action_info == event.action_info || (this.action_info != null && this.action_info.equals(event.action_info))) && ((this.expand == event.expand || (this.expand != null && this.expand.equals(event.expand))) && ((this.media == event.media || (this.media != null && this.media.equals(event.media))) && ((this.chat == event.chat || (this.chat != null && this.chat.equals(event.chat))) && ((this.post_composer == event.post_composer || (this.post_composer != null && this.post_composer.equals(event.post_composer))) && ((this.widget == event.widget || (this.widget != null && this.widget.equals(event.widget))) && ((this.profile == event.profile || (this.profile != null && this.profile.equals(event.profile))) && ((this.onboarding == event.onboarding || (this.onboarding != null && this.onboarding.equals(event.onboarding))) && ((this.timer == event.timer || (this.timer != null && this.timer.equals(event.timer))) && ((this.tfa == event.tfa || (this.tfa != null && this.tfa.equals(event.tfa))) && ((this.api_response == event.api_response || (this.api_response != null && this.api_response.equals(event.api_response))) && ((this.api == event.api || (this.api != null && this.api.equals(event.api))) && ((this.discovery_unit == event.discovery_unit || (this.discovery_unit != null && this.discovery_unit.equals(event.discovery_unit))) && ((this.experiment == event.experiment || (this.experiment != null && this.experiment.equals(event.experiment))) && ((this.share == event.share || (this.share != null && this.share.equals(event.share))) && ((this.user_subreddit == event.user_subreddit || (this.user_subreddit != null && this.user_subreddit.equals(event.user_subreddit))) && ((this.notification_request == event.notification_request || (this.notification_request != null && this.notification_request.equals(event.notification_request))) && ((this.search == event.search || (this.search != null && this.search.equals(event.search))) && ((this.message == event.message || (this.message != null && this.message.equals(event.message))) && ((this.admin == event.admin || (this.admin != null && this.admin.equals(event.admin))) && ((this.ticket == event.ticket || (this.ticket != null && this.ticket.equals(event.ticket))) && ((this.mailroom_request == event.mailroom_request || (this.mailroom_request != null && this.mailroom_request.equals(event.mailroom_request))) && ((this.comment_composer == event.comment_composer || (this.comment_composer != null && this.comment_composer.equals(event.comment_composer))) && ((this.gold_purchase == event.gold_purchase || (this.gold_purchase != null && this.gold_purchase.equals(event.gold_purchase))) && ((this.payment == event.payment || (this.payment != null && this.payment.equals(event.payment))) && ((this.news == event.news || (this.news != null && this.news.equals(event.news))) && ((this.outbound == event.outbound || (this.outbound != null && this.outbound.equals(event.outbound))) && ((this.geo == event.geo || (this.geo != null && this.geo.equals(event.geo))) && ((this.user_legacy_id == event.user_legacy_id || (this.user_legacy_id != null && this.user_legacy_id.equals(event.user_legacy_id))) && ((this.content_metadata == event.content_metadata || (this.content_metadata != null && this.content_metadata.equals(event.content_metadata))) && ((this.url_parsed == event.url_parsed || (this.url_parsed != null && this.url_parsed.equals(event.url_parsed))) && ((this.link_sharing == event.link_sharing || (this.link_sharing != null && this.link_sharing.equals(event.link_sharing))) && (this.create_request_timestamp == event.create_request_timestamp || (this.create_request_timestamp != null && this.create_request_timestamp.equals(event.create_request_timestamp)))))))))))))))))))))))))))))))))))))))))))))))))))))))))) {
            if (this.inferred != event.inferred) {
                if (!(this.inferred == null || this.inferred.equals(event.inferred) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.source.hashCode() ^ 16777619) * -2128831035) ^ this.action.hashCode()) * -2128831035) ^ this.noun.hashCode()) * -2128831035) ^ (this.endpoint_timestamp == null ? 0 : this.endpoint_timestamp.hashCode())) * -2128831035) ^ this.client_timestamp.hashCode()) * -2128831035) ^ this.uuid.hashCode()) * -2128831035) ^ (this.utc_offset == null ? 0 : this.utc_offset.hashCode())) * -2128831035) ^ (this.correlation_id == null ? 0 : this.correlation_id.hashCode())) * -2128831035) ^ (this.post == null ? 0 : this.post.hashCode())) * -2128831035) ^ (this.listing == null ? 0 : this.listing.hashCode())) * -2128831035) ^ (this.comment == null ? 0 : this.comment.hashCode())) * -2128831035) ^ (this.notification == null ? 0 : this.notification.hashCode())) * -2128831035) ^ (this.oauth == null ? 0 : this.oauth.hashCode())) * -2128831035) ^ (this.screen == null ? 0 : this.screen.hashCode())) * -2128831035) ^ (this.app == null ? 0 : this.app.hashCode())) * -2128831035) ^ (this.platform == null ? 0 : this.platform.hashCode())) * -2128831035) ^ (this.request == null ? 0 : this.request.hashCode())) * -2128831035) ^ (this.referrer == null ? 0 : this.referrer.hashCode())) * -2128831035) ^ (this.dom_timer == null ? 0 : this.dom_timer.hashCode())) * -2128831035) ^ (this.user == null ? 0 : this.user.hashCode())) * -2128831035) ^ (this.user_preferences == null ? 0 : this.user_preferences.hashCode())) * -2128831035) ^ (this.subreddit == null ? 0 : this.subreddit.hashCode())) * -2128831035) ^ (this.session == null ? 0 : this.session.hashCode())) * -2128831035) ^ (this.action_info == null ? 0 : this.action_info.hashCode())) * -2128831035) ^ (this.expand == null ? 0 : this.expand.hashCode())) * -2128831035) ^ (this.media == null ? 0 : this.media.hashCode())) * -2128831035) ^ (this.chat == null ? 0 : this.chat.hashCode())) * -2128831035) ^ (this.post_composer == null ? 0 : this.post_composer.hashCode())) * -2128831035) ^ (this.widget == null ? 0 : this.widget.hashCode())) * -2128831035) ^ (this.profile == null ? 0 : this.profile.hashCode())) * -2128831035) ^ (this.onboarding == null ? 0 : this.onboarding.hashCode())) * -2128831035) ^ (this.timer == null ? 0 : this.timer.hashCode())) * -2128831035) ^ (this.tfa == null ? 0 : this.tfa.hashCode())) * -2128831035) ^ (this.api_response == null ? 0 : this.api_response.hashCode())) * -2128831035) ^ (this.api == null ? 0 : this.api.hashCode())) * -2128831035) ^ (this.discovery_unit == null ? 0 : this.discovery_unit.hashCode())) * -2128831035) ^ (this.experiment == null ? 0 : this.experiment.hashCode())) * -2128831035) ^ (this.share == null ? 0 : this.share.hashCode())) * -2128831035) ^ (this.user_subreddit == null ? 0 : this.user_subreddit.hashCode())) * -2128831035) ^ (this.notification_request == null ? 0 : this.notification_request.hashCode())) * -2128831035) ^ (this.search == null ? 0 : this.search.hashCode())) * -2128831035) ^ (this.message == null ? 0 : this.message.hashCode())) * -2128831035) ^ (this.admin == null ? 0 : this.admin.hashCode())) * -2128831035) ^ (this.ticket == null ? 0 : this.ticket.hashCode())) * -2128831035) ^ (this.mailroom_request == null ? 0 : this.mailroom_request.hashCode())) * -2128831035) ^ (this.comment_composer == null ? 0 : this.comment_composer.hashCode())) * -2128831035) ^ (this.gold_purchase == null ? 0 : this.gold_purchase.hashCode())) * -2128831035) ^ (this.payment == null ? 0 : this.payment.hashCode())) * -2128831035) ^ (this.news == null ? 0 : this.news.hashCode())) * -2128831035) ^ (this.outbound == null ? 0 : this.outbound.hashCode())) * -2128831035) ^ (this.geo == null ? 0 : this.geo.hashCode())) * -2128831035) ^ (this.user_legacy_id == null ? 0 : this.user_legacy_id.hashCode())) * -2128831035) ^ (this.content_metadata == null ? 0 : this.content_metadata.hashCode())) * -2128831035) ^ (this.url_parsed == null ? 0 : this.url_parsed.hashCode())) * -2128831035) ^ (this.link_sharing == null ? 0 : this.link_sharing.hashCode())) * -2128831035) ^ (this.create_request_timestamp == null ? 0 : this.create_request_timestamp.hashCode())) * -2128831035;
        if (this.inferred != null) {
            i = this.inferred.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Event{source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", action=");
        stringBuilder.append(this.action);
        stringBuilder.append(", noun=");
        stringBuilder.append(this.noun);
        stringBuilder.append(", endpoint_timestamp=");
        stringBuilder.append(this.endpoint_timestamp);
        stringBuilder.append(", client_timestamp=");
        stringBuilder.append(this.client_timestamp);
        stringBuilder.append(", uuid=");
        stringBuilder.append(this.uuid);
        stringBuilder.append(", utc_offset=");
        stringBuilder.append(this.utc_offset);
        stringBuilder.append(", correlation_id=");
        stringBuilder.append(this.correlation_id);
        stringBuilder.append(", post=");
        stringBuilder.append(this.post);
        stringBuilder.append(", listing=");
        stringBuilder.append(this.listing);
        stringBuilder.append(", comment=");
        stringBuilder.append(this.comment);
        stringBuilder.append(", notification=");
        stringBuilder.append(this.notification);
        stringBuilder.append(", oauth=");
        stringBuilder.append(this.oauth);
        stringBuilder.append(", screen=");
        stringBuilder.append(this.screen);
        stringBuilder.append(", app=");
        stringBuilder.append(this.app);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", request=");
        stringBuilder.append(this.request);
        stringBuilder.append(", referrer=");
        stringBuilder.append(this.referrer);
        stringBuilder.append(", dom_timer=");
        stringBuilder.append(this.dom_timer);
        stringBuilder.append(", user=");
        stringBuilder.append(this.user);
        stringBuilder.append(", user_preferences=");
        stringBuilder.append(this.user_preferences);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", session=");
        stringBuilder.append(this.session);
        stringBuilder.append(", action_info=");
        stringBuilder.append(this.action_info);
        stringBuilder.append(", expand=");
        stringBuilder.append(this.expand);
        stringBuilder.append(", media=");
        stringBuilder.append(this.media);
        stringBuilder.append(", chat=");
        stringBuilder.append(this.chat);
        stringBuilder.append(", post_composer=");
        stringBuilder.append(this.post_composer);
        stringBuilder.append(", widget=");
        stringBuilder.append(this.widget);
        stringBuilder.append(", profile=");
        stringBuilder.append(this.profile);
        stringBuilder.append(", onboarding=");
        stringBuilder.append(this.onboarding);
        stringBuilder.append(", timer=");
        stringBuilder.append(this.timer);
        stringBuilder.append(", tfa=");
        stringBuilder.append(this.tfa);
        stringBuilder.append(", api_response=");
        stringBuilder.append(this.api_response);
        stringBuilder.append(", api=");
        stringBuilder.append(this.api);
        stringBuilder.append(", discovery_unit=");
        stringBuilder.append(this.discovery_unit);
        stringBuilder.append(", experiment=");
        stringBuilder.append(this.experiment);
        stringBuilder.append(", share=");
        stringBuilder.append(this.share);
        stringBuilder.append(", user_subreddit=");
        stringBuilder.append(this.user_subreddit);
        stringBuilder.append(", notification_request=");
        stringBuilder.append(this.notification_request);
        stringBuilder.append(", search=");
        stringBuilder.append(this.search);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", admin=");
        stringBuilder.append(this.admin);
        stringBuilder.append(", ticket=");
        stringBuilder.append(this.ticket);
        stringBuilder.append(", mailroom_request=");
        stringBuilder.append(this.mailroom_request);
        stringBuilder.append(", comment_composer=");
        stringBuilder.append(this.comment_composer);
        stringBuilder.append(", gold_purchase=");
        stringBuilder.append(this.gold_purchase);
        stringBuilder.append(", payment=");
        stringBuilder.append(this.payment);
        stringBuilder.append(", news=");
        stringBuilder.append(this.news);
        stringBuilder.append(", outbound=");
        stringBuilder.append(this.outbound);
        stringBuilder.append(", geo=");
        stringBuilder.append(this.geo);
        stringBuilder.append(", user_legacy_id=");
        stringBuilder.append(this.user_legacy_id);
        stringBuilder.append(", content_metadata=");
        stringBuilder.append(this.content_metadata);
        stringBuilder.append(", url_parsed=");
        stringBuilder.append(this.url_parsed);
        stringBuilder.append(", link_sharing=");
        stringBuilder.append(this.link_sharing);
        stringBuilder.append(", create_request_timestamp=");
        stringBuilder.append(this.create_request_timestamp);
        stringBuilder.append(", inferred=");
        stringBuilder.append(this.inferred);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
