package com.reddit.social.presentation.chatrequests.view;

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

public final class ChatRequestListScreen_ViewBinding implements Unbinder {
    private ChatRequestListScreen f29673b;

    public ChatRequestListScreen_ViewBinding(ChatRequestListScreen chatRequestListScreen, View view) {
        this.f29673b = chatRequestListScreen;
        chatRequestListScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'recyclerView'", RecyclerView.class);
        chatRequestListScreen.swipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        chatRequestListScreen.contentContainer = (FrameLayout) Utils.b(view, C1761R.id.content_container, "field 'contentContainer'", FrameLayout.class);
        chatRequestListScreen.errorContainer = (LinearLayout) Utils.b(view, C1761R.id.error_container, "field 'errorContainer'", LinearLayout.class);
        chatRequestListScreen.errorMessage = (TextView) Utils.b(view, C1761R.id.error_message, "field 'errorMessage'", TextView.class);
        chatRequestListScreen.retryButton = (TextView) Utils.b(view, C1761R.id.retry_button, "field 'retryButton'", TextView.class);
        chatRequestListScreen.emptyContainer = (ViewStub) Utils.b(view, C1761R.id.empty_container_stub, "field 'emptyContainer'", ViewStub.class);
        chatRequestListScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
    }

    public final void m30703a() {
        ChatRequestListScreen chatRequestListScreen = this.f29673b;
        if (chatRequestListScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29673b = null;
        chatRequestListScreen.recyclerView = null;
        chatRequestListScreen.swipeRefreshLayout = null;
        chatRequestListScreen.contentContainer = null;
        chatRequestListScreen.errorContainer = null;
        chatRequestListScreen.errorMessage = null;
        chatRequestListScreen.retryButton = null;
        chatRequestListScreen.emptyContainer = null;
        chatRequestListScreen.noConnectionBanner = null;
    }
}
