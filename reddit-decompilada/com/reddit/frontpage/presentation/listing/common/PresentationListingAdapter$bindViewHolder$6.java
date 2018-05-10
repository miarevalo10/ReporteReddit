package com.reddit.frontpage.presentation.listing.common;

import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v2.Banner;
import com.reddit.frontpage.util.IntentUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
final class PresentationListingAdapter$bindViewHolder$6 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Banner f36553a;

    PresentationListingAdapter$bindViewHolder$6(Banner banner) {
        this.f36553a = banner;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        IntentUtil.m23752a(this.f36553a.getDeeplinkUrl());
        return Unit.f25273a;
    }
}
