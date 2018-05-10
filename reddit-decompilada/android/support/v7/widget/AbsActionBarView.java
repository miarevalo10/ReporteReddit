package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class AbsActionBarView extends ViewGroup {
    protected final VisibilityAnimListener f2050a;
    protected final Context f2051b;
    protected ActionMenuView f2052c;
    protected ActionMenuPresenter f2053d;
    protected int f2054e;
    protected ViewPropertyAnimatorCompat f2055f;
    private boolean f2056g;
    private boolean f2057h;

    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        int f11805a;
        final /* synthetic */ AbsActionBarView f11806b;
        private boolean f11807c = null;

        protected VisibilityAnimListener(AbsActionBarView absActionBarView) {
            this.f11806b = absActionBarView;
        }

        public final VisibilityAnimListener m10513a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.f11806b.f2055f = viewPropertyAnimatorCompat;
            this.f11805a = i;
            return this;
        }

        public final void mo377a(View view) {
            super.setVisibility(0);
            this.f11807c = null;
        }

        public final void mo378b(View view) {
            if (this.f11807c == null) {
                this.f11806b.f2055f = null;
                super.setVisibility(this.f11805a);
            }
        }

        public final void mo379c(View view) {
            this.f11807c = true;
        }
    }

    protected static int m1746a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2050a = new VisibilityAnimListener(this);
        attributeSet = new TypedValue();
        if (context.getTheme().resolveAttribute(C0164R.attr.actionBarPopupTheme, attributeSet, true) == 0 || attributeSet.resourceId == 0) {
            this.f2051b = context;
        } else {
            this.f2051b = new ContextThemeWrapper(context, attributeSet.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = getContext().obtainStyledAttributes(null, C0164R.styleable.ActionBar, C0164R.attr.actionBarStyle, 0);
        setContentHeight(configuration.getLayoutDimension(C0164R.styleable.ActionBar_height, 0));
        configuration.recycle();
        if (this.f2053d != null) {
            this.f2053d.m16894d();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2056g = false;
        }
        if (!this.f2056g) {
            motionEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && motionEvent == null) {
                this.f2056g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2056g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2057h = false;
        }
        if (!this.f2057h) {
            motionEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && motionEvent == null) {
                this.f2057h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2057h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f2054e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f2054e;
    }

    public int getAnimatedVisibility() {
        if (this.f2055f != null) {
            return this.f2050a.f11805a;
        }
        return getVisibility();
    }

    public ViewPropertyAnimatorCompat mo548a(int i, long j) {
        if (this.f2055f != null) {
            this.f2055f.m1296a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat a = ViewCompat.m1254o(this).m1291a(1.0f);
            a.m1292a(j);
            a.m1293a(this.f2050a.m10513a(a, i));
            return a;
        }
        a = ViewCompat.m1254o(this).m1291a(0.0f);
        a.m1292a(j);
        a.m1293a(this.f2050a.m10513a(a, i));
        return a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f2055f != null) {
                this.f2055f.m1296a();
            }
            super.setVisibility(i);
        }
    }

    public boolean mo549a() {
        return this.f2053d != null ? this.f2053d.m16896f() : false;
    }

    protected static int m1747a(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - 0);
    }

    protected static int m1748a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        i2 += (i3 - measuredHeight) / 2;
        if (z) {
            view.layout(i - measuredWidth, i2, i, measuredHeight + i2);
        } else {
            view.layout(i, i2, i + measuredWidth, measuredHeight + i2);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
