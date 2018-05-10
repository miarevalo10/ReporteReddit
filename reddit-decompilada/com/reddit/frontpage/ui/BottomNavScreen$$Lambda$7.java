package com.reddit.frontpage.ui;

import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import io.reactivex.functions.Consumer;

final /* synthetic */ class BottomNavScreen$$Lambda$7 implements Consumer {
    private final BottomNavScreen f28874a;

    BottomNavScreen$$Lambda$7(BottomNavScreen bottomNavScreen) {
        this.f28874a = bottomNavScreen;
    }

    public final void accept(Object obj) {
        BottomNavScreen bottomNavScreen = this.f28874a;
        obj = ((Integer) obj).intValue();
        Util.m24006c();
        bottomNavScreen.bottomNav.m24210a(Item.f21975d, obj);
    }
}
