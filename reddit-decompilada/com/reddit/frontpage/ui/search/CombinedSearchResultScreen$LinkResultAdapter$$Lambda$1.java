package com.reddit.frontpage.ui.search;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.widgets.LinkFooterView.OnViewCommentsListener;

final /* synthetic */ class CombinedSearchResultScreen$LinkResultAdapter$$Lambda$1 implements OnViewCommentsListener {
    private final LinkResultAdapter f29275a;
    private final Link f29276b;

    CombinedSearchResultScreen$LinkResultAdapter$$Lambda$1(LinkResultAdapter linkResultAdapter, Link link) {
        this.f29275a = linkResultAdapter;
        this.f29276b = link;
    }

    public final void mo4990a() {
        Routing.m22623a((Screen) this.f29275a.f29278a, Nav.m22557a(this.f29276b.getId(), null, null));
    }
}
