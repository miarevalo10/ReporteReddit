package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.presentation.listing.model.FooterState;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "", "footerIndex", "", "getFooterIndex", "()I", "footerState", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "getFooterState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "listingItemCount", "getListingItemCount", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadMoreListingAdapter.kt */
public interface LoadMoreListingAdapter {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: LoadMoreListingAdapter.kt */
    public static final class DefaultImpls {
        public static FooterState m22929a() {
            return FooterState.NONE;
        }
    }

    FooterState F_();

    int mo4926b();

    int mo4927j();
}
