package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

final /* synthetic */ class XPostImageDetailScreen$$Lambda$1 implements OnClickListener {
    private final XPostImageDetailScreen f21210a;
    private final Link f21211b;

    XPostImageDetailScreen$$Lambda$1(XPostImageDetailScreen xPostImageDetailScreen, Link link) {
        this.f21210a = xPostImageDetailScreen;
        this.f21211b = link;
    }

    public final void onClick(View view) {
        this.f21210a.m42483a(this.f21211b);
    }
}
