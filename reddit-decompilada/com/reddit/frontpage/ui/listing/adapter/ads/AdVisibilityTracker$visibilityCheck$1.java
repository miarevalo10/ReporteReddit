package com.reddit.frontpage.ui.listing.adapter.ads;

import android.view.View;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker.TrackingInfo;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker.VisiblityListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdVisibilityTracker.kt */
final class AdVisibilityTracker$visibilityCheck$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AdVisibilityTracker f37292a;

    AdVisibilityTracker$visibilityCheck$1(AdVisibilityTracker adVisibilityTracker) {
        this.f37292a = adVisibilityTracker;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f37292a.f21344e = false;
        Object keySet = this.f37292a.f21341b.keySet();
        Intrinsics.m26843a(keySet, "trackedViews.keys");
        for (View view : (Iterable) keySet) {
            TrackingInfo trackingInfo = (TrackingInfo) this.f37292a.f21341b.get(view);
            float a = AdVisibilityTracker.m23444a(this.f37292a, view);
            if ((trackingInfo == null || a != trackingInfo.f21337b) && trackingInfo != null) {
                VisiblityListener visiblityListener = trackingInfo.f21336a;
                if (visiblityListener != null) {
                    visiblityListener.mo4955a(a);
                }
            }
            if (trackingInfo != null) {
                trackingInfo.f21337b = a;
            }
        }
        return Unit.f25273a;
    }
}
