package com.reddit.frontpage.util;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TwoActionSnackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import timber.log.Timber;

public class ViewUtils {
    public static Snackbar m24059a(View view, int i, int i2) {
        if (m24063b(view)) {
            view = Snackbar.a(view, i, i2);
            m24062a(view.d);
            return view;
        }
        Timber.e("ViewUtils.makeSnackbar: no suitable parent for snackbar", new Object[0]);
        return null;
    }

    public static Snackbar m24060a(View view, CharSequence charSequence, int i) {
        if (m24063b(view)) {
            view = Snackbar.a(view, charSequence, i);
            m24062a(view.d);
            return view;
        }
        Timber.e("ViewUtils.makeSnackbar: no suitable parent for snackbar", new Object[null]);
        return null;
    }

    public static TwoActionSnackbar m24061a(View view, int i) {
        view = TwoActionSnackbar.a(view, i);
        m24062a(view.b);
        return view;
    }

    private static void m24062a(View view) {
        view.setBackgroundColor(Util.m23950a((int) C1761R.color.rdt_semi_black));
        TextView textView = (TextView) view.findViewById(C1761R.id.snackbar_text);
        if (textView != null) {
            textView.setTextColor(Util.m23950a((int) C1761R.color.rdt_white));
        }
    }

    private static boolean m24063b(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return true;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                view = view.getParent();
                if (view instanceof View) {
                    view = view;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                if (viewGroup == null) {
                    return null;
                }
                return true;
            }
        }
        return true;
    }
}
