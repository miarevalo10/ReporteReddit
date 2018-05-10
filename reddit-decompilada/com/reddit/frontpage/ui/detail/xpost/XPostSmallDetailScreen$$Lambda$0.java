package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class XPostSmallDetailScreen$$Lambda$0 implements OnClickListener {
    private final XPostSmallDetailScreen f21212a;
    private final Link f21213b;

    XPostSmallDetailScreen$$Lambda$0(XPostSmallDetailScreen xPostSmallDetailScreen, Link link) {
        this.f21212a = xPostSmallDetailScreen;
        this.f21213b = link;
    }

    public final void onClick(View view) {
        Routing.m22627b(Routing.m22617a(this.f21212a.am_()), Nav.m22541a(this.f21213b));
    }
}
