package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    public boolean f1442a;
    private ViewParent f1443b;
    private ViewParent f1444c;
    private final View f1445d;
    private int[] f1446e;

    public NestedScrollingChildHelper(View view) {
        this.f1445d = view;
    }

    public final void m1124a(boolean z) {
        if (this.f1442a) {
            ViewCompat.m1205F(this.f1445d);
        }
        this.f1442a = z;
    }

    public final boolean m1127a(int i) {
        return m1123c(i) != 0;
    }

    public final boolean m1128a(int i, int i2) {
        if (m1127a(i2)) {
            return true;
        }
        if (this.f1442a) {
            View view = this.f1445d;
            for (ViewParent parent = this.f1445d.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.m1288a(parent, view, this.f1445d, i, i2)) {
                    m1122a(i2, parent);
                    ViewParentCompat.m1289b(parent, view, this.f1445d, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final void m1133b(int i) {
        ViewParent c = m1123c(i);
        if (c != null) {
            ViewParentCompat.m1283a(c, this.f1445d, i);
            m1122a(i, null);
        }
    }

    public final boolean m1129a(int i, int i2, int i3, int i4, int[] iArr) {
        return m1130a(i, i2, i3, i4, iArr, 0);
    }

    public final boolean m1131a(int i, int i2, int[] iArr, int[] iArr2) {
        return m1132a(i, i2, iArr, iArr2, 0);
    }

    private ViewParent m1123c(int i) {
        switch (i) {
            case 0:
                return this.f1443b;
            case 1:
                return this.f1444c;
            default:
                return 0;
        }
    }

    private void m1122a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f1443b = viewParent;
                return;
            case 1:
                this.f1444c = viewParent;
                break;
            default:
                break;
        }
    }

    public final boolean m1130a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        int[] iArr2 = iArr;
        if (this.f1442a) {
            int i6 = i5;
            ViewParent c = m1123c(i6);
            if (c == null) {
                return false;
            }
            int i7;
            int i8;
            if (i == 0 && i2 == 0 && i3 == 0) {
                if (i4 == 0) {
                    if (iArr2 != null) {
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                }
            }
            if (iArr2 != null) {
                r0.f1445d.getLocationInWindow(iArr2);
                i7 = iArr2[0];
                i8 = iArr2[1];
            } else {
                i7 = 0;
                i8 = i7;
            }
            ViewParentCompat.m1284a(c, r0.f1445d, i, i2, i3, i4, i6);
            if (iArr2 != null) {
                r0.f1445d.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i7;
                iArr2[1] = iArr2[1] - i8;
            }
            return true;
        }
        return false;
    }

    public final boolean m1132a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (this.f1442a) {
            ViewParent c = m1123c(i3);
            if (c == null) {
                return false;
            }
            int i4;
            int i5;
            if (i == 0) {
                if (i2 == 0) {
                    if (iArr2 != null) {
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                }
            }
            if (iArr2 != null) {
                this.f1445d.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = i4;
            }
            if (iArr == null) {
                if (this.f1446e == null) {
                    this.f1446e = new int[2];
                }
                iArr = this.f1446e;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.m1285a(c, this.f1445d, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f1445d.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            if (iArr[0] == 0) {
                if (iArr[1] == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean m1126a(float f, float f2, boolean z) {
        if (this.f1442a) {
            ViewParent c = m1123c(0);
            if (c != null) {
                return ViewParentCompat.m1287a(c, this.f1445d, f, f2, z);
            }
        }
        return false;
    }

    public final boolean m1125a(float f, float f2) {
        if (this.f1442a) {
            ViewParent c = m1123c(0);
            if (c != null) {
                return ViewParentCompat.m1286a(c, this.f1445d, f, f2);
            }
        }
        return false;
    }
}
