package com.reddit.frontpage.ui.listing.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$26 implements Function3 {
    private final CardLinkAdapter f34350a;
    private final CarouselViewHolder f34351b;

    CardLinkAdapter$$Lambda$26(CardLinkAdapter cardLinkAdapter, CarouselViewHolder carouselViewHolder) {
        this.f34350a = cardLinkAdapter;
        this.f34351b = carouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        CardLinkAdapter cardLinkAdapter = this.f34350a;
        ViewHolder viewHolder = this.f34351b;
        Integer num = (Integer) obj;
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        obj3 = viewHolder.d();
        int intValue = cardLinkAdapter.a_(viewHolder).intValue();
        num.intValue();
        CarouselCollectionPresentationModel l = cardLinkAdapter.m30233l(intValue);
        obj = iCarouselItemPresentationModel.mo6444k() ^ 1;
        String b = iCarouselItemPresentationModel.mo6435b();
        if (obj != null) {
            iCarouselItemPresentationModel.mo6434a(true);
            cardLinkAdapter.d(obj3);
            cardLinkAdapter.m30210a(true, b);
            CardLinkAdapter.m30175m().mo4772a(set, intValue, l, cardLinkAdapter.mo6508g(), true);
        }
        return Unit.f25273a;
    }
}
