package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.util.LinkUtil;

final /* synthetic */ class LinkFooterView$$Lambda$6 implements OnClickListener {
    private final LinkFooterView f21897a;
    private final Link f21898b;

    LinkFooterView$$Lambda$6(LinkFooterView linkFooterView, Link link) {
        this.f21897a = linkFooterView;
        this.f21898b = link;
    }

    public final void onClick(View view) {
        LinkFooterView linkFooterView = this.f21897a;
        Link link = this.f21898b;
        if (linkFooterView.f21902d != null) {
            view = AppAnalytics.m21858b().m21823a(view);
            view.f19955b = "post_share";
            view.f19956c = link.getUrl();
            view.f19957d = link.getName();
            view.f19959f = link.getDomain();
            view.m21825a();
            LinkUtil.m23785a(link, linkFooterView.extraActionContainer);
            view = linkFooterView.f21902d;
            link.getTitle();
            view.mo4945a(link.getPermalink(), link);
        }
    }
}
