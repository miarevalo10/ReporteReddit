package com.reddit.frontpage.ui.search;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.NetworkError;
import com.android.volley.ServerError;
import com.evernote.android.state.State;
import com.google.common.collect.ImmutableList;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.common.SearchSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.datalibrary.frontpage.data.provider.LinkSearchListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkSearchListingProvider.LinkSearchErrorEvent;
import com.reddit.datalibrary.frontpage.data.provider.LinkSearchListingProvider.LinkSearchEvent;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditLinkSearchListingProvider;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.Util;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

public class LinkSearchResultScreen extends BaseScreen implements Searchable {
    private static final List<SortOption<SearchSortType>> f39308O;
    private static final SortOption<SearchSortType> f39309P;
    private LinearLayout f39310A;
    private TextView f39311B;
    private TextView f39312C;
    private SearchView f39313D;
    private LinkSearchListingProvider f39314E;
    private RecyclerHeaderFooterAdapter f39315F;
    private LinkResultAdapter f39316G;
    private final int f39317H = 103;
    private final CompositeDisposable f39318M = new CompositeDisposable();
    private final PublishSubject<SortSelection<SearchSortType>> f39319N = PublishSubject.create();
    @State
    boolean multireddit;
    @State
    String query;
    @State
    String searchContext;
    @State
    int sortId = 0;
    @State
    int timeframeId = 5;
    private RecyclerView f39320v;
    private View f39321w;
    private View f39322x;
    private TextView f39323y;
    private ViewGroup f39324z;

    class C23692 implements Observer<SortSelection<SearchSortType>> {
        final /* synthetic */ LinkSearchResultScreen f29290a;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        C23692(LinkSearchResultScreen linkSearchResultScreen) {
            this.f29290a = linkSearchResultScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            SortSelection sortSelection = (SortSelection) obj;
            if (this.f29290a.e) {
                LinkSearchResultScreen.m39484a(this.f29290a, sortSelection);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f29290a.f39318M.mo5631a(disposable);
        }
    }

    class LinkResultAdapter extends Adapter {
        final /* synthetic */ LinkSearchResultScreen f29294a;
        private CardLinkAdapter f29295b = new CardLinkAdapter(this, this.f29294a.am_()) {
            final /* synthetic */ LinkResultAdapter f34456a;

            public final boolean mo6477c() {
                return true;
            }

            public final /* synthetic */ Listable mo6476c(int i) {
                return C26961.m35227i();
            }

            public final /* synthetic */ Object mo4996g(int i) {
                return C26961.m35227i();
            }

            private static Link m35227i() {
                throw new RuntimeException("Unexpected call to getItem()");
            }

            public final int m35228a() {
                throw new RuntimeException("Unexpected call to getItemCount()");
            }

            protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
                throw new RuntimeException("Unexpected call to navigateToPostDetail()");
            }
        };

        LinkResultAdapter(LinkSearchResultScreen linkSearchResultScreen) {
            this.f29294a = linkSearchResultScreen;
        }

        public final ViewHolder m30379a(ViewGroup viewGroup, int i) {
            if (i != 103) {
                return this.f29295b.m30219c(viewGroup, i);
            }
            viewGroup = LayoutInflater.from(this.f29294a.am_()).inflate(C1761R.layout.listitem_header_subreddit_search, viewGroup, false);
            i = viewGroup.findViewById(C1761R.id.sort_options);
            this.f29294a.f39323y = (TextView) i.findViewById(C1761R.id.sort_name);
            this.f29294a.f39323y.setText(Sorting.m21806a(this.f29294a.f39314E.e));
            i.setOnClickListener(new LinkSearchResultScreen$LinkResultAdapter$$Lambda$0(this));
            return new ViewHolder(this, viewGroup) {
                final /* synthetic */ LinkResultAdapter f29293a;
            };
        }

