package com.reddit.frontpage.commons.analytics.events.v2;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.data.events.models.components.ActionInfo.Builder;
import com.reddit.data.events.models.components.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.BaseEventBuilder;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.util.SubredditUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u001c\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u001a\u001a\u00020\u001bR\u0016\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder;", "Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "()V", "actionInfo", "Lcom/reddit/data/events/models/components/ActionInfo$Builder;", "getActionInfo", "()Lcom/reddit/data/events/models/components/ActionInfo$Builder;", "hasActionInfo", "", "action", "Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$Action;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "noun", "Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$Noun;", "pageType", "Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$PageType;", "post", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "prepareAnalytics", "", "source", "Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$Source;", "subredditFromLink", "voteChange", "direction", "", "Action", "Noun", "PageType", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingEventBuilder.kt */
public final class OnboardingEventBuilder extends BaseEventBuilder<OnboardingEventBuilder> {
    private final Builder actionInfo = new Builder();
    private boolean hasActionInfo;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLICK", "DESELECT", "FAIL", "SELECT", "VIEW", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingEventBuilder.kt */
    public enum Action {
        ;
        
        final String value;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BACK", "BODY", "CATEGORY", "CLEAR_VOTE", "COMMENTS", "DONE", "DOWNVOTE", "ENTER_FEED", "EXIT_FEED", "EXPLORE", "LOAD_FEED", "LOAD_MORE_COMMENTS", "POST", "SCREEN", "SHARE", "SKIP", "SUBREDDIT", "SUBSCRIBE", "SUBSCRIBE_TO_ALL", "UPVOTE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingEventBuilder.kt */
    public enum Noun {
        ;
        
        final String value;

        private Noun(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$PageType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RECOMMENDATIONS", "POST_DETAIL", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingEventBuilder.kt */
    public enum PageType {
        ;
        
        public final String value;

        private PageType(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder$Source;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMMENT", "ONBOARDING", "POST", "THEATER_MODE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingEventBuilder.kt */
    public enum Source {
        ;
        
        final String value;

        private Source(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }
    }

    private final Builder m28953c() {
        this.hasActionInfo = true;
        return this.actionInfo;
    }

    public final OnboardingEventBuilder m28958a(PageType pageType) {
        Intrinsics.m26847b(pageType, "pageType");
        OnboardingEventBuilder onboardingEventBuilder = this;
        m28953c().page_type(pageType.value);
        return onboardingEventBuilder;
    }

    public final OnboardingEventBuilder m28960a(SubredditCategory subredditCategory) {
        OnboardingEventBuilder onboardingEventBuilder = this;
        if (subredditCategory != null) {
            Subreddit.Builder builder = onboardingEventBuilder.subredditBuilder;
            subredditCategory = subredditCategory.getName();
            if (subredditCategory == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase = subredditCategory.toLowerCase();
            Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
            builder.category_name(toLowerCase);
            onboardingEventBuilder.subredditSet = true;
        }
        return onboardingEventBuilder;
    }

    public final OnboardingEventBuilder m28955a(Link link) {
        OnboardingEventBuilder onboardingEventBuilder = this;
        if (link != null) {
            Object subredditDetail;
            if (link.getSubredditDetail() != null) {
                subredditDetail = link.getSubredditDetail();
                Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
                subredditDetail = SubredditUtil.m23912a(subredditDetail.b());
                link = link.getSubredditDetail().getName();
                Intrinsics.m26843a(subredditDetail, "subredditName");
                m21889a(link, subredditDetail);
            } else if (link instanceof ClientLink) {
                subredditDetail = ((ClientLink) link).getSubredditId();
                Intrinsics.m26843a(subredditDetail, "link.subredditId");
                link = link.getSubreddit();
                if (link == null) {
                    link = "";
                }
                m21889a(subredditDetail, link);
            }
        }
        return onboardingEventBuilder;
    }

    public final OnboardingEventBuilder m28961b(Link link) {
        OnboardingEventBuilder onboardingEventBuilder = this;
        if (link != null) {
            String a = ThingUtil.a(link.getName(), ThingType.c);
            String name = AppAnalytics.m21848a(link.getLinkType()).name();
            Object title = link.getTitle();
            Intrinsics.m26843a(title, "link.title");
            m21890a(a, name, title);
        }
        return onboardingEventBuilder;
    }

    public final OnboardingEventBuilder m28954a(int i) {
        Noun noun;
        OnboardingEventBuilder onboardingEventBuilder = this;
        switch (i) {
            case -1:
                noun = Noun.DOWNVOTE;
                break;
            case 0:
                noun = Noun.CLEAR_VOTE;
                break;
            case 1:
                noun = Noun.UPVOTE;
                break;
            default:
                noun = 0;
                break;
        }
        if (noun != 0) {
            m28957a(noun);
        }
        return onboardingEventBuilder;
    }

    public final void mo4573b() {
        if (this.hasActionInfo) {
            this.builder.action_info(m28953c().build());
        }
    }

    public final OnboardingEventBuilder m28959a(Source source) {
        Intrinsics.m26847b(source, "source");
        return (OnboardingEventBuilder) super.m21888a(source.value);
    }

    public final OnboardingEventBuilder m28956a(Action action) {
        Intrinsics.m26847b(action, "action");
        return (OnboardingEventBuilder) super.m21892b(action.value);
    }

    public final OnboardingEventBuilder m28957a(Noun noun) {
        Intrinsics.m26847b(noun, "noun");
        return (OnboardingEventBuilder) super.m21895c(noun.value);
    }
}
