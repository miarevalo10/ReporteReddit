package com.reddit.frontpage.presentation.listing.submitted;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$onEmptyInflate$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen;Landroid/view/View;)V", "onGlobalLayout", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
public final class UserSubmittedListingScreen$onEmptyInflate$1 implements OnGlobalLayoutListener {
    final /* synthetic */ UserSubmittedListingScreen f20645a;
    final /* synthetic */ View f20646b;

    UserSubmittedListingScreen$onEmptyInflate$1(UserSubmittedListingScreen userSubmittedListingScreen, View view) {
        this.f20645a = userSubmittedListingScreen;
        this.f20646b = view;
    }

    public final void onGlobalLayout() {
        Object d = this.f20645a.K;
        Intrinsics.m26843a(d, "rootView");
        d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        UserSubmittedListingScreen.m40670O();
    }
}
