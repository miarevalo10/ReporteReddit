package com.reddit.frontpage.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SmoothScrollUtil {
    public static int m23906a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.getChildCount() == 0) {
            return 0;
        }
        View childAt = recyclerView.getChildAt(0);
        recyclerView = Math.abs((recyclerView.getChildAdapterPosition(childAt) - i2) * (i == 1 ? childAt.getHeight() : childAt.getWidth()));
        if (recyclerView == null) {
            recyclerView = (int) Math.abs(i == 1 ? childAt.getY() : childAt.getX());
        }
        return recyclerView;
    }
}
