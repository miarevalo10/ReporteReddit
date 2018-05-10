package com.reddit.frontpage.ui.search;

import android.app.SearchManager;
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
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.provider.SubredditSearchListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditSearchListingProvider.SubredditSearchEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.subscribe.SubscribeRedditView;
import java.util.ArrayList;
import java.util.Objects;

public class SubredditSearchResultScreen extends BaseScreen implements Searchable {
    @State
    String after;
    @BindView
    View loadingSnoo;
    @BindView
    RecyclerView mResultList;
    @State
    String query;
    @State
    ArrayList<ThingWrapper> subreddits;
    RecyclerHeaderFooterAdapter f39325v;
    SubredditSearchListingProvider f39326w;
    private View f39327x;
    private SearchView f39328y;

    public class NameIconViewHolder extends ViewHolder {
        public TextView f29298a;
        public ShapedIconView f29299b;
        final /* synthetic */ SubredditSearchResultScreen f29300p;

        public NameIconViewHolder(SubredditSearchResultScreen subredditSearchResultScreen, View view) {
            this.f29300p = subredditSearchResultScreen;
            super(view);
            this.f29298a = (TextView) view.findViewById(C1761R.id.subreddit_name);
            this.f29299b = (ShapedIconView) view.findViewById(C1761R.id.subreddit_icon);
        }
    }

    class SubredditResultAdapter extends Adapter {
        final /* synthetic */ SubredditSearchResultScreen f29301a;

        SubredditResultAdapter(SubredditSearchResultScreen subredditSearchResultScreen) {
            this.f29301a = subredditSearchResultScreen;
        }

        public final ViewHolder m30384a(ViewGroup viewGroup, int i) {
            return new SubredditNameIconViewHolder(this.f29301a, LayoutInflater.from(this.f29301a.am_()).inflate(C1761R.layout.listitem_subreddit_name_icon_subscribe, viewGroup, false));
        }

        public final void m30385a(ViewHolder viewHolder, int i) {
            Subreddit subreddit;
            SubredditNameIconViewHolder subredditNameIconViewHolder = (SubredditNameIconViewHolder) viewHolder;
            ThingWrapper thingWrapper = (ThingWrapper) this.f29301a.f39326w.mObjects.get(i);
            Account account = null;
            if (thingWrapper instanceof SubredditWrapper) {
                subreddit = (Subreddit) ((SubredditWrapper) thingWrapper).getData();
            } else if (thingWrapper instanceof AccountWrapper) {
                subreddit = ((Account) ((AccountWrapper) thingWrapper).getData()).subreddit;
            } else {
                subreddit = null;
            }
            ThingWrapper thingWrapper2 = (ThingWrapper) this.f29301a.f39326w.mObjects.get(i);
            if (thingWrapper2 instanceof AccountWrapper) {
                account = (Account) ((AccountWrapper) thingWrapper2).getData();
            }
            subredditNameIconViewHolder.f34457q = subreddit;
            subredditNameIconViewHolder.a.setText(subredditNameIconViewHolder.f34457q.display_name_prefixed);
            Util.m23978a(subredditNameIconViewHolder.b, subredditNameIconViewHolder.f34457q);
            subredditNameIconViewHolder.f34458r.m35331a(subreddit);
            viewHolder.c.setOnClickListener(new SubredditSearchResultScreen$SubredditResultAdapter$$Lambda$0(this, account, subreddit));
        }

        public final int m30383a() {
            return this.f29301a.f39326w.c();
        }
    }

    public class SubredditNameIconViewHolder extends NameIconViewHolder {
        Subreddit f34457q;
        SubscribeRedditView f34458r;
        final /* synthetic */ SubredditSearchResultScreen f34459s;

        public SubredditNameIconViewHolder(SubredditSearchResultScreen subredditSearchResultScreen, View view) {
            this.f34459s = subredditSearchResultScreen;
            super(subredditSearchResultScreen, view);
            this.f34458r = (SubscribeRedditView) view.findViewById(C1761R.id.subscribe);
            this.f34458r.mo6542a(SessionManager.b().c);
        }
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_search;
    }

    public static SubredditSearchResultScreen m39502a(String str, ArrayList<ThingWrapper> arrayList, String str2) {
        SubredditSearchResultScreen subredditSearchResultScreen = new SubredditSearchResultScreen();
        subredditSearchResultScreen.query = str;
        subredditSearchResultScreen.subreddits = arrayList;
        subredditSearchResultScreen.after = str2;
        return subredditSearchResultScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        viewGroup = new LinearLayoutManager(am_(), 1, false);
        this.mResultList.setLayoutManager(viewGroup);
        this.f39327x = layoutInflater.inflate(C1761R.layout.list_loading_footer, this.mResultList, false);
        this.mResultList.addOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SubredditSearchResultScreen f29297b;

            public final void m30382a(RecyclerView recyclerView, int i, int i2) {
                super.a(recyclerView, i, i2);
                if (viewGroup.m() >= this.f29297b.f39325v.mo6510a() - 5 && this.f29297b.f39326w.mAfter != null) {
                    this.f29297b.f39326w.a(ListingPerformanceTracker.m21961a(this.f29297b.getAnalyticsScreenName()));
                }
            }
        });
        n();
        this.f39325v = new RecyclerHeaderFooterAdapter(new SubredditResultAdapter(this));
        this.f39325v.f34365c = this.f39327x;
        this.mResultList.setAdapter(this.f39325v);
        m39505w();
        this.loadingSnoo.setBackground(AnimUtil.m23637a(am_()));
        SearchManager searchManager = (SearchManager) am_().getSystemService("search");
        this.f39328y = (SearchView) this.K.findViewById(C1761R.id.search_view);
        this.f39328y.setSearchableInfo(searchManager.getSearchableInfo(am_().getComponentName()));
        this.f39328y.setIconifiedByDefault(false);
        this.f39328y.requestFocus();
        if (TextUtils.isEmpty(this.query) == null) {
            this.f39328y.setQuery(this.query, false);
        } else {
            Util.m23971a(this.f39328y);
        }
        return this.K;
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (TextUtils.isEmpty(this.query) == null) {
            m37537h(this.query);
        }
    }

    public void onEvent(SubredditSearchEvent subredditSearchEvent) {
        this.f39326w.e();
        m39505w();
        if (this.f39326w.mAfter == null) {
            this.f39325v.f34365c = null;
        } else if (this.f39325v.m35096g() == null) {
            this.f39325v.f34365c = this.f39327x;
        }
        this.f39325v.a_.b();
    }

    private void m39505w() {
        this.loadingSnoo.setVisibility(8);
        this.mResultList.setVisibility(0);
    }

    protected final void mo7144v() {
        this.f39326w = new SubredditSearchListingProvider(this.query, this.subreddits, this.after);
        this.f39326w.e();
        m37523a(this.f39326w);
    }

    public final void mo7239b(String str) {
        if (!Objects.equals(str, this.query)) {
            this.subreddits.clear();
            this.query = str;
            this.after = null;
            SubredditSearchListingProvider subredditSearchListingProvider = this.f39326w;
            String str2 = this.query;
            String str3 = this.after;
            subredditSearchListingProvider.c = str2;
            subredditSearchListingProvider.mAfter = str3;
            if (subredditSearchListingProvider.mObjects != null) {
                subredditSearchListingProvider.mObjects.clear();
            }
            this.f39326w.a(true, null);
        }
    }
}
