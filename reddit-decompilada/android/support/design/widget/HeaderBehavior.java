package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    OverScroller f16442a;
    private Runnable f16443b;
    private boolean f16444c;
    private int f16445d = -1;
    private int f16446e;
    private int f16447f = -1;
    private VelocityTracker f16448g;

    private class FlingRunnable implements Runnable {
        final /* synthetic */ HeaderBehavior f599a;
        private final CoordinatorLayout f600b;
        private final V f601c;

        FlingRunnable(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            this.f599a = headerBehavior;
            this.f600b = coordinatorLayout;
            this.f601c = v;
        }

        public void run() {
            if (!(this.f601c == null || this.f599a.f16442a == null)) {
                if (this.f599a.f16442a.computeScrollOffset()) {
                    this.f599a.a_(this.f600b, this.f601c, this.f599a.f16442a.getCurrY());
                    ViewCompat.m1224a(this.f601c, (Runnable) this);
                    return;
                }
                this.f599a.mo3820a(this.f600b, this.f601c);
            }
        }
    }

    void mo3820a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean mo3827b() {
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean mo76a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f16447f < 0) {
            this.f16447f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f16444c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f16444c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (mo3827b() && coordinatorLayout.m16550a((View) v, x, y) != null) {
                    this.f16446e = y;
                    this.f16445d = motionEvent.getPointerId(0);
                    m16554d();
                    break;
                }
            case 1:
            case 3:
                this.f16444c = false;
                this.f16445d = -1;
                if (this.f16448g != null) {
                    this.f16448g.recycle();
                    this.f16448g = null;
                    break;
                }
                break;
            case 2:
                coordinatorLayout = this.f16445d;
                if (coordinatorLayout != -1) {
                    coordinatorLayout = motionEvent.findPointerIndex(coordinatorLayout);
                    if (coordinatorLayout != -1) {
                        coordinatorLayout = (int) motionEvent.getY(coordinatorLayout);
                        if (Math.abs(coordinatorLayout - this.f16446e) > this.f16447f) {
                            this.f16444c = true;
                            this.f16446e = coordinatorLayout;
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
        if (this.f16448g != null) {
            this.f16448g.addMovement(motionEvent);
        }
        return this.f16444c;
    }

    public final boolean mo80b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
        View view = v;
        MotionEvent motionEvent2 = motionEvent;
        if (this.f16447f < 0) {
            r6.f16447f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                y = (int) motionEvent.getY();
                if (coordinatorLayout2.m16550a(view, (int) motionEvent.getX(), y) && mo3827b()) {
                    r6.f16446e = y;
                    r6.f16445d = motionEvent2.getPointerId(0);
                    m16554d();
                    break;
                }
                return false;
                break;
            case 1:
                if (r6.f16448g != null) {
                    r6.f16448g.addMovement(motionEvent2);
                    r6.f16448g.computeCurrentVelocity(1000);
                    float yVelocity = r6.f16448g.getYVelocity(r6.f16445d);
                    int i = -mo3819a(view);
                    if (r6.f16443b != null) {
                        view.removeCallbacks(r6.f16443b);
                        r6.f16443b = null;
                    }
                    if (r6.f16442a == null) {
                        r6.f16442a = new OverScroller(v.getContext());
                    }
                    r6.f16442a.fling(0, mo3828c(), 0, Math.round(yVelocity), 0, 0, i, 0);
                    if (!r6.f16442a.computeScrollOffset()) {
                        mo3820a(coordinatorLayout, v);
                        break;
                    }
                    r6.f16443b = new FlingRunnable(r6, coordinatorLayout2, view);
                    ViewCompat.m1224a(view, r6.f16443b);
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent2.findPointerIndex(r6.f16445d);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent2.getY(findPointerIndex);
                    y = r6.f16446e - findPointerIndex;
                    if (!r6.f16444c && Math.abs(y) > r6.f16447f) {
                        r6.f16444c = true;
                        y = y > 0 ? y - r6.f16447f : y + r6.f16447f;
                    }
                    if (r6.f16444c) {
                        r6.f16446e = findPointerIndex;
                        m16560b(coordinatorLayout2, view, y, mo3826b(view), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
            default:
                break;
        }
        r6.f16444c = false;
        r6.f16445d = -1;
        if (r6.f16448g != null) {
            r6.f16448g.recycle();
            r6.f16448g = null;
        }
        if (r6.f16448g != null) {
            r6.f16448g.addMovement(motionEvent2);
        }
        return true;
    }

    final int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo3818a(coordinatorLayout, v, i, Integer.MIN_VALUE, RedditJobManager.f10810d);
    }

    int mo3818a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        V c = mo3828c();
        if (i2 != 0 && c >= i2 && c <= i3) {
            v = MathUtils.m854a(i, i2, i3);
            if (c != v) {
                mo3824a(v);
                return c - v;
            }
        }
        return null;
    }

    int mo3817a() {
        return mo3828c();
    }

    final int m16560b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo3818a(coordinatorLayout, v, mo3817a() - i, i2, i3);
    }

    int mo3826b(V v) {
        return -v.getHeight();
    }

    int mo3819a(V v) {
        return v.getHeight();
    }

    private void m16554d() {
        if (this.f16448g == null) {
            this.f16448g = VelocityTracker.obtain();
        }
    }
}
