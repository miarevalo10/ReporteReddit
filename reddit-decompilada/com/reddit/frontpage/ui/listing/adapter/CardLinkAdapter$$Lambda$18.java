package com.reddit.frontpage.ui.listing.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$18 implements Function3 {
    private final CardLinkAdapter f34334a;
    private final LinkCarouselViewHolder f34335b;

    CardLinkAdapter$$Lambda$18(CardLinkAdapter cardLinkAdapter, LinkCarouselViewHolder linkCarouselViewHolder) {
        this.f34334a = cardLinkAdapter;
        this.f34335b = linkCarouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        CardLinkAdapter cardLinkAdapter = this.f34334a;
        ViewHolder viewHolder = this.f34335b;
        Integer num = (Integer) obj;
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = (LinkCarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        obj3 = viewHolder.d();
        int intValue = cardLinkAdapter.a_(viewHolder).intValue();
        num.intValue();
        CarouselCollectionPresentationModel m = cardLinkAdapter.m30234m(intValue);
        if ((linkCarouselItemPresentationModel.f28076e ^ 1) != null) {
            String str = linkCarouselItemPresentationModel.f28074c;
            for (LinkCarouselItemPresentationModel linkCarouselItemPresentationModel2 : m.f36374k) {
                if (linkCarouselItemPresentationModel2.f28074c.equals(str)) {
                    linkCarouselItemPresentationModel2.f28076e = true;
                }
            }
            cardLinkAdapter.d(obj3);
            cardLinkAdapter.m30210a(true, str);
            CardLinkAdapter.m30175m().mo4772a(set, intValue, m, cardLinkAdapter.mo6508g(), true);
        }
        return Unit.f25273a;
    }
}
