package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    public WeakReference<View> f1485a;
    Runnable f1486b = null;
    Runnable f1487c = null;
    int f1488d = -1;

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        ViewPropertyAnimatorCompat f11476a;
        boolean f11477b;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f11476a = viewPropertyAnimatorCompat;
        }

        public final void mo377a(View view) {
            this.f11477b = false;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (this.f11476a.f1488d >= 0) {
                view.setLayerType(2, null);
            }
            if (this.f11476a.f1486b != null) {
                Runnable runnable = this.f11476a.f1486b;
                this.f11476a.f1486b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo377a(view);
            }
        }

        public final void mo378b(View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (this.f11476a.f1488d >= 0) {
                view.setLayerType(this.f11476a.f1488d, null);
                this.f11476a.f1488d = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f11477b) {
                if (this.f11476a.f1487c != null) {
                    Runnable runnable = this.f11476a.f1487c;
                    this.f11476a.f1487c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo378b(view);
                }
                this.f11477b = true;
            }
        }

        public final void mo379c(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo379c(view);
            }
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f1485a = new WeakReference(view);
    }

    public final ViewPropertyAnimatorCompat m1292a(long j) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m1291a(float f) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m1297b(float f) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m1300c(float f) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m1295a(Interpolator interpolator) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m1298b(long j) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public final void m1296a() {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void m1299b() {
        View view = (View) this.f1485a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final ViewPropertyAnimatorCompat m1293a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f1485a.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                m1290a(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                m1290a(view, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    private void m1290a(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ ViewPropertyAnimatorCompat f1481c;

                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.mo379c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.mo378b(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.mo377a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public final ViewPropertyAnimatorCompat m1294a(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = (View) this.f1485a.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                animatorUpdateListener = new AnimatorUpdateListener(this) {
                    final /* synthetic */ ViewPropertyAnimatorCompat f1484c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        viewPropertyAnimatorUpdateListener.mo460a();
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
