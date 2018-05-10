package com.reddit.frontpage.ui.listing;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.SubscribeLinkHeaderView;
import java.util.Set;

public abstract class SubscribeListingScreen extends AdsListingScreen {
    private Set<String> f40628M;

    protected class SubscribeLinkAdapter extends FrontpageLinkAdapter {
        final /* synthetic */ SubscribeListingScreen f37288b;

        public SubscribeLinkAdapter(SubscribeListingScreen subscribeListingScreen, Context context) {
            this.f37288b = subscribeListingScreen;
            super(subscribeListingScreen, context, subscribeListingScreen.mo7453V(), 8);
        }

        protected final void mo6506b(LinkViewHolder linkViewHolder, Link link) {
            super.mo6506b(linkViewHolder, link);
            if (!this.f37288b.F) {
                if (linkViewHolder.f34379b instanceof SubscribeLinkHeaderView) {
                    String subreddit = link.getSubreddit();
                    boolean contains = this.f37288b.f40628M.contains(subreddit.trim().toLowerCase());
                    SubscribeLinkHeaderView subscribeLinkHeaderView = (SubscribeLinkHeaderView) linkViewHolder.f34379b;
                    subscribeLinkHeaderView.m24150a(contains ^ 1);
                    if (contains) {
                        subscribeLinkHeaderView.getSubscribeContainer().setOnClickListener(new SubscribeListingScreen$SubscribeLinkAdapter$$Lambda$1(this, subreddit));
                        return;
                    }
                    subscribeLinkHeaderView.getSubscribeContainer().setOnClickListener(new SubscribeListingScreen$SubscribeLinkAdapter$$Lambda$0(this, subreddit, link, subscribeLinkHeaderView));
                    subscribeLinkHeaderView.setSubscribeIcon(SubredditUtil.m23911a(subreddit, (boolean) null));
                }
            }
        }

        final /* synthetic */ void m37610a(String str, Link link, SubscribeLinkHeaderView subscribeLinkHeaderView) {
            if (SessionManager.b().c.isAnonymous()) {
                SessionManager.b().a(Util.m24019e(this.k), true);
                return;
            }
            Boolean a = SubredditUtil.m23911a(str, false);
            Session session = SessionManager.b().c;
            if (a.booleanValue()) {
                Routing.m22623a((Screen) this.f37288b, (Screen) Nav.m22566b(str));
                return;
            }
            SubredditUtil.m23916a(link, this.f37288b);
            subscribeLinkHeaderView.setSubscribeIcon(Boolean.valueOf(a.booleanValue() ^ 1));
        }
    }

    protected final String mo7447x() {
        return Util.m23960a((int) C1761R.string.fmt_ad_unit_name, mo7451T());
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f40628M = SubredditUtil.m23931c();
        return this.K;
    }

    protected void mo6992b(View view) {
        this.f40628M = SubredditUtil.m23931c();
        super.mo6992b(view);
    }

    protected final CardLinkAdapter mo7455Y() {
        if (this.F) {
            return super.mo7455Y();
        }
        CardLinkAdapter subscribeLinkAdapter = new SubscribeLinkAdapter(this, am_());
        subscribeLinkAdapter.f29116m = new SubscribeListingScreen$$Lambda$0(this);
        return subscribeLinkAdapter;
    }

    final /* synthetic */ void mo7708a(LinkViewHolder linkViewHolder) {
        m39251b((ViewHolder) linkViewHolder);
    }
}
