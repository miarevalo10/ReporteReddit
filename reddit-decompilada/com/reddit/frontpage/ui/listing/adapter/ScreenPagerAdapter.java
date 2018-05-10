package com.reddit.frontpage.ui.listing.adapter;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.BaseScreen;

public abstract class ScreenPagerAdapter extends RouterPagerAdapter {
    public boolean f34367g = true;

    public abstract Screen mo6953a(int i);

    public void mo6954a(Screen screen, int i) {
    }

    public abstract int mo6955f();

    public ScreenPagerAdapter(Controller controller, boolean z) {
        super(controller);
        this.b = z ? RedditJobManager.f10810d : null;
        super.e();
    }

    public final void m35099a(Router router, int i) {
        Screen screen;
        if (router.n()) {
            screen = (BaseScreen) ((RouterTransaction) router.m().get(0)).a;
        } else {
            screen = (BaseScreen) mo6953a(i);
            screen.suppressScreenViewEvent = true;
            router.d(RouterTransaction.a(screen));
        }
        mo6954a(screen, i);
    }

    public final void m35104g() {
        this.f34367g = false;
    }

    public final int m35101c() {
        return this.f34367g ? mo6955f() : 0;
    }

    public final Screen m35102d(int i) {
        Router router = (Router) this.c.get(i);
        return (router == null || router.c.b() <= 0) ? 0 : (Screen) ((RouterTransaction) router.m().get(0)).a;
    }
}
