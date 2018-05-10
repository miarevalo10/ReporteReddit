package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class XPostVideoLegacyDetailScreen$$Lambda$0 implements OnClickListener {
    private final XPostVideoLegacyDetailScreen f21217a;
    private final Link f21218b;

    XPostVideoLegacyDetailScreen$$Lambda$0(XPostVideoLegacyDetailScreen xPostVideoLegacyDetailScreen, Link link) {
        this.f21217a = xPostVideoLegacyDetailScreen;
        this.f21218b = link;
    }

    public final void onClick(View view) {
        Routing.m22627b(Routing.m22617a(this.f21217a.am_()), Nav.m22541a(this.f21218b));
    }
}
