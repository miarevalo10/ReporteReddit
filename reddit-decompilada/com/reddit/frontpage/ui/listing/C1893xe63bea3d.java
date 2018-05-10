package com.reddit.frontpage.ui.listing;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class C1893xe63bea3d implements OnClickListener {
    final /* synthetic */ LegacySubredditListingScreen f21305a;
    final /* synthetic */ Session f21306b;

    C1893xe63bea3d(LegacySubredditListingScreen legacySubredditListingScreen, Session session) {
        this.f21305a = legacySubredditListingScreen;
        this.f21306b = session;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SubredditUtil.m23927b(this.f21305a.subredditModel, this.f21305a.getAnalyticsScreenName());
        Screen screen = (Screen) this.f21305a;
        Object[] objArr = new Object[1];
        Subreddit subreddit = this.f21305a.subredditModel;
        if (subreddit == null) {
            Intrinsics.m26842a();
        }
        objArr[0] = subreddit.getDisplayNamePrefixed();
        dialogInterface = Screens.m22629a(screen, Util.m23960a((int) C1761R.string.fmt_now_unsubscribed, objArr), -1);
        if (dialogInterface != null) {
            dialogInterface.a();
        }
        this.f21305a.subscribed = false;
        this.f21305a.m42274g(true);
    }
}
