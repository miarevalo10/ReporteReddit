package com.reddit.frontpage.ui.submit.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import com.reddit.frontpage.ui.submit.search.SubredditSelectScreen.SubredditNameInfoAdapter;

final /* synthetic */ class SubredditSelectScreen$SubredditNameInfoAdapter$$Lambda$0 implements OnClickListener {
    private final SubredditNameInfoAdapter f21645a;
    private final SubredditNameInfo f21646b;

    SubredditSelectScreen$SubredditNameInfoAdapter$$Lambda$0(SubredditNameInfoAdapter subredditNameInfoAdapter, SubredditNameInfo subredditNameInfo) {
        this.f21645a = subredditNameInfoAdapter;
        this.f21646b = subredditNameInfo;
    }

    public final void onClick(View view) {
        view = this.f21645a;
        SubredditNameInfo subredditNameInfo = this.f21646b;
        SubredditSelectScreen.m39601a(view.f29363b, subredditNameInfo.name, subredditNameInfo.id, subredditNameInfo.icon_img, null);
    }
}
