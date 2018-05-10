package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.listing.common.ListingLinkActions;
import com.reddit.frontpage.presentation.listing.common.ListingModeratorActions;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.presentation.listing.submitted.karma.KarmaCarouselContract$Presenter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract;", "", "Navigator", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingContract.kt */
public interface UserSubmittedListingContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$View;", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "username", "", "getUsername", "()Ljava/lang/String;", "hideLoading", "", "hideRefreshing", "notifyLoadMoreError", "errorMessage", "showContentListView", "showEmptyListView", "showLoading", "showRefreshing", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingContract.kt */
    public interface View extends ListingView<Listable> {
        void O_();

        void P_();

        void Q_();

        String mo7368a();

        void mo7369b();

        void mo7370c();

        void mo7371d();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingActions;", "Lcom/reddit/frontpage/presentation/listing/submitted/karma/KarmaCarouselContract$Presenter;", "createScreenViewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "createScreenViewLegacyEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent;", "event", "onLoadErrorClicked", "", "sendScrollEvent", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter, ListingLinkActions, ListingModeratorActions, KarmaCarouselContract$Presenter {
    }
}
