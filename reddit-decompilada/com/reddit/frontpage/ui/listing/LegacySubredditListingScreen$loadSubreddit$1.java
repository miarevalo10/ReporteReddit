package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.util.NetworkUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class LegacySubredditListingScreen$loadSubreddit$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ LegacySubredditListingScreen f37283a;

    LegacySubredditListingScreen$loadSubreddit$1(LegacySubredditListingScreen legacySubredditListingScreen) {
        this.f37283a = legacySubredditListingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Throwable) obj, "it");
        if (NetworkUtil.m23842b() != null) {
            LegacySubredditListingScreen.m42258a(this.f37283a);
        } else {
            Screens.m22628a((Screen) this.f37283a, (int) C1761R.string.error_network_error).a();
        }
        return Unit.f25273a;
    }
}
