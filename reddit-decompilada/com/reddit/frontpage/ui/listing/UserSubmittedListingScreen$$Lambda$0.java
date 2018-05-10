package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.presentation.carousel.CarouselColorGenerator;
import io.reactivex.functions.Function;
import java.util.List;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$0 implements Function {
    private final CarouselColorGenerator f29076a;

    UserSubmittedListingScreen$$Lambda$0(CarouselColorGenerator carouselColorGenerator) {
        this.f29076a = carouselColorGenerator;
    }

    public final Object apply(Object obj) {
        return UserSubmittedListingScreen.m41027a(this.f29076a, (List) obj);
    }
}