        public final void m30380a(ViewHolder viewHolder, int i) {
            if (i != 0) {
                LinkViewHolder linkViewHolder = (LinkViewHolder) viewHolder;
                Link link = (Link) ((LinkWrapper) this.f29294a.f39314E.a(i - 1)).getData();
                linkViewHolder.mo7002a(link);
                linkViewHolder.c.setOnClickListener(new LinkSearchResultScreen$LinkResultAdapter$$Lambda$1(this, link));
                linkViewHolder.m35120a(new LinkSearchResultScreen$LinkResultAdapter$$Lambda$2(this, link));
            }
        }

        public final int m30378a() {
            return this.f29294a.f39314E.c();
        }

        public final int m30381b(int i) {
            if (i == 0) {
                return 103;
            }
            return Util.m23994b((Link) ((LinkWrapper) this.f29294a.f39314E.a(i + -1)).getData()) == 0 ? 3 : 10;
        }
    }

    public String getAnalyticsScreenName() {
        return "subreddit_search_results";
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_search;
    }

    static {
        List a = ImmutableList.a(new SortOption(C1761R.drawable.ic_icon_sort_hot, C1761R.string.label_sort_most_relevant, SearchSortType.a, false), new SortOption(C1761R.drawable.ic_icon_sort_new, C1761R.string.label_sort_new, SearchSortType.c, false), new SortOption(C1761R.drawable.ic_icon_sort_top, C1761R.string.label_sort_top, SearchSortType.b, true), new SortOption(C1761R.drawable.ic_icon_comments, C1761R.string.label_sort_comment_count, SearchSortType.d, true));
        f39308O = a;
        f39309P = (SortOption) a.get(0);
    }

