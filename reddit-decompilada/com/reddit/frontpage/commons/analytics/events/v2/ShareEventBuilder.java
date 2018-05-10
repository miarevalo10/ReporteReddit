package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.Post;
import com.reddit.data.events.models.components.Subreddit;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.util.Platform;
import com.reddit.frontpage.util.SubredditUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u001a\u0010\u0014\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder;", "", "()V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Action;", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "noun", "Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Noun;", "post", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "Lcom/reddit/frontpage/domain/model/Link;", "save", "send", "", "source", "Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Source;", "subreddit", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Subreddit;", "id", "", "name", "target", "app", "Action", "Companion", "Noun", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ShareEventBuilder.kt */
public final class ShareEventBuilder {
    public static final Companion Companion = new Companion();
    public final Builder builder = new Builder();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Clicked", "ShareComplete", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ShareEventBuilder.kt */
    public enum Action {
        ;
        
        final String value;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Companion;", "", "()V", "clear", "", "restore", "Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ShareEventBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ShareEventBuilder m21932a() {
            Object a = InternalSettings.a();
            Intrinsics.m26843a(a, "InternalSettings.getInstance()");
            ShareEventBuilder j = a.j();
            return j != null ? j : null;
        }

        public static void m21933b() {
            InternalSettings.a().i();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Share", "ShareSuccess", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ShareEventBuilder.kt */
    public enum Noun {
        ;
        
        final String value;

        private Noun(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/ShareEventBuilder$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PostListing", "PostDetail", "CommentOverflow", "PostShareComplete", "CommentShareComplete", "TheaterMode", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ShareEventBuilder.kt */
    public enum Source {
        ;
        
        final String value;

        private Source(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    public static final ShareEventBuilder m21934c() {
        return Companion.m21932a();
    }

    public static final void m21935d() {
        Companion.m21933b();
    }

    public final ShareEventBuilder m21941a(Source source) {
        Intrinsics.m26847b(source, "source");
        this.builder.source(source.value);
        return this;
    }

    public final ShareEventBuilder m21939a(Action action) {
        Intrinsics.m26847b(action, "action");
        this.builder.action(action.value);
        return this;
    }

    public final ShareEventBuilder m21940a(Noun noun) {
        Intrinsics.m26847b(noun, "noun");
        this.builder.noun(noun.value);
        return this;
    }

    public final ShareEventBuilder m21943a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            Builder builder = this.builder;
            str = new Subreddit.Builder().id(ThingUtil.a(str, ThingType.d));
            Object a = SubredditUtil.m23912a(str2);
            Intrinsics.m26843a(a, "SubredditUtil.stripSubredditPrefix(name)");
            if (a == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            a = a.toLowerCase();
            Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
            builder.subreddit(str.name(a).build());
        }
        return this;
    }

    public final ShareEventBuilder m21937a(com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit) {
        if (!(subreddit == null || subreddit.getName() == null || subreddit.b() == null)) {
            Builder builder = this.builder;
            Subreddit.Builder id = new Subreddit.Builder().id(ThingUtil.a(subreddit.getName(), ThingType.d));
            Object a = SubredditUtil.m23912a(subreddit.b());
            Intrinsics.m26843a(a, "SubredditUtil.stripSubre…ix(subreddit.displayName)");
            if (a == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            a = a.toLowerCase();
            Intrinsics.m26843a(a, "(this as java.lang.String).toLowerCase()");
            builder.subreddit(id.name(a).build());
        }
        return this;
    }

    public final ShareEventBuilder m21938a(Link link) {
        if (!(link == null || link.getName() == null || link.getTitle() == null)) {
            Builder builder = this.builder;
            Post.Builder id = new Post.Builder().id(ThingUtil.a(link.getName(), ThingType.c));
            String name = AppAnalytics.m21848a(link.getLinkType()).name();
            if (name == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase = name.toLowerCase();
            Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
            builder.post(id.type(toLowerCase).title(link.getTitle()).nsfw(Boolean.valueOf(link.isNsfw())).spoiler(Boolean.valueOf(link.isSpoiler())).url(link.getUrl()).domain(link.getDomain()).created_timestamp(Long.valueOf(DateUtil.m22703a(link.getCreatedUtc()))).build());
        }
        return this;
    }

    public final ShareEventBuilder m21942a(com.reddit.frontpage.domain.model.Link link) {
        Intrinsics.m26847b(link, "link");
        Builder builder = this.builder;
        Post.Builder id = new Post.Builder().id(ThingUtil.a(link.getId(), ThingType.c));
        String name = link.getAnalyticsPostType().name();
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = name.toLowerCase();
        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        builder.post(id.type(toLowerCase).title(link.getTitle()).nsfw(Boolean.valueOf(link.getOver18())).spoiler(Boolean.valueOf(link.getSpoiler())).url(link.getUrl()).domain(link.getDomain()).created_timestamp(Long.valueOf(DateUtil.m22703a(link.getCreatedUtc()))).build());
        return this;
    }

    public final ShareEventBuilder m21936a(Comment comment) {
        if (!(comment == null || comment.getId() == null || comment.j() == null)) {
            Builder builder = this.builder;
            com.reddit.data.events.models.components.Comment.Builder id = new com.reddit.data.events.models.components.Comment.Builder().id(ThingUtil.a(comment.getName(), ThingType.a));
            Object j = comment.j();
            Intrinsics.m26843a(j, "comment.linkId");
            id = id.post_id(ThingUtil.a(j, ThingType.c));
            Object a = comment.a();
            Intrinsics.m26843a(a, "comment.parentId");
            builder.comment(id.parent_id(ThingUtil.a(a, ThingType.a)).build());
        }
        return this;
    }

    public final void m21944a() {
        Analytics analytics = Analytics.a;
        Builder builder = this.builder;
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b = b.c();
        Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
        Analytics.a(builder, (AnalyticsSession) b, Platform.f29397a);
    }

    public final ShareEventBuilder m21945b() {
        InternalSettings.a().a(this);
        return this;
    }
}
