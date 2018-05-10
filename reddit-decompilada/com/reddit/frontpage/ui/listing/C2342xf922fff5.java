package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "it", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class C2342xf922fff5<T, R> implements Function<T, R> {
    public static final C2342xf922fff5 f29056a = new C2342xf922fff5();

    C2342xf922fff5() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj;
        Intrinsics.m26847b(carouselCollectionPresentationModel, "it");
        return (GeneralCarouselCollectionPresentationModel) carouselCollectionPresentationModel;
    }
}
