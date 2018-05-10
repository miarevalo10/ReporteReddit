package com.reddit.frontpage.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserScreen;
import com.reddit.frontpage.presentation.usermodal.UserModalScreen;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import timber.log.Timber;

final /* synthetic */ class LinkHeaderView$$Lambda$5 implements OnClickListener {
    private final LinkHeaderView f21913a;
    private final View f21914b;
    private final Link f21915c;

    LinkHeaderView$$Lambda$5(LinkHeaderView linkHeaderView, View view, Link link) {
        this.f21913a = linkHeaderView;
        this.f21914b = view;
        this.f21915c = link;
    }

    public final void onClick(View view) {
        view = this.f21913a;
        View view2 = this.f21914b;
        Link link = this.f21915c;
        Context context = view2.getContext();
        if (view.f29462e == null || SubredditUtil.m23920a(link.getSubreddit()) != null) {
            if (Util.m24041k(link.getAuthor()) == null) {
                if (link.getSubredditDetail() == null || link.getSubredditDetail().user_is_moderator == null) {
                    if (link.getAuthor() == null) {
                        Timber.e("NON-NULL-ERROR: LinkHeaderView.attachClickListener. link.getAuthor() is null", new Object[0]);
                    }
                    Routing.m22619a(context, Nav.m22594j(link.getAuthor()));
                } else {
                    Screen a = Routing.m22617a(context);
                    if (!(Util.m24041k(link.getAuthor()) || a == null || a.getClass().getName().equals(AddBannedUserScreen.class.getName()))) {
                        UserModalScreen.m29886a(a, link).m29901f();
                    }
                    return;
                }
            }
            return;
        }
        Routing.m22619a(context, Nav.m22566b(link.getSubreddit()));
    }
}
