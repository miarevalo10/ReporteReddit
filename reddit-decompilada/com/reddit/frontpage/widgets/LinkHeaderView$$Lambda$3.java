package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.Reportable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.ui.modtools.PopupModReports;

final /* synthetic */ class LinkHeaderView$$Lambda$3 implements OnClickListener {
    private final LinkHeaderView f21911a;
    private final Link f21912b;

    LinkHeaderView$$Lambda$3(LinkHeaderView linkHeaderView, Link link) {
        this.f21911a = linkHeaderView;
        this.f21912b = link;
    }

    public final void onClick(View view) {
        view = this.f21911a;
        Reportable reportable = this.f21912b;
        if (reportable.getNumReports() > 0) {
            new PopupModReports(view.getContext(), reportable, AppAnalytics.m21849a(view), new LinkHeaderView$$Lambda$4(view, reportable)).m23562b();
        }
    }
}
