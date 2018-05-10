package android.support.v7.preference;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;

public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
    final RecyclerView f16588a;
    final AccessibilityDelegateCompat f16589c = super.mo3197a();
    final AccessibilityDelegateCompat f16590d = new C10171(this);

    class C10171 extends AccessibilityDelegateCompat {
        final /* synthetic */ PreferenceRecyclerViewAccessibilityDelegate f11652a;

        C10171(PreferenceRecyclerViewAccessibilityDelegate preferenceRecyclerViewAccessibilityDelegate) {
            this.f11652a = preferenceRecyclerViewAccessibilityDelegate;
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.f11652a.f16589c.mo38a(view, accessibilityNodeInfoCompat);
            view = this.f11652a.f16588a.getChildAdapterPosition(view);
            Adapter adapter = this.f11652a.f16588a.getAdapter();
            if (adapter instanceof PreferenceGroupAdapter) {
                view = ((PreferenceGroupAdapter) adapter).m10366c(view);
                if (view != null) {
                    view.mo3188a(accessibilityNodeInfoCompat);
                }
            }
        }

        public final boolean mo82a(View view, int i, Bundle bundle) {
            return this.f11652a.f16589c.mo82a(view, i, bundle);
        }
    }

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f16588a = recyclerView;
    }

    public final AccessibilityDelegateCompat mo3197a() {
        return this.f16590d;
    }
}
