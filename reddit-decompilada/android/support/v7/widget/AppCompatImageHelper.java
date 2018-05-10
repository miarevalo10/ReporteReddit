package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageHelper {
    private final ImageView f2156a;
    private TintInfo f2157b;
    private TintInfo f2158c;
    private TintInfo f2159d;

    public AppCompatImageHelper(ImageView imageView) {
        this.f2156a = imageView;
    }

    public final void m1825a(AttributeSet attributeSet, int i) {
        attributeSet = TintTypedArray.m2308a(this.f2156a.getContext(), attributeSet, C0164R.styleable.AppCompatImageView, i, 0);
        try {
            i = this.f2156a.getDrawable();
            if (i == 0) {
                int g = attributeSet.m2323g(C0164R.styleable.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    i = AppCompatResources.m1570b(this.f2156a.getContext(), g);
                    if (i != 0) {
                        this.f2156a.setImageDrawable(i);
                    }
                }
            }
            if (i != 0) {
                DrawableUtils.m1959b(i);
            }
            if (attributeSet.m2322f(C0164R.styleable.AppCompatImageView_tint) != 0) {
                ImageViewCompat.m1406a(this.f2156a, attributeSet.m2320e(C0164R.styleable.AppCompatImageView_tint));
            }
            if (attributeSet.m2322f(C0164R.styleable.AppCompatImageView_tintMode) != 0) {
                ImageViewCompat.m1407a(this.f2156a, DrawableUtils.m1957a(attributeSet.m2310a(C0164R.styleable.AppCompatImageView_tintMode, -1), null));
            }
            attributeSet.f2595b.recycle();
        } catch (Throwable th) {
            attributeSet.f2595b.recycle();
        }
    }

    public final void m1822a(int i) {
        if (i != 0) {
            i = AppCompatResources.m1570b(this.f2156a.getContext(), i);
            if (i != 0) {
                DrawableUtils.m1959b(i);
            }
            this.f2156a.setImageDrawable(i);
        } else {
            this.f2156a.setImageDrawable(null);
        }
        m1829d();
    }

    final boolean m1826a() {
        return VERSION.SDK_INT < 21 || !(this.f2156a.getBackground() instanceof RippleDrawable);
    }

    final void m1823a(ColorStateList colorStateList) {
        if (this.f2158c == null) {
            this.f2158c = new TintInfo();
        }
        this.f2158c.f2590a = colorStateList;
        this.f2158c.f2593d = true;
        m1829d();
    }

    final ColorStateList m1827b() {
        return this.f2158c != null ? this.f2158c.f2590a : null;
    }

    final void m1824a(Mode mode) {
        if (this.f2158c == null) {
            this.f2158c = new TintInfo();
        }
        this.f2158c.f2591b = mode;
        this.f2158c.f2592c = true;
        m1829d();
    }

    final Mode m1828c() {
        return this.f2158c != null ? this.f2158c.f2591b : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m1829d() {
        /*
        r5 = this;
        r0 = r5.f2156a;
        r0 = r0.getDrawable();
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        android.support.v7.widget.DrawableUtils.m1959b(r0);
    L_0x000b:
        if (r0 == 0) goto L_0x007e;
    L_0x000d:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        r3 = 0;
        r4 = 1;
        if (r1 <= r2) goto L_0x001d;
    L_0x0015:
        r1 = r5.f2157b;
        if (r1 == 0) goto L_0x001b;
    L_0x0019:
        r1 = r4;
        goto L_0x0020;
    L_0x001b:
        r1 = r3;
        goto L_0x0020;
    L_0x001d:
        if (r1 != r2) goto L_0x001b;
    L_0x001f:
        goto L_0x0019;
    L_0x0020:
        if (r1 == 0) goto L_0x005f;
    L_0x0022:
        r1 = r5.f2159d;
        if (r1 != 0) goto L_0x002d;
    L_0x0026:
        r1 = new android.support.v7.widget.TintInfo;
        r1.<init>();
        r5.f2159d = r1;
    L_0x002d:
        r1 = r5.f2159d;
        r1.m2305a();
        r2 = r5.f2156a;
        r2 = android.support.v4.widget.ImageViewCompat.m1405a(r2);
        if (r2 == 0) goto L_0x003e;
    L_0x003a:
        r1.f2593d = r4;
        r1.f2590a = r2;
    L_0x003e:
        r2 = r5.f2156a;
        r2 = android.support.v4.widget.ImageViewCompat.m1408b(r2);
        if (r2 == 0) goto L_0x004a;
    L_0x0046:
        r1.f2592c = r4;
        r1.f2591b = r2;
    L_0x004a:
        r2 = r1.f2593d;
        if (r2 != 0) goto L_0x0052;
    L_0x004e:
        r2 = r1.f2592c;
        if (r2 == 0) goto L_0x005c;
    L_0x0052:
        r2 = r5.f2156a;
        r2 = r2.getDrawableState();
        android.support.v7.widget.AppCompatDrawableManager.m1811a(r0, r1, r2);
        r3 = r4;
    L_0x005c:
        if (r3 == 0) goto L_0x005f;
    L_0x005e:
        return;
    L_0x005f:
        r1 = r5.f2158c;
        if (r1 == 0) goto L_0x006f;
    L_0x0063:
        r1 = r5.f2158c;
        r2 = r5.f2156a;
        r2 = r2.getDrawableState();
        android.support.v7.widget.AppCompatDrawableManager.m1811a(r0, r1, r2);
        return;
    L_0x006f:
        r1 = r5.f2157b;
        if (r1 == 0) goto L_0x007e;
    L_0x0073:
        r1 = r5.f2157b;
        r2 = r5.f2156a;
        r2 = r2.getDrawableState();
        android.support.v7.widget.AppCompatDrawableManager.m1811a(r0, r1, r2);
    L_0x007e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatImageHelper.d():void");
    }
}
