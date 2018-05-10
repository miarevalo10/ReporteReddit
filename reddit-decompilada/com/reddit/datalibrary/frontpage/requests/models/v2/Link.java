package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.datalibrary.frontpage.requests.models.Commentable;
import com.reddit.datalibrary.frontpage.requests.models.Gildable;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.Reportable;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkMedia;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface Link extends Commentable, Gildable, Replyable, Reportable, Votable, Thing, AdsRelated, Listable, Shareable {
    public static final int DISTINGUISHED_ADMIN = 1;
    public static final int DISTINGUISHED_MODERATOR = 2;
    public static final int DISTINGUISHED_NONE = 0;
    public static final int LINK_TYPE_CAROUSEL = 7;
    public static final int LINK_TYPE_FEATURED_CAROUSEL = 8;
    public static final int LINK_TYPE_IMAGE = 4;
    public static final int LINK_TYPE_LIVE = 6;
    public static final int LINK_TYPE_SELF = 2;
    public static final int LINK_TYPE_SELF_IMAGE = 3;
    public static final int LINK_TYPE_SUBMITTED_VIDEO = 9;
    public static final int LINK_TYPE_UNKNOWN = 0;
    public static final int LINK_TYPE_VIDEO = 5;
    public static final int LINK_TYPE_WEBSITE = 1;
    public static final int LINK_TYPE_XPOST = 10;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistinguishedType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkType {
    }

    List<AdEvent> getAdEvents();

    String getApprovedBy();

    String getAuthor();

    Boolean getAuthorCakeday();

    String getAuthorFlairRichText();

    List<ClientLink> getCrosspostParentList();

    String getDisplayDomain();

    int getDistinguishedType();

    int getGilded();

    Boolean getLikes();

    String getLinkFlairRichText();

    String getLinkFlairText();

    int getLinkType();

    String getLocationName();

    LinkMedia getMedia();

    long getNumComments();

    int getNumReports();

    OutboundLink getOutboundLink();

    String getPermalink();

    String getPostHint();

    LinkPreview getPreview();

    int getScore();

    String getSelfText();

    String getSelfTextHtml();

    String getSubreddit();

    Subreddit getSubredditDetail();

    String getSubredditNamePrefixed();

    String getSuggestedSort();

    String getTitle();

    String getUrl();

    long getViewCount();

    String getWebsocketUrl();

    boolean isApproved();

    boolean isArchived();

    boolean isBlankAd();

    boolean isDistinguished();

    boolean isGif();

    boolean isHidden();

    boolean isLocked();

    boolean isNsfw();

    boolean isOver18();

    boolean isPromoted();

    boolean isQuarantined();

    boolean isRead();

    boolean isRemoved();

    boolean isSaved();

    boolean isSelf();

    boolean isSpam();

    boolean isSpoiler();

    boolean isStickied();

    boolean isVideo();

    void markRead();

    boolean trackScroll();
}
