package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.text.TextUtils;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkMedia;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v1.RedditVideo;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.AdUtil;
import com.reddit.frontpage.util.GoldUtil;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.Util;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.StringsKt__StringsKt;
import org.parceler.Parcel;

@Parcel
public class ClientLink extends BaseModel implements DeserializationPostProcessable, Link, Serializable {
    private static final String DISTINGUISHED_ADMIN_TEXT = "admin";
    private static final String DISTINGUISHED_MODERATOR_TEXT = "moderator";
    static AtomicInteger instanceCounter = new AtomicInteger();
    boolean _dirty;
    @ColumnIgnore
    List<ImageResolution> _gifData;
    ImageResolution _gifPreview;
    long _id;
    @ColumnIgnore
    int _linkType;
    @ColumnIgnore
    List<ImageResolution> _mp4Data;
    ImageResolution _mp4Preview;
    @ColumnIgnore
    List<ImageResolution> _nsfwData;
    ImageResolution _nsfwPreview;
    boolean _read;
    long _readUtc;
    @ColumnIgnore
    List<ImageResolution> _sourceData;
    ImageResolution _sourcePreview;
    boolean approved;
    String approved_by;
    boolean archived;
    String author;
    boolean author_cakeday;
    @ColumnIgnore
    List<FlairRichTextItem> author_flair_richtext;
    String author_flair_text;
    String body;
    boolean brand_safe;
    String circlepost_websocket_url;
    long created_utc;
    @ColumnIgnore
    List<ClientLink> crosspost_parent_list;
    String distinguished;
    String domain;
    @SerializedName(a = "domain_override")
    @ColumnIgnore
    String domainOverride;
    @ColumnIgnore
    List<AdEvent> events;
    String from_id;
    String from_kind;
    int gilded;
    boolean has_reddit_video_preview;
    boolean hidden;
    boolean hide_score;
    String id;
    @ColumnIgnore
    String instanceId;
    boolean is_betrayed;
    boolean is_blank;
    boolean is_self;
    boolean is_video;
    Boolean likes;
    String link_flair_id;
    @ColumnIgnore
    List<FlairRichTextItem> link_flair_richtext;
    String link_flair_text;
    String location_name;
    boolean locked;
    @ColumnIgnore
    LinkMedia media;
    @ColumnIgnore
    String[][] mod_reports;
    String name;
    long num_comments;
    int num_reports;
    @SerializedName(a = "outbound_link")
    @ColumnIgnore
    OutboundLink outboundLink;
    boolean over_18;
    String permalink;
    String post_hint;
    @ColumnIgnore
    LinkPreview preview;
    boolean promoted;
    boolean quarantined;
    boolean removed;
    String rvp_dash_url;
    int rvp_duration;
    String rvp_fallback_url;
    int rvp_height;
    String rvp_hls_url;
    boolean rvp_is_gif;
    String rvp_scrubber_media_url;
    String rvp_transcoder_status;
    int rvp_width;
    boolean saved;
    int score;
    String scrubber_media_url;
    String selftext;
    String selftext_html;
    boolean spam;
    boolean spoiler;
    @ColumnIgnore
    Subreddit sr_detail;
    boolean stickied;
    String subreddit;
    String subreddit_id;
    String subreddit_name_prefixed;
    String suggested_sort;
    String thumbnail;
    String title;
    String url;
    @ColumnIgnore
    String[][] user_reports;
    String video_dash_url;
    int video_duration;
    int video_height;
    boolean video_is_gif;
    String video_scrubber_media_url;
    int video_width;
    long view_count;
    String vote_key;
    String websocket_url;

    public int getListableType() {
        return 1;
    }

    public int getMinAndroidVersion() {
        return 0;
    }

    public boolean trackScroll() {
        return true;
    }

    public ClientLink() {
        this.user_reports = new String[0][];
        this.mod_reports = new String[0][];
        this._linkType = 0;
    }

    public ClientLink(ClientLink clientLink) {
        this.user_reports = new String[0][];
        this.mod_reports = new String[0][];
        this._linkType = 0;
        updateServerProperties(clientLink);
        updateClientProperties(clientLink);
    }

    public ClientLink(String str, Subreddit subreddit, String str2) {
        this.user_reports = new String[0][];
        this.mod_reports = new String[0][];
        this._linkType = 0;
        this.id = str.substring(3);
        this.name = str;
        this.sr_detail = subreddit;
        this.title = str2;
    }

