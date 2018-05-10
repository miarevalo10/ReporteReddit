package com.reddit.frontpage.nav;

import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen.FloatingActionsCallback;
import com.reddit.frontpage.widgets.FloatingActionsView;
import com.reddit.frontpage.widgets.FloatingActionsView$$Lambda$5;

public class FloatingActionsManager implements FloatingActionsCallback {
    final FloatingActionsView f28037a;
    private boolean f28038b;

    public FloatingActionsManager(FloatingActionsView floatingActionsView) {
        this.f28037a = floatingActionsView;
        this.f28037a.setMenuOnClickedListener(new FloatingActionsManager$$Lambda$0(this));
    }

    public final void m29345a(BaseScreen baseScreen) {
        this.f28038b = false;
        this.f28037a.m24141b();
        if (baseScreen != null) {
            baseScreen.f37157L = this;
        }
        if (this.f28038b == null) {
            this.f28037a.setMenuSubmitMediaOnClickedListener(null);
            this.f28037a.setMenuSubmitSelfOnClickedListener(null);
            this.f28037a.setMenuSubmitLinkOnClickedListener(null);
            baseScreen = this.f28037a;
            baseScreen.m24140a(new FloatingActionsView$$Lambda$5(baseScreen));
            this.f28037a.setButtonOnClickedListener(null);
            FloatingActionsView.m24137a(this.f28037a.button, true);
            this.f28037a.setEnabled(false);
        }
    }
}
