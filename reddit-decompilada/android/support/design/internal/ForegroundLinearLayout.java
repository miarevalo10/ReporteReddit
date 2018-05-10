package android.support.design.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.design.C0016R;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    protected boolean f10999a;
    boolean f11000b;
    private Drawable f11001c;
    private final Rect f11002d;
    private final Rect f11003e;
    private int f11004f;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11002d = new Rect();
        this.f11003e = new Rect();
        this.f11004f = 119;
        this.f10999a = true;
        this.f11000b = false;
        context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.ForegroundLinearLayout, i, 0);
        this.f11004f = context.getInt(C0016R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f11004f);
        attributeSet = context.getDrawable(C0016R.styleable.ForegroundLinearLayout_android_foreground);
        if (attributeSet != null) {
            setForeground(attributeSet);
        }
        this.f10999a = context.getBoolean(C0016R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        context.recycle();
    }

    public int getForegroundGravity() {
        return this.f11004f;
    }

    public void setForegroundGravity(int i) {
        if (this.f11004f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f11004f = i;
            if (this.f11004f == 119 && this.f11001c != 0) {
                this.f11001c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.f11001c) {
                return null;
            }
        }
        return true;
    }

    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f11001c != null) {
            this.f11001c.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11001c != null && this.f11001c.isStateful()) {
            this.f11001c.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.f11001c != drawable) {
            if (this.f11001c != null) {
                this.f11001c.setCallback(null);
                unscheduleDrawable(this.f11001c);
            }
            this.f11001c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f11004f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.f11001c;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f11000b = z | this.f11000b;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11000b = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f11001c != null) {
            Drawable drawable = this.f11001c;
            if (this.f11000b) {
                this.f11000b = false;
                Rect rect = this.f11002d;
                Rect rect2 = this.f11003e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f10999a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f11004f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @RequiresApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f11001c != null) {
            this.f11001c.setHotspot(f, f2);
        }
    }
}
