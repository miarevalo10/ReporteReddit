package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.OnLinkHiddenListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/frontpage/presentation/listing/common/PresentationListingAdapter$onLinkHiddenListener$1", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnLinkHiddenListener;", "(Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;)V", "onLinkHidden", "", "holder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
public final class PresentationListingAdapter$onLinkHiddenListener$1 implements OnLinkHiddenListener {
    final /* synthetic */ PresentationListingAdapter f28273a;

    PresentationListingAdapter$onLinkHiddenListener$1(PresentationListingAdapter presentationListingAdapter) {
        this.f28273a = presentationListingAdapter;
    }

    public final void mo4839a(LinkViewHolder linkViewHolder) {
        Intrinsics.m26847b(linkViewHolder, "holder");
        this.f28273a.mo6937a((ViewHolder) linkViewHolder, (Function1) new PresentationListingAdapter$onLinkHiddenListener$1$onLinkHidden$1(this));
    }
}
