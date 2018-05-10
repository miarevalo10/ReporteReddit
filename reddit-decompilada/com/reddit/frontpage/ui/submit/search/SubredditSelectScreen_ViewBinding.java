package com.reddit.frontpage.ui.submit.search;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.GoEditTextView;

public class SubredditSelectScreen_ViewBinding implements Unbinder {
    private SubredditSelectScreen f29370b;

    public SubredditSelectScreen_ViewBinding(SubredditSelectScreen subredditSelectScreen, View view) {
        this.f29370b = subredditSelectScreen;
        subredditSelectScreen.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
        subredditSelectScreen.subredditFilter = (GoEditTextView) Utils.b(view, C1761R.id.filter, "field 'subredditFilter'", GoEditTextView.class);
        subredditSelectScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    }

    public final void m30424a() {
        SubredditSelectScreen subredditSelectScreen = this.f29370b;
        if (subredditSelectScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29370b = null;
        subredditSelectScreen.toolbar = null;
        subredditSelectScreen.subredditFilter = null;
        subredditSelectScreen.recyclerView = null;
    }
}
