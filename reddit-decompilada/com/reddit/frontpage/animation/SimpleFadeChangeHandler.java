package com.reddit.frontpage.animation;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.reddit.frontpage.debug.TracingAnimatorListener;

public class SimpleFadeChangeHandler extends FadeChangeHandler {
    protected final Animator m36704a(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        viewGroup = super.a(viewGroup, view, view2, z, z2);
        viewGroup.addListener(new TracingAnimatorListener(this, "SimpleScreenFade") {
            final /* synthetic */ SimpleFadeChangeHandler f27426a;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        return viewGroup;
    }

    public final ControllerChangeHandler m36705b() {
        return new SimpleFadeChangeHandler();
    }
}
