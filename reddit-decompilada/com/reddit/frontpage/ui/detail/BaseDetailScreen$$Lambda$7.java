package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.widgets.SubscribeDetailHeaderView;

final /* synthetic */ class BaseDetailScreen$$Lambda$7 implements OnClickListener {
    private final BaseDetailScreen f21156a;
    private final SubscribeDetailHeaderView f21157b;

    BaseDetailScreen$$Lambda$7(BaseDetailScreen baseDetailScreen, SubscribeDetailHeaderView subscribeDetailHeaderView) {
        this.f21156a = baseDetailScreen;
        this.f21157b = subscribeDetailHeaderView;
    }

    public final void onClick(View view) {
        BaseScreen baseScreen = this.f21156a;
        SubscribeDetailHeaderView subscribeDetailHeaderView = this.f21157b;
        Boolean a = SubredditUtil.m23911a(baseScreen.f39153F.getSubreddit(), false);
        Session session = SessionManager.b().c;
        baseScreen.getAnalyticsScreenName();
        if (a.booleanValue()) {
            SubredditUtil.m23925b(baseScreen.f39153F, baseScreen);
        } else {
            SubredditUtil.m23916a(baseScreen.f39153F, baseScreen);
        }
        subscribeDetailHeaderView.setSubscribeIcon(Boolean.valueOf(a.booleanValue() ^ 1));
    }
}
