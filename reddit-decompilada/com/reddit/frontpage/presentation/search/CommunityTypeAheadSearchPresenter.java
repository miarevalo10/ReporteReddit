package com.reddit.frontpage.presentation.search;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.model.AccountSearchResultItem;
import com.reddit.frontpage.domain.model.SearchResultItem;
import com.reddit.frontpage.domain.model.SearchType;
import com.reddit.frontpage.domain.model.SubredditSearchResultItem;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.presentation.analytics.SearchAnalytics;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import com.reddit.frontpage.presentation.search.CommunitySearchTypeAheadMoreResultsItem.Companion;
import com.reddit.frontpage.presentation.search.SearchModelsMapper.SearchItemPresentationModel;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&BG\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001eH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchPresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunityTypeAheadSearchPresenter;", "view", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;", "repository", "Lcom/reddit/frontpage/domain/repository/SearchRepository;", "numberFormatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "resourceProvider", "Lcom/reddit/frontpage/domain/common/ResourceProvider;", "accountFormatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "analytics", "Lcom/reddit/frontpage/presentation/analytics/SearchAnalytics;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;Lcom/reddit/frontpage/domain/repository/SearchRepository;Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;Lcom/reddit/frontpage/domain/common/ResourceProvider;Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;Lcom/reddit/frontpage/presentation/analytics/SearchAnalytics;Lcom/reddit/common/rx/PostExecutionThread;)V", "models", "", "Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadItem;", "searchResults", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "attach", "", "mapTypeAheadResult", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result;", "currentQuery", "", "", "onItemClicked", "position", "", "saveClickedQuery", "query", "saveQuery", "Result", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityTypeAheadSearchPresenter.kt */
public final class CommunityTypeAheadSearchPresenter extends CommunitySearchPresenter implements com.reddit.frontpage.presentation.search.CommunitySearchContract.CommunityTypeAheadSearchPresenter {
    private final List<SearchResultItem> f37065a = ((List) new ArrayList());
    private final List<CommunitySearchTypeAheadItem> f37066b = ((List) new ArrayList());
    private final View f37067c;
    private final CommunitySearchNavigator f37068d;
    private final SearchRepository f37069e;
    private final NumberFormatter f37070f;
    private final ResourceProvider f37071g;
    private final AccountFormatter f37072h;
    private final SearchAnalytics f37073i;
    private final PostExecutionThread f37074j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result$Error;", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunityTypeAheadSearchPresenter.kt */
    private static abstract class Result {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result$Error;", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunityTypeAheadSearchPresenter.kt */
        public static final class Error extends Result {
            public static final Error f28770a = new Error();

            private Error() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result$Success;", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result;", "query", "", "moreResultsPresentationModel", "Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadMoreResultsItem;", "searchResults", "", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "models", "Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadItem;", "(Ljava/lang/String;Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadMoreResultsItem;Ljava/util/List;Ljava/util/List;)V", "getModels", "()Ljava/util/List;", "getMoreResultsPresentationModel", "()Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadMoreResultsItem;", "getQuery", "()Ljava/lang/String;", "getSearchResults", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunityTypeAheadSearchPresenter.kt */
        public static final class Success extends Result {
            final String f28771a;
            final CommunitySearchTypeAheadMoreResultsItem f28772b;
            final List<SearchResultItem> f28773c;
            final List<CommunitySearchTypeAheadItem> f28774d;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        Success success = (Success) obj;
                        if (Intrinsics.m26845a(this.f28771a, success.f28771a) && Intrinsics.m26845a(this.f28772b, success.f28772b) && Intrinsics.m26845a(this.f28773c, success.f28773c) && Intrinsics.m26845a(this.f28774d, success.f28774d)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                String str = this.f28771a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                CommunitySearchTypeAheadMoreResultsItem communitySearchTypeAheadMoreResultsItem = this.f28772b;
                hashCode = (hashCode + (communitySearchTypeAheadMoreResultsItem != null ? communitySearchTypeAheadMoreResultsItem.hashCode() : 0)) * 31;
                List list = this.f28773c;
                hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                list = this.f28774d;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(query=");
                stringBuilder.append(this.f28771a);
                stringBuilder.append(", moreResultsPresentationModel=");
                stringBuilder.append(this.f28772b);
                stringBuilder.append(", searchResults=");
                stringBuilder.append(this.f28773c);
                stringBuilder.append(", models=");
                stringBuilder.append(this.f28774d);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public Success(String str, CommunitySearchTypeAheadMoreResultsItem communitySearchTypeAheadMoreResultsItem, List<? extends SearchResultItem> list, List<CommunitySearchTypeAheadItem> list2) {
                Intrinsics.m26847b(str, "query");
                Intrinsics.m26847b(communitySearchTypeAheadMoreResultsItem, "moreResultsPresentationModel");
                Intrinsics.m26847b(list, "searchResults");
                Intrinsics.m26847b(list2, "models");
                super();
                this.f28771a = str;
                this.f28772b = communitySearchTypeAheadMoreResultsItem;
                this.f28773c = list;
                this.f28774d = list2;
            }
        }

        private Result() {
        }
    }

