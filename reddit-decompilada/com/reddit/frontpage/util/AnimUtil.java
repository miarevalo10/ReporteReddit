package com.reddit.frontpage.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooIndeterminateAnimation;
import com.reddit.frontpage.presentation.common.ResourcesUtil;

public class AnimUtil {

    private static class NoOpAnimationListener implements AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        private NoOpAnimationListener() {
        }
    }

    public static Animation m23638a(int i, int i2) {
        Animation animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setDuration(150);
        animationSet.setRepeatMode(2);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f, (float) (i / 2), (float) (i2 / 2));
        scaleAnimation.setRepeatCount(1);
        i = new AlphaAnimation(1065353216, 0.5f);
        i.setRepeatCount(1);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(i);
        return animationSet;
    }

    public static Drawable m23637a(Context context) {
        SnooIndeterminateAnimation snooIndeterminateAnimation = new SnooIndeterminateAnimation();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ResourcesUtil.m22740i(context, C1761R.attr.rdt_loader_background_color));
        return new LayerDrawable(new Drawable[]{gradientDrawable, snooIndeterminateAnimation});
    }

    public static void m23639a(View view, final Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setAnimationListener(new NoOpAnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
                runnable.run();
            }
        });
        view.startAnimation(alphaAnimation);
    }
}
