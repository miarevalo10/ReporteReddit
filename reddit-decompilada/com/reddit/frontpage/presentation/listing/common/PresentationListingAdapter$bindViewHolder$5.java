package com.reddit.frontpage.presentation.listing.common;

import android.view.View;
import com.reddit.frontpage.presentation.listing.model.LiveUpdateEventPresentationModel;
import com.reddit.frontpage.ui.listing.newcard.LiveThreadViewHolder;
import com.reddit.frontpage.util.IntentUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
final class PresentationListingAdapter$bindViewHolder$5 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ LiveThreadViewHolder f36551a;
    final /* synthetic */ LiveUpdateEventPresentationModel f36552b;

    PresentationListingAdapter$bindViewHolder$5(LiveThreadViewHolder liveThreadViewHolder, LiveUpdateEventPresentationModel liveUpdateEventPresentationModel) {
        this.f36551a = liveThreadViewHolder;
        this.f36552b = liveUpdateEventPresentationModel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f36551a.c;
        Intrinsics.m26843a(obj, "holder.itemView");
        obj = obj.getContext();
        obj.startActivity(IntentUtil.m23761b(obj, this.f36552b.f34000a));
        return Unit.f25273a;
    }
}
