package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter.OnLinkHiddenListener;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView;
import com.reddit.frontpage.widgets.LinkFooterView.OnShareListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnViewCommentsListener;
import com.reddit.frontpage.widgets.LinkHeader;
import com.reddit.frontpage.widgets.LinkHeaderView;
import com.reddit.frontpage.widgets.SubscribeLinkHeaderView;
import kotlin.Unit;

public abstract class LinkViewHolder extends ListingViewHolder {
    public String f34378a;
    public LinkHeader f34379b;
    @BindView
    public LinkFooterView footerView;
    @BindView
    ViewStub headerStub;
    protected OnViewMediaListener f34380p;
    protected OnLinkHiddenListener f34381q;
    public OnShareListener f34382r;
    protected Link f34383s;
    public boolean f34384t;
    public boolean f34385u;

    public interface OnViewMediaListener {
        void mo4993a(Link link);

        void mo4994b(Link link);

        void mo4995c(Link link);
    }

    public final int mo6480Q() {
        return 0;
    }

    protected abstract void mo7001a(int i);

    protected abstract void mo7003b(boolean z);

    public boolean mo7005v() {
        return false;
    }

    public void mo7006w() {
    }

    public final void m35121a(String str) {
        this.f34378a = str;
    }

    protected LinkViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
    }

    public void mo7002a(Link link) {
        this.f34383s = link;
        if (!mo7005v()) {
            this.f34379b.b_(link);
            this.footerView.m24175a(link);
            if (this.f34384t) {
                mo7001a(link.isRead() ? 128 : 255);
            }
            mo7003b(this.f34385u);
            SessionManager b = SessionManager.b();
            this.f34379b.setOnMenuItemClickListener(new LinkViewHolder$$Lambda$1(this, this.c.getContext(), b, b.c));
            if (!ModUtil.m23824a().getRemovedState(link.getName(), link.isRemoved())) {
                if (!ModUtil.m23824a().m30459d(link.getName(), link.isSpam())) {
                    this.c.setAlpha(1.0f);
                    this.f34379b.setDomainClickListener(new LinkViewHolder$$Lambda$0(this, link));
                }
            }
            this.c.setAlpha(0.5f);
            this.f34379b.setDomainClickListener(new LinkViewHolder$$Lambda$0(this, link));
        }
    }

    final /* synthetic */ void m35123b(Link link) {
        if (this.f34380p != null) {
            this.f34380p.mo4994b(link);
        }
    }

    final /* synthetic */ boolean m35122a(Context context, SessionManager sessionManager, Session session, MenuItem menuItem) {
        Link link = this.f34383s;
        switch (menuItem.getItemId()) {
            case C1761R.id.action_hide:
                context = AppAnalytics.m21858b().m21823a((View) this.f34379b);
                context.f19955b = "post_hide";
                context.m21825a();
                CustomReportEventBuilder.m28937a(link, "post_overflow", "click", CustomReasonsNoun.f20020e.f20028l);
                LinkUtil.m23800d(link.getName());
                if (this.f34381q != null) {
                    this.f34381q.mo4978a(this);
                    break;
                }
                break;
            case C1761R.id.action_report:
                CustomReportEventBuilder.m28937a(link, "post_overflow", "click", CustomReasonsNoun.f20017b.f20028l);
                if (AccountUtil.a(sessionManager) == null) {
                    if (this.f34383s != null) {
                        RedditAlertDialog.m23310a(this.f34383s.getAuthor(), this.c.getContext().getString(C1761R.string.action_report_post), this.c.getContext(), this.f34383s, this.f34383s, new LinkViewHolder$$Lambda$3(this)).m29514c();
                        break;
                    }
                }
                RedditAlertDialog.m23312a(context).m23323a();
                break;
                break;
            case C1761R.id.action_save:
                menuItem = AppAnalytics.m21858b().m21823a(this.c);
                menuItem.f19955b = "post_save";
                menuItem.f19956c = this.f34383s.getUrl();
                menuItem.f19957d = this.f34383s.getName();
                menuItem.f19959f = this.f34383s.getDomain();
                menuItem.m21825a();
                CustomReportEventBuilder.m28937a(link, "post_overflow", "click", CustomReasonsNoun.f20018c.f20028l);
                context = Util.m24019e(context);
                if (sessionManager.c.isAnonymous() == null) {
                    LinkUtil.m23782a(session, link.getName());
                    break;
                }
                sessionManager.a(context, true);
                break;
            case C1761R.id.action_share:
                if (this.f34382r != null) {
                    LinkUtil.m23785a(this.f34383s, (View) this.f34379b);
                    context = this.f34382r;
                    link.getTitle();
                    context.mo4945a(link.getPermalink(), this.f34383s);
                    break;
                }
                break;
            case C1761R.id.action_unhide:
                LinkUtil.m23802e(link.getName());
                break;
            case C1761R.id.action_unsave:
                context = AppAnalytics.m21858b().m21823a(this.c);
                context.f19955b = "post_unsave";
                context.f19956c = this.f34383s.getUrl();
                context.f19957d = this.f34383s.getName();
                context.f19959f = this.f34383s.getDomain();
                context.m21825a();
                LinkUtil.m23792b(session, link.getName());
                if (this.f34381q != null) {
                    this.f34381q.mo4978a(this);
                    break;
                }
                break;
            default:
                break;
        }
        return true;
    }

    final /* synthetic */ Unit m35113H() {
        if (this.f34381q != null) {
            this.f34381q.mo4978a(this);
        }
        return Unit.f25273a;
    }

    public final void m35118a(OnLinkHiddenListener onLinkHiddenListener) {
        this.f34381q = onLinkHiddenListener;
    }

    public final void m35119a(OnViewMediaListener onViewMediaListener) {
        this.f34380p = onViewMediaListener;
    }

    public final void m35120a(OnViewCommentsListener onViewCommentsListener) {
        this.footerView.setOnViewCommentsListener(onViewCommentsListener);
    }

    public final void m35117a(ModQueueCheckListener<Thing> modQueueCheckListener) {
        this.f34379b.setModQueueCheckListener(modQueueCheckListener);
    }

    public void mo7004c(boolean z) {
        if (z) {
            this.headerStub.setLayoutResource(C1761R.layout.subscribe_link_header_view_legacy);
            this.f34379b = (SubscribeLinkHeaderView) this.headerStub.inflate();
            return;
        }
        this.headerStub.setLayoutResource(C1761R.layout.link_header_view_legacy);
        this.headerStub.getLayoutParams().height = Util.m24012d((int) C1761R.dimen.linkheader_height);
        this.f34379b = (LinkHeaderView) this.headerStub.inflate();
    }

    final /* synthetic */ void m35112G() {
        mo7002a(this.f34383s);
    }
}
