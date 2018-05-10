package com.reddit.frontpage.ui.profile;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SavedListingScreen_ViewBinding implements Unbinder {
    private SavedListingScreen f29240b;

    public SavedListingScreen_ViewBinding(SavedListingScreen savedListingScreen, View view) {
        this.f29240b = savedListingScreen;
        savedListingScreen.contentContainer = (FrameLayout) Utils.b(view, C1761R.id.content_container, "field 'contentContainer'", FrameLayout.class);
        savedListingScreen.emptyContainer = Utils.a(view, C1761R.id.empty_container, "field 'emptyContainer'");
        savedListingScreen.errorContainer = (LinearLayout) Utils.b(view, C1761R.id.error_container, "field 'errorContainer'", LinearLayout.class);
        savedListingScreen.swipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        savedListingScreen.progressBar = Utils.a(view, C1761R.id.progress_bar, "field 'progressBar'");
        savedListingScreen.errorMessage = (TextView) Utils.b(view, C1761R.id.error_message, "field 'errorMessage'", TextView.class);
        savedListingScreen.retryButton = (TextView) Utils.b(view, C1761R.id.retry_button, "field 'retryButton'", TextView.class);
        savedListingScreen.listview = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'listview'", RecyclerView.class);
    }

    public final void m30347a() {
        SavedListingScreen savedListingScreen = this.f29240b;
        if (savedListingScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29240b = null;
        savedListingScreen.contentContainer = null;
        savedListingScreen.emptyContainer = null;
        savedListingScreen.errorContainer = null;
        savedListingScreen.swipeRefreshLayout = null;
        savedListingScreen.progressBar = null;
        savedListingScreen.errorMessage = null;
        savedListingScreen.retryButton = null;
        savedListingScreen.listview = null;
    }
}
