package com.reddit.social.presentation.contacts.view;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class ContactViewHolder_ViewBinding implements Unbinder {
    private ContactViewHolder f29725b;

    public ContactViewHolder_ViewBinding(ContactViewHolder contactViewHolder, View view) {
        this.f29725b = contactViewHolder;
        contactViewHolder.row = (RelativeLayout) Utils.b(view, C1761R.id.row, "field 'row'", RelativeLayout.class);
        contactViewHolder.restOfRedditText = (TextView) Utils.b(view, C1761R.id.rest_of_reddit_text, "field 'restOfRedditText'", TextView.class);
        contactViewHolder.icon = (ImageView) Utils.b(view, C1761R.id.user_icon, "field 'icon'", ImageView.class);
        contactViewHolder.checkBox = (CheckBox) Utils.b(view, C1761R.id.check_box, "field 'checkBox'", CheckBox.class);
        contactViewHolder.username = (TextView) Utils.b(view, C1761R.id.username, "field 'username'", TextView.class);
        contactViewHolder.karmaAndAge = (TextView) Utils.b(view, C1761R.id.karma_and_age, "field 'karmaAndAge'", TextView.class);
        contactViewHolder.status = (TextView) Utils.b(view, C1761R.id.status, "field 'status'", TextView.class);
    }

    public final void m30753a() {
        ContactViewHolder contactViewHolder = this.f29725b;
        if (contactViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29725b = null;
        contactViewHolder.row = null;
        contactViewHolder.restOfRedditText = null;
        contactViewHolder.icon = null;
        contactViewHolder.checkBox = null;
        contactViewHolder.username = null;
        contactViewHolder.karmaAndAge = null;
        contactViewHolder.status = null;
    }
}
