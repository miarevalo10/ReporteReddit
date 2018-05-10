package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class BaseScreen$$Lambda$7 implements OnClickListener {
    private final BaseScreen f21064a;

    BaseScreen$$Lambda$7(BaseScreen baseScreen) {
        this.f21064a = baseScreen;
    }

    public final void onClick(View view) {
        view = this.f21064a;
        if (view.am_() == null) {
            RedditLogger.m21984a(BaseScreen$$Lambda$9.f34208a);
            return;
        }
        view.a(IntentUtil.m23738a(view.am_()), 1);
        view.aw();
    }
}
