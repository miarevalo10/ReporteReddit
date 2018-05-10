package com.reddit.frontpage.commons.analytics;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.reddit.frontpage.commons.analytics.AppAnalytics.FocusListenerBuilder;

final /* synthetic */ class AppAnalytics$FocusListenerBuilder$$Lambda$0 implements OnFocusChangeListener {
    private final FocusListenerBuilder f19971a;

    AppAnalytics$FocusListenerBuilder$$Lambda$0(FocusListenerBuilder focusListenerBuilder) {
        this.f19971a = focusListenerBuilder;
    }

    public final void onFocusChange(View view, boolean z) {
        view = this.f19971a;
        if (z) {
            z = AppAnalytics.m21858b();
            z.f19954a = view.f19972a;
            z.f19955b = view.f19973b;
            z.m21825a();
        }
    }
}
