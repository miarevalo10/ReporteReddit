package com.reddit.frontpage.nav;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.FloatingActionsView$$Lambda$6;

final /* synthetic */ class FloatingActionsManager$$Lambda$0 implements OnClickListener {
    private final FloatingActionsManager f20313a;

    FloatingActionsManager$$Lambda$0(FloatingActionsManager floatingActionsManager) {
        this.f20313a = floatingActionsManager;
    }

    public final void onClick(View view) {
        FloatingActionsManager floatingActionsManager = this.f20313a;
        SessionManager b = SessionManager.b();
        if (b.c.isAnonymous()) {
            SessionManager.b().a(Util.m24019e(view.getContext()), true);
        } else if (AccountUtil.a(b) != null) {
            RedditAlertDialog.m23312a(floatingActionsManager.f28037a.getContext()).m23323a();
        } else {
            view = floatingActionsManager.f28037a;
            view.m24140a(new FloatingActionsView$$Lambda$6(view));
        }
    }
}
