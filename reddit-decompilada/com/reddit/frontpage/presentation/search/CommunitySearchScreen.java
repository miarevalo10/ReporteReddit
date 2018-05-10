package com.reddit.frontpage.presentation.search;

import android.app.Activity;
import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.CommunitySearchComponent.Builder;
import com.reddit.frontpage.di.component.DaggerCommunitySearchComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.common.ui.view.RedditSearchView;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.common.LoadMoreOnScrollListener;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.subscribe.SubscribeRedditView;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21ServicesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ABB\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0014J\u0018\u00103\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\"H\u0016J\u0010\u00109\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010:\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0014J\u0010\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\"H\u0002J\b\u0010?\u001a\u00020\"H\u0016J\b\u0010@\u001a\u00020\"H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006C"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;", "()V", "adapter", "Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen$Adapter;", "currentQuery", "", "getCurrentQuery", "()Ljava/lang/String;", "query", "Lio/reactivex/subjects/BehaviorSubject;", "getQuery", "()Lio/reactivex/subjects/BehaviorSubject;", "recentSearchPresenter", "Lcom/reddit/frontpage/presentation/search/RecentSearchPresenter;", "getRecentSearchPresenter", "()Lcom/reddit/frontpage/presentation/search/RecentSearchPresenter;", "setRecentSearchPresenter", "(Lcom/reddit/frontpage/presentation/search/RecentSearchPresenter;)V", "searchResultsPresenter", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter;", "getSearchResultsPresenter", "()Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter;", "setSearchResultsPresenter", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter;)V", "typeAheadPresenter", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter;", "getTypeAheadPresenter", "()Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter;", "setTypeAheadPresenter", "(Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter;)V", "diffAndSetItems", "", "items", "", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "getLayoutId", "", "hideKeyboard", "navigateToAccount", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "navigateToCommunitySearchSubmission", "navigateToSubreddit", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDetach", "setupSearch", "searchView", "Landroid/support/v7/widget/SearchView;", "showKeyboard", "showLoadError", "showNoResults", "Adapter", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchScreen.kt */
public final class CommunitySearchScreen extends MvpBaseScreen implements View, CommunitySearchNavigator {
    public static final Companion f40136z = new Companion();
    private final Adapter f40137A = new Adapter(this);
    final BehaviorSubject<String> f40138v;
    @Inject
    public RecentSearchPresenter f40139w;
    @Inject
    public CommunityTypeAheadSearchPresenter f40140x;
    @Inject
    public CommunitySearchResultsPresenter f40141y;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen$Companion;", "", "()V", "EMPTY_RESULTS_DISPLAY_CHILD", "", "ERROR_DISPLAY_CHILD", "RESULTS_DISPLAY_CHILD", "newInstance", "Lcom/reddit/frontpage/nav/Screen;", "query", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static Screen m23190a(String str) {
            Intrinsics.m26847b(str, "query");
            CommunitySearchScreen communitySearchScreen = new CommunitySearchScreen();
            communitySearchScreen.f40138v.onNext(str);
            return communitySearchScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen$Adapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/search/SearchItemViewHolder;", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen;)V", "items", "", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "getItems", "()Ljava/util/List;", "listingItemCount", "", "getListingItemCount", "()I", "getItemCount", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchScreen.kt */
    private final class Adapter extends android.support.v7.widget.RecyclerView.Adapter<SearchItemViewHolder> implements LoadMoreListingAdapter {
        final List<CommunitySearchItem> f28757a = ((List) new ArrayList());
        final /* synthetic */ CommunitySearchScreen f28758b;

        public final int mo4926b() {
            return -1;
        }

        public Adapter(CommunitySearchScreen communitySearchScreen) {
            this.f28758b = communitySearchScreen;
        }

        public final FooterState F_() {
            return DefaultImpls.m22929a();
        }

