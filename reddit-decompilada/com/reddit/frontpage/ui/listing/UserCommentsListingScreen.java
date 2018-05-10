package com.reddit.frontpage.ui.listing;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.provider.CommentListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentListingProvider.CommentListingEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.layout.SmoothScrollingLinearLayoutManager;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import timber.log.Timber;

public class UserCommentsListingScreen extends BaseScreen {
    @BindView
    FrameLayout contentContainer;
    @BindView
    ViewStub emptyContainer;
    @BindView
    LinearLayout errorContainer;
    @State
    public boolean isContributor;
    @BindView
    RecyclerView listView;
    @BindView
    View loadingSpinner;
    @BindView
    SwipeRefreshLayout swipeRefreshLayout;
    @State
    String username;
    ItemDecoration f39232v;
    View f39233w;
    CommentListingProvider f39234x;
    RecyclerHeaderFooterAdapter f39235y;

    public class CommentListingAdapter extends Adapter<CommentViewHolder> {
        final /* synthetic */ UserCommentsListingScreen f29070a;

        public CommentListingAdapter(UserCommentsListingScreen userCommentsListingScreen) {
            this.f29070a = userCommentsListingScreen;
        }

        public final /* synthetic */ void m30124a(ViewHolder viewHolder, int i) {
            CommentViewHolder commentViewHolder = (CommentViewHolder) viewHolder;
            Comment comment = (Comment) ((CommentWrapper) this.f29070a.f39234x.a(i)).getData();
            commentViewHolder.subject.setText(comment.link_title);
            commentViewHolder.preview.setText(Util.m24030g(comment.b()));
            commentViewHolder.metadata.setText(CommentViewHolder.m30125a(comment));
            commentViewHolder.metadata.setCompoundDrawablesRelative(null, null, ResourcesUtil.m22733e(commentViewHolder.c.getContext(), commentViewHolder.metadata.getCompoundDrawablesRelative()[2]), null);
            commentViewHolder.c.setOnClickListener(new UserCommentsListingScreen$CommentViewHolder$$Lambda$0(commentViewHolder, comment));
        }

        public final int m30122a() {
            return this.f29070a.f39234x.c();
        }

        public final /* synthetic */ ViewHolder m30123a(ViewGroup viewGroup, int i) {
            return new CommentViewHolder(this.f29070a, LayoutInflater.from(this.f29070a.am_()).inflate(C1761R.layout.listitem_activity_comment, viewGroup, false));
        }
    }

    public class CommentViewHolder extends ViewHolder {
        final /* synthetic */ UserCommentsListingScreen f29071a;
        @BindView
        TextView metadata;
        @BindView
        TextView preview;
        @BindView
        TextView subject;

        public CommentViewHolder(UserCommentsListingScreen userCommentsListingScreen, View view) {
            this.f29071a = userCommentsListingScreen;
            super(view);
            ButterKnife.a(this, view);
        }

        static String m30125a(Comment comment) {
            CharSequence b = DateUtil.m23684b(comment.getCreatedUtc());
            String string = FrontpageApplication.f27402a.getString(C1761R.string.unicode_bullet);
            String string2 = FrontpageApplication.f27402a.getString(C1761R.string.unicode_space);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(comment.subreddit_name_prefixed);
            stringBuilder.append(string2);
            stringBuilder.append(string);
            stringBuilder.append(string2);
            stringBuilder.append(b);
            stringBuilder.append(string2);
            stringBuilder.append(string);
            stringBuilder.append(string2);
            stringBuilder.append(CountUtil.m23674a((long) comment.getScore()));
            return stringBuilder.toString();
        }
    }

    public class CommentViewHolder_ViewBinding implements Unbinder {
        private CommentViewHolder f29072b;

        public CommentViewHolder_ViewBinding(CommentViewHolder commentViewHolder, View view) {
            this.f29072b = commentViewHolder;
            commentViewHolder.subject = (TextView) Utils.b(view, C1761R.id.subject, "field 'subject'", TextView.class);
            commentViewHolder.metadata = (TextView) Utils.b(view, C1761R.id.metadata, "field 'metadata'", TextView.class);
            commentViewHolder.preview = (TextView) Utils.b(view, C1761R.id.preview, "field 'preview'", TextView.class);
        }

        public final void m30126a() {
            CommentViewHolder commentViewHolder = this.f29072b;
            if (commentViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f29072b = null;
            commentViewHolder.subject = null;
            commentViewHolder.metadata = null;
            commentViewHolder.preview = null;
        }
    }

    private class LoadMoreOnScrollListener extends OnScrollListener {
        final /* synthetic */ UserCommentsListingScreen f29073a;
        private final LinearLayoutManager f29074b;

        LoadMoreOnScrollListener(UserCommentsListingScreen userCommentsListingScreen, LinearLayoutManager linearLayoutManager) {
            this.f29073a = userCommentsListingScreen;
            this.f29074b = linearLayoutManager;
        }

