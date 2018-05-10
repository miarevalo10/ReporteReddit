package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class WindowInsetsCompat {
    public final Object f1489a;

    private WindowInsetsCompat(Object obj) {
        this.f1489a = obj;
    }

    public final int m1307a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1489a).getSystemWindowInsetLeft() : 0;
    }

    public final int m1309b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1489a).getSystemWindowInsetTop() : 0;
    }

    public final int m1310c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1489a).getSystemWindowInsetRight() : 0;
    }

    public final int m1311d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1489a).getSystemWindowInsetBottom() : 0;
    }

    public final boolean m1312e() {
        return VERSION.SDK_INT >= 21 ? ((WindowInsets) this.f1489a).isConsumed() : false;
    }

    public final WindowInsetsCompat m1313f() {
        return VERSION.SDK_INT >= 20 ? new WindowInsetsCompat(((WindowInsets) this.f1489a).consumeSystemWindowInsets()) : null;
    }

    public final WindowInsetsCompat m1308a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new WindowInsetsCompat(((WindowInsets) this.f1489a).replaceSystemWindowInsets(i, i2, i3, i4)) : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                WindowInsetsCompat windowInsetsCompat = (WindowInsetsCompat) obj;
                if (this.f1489a == null) {
                    return windowInsetsCompat.f1489a == null;
                } else {
                    return this.f1489a.equals(windowInsetsCompat.f1489a);
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f1489a == null ? 0 : this.f1489a.hashCode();
    }

    static WindowInsetsCompat m1305a(Object obj) {
        return obj == null ? null : new WindowInsetsCompat(obj);
    }

    static Object m1306a(WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat == null ? null : windowInsetsCompat.f1489a;
    }
}
