package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.google.android.exoplayer2.ui.TimeBar.OnScrubListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;
import java.util.Locale;

public class DefaultTimeBar extends View implements TimeBar {
    private Point f13593A;
    private boolean f13594B;
    private long f13595C;
    private long f13596D;
    private long f13597E;
    private long f13598F;
    private int f13599G;
    private long[] f13600H;
    private boolean[] f13601I;
    private final Rect f13602a = new Rect();
    private final Rect f13603b = new Rect();
    private final Rect f13604c = new Rect();
    private final Rect f13605d = new Rect();
    private final Paint f13606e = new Paint();
    private final Paint f13607f = new Paint();
    private final Paint f13608g = new Paint();
    private final Paint f13609h = new Paint();
    private final Paint f13610i = new Paint();
    private final Paint f13611j = new Paint();
    private final int f13612k;
    private final int f13613l;
    private final int f13614m;
    private final int f13615n;
    private final int f13616o;
    private final int f13617p;
    private final int f13618q;
    private final int f13619r;
    private final StringBuilder f13620s;
    private final Formatter f13621t;
    private final Runnable f13622u;
    private OnScrubListener f13623v;
    private int f13624w;
    private long f13625x;
    private int f13626y;
    private int[] f13627z;

    class C04211 implements Runnable {
        final /* synthetic */ DefaultTimeBar f5157a;

        C04211(DefaultTimeBar defaultTimeBar) {
            this.f5157a = defaultTimeBar;
        }

        public void run() {
            this.f5157a.m12654b();
        }
    }

    private static int m12647a(int i) {
        return (i & 16777215) | 855638016;
    }