    public ClientLink(Link link) {
        int i = 0;
        this.user_reports = new String[0][];
        this.mod_reports = new String[0][];
        this._linkType = 0;
        this.id = link.getId();
        this.name = link.getKindWithId();
        this.created_utc = link.getCreatedUtc();
        this.title = link.getTitle();
        this.domain = link.getDomain();
        this.url = link.getUrl();
        this.score = link.getScore();
        this.likes = link.getLikes();
        this.num_comments = link.getNumComments();
        this.view_count = link.getViewCount() == null ? 0 : link.getViewCount().longValue();
        this.subreddit = link.getSubreddit();
        this.subreddit_id = link.getSubredditId();
        this.subreddit_name_prefixed = link.getSubredditNamePrefixed();
        this.link_flair_text = link.getLinkFlairText();
        this.link_flair_id = link.getLinkFlairId();
        this.author = link.getAuthor();
        this.author_cakeday = link.getAuthorCakeday();
        this.gilded = link.getGilded();
        this.over_18 = link.getOver18();
        this.spoiler = link.getSpoiler();
        this.suggested_sort = link.getSuggestedSort();
        this.thumbnail = link.getThumbnail();
        this.body = link.getBody();
        this.selftext = link.getSelftext();
        this.selftext_html = link.getSelftextHtml();
        this.permalink = link.getPermalink();
        this.is_self = link.isSelf();
        this.post_hint = link.getPostHint();
        this.author_flair_text = getAuthorFlairText();
        this.from_id = "";
        this.from_kind = "";
        this.websocket_url = link.getWebsocketUrl();
        this.archived = link.getArchived();
        this.locked = link.getLocked();
        this.quarantined = link.getQuarantine();
        this.promoted = link.getPromoted();
        this.hidden = link.getHidden();
        this.saved = link.getSaved();
        this.hide_score = link.getHideScore();
        this.stickied = link.getStickied();
        this.distinguished = link.getDistinguished();
        this.approved_by = link.getApprovedBy();
        this.approved = link.getApproved();
        this.removed = link.getRemoved();
        this.spam = link.getSpam();
        if (link.getNumReports() != null) {
            i = link.getNumReports().intValue();
        }
        this.num_reports = i;
        this.brand_safe = link.getBrandSafe();
        this.scrubber_media_url = "";
        this.is_video = link.isVideo();
        this.location_name = link.getLocationName();
        this.is_blank = link.isBlankAd();
        this.user_reports = (String[][]) Iterables.a(Collections2.a(link.getUserReports(), ClientLink$$Lambda$0.$instance), String[].class);
        this.mod_reports = (String[][]) Iterables.a(Collections2.a(link.getModReports(), ClientLink$$Lambda$1.$instance), String[].class);
        if (link.getPreview() != null) {
            this.preview = new LinkPreview(link.getPreview());
        }
        if (link.getMedia() != null) {
            this.media = new LinkMedia(link.getMedia());
        }
        if (link.getCrossPostParentList() != null) {
            this.crosspost_parent_list = Lists.a(link.getCrossPostParentList(), ClientLink$$Lambda$2.$instance);
        }
        if (link.getEvents() != null) {
            this.events = Lists.a(link.getEvents(), ClientLink$$Lambda$3.$instance);
        }
        this.domainOverride = link.getDomainOverride();
        if (link.getOutboundLink() != null) {
            this.outboundLink = link.getOutboundLink().toLegacy();
        }
        if (link.getLinkFlairRichTextObject() != null) {
            this.link_flair_richtext = Lists.a(link.getLinkFlairRichTextObject(), ClientLink$$Lambda$4.$instance);
        }
        if (link.getAuthorFlairRichTextObject() != null) {
            this.author_flair_richtext = Lists.a(link.getAuthorFlairRichTextObject(), ClientLink$$Lambda$5.$instance);
        }
        if (link.getSubredditDetail() != null) {
            this.sr_detail = new Subreddit(link.getSubredditDetail());
        }
        postDeserialization();
    }

