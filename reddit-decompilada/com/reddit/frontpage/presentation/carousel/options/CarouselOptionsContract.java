package com.reddit.frontpage.presentation.carousel.options;

import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselOptionsContract.kt */
public interface CarouselOptionsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/options/CarouselOptionsContract$Presenter;", "", "onCarouselShowMeLessSelected", "", "listablePosition", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "idsSeen", "", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselOptionsContract.kt */
    public interface Presenter {
        void mo4989a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set);
    }
}
