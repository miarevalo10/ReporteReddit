package com.reddit.frontpage.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.changehandler.AnimatorChangeHandler;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/animation/VerticalFadeChangeHandler;", "Lcom/bluelinelabs/conductor/changehandler/AnimatorChangeHandler;", "()V", "offsetY", "", "copy", "Lcom/bluelinelabs/conductor/ControllerChangeHandler;", "getAnimator", "Landroid/animation/Animator;", "container", "Landroid/view/ViewGroup;", "from", "Landroid/view/View;", "to", "isPush", "", "toAddedToContainer", "resetFromView", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: VerticalFadeChangeHandler.kt */
public final class VerticalFadeChangeHandler extends AnimatorChangeHandler {
    public static final Companion f33482d = new Companion();
    private static final LinearOutSlowInInterpolator f33483f = new LinearOutSlowInInterpolator();
    private static final FastOutLinearInInterpolator f33484g = new FastOutLinearInInterpolator();
    private final float f33485e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/animation/VerticalFadeChangeHandler$Companion;", "", "()V", "PROPERTY_ALPHA", "", "PROPERTY_TRANSLATION_Y", "popInterpolator", "Landroid/support/v4/view/animation/FastOutLinearInInterpolator;", "getPopInterpolator", "()Landroid/support/v4/view/animation/FastOutLinearInInterpolator;", "pushInterpolator", "Landroid/support/v4/view/animation/LinearOutSlowInInterpolator;", "getPushInterpolator", "()Landroid/support/v4/view/animation/LinearOutSlowInInterpolator;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: VerticalFadeChangeHandler.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public VerticalFadeChangeHandler() {
        Object obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        this.f33485e = obj.getResources().getDimension(C1761R.dimen.screen_transition_offset_y);
    }

    protected final Animator m34360a(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        Intrinsics.m26847b(viewGroup, "container");
        if (z) {
            if (view2 == null) {
                Intrinsics.m26842a();
            }
            view = view2;
        } else if (view == null) {
            Intrinsics.m26842a();
        }
        viewGroup = null;
        view2 = z ? this.f33485e : null;
        if (z) {
            z2 = false;
        } else {
            z2 = this.f33485e;
        }
        float f = z ? null : 1.0f;
        if (z) {
            viewGroup = 1065353216;
        }
        r2 = new PropertyValuesHolder[2];
        r2[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{f, viewGroup});
        r2[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{view2, z2});
        Object ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, r2);
        ofPropertyValuesHolder.setInterpolator((TimeInterpolator) (z ? f33483f : f33484g));
        Intrinsics.m26843a(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…lse popInterpolator\n    }");
        return (Animator) ofPropertyValuesHolder;
    }

    protected final void m34361a(View view) {
        Intrinsics.m26847b(view, "from");
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }

    public final ControllerChangeHandler m34362b() {
        return new VerticalFadeChangeHandler();
    }
}
