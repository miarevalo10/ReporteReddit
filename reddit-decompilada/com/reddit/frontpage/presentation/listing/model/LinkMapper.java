package com.reddit.frontpage.presentation.listing.model;

import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Image;
import com.reddit.frontpage.domain.model.ImageResolution;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.LinkMedia;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.domain.model.LiveUpdateEvent;
import com.reddit.frontpage.domain.model.Preview;
import com.reddit.frontpage.domain.model.RedditVideo;
import com.reddit.frontpage.domain.model.SubredditDetail;
import com.reddit.frontpage.domain.model.Variant;
import com.reddit.frontpage.domain.model.Variants;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil.Mp4PreviewParams;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil.Mp4PreviewParams.Companion;
import com.reddit.frontpage.util.ImgurUtil;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JB\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00100\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0006J\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/LinkMapper;", "", "()V", "toCarouselItemPresentationModel", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "item", "Lcom/reddit/frontpage/domain/model/Link;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "showSubredditHeader", "", "toCarouselItemPresentationModels", "", "items", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel$LinkCause;", "toLinkPresentationModels", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "links", "toLiveUpdateEventPresentationModel", "Lcom/reddit/frontpage/presentation/listing/model/LiveUpdateEventPresentationModel;", "liveUpdateEvent", "Lcom/reddit/frontpage/domain/model/LiveUpdateEvent;", "toPresentationModel", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "link", "Lcom/reddit/frontpage/domain/model/ILink;", "toPresentationModels", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkMapper.kt */
public final class LinkMapper {
    public static final LinkMapper f20611a = new LinkMapper();

    private LinkMapper() {
    }

