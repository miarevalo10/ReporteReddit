package com.reddit.frontpage.ui.carousel;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CarouselViewHolder.kt */
final class CarouselViewHolder$bind$$inlined$apply$lambda$1 extends Lambda implements Function2<Integer, ICarouselItemPresentationModel, Unit> {
    final /* synthetic */ CarouselViewHolder f37169a;
    final /* synthetic */ GeneralCarouselCollectionPresentationModel f37170b;
    final /* synthetic */ Function3 f37171c;
    final /* synthetic */ Function3 f37172d;
    final /* synthetic */ Function3 f37173e;

    CarouselViewHolder$bind$$inlined$apply$lambda$1(CarouselViewHolder carouselViewHolder, GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel, Function3 function3, Function3 function32, Function3 function33) {
        this.f37169a = carouselViewHolder;
        this.f37170b = generalCarouselCollectionPresentationModel;
        this.f37171c = function3;
        this.f37172d = function32;
        this.f37173e = function33;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        obj = ((Number) obj).intValue();
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        Intrinsics.m26847b(iCarouselItemPresentationModel, "item");
        this.f37171c.mo6509a(Integer.valueOf(obj), iCarouselItemPresentationModel, this.f37169a.m34909x());
        return Unit.f25273a;
    }
}
