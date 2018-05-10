package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView.ItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
    protected Context f11717a;
    protected Context f11718b;
    protected MenuBuilder f11719c;
    protected LayoutInflater f11720d;
    protected LayoutInflater f11721e;
    public Callback f11722f;
    protected MenuView f11723g;
    public int f11724h;
    private int f11725i;
    private int f11726j;

    public abstract void mo3225a(MenuItemImpl menuItemImpl, ItemView itemView);

    public boolean mo50a() {
        return false;
    }

    public final boolean mo51a(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean mo54b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean mo3228c(MenuItemImpl menuItemImpl) {
        return true;
    }

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f11717a = context;
        this.f11720d = LayoutInflater.from(context);
        this.f11725i = i;
        this.f11726j = i2;
    }

    public void mo45a(Context context, MenuBuilder menuBuilder) {
        this.f11718b = context;
        this.f11721e = LayoutInflater.from(this.f11718b);
        this.f11719c = menuBuilder;
    }

    public MenuView mo3223a(ViewGroup viewGroup) {
        if (this.f11723g == null) {
            this.f11723g = (MenuView) this.f11720d.inflate(this.f11725i, viewGroup, false);
            this.f11723g.mo536a(this.f11719c);
            mo49a(true);
        }
        return this.f11723g;
    }

    public void mo49a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f11723g;
        if (viewGroup != null) {
            int i = 0;
            if (this.f11719c != null) {
                this.f11719c.flagActionItems();
                ArrayList visibleItems = this.f11719c.getVisibleItems();
                int size = visibleItems.size();
                int i2 = 0;
                int i3 = i2;
                while (i2 < size) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) visibleItems.get(i2);
                    if (mo3228c(menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i3);
                        MenuItemImpl itemData = childAt instanceof ItemView ? ((ItemView) childAt).getItemData() : null;
                        View a = mo3224a(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.f11723g).addView(a, i3);
                        }
                        i3++;
                    }
                    i2++;
                }
                i = i3;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo3226a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean mo3226a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public final void mo48a(Callback callback) {
        this.f11722f = callback;
    }

    public View mo3224a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        ItemView itemView;
        if (view instanceof ItemView) {
            itemView = (ItemView) view;
        } else {
            itemView = (ItemView) this.f11720d.inflate(this.f11726j, viewGroup, false);
        }
        mo3225a(menuItemImpl, itemView);
        return (View) itemView;
    }

    public void mo47a(MenuBuilder menuBuilder, boolean z) {
        if (this.f11722f != null) {
            this.f11722f.mo428a(menuBuilder, z);
        }
    }

    public boolean mo52a(SubMenuBuilder subMenuBuilder) {
        return this.f11722f != null ? this.f11722f.mo429a(subMenuBuilder) : null;
    }

    public final int mo53b() {
        return this.f11724h;
    }
}
