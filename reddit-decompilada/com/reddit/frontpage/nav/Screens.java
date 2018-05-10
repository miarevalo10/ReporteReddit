package com.reddit.frontpage.nav;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.reddit.frontpage.util.ViewUtils;

public class Screens {
    public static View m22633b(Screen screen) {
        return m22630a(screen).j;
    }

    public static void m22631a(Context context, int i) {
        context = Routing.m22617a(context);
        if (context != null) {
            context = ViewUtils.m24059a(m22630a(context).j, i, 0);
            if (context != null) {
                context.a();
            }
        }
    }

    public static void m22632a(Context context, String str) {
        context = Routing.m22617a(context);
        if (context != null) {
            context = ViewUtils.m24060a(m22630a(context).j, (CharSequence) str, 0);
            if (context != null) {
                context.a();
            }
        }
    }

    public static Screen m22630a(Screen screen) {
        while (screen.k != null) {
            screen = screen.k;
        }
        return screen;
    }

    public static Snackbar m22629a(Screen screen, CharSequence charSequence, int i) {
        return ViewUtils.m24060a(m22630a(screen).j, charSequence, i);
    }

    public static Snackbar m22628a(Screen screen, int i) {
        return ViewUtils.m24059a(m22630a(screen).j, i, 0);
    }
}
