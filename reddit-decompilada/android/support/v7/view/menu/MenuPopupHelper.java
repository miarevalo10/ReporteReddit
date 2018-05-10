package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class MenuPopupHelper {
    protected View f2036a;
    public int f2037b;
    public OnDismissListener f2038c;
    private final Context f2039d;
    private final MenuBuilder f2040e;
    private final boolean f2041f;
    private final int f2042g;
    private final int f2043h;
    private boolean f2044i;
    private Callback f2045j;
    private MenuPopup f2046k;
    private final OnDismissListener f2047l;

    class C01871 implements OnDismissListener {
        final /* synthetic */ MenuPopupHelper f2035a;

        C01871(MenuPopupHelper menuPopupHelper) {
            this.f2035a = menuPopupHelper;
        }

        public void onDismiss() {
            this.f2035a.mo567e();
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f2037b = 8388611;
        this.f2047l = new C01871(this);
        this.f2039d = context;
        this.f2040e = menuBuilder;
        this.f2036a = view;
        this.f2041f = z;
        this.f2042g = i;
        this.f2043h = i2;
    }

    public final void m1717a(boolean z) {
        this.f2044i = z;
        if (this.f2046k != null) {
            this.f2046k.mo3205b(z);
        }
    }

    public final void m1714a() {
        if (!m1719c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final MenuPopup m1718b() {
        if (this.f2046k == null) {
            Display defaultDisplay = ((WindowManager) this.f2039d.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            if ((Math.min(point.x, point.y) >= this.f2039d.getResources().getDimensionPixelSize(C0164R.dimen.abc_cascading_menus_min_smallest_width) ? 1 : null) != null) {
                MenuPopup cascadingMenuPopup = new CascadingMenuPopup(this.f2039d, this.f2036a, this.f2042g, this.f2043h, this.f2041f);
            } else {
                MenuPopup standardMenuPopup = new StandardMenuPopup(this.f2039d, this.f2040e, this.f2036a, this.f2042g, this.f2043h, this.f2041f);
            }
            r0.mo3201a(this.f2040e);
            r0.mo3203a(this.f2047l);
            r0.mo3202a(this.f2036a);
            r0.mo48a(this.f2045j);
            r0.mo3205b(this.f2044i);
            r0.mo3200a(this.f2037b);
            this.f2046k = r0;
        }
        return this.f2046k;
    }

    public final boolean m1719c() {
        if (m1722f()) {
            return true;
        }
        if (this.f2036a == null) {
            return false;
        }
        m1715a(0, 0, false, false);
        return true;
    }

    final void m1715a(int i, int i2, boolean z, boolean z2) {
        MenuPopup b = m1718b();
        b.mo3207c(z2);
        if (z) {
            if (GravityCompat.m1096a(this.f2037b, ViewCompat.m1242f(this.f2036a)) & 7) {
                i += this.f2036a.getWidth();
            }
            b.mo3204b(i);
            b.mo3206c(i2);
            z = (int) ((true * this.f2039d.getResources().getDisplayMetrics().density) / true);
            b.f11804e = new Rect(i - z, i2 - z, i + z, i2 + z);
        }
        b.mo653d();
    }

    public final void m1720d() {
        if (m1722f()) {
            this.f2046k.mo654e();
        }
    }

    protected void mo567e() {
        this.f2046k = null;
        if (this.f2038c != null) {
            this.f2038c.onDismiss();
        }
    }

    public final boolean m1722f() {
        return this.f2046k != null && this.f2046k.mo655f();
    }

    public final void m1716a(Callback callback) {
        this.f2045j = callback;
        if (this.f2046k != null) {
            this.f2046k.mo48a(callback);
        }
    }
}
