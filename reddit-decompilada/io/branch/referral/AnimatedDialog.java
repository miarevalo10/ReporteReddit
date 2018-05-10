package io.branch.referral;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class AnimatedDialog extends Dialog {
    private boolean f24472a;
    private final boolean f24473b;

    class C21032 implements AnimationListener {
        final /* synthetic */ AnimatedDialog f24471a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C21032(AnimatedDialog animatedDialog) {
            this.f24471a = animatedDialog;
        }

        public void onAnimationEnd(Animation animation) {
            this.f24471a.dismiss();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f24473b != null) {
            bundle = getWindow().getAttributes();
            bundle.width = -1;
            getWindow().setAttributes(bundle);
        }
    }

    public void show() {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        ((ViewGroup) getWindow().getDecorView()).getChildAt(0).startAnimation(translateAnimation);
        super.show();
    }

    public void cancel() {
        if (!this.f24472a) {
            this.f24472a = true;
            Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(500);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            ((ViewGroup) getWindow().getDecorView()).getChildAt(0).startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new C21032(this));
        }
    }

    public void setContentView(int i) {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().addFlags(2);
        getWindow().addFlags(1024);
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 80;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);
        getWindow().setWindowAnimations(17432578);
        setCanceledOnTouchOutside(true);
        super.setContentView(i);
    }
}
