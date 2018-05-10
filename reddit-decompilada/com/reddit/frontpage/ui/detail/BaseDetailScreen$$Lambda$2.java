package com.reddit.frontpage.ui.detail;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import com.bluelinelabs.conductor.Controller;

final /* synthetic */ class BaseDetailScreen$$Lambda$2 implements OnOffsetChangedListener {
    private final BaseDetailScreen f28937a;

    BaseDetailScreen$$Lambda$2(BaseDetailScreen baseDetailScreen) {
        this.f28937a = baseDetailScreen;
    }

    public final void m29991a(AppBarLayout appBarLayout, int i) {
        Controller controller = this.f28937a;
        if (controller.e) {
            appBarLayout = (!controller.detailList.isNestedScrollingEnabled() || i + appBarLayout.getTotalScrollRange() > 0) ? null : true;
            if (appBarLayout != null) {
                controller.mo4953b(controller.f39150C.f28924a);
                return;
            }
            controller.mo4953b((Integer) null);
        }
    }
}
