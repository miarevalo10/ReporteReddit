package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkMedia;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import java.io.Serializable;
import java.util.List;

public class SubmittedVideoLink implements Link, Serializable {
    public final VideoUpload videoUpload;

    public List<AdEvent> getAdEvents() {
        return null;
    }

    public String getApprovedBy() {
        return null;
    }

    public String getAuthor() {
        return null;
    }

    public Boolean getAuthorCakeday() {
        return null;
    }

    public String getAuthorFlairRichText() {
        return null;
    }

    public long getCreatedUtc() {
        return 0;
    }

    public List<ClientLink> getCrosspostParentList() {
        return null;
    }

    public String getDisplayDomain() {
        return null;
    }

    public int getDistinguishedType() {
        return 0;
    }

    public String getDomain() {
        return null;
    }

    public int getGilded() {
        return 0;
    }

    public String getInstanceId() {
        return "";
    }

    public Boolean getLikes() {
        return null;
    }

    public String getLinkFlairRichText() {
        return null;
    }

    public String getLinkFlairText() {
        return null;
    }

    public int getLinkType() {
        return 9;
    }

    public int getListableType() {
        return 6;
    }

    public String getLocationName() {
        return null;
    }

    public LinkMedia getMedia() {
        return null;
    }

    public int getMinAndroidVersion() {
        return 0;
    }

    public long getNumComments() {
        return 0;
    }

    public int getNumReports() {
        return 0;
    }

    public OutboundLink getOutboundLink() {
        return null;
    }

    public String getPermalink() {
        return null;
    }

    public String getPostHint() {
        return null;
    }

    public LinkPreview getPreview() {
        return null;
    }

    public Listing<ReplyableWrapper> getReplies() {
        return null;
    }

    public int getScore() {
        return 0;
    }

    public String getSelfText() {
        return null;
    }

    public String getSelfTextHtml() {
        return null;
    }

    public Subreddit getSubredditDetail() {
        return null;
    }

    public String getSubredditNamePrefixed() {
        return null;
    }

    public String getSuggestedSort() {
        return null;
    }

    public long getViewCount() {
        return 0;
    }

    public String getVotableType() {
        return null;
    }

    public int getVoteDirection() {
        return 0;
    }

    public String getWebsocketUrl() {
        return null;
    }

    public boolean isApproved() {
        return false;
    }

    public boolean isArchived() {
        return false;
    }

    public boolean isBlankAd() {
        return false;
    }

    public boolean isBrandSafe() {
        return false;
    }

    public boolean isDistinguished() {
        return false;
    }

    public boolean isHidden() {
        return false;
    }

    public boolean isLocked() {
        return false;
    }

    public boolean isNsfw() {
        return false;
    }

    public boolean isOver18() {
        return false;
    }

    public boolean isPromoted() {
        return false;
    }

    public boolean isQuarantined() {
        return false;
    }

    public boolean isRead() {
        return false;
    }

    public boolean isRemoved() {
        return false;
    }

    public boolean isSaved() {
        return false;
    }

    public boolean isScoreHidden() {
        return false;
    }

    public boolean isSelf() {
        return true;
    }

    public boolean isSpam() {
        return false;
    }

    public boolean isSpoiler() {
        return false;
    }

    public boolean isStickied() {
        return false;
    }

    public boolean isVideo() {
        return true;
    }

    public void markRead() {
    }

    public void setReplies(Listing<ReplyableWrapper> listing) {
    }

    public boolean trackScroll() {
        return false;
    }

    public SubmittedVideoLink(VideoUpload videoUpload) {
        this.videoUpload = videoUpload;
    }

    public String getId() {
        return this.videoUpload.getRequestId();
    }

    public String getName() {
        return this.videoUpload.getTitle();
    }

    public long getUniqueID() {
        return (long) this.videoUpload.getId();
    }

    public String getTitle() {
        return this.videoUpload.getTitle();
    }

    public String getUrl() {
        return this.videoUpload.getFilePath();
    }

    public String getSubreddit() {
        return this.videoUpload.getSubreddit();
    }

    public String[][] getUserReports() {
        return new String[0][];
    }

    public String[][] getModReports() {
        return new String[0][];
    }

    public boolean isGif() {
        return this.videoUpload.isGif();
    }
}
