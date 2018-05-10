package com.reddit.frontpage.ui.search;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.widgets.LinkFooterView.OnViewCommentsListener;

final /* synthetic */ class LinkSearchResultScreen$LinkResultAdapter$$Lambda$2 implements OnViewCommentsListener {
    private final LinkResultAdapter f29291a;
    private final Link f29292b;

    LinkSearchResultScreen$LinkResultAdapter$$Lambda$2(LinkResultAdapter linkResultAdapter, Link link) {
        this.f29291a = linkResultAdapter;
        this.f29292b = link;
    }

    public final void mo4990a() {
        Routing.m22623a((Screen) this.f29291a.f29294a, Nav.m22557a(this.f29292b.getId(), null, null));
    }
}
