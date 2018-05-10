package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class LegacySubredditListingScreen$loadSubreddit$2 extends Lambda implements Function1<Subreddit, Unit> {
    final /* synthetic */ LegacySubredditListingScreen f37284a;

    LegacySubredditListingScreen$loadSubreddit$2(LegacySubredditListingScreen legacySubredditListingScreen) {
        this.f37284a = legacySubredditListingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        LegacySubredditListingScreen.m42261a(this.f37284a, subreddit.getDisplayName());
        this.f37284a.mo7733b(subreddit);
        if (this.f37284a.f40620S != null) {
            this.f37284a.E_();
            this.f37284a.f40620S = false;
        }
        return Unit.f25273a;
    }
}
