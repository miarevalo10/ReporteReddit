package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;

class FastScroller extends ItemDecoration implements OnItemTouchListener {
    private static final int[] f11937p = new int[]{16842919};
    private static final int[] f11938q = new int[0];
    private int f11939A = 0;
    private final int[] f11940B = new int[2];
    private final int[] f11941C = new int[2];
    private final Runnable f11942D = new C02061(this);
    private final OnScrollListener f11943E = new C10272(this);
    final int f11944a;
    int f11945b;
    int f11946c;
    float f11947d;
    int f11948e;
    int f11949f;
    float f11950g;
    int f11951h = 0;
    int f11952i = 0;
    RecyclerView f11953j;
    boolean f11954k = false;
    boolean f11955l = false;
    int f11956m = 0;
    final ValueAnimator f11957n = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    int f11958o = 0;
    private final int f11959r;
    private final StateListDrawable f11960s;
    private final Drawable f11961t;
    private final int f11962u;
    private final int f11963v;
    private final StateListDrawable f11964w;
    private final Drawable f11965x;
    private final int f11966y;
    private final int f11967z;

    class C02061 implements Runnable {
        final /* synthetic */ FastScroller f2261a;

        C02061(FastScroller fastScroller) {
            this.f2261a = fastScroller;
        }

        public void run() {
            FastScroller fastScroller = this.f2261a;
            switch (fastScroller.f11958o) {
                case 1:
                    fastScroller.f11957n.cancel();
                    break;
                case 2:
                    break;
                default:
                    return;
            }
            fastScroller.f11958o = 3;
            fastScroller.f11957n.setFloatValues(new float[]{((Float) fastScroller.f11957n.getAnimatedValue()).floatValue(), 0.0f});
            fastScroller.f11957n.setDuration(500);
            fastScroller.f11957n.start();
        }
    }

    private class AnimatorListener extends AnimatorListenerAdapter {
        final /* synthetic */ FastScroller f2262a;
        private boolean f2263b;

        private AnimatorListener(FastScroller fastScroller) {
            this.f2262a = fastScroller;
            this.f2263b = null;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2263b != null) {
                this.f2263b = false;
            } else if (((Float) this.f2262a.f11957n.getAnimatedValue()).floatValue() == 0.0f) {
                this.f2262a.f11958o = 0;
                this.f2262a.m10646a(0);
            } else {
                this.f2262a.f11958o = 2;
                this.f2262a.f11953j.invalidate();
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f2263b = true;
        }
    }

    private class AnimatorUpdater implements AnimatorUpdateListener {
        final /* synthetic */ FastScroller f2264a;

        private AnimatorUpdater(FastScroller fastScroller) {
            this.f2264a = fastScroller;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator = (int) (255.0f * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f2264a.f11960s.setAlpha(valueAnimator);
            this.f2264a.f11961t.setAlpha(valueAnimator);
            this.f2264a.f11953j.invalidate();
        }
    }

    class C10272 extends OnScrollListener {
        final /* synthetic */ FastScroller f11936a;

        C10272(FastScroller fastScroller) {
            this.f11936a = fastScroller;
        }

