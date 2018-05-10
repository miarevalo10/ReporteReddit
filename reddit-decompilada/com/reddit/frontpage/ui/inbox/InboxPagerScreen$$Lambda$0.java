package com.reddit.frontpage.ui.inbox;

import android.content.DialogInterface;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class InboxPagerScreen$$Lambda$0 implements Function1 {
    private final InboxPagerScreen f34296a;

    InboxPagerScreen$$Lambda$0(InboxPagerScreen inboxPagerScreen) {
        this.f34296a = inboxPagerScreen;
    }

    public final Object mo6492a(Object obj) {
        Screen screen = this.f34296a;
        ((DialogInterface) obj).dismiss();
        Routing.m22623a(screen, Nav.m22588h(null));
        return Unit.f25273a;
    }
}
