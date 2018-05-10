package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/frontpage/ui/listing/LegacyFrontpageScreen$onEmptyInflate$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Lcom/reddit/frontpage/ui/listing/LegacyFrontpageScreen;Landroid/view/View;)V", "onGlobalLayout", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LegacyFrontpageScreen.kt */
public final class LegacyFrontpageScreen$onEmptyInflate$1 implements OnGlobalLayoutListener {
    final /* synthetic */ LegacyFrontpageScreen f21291a;
    final /* synthetic */ View f21292b;

    LegacyFrontpageScreen$onEmptyInflate$1(LegacyFrontpageScreen legacyFrontpageScreen, View view) {
        this.f21291a = legacyFrontpageScreen;
        this.f21292b = view;
    }

    public final void onGlobalLayout() {
        this.f21291a.m42224i(this.f21292b);
        Object a = this.f21291a.K;
        Intrinsics.m26843a(a, "rootView");
        a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
