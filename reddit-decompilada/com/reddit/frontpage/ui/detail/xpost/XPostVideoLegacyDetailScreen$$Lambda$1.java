package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

final /* synthetic */ class XPostVideoLegacyDetailScreen$$Lambda$1 implements OnClickListener {
    private final XPostVideoLegacyDetailScreen f21219a;
    private final Link f21220b;

    XPostVideoLegacyDetailScreen$$Lambda$1(XPostVideoLegacyDetailScreen xPostVideoLegacyDetailScreen, Link link) {
        this.f21219a = xPostVideoLegacyDetailScreen;
        this.f21220b = link;
    }

    public final void onClick(View view) {
        this.f21219a.m42505a(this.f21220b);
    }
}
