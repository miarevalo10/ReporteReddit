package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class BaseDetailScreen$$Lambda$10 implements OnClickListener {
    private final BaseDetailScreen f21135a;

    BaseDetailScreen$$Lambda$10(BaseDetailScreen baseDetailScreen) {
        this.f21135a = baseDetailScreen;
    }

    public final void onClick(View view) {
        view = this.f21135a;
        view.detailList.smoothScrollToPosition(view.f39154G.m35095f());
        view.f39165Y = 0;
        view.f39148A.setLiveCommentCount(view.f39165Y);
    }
}
