package com.reddit.frontpage.presentation.listing;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/frontpage/presentation/listing/FrontpageListingScreen$onEmptyInflated$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen;Landroid/view/View;)V", "onGlobalLayout", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
public final class FrontpageListingScreen$onEmptyInflated$1 implements OnGlobalLayoutListener {
    final /* synthetic */ FrontpageListingScreen f20562a;
    final /* synthetic */ View f20563b;

    FrontpageListingScreen$onEmptyInflated$1(FrontpageListingScreen frontpageListingScreen, View view) {
        this.f20562a = frontpageListingScreen;
        this.f20563b = view;
    }

    public final void onGlobalLayout() {
        Object b = this.f20562a.K;
        Intrinsics.m26843a(b, "rootView");
        b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f20562a.m41969h(this.f20563b);
    }
}
