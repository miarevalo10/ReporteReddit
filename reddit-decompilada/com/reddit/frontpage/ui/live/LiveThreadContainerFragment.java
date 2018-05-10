package com.reddit.frontpage.ui.live;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.provider.LiveThreadProvider;
import com.reddit.datalibrary.frontpage.data.provider.LiveThreadProvider.LiveThreadLoadEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.HasToolbar;
import com.reddit.frontpage.ui.detail.live.LiveDetailsFragment;
import com.reddit.frontpage.util.LinkUtil;

public class LiveThreadContainerFragment extends BaseFrontpageFragment implements HasToolbar, OnViewerCountChangeListener {
    private static final int[] f39236a = new int[]{C1761R.string.title_tab_live_updates, C1761R.string.title_tab_details};
    private PagerAdapter f39237b;
    @State
    boolean enablePaging;
    @State(ParcelerBundler.class)
    LiveThread liveThread;
    @State
    String liveThreadId;
    @BindView
    TextView liveTitleView;
    @BindView
    TextView liveViewersView;
    @State(ParcelerBundler.class)
    LiveThreadProvider provider;
    @BindView
    TabLayout tabLayout;
    @BindView
    public Toolbar toolbar;
    @BindView
    ViewPager viewPager;

    private class LoadingPagerAdapter extends PagerAdapter {
        final /* synthetic */ LiveThreadContainerFragment f29156b;

        public final boolean m30260a(View view, Object obj) {
            return view == obj;
        }

        private LoadingPagerAdapter(LiveThreadContainerFragment liveThreadContainerFragment) {
            this.f29156b = liveThreadContainerFragment;
        }

        public final Object m30258a(ViewGroup viewGroup, int i) {
            i = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.live_loading, viewGroup, false);
            viewGroup.addView(i);
            return i;
        }

        public final void m30259a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeAllViews();
        }

        public final int m30262c() {
            return LiveThreadContainerFragment.f39236a.length;
        }

        public final CharSequence m30261b(int i) {
            return this.f29156b.getString(LiveThreadContainerFragment.f39236a[i]);
        }
    }

    private class LivePagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ LiveThreadContainerFragment f34401b;

        LivePagerAdapter(LiveThreadContainerFragment liveThreadContainerFragment, FragmentManager fragmentManager) {
            this.f34401b = liveThreadContainerFragment;
            super(fragmentManager);
        }

        public final Fragment m35139a(int i) {
            switch (i) {
                case 0:
                    return LiveUpdatesFragment.m39331a(this.f34401b.liveThread, this.f34401b);
                case 1:
                    return LiveDetailsFragment.m39144a(this.f34401b.liveThread);
                default:
                    return 0;
            }
        }

        public final int m35141c() {
            return LiveThreadContainerFragment.f39236a.length;
        }

        public final CharSequence m35140b(int i) {
            return this.f34401b.getString(LiveThreadContainerFragment.f39236a[i]);
        }
    }

    public final int mo7160h() {
        return C1761R.layout.fragment_live_thread;
    }

    public static LiveThreadContainerFragment m39323a(LiveThread liveThread) {
        Bundle bundle = new Bundle();
        LiveThreadContainerFragment liveThreadContainerFragment = new LiveThreadContainerFragment();
        liveThreadContainerFragment.setArguments(bundle);
        liveThreadContainerFragment.liveThread = liveThread;
        liveThreadContainerFragment.enablePaging = true;
        return liveThreadContainerFragment;
    }

    public static LiveThreadContainerFragment m39324a(String str) {
        Bundle bundle = new Bundle();
        LiveThreadContainerFragment liveThreadContainerFragment = new LiveThreadContainerFragment();
        liveThreadContainerFragment.setArguments(bundle);
        liveThreadContainerFragment.liveThreadId = str;
        liveThreadContainerFragment.enablePaging = true;
        return liveThreadContainerFragment;
    }

    public final Toolbar mo7208b() {
        return this.toolbar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (this.liveThread != null) {
            this.provider = new LiveThreadProvider(this.liveThread);
            this.f39237b = new LivePagerAdapter(this, getChildFragmentManager());
            return;
        }
        this.provider = new LiveThreadProvider(this.liveThreadId);
        this.f39237b = new LoadingPagerAdapter();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        layoutInflater = true;
        setHasOptionsMenu(true);
        viewGroup = this.e.getContext();
        this.tabLayout.a(ResourcesUtil.m22740i(viewGroup, C1761R.attr.rdt_meta_text_color), ResourcesUtil.m22740i(viewGroup, C1761R.attr.rdt_body_text_color));
        this.viewPager.setAdapter(this.f39237b);
        this.tabLayout.setupWithViewPager(this.viewPager);
        viewGroup = this.viewPager;
        if (this.liveThread == null || this.enablePaging == null) {
            layoutInflater = null;
        }
        viewGroup.setEnabled(layoutInflater);
        return this.e;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BaseActivity baseActivity = (BaseActivity) getActivity();
        baseActivity.a(this.toolbar);
        baseActivity.c().a().b(true);
        m39327c();
        if (this.liveThread == null) {
            this.provider.load();
        }
    }

    public void onResume() {
        super.onResume();
        this.provider.load();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_live_thread, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1761R.id.action_share) {
            return super.onOptionsItemSelected(menuItem);
        }
        menuItem = AppAnalytics.m21858b();
        menuItem.f19954a = Kind.LIVE;
        menuItem.f19955b = TheaterModeEvents.NOUN_SHARE;
        menuItem.f19958e = this.liveThreadId;
        menuItem.m21825a();
        LinkUtil.m23779a(getActivity(), this.liveThread);
        return true;
    }

    public final void mo7221a(int i) {
        m39326b(i);
    }

    public void onEventMainThread(LiveThreadLoadEvent liveThreadLoadEvent) {
        if (this.liveThread == null) {
            this.liveThread = this.provider.getLiveThread();
            m39327c();
            this.f39237b = new LivePagerAdapter(this, getChildFragmentManager());
            this.viewPager.setAdapter(this.f39237b);
            this.viewPager.setEnabled(this.enablePaging);
        }
    }

    private void m39327c() {
        int i;
        if (this.liveThread == null || !this.liveThread.isLive()) {
            f39236a[0] = C1761R.string.title_tab_archived;
            this.liveViewersView.setVisibility(8);
        } else {
            this.liveViewersView.setVisibility(0);
            f39236a[0] = C1761R.string.title_tab_live_updates;
            m39326b(this.liveThread.getViewerCount());
        }
        if (this.liveThread != null) {
            if (!this.liveThread.isLive()) {
                i = C1761R.drawable.circle_transulcent_white;
                this.liveTitleView.setCompoundDrawablesRelative(getResources().getDrawable(i), null, null, null);
            }
        }
        i = C1761R.drawable.circle_white;
        this.liveTitleView.setCompoundDrawablesRelative(getResources().getDrawable(i), null, null, null);
    }

    private void m39326b(int i) {
        i = Math.max(1, i);
        this.liveViewersView.setText(getResources().getQuantityString(C1761R.plurals.fmt_live_viewers, i, new Object[]{Integer.valueOf(i)}));
        this.liveViewersView.setVisibility(0);
    }
}
