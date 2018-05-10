package com.reddit.frontpage.presentation.listing.history;

import android.annotation.SuppressLint;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.HistoryLoadData;
import com.reddit.frontpage.domain.usecase.HistoryLoadDataParams;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.common.ui.Features;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.Presenter;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.View;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001SBW\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020'H\u0017J\u0018\u0010)\u001a\u00020'2\u0006\u0010$\u001a\u00020%2\u0006\u0010*\u001a\u00020\u001bH\u0002J \u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020\u001bH\u0003J\u0012\u0010/\u001a\u00020'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J4\u00100\u001a\u00020'2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00101\u001a\u00020\u001b2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020'03H\u0002J\b\u00104\u001a\u00020'H\u0016J\r\u00105\u001a\u00020\u001bH\u0001¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u00109\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010<\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\b\u0010=\u001a\u00020'H\u0016J\u0010\u0010>\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010A\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010B\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010C\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010D\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010F\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010G\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010H\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010I\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010J\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010K\u001a\u00020'2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010L\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u00108\u001a\u00020\u001eH\u0016J\u0010\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020PH\u0016J\b\u00101\u001a\u00020'H\u0002J\u0010\u0010Q\u001a\u00020'2\u0006\u0010*\u001a\u00020\u001bH\u0002J\b\u0010R\u001a\u00020'H\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingContract$View;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "historyLoadData", "Lcom/reddit/frontpage/domain/usecase/HistoryLoadData;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "moderatorActions", "Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "parameters", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingContract$Parameters;", "(Lcom/reddit/frontpage/presentation/listing/history/HistoryListingContract$View;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;Lcom/reddit/frontpage/domain/usecase/HistoryLoadData;Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/listing/history/HistoryListingContract$Parameters;)V", "after", "", "isLoadingMore", "", "linkPositions", "", "", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "attach", "", "clearRecentsHistory", "handleError", "isFirstLoad", "handleLinksLoadResult", "loadResult", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult$Success;", "wasRefreshing", "handleViewShouldLoadMore", "loadListingAndSetOnView", "refresh", "onSuccess", "Lkotlin/Function0;", "loadMore", "mvpEnabled", "mvpEnabled$app_standardRelease", "onCommentsSelected", "presentationModelPosition", "onCommunitySelected", "onCrossPostSelected", "onHideSelected", "onLinkSelected", "onLoadErrorClicked", "onModerateApprove", "onModerateDistinguish", "onModerateLockComments", "onModerateMarkNsfw", "onModerateMarkSpoiler", "onModeratePinAnnouncement", "onModerateRemove", "onModerateRemoveAsSpam", "onModerateSelected", "onPreviewSelected", "onReportSelected", "onSaveSelected", "onShareSelected", "onSortSelected", "onSourceSelected", "onSubscribeSelected", "onViewModeSelected", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "showLoadError", "updateListing", "HistoryLoadResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistoryListingPresenter.kt */
public final class HistoryListingPresenter extends DisposablePresenter implements Presenter {
    final View f36663a;
    private final List<Link> f36664b = ((List) new ArrayList());
    private final List<Listable> f36665c = ((List) new ArrayList());
    private final Map<String, Integer> f36666d = ((Map) new LinkedHashMap());
    private HistorySortType f36667e;
    private String f36668f;
    private boolean f36669g;
    private final SessionManager f36670h;
    private final HistoryLoadData f36671i;
    private final LinkRepository f36672j;
    private final PreferenceRepository f36673k;
    private final UserLinkActions f36674l;
    private final ModeratorLinkActions f36675m;
    private final BackgroundThread f36676n;
    private final PostExecutionThread f36677o;
    private final Parameters f36678p;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult;", "", "()V", "Error", "Success", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult$Error;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult$Success;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: HistoryListingPresenter.kt */
    private static abstract class HistoryLoadResult {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult$Error;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult;", "()V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: HistoryListingPresenter.kt */
        public static final class Error extends HistoryLoadResult {
            public static final Error f28395a = new Error();

