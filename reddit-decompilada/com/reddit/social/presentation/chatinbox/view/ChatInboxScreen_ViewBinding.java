package com.reddit.social.presentation.chatinbox.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class ChatInboxScreen_ViewBinding implements Unbinder {
    private ChatInboxScreen f29630b;

    public ChatInboxScreen_ViewBinding(ChatInboxScreen chatInboxScreen, View view) {
        this.f29630b = chatInboxScreen;
        chatInboxScreen.splashScreen = (LinearLayout) Utils.b(view, C1761R.id.chat_splash, "field 'splashScreen'", LinearLayout.class);
        chatInboxScreen.splashStartButton = (Button) Utils.b(view, C1761R.id.chat_splash_start, "field 'splashStartButton'", Button.class);
        chatInboxScreen.toolbarTitle = (TextView) Utils.b(view, C1761R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
        chatInboxScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.link_list, "field 'recyclerView'", RecyclerView.class);
        chatInboxScreen.swipeRefreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.chat_inbox_refresh_layout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        chatInboxScreen.contentContainer = (FrameLayout) Utils.b(view, C1761R.id.content_container, "field 'contentContainer'", FrameLayout.class);
        chatInboxScreen.errorContainer = (LinearLayout) Utils.b(view, C1761R.id.error_container, "field 'errorContainer'", LinearLayout.class);
        chatInboxScreen.errorMessage = (TextView) Utils.b(view, C1761R.id.error_message, "field 'errorMessage'", TextView.class);
        chatInboxScreen.retryButton = (TextView) Utils.b(view, C1761R.id.retry_button, "field 'retryButton'", TextView.class);
        chatInboxScreen.emptyContainer = (FrameLayout) Utils.b(view, C1761R.id.empty_container_stub, "field 'emptyContainer'", FrameLayout.class);
        chatInboxScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
        chatInboxScreen.startChatButton = (Button) Utils.b(view, C1761R.id.start_chat_button, "field 'startChatButton'", Button.class);
        chatInboxScreen.loadingSnoo = Utils.a(view, C1761R.id.progress_bar, "field 'loadingSnoo'");
    }

    public final void m30659a() {
        ChatInboxScreen chatInboxScreen = this.f29630b;
        if (chatInboxScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29630b = null;
        chatInboxScreen.splashScreen = null;
        chatInboxScreen.splashStartButton = null;
        chatInboxScreen.toolbarTitle = null;
        chatInboxScreen.recyclerView = null;
        chatInboxScreen.swipeRefreshLayout = null;
        chatInboxScreen.contentContainer = null;
        chatInboxScreen.errorContainer = null;
        chatInboxScreen.errorMessage = null;
        chatInboxScreen.retryButton = null;
        chatInboxScreen.emptyContainer = null;
        chatInboxScreen.noConnectionBanner = null;
        chatInboxScreen.startChatButton = null;
        chatInboxScreen.loadingSnoo = null;
    }
}