        public final void mo616a(RecyclerView recyclerView, int i, int i2) {
            i = this.f11936a;
            i2 = recyclerView.computeHorizontalScrollOffset();
            recyclerView = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = i.f11953j.computeVerticalScrollRange();
            int i3 = i.f11952i;
            boolean z = computeVerticalScrollRange - i3 > 0 && i.f11952i >= i.f11944a;
            i.f11954k = z;
            int computeHorizontalScrollRange = i.f11953j.computeHorizontalScrollRange();
            int i4 = i.f11951h;
            boolean z2 = computeHorizontalScrollRange - i4 > 0 && i.f11951h >= i.f11944a;
            i.f11955l = z2;
            if (i.f11954k || i.f11955l) {
                if (i.f11954k) {
                    float f = (float) i3;
                    i.f11946c = (int) ((f * (((float) recyclerView) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                    i.f11945b = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (i.f11955l != null) {
                    recyclerView = (float) i2;
                    i2 = (float) i4;
                    i.f11949f = (int) ((i2 * (recyclerView + (i2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                    i.f11948e = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                if (i.f11956m == null || i.f11956m == 1) {
                    i.m10646a(1);
                }
                return;
            }
            if (i.f11956m != null) {
                i.m10646a(0);
            }
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f11960s = stateListDrawable;
        this.f11961t = drawable;
        this.f11964w = stateListDrawable2;
        this.f11965x = drawable2;
        this.f11962u = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f11963v = Math.max(i, drawable.getIntrinsicWidth());
        this.f11966y = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f11967z = Math.max(i, drawable2.getIntrinsicWidth());
        this.f11944a = i2;
        this.f11959r = i3;
        this.f11960s.setAlpha(255);
        this.f11961t.setAlpha(255);
        this.f11957n.addListener(new AnimatorListener());
        this.f11957n.addUpdateListener(new AnimatorUpdater());
        if (this.f11953j != recyclerView) {
            if (this.f11953j != null) {
                this.f11953j.removeItemDecoration(this);
                this.f11953j.removeOnItemTouchListener(this);
                this.f11953j.removeOnScrollListener(this.f11943E);
                m10642c();
            }
            this.f11953j = recyclerView;
            if (this.f11953j != null) {
                this.f11953j.addItemDecoration(this);
                this.f11953j.addOnItemTouchListener(this);
                this.f11953j.addOnScrollListener(this.f11943E);
            }
        }
    }

    final void m10646a(int i) {
        if (i == 2 && this.f11956m != 2) {
            this.f11960s.setState(f11937p);
            m10642c();
        }
        if (i == 0) {
            this.f11953j.invalidate();
        } else {
            m10638b();
        }
        if (this.f11956m == 2 && i != 2) {
            this.f11960s.setState(f11938q);
            m10639b(1200);
        } else if (i == 1) {
            m10639b(1500);
        }
        this.f11956m = i;
    }

    private boolean m10636a() {
        return ViewCompat.m1242f(this.f11953j) == 1;
    }

    private void m10638b() {
        int i = this.f11958o;
        if (i != 0) {
            if (i == 3) {
                this.f11957n.cancel();
            } else {
                return;
            }
        }
        this.f11958o = 1;
        this.f11957n.setFloatValues(new float[]{((Float) this.f11957n.getAnimatedValue()).floatValue(), 1.0f});
        this.f11957n.setDuration(500);
        this.f11957n.setStartDelay(0);
        this.f11957n.start();
    }

    private void m10642c() {
        this.f11953j.removeCallbacks(this.f11942D);
    }

    private void m10639b(int i) {
        m10642c();
        this.f11953j.postDelayed(this.f11942D, (long) i);
    }

    public final void mo483a(Canvas canvas, RecyclerView recyclerView) {
        if (this.f11951h == this.f11953j.getWidth()) {
            if (this.f11952i == this.f11953j.getHeight()) {
                if (this.f11958o != null) {
                    int i;
                    if (this.f11954k != null) {
                        recyclerView = this.f11951h - this.f11962u;
                        i = this.f11946c - (this.f11945b / 2);
                        this.f11960s.setBounds(0, 0, this.f11962u, this.f11945b);
                        this.f11961t.setBounds(0, 0, this.f11963v, this.f11952i);
                        if (m10636a()) {
                            this.f11961t.draw(canvas);
                            canvas.translate((float) this.f11962u, (float) i);
                            canvas.scale(-1.0f, 1.0f);
                            this.f11960s.draw(canvas);
                            canvas.scale(1.0f, 1.0f);
                            canvas.translate((float) (-this.f11962u), (float) (-i));
                        } else {
                            canvas.translate((float) recyclerView, 0.0f);
                            this.f11961t.draw(canvas);
                            canvas.translate(0.0f, (float) i);
                            this.f11960s.draw(canvas);
                            canvas.translate((float) (-recyclerView), (float) (-i));
                        }
                    }
                    if (this.f11955l != null) {
                        recyclerView = this.f11952i - this.f11966y;
                        i = this.f11949f - (this.f11948e / 2);
                        this.f11964w.setBounds(0, 0, this.f11948e, this.f11966y);
                        this.f11965x.setBounds(0, 0, this.f11951h, this.f11967z);
                        canvas.translate(0.0f, (float) recyclerView);
                        this.f11965x.draw(canvas);
                        canvas.translate((float) i, 0.0f);
                        this.f11964w.draw(canvas);
                        canvas.translate((float) (-i), (float) (-recyclerView));
                    }
                }
                return;
            }
        }
        this.f11951h = this.f11953j.getWidth();
        this.f11952i = this.f11953j.getHeight();
        m10646a(0);
    }

    public final boolean mo618a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f11956m == 1) {
            recyclerView = m10637a(motionEvent.getX(), motionEvent.getY());
            boolean b = m10641b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (recyclerView == null && !b) {
                return false;
            }
            if (b) {
                this.f11939A = 1;
                this.f11950g = (float) ((int) motionEvent.getX());
            } else if (recyclerView != null) {
                this.f11939A = 2;
                this.f11947d = (float) ((int) motionEvent.getY());
            }
            m10646a(2);
        } else if (this.f11956m != 2) {
            return false;
        }
        return true;
    }

    public final void mo617a(MotionEvent motionEvent) {
        if (this.f11956m != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a = m10637a(motionEvent.getX(), motionEvent.getY());
                boolean b = m10641b(motionEvent.getX(), motionEvent.getY());
                if (a || b) {
                    if (b) {
                        this.f11939A = 1;
                        this.f11950g = (float) ((int) motionEvent.getX());
                    } else if (a) {
                        this.f11939A = 2;
                        this.f11947d = (float) ((int) motionEvent.getY());
                    }
                    m10646a(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f11956m == 2) {
                this.f11947d = 0.0f;
                this.f11950g = 0.0f;
                m10646a(1);
                this.f11939A = 0;
            } else {
                if (motionEvent.getAction() == 2 && this.f11956m == 2) {
                    m10638b();
                    if (this.f11939A == 1) {
                        float x = motionEvent.getX();
                        this.f11941C[0] = this.f11959r;
                        this.f11941C[1] = this.f11951h - this.f11959r;
                        int[] iArr = this.f11941C;
                        x = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                        if (Math.abs(((float) this.f11949f) - x) >= 2.0f) {
                            int a2 = m10633a(this.f11950g, x, iArr, this.f11953j.computeHorizontalScrollRange(), this.f11953j.computeHorizontalScrollOffset(), this.f11951h);
                            if (a2 != 0) {
                                this.f11953j.scrollBy(a2, 0);
                            }
                            this.f11950g = x;
                        }
                    }
                    if (this.f11939A == 2) {
                        motionEvent = motionEvent.getY();
                        this.f11940B[0] = this.f11959r;
                        this.f11940B[1] = this.f11952i - this.f11959r;
                        int[] iArr2 = this.f11940B;
                        motionEvent = Math.max((float) iArr2[0], Math.min((float) iArr2[1], motionEvent));
                        if (Math.abs(((float) this.f11946c) - motionEvent) >= 2.0f) {
                            int a3 = m10633a(this.f11947d, motionEvent, iArr2, this.f11953j.computeVerticalScrollRange(), this.f11953j.computeVerticalScrollOffset(), this.f11952i);
                            if (a3 != 0) {
                                this.f11953j.scrollBy(0, a3);
                            }
                            this.f11947d = motionEvent;
                        }
                    }
                }
            }
        }
    }

    private static int m10633a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        i -= i3;
        f = (int) (((f2 - f) / ((float) i4)) * ((float) i));
        i2 += f;
        return (i2 >= i || i2 < 0) ? 0 : f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m10637a(float r3, float r4) {
        /*
        r2 = this;
        r0 = r2.m10636a();
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = r2.f11962u;
        r0 = r0 / 2;
        r0 = (float) r0;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 > 0) goto L_0x0034;
    L_0x000f:
        goto L_0x001a;
    L_0x0010:
        r0 = r2.f11951h;
        r1 = r2.f11962u;
        r0 = r0 - r1;
        r0 = (float) r0;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 < 0) goto L_0x0034;
    L_0x001a:
        r3 = r2.f11946c;
        r0 = r2.f11945b;
        r0 = r0 / 2;
        r3 = r3 - r0;
        r3 = (float) r3;
        r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r3 < 0) goto L_0x0034;
    L_0x0026:
        r3 = r2.f11946c;
        r0 = r2.f11945b;
        r0 = r0 / 2;
        r3 = r3 + r0;
        r3 = (float) r3;
        r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x0034;
    L_0x0032:
        r3 = 1;
        return r3;
    L_0x0034:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.FastScroller.a(float, float):boolean");
    }

    private boolean m10641b(float f, float f2) {
        return f2 >= ((float) (this.f11952i - this.f11966y)) && f >= ((float) (this.f11949f - (this.f11948e / 2))) && f <= ((float) (this.f11949f + (this.f11948e / 2)));
    }
}
