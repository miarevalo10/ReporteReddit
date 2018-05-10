package com.reddit.frontpage.widgets;

import android.support.percent.PercentFrameLayout;
import android.view.ViewGroup.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RefreshPill.kt */
final class RefreshPill$listener$1$INITIAL_DISTANCE_TO_TRAVEL$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ RefreshPill$listener$1 f37428a;

    RefreshPill$listener$1$INITIAL_DISTANCE_TO_TRAVEL$2(RefreshPill$listener$1 refreshPill$listener$1) {
        this.f37428a = refreshPill$listener$1;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        LayoutParams layoutParams = this.f37428a.f29480d.getLayoutParams();
        if (layoutParams != null) {
            return Float.valueOf((float) (((PercentFrameLayout.LayoutParams) layoutParams).topMargin + this.f37428a.f29480d.getMeasuredHeight()));
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.percent.PercentFrameLayout.LayoutParams");
    }
}
