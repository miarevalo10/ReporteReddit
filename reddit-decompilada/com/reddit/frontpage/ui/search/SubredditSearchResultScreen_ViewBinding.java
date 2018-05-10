package com.reddit.frontpage.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SubredditSearchResultScreen_ViewBinding implements Unbinder {
    private SubredditSearchResultScreen f29302b;

    public SubredditSearchResultScreen_ViewBinding(SubredditSearchResultScreen subredditSearchResultScreen, View view) {
        this.f29302b = subredditSearchResultScreen;
        subredditSearchResultScreen.loadingSnoo = Utils.a(view, C1761R.id.progress_bar, "field 'loadingSnoo'");
        subredditSearchResultScreen.mResultList = (RecyclerView) Utils.b(view, C1761R.id.result_list, "field 'mResultList'", RecyclerView.class);
    }

    public final void m30386a() {
        SubredditSearchResultScreen subredditSearchResultScreen = this.f29302b;
        if (subredditSearchResultScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29302b = null;
        subredditSearchResultScreen.loadingSnoo = null;
        subredditSearchResultScreen.mResultList = null;
    }
}
