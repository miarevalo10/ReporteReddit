package com.reddit.frontpage.presentation.communities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.CommunitiesComponent.Builder;
import com.reddit.frontpage.di.component.DaggerCommunitiesComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.RedditSearchView;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollThumbView;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollView;
import com.reddit.frontpage.presentation.communities.CommunitiesContract.View;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.communities.model.LargeSubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.SmallSubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.carousel.LargeCarouselViewHolder;
import com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.Nimbledroid.Scenario;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.DimensionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0007EFGHIJKB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0016\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u001aH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020$H\u0016J\u0018\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020$H\u0016J\u0018\u00105\u001a\u00020\u001a2\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020$H\u0016J\b\u00106\u001a\u00020\u001aH\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:H\u0014J\u0018\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010A\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:H\u0014J\b\u0010B\u001a\u00020'H\u0016J\u0016\u0010C\u001a\u00020\u001a2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006L"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$View;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesNavigator;", "()V", "adapter", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesAdapter;", "adapter$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "fastScrollWidthListener", "Landroid/view/View$OnLayoutChangeListener;", "presenter", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter;)V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "diffAndSetItems", "communities", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "disableFastScroll", "enableFastScroll", "getLayoutId", "", "getOldListItems", "hasNavigationDrawer", "", "navigateToAllCommunity", "navigateToMultiredditDetail", "multiredditName", "navigateToSubredditDetail", "subredditName", "notifyDiffResult", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "resetScreen", "setListing", "posts", "CommunitiesAdapter", "CommunitiesListItemViewHolder", "CommunitySectionViewHolder", "CommunityViewHolder", "Companion", "FavoritableCommunityViewHolder", "NonFavoritableCommunityViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
public final class CommunitiesScreen extends MvpBaseScreen implements View, CommunitiesNavigator {
    static final /* synthetic */ KProperty[] f40008v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CommunitiesScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesAdapter;"))};
    public static final Companion f40009x = new Companion();
    @State
    String username;
    @Inject
    public CommunitiesPresenter f40010w;
    private final InvalidatableLazy f40011y = LazyKt.m24085a((BaseScreen) this, (Function0) new CommunitiesScreen$adapter$2(this));
    private OnLayoutChangeListener f40012z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$Companion;", "", "()V", "SOURCE_PAGE", "", "newInstance", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "username", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CommunitiesScreen m22790a(String str) {
            CommunitiesScreen communitiesScreen = new CommunitiesScreen();
            communitiesScreen.username = str;
            return communitiesScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0005H\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\b¨\u0006%"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;)V", "value", "", "favoriteMargin", "getFavoriteMargin", "()I", "setFavoriteMargin", "(I)V", "listItems", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "getListItems", "()Ljava/util/List;", "setListItems", "(Ljava/util/List;)V", "screenWidth", "getScreenWidth", "createLargeSubredditListingCarouselViewHolder", "Lcom/reddit/frontpage/ui/carousel/LargeCarouselViewHolder;", "parent", "Landroid/view/ViewGroup;", "createMediumSubredditListingCarouselViewHolder", "Lcom/reddit/frontpage/ui/carousel/SmallCarouselViewHolder;", "createSmallSubredditListingCarouselViewHolder", "getItemCount", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "viewType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    private final class CommunitiesAdapter extends Adapter<ViewHolder> {
        List<? extends CommunityListItem> f28118a = CollectionsKt__CollectionsKt.m26790a();
        final /* synthetic */ CommunitiesScreen f28119b;
        private int f28120c;

        public CommunitiesAdapter(CommunitiesScreen communitiesScreen) {
            this.f28119b = communitiesScreen;
        }

        public final void m29471a(List<? extends CommunityListItem> list) {
            Intrinsics.m26847b(list, "<set-?>");
            this.f28118a = list;
        }

        public final void m29473c(int i) {
            if (i != this.f28120c) {
                this.f28120c = i;
                e();
            }
        }

