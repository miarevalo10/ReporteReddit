package com.reddit.social.presentation.groupchat.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class GroupMembersScreen_ViewBinding implements Unbinder {
    private GroupMembersScreen f29852b;

    public GroupMembersScreen_ViewBinding(GroupMembersScreen groupMembersScreen, View view) {
        this.f29852b = groupMembersScreen;
        groupMembersScreen.members = (RecyclerView) Utils.b(view, C1761R.id.members, "field 'members'", RecyclerView.class);
        groupMembersScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
    }

    public final void m30853a() {
        GroupMembersScreen groupMembersScreen = this.f29852b;
        if (groupMembersScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29852b = null;
        groupMembersScreen.members = null;
        groupMembersScreen.noConnectionBanner = null;
    }
}
