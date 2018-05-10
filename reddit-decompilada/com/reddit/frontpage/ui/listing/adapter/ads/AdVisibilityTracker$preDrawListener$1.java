package com.reddit.frontpage.ui.listing.adapter.ads;

import android.view.ViewTreeObserver.OnPreDrawListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onPreDraw"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdVisibilityTracker.kt */
final class AdVisibilityTracker$preDrawListener$1 implements OnPreDrawListener {
    final /* synthetic */ AdVisibilityTracker f21339a;

    AdVisibilityTracker$preDrawListener$1(AdVisibilityTracker adVisibilityTracker) {
        this.f21339a = adVisibilityTracker;
    }

    public final boolean onPreDraw() {
        this.f21339a.m23447c();
        return true;
    }
}
