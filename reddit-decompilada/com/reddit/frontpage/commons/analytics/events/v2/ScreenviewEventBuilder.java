package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.ActionInfo;
import com.reddit.data.events.models.components.Comment;
import com.reddit.data.events.models.components.Listing;
import com.reddit.data.events.models.components.Post;
import com.reddit.data.events.models.components.Profile;
import com.reddit.data.events.models.components.Subreddit;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.model.AnalyticsPostType;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.util.Platform;
import com.reddit.frontpage.util.SubredditUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\"J0\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004JQ\u0010)\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00132\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "", "()V", "commentAuthorId", "", "commentId", "listingGeoFilter", "listingLength", "", "Ljava/lang/Long;", "listingLinkIds", "", "listingSort", "listingSortTime", "pageType", "postCreatedUtc", "postDomain", "postId", "postIsNsfw", "", "Ljava/lang/Boolean;", "postIsSpoiler", "postTitle", "postType", "Lcom/reddit/frontpage/domain/model/AnalyticsPostType;", "postUrl", "profileId", "profileName", "subredditId", "subredditName", "comment", "id", "authorId", "createBuilder", "Lcom/reddit/data/events/models/Event$Builder;", "listing", "length", "links", "sort", "sortTime", "geoFilter", "post", "type", "title", "isNsfw", "isSpoiler", "url", "domain", "createdUtc", "(Ljava/lang/String;Lcom/reddit/frontpage/domain/model/AnalyticsPostType;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "profile", "name", "send", "", "subreddit", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ScreenviewEventBuilder.kt */
public final class ScreenviewEventBuilder {
    private static final String ACTION = "view";
    public static final Companion Companion = new Companion();
    private static final String LISTING_GEO_FILTER_DEFAULT = "GLOBAL";
    private static final String NOUN = "screen";
    private static final String SOURCE = "global";
    public String commentAuthorId;
    public String commentId;
    public String listingGeoFilter;
    private Long listingLength;
    private List<String> listingLinkIds;
    private String listingSort;
    private String listingSortTime;
    private String pageType;
    private Long postCreatedUtc;
    private String postDomain;
    private String postId;
    private Boolean postIsNsfw = Boolean.valueOf(false);
    private Boolean postIsSpoiler = Boolean.valueOf(false);
    private String postTitle;
    private AnalyticsPostType postType;
    private String postUrl;
    private String profileId;
    private String profileName;
    private String subredditId;
    private String subredditName;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder$Companion;", "", "()V", "ACTION", "", "LISTING_GEO_FILTER_DEFAULT", "NOUN", "SOURCE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ScreenviewEventBuilder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final Builder m21925a() {
        Profile profile;
        Post post;
        Comment comment = null;
        Subreddit build = (this.subredditId == null || this.subredditName == null) ? null : new Subreddit.Builder().id(this.subredditId).name(this.subredditName).build();
        if (this.profileId == null || this.profileName == null) {
            profile = null;
        } else {
            profile = new Profile.Builder().id(this.profileId).name(this.profileName).type(build != null ? "default" : "legacy").build();
        }
        Listing build2 = (this.listingLength == null || this.listingLinkIds == null) ? null : new Listing.Builder().length(this.listingLength).links(this.listingLinkIds).sort(this.listingSort).sort_time_filter(this.listingSortTime).geo_filter(this.listingGeoFilter).build();
        if (this.postId == null || this.postType == null || this.postTitle == null) {
            post = null;
        } else {
            Post.Builder id = new Post.Builder().id(this.postId);
            AnalyticsPostType analyticsPostType = this.postType;
            String name = analyticsPostType != null ? analyticsPostType.name() : null;
            if (name == null) {
                Intrinsics.m26842a();
            }
            if (name == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase = name.toLowerCase();
            Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
            id = id.type(toLowerCase).title(this.postTitle).nsfw(this.postIsNsfw).spoiler(this.postIsSpoiler).url(this.postUrl).domain(this.postDomain);
            if (this.postCreatedUtc != null) {
                Long l = this.postCreatedUtc;
                if (l == null) {
                    Intrinsics.m26842a();
                }
                id.created_timestamp(Long.valueOf(DateUtil.m22703a(l.longValue())));
            }
            post = id.build();
        }
        if (!(this.postId == null || this.commentId == null || this.commentAuthorId == null)) {
            comment = new Comment.Builder().post_id(this.postId).id(this.commentId).build();
        }
        Object comment2 = new Builder().source(SOURCE).action(ACTION).noun(NOUN).action_info(new ActionInfo.Builder().page_type(this.pageType).build()).subreddit(build).profile(profile).listing(build2).post(post).comment(comment);
        Intrinsics.m26843a(comment2, "Event.Builder()\n        …        .comment(comment)");
        return comment2;
    }

    public final void m21931b() {
        Analytics analytics = Analytics.a;
        Builder a = m21925a();
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b = b.c();
        Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
        Analytics.a(a, (AnalyticsSession) b, Platform.f29397a);
    }

    public final ScreenviewEventBuilder m21927a(String str) {
        int i;
        CharSequence charSequence = str;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                i = 0;
                if (i != 0) {
                    Timber.e("Analytics: no page_type for screenview event", new Object[0]);
                }
                this.pageType = str;
                return this;
            }
        }
        i = 1;
        if (i != 0) {
            Timber.e("Analytics: no page_type for screenview event", new Object[0]);
        }
        this.pageType = str;
        return this;
    }

    public final ScreenviewEventBuilder m21929a(String str, String str2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        if ((((CharSequence) ThingUtil.b(str)).length() == 0 ? 1 : 0) != 0) {
            str = new StringBuilder("Analytics: invalid subreddit kindWithId for screenview event (");
            str.append(this.pageType);
            str.append(')');
            Timber.e(str.toString(), new Object[0]);
            return this;
        }
        this.subredditId = ThingUtil.a(str, ThingType.d);
        Object a = SubredditUtil.m23912a(str2);
        Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
        if (a == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        a = a.toLowerCase();
        Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
        this.subredditName = a;
        return this;
    }

    public final ScreenviewEventBuilder m21930b(String str, String str2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        this.profileId = ThingUtil.a(str, ThingType.b);
        Object a = SubredditUtil.m23912a(str2);
        Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
        if (a == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        a = a.toLowerCase();
        Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
        this.profileName = a;
        return this;
    }

    public final ScreenviewEventBuilder m21926a(long j, List<String> list, String str, String str2) {
        Intrinsics.m26847b(list, "links");
        this.listingLength = Long.valueOf(j);
        this.listingLinkIds = list;
        this.listingSort = str;
        this.listingSortTime = str2;
        return this;
    }

    public final ScreenviewEventBuilder m21928a(String str, AnalyticsPostType analyticsPostType, String str2, Boolean bool, Boolean bool2, String str3, String str4, Long l) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(analyticsPostType, "type");
        Intrinsics.m26847b(str2, "title");
        Intrinsics.m26847b(str3, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(str4, "domain");
        this.postId = ThingUtil.a(str, ThingType.c);
        this.postType = analyticsPostType;
        this.postTitle = str2;
        this.postIsNsfw = bool;
        this.postIsSpoiler = bool2;
        this.postUrl = str3;
        this.postDomain = str4;
        this.postCreatedUtc = l;
        return this;
    }
}
