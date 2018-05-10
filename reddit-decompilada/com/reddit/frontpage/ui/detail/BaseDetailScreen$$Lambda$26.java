package com.reddit.frontpage.ui.detail;

import android.view.View;
import com.bluelinelabs.conductor.Controller;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;
import com.reddit.frontpage.ui.layout.StickyHeaderLinearLayoutManager;

final /* synthetic */ class BaseDetailScreen$$Lambda$26 implements Runnable {
    private final BaseDetailScreen f21148a;
    private final String f21149b;
    private final boolean f21150c;
    private final boolean f21151d;

    BaseDetailScreen$$Lambda$26(BaseDetailScreen baseDetailScreen, String str, boolean z, boolean z2) {
        this.f21148a = baseDetailScreen;
        this.f21149b = str;
        this.f21150c = z;
        this.f21151d = z2;
    }

    public final void run() {
        Controller controller = this.f21148a;
        String str = this.f21149b;
        boolean z = this.f21150c;
        boolean z2 = this.f21151d;
        if (controller.e) {
            controller.f39160R = "post_detail";
            int a = controller.f39155H.a(str);
            if (a >= 0) {
                ReplyableTreeNode a2 = controller.f39155H.a(a);
                if (a2.f21184c) {
                    int f = controller.f39154G.m35095f() + a;
                    StickyHeaderLinearLayoutManager stickyHeaderLinearLayoutManager = (StickyHeaderLinearLayoutManager) controller.detailList.getLayoutManager();
                    controller.f39160R = "single_comment_thread";
                    int m = stickyHeaderLinearLayoutManager.m();
                    View a3 = stickyHeaderLinearLayoutManager.a(m);
                    if (a3 == null || !a3.equals(controller.f39152E)) {
                        controller.f39151D.setVisibility(0);
                    } else {
                        controller.f39151D.setVisibility(8);
                    }
                    if (!z || f >= m) {
                        if (z2) {
                            controller.detailList.smoothScrollToPosition(f);
                        } else {
                            stickyHeaderLinearLayoutManager.e(f, controller.f39149B.getMeasuredHeight() * 2);
                        }
                    }
                    if (controller.f39156M != null && str.equals(controller.f39156M)) {
                        controller.f39166Z = true;
                    }
                } else {
                    controller.f39155H.b(a2);
                }
            }
        }
    }
}