    public ClientLink(LinkPresentationModel linkPresentationModel) {
        long j;
        this.user_reports = new String[0][];
        this.mod_reports = new String[0][];
        this._linkType = 0;
        this.id = StringsKt__StringsKt.m42446a(linkPresentationModel.f33977d, '_', linkPresentationModel.f33977d);
        this.name = linkPresentationModel.getName();
        this.created_utc = linkPresentationModel.f33982i;
        this.title = linkPresentationModel.f33999z;
        this.domain = linkPresentationModel.getDomain();
        this.url = linkPresentationModel.ad;
        this.score = linkPresentationModel.getScore();
        this.likes = linkPresentationModel.an;
        this.num_comments = linkPresentationModel.f33966S;
        if (linkPresentationModel.f33967T == null) {
            j = 0;
        } else {
            j = linkPresentationModel.f33967T.longValue();
        }
        this.view_count = j;
        this.subreddit = linkPresentationModel.af;
        this.subreddit_id = linkPresentationModel.ag;
        this.subreddit_name_prefixed = linkPresentationModel.f33979f;
        this.link_flair_text = linkPresentationModel.f33980g;
        this.author = linkPresentationModel.f33985l;
        this.author_cakeday = linkPresentationModel.f33987n;
        this.gilded = linkPresentationModel.f33990q;
        this.over_18 = linkPresentationModel.f33950C;
        this.spoiler = linkPresentationModel.f33953F;
        this.suggested_sort = linkPresentationModel.f33951D;
        this.thumbnail = linkPresentationModel.f33952E;
        this.selftext = linkPresentationModel.f33958K;
        this.selftext_html = linkPresentationModel.f33959L;
        this.permalink = linkPresentationModel.ae;
        this.is_self = linkPresentationModel.ao;
        this.post_hint = linkPresentationModel.ap;
        this.author_flair_text = getAuthorFlairText();
        this.from_id = "";
        this.from_kind = "";
        this.websocket_url = "";
        this.archived = linkPresentationModel.f33989p;
        this.locked = linkPresentationModel.f33995v;
        this.quarantined = linkPresentationModel.f33998y;
        this.promoted = linkPresentationModel.f33962O;
        this.hidden = linkPresentationModel.f33973Z;
        this.saved = linkPresentationModel.aa;
        this.hide_score = linkPresentationModel.f33965R;
        this.stickied = linkPresentationModel.f33992s;
        this.distinguished = linkPresentationModel.f33994u;
        this.approved_by = linkPresentationModel.f33997x;
        this.approved = linkPresentationModel.f33996w;
        this.removed = linkPresentationModel.ab;
        this.spam = linkPresentationModel.ac;
        this.num_reports = linkPresentationModel.f33969V;
        this.brand_safe = true;
        this.scrubber_media_url = "";
        this.is_video = linkPresentationModel.ar;
        this.location_name = linkPresentationModel.f33988o;
        this.user_reports = linkPresentationModel.getUserReports();
        this.mod_reports = linkPresentationModel.getModReports();
        if (linkPresentationModel.at != null) {
            this.preview = new LinkPreview(linkPresentationModel.at);
        }
        if (linkPresentationModel.au != null) {
            this.media = new LinkMedia(linkPresentationModel.au);
        }
        if (linkPresentationModel.al != null) {
            this.crosspost_parent_list = Lists.a(linkPresentationModel.al, ClientLink$$Lambda$6.$instance);
        }
        this.domainOverride = linkPresentationModel.f33964Q;
        if (linkPresentationModel.f33963P != null) {
            this.outboundLink = linkPresentationModel.f33963P.toLegacy();
        }
        if (linkPresentationModel.f33961N != null) {
            this.events = Lists.a(linkPresentationModel.f33961N, ClientLink$$Lambda$7.$instance);
        }
        postDeserialization();
    }

