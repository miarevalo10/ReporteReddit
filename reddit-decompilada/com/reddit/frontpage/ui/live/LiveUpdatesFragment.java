package com.reddit.frontpage.ui.live;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import com.reddit.datalibrary.frontpage.data.provider.BaseListingProvider2;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.data.provider.LiveUpdateProvider;
import com.reddit.datalibrary.frontpage.data.provider.LiveUpdateProvider.LiveUpdateLoadEvent;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient.WebSocketConnection;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.datalibrary.frontpage.requests.models.v2.live.LiveThreadUpdater;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;
import com.reddit.frontpage.commons.analytics.listener.AnalyticsOnScrollListener;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.layout.SmoothScrollingLinearLayoutManager;
import com.reddit.frontpage.ui.listener.OnPercentScrollListener;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.Util;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.regex.Matcher;
import javax.inject.Inject;
import timber.log.Timber;

public class LiveUpdatesFragment extends BaseFrontpageFragment implements TweetSource {
    @Inject
    RemoteWebSocketDataSource f39238a;
    LinearLayoutManager f39239b;
    private OnViewerCountChangeListener f39240c;
    private LiveUpdateProvider f39241d;
    private LiveUpdateAdapter f39242g;
    private RecyclerHeaderFooterAdapter f39243h;
    private LiveThreadHeader f39244i;
    private int f39245j = 0;
    private LongSparseArray<Tweet> f39246k = new LongSparseArray();
    private WebSocketConnection f39247l;
    @State(ParcelerBundler.class)
    LiveThread liveThread;
    private AnalyticsOnScrollListener f39248m;
    private ScheduledFuture<?> f39249n;
    @BindView
    RecyclerView recyclerView;
    @BindView
    SwipeRefreshLayout refreshLayout;
    @BindView
    TextView updateCounterView;
    @State(ParcelerBundler.class)
    List<LiveUpdate> updates;

    class C19022 implements OnClickListener {
        final /* synthetic */ LiveUpdatesFragment f21451a;

        class C19011 implements Runnable {
            final /* synthetic */ C19022 f21450a;

            C19011(C19022 c19022) {
                this.f21450a = c19022;
            }

            public void run() {
                this.f21450a.f21451a.m39336b();
            }
        }

        C19022(LiveUpdatesFragment liveUpdatesFragment) {
            this.f21451a = liveUpdatesFragment;
        }

        public void onClick(View view) {
            this.f21451a.recyclerView.smoothScrollToPosition(0);
            this.f21451a.updateCounterView.setVisibility(8);
            this.f21451a.f39245j = 0;
            this.f21451a.recyclerView.post(new C19011(this));
        }
    }

    interface OnViewerCountChangeListener {
        void mo7221a(int i);
    }

    class C23541 implements OnRefreshListener {
        final /* synthetic */ LiveUpdatesFragment f29165a;

        C23541(LiveUpdatesFragment liveUpdatesFragment) {
            this.f29165a = liveUpdatesFragment;
        }

        public final void m30272a() {
            this.f29165a.m39336b();
            this.f29165a.f39241d.a(true, null);
        }
    }

    class C23555 implements LiveThreadUpdater {
        final /* synthetic */ LiveUpdatesFragment f29166a;

        C23555(LiveUpdatesFragment liveUpdatesFragment) {
            this.f29166a = liveUpdatesFragment;
        }

        public final void mo5003a(int i) {
            if (this.f29166a.f39240c != null) {
                this.f29166a.f39240c.mo7221a(i);
            }
        }

        public final void mo5005a(LiveUpdate liveUpdate) {
            this.f29166a.updates.add(liveUpdate);
            this.f29166a.f39243h.e(this.f29166a.f39243h.m35095f());
            if (LiveUpdatesFragment.m39338d(this.f29166a) != null) {
                this.f29166a.f39245j = this.f29166a.f39245j + 1;
                this.f29166a.updateCounterView.setText(this.f29166a.getResources().getQuantityString(C1761R.plurals.fmt_live_updates, this.f29166a.f39245j, new Object[]{Integer.valueOf(this.f29166a.f39245j)}));
                this.f29166a.updateCounterView.setVisibility(0);
                return;
            }
            if (this.f29166a.recyclerView.getScrollY() == null) {
                this.f29166a.recyclerView.scrollToPosition(0);
            }
        }

