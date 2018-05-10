package com.reddit.frontpage.ui.inbox;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ScreenPager;

public class InboxPagerScreen_ViewBinding implements Unbinder {
    private InboxPagerScreen f28999b;

    public InboxPagerScreen_ViewBinding(InboxPagerScreen inboxPagerScreen, View view) {
        this.f28999b = inboxPagerScreen;
        inboxPagerScreen.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
        inboxPagerScreen.mTabLayout = (TabLayout) Utils.b(view, C1761R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
        inboxPagerScreen.screenPager = (ScreenPager) Utils.b(view, C1761R.id.screen_pager, "field 'screenPager'", ScreenPager.class);
    }

    public final void m30065a() {
        InboxPagerScreen inboxPagerScreen = this.f28999b;
        if (inboxPagerScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28999b = null;
        inboxPagerScreen.toolbar = null;
        inboxPagerScreen.mTabLayout = null;
        inboxPagerScreen.screenPager = null;
    }
}
