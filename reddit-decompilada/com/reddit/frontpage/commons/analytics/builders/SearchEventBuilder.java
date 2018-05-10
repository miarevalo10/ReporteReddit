package com.reddit.frontpage.commons.analytics.builders;

import com.reddit.data.events.models.components.ActionInfo;
import com.reddit.data.events.models.components.Search;
import com.reddit.data.events.models.components.User.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/SearchEventBuilder;", "Lcom/reddit/frontpage/commons/analytics/builders/BaseEventBuilder;", "()V", "actionInfo", "Lcom/reddit/data/events/models/components/ActionInfo$Builder;", "hasUser", "", "search", "Lcom/reddit/data/events/models/components/Search$Builder;", "user", "Lcom/reddit/data/events/models/components/User$Builder;", "prepareAnalytics", "", "setAccount", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "setPageType", "pageType", "", "setPosition", "position", "", "setQuery", "query", "setSubreddit", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Action", "Noun", "PageType", "Source", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchEventBuilder.kt */
public final class SearchEventBuilder extends BaseEventBuilder<SearchEventBuilder> {
    public boolean f27460a;
    public final Builder f27461b = new Builder();
    private final ActionInfo.Builder f27462c = new ActionInfo.Builder();
    private final Search.Builder f27463d = new Search.Builder();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/SearchEventBuilder$Action;", "", "actionName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "VIEW", "CLICK", "SEND", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SearchEventBuilder.kt */
    public enum Action {
        ;
        
        public final String f20073d;

        private Action(String str) {
            Intrinsics.m26847b(str, "actionName");
            this.f20073d = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/SearchEventBuilder$Noun;", "", "nounName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getNounName", "()Ljava/lang/String;", "SEARCH_REQUEST", "SEARCH_RESULTS", "SEARCH_SUBMISSION", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SearchEventBuilder.kt */
    public enum Noun {
        ;
        
        public final String f20078d;

        private Noun(String str) {
            Intrinsics.m26847b(str, "nounName");
            this.f20078d = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/SearchEventBuilder$PageType;", "", "pageTypeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPageTypeName", "()Ljava/lang/String;", "RECENT", "TYPE_AHEAD", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SearchEventBuilder.kt */
    public enum PageType {
        ;
        
        public final String f20082c;

        private PageType(String str) {
            Intrinsics.m26847b(str, "pageTypeName");
            this.f20082c = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/builders/SearchEventBuilder$Source;", "", "sourceName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "TYPE_AHEAD", "TYPE_AHEAD_DETAIL", "RECENT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SearchEventBuilder.kt */
    public enum Source {
        ;
        
        public final String f20087d;

        private Source(String str) {
            Intrinsics.m26847b(str, "sourceName");
            this.f20087d = str;
        }
    }

    public final void m28943e(String str) {
        Intrinsics.m26847b(str, "query");
        this.f27463d.query(str);
    }

    public final void m28941a(long j) {
        this.f27462c.position(Long.valueOf(j));
    }

    public final void m28944f(String str) {
        Intrinsics.m26847b(str, "pageType");
        this.f27462c.page_type(str);
    }

    public final void mo4573b() {
        if (this.f27460a) {
            this.builder.user(this.f27461b.build());
        }
        this.builder.search(this.f27463d.build());
    }
}
