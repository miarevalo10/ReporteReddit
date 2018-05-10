package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.View;

class AppCompatBackgroundHelper {
    private final View f2126a;
    private final AppCompatDrawableManager f2127b;
    private int f2128c = -1;
    private TintInfo f2129d;
    private TintInfo f2130e;
    private TintInfo f2131f;

    AppCompatBackgroundHelper(View view) {
        this.f2126a = view;
        this.f2127b = AppCompatDrawableManager.m1809a();
    }

    final void m1795a(AttributeSet attributeSet, int i) {
        attributeSet = TintTypedArray.m2308a(this.f2126a.getContext(), attributeSet, C0164R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (attributeSet.m2322f(C0164R.styleable.ViewBackgroundHelper_android_background) != 0) {
                this.f2128c = attributeSet.m2323g(C0164R.styleable.ViewBackgroundHelper_android_background, -1);
                i = this.f2127b.m1820b(this.f2126a.getContext(), this.f2128c);
                if (i != 0) {
                    m1790b(i);
                }
            }
            if (attributeSet.m2322f(C0164R.styleable.ViewBackgroundHelper_backgroundTint) != 0) {
                ViewCompat.m1216a(this.f2126a, attributeSet.m2320e(C0164R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (attributeSet.m2322f(C0164R.styleable.ViewBackgroundHelper_backgroundTintMode) != 0) {
                ViewCompat.m1217a(this.f2126a, DrawableUtils.m1957a(attributeSet.m2310a(C0164R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            attributeSet.f2595b.recycle();
        } catch (Throwable th) {
            attributeSet.f2595b.recycle();
        }
    }

    final void m1792a(int i) {
        this.f2128c = i;
        m1790b(this.f2127b != null ? this.f2127b.m1820b(this.f2126a.getContext(), i) : 0);
        m1798d();
    }

    final void m1791a() {
        this.f2128c = -1;
        m1790b(null);
        m1798d();
    }

    final void m1793a(ColorStateList colorStateList) {
        if (this.f2130e == null) {
            this.f2130e = new TintInfo();
        }
        this.f2130e.f2590a = colorStateList;
        this.f2130e.f2593d = true;
        m1798d();
    }

    final ColorStateList m1796b() {
        return this.f2130e != null ? this.f2130e.f2590a : null;
    }

    final void m1794a(Mode mode) {
        if (this.f2130e == null) {
            this.f2130e = new TintInfo();
        }
        this.f2130e.f2591b = mode;
        this.f2130e.f2592c = true;
        m1798d();
    }

    final Mode m1797c() {
        return this.f2130e != null ? this.f2130e.f2591b : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m1798d() {
        /*
        r5 = this;
        r0 = r5.f2126a;
        r0 = r0.getBackground();
        if (r0 == 0) goto L_0x0079;
    L_0x0008:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        r3 = 0;
        r4 = 1;
        if (r1 <= r2) goto L_0x0018;
    L_0x0010:
        r1 = r5.f2129d;
        if (r1 == 0) goto L_0x0016;
    L_0x0014:
        r1 = r4;
        goto L_0x001b;
    L_0x0016:
        r1 = r3;
        goto L_0x001b;
    L_0x0018:
        if (r1 != r2) goto L_0x0016;
    L_0x001a:
        goto L_0x0014;
    L_0x001b:
        if (r1 == 0) goto L_0x005a;
    L_0x001d:
        r1 = r5.f2131f;
        if (r1 != 0) goto L_0x0028;
    L_0x0021:
        r1 = new android.support.v7.widget.TintInfo;
        r1.<init>();
        r5.f2131f = r1;
    L_0x0028:
        r1 = r5.f2131f;
        r1.m2305a();
        r2 = r5.f2126a;
        r2 = android.support.v4.view.ViewCompat.m1202C(r2);
        if (r2 == 0) goto L_0x0039;
    L_0x0035:
        r1.f2593d = r4;
        r1.f2590a = r2;
    L_0x0039:
        r2 = r5.f2126a;
        r2 = android.support.v4.view.ViewCompat.m1203D(r2);
        if (r2 == 0) goto L_0x0045;
    L_0x0041:
        r1.f2592c = r4;
        r1.f2591b = r2;
    L_0x0045:
        r2 = r1.f2593d;
        if (r2 != 0) goto L_0x004d;
    L_0x0049:
        r2 = r1.f2592c;
        if (r2 == 0) goto L_0x0057;
    L_0x004d:
        r2 = r5.f2126a;
        r2 = r2.getDrawableState();
        android.support.v7.widget.AppCompatDrawableManager.m1811a(r0, r1, r2);
        r3 = r4;
    L_0x0057:
        if (r3 == 0) goto L_0x005a;
    L_0x0059:
        return;
    L_0x005a:
        r1 = r5.f2130e;
        if (r1 == 0) goto L_0x006a;
    L_0x005e:
        r1 = r5.f2130e;
        r2 = r5.f2126a;
        r2 = r2.getDrawableState();
        android.support.v7.widget.AppCompatDrawableManager.m1811a(r0, r1, r2);
        return;
    L_0x006a:
        r1 = r5.f2129d;
        if (r1 == 0) goto L_0x0079;
    L_0x006e:
        r1 = r5.f2129d;
        r2 = r5.f2126a;
        r2 = r2.getDrawableState();
        android.support.v7.widget.AppCompatDrawableManager.m1811a(r0, r1, r2);
    L_0x0079:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatBackgroundHelper.d():void");
    }

    private void m1790b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2129d == null) {
                this.f2129d = new TintInfo();
            }
            this.f2129d.f2590a = colorStateList;
            this.f2129d.f2593d = true;
        } else {
            this.f2129d = null;
        }
        m1798d();
    }
}
