package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue f2212a;
    public final Rect f2213b;
    private TypedValue f2214c;
    private TypedValue f2215d;
    private TypedValue f2216e;
    private TypedValue f2217f;
    private TypedValue f2218g;
    private OnAttachListener f2219h;

    public interface OnAttachListener {
        void mo427a();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2213b = new Rect();
    }

    public final void m1914a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f2219h = onAttachListener;
    }

    protected void onMeasure(int i, int i2) {
        int dimension;
        TypedValue typedValue;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj = 1;
        Object obj2 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = obj2 != null ? this.f2216e : this.f2215d;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                dimension = typedValue2.type == 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type == 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                if (dimension > 0) {
                    dimension = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f2213b.left + this.f2213b.right), MeasureSpec.getSize(i)), 1073741824);
                    i = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        typedValue = obj2 == null ? this.f2217f : this.f2218g;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            mode2 = typedValue.type != 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type != 6 ? (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels) : 0;
                            if (mode2 > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (this.f2213b.top + this.f2213b.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(dimension, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (i == 0 && mode == Integer.MIN_VALUE) {
                        i = obj2 == null ? this.f2214c : this.f2212a;
                        if (!(i == 0 || i.type == 0)) {
                            i = i.type != 5 ? (int) i.getDimension(displayMetrics) : i.type != 6 ? (int) i.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (i > 0) {
                                i -= this.f2213b.left + this.f2213b.right;
                            }
                            if (mode2 < i) {
                                dimension = MeasureSpec.makeMeasureSpec(i, 1073741824);
                                if (obj == null) {
                                    super.onMeasure(dimension, i2);
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        super.onMeasure(dimension, i2);
                    }
                }
            }
        }
        dimension = i;
        i = 0;
        if (mode2 == Integer.MIN_VALUE) {
            if (obj2 == null) {
            }
            if (typedValue.type != 5) {
                if (typedValue.type != 6) {
                }
            }
            if (mode2 > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (this.f2213b.top + this.f2213b.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(dimension, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj2 == null) {
        }
        if (i.type != 5) {
            if (i.type != 6) {
            }
        }
        if (i > 0) {
            i -= this.f2213b.left + this.f2213b.right;
        }
        if (mode2 < i) {
            dimension = MeasureSpec.makeMeasureSpec(i, 1073741824);
            if (obj == null) {
                super.onMeasure(dimension, i2);
            }
        }
        obj = null;
        if (obj == null) {
            super.onMeasure(dimension, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2212a == null) {
            this.f2212a = new TypedValue();
        }
        return this.f2212a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2214c == null) {
            this.f2214c = new TypedValue();
        }
        return this.f2214c;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2215d == null) {
            this.f2215d = new TypedValue();
        }
        return this.f2215d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2216e == null) {
            this.f2216e = new TypedValue();
        }
        return this.f2216e;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2217f == null) {
            this.f2217f = new TypedValue();
        }
        return this.f2217f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2218g == null) {
            this.f2218g = new TypedValue();
        }
        return this.f2218g;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2219h != null) {
            this.f2219h.mo427a();
        }
    }
}
