package com.reddit.frontpage.presentation.listing.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
final class PresentationListingAdapter$configure$2$onLockCommentsChanged$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ PresentationListingAdapter$configure$2 f36559a;

    PresentationListingAdapter$configure$2$onLockCommentsChanged$1(PresentationListingAdapter$configure$2 presentationListingAdapter$configure$2) {
        this.f36559a = presentationListingAdapter$configure$2;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ((ListingModeratorActions) this.f36559a.f28271a.f33885b).mo6945j(((Number) obj).intValue());
        return Unit.f25273a;
    }
}
