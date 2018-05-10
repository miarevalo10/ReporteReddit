package com.reddit.frontpage.ui;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration$.Lambda.3;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class BottomNavScreen$$Lambda$0 implements Function1 {
    private final BottomNavScreen f34209a;

    BottomNavScreen$$Lambda$0(BottomNavScreen bottomNavScreen) {
        this.f34209a = bottomNavScreen;
    }

    public final Object mo6492a(Object obj) {
        Item item = (Item) obj;
        Session session = SessionManager.b().c;
        boolean isAnonymous = session.isAnonymous();
        String str = null;
        switch (item) {
            case f21972a:
                return Nav.m22536a();
            case f21973b:
                if (!isAnonymous) {
                    str = session.getUsername();
                }
                return Nav.m22547a(str);
            case f21975d:
                if (isAnonymous) {
                    return Nav.m22537a((int) C1761R.string.label_chat, (int) C1761R.string.label_logged_out_chat, Boolean.valueOf(false));
                }
                return Nav.m22587h();
            case f21976e:
                obj = FrontpageSettings.a().t();
                obj = (obj.a(3.$instance) || obj.experiments.trending_pn_logged_out.active == null) ? null : true;
                if (obj == null) {
                    if (isAnonymous) {
                        return Nav.m22537a((int) C1761R.string.label_inbox, (int) C1761R.string.label_logged_out_inbox, Boolean.valueOf(false));
                    }
                }
                return Nav.m22584g();
            default:
                return null;
        }
    }
}
