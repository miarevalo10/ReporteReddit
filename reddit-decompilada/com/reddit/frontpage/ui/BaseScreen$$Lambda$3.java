package com.reddit.frontpage.ui;

import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.view.MenuItem;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.Util;
import timber.log.Timber;

final /* synthetic */ class BaseScreen$$Lambda$3 implements OnNavigationItemSelectedListener {
    private final BaseScreen f28867a;

    BaseScreen$$Lambda$3(BaseScreen baseScreen) {
        this.f28867a = baseScreen;
    }

    public final boolean m29931a(MenuItem menuItem) {
        Screen screen = this.f28867a;
        menuItem = menuItem.getItemId();
        if (menuItem != C1761R.id.profile_history) {
            switch (menuItem) {
                case C1761R.id.profile_saved:
                    Routing.m22623a(screen, Nav.m22577e());
                    break;
                case C1761R.id.profile_self:
                    screen.av();
                    break;
                case C1761R.id.profile_sign_up_log_in:
                    SessionManager.b().a(Util.m24019e(screen.am_()), false);
                    break;
                default:
                    Timber.e("Unknown menu item specified.", new Object[0]);
                    break;
            }
        }
        Routing.m22623a(screen, Nav.m22581f());
        screen.aw();
        return true;
    }
}
