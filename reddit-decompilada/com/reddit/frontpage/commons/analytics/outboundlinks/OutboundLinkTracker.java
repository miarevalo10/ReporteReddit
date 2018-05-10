package com.reddit.frontpage.commons.analytics.outboundlinks;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.data.events.models.components.Comment.Builder;
import com.reddit.data.events.models.components.Post;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.OutboundLinkEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OutboundLinkEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OutboundLinkEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OutboundLinkEventBuilder.Source;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.detail.CommentPresentationModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J*\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/outboundlinks/OutboundLinkTracker;", "", "()V", "OUTBOUND_LINK_REQUEST_CODE", "", "correlationId", "Ljava/util/UUID;", "browserClose", "", "launchBrowser", "outboundUrl", "", "outboundLinkClick", "Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder;", "kotlin.jvm.PlatformType", "uri", "uriSource", "screenName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OutboundLinkTracker.kt */
public final class OutboundLinkTracker {
    public static final OutboundLinkTracker f20089a = new OutboundLinkTracker();
    private static UUID f20090b;

    private OutboundLinkTracker() {
    }

    public static final OutboundLinkEventBuilder m21950a(String str, Object obj, String str2) {
        Intrinsics.m26847b(str, "uri");
        Intrinsics.m26847b(obj, "uriSource");
        OutboundLinkEventBuilder v = AppAnalytics.m21885v();
        v.m21919a(Action.Click);
        v.m21920a(Noun.OutboundLink);
        v.m21924b(str);
        Object j;
        if ((obj instanceof Comment) != null) {
            v.m21921a(Source.Comment);
            Comment comment = (Comment) obj;
            if (!(comment == null || comment.getId() == null || comment.j() == null)) {
                str = new Builder().id(ThingUtil.a(comment.getName(), ThingType.a));
                j = comment.j();
                Intrinsics.m26843a(j, "comment.linkId");
                v.commentBuilder = str.post_id(ThingUtil.a(j, ThingType.c)).parent_id(comment.a());
            }
        } else if ((obj instanceof CommentPresentationModel) != null) {
            v.m21921a(Source.Comment);
            CommentPresentationModel commentPresentationModel = (CommentPresentationModel) obj;
            if (commentPresentationModel != null) {
                v.commentBuilder = new Builder().id(ThingUtil.a(commentPresentationModel.f28148a, ThingType.a)).post_id(ThingUtil.a(commentPresentationModel.f28150c, ThingType.c)).parent_id(commentPresentationModel.f28149b);
            }
        } else if ((obj instanceof Link) != null) {
            Source source;
            Link link;
            if (str2 != null) {
                str = str2.hashCode();
                if (str != -409825007) {
                    if (str != 243697872) {
                        if (str == 841698619) {
                            if (str2.equals("community_view") != null) {
                                source = Source.Community;
                                v.m21921a(source);
                                link = (Link) obj;
                                if (!(link == null || link.getName() == null || link.getTitle() == null)) {
                                    str = new Post.Builder().id(ThingUtil.a(link.getName(), ThingType.c));
                                    str2 = AppAnalytics.m21848a(link.getLinkType()).name();
                                    if (str2 != null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    j = str2.toLowerCase();
                                    Intrinsics.m26843a(j, "(this as java.lang.String).toLowerCase()");
                                    v.postBuilder = str.type(j).title(link.getTitle()).nsfw(Boolean.valueOf(link.isNsfw())).spoiler(Boolean.valueOf(link.isSpoiler())).url(link.getUrl()).domain(link.getDomain()).created_timestamp(Long.valueOf(DateUtil.m22703a(link.getCreatedUtc())));
                                }
                            }
                        }
                    } else if (str2.equals("post_detail") != null) {
                        source = Source.PostDetail;
                        v.m21921a(source);
                        link = (Link) obj;
                        str = new Post.Builder().id(ThingUtil.a(link.getName(), ThingType.c));
                        str2 = AppAnalytics.m21848a(link.getLinkType()).name();
                        if (str2 != null) {
                            j = str2.toLowerCase();
                            Intrinsics.m26843a(j, "(this as java.lang.String).toLowerCase()");
                            v.postBuilder = str.type(j).title(link.getTitle()).nsfw(Boolean.valueOf(link.isNsfw())).spoiler(Boolean.valueOf(link.isSpoiler())).url(link.getUrl()).domain(link.getDomain()).created_timestamp(Long.valueOf(DateUtil.m22703a(link.getCreatedUtc())));
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } else if (str2.equals("profile_myposts") != null) {
                    source = Source.Profile;
                    v.m21921a(source);
                    link = (Link) obj;
                    str = new Post.Builder().id(ThingUtil.a(link.getName(), ThingType.c));
                    str2 = AppAnalytics.m21848a(link.getLinkType()).name();
                    if (str2 != null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    j = str2.toLowerCase();
                    Intrinsics.m26843a(j, "(this as java.lang.String).toLowerCase()");
                    v.postBuilder = str.type(j).title(link.getTitle()).nsfw(Boolean.valueOf(link.isNsfw())).spoiler(Boolean.valueOf(link.isSpoiler())).url(link.getUrl()).domain(link.getDomain()).created_timestamp(Long.valueOf(DateUtil.m22703a(link.getCreatedUtc())));
                }
            }
            source = Source.Listing;
            v.m21921a(source);
            link = (Link) obj;
            str = new Post.Builder().id(ThingUtil.a(link.getName(), ThingType.c));
            str2 = AppAnalytics.m21848a(link.getLinkType()).name();
            if (str2 != null) {
                j = str2.toLowerCase();
                Intrinsics.m26843a(j, "(this as java.lang.String).toLowerCase()");
                v.postBuilder = str.type(j).title(link.getTitle()).nsfw(Boolean.valueOf(link.isNsfw())).spoiler(Boolean.valueOf(link.isSpoiler())).url(link.getUrl()).domain(link.getDomain()).created_timestamp(Long.valueOf(DateUtil.m22703a(link.getCreatedUtc())));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            Timber.e("OutboundLinkTracker.outboundLinkClick unidentified source", new Object[null]);
        }
        v.m21923a();
        return v;
    }

    public static final void m21952a(String str) {
        Intrinsics.m26847b(str, "outboundUrl");
        if (f20090b != null) {
            Timber.e("OutboundLinkTracker.launchBrowser.correlationId!=null", new Object[0]);
        }
        f20090b = UUID.randomUUID();
        AppAnalytics.m21885v().m21919a(Action.View).m21920a(Noun.Screen).m21921a(Source.Browser).m21922a(String.valueOf(f20090b)).m21924b(str).m21923a();
    }

    public static final void m21951a() {
        if (f20090b != null) {
            String valueOf = String.valueOf(f20090b);
            f20090b = null;
            AppAnalytics.m21885v().m21919a(Action.Close).m21920a(Noun.Screen).m21921a(Source.Browser).m21922a(valueOf).m21923a();
        }
    }
}
