package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView {
    private static final int[] f2328h = new int[]{0};
    final Rect f2329a = new Rect();
    int f2330b = 0;
    int f2331c = 0;
    int f2332d = 0;
    int f2333e = 0;
    protected int f2334f;
    Field f2335g;
    private GateKeeperDrawable f2336i;

    private static class GateKeeperDrawable extends DrawableWrapper {
        boolean f12033a = true;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        public boolean setState(int[] iArr) {
            return this.f12033a ? super.setState(iArr) : null;
        }

        public void draw(Canvas canvas) {
            if (this.f12033a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f12033a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f12033a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.f12033a ? super.setVisible(z, z2) : false;
        }
    }

    protected boolean mo615a() {
        return false;
    }

    public ListViewCompat(Context context, int i) {
        super(context, null, i);
        try {
            this.f2335g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2335g.setAccessible(1);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f2336i = drawable != null ? new GateKeeperDrawable(drawable) : null;
        super.setSelector(this.f2336i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2330b = rect.left;
        this.f2331c = rect.top;
        this.f2332d = rect.right;
        this.f2333e = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        boolean z = true;
        setSelectorEnabled(true);
        Drawable selector = getSelector();
        if (selector != null) {
            if (!mo615a() || !isPressed()) {
                z = false;
            }
            if (z) {
                selector.setState(getDrawableState());
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2334f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    public final int m1980a(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingTop += listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i3 = listPaddingTop;
        listPaddingTop = 0;
        int i4 = listPaddingTop;
        View view = null;
        while (listPaddingTop < count) {
            int itemViewType = adapter.getItemViewType(listPaddingTop);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = adapter.getView(listPaddingTop, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                itemViewType = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                itemViewType = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, itemViewType);
            view.forceLayout();
            if (listPaddingTop > 0) {
                i3 += dividerHeight;
            }
            i3 += view.getMeasuredHeight();
            if (i3 >= i2) {
                return i2;
            }
            listPaddingTop++;
        }
        return i3;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2336i != null) {
            this.f2336i.f12033a = z;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f2329a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2329a);
                selector.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }
}