        public final void mo5006a(String str) {
            LiveUpdateAdapter e = this.f29166a.f39242g;
            str = e.m30280a(str);
            int c = e.m30283c(str);
            if (str >= null) {
                ((LiveUpdate) e.f29167a.get(str)).setStricken(true);
            }
            this.f29166a.f39243h.d(c + this.f29166a.f39243h.m35095f());
        }

        public final void mo5008b(String str) {
            LiveUpdateAdapter e = this.f29166a.f39242g;
            str = e.m30280a(str);
            int c = e.m30283c(str);
            if (str >= null) {
                e.f29167a.remove(str);
            }
            this.f29166a.f39243h.f(c + this.f29166a.f39243h.m35095f());
        }

        public final void mo5007a(String str, List<MobileEmbed> list) {
            LiveUpdateAdapter e = this.f29166a.f39242g;
            str = e.m30280a(str);
            int c = e.m30283c(str);
            if (str >= null) {
                ((LiveUpdate) e.f29167a.get(str)).setMobileEmbeds(list);
            }
            this.f29166a.f39243h.d(c + this.f29166a.f39243h.m35095f());
        }

        public final void mo5004a(LiveThread liveThread) {
            this.f29166a.liveThread.merge(liveThread);
            this.f29166a.m39333a();
        }
    }

    private class LiveUpdateAdapter extends Adapter<LiveUpdateViewHolder> {
        List<LiveUpdate> f29167a;
        final /* synthetic */ LiveUpdatesFragment f29168b;

        private LiveUpdateAdapter(LiveUpdatesFragment liveUpdatesFragment) {
            this.f29168b = liveUpdatesFragment;
            this.f29167a = new ArrayList();
        }

        public final /* synthetic */ void m30282a(ViewHolder viewHolder, int i) {
            LiveUpdateViewHolder liveUpdateViewHolder = (LiveUpdateViewHolder) viewHolder;
            LiveUpdate liveUpdate = (LiveUpdate) this.f29167a.get((this.f29167a.size() - i) - 1);
            liveUpdateViewHolder.container.removeAllViews();
            List<MobileEmbed> mobileEmbeds = liveUpdate.getMobileEmbeds();
            if (liveUpdate.isStricken() || mobileEmbeds.size() <= 0) {
                if (liveUpdate.isStricken()) {
                    StringBuilder stringBuilder = new StringBuilder("<del>");
                    stringBuilder.append(liveUpdate.getBodyHtml());
                    stringBuilder.append("</del>");
                    liveUpdateViewHolder.m30270a(stringBuilder.toString());
                } else {
                    liveUpdateViewHolder.m30270a(liveUpdate.getBodyHtml());
                }
            } else if (mobileEmbeds.size() == 1 && TextUtils.equals(((MobileEmbed) mobileEmbeds.get(0)).getOriginalUrl(), Util.m24033h(liveUpdate.getBody()))) {
                liveUpdateViewHolder.m30269a((MobileEmbed) mobileEmbeds.get(0));
            } else {
                String bodyHtml = liveUpdate.getBodyHtml();
                Matcher matcher = LiveUpdateViewHolder.f29160a.matcher(bodyHtml);
                int i2 = 0;
                for (MobileEmbed mobileEmbed : mobileEmbeds) {
                    if (mobileEmbed.getOriginalUrl() != null && LiveUpdateViewHolder.f29161b.contains(mobileEmbed.getType())) {
                        int start;
                        int i3 = -1;
                        while (true) {
                            boolean find = matcher.find();
                            if (!find) {
                                break;
                            }
                            String group = matcher.group(1);
                            start = matcher.start();
                            if (mobileEmbed.getOriginalUrl().startsWith(Html.fromHtml(group).toString())) {
                                break;
                            }
                            i3 = start;
                        }
                        i3 = start;
                        if (i3 >= 0 && find) {
                            liveUpdateViewHolder.m30270a(bodyHtml.substring(i2, i3));
                            i2 = matcher.group().length() + i3;
                            liveUpdateViewHolder.m30269a(mobileEmbed);
                        }
                    }
                }
                if (i2 < bodyHtml.length() - 1) {
                    liveUpdateViewHolder.m30270a(bodyHtml.substring(i2));
                }
            }
            Context context = liveUpdateViewHolder.c.getContext();
            CharSequence stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getString(C1761R.string.fmt_u_name, new Object[]{liveUpdate.getAuthor()}));
            stringBuilder2.append(context.getString(C1761R.string.unicode_delimiter));
            liveUpdateViewHolder.authorView.setText(stringBuilder2);
            liveUpdateViewHolder.ageView.setStartTime(liveUpdate.getCreatedUtc());
        }

