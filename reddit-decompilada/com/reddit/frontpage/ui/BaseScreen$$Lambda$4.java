package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class BaseScreen$$Lambda$4 implements OnClickListener {
    private final BaseScreen f21061a;

    BaseScreen$$Lambda$4(BaseScreen baseScreen) {
        this.f21061a = baseScreen;
    }

    public final void onClick(View view) {
        view = this.f21061a;
        SessionManager.b().a(Util.m24019e(view.am_()), false);
        view.aw();
    }
}
