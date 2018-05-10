package com.reddit.frontpage.ui.listing.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$24 implements Function3 {
    private final CardLinkAdapter f34346a;
    private final LinkCarouselViewHolder f34347b;

    CardLinkAdapter$$Lambda$24(CardLinkAdapter cardLinkAdapter, LinkCarouselViewHolder linkCarouselViewHolder) {
        this.f34346a = cardLinkAdapter;
        this.f34347b = linkCarouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        CardLinkAdapter cardLinkAdapter = this.f34346a;
        ViewHolder viewHolder = this.f34347b;
        Integer num = (Integer) obj;
        LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel = (LinkCarouselCollectionPresentationModel) obj2;
        Set set = (Set) obj3;
        int d = viewHolder.d();
        cardLinkAdapter.a_(viewHolder).intValue();
        num.intValue();
        obj = linkCarouselCollectionPresentationModel.f36373j;
        if (obj == null) {
            boolean z = obj ^ 1;
            cardLinkAdapter.m30210a(z, linkCarouselCollectionPresentationModel.f36368e);
            linkCarouselCollectionPresentationModel.f36373j = z;
            cardLinkAdapter.d(d);
            CardLinkAdapter.m30175m().mo4775b(set, linkCarouselCollectionPresentationModel, cardLinkAdapter.mo6508g());
        }
        return Unit.f25273a;
    }
}
