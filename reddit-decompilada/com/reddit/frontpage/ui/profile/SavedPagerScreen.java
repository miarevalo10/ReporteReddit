package com.reddit.frontpage.ui.profile;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.crashlytics.android.Crashlytics;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.SimpleOnTabSelectedListener;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ScreenPager;
import org.parceler.Parcel;

public class SavedPagerScreen extends BaseScreen {
    private static final int[] f39266v = new int[]{C1761R.string.title_posts, C1761R.string.title_comments};
    @BindView
    ScreenPager screenPager;
    @BindView
    TabLayout tabLayout;
    private SavedPagerAdapter f39267w;

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        DeepLinker() {
        }

        public Screen createScreen() {
            return SavedPagerScreen.m39404w();
        }
    }

    class C26941 extends SimpleOnTabSelectedListener {
        final /* synthetic */ SavedPagerScreen f34412a;

        C26941(SavedPagerScreen savedPagerScreen) {
            this.f34412a = savedPagerScreen;
        }

        public final void mo6520a(Tab tab) {
            SavedPagerScreen.m39403a(tab.e);
        }
    }

    private class SavedPagerAdapter extends ScreenPagerAdapter {
        final /* synthetic */ SavedPagerScreen f37330d;

        SavedPagerAdapter(SavedPagerScreen savedPagerScreen) {
            this.f37330d = savedPagerScreen;
            super(savedPagerScreen, true);
        }

        public final Screen mo6953a(int i) {
            switch (i) {
                case 0:
                    return SavedLinksScreen.m41067w();
                case 1:
                    return SavedCommentsScreen.m41057w();
                default:
                    return 0;
            }
        }

        public final int mo6955f() {
            return SavedPagerScreen.f39266v.length;
        }

        public final CharSequence m37753b(int i) {
            return Util.m24027f(SavedPagerScreen.f39266v[i]);
        }
    }

    public final int mo7141s() {
        return C1761R.layout.screen_saved_pager;
    }

    public static SavedPagerScreen m39404w() {
        return new SavedPagerScreen();
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39267w = new SavedPagerAdapter(this);
        n();
        this.screenPager.setAdapter(this.f39267w);
        this.tabLayout.setupWithViewPager(this.screenPager);
        this.tabLayout.a(new C26941(this));
        return this.K;
    }

    protected final void mo6992b(View view) {
        Crashlytics.log("SavedPagerScreen: uses ScreenPager");
        super.mo6992b(view);
    }

    public final void mo6987a(View view) {
        super.mo6987a(view);
        this.f39267w.f34367g = false;
        this.f39267w = null;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(C1761R.string.title_saved);
    }

    static /* synthetic */ void m39403a(int i) {
        String str = "unspecified";
        switch (i) {
            case 0:
                str = "posts";
                break;
            case 1:
                str = "comments";
                break;
            default:
                break;
        }
        i = AppAnalytics.m21871h();
        i.f19970c = "profile_saved";
        i.f19968a = str;
        i.m21832a();
    }
}
