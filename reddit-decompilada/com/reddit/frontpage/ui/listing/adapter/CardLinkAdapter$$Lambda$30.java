package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.options.CarouselOptionsContract.Presenter;
import java.util.Set;

final /* synthetic */ class CardLinkAdapter$$Lambda$30 implements Presenter {
    private final CardLinkAdapter f29093a;
    private final int f29094b;

    CardLinkAdapter$$Lambda$30(CardLinkAdapter cardLinkAdapter, int i) {
        this.f29093a = cardLinkAdapter;
        this.f29094b = i;
    }

    public final void mo4989a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set set) {
        CardLinkAdapter cardLinkAdapter = this.f29093a;
        int i2 = this.f29094b;
        FrontpageSettings.a().f(carouselCollectionPresentationModel.mo6934a().unique_id);
        cardLinkAdapter.f29117n.dismiss();
        cardLinkAdapter.m30223e(i2, i);
        CardLinkAdapter.m30175m().mo4777d(set, carouselCollectionPresentationModel, cardLinkAdapter.mo6508g());
    }
}
