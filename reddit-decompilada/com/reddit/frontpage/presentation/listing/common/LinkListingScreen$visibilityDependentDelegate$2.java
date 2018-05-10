package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkListingScreen.kt */
final class LinkListingScreen$visibilityDependentDelegate$2 extends Lambda implements Function0<VisibilityDependentDelegate> {
    final /* synthetic */ LinkListingScreen f36536a;

    LinkListingScreen$visibilityDependentDelegate$2(LinkListingScreen linkListingScreen) {
        this.f36536a = linkListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new VisibilityDependentDelegate(this.f36536a.af());
    }
}
