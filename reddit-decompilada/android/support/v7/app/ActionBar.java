package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class ActionBar {

    public static class LayoutParams extends MarginLayoutParams {
        public int f1696a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1696a = 0;
            context = context.obtainStyledAttributes(attributeSet, C0164R.styleable.ActionBarLayout);
            this.f1696a = context.getInt(C0164R.styleable.ActionBarLayout_android_layout_gravity, 0);
            context.recycle();
        }

        public LayoutParams() {
            super(-2, -2);
            this.f1696a = 0;
            this.f1696a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1696a = 0;
            this.f1696a = layoutParams.f1696a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1696a = null;
        }
    }

    @Deprecated
    public static abstract class Tab {
        public abstract Drawable m1470a();

        public abstract CharSequence m1471b();

        public abstract View m1472c();

        public abstract CharSequence m1473d();
    }

    public abstract int mo436a();

    public ActionMode mo475a(Callback callback) {
        return null;
    }

    public abstract void mo437a(int i);

    public void mo438a(Configuration configuration) {
    }

    public void mo439a(Drawable drawable) {
    }

    public abstract void mo440a(CharSequence charSequence);

    public abstract void mo441a(boolean z);

    public boolean mo442a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean mo443a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void mo444b();

    public void mo445b(CharSequence charSequence) {
    }

    public abstract void mo446b(boolean z);

    public abstract void mo447c();

    public abstract void mo448c(boolean z);

    public void mo449d(boolean z) {
    }

    public abstract boolean mo450d();

    public Context mo451e() {
        return null;
    }

    public void mo452e(boolean z) {
    }

    public void mo453f() {
    }

    public void mo454f(boolean z) {
    }

    public boolean mo455g() {
        return false;
    }

    public boolean mo456h() {
        return false;
    }

    public boolean mo457i() {
        return false;
    }

    public boolean mo458j() {
        return false;
    }

    void mo459k() {
    }
}
