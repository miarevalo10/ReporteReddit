package com.reddit.frontpage.ui.listing;

import android.view.View;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class LegacySubredditListingScreen$bindSubreddit$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ LegacySubredditListingScreen f37271a;

    LegacySubredditListingScreen$bindSubreddit$2(LegacySubredditListingScreen legacySubredditListingScreen) {
        this.f37271a = legacySubredditListingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37271a.aE();
        if (obj == null || obj.getMaxLines() != 2147483647) {
            obj = this.f37271a.aE();
            if (obj != null && TextViewsKt.m24098a(obj) == 1) {
                obj = this.f37271a.aE();
                if (obj != null) {
                    obj.setMaxLines(RedditJobManager.f10810d);
                }
            }
        } else {
            obj = this.f37271a.aE();
            if (obj != null) {
                obj.setMaxLines(3);
            }
        }
        return Unit.f25273a;
    }
}
