package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class BaseDetailScreen$$Lambda$6 implements OnClickListener {
    private final BaseDetailScreen f21154a;
    private final boolean f21155b;

    BaseDetailScreen$$Lambda$6(BaseDetailScreen baseDetailScreen, boolean z) {
        this.f21154a = baseDetailScreen;
        this.f21155b = z;
    }

    public final void onClick(View view) {
        view = this.f21154a;
        if (this.f21155b) {
            SessionManager.b().a(Util.m24019e(view.am_()), true);
        }
    }
}
