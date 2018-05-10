package com.reddit.social.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"com/reddit/social/widgets/WidgetKeyboard$hideCustomKeyboard$1$2", "Landroid/animation/AnimatorListenerAdapter;", "(Lcom/reddit/social/widgets/WidgetKeyboard$hideCustomKeyboard$1;)V", "isAnimationEnding", "", "()Z", "setAnimationEnding", "(Z)V", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: WidgetKeyboard.kt */
public final class WidgetKeyboard$hideCustomKeyboard$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
    final /* synthetic */ WidgetKeyboard f22499a;
    private boolean f22500b;

    WidgetKeyboard$hideCustomKeyboard$$inlined$apply$lambda$2(WidgetKeyboard widgetKeyboard) {
        this.f22499a = widgetKeyboard;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.f22500b == null) {
            this.f22500b = true;
            if (this.f22499a.f22507f != null) {
                animator = this.f22499a.getParent();
                if (animator == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
                }
                ((RelativeLayout) animator).getViewTreeObserver().addOnGlobalLayoutListener(this.f22499a.f22509h);
                WidgetKeyboard.m24785d(this.f22499a);
                ((EditText) ((WidgetKeyboardHeader) this.f22499a.m24794a(C1761R.id.keyboardHeader)).m24800a(C1761R.id.chatMessage)).requestFocus();
                return;
            }
            animator = this.f22499a.getParent();
            if (animator == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
            ((RelativeLayout) animator).post(new Runnable() {
                public final void run() {
                    Object obj = (FrameLayout) this.f22499a.m24794a(C1761R.id.keyboardMediumContainer);
                    Intrinsics.m26843a(obj, "keyboardMediumContainer");
                    obj.getLayoutParams().height = 0;
                    ((FrameLayout) this.f22499a.m24794a(C1761R.id.keyboardMediumContainer)).requestLayout();
                }
            });
        }
    }
}
