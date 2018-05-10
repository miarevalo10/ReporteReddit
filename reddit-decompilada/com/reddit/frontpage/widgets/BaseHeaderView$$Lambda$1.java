package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class BaseHeaderView$$Lambda$1 implements OnClickListener {
    private final BaseHeaderView f21846a;
    private final Runnable f21847b;

    BaseHeaderView$$Lambda$1(BaseHeaderView baseHeaderView, Runnable runnable) {
        this.f21846a = baseHeaderView;
        this.f21847b = runnable;
    }

    public final void onClick(View view) {
        this.f21846a.m24135b(this.f21847b);
    }
}
