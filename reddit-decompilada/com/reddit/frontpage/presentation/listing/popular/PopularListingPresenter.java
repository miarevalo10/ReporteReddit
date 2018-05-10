package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase;
import com.reddit.frontpage.domain.usecase.DiffListingUseCaseParams;
import com.reddit.frontpage.domain.usecase.PopularLoadData;
import com.reddit.frontpage.domain.usecase.PopularLoadDataParams;
import com.reddit.frontpage.domain.usecase.PopularRefreshData;
import com.reddit.frontpage.domain.usecase.PopularRefreshDataParams;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.Presenter;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.View;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.MaybesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.SinglesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0002`aBo\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000201H\u0016JJ\u00103\u001a\u0002012\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\"H\u0002J:\u00107\u001a\u0002012\u0006\u00106\u001a\u00020\"2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\"2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u00020\"H\u0003J\b\u0010:\u001a\u000201H\u0002J\u001c\u0010;\u001a\u0002012\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002JT\u0010<\u001a\u0002012\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010=\u001a\u00020\"2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u00105\u001a\u00020\"2\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u0002010?H\u0002J\b\u0010@\u001a\u000201H\u0016J\u0010\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010C\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010D\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010E\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010F\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\b\u0010G\u001a\u000201H\u0016J\u0010\u0010H\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010I\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010J\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010K\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010L\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010M\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010N\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010O\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010P\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010Q\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\b\u0010R\u001a\u000201H\u0016J\u0010\u0010S\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010T\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010U\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u001a\u0010V\u001a\u0002012\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010W\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010X\u001a\u0002012\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010Y\u001a\u0002012\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u000201H\u0002J\b\u0010]\u001a\u000201H\u0016J\u0010\u0010^\u001a\u0002012\u0006\u00104\u001a\u00020\"H\u0002J\b\u0010_\u001a\u000201H\u0016R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$View;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "popularLoadData", "Lcom/reddit/frontpage/domain/usecase/PopularLoadData;", "popularRefreshData", "Lcom/reddit/frontpage/domain/usecase/PopularRefreshData;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "moderatorActions", "Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "adsActions", "Lcom/reddit/frontpage/presentation/listing/common/AdsActions;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "diffListingUseCase", "Lcom/reddit/frontpage/domain/usecase/DiffListingUseCase;", "parameters", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$Parameters;", "(Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$View;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;Lcom/reddit/frontpage/domain/usecase/PopularLoadData;Lcom/reddit/frontpage/domain/usecase/PopularRefreshData;Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/listing/common/AdsActions;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/frontpage/domain/usecase/DiffListingUseCase;Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$Parameters;)V", "adDistance", "", "after", "isLoadingMore", "", "linkPositions", "", "", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "previouslyAttached", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "attach", "", "destroy", "handleError", "isFirstLoad", "retryLocal", "wasRefreshing", "handleLinksLoadResult", "loadResult", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult$Success;", "handleRefreshPillVisibility", "handleViewShouldLoadMore", "loadListingAndSetOnView", "refresh", "onSuccess", "Lkotlin/Function0;", "loadMore", "onCommentsSelected", "presentationModelPosition", "onCommunitySelected", "onCrossPostSelected", "onHideSelected", "onLinkSelected", "onLoadErrorClicked", "onModerateApprove", "onModerateDistinguish", "onModerateLockComments", "onModerateMarkNsfw", "onModerateMarkSpoiler", "onModeratePinAnnouncement", "onModerateRemove", "onModerateRemoveAsSpam", "onModerateSelected", "onPreviewSelected", "onRefreshPillSelected", "onReportSelected", "onSaveSelected", "onShareSelected", "onSortSelected", "onSourceSelected", "onSubscribeSelected", "onViewModeSelected", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "refreshPopular", "sendScrollAnalytics", "showLoadError", "updateListing", "Companion", "PopularLoadResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PopularListingPresenter.kt */
public final class PopularListingPresenter extends DisposablePresenter implements Presenter {
    public static final Companion f36710g = new Companion();
    public SortType f36711a = SortType.c;
    public SortTimeFrame f36712b = SortTimeFrame.c;
    public String f36713c;
    public String f36714d;
    public boolean f36715e;
    public final View f36716f;
    private final List<Link> f36717h = ((List) new ArrayList());
    private final List<Listable> f36718i = ((List) new ArrayList());
    private final Map<String, Integer> f36719j = ((Map) new LinkedHashMap());
    private boolean f36720k;
    private final SessionManager f36721l;
    private final PopularLoadData f36722m;
    private final PopularRefreshData f36723n;
    private final UserLinkActions f36724o;
    private final ModeratorLinkActions f36725p;
    private final PostExecutionThread f36726q;
    private final AdsActions f36727r;
    private final FrontpageSettings f36728s;
    private final PreferenceRepository f36729t;
    private final BackgroundThread f36730u;
    private final DiffListingUseCase f36731v;
    private final Parameters f36732w;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$Companion;", "", "()V", "EMPTY_LISTING_SIZE", "", "SCREEN_NAME", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PopularListingPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult$Error;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PopularListingPresenter.kt */
    private static abstract class PopularLoadResult {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult$Error;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: PopularListingPresenter.kt */
        public static final class Error extends PopularLoadResult {
            public static final Error f28436a = new Error();

            private Error() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001b\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult$Success;", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult;", "links", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "models", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "adsList", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "(Lcom/reddit/datalibrary/frontpage/data/model/Listing;Ljava/util/List;Ljava/util/List;)V", "getAdsList", "()Ljava/util/List;", "getLinks", "()Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "getModels", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: PopularListingPresenter.kt */
        public static final class Success extends PopularLoadResult {
            final Listing<Link> f28437a;
            final List<Listable> f28438b;
            final List<NativeAdInfo<?>> f28439c;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        Success success = (Success) obj;
                        if (Intrinsics.m26845a(this.f28437a, success.f28437a) && Intrinsics.m26845a(this.f28438b, success.f28438b) && Intrinsics.m26845a(this.f28439c, success.f28439c)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                Listing listing = this.f28437a;
                int i = 0;
                int hashCode = (listing != null ? listing.hashCode() : 0) * 31;
                List list = this.f28438b;
                hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                list = this.f28439c;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(links=");
                stringBuilder.append(this.f28437a);
                stringBuilder.append(", models=");
                stringBuilder.append(this.f28438b);
                stringBuilder.append(", adsList=");
                stringBuilder.append(this.f28439c);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public Success(Listing<Link> listing, List<? extends Listable> list, List<? extends NativeAdInfo<?>> list2) {
                Intrinsics.m26847b(listing, "links");
                Intrinsics.m26847b(list, "models");
                Intrinsics.m26847b(list2, "adsList");
                super();
                this.f28437a = listing;
                this.f28438b = list;
                this.f28439c = list2;
            }
        }

        private PopularLoadResult() {
        }
    }

    @Inject
    public PopularListingPresenter(View view, SessionManager sessionManager, PopularLoadData popularLoadData, PopularRefreshData popularRefreshData, UserLinkActions userLinkActions, ModeratorLinkActions moderatorLinkActions, PostExecutionThread postExecutionThread, AdsActions adsActions, FrontpageSettings frontpageSettings, PreferenceRepository preferenceRepository, BackgroundThread backgroundThread, DiffListingUseCase diffListingUseCase, Parameters parameters) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(popularLoadData, "popularLoadData");
        Intrinsics.m26847b(popularRefreshData, "popularRefreshData");
        Intrinsics.m26847b(userLinkActions, "linkActions");
        Intrinsics.m26847b(moderatorLinkActions, "moderatorActions");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(adsActions, "adsActions");
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(diffListingUseCase, "diffListingUseCase");
        Intrinsics.m26847b(parameters, "parameters");
        this.f36716f = view;
        this.f36721l = sessionManager;
        this.f36722m = popularLoadData;
        this.f36723n = popularRefreshData;
        this.f36724o = userLinkActions;
        this.f36725p = moderatorLinkActions;
        this.f36726q = postExecutionThread;
        this.f36727r = adsActions;
        this.f36728s = frontpageSettings;
        this.f36729t = preferenceRepository;
        this.f36730u = backgroundThread;
        this.f36731v = diffListingUseCase;
        this.f36732w = parameters;
    }

    public final void attach() {
        Object subscribe = ObservablesKt.m24092b(ObservablesKt.m24090a(this.f36732w.f20638a, (Thread) this.f36730u), this.f36726q).subscribe((Consumer) new PopularListingPresenter$attach$1(this));
        Intrinsics.m26843a(subscribe, "parameters.sortObservabl…rameOption)\n            }");
        handleDispose(subscribe);
        if (this.f36720k) {
            this.f36716f.mo7644Q();
            subscribe = MaybesKt.m24088b(this.f36731v.m22526b(new DiffListingUseCaseParams(this.f36718i, ListingType.f20575b, this.f36711a, this.f36712b)), this.f36726q).subscribe((Consumer) new PopularListingPresenter$attach$2(this));
            Intrinsics.m26843a(subscribe, "diffListingUseCase\n     …Distance)\n              }");
            handleDispose(subscribe);
            return;
        }
        this.f36720k = true;
        this.f36716f.mo7646S();
        m37158a(this, this.f36711a, this.f36712b, true, null, null, false, null, 120);
    }

    public final void destroy() {
        this.f36727r.mo4842a();
    }

    public final void m37169a(ListingViewMode listingViewMode) {
        Intrinsics.m26847b(listingViewMode, "mode");
        Object subscribe = CompletablesKt.m24073a(this.f36729t.m22470a("listingViewMode.popular", listingViewMode), this.f36730u).subscribe();
        Intrinsics.m26843a(subscribe, "preferenceRepository\n   …ead)\n        .subscribe()");
        handleDispose(subscribe);
        this.f36716f.mo7653a(listingViewMode);
    }

    public final void mo6485c(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4882a((LinkPresentationModel) i);
    }

    public final void mo6486d(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4885b((LinkPresentationModel) i, this.f36717h, this.f36719j);
    }

    public final void mo6483a(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4884a((LinkPresentationModel) i, this.f36719j, ListingType.f20575b, (LinkSortType) this.f36711a, this.f36712b);
    }

    public final void mo6484b(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4883a((LinkPresentationModel) i, this.f36717h, this.f36719j);
    }

    public final void mo6487e(int i) {
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) i;
        UserLinkActions userLinkActions = this.f36724o;
        List list = this.f36717h;
        Object obj = this.f36719j.get(linkPresentationModel.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        userLinkActions.mo4881a((Link) list.get(((Number) obj).intValue()), linkPresentationModel);
    }

    public final void mo6488f(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4886b((LinkPresentationModel) i, this.f36719j, ListingType.f20575b, (LinkSortType) this.f36711a, this.f36712b);
    }

    public final void mo6489g(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        i = this.f36718i.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4887c((LinkPresentationModel) i, this.f36717h, this.f36719j);
    }

    public final void mo6951p(int i) {
        UserLinkActions userLinkActions = this.f36724o;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        int i2 = i;
        userLinkActions.mo4880a(i2, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, new PopularListingPresenter$onHideSelected$1(this, i));
    }

    public final void mo6952q(int i) {
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) obj;
        List list = this.f36717h;
        obj = this.f36719j.get(linkPresentationModel.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        Link link = (Link) list.get(((Number) obj).intValue());
        this.f36724o.mo4879a(i, this.f36716f, link, new PopularListingPresenter$onSubscribeSelected$1(this, link));
    }

    public final void mo6943h(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4871a(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6944i(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4872b(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6946k(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4874d(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6950o(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4878h(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6945j(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4873c(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6947l(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4875e(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6948m(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4876f(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public final void mo6949n(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36725p;
        Object obj = this.f36718i.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4877g(i, (LinkPresentationModel) obj, this.f36717h, this.f36719j, this.f36718i, this.f36716f);
    }

    public static /* synthetic */ void m37158a(PopularListingPresenter popularListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame, boolean z, String str, String str2, boolean z2, Function0 function0, int i) {
        Pair a;
        PopularListingPresenter popularListingPresenter2 = popularListingPresenter;
        String str3 = (i & 8) != 0 ? null : str;
        String str4 = (i & 16) != 0 ? null : str2;
        int i2 = 0;
        boolean z3 = (i & 32) != 0 ? false : z2;
        Function0 function02 = (i & 64) != 0 ? PopularListingPresenter$loadListingAndSetOnView$1.f36703a : function0;
        Object t = popularListingPresenter2.f36728s.t();
        Intrinsics.m26843a(t, "frontpageSettings.appConfig");
        String a2 = t.a().a("popular");
        Object c = popularListingPresenter2.f36721l.c();
        Intrinsics.m26843a(c, "sessionManager.activeSession");
        AdContext adContext = new AdContext(c, "popular", a2, (byte) 0);
        boolean isEmpty = popularListingPresenter2.f36717h.isEmpty();
        AdsActions adsActions = popularListingPresenter2.f36727r;
        if (!z) {
            i2 = popularListingPresenter2.f36717h.size();
        }
        int a3 = adsActions.mo4840a(i2);
        if (!z || z3) {
            a = popularListingPresenter2.f36722m.m29332a(new PopularLoadDataParams(sortType, sortTimeFrame, str3, str4, popularListingPresenter2.f36716f.H_(), adContext, a3));
        } else {
            popularListingPresenter2.f36713c = null;
            a = popularListingPresenter2.f36723n.m29333a(new PopularRefreshDataParams(sortType, sortTimeFrame, popularListingPresenter2.f36716f.H_(), adContext, a3));
        }
        Single single = (Single) a.f25267a;
        Object onErrorReturn = ((Observable) a.f25268b).toList().onErrorReturn(PopularListingPresenter$loadListingAndSetOnView$2.f28442a);
        Intrinsics.m26843a(onErrorReturn, "ads.toList().onErrorReturn { emptyList() }");
        onErrorReturn = SinglesKt.m26767a(single, (SingleSource) onErrorReturn).map(PopularListingPresenter$loadListingAndSetOnView$3.f28443a).onErrorReturn(PopularListingPresenter$loadListingAndSetOnView$4.f28444a);
        Intrinsics.m26843a(onErrorReturn, "popular.zipWith(ads.toLi…PopularLoadResult.Error }");
        onErrorReturn = com.reddit.frontpage.util.kotlin.SinglesKt.m24094b(onErrorReturn, popularListingPresenter2.f36726q).subscribe((Consumer) new PopularListingPresenter$loadListingAndSetOnView$5(popularListingPresenter2, sortType, sortTimeFrame, str3, str4, isEmpty, z3, z, function02));
        Intrinsics.m26843a(onErrorReturn, "popular.zipWith(ads.toLi…  }\n          }\n        }");
        popularListingPresenter2.handleDispose(onErrorReturn);
    }

    private final void m37161a(String str, String str2) {
        this.f36713c = str;
        this.f36714d = str2;
        if (str != null) {
            this.f36716f.mo7650W();
        } else {
            this.f36716f.mo7651X();
        }
    }

    public final void m37167a() {
        m37158a(this, this.f36711a, this.f36712b, true, null, null, false, new PopularListingPresenter$refreshPopular$1(this), 56);
    }

    public static final /* synthetic */ void m37157a(PopularListingPresenter popularListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, boolean z2, boolean z3) {
        PopularListingPresenter popularListingPresenter2 = popularListingPresenter;
        if (z3 && !z2) {
            m37158a(popularListingPresenter2, sortType, sortTimeFrame, z3, str, str2, true, null, 64);
        } else if (z3 && !z) {
            popularListingPresenter2.f36716f.mo7649V();
            popularListingPresenter2.f36716f.mo7652a(popularListingPresenter2.f36711a, popularListingPresenter2.f36712b);
            popularListingPresenter2.f36716f.mo7647T();
        } else if (z) {
            popularListingPresenter2.f36716f.mo7336y();
        } else {
            popularListingPresenter2.f36715e = false;
            popularListingPresenter2.f36716f.mo7643P();
        }
    }

    public static final /* synthetic */ void m37160a(PopularListingPresenter popularListingPresenter, boolean z, Success success, boolean z2, SortType sortType, SortTimeFrame sortTimeFrame, boolean z3) {
        Listing listing = success.f28437a;
        List list = success.f28438b;
        List children = listing.getChildren();
        int size = popularListingPresenter.f36718i.size();
        popularListingPresenter.f36711a = sortType;
        popularListingPresenter.f36712b = sortTimeFrame;
        if (z) {
            popularListingPresenter.f36717h.clear();
            popularListingPresenter.f36718i.clear();
            popularListingPresenter.f36719j.clear();
        }
        popularListingPresenter.m37161a(listing.getAfter(), listing.getAdDistance());
        popularListingPresenter.f36718i.addAll(list);
        sortType = popularListingPresenter.f36717h.size();
        popularListingPresenter.f36717h.addAll(children);
        sortTimeFrame = popularListingPresenter.f36719j;
        Iterable<Link> iterable = children;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (Link uniqueId : iterable) {
            int i2 = i + 1;
            arrayList.add(TuplesKt.m26780a(uniqueId.getUniqueId(), Integer.valueOf(i + sortType)));
            i = i2;
        }
        MapsKt__MapsKt.m36122a((Map) sortTimeFrame, (Iterable) (List) arrayList);
        success = popularListingPresenter.f36727r.mo4841a(success.f28439c, popularListingPresenter.f36718i);
        popularListingPresenter.f36716f.mo7330b((List) popularListingPresenter.f36718i);
        if (z) {
            if (popularListingPresenter.f36717h.isEmpty()) {
                popularListingPresenter.f36716f.mo7645R();
            } else {
                if (z2) {
                    popularListingPresenter.f36716f.mo7644Q();
                } else {
                    popularListingPresenter.f36716f.mo7649V();
                }
                popularListingPresenter.f36716f.mo7335x();
            }
            if (z3) {
                popularListingPresenter.f36716f.mo7647T();
            }
            return;
        }
        popularListingPresenter.f36716f.mo7323a(size, list.size());
        for (Number intValue : (Iterable) success) {
            popularListingPresenter.f36716f.mo7323a(intValue.intValue(), 1);
        }
    }
}
