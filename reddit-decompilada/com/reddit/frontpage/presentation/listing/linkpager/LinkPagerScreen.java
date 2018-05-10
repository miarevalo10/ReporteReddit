package com.reddit.frontpage.presentation.listing.linkpager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerLinkPagerComponent;
import com.reddit.frontpage.di.component.LinkPagerComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters.HistoryParameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters.StandardParameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.View;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.HasToolbar;
import com.reddit.frontpage.ui.color.ColorSource;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.ui.detail.OnLinkActionListener;
import com.reddit.frontpage.ui.detail.image.ImageDetailScreen;
import com.reddit.frontpage.ui.detail.self.SelfDetailScreen;
import com.reddit.frontpage.ui.detail.video.VideoDetailScreen;
import com.reddit.frontpage.ui.detail.video.VideoDetailScreenLegacy;
import com.reddit.frontpage.ui.detail.web.WebDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostImageDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostSmallDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostVideoDetailScreen;
import com.reddit.frontpage.ui.detail.xpost.XPostVideoLegacyDetailScreen;
import com.reddit.frontpage.ui.listing.BaseLinkListingScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.widgets.ScreenPager;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002{|B\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0013H\u0016J\b\u0010M\u001a\u00020\u0013H\u0016J\b\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020JH\u0016J\b\u0010S\u001a\u00020JH\u0016J\b\u0010T\u001a\u00020JH\u0016J\u0010\u0010U\u001a\u00020J2\u0006\u0010V\u001a\u00020WH\u0014J\b\u0010X\u001a\u00020YH\u0016J\u0018\u0010Z\u001a\u00020J2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0016J\u0018\u0010_\u001a\u00020W2\u0006\u0010]\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020J2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010d\u001a\u00020J2\u0006\u0010V\u001a\u00020WH\u0014J\b\u0010e\u001a\u00020JH\u0014J\u0017\u0010f\u001a\u00020J2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010g\u001a\u00020JH\u0016J\b\u0010h\u001a\u00020JH\u0016J\b\u0010i\u001a\u00020JH\u0016J\u0010\u0010j\u001a\u00020Y2\u0006\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020J2\u0006\u0010[\u001a\u00020\\H\u0016J\u0017\u0010n\u001a\u00020J2\b\u0010F\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0018J\u0018\u0010o\u001a\u00020J2\u0006\u0010p\u001a\u00020\u00132\u0006\u0010q\u001a\u00020YH\u0002J\u0010\u0010r\u001a\u00020J2\u0006\u0010p\u001a\u00020\u0013H\u0002J\u0010\u0010s\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0005H\u0016J\u0010\u0010t\u001a\u00020J2\u0006\u0010u\u001a\u00020\u0013H\u0016J\u0016\u0010v\u001a\u00020J2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020y0xH\u0016J\b\u0010z\u001a\u00020JH\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010&\u001a\u00060'R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R \u0010@\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER(\u0010F\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138V@VX\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018¨\u0006}"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$View;", "Lcom/reddit/frontpage/ui/detail/OnLinkActionListener;", "Lcom/reddit/frontpage/ui/color/ColorSource;", "Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "Lcom/reddit/frontpage/widgets/modtools/modqueue/ModModeable;", "()V", "adsVisibilityTracker", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;", "getAdsVisibilityTracker", "()Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;", "setAdsVisibilityTracker", "(Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;)V", "currentScreen", "Lcom/reddit/frontpage/nav/Screen;", "getCurrentScreen", "()Lcom/reddit/frontpage/nav/Screen;", "color", "", "keyColor", "getKeyColor", "()Ljava/lang/Integer;", "setKeyColor", "(Ljava/lang/Integer;)V", "linkPosition", "getLinkPosition", "()I", "setLinkPosition", "(I)V", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "setListingType", "(Lcom/reddit/frontpage/presentation/listing/common/ListingType;)V", "onColorChangedCallbacks", "", "pagerAdapter", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$PagerAdapter;", "getPagerAdapter", "()Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$PagerAdapter;", "pagerAdapter$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "presenter", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerPresenter;)V", "screenPager", "Lcom/reddit/frontpage/widgets/ScreenPager;", "selectedLinkId", "", "getSelectedLinkId", "()Ljava/lang/String;", "setSelectedLinkId", "(Ljava/lang/String;)V", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "setSort", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;)V", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "setSortTimeFrame", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "topColor", "getTopColor", "setTopColor", "addOnColorChangedCallback", "", "callback", "getDefaultScreenPosition", "getLayoutId", "getTargetScreen", "Lcom/reddit/frontpage/ui/listing/BaseLinkListingScreen;", "initParameters", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;", "notifyListingChanged", "notifyLoadError", "notifyLoadMoreError", "onAttach", "view", "Landroid/view/View;", "onBackPressed", "", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onInitialize", "onKeyColorChanged", "onLinkDeleted", "onLinkHidden", "onLinkUnhidden", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "onTopColorChanged", "pageSelected", "pagerPosition", "isSwipe", "pageUnselected", "removeOnColorChangedCallback", "setCurrentPosition", "position", "setListing", "listing", "", "Lcom/reddit/frontpage/domain/model/Link;", "showContentView", "Companion", "PagerAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerScreen.kt */
public final class LinkPagerScreen extends MvpBaseScreen implements View, ColorSource, OnColorChangedCallback, OnLinkActionListener, ModModeable {
    static final /* synthetic */ KProperty[] f40051v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkPagerScreen.class), "pagerAdapter", "getPagerAdapter()Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$PagerAdapter;"))};
    public static final Companion f40052y = new Companion();
    private final List<OnColorChangedCallback> f40053A = new ArrayList();
    private final InvalidatableLazy f40054B = LazyKt.m24085a((BaseScreen) this, (Function0) new LinkPagerScreen$pagerAdapter$2(this));
    @State
    int linkPosition;
    @State
    public ListingType listingType;
    @State
    public String selectedLinkId;
    @State
    public LinkSortType sort;
    @State
    SortTimeFrame sortTimeFrame;
    @Inject
    public LinkPagerPresenter f40055w;
    @Inject
    public AdVisibilityTracker f40056x;
    private ScreenPager f40057z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen;", "selectedLinkId", "", "linkPosition", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LinkPagerScreen m22968a(String str, int i, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame) {
            Intrinsics.m26847b(str, "selectedLinkId");
            Intrinsics.m26847b(listingType, "listingType");
            Intrinsics.m26847b(linkSortType, "sort");
            LinkPagerScreen linkPagerScreen = new LinkPagerScreen();
            Intrinsics.m26847b(str, "<set-?>");
            linkPagerScreen.selectedLinkId = str;
            linkPagerScreen.linkPosition = i;
            Intrinsics.m26847b(listingType, "<set-?>");
            linkPagerScreen.listingType = listingType;
            Intrinsics.m26847b(linkSortType, "<set-?>");
            linkPagerScreen.sort = linkSortType;
            linkPagerScreen.sortTimeFrame = sortTimeFrame;
            return linkPagerScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$PagerAdapter;", "Lcom/reddit/frontpage/ui/listing/adapter/ScreenPagerAdapter;", "(Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen;)V", "listing", "", "Lcom/reddit/frontpage/domain/model/Link;", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "sourcePage", "", "getSourcePage", "()Ljava/lang/String;", "setSourcePage", "(Ljava/lang/String;)V", "configureScreen", "", "screen", "Lcom/reddit/frontpage/nav/Screen;", "position", "", "createScreen", "getCrossPostPostDetailScreen", "Lcom/reddit/frontpage/ui/detail/xpost/XPostDetailScreen;", "link", "clientLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/ClientLink;", "extras", "Landroid/os/Bundle;", "getScreenCount", "getVideoPostDetailScreen", "Lcom/reddit/frontpage/ui/detail/FlexContainerDetailScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerScreen.kt */
    private final class PagerAdapter extends ScreenPagerAdapter {
        List<Link> f36698d = CollectionsKt__CollectionsKt.m26790a();
        public String f36699e;
        final /* synthetic */ LinkPagerScreen f36700f;

        public PagerAdapter(LinkPagerScreen linkPagerScreen) {
            this.f36700f = linkPagerScreen;
            super(linkPagerScreen, false);
        }

        protected final void mo6954a(Screen screen, int i) {
            Intrinsics.m26847b(screen, "screen");
            screen.a_(1);
        }

        protected final Screen mo6953a(int i) {
            Link link = (Link) this.f36698d.get(i);
            Bundle bundle = new Bundle();
            bundle.putInt("com.reddit.arg.position", i);
            bundle.putBoolean("com.reddit.arg.enableScreenViewEvents", false);
            i = "com.reddit.arg.sourcePage";
            String str = this.f36699e;
            if (str == null) {
                Intrinsics.m26844a("sourcePage");
            }
            bundle.putString(i, str);
            bundle.putBoolean("com.reddit.arg.fromFeed", true);
            i = new ClientLink(link);
            Object a;
            if (Intrinsics.m26845a(link.getLinkType(), LinkType.CROSSPOST)) {
                List crossPostParentList = link.getCrossPostParentList();
                if (crossPostParentList == null) {
                    Intrinsics.m26842a();
                }
                Link link2 = (Link) crossPostParentList.get(0);
                if (link2.isImageLinkType()) {
                    a = XPostImageDetailScreen.m42481a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                    Intrinsics.m26843a(a, "XPostImageDetailScreen.n…tance(clientLink, extras)");
                    i = (XPostDetailScreen) a;
                } else if (link2.isVideo()) {
                    a = XPostVideoDetailScreen.m42487a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                    Intrinsics.m26843a(a, "XPostVideoDetailScreen.n…tance(clientLink, extras)");
                    i = (XPostDetailScreen) a;
                } else if (link2.isVideoLinkType()) {
                    a = XPostVideoLegacyDetailScreen.m42501a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                    Intrinsics.m26843a(a, "XPostVideoLegacyDetailSc…tance(clientLink, extras)");
                    i = (XPostDetailScreen) a;
                } else {
                    a = XPostSmallDetailScreen.m42484a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                    Intrinsics.m26843a(a, "XPostSmallDetailScreen.n…tance(clientLink, extras)");
                    i = (XPostDetailScreen) a;
                }
                i = (BaseDetailScreen) i;
            } else if (link.isSelf()) {
                a = SelfDetailScreen.m42157a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                Intrinsics.m26843a(a, "SelfDetailScreen.newInstance(clientLink, extras)");
                i = (BaseDetailScreen) a;
            } else if (link.isVideoLinkType()) {
                if (link.isVideo()) {
                    Object a2 = InternalSettings.a();
                    Intrinsics.m26843a(a2, "InternalSettings.getInstance()");
                    if (!a2.q()) {
                        a = VideoDetailScreen.m42165a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                        Intrinsics.m26843a(a, "VideoDetailScreen.newInstance(clientLink, extras)");
                        i = (FlexContainerDetailScreen) a;
                        i = (BaseDetailScreen) i;
                    }
                }
                a = VideoDetailScreenLegacy.m42203a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                Intrinsics.m26843a(a, "VideoDetailScreenLegacy.…tance(clientLink, extras)");
                i = (FlexContainerDetailScreen) a;
                i = (BaseDetailScreen) i;
            } else if (link.isImageLinkType()) {
                a = ImageDetailScreen.m42154a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                Intrinsics.m26843a(a, "ImageDetailScreen.newInstance(clientLink, extras)");
                i = (BaseDetailScreen) a;
            } else {
                a = WebDetailScreen.m42213a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) i, bundle);
                Intrinsics.m26843a(a, "WebDetailScreen.newInstance(clientLink, extras)");
                i = (BaseDetailScreen) a;
            }
            i.m29363b((Screen) this.f36700f);
            i.t_().putBoolean("com.reddit.arg.mark_read", false);
            i.t_().putBoolean("com.reddit.arg.immediate_view", false);
            if (link.getPromoted()) {
                AdVisibilityTracker adVisibilityTracker = this.f36700f.f40056x;
                if (adVisibilityTracker == null) {
                    Intrinsics.m26844a("adsVisibilityTracker");
                }
                i.m39121a(adVisibilityTracker);
            }
            return (Screen) i;
        }

        public final int mo6955f() {
            return this.f36698d.size();
        }
    }

    private final PagerAdapter m40638P() {
        return (PagerAdapter) this.f40054B.mo5678b();
    }

    public static final LinkPagerScreen m40639a(String str, int i, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame) {
        return Companion.m22968a(str, i, listingType, linkSortType, sortTimeFrame);
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_pager;
    }

    public final int mo7143u() {
        return 2;
    }

    public LinkPagerScreen() {
        super();
        n();
        ModUtil.m23838e();
    }

    public final Integer mo4954w() {
        Screen O = m40637O();
        if (!(O instanceof ColorSource)) {
            O = null;
        }
        ColorSource colorSource = (ColorSource) O;
        return colorSource != null ? colorSource.mo4954w() : null;
    }

    public final void mo4951a(Integer num) {
        throw ((Throwable) new UnsupportedOperationException());
    }

    public final Integer mo4949M() {
        Screen O = m40637O();
        if (!(O instanceof ColorSource)) {
            O = null;
        }
        ColorSource colorSource = (ColorSource) O;
        return colorSource != null ? colorSource.mo4949M() : null;
    }

    public final void mo4953b(Integer num) {
        throw ((Throwable) new UnsupportedOperationException());
    }

    private final Screen m40637O() {
        PagerAdapter P = m40638P();
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        return P.m35102d(screenPager.getCurrentItem());
    }

    protected final void mo7142t() {
        Parameters standardParameters;
        super.mo7142t();
        Builder a = DaggerLinkPagerComponent.m29175a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a = a.mo4678a(k).mo4680a((View) this).mo4681a(kotlin.LazyKt.m26777a(new LinkPagerScreen$onInitialize$1(this)));
        LinkSortType linkSortType = this.sort;
        if (linkSortType == null) {
            Intrinsics.m26844a("sort");
        }
        LinkSortType linkSortType2;
        if (linkSortType instanceof SortType) {
            String str = this.selectedLinkId;
            if (str == null) {
                Intrinsics.m26844a("selectedLinkId");
            }
            int i = this.linkPosition;
            ListingType listingType = this.listingType;
            if (listingType == null) {
                Intrinsics.m26844a("listingType");
            }
            linkSortType2 = this.sort;
            if (linkSortType2 == null) {
                Intrinsics.m26844a("sort");
            }
            if (linkSortType2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.data.feature.common.SortType");
            }
            standardParameters = new StandardParameters(str, i, listingType, (SortType) linkSortType2, this.sortTimeFrame);
        } else if (linkSortType instanceof HistorySortType) {
            String str2 = this.selectedLinkId;
            if (str2 == null) {
                Intrinsics.m26844a("selectedLinkId");
            }
            int i2 = this.linkPosition;
            ListingType listingType2 = this.listingType;
            if (listingType2 == null) {
                Intrinsics.m26844a("listingType");
            }
            Object b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            Object username = b.c().getUsername();
            Intrinsics.m26843a(username, "SessionManager.getInstan…().activeSession.username");
            linkSortType2 = this.sort;
            if (linkSortType2 == null) {
                Intrinsics.m26844a("sort");
            }
            if (linkSortType2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.history.HistorySortType");
            }
            standardParameters = new HistoryParameters(str2, i2, listingType2, username, (HistorySortType) linkSortType2);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Unsupported LinkSortType ");
            linkSortType2 = this.sort;
            if (linkSortType2 == null) {
                Intrinsics.m26844a("sort");
            }
            stringBuilder.append(linkSortType2);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
        a.mo4679a(standardParameters).mo4682a().mo4683a(this);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        layoutInflater = super.mo7139a(layoutInflater, viewGroup);
        if (layoutInflater == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ScreenPager");
        }
        ScreenPager screenPager = (ScreenPager) layoutInflater;
        screenPager.addOnPageChangeListener((OnPageChangeListener) new LinkPagerScreen$onCreateView$$inlined$apply$lambda$1(screenPager, this));
        screenPager.setAdapter(m40638P());
        screenPager.setEnabled(null);
        this.f40057z = screenPager;
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void m40649a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        PagerAdapter P = m40638P();
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        Screen d = P.m35102d(screenPager.getCurrentItem());
        if (d != null) {
            d.a(menu, menuInflater);
        }
    }

    public final void m40648a(Menu menu) {
        Intrinsics.m26847b(menu, "menu");
        super.a(menu);
        PagerAdapter P = m40638P();
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        Screen d = P.m35102d(screenPager.getCurrentItem());
        if (d != null) {
            d.a(menu);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        PagerAdapter P = m40638P();
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        Screen d = P.m35102d(screenPager.getCurrentItem());
        if (d != null) {
            return d.mo7201a(menuItem);
        }
        return super.mo7201a(menuItem);
    }

    public final boolean mo6986J() {
        PagerAdapter P = m40638P();
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        Screen d = P.m35102d(screenPager.getCurrentItem());
        return d != null ? d.mo6986J() : false;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        m40638P().m35104g();
        ay();
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40055w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
        view = this.f40056x;
        if (view == null) {
            Intrinsics.m26844a("adsVisibilityTracker");
        }
        view.m23449a();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40055w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
        view = this.f40056x;
        if (view == null) {
            Intrinsics.m26844a("adsVisibilityTracker");
        }
        view.m23452b();
    }

    public final void mo7361a(List<Link> list) {
        Intrinsics.m26847b(list, "listing");
        PagerAdapter P = m40638P();
        Intrinsics.m26847b(list, "<set-?>");
        P.f36698d = list;
    }

    public final void mo7359a() {
        m37532c((int) C1761R.string.error_network_error);
    }

    public final void mo7362b() {
        m37532c((int) C1761R.string.error_network_error);
    }

    public final void mo7363c() {
        m40638P().d();
    }

    public final void mo7360a(int i) {
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        screenPager.setCurrentItem(i, false);
        screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        screenPager.post(new LinkPagerScreen$setCurrentPosition$1(this, i));
    }

    public final void mo7364d() {
        ScreenPager screenPager = this.f40057z;
        if (screenPager == null) {
            Intrinsics.m26844a("screenPager");
        }
        screenPager.setEnabled(true);
    }

    public final void mo7146x() {
        ai_();
    }

    public final void mo7147y() {
        ai_();
    }

    public final void q_() {
        ai_();
    }

    public final void mo4950a(OnColorChangedCallback onColorChangedCallback) {
        Intrinsics.m26847b(onColorChangedCallback, "callback");
        this.f40053A.add(onColorChangedCallback);
    }

    public final void mo4952b(OnColorChangedCallback onColorChangedCallback) {
        Intrinsics.m26847b(onColorChangedCallback, "callback");
        this.f40053A.remove(onColorChangedCallback);
    }

    public final void mo4943c(Integer num) {
        for (OnColorChangedCallback c : this.f40053A) {
            c.mo4943c(num);
        }
    }

    public final void mo4944d(Integer num) {
        for (OnColorChangedCallback d : this.f40053A) {
            d.mo4944d(num);
        }
    }

    public final /* synthetic */ Screen mo7220H() {
        Screen H = super.mo7220H();
        if (H != null) {
            return (BaseLinkListingScreen) H;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.BaseLinkListingScreen");
    }

    public static final /* synthetic */ void m40640a(LinkPagerScreen linkPagerScreen, int i) {
        i = linkPagerScreen.m40638P().m35102d(i);
        if (!(i instanceof BaseDetailScreen)) {
            i = 0;
        }
        BaseDetailScreen baseDetailScreen = (BaseDetailScreen) i;
        if (baseDetailScreen != null) {
            baseDetailScreen.mo4952b((OnColorChangedCallback) linkPagerScreen);
            baseDetailScreen.mo7690f((boolean) null);
        }
    }

    public static final /* synthetic */ void m40641b(LinkPagerScreen linkPagerScreen, int i) {
        Screen d = linkPagerScreen.m40638P().m35102d(i);
        Activity activity = null;
        if (!(d instanceof BaseDetailScreen)) {
            d = null;
        }
        BaseDetailScreen baseDetailScreen = (BaseDetailScreen) d;
        if (baseDetailScreen != null) {
            HasToolbar hasToolbar = !(baseDetailScreen instanceof HasToolbar) ? null : baseDetailScreen;
            if (hasToolbar != null) {
                Toolbar b = hasToolbar.mo7208b();
                if (b != null) {
                    Activity am_ = linkPagerScreen.am_();
                    if (am_ instanceof BaseActivity) {
                        activity = am_;
                    }
                    BaseActivity baseActivity = (BaseActivity) activity;
                    if (baseActivity != null) {
                        baseActivity.a(b);
                        ActionBar b2 = baseActivity.b();
                        if (b2 != null) {
                            b2.c(false);
                            b2.b(true);
                            b2.a(ResourcesUtil.m22736g((Context) baseActivity, (int) C1761R.drawable.ic_icon_close));
                        }
                        baseActivity.invalidateOptionsMenu();
                    }
                    b.setNavigationOnClickListener(new LinkPagerScreen$pageSelected$$inlined$let$lambda$1(linkPagerScreen));
                }
            }
            for (OnColorChangedCallback onColorChangedCallback : linkPagerScreen.f40053A) {
                onColorChangedCallback.mo4943c(linkPagerScreen.mo4954w());
                onColorChangedCallback.mo4944d(linkPagerScreen.mo4949M());
            }
            baseDetailScreen.mo4950a((OnColorChangedCallback) linkPagerScreen);
            baseDetailScreen.mo7690f(true);
            baseDetailScreen.m39096R();
            linkPagerScreen = linkPagerScreen.f40055w;
            if (linkPagerScreen == null) {
                Intrinsics.m26844a("presenter");
            }
            linkPagerScreen.m34740a(i);
        }
    }
}
