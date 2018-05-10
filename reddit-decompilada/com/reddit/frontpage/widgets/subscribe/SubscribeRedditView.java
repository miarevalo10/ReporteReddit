package com.reddit.frontpage.widgets.subscribe;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.widget.ImageView;
import butterknife.BindView;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.widgets.RedditView$$Lambda$0;
import com.reddit.frontpage.widgets.SessionRedditView;
import com.reddit.frontpage.widgets.action.RedditAction;
import com.reddit.frontpage.widgets.action.SessionRedditAction;
import timber.log.Timber;

public class SubscribeRedditView extends SessionRedditView {
    private Subreddit f34552b;
    private Boolean f34553c;
    @BindView
    ImageView subscribeImage;

    private class SubscribeAction extends SessionRedditAction {
        final /* synthetic */ SubscribeRedditView f34551b;

        SubscribeAction(SubscribeRedditView subscribeRedditView, Session session) {
            this.f34551b = subscribeRedditView;
            super(session);
        }

        public final void mo6541c() {
            if (this.f34551b.getContext() instanceof FragmentActivity) {
                SessionManager.b().a((FragmentActivity) ((Activity) this.f34551b.getContext()), true);
            }
        }

        public final boolean mo6540b() {
            if (this.f34551b.f34552b == null) {
                return false;
            }
            this.f34551b.f34553c = Boolean.valueOf(this.f34551b.subscribeImage.isSelected() ^ true);
            this.f34551b.m35333c();
            if (this.f34551b.f34553c.booleanValue()) {
                SubredditUtil.m23915a(this.f34551b.f34552b, AppAnalytics.m21849a(this.f34551b));
            } else {
                SubredditUtil.m23924b(this.f34551b.f34552b, AppAnalytics.m21849a(this.f34551b));
            }
            return true;
        }
    }

    public int getLayoutId() {
        return C1761R.layout.rdt_widget_subscribe;
    }

    public SubscribeRedditView(Context context) {
        super(context);
    }

    public SubscribeRedditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubscribeRedditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SubscribeRedditView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void mo6542a(Session session) {
        super.mo6542a(session);
        RedditAction subscribeAction = new SubscribeAction(this, session);
        this.f21940a = subscribeAction;
        if (this.f21940a != null) {
            setOnClickListener(new RedditView$$Lambda$0(subscribeAction));
        }
    }

    public final void m35331a(Subreddit subreddit) {
        this.f34552b = subreddit;
        try {
            this.f34553c = Boolean.valueOf(subreddit.c());
            m35333c();
        } catch (Subreddit subreddit2) {
            Timber.c(subreddit2, "CRASHLYTICS_CRASH_TAG_SubscribeRedditView.attachSubreddit", new Object[0]);
        }
    }

    public final void m35332b() {
        this.f34553c = Boolean.valueOf(this.f34553c.booleanValue() ^ 1);
        m35333c();
    }

    public final void m35333c() {
        this.subscribeImage.setSelected(this.f34553c.booleanValue());
    }
}
