package com.reddit.frontpage.presentation.modtools.modlist;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ScreenPager;

public final class ModListPagerScreen_ViewBinding implements Unbinder {
    private ModListPagerScreen f28621b;

    public ModListPagerScreen_ViewBinding(ModListPagerScreen modListPagerScreen, View view) {
        this.f28621b = modListPagerScreen;
        modListPagerScreen.tabLayout = (TabLayout) Utils.b(view, C1761R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
        modListPagerScreen.screenPager = (ScreenPager) Utils.b(view, C1761R.id.screen_pager, "field 'screenPager'", ScreenPager.class);
    }

    public final void m29774a() {
        ModListPagerScreen modListPagerScreen = this.f28621b;
        if (modListPagerScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28621b = null;
        modListPagerScreen.tabLayout = null;
        modListPagerScreen.screenPager = null;
    }
}