    public static LinkPresentationModel m22969a(Link link) {
        String dashUrl;
        boolean hasMp4Url;
        Preview preview;
        List images;
        Image image;
        Variants variants;
        Variant mp4;
        String str;
        List a;
        Variant a2;
        ImageResolution source;
        String url;
        Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel;
        LinkPreviewUtil linkPreviewUtil;
        ImageResolutionPresentationModel a3;
        int score;
        boolean hideScore;
        long numComments;
        Long viewCount;
        boolean canMod;
        Integer numReports;
        int intValue;
        List userReports;
        List modReports;
        boolean isRead;
        boolean hidden;
        boolean saved;
        String url2;
        String permalink;
        String domain;
        String subreddit;
        String subredditId;
        SubredditDetail subredditDetail;
        String keyColor;
        String iconImage;
        Boolean over18;
        boolean booleanValue;
        boolean booleanValue2;
        List crossPostParentList;
        List b;
        Boolean likes;
        boolean isSelf;
        String postHint;
        String locationName;
        String selftext;
        String selftextHtml;
        boolean isVideo;
        boolean isVideoLinkType;
        boolean isImageLinkType;
        Preview preview2;
        LinkMedia media;
        boolean isBlankAd;
        Link link2 = link;
        Intrinsics.m26847b(link2, "link");
        LinkType linkType = link.getLinkType();
        String uniqueId = link.getUniqueId();
        String id = link.getId();
        String kindWithId = link.getKindWithId();
        long hashCode = link.getPromoted() ? (long) link.getUniqueId().hashCode() : Util.m24024f(link.getId());
        String subredditNamePrefixed = link.getSubredditNamePrefixed();
        String linkFlairText = link.getLinkFlairText();
        String linkFlairRichText = link.getLinkFlairRichText();
        long createdUtc = link.getCreatedUtc();
        String c = DateUtil.m22705a(link.getCreatedUtc(), true);
        String generateDomainLabel = link2.generateDomainLabel(linkType);
        String author = link.getAuthor();
        String l = Util.m24042l(link.getAuthor());
        String str2 = author;
        Intrinsics.m26843a((Object) l, "Util.formatUsername(author)");
        String authorFlairRichText = link.getAuthorFlairRichText();
        boolean authorCakeday = link.getAuthorCakeday();
        boolean archived = link.getArchived();
        int gilded = link.getGilded();
        Integer numReports2 = link.getNumReports();
        boolean stickied = link.getStickied();
        DistinguishType distinguishType = link.getDistinguishType();
        String distinguished = link.getDistinguished();
        boolean locked = link.getLocked();
        boolean approved = link.getApproved();
        boolean quarantine = link.getQuarantine();
        String title = link.getTitle();
        String linkFlairText2 = link.getLinkFlairText();
        String authorFlairRichText2 = link.getAuthorFlairRichText();
        boolean over182 = link.getOver18();
        String suggestedSort = link.getSuggestedSort();
        String thumbnail = link.getThumbnail();
        boolean spoiler = link.getSpoiler();
        LinkPreviewUtil linkPreviewUtil2 = LinkPreviewUtil.f20852a;
        Intrinsics.m26847b(link2, "link");
        String str3 = l;
        String str4 = generateDomainLabel;
        ImageLinkPreviewPresentationModel a4 = LinkPreviewUtil.m23076a(link.getSpoiler(), link.getOver18(), link.getPreview());
        Companion companion = Mp4PreviewParams.f28521h;
        Intrinsics.m26847b(link2, "link");
        boolean isVideo2 = link.isVideo();
        LinkMedia media2 = link.getMedia();
        if (media2 != null) {
            RedditVideo redditVideo = media2.getRedditVideo();
            if (redditVideo != null) {
                dashUrl = redditVideo.getDashUrl();
                hasMp4Url = link.hasMp4Url();
                preview = link.getPreview();
                if (preview != null) {
                    images = preview.getImages();
                    if (images != null) {
                        image = (Image) CollectionsKt___CollectionsKt.m41430d(images);
                        if (image != null) {
                            variants = image.getVariants();
                            if (variants != null) {
                                mp4 = variants.getMp4();
                                if (mp4 != null) {
                                    images = mp4.getResolutions();
                                    if (images != null) {
                                        str = c;
                                        if ((images.isEmpty() ^ 1) != 0) {
                                            images = null;
                                        }
                                        if (images != null) {
                                            a = CollectionsKt__CollectionsKt.m26790a();
                                            a2 = Companion.m23075a(link);
                                            if (a2 != null) {
                                                source = a2.getSource();
                                                if (source != null) {
                                                    url = source.getUrl();
                                                    mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                                    linkPreviewUtil = LinkPreviewUtil.f20852a;
                                                    a3 = LinkPreviewUtil.m23077a(link);
                                                    score = link.getScore();
                                                    hideScore = link.getHideScore();
                                                    numComments = link.getNumComments();
                                                    viewCount = link.getViewCount();
                                                    canMod = link.getCanMod();
                                                    numReports = link.getNumReports();
                                                    intValue = numReports == null ? numReports.intValue() : 0;
                                                    userReports = link.getUserReports();
                                                    modReports = link.getModReports();
                                                    isRead = link.isRead();
                                                    hidden = link.getHidden();
                                                    saved = link.getSaved();
                                                    url2 = link.getUrl();
                                                    permalink = link.getPermalink();
                                                    domain = link.getDomain();
                                                    subreddit = link.getSubreddit();
                                                    subredditId = link.getSubredditId();
                                                    subredditDetail = link.getSubredditDetail();
                                                    keyColor = subredditDetail == null ? subredditDetail.getKeyColor() : null;
                                                    subredditDetail = link.getSubredditDetail();
                                                    iconImage = subredditDetail == null ? subredditDetail.getIconImage() : null;
                                                    subredditDetail = link.getSubredditDetail();
                                                    if (subredditDetail != null) {
                                                        over18 = subredditDetail.getOver18();
                                                        if (over18 != null) {
                                                            booleanValue = over18.booleanValue();
                                                            subredditDetail = link.getSubredditDetail();
                                                            if (subredditDetail != null) {
                                                                over18 = subredditDetail.getUserIsModerator();
                                                                if (over18 != null) {
                                                                    booleanValue2 = over18.booleanValue();
                                                                    crossPostParentList = link.getCrossPostParentList();
                                                                    if (crossPostParentList == null) {
                                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                                    }
                                                                    b = m22972b(crossPostParentList);
                                                                    likes = link.getLikes();
                                                                    isSelf = link.isSelf();
                                                                    postHint = link.getPostHint();
                                                                    locationName = link.getLocationName();
                                                                    selftext = link.getSelftext();
                                                                    selftextHtml = link.getSelftextHtml();
                                                                    isVideo = link.isVideo();
                                                                    isVideoLinkType = link.isVideoLinkType();
                                                                    isImageLinkType = link.isImageLinkType();
                                                                    preview2 = link.getPreview();
                                                                    media = link.getMedia();
                                                                    isBlankAd = link.isBlankAd();
                                                                    crossPostParentList = link.getEvents();
                                                                    if (crossPostParentList == null) {
                                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                                    }
                                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                                }
                                                            }
                                                            booleanValue2 = false;
                                                            crossPostParentList = link.getCrossPostParentList();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            b = m22972b(crossPostParentList);
                                                            likes = link.getLikes();
                                                            isSelf = link.isSelf();
                                                            postHint = link.getPostHint();
                                                            locationName = link.getLocationName();
                                                            selftext = link.getSelftext();
                                                            selftextHtml = link.getSelftextHtml();
                                                            isVideo = link.isVideo();
                                                            isVideoLinkType = link.isVideoLinkType();
                                                            isImageLinkType = link.isImageLinkType();
                                                            preview2 = link.getPreview();
                                                            media = link.getMedia();
                                                            isBlankAd = link.isBlankAd();
                                                            crossPostParentList = link.getEvents();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                        }
                                                    }
                                                    booleanValue = false;
                                                    subredditDetail = link.getSubredditDetail();
                                                    if (subredditDetail != null) {
                                                        over18 = subredditDetail.getUserIsModerator();
                                                        if (over18 != null) {
                                                            booleanValue2 = over18.booleanValue();
                                                            crossPostParentList = link.getCrossPostParentList();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            b = m22972b(crossPostParentList);
                                                            likes = link.getLikes();
                                                            isSelf = link.isSelf();
                                                            postHint = link.getPostHint();
                                                            locationName = link.getLocationName();
                                                            selftext = link.getSelftext();
                                                            selftextHtml = link.getSelftextHtml();
                                                            isVideo = link.isVideo();
                                                            isVideoLinkType = link.isVideoLinkType();
                                                            isImageLinkType = link.isImageLinkType();
                                                            preview2 = link.getPreview();
                                                            media = link.getMedia();
                                                            isBlankAd = link.isBlankAd();
                                                            crossPostParentList = link.getEvents();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                        }
                                                    }
                                                    booleanValue2 = false;
                                                    crossPostParentList = link.getCrossPostParentList();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    b = m22972b(crossPostParentList);
                                                    likes = link.getLikes();
                                                    isSelf = link.isSelf();
                                                    postHint = link.getPostHint();
                                                    locationName = link.getLocationName();
                                                    selftext = link.getSelftext();
                                                    selftextHtml = link.getSelftextHtml();
                                                    isVideo = link.isVideo();
                                                    isVideoLinkType = link.isVideoLinkType();
                                                    isImageLinkType = link.isImageLinkType();
                                                    preview2 = link.getPreview();
                                                    media = link.getMedia();
                                                    isBlankAd = link.isBlankAd();
                                                    crossPostParentList = link.getEvents();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                }
                                            }
                                            url = null;
                                            mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                            linkPreviewUtil = LinkPreviewUtil.f20852a;
                                            a3 = LinkPreviewUtil.m23077a(link);
                                            score = link.getScore();
                                            hideScore = link.getHideScore();
                                            numComments = link.getNumComments();
                                            viewCount = link.getViewCount();
                                            canMod = link.getCanMod();
                                            numReports = link.getNumReports();
                                            if (numReports == null) {
                                            }
                                            userReports = link.getUserReports();
                                            modReports = link.getModReports();
                                            isRead = link.isRead();
                                            hidden = link.getHidden();
                                            saved = link.getSaved();
                                            url2 = link.getUrl();
                                            permalink = link.getPermalink();
                                            domain = link.getDomain();
                                            subreddit = link.getSubreddit();
                                            subredditId = link.getSubredditId();
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail == null) {
                                            }
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail == null) {
                                            }
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail != null) {
                                                over18 = subredditDetail.getOver18();
                                                if (over18 != null) {
                                                    booleanValue = over18.booleanValue();
                                                    subredditDetail = link.getSubredditDetail();
                                                    if (subredditDetail != null) {
                                                        over18 = subredditDetail.getUserIsModerator();
                                                        if (over18 != null) {
                                                            booleanValue2 = over18.booleanValue();
                                                            crossPostParentList = link.getCrossPostParentList();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            b = m22972b(crossPostParentList);
                                                            likes = link.getLikes();
                                                            isSelf = link.isSelf();
                                                            postHint = link.getPostHint();
                                                            locationName = link.getLocationName();
                                                            selftext = link.getSelftext();
                                                            selftextHtml = link.getSelftextHtml();
                                                            isVideo = link.isVideo();
                                                            isVideoLinkType = link.isVideoLinkType();
                                                            isImageLinkType = link.isImageLinkType();
                                                            preview2 = link.getPreview();
                                                            media = link.getMedia();
                                                            isBlankAd = link.isBlankAd();
                                                            crossPostParentList = link.getEvents();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                        }
                                                    }
                                                    booleanValue2 = false;
                                                    crossPostParentList = link.getCrossPostParentList();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    b = m22972b(crossPostParentList);
                                                    likes = link.getLikes();
                                                    isSelf = link.isSelf();
                                                    postHint = link.getPostHint();
                                                    locationName = link.getLocationName();
                                                    selftext = link.getSelftext();
                                                    selftextHtml = link.getSelftextHtml();
                                                    isVideo = link.isVideo();
                                                    isVideoLinkType = link.isVideoLinkType();
                                                    isImageLinkType = link.isImageLinkType();
                                                    preview2 = link.getPreview();
                                                    media = link.getMedia();
                                                    isBlankAd = link.isBlankAd();
                                                    crossPostParentList = link.getEvents();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                }
                                            }
                                            booleanValue = false;
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail != null) {
                                                over18 = subredditDetail.getUserIsModerator();
                                                if (over18 != null) {
                                                    booleanValue2 = over18.booleanValue();
                                                    crossPostParentList = link.getCrossPostParentList();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    b = m22972b(crossPostParentList);
                                                    likes = link.getLikes();
                                                    isSelf = link.isSelf();
                                                    postHint = link.getPostHint();
                                                    locationName = link.getLocationName();
                                                    selftext = link.getSelftext();
                                                    selftextHtml = link.getSelftextHtml();
                                                    isVideo = link.isVideo();
                                                    isVideoLinkType = link.isVideoLinkType();
                                                    isImageLinkType = link.isImageLinkType();
                                                    preview2 = link.getPreview();
                                                    media = link.getMedia();
                                                    isBlankAd = link.isBlankAd();
                                                    crossPostParentList = link.getEvents();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                }
                                            }
                                            booleanValue2 = false;
                                            crossPostParentList = link.getCrossPostParentList();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            b = m22972b(crossPostParentList);
                                            likes = link.getLikes();
                                            isSelf = link.isSelf();
                                            postHint = link.getPostHint();
                                            locationName = link.getLocationName();
                                            selftext = link.getSelftext();
                                            selftextHtml = link.getSelftextHtml();
                                            isVideo = link.isVideo();
                                            isVideoLinkType = link.isVideoLinkType();
                                            isImageLinkType = link.isImageLinkType();
                                            preview2 = link.getPreview();
                                            media = link.getMedia();
                                            isBlankAd = link.isBlankAd();
                                            crossPostParentList = link.getEvents();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                        }
                                        a = images;
                                        a2 = Companion.m23075a(link);
                                        if (a2 != null) {
                                            source = a2.getSource();
                                            if (source != null) {
                                                url = source.getUrl();
                                                mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                                linkPreviewUtil = LinkPreviewUtil.f20852a;
                                                a3 = LinkPreviewUtil.m23077a(link);
                                                score = link.getScore();
                                                hideScore = link.getHideScore();
                                                numComments = link.getNumComments();
                                                viewCount = link.getViewCount();
                                                canMod = link.getCanMod();
                                                numReports = link.getNumReports();
                                                if (numReports == null) {
                                                }
                                                userReports = link.getUserReports();
                                                modReports = link.getModReports();
                                                isRead = link.isRead();
                                                hidden = link.getHidden();
                                                saved = link.getSaved();
                                                url2 = link.getUrl();
                                                permalink = link.getPermalink();
                                                domain = link.getDomain();
                                                subreddit = link.getSubreddit();
                                                subredditId = link.getSubredditId();
                                                subredditDetail = link.getSubredditDetail();
                                                if (subredditDetail == null) {
                                                }
                                                subredditDetail = link.getSubredditDetail();
                                                if (subredditDetail == null) {
                                                }
                                                subredditDetail = link.getSubredditDetail();
                                                if (subredditDetail != null) {
                                                    over18 = subredditDetail.getOver18();
                                                    if (over18 != null) {
                                                        booleanValue = over18.booleanValue();
                                                        subredditDetail = link.getSubredditDetail();
                                                        if (subredditDetail != null) {
                                                            over18 = subredditDetail.getUserIsModerator();
                                                            if (over18 != null) {
                                                                booleanValue2 = over18.booleanValue();
                                                                crossPostParentList = link.getCrossPostParentList();
                                                                if (crossPostParentList == null) {
                                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                                }
                                                                b = m22972b(crossPostParentList);
                                                                likes = link.getLikes();
                                                                isSelf = link.isSelf();
                                                                postHint = link.getPostHint();
                                                                locationName = link.getLocationName();
                                                                selftext = link.getSelftext();
                                                                selftextHtml = link.getSelftextHtml();
                                                                isVideo = link.isVideo();
                                                                isVideoLinkType = link.isVideoLinkType();
                                                                isImageLinkType = link.isImageLinkType();
                                                                preview2 = link.getPreview();
                                                                media = link.getMedia();
                                                                isBlankAd = link.isBlankAd();
                                                                crossPostParentList = link.getEvents();
                                                                if (crossPostParentList == null) {
                                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                                }
                                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                            }
                                                        }
                                                        booleanValue2 = false;
                                                        crossPostParentList = link.getCrossPostParentList();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        b = m22972b(crossPostParentList);
                                                        likes = link.getLikes();
                                                        isSelf = link.isSelf();
                                                        postHint = link.getPostHint();
                                                        locationName = link.getLocationName();
                                                        selftext = link.getSelftext();
                                                        selftextHtml = link.getSelftextHtml();
                                                        isVideo = link.isVideo();
                                                        isVideoLinkType = link.isVideoLinkType();
                                                        isImageLinkType = link.isImageLinkType();
                                                        preview2 = link.getPreview();
                                                        media = link.getMedia();
                                                        isBlankAd = link.isBlankAd();
                                                        crossPostParentList = link.getEvents();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                    }
                                                }
                                                booleanValue = false;
                                                subredditDetail = link.getSubredditDetail();
                                                if (subredditDetail != null) {
                                                    over18 = subredditDetail.getUserIsModerator();
                                                    if (over18 != null) {
                                                        booleanValue2 = over18.booleanValue();
                                                        crossPostParentList = link.getCrossPostParentList();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        b = m22972b(crossPostParentList);
                                                        likes = link.getLikes();
                                                        isSelf = link.isSelf();
                                                        postHint = link.getPostHint();
                                                        locationName = link.getLocationName();
                                                        selftext = link.getSelftext();
                                                        selftextHtml = link.getSelftextHtml();
                                                        isVideo = link.isVideo();
                                                        isVideoLinkType = link.isVideoLinkType();
                                                        isImageLinkType = link.isImageLinkType();
                                                        preview2 = link.getPreview();
                                                        media = link.getMedia();
                                                        isBlankAd = link.isBlankAd();
                                                        crossPostParentList = link.getEvents();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                    }
                                                }
                                                booleanValue2 = false;
                                                crossPostParentList = link.getCrossPostParentList();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                b = m22972b(crossPostParentList);
                                                likes = link.getLikes();
                                                isSelf = link.isSelf();
                                                postHint = link.getPostHint();
                                                locationName = link.getLocationName();
                                                selftext = link.getSelftext();
                                                selftextHtml = link.getSelftextHtml();
                                                isVideo = link.isVideo();
                                                isVideoLinkType = link.isVideoLinkType();
                                                isImageLinkType = link.isImageLinkType();
                                                preview2 = link.getPreview();
                                                media = link.getMedia();
                                                isBlankAd = link.isBlankAd();
                                                crossPostParentList = link.getEvents();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                            }
                                        }
                                        url = null;
                                        mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                        linkPreviewUtil = LinkPreviewUtil.f20852a;
                                        a3 = LinkPreviewUtil.m23077a(link);
                                        score = link.getScore();
                                        hideScore = link.getHideScore();
                                        numComments = link.getNumComments();
                                        viewCount = link.getViewCount();
                                        canMod = link.getCanMod();
                                        numReports = link.getNumReports();
                                        if (numReports == null) {
                                        }
                                        userReports = link.getUserReports();
                                        modReports = link.getModReports();
                                        isRead = link.isRead();
                                        hidden = link.getHidden();
                                        saved = link.getSaved();
                                        url2 = link.getUrl();
                                        permalink = link.getPermalink();
                                        domain = link.getDomain();
                                        subreddit = link.getSubreddit();
                                        subredditId = link.getSubredditId();
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail == null) {
                                        }
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail == null) {
                                        }
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail != null) {
                                            over18 = subredditDetail.getOver18();
                                            if (over18 != null) {
                                                booleanValue = over18.booleanValue();
                                                subredditDetail = link.getSubredditDetail();
                                                if (subredditDetail != null) {
                                                    over18 = subredditDetail.getUserIsModerator();
                                                    if (over18 != null) {
                                                        booleanValue2 = over18.booleanValue();
                                                        crossPostParentList = link.getCrossPostParentList();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        b = m22972b(crossPostParentList);
                                                        likes = link.getLikes();
                                                        isSelf = link.isSelf();
                                                        postHint = link.getPostHint();
                                                        locationName = link.getLocationName();
                                                        selftext = link.getSelftext();
                                                        selftextHtml = link.getSelftextHtml();
                                                        isVideo = link.isVideo();
                                                        isVideoLinkType = link.isVideoLinkType();
                                                        isImageLinkType = link.isImageLinkType();
                                                        preview2 = link.getPreview();
                                                        media = link.getMedia();
                                                        isBlankAd = link.isBlankAd();
                                                        crossPostParentList = link.getEvents();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                    }
                                                }
                                                booleanValue2 = false;
                                                crossPostParentList = link.getCrossPostParentList();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                b = m22972b(crossPostParentList);
                                                likes = link.getLikes();
                                                isSelf = link.isSelf();
                                                postHint = link.getPostHint();
                                                locationName = link.getLocationName();
                                                selftext = link.getSelftext();
                                                selftextHtml = link.getSelftextHtml();
                                                isVideo = link.isVideo();
                                                isVideoLinkType = link.isVideoLinkType();
                                                isImageLinkType = link.isImageLinkType();
                                                preview2 = link.getPreview();
                                                media = link.getMedia();
                                                isBlankAd = link.isBlankAd();
                                                crossPostParentList = link.getEvents();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                            }
                                        }
                                        booleanValue = false;
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail != null) {
                                            over18 = subredditDetail.getUserIsModerator();
                                            if (over18 != null) {
                                                booleanValue2 = over18.booleanValue();
                                                crossPostParentList = link.getCrossPostParentList();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                b = m22972b(crossPostParentList);
                                                likes = link.getLikes();
                                                isSelf = link.isSelf();
                                                postHint = link.getPostHint();
                                                locationName = link.getLocationName();
                                                selftext = link.getSelftext();
                                                selftextHtml = link.getSelftextHtml();
                                                isVideo = link.isVideo();
                                                isVideoLinkType = link.isVideoLinkType();
                                                isImageLinkType = link.isImageLinkType();
                                                preview2 = link.getPreview();
                                                media = link.getMedia();
                                                isBlankAd = link.isBlankAd();
                                                crossPostParentList = link.getEvents();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                            }
                                        }
                                        booleanValue2 = false;
                                        crossPostParentList = link.getCrossPostParentList();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        b = m22972b(crossPostParentList);
                                        likes = link.getLikes();
                                        isSelf = link.isSelf();
                                        postHint = link.getPostHint();
                                        locationName = link.getLocationName();
                                        selftext = link.getSelftext();
                                        selftextHtml = link.getSelftextHtml();
                                        isVideo = link.isVideo();
                                        isVideoLinkType = link.isVideoLinkType();
                                        isImageLinkType = link.isImageLinkType();
                                        preview2 = link.getPreview();
                                        media = link.getMedia();
                                        isBlankAd = link.isBlankAd();
                                        crossPostParentList = link.getEvents();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                    }
                                }
                            }
                        }
                    }
                }
                str = c;
                a = CollectionsKt__CollectionsKt.m26790a();
                a2 = Companion.m23075a(link);
                if (a2 != null) {
                    source = a2.getSource();
                    if (source != null) {
                        url = source.getUrl();
                        mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                        linkPreviewUtil = LinkPreviewUtil.f20852a;
                        a3 = LinkPreviewUtil.m23077a(link);
                        score = link.getScore();
                        hideScore = link.getHideScore();
                        numComments = link.getNumComments();
                        viewCount = link.getViewCount();
                        canMod = link.getCanMod();
                        numReports = link.getNumReports();
                        if (numReports == null) {
                        }
                        userReports = link.getUserReports();
                        modReports = link.getModReports();
                        isRead = link.isRead();
                        hidden = link.getHidden();
                        saved = link.getSaved();
                        url2 = link.getUrl();
                        permalink = link.getPermalink();
                        domain = link.getDomain();
                        subreddit = link.getSubreddit();
                        subredditId = link.getSubredditId();
                        subredditDetail = link.getSubredditDetail();
                        if (subredditDetail == null) {
                        }
                        subredditDetail = link.getSubredditDetail();
                        if (subredditDetail == null) {
                        }
                        subredditDetail = link.getSubredditDetail();
                        if (subredditDetail != null) {
                            over18 = subredditDetail.getOver18();
                            if (over18 != null) {
                                booleanValue = over18.booleanValue();
                                subredditDetail = link.getSubredditDetail();
                                if (subredditDetail != null) {
                                    over18 = subredditDetail.getUserIsModerator();
                                    if (over18 != null) {
                                        booleanValue2 = over18.booleanValue();
                                        crossPostParentList = link.getCrossPostParentList();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        b = m22972b(crossPostParentList);
                                        likes = link.getLikes();
                                        isSelf = link.isSelf();
                                        postHint = link.getPostHint();
                                        locationName = link.getLocationName();
                                        selftext = link.getSelftext();
                                        selftextHtml = link.getSelftextHtml();
                                        isVideo = link.isVideo();
                                        isVideoLinkType = link.isVideoLinkType();
                                        isImageLinkType = link.isImageLinkType();
                                        preview2 = link.getPreview();
                                        media = link.getMedia();
                                        isBlankAd = link.isBlankAd();
                                        crossPostParentList = link.getEvents();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                    }
                                }
                                booleanValue2 = false;
                                crossPostParentList = link.getCrossPostParentList();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                b = m22972b(crossPostParentList);
                                likes = link.getLikes();
                                isSelf = link.isSelf();
                                postHint = link.getPostHint();
                                locationName = link.getLocationName();
                                selftext = link.getSelftext();
                                selftextHtml = link.getSelftextHtml();
                                isVideo = link.isVideo();
                                isVideoLinkType = link.isVideoLinkType();
                                isImageLinkType = link.isImageLinkType();
                                preview2 = link.getPreview();
                                media = link.getMedia();
                                isBlankAd = link.isBlankAd();
                                crossPostParentList = link.getEvents();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                            }
                        }
                        booleanValue = false;
                        subredditDetail = link.getSubredditDetail();
                        if (subredditDetail != null) {
                            over18 = subredditDetail.getUserIsModerator();
                            if (over18 != null) {
                                booleanValue2 = over18.booleanValue();
                                crossPostParentList = link.getCrossPostParentList();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                b = m22972b(crossPostParentList);
                                likes = link.getLikes();
                                isSelf = link.isSelf();
                                postHint = link.getPostHint();
                                locationName = link.getLocationName();
                                selftext = link.getSelftext();
                                selftextHtml = link.getSelftextHtml();
                                isVideo = link.isVideo();
                                isVideoLinkType = link.isVideoLinkType();
                                isImageLinkType = link.isImageLinkType();
                                preview2 = link.getPreview();
                                media = link.getMedia();
                                isBlankAd = link.isBlankAd();
                                crossPostParentList = link.getEvents();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                            }
                        }
                        booleanValue2 = false;
                        crossPostParentList = link.getCrossPostParentList();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        b = m22972b(crossPostParentList);
                        likes = link.getLikes();
                        isSelf = link.isSelf();
                        postHint = link.getPostHint();
                        locationName = link.getLocationName();
                        selftext = link.getSelftext();
                        selftextHtml = link.getSelftextHtml();
                        isVideo = link.isVideo();
                        isVideoLinkType = link.isVideoLinkType();
                        isImageLinkType = link.isImageLinkType();
                        preview2 = link.getPreview();
                        media = link.getMedia();
                        isBlankAd = link.isBlankAd();
                        crossPostParentList = link.getEvents();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                    }
                }
                url = null;
                mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                linkPreviewUtil = LinkPreviewUtil.f20852a;
                a3 = LinkPreviewUtil.m23077a(link);
                score = link.getScore();
                hideScore = link.getHideScore();
                numComments = link.getNumComments();
                viewCount = link.getViewCount();
                canMod = link.getCanMod();
                numReports = link.getNumReports();
                if (numReports == null) {
                }
                userReports = link.getUserReports();
                modReports = link.getModReports();
                isRead = link.isRead();
                hidden = link.getHidden();
                saved = link.getSaved();
                url2 = link.getUrl();
                permalink = link.getPermalink();
                domain = link.getDomain();
                subreddit = link.getSubreddit();
                subredditId = link.getSubredditId();
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail == null) {
                }
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail == null) {
                }
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail != null) {
                    over18 = subredditDetail.getOver18();
                    if (over18 != null) {
                        booleanValue = over18.booleanValue();
                        subredditDetail = link.getSubredditDetail();
                        if (subredditDetail != null) {
                            over18 = subredditDetail.getUserIsModerator();
                            if (over18 != null) {
                                booleanValue2 = over18.booleanValue();
                                crossPostParentList = link.getCrossPostParentList();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                b = m22972b(crossPostParentList);
                                likes = link.getLikes();
                                isSelf = link.isSelf();
                                postHint = link.getPostHint();
                                locationName = link.getLocationName();
                                selftext = link.getSelftext();
                                selftextHtml = link.getSelftextHtml();
                                isVideo = link.isVideo();
                                isVideoLinkType = link.isVideoLinkType();
                                isImageLinkType = link.isImageLinkType();
                                preview2 = link.getPreview();
                                media = link.getMedia();
                                isBlankAd = link.isBlankAd();
                                crossPostParentList = link.getEvents();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                            }
                        }
                        booleanValue2 = false;
                        crossPostParentList = link.getCrossPostParentList();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        b = m22972b(crossPostParentList);
                        likes = link.getLikes();
                        isSelf = link.isSelf();
                        postHint = link.getPostHint();
                        locationName = link.getLocationName();
                        selftext = link.getSelftext();
                        selftextHtml = link.getSelftextHtml();
                        isVideo = link.isVideo();
                        isVideoLinkType = link.isVideoLinkType();
                        isImageLinkType = link.isImageLinkType();
                        preview2 = link.getPreview();
                        media = link.getMedia();
                        isBlankAd = link.isBlankAd();
                        crossPostParentList = link.getEvents();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                    }
                }
                booleanValue = false;
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail != null) {
                    over18 = subredditDetail.getUserIsModerator();
                    if (over18 != null) {
                        booleanValue2 = over18.booleanValue();
                        crossPostParentList = link.getCrossPostParentList();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        b = m22972b(crossPostParentList);
                        likes = link.getLikes();
                        isSelf = link.isSelf();
                        postHint = link.getPostHint();
                        locationName = link.getLocationName();
                        selftext = link.getSelftext();
                        selftextHtml = link.getSelftextHtml();
                        isVideo = link.isVideo();
                        isVideoLinkType = link.isVideoLinkType();
                        isImageLinkType = link.isImageLinkType();
                        preview2 = link.getPreview();
                        media = link.getMedia();
                        isBlankAd = link.isBlankAd();
                        crossPostParentList = link.getEvents();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                    }
                }
                booleanValue2 = false;
                crossPostParentList = link.getCrossPostParentList();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                b = m22972b(crossPostParentList);
                likes = link.getLikes();
                isSelf = link.isSelf();
                postHint = link.getPostHint();
                locationName = link.getLocationName();
                selftext = link.getSelftext();
                selftextHtml = link.getSelftextHtml();
                isVideo = link.isVideo();
                isVideoLinkType = link.isVideoLinkType();
                isImageLinkType = link.isImageLinkType();
                preview2 = link.getPreview();
                media = link.getMedia();
                isBlankAd = link.isBlankAd();
                crossPostParentList = link.getEvents();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
            }
        }
        dashUrl = null;
        hasMp4Url = link.hasMp4Url();
        preview = link.getPreview();
        if (preview != null) {
            images = preview.getImages();
            if (images != null) {
                image = (Image) CollectionsKt___CollectionsKt.m41430d(images);
                if (image != null) {
                    variants = image.getVariants();
                    if (variants != null) {
                        mp4 = variants.getMp4();
                        if (mp4 != null) {
                            images = mp4.getResolutions();
                            if (images != null) {
                                str = c;
                                if ((images.isEmpty() ^ 1) != 0) {
                                    images = null;
                                }
                                if (images != null) {
                                    a = images;
                                    a2 = Companion.m23075a(link);
                                    if (a2 != null) {
                                        source = a2.getSource();
                                        if (source != null) {
                                            url = source.getUrl();
                                            mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                            linkPreviewUtil = LinkPreviewUtil.f20852a;
                                            a3 = LinkPreviewUtil.m23077a(link);
                                            score = link.getScore();
                                            hideScore = link.getHideScore();
                                            numComments = link.getNumComments();
                                            viewCount = link.getViewCount();
                                            canMod = link.getCanMod();
                                            numReports = link.getNumReports();
                                            if (numReports == null) {
                                            }
                                            userReports = link.getUserReports();
                                            modReports = link.getModReports();
                                            isRead = link.isRead();
                                            hidden = link.getHidden();
                                            saved = link.getSaved();
                                            url2 = link.getUrl();
                                            permalink = link.getPermalink();
                                            domain = link.getDomain();
                                            subreddit = link.getSubreddit();
                                            subredditId = link.getSubredditId();
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail == null) {
                                            }
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail == null) {
                                            }
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail != null) {
                                                over18 = subredditDetail.getOver18();
                                                if (over18 != null) {
                                                    booleanValue = over18.booleanValue();
                                                    subredditDetail = link.getSubredditDetail();
                                                    if (subredditDetail != null) {
                                                        over18 = subredditDetail.getUserIsModerator();
                                                        if (over18 != null) {
                                                            booleanValue2 = over18.booleanValue();
                                                            crossPostParentList = link.getCrossPostParentList();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            b = m22972b(crossPostParentList);
                                                            likes = link.getLikes();
                                                            isSelf = link.isSelf();
                                                            postHint = link.getPostHint();
                                                            locationName = link.getLocationName();
                                                            selftext = link.getSelftext();
                                                            selftextHtml = link.getSelftextHtml();
                                                            isVideo = link.isVideo();
                                                            isVideoLinkType = link.isVideoLinkType();
                                                            isImageLinkType = link.isImageLinkType();
                                                            preview2 = link.getPreview();
                                                            media = link.getMedia();
                                                            isBlankAd = link.isBlankAd();
                                                            crossPostParentList = link.getEvents();
                                                            if (crossPostParentList == null) {
                                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                            }
                                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                        }
                                                    }
                                                    booleanValue2 = false;
                                                    crossPostParentList = link.getCrossPostParentList();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    b = m22972b(crossPostParentList);
                                                    likes = link.getLikes();
                                                    isSelf = link.isSelf();
                                                    postHint = link.getPostHint();
                                                    locationName = link.getLocationName();
                                                    selftext = link.getSelftext();
                                                    selftextHtml = link.getSelftextHtml();
                                                    isVideo = link.isVideo();
                                                    isVideoLinkType = link.isVideoLinkType();
                                                    isImageLinkType = link.isImageLinkType();
                                                    preview2 = link.getPreview();
                                                    media = link.getMedia();
                                                    isBlankAd = link.isBlankAd();
                                                    crossPostParentList = link.getEvents();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                }
                                            }
                                            booleanValue = false;
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail != null) {
                                                over18 = subredditDetail.getUserIsModerator();
                                                if (over18 != null) {
                                                    booleanValue2 = over18.booleanValue();
                                                    crossPostParentList = link.getCrossPostParentList();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    b = m22972b(crossPostParentList);
                                                    likes = link.getLikes();
                                                    isSelf = link.isSelf();
                                                    postHint = link.getPostHint();
                                                    locationName = link.getLocationName();
                                                    selftext = link.getSelftext();
                                                    selftextHtml = link.getSelftextHtml();
                                                    isVideo = link.isVideo();
                                                    isVideoLinkType = link.isVideoLinkType();
                                                    isImageLinkType = link.isImageLinkType();
                                                    preview2 = link.getPreview();
                                                    media = link.getMedia();
                                                    isBlankAd = link.isBlankAd();
                                                    crossPostParentList = link.getEvents();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                }
                                            }
                                            booleanValue2 = false;
                                            crossPostParentList = link.getCrossPostParentList();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            b = m22972b(crossPostParentList);
                                            likes = link.getLikes();
                                            isSelf = link.isSelf();
                                            postHint = link.getPostHint();
                                            locationName = link.getLocationName();
                                            selftext = link.getSelftext();
                                            selftextHtml = link.getSelftextHtml();
                                            isVideo = link.isVideo();
                                            isVideoLinkType = link.isVideoLinkType();
                                            isImageLinkType = link.isImageLinkType();
                                            preview2 = link.getPreview();
                                            media = link.getMedia();
                                            isBlankAd = link.isBlankAd();
                                            crossPostParentList = link.getEvents();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                        }
                                    }
                                    url = null;
                                    mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                    linkPreviewUtil = LinkPreviewUtil.f20852a;
                                    a3 = LinkPreviewUtil.m23077a(link);
                                    score = link.getScore();
                                    hideScore = link.getHideScore();
                                    numComments = link.getNumComments();
                                    viewCount = link.getViewCount();
                                    canMod = link.getCanMod();
                                    numReports = link.getNumReports();
                                    if (numReports == null) {
                                    }
                                    userReports = link.getUserReports();
                                    modReports = link.getModReports();
                                    isRead = link.isRead();
                                    hidden = link.getHidden();
                                    saved = link.getSaved();
                                    url2 = link.getUrl();
                                    permalink = link.getPermalink();
                                    domain = link.getDomain();
                                    subreddit = link.getSubreddit();
                                    subredditId = link.getSubredditId();
                                    subredditDetail = link.getSubredditDetail();
                                    if (subredditDetail == null) {
                                    }
                                    subredditDetail = link.getSubredditDetail();
                                    if (subredditDetail == null) {
                                    }
                                    subredditDetail = link.getSubredditDetail();
                                    if (subredditDetail != null) {
                                        over18 = subredditDetail.getOver18();
                                        if (over18 != null) {
                                            booleanValue = over18.booleanValue();
                                            subredditDetail = link.getSubredditDetail();
                                            if (subredditDetail != null) {
                                                over18 = subredditDetail.getUserIsModerator();
                                                if (over18 != null) {
                                                    booleanValue2 = over18.booleanValue();
                                                    crossPostParentList = link.getCrossPostParentList();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    b = m22972b(crossPostParentList);
                                                    likes = link.getLikes();
                                                    isSelf = link.isSelf();
                                                    postHint = link.getPostHint();
                                                    locationName = link.getLocationName();
                                                    selftext = link.getSelftext();
                                                    selftextHtml = link.getSelftextHtml();
                                                    isVideo = link.isVideo();
                                                    isVideoLinkType = link.isVideoLinkType();
                                                    isImageLinkType = link.isImageLinkType();
                                                    preview2 = link.getPreview();
                                                    media = link.getMedia();
                                                    isBlankAd = link.isBlankAd();
                                                    crossPostParentList = link.getEvents();
                                                    if (crossPostParentList == null) {
                                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                    }
                                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                }
                                            }
                                            booleanValue2 = false;
                                            crossPostParentList = link.getCrossPostParentList();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            b = m22972b(crossPostParentList);
                                            likes = link.getLikes();
                                            isSelf = link.isSelf();
                                            postHint = link.getPostHint();
                                            locationName = link.getLocationName();
                                            selftext = link.getSelftext();
                                            selftextHtml = link.getSelftextHtml();
                                            isVideo = link.isVideo();
                                            isVideoLinkType = link.isVideoLinkType();
                                            isImageLinkType = link.isImageLinkType();
                                            preview2 = link.getPreview();
                                            media = link.getMedia();
                                            isBlankAd = link.isBlankAd();
                                            crossPostParentList = link.getEvents();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                        }
                                    }
                                    booleanValue = false;
                                    subredditDetail = link.getSubredditDetail();
                                    if (subredditDetail != null) {
                                        over18 = subredditDetail.getUserIsModerator();
                                        if (over18 != null) {
                                            booleanValue2 = over18.booleanValue();
                                            crossPostParentList = link.getCrossPostParentList();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            b = m22972b(crossPostParentList);
                                            likes = link.getLikes();
                                            isSelf = link.isSelf();
                                            postHint = link.getPostHint();
                                            locationName = link.getLocationName();
                                            selftext = link.getSelftext();
                                            selftextHtml = link.getSelftextHtml();
                                            isVideo = link.isVideo();
                                            isVideoLinkType = link.isVideoLinkType();
                                            isImageLinkType = link.isImageLinkType();
                                            preview2 = link.getPreview();
                                            media = link.getMedia();
                                            isBlankAd = link.isBlankAd();
                                            crossPostParentList = link.getEvents();
                                            if (crossPostParentList == null) {
                                                crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                            }
                                            return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                        }
                                    }
                                    booleanValue2 = false;
                                    crossPostParentList = link.getCrossPostParentList();
                                    if (crossPostParentList == null) {
                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                    }
                                    b = m22972b(crossPostParentList);
                                    likes = link.getLikes();
                                    isSelf = link.isSelf();
                                    postHint = link.getPostHint();
                                    locationName = link.getLocationName();
                                    selftext = link.getSelftext();
                                    selftextHtml = link.getSelftextHtml();
                                    isVideo = link.isVideo();
                                    isVideoLinkType = link.isVideoLinkType();
                                    isImageLinkType = link.isImageLinkType();
                                    preview2 = link.getPreview();
                                    media = link.getMedia();
                                    isBlankAd = link.isBlankAd();
                                    crossPostParentList = link.getEvents();
                                    if (crossPostParentList == null) {
                                        crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                    }
                                    return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                }
                                a = CollectionsKt__CollectionsKt.m26790a();
                                a2 = Companion.m23075a(link);
                                if (a2 != null) {
                                    source = a2.getSource();
                                    if (source != null) {
                                        url = source.getUrl();
                                        mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                        linkPreviewUtil = LinkPreviewUtil.f20852a;
                                        a3 = LinkPreviewUtil.m23077a(link);
                                        score = link.getScore();
                                        hideScore = link.getHideScore();
                                        numComments = link.getNumComments();
                                        viewCount = link.getViewCount();
                                        canMod = link.getCanMod();
                                        numReports = link.getNumReports();
                                        if (numReports == null) {
                                        }
                                        userReports = link.getUserReports();
                                        modReports = link.getModReports();
                                        isRead = link.isRead();
                                        hidden = link.getHidden();
                                        saved = link.getSaved();
                                        url2 = link.getUrl();
                                        permalink = link.getPermalink();
                                        domain = link.getDomain();
                                        subreddit = link.getSubreddit();
                                        subredditId = link.getSubredditId();
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail == null) {
                                        }
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail == null) {
                                        }
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail != null) {
                                            over18 = subredditDetail.getOver18();
                                            if (over18 != null) {
                                                booleanValue = over18.booleanValue();
                                                subredditDetail = link.getSubredditDetail();
                                                if (subredditDetail != null) {
                                                    over18 = subredditDetail.getUserIsModerator();
                                                    if (over18 != null) {
                                                        booleanValue2 = over18.booleanValue();
                                                        crossPostParentList = link.getCrossPostParentList();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        b = m22972b(crossPostParentList);
                                                        likes = link.getLikes();
                                                        isSelf = link.isSelf();
                                                        postHint = link.getPostHint();
                                                        locationName = link.getLocationName();
                                                        selftext = link.getSelftext();
                                                        selftextHtml = link.getSelftextHtml();
                                                        isVideo = link.isVideo();
                                                        isVideoLinkType = link.isVideoLinkType();
                                                        isImageLinkType = link.isImageLinkType();
                                                        preview2 = link.getPreview();
                                                        media = link.getMedia();
                                                        isBlankAd = link.isBlankAd();
                                                        crossPostParentList = link.getEvents();
                                                        if (crossPostParentList == null) {
                                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                        }
                                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                                    }
                                                }
                                                booleanValue2 = false;
                                                crossPostParentList = link.getCrossPostParentList();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                b = m22972b(crossPostParentList);
                                                likes = link.getLikes();
                                                isSelf = link.isSelf();
                                                postHint = link.getPostHint();
                                                locationName = link.getLocationName();
                                                selftext = link.getSelftext();
                                                selftextHtml = link.getSelftextHtml();
                                                isVideo = link.isVideo();
                                                isVideoLinkType = link.isVideoLinkType();
                                                isImageLinkType = link.isImageLinkType();
                                                preview2 = link.getPreview();
                                                media = link.getMedia();
                                                isBlankAd = link.isBlankAd();
                                                crossPostParentList = link.getEvents();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                            }
                                        }
                                        booleanValue = false;
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail != null) {
                                            over18 = subredditDetail.getUserIsModerator();
                                            if (over18 != null) {
                                                booleanValue2 = over18.booleanValue();
                                                crossPostParentList = link.getCrossPostParentList();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                b = m22972b(crossPostParentList);
                                                likes = link.getLikes();
                                                isSelf = link.isSelf();
                                                postHint = link.getPostHint();
                                                locationName = link.getLocationName();
                                                selftext = link.getSelftext();
                                                selftextHtml = link.getSelftextHtml();
                                                isVideo = link.isVideo();
                                                isVideoLinkType = link.isVideoLinkType();
                                                isImageLinkType = link.isImageLinkType();
                                                preview2 = link.getPreview();
                                                media = link.getMedia();
                                                isBlankAd = link.isBlankAd();
                                                crossPostParentList = link.getEvents();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                            }
                                        }
                                        booleanValue2 = false;
                                        crossPostParentList = link.getCrossPostParentList();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        b = m22972b(crossPostParentList);
                                        likes = link.getLikes();
                                        isSelf = link.isSelf();
                                        postHint = link.getPostHint();
                                        locationName = link.getLocationName();
                                        selftext = link.getSelftext();
                                        selftextHtml = link.getSelftextHtml();
                                        isVideo = link.isVideo();
                                        isVideoLinkType = link.isVideoLinkType();
                                        isImageLinkType = link.isImageLinkType();
                                        preview2 = link.getPreview();
                                        media = link.getMedia();
                                        isBlankAd = link.isBlankAd();
                                        crossPostParentList = link.getEvents();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                    }
                                }
                                url = null;
                                mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                                linkPreviewUtil = LinkPreviewUtil.f20852a;
                                a3 = LinkPreviewUtil.m23077a(link);
                                score = link.getScore();
                                hideScore = link.getHideScore();
                                numComments = link.getNumComments();
                                viewCount = link.getViewCount();
                                canMod = link.getCanMod();
                                numReports = link.getNumReports();
                                if (numReports == null) {
                                }
                                userReports = link.getUserReports();
                                modReports = link.getModReports();
                                isRead = link.isRead();
                                hidden = link.getHidden();
                                saved = link.getSaved();
                                url2 = link.getUrl();
                                permalink = link.getPermalink();
                                domain = link.getDomain();
                                subreddit = link.getSubreddit();
                                subredditId = link.getSubredditId();
                                subredditDetail = link.getSubredditDetail();
                                if (subredditDetail == null) {
                                }
                                subredditDetail = link.getSubredditDetail();
                                if (subredditDetail == null) {
                                }
                                subredditDetail = link.getSubredditDetail();
                                if (subredditDetail != null) {
                                    over18 = subredditDetail.getOver18();
                                    if (over18 != null) {
                                        booleanValue = over18.booleanValue();
                                        subredditDetail = link.getSubredditDetail();
                                        if (subredditDetail != null) {
                                            over18 = subredditDetail.getUserIsModerator();
                                            if (over18 != null) {
                                                booleanValue2 = over18.booleanValue();
                                                crossPostParentList = link.getCrossPostParentList();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                b = m22972b(crossPostParentList);
                                                likes = link.getLikes();
                                                isSelf = link.isSelf();
                                                postHint = link.getPostHint();
                                                locationName = link.getLocationName();
                                                selftext = link.getSelftext();
                                                selftextHtml = link.getSelftextHtml();
                                                isVideo = link.isVideo();
                                                isVideoLinkType = link.isVideoLinkType();
                                                isImageLinkType = link.isImageLinkType();
                                                preview2 = link.getPreview();
                                                media = link.getMedia();
                                                isBlankAd = link.isBlankAd();
                                                crossPostParentList = link.getEvents();
                                                if (crossPostParentList == null) {
                                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                                }
                                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                            }
                                        }
                                        booleanValue2 = false;
                                        crossPostParentList = link.getCrossPostParentList();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        b = m22972b(crossPostParentList);
                                        likes = link.getLikes();
                                        isSelf = link.isSelf();
                                        postHint = link.getPostHint();
                                        locationName = link.getLocationName();
                                        selftext = link.getSelftext();
                                        selftextHtml = link.getSelftextHtml();
                                        isVideo = link.isVideo();
                                        isVideoLinkType = link.isVideoLinkType();
                                        isImageLinkType = link.isImageLinkType();
                                        preview2 = link.getPreview();
                                        media = link.getMedia();
                                        isBlankAd = link.isBlankAd();
                                        crossPostParentList = link.getEvents();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                    }
                                }
                                booleanValue = false;
                                subredditDetail = link.getSubredditDetail();
                                if (subredditDetail != null) {
                                    over18 = subredditDetail.getUserIsModerator();
                                    if (over18 != null) {
                                        booleanValue2 = over18.booleanValue();
                                        crossPostParentList = link.getCrossPostParentList();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        b = m22972b(crossPostParentList);
                                        likes = link.getLikes();
                                        isSelf = link.isSelf();
                                        postHint = link.getPostHint();
                                        locationName = link.getLocationName();
                                        selftext = link.getSelftext();
                                        selftextHtml = link.getSelftextHtml();
                                        isVideo = link.isVideo();
                                        isVideoLinkType = link.isVideoLinkType();
                                        isImageLinkType = link.isImageLinkType();
                                        preview2 = link.getPreview();
                                        media = link.getMedia();
                                        isBlankAd = link.isBlankAd();
                                        crossPostParentList = link.getEvents();
                                        if (crossPostParentList == null) {
                                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                        }
                                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                                    }
                                }
                                booleanValue2 = false;
                                crossPostParentList = link.getCrossPostParentList();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                b = m22972b(crossPostParentList);
                                likes = link.getLikes();
                                isSelf = link.isSelf();
                                postHint = link.getPostHint();
                                locationName = link.getLocationName();
                                selftext = link.getSelftext();
                                selftextHtml = link.getSelftextHtml();
                                isVideo = link.isVideo();
                                isVideoLinkType = link.isVideoLinkType();
                                isImageLinkType = link.isImageLinkType();
                                preview2 = link.getPreview();
                                media = link.getMedia();
                                isBlankAd = link.isBlankAd();
                                crossPostParentList = link.getEvents();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                            }
                        }
                    }
                }
            }
        }
        str = c;
        a = CollectionsKt__CollectionsKt.m26790a();
        a2 = Companion.m23075a(link);
        if (a2 != null) {
            source = a2.getSource();
            if (source != null) {
                url = source.getUrl();
                mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
                linkPreviewUtil = LinkPreviewUtil.f20852a;
                a3 = LinkPreviewUtil.m23077a(link);
                score = link.getScore();
                hideScore = link.getHideScore();
                numComments = link.getNumComments();
                viewCount = link.getViewCount();
                canMod = link.getCanMod();
                numReports = link.getNumReports();
                if (numReports == null) {
                }
                userReports = link.getUserReports();
                modReports = link.getModReports();
                isRead = link.isRead();
                hidden = link.getHidden();
                saved = link.getSaved();
                url2 = link.getUrl();
                permalink = link.getPermalink();
                domain = link.getDomain();
                subreddit = link.getSubreddit();
                subredditId = link.getSubredditId();
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail == null) {
                }
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail == null) {
                }
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail != null) {
                    over18 = subredditDetail.getOver18();
                    if (over18 != null) {
                        booleanValue = over18.booleanValue();
                        subredditDetail = link.getSubredditDetail();
                        if (subredditDetail != null) {
                            over18 = subredditDetail.getUserIsModerator();
                            if (over18 != null) {
                                booleanValue2 = over18.booleanValue();
                                crossPostParentList = link.getCrossPostParentList();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                b = m22972b(crossPostParentList);
                                likes = link.getLikes();
                                isSelf = link.isSelf();
                                postHint = link.getPostHint();
                                locationName = link.getLocationName();
                                selftext = link.getSelftext();
                                selftextHtml = link.getSelftextHtml();
                                isVideo = link.isVideo();
                                isVideoLinkType = link.isVideoLinkType();
                                isImageLinkType = link.isImageLinkType();
                                preview2 = link.getPreview();
                                media = link.getMedia();
                                isBlankAd = link.isBlankAd();
                                crossPostParentList = link.getEvents();
                                if (crossPostParentList == null) {
                                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                                }
                                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                            }
                        }
                        booleanValue2 = false;
                        crossPostParentList = link.getCrossPostParentList();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        b = m22972b(crossPostParentList);
                        likes = link.getLikes();
                        isSelf = link.isSelf();
                        postHint = link.getPostHint();
                        locationName = link.getLocationName();
                        selftext = link.getSelftext();
                        selftextHtml = link.getSelftextHtml();
                        isVideo = link.isVideo();
                        isVideoLinkType = link.isVideoLinkType();
                        isImageLinkType = link.isImageLinkType();
                        preview2 = link.getPreview();
                        media = link.getMedia();
                        isBlankAd = link.isBlankAd();
                        crossPostParentList = link.getEvents();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                    }
                }
                booleanValue = false;
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail != null) {
                    over18 = subredditDetail.getUserIsModerator();
                    if (over18 != null) {
                        booleanValue2 = over18.booleanValue();
                        crossPostParentList = link.getCrossPostParentList();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        b = m22972b(crossPostParentList);
                        likes = link.getLikes();
                        isSelf = link.isSelf();
                        postHint = link.getPostHint();
                        locationName = link.getLocationName();
                        selftext = link.getSelftext();
                        selftextHtml = link.getSelftextHtml();
                        isVideo = link.isVideo();
                        isVideoLinkType = link.isVideoLinkType();
                        isImageLinkType = link.isImageLinkType();
                        preview2 = link.getPreview();
                        media = link.getMedia();
                        isBlankAd = link.isBlankAd();
                        crossPostParentList = link.getEvents();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                    }
                }
                booleanValue2 = false;
                crossPostParentList = link.getCrossPostParentList();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                b = m22972b(crossPostParentList);
                likes = link.getLikes();
                isSelf = link.isSelf();
                postHint = link.getPostHint();
                locationName = link.getLocationName();
                selftext = link.getSelftext();
                selftextHtml = link.getSelftextHtml();
                isVideo = link.isVideo();
                isVideoLinkType = link.isVideoLinkType();
                isImageLinkType = link.isImageLinkType();
                preview2 = link.getPreview();
                media = link.getMedia();
                isBlankAd = link.isBlankAd();
                crossPostParentList = link.getEvents();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
            }
        }
        url = null;
        mp4LinkPreviewPresentationModel = new Mp4LinkPreviewPresentationModel(new Mp4PreviewParams(isVideo2, dashUrl, hasMp4Url, a, url, ImgurUtil.m23728a(link.getUrl()), ImgurUtil.m23729b(link.getUrl())));
        linkPreviewUtil = LinkPreviewUtil.f20852a;
        a3 = LinkPreviewUtil.m23077a(link);
        score = link.getScore();
        hideScore = link.getHideScore();
        numComments = link.getNumComments();
        viewCount = link.getViewCount();
        canMod = link.getCanMod();
        numReports = link.getNumReports();
        if (numReports == null) {
        }
        userReports = link.getUserReports();
        modReports = link.getModReports();
        isRead = link.isRead();
        hidden = link.getHidden();
        saved = link.getSaved();
        url2 = link.getUrl();
        permalink = link.getPermalink();
        domain = link.getDomain();
        subreddit = link.getSubreddit();
        subredditId = link.getSubredditId();
        subredditDetail = link.getSubredditDetail();
        if (subredditDetail == null) {
        }
        subredditDetail = link.getSubredditDetail();
        if (subredditDetail == null) {
        }
        subredditDetail = link.getSubredditDetail();
        if (subredditDetail != null) {
            over18 = subredditDetail.getOver18();
            if (over18 != null) {
                booleanValue = over18.booleanValue();
                subredditDetail = link.getSubredditDetail();
                if (subredditDetail != null) {
                    over18 = subredditDetail.getUserIsModerator();
                    if (over18 != null) {
                        booleanValue2 = over18.booleanValue();
                        crossPostParentList = link.getCrossPostParentList();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        b = m22972b(crossPostParentList);
                        likes = link.getLikes();
                        isSelf = link.isSelf();
                        postHint = link.getPostHint();
                        locationName = link.getLocationName();
                        selftext = link.getSelftext();
                        selftextHtml = link.getSelftextHtml();
                        isVideo = link.isVideo();
                        isVideoLinkType = link.isVideoLinkType();
                        isImageLinkType = link.isImageLinkType();
                        preview2 = link.getPreview();
                        media = link.getMedia();
                        isBlankAd = link.isBlankAd();
                        crossPostParentList = link.getEvents();
                        if (crossPostParentList == null) {
                            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                        }
                        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
                    }
                }
                booleanValue2 = false;
                crossPostParentList = link.getCrossPostParentList();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                b = m22972b(crossPostParentList);
                likes = link.getLikes();
                isSelf = link.isSelf();
                postHint = link.getPostHint();
                locationName = link.getLocationName();
                selftext = link.getSelftext();
                selftextHtml = link.getSelftextHtml();
                isVideo = link.isVideo();
                isVideoLinkType = link.isVideoLinkType();
                isImageLinkType = link.isImageLinkType();
                preview2 = link.getPreview();
                media = link.getMedia();
                isBlankAd = link.isBlankAd();
                crossPostParentList = link.getEvents();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
            }
        }
        booleanValue = false;
        subredditDetail = link.getSubredditDetail();
        if (subredditDetail != null) {
            over18 = subredditDetail.getUserIsModerator();
            if (over18 != null) {
                booleanValue2 = over18.booleanValue();
                crossPostParentList = link.getCrossPostParentList();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                b = m22972b(crossPostParentList);
                likes = link.getLikes();
                isSelf = link.isSelf();
                postHint = link.getPostHint();
                locationName = link.getLocationName();
                selftext = link.getSelftext();
                selftextHtml = link.getSelftextHtml();
                isVideo = link.isVideo();
                isVideoLinkType = link.isVideoLinkType();
                isImageLinkType = link.isImageLinkType();
                preview2 = link.getPreview();
                media = link.getMedia();
                isBlankAd = link.isBlankAd();
                crossPostParentList = link.getEvents();
                if (crossPostParentList == null) {
                    crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
                }
                return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
            }
        }
        booleanValue2 = false;
        crossPostParentList = link.getCrossPostParentList();
        if (crossPostParentList == null) {
            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
        }
        b = m22972b(crossPostParentList);
        likes = link.getLikes();
        isSelf = link.isSelf();
        postHint = link.getPostHint();
        locationName = link.getLocationName();
        selftext = link.getSelftext();
        selftextHtml = link.getSelftextHtml();
        isVideo = link.isVideo();
        isVideoLinkType = link.isVideoLinkType();
        isImageLinkType = link.isImageLinkType();
        preview2 = link.getPreview();
        media = link.getMedia();
        isBlankAd = link.isBlankAd();
        crossPostParentList = link.getEvents();
        if (crossPostParentList == null) {
            crossPostParentList = CollectionsKt__CollectionsKt.m26790a();
        }
        return new LinkPresentationModel(linkType, uniqueId, id, hashCode, kindWithId, subredditNamePrefixed, linkFlairText, linkFlairRichText, createdUtc, str, str4, str2, str3, authorCakeday, locationName, archived, gilded, numReports2, stickied, distinguishType, distinguished, locked, approved, quarantine, title, linkFlairText2, authorFlairRichText2, over182, suggestedSort, thumbnail, spoiler, a4, mp4LinkPreviewPresentationModel, a3, authorFlairRichText, selftext, selftextHtml, isBlankAd, crossPostParentList, link.getPromoted(), link.getOutboundLink(), link.getDomainOverride(), score, hideScore, numComments, viewCount, canMod, intValue, userReports, modReports, isRead, hidden, saved, url2, permalink, domain, subreddit, subredditId, keyColor, iconImage, booleanValue, booleanValue2, b, likes, isSelf, postHint, isVideo, isVideoLinkType, isImageLinkType, preview2, media, link);
    }

    public static List<Listable> m22970a(List<? extends ILink> list) {
        Intrinsics.m26847b(list, "links");
        Iterable<ILink> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (ILink iLink : iterable) {
            Object a;
            Intrinsics.m26847b(iLink, "link");
            if (iLink instanceof Link) {
                a = m22969a((Link) iLink);
            } else if (iLink instanceof LiveUpdateEvent) {
                LiveUpdateEvent liveUpdateEvent = (LiveUpdateEvent) iLink;
                a = new LiveUpdateEventPresentationModel(liveUpdateEvent.getId(), liveUpdateEvent.getTitle(), liveUpdateEvent.getViewerCount());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(a);
        }
        return (List) arrayList;
    }

    private static List<LinkPresentationModel> m22972b(List<Link> list) {
        Iterable<Link> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Link a : iterable) {
            arrayList.add(m22969a(a));
        }
        return (List) arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel> m22971a(java.util.List<kotlin.Pair<com.reddit.frontpage.domain.model.Link, com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel.LinkCause>> r23, com.reddit.frontpage.domain.model.Subreddit r24, com.reddit.datalibrary.frontpage.data.model.Account r25, boolean r26) {
        /*
        r0 = r23;
        r1 = "items";
        kotlin.jvm.internal.Intrinsics.m26847b(r0, r1);
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r2 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r0);
        r1.<init>(r2);
        r1 = (java.util.Collection) r1;
        r0 = r0.iterator();
    L_0x0018:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0108;
    L_0x001e:
        r2 = r0.next();
        r2 = (kotlin.Pair) r2;
        r2 = r2.f25267a;
        r2 = (com.reddit.frontpage.domain.model.Link) r2;
        r3 = com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel.f28071n;
        r3 = "link";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r3);
        r3 = new com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
        r5 = r2.getId();
        r4 = r2.getSubredditDetail();
        r6 = 0;
        if (r4 == 0) goto L_0x0042;
    L_0x003c:
        r4 = r4.getIconImage();
        r7 = r4;
        goto L_0x0043;
    L_0x0042:
        r7 = r6;
    L_0x0043:
        r8 = r2.getSubredditNamePrefixed();
        r9 = r2.getCreatedUtc();
        r4 = 0;
        r9 = com.reddit.frontpage.presentation.common.DateUtil.m22705a(r9, r4);
        if (r24 == 0) goto L_0x0058;
    L_0x0052:
        r10 = r24.getUserIsSubscriber();
        if (r10 != 0) goto L_0x0066;
    L_0x0058:
        if (r25 == 0) goto L_0x0065;
    L_0x005a:
        r10 = r25.getSubreddit();
        if (r10 == 0) goto L_0x0065;
    L_0x0060:
        r10 = r10.getUserIsSubscriber();
        goto L_0x0066;
    L_0x0065:
        r10 = r6;
    L_0x0066:
        if (r10 == 0) goto L_0x006d;
    L_0x0068:
        r10 = r10.booleanValue();
        goto L_0x006e;
    L_0x006d:
        r10 = r4;
    L_0x006e:
        r11 = r2.getSubredditDetail();
        if (r11 == 0) goto L_0x0078;
    L_0x0074:
        r6 = r11.getKeyColor();
    L_0x0078:
        r11 = r6;
        r12 = r2.getTitle();
        r13 = r2.getSelftext();
        r6 = r2.getScore();
        r14 = (long) r6;
        r6 = com.reddit.frontpage.util.CountUtil.m23674a(r14);
        r15 = r2.getScore();
        r14 = 1;
        r19 = r0;
        r0 = new java.lang.Object[r14];
        r0[r4] = r6;
        r6 = 2131755015; // 0x7f100007 float:1.9140897E38 double:1.0532269183E-314;
        r0 = com.reddit.frontpage.util.Util.m23959a(r6, r15, r0);
        r6 = "Util.getQuantityString(R…core, friendlyScoreCount)";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r6);
        r20 = r5;
        r4 = r2.getNumComments();
        r4 = com.reddit.frontpage.util.CountUtil.m23674a(r4);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r0);
        r0 = 32;
        r5.append(r0);
        r6 = 2131887327; // 0x7f1204df float:1.9409258E38 double:1.053292289E-314;
        r6 = com.reddit.frontpage.util.Util.m24027f(r6);
        r5.append(r6);
        r5.append(r0);
        r21 = r1;
        r0 = r2.getNumComments();
        r0 = (int) r0;
        r1 = new java.lang.Object[r14];
        r6 = 0;
        r1[r6] = r4;
        r4 = 2131755011; // 0x7f100003 float:1.914089E38 double:1.0532269163E-314;
        r0 = com.reddit.frontpage.util.Util.m23959a(r4, r0, r1);
        r5.append(r0);
        r0 = r5.toString();
        r1 = r2.getId();
        r14 = com.reddit.frontpage.util.Util.m24024f(r1);
        r16 = r2.getLinkType();
        r17 = m22969a(r2);
        r4 = r3;
        r5 = r20;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r0;
        r18 = r26;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18);
        r1 = r21;
        r1.add(r3);
        r0 = r19;
        goto L_0x0018;
    L_0x0108:
        r1 = (java.util.List) r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.listing.model.LinkMapper.a(java.util.List, com.reddit.frontpage.domain.model.Subreddit, com.reddit.datalibrary.frontpage.data.model.Account, boolean):java.util.List<com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel>");
    }
}
