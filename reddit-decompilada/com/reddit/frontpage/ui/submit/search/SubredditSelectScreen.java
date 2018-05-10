package com.reddit.frontpage.ui.submit.search;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bolts.Task;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallbackContinuation;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository$.Lambda.4;
import com.reddit.datalibrary.frontpage.data.provider.RecentSubredditLoaderProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditNameInfoProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditNameInfoProvider.1;
import com.reddit.datalibrary.frontpage.data.provider.SubredditSelectDataProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubscribedSubredditProvider;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.GoEditTextView;
import com.reddit.frontpage.widgets.ShapedIconView;
import de.greenrobot.event.EventBus;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class SubredditSelectScreen extends BaseScreen {
    @BindView
    RecyclerView recyclerView;
    @State
    String requestId;
    @BindView
    GoEditTextView subredditFilter;
    @BindView
    Toolbar toolbar;
    private SubredditSelectionAdapter f39370v;
    private SubredditNameInfoAdapter f39371w;
    private Disposable f39372x;
    private Disposable f39373y;

    public class DividerViewHolder extends ViewHolder {
        final /* synthetic */ SubredditSelectScreen f29360a;
        @BindView
        TextView dividerText;

        public DividerViewHolder(SubredditSelectScreen subredditSelectScreen, View view) {
            this.f29360a = subredditSelectScreen;
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public class DividerViewHolder_ViewBinding implements Unbinder {
        private DividerViewHolder f29361b;

        public DividerViewHolder_ViewBinding(DividerViewHolder dividerViewHolder, View view) {
            this.f29361b = dividerViewHolder;
            dividerViewHolder.dividerText = (TextView) Utils.b(view, 16908310, "field 'dividerText'", TextView.class);
        }

        public final void m30414a() {
            DividerViewHolder dividerViewHolder = this.f29361b;
            if (dividerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f29361b = null;
            dividerViewHolder.dividerText = null;
        }
    }

    public class SubredditNameInfoAdapter extends Adapter<SubredditNameInfoViewHolder> {
        List<SubredditNameInfo> f29362a = new ArrayList();
        final /* synthetic */ SubredditSelectScreen f29363b;

        public final /* synthetic */ void m30417a(ViewHolder viewHolder, int i) {
            SubredditNameInfoViewHolder subredditNameInfoViewHolder = (SubredditNameInfoViewHolder) viewHolder;
            SubredditNameInfo subredditNameInfo = (SubredditNameInfo) this.f29362a.get(i);
            Util.m23982a(subredditNameInfoViewHolder.iconView, subredditNameInfo.icon_img, null);
            subredditNameInfoViewHolder.subredditName.setText(subredditNameInfo.name);
            subredditNameInfoViewHolder.subscriberCount.setText(Util.m23960a((int) C1761R.string.fmt_num_subscribers_simple, CountUtil.m23674a((long) subredditNameInfo.subscriber_count)));
            subredditNameInfoViewHolder.c.setOnClickListener(new SubredditSelectScreen$SubredditNameInfoAdapter$$Lambda$0(this, subredditNameInfo));
        }

        public SubredditNameInfoAdapter(SubredditSelectScreen subredditSelectScreen) {
            this.f29363b = subredditSelectScreen;
        }

        public final int m30415a() {
            return this.f29362a.size();
        }

        public final /* synthetic */ ViewHolder m30416a(ViewGroup viewGroup, int i) {
            return new SubredditNameInfoViewHolder(this.f29363b, LayoutInflater.from(this.f29363b.am_()).inflate(C1761R.layout.listitem_subreddit_search, viewGroup, false));
        }
    }

    public class SubredditNameInfoViewHolder extends ViewHolder {
        final /* synthetic */ SubredditSelectScreen f29364a;
        @BindView
        ShapedIconView iconView;
        @BindView
        TextView subredditName;
        @BindView
        TextView subscriberCount;

        public SubredditNameInfoViewHolder(SubredditSelectScreen subredditSelectScreen, View view) {
            this.f29364a = subredditSelectScreen;
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public class SubredditNameInfoViewHolder_ViewBinding implements Unbinder {
        private SubredditNameInfoViewHolder f29365b;

        public SubredditNameInfoViewHolder_ViewBinding(SubredditNameInfoViewHolder subredditNameInfoViewHolder, View view) {
            this.f29365b = subredditNameInfoViewHolder;
            subredditNameInfoViewHolder.iconView = (ShapedIconView) Utils.b(view, C1761R.id.subreddit_icon, "field 'iconView'", ShapedIconView.class);
            subredditNameInfoViewHolder.subredditName = (TextView) Utils.b(view, C1761R.id.subreddit_name, "field 'subredditName'", TextView.class);
            subredditNameInfoViewHolder.subscriberCount = (TextView) Utils.b(view, C1761R.id.subscriber_count, "field 'subscriberCount'", TextView.class);
        }

        public final void m30418a() {
            SubredditNameInfoViewHolder subredditNameInfoViewHolder = this.f29365b;
            if (subredditNameInfoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f29365b = null;
            subredditNameInfoViewHolder.iconView = null;
            subredditNameInfoViewHolder.subredditName = null;
            subredditNameInfoViewHolder.subscriberCount = null;
        }
    }

    public class SubredditSelectionAdapter extends Adapter<ViewHolder> {
        List<SubredditSelectData> f29366a = new ArrayList();
        final /* synthetic */ SubredditSelectScreen f29367b;

        public SubredditSelectionAdapter(SubredditSelectScreen subredditSelectScreen) {
            this.f29367b = subredditSelectScreen;
        }

        public final ViewHolder m30420a(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new DividerViewHolder(this.f29367b, LayoutInflater.from(this.f29367b.am_()).inflate(C1761R.layout.listitem_subreddit_header, viewGroup, false));
            }
            return new SubredditViewHolder(this.f29367b, LayoutInflater.from(this.f29367b.am_()).inflate(C1761R.layout.listitem_subreddit, viewGroup, false));
        }

        public final void m30421a(ViewHolder viewHolder, int i) {
            if (m30422b(i) == 1) {
                ((DividerViewHolder) viewHolder).dividerText.setText(((SubredditDivider) this.f29366a.get(i)).f21640d);
                return;
            }
            SubredditData subredditData = (SubredditData) this.f29366a.get(i);
            SubredditViewHolder subredditViewHolder = (SubredditViewHolder) viewHolder;
            if (SubredditUtil.m23920a(subredditData.f21640d)) {
                subredditViewHolder.subredditName.setText(C1761R.string.rdt_promoter_my_profile);
                Util.m23977a(subredditViewHolder.icon, (Account) AccountStorage.b.a(SessionManager.b().c.getUsername()));
            } else {
                subredditViewHolder.subredditName.setText(subredditData.f21640d);
                Util.m23982a(subredditViewHolder.icon, subredditData.f29355b, subredditData.f29356c);
            }
            viewHolder.c.setOnClickListener(new SubredditSelectScreen$SubredditSelectionAdapter$$Lambda$0(this, subredditData));
        }

        public final int m30419a() {
            return this.f29366a.size();
        }

        public final int m30422b(int i) {
            return ((SubredditSelectData) this.f29366a.get(i)).f21641e;
        }
    }

    public class SubredditViewHolder extends ViewHolder {
        final /* synthetic */ SubredditSelectScreen f29368a;
        @BindView
        ShapedIconView icon;
        @BindView
        TextView subredditName;

        public SubredditViewHolder(SubredditSelectScreen subredditSelectScreen, View view) {
            this.f29368a = subredditSelectScreen;
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public class SubredditViewHolder_ViewBinding implements Unbinder {
        private SubredditViewHolder f29369b;

        public SubredditViewHolder_ViewBinding(SubredditViewHolder subredditViewHolder, View view) {
            this.f29369b = subredditViewHolder;
            subredditViewHolder.subredditName = (TextView) Utils.b(view, C1761R.id.subreddit_name, "field 'subredditName'", TextView.class);
            subredditViewHolder.icon = (ShapedIconView) Utils.b(view, C1761R.id.subreddit_icon, "field 'icon'", ShapedIconView.class);
        }

        public final void m30423a() {
            SubredditViewHolder subredditViewHolder = this.f29369b;
            if (subredditViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f29369b = null;
            subredditViewHolder.subredditName = null;
            subredditViewHolder.icon = null;
        }
    }

    class C26991 extends DisposableObserver<List<SubredditNameInfo>> {
        final /* synthetic */ SubredditSelectScreen f34465a;

        public void onComplete() {
        }

        C26991(SubredditSelectScreen subredditSelectScreen) {
            this.f34465a = subredditSelectScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            List list = (List) obj;
            SubredditSelectScreen.m39600a(this.f34465a, this.f34465a.f39371w);
            Adapter a = this.f34465a.f39371w;
            a.f29362a = list;
            a.a_.b();
        }

        public void onError(Throwable th) {
            SubredditSelectScreen.m39600a(this.f34465a, this.f34465a.f39370v);
            StringBuilder stringBuilder = new StringBuilder("Subreddit name search error: ");
            stringBuilder.append(th.getMessage());
            Timber.e(stringBuilder.toString(), new Object[0]);
        }
    }

    class C27003 extends DisposableObserver<List<SubredditSelectData>> {
        final /* synthetic */ SubredditSelectScreen f34466a;

        public void onComplete() {
        }

        C27003(SubredditSelectScreen subredditSelectScreen) {
            this.f34466a = subredditSelectScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            List list = (List) obj;
            Adapter b = this.f34466a.f39370v;
            b.f29366a = list;
            b.a_.b();
        }

        public void onError(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("SubredditSelect Error: ");
            stringBuilder.append(th.getMessage());
            Timber.e(stringBuilder.toString(), new Object[0]);
        }
    }

    public final int mo7141s() {
        return C1761R.layout.screen_subreddit_select;
    }

    public final int mo7143u() {
        return 2;
    }

    public static SubredditSelectScreen m39598a(String str) {
        SubredditSelectScreen subredditSelectScreen = new SubredditSelectScreen();
        subredditSelectScreen.requestId = str;
        return subredditSelectScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = new SubredditNameInfoProvider();
        this.f39373y = (Disposable) layoutInflater.a.map(SubredditSelectScreen$$Lambda$0.f29358a).subscribeWith(new C26991(this));
        this.subredditFilter.setOnGoClickedListener(new SubredditSelectScreen$$Lambda$1(this));
        this.subredditFilter.setOnEditorActionListener(new SubredditSelectScreen$$Lambda$2(this));
        this.subredditFilter.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SubredditSelectScreen f21644b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().trim().length() > 2) {
                    i = layoutInflater;
                    charSequence = charSequence.toString().trim();
                    Task.a(new 4(i.b, charSequence)).a(AsyncCallbackContinuation.a(new 1(i, charSequence)), Task.b);
                    return;
                }
                SubredditSelectScreen.m39600a(this.f21644b, this.f21644b.f39370v);
            }
        });
        this.f39371w = new SubredditNameInfoAdapter(this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(am_(), 1, false));
        this.f39370v = new SubredditSelectionAdapter(this);
        this.recyclerView.setAdapter(this.f39370v);
        layoutInflater = new SubredditSelectDataProvider();
        this.f39372x = (Disposable) layoutInflater.g.subscribeWith(new C27003(this));
        viewGroup = am_();
        if (layoutInflater.g.hasObservers()) {
            EventBus.getDefault().register(layoutInflater);
            layoutInflater.e = 5;
            layoutInflater.f = RedditJobManager.f10810d;
            layoutInflater.c = false;
            layoutInflater.d = false;
            layoutInflater.a = new RecentSubredditLoaderProvider();
            layoutInflater.b = new SubscribedSubredditProvider();
            layoutInflater.a.a(viewGroup);
            layoutInflater.b.a(viewGroup);
            return this.K;
        }
        throw new IllegalStateException("Subscribe using getSubredditObservable() before fetching the data.");
    }

    static final /* synthetic */ List m39599a(List list) throws Exception {
        if (list == null) {
            return null;
        }
        for (SubredditNameInfo subredditNameInfo : list) {
            if (!(SubredditUtil.m23929b(subredditNameInfo.name) || SubredditUtil.m23920a(subredditNameInfo.name))) {
                subredditNameInfo.name = String.format(Util.m24027f((int) C1761R.string.fmt_r_name), new Object[]{subredditNameInfo.name});
            }
        }
        return list;
    }

    protected final void au() {
        n();
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_();
        appCompatActivity.a(at());
        mo7185a(appCompatActivity.c().a());
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(true);
        actionBar.b(true);
        actionBar.c(true);
        actionBar.a(C1761R.string.title_select_community);
    }

    public final void mo7191l() {
        this.f39372x.mo5626a();
        this.f39373y.mo5626a();
        super.mo7191l();
    }

    public final boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return null;
        }
        m29351F();
        return true;
    }

    static /* synthetic */ void m39600a(SubredditSelectScreen subredditSelectScreen, Adapter adapter) {
        if (subredditSelectScreen.recyclerView.getAdapter() != adapter) {
            subredditSelectScreen.recyclerView.setAdapter(adapter);
        }
    }

    static /* synthetic */ boolean m39601a(SubredditSelectScreen subredditSelectScreen, String str, String str2, String str3, String str4) {
        EventBus.getDefault().postSticky(new SubredditSelectEvent(subredditSelectScreen.requestId, str, str2, str3, str4));
        subredditSelectScreen.m29351F();
        return true;
    }
}
