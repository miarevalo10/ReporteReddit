package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public class ViewDragHelper {
    private static final Interpolator f1673v = new C01481();
    int f1674a;
    public int f1675b;
    float[] f1676c;
    float[] f1677d;
    float[] f1678e;
    float[] f1679f;
    float f1680g;
    int f1681h;
    int f1682i;
    View f1683j;
    private int f1684k = -1;
    private int[] f1685l;
    private int[] f1686m;
    private int[] f1687n;
    private int f1688o;
    private VelocityTracker f1689p;
    private float f1690q;
    private OverScroller f1691r;
    private final Callback f1692s;
    private boolean f1693t;
    private final ViewGroup f1694u;
    private final Runnable f1695w = new C01492(this);

    static class C01481 implements Interpolator {
        public final float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }

        C01481() {
        }
    }

    class C01492 implements Runnable {
        final /* synthetic */ ViewDragHelper f1672a;

        C01492(ViewDragHelper viewDragHelper) {
            this.f1672a = viewDragHelper;
        }

        public void run() {
            this.f1672a.m1467b(0);
        }
    }

    public static abstract class Callback {
        public static int m1432b(int i) {
            return i;
        }

        public int mo66a() {
            return 0;
        }

        public int mo115a(View view) {
            return 0;
        }

        public void mo67a(int i) {
        }

        public void mo389a(int i, int i2) {
        }

        public void mo68a(View view, float f, float f2) {
        }

        public abstract boolean mo69a(View view, int i);

        public void mo70b(View view, int i) {
        }

        public int mo71c(View view, int i) {
            return 0;
        }

        public int mo72d(View view, int i) {
            return 0;
        }

        public void mo390d() {
        }

        public void mo116e(View view, int i) {
        }
    }

    private void m1457c(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.widget.ViewDragHelper.c(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.c(int):void");
    }

    public static ViewDragHelper m1447a(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public static ViewDragHelper m1446a(ViewGroup viewGroup, float f, Callback callback) {
        viewGroup = m1447a(viewGroup, callback);
        viewGroup.f1675b = (int) (((float) viewGroup.f1675b) * (1.0f / f));
        return viewGroup;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1694u = viewGroup;
            this.f1692s = callback;
            viewGroup = ViewConfiguration.get(context);
            this.f1681h = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.f1675b = viewGroup.getScaledTouchSlop();
            this.f1690q = (float) viewGroup.getScaledMaximumFlingVelocity();
            this.f1680g = (float) viewGroup.getScaledMinimumFlingVelocity();
            this.f1691r = new OverScroller(context, f1673v);
        }
    }

    public final void m1461a(View view, int i) {
        if (view.getParent() != this.f1694u) {
            i = new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
            i.append(this.f1694u);
            i.append(")");
            throw new IllegalArgumentException(i.toString());
        }
        this.f1683j = view;
        this.f1684k = i;
        this.f1692s.mo116e(view, i);
        m1467b(1);
    }

    public final void m1460a() {
        this.f1684k = -1;
        if (this.f1676c != null) {
            Arrays.fill(this.f1676c, 0.0f);
            Arrays.fill(this.f1677d, 0.0f);
            Arrays.fill(this.f1678e, 0.0f);
            Arrays.fill(this.f1679f, 0.0f);
            Arrays.fill(this.f1685l, 0);
            Arrays.fill(this.f1686m, 0);
            Arrays.fill(this.f1687n, 0);
            this.f1688o = 0;
        }
        if (this.f1689p != null) {
            this.f1689p.recycle();
            this.f1689p = null;
        }
    }

    public final boolean m1465a(View view, int i, int i2) {
        this.f1683j = view;
        this.f1684k = -1;
        view = m1451a(i, i2, 0, 0);
        if (view == null && this.f1674a == 0 && this.f1683j != 0) {
            this.f1683j = 0;
        }
        return view;
    }

    public final boolean m1463a(int i, int i2) {
        if (this.f1693t) {
            return m1451a(i, i2, (int) this.f1689p.getXVelocity(this.f1684k), (int) this.f1689p.getYVelocity(this.f1684k));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m1451a(int i, int i2, int i3, int i4) {
        int left = this.f1683j.getLeft();
        int top = this.f1683j.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1691r.abortAnimation();
            m1467b(0);
            return false;
        }
        float f;
        float f2;
        View view = this.f1683j;
        i2 = m1453b(i3, (int) this.f1680g, (int) this.f1690q);
        i3 = m1453b(i4, (int) this.f1680g, (int) this.f1690q);
        i4 = Math.abs(i5);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i3);
        int i7 = abs2 + abs3;
        int i8 = i4 + abs;
        if (i2 != 0) {
            i4 = (float) abs2;
            f = (float) i7;
        } else {
            i4 = (float) i4;
            f = (float) i8;
        }
        i4 /= f;
        if (i3 != 0) {
            f2 = (float) abs3;
            f = (float) i7;
        } else {
            f2 = (float) abs;
            f = (float) i8;
        }
        f2 /= f;
        this.f1691r.startScroll(left, top, i5, i6, (int) ((((float) m1445a(i5, i2, this.f1692s.mo115a(view))) * i4) + (((float) m1445a(i6, i3, this.f1692s.mo66a())) * f2)));
        m1467b(2);
        return true;
    }

    private int m1445a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1694u.getWidth();
        float f = (float) (width / 2);
        f += ((float) Math.sin((double) ((Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f) * 0.47123894f))) * f;
        i2 = Math.abs(i2);
        if (i2 > 0) {
            i = 4 * Math.round(1148846080 * Math.abs(f / ((float) i2)));
        } else {
            i = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1065353216) * 1132462080);
        }
        return Math.min(i, 600);
    }

    private static int m1453b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs > i3) {
            return i > 0 ? i3 : -i3;
        } else {
            return i;
        }
    }

    private static float m1444a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        } else {
            return f;
        }
    }

    public final boolean m1469b() {
        if (this.f1674a == 2) {
            boolean computeScrollOffset = this.f1691r.computeScrollOffset();
            int currX = this.f1691r.getCurrX();
            int currY = this.f1691r.getCurrY();
            int left = currX - this.f1683j.getLeft();
            int top = currY - this.f1683j.getTop();
            if (left != 0) {
                ViewCompat.m1236c(this.f1683j, left);
            }
            if (top != 0) {
                ViewCompat.m1231b(this.f1683j, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1692s.mo70b(this.f1683j, currX);
            }
            if (computeScrollOffset && currX == this.f1691r.getFinalX() && currY == this.f1691r.getFinalY()) {
                this.f1691r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f1694u.post(this.f1695w);
            }
        }
        if (this.f1674a == 2) {
            return true;
        }
        return false;
    }

    private void m1448a(float f, float f2) {
        this.f1693t = true;
        this.f1692s.mo68a(this.f1683j, f, f2);
        this.f1693t = false;
        if (this.f1674a == Float.MIN_VALUE) {
            m1467b(0);
        }
    }

    private void m1458c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m1459d(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1678e[pointerId] = x;
                this.f1679f[pointerId] = y;
            }
        }
    }

    public final boolean m1462a(int i) {
        return ((1 << i) & this.f1688o) != 0;
    }

    final void m1467b(int i) {
        this.f1694u.removeCallbacks(this.f1695w);
        if (this.f1674a != i) {
            this.f1674a = i;
            this.f1692s.mo67a(i);
            if (this.f1674a == 0) {
                this.f1683j = 0;
            }
        }
    }

    private boolean m1455b(View view, int i) {
        if (view == this.f1683j && this.f1684k == i) {
            return true;
        }
        if (view == null || !this.f1692s.mo69a(view, i)) {
            return null;
        }
        this.f1684k = i;
        m1461a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m1464a(android.view.MotionEvent r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r18.getActionMasked();
        r3 = r18.getActionIndex();
        if (r2 != 0) goto L_0x0011;
    L_0x000e:
        r17.m1460a();
    L_0x0011:
        r4 = r0.f1689p;
        if (r4 != 0) goto L_0x001b;
    L_0x0015:
        r4 = android.view.VelocityTracker.obtain();
        r0.f1689p = r4;
    L_0x001b:
        r4 = r0.f1689p;
        r4.addMovement(r1);
        r4 = 2;
        r6 = 1;
        switch(r2) {
            case 0: goto L_0x00f0;
            case 1: goto L_0x00ec;
            case 2: goto L_0x0066;
            case 3: goto L_0x00ec;
            case 4: goto L_0x0025;
            case 5: goto L_0x0030;
            case 6: goto L_0x0027;
            default: goto L_0x0025;
        };
    L_0x0025:
        goto L_0x011f;
    L_0x0027:
        r1 = r1.getPointerId(r3);
        r0.m1457c(r1);
        goto L_0x011f;
    L_0x0030:
        r2 = r1.getPointerId(r3);
        r7 = r1.getX(r3);
        r1 = r1.getY(r3);
        r0.m1449a(r7, r1, r2);
        r3 = r0.f1674a;
        if (r3 != 0) goto L_0x0053;
    L_0x0043:
        r1 = r0.f1685l;
        r1 = r1[r2];
        r2 = r0.f1682i;
        r1 = r1 & r2;
        if (r1 == 0) goto L_0x011f;
    L_0x004c:
        r1 = r0.f1692s;
        r1.mo390d();
        goto L_0x011f;
    L_0x0053:
        r3 = r0.f1674a;
        if (r3 != r4) goto L_0x011f;
    L_0x0057:
        r3 = (int) r7;
        r1 = (int) r1;
        r1 = r0.m1466b(r3, r1);
        r3 = r0.f1683j;
        if (r1 != r3) goto L_0x011f;
    L_0x0061:
        r0.m1455b(r1, r2);
        goto L_0x011f;
    L_0x0066:
        r2 = r0.f1676c;
        if (r2 == 0) goto L_0x011f;
    L_0x006a:
        r2 = r0.f1677d;
        if (r2 == 0) goto L_0x011f;
    L_0x006e:
        r2 = r18.getPointerCount();
        r3 = 0;
    L_0x0073:
        if (r3 >= r2) goto L_0x00e8;
    L_0x0075:
        r4 = r1.getPointerId(r3);
        r7 = r0.m1459d(r4);
        if (r7 == 0) goto L_0x00e5;
    L_0x007f:
        r7 = r1.getX(r3);
        r8 = r1.getY(r3);
        r9 = r0.f1676c;
        r9 = r9[r4];
        r9 = r7 - r9;
        r10 = r0.f1677d;
        r10 = r10[r4];
        r10 = r8 - r10;
        r7 = (int) r7;
        r8 = (int) r8;
        r7 = r0.m1466b(r7, r8);
        if (r7 == 0) goto L_0x00a3;
    L_0x009b:
        r8 = r0.m1452a(r7, r9, r10);
        if (r8 == 0) goto L_0x00a3;
    L_0x00a1:
        r8 = r6;
        goto L_0x00a4;
    L_0x00a3:
        r8 = 0;
    L_0x00a4:
        if (r8 == 0) goto L_0x00d6;
    L_0x00a6:
        r11 = r7.getLeft();
        r12 = (int) r9;
        r12 = r12 + r11;
        r13 = r0.f1692s;
        r12 = r13.mo72d(r7, r12);
        r13 = r7.getTop();
        r14 = (int) r10;
        r14 = r14 + r13;
        r15 = r0.f1692s;
        r14 = r15.mo71c(r7, r14);
        r15 = r0.f1692s;
        r15 = r15.mo115a(r7);
        r5 = r0.f1692s;
        r5 = r5.mo66a();
        if (r15 == 0) goto L_0x00d0;
    L_0x00cc:
        if (r15 <= 0) goto L_0x00d6;
    L_0x00ce:
        if (r12 != r11) goto L_0x00d6;
    L_0x00d0:
        if (r5 == 0) goto L_0x00e8;
    L_0x00d2:
        if (r5 <= 0) goto L_0x00d6;
    L_0x00d4:
        if (r14 == r13) goto L_0x00e8;
    L_0x00d6:
        r0.m1454b(r9, r10, r4);
        r5 = r0.f1674a;
        if (r5 == r6) goto L_0x00e8;
    L_0x00dd:
        if (r8 == 0) goto L_0x00e5;
    L_0x00df:
        r4 = r0.m1455b(r7, r4);
        if (r4 != 0) goto L_0x00e8;
    L_0x00e5:
        r3 = r3 + 1;
        goto L_0x0073;
    L_0x00e8:
        r17.m1458c(r18);
        goto L_0x011f;
    L_0x00ec:
        r17.m1460a();
        goto L_0x011f;
    L_0x00f0:
        r2 = r18.getX();
        r3 = r18.getY();
        r5 = 0;
        r1 = r1.getPointerId(r5);
        r0.m1449a(r2, r3, r1);
        r2 = (int) r2;
        r3 = (int) r3;
        r2 = r0.m1466b(r2, r3);
        r3 = r0.f1683j;
        if (r2 != r3) goto L_0x0111;
    L_0x010a:
        r3 = r0.f1674a;
        if (r3 != r4) goto L_0x0111;
    L_0x010e:
        r0.m1455b(r2, r1);
    L_0x0111:
        r2 = r0.f1685l;
        r1 = r2[r1];
        r2 = r0.f1682i;
        r1 = r1 & r2;
        if (r1 == 0) goto L_0x011f;
    L_0x011a:
        r1 = r0.f1692s;
        r1.mo390d();
    L_0x011f:
        r1 = r0.f1674a;
        if (r1 != r6) goto L_0x0124;
    L_0x0123:
        return r6;
    L_0x0124:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.a(android.view.MotionEvent):boolean");
    }

    public final void m1468b(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m1460a();
        }
        if (this.f1689p == null) {
            this.f1689p = VelocityTracker.obtain();
        }
        this.f1689p.addMovement(motionEvent);
        int i = 0;
        float y;
        float x;
        View b;
        int left;
        switch (actionMasked) {
            case 0:
                float x2 = motionEvent.getX();
                y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View b2 = m1466b((int) x2, (int) y);
                m1449a(x2, y, pointerId);
                m1455b(b2, pointerId);
                if ((this.f1685l[pointerId] & this.f1682i) != null) {
                    this.f1692s.mo390d();
                    return;
                }
                break;
            case 1:
                if (this.f1674a == 1) {
                    m1456c();
                }
                m1460a();
                return;
            case 2:
                if (this.f1674a != 1) {
                    actionMasked = motionEvent.getPointerCount();
                    while (i < actionMasked) {
                        actionIndex = motionEvent.getPointerId(i);
                        if (m1459d(actionIndex)) {
                            x = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x - this.f1676c[actionIndex];
                            float f2 = y2 - this.f1677d[actionIndex];
                            m1454b(f, f2, actionIndex);
                            if (this.f1674a != 1) {
                                b = m1466b((int) x, (int) y2);
                                if (m1452a(b, f, f2) && m1455b(b, actionIndex)) {
                                }
                            }
                            m1458c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m1458c(motionEvent);
                    return;
                } else if (m1459d(this.f1684k)) {
                    actionMasked = motionEvent.findPointerIndex(this.f1684k);
                    y = motionEvent.getX(actionMasked);
                    actionIndex = (int) (y - this.f1678e[this.f1684k]);
                    actionMasked = (int) (motionEvent.getY(actionMasked) - this.f1679f[this.f1684k]);
                    i = this.f1683j.getLeft() + actionIndex;
                    int top = this.f1683j.getTop() + actionMasked;
                    left = this.f1683j.getLeft();
                    int top2 = this.f1683j.getTop();
                    if (actionIndex != 0) {
                        i = this.f1692s.mo72d(this.f1683j, i);
                        ViewCompat.m1236c(this.f1683j, i - left);
                    }
                    if (actionMasked != 0) {
                        ViewCompat.m1231b(this.f1683j, this.f1692s.mo71c(this.f1683j, top) - top2);
                    }
                    if (!(actionIndex == 0 && actionMasked == 0)) {
                        this.f1692s.mo70b(this.f1683j, i);
                    }
                    m1458c(motionEvent);
                    return;
                }
                break;
            case 3:
                if (this.f1674a == 1) {
                    m1448a(0.0f, 0.0f);
                }
                m1460a();
                break;
            case 5:
                actionMasked = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                m1449a(x, y3, actionMasked);
                if (this.f1674a == 0) {
                    m1455b(m1466b((int) x, (int) y3), actionMasked);
                    if ((this.f1685l[actionMasked] & this.f1682i) != null) {
                        this.f1692s.mo390d();
                    }
                    return;
                }
                actionIndex = (int) x;
                motionEvent = (int) y3;
                b = this.f1683j;
                if (b != null && actionIndex >= b.getLeft() && actionIndex < b.getRight() && motionEvent >= b.getTop() && motionEvent < b.getBottom()) {
                    i = 1;
                }
                if (i != 0) {
                    m1455b(this.f1683j, actionMasked);
                    return;
                }
                break;
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.f1674a == 1 && actionMasked == this.f1684k) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        left = motionEvent.getPointerId(i);
                        if (left != this.f1684k) {
                            if (m1466b((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f1683j && m1455b(this.f1683j, left)) {
                                motionEvent = this.f1684k;
                                if (motionEvent == -1) {
                                    m1456c();
                                }
                            }
                        }
                        i++;
                    }
                    motionEvent = -1;
                    if (motionEvent == -1) {
                        m1456c();
                    }
                }
                m1457c(actionMasked);
                return;
            default:
                break;
        }
    }

    private void m1454b(float f, float f2, int i) {
        int a = m1450a(f, f2, i, 1);
        if (m1450a(f2, f, i, 4)) {
            a |= 4;
        }
        if (m1450a(f, f2, i, 2)) {
            a |= 2;
        }
        if (m1450a(f2, f, i, 8) != null) {
            a |= 8;
        }
        if (a != 0) {
            f = this.f1686m;
            f[i] = f[i] | a;
            this.f1692s.mo389a(a, i);
        }
    }

    private boolean m1450a(float f, float f2, int i, int i2) {
        f = Math.abs(f);
        f2 = Math.abs(f2);
        if (!((this.f1685l[i] & i2) != i2 || (this.f1682i & i2) == 0 || (this.f1687n[i] & i2) == i2 || (this.f1686m[i] & i2) == i2)) {
            if (f > ((float) this.f1675b) || f2 > ((float) this.f1675b)) {
                if ((this.f1686m[i] & i2) != null || f <= ((float) this.f1675b)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean m1452a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        view = this.f1692s.mo115a(view) > null ? 1 : null;
        boolean z = this.f1692s.mo66a() > 0;
        return (view == null || !z) ? view != null ? Math.abs(f) > ((float) this.f1675b) : z && Math.abs(f2) > ((float) this.f1675b) : (f * f) + (f2 * f2) > ((float) (this.f1675b * this.f1675b));
    }

    private void m1456c() {
        this.f1689p.computeCurrentVelocity(1000, this.f1690q);
        m1448a(m1444a(this.f1689p.getXVelocity(this.f1684k), this.f1680g, this.f1690q), m1444a(this.f1689p.getYVelocity(this.f1684k), this.f1680g, this.f1690q));
    }

    public final View m1466b(int i, int i2) {
        for (int childCount = this.f1694u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1694u.getChildAt(Callback.m1432b(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return 0;
    }

    private boolean m1459d(int i) {
        if (m1462a(i)) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("Ignoring pointerId=");
        stringBuilder.append(i);
        stringBuilder.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        Log.e("ViewDragHelper", stringBuilder.toString());
        return false;
    }

    private void m1449a(float f, float f2, int i) {
        int i2 = 0;
        if (this.f1676c == null || this.f1676c.length <= i) {
            int i3 = i + 1;
            Object obj = new float[i3];
            Object obj2 = new float[i3];
            Object obj3 = new float[i3];
            Object obj4 = new float[i3];
            Object obj5 = new int[i3];
            Object obj6 = new int[i3];
            Object obj7 = new int[i3];
            if (this.f1676c != null) {
                System.arraycopy(this.f1676c, 0, obj, 0, this.f1676c.length);
                System.arraycopy(this.f1677d, 0, obj2, 0, this.f1677d.length);
                System.arraycopy(this.f1678e, 0, obj3, 0, this.f1678e.length);
                System.arraycopy(this.f1679f, 0, obj4, 0, this.f1679f.length);
                System.arraycopy(this.f1685l, 0, obj5, 0, this.f1685l.length);
                System.arraycopy(this.f1686m, 0, obj6, 0, this.f1686m.length);
                System.arraycopy(this.f1687n, 0, obj7, 0, this.f1687n.length);
            }
            this.f1676c = obj;
            this.f1677d = obj2;
            this.f1678e = obj3;
            this.f1679f = obj4;
            this.f1685l = obj5;
            this.f1686m = obj6;
            this.f1687n = obj7;
        }
        float[] fArr = this.f1676c;
        this.f1678e[i] = f;
        fArr[i] = f;
        fArr = this.f1677d;
        this.f1679f[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.f1685l;
        int i4 = (int) f;
        int i5 = (int) f2;
        if (i4 < this.f1694u.getLeft() + this.f1681h) {
            i2 = 1;
        }
        if (i5 < this.f1694u.getTop() + this.f1681h) {
            i2 |= 4;
        }
        if (i4 > this.f1694u.getRight() - this.f1681h) {
            i2 |= 2;
        }
        if (i5 > this.f1694u.getBottom() - this.f1681h) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.f1688o |= Float.MIN_VALUE << i;
    }
}
