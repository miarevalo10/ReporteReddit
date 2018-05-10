package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior<V extends View> extends Behavior<V> {
    private boolean f11119a;
    ViewDragHelper f11120b;
    OnDismissListener f11121c;
    int f11122d = 2;
    float f11123e = 0.5f;
    float f11124f = 0.0f;
    float f11125g = 0.5f;
    private float f11126h = 0.0f;
    private boolean f11127i;
    private final Callback f11128j = new C09871(this);

    public interface OnDismissListener {
        void mo62a(int i);

        void mo63a(View view);
    }

    private class SettleRunnable implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f620a;
        private final View f621b;
        private final boolean f622c;

        SettleRunnable(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f620a = swipeDismissBehavior;
            this.f621b = view;
            this.f622c = z;
        }

        public void run() {
            if (this.f620a.f11120b == null || !this.f620a.f11120b.m1469b()) {
                if (this.f622c && this.f620a.f11121c != null) {
                    this.f620a.f11121c.mo63a(this.f621b);
                }
                return;
            }
            ViewCompat.m1224a(this.f621b, (Runnable) this);
        }
    }

    class C09871 extends Callback {
        final /* synthetic */ SwipeDismissBehavior f11116a;
        private int f11117b;
        private int f11118c = -1;

        C09871(SwipeDismissBehavior swipeDismissBehavior) {
            this.f11116a = swipeDismissBehavior;
        }

        public final boolean mo69a(View view, int i) {
            return (this.f11118c != -1 || this.f11116a.mo3076a(view) == null) ? null : true;
        }

        public final void mo116e(View view, int i) {
            this.f11118c = i;
            this.f11117b = view.getLeft();
            view = view.getParent();
            if (view != null) {
                view.requestDisallowInterceptTouchEvent(1);
            }
        }

        public final void mo67a(int i) {
            if (this.f11116a.f11121c != null) {
                this.f11116a.f11121c.mo62a(i);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo68a(android.view.View r8, float r9, float r10) {
            /*
            r7 = this;
            r10 = -1;
            r7.f11118c = r10;
            r10 = r8.getWidth();
            r0 = 0;
            r1 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            r2 = 0;
            r3 = 1;
            if (r1 == 0) goto L_0x003f;
        L_0x000e:
            r4 = android.support.v4.view.ViewCompat.m1242f(r8);
            if (r4 != r3) goto L_0x0016;
        L_0x0014:
            r4 = r3;
            goto L_0x0017;
        L_0x0016:
            r4 = r2;
        L_0x0017:
            r5 = r7.f11116a;
            r5 = r5.f11122d;
            r6 = 2;
            if (r5 != r6) goto L_0x001f;
        L_0x001e:
            goto L_0x005a;
        L_0x001f:
            r5 = r7.f11116a;
            r5 = r5.f11122d;
            if (r5 != 0) goto L_0x002f;
        L_0x0025:
            if (r4 == 0) goto L_0x002c;
        L_0x0027:
            r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r9 >= 0) goto L_0x005c;
        L_0x002b:
            goto L_0x005a;
        L_0x002c:
            if (r1 <= 0) goto L_0x005c;
        L_0x002e:
            goto L_0x005a;
        L_0x002f:
            r5 = r7.f11116a;
            r5 = r5.f11122d;
            if (r5 != r3) goto L_0x005c;
        L_0x0035:
            if (r4 == 0) goto L_0x003a;
        L_0x0037:
            if (r1 <= 0) goto L_0x005c;
        L_0x0039:
            goto L_0x005a;
        L_0x003a:
            r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r9 >= 0) goto L_0x005c;
        L_0x003e:
            goto L_0x005a;
        L_0x003f:
            r9 = r8.getLeft();
            r0 = r7.f11117b;
            r9 = r9 - r0;
            r0 = r8.getWidth();
            r0 = (float) r0;
            r1 = r7.f11116a;
            r1 = r1.f11123e;
            r0 = r0 * r1;
            r0 = java.lang.Math.round(r0);
            r9 = java.lang.Math.abs(r9);
            if (r9 < r0) goto L_0x005c;
        L_0x005a:
            r9 = r3;
            goto L_0x005d;
        L_0x005c:
            r9 = r2;
        L_0x005d:
            if (r9 == 0) goto L_0x0070;
        L_0x005f:
            r9 = r8.getLeft();
            r0 = r7.f11117b;
            if (r9 >= r0) goto L_0x006b;
        L_0x0067:
            r9 = r7.f11117b;
            r9 = r9 - r10;
            goto L_0x006e;
        L_0x006b:
            r9 = r7.f11117b;
            r9 = r9 + r10;
        L_0x006e:
            r2 = r3;
            goto L_0x0072;
        L_0x0070:
            r9 = r7.f11117b;
        L_0x0072:
            r10 = r7.f11116a;
            r10 = r10.f11120b;
            r0 = r8.getTop();
            r9 = r10.m1463a(r9, r0);
            if (r9 == 0) goto L_0x008b;
        L_0x0080:
            r9 = new android.support.design.widget.SwipeDismissBehavior$SettleRunnable;
            r10 = r7.f11116a;
            r9.<init>(r10, r8, r2);
            android.support.v4.view.ViewCompat.m1224a(r8, r9);
            return;
        L_0x008b:
            if (r2 == 0) goto L_0x009a;
        L_0x008d:
            r9 = r7.f11116a;
            r9 = r9.f11121c;
            if (r9 == 0) goto L_0x009a;
        L_0x0093:
            r9 = r7.f11116a;
            r9 = r9.f11121c;
            r9.mo63a(r8);
        L_0x009a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.SwipeDismissBehavior.1.a(android.view.View, float, float):void");
        }

        public final int mo115a(View view) {
            return view.getWidth();
        }

        public final int mo72d(View view, int i) {
            int width;
            int i2;
            Object obj = ViewCompat.m1242f(view) == 1 ? 1 : null;
            if (this.f11116a.f11122d == 0) {
                if (obj != null) {
                    width = this.f11117b - view.getWidth();
                    i2 = this.f11117b;
                } else {
                    width = this.f11117b;
                    i2 = view.getWidth() + this.f11117b;
                }
            } else if (this.f11116a.f11122d != 1) {
                width = this.f11117b - view.getWidth();
                i2 = view.getWidth() + this.f11117b;
            } else if (obj != null) {
                width = this.f11117b;
                i2 = view.getWidth() + this.f11117b;
            } else {
                width = this.f11117b - view.getWidth();
                i2 = this.f11117b;
            }
            return SwipeDismissBehavior.m9605a(width, i, i2);
        }

        public final int mo71c(View view, int i) {
            return view.getTop();
        }

        public final void mo70b(View view, int i) {
            float width = ((float) this.f11117b) + (((float) view.getWidth()) * this.f11116a.f11124f);
            float width2 = ((float) this.f11117b) + (((float) view.getWidth()) * this.f11116a.f11125g);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0);
            } else {
                view.setAlpha(SwipeDismissBehavior.m9603a(1.0f - SwipeDismissBehavior.m9604a(width, width2, f)));
            }
        }
    }

    static float m9604a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public boolean mo3076a(View view) {
        return true;
    }

    public final void m9606a() {
        this.f11124f = m9603a(0.1f);
    }

    public final void m9609b() {
        this.f11125g = m9603a(0.6f);
    }

    public boolean mo76a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f11119a;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    this.f11119a = coordinatorLayout.m16550a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                    z = this.f11119a;
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
        this.f11119a = false;
        if (!z) {
            return false;
        }
        if (this.f11120b == null) {
            if (this.f11127i != null) {
                coordinatorLayout = ViewDragHelper.m1446a((ViewGroup) coordinatorLayout, this.f11126h, this.f11128j);
            } else {
                coordinatorLayout = ViewDragHelper.m1447a((ViewGroup) coordinatorLayout, this.f11128j);
            }
            this.f11120b = coordinatorLayout;
        }
        return this.f11120b.m1464a(motionEvent);
    }

    public final boolean mo80b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f11120b == null) {
            return null;
        }
        this.f11120b.m1468b(motionEvent);
        return true;
    }

    static float m9603a(float f) {
        return Math.min(Math.max(0.0f, f), 1.0f);
    }

    static int m9605a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
