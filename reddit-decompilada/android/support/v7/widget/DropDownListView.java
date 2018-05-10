package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.C0164R;
import android.view.MotionEvent;
import android.view.View;

class DropDownListView extends ListViewCompat {
    private boolean f11931h;
    private boolean f11932i;
    private boolean f11933j;
    private ViewPropertyAnimatorCompat f11934k;
    private ListViewAutoScrollHelper f11935l;

    public DropDownListView(Context context, boolean z) {
        super(context, C0164R.attr.dropDownListViewStyle);
        this.f11932i = z;
        setCacheColorHint(null);
    }

    public boolean mo3247a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        View view = this;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = false;
        switch (actionMasked) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z2 = false;
                break;
            default:
                z3 = true;
                z2 = false;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        View childAt;
        if (findPointerIndex < 0) {
            z2 = false;
            if (!z3 || r3) {
                view.f11933j = false;
                setPressed(false);
                drawableStateChanged();
                childAt = getChildAt(view.f - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                if (view.f11934k != null) {
                    view.f11934k.m1296a();
                    view.f11934k = null;
                }
            }
            if (!z3) {
                if (view.f11935l == null) {
                    view.f11935l = new ListViewAutoScrollHelper(view);
                }
                view.f11935l.m1343a(true);
                view.f11935l.onTouch(view, motionEvent2);
            } else if (view.f11935l != null) {
                view.f11935l.m1343a(false);
            }
            return z3;
        }
        int x = (int) motionEvent2.getX(findPointerIndex);
        findPointerIndex = (int) motionEvent2.getY(findPointerIndex);
        int pointToPosition = pointToPosition(x, findPointerIndex);
        if (pointToPosition == -1) {
            z2 = true;
            z3 = z;
            view.f11933j = false;
            setPressed(false);
            drawableStateChanged();
            childAt = getChildAt(view.f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (view.f11934k != null) {
                view.f11934k.m1296a();
                view.f11934k = null;
            }
            if (!z3) {
                if (view.f11935l == null) {
                    view.f11935l = new ListViewAutoScrollHelper(view);
                }
                view.f11935l.m1343a(true);
                view.f11935l.onTouch(view, motionEvent2);
            } else if (view.f11935l != null) {
                view.f11935l.m1343a(false);
            }
            return z3;
        }
        boolean z4;
        childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
        float f = (float) x;
        float f2 = (float) findPointerIndex;
        view.f11933j = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (view.f != -1) {
            View childAt2 = getChildAt(view.f - getFirstVisiblePosition());
            if (!(childAt2 == null || childAt2 == childAt || !childAt2.isPressed())) {
                childAt2.setPressed(false);
            }
        }
        view.f = pointToPosition;
        float left = f - ((float) childAt.getLeft());
        float top = f2 - ((float) childAt.getTop());
        if (VERSION.SDK_INT >= 21) {
            childAt.drawableHotspotChanged(left, top);
        }
        if (!childAt.isPressed()) {
            childAt.setPressed(true);
        }
        Drawable selector = getSelector();
        boolean z5 = (selector == null || pointToPosition == -1) ? false : true;
        if (z5) {
            selector.setVisible(false, false);
        }
        Rect rect = view.f2329a;
        rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        rect.left -= view.f2330b;
        rect.top -= view.f2331c;
        rect.right += view.f2332d;
        rect.bottom += view.f2333e;
        try {
            z3 = view.f2335g.getBoolean(view);
            if (childAt.isEnabled() != z3) {
                view.f2335g.set(view, Boolean.valueOf(z3 ^ true));
                if (pointToPosition != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (z5) {
            Rect rect2 = view.f2329a;
            float exactCenterX = rect2.exactCenterX();
            float exactCenterY = rect2.exactCenterY();
            z4 = false;
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.m830a(selector, exactCenterX, exactCenterY);
        } else {
            z4 = false;
        }
        Drawable selector2 = getSelector();
        if (!(selector2 == null || pointToPosition == -1)) {
            DrawableCompat.m830a(selector2, f, f2);
        }
        setSelectorEnabled(z4);
        refreshDrawableState();
        if (actionMasked == 1) {
            performItemClick(childAt, pointToPosition, getItemIdAtPosition(pointToPosition));
        }
        z3 = true;
        z2 = false;
        view.f11933j = false;
        setPressed(false);
        drawableStateChanged();
        childAt = getChildAt(view.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (view.f11934k != null) {
            view.f11934k.m1296a();
            view.f11934k = null;
        }
        if (!z3) {
            if (view.f11935l == null) {
                view.f11935l = new ListViewAutoScrollHelper(view);
            }
            view.f11935l.m1343a(true);
            view.f11935l.onTouch(view, motionEvent2);
        } else if (view.f11935l != null) {
            view.f11935l.m1343a(false);
        }
        return z3;
    }

    void setListSelectionHidden(boolean z) {
        this.f11931h = z;
    }

    protected final boolean mo615a() {
        if (!this.f11933j) {
            if (!super.mo615a()) {
                return false;
            }
        }
        return true;
    }

    public boolean isInTouchMode() {
        return (this.f11932i && this.f11931h) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        if (!this.f11932i) {
            if (!super.hasWindowFocus()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFocused() {
        if (!this.f11932i) {
            if (!super.isFocused()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFocus() {
        if (!this.f11932i) {
            if (!super.hasFocus()) {
                return false;
            }
        }
        return true;
    }
}
