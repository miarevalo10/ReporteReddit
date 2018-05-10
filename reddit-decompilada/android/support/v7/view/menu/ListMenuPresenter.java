package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView.ItemView;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class ListMenuPresenter implements MenuPresenter, OnItemClickListener {
    Context f11749a;
    public LayoutInflater f11750b;
    MenuBuilder f11751c;
    public ExpandedMenuView f11752d;
    int f11753e;
    int f11754f;
    int f11755g;
    public Callback f11756h;
    public MenuAdapter f11757i;
    private int f11758j;

    private class MenuAdapter extends BaseAdapter {
        final /* synthetic */ ListMenuPresenter f2027a;
        private int f2028b = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public /* synthetic */ Object getItem(int i) {
            return m1708a(i);
        }

        public MenuAdapter(ListMenuPresenter listMenuPresenter) {
            this.f2027a = listMenuPresenter;
            m1707a();
        }

        public int getCount() {
            int size = this.f2027a.f11751c.getNonActionItems().size() - this.f2027a.f11753e;
            return this.f2028b < 0 ? size : size - 1;
        }

        public final MenuItemImpl m1708a(int i) {
            ArrayList nonActionItems = this.f2027a.f11751c.getNonActionItems();
            i += this.f2027a.f11753e;
            if (this.f2028b >= 0 && i >= this.f2028b) {
                i++;
            }
            return (MenuItemImpl) nonActionItems.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f2027a.f11750b.inflate(this.f2027a.f11755g, viewGroup, false);
            }
            ((ItemView) view).mo538a(m1708a(i));
            return view;
        }

        private void m1707a() {
            MenuItemImpl expandedItem = this.f2027a.f11751c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList nonActionItems = this.f2027a.f11751c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (((MenuItemImpl) nonActionItems.get(i)) == expandedItem) {
                        this.f2028b = i;
                        return;
                    }
                }
            }
            this.f2028b = -1;
        }

        public void notifyDataSetChanged() {
            m1707a();
            super.notifyDataSetChanged();
        }
    }

    public final boolean mo50a() {
        return false;
    }

    public final boolean mo51a(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean mo54b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public ListMenuPresenter(Context context, int i) {
        this(i);
        this.f11749a = context;
        this.f11750b = LayoutInflater.from(this.f11749a);
    }

    private ListMenuPresenter(int i) {
        this.f11755g = i;
        this.f11754f = 0;
    }

    public final void mo45a(Context context, MenuBuilder menuBuilder) {
        if (this.f11754f != 0) {
            this.f11749a = new ContextThemeWrapper(context, this.f11754f);
            this.f11750b = LayoutInflater.from(this.f11749a);
        } else if (this.f11749a != null) {
            this.f11749a = context;
            if (this.f11750b == null) {
                this.f11750b = LayoutInflater.from(this.f11749a);
            }
        }
        this.f11751c = menuBuilder;
        if (this.f11757i != null) {
            this.f11757i.notifyDataSetChanged();
        }
    }

    public final ListAdapter m10468d() {
        if (this.f11757i == null) {
            this.f11757i = new MenuAdapter(this);
        }
        return this.f11757i;
    }

    public final void mo49a(boolean z) {
        if (this.f11757i) {
            this.f11757i.notifyDataSetChanged();
        }
    }

    public final void mo48a(Callback callback) {
        this.f11756h = callback;
    }

    public final boolean mo52a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return null;
        }
        MenuDialogHelper menuDialogHelper = new MenuDialogHelper(subMenuBuilder);
        MenuBuilder menuBuilder = menuDialogHelper.f11759a;
        Builder builder = new Builder(menuBuilder.getContext());
        menuDialogHelper.f11761c = new ListMenuPresenter(builder.f1801a.f1731a, C0164R.layout.abc_list_menu_item_layout);
        menuDialogHelper.f11761c.f11756h = menuDialogHelper;
        menuDialogHelper.f11759a.addMenuPresenter(menuDialogHelper.f11761c);
        builder.f1801a.f1750t = menuDialogHelper.f11761c.m10468d();
        builder.f1801a.f1751u = menuDialogHelper;
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.f1801a.f1737g = headerView;
        } else {
            builder.m1511a(menuBuilder.getHeaderIcon()).m1513a(menuBuilder.getHeaderTitle());
        }
        builder.f1801a.f1748r = menuDialogHelper;
        menuDialogHelper.f11760b = builder.m1521b();
        menuDialogHelper.f11760b.setOnDismissListener(menuDialogHelper);
        LayoutParams attributes = menuDialogHelper.f11760b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        menuDialogHelper.f11760b.show();
        if (this.f11756h != null) {
            this.f11756h.mo429a(subMenuBuilder);
        }
        return true;
    }

    public final void mo47a(MenuBuilder menuBuilder, boolean z) {
        if (this.f11756h != null) {
            this.f11756h.mo428a(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f11751c.performItemAction(this.f11757i.m1708a(i), this, 0);
    }

    public final int mo53b() {
        return this.f11758j;
    }

    public final Parcelable mo55c() {
        if (this.f11752d == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        if (this.f11752d != null) {
            this.f11752d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void mo46a(Parcelable parcelable) {
        parcelable = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (parcelable != null) {
            this.f11752d.restoreHierarchyState(parcelable);
        }
    }
}
