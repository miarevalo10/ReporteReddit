package com.reddit.frontpage.ui.detail.video;

import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.widgets.LinkFooterView.OnShareListener;

final /* synthetic */ class VideoPlayerScreen$$Lambda$3 implements OnShareListener {
    private final ViewGroup f28976a;

    VideoPlayerScreen$$Lambda$3(ViewGroup viewGroup) {
        this.f28976a = viewGroup;
    }

    public final void mo4945a(String str, Link link) {
        VideoPlayerScreen.m40936b(this.f28976a, str);
    }
}
