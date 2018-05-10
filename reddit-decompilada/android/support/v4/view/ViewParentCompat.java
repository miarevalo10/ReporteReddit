package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class ViewParentCompat {
    static final ViewParentCompatBaseImpl f1478a;

    static class ViewParentCompatBaseImpl {
        ViewParentCompatBaseImpl() {
        }

        public boolean mo3154a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i) : null;
        }

        public void mo3155b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo3149a(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo3150a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo3151a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo3153a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z) : null;
        }

        public boolean mo3152a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2) : null;
        }
    }

    @RequiresApi(19)
    static class ViewParentCompatApi19Impl extends ViewParentCompatBaseImpl {
        ViewParentCompatApi19Impl() {
        }
    }

    @RequiresApi(21)
    static class ViewParentCompatApi21Impl extends ViewParentCompatApi19Impl {
        ViewParentCompatApi21Impl() {
        }

        public final boolean mo3154a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (View view3) {
                i = new StringBuilder("ViewParent ");
                i.append(viewParent);
                i.append(" does not implement interface method onStartNestedScroll");
                Log.e("ViewParentCompat", i.toString(), view3);
                return null;
            }
        }

        public final void mo3155b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (View view3) {
                i = new StringBuilder("ViewParent ");
                i.append(viewParent);
                i.append(" does not implement interface method onNestedScrollAccepted");
                Log.e("ViewParentCompat", i.toString(), view3);
            }
        }

        public final void mo3149a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (View view2) {
                StringBuilder stringBuilder = new StringBuilder("ViewParent ");
                stringBuilder.append(viewParent);
                stringBuilder.append(" does not implement interface method onStopNestedScroll");
                Log.e("ViewParentCompat", stringBuilder.toString(), view2);
            }
        }

        public final void mo3150a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (View view2) {
                i2 = new StringBuilder("ViewParent ");
                i2.append(viewParent);
                i2.append(" does not implement interface method onNestedScroll");
                Log.e("ViewParentCompat", i2.toString(), view2);
            }
        }

        public final void mo3151a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (View view2) {
                i2 = new StringBuilder("ViewParent ");
                i2.append(viewParent);
                i2.append(" does not implement interface method onNestedPreScroll");
                Log.e("ViewParentCompat", i2.toString(), view2);
            }
        }

        public final boolean mo3153a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (View view2) {
                f2 = new StringBuilder("ViewParent ");
                f2.append(viewParent);
                f2.append(" does not implement interface method onNestedFling");
                Log.e("ViewParentCompat", f2.toString(), view2);
                return null;
            }
        }

        public final boolean mo3152a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (View view2) {
                f2 = new StringBuilder("ViewParent ");
                f2.append(viewParent);
                f2.append(" does not implement interface method onNestedPreFling");
                Log.e("ViewParentCompat", f2.toString(), view2);
                return null;
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1478a = new ViewParentCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            f1478a = new ViewParentCompatApi19Impl();
        } else {
            f1478a = new ViewParentCompatBaseImpl();
        }
    }

    public static boolean m1288a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).mo3083a(view, view2, i, i2);
        }
        return i2 == 0 ? f1478a.mo3154a(viewParent, view, view2, i) : null;
    }

    public static void m1289b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo3084b(view2, i);
            return;
        }
        if (i2 == 0) {
            f1478a.mo3155b(viewParent, view, view2, i);
        }
    }

    public static void m1283a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo3085c(view, i);
            return;
        }
        if (i == 0) {
            f1478a.mo3149a(viewParent, view);
        }
    }

    public static void m1284a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo3081a(view, i2, i4, i5);
            return;
        }
        if (i5 == 0) {
            f1478a.mo3150a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void m1285a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).mo3082a(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            f1478a.mo3151a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean m1287a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1478a.mo3153a(viewParent, view, f, f2, z);
    }

    public static boolean m1286a(ViewParent viewParent, View view, float f, float f2) {
        return f1478a.mo3152a(viewParent, view, f, f2);
    }
}