    public void updateServerProperties(ClientLink clientLink) {
        this._id = clientLink._id;
        this.id = clientLink.id;
        this.name = clientLink.name;
        this.created_utc = clientLink.created_utc;
        this.title = clientLink.title;
        this.body = clientLink.body;
        this.domain = clientLink.domain;
        this.url = clientLink.url;
        this.scrubber_media_url = clientLink.scrubber_media_url;
        this.score = clientLink.score;
        this.likes = clientLink.likes;
        this.num_comments = clientLink.num_comments;
        this.view_count = clientLink.view_count;
        this.subreddit = clientLink.subreddit;
        this.subreddit_id = clientLink.subreddit_id;
        this.subreddit_name_prefixed = clientLink.subreddit_name_prefixed;
        this.link_flair_text = clientLink.link_flair_text;
        this.link_flair_richtext = clientLink.link_flair_richtext;
        this.link_flair_id = clientLink.link_flair_id;
        this.author = clientLink.author;
        this.author_cakeday = clientLink.author_cakeday;
        this.gilded = clientLink.gilded;
        this.over_18 = clientLink.over_18;
        this.spoiler = clientLink.spoiler;
        this.suggested_sort = clientLink.suggested_sort;
        this.thumbnail = clientLink.thumbnail;
        this.media = clientLink.media;
        this.selftext = clientLink.selftext;
        this.selftext_html = clientLink.selftext_html;
        this.preview = clientLink.preview;
        this.permalink = clientLink.permalink;
        this.is_self = clientLink.is_self;
        this.post_hint = clientLink.post_hint;
        this.author_flair_text = clientLink.author_flair_text;
        this.author_flair_richtext = clientLink.author_flair_richtext;
        this.sr_detail = clientLink.sr_detail;
        this.from_id = clientLink.from_id;
        this.from_kind = clientLink.from_kind;
        this.websocket_url = clientLink.websocket_url;
        this.archived = clientLink.archived;
        this.locked = clientLink.locked;
        this.quarantined = clientLink.quarantined;
        this.promoted = clientLink.promoted;
        this.hidden = clientLink.hidden;
        this.saved = clientLink.saved;
        this.hide_score = clientLink.hide_score;
        this.stickied = clientLink.stickied;
        this.distinguished = clientLink.distinguished;
        this.approved_by = clientLink.approved_by;
        this.removed = clientLink.removed;
        this.spam = clientLink.spam;
        this.approved = clientLink.approved;
        this.num_reports = clientLink.num_reports;
        this.mod_reports = clientLink.mod_reports;
        this.user_reports = clientLink.user_reports;
        this.brand_safe = clientLink.brand_safe;
        this.location_name = clientLink.location_name;
        this.instanceId = clientLink.instanceId;
        this._sourcePreview = clientLink._sourcePreview;
        this._nsfwPreview = clientLink._nsfwPreview;
        this._gifPreview = clientLink._gifPreview;
        this._mp4Preview = clientLink._mp4Preview;
        this._sourceData = clientLink._sourceData;
        this._nsfwData = clientLink._nsfwData;
        this._gifData = clientLink._gifData;
        this._mp4Data = clientLink._mp4Data;
        this.is_video = clientLink.is_video;
        this.is_blank = clientLink.is_blank;
        this.has_reddit_video_preview = clientLink.has_reddit_video_preview;
        this.rvp_height = clientLink.rvp_height;
        this.rvp_width = clientLink.rvp_width;
        this.rvp_dash_url = clientLink.rvp_dash_url;
        this.rvp_duration = clientLink.rvp_duration;
        this.rvp_hls_url = clientLink.rvp_hls_url;
        this.rvp_is_gif = clientLink.rvp_is_gif;
        this.rvp_fallback_url = clientLink.rvp_fallback_url;
        this.rvp_scrubber_media_url = clientLink.rvp_scrubber_media_url;
        this.rvp_transcoder_status = clientLink.rvp_transcoder_status;
        this.video_width = clientLink.video_width;
        this.video_height = clientLink.video_height;
        this.video_duration = clientLink.video_duration;
        this.video_dash_url = clientLink.video_dash_url;
        this.video_scrubber_media_url = clientLink.video_scrubber_media_url;
        this.video_is_gif = clientLink.video_is_gif;
        this.crosspost_parent_list = clientLink.crosspost_parent_list;
        this.events = clientLink.events;
        this.domainOverride = clientLink.domainOverride;
        this.outboundLink = clientLink.outboundLink;
    }

    public void updateClientProperties(ClientLink clientLink) {
        this._read = clientLink._read;
        this._readUtc = clientLink._readUtc;
        this._dirty = clientLink._dirty;
        this._linkType = clientLink._linkType;
    }

