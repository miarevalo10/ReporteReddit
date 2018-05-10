package com.reddit.frontpage.presentation.viewmode;

import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ViewModeOptionsContract.kt */
public interface ViewModeOptionsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionsContract$View;", "", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "clearSelections", "", "notifyModeSelection", "setCardOption", "setCompactOption", "setGalleryOption", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ViewModeOptionsContract.kt */
    public interface View {
        ListingViewMode mo7192a();

        void mo7193a(ListingViewMode listingViewMode);

        void mo7176b();

        void mo7194c();

        void mo7195d();

        void mo7196e();
    }
}
