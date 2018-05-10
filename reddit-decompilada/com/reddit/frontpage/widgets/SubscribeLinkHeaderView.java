package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.util.ArraySet;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.listing.ui.view.HeaderMetadataView.StringWithIndicators;
import com.reddit.frontpage.presentation.listing.ui.view.Indicator;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import com.reddit.frontpage.util.MenuUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import java.util.Set;

public class SubscribeLinkHeaderView extends HeaderMetadataView implements LinkHeader {
    protected PopupMenu f29487b;
    private MenuItem f29488c;
    private MenuItem f29489d;
    private MenuItem f29490e;
    private MenuItem f29491f;
    private MenuItem f29492g;
    private MenuItem f29493h;
    private Runnable f29494i;

    protected final String mo5061a() {
        return "";
    }

    public final void mo5063a(Runnable runnable) {
    }

    public void setDisplaySubredditName(boolean z) {
    }

    public void setModQueueCheckListener(ModQueueCheckListener<Thing> modQueueCheckListener) {
    }

    public void setShowOverflow(boolean z) {
    }

    public void setAnalyticsRunnable(Runnable runnable) {
        this.f29494i = runnable;
    }

    public SubscribeLinkHeaderView(Context context) {
        this(context, null);
    }

    public SubscribeLinkHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeLinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SubscribeLinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f29487b = new PopupMenu(getContext(), getOverflowIcon());
        MenuUtil.m23812a(this.f29487b.a);
        this.f29487b.a(C1761R.menu.menu_link_options);
        if (SessionManager.b().c.isAnonymous()) {
            this.f29487b.a.findItem(C1761R.id.action_report).setVisible(false);
        }
        getOverflowLayout().setOnClickListener(new SubscribeLinkHeaderView$$Lambda$0(this));
        this.f29488c = this.f29487b.a.findItem(C1761R.id.action_hide);
        this.f29489d = this.f29487b.a.findItem(C1761R.id.action_unhide);
        this.f29490e = this.f29487b.a.findItem(C1761R.id.action_report);
        this.f29491f = this.f29487b.a.findItem(C1761R.id.action_save);
        this.f29492g = this.f29487b.a.findItem(C1761R.id.action_unsave);
        this.f29493h = this.f29487b.a.findItem(C1761R.id.action_share);
    }

    final /* synthetic */ void mo5064b() {
        this.f29487b.b.a();
        if (this.f29494i != null) {
            this.f29494i.run();
        }
    }

    protected final StringWithIndicators mo5062b(Link link) {
        String f = Util.m24027f((int) C1761R.string.unicode_delimiter);
        String l = Util.m24042l(link.getAuthor());
        Set arraySet = new ArraySet();
        if (link.getAuthor().equals(SessionUtil.m23899e())) {
            arraySet.add(Indicator.f20734c);
        }
        if (link.getAuthorCakeday().booleanValue()) {
            arraySet.add(Indicator.f20736e);
        }
        if (link.getDistinguishedType() == 1) {
            arraySet.add(Indicator.f20732a);
        } else if (link.getDistinguishedType() == 2) {
            arraySet.add(Indicator.f20733b);
        } else if (ModUtil.m23824a().getDistinguishState(link.getName(), link.isDistinguished())) {
            arraySet.add(Indicator.f20733b);
        }
        int gilded = link.getGilded();
        if (gilded > 0) {
            arraySet.add(Indicator.f20737f);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (gilded > 1) {
            stringBuilder.append(getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(gilded)}));
        }
        if (!link.isPromoted()) {
            stringBuilder.append(f);
            stringBuilder.append(DateUtil.m22705a(link.getCreatedUtc(), false));
        }
        gilded = link.getLinkType();
        if (gilded == 4 || gilded == 5) {
            link = DomainUtil.m22714a(link.getDisplayDomain());
            if (!TextUtils.isEmpty(link)) {
                stringBuilder.append(f);
                stringBuilder.append(link);
            }
        }
        return new StringWithIndicators(l, arraySet, "", stringBuilder.toString());
    }

    public final void b_(Link link) {
        m24149a(link);
        Session session = SessionManager.b().c;
        boolean z = false;
        boolean z2 = (session.isAnonymous() || SessionUtil.m23895a(session, link.getAuthor())) ? false : true;
        boolean isHidden = link.isHidden();
        MenuItem menuItem = this.f29488c;
        boolean z3 = z2 && !isHidden;
        menuItem.setVisible(z3);
        menuItem = this.f29489d;
        isHidden = z2 && isHidden;
        menuItem.setVisible(isHidden);
        this.f29490e.setVisible(z2);
        this.f29491f.setVisible(link.isSaved() ^ true);
        this.f29492g.setVisible(link.isSaved());
        Subreddit subredditDetail = link.getSubredditDetail();
        MenuItem menuItem2 = this.f29493h;
        if (subredditDetail != null && subredditDetail.user_is_moderator) {
            z = true;
        }
        menuItem2.setVisible(z);
        getTopMetadata().setOnClickListener(new SubscribeLinkHeaderView$$Lambda$1(this, link));
    }

    public void setDomainClickListener(OnClickListener onClickListener) {
        getBottomMetadataAfterIndicators().setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f29487b.c = onMenuItemClickListener;
    }
}
