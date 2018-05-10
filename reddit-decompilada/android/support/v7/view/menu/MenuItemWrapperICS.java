package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@RequiresApi(14)
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {
    public Method f16635e;

    class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider f11799c;
        final /* synthetic */ MenuItemWrapperICS f11800d;

        public ActionProviderWrapper(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
            this.f11800d = menuItemWrapperICS;
            super(context);
            this.f11799c = actionProvider;
        }

        public final View mo542a() {
            return this.f11799c.onCreateActionView();
        }

        public final boolean mo544d() {
            return this.f11799c.onPerformDefaultAction();
        }

        public final boolean mo545e() {
            return this.f11799c.hasSubMenu();
        }

        public final void mo543a(SubMenu subMenu) {
            this.f11799c.onPrepareSubMenu(this.f11800d.m10448a(subMenu));
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView f11801a;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f11801a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.f11801a.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.f11801a.onActionViewCollapsed();
        }
    }

    private class OnActionExpandListenerWrapper extends BaseWrapper<OnActionExpandListener> implements OnActionExpandListener {
        final /* synthetic */ MenuItemWrapperICS f11802a;

        OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, OnActionExpandListener onActionExpandListener) {
            this.f11802a = menuItemWrapperICS;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.d).onMenuItemActionExpand(this.f11802a.m10447a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.d).onMenuItemActionCollapse(this.f11802a.m10447a(menuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ MenuItemWrapperICS f11803a;

        OnMenuItemClickListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, OnMenuItemClickListener onMenuItemClickListener) {
            this.f11803a = menuItemWrapperICS;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.d).onMenuItemClick(this.f11803a.m10447a(menuItem));
        }
    }

    MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    public int getItemId() {
        return ((SupportMenuItem) this.d).getItemId();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.d).getGroupId();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.d).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.d).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.d).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.d).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.d).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.d).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.d).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.d).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.d).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.d).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.d).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.d).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((SupportMenuItem) this.d).setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.d).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((SupportMenuItem) this.d).setNumericShortcut(c, i);
        return this;
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.d).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((SupportMenuItem) this.d).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.d).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((SupportMenuItem) this.d).setAlphabeticShortcut(c, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.d).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((SupportMenuItem) this.d).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.d).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.d).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.d).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.d).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.d).setVisible(z);
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.d).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.d).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.d).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.d).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m10448a(((SupportMenuItem) this.d).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.d).setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.d).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.d).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.d).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((SupportMenuItem) this.d).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.d).setActionView(i);
        i = ((SupportMenuItem) this.d).getActionView();
        if (i instanceof android.view.CollapsibleActionView) {
            ((SupportMenuItem) this.d).setActionView(new CollapsibleActionViewWrapper(i));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.d).getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? (View) ((CollapsibleActionViewWrapper) actionView).f11801a : actionView;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((SupportMenuItem) this.d).mo509a(actionProvider != null ? mo3851a(actionProvider) : null);
        return this;
    }

    public android.view.ActionProvider getActionProvider() {
        ActionProvider a = ((SupportMenuItem) this.d).mo511a();
        return a instanceof ActionProviderWrapper ? ((ActionProviderWrapper) a).f11799c : null;
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.d).expandActionView();
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.d).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.d).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.d).setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((SupportMenuItem) this.d).mo510a(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((SupportMenuItem) this.d).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((SupportMenuItem) this.d).mo512b(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((SupportMenuItem) this.d).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((SupportMenuItem) this.d).setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((SupportMenuItem) this.d).getIconTintList();
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((SupportMenuItem) this.d).setIconTintMode(mode);
        return this;
    }

    public Mode getIconTintMode() {
        return ((SupportMenuItem) this.d).getIconTintMode();
    }

    ActionProviderWrapper mo3851a(android.view.ActionProvider actionProvider) {
        return new ActionProviderWrapper(this, this.a, actionProvider);
    }
}
