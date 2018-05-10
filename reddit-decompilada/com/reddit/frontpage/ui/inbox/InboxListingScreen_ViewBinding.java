package com.reddit.frontpage.ui.inbox;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class InboxListingScreen_ViewBinding implements Unbinder {
    private InboxListingScreen f28998b;

    public InboxListingScreen_ViewBinding(InboxListingScreen inboxListingScreen, View view) {
        this.f28998b = inboxListingScreen;
        inboxListingScreen.mListView = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'mListView'", RecyclerView.class);
        inboxListingScreen.mSwipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'mSwipeRefreshLayout'", SwipeRefreshLayout.class);
        inboxListingScreen.mContentContainer = (FrameLayout) Utils.b(view, C1761R.id.content_container, "field 'mContentContainer'", FrameLayout.class);
        inboxListingScreen.mErrorContainer = (LinearLayout) Utils.b(view, C1761R.id.error_container, "field 'mErrorContainer'", LinearLayout.class);
        inboxListingScreen.mErrorMessage = (TextView) Utils.b(view, C1761R.id.error_message, "field 'mErrorMessage'", TextView.class);
        inboxListingScreen.mRetryButton = (TextView) Utils.b(view, C1761R.id.retry_button, "field 'mRetryButton'", TextView.class);
        inboxListingScreen.emptyContainer = (ViewStub) Utils.b(view, C1761R.id.empty_container_stub, "field 'emptyContainer'", ViewStub.class);
        inboxListingScreen.authContainer = (ViewStub) Utils.b(view, C1761R.id.auth_container, "field 'authContainer'", ViewStub.class);
    }

    public void mo6500a() {
        InboxListingScreen inboxListingScreen = this.f28998b;
        if (inboxListingScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28998b = null;
        inboxListingScreen.mListView = null;
        inboxListingScreen.mSwipeRefreshLayout = null;
        inboxListingScreen.mContentContainer = null;
        inboxListingScreen.mErrorContainer = null;
        inboxListingScreen.mErrorMessage = null;
        inboxListingScreen.mRetryButton = null;
        inboxListingScreen.emptyContainer = null;
        inboxListingScreen.authContainer = null;
    }
}
