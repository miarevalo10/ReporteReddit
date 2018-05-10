package com.reddit.frontpage.presentation.search;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.model.AccountSearchResultItem;
import com.reddit.frontpage.domain.model.SearchResult;
import com.reddit.frontpage.domain.model.SearchResultItem;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditSearchResultItem;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import com.reddit.frontpage.ui.profile.profilesettings.model.AccountMapper;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00018BG\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0002J3\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\"0*H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\b\u00102\u001a\u00020\"H\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u00104\u001a\u00020\"H\u0002J\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020(06*\b\u0012\u0004\u0012\u00020706H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchPresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunitySearchResultsPresenter;", "view", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;", "repository", "Lcom/reddit/frontpage/domain/repository/SearchRepository;", "resourceProvider", "Lcom/reddit/frontpage/domain/common/ResourceProvider;", "numberFormatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "accountFormatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;Lcom/reddit/frontpage/domain/repository/SearchRepository;Lcom/reddit/frontpage/domain/common/ResourceProvider;Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;Lcom/reddit/frontpage/domain/repository/SubredditRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "after", "", "isLoadingMore", "", "loadMoreDisposable", "Lio/reactivex/disposables/Disposable;", "models", "", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultItem;", "query", "searchDisposable", "searchResults", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "attach", "", "clearSearchState", "detach", "diffModelsOnView", "handleSearchResult", "result", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result;", "onSuccess", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result$Success;", "Lkotlin/ParameterName;", "name", "onItemClicked", "position", "", "onItemSubscribed", "onLoadMoreMore", "onQuerySubmitted", "onSearchError", "mapToResult", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/SearchResult;", "Result", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchResultsPresenter.kt */
public final class CommunitySearchResultsPresenter extends CommunitySearchPresenter implements com.reddit.frontpage.presentation.search.CommunitySearchContract.CommunitySearchResultsPresenter {
    String f37049a;
    String f37050b;
    final List<SearchResultItem> f37051c = ((List) new ArrayList());
    boolean f37052d;
    Disposable f37053e;
    final CommunitySearchNavigator f37054f;
    final SearchRepository f37055g;
    final PostExecutionThread f37056h;
    private final List<CommunitySearchResultItem> f37057i = ((List) new ArrayList());
    private Disposable f37058j;
    private final View f37059k;
    private final ResourceProvider f37060l;
    private final NumberFormatter f37061m;
    private final AccountFormatter f37062n;
    private final SubredditRepository f37063o;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result$Error;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchResultsPresenter.kt */
    private static abstract class Result {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result$Error;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitySearchResultsPresenter.kt */
        public static final class Error extends Result {
            public static final Error f28751a = new Error();

            private Error() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result$Success;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result;", "result", "Lcom/reddit/frontpage/domain/model/SearchResult;", "models", "", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultItem;", "(Lcom/reddit/frontpage/domain/model/SearchResult;Ljava/util/List;)V", "getModels", "()Ljava/util/List;", "getResult", "()Lcom/reddit/frontpage/domain/model/SearchResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitySearchResultsPresenter.kt */
        public static final class Success extends Result {
            final SearchResult f28752a;
            final List<CommunitySearchResultItem> f28753b;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        Success success = (Success) obj;
                        if (Intrinsics.m26845a(this.f28752a, success.f28752a) && Intrinsics.m26845a(this.f28753b, success.f28753b)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                SearchResult searchResult = this.f28752a;
                int i = 0;
                int hashCode = (searchResult != null ? searchResult.hashCode() : 0) * 31;
                List list = this.f28753b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(result=");
                stringBuilder.append(this.f28752a);
                stringBuilder.append(", models=");
                stringBuilder.append(this.f28753b);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public Success(SearchResult searchResult, List<CommunitySearchResultItem> list) {
                Intrinsics.m26847b(searchResult, "result");
                Intrinsics.m26847b(list, "models");
                super();
                this.f28752a = searchResult;
                this.f28753b = list;
            }
        }

        private Result() {
        }
    }

    public final void attach() {
    }

