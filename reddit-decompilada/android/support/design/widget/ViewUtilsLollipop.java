package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.design.C0016R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

@RequiresApi(21)
class ViewUtilsLollipop {
    private static final int[] f726a = new int[]{16843848};

    static void m358a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void m360a(View view, AttributeSet attributeSet, int i) {
        Context context = view.getContext();
        attributeSet = context.obtainStyledAttributes(attributeSet, f726a, 0, i);
        try {
            if (attributeSet.hasValue(0) != 0) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, attributeSet.getResourceId(0, 0)));
            }
            attributeSet.recycle();
        } catch (Throwable th) {
            attributeSet.recycle();
        }
    }

    static void m359a(View view, float f) {
        int integer = view.getResources().getInteger(C0016R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = (long) integer;
        stateListAnimator.addState(new int[]{16842766, C0016R.attr.state_collapsible, -C0016R.attr.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f}).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }
}