    @Inject
    public CommunityTypeAheadSearchPresenter(View view, CommunitySearchNavigator communitySearchNavigator, SearchRepository searchRepository, NumberFormatter numberFormatter, ResourceProvider resourceProvider, AccountFormatter accountFormatter, SearchAnalytics searchAnalytics, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(communitySearchNavigator, "navigator");
        Intrinsics.m26847b(searchRepository, "repository");
        Intrinsics.m26847b(numberFormatter, "numberFormatter");
        Intrinsics.m26847b(resourceProvider, "resourceProvider");
        Intrinsics.m26847b(accountFormatter, "accountFormatter");
        Intrinsics.m26847b(searchAnalytics, "analytics");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f37067c = view;
        this.f37068d = communitySearchNavigator;
        this.f37069e = searchRepository;
        this.f37070f = numberFormatter;
        this.f37071g = resourceProvider;
        this.f37072h = accountFormatter;
        this.f37073i = searchAnalytics;
        this.f37074j = postExecutionThread;
    }

    public final void attach() {
        SearchRepository searchRepository = this.f37069e;
        Observable filter = this.f37067c.mo7424a().filter(CommunityTypeAheadSearchPresenter$attach$1.f28775a);
        Intrinsics.m26843a((Object) filter, "view.query\n             …ilter { it.isNotEmpty() }");
        Object onErrorReturn = searchRepository.m22487a(filter).map(new CommunityTypeAheadSearchPresenter$attach$2(this)).onErrorReturn(CommunityTypeAheadSearchPresenter$attach$3.f28777a);
        Intrinsics.m26843a(onErrorReturn, "repository\n        .getS…orReturn { Result.Error }");
        onErrorReturn = ObservablesKt.m24092b(onErrorReturn, this.f37074j).subscribe((Consumer) new CommunityTypeAheadSearchPresenter$attach$4(this));
        Intrinsics.m26843a(onErrorReturn, "repository\n        .getS…  }\n          }\n        }");
        handleDispose(onErrorReturn);
    }

    public final void m37454a(int i) {
        if (this.f37066b.size() != 1) {
            if (i != this.f37066b.size()) {
                SearchResultItem searchResultItem = (SearchResultItem) this.f37065a.get(i);
                if (searchResultItem instanceof SubredditSearchResultItem) {
                    SubredditSearchResultItem subredditSearchResultItem = (SubredditSearchResultItem) searchResultItem;
                    m37449a(i, subredditSearchResultItem.getSubreddit().getDisplayName());
                    this.f37068d.mo7426a(subredditSearchResultItem.getSubreddit());
                    return;
                }
                if (searchResultItem instanceof AccountSearchResultItem) {
                    AccountSearchResultItem accountSearchResultItem = (AccountSearchResultItem) searchResultItem;
                    m37449a(i, accountSearchResultItem.getAccount().getUsername());
                    this.f37068d.mo7425a(accountSearchResultItem.getAccount());
                }
                return;
            }
        }
        String b = this.f37067c.mo7429b();
        m37450a(b);
        this.f37068d.mo7427a(b);
        this.f37073i.mo4782b(b);
    }

    private final void m37449a(int i, String str) {
        m37450a(str);
        this.f37073i.mo4783c(i, str);
    }

    private final void m37450a(String str) {
        Object subscribe = CompletablesKt.m24074b(this.f37069e.m22486a(str, SearchType.SUBREDDIT), this.f37074j).subscribe();
        Intrinsics.m26843a(subscribe, "repository.saveQuery(que…ead)\n        .subscribe()");
        handleDispose(subscribe);
    }

    public static final /* synthetic */ Result m37448a(CommunityTypeAheadSearchPresenter communityTypeAheadSearchPresenter, String str, List list) {
        Companion companion = CommunitySearchTypeAheadMoreResultsItem.f28768d;
        CommunitySearchTypeAheadMoreResultsItem a = Companion.m23191a(str, communityTypeAheadSearchPresenter.f37071g);
        Iterable<SearchResultItem> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (SearchResultItem searchResultItem : iterable) {
            SearchModelsMapper searchModelsMapper = SearchModelsMapper.f20973a;
            SearchItemPresentationModel a2 = SearchModelsMapper.m23193a(searchResultItem, communityTypeAheadSearchPresenter.f37071g, communityTypeAheadSearchPresenter.f37070f, communityTypeAheadSearchPresenter.f37072h);
            arrayList.add(new CommunitySearchTypeAheadItem(a2.f20970a, a2.f20971b, a2.f20972c));
        }
        return new Success(str, a, list, (List) arrayList);
    }
}
