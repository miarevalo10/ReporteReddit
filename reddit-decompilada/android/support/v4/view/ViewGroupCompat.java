package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.compat.C0003R;
import android.view.ViewGroup;

public final class ViewGroupCompat {
    static final ViewGroupCompatBaseImpl f1464a;

    static class ViewGroupCompatBaseImpl {
        ViewGroupCompatBaseImpl() {
        }

        public boolean mo3148a(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(C0003R.id.tag_transition_group);
            if ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null) {
                if (ViewCompat.m1262w(viewGroup) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    @RequiresApi(18)
    static class ViewGroupCompatApi18Impl extends ViewGroupCompatBaseImpl {
        ViewGroupCompatApi18Impl() {
        }
    }

    @RequiresApi(21)
    static class ViewGroupCompatApi21Impl extends ViewGroupCompatApi18Impl {
        ViewGroupCompatApi21Impl() {
        }

        public final boolean mo3148a(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1464a = new ViewGroupCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 18) {
            f1464a = new ViewGroupCompatApi18Impl();
        } else {
            f1464a = new ViewGroupCompatBaseImpl();
        }
    }

    @Deprecated
    public static void m1270a(ViewGroup viewGroup) {
        viewGroup.setMotionEventSplittingEnabled(false);
    }

    public static boolean m1271b(ViewGroup viewGroup) {
        return f1464a.mo3148a(viewGroup);
    }
}