    public void postDeserialization() {
        this.instanceId = Integer.toString(instanceCounter.incrementAndGet());
        this.has_reddit_video_preview = false;
        if (this.preview != null) {
            this._sourcePreview = this.preview.getSource();
            this._nsfwPreview = this.preview.getObfuscated();
            this._gifPreview = this.preview.getGif();
            this._mp4Preview = this.preview.getMp4();
            this._sourceData = this.preview.getSourceResolutions();
            this._nsfwData = this.preview.getObfuscatedResolutions();
            this._gifData = this.preview.getGifResolutions();
            this._mp4Data = this.preview.getMp4Resolutions();
            if (this.preview.getRedditVideoPreview() != null) {
                RedditVideo redditVideoPreview = this.preview.getRedditVideoPreview();
                this.has_reddit_video_preview = true;
                this.rvp_height = redditVideoPreview.getHeight();
                this.rvp_width = redditVideoPreview.getWidth();
                this.rvp_dash_url = redditVideoPreview.getDashUrl();
                this.rvp_duration = redditVideoPreview.getDuration();
                this.rvp_hls_url = redditVideoPreview.getHlsUrl();
                this.rvp_is_gif = redditVideoPreview.isGif();
                this.rvp_fallback_url = redditVideoPreview.getFallbackUrl();
                this.rvp_scrubber_media_url = redditVideoPreview.getScrubberMediaUrl();
                this.rvp_transcoder_status = redditVideoPreview.getTranscodingStatus();
            }
        }
        if (!(this.media == null || this.media.getRedditVideo() == null)) {
            redditVideoPreview = this.media.getRedditVideo();
            this.video_width = redditVideoPreview.getWidth();
            this.video_height = redditVideoPreview.getHeight();
            this.video_duration = redditVideoPreview.getDuration();
            this.video_dash_url = redditVideoPreview.getDashUrl();
            this.video_scrubber_media_url = redditVideoPreview.getScrubberMediaUrl();
            this.video_is_gif = redditVideoPreview.isGif();
        }
        this._id = Util.m24024f(StringsKt__StringsKt.m42446a(this.id, '_', this.id));
        if (this.promoted) {
            this._id = (long) AdUtil.m23633a((Link) this).hashCode();
        }
    }

