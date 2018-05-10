package com.reddit.frontpage.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class SubredditSearchResultScreen$SubredditResultAdapter$$Lambda$0 implements OnClickListener {
    private final SubredditResultAdapter f21594a;
    private final Account f21595b;
    private final Subreddit f21596c;

    SubredditSearchResultScreen$SubredditResultAdapter$$Lambda$0(SubredditResultAdapter subredditResultAdapter, Account account, Subreddit subreddit) {
        this.f21594a = subredditResultAdapter;
        this.f21595b = account;
        this.f21596c = subreddit;
    }

    public final void onClick(View view) {
        view = this.f21594a;
        Account account = this.f21595b;
        Subreddit subreddit = this.f21596c;
        Util.m23972a(view.f29301a.f39328y);
        if (account == null) {
            Routing.m22623a((Screen) view.f29301a, Nav.m22566b(subreddit.display_name));
        } else if (!Util.m24041k(account.getName())) {
            Routing.m22623a((Screen) view.f29301a, Nav.m22594j(account.getName()));
        }
    }
}
