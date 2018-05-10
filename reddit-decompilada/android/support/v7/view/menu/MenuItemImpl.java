package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuView.ItemView;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class MenuItemImpl implements SupportMenuItem {
    static String f11764f;
    static String f11765g;
    static String f11766h;
    static String f11767i;
    private ColorStateList f11768A = null;
    private Mode f11769B = null;
    private boolean f11770C = false;
    private boolean f11771D = false;
    private boolean f11772E = false;
    private int f11773F = 16;
    private View f11774G;
    private OnActionExpandListener f11775H;
    private boolean f11776I = false;
    final int f11777a;
    MenuBuilder f11778b;
    int f11779c = 0;
    public ActionProvider f11780d;
    ContextMenuInfo f11781e;
    private final int f11782j;
    private final int f11783k;
    private final int f11784l;
    private CharSequence f11785m;
    private CharSequence f11786n;
    private Intent f11787o;
    private char f11788p;
    private int f11789q = 4096;
    private char f11790r;
    private int f11791s = 4096;
    private Drawable f11792t;
    private int f11793u = 0;
    private SubMenuBuilder f11794v;
    private Runnable f11795w;
    private OnMenuItemClickListener f11796x;
    private CharSequence f11797y;
    private CharSequence f11798z;

    class C10201 implements VisibilityListener {
        final /* synthetic */ MenuItemImpl f11763a;

        C10201(MenuItemImpl menuItemImpl) {
            this.f11763a = menuItemImpl;
        }

        public final void mo541a() {
            this.f11763a.f11778b.onItemVisibleChanged(this.f11763a);
        }
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        return m10473a(view);
    }

    public final /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return mo510a(charSequence);
    }

    public final /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return mo512b(charSequence);
    }

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f11778b = menuBuilder;
        this.f11782j = i2;
        this.f11783k = i;
        this.f11784l = i3;
        this.f11777a = i4;
        this.f11785m = charSequence;
        this.f11779c = i5;
    }

    public final boolean m10482b() {
        if ((this.f11796x != null && this.f11796x.onMenuItemClick(this)) || this.f11778b.dispatchMenuItemSelected(this.f11778b, this)) {
            return true;
        }
        if (this.f11795w != null) {
            this.f11795w.run();
            return true;
        }
        if (this.f11787o != null) {
            try {
                this.f11778b.getContext().startActivity(this.f11787o);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f11780d == null || !this.f11780d.mo544d()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.f11773F & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f11773F |= 16;
        } else {
            this.f11773F &= -17;
        }
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final int getGroupId() {
        return this.f11783k;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.f11782j;
    }

    public final int getOrder() {
        return this.f11784l;
    }

    public final Intent getIntent() {
        return this.f11787o;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f11787o = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.f11790r;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.f11790r == c) {
            return this;
        }
        this.f11790r = Character.toLowerCase(c);
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f11790r == c && this.f11791s == i) {
            return this;
        }
        this.f11790r = Character.toLowerCase(c);
        this.f11791s = KeyEvent.normalizeMetaState(i);
        this.f11778b.onItemsChanged(0);
        return this;
    }

    public final int getAlphabeticModifiers() {
        return this.f11791s;
    }

    public final char getNumericShortcut() {
        return this.f11788p;
    }

    public final int getNumericModifiers() {
        return this.f11789q;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.f11788p == c) {
            return this;
        }
        this.f11788p = c;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.f11788p == c && this.f11789q == i) {
            return this;
        }
        this.f11788p = c;
        this.f11789q = KeyEvent.normalizeMetaState(i);
        this.f11778b.onItemsChanged(0);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.f11788p = c;
        this.f11790r = Character.toLowerCase(c2);
        this.f11778b.onItemsChanged('\u0000');
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f11788p = c;
        this.f11789q = KeyEvent.normalizeMetaState(i);
        this.f11790r = Character.toLowerCase(c2);
        this.f11791s = KeyEvent.normalizeMetaState(i2);
        this.f11778b.onItemsChanged('\u0000');
        return this;
    }

    final char m10483c() {
        return this.f11778b.isQwertyMode() ? this.f11790r : this.f11788p;
    }

    final boolean m10486d() {
        return this.f11778b.isShortcutsVisible() && m10483c() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.f11794v;
    }

    public final boolean hasSubMenu() {
        return this.f11794v != null;
    }

    public final void m10478a(SubMenuBuilder subMenuBuilder) {
        this.f11794v = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f11785m;
    }

    final CharSequence m10477a(ItemView itemView) {
        if (itemView == null || itemView.mo539a() == null) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f11785m = charSequence;
        this.f11778b.onItemsChanged(false);
        if (this.f11794v != null) {
            this.f11794v.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.f11778b.getContext().getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f11786n != null ? this.f11786n : this.f11785m;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f11786n = charSequence;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.f11792t != null) {
            return m10472a(this.f11792t);
        }
        if (this.f11793u == 0) {
            return null;
        }
        Drawable b = AppCompatResources.m1570b(this.f11778b.getContext(), this.f11793u);
        this.f11793u = 0;
        this.f11792t = b;
        return m10472a(b);
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f11793u = 0;
        this.f11792t = drawable;
        this.f11772E = true;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.f11792t = null;
        this.f11793u = i;
        this.f11772E = true;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f11768A = colorStateList;
        this.f11770C = true;
        this.f11772E = true;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.f11768A;
    }

    public final MenuItem setIconTintMode(Mode mode) {
        this.f11769B = mode;
        this.f11771D = true;
        this.f11772E = true;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final Mode getIconTintMode() {
        return this.f11769B;
    }

    private Drawable m10472a(Drawable drawable) {
        if (drawable != null && this.f11772E && (this.f11770C || this.f11771D)) {
            drawable = DrawableCompat.m844g(drawable).mutate();
            if (this.f11770C) {
                DrawableCompat.m833a(drawable, this.f11768A);
            }
            if (this.f11771D) {
                DrawableCompat.m836a(drawable, this.f11769B);
            }
            this.f11772E = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.f11773F & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        boolean z2 = this.f11773F;
        this.f11773F = z | (this.f11773F & -2);
        if (z2 != this.f11773F) {
            this.f11778b.onItemsChanged(false);
        }
        return this;
    }

    public final void m10479a(boolean z) {
        this.f11773F = (z ? true : false) | (this.f11773F & -5);
    }

    public final boolean m10488e() {
        return (this.f11773F & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.f11773F & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.f11773F & 4) != 0) {
            this.f11778b.setExclusiveItemChecked(this);
        } else {
            m10481b(z);
        }
        return this;
    }

    final void m10481b(boolean z) {
        boolean z2 = this.f11773F;
        this.f11773F = (z ? true : false) | (this.f11773F & -3);
        if (z2 != this.f11773F) {
            this.f11778b.onItemsChanged(false);
        }
    }

    public final boolean isVisible() {
        return (this.f11780d == null || !this.f11780d.mo3211b()) ? (this.f11773F & 8) == 0 : (this.f11773F & 8) == 0 && this.f11780d.mo3212c();
    }

    final boolean m10484c(boolean z) {
        boolean z2 = this.f11773F;
        this.f11773F = (z ? false : true) | (this.f11773F & -9);
        if (z2 != this.f11773F) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (m10484c(z)) {
            this.f11778b.onItemVisibleChanged(this);
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f11796x = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.f11785m != null ? this.f11785m.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.f11781e;
    }

    public final boolean m10489f() {
        return (this.f11773F & 32) == 32;
    }

    public final boolean m10490g() {
        return (this.f11779c & 1) == 1;
    }

    public final boolean m10491h() {
        return (this.f11779c & 2) == 2;
    }

    public final void m10485d(boolean z) {
        if (z) {
            this.f11773F |= 32;
        } else {
            this.f11773F &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f11779c = i;
                this.f11778b.onItemActionRequestChanged(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private SupportMenuItem m10473a(View view) {
        this.f11774G = view;
        this.f11780d = null;
        if (view != null && view.getId() == -1 && this.f11782j > 0) {
            view.setId(this.f11782j);
        }
        this.f11778b.onItemActionRequestChanged(this);
        return this;
    }

    public final View getActionView() {
        if (this.f11774G != null) {
            return this.f11774G;
        }
        if (this.f11780d == null) {
            return null;
        }
        this.f11774G = this.f11780d.mo3209a((MenuItem) this);
        return this.f11774G;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final ActionProvider mo511a() {
        return this.f11780d;
    }

    public final SupportMenuItem mo509a(ActionProvider actionProvider) {
        if (this.f11780d != null) {
            ActionProvider actionProvider2 = this.f11780d;
            actionProvider2.f1434b = null;
            actionProvider2.f1433a = null;
        }
        this.f11774G = null;
        this.f11780d = actionProvider;
        this.f11778b.onItemsChanged(true);
        if (this.f11780d != null) {
            this.f11780d.mo3210a(new C10201(this));
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!m10492i()) {
            return false;
        }
        if (this.f11775H != null) {
            if (!this.f11775H.onMenuItemActionExpand(this)) {
                return false;
            }
        }
        return this.f11778b.expandItemActionView(this);
    }

    public final boolean collapseActionView() {
        if ((this.f11779c & 8) == 0) {
            return false;
        }
        if (this.f11774G == null) {
            return true;
        }
        if (this.f11775H != null) {
            if (!this.f11775H.onMenuItemActionCollapse(this)) {
                return false;
            }
        }
        return this.f11778b.collapseItemActionView(this);
    }

    public final boolean m10492i() {
        if ((this.f11779c & 8) == 0) {
            return false;
        }
        if (this.f11774G == null && this.f11780d != null) {
            this.f11774G = this.f11780d.mo3209a((MenuItem) this);
        }
        if (this.f11774G != null) {
            return true;
        }
        return false;
    }

    public final void m10487e(boolean z) {
        this.f11776I = z;
        this.f11778b.onItemsChanged(false);
    }

    public final boolean isActionViewExpanded() {
        return this.f11776I;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f11775H = onActionExpandListener;
        return this;
    }

    public final SupportMenuItem mo510a(CharSequence charSequence) {
        this.f11797y = charSequence;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.f11797y;
    }

    public final SupportMenuItem mo512b(CharSequence charSequence) {
        this.f11798z = charSequence;
        this.f11778b.onItemsChanged(false);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.f11798z;
    }

    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.f11778b.getContext();
        m10473a(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }
}
