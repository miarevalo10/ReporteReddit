package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements ItemView {
    private MenuItemImpl f11734a;
    private ImageView f11735b;
    private RadioButton f11736c;
    private TextView f11737d;
    private CheckBox f11738e;
    private TextView f11739f;
    private ImageView f11740g;
    private Drawable f11741h;
    private int f11742i;
    private Context f11743j;
    private boolean f11744k;
    private Drawable f11745l;
    private int f11746m;
    private LayoutInflater f11747n;
    private boolean f11748o;

    public final boolean mo539a() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        attributeSet = TintTypedArray.m2308a(getContext(), attributeSet, C0164R.styleable.MenuView, i, 0);
        this.f11741h = attributeSet.m2311a(C0164R.styleable.MenuView_android_itemBackground);
        this.f11742i = attributeSet.m2323g(C0164R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f11744k = attributeSet.m2312a(C0164R.styleable.MenuView_preserveIconSpacing, false);
        this.f11743j = context;
        this.f11745l = attributeSet.m2311a(C0164R.styleable.MenuView_subMenuArrow);
        attributeSet.f2595b.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.m1219a((View) this, this.f11741h);
        this.f11737d = (TextView) findViewById(C0164R.id.title);
        if (this.f11742i != -1) {
            this.f11737d.setTextAppearance(this.f11743j, this.f11742i);
        }
        this.f11739f = (TextView) findViewById(C0164R.id.shortcut);
        this.f11740g = (ImageView) findViewById(C0164R.id.submenuarrow);
        if (this.f11740g != null) {
            this.f11740g.setImageDrawable(this.f11745l);
        }
    }

    public final void mo538a(MenuItemImpl menuItemImpl) {
        this.f11734a = menuItemImpl;
        int i = 0;
        this.f11746m = 0;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m10477a((ItemView) this));
        setCheckable(menuItemImpl.isCheckable());
        boolean d = menuItemImpl.m10486d();
        menuItemImpl.m10483c();
        if (!d || !this.f11734a.m10486d()) {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.f11739f;
            char c = this.f11734a.m10483c();
            if (c == '\u0000') {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(MenuItemImpl.f11764f);
                if (c == '\b') {
                    stringBuilder.append(MenuItemImpl.f11766h);
                } else if (c == '\n') {
                    stringBuilder.append(MenuItemImpl.f11765g);
                } else if (c != ' ') {
                    stringBuilder.append(c);
                } else {
                    stringBuilder.append(MenuItemImpl.f11767i);
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.f11739f.getVisibility() != i) {
            this.f11739f.setVisibility(i);
        }
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    public void setForceShowIcon(boolean z) {
        this.f11748o = z;
        this.f11744k = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f11737d.setText(charSequence);
            if (this.f11737d.getVisibility() != null) {
                this.f11737d.setVisibility(0);
            }
        } else if (this.f11737d.getVisibility() != 8) {
            this.f11737d.setVisibility(8);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f11734a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f11736c != null || this.f11738e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f11734a.m10488e()) {
                if (this.f11736c == null) {
                    m10453b();
                }
                compoundButton = this.f11736c;
                compoundButton2 = this.f11738e;
            } else {
                if (this.f11738e == null) {
                    m10454c();
                }
                compoundButton = this.f11738e;
                compoundButton2 = this.f11736c;
            }
            if (z) {
                compoundButton.setChecked(this.f11734a.isChecked());
                z = z ? false : true;
                if (compoundButton.getVisibility() != z) {
                    compoundButton.setVisibility(z);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility())) {
                    compoundButton2.setVisibility(8);
                }
                return;
            }
            if (this.f11738e) {
                this.f11738e.setVisibility(8);
            }
            if (this.f11736c) {
                this.f11736c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f11734a.m10488e()) {
            if (this.f11736c == null) {
                m10453b();
            }
            compoundButton = this.f11736c;
        } else {
            if (this.f11738e == null) {
                m10454c();
            }
            compoundButton = this.f11738e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f11740g != null) {
            this.f11740g.setVisibility(z ? false : true);
        }
    }

    private void setShortcut$25d965e(boolean z) {
        z = (z && this.f11734a.m10486d()) ? false : true;
        if (!z) {
            CharSequence charSequence;
            TextView textView = this.f11739f;
            char c = this.f11734a.m10483c();
            if (c == '\u0000') {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(MenuItemImpl.f11764f);
                if (c == '\b') {
                    stringBuilder.append(MenuItemImpl.f11766h);
                } else if (c == '\n') {
                    stringBuilder.append(MenuItemImpl.f11765g);
                } else if (c != ' ') {
                    stringBuilder.append(c);
                } else {
                    stringBuilder.append(MenuItemImpl.f11767i);
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.f11739f.getVisibility() != z) {
            this.f11739f.setVisibility(z);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z;
        ImageView imageView;
        if (!this.f11734a.f11778b.getOptionalIconsVisible()) {
            if (!this.f11748o) {
                z = false;
                if (z && !this.f11744k) {
                    return;
                }
                if (this.f11735b == null || drawable != null || this.f11744k) {
                    if (this.f11735b == null) {
                        this.f11735b = (ImageView) getInflater().inflate(C0164R.layout.abc_list_menu_item_icon, this, false);
                        addView(this.f11735b, 0);
                    }
                    if (drawable == null) {
                        if (this.f11744k) {
                            this.f11735b.setVisibility(8);
                        }
                    }
                    imageView = this.f11735b;
                    if (z) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.f11735b.getVisibility() != null) {
                        this.f11735b.setVisibility(0);
                    }
                }
                return;
            }
        }
        z = true;
        if (z) {
        }
        if (this.f11735b == null) {
        }
        if (this.f11735b == null) {
            this.f11735b = (ImageView) getInflater().inflate(C0164R.layout.abc_list_menu_item_icon, this, false);
            addView(this.f11735b, 0);
        }
        if (drawable == null) {
            if (this.f11744k) {
                this.f11735b.setVisibility(8);
            }
        }
        imageView = this.f11735b;
        if (z) {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        if (this.f11735b.getVisibility() != null) {
            this.f11735b.setVisibility(0);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f11735b != null && this.f11744k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f11735b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m10453b() {
        this.f11736c = (RadioButton) getInflater().inflate(C0164R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f11736c);
    }

    private void m10454c() {
        this.f11738e = (CheckBox) getInflater().inflate(C0164R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f11738e);
    }

    private LayoutInflater getInflater() {
        if (this.f11747n == null) {
            this.f11747n = LayoutInflater.from(getContext());
        }
        return this.f11747n;
    }
}
