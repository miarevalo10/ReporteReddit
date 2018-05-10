package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
final class PresentationListingAdapter$bindViewHolder$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PresentationListingAdapter f36543a;
    final /* synthetic */ LinkViewHolder f36544b;

    PresentationListingAdapter$bindViewHolder$2(PresentationListingAdapter presentationListingAdapter, LinkViewHolder linkViewHolder) {
        this.f36543a = presentationListingAdapter;
        this.f36544b = linkViewHolder;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f36543a.mo6937a((ViewHolder) this.f36544b, (Function1) new Function1<Integer, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                this.f36543a.f33885b.mo6485c(((Number) obj).intValue());
                return Unit.f25273a;
            }
        });
        return Unit.f25273a;
    }
}
