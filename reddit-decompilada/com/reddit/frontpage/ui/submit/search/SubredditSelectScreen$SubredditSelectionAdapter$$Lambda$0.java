package com.reddit.frontpage.ui.submit.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.ui.submit.search.SubredditSelectScreen.SubredditSelectionAdapter;

final /* synthetic */ class SubredditSelectScreen$SubredditSelectionAdapter$$Lambda$0 implements OnClickListener {
    private final SubredditSelectionAdapter f21647a;
    private final SubredditData f21648b;

    SubredditSelectScreen$SubredditSelectionAdapter$$Lambda$0(SubredditSelectionAdapter subredditSelectionAdapter, SubredditData subredditData) {
        this.f21647a = subredditSelectionAdapter;
        this.f21648b = subredditData;
    }

    public final void onClick(View view) {
        view = this.f21647a;
        SubredditSelectData subredditSelectData = this.f21648b;
        SubredditSelectScreen.m39601a(view.f29367b, subredditSelectData.f21640d, subredditSelectData.f29354a, subredditSelectData.f29355b, subredditSelectData.f29356c);
    }
}
