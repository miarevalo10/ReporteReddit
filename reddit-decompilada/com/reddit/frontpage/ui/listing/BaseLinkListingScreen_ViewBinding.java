package com.reddit.frontpage.ui.listing;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.RefreshPill;

public class BaseLinkListingScreen_ViewBinding implements Unbinder {
    private BaseLinkListingScreen f29021b;

    public BaseLinkListingScreen_ViewBinding(BaseLinkListingScreen baseLinkListingScreen, View view) {
        this.f29021b = baseLinkListingScreen;
        baseLinkListingScreen.listView = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'listView'", RecyclerView.class);
        baseLinkListingScreen.refreshPill = (RefreshPill) Utils.b(view, C1761R.id.refresh_pill, "field 'refreshPill'", RefreshPill.class);
        baseLinkListingScreen.swipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        baseLinkListingScreen.contentContainer = (FrameLayout) Utils.b(view, C1761R.id.content_container, "field 'contentContainer'", FrameLayout.class);
        baseLinkListingScreen.errorContainer = (ViewStub) Utils.b(view, C1761R.id.error_container_stub, "field 'errorContainer'", ViewStub.class);
        baseLinkListingScreen.emptyContainer = (ViewStub) Utils.b(view, C1761R.id.empty_container_stub, "field 'emptyContainer'", ViewStub.class);
        baseLinkListingScreen.loadingSpinner = Utils.a(view, C1761R.id.progress_bar, "field 'loadingSpinner'");
    }

    public final void m30088a() {
        BaseLinkListingScreen baseLinkListingScreen = this.f29021b;
        if (baseLinkListingScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29021b = null;
        baseLinkListingScreen.listView = null;
        baseLinkListingScreen.refreshPill = null;
        baseLinkListingScreen.swipeRefreshLayout = null;
        baseLinkListingScreen.contentContainer = null;
        baseLinkListingScreen.errorContainer = null;
        baseLinkListingScreen.emptyContainer = null;
        baseLinkListingScreen.loadingSpinner = null;
    }
}
