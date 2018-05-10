package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"com/reddit/frontpage/presentation/listing/common/LinkListingScreen$changedListener$1", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate$ItemChangedListener;", "(Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;)V", "notifyItemOfScreenChange", "", "position", "", "onScreen", "", "notifyItemsOfScreenChange", "start", "end", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkListingScreen.kt */
public final class LinkListingScreen$changedListener$1 implements ItemChangedListener {
    final /* synthetic */ LinkListingScreen f28266a;

    LinkListingScreen$changedListener$1(LinkListingScreen linkListingScreen) {
        this.f28266a = linkListingScreen;
    }

    public final void mo4827a(int i, int i2) {
        this.f28266a.mo7641w().m23491a(i, i2, true);
    }

    public final void mo4826a(int i) {
        this.f28266a.mo7641w().m23492a(i, true);
    }
}
