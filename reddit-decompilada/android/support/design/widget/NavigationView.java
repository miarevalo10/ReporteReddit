package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C0016R;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] f11092e = new int[]{16842912};
    private static final int[] f11093f = new int[]{-16842910};
    public final NavigationMenuPresenter f11094c;
    OnNavigationItemSelectedListener f11095d;
    private final NavigationMenu f11096g;
    private int f11097h;
    private MenuInflater f11098i;

    public interface OnNavigationItemSelectedListener {
        boolean m274a(MenuItem menuItem);
    }

    class C09861 implements Callback {
        final /* synthetic */ NavigationView f11091a;

        public final void mo107a(MenuBuilder menuBuilder) {
        }

        C09861(NavigationView navigationView) {
            this.f11091a = navigationView;
        }

        public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f11091a.f11095d == null) {
                return null;
            }
            this.f11091a.f11095d.m274a(menuItem);
            return true;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C00351();
        public Bundle menuState;

        static class C00351 implements ClassLoaderCreator<SavedState> {
            C00351() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList e;
        int g;
        int i2;
        super(context, attributeSet, i);
        this.f11094c = new NavigationMenuPresenter();
        ThemeUtils.m333a(context);
        this.f11096g = new NavigationMenu(context);
        attributeSet = TintTypedArray.m2308a(context, attributeSet, C0016R.styleable.NavigationView, i, C0016R.style.Widget_Design_NavigationView);
        ViewCompat.m1219a((View) this, attributeSet.m2311a(C0016R.styleable.NavigationView_android_background));
        if (attributeSet.m2322f(C0016R.styleable.NavigationView_elevation) != 0) {
            ViewCompat.m1243f(this, (float) attributeSet.m2319e(C0016R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.m1232b((View) this, attributeSet.m2312a(C0016R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f11097h = attributeSet.m2319e(C0016R.styleable.NavigationView_android_maxWidth, 0);
        if (attributeSet.m2322f(C0016R.styleable.NavigationView_itemIconTint) != 0) {
            e = attributeSet.m2320e(C0016R.styleable.NavigationView_itemIconTint);
        } else {
            e = m9583b(16842808);
        }
        if (attributeSet.m2322f(C0016R.styleable.NavigationView_itemTextAppearance)) {
            g = attributeSet.m2323g(C0016R.styleable.NavigationView_itemTextAppearance, 0);
            i2 = 1;
        } else {
            i2 = false;
            g = i2;
        }
        ColorStateList colorStateList = null;
        if (attributeSet.m2322f(C0016R.styleable.NavigationView_itemTextColor)) {
            colorStateList = attributeSet.m2320e(C0016R.styleable.NavigationView_itemTextColor);
        }
        if (i2 == 0 && r4 == null) {
            colorStateList = m9583b(16842806);
        }
        Drawable a = attributeSet.m2311a(C0016R.styleable.NavigationView_itemBackground);
        this.f11096g.setCallback(new C09861(this));
        this.f11094c.f11017d = 1;
        this.f11094c.mo45a(context, this.f11096g);
        this.f11094c.m9490a(e);
        if (i2 != 0) {
            this.f11094c.m9488a(g);
        }
        this.f11094c.m9500b(colorStateList);
        this.f11094c.m9491a(a);
        this.f11096g.addMenuPresenter(this.f11094c);
        context = this.f11094c;
        if (context.f11014a == 0) {
            context.f11014a = (NavigationMenuView) context.f11019f.inflate(C0016R.layout.design_navigation_menu, this, false);
            if (context.f11018e == 0) {
                context.f11018e = new NavigationMenuAdapter(context);
            }
            context.f11015b = (LinearLayout) context.f11019f.inflate(C0016R.layout.design_navigation_item_header, context.f11014a, false);
            context.f11014a.setAdapter(context.f11018e);
        }
        addView((View) context.f11014a);
        if (attributeSet.m2322f(C0016R.styleable.NavigationView_menu) != null) {
            m9584a(attributeSet.m2323g(C0016R.styleable.NavigationView_menu, 0));
        }
        if (attributeSet.m2322f(C0016R.styleable.NavigationView_headerLayout) != null) {
            context = attributeSet.m2323g(C0016R.styleable.NavigationView_headerLayout, 0);
            i = this.f11094c;
            i.f11015b.addView(i.f11019f.inflate(context, i.f11015b, false));
            i.f11014a.setPadding(0, 0, 0, i.f11014a.getPaddingBottom());
        }
        attributeSet.f2595b.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.f11096g.savePresenterStates(savedState.menuState);
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f11096g.restorePresenterStates(savedState.menuState);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f11095d = onNavigationItemSelectedListener;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.f11097h), 1073741824);
        } else if (mode == 0) {
            i = MeasureSpec.makeMeasureSpec(this.f11097h, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected final void mo109a(WindowInsetsCompat windowInsetsCompat) {
        NavigationMenuPresenter navigationMenuPresenter = this.f11094c;
        int b = windowInsetsCompat.m1309b();
        if (navigationMenuPresenter.f11025l != b) {
            navigationMenuPresenter.f11025l = b;
            if (navigationMenuPresenter.f11015b.getChildCount() == 0) {
                navigationMenuPresenter.f11014a.setPadding(0, navigationMenuPresenter.f11025l, 0, navigationMenuPresenter.f11014a.getPaddingBottom());
            }
        }
        ViewCompat.m1229b(navigationMenuPresenter.f11015b, windowInsetsCompat);
    }

    public final void m9584a(int i) {
        this.f11094c.m9501b(true);
        getMenuInflater().inflate(i, this.f11096g);
        this.f11094c.m9501b(false);
        this.f11094c.mo49a(false);
    }

    public Menu getMenu() {
        return this.f11096g;
    }

    public int getHeaderCount() {
        return this.f11094c.f11015b.getChildCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.f11094c.f11023j;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f11094c.m9490a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f11094c.f11022i;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f11094c.m9500b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f11094c.f11024k;
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.m714a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.f11094c.m9491a(drawable);
    }

    public void setCheckedItem(int i) {
        i = this.f11096g.findItem(i);
        if (i != 0) {
            this.f11094c.f11018e.m9482a((MenuItemImpl) i);
        }
    }

    public void setItemTextAppearance(int i) {
        this.f11094c.m9488a(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f11098i == null) {
            this.f11098i = new SupportMenuInflater(getContext());
        }
        return this.f11098i;
    }

    private ColorStateList m9583b(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true) == 0) {
            return null;
        }
        i = AppCompatResources.m1569a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0164R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = i.getDefaultColor();
        return new ColorStateList(new int[][]{f11093f, f11092e, EMPTY_STATE_SET}, new int[]{i.getColorForState(f11093f, defaultColor), i2, defaultColor});
    }
}
