package com.reddit.frontpage.ui;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class BaseScreen$$Lambda$2 implements OnClickListener {
    private final BaseScreen f21060a;

    BaseScreen$$Lambda$2(BaseScreen baseScreen) {
        this.f21060a = baseScreen;
    }

    public final void onClick(View view) {
        view = this.f21060a.f37155J;
        View a = view.a(8388611);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("No drawer view found with gravity ");
            stringBuilder.append(DrawerLayout.b(8388611));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        view.e(a);
    }
}
