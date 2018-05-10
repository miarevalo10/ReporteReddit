package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase;
import com.reddit.frontpage.domain.usecase.DiffListingUseCaseParams;
import com.reddit.frontpage.domain.usecase.FrontpageLoadData;
import com.reddit.frontpage.domain.usecase.FrontpageLoadDataParams;
import com.reddit.frontpage.domain.usecase.FrontpageRefreshData;
import com.reddit.frontpage.domain.usecase.FrontpageRefreshDataParams;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase.LegacyListingSort;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase.ListingSortParams;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.carousel.RedditCarouselActions.SubscribeResult;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.options.CarouselOptionsContract.Presenter;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.listing.CarouselView;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.View;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.MaybesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.SinglesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b*\u00011\b\u0007\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0001\u0001B\u0001\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%¢\u0006\u0002\u0010&J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020GH\u0016J\b\u0010I\u001a\u00020GH\u0016JJ\u0010J\u001a\u00020G2\u0006\u0010?\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010K\u001a\u0002042\u0006\u0010L\u001a\u0002042\u0006\u0010M\u001a\u000204H\u0002J:\u0010N\u001a\u00020G2\u0006\u0010M\u001a\u0002042\u0006\u0010O\u001a\u00020P2\u0006\u0010K\u001a\u0002042\u0006\u0010?\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010L\u001a\u000204H\u0003J\b\u0010Q\u001a\u00020GH\u0002J\u001c\u0010R\u001a\u00020G2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002JT\u0010S\u001a\u00020G2\u0006\u0010?\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010T\u001a\u0002042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010L\u001a\u0002042\u000e\b\u0002\u0010U\u001a\b\u0012\u0004\u0012\u00020G0VH\u0002J\b\u0010W\u001a\u00020GH\u0016J\u0010\u0010X\u001a\u00020G2\u0006\u0010Y\u001a\u00020ZH\u0002J&\u0010[\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J\u001e\u0010a\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J.\u0010b\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010c\u001a\u0002082\u0006\u0010]\u001a\u00020d2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J.\u0010e\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010c\u001a\u0002082\u0006\u0010]\u001a\u00020d2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J.\u0010f\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010c\u001a\u0002082\u0006\u0010]\u001a\u00020d2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J.\u0010g\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010c\u001a\u0002082\u0006\u0010]\u001a\u00020d2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J&\u0010h\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010i\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J&\u0010j\u001a\u00020G2\u0006\u0010\\\u001a\u0002082\u0006\u0010i\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0016J\u0010\u0010k\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010m\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010n\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\b\u0010o\u001a\u00020GH\u0016J\u0010\u0010p\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010q\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\b\u0010r\u001a\u00020GH\u0016J\u0010\u0010s\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010t\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010u\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010v\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010w\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010x\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010y\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010z\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010{\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010|\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\b\u0010}\u001a\u00020GH\u0016J\u0010\u0010~\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0010\u0010\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0011\u0010\u0001\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u001b\u0010\u0001\u001a\u00020G2\u0006\u0010?\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0011\u0010\u0001\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0011\u0010\u0001\u001a\u00020G2\u0006\u0010l\u001a\u000208H\u0016J\u0013\u0010\u0001\u001a\u00020G2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020GH\u0002J\u001b\u0010\u0001\u001a\u00020G2\u0006\u0010?\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\t\u0010\u0001\u001a\u00020GH\u0016J\u0011\u0010\u0001\u001a\u00020G2\u0006\u0010K\u001a\u000204H\u0002J\t\u0010\u0001\u001a\u00020GH\u0016R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0010\u00100\u001a\u000201X\u0004¢\u0006\u0004\n\u0002\u00102R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020807X\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=0:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\bA\u0010BR\u001a\u0010C\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\bE\u0010BR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$Presenter;", "Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$View;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "listingNavigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "frontpageNavigator", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageNavigator;", "frontpageLoadData", "Lcom/reddit/frontpage/domain/usecase/FrontpageLoadData;", "frontpageRefreshData", "Lcom/reddit/frontpage/domain/usecase/FrontpageRefreshData;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "moderatorActions", "Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "adsActions", "Lcom/reddit/frontpage/presentation/listing/common/AdsActions;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "listingSortUseCase", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase;", "carouselActions", "Lcom/reddit/frontpage/presentation/carousel/CarouselActions;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "diffListingUseCase", "Lcom/reddit/frontpage/domain/usecase/DiffListingUseCase;", "parameters", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$Parameters;", "(Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$View;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageNavigator;Lcom/reddit/frontpage/domain/usecase/FrontpageLoadData;Lcom/reddit/frontpage/domain/usecase/FrontpageRefreshData;Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lcom/reddit/frontpage/presentation/listing/common/AdsActions;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase;Lcom/reddit/frontpage/presentation/carousel/CarouselActions;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/domain/usecase/DiffListingUseCase;Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$Parameters;)V", "adDistance", "", "after", "discoveryUnitDelegate", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "getDiscoveryUnitDelegate", "()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "discoveryUnitDelegate$delegate", "Lkotlin/Lazy;", "discoveryUnitListingView", "com/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$discoveryUnitListingView$1", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$discoveryUnitListingView$1;", "isLoadingMore", "", "isViewAttached", "linkPositions", "", "", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "previouslyAttached", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sort$annotations", "()V", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "sortTimeFrame$annotations", "attach", "", "destroy", "detach", "handleError", "isFirstLoad", "retryLocal", "wasRefreshing", "handleLinksLoadResult", "loadResult", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult$Success;", "handleRefreshPillVisibility", "handleViewShouldLoadMore", "loadListingAndSetOnView", "refresh", "onSuccess", "Lkotlin/Function0;", "loadMore", "notifyViewOfSubscribe", "result", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult;", "onCarouselClicked", "listablePosition", "model", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "idsSeen", "", "onCarouselImpression", "onCarouselItemDismissed", "carouselItemPosition", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "onCarouselItemHeaderSelected", "onCarouselItemSelected", "onCarouselItemSubscribed", "onCarouselShowMeLessSelected", "item", "onCarouselSubscribed", "onCommentsSelected", "presentationModelPosition", "onCommunitySelected", "onCrossPostSelected", "onExplorePopularSelected", "onHideSelected", "onLinkSelected", "onLoadErrorClicked", "onModerateApprove", "onModerateDistinguish", "onModerateLockComments", "onModerateMarkNsfw", "onModerateMarkSpoiler", "onModeratePinAnnouncement", "onModerateRemove", "onModerateRemoveAsSpam", "onModerateSelected", "onPreviewSelected", "onRefreshPillSelected", "onReportSelected", "onSaveSelected", "onShareSelected", "onSortSelected", "onSourceSelected", "onSubscribeSelected", "onViewModeSelected", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "refreshFrontpage", "saveSortOptions", "sendScrollAnalytics", "showLoadError", "updateListing", "Companion", "FrontpageLoadResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageListingPresenter.kt */
public final class FrontpageListingPresenter extends DisposablePresenter implements Presenter, FrontpageListingContract.Presenter {
    static final /* synthetic */ KProperty[] f36626a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(FrontpageListingPresenter.class), "discoveryUnitDelegate", "getDiscoveryUnitDelegate()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;"))};
    public static final Companion f36627g = new Companion();
    private final ListingSortUseCase f36628A;
    private final BackgroundThread f36629B;
    private final PostExecutionThread f36630C;
    private final DiffListingUseCase f36631D;
    private final Parameters f36632E;
    public final List<Listable> f36633b = new ArrayList();
    public final View f36634c;
    public final ListingNavigator f36635d;
    public final FrontpageSettings f36636e;
    public final CarouselActions f36637f;
    private final Lazy f36638h = LazyKt.m26777a(new FrontpageListingPresenter$discoveryUnitDelegate$2(this));
    private final List<Link> f36639i = new ArrayList();
    private final Map<String, Integer> f36640j = new LinkedHashMap();
    private SortType f36641k = SortType.a;
    private SortTimeFrame f36642l = SortTimeFrame.c;
    private String f36643m;
    private String f36644n;
    private boolean f36645o;
    private boolean f36646p;
    private boolean f36647q;
    private final FrontpageListingPresenter$discoveryUnitListingView$1 f36648r = new FrontpageListingPresenter$discoveryUnitListingView$1(this);
    private final SessionManager f36649s;
    private final FrontpageNavigator f36650t;
    private final FrontpageLoadData f36651u;
    private final FrontpageRefreshData f36652v;
    private final UserLinkActions f36653w;
    private final ModeratorLinkActions f36654x;
    private final AdsActions f36655y;
    private final PreferenceRepository f36656z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$Companion;", "", "()V", "EMPTY_LISTING_SIZE", "", "SCREEN_NAME", "", "SOURCE_PAGE", "SURFACE_NAME", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageListingPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult$Error;", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageListingPresenter.kt */
    private static abstract class FrontpageLoadResult {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult$Error;", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: FrontpageListingPresenter.kt */
        public static final class Error extends FrontpageLoadResult {
            public static final Error f28376a = new Error();

            private Error() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001b\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult$Success;", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult;", "links", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/ILink;", "models", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "adsList", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "(Lcom/reddit/datalibrary/frontpage/data/model/Listing;Ljava/util/List;Ljava/util/List;)V", "getAdsList", "()Ljava/util/List;", "getLinks", "()Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "getModels", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: FrontpageListingPresenter.kt */
        public static final class Success extends FrontpageLoadResult {
            final Listing<ILink> f28377a;
            final List<Listable> f28378b;
            final List<NativeAdInfo<?>> f28379c;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        Success success = (Success) obj;
                        if (Intrinsics.m26845a(this.f28377a, success.f28377a) && Intrinsics.m26845a(this.f28378b, success.f28378b) && Intrinsics.m26845a(this.f28379c, success.f28379c)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                Listing listing = this.f28377a;
                int i = 0;
                int hashCode = (listing != null ? listing.hashCode() : 0) * 31;
                List list = this.f28378b;
                hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                list = this.f28379c;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(links=");
                stringBuilder.append(this.f28377a);
                stringBuilder.append(", models=");
                stringBuilder.append(this.f28378b);
                stringBuilder.append(", adsList=");
                stringBuilder.append(this.f28379c);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public Success(Listing<? extends ILink> listing, List<? extends Listable> list, List<? extends NativeAdInfo<?>> list2) {
                Intrinsics.m26847b(listing, "links");
                Intrinsics.m26847b(list, "models");
                Intrinsics.m26847b(list2, "adsList");
                super();
                this.f28377a = listing;
                this.f28378b = list;
                this.f28379c = list2;
            }
        }

        private FrontpageLoadResult() {
        }
    }

    private final DiscoveryUnitManager m37051c() {
        return (DiscoveryUnitManager) this.f36638h.mo5678b();
    }

    public final void mo6952q(int i) {
    }

    @Inject
    public FrontpageListingPresenter(View view, SessionManager sessionManager, ListingNavigator listingNavigator, FrontpageNavigator frontpageNavigator, FrontpageLoadData frontpageLoadData, FrontpageRefreshData frontpageRefreshData, UserLinkActions userLinkActions, ModeratorLinkActions moderatorLinkActions, FrontpageSettings frontpageSettings, AdsActions adsActions, PreferenceRepository preferenceRepository, ListingSortUseCase listingSortUseCase, CarouselActions carouselActions, BackgroundThread backgroundThread, PostExecutionThread postExecutionThread, DiffListingUseCase diffListingUseCase, Parameters parameters) {
        FrontpageListingPresenter frontpageListingPresenter = this;
        View view2 = view;
        SessionManager sessionManager2 = sessionManager;
        ListingNavigator listingNavigator2 = listingNavigator;
        FrontpageNavigator frontpageNavigator2 = frontpageNavigator;
        FrontpageLoadData frontpageLoadData2 = frontpageLoadData;
        FrontpageRefreshData frontpageRefreshData2 = frontpageRefreshData;
        UserLinkActions userLinkActions2 = userLinkActions;
        ModeratorLinkActions moderatorLinkActions2 = moderatorLinkActions;
        FrontpageSettings frontpageSettings2 = frontpageSettings;
        AdsActions adsActions2 = adsActions;
        PreferenceRepository preferenceRepository2 = preferenceRepository;
        ListingSortUseCase listingSortUseCase2 = listingSortUseCase;
        CarouselActions carouselActions2 = carouselActions;
        BackgroundThread backgroundThread2 = backgroundThread;
        PostExecutionThread postExecutionThread2 = postExecutionThread;
        DiffListingUseCase diffListingUseCase2 = diffListingUseCase;
        Intrinsics.m26847b(view2, "view");
        Intrinsics.m26847b(sessionManager2, "sessionManager");
        Intrinsics.m26847b(listingNavigator2, "listingNavigator");
        Intrinsics.m26847b(frontpageNavigator2, "frontpageNavigator");
        Intrinsics.m26847b(frontpageLoadData2, "frontpageLoadData");
        Intrinsics.m26847b(frontpageRefreshData2, "frontpageRefreshData");
        Intrinsics.m26847b(userLinkActions2, "linkActions");
        Intrinsics.m26847b(moderatorLinkActions2, "moderatorActions");
        Intrinsics.m26847b(frontpageSettings2, "frontpageSettings");
        Intrinsics.m26847b(adsActions2, "adsActions");
        Intrinsics.m26847b(preferenceRepository2, "preferenceRepository");
        Intrinsics.m26847b(listingSortUseCase2, "listingSortUseCase");
        Intrinsics.m26847b(carouselActions2, "carouselActions");
        Intrinsics.m26847b(backgroundThread2, "backgroundThread");
        Intrinsics.m26847b(postExecutionThread2, "postExecutionThread");
        Intrinsics.m26847b(diffListingUseCase, "diffListingUseCase");
        Intrinsics.m26847b(parameters, "parameters");
        DiffListingUseCase diffListingUseCase3 = diffListingUseCase;
        this.f36634c = view2;
        this.f36649s = sessionManager2;
        this.f36635d = listingNavigator2;
        this.f36650t = frontpageNavigator2;
        this.f36651u = frontpageLoadData2;
        this.f36652v = frontpageRefreshData2;
        this.f36653w = userLinkActions2;
        this.f36654x = moderatorLinkActions2;
        this.f36636e = frontpageSettings2;
        this.f36655y = adsActions2;
        this.f36656z = preferenceRepository2;
        this.f36628A = listingSortUseCase2;
        this.f36637f = carouselActions2;
        this.f36629B = backgroundThread2;
        this.f36630C = postExecutionThread;
        this.f36631D = diffListingUseCase3;
        this.f36632E = parameters;
    }

    public final void attach() {
        this.f36647q = true;
        Object subscribe = ObservablesKt.m24092b(ObservablesKt.m24090a(this.f36632E.f20595a, (Thread) this.f36629B), this.f36630C).subscribe((Consumer) new FrontpageListingPresenter$attach$1(this));
        Intrinsics.m26843a(subscribe, "parameters.sortObservabl…rameOption)\n            }");
        handleDispose(subscribe);
        if (!this.f36645o || (this.f36639i.isEmpty() ^ 1) == 0) {
            this.f36645o = true;
            this.f36634c.mo7623T();
            ListingSortUseCase listingSortUseCase = this.f36628A;
            com.reddit.frontpage.domain.usecase.ListingSortUseCase.ListingSortParams.Companion companion = ListingSortParams.f20282c;
            LegacyListingSort legacyListingSort = (LegacyListingSort) listingSortUseCase.m22524b(com.reddit.frontpage.domain.usecase.ListingSortUseCase.ListingSortParams.Companion.m22517a(this.f36634c.D_(), this.f36641k, this.f36642l)).blockingGet();
            int i = legacyListingSort.f20280a;
            int i2 = legacyListingSort.f20281b;
            this.f36641k = SortingsLegacyMapper.a(i);
            this.f36642l = SortingsLegacyMapper.b(i2);
            this.f36634c.mo7632a(this.f36641k, this.f36642l);
            m37046a(this, this.f36641k, this.f36642l, true, null, null, false, null, 120);
            return;
        }
        if (this.f36636e.i("front_page")) {
            this.f36634c.mo7624U();
        } else {
            this.f36634c.mo7625V();
        }
        this.f36634c.mo7621R();
        Object subscribe2 = MaybesKt.m24088b(this.f36631D.m22526b(new DiffListingUseCaseParams(this.f36633b, ListingType.f20574a, this.f36641k, this.f36642l)), this.f36630C).subscribe((Consumer) new FrontpageListingPresenter$attach$2(this));
        Intrinsics.m26843a(subscribe2, "diffListingUseCase\n     …Distance)\n              }");
        handleDispose(subscribe2);
    }

    public final void detach() {
        super.detach();
        this.f36647q = false;
    }

    public final void destroy() {
        this.f36655y.mo4842a();
        m37051c().f21278a.m32077c();
    }

    public final void m37065a(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "mode");
        Object subscribe = CompletablesKt.m24073a(this.f36656z.m22470a("listingViewMode.frontpage", listingViewMode), this.f36629B).subscribe();
        Intrinsics.m26843a(subscribe, "preferenceRepository\n   …ead)\n        .subscribe()");
        handleDispose(subscribe);
        this.f36634c.mo7633a(listingViewMode);
    }

    public final void m37059a() {
        if (this.f36643m != null && !this.f36646p) {
            this.f36646p = true;
            m37046a(this, this.f36641k, this.f36642l, false, this.f36643m, this.f36644n, false, new FrontpageListingPresenter$loadMore$1(this), 32);
        }
    }

    public final void mo6485c(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4882a((LinkPresentationModel) i);
    }

    public final void mo6486d(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4885b((LinkPresentationModel) i, this.f36639i, this.f36640j);
    }

    public final void mo6483a(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4884a((LinkPresentationModel) i, this.f36640j, ListingType.f20574a, (LinkSortType) this.f36641k, this.f36642l);
    }

    public final void mo6484b(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4883a((LinkPresentationModel) i, this.f36639i, this.f36640j);
    }

    public final void mo6487e(int i) {
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) i;
        UserLinkActions userLinkActions = this.f36653w;
        List list = this.f36639i;
        Object obj = this.f36640j.get(linkPresentationModel.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        userLinkActions.mo4881a((Link) list.get(((Number) obj).intValue()), linkPresentationModel);
    }

    public final void mo6488f(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4886b((LinkPresentationModel) i, this.f36640j, ListingType.f20574a, (LinkSortType) this.f36641k, this.f36642l);
    }

    public final void mo6489g(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        i = this.f36633b.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4887c((LinkPresentationModel) i, this.f36639i, this.f36640j);
    }

    public final void mo6951p(int i) {
        UserLinkActions userLinkActions = this.f36653w;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4880a(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, new FrontpageListingPresenter$onHideSelected$1(this, i));
    }

    public final void mo6943h(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4871a(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6944i(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4872b(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6946k(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4874d(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6950o(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4878h(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6945j(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4873c(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6947l(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4875e(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6948m(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4876f(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo6949n(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36654x;
        Object obj = this.f36633b.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4877g(i, (LinkPresentationModel) obj, this.f36639i, this.f36640j, this.f36633b, this.f36634c);
    }

    public final void mo4989a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set) {
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        this.f36637f.mo4793a("frontpage", this.f36639i, this.f36633b, i, carouselCollectionPresentationModel, (Set) set, (ListingView) this.f36634c, (CarouselView) this.f36634c);
    }

    public final void m37061a(int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set) {
        Intrinsics.m26847b(carouselItemPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        handleDispose(this.f36637f.mo4788a("frontpage", this.f36633b, i, i2, carouselItemPresentationModel, set, this.f36634c, null, null, null, null, true));
    }

    public final void m37063a(int i, Set<String> set) {
        Intrinsics.m26847b(set, "idsSeen");
        this.f36637f.mo4790a("frontpage", this.f36633b, i, (Set) set, null);
    }

    static /* synthetic */ void m37046a(FrontpageListingPresenter frontpageListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame, boolean z, String str, String str2, boolean z2, Function0 function0, int i) {
        Pair a;
        FrontpageListingPresenter frontpageListingPresenter2 = frontpageListingPresenter;
        String str3 = (i & 8) != 0 ? null : str;
        String str4 = (i & 16) != 0 ? null : str2;
        int i2 = 0;
        boolean z3 = (i & 32) != 0 ? false : z2;
        Function0 function02 = (i & 64) != 0 ? FrontpageListingPresenter$loadListingAndSetOnView$1.f36621a : function0;
        Object t = frontpageListingPresenter2.f36636e.t();
        Intrinsics.m26843a(t, "frontpageSettings.appConfig");
        String a2 = t.a().a("frontpage");
        Object c = frontpageListingPresenter2.f36649s.c();
        Intrinsics.m26843a(c, "sessionManager.activeSession");
        AdContext adContext = new AdContext(c, "frontpage", a2, (byte) 0);
        boolean isEmpty = frontpageListingPresenter2.f36639i.isEmpty();
        if (isEmpty || z) {
            frontpageListingPresenter2.f36636e.j("front_page");
        }
        AdsActions adsActions = frontpageListingPresenter2.f36655y;
        if (!z) {
            i2 = frontpageListingPresenter2.f36639i.size();
        }
        int a3 = adsActions.mo4840a(i2);
        if (!z || z3) {
            a = frontpageListingPresenter2.f36651u.m29320a(new FrontpageLoadDataParams(sortType, sortTimeFrame, str3, str4, frontpageListingPresenter2.f36634c.mo7619P(), adContext, a3));
        } else {
            frontpageListingPresenter2.f36643m = null;
            frontpageListingPresenter2.f36644n = null;
            a = frontpageListingPresenter2.f36652v.m29321a(new FrontpageRefreshDataParams(sortType, sortTimeFrame, frontpageListingPresenter2.f36634c.mo7619P(), adContext, a3));
        }
        Single single = (Single) a.f25267a;
        Object onErrorReturn = ((Observable) a.f25268b).toList().onErrorReturn(FrontpageListingPresenter$loadListingAndSetOnView$2.f28383a);
        Intrinsics.m26843a(onErrorReturn, "ads.toList().onErrorReturn { emptyList() }");
        onErrorReturn = SinglesKt.m26767a(single, (SingleSource) onErrorReturn).map(FrontpageListingPresenter$loadListingAndSetOnView$3.f28384a).onErrorReturn(FrontpageListingPresenter$loadListingAndSetOnView$4.f28385a);
        Intrinsics.m26843a(onErrorReturn, "frontpage.zipWith(ads.to…ontpageLoadResult.Error }");
        onErrorReturn = com.reddit.frontpage.util.kotlin.SinglesKt.m24094b(onErrorReturn, frontpageListingPresenter2.f36630C).subscribe((Consumer) new FrontpageListingPresenter$loadListingAndSetOnView$5(frontpageListingPresenter2, sortType, sortTimeFrame, str3, str4, isEmpty, z3, z, function02));
        Intrinsics.m26843a(onErrorReturn, "frontpage.zipWith(ads.to…  }\n          }\n        }");
        frontpageListingPresenter2.handleDispose(onErrorReturn);
    }

    private final void m37049a(String str, String str2) {
        this.f36643m = str;
        this.f36644n = str2;
        if (str != null) {
            this.f36634c.mo7629Z();
        } else {
            this.f36634c.aa();
        }
    }

    public final void m37066b() {
        m37046a(this, this.f36641k, this.f36642l, true, null, null, false, new FrontpageListingPresenter$refreshFrontpage$1(this), 56);
    }

    public final void m37064a(SubscribeResult subscribeResult) {
        Disposable disposable = subscribeResult.f20337a;
        if (disposable != null) {
            handleDispose(disposable);
        }
        Integer a = subscribeResult.f20340d.mo4785a();
        if (a != null) {
            int intValue = a.intValue();
            View view = this.f36634c;
            String a2 = Util.m23960a(intValue, subscribeResult.f20339c);
            Intrinsics.m26843a((Object) a2, "Util.getString(it, result.subredditDisplayName)");
            view.mo7635a(a2);
        }
    }

    public static final /* synthetic */ void m37045a(FrontpageListingPresenter frontpageListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, boolean z2, boolean z3) {
        FrontpageListingPresenter frontpageListingPresenter2 = frontpageListingPresenter;
        if (z3 && !z2) {
            m37046a(frontpageListingPresenter2, sortType, sortTimeFrame, z3, str, str2, true, null, 64);
        } else if (z3 && !z) {
            frontpageListingPresenter2.f36634c.mo7628Y();
            frontpageListingPresenter2.f36634c.mo7632a(frontpageListingPresenter2.f36641k, frontpageListingPresenter2.f36642l);
            frontpageListingPresenter2.f36634c.mo7626W();
        } else if (z) {
            frontpageListingPresenter2.f36634c.mo7336y();
        } else {
            frontpageListingPresenter2.f36646p = false;
            frontpageListingPresenter2.f36634c.mo7620Q();
        }
    }

    public static final /* synthetic */ void m37048a(FrontpageListingPresenter frontpageListingPresenter, boolean z, Success success, boolean z2, SortType sortType, SortTimeFrame sortTimeFrame, boolean z3) {
        Listing listing = success.f28377a;
        List list = success.f28378b;
        List a = CollectionsKt___CollectionsKt.m41416a((Iterable) listing.getChildren(), Link.class);
        int size = frontpageListingPresenter.f36633b.size();
        frontpageListingPresenter.f36641k = sortType;
        frontpageListingPresenter.f36642l = sortTimeFrame;
        if (z) {
            frontpageListingPresenter.f36639i.clear();
            frontpageListingPresenter.f36633b.clear();
            frontpageListingPresenter.f36640j.clear();
        }
        frontpageListingPresenter.m37049a(listing.getAfter(), listing.getAdDistance());
        frontpageListingPresenter.f36633b.addAll(list);
        sortType = frontpageListingPresenter.f36639i.size();
        frontpageListingPresenter.f36639i.addAll(a);
        sortTimeFrame = frontpageListingPresenter.f36640j;
        Iterable<Link> iterable = a;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (Link uniqueId : iterable) {
            int i2 = i + 1;
            arrayList.add(TuplesKt.m26780a(uniqueId.getUniqueId(), Integer.valueOf(i + sortType)));
            i = i2;
        }
        MapsKt__MapsKt.m36122a((Map) sortTimeFrame, (Iterable) (List) arrayList);
        frontpageListingPresenter.m37051c().m23416a(frontpageListingPresenter.f36633b);
        success = frontpageListingPresenter.f36655y.mo4841a(success.f28379c, frontpageListingPresenter.f36633b);
        frontpageListingPresenter.f36634c.mo7330b((List) frontpageListingPresenter.f36633b);
        if (z) {
            if (frontpageListingPresenter.f36639i.isEmpty()) {
                frontpageListingPresenter.f36634c.mo7622S();
            } else {
                if (z2) {
                    frontpageListingPresenter.f36634c.mo7621R();
                } else {
                    frontpageListingPresenter.f36634c.mo7628Y();
                }
                frontpageListingPresenter.f36634c.mo7335x();
            }
            if (z3) {
                frontpageListingPresenter.f36634c.mo7626W();
            }
            return;
        }
        frontpageListingPresenter.f36634c.mo7323a(size, list.size());
        for (Number intValue : (Iterable) success) {
            frontpageListingPresenter.f36634c.mo7323a(intValue.intValue(), 1);
        }
    }

    public static final /* synthetic */ void m37044a(FrontpageListingPresenter frontpageListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame) {
        ListingSortUseCase listingSortUseCase = frontpageListingPresenter.f36628A;
        com.reddit.frontpage.domain.usecase.ListingSortUseCase.ListingSortParams.Companion companion = ListingSortParams.f20282c;
        Object subscribe = CompletablesKt.m24074b(listingSortUseCase.m22523a(com.reddit.frontpage.domain.usecase.ListingSortUseCase.ListingSortParams.Companion.m22517a(frontpageListingPresenter.f36634c.D_(), sortType, sortTimeFrame)), (Thread) frontpageListingPresenter.f36630C).subscribe();
        Intrinsics.m26843a(subscribe, "listingSortUseCase\n     …\n            .subscribe()");
        frontpageListingPresenter.handleDispose(subscribe);
    }
}
