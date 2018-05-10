package com.reddit.frontpage.ui.carousel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.LinkCarouselItemViewHolder.WhenMappings;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkCarouselViewHolder.kt */
final class LinkCarouselViewHolder$2$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ CarouselRecyclerView f37202a;

    LinkCarouselViewHolder$2$1(CarouselRecyclerView carouselRecyclerView) {
        this.f37202a = carouselRecyclerView;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = ((Number) obj).intValue();
        ViewHolder findViewHolderForAdapterPosition = this.f37202a.findViewHolderForAdapterPosition(obj - 1);
        if (!(findViewHolderForAdapterPosition instanceof LinkCarouselItemViewHolder)) {
            findViewHolderForAdapterPosition = null;
        }
        LinkCarouselItemViewHolder linkCarouselItemViewHolder = (LinkCarouselItemViewHolder) findViewHolderForAdapterPosition;
        if (linkCarouselItemViewHolder != null) {
            linkCarouselItemViewHolder.m29974w();
        }
        findViewHolderForAdapterPosition = this.f37202a.findViewHolderForAdapterPosition(obj);
        if (findViewHolderForAdapterPosition == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.carousel.LinkCarouselItemViewHolder");
        }
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = ((LinkCarouselItemViewHolder) findViewHolderForAdapterPosition).f28923p;
        if (linkCarouselItemPresentationModel == null) {
            Intrinsics.m26844a("item");
        }
        LinkType linkType = linkCarouselItemPresentationModel.f28082k;
        int[] iArr = WhenMappings.f21128b;
        linkType.ordinal();
        obj = this.f37202a.findViewHolderForAdapterPosition(obj + 1);
        if (!(obj instanceof LinkCarouselItemViewHolder)) {
            obj = null;
        }
        LinkCarouselItemViewHolder linkCarouselItemViewHolder2 = (LinkCarouselItemViewHolder) obj;
        if (linkCarouselItemViewHolder2 != null) {
            linkCarouselItemViewHolder2.m29974w();
        }
        return Unit.f25273a;
    }
}
