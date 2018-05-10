package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.widgets.SubscribeLinkHeaderView;

final /* synthetic */ class SubscribeListingScreen$SubscribeLinkAdapter$$Lambda$0 implements OnClickListener {
    private final SubscribeLinkAdapter f21315a;
    private final String f21316b;
    private final Link f21317c;
    private final SubscribeLinkHeaderView f21318d;

    SubscribeListingScreen$SubscribeLinkAdapter$$Lambda$0(SubscribeLinkAdapter subscribeLinkAdapter, String str, Link link, SubscribeLinkHeaderView subscribeLinkHeaderView) {
        this.f21315a = subscribeLinkAdapter;
        this.f21316b = str;
        this.f21317c = link;
        this.f21318d = subscribeLinkHeaderView;
    }

    public final void onClick(View view) {
        this.f21315a.m37610a(this.f21316b, this.f21317c, this.f21318d);
    }
}
