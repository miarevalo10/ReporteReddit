package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

final /* synthetic */ class XPostSmallDetailScreen$$Lambda$1 implements OnClickListener {
    private final XPostSmallDetailScreen f21214a;
    private final Link f21215b;

    XPostSmallDetailScreen$$Lambda$1(XPostSmallDetailScreen xPostSmallDetailScreen, Link link) {
        this.f21214a = xPostSmallDetailScreen;
        this.f21215b = link;
    }

    public final void onClick(View view) {
        this.f21214a.m42486a(this.f21215b);
    }
}