    private static int m12653b(int i) {
        return (i & 16777215) | -872415232;
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13611j.setAntiAlias(true);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f13619r = m12648a(displayMetrics, -50);
        int a = m12648a(displayMetrics, 4);
        int a2 = m12648a(displayMetrics, 26);
        int a3 = m12648a(displayMetrics, 4);
        int a4 = m12648a(displayMetrics, 12);
        int a5 = m12648a(displayMetrics, 0);
        int a6 = m12648a(displayMetrics, 16);
        if (attributeSet != null) {
            context = context.getTheme().obtainStyledAttributes(attributeSet, C0422R.styleable.DefaultTimeBar, 0, 0);
            try {
                this.f13612k = context.getDimensionPixelSize(C0422R.styleable.DefaultTimeBar_bar_height, a);
                this.f13613l = context.getDimensionPixelSize(C0422R.styleable.DefaultTimeBar_touch_target_height, a2);
                this.f13614m = context.getDimensionPixelSize(C0422R.styleable.DefaultTimeBar_ad_marker_width, a3);
                this.f13615n = context.getDimensionPixelSize(C0422R.styleable.DefaultTimeBar_scrubber_enabled_size, a4);
                this.f13616o = context.getDimensionPixelSize(C0422R.styleable.DefaultTimeBar_scrubber_disabled_size, a5);
                this.f13617p = context.getDimensionPixelSize(C0422R.styleable.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = context.getInt(C0422R.styleable.DefaultTimeBar_played_color, -1);
                a6 = context.getInt(C0422R.styleable.DefaultTimeBar_scrubber_color, -16777216 | i);
                a3 = context.getInt(C0422R.styleable.DefaultTimeBar_buffered_color, m12653b(i));
                a = context.getInt(C0422R.styleable.DefaultTimeBar_unplayed_color, m12647a(i));
                a2 = context.getInt(C0422R.styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                a4 = context.getInt(C0422R.styleable.DefaultTimeBar_played_ad_marker_color, 855638016 | (16777215 & a2));
                this.f13606e.setColor(i);
                this.f13611j.setColor(a6);
                this.f13607f.setColor(a3);
                this.f13608g.setColor(a);
                this.f13609h.setColor(a2);
                this.f13610i.setColor(a4);
            } finally {
                context.recycle();
            }
        } else {
            this.f13612k = a;
            this.f13613l = a2;
            this.f13614m = a3;
            this.f13615n = a4;
            this.f13616o = a5;
            this.f13617p = a6;
            this.f13606e.setColor(-1);
            this.f13611j.setColor(-1);
            this.f13607f.setColor(m12653b(-1));
            this.f13608g.setColor(m12647a(-1));
            this.f13609h.setColor(-1291845888);
        }
        this.f13620s = new StringBuilder();
        this.f13621t = new Formatter(this.f13620s, Locale.getDefault());
        this.f13622u = new C04211(this);
        this.f13618q = (Math.max(this.f13616o, Math.max(this.f13615n, this.f13617p)) + 1) / 2;
        this.f13596D = -9223372036854775807L;
        this.f13625x = -9223372036854775807L;
        this.f13624w = 20;
        setFocusable(true);
        if (Util.f5283a >= 16 && getImportantForAccessibility() == null) {
            setImportantForAccessibility(1);
        }
    }

    public void setListener(OnScrubListener onScrubListener) {
        this.f13623v = onScrubListener;
    }

    public void setKeyTimeIncrement(long j) {
        Assertions.m4184a(j > 0);
        this.f13624w = -1;
        this.f13625x = j;
    }

    public void setKeyCountIncrement(int i) {
        Assertions.m4184a(i > 0);
        this.f13624w = i;
        this.f13625x = -9223372036854775807L;
    }

    public void setPosition(long j) {
        this.f13597E = j;
        setContentDescription(getProgressText());
        m12655c();
    }

    public void setBufferedPosition(long j) {
        this.f13598F = j;
        m12655c();
    }

    public void setDuration(long j) {
        this.f13596D = j;
        if (this.f13594B && j == -9223372036854775807L) {
            m12654b();
        }
        m12655c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f13594B && !z) {
            m12654b();
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        int height = this.f13603b.height();
        int centerY = this.f13603b.centerY() - (height / 2);
        height += centerY;
        if (this.f13596D <= 0) {
            canvas.drawRect((float) r0.f13603b.left, (float) centerY, (float) r0.f13603b.right, (float) height, r0.f13608g);
        } else {
            int i = r0.f13604c.left;
            int i2 = r0.f13604c.right;
            int max = Math.max(Math.max(r0.f13603b.left, i2), r0.f13605d.right);
            if (max < r0.f13603b.right) {
                canvas.drawRect((float) max, (float) centerY, (float) r0.f13603b.right, (float) height, r0.f13608g);
            }
            i = Math.max(i, r0.f13605d.right);
            if (i2 > i) {
                canvas.drawRect((float) i, (float) centerY, (float) i2, (float) height, r0.f13607f);
            }
            if (r0.f13605d.width() > 0) {
                canvas.drawRect((float) r0.f13605d.left, (float) centerY, (float) r0.f13605d.right, (float) height, r0.f13606e);
            }
            i = r0.f13614m / 2;
            for (max = 0; max < r0.f13599G; max++) {
                int min = r0.f13603b.left + Math.min(r0.f13603b.width() - r0.f13614m, Math.max(0, ((int) ((((long) r0.f13603b.width()) * Util.m4318b(r0.f13600H[max], r0.f13596D)) / r0.f13596D)) - i));
                canvas.drawRect((float) min, (float) centerY, (float) (min + r0.f13614m), (float) height, r0.f13601I[max] ? r0.f13610i : r0.f13609h);
            }
        }
        if (r0.f13596D > 0) {
            if (!r0.f13594B) {
                if (!isFocused()) {
                    height = isEnabled() ? r0.f13615n : r0.f13616o;
                    canvas.drawCircle((float) Util.m4297a(r0.f13605d.right, r0.f13605d.left, r0.f13603b.right), (float) r0.f13605d.centerY(), (float) (height / 2), r0.f13611j);
                }
            }
            height = r0.f13617p;
            canvas.drawCircle((float) Util.m4297a(r0.f13605d.right, r0.f13605d.left, r0.f13603b.right), (float) r0.f13605d.centerY(), (float) (height / 2), r0.f13611j);
        } else {
            Canvas canvas2 = canvas;
        }
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (this.f13596D > 0) {
                if (this.f13627z == null) {
                    this.f13627z = new int[2];
                    this.f13593A = new Point();
                }
                getLocationOnScreen(this.f13627z);
                this.f13593A.set(((int) motionEvent.getRawX()) - this.f13627z[0], ((int) motionEvent.getRawY()) - this.f13627z[1]);
                Point point = this.f13593A;
                int i = point.x;
                int i2 = point.y;
                switch (motionEvent.getAction()) {
                    case 0:
                        float f = (float) i;
                        if (this.f13602a.contains((int) f, (int) ((float) i2))) {
                            m12649a();
                            m12650a(f);
                            this.f13595C = getScrubberPosition();
                            m12655c();
                            invalidate();
                            return true;
                        }
                        break;
                    case 1:
                    case 3:
                        if (this.f13594B) {
                            motionEvent.getAction();
                            m12654b();
                            return true;
                        }
                        break;
                    case 2:
                        if (this.f13594B != null) {
                            if (i2 < this.f13619r) {
                                m12650a((float) (this.f13626y + ((i - this.f13626y) / 3)));
                            } else {
                                this.f13626y = i;
                                m12650a((float) i);
                            }
                            this.f13595C = getScrubberPosition();
                            m12655c();
                            invalidate();
                            return true;
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
        r4 = this;
        r0 = r4.isEnabled();
        if (r0 == 0) goto L_0x0036;
    L_0x0006:
        r0 = r4.getPositionIncrement();
        r2 = 66;
        r3 = 1;
        if (r5 == r2) goto L_0x0027;
    L_0x000f:
        switch(r5) {
            case 21: goto L_0x0013;
            case 22: goto L_0x0014;
            case 23: goto L_0x0027;
            default: goto L_0x0012;
        };
    L_0x0012:
        goto L_0x0036;
    L_0x0013:
        r0 = -r0;
    L_0x0014:
        r0 = r4.m12652a(r0);
        if (r0 == 0) goto L_0x0036;
    L_0x001a:
        r5 = r4.f13622u;
        r4.removeCallbacks(r5);
        r5 = r4.f13622u;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4.postDelayed(r5, r0);
        return r3;
    L_0x0027:
        r0 = r4.f13594B;
        if (r0 == 0) goto L_0x0036;
    L_0x002b:
        r5 = r4.f13622u;
        r4.removeCallbacks(r5);
        r5 = r4.f13622u;
        r5.run();
        return r3;
    L_0x0036:
        r5 = super.onKeyDown(r5, r6);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == 0) {
            i2 = this.f13613l;
        } else if (mode != 1073741824) {
            i2 = Math.min(this.f13613l, i2);
        }
        setMeasuredDimension(MeasureSpec.getSize(i), i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        i3 -= i;
        i4 = ((i4 - i2) - this.f13613l) / 2;
        i = ((this.f13613l - this.f13612k) / 2) + i4;
        this.f13602a.set(getPaddingLeft(), i4, i3 - getPaddingRight(), this.f13613l + i4);
        this.f13603b.set(this.f13602a.left + this.f13618q, i, this.f13602a.right - this.f13618q, this.f13612k + i);
        m12655c();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(DefaultTimeBar.class.getName());
    }

    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DefaultTimeBar.class.getCanonicalName());
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f13596D > 0) {
            if (Util.f5283a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            if (Util.f5283a >= 16) {
                accessibilityNodeInfo.addAction(4096);
                accessibilityNodeInfo.addAction(8192);
            }
        }
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle) != null) {
            return true;
        }
        if (this.f13596D <= 0) {
            return false;
        }
        if (i == 8192) {
            if (m12652a(-getPositionIncrement()) != 0) {
                m12654b();
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (m12652a(getPositionIncrement()) != 0) {
                m12654b();
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void m12649a() {
        this.f13594B = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.f13623v != null) {
            getScrubberPosition();
        }
    }

    private void m12654b() {
        this.f13594B = false;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        if (this.f13623v != null) {
            getScrubberPosition();
        }
    }

    private void m12655c() {
        this.f13604c.set(this.f13603b);
        this.f13605d.set(this.f13603b);
        long j = this.f13594B ? this.f13595C : this.f13597E;
        if (this.f13596D > 0) {
            this.f13604c.right = Math.min(this.f13603b.left + ((int) ((((long) this.f13603b.width()) * this.f13598F) / this.f13596D)), this.f13603b.right);
            this.f13605d.right = Math.min(this.f13603b.left + ((int) ((((long) this.f13603b.width()) * j) / this.f13596D)), this.f13603b.right);
        } else {
            this.f13604c.right = this.f13603b.left;
            this.f13605d.right = this.f13603b.left;
        }
        invalidate(this.f13602a);
    }

    private void m12650a(float f) {
        this.f13605d.right = Util.m4297a((int) f, this.f13603b.left, this.f13603b.right);
    }

    private long getScrubberPosition() {
        if (this.f13603b.width() > 0) {
            if (this.f13596D != -9223372036854775807L) {
                return (((long) this.f13605d.width()) * this.f13596D) / ((long) this.f13603b.width());
            }
        }
        return 0;
    }

    private String getProgressText() {
        return Util.m4304a(this.f13620s, this.f13621t, this.f13597E);
    }

    private long getPositionIncrement() {
        if (this.f13625x == -9223372036854775807L) {
            return this.f13596D == -9223372036854775807L ? 0 : this.f13596D / ((long) this.f13624w);
        } else {
            return this.f13625x;
        }
    }

    private boolean m12652a(long j) {
        if (this.f13596D <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.f13595C = Util.m4318b(j + scrubberPosition, this.f13596D);
        if (this.f13595C == scrubberPosition) {
            return false;
        }
        if (this.f13594B == null) {
            m12649a();
        }
        m12655c();
        return 1;
    }

    private static int m12648a(DisplayMetrics displayMetrics, int i) {
        return (int) ((((float) i) * displayMetrics.density) + 1056964608);
    }
}
