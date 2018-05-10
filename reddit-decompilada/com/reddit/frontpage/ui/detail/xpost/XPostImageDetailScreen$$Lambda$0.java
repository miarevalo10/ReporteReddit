package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class XPostImageDetailScreen$$Lambda$0 implements OnClickListener {
    private final XPostImageDetailScreen f21208a;
    private final Link f21209b;

    XPostImageDetailScreen$$Lambda$0(XPostImageDetailScreen xPostImageDetailScreen, Link link) {
        this.f21208a = xPostImageDetailScreen;
        this.f21209b = link;
    }

    public final void onClick(View view) {
        Routing.m22627b(Routing.m22617a(this.f21208a.am_()), Nav.m22541a(this.f21209b));
    }
}
