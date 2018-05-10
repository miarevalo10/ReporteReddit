package android.support.v4.widget;

import android.widget.ListView;

public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView f11496f;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.f11496f = listView;
    }

    public final void mo396a(int i) {
        ListViewCompat.m1409a(this.f11496f, i);
    }

    public final boolean mo397b(int i) {
        ListView listView = this.f11496f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 < count || listView.getChildAt(childCount - 1).getBottom() > listView.getHeight()) {
                return true;
            }
            return false;
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < 0) {
                return true;
            }
            return false;
        }
        return true;
    }
}
