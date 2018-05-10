package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LinkFlairView_ViewBinding implements Unbinder {
    private LinkFlairView f29125b;

    public LinkFlairView_ViewBinding(LinkFlairView linkFlairView, View view) {
        this.f29125b = linkFlairView;
        linkFlairView.nsfwView = (TextView) Utils.b(view, C1761R.id.link_flair_nsfw, "field 'nsfwView'", TextView.class);
        linkFlairView.spoilerView = (TextView) Utils.b(view, C1761R.id.link_flair_spoiler, "field 'spoilerView'", TextView.class);
        linkFlairView.quarantinedView = (TextView) Utils.b(view, C1761R.id.link_flair_quarantined, "field 'quarantinedView'", TextView.class);
        linkFlairView.flairView = (TextView) Utils.b(view, C1761R.id.link_flair_flair, "field 'flairView'", TextView.class);
        linkFlairView.removedView = (TextView) Utils.b(view, C1761R.id.link_flair_removed, "field 'removedView'", TextView.class);
        linkFlairView.removedSpamView = (TextView) Utils.b(view, C1761R.id.link_flair_removed_as_spam, "field 'removedSpamView'", TextView.class);
    }

    public final void m30243a() {
        LinkFlairView linkFlairView = this.f29125b;
        if (linkFlairView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29125b = null;
        linkFlairView.nsfwView = null;
        linkFlairView.spoilerView = null;
        linkFlairView.quarantinedView = null;
        linkFlairView.flairView = null;
        linkFlairView.removedView = null;
        linkFlairView.removedSpamView = null;
    }
}
