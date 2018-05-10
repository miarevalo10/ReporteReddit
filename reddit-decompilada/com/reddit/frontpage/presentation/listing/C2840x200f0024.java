package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "carouselItemPosition", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class C2840x200f0024 extends Lambda implements Function3<Integer, ICarouselItemPresentationModel, Set<? extends String>, Unit> {
    final /* synthetic */ FrontpageLinkAdapter f36492a;
    final /* synthetic */ int f36493b;

    C2840x200f0024(FrontpageLinkAdapter frontpageLinkAdapter, int i) {
        this.f36492a = frontpageLinkAdapter;
        this.f36493b = i;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj = ((Number) obj).intValue();
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        Intrinsics.m26847b(iCarouselItemPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        this.f36492a.f36505q.mo6942a(Integer.valueOf(this.f36493b), Integer.valueOf(obj), (CarouselItemPresentationModel) iCarouselItemPresentationModel, set);
        return Unit.f25273a;
    }
}
