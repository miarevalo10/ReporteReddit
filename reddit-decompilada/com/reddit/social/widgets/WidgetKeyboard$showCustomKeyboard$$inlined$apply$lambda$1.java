package com.reddit.social.widgets;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 1, 9})
/* compiled from: WidgetKeyboard.kt */
final class WidgetKeyboard$showCustomKeyboard$$inlined$apply$lambda$1 implements AnimatorUpdateListener {
    final /* synthetic */ WidgetKeyboard f22501a;

    WidgetKeyboard$showCustomKeyboard$$inlined$apply$lambda$1(WidgetKeyboard widgetKeyboard) {
        this.f22501a = widgetKeyboard;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.f22501a.m24786e()) {
            Object obj = (FrameLayout) this.f22501a.m24794a(C1761R.id.keyboardMediumContainer);
            Intrinsics.m26843a(obj, "keyboardMediumContainer");
            if (obj.getVisibility() == 8) {
                obj = (FrameLayout) this.f22501a.m24794a(C1761R.id.keyboardMediumContainer);
                Intrinsics.m26843a(obj, "keyboardMediumContainer");
                obj.setVisibility(0);
            }
            Intrinsics.m26843a((Object) valueAnimator, "valueAnimator");
            valueAnimator = valueAnimator.getAnimatedValue();
            if (valueAnimator == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            valueAnimator = ((Integer) valueAnimator).intValue();
            obj = (FrameLayout) this.f22501a.m24794a(C1761R.id.keyboardMediumContainer);
            Intrinsics.m26843a(obj, "keyboardMediumContainer");
            obj.getLayoutParams().height = valueAnimator;
            ((FrameLayout) this.f22501a.m24794a(C1761R.id.keyboardMediumContainer)).requestLayout();
            valueAnimator = this.f22501a;
            obj = (FrameLayout) this.f22501a.m24794a(C1761R.id.keyboardMediumContainer);
            Intrinsics.m26843a(obj, "keyboardMediumContainer");
            valueAnimator.m24779a((ViewGroup) obj);
        }
    }
}
