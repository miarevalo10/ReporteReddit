package com.reddit.frontpage.ui.listing.newcard;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Landroid/support/v7/widget/RecyclerView;)V", "notifyItemOfScreenChange", "", "position", "", "onScreen", "", "notifyItemsOfScreenChange", "start", "end", "notifyVisibleItemsOfScreenChange", "ItemChangedListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: VisibilityDependentDelegate.kt */
public final class VisibilityDependentDelegate {
    private final RecyclerView f21381a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate$ItemChangedListener;", "", "notifyItemOfScreenChange", "", "position", "", "onScreen", "", "notifyItemsOfScreenChange", "start", "end", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: VisibilityDependentDelegate.kt */
    public interface ItemChangedListener {
        void mo4826a(int i);

        void mo4827a(int i, int i2);
    }

    public VisibilityDependentDelegate(RecyclerView recyclerView) {
        Intrinsics.m26847b(recyclerView, "recyclerView");
        this.f21381a = recyclerView;
    }

    public final void m23491a(int i, int i2, boolean z) {
        if (i <= i2) {
            while (true) {
                m23492a(i, z);
                if (i != i2) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void m23493a(boolean z) {
        LayoutManager layoutManager = this.f21381a.getLayoutManager();
        if (layoutManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        int k = ((LinearLayoutManager) layoutManager).k();
        LayoutManager layoutManager2 = this.f21381a.getLayoutManager();
        if (layoutManager2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        m23491a(k, ((LinearLayoutManager) layoutManager2).m(), z);
    }

    public final void m23492a(int i, boolean z) {
        i = this.f21381a.findViewHolderForAdapterPosition(i);
        if (i instanceof VisibilityDependent) {
            VisibilityDependent visibilityDependent = (VisibilityDependent) i;
            if (z) {
                visibilityDependent.ap();
                return;
            }
            visibilityDependent.aq();
        }
    }
}