    public static LinkSearchResultScreen m39483a(String str, boolean z) {
        LinkSearchResultScreen linkSearchResultScreen = new LinkSearchResultScreen();
        linkSearchResultScreen.searchContext = str;
        linkSearchResultScreen.query = null;
        linkSearchResultScreen.multireddit = z;
        return linkSearchResultScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39313D = (SearchView) this.K.findViewById(C1761R.id.search_view);
        this.f39324z = (ViewGroup) this.K.findViewById(C1761R.id.no_results_container);
        this.f39310A = (LinearLayout) this.K.findViewById(C1761R.id.error_container);
        this.f39320v = (RecyclerView) this.K.findViewById(C1761R.id.result_list);
        this.f39321w = this.K.findViewById(C1761R.id.progress_bar);
        this.f39311B = (TextView) this.f39310A.findViewById(C1761R.id.error_message);
        this.f39312C = (TextView) this.f39310A.findViewById(C1761R.id.retry_button);
        this.f39312C.setOnClickListener(new LinkSearchResultScreen$$Lambda$0(this));
        viewGroup = new LinearLayoutManager(am_(), 1, false);
        this.f39320v.setLayoutManager(viewGroup);
        this.f39322x = layoutInflater.inflate(C1761R.layout.list_loading_footer, this.f39320v, false);
        this.f39320v.addItemDecoration(DividerItemDecoration.m30092a(am_(), 1));
        this.f39320v.addOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ LinkSearchResultScreen f29289b;

            public final void m30376a(RecyclerView recyclerView, int i, int i2) {
                super.a(recyclerView, i, i2);
                if (viewGroup.m() >= this.f29289b.f39315F.mo6510a() - 5 && this.f29289b.f39314E.mAfter != null) {
                    this.f29289b.f39314E.a(ListingPerformanceTracker.m21961a(this.f29289b.getAnalyticsScreenName()));
                }
            }
        });
        this.f39316G = new LinkResultAdapter(this);
        this.f39315F = new RecyclerHeaderFooterAdapter(this.f39316G);
        this.f39319N.subscribeOn(FrontpageApplication.m28875k().mo4632t().a()).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new C23692(this));
        m39500w();
        this.f39320v.setAdapter(this.f39315F);
        this.f39321w.setBackground(AnimUtil.m23637a(am_()));
        SearchManager searchManager = (SearchManager) am_().getSystemService("search");
        this.f39313D.setIconifiedByDefault(false);
        this.f39313D.setSearchableInfo(searchManager.getSearchableInfo(am_().getComponentName()));
        if (TextUtils.isEmpty(this.query) == null) {
            this.f39313D.setQuery(this.query, false);
        }
        this.f39313D.requestFocus();
        this.f39313D.setQueryHint(ao_().getString(C1761R.string.search_subreddit_fmt_hint, new Object[]{this.searchContext}));
        if (TextUtils.isEmpty(this.query) != null) {
            Util.m23971a(this.f39313D);
        }
        return this.K;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.c(false);
    }

    public final void mo7239b(String str) {
        if (!TextUtils.equals(this.query, str)) {
            this.sortId = 0;
            this.timeframeId = 5;
            this.query = str;
            m39500w();
            if (this.f39313D != null) {
                this.f39313D.setQuery(str, false);
            }
            if (this.f39323y != null) {
                this.f39323y.setText(Sorting.m21806a(this.sortId));
            }
        }
    }

    final void m39500w() {
        if (!TextUtils.isEmpty(this.query)) {
            m39492y();
            this.f39314E.a(this.query, this.sortId, this.timeframeId, ListingPerformanceTracker.m21961a(getAnalyticsScreenName()));
        }
    }

    private SortOption<SearchSortType> m39491x() {
        for (SortOption<SearchSortType> sortOption : f39308O) {
            if (SortingsLegacyMapper.a((SearchSortType) sortOption.f20414c) == this.sortId) {
                return sortOption;
            }
        }
        return f39309P;
    }

    @SuppressLint({"RestrictedApi"})
    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.f39313D.clearFocus();
        if (this.f39318M != null) {
            this.f39318M.m32077c();
        }
    }

    protected final void mo7144v() {
        if (this.multireddit) {
            this.f39314E = new MultiredditLinkSearchListingProvider(this.searchContext);
        } else {
            this.f39314E = new LinkSearchListingProvider(this.searchContext);
        }
        m37523a(this.f39314E);
    }

    public final void mo7219a(ErrorEvent errorEvent) {
        if (errorEvent instanceof LinkSearchErrorEvent) {
            errorEvent = errorEvent.exception;
            this.f39321w.setVisibility(8);
            this.f39320v.setVisibility(8);
            this.f39310A.setVisibility(0);
            if (errorEvent instanceof NetworkError) {
                this.f39311B.setText(C1761R.string.error_network_error);
                return;
            } else if (errorEvent instanceof ServerError) {
                this.f39311B.setText(C1761R.string.error_server_error);
                return;
            } else {
                m37526a((Exception) errorEvent);
                return;
            }
        }
        super.mo7219a(errorEvent);
    }

    private void m39492y() {
        this.f39321w.setVisibility(0);
        this.f39320v.setVisibility(8);
        this.f39324z.setVisibility(8);
        this.f39310A.setVisibility(8);
    }

    public void onEvent(LinkSearchEvent linkSearchEvent) {
        this.f39321w.setVisibility(8);
        this.f39310A.setVisibility(8);
        if (this.f39314E.c() != null) {
            this.f39320v.setVisibility(0);
        } else {
            this.f39324z.setVisibility(0);
        }
        if (this.f39314E.mAfter == null) {
            this.f39315F.f34365c = null;
        } else if (this.f39315F.m35096g() == null) {
            this.f39315F.f34365c = this.f39322x;
        }
        this.f39315F.a_.b();
    }

    static /* synthetic */ void m39484a(LinkSearchResultScreen linkSearchResultScreen, SortSelection sortSelection) {
        linkSearchResultScreen.m39492y();
        linkSearchResultScreen.sortId = SortingsLegacyMapper.a((SearchSortType) sortSelection.a.f20414c);
        linkSearchResultScreen.timeframeId = SortingsLegacyMapper.a(sortSelection.b);
        sortSelection = linkSearchResultScreen.f39314E;
        int i = linkSearchResultScreen.sortId;
        int i2 = linkSearchResultScreen.timeframeId;
        String a = ListingPerformanceTracker.m21961a(linkSearchResultScreen.getAnalyticsScreenName());
        sortSelection.e = i;
        sortSelection.f = i2;
        sortSelection.mAfter = null;
        sortSelection.a(true, a);
        linkSearchResultScreen.f39323y.setText(Sorting.m21806a(linkSearchResultScreen.sortId));
    }
}
