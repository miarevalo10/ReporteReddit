package com.reddit.frontpage.ui.profile;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.analytics.ChatAnalytics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import timber.log.Timber;

final /* synthetic */ class ProfilePagerScreen$$Lambda$2 implements Function1 {
    private final ProfilePagerScreen f34407a;

    ProfilePagerScreen$$Lambda$2(ProfilePagerScreen profilePagerScreen) {
        this.f34407a = profilePagerScreen;
    }

    public final Object mo6492a(Object obj) {
        Screen screen = this.f34407a;
        ((DialogInterface) obj).dismiss();
        obj = new ChatAnalytics();
        ChatAnalytics.m24468b();
        obj = SessionUtil.m23898d();
        if (obj != null) {
            if (!TextUtils.isEmpty(screen.userId)) {
                Routing.m22623a(screen, Nav.m22598k(screen.userId, screen.username));
                return Unit.f25273a;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Error invoking one on one messaging. Account is null:");
        stringBuilder.append(obj == null ? true : null);
        stringBuilder.append(". UserId is empty: ");
        stringBuilder.append(TextUtils.isEmpty(screen.userId));
        Timber.e(stringBuilder.toString(), new Object[0]);
        return Unit.f25273a;
    }
}
