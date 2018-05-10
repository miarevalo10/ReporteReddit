package com.reddit.frontpage.ui.search;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.android.volley.NetworkError;
import com.android.volley.ServerError;
import com.evernote.android.state.State;
import com.google.common.collect.ImmutableList;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.common.SearchSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider.1;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider.2;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider.CombinedSearchErrorEvent;
import com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider.CombinedSearchEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SimpleSortOptionsDialog;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.DecorationInclusionStrategy;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.subscribe.SubscribeRedditView;
import de.greenrobot.event.EventBus;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class CombinedSearchResultScreen extends BaseScreen implements Searchable {
    private static final List<SortOption<SearchSortType>> f39288N;
    private static final SortOption<SearchSortType> f39289O;
    private LinearLayout f39290A;
    private TextView f39291B;
    private TextView f39292C;
    private CombinedSearchProvider f39293D;
    private RecyclerHeaderFooterAdapter f39294E;
    private LinkResultAdapter f39295F;
    private SearchView f39296G;
    private final CompositeDisposable f39297H = new CompositeDisposable();
    private final PublishSubject<SortSelection<SearchSortType>> f39298M = PublishSubject.create();
    private final int f39299P = 100;
    private final int f39300Q = 101;
    private final int f39301R = 102;
    private final int f39302S = 103;
    @BindView
    ViewGroup mNoResultsContainer;
    @State
    String query;
    @State
    int sortId = 0;
    @State
    int timeframeId = 5;
    SubredditResultAdapter f39303v;
    private View f39304w;
    private View f39305x;
    private TextView f39306y;
    private RecyclerView f39307z;

    class C23632 implements Observer<SortSelection<SearchSortType>> {
        final /* synthetic */ CombinedSearchResultScreen f29273a;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        C23632(CombinedSearchResultScreen combinedSearchResultScreen) {
            this.f29273a = combinedSearchResultScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            SortSelection sortSelection = (SortSelection) obj;
            if (this.f29273a.e) {
                CombinedSearchResultScreen.m39458a(this.f29273a, sortSelection);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f29273a.f39297H.mo5631a(disposable);
        }
    }

    class C23643 implements OnQueryTextListener {
        final /* synthetic */ CombinedSearchResultScreen f29274a;

        public final boolean m30360a(String str) {
            return false;
        }

        C23643(CombinedSearchResultScreen combinedSearchResultScreen) {
            this.f29274a = combinedSearchResultScreen;
        }

        public final boolean m30361b(String str) {
            if (this.f29274a.e) {
                Screen screen = this.f29274a;
                Routing.m22621a(screen);
                if (str.isEmpty()) {
                    Routing.m22623a(screen, Nav.m22603n(""));
                } else {
                    Routing.m22623a(screen, Nav.m22604o(str));
                }
                return true;
            }
            RedditLogger.m21982a("CombinedSearchResultsScreen#onQueryTextChange: screen not attached!");
            return true;
        }
    }

    class LinkResultAdapter extends Adapter {
        final /* synthetic */ CombinedSearchResultScreen f29278a;
        private CardLinkAdapter f29279b;

        class C19072 implements OnClickListener {
            final /* synthetic */ LinkResultAdapter f21585a;

            C19072(LinkResultAdapter linkResultAdapter) {
                this.f21585a = linkResultAdapter;
            }

            public void onClick(View view) {
                new SimpleSortOptionsDialog(this.f21585a.f29278a.f39298M, this.f21585a.f29278a.am_(), this.f21585a.f29278a.am_().getResources().getString(C1761R.string.title_sort_results), CombinedSearchResultScreen.f39288N, CombinedSearchResultScreen.f39289O, this.f21585a.f29278a.m39471x(), true, SortingsLegacyMapper.b(this.f21585a.f29278a.timeframeId)).f20405a.show();
            }
        }

        LinkResultAdapter(final CombinedSearchResultScreen combinedSearchResultScreen, Context context) {
            this.f29278a = combinedSearchResultScreen;
            this.f29279b = new CardLinkAdapter(this, context) {
                final /* synthetic */ LinkResultAdapter f34452b;

                public final boolean mo6477c() {
                    return true;
                }

                public final /* synthetic */ Listable mo6476c(int i) {
                    return C26951.m35221i();
                }

                public final /* synthetic */ Object mo4996g(int i) {
                    return C26951.m35221i();
                }

                private static Link m35221i() {
                    throw new RuntimeException("Unexpected call to getItem()");
                }

                public final int m35222a() {
                    throw new RuntimeException("Unexpected call to getItemCount()");
                }

                protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
                    throw new RuntimeException("Unexpected call to navigateToPostDetail()");
                }
            };
        }

        public final ViewHolder m30364a(ViewGroup viewGroup, int i) {
            if (i != 103) {
                return this.f29279b.m30219c(viewGroup, i);
            }
            viewGroup = LayoutInflater.from(this.f29278a.am_()).inflate(C1761R.layout.listitem_header_subreddit_search, viewGroup, false);
            i = viewGroup.findViewById(C1761R.id.sort_options);
            this.f29278a.f39306y = (TextView) i.findViewById(C1761R.id.sort_name);
            this.f29278a.f39306y.setText(Sorting.m21806a(this.f29278a.f39293D.mSortId));
            i.setOnClickListener(new C19072(this));
            return new ViewHolder(this, viewGroup) {
                final /* synthetic */ LinkResultAdapter f29277a;
            };
        }

        public final void m30365a(ViewHolder viewHolder, int i) {
            if (i != 0) {
                LinkViewHolder linkViewHolder = (LinkViewHolder) viewHolder;
                Link link = (Link) this.f29278a.f39293D.a(i - 1).getData();
                linkViewHolder.mo7002a(link);
                linkViewHolder.c.setOnClickListener(new CombinedSearchResultScreen$LinkResultAdapter$$Lambda$0(this, link));
                linkViewHolder.m35120a(new CombinedSearchResultScreen$LinkResultAdapter$$Lambda$1(this, link));
            }
        }

        public final int m30363a() {
            return this.f29278a.f39293D.mLinks.size();
        }

        public final int m30366b(int i) {
            if (i == 0) {
                return 103;
            }
            return Util.m23994b((Link) this.f29278a.f39293D.a(i + -1).getData()) == 0 ? 3 : 10;
        }
    }

    public class NameIconViewHolder extends ViewHolder {
        public TextView f29280a;
        public ShapedIconView f29281b;
        final /* synthetic */ CombinedSearchResultScreen f29282p;

        public NameIconViewHolder(CombinedSearchResultScreen combinedSearchResultScreen, View view) {
            this.f29282p = combinedSearchResultScreen;
            super(view);
            this.f29280a = (TextView) view.findViewById(C1761R.id.subreddit_name);
            this.f29281b = (ShapedIconView) view.findViewById(C1761R.id.subreddit_icon);
        }
    }

    class SearchResultAdapter extends Adapter {
        final /* synthetic */ CombinedSearchResultScreen f29283a;

        SearchResultAdapter(CombinedSearchResultScreen combinedSearchResultScreen) {
            this.f29283a = combinedSearchResultScreen;
        }

        public final ViewHolder m30368a(ViewGroup viewGroup, int i) {
            if (!(i == 100 || i == 101)) {
                if (i != 102) {
                    StringBuilder stringBuilder = new StringBuilder("vt: ");
                    stringBuilder.append(i);
                    Timber.b(stringBuilder.toString(), new Object[0]);
                    return this.f29283a.f39295F.b(viewGroup, i);
                }
            }
            return this.f29283a.f39303v.b(viewGroup, i);
        }

        public final void m30369a(ViewHolder viewHolder, int i) {
            int a = this.f29283a.f39303v.m30371a();
            if (a <= 1 || i > a - 1) {
                this.f29283a.f39295F.m30365a(viewHolder, i - a);
            } else {
                this.f29283a.f39303v.m30373a(viewHolder, i);
            }
        }

        public final int m30370b(int i) {
            int a = this.f29283a.f39303v.m30371a();
            if (a <= 1 || i > a - 1) {
                return this.f29283a.f39295F.m30366b(i - a);
            }
            return this.f29283a.f39303v.m30374b(i);
        }

        public final int m30367a() {
            return this.f29283a.f39303v.m30371a() + this.f29283a.f39295F.m30363a();
        }
    }

    class SubredditResultAdapter extends Adapter {
        final /* synthetic */ CombinedSearchResultScreen f29286a;

        class C19082 implements OnClickListener {
            final /* synthetic */ SubredditResultAdapter f21589a;

            C19082(SubredditResultAdapter subredditResultAdapter) {
                this.f21589a = subredditResultAdapter;
            }

            public void onClick(View view) {
                String str = this.f21589a.f29286a.f39293D.mQuery;
                String str2 = this.f21589a.f29286a.f39293D.mSubredditsAfter;
                Routing.m22623a((Screen) this.f21589a.f29286a, Nav.m22560a(str, new ArrayList(this.f21589a.f29286a.f39293D.mSubreddits), str2));
            }
        }

        SubredditResultAdapter(CombinedSearchResultScreen combinedSearchResultScreen) {
            this.f29286a = combinedSearchResultScreen;
        }

        public final ViewHolder m30372a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 100:
                    return new ViewHolder(this, LayoutInflater.from(this.f29286a.am_()).inflate(C1761R.layout.listitem_header_communites, viewGroup, false)) {
                        final /* synthetic */ SubredditResultAdapter f29284a;
                    };
                case 101:
                    return new SubredditNameIconViewHolder(this.f29286a, LayoutInflater.from(this.f29286a.am_()).inflate(C1761R.layout.listitem_subreddit_name_icon_subscribe, viewGroup, false));
                case 102:
                    viewGroup = LayoutInflater.from(this.f29286a.am_()).inflate(C1761R.layout.listitem_footer_show_more, viewGroup, false);
                    viewGroup.findViewById(C1761R.id.show_more).setOnClickListener(new C19082(this));
                    return new ViewHolder(this, viewGroup) {
                        final /* synthetic */ SubredditResultAdapter f29285a;
                    };
                default:
                    return null;
            }
        }

        public final void m30373a(ViewHolder viewHolder, int i) {
            int b = m30374b(i);
            if (b != 100 && b != 102) {
                Subreddit subreddit;
                SubredditNameIconViewHolder subredditNameIconViewHolder = (SubredditNameIconViewHolder) viewHolder;
                i--;
                ThingWrapper thingWrapper = (ThingWrapper) this.f29286a.f39293D.mSubreddits.get(i);
                Account account = null;
                if (thingWrapper instanceof SubredditWrapper) {
                    subreddit = (Subreddit) ((SubredditWrapper) thingWrapper).getData();
                } else if (thingWrapper instanceof AccountWrapper) {
                    subreddit = ((Account) ((AccountWrapper) thingWrapper).getData()).subreddit;
                } else {
                    Timber.e("Unexpected wrapper type: %s", new Object[]{thingWrapper.getClass().getSimpleName()});
                    subreddit = null;
                }
                ThingWrapper thingWrapper2 = (ThingWrapper) this.f29286a.f39293D.mSubreddits.get(i);
                if (thingWrapper2 instanceof AccountWrapper) {
                    account = (Account) ((AccountWrapper) thingWrapper2).getData();
                }
                subredditNameIconViewHolder.f34453q = subreddit;
                i = subredditNameIconViewHolder.f34453q.display_name_prefixed;
                if (!TextUtils.isEmpty(i)) {
                    subredditNameIconViewHolder.a.setText(i);
                }
                Util.m23978a(subredditNameIconViewHolder.b, subredditNameIconViewHolder.f34453q);
                subredditNameIconViewHolder.f34454r.m35331a(subreddit);
                viewHolder.c.setOnClickListener(new CombinedSearchResultScreen$SubredditResultAdapter$$Lambda$0(this, account, subreddit));
            }
        }

        public final int m30371a() {
            int size = this.f29286a.f39293D.mSubreddits.size();
            int i = size > 0 ? size + 1 : 0;
            return (size > 3 || this.f29286a.f39293D.mSubredditsAfter != null) ? i + 1 : i;
        }

        public final int m30374b(int i) {
            if (i == 0) {
                return 100;
            }
            return (this.f29286a.f39293D.mSubredditsAfter == null || i != this.f29286a.f39293D.mSubreddits.size() + 1) ? 101 : 102;
        }
    }

    public class SubredditNameIconViewHolder extends NameIconViewHolder {
        Subreddit f34453q;
        SubscribeRedditView f34454r;
        final /* synthetic */ CombinedSearchResultScreen f34455s;

        public SubredditNameIconViewHolder(CombinedSearchResultScreen combinedSearchResultScreen, View view) {
            this.f34455s = combinedSearchResultScreen;
            super(combinedSearchResultScreen, view);
            this.f34454r = (SubscribeRedditView) view.findViewById(C1761R.id.subscribe);
            this.f34454r.mo6542a(SessionManager.b().c);
        }
    }

    public String getAnalyticsScreenName() {
        return "search_results";
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_search;
    }

    static {
        List a = ImmutableList.a(new SortOption(C1761R.drawable.ic_icon_sort_hot, C1761R.string.label_sort_most_relevant, SearchSortType.a, false), new SortOption(C1761R.drawable.ic_icon_sort_new, C1761R.string.label_sort_new, SearchSortType.c, false), new SortOption(C1761R.drawable.ic_icon_sort_top, C1761R.string.label_sort_top, SearchSortType.b, true), new SortOption(C1761R.drawable.ic_icon_comments, C1761R.string.label_sort_comment_count, SearchSortType.d, true));
        f39288N = a;
        f39289O = (SortOption) a.get(0);
    }

    public static CombinedSearchResultScreen m39457a(String str) {
        CombinedSearchResultScreen combinedSearchResultScreen = new CombinedSearchResultScreen();
        combinedSearchResultScreen.query = str;
        return combinedSearchResultScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39290A = (LinearLayout) this.K.findViewById(C1761R.id.error_container);
        this.f39307z = (RecyclerView) this.K.findViewById(C1761R.id.result_list);
        this.f39304w = this.K.findViewById(C1761R.id.progress_bar);
        this.f39291B = (TextView) this.f39290A.findViewById(C1761R.id.error_message);
        this.f39292C = (TextView) this.f39290A.findViewById(C1761R.id.retry_button);
        this.f39292C.setOnClickListener(new CombinedSearchResultScreen$$Lambda$0(this));
        viewGroup = new LinearLayoutManager(am_(), 1, false);
        this.f39307z.setLayoutManager(viewGroup);
        this.f39305x = layoutInflater.inflate(C1761R.layout.list_loading_footer, this.f39307z, false);
        this.f39307z.addItemDecoration(DividerItemDecoration.m30093a(am_(), 1, new DecorationInclusionStrategy(new CombinedSearchResultScreen$$Lambda$1(this))));
        this.f39307z.addOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CombinedSearchResultScreen f29272b;

            public final void m30359a(RecyclerView recyclerView, int i, int i2) {
                super.a(recyclerView, i, i2);
                if (viewGroup.m() >= this.f29272b.f39294E.mo6510a() - 5 && this.f29272b.f39293D.mLinksAfter != null) {
                    recyclerView = this.f29272b.f39293D;
                    if (recyclerView.b == 0) {
                        recyclerView.b = true;
                        RemoteRedditApiDataSource.a(recyclerView.mQuery, Sorting.m21806a(recyclerView.mSortId), Sorting.m21810d(recyclerView.mTimeframeId), recyclerView.mLinksAfter).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new 2(recyclerView));
                    }
                }
            }
        });
        n();
        this.f39303v = new SubredditResultAdapter(this);
        this.f39295F = new LinkResultAdapter(this, am_());
        this.f39294E = new RecyclerHeaderFooterAdapter(new SearchResultAdapter(this));
        this.f39298M.subscribeOn(FrontpageApplication.m28875k().mo4632t().a()).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new C23632(this));
        m39480w();
        this.f39307z.setAdapter(this.f39294E);
        this.f39304w.setBackground(AnimUtil.m23637a(am_()));
        SearchManager searchManager = (SearchManager) am_().getSystemService("search");
        this.f39296G = (SearchView) this.K.findViewById(C1761R.id.search_view);
        this.f39296G.setSearchableInfo(searchManager.getSearchableInfo(am_().getComponentName()));
        if (TextUtils.isEmpty(this.query) == null) {
            this.f39296G.setQuery(this.query, false);
        }
        this.f39296G.setOnQueryTextListener(new C23643(this));
        return this.K;
    }

    @SuppressLint({"RestrictedApi"})
    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.f39296G.clearFocus();
        if (this.f39297H != null) {
            this.f39297H.m32077c();
        }
    }

    public final void mo6987a(View view) {
        super.mo6987a(view);
        this.f39296G.setOnQueryTextListener(null);
    }

    protected final void mo7144v() {
        this.f39293D = new CombinedSearchProvider();
        m37523a(this.f39293D);
    }

    public final void mo7239b(String str) {
        if (!TextUtils.equals(this.query, str)) {
            this.sortId = 0;
            this.timeframeId = 5;
            this.query = str;
            m39480w();
            if (this.f39296G != null) {
                this.f39296G.setQuery(str, false);
            }
            if (this.f39306y != null) {
                this.f39306y.setText(Sorting.m21806a(this.sortId));
            }
        }
    }

    final void m39480w() {
        if (!TextUtils.isEmpty(this.query)) {
            this.f39304w.setVisibility(0);
            this.f39307z.setVisibility(8);
            this.mNoResultsContainer.setVisibility(8);
            this.f39290A.setVisibility(8);
            if (this.f39296G != null) {
                this.f39296G.clearFocus();
            }
            CombinedSearchProvider combinedSearchProvider = this.f39293D;
            String str = this.query;
            int i = this.sortId;
            int i2 = this.timeframeId;
            if (!combinedSearchProvider.b) {
                int i3;
                boolean z;
                if (combinedSearchProvider.mLinks.isEmpty()) {
                    if (combinedSearchProvider.mSubreddits.isEmpty()) {
                        i3 = 0;
                        z = TextUtils.equals(combinedSearchProvider.mQuery, str) && combinedSearchProvider.mSortId == i && combinedSearchProvider.mTimeframeId == i2;
                        if (z || r5 == 0) {
                            combinedSearchProvider.b = true;
                            combinedSearchProvider.mQuery = str;
                            combinedSearchProvider.mSortId = i;
                            combinedSearchProvider.mTimeframeId = i2;
                            combinedSearchProvider.mLinksAfter = null;
                            RemoteRedditApiDataSource.b(str, Sorting.m21806a(i), Sorting.m21810d(i2)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new 1(combinedSearchProvider, str));
                        } else {
                            EventBus.getDefault().postSticky(new CombinedSearchEvent(str));
                            Timber.b("Query (%s) is cached from previous query", new Object[]{str});
                            return;
                        }
                    }
                }
                i3 = true;
                if (!TextUtils.equals(combinedSearchProvider.mQuery, str)) {
                }
                if (z) {
                }
                combinedSearchProvider.b = true;
                combinedSearchProvider.mQuery = str;
                combinedSearchProvider.mSortId = i;
                combinedSearchProvider.mTimeframeId = i2;
                combinedSearchProvider.mLinksAfter = null;
                RemoteRedditApiDataSource.b(str, Sorting.m21806a(i), Sorting.m21810d(i2)).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new 1(combinedSearchProvider, str));
            }
        }
    }

    public void onEvent(CombinedSearchEvent combinedSearchEvent) {
        EventBus.getDefault().removeStickyEvent((Object) combinedSearchEvent);
        this.f39304w.setVisibility(8);
        this.f39290A.setVisibility(8);
        if (this.f39293D.mLinks.size() == null) {
            if (this.f39293D.mSubreddits.size() == null) {
                combinedSearchEvent = null;
                if (combinedSearchEvent == null) {
                    this.f39307z.setVisibility(0);
                } else {
                    this.mNoResultsContainer.setVisibility(0);
                }
                if (this.f39293D.mLinksAfter != null) {
                    this.f39294E.f34365c = null;
                } else if (this.f39294E.m35096g() == null) {
                    this.f39294E.f34365c = this.f39305x;
                }
                this.f39294E.a_.b();
            }
        }
        combinedSearchEvent = true;
        if (combinedSearchEvent == null) {
            this.mNoResultsContainer.setVisibility(0);
        } else {
            this.f39307z.setVisibility(0);
        }
        if (this.f39293D.mLinksAfter != null) {
            this.f39294E.f34365c = null;
        } else if (this.f39294E.m35096g() == null) {
            this.f39294E.f34365c = this.f39305x;
        }
        this.f39294E.a_.b();
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.c(false);
    }

    public final void mo7219a(ErrorEvent errorEvent) {
        if (errorEvent instanceof CombinedSearchErrorEvent) {
            errorEvent = errorEvent.exception;
            this.f39304w.setVisibility(8);
            this.f39307z.setVisibility(8);
            this.f39290A.setVisibility(0);
            if (errorEvent instanceof NetworkError) {
                this.f39291B.setText(C1761R.string.error_network_error);
                return;
            } else if (errorEvent instanceof ServerError) {
                this.f39291B.setText(C1761R.string.error_server_error);
                return;
            } else {
                m37526a((Exception) errorEvent);
                return;
            }
        }
        super.mo7219a(errorEvent);
    }

    private SortOption<SearchSortType> m39471x() {
        for (SortOption<SearchSortType> sortOption : f39288N) {
            if (SortingsLegacyMapper.a((SearchSortType) sortOption.f20414c) == this.sortId) {
                return sortOption;
            }
        }
        return f39289O;
    }

    static /* synthetic */ void m39458a(CombinedSearchResultScreen combinedSearchResultScreen, SortSelection sortSelection) {
        combinedSearchResultScreen.sortId = SortingsLegacyMapper.a((SearchSortType) sortSelection.a.f20414c);
        combinedSearchResultScreen.timeframeId = SortingsLegacyMapper.a(sortSelection.b);
        combinedSearchResultScreen.m39480w();
        combinedSearchResultScreen.f39306y.setText(Sorting.m21806a(combinedSearchResultScreen.sortId));
    }
}
