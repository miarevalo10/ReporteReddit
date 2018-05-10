package com.reddit.frontpage.presentation.listing.common;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/ViewStub;", "kotlin.jvm.PlatformType", "inflated", "Landroid/view/View;", "onInflate"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkListingScreen.kt */
final class LinkListingScreen$onCreateView$4 implements OnInflateListener {
    final /* synthetic */ LinkListingScreen f20572a;

    LinkListingScreen$onCreateView$4(LinkListingScreen linkListingScreen) {
        this.f20572a = linkListingScreen;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        viewStub = this.f20572a;
        Intrinsics.m26843a((Object) view, "inflated");
        viewStub.mo7640g(view);
    }
}
