package com.reddit.frontpage.ui.submit;

import android.app.Dialog;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.reddit.datalibrary.frontpage.data.provider.LoaderProvider;
import com.reddit.datalibrary.frontpage.data.provider.RecentSubredditCursorEvent;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.submit.adapter.LoaderProviderRecyclerViewAdapter;
import com.reddit.frontpage.ui.submit.adapter.LoaderProviderViewHolder;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.GoEditTextView;
import com.reddit.frontpage.widgets.ShapedIconView;
import de.greenrobot.event.EventBus;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public class SubredditSelectDialog {
    private RecentSubredditAdapter f21627a;
    private View f21628b;
    private LoaderProvider<RecentSubreddit> f21629c;
    @BindView
    GoEditTextView communityName;
    private LayoutInflater f21630d;
    private String f21631e;
    private Dialog f21632f;
    @BindView
    ShapedIconView promoterIcon;
    @BindView
    View promoterInfoContainer;
    @BindView
    TextView promoterName;
    @BindView
    RecyclerView recentList;

    private class RecentSubredditAdapter extends LoaderProviderRecyclerViewAdapter<RecentSubreddit, RecentSubredditViewHolder> {
        final /* synthetic */ SubredditSelectDialog f34460a;

        public final /* synthetic */ void mo6529a(LoaderProviderViewHolder loaderProviderViewHolder) {
            RecentSubredditViewHolder recentSubredditViewHolder = (RecentSubredditViewHolder) loaderProviderViewHolder;
            RecentSubreddit recentSubreddit = (RecentSubreddit) recentSubredditViewHolder.f29346a;
            RecentSubredditViewHolder.m35235a(recentSubredditViewHolder);
            recentSubredditViewHolder.c.setOnClickListener(new SubredditSelectDialog$RecentSubredditAdapter$$Lambda$0(this, recentSubreddit));
        }

        public final /* synthetic */ ViewHolder m35233a(ViewGroup viewGroup, int i) {
            return new RecentSubredditViewHolder(this.f34460a.f21630d.inflate(C1761R.layout.listitem_subreddit, viewGroup, false));
        }
    }

    private static class RecentSubredditViewHolder extends LoaderProviderViewHolder<RecentSubreddit> {
        private final TextView f34461b;
        private final ShapedIconView f34462p;

        private RecentSubredditViewHolder(View view) {
            super(view, new RecentSubreddit((byte) 0));
            this.f34461b = (TextView) view.findViewById(C1761R.id.subreddit_name);
            this.f34462p = (ShapedIconView) view.findViewById(C1761R.id.subreddit_icon);
        }

        static /* synthetic */ void m35235a(RecentSubredditViewHolder recentSubredditViewHolder) {
            CharSequence fromHtml;
            RecentSubreddit recentSubreddit = (RecentSubreddit) recentSubredditViewHolder.f29346a;
            String a = Util.m23960a((int) C1761R.string.fmt_r_name_html, recentSubreddit.subredditName);
            if (VERSION.SDK_INT >= 24) {
                fromHtml = Html.fromHtml(a, 0);
            } else {
                fromHtml = Html.fromHtml(a);
            }
            recentSubredditViewHolder.f34461b.setText(fromHtml);
            Util.m23982a(recentSubredditViewHolder.f34462p, recentSubreddit.icon, recentSubreddit.keyColor);
        }
    }

    public void onEvent(RecentSubredditCursorEvent recentSubredditCursorEvent) {
        Timber.b("got subreddit event", new Object[0]);
        EventBus.getDefault().removeStickyEvent((Object) recentSubredditCursorEvent);
        recentSubredditCursorEvent = this.f21627a;
        Object obj = this.f21629c;
        Intrinsics.m26847b(obj, "newProvider");
        if (Intrinsics.m26845a(recentSubredditCursorEvent.f29345b, obj)) {
            recentSubredditCursorEvent = null;
        } else {
            LoaderProvider loaderProvider = recentSubredditCursorEvent.f29345b;
            recentSubredditCursorEvent.f29345b = obj;
            recentSubredditCursorEvent.a_.b();
            recentSubredditCursorEvent = loaderProvider;
        }
        if (recentSubredditCursorEvent != null) {
            recentSubredditCursorEvent.finish();
        }
        if (this.f21627a.m30403a() == null) {
            this.f21628b.setVisibility(8);
        } else {
            this.f21628b.setVisibility(0);
        }
        this.f21627a.a_.b();
    }
}
