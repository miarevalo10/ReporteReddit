package com.reddit.frontpage.presentation.listing.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.listing.history.HistorySortHeaderPresentationModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
final class C1824x6806beb4 implements OnClickListener {
    final /* synthetic */ PresentationListingAdapter f20588a;
    final /* synthetic */ HistorySortHeaderPresentationModel f20589b;

    C1824x6806beb4(PresentationListingAdapter presentationListingAdapter, HistorySortHeaderPresentationModel historySortHeaderPresentationModel) {
        this.f20588a = presentationListingAdapter;
        this.f20589b = historySortHeaderPresentationModel;
    }

    public final void onClick(View view) {
        this.f20588a.f33888q.invoke();
    }
}
