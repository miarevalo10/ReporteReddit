package com.reddit.frontpage.widgets;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SlideDownAnimation;
import com.reddit.frontpage.animation.SlideUpAnimation;

public class RedditSnackbar {

    public static class Builder {
        public String f21934a = "";
        private final Activity f21935b;
        private int f21936c = C1761R.layout.widget_snackbar;
        private int f21937d = C1761R.id.text;
        private int f21938e = -1;

        public Builder(Activity activity) {
            this.f21935b = activity;
        }

        public final void m24188a() {
            final View frameLayout = new FrameLayout(this.f21935b);
            Resources resources = this.f21935b.getResources();
            final int applyDimension = (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, applyDimension);
            layoutParams.gravity = 80;
            frameLayout.setLayoutParams(layoutParams);
            int i = this.f21938e;
            if (i < 0) {
                i = resources.getColor(C1761R.color.rdt_alien_blue);
            }
            frameLayout.setBackgroundColor(i);
            View inflate = this.f21935b.getLayoutInflater().inflate(this.f21936c, frameLayout, false);
            ((TextView) inflate.findViewById(this.f21937d)).setText(this.f21934a);
            frameLayout.addView(inflate);
            ViewGroup viewGroup = (ViewGroup) this.f21935b.findViewById(16908290);
            viewGroup.addView(frameLayout);
            frameLayout.bringToFront();
            frameLayout.setTranslationY((float) applyDimension);
            viewGroup.invalidate();
            SlideUpAnimation slideUpAnimation = new SlideUpAnimation(frameLayout);
            slideUpAnimation.f19914a = ObjectAnimator.ofFloat(slideUpAnimation.f19915b, "translationY", new float[]{slideUpAnimation.f19915b.getTranslationY(), slideUpAnimation.f19915b.getTranslationY() - r4}).setDuration((long) slideUpAnimation.f19916c);
            slideUpAnimation.f19914a.start();
            frameLayout.postDelayed(new Runnable(this) {
                final /* synthetic */ Builder f21933c;

                public void run() {
                    SlideDownAnimation slideDownAnimation = new SlideDownAnimation(frameLayout);
                    int i = applyDimension;
                    slideDownAnimation.f19911a = ObjectAnimator.ofFloat(slideDownAnimation.f19912b, "translationY", new float[]{slideDownAnimation.f19912b.getTranslationY(), slideDownAnimation.f19912b.getTranslationY() + ((float) i)}).setDuration((long) slideDownAnimation.f19913c);
                    slideDownAnimation.f19911a.start();
                }
            }, 500);
        }
    }

    public static Builder m24189a(Activity activity) {
        return new Builder(activity);
    }
}
