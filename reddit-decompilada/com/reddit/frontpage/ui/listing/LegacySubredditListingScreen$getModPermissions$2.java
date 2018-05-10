package com.reddit.frontpage.ui.listing;

import android.view.View;
import com.reddit.datalibrary.frontpage.data.model.ModPermissions;
import com.reddit.datalibrary.frontpage.data.model.Moderator;
import com.reddit.datalibrary.frontpage.data.model.ModeratorsResponse;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "moderatorsResponse", "Lcom/reddit/datalibrary/frontpage/data/model/ModeratorsResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class LegacySubredditListingScreen$getModPermissions$2 extends Lambda implements Function1<ModeratorsResponse, Unit> {
    final /* synthetic */ LegacySubredditListingScreen f37282a;

    LegacySubredditListingScreen$getModPermissions$2(LegacySubredditListingScreen legacySubredditListingScreen) {
        this.f37282a = legacySubredditListingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ModeratorsResponse moderatorsResponse = (ModeratorsResponse) obj;
        if (moderatorsResponse.getModerators().size() == 1) {
            this.f37282a.f40619R = ((Moderator) CollectionsKt___CollectionsKt.m41430d((List) moderatorsResponse.getModerators())).getModPermissions();
            if (!(this.f37282a.subredditModel == null || this.f37282a.f40619R == null)) {
                obj = this.f37282a.subredditModel;
                if (obj == null) {
                    Intrinsics.m26842a();
                }
                ListingFilterBarView listingFilterBarView = this.f37282a.f40617O;
                if (listingFilterBarView == null) {
                    Intrinsics.m26842a();
                }
                View modModeButton = listingFilterBarView.getModModeButton();
                ModPermissions e = this.f37282a.f40619R;
                if (e == null) {
                    Intrinsics.m26842a();
                }
                ModUtil.m23827a(obj, modModeButton, e, new Runnable() {
                    public final void run() {
                        this.f37282a.an();
                    }
                });
            }
        }
        return Unit.f25273a;
    }
}
