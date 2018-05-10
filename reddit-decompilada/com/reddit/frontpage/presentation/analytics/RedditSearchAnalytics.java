package com.reddit.frontpage.presentation.analytics;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.commons.analytics.builders.SearchEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.SearchEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.builders.SearchEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.builders.SearchEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.builders.SearchEventBuilder.Source;
import com.reddit.frontpage.domain.model.Subreddit;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016J,\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016J,\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/analytics/RedditSearchAnalytics;", "Lcom/reddit/frontpage/presentation/analytics/SearchAnalytics;", "()V", "correlationId", "", "onRecentClick", "", "position", "", "query", "onRecentView", "onTypeAhead", "onTypeAheadClick", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "onTypeAheadSubmission", "onTypeAheadView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchAnalytics.kt */
public final class RedditSearchAnalytics implements SearchAnalytics {
    private final String f28062a;

    @Inject
    public RedditSearchAnalytics() {
        Object uuid = UUID.randomUUID().toString();
        Intrinsics.m26843a(uuid, "UUID.randomUUID().toString()");
        this.f28062a = uuid;
    }

    public final void mo4778a(int i, String str) {
        Intrinsics.m26847b(str, "query");
        SearchEventBuilder searchEventBuilder = new SearchEventBuilder();
        searchEventBuilder.m21896d(this.f28062a);
        searchEventBuilder.m28941a((long) i);
        searchEventBuilder.m28943e(str);
        searchEventBuilder.m21888a((String) Source.f20085c.f20087d);
        searchEventBuilder.m21892b(Action.f20069a.f20073d);
        searchEventBuilder.m21895c(Noun.f20075b.f20078d);
        searchEventBuilder.m28944f(PageType.f20079a.f20082c);
        searchEventBuilder.m21891a();
    }

    public final void mo4781b(int i, String str) {
        Intrinsics.m26847b(str, "query");
        SearchEventBuilder searchEventBuilder = new SearchEventBuilder();
        searchEventBuilder.m21896d(this.f28062a);
        searchEventBuilder.m28941a((long) i);
        searchEventBuilder.m28943e(str);
        searchEventBuilder.m21888a((String) Source.f20085c.f20087d);
        searchEventBuilder.m21892b(Action.f20070b.f20073d);
        searchEventBuilder.m21895c(Noun.f20075b.f20078d);
        searchEventBuilder.m28944f(PageType.f20079a.f20082c);
        searchEventBuilder.m21891a();
    }

    public final void mo4780a(String str) {
        Intrinsics.m26847b(str, "query");
        SearchEventBuilder searchEventBuilder = new SearchEventBuilder();
        searchEventBuilder.m21896d(this.f28062a);
        searchEventBuilder.m28943e(str);
        searchEventBuilder.m21888a(Source.f20083a.f20087d);
        searchEventBuilder.m21892b(Action.f20071c.f20073d);
        searchEventBuilder.m21895c(Noun.f20074a.f20078d);
        searchEventBuilder.m28944f(PageType.f20080b.f20082c);
        searchEventBuilder.m21891a();
    }

    public final void mo4779a(int i, String str, Account account, Subreddit subreddit) {
        Intrinsics.m26847b(str, "query");
        SearchEventBuilder searchEventBuilder = new SearchEventBuilder();
        searchEventBuilder.m21896d(this.f28062a);
        searchEventBuilder.m28941a((long) i);
        searchEventBuilder.m28943e(str);
        searchEventBuilder.m21888a((String) Source.f20084b.f20087d);
        searchEventBuilder.m21892b(Action.f20069a.f20073d);
        searchEventBuilder.m21895c(Noun.f20075b.f20078d);
        if (account != null) {
            Intrinsics.m26847b(account, "account");
            searchEventBuilder.f27460a = true;
            i = searchEventBuilder.f27461b;
            i.created_timestamp(Long.valueOf(account.getCreatedUtc()));
            i.has_gold(Boolean.valueOf(account.isGold()));
            i.id(account.getId());
            i.logged_in(Boolean.valueOf(null));
        }
        if (subreddit != null) {
            Intrinsics.m26847b(subreddit, "subreddit");
            searchEventBuilder.m21889a(subreddit.getKindWithId(), subreddit.getDisplayName());
        }
        searchEventBuilder.m28944f(PageType.f20080b.f20082c);
        searchEventBuilder.m21891a();
    }

    public final void mo4783c(int i, String str) {
        Intrinsics.m26847b(str, "query");
        SearchEventBuilder searchEventBuilder = new SearchEventBuilder();
        searchEventBuilder.m21896d(this.f28062a);
        searchEventBuilder.m28941a((long) i);
        searchEventBuilder.m28943e(str);
        searchEventBuilder.m21888a((String) Source.f20084b.f20087d);
        searchEventBuilder.m21892b(Action.f20070b.f20073d);
        searchEventBuilder.m21895c(Noun.f20075b.f20078d);
        searchEventBuilder.m28944f(PageType.f20080b.f20082c);
        searchEventBuilder.m21891a();
    }

    public final void mo4782b(String str) {
        Intrinsics.m26847b(str, "query");
        SearchEventBuilder searchEventBuilder = new SearchEventBuilder();
        searchEventBuilder.m21896d(this.f28062a);
        searchEventBuilder.m28943e(str);
        searchEventBuilder.m21888a(Source.f20084b.f20087d);
        searchEventBuilder.m21892b(Action.f20071c.f20073d);
        searchEventBuilder.m21895c(Noun.f20076c.f20078d);
        searchEventBuilder.m28944f(PageType.f20080b.f20082c);
        searchEventBuilder.m21891a();
    }
}
