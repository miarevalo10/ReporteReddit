package com.reddit.frontpage.animation;

import android.view.View;

public class ScaleInOutAnimationCoordinator extends AnimationTargetCoordinator {
    private final ScaleInAnimationRunner f27423a = new ScaleInAnimationRunner(this.f27425c);
    private final ScaleOutAnimationRunner f27424b = new ScaleOutAnimationRunner(this.f27425c);
    private final View f27425c;

    public ScaleInOutAnimationCoordinator(View view) {
        this.f27425c = view;
        m21786a((MultiListenerAnimationRunner) this.f27423a);
        m21786a((MultiListenerAnimationRunner) this.f27424b);
    }

    public final void m28891a() {
        if (this.f27425c.getVisibility() != 0) {
            m21787b(this.f27423a);
        }
    }

    public final void m28892b() {
        if (this.f27425c.getVisibility() == 0) {
            m21787b(this.f27424b);
        }
    }
}
