package com.reddit.frontpage.widgets;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;

final /* synthetic */ class LinkHeaderView$$Lambda$4 implements OnModActionCompletedListener {
    private final LinkHeaderView f29459a;
    private final Link f29460b;

    LinkHeaderView$$Lambda$4(LinkHeaderView linkHeaderView, Link link) {
        this.f29459a = linkHeaderView;
        this.f29460b = link;
    }

    public final void mo4891a() {
        this.f29459a.b_(this.f29460b);
    }
}
