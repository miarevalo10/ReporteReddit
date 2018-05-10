package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.listing.CarouselView;
import com.reddit.frontpage.presentation.listing.common.ListingModeratorActions;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.presentation.listing.common.MutableListingLinkActions;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract;", "", "Navigator", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageListingContract.kt */
public interface FrontpageListingContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$Parameters;", "", "sortObservable", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "(Lio/reactivex/Observable;)V", "getSortObservable", "()Lio/reactivex/Observable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageListingContract.kt */
    public static final class Parameters {
        final Observable<SortSelection<SortType>> f20595a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (Intrinsics.m26845a(this.f20595a, ((Parameters) obj).f20595a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Observable observable = this.f20595a;
            return observable != null ? observable.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(sortObservable=");
            stringBuilder.append(this.f20595a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(Observable<SortSelection<SortType>> observable) {
            Intrinsics.m26847b(observable, "sortObservable");
            this.f20595a = observable;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH&J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001a\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\fH&J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\fH&J\b\u0010\u001f\u001a\u00020\fH&J\b\u0010 \u001a\u00020\fH&J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0006H&R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/;", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/common/ReportableLinkActionView;", "Lcom/reddit/frontpage/presentation/listing/CarouselView;", "listingName", "", "getListingName", "()Ljava/lang/String;", "getCurrentViewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "hideLoadMoreView", "", "hideLoading", "hideRefreshPill", "hideRefreshing", "notifyLoadMoreNetworkError", "setListingViewMode", "mode", "setSorting", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "showContentListView", "showEmptyListView", "showLoadMoreView", "showLoading", "showMessage", "message", "showNetworkErrorMessage", "showRefreshPill", "showRefreshing", "showShortDurationMessage", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FrontpageListingContract.kt */
    public interface View extends CarouselView, ListingView<Listable> {
        String D_();

        ListingViewMode mo7619P();

        void mo7620Q();

        void mo7621R();

        void mo7622S();

        void mo7623T();

        void mo7624U();

        void mo7625V();

        void mo7626W();

        void mo7627X();

        void mo7628Y();

        void mo7629Z();

        void mo7632a(SortType sortType, SortTimeFrame sortTimeFrame);

        void mo7633a(ListingViewMode listingViewMode);

        void mo7635a(String str);

        void aa();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u001c\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingActions;", "Lcom/reddit/frontpage/presentation/carousel/ListingCarouselActions;", "onExplorePopularSelected", "", "onLoadErrorClicked", "onRefreshPillSelected", "onSortSelected", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "onViewModeSelected", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "sendScrollAnalytics", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter, ListingModeratorActions, MutableListingLinkActions {
    }
}
