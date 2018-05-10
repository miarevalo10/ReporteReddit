package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements SubUiVisibilityListener {
    private final SparseBooleanArray f16662A = new SparseBooleanArray();
    private View f16663B;
    private ActionMenuPopupCallback f16664C;
    OverflowMenuButton f16665i;
    Drawable f16666j;
    boolean f16667k;
    boolean f16668l;
    OverflowPopup f16669m;
    ActionButtonSubmenu f16670n;
    OpenOverflowRunnable f16671o;
    final PopupPresenterCallback f16672p = new PopupPresenterCallback(this);
    int f16673q;
    private boolean f16674r;
    private boolean f16675s;
    private int f16676t;
    private int f16677u;
    private int f16678v;
    private boolean f16679w;
    private boolean f16680x;
    private boolean f16681y;
    private int f16682z;

    private class OpenOverflowRunnable implements Runnable {
        final /* synthetic */ ActionMenuPresenter f2074a;
        private OverflowPopup f2075b;

        public OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, OverflowPopup overflowPopup) {
            this.f2074a = actionMenuPresenter;
            this.f2075b = overflowPopup;
        }

        public void run() {
            if (this.f2074a.c != null) {
                this.f2074a.c.changeMenuMode();
            }
            View view = (View) this.f2074a.g;
            if (!(view == null || view.getWindowToken() == null || !this.f2075b.m1719c())) {
                this.f2074a.f16669m = this.f2075b;
            }
            this.f2074a.f16671o = null;
        }
    }

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C01941();
        public int f2076a;

        static class C01941 implements Creator<SavedState> {
            C01941() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2076a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2076a);
        }
    }

    private class ActionButtonSubmenu extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter f11848d;

        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, SubMenuBuilder subMenuBuilder, View view) {
            this.f11848d = actionMenuPresenter;
            super(context, subMenuBuilder, view, false, C0164R.attr.actionOverflowMenuStyle);
            if (((MenuItemImpl) subMenuBuilder.getItem()).m10489f() == null) {
                this.f2036a = actionMenuPresenter.f16665i == null ? (View) actionMenuPresenter.g : actionMenuPresenter.f16665i;
            }
            m1716a((Callback) actionMenuPresenter.f16672p);
        }

        protected final void mo567e() {
            this.f11848d.f16670n = null;
            this.f11848d.f16673q = 0;
            super.mo567e();
        }
    }

    private class ActionMenuPopupCallback extends PopupCallback {
        final /* synthetic */ ActionMenuPresenter f11849a;

        ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
            this.f11849a = actionMenuPresenter;
        }

        public final ShowableListMenu mo568a() {
            return this.f11849a.f16670n != null ? this.f11849a.f16670n.m1718b() : null;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter f11852d;

        public OverflowPopup(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view) {
            this.f11852d = actionMenuPresenter;
            super(context, menuBuilder, view, true, C0164R.attr.actionOverflowMenuStyle);
            m1716a((Callback) actionMenuPresenter.f16672p);
        }

        protected final void mo567e() {
            if (this.f11852d.c != null) {
                this.f11852d.c.close();
            }
            this.f11852d.f16669m = null;
            super.mo567e();
        }
    }

    private class PopupPresenterCallback implements Callback {
        final /* synthetic */ ActionMenuPresenter f11853a;

        PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
            this.f11853a = actionMenuPresenter;
        }

        public final boolean mo429a(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            this.f11853a.f16673q = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            Callback callback = this.f11853a.f11722f;
            if (callback != null) {
                return callback.mo429a(menuBuilder);
            }
            return false;
        }

        public final void mo428a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            Callback callback = this.f11853a.f11722f;
            if (callback != null) {
                callback.mo428a(menuBuilder, z);
            }
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter f16660a;
        private final float[] f16661b = new float[2];

        public final boolean mo3198c() {
            return false;
        }

        public final boolean mo3199d() {
            return false;
        }

        public OverflowMenuButton(final ActionMenuPresenter actionMenuPresenter, Context context) {
            this.f16660a = actionMenuPresenter;
            super(context, null, C0164R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.m2349a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, this) {
                final /* synthetic */ OverflowMenuButton f11851b;

                public final ShowableListMenu mo532a() {
                    if (this.f11851b.f16660a.f16669m == null) {
                        return null;
                    }
                    return this.f11851b.f16660a.f16669m.m1718b();
                }

                public final boolean mo533b() {
                    this.f11851b.f16660a.m16896f();
                    return true;
                }

                public final boolean mo569c() {
                    if (this.f11851b.f16660a.f16671o != null) {
                        return false;
                    }
                    this.f11851b.f16660a.m16897g();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            this.f16660a.m16896f();
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            i = super.setFrame(i, i2, i3, i4);
            i2 = getDrawable();
            Drawable background = getBackground();
            if (!(i2 == 0 || background == 0)) {
                i2 = getWidth();
                i4 = getHeight();
                int max = Math.max(i2, i4) / 2;
                i2 = (i2 + (getPaddingLeft() - getPaddingRight())) / 2;
                i4 = (i4 + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.m832a(background, i2 - max, i4 - max, i2 + max, i4 + max);
            }
            return i;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0164R.layout.abc_action_menu_layout, C0164R.layout.abc_action_menu_item_layout);
    }

    public final void mo45a(Context context, MenuBuilder menuBuilder) {
        super.mo45a(context, menuBuilder);
        menuBuilder = context.getResources();
        context = ActionBarPolicy.m1671a(context);
        if (!this.f16675s) {
            boolean z = true;
            if (VERSION.SDK_INT < 19) {
                if (ViewConfiguration.get(context.f1959a).hasPermanentMenuKey()) {
                    z = false;
                }
            }
            this.f16674r = z;
        }
        if (!this.f16681y) {
            this.f16676t = context.f1959a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.f16679w) {
            this.f16678v = context.m1672a();
        }
        context = this.f16676t;
        if (this.f16674r) {
            if (this.f16665i == null) {
                this.f16665i = new OverflowMenuButton(this, this.a);
                if (this.f16667k) {
                    this.f16665i.setImageDrawable(this.f16666j);
                    this.f16666j = null;
                    this.f16667k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f16665i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            context -= this.f16665i.getMeasuredWidth();
        } else {
            this.f16665i = null;
        }
        this.f16677u = context;
        this.f16682z = (int) (1113587712 * menuBuilder.getDisplayMetrics().density);
        this.f16663B = null;
    }

    public final void m16894d() {
        if (!this.f16679w) {
            this.f16678v = ActionBarPolicy.m1671a(this.b).m1672a();
        }
        if (this.c != null) {
            this.c.onItemsChanged(true);
        }
    }

    public final void m16895e() {
        this.f16674r = true;
        this.f16675s = true;
    }

    public final MenuView mo3223a(ViewGroup viewGroup) {
        MenuView menuView = this.g;
        MenuView a = super.mo3223a(viewGroup);
        if (menuView != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    public final View mo3224a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m10492i()) {
            actionView = super.mo3224a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() != null ? 8 : null);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (actionMenuView.checkLayoutParams(layoutParams) == null) {
            actionView.setLayoutParams(ActionMenuView.m10550a(layoutParams));
        }
        return actionView;
    }

    public final void mo3225a(MenuItemImpl menuItemImpl, ItemView itemView) {
        itemView.mo538a(menuItemImpl);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.g);
        if (this.f16664C == null) {
            this.f16664C = new ActionMenuPopupCallback(this);
        }
        actionMenuItemView.setPopupCallback(this.f16664C);
    }

    public final boolean mo3228c(MenuItemImpl menuItemImpl) {
        return menuItemImpl.m10489f();
    }

    public final void mo49a(boolean z) {
        int size;
        super.mo49a(z);
        ((View) this.g).requestLayout();
        int i = 0;
        if (this.c) {
            z = this.c.getActionItems();
            size = z.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActionProvider actionProvider = ((MenuItemImpl) z.get(i2)).f11780d;
                if (actionProvider != null) {
                    actionProvider.f1433a = this;
                }
            }
        }
        z = this.c ? this.c.getNonActionItems() : false;
        if (this.f16674r && z) {
            size = z.size();
            if (size == 1) {
                i = ((MenuItemImpl) z.get(0)).isActionViewExpanded() ^ 1;
            } else if (size > 0) {
                i = 1;
            }
        }
        if (i != 0) {
            if (!this.f16665i) {
                this.f16665i = new OverflowMenuButton(this, this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f16665i.getParent();
            if (viewGroup != this.g) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f16665i);
                }
                ((ActionMenuView) this.g).addView(this.f16665i, ActionMenuView.m10548a());
            }
        } else if (this.f16665i && this.f16665i.getParent() == this.g) {
            ((ViewGroup) this.g).removeView(this.f16665i);
        }
        ((ActionMenuView) this.g).setOverflowReserved(this.f16674r);
    }

    public final boolean mo3226a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f16665i) {
            return null;
        }
        return super.mo3226a(viewGroup, i);
    }

    public final boolean mo52a(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        View childAt;
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.f16658a != this.c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.f16658a;
        }
        MenuItemImpl item = subMenuBuilder2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.g;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ItemView) && ((ItemView) childAt).getItemData() == item) {
                    break;
                }
            }
        }
        childAt = null;
        if (childAt == null) {
            return false;
        }
        this.f16673q = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item2 = subMenuBuilder.getItem(i2);
            if (item2.isVisible() && item2.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.f16670n = new ActionButtonSubmenu(this, this.b, subMenuBuilder, childAt);
        this.f16670n.m1717a(z);
        this.f16670n.m1714a();
        super.mo52a(subMenuBuilder);
        return true;
    }

    public final boolean m16896f() {
        if (!this.f16674r || m16900j() || this.c == null || this.g == null || this.f16671o != null || this.c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.f16671o = new OpenOverflowRunnable(this, new OverflowPopup(this, this.b, this.c, this.f16665i));
        ((View) this.g).post(this.f16671o);
        super.mo52a(null);
        return true;
    }

    public final boolean m16897g() {
        if (this.f16671o == null || this.g == null) {
            MenuPopupHelper menuPopupHelper = this.f16669m;
            if (menuPopupHelper == null) {
                return false;
            }
            menuPopupHelper.m1720d();
            return true;
        }
        ((View) this.g).removeCallbacks(this.f16671o);
        this.f16671o = null;
        return true;
    }

    public final boolean m16898h() {
        return m16897g() | m16899i();
    }

    public final boolean m16899i() {
        if (this.f16670n == null) {
            return false;
        }
        this.f16670n.m1720d();
        return true;
    }

    public final boolean m16900j() {
        return this.f16669m != null && this.f16669m.m1722f();
    }

    public final boolean mo50a() {
        ArrayList visibleItems;
        ActionMenuPresenter actionMenuPresenter;
        int size;
        boolean z = false;
        if (this.c != null) {
            visibleItems = actionMenuPresenter.c.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i = actionMenuPresenter.f16678v;
        int i2 = actionMenuPresenter.f16677u;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.g;
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        int i6 = i;
        for (i = i5; i < size; i++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) visibleItems.get(i);
            if (menuItemImpl.m10491h()) {
                i3++;
            } else if (menuItemImpl.m10490g()) {
                i5++;
            } else {
                i4 = 1;
            }
            if (actionMenuPresenter.f16668l && menuItemImpl.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (actionMenuPresenter.f16674r && (r9 != 0 || i5 + i3 > i6)) {
            i6--;
        }
        i6 -= i3;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f16662A;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f16680x) {
            i3 = i2 / actionMenuPresenter.f16682z;
            i4 = ((i2 % actionMenuPresenter.f16682z) / i3) + actionMenuPresenter.f16682z;
        } else {
            i3 = 0;
            i4 = i3;
        }
        int i7 = 0;
        i5 = i2;
        i2 = i7;
        while (i2 < size) {
            boolean z2;
            int i8;
            MenuItemImpl menuItemImpl2 = (MenuItemImpl) visibleItems.get(i2);
            int measuredWidth;
            boolean z3;
            if (menuItemImpl2.m10491h()) {
                View a = actionMenuPresenter.mo3224a(menuItemImpl2, actionMenuPresenter.f16663B, viewGroup);
                if (actionMenuPresenter.f16663B == null) {
                    actionMenuPresenter.f16663B = a;
                }
                if (actionMenuPresenter.f16680x) {
                    i3 -= ActionMenuView.m10547a(a, i4, i3, makeMeasureSpec, z);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                measuredWidth = a.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i7 == 0) {
                    i7 = measuredWidth;
                }
                measuredWidth = menuItemImpl2.getGroupId();
                if (measuredWidth != 0) {
                    z3 = true;
                    sparseBooleanArray.put(measuredWidth, true);
                } else {
                    z3 = true;
                }
                menuItemImpl2.m10485d(z3);
                z2 = z;
                i8 = size;
            } else if (menuItemImpl2.m10490g()) {
                measuredWidth = menuItemImpl2.getGroupId();
                z3 = sparseBooleanArray.get(measuredWidth);
                z = (i6 > 0 || z3) && i5 > 0 && (!actionMenuPresenter.f16680x || i3 > 0);
                if (z) {
                    int i9 = z;
                    View a2 = actionMenuPresenter.mo3224a(menuItemImpl2, actionMenuPresenter.f16663B, viewGroup);
                    i8 = size;
                    if (actionMenuPresenter.f16663B == null) {
                        actionMenuPresenter.f16663B = a2;
                    }
                    if (actionMenuPresenter.f16680x) {
                        int a3 = ActionMenuView.m10547a(a2, i4, i3, makeMeasureSpec, 0);
                        i3 -= a3;
                        if (a3 == 0) {
                            i9 = 0;
                        }
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i7 == 0) {
                        i7 = measuredWidth2;
                    }
                    if (actionMenuPresenter.f16680x) {
                        z = i9 & (i5 >= 0 ? 1 : 0);
                    } else {
                        z = i9 & (i5 + i7 > 0 ? 1 : 0);
                    }
                } else {
                    boolean z4 = z;
                    i8 = size;
                }
                if (z && measuredWidth != 0) {
                    sparseBooleanArray.put(measuredWidth, true);
                } else if (z3) {
                    sparseBooleanArray.put(measuredWidth, false);
                    size = 0;
                    while (size < i2) {
                        MenuItemImpl menuItemImpl3 = (MenuItemImpl) visibleItems.get(size);
                        if (menuItemImpl3.getGroupId() == measuredWidth) {
                            if (menuItemImpl3.m10489f()) {
                                i6++;
                            }
                            menuItemImpl3.m10485d(false);
                        }
                        size++;
                        actionMenuPresenter = this;
                    }
                }
                if (z) {
                    i6--;
                }
                menuItemImpl2.m10485d(z);
                z2 = false;
            } else {
                z2 = z;
                i8 = size;
                menuItemImpl2.m10485d(z2);
            }
            i2++;
            z = z2;
            size = i8;
            actionMenuPresenter = this;
        }
        return true;
    }

    public final void mo47a(MenuBuilder menuBuilder, boolean z) {
        m16898h();
        super.mo47a(menuBuilder, z);
    }

    public final Parcelable mo55c() {
        Parcelable savedState = new SavedState();
        savedState.f2076a = this.f16673q;
        return savedState;
    }

    public final void mo46a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f2076a > 0) {
                parcelable = this.c.findItem(savedState.f2076a);
                if (parcelable != null) {
                    mo52a((SubMenuBuilder) parcelable.getSubMenu());
                }
            }
        }
    }

    public final void mo3227b(boolean z) {
        if (z) {
            super.mo52a((SubMenuBuilder) false);
            return;
        }
        if (this.c) {
            this.c.close(false);
        }
    }

    public final void m16886a(ActionMenuView actionMenuView) {
        this.g = actionMenuView;
        actionMenuView.f11861a = this.c;
    }
}