    @Inject
    public CommunitySearchResultsPresenter(View view, CommunitySearchNavigator communitySearchNavigator, SearchRepository searchRepository, ResourceProvider resourceProvider, NumberFormatter numberFormatter, AccountFormatter accountFormatter, SubredditRepository subredditRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(communitySearchNavigator, "navigator");
        Intrinsics.m26847b(searchRepository, "repository");
        Intrinsics.m26847b(resourceProvider, "resourceProvider");
        Intrinsics.m26847b(numberFormatter, "numberFormatter");
        Intrinsics.m26847b(accountFormatter, "accountFormatter");
        Intrinsics.m26847b(subredditRepository, "subredditRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f37059k = view;
        this.f37054f = communitySearchNavigator;
        this.f37055g = searchRepository;
        this.f37060l = resourceProvider;
        this.f37061m = numberFormatter;
        this.f37062n = accountFormatter;
        this.f37063o = subredditRepository;
        this.f37056h = postExecutionThread;
    }

    public final void detach() {
        super.detach();
        Disposable disposable = this.f37058j;
        if (disposable != null) {
            disposable.mo5626a();
        }
        disposable = this.f37053e;
        if (disposable != null) {
            disposable.mo5626a();
        }
    }

    public final void m37422a(int i) {
        Object kindWithId;
        Object subredditSearchResultItem;
        CommunityPresentationModel a;
        C2886xb8dec0e6 c2886xb8dec0e6;
        int i2 = i;
        SearchResultItem searchResultItem = (SearchResultItem) this.f37051c.get(i2);
        CommunitySearchResultItem communitySearchResultItem = (CommunitySearchResultItem) this.f37057i.get(i2);
        boolean z = communitySearchResultItem.f28749d ^ 1;
        if (searchResultItem instanceof SubredditSearchResultItem) {
            Subreddit copy$default = Subreddit.copy$default(((SubredditSearchResultItem) searchResultItem).getSubreddit(), null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, null, null, false, null, null, null, null, null, null, null, null, Boolean.valueOf(z), null, 402653183, null);
            kindWithId = copy$default.getKindWithId();
            subredditSearchResultItem = new SubredditSearchResultItem(copy$default);
            SearchModelsMapper searchModelsMapper = SearchModelsMapper.f20973a;
            a = SearchModelsMapper.m23192a(copy$default);
        } else if (searchResultItem instanceof AccountSearchResultItem) {
            AccountSearchResultItem accountSearchResultItem = (AccountSearchResultItem) searchResultItem;
            Account account = accountSearchResultItem.getAccount();
            UserSubreddit subreddit = accountSearchResultItem.getAccount().getSubreddit();
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
            Account copy$default2 = Account.copy$default(account, null, null, 0, false, false, false, null, false, 0, 0, false, false, null, 0, false, false, false, 0, UserSubreddit.copy$default(subreddit, null, null, null, null, null, null, null, null, null, false, null, null, 0, false, null, false, null, null, null, null, Boolean.valueOf(z), false, 3145727, null), null, null, 1835007, null);
            UserSubreddit subreddit2 = copy$default2.getSubreddit();
            if (subreddit2 == null) {
                Intrinsics.m26842a();
            }
            kindWithId = subreddit2.getKindWithId();
            subredditSearchResultItem = new AccountSearchResultItem(copy$default2);
            AccountMapper accountMapper = AccountMapper.f21543a;
            a = AccountMapper.m23603b(copy$default2);
        } else {
            throw new IllegalStateException("Unhandled search result item type");
        }
        r0.f37051c.set(i2, subredditSearchResultItem);
        r0.f37057i.set(i2, CommunitySearchResultItem.m29855a(communitySearchResultItem, a, z));
        if (z) {
            c2886xb8dec0e6 = new C2886xb8dec0e6(r0.f37063o);
        } else {
            c2886xb8dec0e6 = new C2887xb8dec0e7(r0.f37063o);
        }
        Object subscribe = ((Completable) c2886xb8dec0e6.mo6492a(kindWithId)).subscribe();
        Intrinsics.m26843a(subscribe, "subredditSubscribeAction(kindWithId).subscribe()");
        handleDispose(subscribe);
    }

    public static final /* synthetic */ void m37414a(CommunitySearchResultsPresenter communitySearchResultsPresenter, Result result, Function1 function1) {
        if (Intrinsics.m26845a((Object) result, Error.f28751a)) {
            communitySearchResultsPresenter.f37059k.mo7430c();
            return;
        }
        if ((result instanceof Success) != null) {
            function1.mo6492a(result);
        }
    }
}
