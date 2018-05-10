package com.reddit.social.presentation.chatinbox.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class ChatInboxViewHolder_ViewBinding implements Unbinder {
    private ChatInboxViewHolder f29631b;

    public ChatInboxViewHolder_ViewBinding(ChatInboxViewHolder chatInboxViewHolder, View view) {
        this.f29631b = chatInboxViewHolder;
        chatInboxViewHolder.contentContainer = (RelativeLayout) Utils.b(view, C1761R.id.content_container, "field 'contentContainer'", RelativeLayout.class);
        chatInboxViewHolder.title = (TextView) Utils.b(view, C1761R.id.chat_group_title, "field 'title'", TextView.class);
        chatInboxViewHolder.message = (TextView) Utils.b(view, C1761R.id.chat_message_preview, "field 'message'", TextView.class);
        chatInboxViewHolder.dateText = (TextView) Utils.b(view, C1761R.id.text_group_channel_list_date, "field 'dateText'", TextView.class);
        chatInboxViewHolder.coverImage = (ImageView) Utils.b(view, C1761R.id.icon, "field 'coverImage'", ImageView.class);
        chatInboxViewHolder.iconPairContainer = (RelativeLayout) Utils.b(view, C1761R.id.icon_pair, "field 'iconPairContainer'", RelativeLayout.class);
        chatInboxViewHolder.iconBack = (ImageView) Utils.b(view, C1761R.id.icon_back, "field 'iconBack'", ImageView.class);
        chatInboxViewHolder.iconFront = (ImageView) Utils.b(view, C1761R.id.icon_front, "field 'iconFront'", ImageView.class);
        chatInboxViewHolder.typingIndicatorContainer = (LinearLayout) Utils.b(view, C1761R.id.container_group_channel_list_typing_indicator, "field 'typingIndicatorContainer'", LinearLayout.class);
        chatInboxViewHolder.divider = (TextView) Utils.b(view, C1761R.id.divider, "field 'divider'", TextView.class);
        chatInboxViewHolder.seeAllContainer = (RelativeLayout) Utils.b(view, C1761R.id.see_all_container, "field 'seeAllContainer'", RelativeLayout.class);
        chatInboxViewHolder.seeAllView = (TextView) Utils.b(view, C1761R.id.see_all_view, "field 'seeAllView'", TextView.class);
    }

    public final void m30660a() {
        ChatInboxViewHolder chatInboxViewHolder = this.f29631b;
        if (chatInboxViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29631b = null;
        chatInboxViewHolder.contentContainer = null;
        chatInboxViewHolder.title = null;
        chatInboxViewHolder.message = null;
        chatInboxViewHolder.dateText = null;
        chatInboxViewHolder.coverImage = null;
        chatInboxViewHolder.iconPairContainer = null;
        chatInboxViewHolder.iconBack = null;
        chatInboxViewHolder.iconFront = null;
        chatInboxViewHolder.typingIndicatorContainer = null;
        chatInboxViewHolder.divider = null;
        chatInboxViewHolder.seeAllContainer = null;
        chatInboxViewHolder.seeAllView = null;
    }
}
