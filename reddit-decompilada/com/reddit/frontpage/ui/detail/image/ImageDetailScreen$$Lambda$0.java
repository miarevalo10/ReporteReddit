package com.reddit.frontpage.ui.detail.image;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

final /* synthetic */ class ImageDetailScreen$$Lambda$0 implements OnClickListener {
    private final ImageDetailScreen f21187a;
    private final Link f21188b;

    ImageDetailScreen$$Lambda$0(ImageDetailScreen imageDetailScreen, Link link) {
        this.f21187a = imageDetailScreen;
        this.f21188b = link;
    }

    public final void onClick(View view) {
        this.f21187a.m42156a(this.f21188b, view);
    }
}
