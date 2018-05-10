package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class LoggedOutScreen$$Lambda$0 implements OnClickListener {
    private final LoggedOutScreen f21076a;

    LoggedOutScreen$$Lambda$0(LoggedOutScreen loggedOutScreen) {
        this.f21076a = loggedOutScreen;
    }

    public final void onClick(View view) {
        SessionManager.b().a(Util.m24019e(this.f21076a.am_()), false);
    }
}
