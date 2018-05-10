package com.reddit.frontpage.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.util.SubredditUtil;

final /* synthetic */ class SubscribeLinkHeaderView$$Lambda$1 implements OnClickListener {
    private final SubscribeLinkHeaderView f21948a;
    private final Link f21949b;

    SubscribeLinkHeaderView$$Lambda$1(SubscribeLinkHeaderView subscribeLinkHeaderView, Link link) {
        this.f21948a = subscribeLinkHeaderView;
        this.f21949b = link;
    }

    public final void onClick(View view) {
        view = this.f21948a;
        Link link = this.f21949b;
        Context context = view.getTopMetadata().getContext();
        if (SubredditUtil.m23920a(link.getSubreddit())) {
            Routing.m22619a(context, Nav.m22594j(link.getAuthor()));
        } else {
            Routing.m22619a(context, Nav.m22566b(link.getSubreddit()));
        }
    }
}
