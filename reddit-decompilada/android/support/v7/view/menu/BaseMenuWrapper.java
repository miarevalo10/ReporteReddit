package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    final Context f11727a;
    Map<SupportMenuItem, MenuItem> f11728b;
    Map<SupportSubMenu, SubMenu> f11729c;

    BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f11727a = context;
    }

    final MenuItem m10447a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f11728b == null) {
            this.f11728b = new ArrayMap();
        }
        menuItem = (MenuItem) this.f11728b.get(menuItem);
        if (menuItem == null) {
            menuItem = MenuWrapperFactory.m1740a(this.f11727a, supportMenuItem);
            this.f11728b.put(supportMenuItem, menuItem);
        }
        return menuItem;
    }

    final SubMenu m10448a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f11729c == null) {
            this.f11729c = new ArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f11729c.get(supportSubMenu);
        if (subMenu2 == null) {
            subMenu2 = MenuWrapperFactory.m1741a(this.f11727a, supportSubMenu);
            this.f11729c.put(supportSubMenu, subMenu2);
        }
        return subMenu2;
    }
}