    public long getDatabaseId() {
        return this._id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getCreatedUtc() {
        return this.created_utc;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getDisplayDomain() {
        if (TextUtils.isEmpty(this.domainOverride)) {
            return this.domain;
        }
        return this.domainOverride;
    }

    public String getUrl() {
        return this.url;
    }

    public String getScrubberMediaUrl() {
        return this.scrubber_media_url;
    }

    public int getScore() {
        return this.score;
    }

    public Boolean getLikes() {
        return this.likes;
    }

    public long getNumComments() {
        return this.num_comments;
    }

    public long getViewCount() {
        return this.view_count;
    }

    public String getSubreddit() {
        return this.subreddit;
    }

    public String getSubredditId() {
        return this.subreddit_id;
    }

    public String getSubredditNamePrefixed() {
        return this.subreddit_name_prefixed;
    }

    public String getLinkFlairText() {
        return this.link_flair_text;
    }

    public String getLinkFlairRichText() {
        if (this.link_flair_richtext != null) {
            return RichTextUtil.m23882a(this.link_flair_richtext);
        }
        return this.link_flair_text != null ? this.link_flair_text : "";
    }

    public String getLinkFlairId() {
        return this.link_flair_id;
    }

    public String getAuthor() {
        return this.author;
    }

    public Boolean getAuthorCakeday() {
        return Boolean.valueOf(this.author_cakeday);
    }

    public int getGilded() {
        return GoldUtil.m23706a(this.name, this.gilded);
    }

    public boolean isOver18() {
        return this.over_18;
    }

    public boolean isNsfw() {
        return this.over_18;
    }

    public boolean isBrandSafe() {
        return this.brand_safe;
    }

    public boolean isSpoiler() {
        return this.spoiler;
    }

    public String getSuggestedSort() {
        return this.suggested_sort;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public LinkMedia getMedia() {
        return this.media;
    }

    public String getSelfText() {
        return this.selftext;
    }

    public String getSelfTextHtml() {
        return this.selftext_html;
    }

    public LinkPreview getPreview() {
        if (this.preview == null && !(this._sourcePreview == null && this._nsfwPreview == null && this._gifPreview == null && this._mp4Preview == null && !this.has_reddit_video_preview)) {
            RedditVideo redditVideo = null;
            if (this.has_reddit_video_preview) {
                redditVideo = new RedditVideo();
                redditVideo.setHeight(this.rvp_height);
                redditVideo.setWidth(this.rvp_width);
                redditVideo.setDashUrl(this.rvp_dash_url);
                redditVideo.setDuration(this.rvp_duration);
                redditVideo.setHlsUrl(this.rvp_hls_url);
                redditVideo.setGif(this.rvp_is_gif);
                redditVideo.setFallbackUrl(this.rvp_fallback_url);
                redditVideo.setScrubberMediaUrl(this.rvp_scrubber_media_url);
                redditVideo.setTranscodingStatus(this.rvp_transcoder_status);
            }
            this.preview = new LinkPreview(this._sourcePreview, this._sourceData, this._nsfwPreview, this._nsfwData, this._gifPreview, this._gifData, this._mp4Preview, this._mp4Data, redditVideo);
        }
        return this.preview;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public boolean isSelf() {
        return this.is_self;
    }

    public String getPostHint() {
        return this.post_hint;
    }

    public String getAuthorFlairText() {
        return this.author_flair_text;
    }

    public String getAuthorFlairRichText() {
        if (this.author_flair_richtext != null) {
            return RichTextUtil.m23882a(this.author_flair_richtext);
        }
        return this.author_flair_text != null ? this.author_flair_text : "";
    }

    public Subreddit getSubredditDetail() {
        return this.sr_detail;
    }

    public String getFromId() {
        return this.from_id;
    }

    public String getFromKind() {
        return this.from_kind;
    }

    public boolean isArchived() {
        return this.archived;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean isQuarantined() {
        return this.quarantined;
    }

    public boolean isPromoted() {
        return this.promoted;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isSaved() {
        return this.saved;
    }

    public boolean isScoreHidden() {
        return this.hide_score;
    }

    public boolean isStickied() {
        return this.stickied;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public int getDistinguishedType() {
        if (!TextUtils.isEmpty(this.distinguished)) {
            String str = this.distinguished;
            int i = -1;
            int hashCode = str.hashCode();
            if (hashCode != -2004703995) {
                if (hashCode == 92668751) {
                    if (str.equals(DISTINGUISHED_ADMIN_TEXT)) {
                        i = 0;
                    }
                }
            } else if (str.equals(DISTINGUISHED_MODERATOR_TEXT)) {
                i = 1;
            }
            switch (i) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                default:
                    break;
            }
        }
        return 0;
    }

    public int getVoteDirection() {
        if (this.likes == null) {
            return 0;
        }
        return this.likes.booleanValue() ? 1 : -1;
    }

    public boolean isRead() {
        return this._read;
    }

    public long getReadUtc() {
        return this._readUtc;
    }

    public void markRead() {
        this._read = true;
        this._readUtc = System.currentTimeMillis();
    }

    public String getVotableType() {
        return this.is_self ? "self" : "link";
    }

    @Deprecated
    public Listing<ReplyableWrapper> getReplies() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void setReplies(Listing<ReplyableWrapper> listing) {
        throw new UnsupportedOperationException();
    }

    public long getUniqueID() {
        return this._id;
    }

    public int getLinkType() {
        if (this._linkType == 0) {
            this._linkType = Util.m23952a((Link) this);
        }
        return this._linkType;
    }

    public String getWebsocketUrl() {
        return this.websocket_url;
    }

    public String getApprovedBy() {
        return this.approved_by;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public boolean isSpam() {
        return this.spam;
    }

    public int getNumReports() {
        return this.num_reports;
    }

    public String[][] getUserReports() {
        return this.user_reports;
    }

    public String[][] getModReports() {
        return this.mod_reports;
    }

    public boolean isDistinguished() {
        return getDistinguishedType() != 0;
    }

    public boolean isVideo() {
        return this.is_video;
    }

    public boolean isGif() {
        if (!Util.m24022e((Link) this)) {
            if (!this.video_is_gif) {
                return false;
            }
        }
        return true;
    }

    public boolean isBlankAd() {
        return this.is_blank;
    }

    public List<ClientLink> getCrosspostParentList() {
        return this.crosspost_parent_list;
    }

    public List<AdEvent> getAdEvents() {
        return this.events;
    }

    public OutboundLink getOutboundLink() {
        return this.outboundLink;
    }

    public String getDomainOverride() {
        return this.domainOverride;
    }

    public String getLocationName() {
        return this.location_name;
    }

    public int getVideoWidth() {
        return this.video_width;
    }

    public int getVideoHeight() {
        return this.video_height;
    }

    public long getVideoDuration() {
        return (long) this.video_duration;
    }

    public String getVideoDashUrl() {
        return this.video_dash_url;
    }

    public String getVideoScrubberUrl() {
        return this.video_scrubber_media_url;
    }
}
