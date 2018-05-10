package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class ActionMenuItem implements SupportMenuItem {
    private final int f11694a;
    private final int f11695b;
    private final int f11696c;
    private final int f11697d;
    private CharSequence f11698e;
    private CharSequence f11699f;
    private Intent f11700g;
    private char f11701h;
    private int f11702i = 4096;
    private char f11703j;
    private int f11704k = 4096;
    private Drawable f11705l;
    private int f11706m = 0;
    private Context f11707n;
    private OnMenuItemClickListener f11708o;
    private CharSequence f11709p;
    private CharSequence f11710q;
    private ColorStateList f11711r = null;
    private Mode f11712s = null;
    private boolean f11713t = false;
    private boolean f11714u = false;
    private int f11715v = 16;

    public final ActionProvider mo511a() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public View getActionView() {
        return null;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public void setShowAsAction(int i) {
    }

    public ActionMenuItem(Context context, CharSequence charSequence) {
        this.f11707n = context;
        this.f11694a = 16908332;
        this.f11695b = 0;
        this.f11696c = 0;
        this.f11697d = 0;
        this.f11698e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f11703j;
    }

    public int getAlphabeticModifiers() {
        return this.f11704k;
    }

    public int getGroupId() {
        return this.f11695b;
    }

    public Drawable getIcon() {
        return this.f11705l;
    }

    public Intent getIntent() {
        return this.f11700g;
    }

    public int getItemId() {
        return this.f11694a;
    }

    public char getNumericShortcut() {
        return this.f11701h;
    }

    public int getNumericModifiers() {
        return this.f11702i;
    }

    public int getOrder() {
        return this.f11697d;
    }

    public CharSequence getTitle() {
        return this.f11698e;
    }

    public CharSequence getTitleCondensed() {
        return this.f11699f != null ? this.f11699f : this.f11698e;
    }

    public boolean isCheckable() {
        return (this.f11715v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f11715v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f11715v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f11715v & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f11703j = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f11703j = Character.toLowerCase(c);
        this.f11704k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f11715v = z | (this.f11715v & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f11715v = (z ? true : false) | (this.f11715v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f11715v = (z ? true : false) | (this.f11715v & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f11705l = drawable;
        this.f11706m = null;
        m10426b();
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f11706m = i;
        this.f11705l = ContextCompat.m714a(this.f11707n, i);
        m10426b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f11700g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f11701h = c;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f11701h = c;
        this.f11702i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f11708o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f11701h = c;
        this.f11703j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f11701h = c;
        this.f11702i = KeyEvent.normalizeMetaState(i);
        this.f11703j = Character.toLowerCase(c2);
        this.f11704k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f11698e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f11698e = this.f11707n.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f11699f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f11715v & 8;
        if (z) {
            i = 0;
        }
        this.f11715v = i2 | i;
        return this;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final SupportMenuItem mo509a(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final SupportMenuItem mo510a(CharSequence charSequence) {
        this.f11709p = charSequence;
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f11709p;
    }

    public final SupportMenuItem mo512b(CharSequence charSequence) {
        this.f11710q = charSequence;
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f11710q;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f11711r = colorStateList;
        this.f11713t = true;
        m10426b();
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f11711r;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f11712s = mode;
        this.f11714u = true;
        m10426b();
        return this;
    }

    public Mode getIconTintMode() {
        return this.f11712s;
    }

    private void m10426b() {
        if (this.f11705l == null) {
            return;
        }
        if (this.f11713t || this.f11714u) {
            this.f11705l = DrawableCompat.m844g(this.f11705l);
            this.f11705l = this.f11705l.mutate();
            if (this.f11713t) {
                DrawableCompat.m833a(this.f11705l, this.f11711r);
            }
            if (this.f11714u) {
                DrawableCompat.m836a(this.f11705l, this.f11712s);
            }
        }
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.f11710q = charSequence;
        return this;
    }

    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.f11709p = charSequence;
        return this;
    }
}
