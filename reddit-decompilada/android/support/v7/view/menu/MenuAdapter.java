package android.support.v7.view.menu;

import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuView.ItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    static final int f2029a = C0164R.layout.abc_popup_menu_item_layout;
    public MenuBuilder f2030b;
    boolean f2031c;
    private int f2032d = -1;
    private final boolean f2033e;
    private final LayoutInflater f2034f;

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return m1710a(i);
    }

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z) {
        this.f2033e = z;
        this.f2034f = layoutInflater;
        this.f2030b = menuBuilder;
        m1709a();
    }

    public int getCount() {
        ArrayList nonActionItems = this.f2033e ? this.f2030b.getNonActionItems() : this.f2030b.getVisibleItems();
        if (this.f2032d < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public final MenuItemImpl m1710a(int i) {
        ArrayList nonActionItems = this.f2033e ? this.f2030b.getNonActionItems() : this.f2030b.getVisibleItems();
        if (this.f2032d >= 0 && i >= this.f2032d) {
            i++;
        }
        return (MenuItemImpl) nonActionItems.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2034f.inflate(f2029a, viewGroup, false);
        }
        ItemView itemView = (ItemView) view;
        if (this.f2031c) {
            ((ListMenuItemView) view).setForceShowIcon(true);
        }
        itemView.mo538a(m1710a(i));
        return view;
    }

    private void m1709a() {
        MenuItemImpl expandedItem = this.f2030b.getExpandedItem();
        if (expandedItem != null) {
            ArrayList nonActionItems = this.f2030b.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (((MenuItemImpl) nonActionItems.get(i)) == expandedItem) {
                    this.f2032d = i;
                    return;
                }
            }
        }
        this.f2032d = -1;
    }

    public void notifyDataSetChanged() {
        m1709a();
        super.notifyDataSetChanged();
    }
}
