package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class BaseScreen$$Lambda$6 implements OnClickListener {
    private final BaseScreen f21063a;

    BaseScreen$$Lambda$6(BaseScreen baseScreen) {
        this.f21063a = baseScreen;
    }

    public final void onClick(View view) {
        SessionManager.b().a(Util.m24019e(this.f21063a.am_()), false);
    }
}
