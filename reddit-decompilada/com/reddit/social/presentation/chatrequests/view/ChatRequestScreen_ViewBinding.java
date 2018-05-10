package com.reddit.social.presentation.chatrequests.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class ChatRequestScreen_ViewBinding implements Unbinder {
    private ChatRequestScreen f29684b;

    public ChatRequestScreen_ViewBinding(ChatRequestScreen chatRequestScreen, View view) {
        this.f29684b = chatRequestScreen;
        chatRequestScreen.groupInfo = (TextView) Utils.b(view, C1761R.id.group_info, "field 'groupInfo'", TextView.class);
        chatRequestScreen.membersList = (RecyclerView) Utils.b(view, C1761R.id.members_list, "field 'membersList'", RecyclerView.class);
        chatRequestScreen.membersListContainer = (LinearLayout) Utils.b(view, C1761R.id.members_list_container, "field 'membersListContainer'", LinearLayout.class);
        chatRequestScreen.acceptButton = (Button) Utils.b(view, C1761R.id.accept_button, "field 'acceptButton'", Button.class);
        chatRequestScreen.declineButton = (Button) Utils.b(view, C1761R.id.decline_button, "field 'declineButton'", Button.class);
        chatRequestScreen.userHeader = (TextView) Utils.b(view, C1761R.id.user_header, "field 'userHeader'", TextView.class);
        chatRequestScreen.chatNote = (TextView) Utils.b(view, C1761R.id.chat_note, "field 'chatNote'", TextView.class);
        chatRequestScreen.blockerInfo = (TextView) Utils.b(view, C1761R.id.blocker_info, "field 'blockerInfo'", TextView.class);
        chatRequestScreen.inviter = (LinearLayout) Utils.b(view, C1761R.id.inviter, "field 'inviter'", LinearLayout.class);
        chatRequestScreen.inviterIcon = (ImageView) Utils.b(view, C1761R.id.inviter_icon, "field 'inviterIcon'", ImageView.class);
        chatRequestScreen.inviterName = (TextView) Utils.b(view, C1761R.id.inviter_name, "field 'inviterName'", TextView.class);
        chatRequestScreen.inviterNsfw = (TextView) Utils.b(view, C1761R.id.inviter_nsfw, "field 'inviterNsfw'", TextView.class);
        chatRequestScreen.inviterBlocked = (TextView) Utils.b(view, C1761R.id.inviter_blocked, "field 'inviterBlocked'", TextView.class);
        chatRequestScreen.inviterKarmaAndAge = (TextView) Utils.b(view, C1761R.id.inviter_karma_and_age, "field 'inviterKarmaAndAge'", TextView.class);
        chatRequestScreen.chatRequestMessage = (FrameLayout) Utils.b(view, C1761R.id.chat_request_message, "field 'chatRequestMessage'", FrameLayout.class);
        chatRequestScreen.previewMessageContainer = (LinearLayout) Utils.b(view, C1761R.id.message_preview_container, "field 'previewMessageContainer'", LinearLayout.class);
        chatRequestScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
        chatRequestScreen.progress = Utils.a(view, C1761R.id.progress, "field 'progress'");
        chatRequestScreen.requestInfo = (LinearLayout) Utils.b(view, C1761R.id.request_info, "field 'requestInfo'", LinearLayout.class);
    }

    public final void m30706a() {
        ChatRequestScreen chatRequestScreen = this.f29684b;
        if (chatRequestScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29684b = null;
        chatRequestScreen.groupInfo = null;
        chatRequestScreen.membersList = null;
        chatRequestScreen.membersListContainer = null;
        chatRequestScreen.acceptButton = null;
        chatRequestScreen.declineButton = null;
        chatRequestScreen.userHeader = null;
        chatRequestScreen.chatNote = null;
        chatRequestScreen.blockerInfo = null;
        chatRequestScreen.inviter = null;
        chatRequestScreen.inviterIcon = null;
        chatRequestScreen.inviterName = null;
        chatRequestScreen.inviterNsfw = null;
        chatRequestScreen.inviterBlocked = null;
        chatRequestScreen.inviterKarmaAndAge = null;
        chatRequestScreen.chatRequestMessage = null;
        chatRequestScreen.previewMessageContainer = null;
        chatRequestScreen.noConnectionBanner = null;
        chatRequestScreen.progress = null;
        chatRequestScreen.requestInfo = null;
    }
}
