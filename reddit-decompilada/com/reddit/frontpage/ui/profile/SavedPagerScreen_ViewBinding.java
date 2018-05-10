package com.reddit.frontpage.ui.profile;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ScreenPager;

public class SavedPagerScreen_ViewBinding implements Unbinder {
    private SavedPagerScreen f29241b;

    public SavedPagerScreen_ViewBinding(SavedPagerScreen savedPagerScreen, View view) {
        this.f29241b = savedPagerScreen;
        savedPagerScreen.tabLayout = (TabLayout) Utils.b(view, C1761R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
        savedPagerScreen.screenPager = (ScreenPager) Utils.b(view, C1761R.id.screen_pager, "field 'screenPager'", ScreenPager.class);
    }

    public final void m30348a() {
        SavedPagerScreen savedPagerScreen = this.f29241b;
        if (savedPagerScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29241b = null;
        savedPagerScreen.tabLayout = null;
        savedPagerScreen.screenPager = null;
    }
}
