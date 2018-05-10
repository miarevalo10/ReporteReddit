package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    public MenuBuilder f16658a;
    private MenuItemImpl f16659b;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f16658a = menuBuilder;
        this.f16659b = menuItemImpl;
    }

    public void setQwertyMode(boolean z) {
        this.f16658a.setQwertyMode(z);
    }

    public boolean isQwertyMode() {
        return this.f16658a.isQwertyMode();
    }

    public void setShortcutsVisible(boolean z) {
        this.f16658a.setShortcutsVisible(z);
    }

    public boolean isShortcutsVisible() {
        return this.f16658a.isShortcutsVisible();
    }

    public MenuItem getItem() {
        return this.f16659b;
    }

    public void setCallback(Callback callback) {
        this.f16658a.setCallback(callback);
    }

    public MenuBuilder getRootMenu() {
        return this.f16658a.getRootMenu();
    }

    boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (!super.dispatchMenuItemSelected(menuBuilder, menuItem)) {
            if (this.f16658a.dispatchMenuItemSelected(menuBuilder, menuItem) == null) {
                return null;
            }
        }
        return true;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f16659b.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f16659b.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.f16658a.expandItemActionView(menuItemImpl);
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.f16658a.collapseItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        int itemId = this.f16659b != null ? this.f16659b.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getActionViewStatesKey());
        stringBuilder.append(":");
        stringBuilder.append(itemId);
        return stringBuilder.toString();
    }
}
