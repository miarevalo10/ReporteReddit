package com.reddit.frontpage.util;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class ModUtil$$Lambda$2 implements OnClickListener {
    private final Runnable f21757a;

    ModUtil$$Lambda$2(Runnable runnable) {
        this.f21757a = runnable;
    }

    public final void onClick(View view) {
        ModUtil.m23829a(this.f21757a, view);
    }
}
