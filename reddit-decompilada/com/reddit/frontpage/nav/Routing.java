package com.reddit.frontpage.nav;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SimpleFadeChangeHandler;
import com.reddit.frontpage.animation.VerticalFadeChangeHandler;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.Util;
import timber.log.Timber;

public class Routing {

    public interface NavigationAware {
        Router mo7778g();

        Router mo7779h();
    }

    public static Screen m22617a(Context context) {
        return m22618a(m22616a(Util.m24014d(context)).mo7779h());
    }

    public static void m22619a(Context context, Screen screen) {
        m22623a(m22617a(context), screen);
    }

    public static void m22623a(Screen screen, Screen screen2) {
        m22624a(screen, screen2, screen2.mo7143u(), "");
    }

    public static void m22627b(Screen screen, Screen screen2) {
        m22624a(screen, screen2, 2, "");
    }

    public static void m22625a(Screen screen, Screen screen2, String str) {
        m22624a(screen, screen2, screen2.mo7143u(), str);
    }

    private static void m22624a(Screen screen, Screen screen2, int i, String str) {
        screen = m22616a(screen.am_()).mo7779h();
        switch (i) {
            case 1:
                screen.b(RouterTransaction.a(screen2).a(str).a(new SimpleFadeChangeHandler()).b(new SimpleFadeChangeHandler()));
                return;
            case 2:
                screen.b(RouterTransaction.a(screen2).a(str).a(new VerticalFadeChangeHandler()).b(new VerticalFadeChangeHandler()));
                return;
            default:
                Timber.e("Unknown screen position: %d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    public static ControllerChangeHandler m22615a() {
        return new SimpleFadeChangeHandler();
    }

    public static void m22621a(Screen screen) {
        m22626a(screen, false);
    }

    public static void m22626a(Screen screen, boolean z) {
        Router h = m22616a(screen.am_()).mo7779h();
        if (z || h != Screens.m22630a(screen).i) {
            if (h.m().size() > true) {
                h.j();
            }
            return;
        }
        h.a(new SimpleFadeChangeHandler());
    }

    public static void m22620a(NavigationAware navigationAware, Screen screen, boolean z) {
        navigationAware = z ? navigationAware.mo7779h() : navigationAware.mo7778g();
        if (navigationAware != null) {
            navigationAware.b(RouterTransaction.a(screen).a(new SimpleFadeChangeHandler()).b(new SimpleFadeChangeHandler()));
        }
    }

    public static Screen m22618a(Router router) {
        if (router != null) {
            if (router.n()) {
                return (Screen) ((RouterTransaction) router.m().get(router.c.b() - 1)).a;
            }
        }
        return null;
    }

    private static NavigationAware m22616a(Activity activity) {
        if (activity instanceof NavigationAware) {
            return (NavigationAware) activity;
        }
        throw new IllegalArgumentException("navigateTo is only usable within an Activity which implements NavigationAware");
    }

    public static void m22622a(Screen screen, ActionBar actionBar) {
        Screen screen2 = (Screen) screen.k;
        if ((screen2 == null || !screen2.mo7197I()) && !(screen2 == null && screen.mo7197I())) {
            actionBar.a(null);
            return;
        }
        actionBar.a(true);
        actionBar.b(true);
        NavigationAware a = m22616a(screen.am_());
        if (a.mo7779h() == a.mo7778g()) {
            actionBar.a(ResourcesUtil.m22732e(screen.am_(), (int) C1761R.drawable.ic_icon_close));
        }
    }
}
