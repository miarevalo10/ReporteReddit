package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ListingViewActions.kt */
final class RedditListingViewActions$notifyLoadError$1 extends Lambda implements Function1<LinkListingScreen, Unit> {
    final /* synthetic */ String f36573a;

    RedditListingViewActions$notifyLoadError$1(String str) {
        this.f36573a = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        LinkListingScreen linkListingScreen = (LinkListingScreen) obj;
        Intrinsics.m26847b(linkListingScreen, "$receiver");
        ViewsKt.m24105b(linkListingScreen.aj());
        ViewsKt.m24107c(linkListingScreen.ak());
        ViewsKt.m24109d(linkListingScreen.al());
        obj = linkListingScreen.f40037F;
        if (obj == null) {
            Intrinsics.m26844a("errorMessageView");
        }
        obj.setText(this.f36573a);
        return Unit.f25273a;
    }
}
