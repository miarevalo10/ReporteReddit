package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class ViewOffsetHelper {
    int f721a;
    int f722b;
    int f723c;
    private final View f724d;
    private int f725e;

    public ViewOffsetHelper(View view) {
        this.f724d = view;
    }

    public final void m354a() {
        this.f721a = this.f724d.getTop();
        this.f725e = this.f724d.getLeft();
        m356b();
    }

    final void m356b() {
        ViewCompat.m1231b(this.f724d, this.f722b - (this.f724d.getTop() - this.f721a));
        ViewCompat.m1236c(this.f724d, this.f723c - (this.f724d.getLeft() - this.f725e));
    }

    public final boolean m355a(int i) {
        if (this.f722b == i) {
            return false;
        }
        this.f722b = i;
        m356b();
        return true;
    }
}
