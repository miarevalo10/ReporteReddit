package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.OnViewMediaListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/presentation/listing/common/PresentationListingAdapter$configure$1", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnViewMediaListener;", "(Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;)V", "onViewCrossPost", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "onViewMedia", "onViewWebsite", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
public final class PresentationListingAdapter$configure$1 implements OnViewMediaListener {
    final /* synthetic */ PresentationListingAdapter f28269a;
    final /* synthetic */ LinkViewHolder f28270b;

    PresentationListingAdapter$configure$1(PresentationListingAdapter presentationListingAdapter, LinkViewHolder linkViewHolder) {
        this.f28269a = presentationListingAdapter;
        this.f28270b = linkViewHolder;
    }

    public final void mo4828a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f28269a.mo6937a((ViewHolder) this.f28270b, (Function1) new PresentationListingAdapter$configure$1$onViewMedia$1(this));
    }

    public final void mo4829b(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f28269a.mo6937a((ViewHolder) this.f28270b, (Function1) new PresentationListingAdapter$configure$1$onViewWebsite$1(this));
    }

    public final void mo4830c(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f28269a.mo6937a((ViewHolder) this.f28270b, (Function1) new PresentationListingAdapter$configure$1$onViewCrossPost$1(this));
    }
}