        public final /* synthetic */ ViewHolder m29858a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            switch (i) {
                case 1:
                    i = (SearchItemViewHolder) new RecentSearchItemViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_community_recent_search, false), new CommunitySearchScreen$Adapter$onCreateViewHolder$1(this.f28758b.m40916w()), new CommunitySearchScreen$Adapter$onCreateViewHolder$2(this.f28758b.m40916w()));
                    break;
                case 2:
                    i = (SearchItemViewHolder) new CommunitySearchResultItemViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_community_search_community, false), new CommunitySearchScreen$Adapter$onCreateViewHolder$3(this.f28758b.m40918y()), new CommunitySearchScreen$Adapter$onCreateViewHolder$4(this.f28758b.m40918y()));
                    break;
                case 3:
                    i = (SearchItemViewHolder) new CommunitySearchResultItemViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_community_search_community, false), new CommunitySearchScreen$Adapter$onCreateViewHolder$5(this.f28758b.m40917x()));
                    break;
                case 4:
                    i = (SearchItemViewHolder) new CommunitySearchResultsItemViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_community_search_community_results, false), new CommunitySearchScreen$Adapter$onCreateViewHolder$6(this.f28758b.m40917x()));
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append(" not supported");
                    throw ((Throwable) new IllegalStateException(stringBuilder.toString()));
            }
            return (ViewHolder) i;
        }

        public final /* synthetic */ void m29859a(ViewHolder viewHolder, int i) {
            SearchItemViewHolder searchItemViewHolder = (SearchItemViewHolder) viewHolder;
            Intrinsics.m26847b(searchItemViewHolder, "holder");
            int b = m29861b(i);
            CommunitySearchItem communitySearchItem = (CommunitySearchItem) this.f28757a.get(i);
            Object obj;
            CommunitySearchResultItemViewHolder communitySearchResultItemViewHolder;
            Object obj2;
            switch (b) {
                case 1:
                    RecentSearchItemViewHolder recentSearchItemViewHolder = (RecentSearchItemViewHolder) searchItemViewHolder;
                    if (communitySearchItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.search.RecentSearchItem");
                    }
                    RecentSearchItem recentSearchItem = (RecentSearchItem) communitySearchItem;
                    Intrinsics.m26847b(recentSearchItem, "item");
                    obj = recentSearchItemViewHolder.c;
                    Intrinsics.m26843a(obj, "itemView");
                    obj = (TextView) obj.findViewById(C1761R.id.recent_search);
                    Intrinsics.m26843a(obj, "itemView.recent_search");
                    obj.setText((CharSequence) recentSearchItem.f28780c);
                    Object obj3 = recentSearchItemViewHolder.c;
                    Intrinsics.m26843a(obj3, "itemView");
                    obj3 = (ImageButton) obj3.findViewById(C1761R.id.dismiss_recent_search);
                    Intrinsics.m26843a(obj3, "itemView.dismiss_recent_search");
                    ((android.view.View) obj3).setOnClickListener((OnClickListener) new C1870x197ec4b8(new RecentSearchItemViewHolder$bind$1(recentSearchItemViewHolder)));
                    return;
                case 2:
                    communitySearchResultItemViewHolder = (CommunitySearchResultItemViewHolder) searchItemViewHolder;
                    if (communitySearchItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.search.CommunitySearchResultItem");
                    }
                    CommunitySearchResultItem communitySearchResultItem = (CommunitySearchResultItem) communitySearchItem;
                    Intrinsics.m26847b(communitySearchResultItem, "item");
                    communitySearchResultItemViewHolder.m34871a(communitySearchResultItem.f28748c);
                    return;
                case 3:
                    communitySearchResultItemViewHolder = (CommunitySearchResultItemViewHolder) searchItemViewHolder;
                    if (communitySearchItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.search.CommunitySearchTypeAheadItem");
                    }
                    CommunitySearchTypeAheadItem communitySearchTypeAheadItem = (CommunitySearchTypeAheadItem) communitySearchItem;
                    Intrinsics.m26847b(communitySearchTypeAheadItem, "item");
                    communitySearchResultItemViewHolder.m34871a(communitySearchTypeAheadItem.f28765c);
                    obj = communitySearchResultItemViewHolder.c;
                    Intrinsics.m26843a(obj, "itemView");
                    obj = (SubscribeRedditView) obj.findViewById(C1761R.id.community_subscribe);
                    Intrinsics.m26843a(obj, "itemView.community_subscribe");
                    ViewsKt.m24109d((android.view.View) obj);
                    obj2 = communitySearchResultItemViewHolder.c;
                    Intrinsics.m26843a(obj2, "itemView");
                    obj2 = (TextView) obj2.findViewById(C1761R.id.community_stats);
                    Intrinsics.m26843a(obj2, "itemView.community_stats");
                    obj2.setText((CharSequence) communitySearchTypeAheadItem.f28766d);
                    return;
                case 4:
                    CommunitySearchResultsItemViewHolder communitySearchResultsItemViewHolder = (CommunitySearchResultsItemViewHolder) searchItemViewHolder;
                    if (communitySearchItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.search.CommunitySearchTypeAheadMoreResultsItem");
                    }
                    CommunitySearchTypeAheadMoreResultsItem communitySearchTypeAheadMoreResultsItem = (CommunitySearchTypeAheadMoreResultsItem) communitySearchItem;
                    Intrinsics.m26847b(communitySearchTypeAheadMoreResultsItem, "item");
                    obj2 = communitySearchResultsItemViewHolder.c;
                    Intrinsics.m26843a(obj2, "itemView");
                    obj2 = (TextView) obj2.findViewById(C1761R.id.community_results);
                    Intrinsics.m26843a(obj2, "itemView.community_results");
                    obj2.setText((CharSequence) communitySearchTypeAheadMoreResultsItem.f28769c);
                    return;
                default:
                    i = new StringBuilder();
                    i.append(b);
                    i.append(" not supported");
                    throw ((Throwable) new IllegalStateException(i.toString()));
            }
        }

        public final int m29856a() {
            return this.f28757a.size();
        }

        public final int m29861b(int i) {
            return ((CommunitySearchItem) this.f28757a.get(i)).f20965a;
        }

        public final long m29857a(int i) {
            return ((CommunitySearchItem) this.f28757a.get(i)).f20966b;
        }

        public final int mo4927j() {
            return this.f28757a.size();
        }
    }

    public static final Screen m40902b(String str) {
        return Companion.m23190a(str);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_community_search;
    }

    public CommunitySearchScreen() {
        super();
        Builder a = DaggerCommunitySearchComponent.m29110a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4647a(k).mo4648a((View) this).mo4649a((CommunitySearchNavigator) this).mo4650a().mo4651a(this);
        Object a2 = BehaviorSubject.m38175a();
        Intrinsics.m26843a(a2, "BehaviorSubject.create<String>()");
        this.f40138v = a2;
    }

    public final RecentSearchPresenter m40916w() {
        RecentSearchPresenter recentSearchPresenter = this.f40139w;
        if (recentSearchPresenter == null) {
            Intrinsics.m26844a("recentSearchPresenter");
        }
        return recentSearchPresenter;
    }

    public final CommunityTypeAheadSearchPresenter m40917x() {
        CommunityTypeAheadSearchPresenter communityTypeAheadSearchPresenter = this.f40140x;
        if (communityTypeAheadSearchPresenter == null) {
            Intrinsics.m26844a("typeAheadPresenter");
        }
        return communityTypeAheadSearchPresenter;
    }

    public final CommunitySearchResultsPresenter m40918y() {
        CommunitySearchResultsPresenter communitySearchResultsPresenter = this.f40141y;
        if (communitySearchResultsPresenter == null) {
            Intrinsics.m26844a("searchResultsPresenter");
        }
        return communitySearchResultsPresenter;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        Intrinsics.m26843a(a, "view");
        Object obj = (RedditSearchView) a.findViewById(C1761R.id.search_view);
        Intrinsics.m26843a(obj, "view.search_view");
        SearchView searchView = (SearchView) obj;
        Object am_ = am_();
        if (am_ != null) {
            Intrinsics.m26843a(am_, "activity");
            searchView.setSearchableInfo(Sdk21ServicesKt.m28416b((Context) am_).getSearchableInfo(am_.getComponentName()));
            searchView.setIconifiedByDefault(false);
            searchView.requestFocus();
            searchView.setQuery(mo7429b(), false);
            searchView.setOnQueryTextListener(new CommunitySearchScreen$setupSearch$$inlined$apply$lambda$1(this, am_));
        }
        viewGroup = new LinearLayoutManager(a.getContext());
        LoadMoreOnScrollListener loadMoreOnScrollListener = new LoadMoreOnScrollListener(viewGroup, this.f40137A, new CommunitySearchScreen$onCreateView$1(this));
        am_ = (RecyclerView) a.findViewById(C1761R.id.community_result_list);
        am_.setAdapter(this.f40137A);
        Intrinsics.m26843a(am_, "this");
        am_.setLayoutManager((LayoutManager) viewGroup);
        return a;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40139w;
        if (view == null) {
            Intrinsics.m26844a("recentSearchPresenter");
        }
        view.attach();
        view = this.f40140x;
        if (view == null) {
            Intrinsics.m26844a("typeAheadPresenter");
        }
        view.attach();
        view = this.f40141y;
        if (view == null) {
            Intrinsics.m26844a("searchResultsPresenter");
        }
        view.attach();
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        Util.m23971a((RedditSearchView) obj.findViewById(C1761R.id.search_view));
        if (this.f40138v.m38179b() == null) {
            this.f40138v.onNext(mo7429b());
        }
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40139w;
        if (view == null) {
            Intrinsics.m26844a("recentSearchPresenter");
        }
        view.detach();
        view = this.f40140x;
        if (view == null) {
            Intrinsics.m26844a("typeAheadPresenter");
        }
        view.detach();
        view = this.f40141y;
        if (view == null) {
            Intrinsics.m26844a("searchResultsPresenter");
        }
        view.detach();
    }

    public final void mo7191l() {
        super.mo7191l();
        RecentSearchPresenter recentSearchPresenter = this.f40139w;
        if (recentSearchPresenter == null) {
            Intrinsics.m26844a("recentSearchPresenter");
        }
        recentSearchPresenter.destroy();
        CommunityTypeAheadSearchPresenter communityTypeAheadSearchPresenter = this.f40140x;
        if (communityTypeAheadSearchPresenter == null) {
            Intrinsics.m26844a("typeAheadPresenter");
        }
        communityTypeAheadSearchPresenter.destroy();
        CommunitySearchResultsPresenter communitySearchResultsPresenter = this.f40141y;
        if (communitySearchResultsPresenter == null) {
            Intrinsics.m26844a("searchResultsPresenter");
        }
        communitySearchResultsPresenter.destroy();
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        Object obj = (RecyclerView) view.findViewById(C1761R.id.community_result_list);
        Intrinsics.m26843a(obj, "view.community_result_list");
        obj.setAdapter(null);
        this.f40137A.f28757a.clear();
    }

    public final void mo7430c() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (ViewAnimator) obj.findViewById(C1761R.id.view_animator);
        Intrinsics.m26843a(obj, "rootView.view_animator");
        obj.setDisplayedChild(1);
    }

    public final void mo7428a(List<? extends CommunitySearchItem> list) {
        Intrinsics.m26847b(list, "items");
        DiffResult a = DiffUtil.a(new CommunitySearchScreen$diffAndSetItems$diffResult$1(this, this.f40137A.f28757a, list), false);
        MutableListsKt.m24089a(this.f40137A.f28757a, list);
        a.a((android.support.v7.widget.RecyclerView.Adapter) this.f40137A);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (ViewAnimator) obj.findViewById(C1761R.id.view_animator);
        Intrinsics.m26843a(obj, "rootView.view_animator");
        obj.setDisplayedChild(0);
    }

    public final void mo7426a(Subreddit subreddit) {
        Intrinsics.m26847b(subreddit, "subreddit");
        m40901O();
        Routing.m22623a((Screen) this, Nav.m22566b(subreddit.getDisplayName()));
    }

    public final void mo7425a(Account account) {
        Intrinsics.m26847b(account, "account");
        m40901O();
        Routing.m22623a((Screen) this, Nav.m22551a(account.getUsername(), null));
    }

    public final void mo7427a(String str) {
        Intrinsics.m26847b(str, "query");
        m40901O();
        Screen screen = this;
        Routing.m22621a(screen);
        Routing.m22623a(screen, Nav.m22603n(str));
    }

    private final void m40901O() {
        Activity am_ = am_();
        Util.m23972a(am_ != null ? am_.getCurrentFocus() : null);
    }

    public final /* bridge */ /* synthetic */ Observable mo7424a() {
        return this.f40138v;
    }

    public final String mo7429b() {
        String str = (String) this.f40138v.m38179b();
        return str == null ? "" : str;
    }
}
