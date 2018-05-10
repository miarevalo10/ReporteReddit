package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.C0016R;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class NavigationMenuPresenter implements MenuPresenter {
    public NavigationMenuView f11014a;
    public LinearLayout f11015b;
    MenuBuilder f11016c;
    public int f11017d;
    public NavigationMenuAdapter f11018e;
    public LayoutInflater f11019f;
    int f11020g;
    boolean f11021h;
    public ColorStateList f11022i;
    public ColorStateList f11023j;
    public Drawable f11024k;
    public int f11025l;
    int f11026m;
    final OnClickListener f11027n = new C00171(this);
    private Callback f11028o;

    class C00171 implements OnClickListener {
        final /* synthetic */ NavigationMenuPresenter f402a;

        C00171(NavigationMenuPresenter navigationMenuPresenter) {
            this.f402a = navigationMenuPresenter;
        }

        public void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            this.f402a.m9501b(true);
            MenuItemImpl itemData = navigationMenuItemView.getItemData();
            boolean performItemAction = this.f402a.f11016c.performItemAction(itemData, this.f402a, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                this.f402a.f11018e.m9482a(itemData);
            }
            this.f402a.m9501b(false);
            this.f402a.mo49a(false);
        }
    }

    private interface NavigationMenuItem {
    }

    private class NavigationMenuAdapter extends Adapter<ViewHolder> {
        final ArrayList<NavigationMenuItem> f11006a = new ArrayList();
        boolean f11007b;
        final /* synthetic */ NavigationMenuPresenter f11008c;
        private MenuItemImpl f11009f;

        public final long mo40a(int i) {
            return (long) i;
        }

        public final /* synthetic */ void mo42a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            if (viewHolder2 instanceof NormalViewHolder) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder2.c;
                if (navigationMenuItemView.f16403e != null) {
                    navigationMenuItemView.f16403e.removeAllViews();
                }
                navigationMenuItemView.f16402d.setCompoundDrawables(null, null, null, null);
            }
        }

        public final /* synthetic */ void mo43a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            switch (mo44b(i)) {
                case 0:
                    View view = (NavigationMenuItemView) viewHolder2.c;
                    view.setIconTintList(this.f11008c.f11023j);
                    if (this.f11008c.f11021h) {
                        view.setTextAppearance(this.f11008c.f11020g);
                    }
                    if (this.f11008c.f11022i != null) {
                        view.setTextColor(this.f11008c.f11022i);
                    }
                    ViewCompat.m1219a(view, this.f11008c.f11024k != null ? this.f11008c.f11024k.getConstantState().newDrawable() : null);
                    NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f11006a.get(i);
                    view.setNeedsEmptyIcon(navigationMenuTextItem.f11013b);
                    view.mo538a(navigationMenuTextItem.f11012a);
                    return;
                case 1:
                    ((TextView) viewHolder2.c).setText(((NavigationMenuTextItem) this.f11006a.get(i)).f11012a.getTitle());
                    return;
                case 2:
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f11006a.get(i);
                    viewHolder2.c.setPadding(0, navigationMenuSeparatorItem.f11010a, 0, navigationMenuSeparatorItem.f11011b);
                    break;
                default:
                    break;
            }
        }

        public NavigationMenuAdapter(NavigationMenuPresenter navigationMenuPresenter) {
            this.f11008c = navigationMenuPresenter;
            m9486b();
        }

        public final int mo39a() {
            return this.f11006a.size();
        }

        public final int mo44b(int i) {
            NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.f11006a.get(i);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).f11012a.hasSubMenu() != 0 ? 1 : 0;
            } else {
                throw new RuntimeException("Unknown item type.");
            }
        }

        final void m9486b() {
            if (!this.f11007b) {
                boolean z = true;
                r0.f11007b = true;
                r0.f11006a.clear();
                r0.f11006a.add(new NavigationMenuHeaderItem());
                int size = r0.f11008c.f11016c.getVisibleItems().size();
                int i = -1;
                int i2 = 0;
                boolean z2 = i2;
                int i3 = z2;
                while (i2 < size) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) r0.f11008c.f11016c.getVisibleItems().get(i2);
                    if (menuItemImpl.isChecked()) {
                        m9482a(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.m10479a(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i2 != 0) {
                                r0.f11006a.add(new NavigationMenuSeparatorItem(r0.f11008c.f11026m, 0));
                            }
                            r0.f11006a.add(new NavigationMenuTextItem(menuItemImpl));
                            int size2 = r0.f11006a.size();
                            int size3 = subMenu.size();
                            int i4 = 0;
                            int i5 = i4;
                            while (i4 < size3) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i4);
                                if (menuItemImpl2.isVisible()) {
                                    if (i5 == 0 && menuItemImpl2.getIcon() != null) {
                                        i5 = z;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.m10479a(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        m9482a(menuItemImpl);
                                    }
                                    r0.f11006a.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                                i4++;
                                z = true;
                            }
                            if (i5 != 0) {
                                m9478e(size2, r0.f11006a.size());
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i) {
                            i3 = r0.f11006a.size();
                            boolean z3 = menuItemImpl.getIcon() != null;
                            if (i2 != 0) {
                                i3++;
                                r0.f11006a.add(new NavigationMenuSeparatorItem(r0.f11008c.f11026m, r0.f11008c.f11026m));
                            }
                            z2 = z3;
                        } else if (!(z2 || menuItemImpl.getIcon() == null)) {
                            m9478e(i3, r0.f11006a.size());
                            z2 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.f11013b = z2;
                        r0.f11006a.add(navigationMenuTextItem);
                        i = groupId;
                    }
                    i2++;
                    z = true;
                }
                r0.f11007b = false;
            }
        }

        private void m9478e(int i, int i2) {
            while (i < i2) {
                ((NavigationMenuTextItem) this.f11006a.get(i)).f11013b = true;
                i++;
            }
        }

        public final void m9482a(MenuItemImpl menuItemImpl) {
            if (this.f11009f != menuItemImpl) {
                if (menuItemImpl.isCheckable()) {
                    if (this.f11009f != null) {
                        this.f11009f.setChecked(false);
                    }
                    this.f11009f = menuItemImpl;
                    menuItemImpl.setChecked(true);
                }
            }
        }

        public final Bundle m9487c() {
            Bundle bundle = new Bundle();
            if (this.f11009f != null) {
                bundle.putInt("android:menu:checked", this.f11009f.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f11006a.size();
            for (int i = 0; i < size; i++) {
                NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.f11006a.get(i);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItemImpl = ((NavigationMenuTextItem) navigationMenuItem).f11012a;
                    View actionView = menuItemImpl != null ? menuItemImpl.getActionView() : null;
                    if (actionView != null) {
                        SparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItemImpl.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public final /* synthetic */ android.support.v7.widget.RecyclerView.ViewHolder mo41a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new NormalViewHolder(this.f11008c.f11019f, viewGroup, this.f11008c.f11027n);
                case 1:
                    return new SubheaderViewHolder(this.f11008c.f11019f, viewGroup);
                case 2:
                    return new SeparatorViewHolder(this.f11008c.f11019f, viewGroup);
                case 3:
                    return new HeaderViewHolder(this.f11008c.f11015b);
                default:
                    return null;
            }
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        final int f11010a;
        final int f11011b;

        public NavigationMenuSeparatorItem(int i, int i2) {
            this.f11010a = i;
            this.f11011b = i2;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {
        final MenuItemImpl f11012a;
        boolean f11013b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f11012a = menuItemImpl;
        }
    }

    private static abstract class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(C0016R.layout.design_navigation_item, viewGroup, false));
            this.c.setOnClickListener(onClickListener);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C0016R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(C0016R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public final boolean mo50a() {
        return false;
    }

    public final boolean mo51a(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean mo52a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public final boolean mo54b(MenuItemImpl menuItemImpl) {
        return false;
    }

    public final void mo45a(Context context, MenuBuilder menuBuilder) {
        this.f11019f = LayoutInflater.from(context);
        this.f11016c = menuBuilder;
        this.f11026m = context.getResources().getDimensionPixelOffset(C0016R.dimen.design_navigation_separator_vertical_padding);
    }

    public final void mo49a(boolean z) {
        if (this.f11018e) {
            z = this.f11018e;
            z.m9486b();
            z.a_.m2036b();
        }
    }

    public final void mo48a(Callback callback) {
        this.f11028o = callback;
    }

    public final void mo47a(MenuBuilder menuBuilder, boolean z) {
        if (this.f11028o != null) {
            this.f11028o.mo428a(menuBuilder, z);
        }
    }

    public final int mo53b() {
        return this.f11017d;
    }

    public final Parcelable mo55c() {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        Parcelable bundle = new Bundle();
        if (this.f11014a != null) {
            SparseArray sparseArray = new SparseArray();
            this.f11014a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f11018e != null) {
            bundle.putBundle("android:menu:adapter", this.f11018e.m9487c());
        }
        if (this.f11015b != null) {
            sparseArray = new SparseArray();
            this.f11015b.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray);
        }
        return bundle;
    }

    public final void mo46a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f11014a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                NavigationMenuAdapter navigationMenuAdapter = this.f11018e;
                int i = 0;
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    navigationMenuAdapter.f11007b = true;
                    int size = navigationMenuAdapter.f11006a.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        NavigationMenuItem navigationMenuItem = (NavigationMenuItem) navigationMenuAdapter.f11006a.get(i3);
                        if (navigationMenuItem instanceof NavigationMenuTextItem) {
                            MenuItemImpl menuItemImpl = ((NavigationMenuTextItem) navigationMenuItem).f11012a;
                            if (menuItemImpl != null && menuItemImpl.getItemId() == i2) {
                                navigationMenuAdapter.m9482a(menuItemImpl);
                                break;
                            }
                        }
                    }
                    navigationMenuAdapter.f11007b = false;
                    navigationMenuAdapter.m9486b();
                }
                sparseParcelableArray = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray != null) {
                    i2 = navigationMenuAdapter.f11006a.size();
                    while (i < i2) {
                        NavigationMenuItem navigationMenuItem2 = (NavigationMenuItem) navigationMenuAdapter.f11006a.get(i);
                        if (navigationMenuItem2 instanceof NavigationMenuTextItem) {
                            MenuItemImpl menuItemImpl2 = ((NavigationMenuTextItem) navigationMenuItem2).f11012a;
                            if (menuItemImpl2 != null) {
                                View actionView = menuItemImpl2.getActionView();
                                if (actionView != null) {
                                    ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItemImpl2.getItemId());
                                    if (parcelableSparseArray != null) {
                                        actionView.restoreHierarchyState(parcelableSparseArray);
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
            }
            parcelable = bundle.getSparseParcelableArray("android:menu:header");
            if (parcelable != null) {
                this.f11015b.restoreHierarchyState(parcelable);
            }
        }
    }

    public final void m9490a(ColorStateList colorStateList) {
        this.f11023j = colorStateList;
        mo49a((boolean) null);
    }

    public final void m9500b(ColorStateList colorStateList) {
        this.f11022i = colorStateList;
        mo49a((boolean) null);
    }

    public final void m9488a(int i) {
        this.f11020g = i;
        this.f11021h = true;
        mo49a((boolean) 0);
    }

    public final void m9491a(Drawable drawable) {
        this.f11024k = drawable;
        mo49a((boolean) null);
    }

    public final void m9501b(boolean z) {
        if (this.f11018e != null) {
            this.f11018e.f11007b = z;
        }
    }
}
