package com.reddit.frontpage.ui.listing;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider.MultiredditCommunityErrorEvent;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider.MultiredditCommunityLoadEvent;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ShapedIconView;

public class MultiredditCommunitiesScreen extends BaseScreen {
    private View f39224A;
    private RecyclerView f39225B;
    private TextView f39226C;
    @State
    String multiredditName;
    RecyclerHeaderFooterAdapter f39227v;
    private MultiredditCommunitiesProvider f39228w;
    private View f39229x;
    private View f39230y;
    private View f39231z;

    class C18961 implements OnClickListener {
        final /* synthetic */ MultiredditCommunitiesScreen f21313a;

        C18961(MultiredditCommunitiesScreen multiredditCommunitiesScreen) {
            this.f21313a = multiredditCommunitiesScreen;
        }

        public void onClick(View view) {
            MultiredditCommunitiesScreen.m39306a(this.f21313a);
            this.f21313a.f39228w.a();
        }
    }

    public class MultiredditCommunityAdapter extends Adapter<MultiredditCommunityViewHolder> {
        final /* synthetic */ MultiredditCommunitiesScreen f29063a;

        public MultiredditCommunityAdapter(MultiredditCommunitiesScreen multiredditCommunitiesScreen) {
            this.f29063a = multiredditCommunitiesScreen;
        }

        public final /* synthetic */ void m30116a(ViewHolder viewHolder, int i) {
            MultiredditCommunityViewHolder multiredditCommunityViewHolder = (MultiredditCommunityViewHolder) viewHolder;
            SubredditInfo subredditInfo = (SubredditInfo) this.f29063a.f39228w.communities.get(i);
            Util.m23982a(multiredditCommunityViewHolder.f29065b, subredditInfo.getIconImage(), subredditInfo.getKeyColor());
            CharSequence displayNamePrefixed = subredditInfo.getDisplayNamePrefixed();
            if (!TextUtils.isEmpty(displayNamePrefixed)) {
                multiredditCommunityViewHolder.f29066p.setText(displayNamePrefixed);
            }
            multiredditCommunityViewHolder.f29067q.setText(Util.m23960a((int) C1761R.string.fmt_num_readers, Long.valueOf(subredditInfo.getSubscribers())));
            multiredditCommunityViewHolder.c.setTag(subredditInfo.getSubredditName());
        }

        public final int m30114a() {
            return this.f29063a.f39228w.b();
        }

        public final /* synthetic */ ViewHolder m30115a(ViewGroup viewGroup, int i) {
            return new MultiredditCommunityViewHolder(this.f29063a, LayoutInflater.from(this.f29063a.am_()).inflate(C1761R.layout.listitem_multireddit_community, viewGroup, false));
        }
    }

    public class MultiredditCommunityViewHolder extends ViewHolder {
        final /* synthetic */ MultiredditCommunitiesScreen f29064a;
        private final ShapedIconView f29065b;
        private final TextView f29066p;
        private final TextView f29067q;

        public MultiredditCommunityViewHolder(MultiredditCommunitiesScreen multiredditCommunitiesScreen, View view) {
            this.f29064a = multiredditCommunitiesScreen;
            super(view);
            this.f29065b = (ShapedIconView) view.findViewById(C1761R.id.subreddit_icon);
            this.f29066p = (TextView) view.findViewById(C1761R.id.subreddit_name);
            this.f29067q = (TextView) view.findViewById(C1761R.id.subreddit_subscribers);
            view.setOnClickListener(new C1897xb4e8fcbe(this));
        }
    }

    public String getAnalyticsScreenName() {
        return "multireddit_communities";
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_multireddit_communities_list;
    }

    public static MultiredditCommunitiesScreen m39305a(String str) {
        MultiredditCommunitiesScreen multiredditCommunitiesScreen = new MultiredditCommunitiesScreen();
        multiredditCommunitiesScreen.multiredditName = str;
        return multiredditCommunitiesScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        ((TextView) this.K.findViewById(C1761R.id.toolbar_title)).setText(this.multiredditName);
        n();
        this.f39229x = this.K.findViewById(C1761R.id.content_container);
        this.f39230y = this.K.findViewById(C1761R.id.error_container);
        this.f39231z = this.f39230y.findViewById(C1761R.id.retry_button);
        this.f39231z.setOnClickListener(new C18961(this));
        this.f39224A = this.K.findViewById(C1761R.id.progress_bar);
        this.f39224A.setBackground(AnimUtil.m23637a(am_()));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.K.findViewById(C1761R.id.refresh_layout);
        swipeRefreshLayout.setVisibility(0);
        swipeRefreshLayout.setEnabled(false);
        this.f39225B = (RecyclerView) this.K.findViewById(C1761R.id.link_list);
        this.f39225B.setLayoutManager(new LinearLayoutManager(am_(), 1, false));
        this.f39226C = (TextView) layoutInflater.inflate(C1761R.layout.listheader_multireddit_community, this.f39225B, false);
        this.f39227v = new RecyclerHeaderFooterAdapter(new MultiredditCommunityAdapter(this));
        this.f39227v.f34364b = this.f39226C;
        this.f39225B.setAdapter(this.f39227v);
        return this.K;
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        this.f39228w.a();
    }

    protected final void mo7144v() {
        this.f39228w = new MultiredditCommunitiesProvider(this.multiredditName);
        m37523a(this.f39228w);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.mo7201a(menuItem);
        }
        Routing.m22621a((Screen) this);
        return true;
    }

    public void onEvent(MultiredditCommunityLoadEvent multiredditCommunityLoadEvent) {
        this.f39226C.setText(Util.m23960a((int) C1761R.string.fmt_num_communities, Integer.valueOf(this.f39228w.b())));
        this.f39225B.getAdapter().a_.b();
        this.f39230y.setVisibility(8);
        this.f39229x.setVisibility(0);
        this.f39224A.setVisibility(8);
        this.f39227v.a_.b();
    }

    public void onEvent(MultiredditCommunityErrorEvent multiredditCommunityErrorEvent) {
        this.f39230y.setVisibility(0);
        this.f39229x.setVisibility(8);
        this.f39224A.setVisibility(8);
    }

    static /* synthetic */ void m39306a(MultiredditCommunitiesScreen multiredditCommunitiesScreen) {
        multiredditCommunitiesScreen.f39230y.setVisibility(8);
        multiredditCommunitiesScreen.f39229x.setVisibility(0);
        multiredditCommunitiesScreen.f39224A.setVisibility(0);
    }
}
