package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class LegacySubredditListingScreen$bindSubreddit$1 implements OnClickListener {
    final /* synthetic */ LegacySubredditListingScreen f21302a;

    LegacySubredditListingScreen$bindSubreddit$1(LegacySubredditListingScreen legacySubredditListingScreen) {
        this.f21302a = legacySubredditListingScreen;
    }

    public final void onClick(View view) {
        this.f21302a.m42272f(this.f21302a.subscribed ^ 1);
    }
}
