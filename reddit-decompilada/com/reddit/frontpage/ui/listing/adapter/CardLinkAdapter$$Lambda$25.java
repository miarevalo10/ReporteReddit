package com.reddit.frontpage.ui.listing.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$25 implements Function3 {
    private final CardLinkAdapter f34348a;
    private final CarouselViewHolder f34349b;

    CardLinkAdapter$$Lambda$25(CardLinkAdapter cardLinkAdapter, CarouselViewHolder carouselViewHolder) {
        this.f34348a = cardLinkAdapter;
        this.f34349b = carouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj3 = this.f34348a;
        ViewHolder viewHolder = this.f34349b;
        Integer num = (Integer) obj;
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        int d = viewHolder.d();
        int intValue = obj3.a_(viewHolder).intValue();
        obj = num.intValue();
        if (intValue >= 0) {
            if (intValue <= obj3.G_().size() - 1) {
                GeneralCarouselCollectionPresentationModel l = obj3.m30233l(intValue);
                List list = l.f36357e;
                if (obj >= null) {
                    if (obj <= list.size() - 1) {
                        list.remove(obj);
                        if (list.isEmpty() != null) {
                            obj3.m30223e(d, intValue);
                        } else {
                            obj3.d(d);
                        }
                        obj3.f29118o.mo5631a(FrontpageApplication.m28875k().mo4613a().m22466a(l.f36362j, new CardLinkAdapter$$Lambda$31(iCarouselItemPresentationModel)).observeOn(CardLinkAdapter.m30176n().a()).subscribe());
                    }
                }
            }
        }
        return Unit.f25273a;
    }
}
