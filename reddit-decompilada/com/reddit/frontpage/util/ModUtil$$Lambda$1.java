package com.reddit.frontpage.util;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class ModUtil$$Lambda$1 implements OnClickListener {
    private final Runnable f21756a;

    ModUtil$$Lambda$1(Runnable runnable) {
        this.f21756a = runnable;
    }

    public final void onClick(View view) {
        ModUtil.m23833b(this.f21756a, view);
    }
}
