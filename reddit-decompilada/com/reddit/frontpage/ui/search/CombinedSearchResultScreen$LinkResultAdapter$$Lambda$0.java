package com.reddit.frontpage.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;

final /* synthetic */ class CombinedSearchResultScreen$LinkResultAdapter$$Lambda$0 implements OnClickListener {
    private final LinkResultAdapter f21583a;
    private final Link f21584b;

    CombinedSearchResultScreen$LinkResultAdapter$$Lambda$0(LinkResultAdapter linkResultAdapter, Link link) {
        this.f21583a = linkResultAdapter;
        this.f21584b = link;
    }

    public final void onClick(View view) {
        Routing.m22623a((Screen) this.f21583a.f29278a, Nav.m22557a(this.f21584b.getId(), null, null));
    }
}
