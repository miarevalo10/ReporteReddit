package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract class SimpleItemAnimator extends ItemAnimator {
    protected boolean f12052m = true;

    public abstract boolean mo3231a(ViewHolder viewHolder);

    public abstract boolean mo3232a(ViewHolder viewHolder, int i, int i2, int i3, int i4);

    public abstract boolean mo3233a(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    public abstract boolean mo3236b(ViewHolder viewHolder);

    public final boolean mo715g(ViewHolder viewHolder) {
        if (this.f12052m) {
            if (viewHolder.m2234l() == null) {
                return null;
            }
        }
        return true;
    }

    public final boolean mo711a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        int i = itemHolderInfo.f2350a;
        int i2 = itemHolderInfo.f2351b;
        itemHolderInfo = viewHolder.f2424c;
        int left = itemHolderInfo2 == null ? itemHolderInfo.getLeft() : itemHolderInfo2.f2350a;
        int top = itemHolderInfo2 == null ? itemHolderInfo.getTop() : itemHolderInfo2.f2351b;
        if (viewHolder.m2237o() != null || (i == left && i2 == top)) {
            return mo3231a(viewHolder);
        }
        itemHolderInfo.layout(left, top, itemHolderInfo.getWidth() + left, itemHolderInfo.getHeight() + top);
        return mo3232a(viewHolder, i, i2, left, top);
    }

    public final boolean mo713b(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        if (itemHolderInfo == null || (itemHolderInfo.f2350a == itemHolderInfo2.f2350a && itemHolderInfo.f2351b == itemHolderInfo2.f2351b)) {
            return mo3236b(viewHolder);
        }
        return mo3232a(viewHolder, itemHolderInfo.f2350a, itemHolderInfo.f2351b, itemHolderInfo2.f2350a, itemHolderInfo2.f2351b);
    }

    public final boolean mo714c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        if (itemHolderInfo.f2350a == itemHolderInfo2.f2350a) {
            if (itemHolderInfo.f2351b == itemHolderInfo2.f2351b) {
                m2062f(viewHolder);
                return null;
            }
        }
        return mo3232a(viewHolder, itemHolderInfo.f2350a, itemHolderInfo.f2351b, itemHolderInfo2.f2350a, itemHolderInfo2.f2351b);
    }

    public final boolean mo712a(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        int i3 = itemHolderInfo.f2350a;
        int i4 = itemHolderInfo.f2351b;
        if (viewHolder2.m2222b()) {
            itemHolderInfo2 = itemHolderInfo.f2350a;
            i = itemHolderInfo.f2351b;
            i2 = itemHolderInfo2;
        } else {
            i2 = itemHolderInfo2.f2350a;
            i = itemHolderInfo2.f2351b;
        }
        return mo3233a(viewHolder, viewHolder2, i3, i4, i2, i);
    }
}
