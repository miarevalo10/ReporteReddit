package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean f2160a = (VERSION.SDK_INT < 21);
    private boolean f2161b;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        context = TintTypedArray.m2308a(context, attributeSet, C0164R.styleable.PopupWindow, i, i2);
        if (context.m2322f(C0164R.styleable.PopupWindow_overlapAnchor) != null) {
            boolean a = context.m2312a(C0164R.styleable.PopupWindow_overlapAnchor, (boolean) 0);
            if (f2160a != 0) {
                this.f2161b = a;
            } else {
                PopupWindowCompat.m1417a((PopupWindow) this, a);
            }
        }
        setBackgroundDrawable(context.m2311a(C0164R.styleable.PopupWindow_android_popupBackground));
        context.f2595b.recycle();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2160a && this.f2161b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2160a && this.f2161b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f2160a && this.f2161b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}
