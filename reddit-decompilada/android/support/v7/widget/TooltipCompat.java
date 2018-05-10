package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class TooltipCompat {
    private static final ViewCompatImpl f2642a;

    private interface ViewCompatImpl {
        void mo768a(View view, CharSequence charSequence);
    }

    @TargetApi(26)
    private static class Api26ViewCompatImpl implements ViewCompatImpl {
        private Api26ViewCompatImpl() {
        }

        public final void mo768a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private static class BaseViewCompatImpl implements ViewCompatImpl {
        private BaseViewCompatImpl() {
        }

        public final void mo768a(View view, CharSequence charSequence) {
            TooltipCompatHandler.m2352a(view, charSequence);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f2642a = new Api26ViewCompatImpl();
        } else {
            f2642a = new BaseViewCompatImpl();
        }
    }

    public static void m2349a(View view, CharSequence charSequence) {
        f2642a.mo768a(view, charSequence);
    }
}
