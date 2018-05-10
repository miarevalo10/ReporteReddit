package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class ActionMenuView extends LinearLayoutCompat implements ItemInvoker, MenuView {
    MenuBuilder f11861a;
    boolean f11862b;
    ActionMenuPresenter f11863c;
    Callback f11864d;
    OnMenuItemClickListener f11865e;
    private Context f11866f;
    private int f11867g;
    private MenuPresenter.Callback f11868h;
    private boolean f11869i;
    private int f11870j;
    private int f11871k;
    private int f11872l;

    public interface ActionMenuChildView {
        boolean mo3198c();

        boolean mo3199d();
    }

    public interface OnMenuItemClickListener {
        boolean mo734a(MenuItem menuItem);
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public final void mo428a(MenuBuilder menuBuilder, boolean z) {
        }

        public final boolean mo429a(MenuBuilder menuBuilder) {
            return false;
        }

        ActionMenuPresenterCallback() {
        }
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean f11854a;
        @ExportedProperty
        public int f11855b;
        @ExportedProperty
        public int f11856c;
        @ExportedProperty
        public boolean f11857d;
        @ExportedProperty
        public boolean f11858e;
        boolean f11859f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f11854a = layoutParams.f11854a;
        }

        public LayoutParams() {
            super(-2, -2);
            this.f11854a = false;
        }
    }

    private class MenuBuilderCallback implements Callback {
        final /* synthetic */ ActionMenuView f11860a;

        MenuBuilderCallback(ActionMenuView actionMenuView) {
            this.f11860a = actionMenuView;
        }

        public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return (this.f11860a.f11865e == null || this.f11860a.f11865e.mo734a(menuItem) == null) ? null : true;
        }

        public final void mo107a(MenuBuilder menuBuilder) {
            if (this.f11860a.f11864d != null) {
                this.f11860a.f11864d.mo107a(menuBuilder);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return m10552c();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams m44255generateDefaultLayoutParams() {
        return m10552c();
    }

    public /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m10549a(attributeSet);
    }

    protected /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m10550a(layoutParams);
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams m44256generateLayoutParams(AttributeSet attributeSet) {
        return m10549a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams m44257generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m10550a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f11871k = (int) (56.0f * f);
        this.f11872l = (int) (4.0f * f);
        this.f11866f = context;
        this.f11867g = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f11867g != i) {
            this.f11867g = i;
            if (i == 0) {
                this.f11866f = getContext();
                return;
            }
            this.f11866f = new ContextThemeWrapper(getContext(), i);
        }
    }

    public int getPopupTheme() {
        return this.f11867g;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f11863c = actionMenuPresenter;
        this.f11863c.m16886a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f11863c != null) {
            this.f11863c.mo49a(false);
            if (this.f11863c.m16900j() != null) {
                this.f11863c.m16897g();
                this.f11863c.m16896f();
            }
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f11865e = onMenuItemClickListener;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f11869i;
        r0.f11869i = MeasureSpec.getMode(i) == 1073741824;
        if (z != r0.f11869i) {
            r0.f11870j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!r0.f11869i || r0.f11861a == null || size == r0.f11870j)) {
            r0.f11870j = size;
            r0.f11861a.onItemsChanged(true);
        }
        size = getChildCount();
        int i3;
        if (!r0.f11869i || size <= 0) {
            int i4 = i2;
            for (i3 = 0; i3 < size; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        size = MeasureSpec.getMode(i2);
        i3 = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        i3 -= paddingLeft;
        paddingLeft = i3 / r0.f11871k;
        i4 = i3 % r0.f11871k;
        if (paddingLeft == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        int a;
        int max;
        boolean z2;
        int i6;
        int i7;
        int i8;
        float bitCount;
        boolean z3;
        int i9 = r0.f11871k + (i4 / paddingLeft);
        i4 = getChildCount();
        int i10 = 0;
        int i11 = i10;
        int i12 = i11;
        int i13 = i12;
        int i14 = i13;
        int i15 = paddingLeft;
        long j = 0;
        paddingLeft = i14;
        while (paddingLeft < i4) {
            View childAt = getChildAt(paddingLeft);
            if (childAt.getVisibility() != 8) {
                int i16;
                boolean z4;
                boolean z5 = childAt instanceof ActionMenuItemView;
                i13++;
                if (z5) {
                    i5 = size2;
                    i16 = i13;
                    z4 = false;
                    childAt.setPadding(r0.f11872l, 0, r0.f11872l, 0);
                } else {
                    i5 = size2;
                    i16 = i13;
                    z4 = false;
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.f11859f = z4;
                layoutParams2.f11856c = z4;
                layoutParams2.f11855b = z4;
                layoutParams2.f11857d = z4;
                layoutParams2.leftMargin = z4;
                layoutParams2.rightMargin = z4;
                z5 = z5 && ((ActionMenuItemView) childAt).m16817b();
                layoutParams2.f11858e = z5;
                a = m10547a(childAt, i9, layoutParams2.f11854a ? 1 : i15, childMeasureSpec, paddingTop);
                i10 = Math.max(i10, a);
                if (layoutParams2.f11857d) {
                    i14++;
                }
                if (layoutParams2.f11854a) {
                    i12 = 1;
                }
                i15 -= a;
                max = Math.max(i11, childAt.getMeasuredHeight());
                if (a == 1) {
                    j |= (long) (1 << paddingLeft);
                    i13 = i16;
                    i11 = max;
                } else {
                    i11 = max;
                    i13 = i16;
                }
            } else {
                i5 = size2;
            }
            paddingLeft++;
            size2 = i5;
        }
        i5 = size2;
        Object obj = (i12 == 0 || i13 != 2) ? null : 1;
        size2 = i15;
        boolean z6 = false;
        while (i14 > 0 && size2 > 0) {
            a = RedditJobManager.f10810d;
            paddingTop = 0;
            int i17 = 0;
            long j2 = 0;
            while (paddingTop < i4) {
                z2 = z6;
                LayoutParams layoutParams3 = (LayoutParams) getChildAt(paddingTop).getLayoutParams();
                i6 = i11;
                if (layoutParams3.f11857d) {
                    if (layoutParams3.f11855b < a) {
                        a = layoutParams3.f11855b;
                        i7 = size;
                        i8 = i3;
                        j2 = (long) (1 << paddingTop);
                        i17 = 1;
                    } else if (layoutParams3.f11855b == a) {
                        i7 = size;
                        i8 = i3;
                        i17++;
                        j2 |= (long) (1 << paddingTop);
                    }
                    paddingTop++;
                    z6 = z2;
                    i11 = i6;
                    size = i7;
                    i3 = i8;
                }
                i7 = size;
                i8 = i3;
                paddingTop++;
                z6 = z2;
                i11 = i6;
                size = i7;
                i3 = i8;
            }
            i7 = size;
            i8 = i3;
            z2 = z6;
            i6 = i11;
            j |= j2;
            if (i17 > size2) {
                break;
            }
            a++;
            for (size = 0; size < i4; size++) {
                View childAt2 = getChildAt(size);
                layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                long j3 = (long) (1 << size);
                if ((j2 & j3) != 0) {
                    if (obj != null && layoutParams3.f11858e && size2 == 1) {
                        childAt2.setPadding(r0.f11872l + i9, 0, r0.f11872l, 0);
                    }
                    layoutParams3.f11855b++;
                    layoutParams3.f11859f = true;
                    size2--;
                } else if (layoutParams3.f11855b == a) {
                    j |= j3;
                }
            }
            i11 = i6;
            size = i7;
            i3 = i8;
            z6 = true;
        }
        i7 = size;
        i8 = i3;
        z2 = z6;
        i6 = i11;
        long j4 = j;
        LayoutParams layoutParams4;
        if (i12 == 0) {
            a = 1;
            if (i13 == 1) {
                max = 1;
                if (size2 > 0 && j4 != 0 && (size2 < i13 - r4 || max != 0 || i10 > r4)) {
                    bitCount = (float) Long.bitCount(j4);
                    if (max == 0) {
                        if (!((1 & j4) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).f11858e)) {
                            bitCount -= 0.5f;
                        }
                        a = i4 - 1;
                        if (!((((long) (1 << a)) & j4) == 0 || ((LayoutParams) getChildAt(a).getLayoutParams()).f11858e)) {
                            bitCount -= 0.5f;
                        }
                    }
                    a = bitCount <= 0.0f ? (int) (((float) (size2 * i9)) / bitCount) : 0;
                    z3 = z2;
                    for (i10 = 0; i10 < i4; i10++) {
                        if ((((long) (1 << i10)) & j4) == 0) {
                            View childAt3;
                            childAt3 = getChildAt(i10);
                            layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams4.f11856c = a;
                                layoutParams4.f11859f = true;
                                if (i10 != 0 && !layoutParams4.f11858e) {
                                    layoutParams4.leftMargin = (-a) / 2;
                                }
                                z3 = true;
                            } else if (layoutParams4.f11854a) {
                                if (i10 != 0) {
                                    layoutParams4.leftMargin = a / 2;
                                }
                                if (i10 != i4 - 1) {
                                    layoutParams4.rightMargin = a / 2;
                                }
                            } else {
                                layoutParams4.f11856c = a;
                                layoutParams4.f11859f = true;
                                layoutParams4.rightMargin = (-a) / 2;
                                z3 = true;
                            }
                        } else {
                            z6 = true;
                        }
                    }
                    z2 = z3;
                }
                if (z2) {
                    for (size = 0; size < i4; size++) {
                        childAt2 = getChildAt(size);
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (layoutParams.f11859f) {
                            childAt2.measure(MeasureSpec.makeMeasureSpec((layoutParams.f11855b * i9) + layoutParams.f11856c, 1073741824), childMeasureSpec);
                        }
                    }
                }
                setMeasuredDimension(i8, i7 == 1073741824 ? i6 : i5);
            }
        }
        a = 1;
        max = 0;
        bitCount = (float) Long.bitCount(j4);
        if (max == 0) {
            bitCount -= 0.5f;
            a = i4 - 1;
            bitCount -= 0.5f;
        }
        if (bitCount <= 0.0f) {
        }
        z3 = z2;
        for (i10 = 0; i10 < i4; i10++) {
            if ((((long) (1 << i10)) & j4) == 0) {
                z6 = true;
            } else {
                childAt3 = getChildAt(i10);
                layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3 instanceof ActionMenuItemView) {
                    layoutParams4.f11856c = a;
                    layoutParams4.f11859f = true;
                    if (i10 != 0) {
                    }
                    z3 = true;
                } else if (layoutParams4.f11854a) {
                    if (i10 != 0) {
                        layoutParams4.leftMargin = a / 2;
                    }
                    if (i10 != i4 - 1) {
                        layoutParams4.rightMargin = a / 2;
                    }
                } else {
                    layoutParams4.f11856c = a;
                    layoutParams4.f11859f = true;
                    layoutParams4.rightMargin = (-a) / 2;
                    z3 = true;
                }
            }
        }
        z2 = z3;
        if (z2) {
            for (size = 0; size < i4; size++) {
                childAt2 = getChildAt(size);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams.f11859f) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((layoutParams.f11855b * i9) + layoutParams.f11856c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i7 == 1073741824) {
        }
        setMeasuredDimension(i8, i7 == 1073741824 ? i6 : i5);
    }

    static int m10547a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        i4 = (view instanceof ActionMenuItemView) != 0 ? (ActionMenuItemView) view : 0;
        boolean z = false;
        i4 = (i4 == 0 || i4.m16817b() == 0) ? 0 : 1;
        int i5 = 2;
        if (i2 <= 0 || (i4 != 0 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), i3);
            i2 = view.getMeasuredWidth();
            int i6 = i2 / i;
            if (i2 % i != 0) {
                i6++;
            }
            if (i4 == 0 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (layoutParams.f11854a == 0 && i4 != 0) {
            z = true;
        }
        layoutParams.f11857d = z;
        layoutParams.f11855b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i * i5, 1073741824), i3);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f11869i) {
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = i3 - i;
            int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
            boolean a = ViewUtils.m2390a(this);
            int i8 = paddingRight;
            int i9 = 0;
            int i10 = 0;
            for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
                View childAt = getChildAt(paddingRight);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.f11854a) {
                        int paddingLeft;
                        int i11;
                        i9 = childAt.getMeasuredWidth();
                        if (m10551a(paddingRight)) {
                            i9 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                            i11 = paddingLeft + i9;
                        } else {
                            i11 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i11 - i9;
                        }
                        i5 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i5, i11, measuredHeight + i5);
                        i8 -= i9;
                        i9 = 1;
                    } else {
                        i8 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        m10551a(paddingRight);
                        i10++;
                    }
                }
            }
            if (childCount == 1 && i9 == 0) {
                View childAt2 = getChildAt(0);
                dividerWidth = childAt2.getMeasuredWidth();
                paddingRight = childAt2.getMeasuredHeight();
                i7 = (i7 / 2) - (dividerWidth / 2);
                i6 -= paddingRight / 2;
                childAt2.layout(i7, i6, dividerWidth + i7, paddingRight + i6);
                return;
            }
            i10 -= i9 ^ 1;
            if (i10 > 0) {
                i5 = i8 / i10;
                dividerWidth = 0;
            } else {
                dividerWidth = 0;
                i5 = 0;
            }
            i7 = Math.max(dividerWidth, i5);
            View childAt3;
            LayoutParams layoutParams2;
            if (a) {
                paddingRight = getWidth() - getPaddingRight();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (!(childAt3.getVisibility() == 8 || layoutParams2.f11854a)) {
                        paddingRight -= layoutParams2.rightMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        i8 = i6 - (i10 / 2);
                        childAt3.layout(paddingRight - i9, i8, paddingRight, i10 + i8);
                        paddingRight -= (i9 + layoutParams2.leftMargin) + i7;
                    }
                    dividerWidth++;
                }
                return;
            }
            paddingRight = getPaddingLeft();
            while (dividerWidth < childCount) {
                childAt3 = getChildAt(dividerWidth);
                layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (!(childAt3.getVisibility() == 8 || layoutParams2.f11854a)) {
                    paddingRight += layoutParams2.leftMargin;
                    i9 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    i8 = i6 - (i10 / 2);
                    childAt3.layout(paddingRight, i8, paddingRight + i9, i10 + i8);
                    paddingRight += (i9 + layoutParams2.rightMargin) + i7;
                }
                dividerWidth++;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m10556b();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f11863c;
        if (actionMenuPresenter.f16665i != null) {
            actionMenuPresenter.f16665i.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.f16667k = true;
        actionMenuPresenter.f16666j = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f11863c;
        if (actionMenuPresenter.f16665i != null) {
            return actionMenuPresenter.f16665i.getDrawable();
        }
        return actionMenuPresenter.f16667k ? actionMenuPresenter.f16666j : null;
    }

    public void setOverflowReserved(boolean z) {
        this.f11862b = z;
    }

    private static LayoutParams m10552c() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.h = 16;
        return layoutParams;
    }

    private LayoutParams m10549a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams m10550a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m10552c();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.h <= null) {
            layoutParams2.h = 16;
        }
        return layoutParams2;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams == null || (layoutParams instanceof LayoutParams) == null) ? null : true;
    }

    public static LayoutParams m10548a() {
        LayoutParams c = m10552c();
        c.f11854a = true;
        return c;
    }

    public final boolean mo537a(MenuItemImpl menuItemImpl) {
        return this.f11861a.performItemAction(menuItemImpl, 0);
    }

    public final void mo536a(MenuBuilder menuBuilder) {
        this.f11861a = menuBuilder;
    }

    public Menu getMenu() {
        if (this.f11861a == null) {
            Context context = getContext();
            this.f11861a = new MenuBuilder(context);
            this.f11861a.setCallback(new MenuBuilderCallback(this));
            this.f11863c = new ActionMenuPresenter(context);
            this.f11863c.m16895e();
            this.f11863c.f11722f = this.f11868h != null ? this.f11868h : new ActionMenuPresenterCallback();
            this.f11861a.addMenuPresenter(this.f11863c, this.f11866f);
            this.f11863c.m16886a(this);
        }
        return this.f11861a;
    }

    public final void m10554a(MenuPresenter.Callback callback, Callback callback2) {
        this.f11868h = callback;
        this.f11864d = callback2;
    }

    public final void m10556b() {
        if (this.f11863c != null) {
            this.f11863c.m16898h();
        }
    }

    private boolean m10551a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = 0 | ((ActionMenuChildView) childAt).mo3199d();
        }
        if (i > 0 && (childAt2 instanceof ActionMenuChildView) != 0) {
            z |= ((ActionMenuChildView) childAt2).mo3198c();
        }
        return z;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f11863c.f16668l = z;
    }
}
