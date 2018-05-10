package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.data.events.Analytics;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.data.events.models.Event.Builder;
import com.reddit.data.events.models.components.Comment;
import com.reddit.data.events.models.components.Outbound;
import com.reddit.data.events.models.components.Post;
import com.reddit.data.events.models.components.Profile;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Platform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003'()B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001dJ \u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder;", "", "()V", "builder", "Lcom/reddit/data/events/models/Event$Builder;", "commentBuilder", "Lcom/reddit/data/events/models/components/Comment$Builder;", "outboundBuilder", "Lcom/reddit/data/events/models/components/Outbound$Builder;", "postBuilder", "Lcom/reddit/data/events/models/components/Post$Builder;", "profileBuilder", "Lcom/reddit/data/events/models/components/Profile$Builder;", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder$Action;", "comment", "commentPresentationModel", "Lcom/reddit/frontpage/presentation/detail/CommentPresentationModel;", "correlationId", "", "legacyComment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "noun", "Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder$Noun;", "outbound", "url", "post", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "Lcom/reddit/frontpage/domain/model/Link;", "profile", "id", "name", "hasSubreddit", "", "send", "", "source", "Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder$Source;", "Action", "Noun", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OutboundLinkEventBuilder.kt */
public final class OutboundLinkEventBuilder {
    private final Builder builder = new Builder();
    public Comment.Builder commentBuilder;
    private Outbound.Builder outboundBuilder;
    public Post.Builder postBuilder;
    private Profile.Builder profileBuilder;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Click", "View", "Close", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OutboundLinkEventBuilder.kt */
    public enum Action {
        ;
        
        final String value;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OutboundLink", "Screen", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OutboundLinkEventBuilder.kt */
    public enum Noun {
        ;
        
        final String value;

        private Noun(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OutboundLinkEventBuilder$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Listing", "PostDetail", "Comment", "Community", "Profile", "Browser", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OutboundLinkEventBuilder.kt */
    public enum Source {
        ;
        
        final String value;

        private Source(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    public final OutboundLinkEventBuilder m21922a(String str) {
        Intrinsics.m26847b(str, "correlationId");
        this.builder.correlation_id(str);
        return this;
    }

    public final OutboundLinkEventBuilder m21921a(Source source) {
        Intrinsics.m26847b(source, "source");
        this.builder.source(source.value);
        return this;
    }

    public final OutboundLinkEventBuilder m21919a(Action action) {
        Intrinsics.m26847b(action, "action");
        this.builder.action(action.value);
        return this;
    }

    public final OutboundLinkEventBuilder m21920a(Noun noun) {
        Intrinsics.m26847b(noun, "noun");
        this.builder.noun(noun.value);
        return this;
    }

    public final OutboundLinkEventBuilder m21924b(String str) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        this.outboundBuilder = new Outbound.Builder();
        Outbound.Builder builder = this.outboundBuilder;
        if (builder != null) {
            builder.url(str);
        }
        return this;
    }

    public final void m21923a() {
        Builder builder;
        if (this.outboundBuilder != null) {
            builder = this.builder;
            Outbound.Builder builder2 = this.outboundBuilder;
            if (builder2 == null) {
                Intrinsics.m26842a();
            }
            builder.outbound(builder2.build());
        }
        if (this.postBuilder != null) {
            builder = this.builder;
            Post.Builder builder3 = this.postBuilder;
            if (builder3 == null) {
                Intrinsics.m26842a();
            }
            builder.post(builder3.build());
        }
        if (this.commentBuilder != null) {
            builder = this.builder;
            Comment.Builder builder4 = this.commentBuilder;
            if (builder4 == null) {
                Intrinsics.m26842a();
            }
            builder.comment(builder4.build());
        }
        if (this.profileBuilder != null) {
            builder = this.builder;
            Profile.Builder builder5 = this.profileBuilder;
            if (builder5 == null) {
                Intrinsics.m26842a();
            }
            builder.profile(builder5.build());
        }
        Analytics analytics = Analytics.a;
        builder = this.builder;
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b = b.c();
        Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
        Analytics.a(builder, (AnalyticsSession) b, Platform.f29397a);
    }
}
