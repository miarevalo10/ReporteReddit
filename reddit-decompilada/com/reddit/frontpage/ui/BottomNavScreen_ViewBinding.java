package com.reddit.frontpage.ui;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.FloatingActionsView;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView;

public class BottomNavScreen_ViewBinding implements Unbinder {
    private BottomNavScreen f28881b;

    public BottomNavScreen_ViewBinding(BottomNavScreen bottomNavScreen, View view) {
        this.f28881b = bottomNavScreen;
        bottomNavScreen.content = (ViewGroup) Utils.b(view, C1761R.id.container, "field 'content'", ViewGroup.class);
        bottomNavScreen.bottomNav = (BottomNavView) Utils.b(view, C1761R.id.bottom_nav, "field 'bottomNav'", BottomNavView.class);
        bottomNavScreen.floatingActionsView = (FloatingActionsView) Utils.b(view, C1761R.id.floating_actions_view_bottom_nav, "field 'floatingActionsView'", FloatingActionsView.class);
    }

    public final void m29938a() {
        BottomNavScreen bottomNavScreen = this.f28881b;
        if (bottomNavScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28881b = null;
        bottomNavScreen.content = null;
        bottomNavScreen.bottomNav = null;
        bottomNavScreen.floatingActionsView = null;
    }
}
