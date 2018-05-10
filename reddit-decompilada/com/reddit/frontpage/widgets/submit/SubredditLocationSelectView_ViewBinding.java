package com.reddit.frontpage.widgets.submit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ShapedIconView;

public class SubredditLocationSelectView_ViewBinding implements Unbinder {
    private SubredditLocationSelectView f29536b;

    public SubredditLocationSelectView_ViewBinding(SubredditLocationSelectView subredditLocationSelectView, View view) {
        this.f29536b = subredditLocationSelectView;
        subredditLocationSelectView.subredditIcon = (ShapedIconView) Utils.b(view, C1761R.id.subreddit_icon, "field 'subredditIcon'", ShapedIconView.class);
        subredditLocationSelectView.subredditView = (TextView) Utils.b(view, C1761R.id.subreddit_name, "field 'subredditView'", TextView.class);
        subredditLocationSelectView.rulesButton = (TextView) Utils.b(view, C1761R.id.subreddit_rules, "field 'rulesButton'", TextView.class);
        subredditLocationSelectView.dropdownIcon = (ImageView) Utils.b(view, C1761R.id.subreddit_dropdown, "field 'dropdownIcon'", ImageView.class);
        subredditLocationSelectView.locationContainer = Utils.a(view, C1761R.id.location_container, "field 'locationContainer'");
        subredditLocationSelectView.locationIcon = (ImageView) Utils.b(view, C1761R.id.location_icon, "field 'locationIcon'", ImageView.class);
        subredditLocationSelectView.locationView = (TextView) Utils.b(view, C1761R.id.location_text, "field 'locationView'", TextView.class);
        subredditLocationSelectView.defaultSubredditText = view.getContext().getResources().getString(C1761R.string.title_select_community);
    }

    public final void m30540a() {
        SubredditLocationSelectView subredditLocationSelectView = this.f29536b;
        if (subredditLocationSelectView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29536b = null;
        subredditLocationSelectView.subredditIcon = null;
        subredditLocationSelectView.subredditView = null;
        subredditLocationSelectView.rulesButton = null;
        subredditLocationSelectView.dropdownIcon = null;
        subredditLocationSelectView.locationContainer = null;
        subredditLocationSelectView.locationIcon = null;
        subredditLocationSelectView.locationView = null;
    }
}
