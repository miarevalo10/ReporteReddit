package com.bluelinelabs.conductor.changehandler;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeCompletedListener;

public abstract class AnimatorChangeHandler extends ControllerChangeHandler {
    long f12250b;
    boolean f12251c;
    private boolean f12252d;
    private boolean f12253e;
    private boolean f12254f;
    private Animator f12255g;
    private OnAnimationReadyOrAbortedListener f12256h;

    private class OnAnimationReadyOrAbortedListener implements OnPreDrawListener {
        final ViewGroup f3155a;
        final View f3156b;
        final View f3157c;
        final boolean f3158d;
        final boolean f3159e = true;
        final ControllerChangeCompletedListener f3160f;
        final /* synthetic */ AnimatorChangeHandler f3161g;
        private boolean f3162h;

        OnAnimationReadyOrAbortedListener(AnimatorChangeHandler animatorChangeHandler, ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener) {
            this.f3161g = animatorChangeHandler;
            this.f3155a = viewGroup;
            this.f3156b = view;
            this.f3157c = view2;
            this.f3158d = z;
            this.f3160f = controllerChangeCompletedListener;
        }

        public boolean onPreDraw() {
            m2752a();
            return true;
        }

        final void m2752a() {
            if (!this.f3162h) {
                this.f3162h = true;
                if (this.f3157c != null) {
                    ViewTreeObserver viewTreeObserver = this.f3157c.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this);
                    }
                }
                this.f3161g.m11155a(this.f3155a, this.f3156b, this.f3157c, this.f3158d, this.f3159e, this.f3160f);
            }
        }
    }

    public abstract Animator mo3257a(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2);

    public abstract void mo3258a(View view);

    public AnimatorChangeHandler() {
        this(-1, true);
    }

    public AnimatorChangeHandler(long j, boolean z) {
        this.f12250b = j;
        this.f12251c = z;
    }

    public final void mo861a(Bundle bundle) {
        super.mo861a(bundle);
        bundle.putLong("AnimatorChangeHandler.duration", this.f12250b);
        bundle.putBoolean("AnimatorChangeHandler.removesFromViewOnPush", this.f12251c);
    }

    public final void mo864b(Bundle bundle) {
        super.mo864b(bundle);
        this.f12250b = bundle.getLong("AnimatorChangeHandler.duration");
        this.f12251c = bundle.getBoolean("AnimatorChangeHandler.removesFromViewOnPush");
    }

    public final void mo863a(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.mo863a(controllerChangeHandler, controller);
        this.f12252d = true;
        if (this.f12255g != null) {
            this.f12255g.cancel();
            return;
        }
        if (this.f12256h != null) {
            this.f12256h.m2752a();
        }
    }

    public final void mo860a() {
        super.mo860a();
        this.f12253e = true;
        if (this.f12255g != null) {
            this.f12255g.end();
            return;
        }
        if (this.f12256h != null) {
            this.f12256h.m2752a();
        }
    }

    public final boolean mo865e() {
        return this.f12251c;
    }

    public final void mo862a(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener) {
        AnimatorChangeHandler animatorChangeHandler = this;
        ViewGroup viewGroup2 = viewGroup;
        View view3 = view2;
        Object obj = null;
        boolean z2 = view3 != null && view2.getParent() == null;
        if (z2) {
            if (!z) {
                if (view != null) {
                    if (view2.getParent() == null) {
                        viewGroup2.addView(view3, viewGroup2.indexOfChild(view));
                    }
                    if (view2.getWidth() <= 0 && view2.getHeight() <= 0) {
                        animatorChangeHandler.f12256h = new OnAnimationReadyOrAbortedListener(animatorChangeHandler, viewGroup2, view, view3, z, controllerChangeCompletedListener);
                        view2.getViewTreeObserver().addOnPreDrawListener(animatorChangeHandler.f12256h);
                        if (obj == null) {
                            m11155a(viewGroup2, view, view3, z, z2, controllerChangeCompletedListener);
                        }
                    }
                }
            }
            viewGroup2.addView(view3);
            animatorChangeHandler.f12256h = new OnAnimationReadyOrAbortedListener(animatorChangeHandler, viewGroup2, view, view3, z, controllerChangeCompletedListener);
            view2.getViewTreeObserver().addOnPreDrawListener(animatorChangeHandler.f12256h);
            if (obj == null) {
                m11155a(viewGroup2, view, view3, z, z2, controllerChangeCompletedListener);
            }
        }
        obj = 1;
        if (obj == null) {
            m11155a(viewGroup2, view, view3, z, z2, controllerChangeCompletedListener);
        }
    }

    private void m11156a(ControllerChangeCompletedListener controllerChangeCompletedListener, AnimatorListener animatorListener) {
        if (!this.f12254f) {
            this.f12254f = true;
            controllerChangeCompletedListener.mo853a();
        }
        if (this.f12255g != null) {
            if (animatorListener != null) {
                this.f12255g.removeListener(animatorListener);
            }
            this.f12255g.cancel();
            this.f12255g = null;
        }
        this.f12256h = null;
    }

    private void m11155a(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2, ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (this.f12252d) {
            m11156a(controllerChangeCompletedListener, null);
        } else if (this.f12253e) {
            if (!(view == null || (z && this.f12251c == null))) {
                viewGroup.removeView(view);
            }
            m11156a(controllerChangeCompletedListener, null);
            if (z && view != null) {
                mo3258a(view);
            }
        } else {
            this.f12255g = mo3257a(viewGroup, view, view2, z, z2);
            if (this.f12250b > 0) {
                this.f12255g.setDuration(this.f12250b);
            }
            final View view3 = view;
            final boolean z3 = z;
            final ViewGroup viewGroup2 = viewGroup;
            final ControllerChangeCompletedListener controllerChangeCompletedListener2 = controllerChangeCompletedListener;
            this.f12255g.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ AnimatorChangeHandler f3154e;

                public void onAnimationCancel(Animator animator) {
                    if (view3 != null && ((z3 == null || this.f3154e.f12251c != null) && this.f3154e.f12253e != null)) {
                        viewGroup2.removeView(view3);
                    }
                    this.f3154e.m11156a(controllerChangeCompletedListener2, (AnimatorListener) this);
                }

                public void onAnimationEnd(Animator animator) {
                    if (this.f3154e.f12252d == null && this.f3154e.f12255g != null) {
                        if (view3 != null && (z3 == null || this.f3154e.f12251c != null)) {
                            viewGroup2.removeView(view3);
                        }
                        this.f3154e.m11156a(controllerChangeCompletedListener2, (AnimatorListener) this);
                        if (z3 != null && view3 != null) {
                            this.f3154e.mo3258a(view3);
                        }
                    }
                }
            });
            this.f12255g.start();
        }
    }
}
