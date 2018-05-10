package com.reddit.frontpage.ui.profile;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.provider.BaseListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.SavedListingProvider.SavedFetchCompleteEvent;
import com.reddit.datalibrary.frontpage.data.provider.SavedListingProvider.SavedFetchFailedEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.Util;

abstract class SavedListingScreen extends BaseScreen {
    @BindView
    FrameLayout contentContainer;
    @BindView
    View emptyContainer;
    @BindView
    LinearLayout errorContainer;
    @BindView
    TextView errorMessage;
    @State
    boolean isCompact;
    @BindView
    RecyclerView listview;
    @BindView
    View progressBar;
    @BindView
    TextView retryButton;
    @BindView
    SwipeRefreshLayout swipeRefreshLayout;
    protected LinearLayoutManager f39261v;
    BaseListingProvider f39262w;
    View f39263x;
    RecyclerHeaderFooterAdapter f39264y;
    ItemDecoration f39265z;

    class C23611 extends OnScrollListener {
        final /* synthetic */ SavedListingScreen f29239a;

        C23611(SavedListingScreen savedListingScreen) {
            this.f29239a = savedListingScreen;
        }

        public final void m30346a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (this.f29239a.f39261v.m() >= this.f29239a.f39262w.c() - 5 && this.f29239a.f39262w.mAfter != null) {
                this.f29239a.f39262w.a(ListingPerformanceTracker.m21961a(this.f29239a.getAnalyticsScreenName()));
            }
        }
    }

    public int mo7141s() {
        return C1761R.layout.bare_link_list;
    }

    protected abstract Adapter mo7465x();

    SavedListingScreen() {
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39261v = new LinearLayoutManager(am_(), 1, false);
        this.listview.setLayoutManager(this.f39261v);
        this.f39264y = new RecyclerHeaderFooterAdapter(mo7465x());
        this.listview.setAdapter(this.f39264y);
        this.f39263x = layoutInflater.inflate(C1761R.layout.list_loading_footer, this.listview, false);
        Util.m23970a(this.swipeRefreshLayout);
        this.swipeRefreshLayout.setOnRefreshListener(new SavedListingScreen$$Lambda$0(this));
        this.listview.addOnScrollListener(new C23611(this));
        this.retryButton.setOnClickListener(new SavedListingScreen$$Lambda$1(this));
        if (this.f39265z != null) {
            this.listview.removeItemDecoration(this.f39265z);
        }
        this.f39265z = DividerItemDecoration.m30093a(am_(), this.isCompact, DividerItemDecoration.m30091a());
        this.listview.addItemDecoration(this.f39265z);
        this.f39262w.a(false, ListingPerformanceTracker.m21961a(getAnalyticsScreenName()));
        return this.K;
    }

    public void onEventMainThread(SavedFetchCompleteEvent savedFetchCompleteEvent) {
        mo7462P();
        if (this.f39262w.mAfter != null && this.f39264y.m35096g() == null) {
            this.f39264y.f34365c = this.f39263x;
        } else if (this.f39262w.mAfter == null && this.f39264y.m35096g() > null) {
            this.f39264y.f34365c = null;
        }
        this.listview.getAdapter().a_.b();
        this.swipeRefreshLayout.setRefreshing(false);
    }

    public void onEventMainThread(SavedFetchFailedEvent savedFetchFailedEvent) {
        mo7466y();
    }

    public void mo7462P() {
        int i = 0;
        int i2 = (this.f39262w == null || this.f39262w.c() <= 0) ? 0 : 1;
        this.emptyContainer.setVisibility(i2 != 0 ? 8 : 0);
        this.contentContainer.setVisibility(i2 != 0 ? 0 : 8);
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (i2 == 0) {
            i = 8;
        }
        swipeRefreshLayout.setVisibility(i);
        this.errorContainer.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    public void mo7461O() {
        this.errorContainer.setVisibility(8);
        this.contentContainer.setVisibility(0);
        this.swipeRefreshLayout.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    public void mo7466y() {
        this.contentContainer.setVisibility(4);
        this.errorContainer.setVisibility(0);
        this.errorMessage.setText(C1761R.string.error_server_error);
        this.retryButton.setVisibility(0);
    }
}
