package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

@RequiresApi(14)
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    public SubMenu setHeaderTitle(int i) {
        ((SupportSubMenu) this.d).setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        ((SupportSubMenu) this.d).setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        ((SupportSubMenu) this.d).setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        ((SupportSubMenu) this.d).setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        ((SupportSubMenu) this.d).setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        ((SupportSubMenu) this.d).clearHeader();
    }

    public SubMenu setIcon(int i) {
        ((SupportSubMenu) this.d).setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        ((SupportSubMenu) this.d).setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m10447a(((SupportSubMenu) this.d).getItem());
    }
}
