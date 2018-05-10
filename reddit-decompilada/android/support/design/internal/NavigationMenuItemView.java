package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0016R;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class NavigationMenuItemView extends ForegroundLinearLayout implements ItemView {
    private static final int[] f16400f = new int[]{16842912};
    boolean f16401c;
    final CheckedTextView f16402d;
    FrameLayout f16403e;
    private final int f16404g;
    private boolean f16405h;
    private MenuItemImpl f16406i;
    private ColorStateList f16407j;
    private boolean f16408k;
    private Drawable f16409l;
    private final AccessibilityDelegateCompat f16410m;

    class C09711 extends AccessibilityDelegateCompat {
        final /* synthetic */ NavigationMenuItemView f11005a;

        C09711(NavigationMenuItemView navigationMenuItemView) {
            this.f11005a = navigationMenuItemView;
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m1326a(this.f11005a.f16401c);
        }
    }

    public final boolean mo539a() {
        return false;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16410m = new C09711(this);
        setOrientation(null);
        LayoutInflater.from(context).inflate(C0016R.layout.design_navigation_menu_item, this, true);
        this.f16404g = context.getResources().getDimensionPixelSize(C0016R.dimen.design_navigation_icon_size);
        this.f16402d = (CheckedTextView) findViewById(C0016R.id.design_menu_item_text);
        this.f16402d.setDuplicateParentStateEnabled(true);
        ViewCompat.m1220a(this.f16402d, this.f16410m);
    }

    public final void mo538a(MenuItemImpl menuItemImpl) {
        this.f16406i = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        boolean z = true;
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(C0164R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f16400f, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            ViewCompat.m1219a((View) this, stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.m2349a(this, menuItemImpl.getTooltipText());
        if (this.f16406i.getTitle() != null || this.f16406i.getIcon() != null || this.f16406i.getActionView() == null) {
            z = false;
        }
        if (z) {
            this.f16402d.setVisibility(8);
            if (this.f16403e != null) {
                LayoutParams layoutParams = (LayoutParams) this.f16403e.getLayoutParams();
                layoutParams.width = -1;
                this.f16403e.setLayoutParams(layoutParams);
                return;
            }
        }
        this.f16402d.setVisibility(0);
        if (this.f16403e != null) {
            layoutParams = (LayoutParams) this.f16403e.getLayoutParams();
            layoutParams.width = -2;
            this.f16403e.setLayoutParams(layoutParams);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f16403e == null) {
                this.f16403e = (FrameLayout) ((ViewStub) findViewById(C0016R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f16403e.removeAllViews();
            this.f16403e.addView(view);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f16406i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f16402d.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f16401c != z) {
            this.f16401c = z;
            AccessibilityDelegateCompat.m1076a(this.f16402d, (int) MPEGConst.CODE_END);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f16402d.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f16408k) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.m844g(drawable).mutate();
                DrawableCompat.m833a(drawable, this.f16407j);
            }
            drawable.setBounds(0, 0, this.f16404g, this.f16404g);
        } else if (this.f16405h) {
            if (this.f16409l == null) {
                this.f16409l = ResourcesCompat.m774a(getResources(), C0016R.drawable.navigation_empty_icon, getContext().getTheme());
                if (this.f16409l != null) {
                    this.f16409l.setBounds(0, 0, this.f16404g, this.f16404g);
                }
            }
            drawable = this.f16409l;
        }
        TextViewCompat.m1430a(this.f16402d, drawable, null, null, null);
    }

    protected int[] onCreateDrawableState(int i) {
        i = super.onCreateDrawableState(i + 1);
        if (this.f16406i != null && this.f16406i.isCheckable() && this.f16406i.isChecked()) {
            mergeDrawableStates(i, f16400f);
        }
        return i;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f16407j = colorStateList;
        this.f16408k = this.f16407j != null ? true : null;
        if (this.f16406i != null) {
            setIcon(this.f16406i.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        TextViewCompat.m1429a(this.f16402d, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f16402d.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f16405h = z;
    }
}
