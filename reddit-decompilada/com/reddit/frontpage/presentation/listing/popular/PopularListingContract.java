package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.listing.common.ListingModeratorActions;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.presentation.listing.common.MutableListingLinkActions;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract;", "", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PopularListingContract.kt */
public interface PopularListingContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$Parameters;", "", "sortObservable", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "(Lio/reactivex/Observable;)V", "getSortObservable", "()Lio/reactivex/Observable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PopularListingContract.kt */
    public static final class Parameters {
        final Observable<SortSelection<SortType>> f20638a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (Intrinsics.m26845a(this.f20638a, ((Parameters) obj).f20638a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Observable observable = this.f20638a;
            return observable != null ? observable.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(sortObservable=");
            stringBuilder.append(this.f20638a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(Observable<SortSelection<SortType>> observable) {
            Intrinsics.m26847b(observable, "sortObservable");
            this.f20638a = observable;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH&J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u000bH&J\b\u0010\u0017\u001a\u00020\u000bH&J\b\u0010\u0018\u001a\u00020\u000bH&J\b\u0010\u0019\u001a\u00020\u000bH&J\b\u0010\u001a\u001a\u00020\u000bH&J\b\u0010\u001b\u001a\u00020\u000bH&J\b\u0010\u001c\u001a\u00020\u000bH&J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0005H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$View;", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/common/ReportableLinkActionView;", "listingName", "", "getListingName", "()Ljava/lang/String;", "getCurrentViewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "hideLoadMoreView", "", "hideRefreshPill", "hideRefreshing", "notifyLoadMoreNetworkError", "setListingViewMode", "mode", "setSorting", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "showContentListView", "showEmptyListView", "showLoadMoreView", "showLoading", "showNetworkErrorMessage", "showRefreshPill", "showRefreshing", "showSubscribedMessage", "subredditName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PopularListingContract.kt */
    public interface View extends ListingView<Listable> {
        ListingViewMode H_();

        void mo7643P();

        void mo7644Q();

        void mo7645R();

        void mo7646S();

        void mo7647T();

        void mo7648U();

        void mo7649V();

        void mo7650W();

        void mo7651X();

        void mo7652a(SortType sortType, SortTimeFrame sortTimeFrame);

        void mo7653a(ListingViewMode listingViewMode);

        void mo7654a(String str);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u001c\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0006H&¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/popular/PopularListingContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingActions;", "onLoadErrorClicked", "", "onRefreshPillSelected", "onSortSelected", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "onViewModeSelected", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "sendScrollAnalytics", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter, ListingModeratorActions, MutableListingLinkActions {
    }
}
