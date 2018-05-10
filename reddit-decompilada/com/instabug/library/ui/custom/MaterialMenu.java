package com.instabug.library.ui.custom;

import android.animation.Animator.AnimatorListener;
import android.view.animation.Interpolator;
import com.instabug.library.ui.custom.MaterialMenuDrawable.AnimationState;
import com.instabug.library.ui.custom.MaterialMenuDrawable.IconState;

public interface MaterialMenu {
    void animateIconState(IconState iconState);

    IconState getIconState();

    void setAnimationListener(AnimatorListener animatorListener);

    void setColor(int i);

    void setIconState(IconState iconState);

    void setInterpolator(Interpolator interpolator);

    void setRTLEnabled(boolean z);

    void setTransformationDuration(int i);

    IconState setTransformationOffset(AnimationState animationState, float f);

    void setVisible(boolean z);
}
