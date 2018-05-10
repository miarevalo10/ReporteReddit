package com.bluelinelabs.conductor.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ControllerChangeHandler;

public class FadeChangeHandler extends AnimatorChangeHandler {
    private FadeChangeHandler(long j, boolean z) {
        super(j, z);
    }

    protected Animator mo3257a(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        viewGroup = new AnimatorSet();
        if (view2 != null) {
            if (z2) {
                z2 = false;
            } else {
                z2 = view2.getAlpha();
            }
            viewGroup.play(ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{z2, true}));
        }
        if (!(view == null || (z && this.f12251c == null))) {
            viewGroup.play(ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{null}));
        }
        return viewGroup;
    }

    protected final void mo3258a(View view) {
        view.setAlpha(1.0f);
    }

    public ControllerChangeHandler mo866b() {
        return new FadeChangeHandler(this.f12250b, this.f12251c);
    }
}
