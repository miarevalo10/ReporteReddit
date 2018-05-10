package com.reddit.frontpage.nav;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Controller.LifecycleListener;
import com.bluelinelabs.conductor.ControllerChangeType;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.frontpage.util.Util;
import timber.log.Timber;

public abstract class Screen extends Controller {
    private static final ScreenLifecycleListener f28039v = new ScreenLifecycleListener();

    private static class ScreenLifecycleListener extends LifecycleListener {
        private ScreenLifecycleListener() {
        }

        public final void m29346a(Controller controller) {
            if (controller instanceof Screen) {
                Screen screen = (Screen) controller;
                screen.mo6985A();
                screen.ah_();
            }
        }

        public final void m29347a(Controller controller, Bundle bundle) {
            if (controller instanceof Screen) {
                ((Screen) controller).mo6985A();
            }
            super.a(controller, bundle);
        }

        public final void m29349b(Controller controller) {
            if (controller instanceof Screen) {
                ((Screen) controller).ae_();
            }
        }

        public final void m29348a(Controller controller, ControllerChangeType controllerChangeType) {
            controllerChangeType = controllerChangeType.f ^ 1;
            controller.a_(controllerChangeType);
            if (controllerChangeType != null) {
                for (Router m : controller.j()) {
                    for (RouterTransaction routerTransaction : m.m()) {
                        routerTransaction.a.a_(true);
                    }
                }
            }
        }
    }

    public abstract void mo6985A();

    public boolean mo6986J() {
        return false;
    }

    public boolean mo7200K() {
        return false;
    }

    public void mo7436L() {
    }

    public abstract void ae_();

    public abstract void ag_();

    public abstract void ah_();

    public boolean mo7210c(Screen screen) {
        return true;
    }

    public int mo7143u() {
        return 1;
    }

    protected Screen() {
    }

    protected Screen(Bundle bundle) {
        super(bundle);
        a(f28039v);
    }

    public void mo6991b(Bundle bundle) {
        super.b(bundle);
        ag_();
    }

    public boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.a(menuItem);
        }
        m29351F();
        return true;
    }

    public void ai_() {
        Util.m23972a(am_().getCurrentFocus());
        Routing.m22621a(this);
    }

    protected final void m29351F() {
        Util.m23972a(am_().getCurrentFocus());
        Routing.m22626a(this, true);
    }

    protected final void m29359a(Screen screen) {
        Routing.m22623a(this, screen);
    }

    protected final void m29360a(Screen screen, String str) {
        Routing.m22625a(this, screen, str);
    }

    protected final void m29352G() {
        Activity am_ = am_();
        if (am_ != null) {
            am_.invalidateOptionsMenu();
        }
    }

    public final void m29363b(Screen screen) {
        m29358a((Controller) screen);
    }

    public Screen mo7220H() {
        return (Screen) k();
    }

    public final void m29358a(Controller controller) {
        if (!(controller == null || mo7210c((Screen) controller))) {
            Timber.e(String.format("Invalid target screen: %s", new Object[]{controller.getClass().getName()}), new Object[0]);
        }
        super.a(controller);
    }

    public boolean mo7197I() {
        return this.i.c.b() > 1;
    }
}
