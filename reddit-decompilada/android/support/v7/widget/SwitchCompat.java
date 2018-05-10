package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.VelocityTracker;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
    private static final int[] f2536N = new int[]{16842912};
    private static final Property<SwitchCompat, Float> f2537b = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(((SwitchCompat) obj).f2575z);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
        }
    };
    private int f2538A;
    private int f2539B;
    private int f2540C;
    private int f2541D;
    private int f2542E;
    private int f2543F;
    private int f2544G;
    private final TextPaint f2545H;
    private ColorStateList f2546I;
    private Layout f2547J;
    private Layout f2548K;
    private TransformationMethod f2549L;
    private final Rect f2550M;
    ObjectAnimator f2551a;
    private Drawable f2552c;
    private ColorStateList f2553d;
    private Mode f2554e;
    private boolean f2555f;
    private boolean f2556g;
    private Drawable f2557h;
    private ColorStateList f2558i;
    private Mode f2559j;
    private boolean f2560k;
    private boolean f2561l;
    private int f2562m;
    private int f2563n;
    private int f2564o;
    private boolean f2565p;
    private CharSequence f2566q;
    private CharSequence f2567r;
    private boolean f2568s;
    private int f2569t;
    private int f2570u;
    private float f2571v;
    private float f2572w;
    private VelocityTracker f2573x;
    private int f2574y;
    private float f2575z;

    public SwitchCompat(android.content.Context r1, android.util.AttributeSet r2, int r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.widget.SwitchCompat.<init>(android.content.Context, android.util.AttributeSet, int):void
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SwitchCompat.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.switchStyle);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f2545H.getTypeface() != null && !this.f2545H.getTypeface().equals(typeface)) || (this.f2545H.getTypeface() == null && typeface != null)) {
            this.f2545H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f2564o = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f2564o;
    }

    public void setSwitchMinWidth(int i) {
        this.f2563n = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f2563n;
    }

    public void setThumbTextPadding(int i) {
        this.f2562m = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f2562m;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f2557h != null) {
            this.f2557h.setCallback(null);
        }
        this.f2557h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.m1570b(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.f2557h;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2558i = colorStateList;
        this.f2560k = true;
        m2299a();
    }

    public ColorStateList getTrackTintList() {
        return this.f2558i;
    }

    public void setTrackTintMode(Mode mode) {
        this.f2559j = mode;
        this.f2561l = true;
        m2299a();
    }

    public Mode getTrackTintMode() {
        return this.f2559j;
    }

    private void m2299a() {
        if (this.f2557h == null) {
            return;
        }
        if (this.f2560k || this.f2561l) {
            this.f2557h = this.f2557h.mutate();
            if (this.f2560k) {
                DrawableCompat.m833a(this.f2557h, this.f2558i);
            }
            if (this.f2561l) {
                DrawableCompat.m836a(this.f2557h, this.f2559j);
            }
            if (this.f2557h.isStateful()) {
                this.f2557h.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.f2552c != null) {
            this.f2552c.setCallback(null);
        }
        this.f2552c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.m1570b(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.f2552c;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2553d = colorStateList;
        this.f2555f = true;
        m2300b();
    }

    public ColorStateList getThumbTintList() {
        return this.f2553d;
    }

    public void setThumbTintMode(Mode mode) {
        this.f2554e = mode;
        this.f2556g = true;
        m2300b();
    }

    public Mode getThumbTintMode() {
        return this.f2554e;
    }

    private void m2300b() {
        if (this.f2552c == null) {
            return;
        }
        if (this.f2555f || this.f2556g) {
            this.f2552c = this.f2552c.mutate();
            if (this.f2555f) {
                DrawableCompat.m833a(this.f2552c, this.f2553d);
            }
            if (this.f2556g) {
                DrawableCompat.m836a(this.f2552c, this.f2554e);
            }
            if (this.f2552c.isStateful()) {
                this.f2552c.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f2565p = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f2565p;
    }

    public CharSequence getTextOn() {
        return this.f2566q;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f2566q = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f2567r;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f2567r = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f2568s != z) {
            this.f2568s = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f2568s;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f2568s) {
            if (this.f2547J == null) {
                this.f2547J = m2298a(this.f2566q);
            }
            if (this.f2548K == null) {
                this.f2548K = m2298a(this.f2567r);
            }
        }
        Rect rect = this.f2550M;
        int i3 = 0;
        if (this.f2552c != null) {
            this.f2552c.getPadding(rect);
            intrinsicWidth = (this.f2552c.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2552c.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = intrinsicWidth;
        }
        this.f2540C = Math.max(this.f2568s ? Math.max(this.f2547J.getWidth(), this.f2548K.getWidth()) + (this.f2562m * 2) : 0, intrinsicWidth);
        if (this.f2557h != null) {
            this.f2557h.getPadding(rect);
            i3 = this.f2557h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        int i4 = rect.right;
        if (this.f2552c != null) {
            Rect a = DrawableUtils.m1958a(this.f2552c);
            intrinsicWidth = Math.max(intrinsicWidth, a.left);
            i4 = Math.max(i4, a.right);
        }
        i4 = Math.max(this.f2563n, ((2 * this.f2540C) + intrinsicWidth) + i4);
        intrinsicWidth = Math.max(i3, intrinsicHeight);
        this.f2538A = i4;
        this.f2539B = intrinsicWidth;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicWidth) {
            setMeasuredDimension(getMeasuredWidthAndState(), intrinsicWidth);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f2566q : this.f2567r;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout m2298a(CharSequence charSequence) {
        if (this.f2549L != null) {
            charSequence = this.f2549L.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.f2545H, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, this.f2545H)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r0 = r9.f2573x;
        r0.addMovement(r10);
        r0 = r10.getActionMasked();
        r1 = 2;
        r2 = 0;
        r3 = 0;
        r4 = 1;
        switch(r0) {
            case 0: goto L_0x00f8;
            case 1: goto L_0x008a;
            case 2: goto L_0x0012;
            case 3: goto L_0x008a;
            default: goto L_0x0010;
        };
    L_0x0010:
        goto L_0x0152;
    L_0x0012:
        r0 = r9.f2569t;
        switch(r0) {
            case 0: goto L_0x0152;
            case 1: goto L_0x0056;
            case 2: goto L_0x0019;
            default: goto L_0x0017;
        };
    L_0x0017:
        goto L_0x0152;
    L_0x0019:
        r10 = r10.getX();
        r0 = r9.getThumbScrollRange();
        r1 = r9.f2571v;
        r1 = r10 - r1;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r0 == 0) goto L_0x002d;
    L_0x0029:
        r0 = (float) r0;
        r0 = r1 / r0;
        goto L_0x0035;
    L_0x002d:
        r0 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0033;
    L_0x0031:
        r0 = r3;
        goto L_0x0035;
    L_0x0033:
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
    L_0x0035:
        r1 = android.support.v7.widget.ViewUtils.m2390a(r9);
        if (r1 == 0) goto L_0x003c;
    L_0x003b:
        r0 = -r0;
    L_0x003c:
        r1 = r9.f2575z;
        r0 = r0 + r1;
        r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r1 >= 0) goto L_0x0045;
    L_0x0043:
        r0 = r2;
        goto L_0x004a;
    L_0x0045:
        r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x004a;
    L_0x0049:
        r0 = r3;
    L_0x004a:
        r1 = r9.f2575z;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x0055;
    L_0x0050:
        r9.f2571v = r10;
        r9.setThumbPosition(r0);
    L_0x0055:
        return r4;
    L_0x0056:
        r0 = r10.getX();
        r2 = r10.getY();
        r3 = r9.f2571v;
        r3 = r0 - r3;
        r3 = java.lang.Math.abs(r3);
        r5 = r9.f2570u;
        r5 = (float) r5;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 > 0) goto L_0x007c;
    L_0x006d:
        r3 = r9.f2572w;
        r3 = r2 - r3;
        r3 = java.lang.Math.abs(r3);
        r5 = r9.f2570u;
        r5 = (float) r5;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x0152;
    L_0x007c:
        r9.f2569t = r1;
        r10 = r9.getParent();
        r10.requestDisallowInterceptTouchEvent(r4);
        r9.f2571v = r0;
        r9.f2572w = r2;
        return r4;
    L_0x008a:
        r0 = r9.f2569t;
        if (r0 != r1) goto L_0x00f0;
    L_0x008e:
        r9.f2569t = r3;
        r0 = r10.getAction();
        if (r0 != r4) goto L_0x009e;
    L_0x0096:
        r0 = r9.isEnabled();
        if (r0 == 0) goto L_0x009e;
    L_0x009c:
        r0 = r4;
        goto L_0x009f;
    L_0x009e:
        r0 = r3;
    L_0x009f:
        r1 = r9.isChecked();
        if (r0 == 0) goto L_0x00d5;
    L_0x00a5:
        r0 = r9.f2573x;
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.computeCurrentVelocity(r5);
        r0 = r9.f2573x;
        r0 = r0.getXVelocity();
        r5 = java.lang.Math.abs(r0);
        r6 = r9.f2574y;
        r6 = (float) r6;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00d0;
    L_0x00bd:
        r5 = android.support.v7.widget.ViewUtils.m2390a(r9);
        if (r5 == 0) goto L_0x00cb;
    L_0x00c3:
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x00c9;
    L_0x00c7:
        r0 = r4;
        goto L_0x00d6;
    L_0x00c9:
        r0 = r3;
        goto L_0x00d6;
    L_0x00cb:
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c9;
    L_0x00cf:
        goto L_0x00c7;
    L_0x00d0:
        r0 = r9.getTargetCheckedState();
        goto L_0x00d6;
    L_0x00d5:
        r0 = r1;
    L_0x00d6:
        if (r0 == r1) goto L_0x00db;
    L_0x00d8:
        r9.playSoundEffect(r3);
    L_0x00db:
        r9.setChecked(r0);
        r0 = android.view.MotionEvent.obtain(r10);
        r1 = 3;
        r0.setAction(r1);
        super.onTouchEvent(r0);
        r0.recycle();
        super.onTouchEvent(r10);
        return r4;
    L_0x00f0:
        r9.f2569t = r3;
        r0 = r9.f2573x;
        r0.clear();
        goto L_0x0152;
    L_0x00f8:
        r0 = r10.getX();
        r1 = r10.getY();
        r2 = r9.isEnabled();
        if (r2 == 0) goto L_0x0152;
    L_0x0106:
        r2 = r9.f2552c;
        if (r2 == 0) goto L_0x014a;
    L_0x010a:
        r2 = r9.getThumbOffset();
        r5 = r9.f2552c;
        r6 = r9.f2550M;
        r5.getPadding(r6);
        r5 = r9.f2542E;
        r6 = r9.f2570u;
        r5 = r5 - r6;
        r6 = r9.f2541D;
        r6 = r6 + r2;
        r2 = r9.f2570u;
        r6 = r6 - r2;
        r2 = r9.f2540C;
        r2 = r2 + r6;
        r7 = r9.f2550M;
        r7 = r7.left;
        r2 = r2 + r7;
        r7 = r9.f2550M;
        r7 = r7.right;
        r2 = r2 + r7;
        r7 = r9.f2570u;
        r2 = r2 + r7;
        r7 = r9.f2544G;
        r8 = r9.f2570u;
        r7 = r7 + r8;
        r6 = (float) r6;
        r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x014a;
    L_0x013a:
        r2 = (float) r2;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x014a;
    L_0x013f:
        r2 = (float) r5;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x014a;
    L_0x0144:
        r2 = (float) r7;
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x014a;
    L_0x0149:
        r3 = r4;
    L_0x014a:
        if (r3 == 0) goto L_0x0152;
    L_0x014c:
        r9.f2569t = r4;
        r9.f2571v = r0;
        r9.f2572w = r1;
    L_0x0152:
        r10 = super.onTouchEvent(r10);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean getTargetCheckedState() {
        return this.f2575z > 0.5f;
    }

    void setThumbPosition(float f) {
        this.f2575z = f;
        invalidate();
    }

    public void toggle() {
        setChecked(isChecked() ^ 1);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        z = isChecked();
        float f = 0.0f;
        if (getWindowToken() == null || !ViewCompat.m1206G(this)) {
            if (this.f2551a != null) {
                this.f2551a.cancel();
            }
            if (z) {
                f = 1.0f;
            }
            setThumbPosition(f);
            return;
        }
        if (z) {
            f = 1.0f;
        }
        this.f2551a = ObjectAnimator.ofFloat(this, f2537b, new float[]{f});
        this.f2551a.setDuration(250);
        if (VERSION.SDK_INT >= true) {
            this.f2551a.setAutoCancel(true);
        }
        this.f2551a.start();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        i = 0;
        if (this.f2552c) {
            z = this.f2550M;
            if (this.f2557h != 0) {
                this.f2557h.getPadding(z);
            } else {
                z.setEmpty();
            }
            i2 = DrawableUtils.m1958a(this.f2552c);
            i3 = Math.max(0, i2.left - z.left);
            z = Math.max(0, i2.right - z.right);
            i = i3;
        } else {
            z = false;
        }
        if (ViewUtils.m2390a(this) != 0) {
            i2 = getPaddingLeft() + i;
            i3 = ((this.f2538A + i2) - i) - z;
        } else {
            i3 = (getWidth() - getPaddingRight()) - z;
            i2 = ((i3 - this.f2538A) + i) + z;
        }
        z = getGravity() & 112;
        if (z) {
            z = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f2539B / 2);
            i = this.f2539B + z;
        } else if (!z) {
            z = getPaddingTop();
            i = this.f2539B + z;
        } else {
            i = getHeight() - getPaddingBottom();
            z = i - this.f2539B;
        }
        this.f2541D = i2;
        this.f2542E = z;
        this.f2544G = i;
        this.f2543F = i3;
    }

    public void draw(Canvas canvas) {
        Rect a;
        Rect rect = this.f2550M;
        int i = this.f2541D;
        int i2 = this.f2542E;
        int i3 = this.f2543F;
        int i4 = this.f2544G;
        int thumbOffset = getThumbOffset() + i;
        if (this.f2552c != null) {
            a = DrawableUtils.m1958a(this.f2552c);
        } else {
            a = DrawableUtils.f2259a;
        }
        if (this.f2557h != null) {
            int i5;
            int i6;
            this.f2557h.getPadding(rect);
            thumbOffset += rect.left;
            if (a != null) {
                if (a.left > rect.left) {
                    i += a.left - rect.left;
                }
                i5 = a.top > rect.top ? (a.top - rect.top) + i2 : i2;
                if (a.right > rect.right) {
                    i3 -= a.right - rect.right;
                }
                if (a.bottom > rect.bottom) {
                    i6 = i4 - (a.bottom - rect.bottom);
                    this.f2557h.setBounds(i, i5, i3, i6);
                }
            } else {
                i5 = i2;
            }
            i6 = i4;
            this.f2557h.setBounds(i, i5, i3, i6);
        }
        if (this.f2552c != null) {
            this.f2552c.getPadding(rect);
            i = thumbOffset - rect.left;
            thumbOffset = (thumbOffset + this.f2540C) + rect.right;
            this.f2552c.setBounds(i, i2, thumbOffset, i4);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.m832a(background, i, i2, thumbOffset, i4);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f2550M;
        Drawable drawable = this.f2557h;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f2542E + rect.top;
        int i2 = this.f2544G - rect.bottom;
        Drawable drawable2 = this.f2552c;
        if (drawable != null) {
            if (!this.f2565p || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = DrawableUtils.m1958a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                int save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f2547J : this.f2548K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.f2546I != null) {
                this.f2545H.setColor(this.f2546I.getColorForState(drawableState, 0));
            }
            this.f2545H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                save = bounds.left + bounds.right;
            } else {
                save = getWidth();
            }
            canvas.translate((float) ((save / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.m2390a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2538A;
        if (!TextUtils.isEmpty(getText())) {
            compoundPaddingLeft += this.f2564o;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.m2390a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2538A;
        if (!TextUtils.isEmpty(getText())) {
            compoundPaddingRight += this.f2564o;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.m2390a(this)) {
            f = 1.0f - this.f2575z;
        } else {
            f = this.f2575z;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f2557h == null) {
            return 0;
        }
        Rect a;
        Rect rect = this.f2550M;
        this.f2557h.getPadding(rect);
        if (this.f2552c != null) {
            a = DrawableUtils.m1958a(this.f2552c);
        } else {
            a = DrawableUtils.f2259a;
        }
        return ((((this.f2538A - this.f2540C) - rect.left) - rect.right) - a.left) - a.right;
    }

    protected int[] onCreateDrawableState(int i) {
        i = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(i, f2536N);
        }
        return i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2552c;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f2557h;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f2552c != null) {
            DrawableCompat.m830a(this.f2552c, f, f2);
        }
        if (this.f2557h != null) {
            DrawableCompat.m830a(this.f2557h, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!(super.verifyDrawable(drawable) || drawable == this.f2552c)) {
            if (drawable != this.f2557h) {
                return null;
            }
        }
        return true;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f2552c != null) {
            this.f2552c.jumpToCurrentState();
        }
        if (this.f2557h != null) {
            this.f2557h.jumpToCurrentState();
        }
        if (this.f2551a != null && this.f2551a.isStarted()) {
            this.f2551a.end();
            this.f2551a = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.f2566q : this.f2567r;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            CharSequence stringBuilder = new StringBuilder();
            stringBuilder.append(text);
            stringBuilder.append(' ');
            stringBuilder.append(charSequence);
            accessibilityNodeInfo.setText(stringBuilder);
        }
    }
}
