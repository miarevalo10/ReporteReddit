package com.reddit.frontpage.presentation.modtools.modlist;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.crashlytics.android.Crashlytics;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsScreen;
import com.reddit.frontpage.presentation.modtools.modlist.editable.EditableModeratorsScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ScreenPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0003;<=B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020\u000bH\u0016J\u0018\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0014J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020-2\u0006\u00101\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\tR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\tR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006>"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/ModAddUserTarget;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "subredditName", "", "(Ljava/lang/String;)V", "POSITION_ALL", "", "POSITION_EDITABLE", "TAB_NAME_RES_IDS", "", "pagerAdapter", "Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen$ModListPagerAdapter;", "screenPager", "Lcom/reddit/frontpage/widgets/ScreenPager;", "getScreenPager", "()Lcom/reddit/frontpage/widgets/ScreenPager;", "setScreenPager", "(Lcom/reddit/frontpage/widgets/ScreenPager;)V", "subredditId", "getSubredditId", "()Ljava/lang/String;", "setSubredditId", "getSubredditName", "setSubredditName", "tabLayout", "Landroid/support/design/widget/TabLayout;", "getTabLayout", "()Landroid/support/design/widget/TabLayout;", "setTabLayout", "(Landroid/support/design/widget/TabLayout;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "getLayoutId", "onAddUserSuccess", "username", "stringRes", "onAttach", "view", "Landroid/view/View;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "DeepLinker", "ModListPagerAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModListPagerScreen.kt */
public final class ModListPagerScreen extends MvpBaseScreen implements ModAddUserTarget {
    public static final Companion f40094v = new Companion();
    @BindView
    public ScreenPager screenPager;
    @State
    public String subredditId;
    @State
    public String subredditName;
    @BindView
    public TabLayout tabLayout;
    private final int f40095w;
    private final int f40096x = 1;
    private final int[] f40097y = new int[]{C1761R.string.mod_tools_title_tab_all, C1761R.string.mod_tools_title_tab_editable};
    private ModListPagerAdapter f40098z = new ModListPagerAdapter(this);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen$Companion;", "", "()V", "ARGS_SUBREDDIT_NAME", "", "args", "Landroid/os/Bundle;", "subredditName", "deepLink", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen;", "subredditId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModListPagerScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ModListPagerScreen m23117a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            ModListPagerScreen modListPagerScreen = new ModListPagerScreen();
            Intrinsics.m26847b(str, "<set-?>");
            modListPagerScreen.subredditId = str;
            Intrinsics.m26847b(str2, "<set-?>");
            modListPagerScreen.subredditName = str2;
            return modListPagerScreen;
        }

        public static ScreenDeepLinker m23118a(String str) {
            Intrinsics.m26847b(str, "subredditName");
            DeepLinker deepLinker = new DeepLinker();
            deepLinker.setSubredditName(str);
            return deepLinker;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen$DeepLinker;", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "()V", "subredditName", "", "getSubredditName", "()Ljava/lang/String;", "setSubredditName", "(Ljava/lang/String;)V", "createScreen", "Lcom/reddit/frontpage/nav/Screen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: ModListPagerScreen.kt */
    public static final class DeepLinker implements ScreenDeepLinker {
        public String subredditName;

        public final String getSubredditName() {
            String str = this.subredditName;
            if (str == null) {
                Intrinsics.m26844a("subredditName");
            }
            return str;
        }

        public final void setSubredditName(String str) {
            Intrinsics.m26847b(str, "<set-?>");
            this.subredditName = str;
        }

        public final Screen createScreen() {
            Companion companion = ModListPagerScreen.f40094v;
            String str = "";
            String str2 = this.subredditName;
            if (str2 == null) {
                Intrinsics.m26844a("subredditName");
            }
            return Companion.m23117a(str, str2);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0014¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen$ModListPagerAdapter;", "Lcom/reddit/frontpage/ui/listing/adapter/ScreenPagerAdapter;", "(Lcom/reddit/frontpage/presentation/modtools/modlist/ModListPagerScreen;)V", "createScreen", "Lcom/reddit/frontpage/nav/Screen;", "position", "", "getPageTitle", "", "getScreenCount", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModListPagerScreen.kt */
    private final class ModListPagerAdapter extends ScreenPagerAdapter {
        final /* synthetic */ ModListPagerScreen f36981d;

        public ModListPagerAdapter(ModListPagerScreen modListPagerScreen) {
            this.f36981d = modListPagerScreen;
            super(modListPagerScreen, true);
        }

        protected final Screen mo6953a(int i) {
            if (i == this.f36981d.f40095w) {
                i = AllModeratorsScreen.f40587w;
                return com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsScreen.Companion.m23126a(this.f36981d.m40793w(), this.f36981d.m40794x());
            }
            i = EditableModeratorsScreen.f40589w;
            return com.reddit.frontpage.presentation.modtools.modlist.editable.EditableModeratorsScreen.Companion.m23127a(this.f36981d.m40793w(), this.f36981d.m40794x());
        }

        protected final int mo6955f() {
            return this.f36981d.f40097y.length;
        }

        public final CharSequence m37355b(int i) {
            Object f = Util.m24027f(this.f36981d.f40097y[i]);
            Intrinsics.m26843a(f, "Util.getString(TAB_NAME_RES_IDS[position])");
            return (CharSequence) f;
        }
    }

    public static final ModListPagerScreen m40783a(String str, String str2) {
        return Companion.m23117a(str, str2);
    }

    public static final ScreenDeepLinker m40784a(String str) {
        return Companion.m23118a(str);
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_modlist_pager;
    }

    public ModListPagerScreen() {
        super();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ModListPagerScreen(android.os.Bundle r2) {
        /*
        r1 = this;
        r0 = "bundle";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r0);
        r1.<init>(r2);
        r2 = 1;
        r1.f40096x = r2;
        r2 = 2;
        r2 = new int[r2];
        r2 = {2131886988, 2131886989};
        r1.f40097y = r2;
        r2 = new com.reddit.frontpage.presentation.modtools.modlist.ModListPagerScreen$ModListPagerAdapter;
        r2.<init>(r1);
        r1.f40098z = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.modtools.modlist.ModListPagerScreen.<init>(android.os.Bundle):void");
    }

    public final String m40793w() {
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        return str;
    }

    public final String m40794x() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        layoutInflater = this.screenPager;
        if (layoutInflater == null) {
            Intrinsics.m26844a("screenPager");
        }
        layoutInflater.setAdapter((PagerAdapter) this.f40098z);
        layoutInflater = this.tabLayout;
        if (layoutInflater == null) {
            Intrinsics.m26844a("tabLayout");
        }
        viewGroup = this.screenPager;
        if (viewGroup == null) {
            Intrinsics.m26844a("screenPager");
        }
        layoutInflater.setupWithViewPager((ViewPager) viewGroup);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        Crashlytics.log("ModListPagerScreen: uses ScreenPager");
        super.mo6992b(view);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        super.mo7185a(actionBar);
        m37537h(Util.m24027f((int) C1761R.string.mod_tools_moderator_list));
    }

    public final void m40788a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_modtools_add, menu);
        Object findItem = menu.findItem(C1761R.id.action_modtools_add);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_modtools_add)");
        findItem.setEnabled(true);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_add) {
            return super.mo7201a(menuItem);
        }
        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27455f)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20031C.f20068M);
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        String str2 = this.subredditName;
        if (str2 == null) {
            Intrinsics.m26844a("subredditName");
        }
        ((ModEventBuilder) modEventBuilder.m21889a(str, str2)).m21891a();
        menuItem = this.subredditId;
        if (menuItem == null) {
            Intrinsics.m26844a("subredditId");
        }
        str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        Screen j = Nav.m22595j(menuItem, str);
        Screen screen = this;
        j.m29363b(screen);
        Routing.m22623a(screen, j);
        return true;
    }

    public final void mo7384a(String str, int i) {
        Intrinsics.m26847b(str, "username");
        str = Screens.m22629a(this, Util.m23960a(i, str), 0);
        if (str != null) {
            str.a();
        }
    }
}
