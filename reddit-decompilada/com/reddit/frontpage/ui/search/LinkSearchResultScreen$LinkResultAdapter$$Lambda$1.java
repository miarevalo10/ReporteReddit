package com.reddit.frontpage.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;

final /* synthetic */ class LinkSearchResultScreen$LinkResultAdapter$$Lambda$1 implements OnClickListener {
    private final LinkResultAdapter f21592a;
    private final Link f21593b;

    LinkSearchResultScreen$LinkResultAdapter$$Lambda$1(LinkResultAdapter linkResultAdapter, Link link) {
        this.f21592a = linkResultAdapter;
        this.f21593b = link;
    }

    public final void onClick(View view) {
        Routing.m22623a((Screen) this.f21592a.f29294a, Nav.m22557a(this.f21593b.getId(), null, null));
    }
}
