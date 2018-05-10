package com.reddit.frontpage.util.kotlin;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\"\u0010\t\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"getPosition", "", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "isFirst", "", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "isLast", "state", "Landroid/support/v7/widget/RecyclerView$State;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: ItemDecorations.kt */
public final class ItemDecorationsKt {
    public static final boolean m24082a(ItemDecoration itemDecoration, View view, RecyclerView recyclerView) {
        Intrinsics.m26847b(itemDecoration, "$receiver");
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(recyclerView, "parent");
        return recyclerView.getChildAdapterPosition(view) == null ? true : null;
    }

    public static final boolean m24083a(ItemDecoration itemDecoration, View view, RecyclerView recyclerView, State state) {
        Intrinsics.m26847b(itemDecoration, "$receiver");
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(recyclerView, "parent");
        Intrinsics.m26847b(state, "state");
        return recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1 ? true : null;
    }
}
