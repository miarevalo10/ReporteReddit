package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements ItemInvoker, MenuView, OnItemClickListener {
    private static final int[] f11731a = new int[]{16842964, 16843049};
    private MenuBuilder f11732b;
    private int f11733c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        context = TintTypedArray.m2308a(context, attributeSet, f11731a, i, 0);
        if (context.m2322f(0) != null) {
            setBackgroundDrawable(context.m2311a(0));
        }
        if (context.m2322f(1) != 0) {
            setDivider(context.m2311a(1));
        }
        context.f2595b.recycle();
    }

    public final void mo536a(MenuBuilder menuBuilder) {
        this.f11732b = menuBuilder;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final boolean mo537a(MenuItemImpl menuItemImpl) {
        return this.f11732b.performItemAction(menuItemImpl, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo537a((MenuItemImpl) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.f11733c;
    }
}
