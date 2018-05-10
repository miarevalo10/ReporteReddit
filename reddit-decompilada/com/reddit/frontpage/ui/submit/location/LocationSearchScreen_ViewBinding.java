package com.reddit.frontpage.ui.submit.location;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.GoEditTextView;

public class LocationSearchScreen_ViewBinding implements Unbinder {
    private LocationSearchScreen f29352b;

    public LocationSearchScreen_ViewBinding(LocationSearchScreen locationSearchScreen, View view) {
        this.f29352b = locationSearchScreen;
        locationSearchScreen.locationEdit = (GoEditTextView) Utils.b(view, C1761R.id.edit_location, "field 'locationEdit'", GoEditTextView.class);
        locationSearchScreen.refreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        locationSearchScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'recyclerView'", RecyclerView.class);
        locationSearchScreen.errorContainer = Utils.a(view, C1761R.id.error_container, "field 'errorContainer'");
        locationSearchScreen.errorMessage = (TextView) Utils.b(view, C1761R.id.error_message, "field 'errorMessage'", TextView.class);
        locationSearchScreen.retryButton = (TextView) Utils.b(view, C1761R.id.retry_button, "field 'retryButton'", TextView.class);
        locationSearchScreen.loadingSpinner = Utils.a(view, C1761R.id.progress_bar, "field 'loadingSpinner'");
        locationSearchScreen.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public final void m30411a() {
        LocationSearchScreen locationSearchScreen = this.f29352b;
        if (locationSearchScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29352b = null;
        locationSearchScreen.locationEdit = null;
        locationSearchScreen.refreshLayout = null;
        locationSearchScreen.recyclerView = null;
        locationSearchScreen.errorContainer = null;
        locationSearchScreen.errorMessage = null;
        locationSearchScreen.retryButton = null;
        locationSearchScreen.loadingSpinner = null;
        locationSearchScreen.toolbar = null;
    }
}
