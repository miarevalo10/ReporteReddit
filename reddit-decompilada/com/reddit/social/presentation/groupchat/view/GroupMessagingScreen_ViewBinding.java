package com.reddit.social.presentation.groupchat.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.social.widgets.WidgetKeyboard;

public final class GroupMessagingScreen_ViewBinding implements Unbinder {
    private GroupMessagingScreen f29868b;

    public GroupMessagingScreen_ViewBinding(GroupMessagingScreen groupMessagingScreen, View view) {
        this.f29868b = groupMessagingScreen;
        groupMessagingScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.recycler_open_channel_chat, "field 'recyclerView'", RecyclerView.class);
        groupMessagingScreen.widgetKeyboard = (WidgetKeyboard) Utils.b(view, C1761R.id.widget_keyboard, "field 'widgetKeyboard'", WidgetKeyboard.class);
        groupMessagingScreen.errorContainer = (LinearLayout) Utils.b(view, C1761R.id.error_container, "field 'errorContainer'", LinearLayout.class);
        groupMessagingScreen.errorMessage = (TextView) Utils.b(view, C1761R.id.error_message, "field 'errorMessage'", TextView.class);
        groupMessagingScreen.retryButton = (TextView) Utils.b(view, C1761R.id.retry_button, "field 'retryButton'", TextView.class);
        groupMessagingScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
        groupMessagingScreen.titleTextView = (TextView) Utils.b(view, C1761R.id.title, "field 'titleTextView'", TextView.class);
        groupMessagingScreen.subtitleTextView = (TextView) Utils.b(view, C1761R.id.subtitle, "field 'subtitleTextView'", TextView.class);
    }

    public final void m30862a() {
        GroupMessagingScreen groupMessagingScreen = this.f29868b;
        if (groupMessagingScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29868b = null;
        groupMessagingScreen.recyclerView = null;
        groupMessagingScreen.widgetKeyboard = null;
        groupMessagingScreen.errorContainer = null;
        groupMessagingScreen.errorMessage = null;
        groupMessagingScreen.retryButton = null;
        groupMessagingScreen.noConnectionBanner = null;
        groupMessagingScreen.titleTextView = null;
        groupMessagingScreen.subtitleTextView = null;
    }
}
