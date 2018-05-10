package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class MenuPopup implements MenuPresenter, ShowableListMenu, OnItemClickListener {
    Rect f11804e;

    public abstract void mo3200a(int i);

    public final void mo45a(Context context, MenuBuilder menuBuilder) {
    }

    public abstract void mo3201a(MenuBuilder menuBuilder);

    public abstract void mo3202a(View view);

    public abstract void mo3203a(OnDismissListener onDismissListener);

    public final boolean mo51a(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final int mo53b() {
        return 0;
    }

    public abstract void mo3204b(int i);

    public abstract void mo3205b(boolean z);

    public final boolean mo54b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public abstract void mo3206c(int i);

    public abstract void mo3207c(boolean z);

    protected boolean mo3208h() {
        return true;
    }

    MenuPopup() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m10498a(listAdapter).f2030b.performItemAction((MenuItem) listAdapter.getItem(i), this, mo3208h() != 0 ? 0 : 4);
    }

    protected static int m10497a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int i2 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        viewGroup = null;
        int i3 = viewGroup;
        View view = null;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != viewGroup) {
                view = null;
                viewGroup = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i2, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= i) {
                return i;
            }
            if (itemViewType > i3) {
                i3 = itemViewType;
            }
            i2++;
        }
        return i3;
    }

    protected static MenuAdapter m10498a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }

    protected static boolean m10499b(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
