package com.reddit.frontpage.ui.listing;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class UserCommentsListingScreen_ViewBinding implements Unbinder {
    private UserCommentsListingScreen f29075b;

    public UserCommentsListingScreen_ViewBinding(UserCommentsListingScreen userCommentsListingScreen, View view) {
        this.f29075b = userCommentsListingScreen;
        userCommentsListingScreen.listView = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'listView'", RecyclerView.class);
        userCommentsListingScreen.contentContainer = (FrameLayout) Utils.b(view, C1761R.id.content_container, "field 'contentContainer'", FrameLayout.class);
        userCommentsListingScreen.errorContainer = (LinearLayout) Utils.b(view, C1761R.id.error_container, "field 'errorContainer'", LinearLayout.class);
        userCommentsListingScreen.swipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        userCommentsListingScreen.loadingSpinner = Utils.a(view, C1761R.id.progress_bar, "field 'loadingSpinner'");
        userCommentsListingScreen.emptyContainer = (ViewStub) Utils.b(view, C1761R.id.empty_container, "field 'emptyContainer'", ViewStub.class);
    }

    public final void m30129a() {
        UserCommentsListingScreen userCommentsListingScreen = this.f29075b;
        if (userCommentsListingScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29075b = null;
        userCommentsListingScreen.listView = null;
        userCommentsListingScreen.contentContainer = null;
        userCommentsListingScreen.errorContainer = null;
        userCommentsListingScreen.swipeRefreshLayout = null;
        userCommentsListingScreen.loadingSpinner = null;
        userCommentsListingScreen.emptyContainer = null;
    }
}
