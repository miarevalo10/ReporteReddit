package com.reddit.social.presentation.groupchat.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.social.presentation.EditTextWithCounter;

public final class MessagingSettingsScreen_ViewBinding implements Unbinder {
    private MessagingSettingsScreen f29876b;

    public MessagingSettingsScreen_ViewBinding(MessagingSettingsScreen messagingSettingsScreen, View view) {
        this.f29876b = messagingSettingsScreen;
        messagingSettingsScreen.groupNameSection = (LinearLayout) Utils.b(view, C1761R.id.group_name_section, "field 'groupNameSection'", LinearLayout.class);
        messagingSettingsScreen.groupName = (EditTextWithCounter) Utils.b(view, C1761R.id.group_name, "field 'groupName'", EditTextWithCounter.class);
        messagingSettingsScreen.saveButton = (Button) Utils.b(view, C1761R.id.save_button, "field 'saveButton'", Button.class);
        messagingSettingsScreen.membersCount = (TextView) Utils.b(view, C1761R.id.members_count, "field 'membersCount'", TextView.class);
        messagingSettingsScreen.membersList = (RecyclerView) Utils.b(view, C1761R.id.private_chat_members, "field 'membersList'", RecyclerView.class);
        messagingSettingsScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
        messagingSettingsScreen.leaveGroupButton = (TextView) Utils.b(view, C1761R.id.leave_group_button, "field 'leaveGroupButton'", TextView.class);
        messagingSettingsScreen.addToGroupButton = (TextView) Utils.b(view, C1761R.id.add_to_group_button, "field 'addToGroupButton'", TextView.class);
        messagingSettingsScreen.startGroupChatButton = (TextView) Utils.b(view, C1761R.id.start_group_chat_button, "field 'startGroupChatButton'", TextView.class);
        messagingSettingsScreen.muteChannelToggleContainer = (LinearLayout) Utils.b(view, C1761R.id.channel_mute_switch_container, "field 'muteChannelToggleContainer'", LinearLayout.class);
        messagingSettingsScreen.muteChannelToggle = (Switch) Utils.b(view, C1761R.id.channel_mute_switch, "field 'muteChannelToggle'", Switch.class);
        messagingSettingsScreen.notifPrefOffText = (TextView) Utils.b(view, C1761R.id.notif_pref_off, "field 'notifPrefOffText'", TextView.class);
    }

    public final void m30864a() {
        MessagingSettingsScreen messagingSettingsScreen = this.f29876b;
        if (messagingSettingsScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29876b = null;
        messagingSettingsScreen.groupNameSection = null;
        messagingSettingsScreen.groupName = null;
        messagingSettingsScreen.saveButton = null;
        messagingSettingsScreen.membersCount = null;
        messagingSettingsScreen.membersList = null;
        messagingSettingsScreen.noConnectionBanner = null;
        messagingSettingsScreen.leaveGroupButton = null;
        messagingSettingsScreen.addToGroupButton = null;
        messagingSettingsScreen.startGroupChatButton = null;
        messagingSettingsScreen.muteChannelToggleContainer = null;
        messagingSettingsScreen.muteChannelToggle = null;
        messagingSettingsScreen.notifPrefOffText = null;
    }
}
