package com.reddit.frontpage.ui;

import com.bluelinelabs.conductor.Controller;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.live.TabNavigationStrategy;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.OnItemSelectedListener;
import kotlin.jvm.internal.Intrinsics;

final /* synthetic */ class BottomNavScreen$$Lambda$8 implements OnItemSelectedListener {
    private final BottomNavScreen f28875a;

    BottomNavScreen$$Lambda$8(BottomNavScreen bottomNavScreen) {
        this.f28875a = bottomNavScreen;
    }

    public final void mo4942a(Item item, Item item2) {
        BottomNavScreen bottomNavScreen = this.f28875a;
        if (item == Item.f21974c) {
            item = SessionManager.b().c.isAnonymous();
            item2 = Routing.m22618a(bottomNavScreen.f39128v);
            if (item != null) {
                Routing.m22627b(item2, Nav.m22537a((int) C1761R.string.label_join_reddit, (int) C1761R.string.label_logged_out_profile, Boolean.valueOf(true)));
                return;
            }
            if (!(item2 == null || item2.e == null)) {
                ((BaseScreen) item2).ax();
            }
            return;
        }
        boolean z = false;
        if (item == item2) {
            item2 = bottomNavScreen.f39129w;
            Intrinsics.m26847b(item, "tab");
            TabNavigationStrategy tabNavigationStrategy = item2.f21456b;
            Intrinsics.m26847b(item, "tab");
            String str = (String) tabNavigationStrategy.f21452a.get(item);
            Controller controller = null;
            if (str != null) {
                item2 = item2.f21455a;
                if (item2 == null) {
                    Intrinsics.m26844a("router");
                }
                item2 = item2.c(str);
                if (item2 != null) {
                    controller = (Screen) item2;
                }
            }
            if (controller != null) {
                if (!(controller.e == null || controller.mo7200K() == null)) {
                    z = true;
                }
                if (!z) {
                    bottomNavScreen.m39006a(item, true);
                }
            }
            return;
        }
        bottomNavScreen.m39006a(item, false);
    }
}
