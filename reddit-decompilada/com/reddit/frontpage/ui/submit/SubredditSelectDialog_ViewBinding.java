package com.reddit.frontpage.ui.submit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.GoEditTextView;
import com.reddit.frontpage.widgets.ShapedIconView;

public class SubredditSelectDialog_ViewBinding implements Unbinder {
    private SubredditSelectDialog f29333b;

    public SubredditSelectDialog_ViewBinding(SubredditSelectDialog subredditSelectDialog, View view) {
        this.f29333b = subredditSelectDialog;
        subredditSelectDialog.recentList = (RecyclerView) Utils.b(view, C1761R.id.recent_list, "field 'recentList'", RecyclerView.class);
        subredditSelectDialog.promoterInfoContainer = Utils.a(view, C1761R.id.promoter_info_container, "field 'promoterInfoContainer'");
        subredditSelectDialog.promoterIcon = (ShapedIconView) Utils.b(view, C1761R.id.promter_icon, "field 'promoterIcon'", ShapedIconView.class);
        subredditSelectDialog.promoterName = (TextView) Utils.b(view, C1761R.id.promoter_name, "field 'promoterName'", TextView.class);
        subredditSelectDialog.communityName = (GoEditTextView) Utils.b(view, C1761R.id.edit_subreddit, "field 'communityName'", GoEditTextView.class);
    }

    public final void m30401a() {
        SubredditSelectDialog subredditSelectDialog = this.f29333b;
        if (subredditSelectDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29333b = null;
        subredditSelectDialog.recentList = null;
        subredditSelectDialog.promoterInfoContainer = null;
        subredditSelectDialog.promoterIcon = null;
        subredditSelectDialog.promoterName = null;
        subredditSelectDialog.communityName = null;
    }
}
