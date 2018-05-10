package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f2676a;
    private int f2677b;
    private WeakReference<View> f2678c;
    private LayoutInflater f2679d;
    private OnInflateListener f2680e;

    public interface OnInflateListener {
    }

    protected final void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2676a = 0;
        context = context.obtainStyledAttributes(attributeSet, C0164R.styleable.ViewStubCompat, i, 0);
        this.f2677b = context.getResourceId(C0164R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f2676a = context.getResourceId(C0164R.styleable.ViewStubCompat_android_layout, 0);
        setId(context.getResourceId(C0164R.styleable.ViewStubCompat_android_id, -1));
        context.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final int getInflatedId() {
        return this.f2677b;
    }

    public final void setInflatedId(int i) {
        this.f2677b = i;
    }

    public final int getLayoutResource() {
        return this.f2676a;
    }

    public final void setLayoutResource(int i) {
        this.f2676a = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2679d = layoutInflater;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.f2679d;
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void setVisibility(int i) {
        if (this.f2678c != null) {
            View view = (View) this.f2678c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m2388a();
        }
    }

    public final View m2388a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2676a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f2679d != null) {
                layoutInflater = this.f2679d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f2676a, viewGroup, false);
            if (this.f2677b != -1) {
                inflate.setId(this.f2677b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2678c = new WeakReference(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public final void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f2680e = onInflateListener;
    }
}
