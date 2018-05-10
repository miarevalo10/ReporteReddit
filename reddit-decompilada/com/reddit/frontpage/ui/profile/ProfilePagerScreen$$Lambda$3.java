package com.reddit.frontpage.ui.profile;

import android.content.DialogInterface;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class ProfilePagerScreen$$Lambda$3 implements Function1 {
    private final ProfilePagerScreen f34408a;

    ProfilePagerScreen$$Lambda$3(ProfilePagerScreen profilePagerScreen) {
        this.f34408a = profilePagerScreen;
    }

    public final Object mo6492a(Object obj) {
        Screen screen = this.f34408a;
        ((DialogInterface) obj).dismiss();
        Routing.m22623a(screen, Nav.m22588h(screen.username));
        return Unit.f25273a;
    }
}
