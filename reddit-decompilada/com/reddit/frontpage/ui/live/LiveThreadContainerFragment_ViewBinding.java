package com.reddit.frontpage.ui.live;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LiveThreadContainerFragment_ViewBinding implements Unbinder {
    private LiveThreadContainerFragment f29157b;

    public LiveThreadContainerFragment_ViewBinding(LiveThreadContainerFragment liveThreadContainerFragment, View view) {
        this.f29157b = liveThreadContainerFragment;
        liveThreadContainerFragment.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
        liveThreadContainerFragment.tabLayout = (TabLayout) Utils.b(view, C1761R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
        liveThreadContainerFragment.viewPager = (ViewPager) Utils.b(view, C1761R.id.view_pager, "field 'viewPager'", ViewPager.class);
        liveThreadContainerFragment.liveTitleView = (TextView) Utils.b(view, C1761R.id.reddit_live, "field 'liveTitleView'", TextView.class);
        liveThreadContainerFragment.liveViewersView = (TextView) Utils.b(view, C1761R.id.live_viewer_count, "field 'liveViewersView'", TextView.class);
    }

    public final void m30263a() {
        LiveThreadContainerFragment liveThreadContainerFragment = this.f29157b;
        if (liveThreadContainerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29157b = null;
        liveThreadContainerFragment.toolbar = null;
        liveThreadContainerFragment.tabLayout = null;
        liveThreadContainerFragment.viewPager = null;
        liveThreadContainerFragment.liveTitleView = null;
        liveThreadContainerFragment.liveViewersView = null;
    }
}
