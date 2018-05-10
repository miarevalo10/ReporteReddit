package com.reddit.frontpage.ui.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.frontpage.ui.submit.search.SubredditSelectEvent;
import de.greenrobot.event.EventBus;

final /* synthetic */ class SubredditSelectDialog$RecentSubredditAdapter$$Lambda$0 implements OnClickListener {
    private final RecentSubredditAdapter f21625a;
    private final RecentSubreddit f21626b;

    SubredditSelectDialog$RecentSubredditAdapter$$Lambda$0(RecentSubredditAdapter recentSubredditAdapter, RecentSubreddit recentSubreddit) {
        this.f21625a = recentSubredditAdapter;
        this.f21626b = recentSubreddit;
    }

    public final void onClick(View view) {
        view = this.f21625a;
        RecentSubreddit recentSubreddit = this.f21626b;
        EventBus.getDefault().postSticky(new SubredditSelectEvent(view.f34460a.f21631e, recentSubreddit.subredditName, recentSubreddit.subredditId, recentSubreddit.icon, recentSubreddit.keyColor));
        view.f34460a.f21632f.dismiss();
    }
}
