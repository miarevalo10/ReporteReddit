package com.reddit.frontpage.presentation.communities;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.communities.CommunitiesContract.Presenter;
import com.reddit.frontpage.presentation.communities.CommunitiesContract.View;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemFavoritablePresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemNonFavoritablePresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemSectionPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.communities.model.LargeSubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.MediumSubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.SmallSubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.SubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager;
import com.reddit.frontpage.util.Util;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003#\u0019)\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0004XYZ[B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\u0018\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u000205H\u0016J\b\u00108\u001a\u000205H\u0002J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002J\b\u0010<\u001a\u000205H\u0002J\b\u0010=\u001a\u000205H\u0002J\u001e\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020,0BH\u0016J.\u0010C\u001a\u0002052\u0006\u0010?\u001a\u00020@2\u0006\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020,0BH\u0016J.\u0010G\u001a\u0002052\u0006\u0010?\u001a\u00020@2\u0006\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020,0BH\u0016J\u0010\u0010H\u001a\u0002052\u0006\u0010I\u001a\u00020\u001dH\u0016J\u0010\u0010J\u001a\u0002052\u0006\u0010I\u001a\u00020\u001dH\u0016J\u0010\u0010K\u001a\u0002052\u0006\u0010I\u001a\u00020\u001dH\u0016J\u0012\u0010L\u001a\u0004\u0018\u000101*\u0006\u0012\u0002\b\u00030MH\u0002J\f\u0010L\u001a\u000201*\u00020\u001dH\u0002J\u0018\u0010N\u001a\b\u0012\u0004\u0012\u0002010O*\b\u0012\u0004\u0012\u00020\u001d0OH\u0002J\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001d0O*\b\u0012\u0004\u0012\u00020\u001d0OH\u0002Jf\u0010Q\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d R*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010O0O R*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d R*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010O0O\u0018\u00010:0:*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0O0:2\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020WH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010 R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0004¢\u0006\u0004\n\u0002\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u0014\u0010+\u001a\u00020,8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/communities/CommunitiesNavigator;", "repository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "carouselActions", "Lcom/reddit/frontpage/presentation/carousel/CarouselActions;", "listingNavigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesContract$View;Lcom/reddit/frontpage/presentation/communities/CommunitiesNavigator;Lcom/reddit/frontpage/domain/repository/SubredditRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/carousel/CarouselActions;Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;)V", "attached", "", "discoveryUnitDelegate", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "getDiscoveryUnitDelegate", "()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "discoveryUnitDelegate$delegate", "Lkotlin/Lazy;", "discoveryUnitListingView", "com/reddit/frontpage/presentation/communities/CommunitiesPresenter$discoveryUnitListingView$1", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$discoveryUnitListingView$1;", "favoriteSection", "Lcom/reddit/frontpage/presentation/communities/Section;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "followingSection", "isDefaultUser", "()Z", "isFastScrollEnabled", "models", "com/reddit/frontpage/presentation/communities/CommunitiesPresenter$models$1", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$models$1;", "moderatedSection", "multiSection", "subscriptionSection", "topSection", "com/reddit/frontpage/presentation/communities/CommunitiesPresenter$topSection$1", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$topSection$1;", "username", "", "getUsername", "()Ljava/lang/String;", "areCommunitiesTheSame", "first", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "second", "areCommunityContentsTheSame", "attach", "", "destroy", "detach", "diffItemsOnView", "fetchDiscoveryUnits", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult;", "loadCommunities", "loadDefaultCommunities", "onCarouselImpression", "listablePosition", "", "idsSeen", "", "onCarouselItemDismissed", "carouselItemPosition", "model", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "onCarouselItemSelected", "onCommunityClicked", "item", "onFavoriteClicked", "onSectionClicked", "asItem", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "asItems", "", "sortCaseInsensitive", "toOrderedPresentationList", "kotlin.jvm.PlatformType", "Lcom/reddit/frontpage/domain/model/Subreddit;", "section", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationSection;", "type", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModelType;", "CommunityLoadResult", "Companion", "DiscoveryUnitLoadResult", "LinkedCommunityLoadResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
public final class CommunitiesPresenter extends DisposablePresenter implements Presenter {
    static final /* synthetic */ KProperty[] f33805a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CommunitiesPresenter.class), "discoveryUnitDelegate", "getDiscoveryUnitDelegate()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;"))};
    public static final Companion f33806d = new Companion();
    private static final CommunityPresentationModel f33807s;
    final CommunitiesPresenter$models$1 f33808b = new CommunitiesPresenter$models$1(this);
    final CommunitiesNavigator f33809c;
    private Section<CommunityPresentationModel> f33810e;
    private Section<CommunityPresentationModel> f33811f;
    private Section<CommunityPresentationModel> f33812g;
    private Section<CommunityPresentationModel> f33813h;
    private Section<CommunityPresentationModel> f33814i;
    private final Lazy f33815j = LazyKt.m26777a((Function0) new CommunitiesPresenter$discoveryUnitDelegate$2(this));
    private boolean f33816k;
    private final CommunitiesPresenter$topSection$1 f33817l = new CommunitiesPresenter$topSection$1();
    private final CommunitiesPresenter$discoveryUnitListingView$1 f33818m = new CommunitiesPresenter$discoveryUnitListingView$1(this);
    private final View f33819n;
    private final SubredditRepository f33820o;
    private final PostExecutionThread f33821p;
    private final CarouselActions f33822q;
    private final ListingNavigator f33823r;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;", "", "communities", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "collapsed", "", "(Ljava/util/List;Z)V", "getCollapsed", "()Z", "getCommunities", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesPresenter.kt */
    private static final class CommunityLoadResult {
        final List<CommunityPresentationModel> f20440a;
        final boolean f20441b;

        public CommunityLoadResult(List<CommunityPresentationModel> list, boolean z) {
            Intrinsics.m26847b(list, "communities");
            this.f20440a = list;
            this.f20441b = z;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$Companion;", "", "()V", "COMMUNITY_ALL", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getCOMMUNITY_ALL", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "DISCOVERY_SURFACE_NAME", "", "FAST_SCROLL_MINIMUM_ITEMS", "", "NUM_SECTIONS", "SCREEN_NAME", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult;", "", "()V", "None", "Result", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult$None;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult$Result;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesPresenter.kt */
    private static abstract class DiscoveryUnitLoadResult {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult$None;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesPresenter.kt */
        public static final class None extends DiscoveryUnitLoadResult {
            public static final None f28105a = new None();

            private None() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult$Result;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult;", "discoveryUnit", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "(Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;)V", "getDiscoveryUnit", "()Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: CommunitiesPresenter.kt */
        public static final class Result extends DiscoveryUnitLoadResult {
            final CarouselCollectionPresentationModel f28106a;

            public Result(CarouselCollectionPresentationModel carouselCollectionPresentationModel) {
                Intrinsics.m26847b(carouselCollectionPresentationModel, "discoveryUnit");
                super();
                this.f28106a = carouselCollectionPresentationModel;
            }
        }

        private DiscoveryUnitLoadResult() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$LinkedCommunityLoadResult;", "", "multi", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;", "favorites", "following", "subscriptions", "moderated", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;)V", "getFavorites", "()Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$CommunityLoadResult;", "getFollowing", "getModerated", "getMulti", "getSubscriptions", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitiesPresenter.kt */
    private static final class LinkedCommunityLoadResult {
        final CommunityLoadResult f20442a;
        final CommunityLoadResult f20443b;
        final CommunityLoadResult f20444c;
        final CommunityLoadResult f20445d;
        final CommunityLoadResult f20446e;

        public LinkedCommunityLoadResult(CommunityLoadResult communityLoadResult, CommunityLoadResult communityLoadResult2, CommunityLoadResult communityLoadResult3, CommunityLoadResult communityLoadResult4, CommunityLoadResult communityLoadResult5) {
            Intrinsics.m26847b(communityLoadResult, "multi");
            Intrinsics.m26847b(communityLoadResult2, "favorites");
            Intrinsics.m26847b(communityLoadResult3, "following");
            Intrinsics.m26847b(communityLoadResult4, "subscriptions");
            Intrinsics.m26847b(communityLoadResult5, "moderated");
            this.f20442a = communityLoadResult;
            this.f20443b = communityLoadResult2;
            this.f20444c = communityLoadResult3;
            this.f20445d = communityLoadResult4;
            this.f20446e = communityLoadResult5;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20447a;

        static {
            int[] iArr = new int[CommunityPresentationModelType.values().length];
            f20447a = iArr;
            iArr[CommunityPresentationModelType.f20483a.ordinal()] = 1;
            f20447a[CommunityPresentationModelType.f20484b.ordinal()] = 2;
            f20447a[CommunityPresentationModelType.f20485c.ordinal()] = 3;
        }
    }

    private final DiscoveryUnitManager m34628c() {
        return (DiscoveryUnitManager) this.f33815j.mo5678b();
    }

    public static final /* synthetic */ Section m34626c(CommunitiesPresenter communitiesPresenter) {
        communitiesPresenter = communitiesPresenter.f33810e;
        if (communitiesPresenter == null) {
            Intrinsics.m26844a("multiSection");
        }
        return communitiesPresenter;
    }

    public static final /* synthetic */ Section m34630d(CommunitiesPresenter communitiesPresenter) {
        communitiesPresenter = communitiesPresenter.f33811f;
        if (communitiesPresenter == null) {
            Intrinsics.m26844a("favoriteSection");
        }
        return communitiesPresenter;
    }

    public static final /* synthetic */ Section m34633e(CommunitiesPresenter communitiesPresenter) {
        communitiesPresenter = communitiesPresenter.f33812g;
        if (communitiesPresenter == null) {
            Intrinsics.m26844a("followingSection");
        }
        return communitiesPresenter;
    }

    public static final /* synthetic */ Section m34636f(CommunitiesPresenter communitiesPresenter) {
        communitiesPresenter = communitiesPresenter.f33813h;
        if (communitiesPresenter == null) {
            Intrinsics.m26844a("subscriptionSection");
        }
        return communitiesPresenter;
    }

    public static final /* synthetic */ Section m34637g(CommunitiesPresenter communitiesPresenter) {
        communitiesPresenter = communitiesPresenter.f33814i;
        if (communitiesPresenter == null) {
            Intrinsics.m26844a("moderatedSection");
        }
        return communitiesPresenter;
    }

    @Inject
    public CommunitiesPresenter(View view, CommunitiesNavigator communitiesNavigator, SubredditRepository subredditRepository, PostExecutionThread postExecutionThread, CarouselActions carouselActions, ListingNavigator listingNavigator) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(communitiesNavigator, "navigator");
        Intrinsics.m26847b(subredditRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(carouselActions, "carouselActions");
        Intrinsics.m26847b(listingNavigator, "listingNavigator");
        this.f33819n = view;
        this.f33809c = communitiesNavigator;
        this.f33820o = subredditRepository;
        this.f33821p = postExecutionThread;
        this.f33822q = carouselActions;
        this.f33823r = listingNavigator;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attach() {
        /*
        r14 = this;
        r0 = 1;
        r14.f33816k = r0;
        r14.m34644a();
        r0 = r14.m34635e();
        if (r0 == 0) goto L_0x0043;
    L_0x000c:
        r0 = r14.f33820o;
        r0 = r0.m22503e();
        r1 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection.f20488b;
        r2 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType.f20485c;
        r0 = r14.m34615a(r0, r1, r2);
        r1 = com.reddit.frontpage.presentation.communities.CommunitiesPresenter$loadDefaultCommunities$1.f28112a;
        r1 = (io.reactivex.functions.Function) r1;
        r0 = r0.map(r1);
        r1 = "repository.getDefaultSub…ap { it.toMutableList() }";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r1 = r14.f33821p;
        r1 = (com.reddit.common.rx.Thread) r1;
        r0 = com.reddit.frontpage.util.kotlin.SinglesKt.m24094b(r0, r1);
        r1 = new com.reddit.frontpage.presentation.communities.CommunitiesPresenter$loadDefaultCommunities$2;
        r1.<init>(r14);
        r1 = (io.reactivex.functions.Consumer) r1;
        r0 = r0.subscribe(r1);
        r1 = "repository.getDefaultSub…ffItemsOnView()\n        }";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r14.handleDispose(r0);
        return;
    L_0x0043:
        r0 = r14.f33819n;
        r0 = r0.mo7332d();
        r1 = r14.m34628c();
        r1.m23417a();
        r1 = r14.m34628c();
        r2 = "communities";
        r1 = r1.m23414a(r2);
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.m41434e(r1);
        r1 = (io.reactivex.Single) r1;
        if (r1 == 0) goto L_0x006c;
    L_0x0062:
        r2 = com.reddit.frontpage.presentation.communities.CommunitiesPresenter$fetchDiscoveryUnits$1.f28108a;
        r2 = (io.reactivex.functions.Function) r2;
        r1 = r1.map(r2);
        if (r1 != 0) goto L_0x0083;
    L_0x006c:
        r1 = com.reddit.frontpage.presentation.communities.CommunitiesPresenter.DiscoveryUnitLoadResult.None.f28105a;
        if (r1 != 0) goto L_0x0078;
    L_0x0070:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.CommunitiesPresenter.DiscoveryUnitLoadResult";
        r0.<init>(r1);
        throw r0;
    L_0x0078:
        r1 = (com.reddit.frontpage.presentation.communities.CommunitiesPresenter.DiscoveryUnitLoadResult) r1;
        r1 = io.reactivex.Single.just(r1);
        r2 = "Single.just(DiscoveryUni… DiscoveryUnitLoadResult)";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r2);
    L_0x0083:
        r2 = r14.f33820o;
        r3 = r14.m34631d();
        r2 = r2.m22498b(r3);
        r3 = new com.reddit.frontpage.presentation.communities.CommunitiesPresenter$loadCommunities$multis$1;
        r3.<init>(r14);
        r3 = (io.reactivex.functions.Function) r3;
        r2 = r2.map(r3);
        r3 = r14.f33820o;
        r4 = r14.m34631d();
        r3 = r3.m22505f(r4);
        r4 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection.f20490d;
        r3 = r14.m34615a(r3, r4, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType.f20484b);
        r4 = r14.f33820o;
        r5 = r14.m34631d();
        r4 = r4.m22504e(r5);
        r5 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection.f20491e;
        r4 = r14.m34615a(r4, r5, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType.f20484b);
        r5 = r14.f33820o;
        r6 = r14.m34631d();
        r5 = r5.m22500c(r6);
        r6 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection.f20492f;
        r5 = r14.m34615a(r5, r6, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType.f20484b);
        r6 = r14.f33820o;
        r7 = r14.m34631d();
        r6 = r6.m22502d(r7);
        r7 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection.f20493g;
        r8 = com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType.f20485c;
        r6 = r14.m34615a(r6, r7, r8);
        r7 = new com.reddit.frontpage.presentation.communities.CommunitiesPresenter$loadCommunities$combiner$1;
        r7.<init>(r0);
        r13 = r7;
        r13 = (io.reactivex.functions.Function5) r13;
        r8 = r2;
        r8 = (io.reactivex.SingleSource) r8;
        r9 = r3;
        r9 = (io.reactivex.SingleSource) r9;
        r10 = r4;
        r10 = (io.reactivex.SingleSource) r10;
        r11 = r5;
        r11 = (io.reactivex.SingleSource) r11;
        r12 = r6;
        r12 = (io.reactivex.SingleSource) r12;
        r0 = io.reactivex.Single.zip(r8, r9, r10, r11, r12, r13);
        r2 = "Single.zip(multis,\n     …ed,\n            combiner)";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r1 = (io.reactivex.SingleSource) r1;
        r0 = io.reactivex.rxkotlin.SinglesKt.m26767a(r0, r1);
        r1 = r14.f33821p;
        r1 = (com.reddit.common.rx.Thread) r1;
        r0 = com.reddit.frontpage.util.kotlin.SinglesKt.m24094b(r0, r1);
        r1 = new com.reddit.frontpage.presentation.communities.CommunitiesPresenter$loadCommunities$1;
        r1.<init>(r14);
        r1 = (io.reactivex.functions.Consumer) r1;
        r0 = r0.subscribe(r1);
        r1 = "Single.zip(multis,\n     …emsOnView()\n            }";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r14.handleDispose(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.communities.CommunitiesPresenter.attach():void");
    }

    public final void detach() {
        super.detach();
        this.f33816k = false;
    }

    public final void destroy() {
        m34628c().f21278a.m32077c();
    }

    final void m34644a() {
        int i;
        this.f33819n.mo7326a(CollectionsKt___CollectionsKt.m41449n(this.f33808b));
        Collection arrayList = new ArrayList();
        for (Object next : this.f33819n.mo7332d()) {
            if (next instanceof CommunityListItemPresentationModel) {
                arrayList.add(next);
            }
        }
        Iterable<CommunityListItemPresentationModel> iterable = (List) arrayList;
        Object next2 = null;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (CommunityListItemPresentationModel a : iterable) {
                if (Intrinsics.m26845a(a.mo7150a().f20471c, CommunityPresentationSection.f20492f)) {
                    i++;
                }
            }
        }
        if (i >= 20) {
            next2 = 1;
        }
        if (next2 != null) {
            this.f33819n.mo7331c();
        } else {
            this.f33819n.mo7327b();
        }
    }

    public static boolean m34625b(CommunityListItem communityListItem, CommunityListItem communityListItem2) {
        Intrinsics.m26847b(communityListItem, "first");
        Intrinsics.m26847b(communityListItem2, "second");
        if ((communityListItem instanceof CommunityListItemSectionPresentationModel) && (communityListItem2 instanceof CommunityListItemSectionPresentationModel)) {
            return Intrinsics.m26845a(((CommunityListItemSectionPresentationModel) communityListItem).f39080c.f20472d, ((CommunityListItemSectionPresentationModel) communityListItem2).f39080c.f20472d);
        }
        if ((communityListItem instanceof CommunityListItemFavoritablePresentationModel) && (communityListItem2 instanceof CommunityListItemFavoritablePresentationModel)) {
            return Intrinsics.m26845a(((CommunityListItemFavoritablePresentationModel) communityListItem).f39076c.f20476h, ((CommunityListItemFavoritablePresentationModel) communityListItem2).f39076c.f20476h);
        }
        return ((communityListItem instanceof SubredditDiscoveryUnitItemPresentationModel) && (communityListItem2 instanceof SubredditDiscoveryUnitItemPresentationModel)) ? Intrinsics.m26845a(((SubredditDiscoveryUnitItemPresentationModel) communityListItem).mo7151a().f36357e, ((SubredditDiscoveryUnitItemPresentationModel) communityListItem2).mo7151a().f36357e) : true;
    }

    public final void m34645a(int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set) {
        Intrinsics.m26847b(carouselItemPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        if (i >= 0) {
            if (i <= CollectionsKt__CollectionsKt.m26787a((List) this.f33808b)) {
                this.f33822q.mo4789a("communities", (List) this.f33808b, i, i2, carouselItemPresentationModel, (Set) set, this.f33823r, (Function0) new CommunitiesPresenter$onCarouselItemSelected$1(this, i));
            }
        }
    }

    public final void m34648b(int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set) {
        CarouselItemPresentationModel carouselItemPresentationModel2 = carouselItemPresentationModel;
        Intrinsics.m26847b(carouselItemPresentationModel2, "model");
        Set<String> set2 = set;
        Intrinsics.m26847b(set2, "idsSeen");
        int i3 = i;
        Object c = CollectionsKt___CollectionsKt.m41425c((List) this.f33808b, i3);
        if (!(c instanceof SubredditDiscoveryUnitItemPresentationModel)) {
            c = null;
        }
        SubredditDiscoveryUnitItemPresentationModel subredditDiscoveryUnitItemPresentationModel = (SubredditDiscoveryUnitItemPresentationModel) c;
        if (subredditDiscoveryUnitItemPresentationModel != null) {
            CarouselActions carouselActions = r0.f33822q;
            String str = "communities";
            CommunitiesPresenter$models$1 communitiesPresenter$models$1 = r0.f33808b;
            if (communitiesPresenter$models$1 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<com.reddit.datalibrary.frontpage.requests.models.v2.Listable>");
            }
            List b = TypeIntrinsics.m26872b(communitiesPresenter$models$1);
            View view = r0.f33819n;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.common.ListingView<com.reddit.datalibrary.frontpage.requests.models.v2.Listable>");
            }
            handleDispose(carouselActions.mo4788a(str, b, i3, i2, carouselItemPresentationModel2, set2, view, new CommunitiesPresenter$onCarouselItemDismissed$1(subredditDiscoveryUnitItemPresentationModel), new CommunitiesPresenter$onCarouselItemDismissed$2(r0, subredditDiscoveryUnitItemPresentationModel), new CommunitiesPresenter$onCarouselItemDismissed$3(r0), new CommunitiesPresenter$onCarouselItemDismissed$4(r0), false));
            m34644a();
        }
    }

    public final void m34646a(int i, Set<String> set) {
        Intrinsics.m26847b(set, "idsSeen");
        this.f33822q.mo4790a("communities", (List) this.f33808b, i, (Set) set, (Function0) new CommunitiesPresenter$onCarouselImpression$1(this, i));
    }

    private final String m34631d() {
        String r_ = this.f33819n.r_();
        return r_ == null ? "Reddit for Android" : r_;
    }

    private final boolean m34635e() {
        return Intrinsics.m26845a(m34631d(), (Object) "Reddit for Android");
    }

    private final Single<List<CommunityPresentationModel>> m34615a(Single<List<Subreddit>> single, CommunityPresentationSection communityPresentationSection, CommunityPresentationModelType communityPresentationModelType) {
        return single.map(new CommunitiesPresenter$toOrderedPresentationList$1(this, communityPresentationModelType, communityPresentationSection));
    }

    static {
        CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20485c;
        CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20487a;
        String f = Util.m24027f((int) C1761R.string.title_all);
        Integer valueOf = Integer.valueOf(C1761R.drawable.ic_icon_sort_top);
        Integer valueOf2 = Integer.valueOf(C1761R.color.rdt_orangered);
        com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
        f33807s = new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, f, null, null, null, null, valueOf, null, valueOf2, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(CommunityPresentationSection.f20487a.name(), new String[0]), false, 8944);
    }

    private static CommunityListItem m34627c(CommunityPresentationModel communityPresentationModel) {
        switch (WhenMappings.f20447a[communityPresentationModel.f20470b.ordinal()]) {
            case 1:
                return new CommunityListItemSectionPresentationModel(communityPresentationModel);
            case 2:
                return new CommunityListItemFavoritablePresentationModel(communityPresentationModel);
            case 3:
                return new CommunityListItemNonFavoritablePresentationModel(communityPresentationModel);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void m34647a(CommunityPresentationModel communityPresentationModel) {
        boolean z;
        CommunityPresentationModel communityPresentationModel2;
        CommunitiesPresenter communitiesPresenter = this;
        CommunityPresentationModel communityPresentationModel3 = communityPresentationModel;
        Intrinsics.m26847b(communityPresentationModel3, "item");
        Boolean bool = communityPresentationModel3.f20476h;
        if (bool == null) {
            Intrinsics.m26842a();
        }
        boolean booleanValue = bool.booleanValue() ^ 1;
        SubredditRepository subredditRepository = communitiesPresenter.f33820o;
        String str = communityPresentationModel3.f20469a;
        String str2 = communityPresentationModel3.f20473e;
        if (str2 == null) {
            Intrinsics.m26842a();
        }
        Object subscribe = subredditRepository.m22495a(str, str2, booleanValue).subscribe();
        Intrinsics.m26843a(subscribe, "repository\n            .…\n            .subscribe()");
        handleDispose(subscribe);
        Function1 communitiesPresenter$onFavoriteClicked$sameCommunityComparison$1 = new CommunitiesPresenter$onFavoriteClicked$sameCommunityComparison$1(communityPresentationModel3);
        if (booleanValue) {
            Section section = communitiesPresenter.f33811f;
            if (section == null) {
                Intrinsics.m26844a("favoriteSection");
            }
            CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20490d;
            Boolean valueOf = Boolean.valueOf(true);
            com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion companion = CommunityPresentationModel.f20468o;
            Function1 function1 = communitiesPresenter$onFavoriteClicked$sameCommunityComparison$1;
            z = booleanValue;
            section.mo4805a(CommunityPresentationModel.m22801a(communityPresentationModel3, null, null, communityPresentationSection, null, null, null, null, valueOf, null, null, null, false, com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion.m22800a(communityPresentationModel3.f20469a, String.valueOf(CommunityPresentationSection.f20490d.ordinal())), false, 12155), function1);
            communityPresentationModel2 = communityPresentationModel;
        } else {
            Function1 function12 = communitiesPresenter$onFavoriteClicked$sameCommunityComparison$1;
            z = booleanValue;
            Section section2 = communitiesPresenter.f33811f;
            if (section2 == null) {
                Intrinsics.m26844a("favoriteSection");
            }
            communityPresentationModel2 = communityPresentationModel;
            section2.mo4808b(communityPresentationModel2, function12);
        }
        communitiesPresenter.f33808b.m40553a((Function1) new CommunitiesPresenter$onFavoriteClicked$1(communityPresentationModel2, z));
        m34644a();
    }

    public static boolean m34619a(CommunityListItem communityListItem, CommunityListItem communityListItem2) {
        Intrinsics.m26847b(communityListItem, "first");
        Intrinsics.m26847b(communityListItem2, "second");
        return communityListItem.f33832b == communityListItem2.f33832b ? true : null;
    }

    public static final /* synthetic */ CommunityListItem m34613a(GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel) {
        switch (generalCarouselCollectionPresentationModel.getListableType()) {
            case 12:
                return new SmallSubredditDiscoveryUnitItemPresentationModel(generalCarouselCollectionPresentationModel);
            case 13:
                return new MediumSubredditDiscoveryUnitItemPresentationModel(generalCarouselCollectionPresentationModel);
            case 14:
                return new LargeSubredditDiscoveryUnitItemPresentationModel(generalCarouselCollectionPresentationModel);
            default:
                return null;
        }
    }

    public static final /* synthetic */ List m34623b(List list) {
        Iterable<CommunityPresentationModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (CommunityPresentationModel c : iterable) {
            arrayList.add(m34627c(c));
        }
        return (List) arrayList;
    }
}
