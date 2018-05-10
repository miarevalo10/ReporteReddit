package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J1\u0010\u0006\u001a\u00020\u0003\"\u0012\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u00072\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ1\u0010\u000f\u001a\u00020\u0003\"\u0012\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u0012J9\u0010\u0013\u001a\u00020\u0003\"\u0012\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u0016J9\u0010\u0017\u001a\u00020\u0003\"\u0012\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u0016J)\u0010\u0018\u001a\u00020\u0003\"\u0012\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&JA\u0010\u001d\u001a\u00020\u0003\"\b\b\u0000\u0010\u001e*\u00020\t\"\u0012\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u001e0\b*\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 2\u0006\u0010\u000b\u001a\u0002H\u0007H&¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J!\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H&¨\u0006+"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "", "hideRefreshing", "", "screen", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "notifyDiffResult", "R", "Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "adapter", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "(Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;)V", "notifyLinkChanged", "position", "", "(ILcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "notifyLinksInserted", "startPosition", "numItems", "(IILcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "notifyLinksRemoved", "notifyListingChanged", "(Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "notifyLoadError", "errorMessage", "", "setListing", "T", "posts", "", "(Ljava/util/List;Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "showContentListView", "showEmptyListView", "layout", "(Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;Ljava/lang/Integer;)V", "showLoading", "showRefreshing", "showSuspendedReportView", "context", "Landroid/content/Context;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingViewActions.kt */
public interface ListingViewActions {
    <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4859a(int i, int i2, R r);

    <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4860a(int i, R r);

    void mo4861a(LinkListingScreen linkListingScreen);

    void mo4862a(LinkListingScreen linkListingScreen, Integer num);

    void mo4863a(LinkListingScreen linkListingScreen, String str);

    <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4864a(R r);

    <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4865a(R r, ViewDiffResult viewDiffResult);

    <T extends Listable, R extends CardLinkAdapter & ListingAdapter<T>> void mo4866a(List<? extends T> list, R r);

    <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4867b(int i, R r);

    void mo4868b(LinkListingScreen linkListingScreen);

    void mo4869c(LinkListingScreen linkListingScreen);

    void mo4870d(LinkListingScreen linkListingScreen);
}
