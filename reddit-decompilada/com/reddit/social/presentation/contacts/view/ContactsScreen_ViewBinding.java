package com.reddit.social.presentation.contacts.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.social.presentation.EditTextWithCounter;

public final class ContactsScreen_ViewBinding implements Unbinder {
    private ContactsScreen f29732b;

    public ContactsScreen_ViewBinding(ContactsScreen contactsScreen, View view) {
        this.f29732b = contactsScreen;
        contactsScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        contactsScreen.noContactsView = (TextView) Utils.b(view, C1761R.id.no_contacts_view, "field 'noContactsView'", TextView.class);
        contactsScreen.contactsCompletionView = (ContactsCompletionView) Utils.b(view, C1761R.id.name_completion_view, "field 'contactsCompletionView'", ContactsCompletionView.class);
        contactsScreen.contactsContainer = (LinearLayout) Utils.b(view, C1761R.id.contacts_invite_container, "field 'contactsContainer'", LinearLayout.class);
        contactsScreen.groupNameContainer = (LinearLayout) Utils.b(view, C1761R.id.contacts_group_name_container, "field 'groupNameContainer'", LinearLayout.class);
        contactsScreen.groupNameEditText = (EditTextWithCounter) Utils.b(view, C1761R.id.contacts_group_name, "field 'groupNameEditText'", EditTextWithCounter.class);
        contactsScreen.inviteButton = (Button) Utils.b(view, C1761R.id.invite_button, "field 'inviteButton'", Button.class);
        contactsScreen.noConnectionBanner = (TextView) Utils.b(view, C1761R.id.connection_banner, "field 'noConnectionBanner'", TextView.class);
        contactsScreen.titleTextView = (TextView) Utils.b(view, C1761R.id.title, "field 'titleTextView'", TextView.class);
        contactsScreen.subtitleTextView = (TextView) Utils.b(view, C1761R.id.subtitle, "field 'subtitleTextView'", TextView.class);
    }

    public final void m30759a() {
        ContactsScreen contactsScreen = this.f29732b;
        if (contactsScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29732b = null;
        contactsScreen.recyclerView = null;
        contactsScreen.noContactsView = null;
        contactsScreen.contactsCompletionView = null;
        contactsScreen.contactsContainer = null;
        contactsScreen.groupNameContainer = null;
        contactsScreen.groupNameEditText = null;
        contactsScreen.inviteButton = null;
        contactsScreen.noConnectionBanner = null;
        contactsScreen.titleTextView = null;
        contactsScreen.subtitleTextView = null;
    }
}
