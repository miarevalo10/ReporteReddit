package com.reddit.frontpage.ui.submit;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.submit.BaseSubmitScreen.Companion;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.SelectionListener;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"com/reddit/frontpage/ui/submit/BaseSubmitScreen$onCreateView$1", "Lcom/reddit/frontpage/widgets/submit/SubredditLocationSelectView$SelectionListener;", "(Lcom/reddit/frontpage/ui/submit/BaseSubmitScreen;)V", "onLocationSelect", "", "onSubredditSelect", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
public final class BaseSubmitScreen$onCreateView$1 implements SelectionListener {
    final /* synthetic */ BaseSubmitScreen f29303a;

    BaseSubmitScreen$onCreateView$1(BaseSubmitScreen baseSubmitScreen) {
        this.f29303a = baseSubmitScreen;
    }

    public final void mo5017a() {
        this.f29303a.subredditSelectRequestId = UUID.randomUUID().toString();
        Routing.m22623a((Screen) this.f29303a, Nav.m22608s(this.f29303a.subredditSelectRequestId));
    }

    public final void mo5018b() {
        ClickEventBuilder a = AppAnalytics.m21858b().m21824a(this.f29303a.getAnalyticsScreenName());
        Companion companion = BaseSubmitScreen.f39338z;
        a.m21826b(BaseSubmitScreen.f39331E).m21825a();
        BaseSubmitScreen.m39512a(this.f29303a);
    }
}