        public final int m30279a() {
            return this.f29167a.size();
        }

        final int m30280a(String str) {
            for (int size = this.f29167a.size() - 1; size >= 0; size--) {
                if (TextUtils.equals(((LiveUpdate) this.f29167a.get(size)).getName(), str)) {
                    return size;
                }
            }
            return -1;
        }

        final int m30283c(int i) {
            return (this.f29167a.size() - i) - 1;
        }
    }

    class C26903 extends OnPercentScrollListener {
        final /* synthetic */ LiveUpdatesFragment f34402a;

        C26903(LiveUpdatesFragment liveUpdatesFragment) {
            this.f34402a = liveUpdatesFragment;
            super(0.5f);
        }

        public final void mo6517a(RecyclerView recyclerView, int i, int i2) {
            super.mo6517a(recyclerView, i, i2);
            if (LiveUpdatesFragment.m39338d(this.f34402a) == null) {
                this.f34402a.f39245j = 0;
                this.f34402a.updateCounterView.setVisibility(8);
            }
        }

        protected final void mo6462a() {
            if (this.f34402a.f39239b.m() >= this.f34402a.f39242g.m30279a() - 5) {
                BaseListingProvider2 b = this.f34402a.f39241d;
                if ((b.listing != null ? b.listing.getAfter() : null) != null) {
                    this.f34402a.f39241d.b(null);
                }
            }
        }
    }

    public String getAnalyticsScreenName() {
        return Kind.LIVE;
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_live_updates;
    }

    public LiveUpdatesFragment() {
        FrontpageApplication.m28877m().mo4608a(this);
    }

    public static LiveUpdatesFragment m39331a(LiveThread liveThread, OnViewerCountChangeListener onViewerCountChangeListener) {
        LiveUpdatesFragment liveUpdatesFragment = new LiveUpdatesFragment();
        liveUpdatesFragment.liveThread = liveThread;
        liveUpdatesFragment.f39240c = onViewerCountChangeListener;
        return liveUpdatesFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f39239b = new SmoothScrollingLinearLayoutManager(getActivity(), 1, false);
        this.recyclerView.setLayoutManager(this.f39239b);
        Util.m23970a(this.refreshLayout);
        this.refreshLayout.setOnRefreshListener(new C23541(this));
        this.f39242g = new LiveUpdateAdapter();
        this.f39243h = new RecyclerHeaderFooterAdapter(this.f39242g);
        this.recyclerView.setAdapter(this.f39243h);
        this.updateCounterView.setOnClickListener(new C19022(this));
        this.recyclerView.addItemDecoration(DividerItemDecoration.m30092a(getContext(), 0));
        this.recyclerView.addOnScrollListener(new C26903(this));
        this.f39248m = new AnalyticsOnScrollListener(this, getAnalyticsScreenName()) {
            final /* synthetic */ LiveUpdatesFragment f34403b;

            protected final void mo6461a(ScrollPayload scrollPayload) {
                int computeVerticalScrollRange = this.f34403b.recyclerView.computeVerticalScrollRange();
                int computeVerticalScrollOffset = this.f34403b.recyclerView.computeVerticalScrollOffset();
                if (computeVerticalScrollRange != 0) {
                    scrollPayload.scroll_percentage = ((float) computeVerticalScrollOffset) / ((float) computeVerticalScrollRange);
                }
                scrollPayload.live_thread_id = this.f34403b.liveThread.getId();
            }
        };
        this.recyclerView.addOnScrollListener(this.f39248m);
        return this.e;
    }

    public void onStart() {
        super.onStart();
        this.f39249n = AppAnalytics.m21859b(getAnalyticsScreenName(), this.liveThread.getId());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f39244i = (LiveThreadHeader) LayoutInflater.from(view.getContext()).inflate(C1761R.layout.item_live_thread_header, this.recyclerView, false);
        m39333a();
        this.f39243h.f34364b = this.f39244i;
    }

    public void onResume() {
        super.onResume();
        this.f39241d.a(false, null);
        Object url = this.liveThread.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f39247l = RemoteWebSocketDataSource.a(Uri.parse(url), new C23555(this));
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f39247l != null) {
            this.f39247l.a();
        }
    }

    public void onStop() {
        super.onStop();
        m39336b();
        if (this.f39249n != null) {
            this.f39249n.cancel(true);
        }
    }

    public final List<BaseOtherProvider> mo7224l() {
        List<BaseOtherProvider> arrayList = new ArrayList(1);
        this.f39241d = new LiveUpdateProvider(this.liveThread.getId());
        arrayList.add(this.f39241d);
        return arrayList;
    }

    public final void mo7223a(final long j, final OnTweetLoadedCallback onTweetLoadedCallback) {
        Tweet tweet = (Tweet) this.f39246k.a(j);
        if (tweet != null) {
            onTweetLoadedCallback.mo5002a(tweet);
        } else {
            TweetUtils.m25941a(Collections.singletonList(Long.valueOf(j)), new Callback<List<Tweet>>(this) {
                final /* synthetic */ LiveUpdatesFragment f34406c;

                public final void mo6518a(Result<List<Tweet>> result) {
                    if (!(result == null || result.f23920a == null)) {
                        if (!((List) result.f23920a).isEmpty()) {
                            Tweet tweet = (Tweet) ((List) result.f23920a).get(0);
                            this.f34406c.f39246k.a(j, tweet);
                            onTweetLoadedCallback.mo5002a(tweet);
                        }
                    }
                }

                public final void mo6519a(TwitterException twitterException) {
                    Timber.c(twitterException, "Failed to load tweet", new Object[0]);
                }
            });
        }
    }

    private void m39333a() {
        this.f39244i.setTitle(this.liveThread.getTitle());
        this.f39244i.setDescription(this.liveThread.getDescriptionHtml());
    }

    public void onEventMainThread(LiveUpdateLoadEvent liveUpdateLoadEvent) {
        if (this.refreshLayout.b) {
            this.refreshLayout.setRefreshing(false);
        }
        if (!(this.updates == null || this.updates.size() == 0)) {
            if (!liveUpdateLoadEvent.a || DateUtil.m23680a(((LiveUpdate) this.updates.get(this.updates.size() - 1)).getCreatedUtc()) > this.f39241d.b) {
                if (liveUpdateLoadEvent.a == null) {
                    liveUpdateLoadEvent = m39332a(this.f39241d.listing);
                    long a = DateUtil.m23680a(((LiveUpdate) liveUpdateLoadEvent.get(liveUpdateLoadEvent.size() - 1)).getCreatedUtc());
                    int size = this.updates.size() - 1;
                    int i = -1;
                    while (true) {
                        int i2 = i;
                        i = size;
                        size = i2;
                        if (i >= 0 && DateUtil.m23680a(((LiveUpdate) this.updates.get(i)).getCreatedUtc()) > a) {
                            size = i - 1;
                        } else if (size >= 0) {
                            liveUpdateLoadEvent.addAll(this.updates.subList(size, this.updates.size()));
                        }
                    }
                    if (size >= 0) {
                        liveUpdateLoadEvent.addAll(this.updates.subList(size, this.updates.size()));
                    }
                    this.updates = liveUpdateLoadEvent;
                    this.f39242g.f29167a = this.updates;
                    this.f39242g.a_.b();
                }
                return;
            }
        }
        this.updates = m39332a(this.f39241d.listing);
        this.f39242g.f29167a = this.updates;
        this.f39242g.a_.b();
    }

    private static List<LiveUpdate> m39332a(Listing<LiveUpdate> listing) {
        List<LiveUpdate> arrayList = new ArrayList(listing.size());
        for (int size = listing.size() - 1; size >= 0; size--) {
            arrayList.add(listing.get(size));
        }
        return arrayList;
    }

    private void m39336b() {
        if (this.f39248m != null) {
            this.f39248m.mo6460a(this.recyclerView);
        }
    }

    static /* synthetic */ boolean m39338d(LiveUpdatesFragment liveUpdatesFragment) {
        int f = liveUpdatesFragment.f39243h.m35095f();
        if (liveUpdatesFragment.f39239b.k() > f) {
            return true;
        }
        return (liveUpdatesFragment.f39239b.k() == f) && liveUpdatesFragment.f39239b.a(f).getTop() < null;
    }
}
