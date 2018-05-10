package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private ViewOffsetHelper f11184a;
    private int f11185b = 0;
    private int f11186c = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo75a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo3087b(coordinatorLayout, v, i);
        if (this.f11184a == null) {
            this.f11184a = new ViewOffsetHelper(v);
        }
        this.f11184a.m354a();
        if (this.f11185b != null) {
            this.f11184a.m355a(this.f11185b);
            this.f11185b = 0;
        }
        if (this.f11186c != null) {
            coordinatorLayout = this.f11184a;
            i = this.f11186c;
            if (coordinatorLayout.f723c != i) {
                coordinatorLayout.f723c = i;
                coordinatorLayout.m356b();
            }
            this.f11186c = 0;
        }
        return true;
    }

    protected void mo3087b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m16546a((View) v, i);
    }

    public boolean mo3824a(int i) {
        if (this.f11184a != null) {
            return this.f11184a.m355a(i);
        }
        this.f11185b = i;
        return false;
    }

    public int mo3828c() {
        return this.f11184a != null ? this.f11184a.f722b : 0;
    }
}
