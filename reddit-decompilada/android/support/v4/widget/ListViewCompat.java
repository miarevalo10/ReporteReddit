package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class ListViewCompat {
    public static void m1409a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }

    public static boolean m1410a(ListView listView) {
        if (VERSION.SDK_INT >= 19) {
            return listView.canScrollList(-1);
        }
        if (listView.getChildCount() == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int top = listView.getChildAt(0).getTop();
        if (firstVisiblePosition <= 0) {
            if (top >= listView.getListPaddingTop()) {
                return false;
            }
        }
        return true;
    }
}
