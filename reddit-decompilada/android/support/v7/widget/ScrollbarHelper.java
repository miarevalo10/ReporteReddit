package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class ScrollbarHelper {
    static int m2257a(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        if (!(layoutManager.m2151q() == null || state.getItemCount() == null || view == null)) {
            if (view2 != null) {
                layoutManager = Math.min(LayoutManager.m2070a(view), LayoutManager.m2070a(view2));
                int max = Math.max(LayoutManager.m2070a(view), LayoutManager.m2070a(view2));
                if (z2) {
                    state = Math.max(0, (state.getItemCount() - max) - 1);
                } else {
                    state = Math.max(0, layoutManager);
                }
                if (!z) {
                    return state;
                }
                return Math.round((((float) state) * (((float) Math.abs(orientationHelper.mo664b(view2) - orientationHelper.mo661a(view))) / ((float) (Math.abs(LayoutManager.m2070a(view) - LayoutManager.m2070a(view2)) + 1)))) + ((float) (orientationHelper.mo663b() - orientationHelper.mo661a(view))));
            }
        }
        return 0;
    }

    static int m2256a(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (!(layoutManager.m2151q() == null || state.getItemCount() == null || view == null)) {
            if (view2 != null) {
                if (!z) {
                    return Math.abs(LayoutManager.m2070a(view) - LayoutManager.m2070a(view2)) + 1;
                }
                return Math.min(orientationHelper.mo669e(), orientationHelper.mo664b(view2) - orientationHelper.mo661a(view));
            }
        }
        return null;
    }

    static int m2258b(State state, OrientationHelper orientationHelper, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (!(layoutManager.m2151q() == null || state.getItemCount() == null || view == null)) {
            if (view2 != null) {
                if (!z) {
                    return state.getItemCount();
                }
                return (int) ((((float) (orientationHelper.mo664b(view2) - orientationHelper.mo661a(view))) / ((float) (Math.abs(LayoutManager.m2070a(view) - LayoutManager.m2070a(view2)) + 1))) * ((float) state.getItemCount()));
            }
        }
        return null;
    }
}