        public final void m30127a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0) {
                recyclerView = AppAnalytics.m21872i();
                recyclerView.f19977a = this.f29073a.getAnalyticsScreenName();
                recyclerView.f19988l = "comments";
                recyclerView.f19989m = this.f29073a.username;
                if (TextUtils.isEmpty(recyclerView.f19977a) != 0) {
                    recyclerView.f19977a = recyclerView.f19978b;
                }
                if (TextUtils.isEmpty(recyclerView.f19977a) != 0) {
                    Timber.e(String.format("Invalid scroll event: screen_name(%s)", new Object[]{recyclerView.f19977a}), new Object[0]);
                }
                BaseEvent scrollEvent = new ScrollEvent(recyclerView.f19977a);
                ScrollPayload scrollPayload = (ScrollPayload) scrollEvent.payload;
                scrollPayload.scroll_percentage = recyclerView.f19979c;
                scrollPayload.total_scroll_items = recyclerView.f19980d;
                scrollPayload.scroll_items_seen = recyclerView.f19981e;
                scrollPayload.total_screens_scrolled = recyclerView.f19982f;
                scrollPayload.posts_seen = recyclerView.f19983g;
                scrollPayload.posts_seen_start_time = recyclerView.f19984h;
                scrollPayload.posts_seen_end_time = recyclerView.f19985i;
                scrollPayload.time_on_page = recyclerView.f19986j;
                scrollPayload.live_thread_id = recyclerView.f19987k;
                scrollPayload.control_name = recyclerView.f19988l;
                scrollPayload.base_url = recyclerView.f19989m;
                scrollPayload.sr_name = recyclerView.f19990n;
                AppAnalytics.m21852a(scrollEvent);
            }
        }

        public final void m30128a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (this.f29074b.m() >= this.f29073a.f39234x.c() - 5 && this.f29073a.f39234x.mAfter != null) {
                this.f29073a.f39233w.setVisibility(0);
                this.f29073a.f39234x.a(ListingPerformanceTracker.m21961a(this.f29073a.getAnalyticsScreenName()));
            }
        }
    }

    protected final void E_() {
    }

    public String getAnalyticsScreenName() {
        return "profile_comments";
    }

    public final int mo7141s() {
        return C1761R.layout.bare_link_list;
    }

    public static UserCommentsListingScreen m39314a(String str) {
        UserCommentsListingScreen userCommentsListingScreen = new UserCommentsListingScreen();
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder("NON-NULL-LOGGING_UserCommentsListingScreen.newInstance:username-null=");
            stringBuilder.append(str == null);
            Timber.e(stringBuilder.toString(), new Object[0]);
        }
        userCommentsListingScreen.username = str;
        return userCommentsListingScreen;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(C1761R.string.title_comments);
    }

    public final ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        ((ScreenViewPayload) N.payload).target_type = "account";
        ((ScreenViewPayload) N.payload).target_name = this.username;
        ((ScreenViewPayload) N.payload).user_name = SessionManager.b().c.getUsername();
        ((ScreenViewPayload) N.payload).is_contributor = this.isContributor;
        Account account = (Account) AccountStorage.b.a(SessionManager.b().c.getUsername());
        if (account != null) {
            ((ScreenViewPayload) N.payload).user_id36 = account.getId();
        }
        return N;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        if (this.f39232v != null) {
            this.listView.removeItemDecoration(this.f39232v);
        }
        this.f39232v = DividerItemDecoration.m30093a(am_(), 1, DividerItemDecoration.m30091a());
        this.listView.addItemDecoration(this.f39232v);
        viewGroup = new SmoothScrollingLinearLayoutManager(am_(), 1, false);
        this.listView.setLayoutManager(viewGroup);
        this.f39235y = new RecyclerHeaderFooterAdapter(new CommentListingAdapter(this));
        this.f39233w = layoutInflater.inflate(C1761R.layout.list_loading_footer, this.listView, false);
        this.f39233w.setVisibility(8);
        this.f39235y.f34365c = this.f39233w;
        this.listView.setAdapter(this.f39235y);
        this.listView.addOnScrollListener(new LoadMoreOnScrollListener(this, viewGroup));
        Util.m23970a(this.swipeRefreshLayout);
        this.swipeRefreshLayout.setOnRefreshListener(new UserCommentsListingScreen$$Lambda$0(this));
        this.loadingSpinner.setBackground(AnimUtil.m23637a(am_()));
        return this.K;
    }

    protected final void mo7144v() {
        this.f39234x = new CommentListingProvider(this.username);
        m37523a(this.f39234x);
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        view = new StringBuilder("NON-NULL-LOGGING_onAttach:username-null=");
        view.append(this.username == null);
        Timber.e(view.toString(), new Object[0]);
        this.f39234x.a(false, ListingPerformanceTracker.m21961a(getAnalyticsScreenName()));
    }

    public void onEvent(CommentListingEvent commentListingEvent) {
        EventBus.getDefault().removeStickyEvent((Object) commentListingEvent);
        if (this.f39235y == null || this.swipeRefreshLayout.b != null) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
        this.errorContainer.setVisibility(8);
        this.contentContainer.setVisibility(0);
        this.swipeRefreshLayout.setVisibility(0);
        this.loadingSpinner.setVisibility(8);
        this.f39233w.setVisibility(8);
        if (this.f39234x == null || this.f39234x.c() != null) {
            this.emptyContainer.setVisibility(8);
        } else {
            this.emptyContainer.setVisibility(0);
        }
        this.f39235y.a_.b();
    }

    public final boolean mo7200K() {
        if (!ListUtil.m23810a((LinearLayoutManager) this.listView.getLayoutManager())) {
            this.listView.smoothScrollToPosition(0);
        }
        return true;
    }
}
