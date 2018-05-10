package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
final class PresentationListingAdapter$bindViewHolder$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PresentationListingAdapter f36540a;
    final /* synthetic */ LinkViewHolder f36541b;

    PresentationListingAdapter$bindViewHolder$1(PresentationListingAdapter presentationListingAdapter, LinkViewHolder linkViewHolder) {
        this.f36540a = presentationListingAdapter;
        this.f36541b = linkViewHolder;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f36540a.mo6937a((ViewHolder) this.f36541b, (Function1) new Function1<Integer, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                obj = ((Number) obj).intValue();
                PresentationListingAdapter.m34700a(this.f36540a, this.f36541b);
                this.f36540a.f33885b.mo6483a(obj);
                return Unit.f25273a;
            }
        });
        return Unit.f25273a;
    }
}
