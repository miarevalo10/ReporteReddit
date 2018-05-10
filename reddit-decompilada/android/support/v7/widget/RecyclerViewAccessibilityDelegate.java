package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    final RecyclerView f12043e;
    final AccessibilityDelegateCompat f12044f = new ItemDelegate(this);

    public static class ItemDelegate extends AccessibilityDelegateCompat {
        final RecyclerViewAccessibilityDelegate f12042a;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f12042a = recyclerViewAccessibilityDelegate;
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            if (!this.f12042a.f12043e.hasPendingAdapterUpdates() && this.f12042a.f12043e.getLayoutManager() != null) {
                this.f12042a.f12043e.getLayoutManager().m2106a(view, accessibilityNodeInfoCompat);
            }
        }

        public final boolean mo82a(View view, int i, Bundle bundle) {
            if (super.mo82a(view, i, bundle) != null) {
                return true;
            }
            if (this.f12042a.f12043e.hasPendingAdapterUpdates() != null || this.f12042a.f12043e.getLayoutManager() == null) {
                return false;
            }
            view = this.f12042a.f12043e.getLayoutManager();
            bundle = view.f2372q.mRecycler;
            view = view.f2372q.mState;
            return false;
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f12043e = recyclerView;
    }

    public final boolean mo82a(View view, int i, Bundle bundle) {
        if (super.mo82a(view, i, bundle) != null) {
            return true;
        }
        if (this.f12043e.hasPendingAdapterUpdates() != null || this.f12043e.getLayoutManager() == null) {
            return false;
        }
        view = this.f12043e.getLayoutManager();
        Recycler recycler = view.f2372q.mRecycler;
        State state = view.f2372q.mState;
        if (view.f2372q == null) {
            return false;
        }
        int i2;
        if (i != 4096) {
            if (i != 8192) {
                i = 0;
                i2 = i;
            } else {
                i = view.f2372q.canScrollVertically(-1) != 0 ? -((view.f2368E - view.m2155u()) - view.m2157w()) : 0;
                if (view.f2372q.canScrollHorizontally(-1)) {
                    i2 = -((view.f2367D - view.m2154t()) - view.m2156v());
                }
            }
            if (i != 0 && i2 == 0) {
                return false;
            }
            view.f2372q.scrollBy(i2, i);
            return true;
        }
        i = view.f2372q.canScrollVertically(1) != 0 ? (view.f2368E - view.m2155u()) - view.m2157w() : 0;
        if (view.f2372q.canScrollHorizontally(1)) {
            i2 = (view.f2367D - view.m2154t()) - view.m2156v();
            if (i != 0) {
            }
            view.f2372q.scrollBy(i2, i);
            return true;
        }
        i2 = 0;
        if (i != 0) {
        }
        view.f2372q.scrollBy(i2, i);
        return true;
    }

    public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.mo38a(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.m1324a(RecyclerView.class.getName());
        if (this.f12043e.hasPendingAdapterUpdates() == null && this.f12043e.getLayoutManager() != null) {
            view = this.f12043e.getLayoutManager();
            Recycler recycler = view.f2372q.mRecycler;
            State state = view.f2372q.mState;
            if (view.f2372q.canScrollVertically(-1) || view.f2372q.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.m1321a(8192);
                accessibilityNodeInfoCompat.m1334d(true);
            }
            if (view.f2372q.canScrollVertically(1) || view.f2372q.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.m1321a(4096);
                accessibilityNodeInfoCompat.m1334d(true);
            }
            view = CollectionInfoCompat.m1316a(view.mo718a(recycler, state), view.mo726b(recycler, state));
            if (VERSION.SDK_INT >= 19) {
                accessibilityNodeInfoCompat.f1523a.setCollectionInfo((CollectionInfo) ((CollectionInfoCompat) view).f1521a);
            }
        }
    }

    public final void mo84a(View view, AccessibilityEvent accessibilityEvent) {
        super.mo84a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !this.f12043e.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo631a(accessibilityEvent);
            }
        }
    }

    public AccessibilityDelegateCompat mo3197a() {
        return this.f12044f;
    }
}