            private Error() {
                super();
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult$Success;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult;", "links", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "models", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "(Lcom/reddit/datalibrary/frontpage/data/model/Listing;Ljava/util/List;)V", "getLinks", "()Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "getModels", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: HistoryListingPresenter.kt */
        public static final class Success extends HistoryLoadResult {
            final Listing<Link> f28396a;
            final List<Listable> f28397b;

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Success) {
                        Success success = (Success) obj;
                        if (Intrinsics.m26845a(this.f28396a, success.f28396a) && Intrinsics.m26845a(this.f28397b, success.f28397b)) {
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                Listing listing = this.f28396a;
                int i = 0;
                int hashCode = (listing != null ? listing.hashCode() : 0) * 31;
                List list = this.f28397b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder("Success(links=");
                stringBuilder.append(this.f28396a);
                stringBuilder.append(", models=");
                stringBuilder.append(this.f28397b);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public Success(Listing<Link> listing, List<? extends Listable> list) {
                Intrinsics.m26847b(listing, "links");
                Intrinsics.m26847b(list, "models");
                super();
                this.f28396a = listing;
                this.f28397b = list;
            }
        }

        private HistoryLoadResult() {
        }
    }

    @Inject
    public HistoryListingPresenter(View view, SessionManager sessionManager, HistoryLoadData historyLoadData, LinkRepository linkRepository, PreferenceRepository preferenceRepository, UserLinkActions userLinkActions, ModeratorLinkActions moderatorLinkActions, BackgroundThread backgroundThread, PostExecutionThread postExecutionThread, Parameters parameters) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(historyLoadData, "historyLoadData");
        Intrinsics.m26847b(linkRepository, "linkRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(userLinkActions, "linkActions");
        Intrinsics.m26847b(moderatorLinkActions, "moderatorActions");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(parameters, "parameters");
        this.f36663a = view;
        this.f36670h = sessionManager;
        this.f36671i = historyLoadData;
        this.f36672j = linkRepository;
        this.f36673k = preferenceRepository;
        this.f36674l = userLinkActions;
        this.f36675m = moderatorLinkActions;
        this.f36676n = backgroundThread;
        this.f36677o = postExecutionThread;
        this.f36678p = parameters;
        view = HistorySortOptions.f20601a;
        this.f36667e = (HistorySortType) HistorySortOptions.m22956a().f20414c;
    }

    public final void attach() {
        Object subscribe = ObservablesKt.m24092b(ObservablesKt.m24090a(this.f36678p.f20596a, (Thread) this.f36676n), this.f36677o).subscribe((Consumer) new HistoryListingPresenter$attach$1(this));
        Intrinsics.m26843a(subscribe, "parameters.sortObservabl…n.sortType)\n            }");
        handleDispose(subscribe);
        if ((this.f36665c.isEmpty() ^ 1) != 0) {
            this.f36663a.mo7661a(this.f36667e);
            this.f36663a.mo7664a(Intrinsics.m26845a(this.f36667e, HistorySortType.f28408a));
            this.f36663a.mo7330b(this.f36665c);
            this.f36663a.mo7335x();
            this.f36663a.J_();
            this.f36663a.mo7665b();
            m37088a(this.f36668f);
            return;
        }
        this.f36663a.L_();
        this.f36663a.mo7661a(this.f36667e);
        m37087a(this.f36667e, null, true, (Function0) HistoryListingPresenter$loadListingAndSetOnView$1.f36657a);
    }

    @SuppressLint({"VisibleForTests"})
    public final void m37093a() {
        if (Intrinsics.m26845a(this.f36667e, HistorySortType.f28408a)) {
            Completable a;
            this.f36663a.mo7660a();
            if (m37092d()) {
                LinkRepository linkRepository = this.f36672j;
                Iterable<Link> iterable = this.f36664b;
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (Link uniqueId : iterable) {
                    arrayList.add(uniqueId.getUniqueId());
                }
                a = linkRepository.m22413a((Collection) (List) arrayList);
            } else {
                a = this.f36673k.m22478c();
            }
            Object subscribe = CompletablesKt.m24074b(a, this.f36677o).subscribe((Action) new HistoryListingPresenter$clearRecentsHistory$1(this));
            Intrinsics.m26843a(subscribe, "clearFunction\n          …resh = true)\n          })");
            handleDispose(subscribe);
        }
    }

    public final void m37095b() {
        if (this.f36668f != null && !this.f36669g) {
            this.f36669g = true;
            m37087a(this.f36667e, this.f36668f, false, (Function0) new HistoryListingPresenter$loadMore$1(this));
        }
    }

    public final void mo6485c(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4882a((LinkPresentationModel) i);
    }

    public final void mo6486d(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4885b((LinkPresentationModel) i, this.f36664b, this.f36666d);
    }

    public final void mo6483a(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4884a((LinkPresentationModel) i, this.f36666d, ListingType.f20577d, this.f36667e, null);
    }

    public final void mo6484b(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4883a((LinkPresentationModel) i, this.f36664b, this.f36666d);
    }

    public final void mo6487e(int i) {
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) i;
        UserLinkActions userLinkActions = this.f36674l;
        List list = this.f36664b;
        Object obj = this.f36666d.get(linkPresentationModel.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        userLinkActions.mo4881a((Link) list.get(((Number) obj).intValue()), linkPresentationModel);
    }

    public final void mo6488f(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4886b((LinkPresentationModel) i, this.f36666d, ListingType.f20577d, (LinkSortType) this.f36667e, null);
    }

    public final void mo6489g(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        i = this.f36665c.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4887c((LinkPresentationModel) i, this.f36664b, this.f36666d);
    }

    public final void mo6951p(int i) {
        UserLinkActions userLinkActions = this.f36674l;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4880a(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, new HistoryListingPresenter$onHideSelected$1(this, i));
    }

    public final void mo6952q(int i) {
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) obj;
        List list = this.f36664b;
        obj = this.f36666d.get(linkPresentationModel.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        Link link = (Link) list.get(((Number) obj).intValue());
        this.f36674l.mo4879a(i, this.f36663a, link, new HistoryListingPresenter$onSubscribeSelected$1(this, link));
    }

    public final void mo6943h(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4871a(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6944i(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4872b(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6946k(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4874d(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6950o(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4878h(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6945j(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4873c(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6947l(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4875e(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6948m(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4876f(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    public final void mo6949n(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36675m;
        Object obj = this.f36665c.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4877g(i, (LinkPresentationModel) obj, this.f36664b, this.f36666d, this.f36665c, this.f36663a);
    }

    private final void m37087a(HistorySortType historySortType, String str, boolean z, Function0<Unit> function0) {
        boolean isEmpty = this.f36664b.isEmpty();
        HistoryLoadData historyLoadData = this.f36671i;
        Object username = this.f36670h.c().getUsername();
        Intrinsics.m26843a(username, "sessionManager.activeSession.username");
        Object onErrorReturn = historyLoadData.m22528b(new HistoryLoadDataParams(username, historySortType, str, m37092d())).map(HistoryListingPresenter$loadListingAndSetOnView$2.f28400a).onErrorReturn(HistoryListingPresenter$loadListingAndSetOnView$3.f28401a);
        Intrinsics.m26843a(onErrorReturn, "historyLoadData.execute(…HistoryLoadResult.Error }");
        Object subscribe = SinglesKt.m24094b(onErrorReturn, this.f36677o).subscribe((Consumer) new HistoryListingPresenter$loadListingAndSetOnView$4(this, historySortType, isEmpty, function0, z));
        Intrinsics.m26843a(subscribe, "historyLoadData.execute(…  }\n          }\n        }");
        handleDispose(subscribe);
    }

    private final void m37088a(String str) {
        this.f36668f = str;
        if (str != null) {
            this.f36663a.mo7666c();
        } else {
            this.f36663a.mo7667d();
        }
    }

    final void m37097c() {
        m37087a(this.f36667e, null, true, (Function0) HistoryListingPresenter$loadListingAndSetOnView$1.f36657a);
    }

    private static boolean m37092d() {
        return Features.m22743b() && Features.m22742a();
    }

    public static final /* synthetic */ void m37086a(HistoryListingPresenter historyListingPresenter, HistorySortType historySortType, boolean z) {
        historyListingPresenter.f36667e = historySortType;
        historyListingPresenter.f36669g = false;
        historyListingPresenter.f36663a.mo7665b();
        historyListingPresenter.f36663a.mo7661a(historySortType);
        if (z) {
            historyListingPresenter.f36663a.mo7336y();
            historyListingPresenter.f36663a.M_();
            historyListingPresenter.f36663a.mo7664a(Intrinsics.m26845a(historyListingPresenter.f36667e, HistorySortType.f28408a));
            return;
        }
        historyListingPresenter.f36663a.I_();
    }

    public static final /* synthetic */ void m37084a(HistoryListingPresenter historyListingPresenter, Success success, HistorySortType historySortType, boolean z) {
        Listing listing = success.f28396a;
        success = success.f28397b;
        List children = listing.getChildren();
        int size = historyListingPresenter.f36665c.size();
        historyListingPresenter.f36667e = historySortType;
        if (z) {
            historyListingPresenter.f36664b.clear();
            historyListingPresenter.f36665c.clear();
            historyListingPresenter.f36666d.clear();
        }
        historyListingPresenter.m37088a(listing.getAfter());
        historyListingPresenter.f36665c.addAll((Collection) success);
        int size2 = historyListingPresenter.f36664b.size();
        historyListingPresenter.f36664b.addAll(children);
        Map map = historyListingPresenter.f36666d;
        Iterable<Link> iterable = children;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (Link uniqueId : iterable) {
            int i2 = i + 1;
            arrayList.add(TuplesKt.m26780a(uniqueId.getUniqueId(), Integer.valueOf(i + size2)));
            i = i2;
        }
        MapsKt__MapsKt.m36122a(map, (Iterable) (List) arrayList);
        historyListingPresenter.f36663a.mo7330b(historyListingPresenter.f36665c);
        if (z) {
            if (historyListingPresenter.f36664b.isEmpty() != null) {
                historyListingPresenter.f36663a.K_();
            } else {
                historyListingPresenter.f36663a.J_();
            }
            historyListingPresenter.f36663a.mo7665b();
            historyListingPresenter.f36663a.mo7335x();
            historyListingPresenter.f36663a.mo7664a(Intrinsics.m26845a((Object) historySortType, HistorySortType.f28408a));
            return;
        }
        historyListingPresenter.f36663a.mo7323a(size, success.size());
    }
}