        public final int m29472b(int i) {
            return ((CommunityListItem) this.f28118a.get(i)).f33831a;
        }

        public final int m29467a() {
            return this.f28118a.size();
        }

        public final long m29468a(int i) {
            return ((CommunityListItem) this.f28118a.get(i)).f33832b;
        }

        public final void m29470a(ViewHolder viewHolder, int i) {
            Intrinsics.m26847b(viewHolder, "holder");
            CommunityListItem communityListItem = (CommunityListItem) this.f28118a.get(i);
            int f = viewHolder.f();
            SmallCarouselViewHolder smallCarouselViewHolder;
            switch (f) {
                case 1:
                case 2:
                case 3:
                    CommunitiesListItemViewHolder communitiesListItemViewHolder = (CommunitiesListItemViewHolder) viewHolder;
                    if (communityListItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel");
                    }
                    communitiesListItemViewHolder.mo6452a(((CommunityListItemPresentationModel) communityListItem).mo7150a());
                    if ((viewHolder instanceof FavoritableCommunityViewHolder) == 0) {
                        viewHolder = null;
                    }
                    FavoritableCommunityViewHolder favoritableCommunityViewHolder = (FavoritableCommunityViewHolder) viewHolder;
                    if (favoritableCommunityViewHolder != null) {
                        i = this.f28120c;
                        viewHolder = favoritableCommunityViewHolder.f33826p;
                        viewHolder.setTranslationX(-((float) i));
                        viewHolder = viewHolder.getParent();
                        if (viewHolder == null) {
                            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                        }
                        android.view.View view = (android.view.View) viewHolder;
                        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), 0, view.getPaddingBottom());
                    }
                    return;
                case 4:
                    LargeCarouselViewHolder largeCarouselViewHolder = (LargeCarouselViewHolder) viewHolder;
                    if (communityListItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.model.LargeSubredditDiscoveryUnitItemPresentationModel");
                    }
                    largeCarouselViewHolder.m34914a(((LargeSubredditDiscoveryUnitItemPresentationModel) communityListItem).f39082c, new CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$1(this, viewHolder), null, new CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$2(this, viewHolder), (Function1) CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$3.f36430a, null);
                    return;
                case 5:
                    smallCarouselViewHolder = (SmallCarouselViewHolder) viewHolder;
                    if (communityListItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.model.SmallSubredditDiscoveryUnitItemPresentationModel");
                    }
                    smallCarouselViewHolder.m34914a(((SmallSubredditDiscoveryUnitItemPresentationModel) communityListItem).f39086c, new CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$4(this, viewHolder), null, new CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$5(this, viewHolder), (Function1) CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$6.f36435a, null);
                    return;
                case 6:
                    smallCarouselViewHolder = (SmallCarouselViewHolder) viewHolder;
                    if (communityListItem == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.model.SmallSubredditDiscoveryUnitItemPresentationModel");
                    }
                    smallCarouselViewHolder.m34914a(((SmallSubredditDiscoveryUnitItemPresentationModel) communityListItem).f39086c, new CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$7(this, viewHolder), null, new CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$8(this, viewHolder), (Function1) CommunitiesScreen$CommunitiesAdapter$onBindViewHolder$9.f36440a, null);
                    return;
                default:
                    i = new StringBuilder();
                    i.append(f);
                    i.append(" not supported");
                    throw ((Throwable) new IllegalArgumentException(i.toString()));
            }
        }

        public final ViewHolder m29469a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            switch (i) {
                case 1:
                    return (ViewHolder) new CommunitySectionViewHolder(this.f28119b, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_community_section, false));
                case 2:
                    return (ViewHolder) new FavoritableCommunityViewHolder(this.f28119b, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_community, false));
                case 3:
                    return (ViewHolder) new NonFavoritableCommunityViewHolder(this.f28119b, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_community, false));
                case 4:
                    i = LargeCarouselViewHolder.f37184b;
                    return com.reddit.frontpage.ui.carousel.LargeCarouselViewHolder.Companion.m23325a(viewGroup, m29466b(), new C2817x7b434738(this));
                case 5:
                    i = SmallCarouselViewHolder.f37244b;
                    return com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion.m23328a(viewGroup, m29466b(), false, new C2818x2d464220(this));
                case 6:
                    i = SmallCarouselViewHolder.f37244b;
                    return com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion.m23328a(viewGroup, m29466b(), false, new C2819x802f2b04(this));
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append(" not supported");
                    throw ((Throwable) new IllegalArgumentException(stringBuilder.toString()));
            }
        }

        private static int m29466b() {
            Object system = Resources.getSystem();
            Intrinsics.m26843a(system, "Resources.getSystem()");
            return system.getDisplayMetrics().widthPixels;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b¢\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesListItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;Landroid/view/View;)V", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getModel", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "setModel", "(Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;)V", "bind", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    private abstract class CommunitiesListItemViewHolder extends ViewHolder {
        protected CommunityPresentationModel f28121a;
        final /* synthetic */ CommunitiesScreen f28122b;

        public CommunitiesListItemViewHolder(CommunitiesScreen communitiesScreen, android.view.View view) {
            Intrinsics.m26847b(view, "view");
            this.f28122b = communitiesScreen;
            super(view);
            Object obj = this.c;
            Intrinsics.m26843a(obj, "itemView");
            obj.setOnClickListener(new C1810x63e53f27((Function1) new Function1<android.view.View, Unit>() {
                public final /* synthetic */ Object mo6492a(Object obj) {
                    obj = this.f28122b.m40578w();
                    Object v = this.m29475v();
                    Intrinsics.m26847b(v, "item");
                    String str = v.f20472d;
                    if (str == null) {
                        Intrinsics.m26842a();
                    }
                    com.reddit.frontpage.presentation.communities.CommunitiesPresenter.Companion companion = CommunitiesPresenter.f33806d;
                    if (Intrinsics.m26845a(v, CommunitiesPresenter.f33807s)) {
                        obj.f33809c.s_();
                    } else if (Intrinsics.m26845a(v.f20471c, CommunityPresentationSection.f20489c)) {
                        obj.f33809c.mo7329b(str);
                    } else {
                        obj.f33809c.mo7325a(str);
                    }
                    return Unit.f25273a;
                }
            }));
        }

        protected final CommunityPresentationModel m29475v() {
            CommunityPresentationModel communityPresentationModel = this.f28121a;
            if (communityPresentationModel == null) {
                Intrinsics.m26844a("model");
            }
            return communityPresentationModel;
        }

        public void mo6452a(CommunityPresentationModel communityPresentationModel) {
            Intrinsics.m26847b(communityPresentationModel, "model");
            this.f28121a = communityPresentationModel;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitySectionViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesListItemViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "view", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "bind", "", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    private final class CommunitySectionViewHolder extends CommunitiesListItemViewHolder {
        final /* synthetic */ CommunitiesScreen f33824p;
        private final TextView f33825q;

        public CommunitySectionViewHolder(CommunitiesScreen communitiesScreen, android.view.View view) {
            Intrinsics.m26847b(view, "view");
            this.f33824p = communitiesScreen;
            super(communitiesScreen, view);
            Object obj = this.c;
            Intrinsics.m26843a(obj, "itemView");
            obj.setOnClickListener(new C1811x1351d61(new Function1<android.view.View, Unit>() {
                public final /* synthetic */ Object mo6492a(Object obj) {
                    obj = this.f33824p.m40578w();
                    CommunityPresentationModel v = this.m29475v();
                    Intrinsics.m26847b(v, "item");
                    obj.f33808b.m40553a((Function1) new CommunitiesPresenter$onSectionClicked$1(v));
                    obj.m34644a();
                    return Unit.f25273a;
                }
            }));
            obj = (TextView) view.findViewById(C1761R.id.community_section_title);
            Intrinsics.m26843a(obj, "view.community_section_title");
            this.f33825q = obj;
        }

        public final void mo6452a(CommunityPresentationModel communityPresentationModel) {
            Intrinsics.m26847b(communityPresentationModel, "model");
            super.mo6452a(communityPresentationModel);
            this.f33825q.setText((CharSequence) communityPresentationModel.f20472d);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b¢\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunityViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunitiesListItemViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "communityView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;Landroid/view/View;)V", "getCommunityView", "()Landroid/view/View;", "favorite", "Landroid/widget/ImageView;", "getFavorite", "()Landroid/widget/ImageView;", "icon", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "name", "Landroid/widget/TextView;", "bind", "", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "bindIcon", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    private abstract class CommunityViewHolder extends CommunitiesListItemViewHolder {
        final ImageView f33826p;
        final /* synthetic */ CommunitiesScreen f33827q;
        private final ShapedIconView f33828r;
        private final TextView f33829s;
        private final android.view.View f33830t;

        public CommunityViewHolder(CommunitiesScreen communitiesScreen, android.view.View view) {
            Intrinsics.m26847b(view, "communityView");
            this.f33827q = communitiesScreen;
            super(communitiesScreen, view);
            this.f33830t = view;
            Object obj = (ShapedIconView) this.f33830t.findViewById(C1761R.id.community_icon);
            Intrinsics.m26843a(obj, "communityView.community_icon");
            this.f33828r = obj;
            obj = (TextView) this.f33830t.findViewById(C1761R.id.community_name);
            Intrinsics.m26843a(obj, "communityView.community_name");
            this.f33829s = obj;
            obj = (ImageView) this.f33830t.findViewById(C1761R.id.community_favorite);
            Intrinsics.m26843a(obj, "communityView.community_favorite");
            this.f33826p = obj;
        }

        public void mo6452a(CommunityPresentationModel communityPresentationModel) {
            Intrinsics.m26847b(communityPresentationModel, "model");
            super.mo6452a(communityPresentationModel);
            Util.m23983a(this.f33828r, communityPresentationModel.f20474f, communityPresentationModel.f20475g, null, communityPresentationModel.f20478j, communityPresentationModel.f20479k, communityPresentationModel.f20477i, communityPresentationModel.f20480l, AccountPrefsUtil.m23629a(Boolean.valueOf(communityPresentationModel.f20482n)));
            this.f33829s.setText(communityPresentationModel.f20472d);
            if (communityPresentationModel.f20476h != null) {
                ImageView imageView = this.f33826p;
                Context context = this.f33830t.getContext();
                Intrinsics.m26843a((Object) context, "communityView.context");
                imageView.setImageDrawable(ResourcesUtil.m22719a(context, (int) C1761R.drawable.ic_icon_favorite, (int) C1761R.attr.rdt_favorite_color_selector));
                this.f33826p.setActivated(communityPresentationModel.f20476h.booleanValue());
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$FavoritableCommunityViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunityViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "view", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;Landroid/view/View;)V", "bind", "", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "updateFavoriteMargin", "margin", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    private final class FavoritableCommunityViewHolder extends CommunityViewHolder {
        final /* synthetic */ CommunitiesScreen f36445r;

        public FavoritableCommunityViewHolder(CommunitiesScreen communitiesScreen, android.view.View view) {
            Intrinsics.m26847b(view, "view");
            this.f36445r = communitiesScreen;
            super(communitiesScreen, view);
        }

        public final void mo6452a(CommunityPresentationModel communityPresentationModel) {
            Intrinsics.m26847b(communityPresentationModel, "model");
            super.mo6452a(communityPresentationModel);
            this.f33826p.setOnClickListener((OnClickListener) new C1812xb4394f77(new CommunitiesScreen$FavoritableCommunityViewHolder$bind$1(this, communityPresentationModel)));
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$NonFavoritableCommunityViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$CommunityViewHolder;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;", "view", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen;Landroid/view/View;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesScreen.kt */
    private final class NonFavoritableCommunityViewHolder extends CommunityViewHolder {
        final /* synthetic */ CommunitiesScreen f36446r;

        public NonFavoritableCommunityViewHolder(CommunitiesScreen communitiesScreen, android.view.View view) {
            Intrinsics.m26847b(view, "view");
            this.f36446r = communitiesScreen;
            super(communitiesScreen, view);
            Object obj = (ImageView) view.findViewById(C1761R.id.community_favorite);
            Intrinsics.m26843a(obj, "view.community_favorite");
            ViewsKt.m24109d((android.view.View) obj);
        }
    }

    private final CommunitiesAdapter m40556O() {
        return (CommunitiesAdapter) this.f40011y.mo5678b();
    }

    public static final CommunitiesScreen m40559c(String str) {
        return Companion.m22790a(str);
    }

    protected final boolean af_() {
        return true;
    }

    public final int mo7141s() {
        return C1761R.layout.screen_communities;
    }

    public final void mo7336y() {
    }

    public CommunitiesScreen() {
        super();
        Builder a = DaggerCommunitiesComponent.m29101a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a.mo4640a(k).mo4642a((CommunitiesNavigator) this).mo4641a((View) this).mo4644a(kotlin.LazyKt.m26777a(new Function0<Activity>() {
            public final /* synthetic */ Object invoke() {
                Activity am_ = this.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                return am_;
            }
        })).mo4643a("communities").mo4645a().mo4646a(this);
    }

    public final CommunitiesPresenter m40578w() {
        CommunitiesPresenter communitiesPresenter = this.f40010w;
        if (communitiesPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return communitiesPresenter;
    }

    public final String r_() {
        return this.username;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40010w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40010w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        Intrinsics.m26843a(a, "view");
        RecyclerView recyclerView = (RecyclerView) a.findViewById(C1761R.id.communities_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(m40556O());
        recyclerView.addOnScrollListener(new CommunitiesScreen$onCreateView$$inlined$apply$lambda$1(recyclerView, this, a));
        FastScrollView fastScrollView = (FastScrollView) a.findViewById(C1761R.id.communities_fastscroll);
        Object obj = (RecyclerView) a.findViewById(C1761R.id.communities_list);
        Intrinsics.m26843a(obj, "view.communities_list");
        FastScrollView.m22776a(fastScrollView, obj, new CommunitiesScreen$onCreateView$$inlined$apply$lambda$2(this, a));
        fastScrollView.addOnLayoutChangeListener(new CommunitiesScreen$onCreateView$2$2(fastScrollView, DimensionsKt.m28408a(fastScrollView.getContext(), C1761R.dimen.recycler_fast_scroll_icon_size)));
        FastScrollThumbView fastScrollThumbView = (FastScrollThumbView) a.findViewById(C1761R.id.communities_fastscroll_thumb);
        obj = (FastScrollView) a.findViewById(C1761R.id.communities_fastscroll);
        Intrinsics.m26843a(obj, "view.communities_fastscroll");
        fastScrollThumbView.setupWithFastScrollView(obj);
        Object obj2 = this.K;
        Intrinsics.m26843a(obj2, "rootView");
        ((RedditSearchView) obj2.findViewById(C1761R.id.search_view)).m34598a(new CommunitiesScreen$onCreateView$3(this));
        return a;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        Object obj = (RecyclerView) view.findViewById(C1761R.id.communities_list);
        Intrinsics.m26843a(obj, "view.communities_list");
        obj.setAdapter(null);
        m40556O().m29471a(CollectionsKt__CollectionsKt.m26790a());
        ay();
    }

    public final void mo7326a(List<? extends CommunityListItem> list) {
        Intrinsics.m26847b(list, "communities");
        DiffResult a = DiffUtil.a(new CommunitiesScreen$diffAndSetItems$result$1(this, m40556O().f28118a, list));
        mo7330b((List) list);
        a.a(m40556O());
    }

    public final void mo7330b(List<? extends CommunityListItem> list) {
        Intrinsics.m26847b(list, "posts");
        m40556O().m29471a((List) list);
    }

    public final void mo7323a(int i, int i2) {
        m40556O().c(i, i2);
    }

    public final void mo7322a(int i) {
        m40556O().d(i, 1);
    }

    public final void mo7328b(int i) {
        m40556O().d(i);
    }

    public final void mo7335x() {
        m40556O().e();
    }

    public final List<CommunityListItem> mo7332d() {
        return m40556O().f28118a;
    }

    public final void mo7327b() {
        android.view.View T_ = T_();
        if (T_ != null) {
            FastScrollView fastScrollView = (FastScrollView) T_.findViewById(C1761R.id.communities_fastscroll);
            if (fastScrollView != null) {
                android.view.View view = fastScrollView;
                if ((view.getVisibility() == 8 ? 1 : null) == null) {
                    ViewsKt.m24109d(view);
                }
                OnLayoutChangeListener onLayoutChangeListener = this.f40012z;
                if (onLayoutChangeListener != null) {
                    fastScrollView.removeOnLayoutChangeListener(onLayoutChangeListener);
                }
                m40556O().m29473c(DimensionsKt.m28408a(view.getContext(), C1761R.dimen.half_pad));
            }
        }
    }

    public final void mo7331c() {
        android.view.View T_ = T_();
        if (T_ != null) {
            FastScrollView fastScrollView = (FastScrollView) T_.findViewById(C1761R.id.communities_fastscroll);
            if (fastScrollView != null) {
                android.view.View view = fastScrollView;
                if ((view.getVisibility() == 8 ? 1 : null) != null) {
                    ViewsKt.m24105b(view);
                }
                this.f40012z = new CommunitiesScreen$enableFastScroll$$inlined$apply$lambda$1(fastScrollView, this);
                fastScrollView.addOnLayoutChangeListener(this.f40012z);
            }
        }
    }

    public final void s_() {
        Routing.m22623a((Screen) this, Nav.m22563b());
    }

    public final void mo7325a(String str) {
        Intrinsics.m26847b(str, "subredditName");
        if (NetworkUtil.m23842b()) {
            Activity am_ = am_();
            if (Intrinsics.m26845a((Object) str, am_ != null ? am_.getString(C1761R.string.mod) : null)) {
                Routing.m22623a((Screen) this, Nav.m22575d(str));
                return;
            } else if (SubredditUtil.m23920a((CharSequence) str)) {
                str = SubredditUtil.m23921b(str);
                if (!Util.m24041k(str)) {
                    Routing.m22623a((Screen) this, Nav.m22594j(str));
                }
                return;
            } else {
                Scenario.f21765a.m23846a();
                Routing.m22623a((Screen) this, Nav.m22566b(SubredditUtil.m23912a(str)));
                return;
            }
        }
        Screens.m22628a((Screen) this, (int) C1761R.string.error_no_internet).a();
    }

    public final void mo7329b(String str) {
        Intrinsics.m26847b(str, "multiredditName");
        Routing.m22623a((Screen) this, Nav.m22582f(str));
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (Toolbar) obj.findViewById(C1761R.id.toolbar);
        Intrinsics.m26843a(obj, "rootView.toolbar");
        Activity am_ = am_();
        obj.setTitle(am_ != null ? am_.getString(C1761R.string.label_communities) : null);
        actionBar.b(false);
    }

    public final boolean mo7200K() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        RecyclerView recyclerView = (RecyclerView) obj.findViewById(C1761R.id.communities_list);
        if (recyclerView != null) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            } else if (!ListUtil.m23810a((LinearLayoutManager) layoutManager)) {
                recyclerView.smoothScrollToPosition(0);
            }
        }
        return false;
    }

    public final void mo7324a(ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        viewDiffResult.f20594a.a(m40556O());
    }
}
