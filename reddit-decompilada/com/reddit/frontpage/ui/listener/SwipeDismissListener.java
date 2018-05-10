package com.reddit.frontpage.ui.listener;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.reddit.frontpage.util.Util;

public abstract class SwipeDismissListener implements OnTouchListener {
    private int f21252a = -1;
    private int f21253b = -1;
    private View[] f21254c;
    private boolean f21255d = true;
    private boolean f21256e = false;

    public abstract void mo4946a();

    public SwipeDismissListener(View... viewArr) {
        this.f21254c = viewArr;
    }

    public boolean onTouch(final View view, MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getPointerCount() > 1) {
            this.f21256e = true;
            return false;
        }
        if (view instanceof SubsamplingScaleImageView) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view;
            if (subsamplingScaleImageView.getScale() != 0.0f) {
                boolean z2;
                ImageViewState state = subsamplingScaleImageView.getState();
                if (state != null) {
                    Point point = new Point();
                    ((Activity) subsamplingScaleImageView.getContext()).getWindowManager().getDefaultDisplay().getSize(point);
                    if (((float) subsamplingScaleImageView.getSHeight()) * state.getScale() > ((float) point.y)) {
                        z2 = true;
                        if (z2) {
                            return false;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    return false;
                }
            }
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f21256e = false;
                this.f21252a = (int) motionEvent.getRawX();
                this.f21253b = (int) motionEvent.getRawY();
                view.setPivotX((float) (view.getWidth() / 2));
                view.setPivotY((float) (view.getHeight() / 2));
                if (Util.m24014d(view.getContext()).getWindowManager().getDefaultDisplay().getRotation() != null) {
                    z = false;
                }
                this.f21255d = z;
                break;
            case 1:
                if (this.f21256e == null) {
                    if (Math.abs(view.getTranslationY()) <= ((float) Math.min(view.getWidth(), view.getHeight())) / 3.0f) {
                        view = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{view.getTranslationY(), 0.0f});
                        view.setDuration(150);
                        view.start();
                        m23381a(m23384b(), 1.0f);
                        break;
                    }
                    motionEvent = view.getResources().getDisplayMetrics().heightPixels;
                    int height = 0 - view.getHeight();
                    if (view.getTranslationY() <= 0.0f) {
                        motionEvent = height;
                    }
                    motionEvent = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{view.getTranslationY(), (float) motionEvent});
                    motionEvent.setDuration(150);
                    motionEvent.start();
                    motionEvent.addListener(new AnimatorListener(this) {
                        final /* synthetic */ SwipeDismissListener f21251b;

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            this.f21251b.mo4946a();
                        }

                        public void onAnimationCancel(Animator animator) {
                            this.f21251b.m23382a(view);
                        }
                    });
                    if (this.f21255d != null) {
                        m23381a(m23384b(), 0.0f);
                        break;
                    }
                }
                break;
            case 2:
                if (!this.f21256e) {
                    view.setTranslationY(motionEvent.getRawY() - ((float) this.f21253b));
                    float rawX = motionEvent.getRawX();
                    motionEvent = motionEvent.getRawY();
                    rawX = Math.abs(rawX - ((float) this.f21252a));
                    motionEvent = Math.abs(motionEvent - ((float) this.f21253b));
                    float max = 1.0f - (Math.max(0.0f, ((float) ((int) Math.sqrt((double) ((rawX * rawX) + (motionEvent * motionEvent))))) / ((float) (Math.max(view.getWidth(), view.getHeight()) / 2))) / 1073741824);
                    if (this.f21255d != null) {
                        m23380a(max);
                        break;
                    }
                }
                break;
            case 3:
            case 4:
                m23382a(view);
                break;
            default:
                break;
        }
        return false;
    }

    private void m23381a(float f, float f2) {
        for (Object ofFloat : this.f21254c) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ofFloat, View.ALPHA, new float[]{f, f2});
            ofFloat2.setDuration(150);
            ofFloat2.start();
        }
    }

    private void m23382a(View view) {
        view.setTranslationY(0.0f);
        view.setTranslationX(0.0f);
        m23380a(1.0f);
    }

    private void m23380a(float f) {
        for (View alpha : this.f21254c) {
            alpha.setAlpha(f);
        }
    }

    private float m23384b() {
        return this.f21254c[0].getAlpha();
    }
}
