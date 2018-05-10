package com.reddit.frontpage.presentation.listing.common;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH&J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "T", "", "notifyDiffResult", "", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "setListing", "posts", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingView.kt */
public interface ListingView<T> {
    void mo7322a(int i);

    void mo7323a(int i, int i2);

    void mo7324a(ViewDiffResult viewDiffResult);

    void mo7328b(int i);

    void mo7330b(List<? extends T> list);

    void mo7335x();

    void mo7336y();
}
