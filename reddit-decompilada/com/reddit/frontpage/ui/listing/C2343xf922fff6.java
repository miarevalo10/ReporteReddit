package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "carousel", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class C2343xf922fff6<T> implements Consumer<GeneralCarouselCollectionPresentationModel<? extends ICarouselItemPresentationModel>> {
    final /* synthetic */ LegacySubredditListingScreen f29057a;

    C2343xf922fff6(LegacySubredditListingScreen legacySubredditListingScreen) {
        this.f29057a = legacySubredditListingScreen;
    }

    public final /* synthetic */ void accept(Object obj) {
        GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = (GeneralCarouselCollectionPresentationModel) obj;
        if (this.f29057a.v_()) {
            LegacySubredditListingScreen legacySubredditListingScreen = this.f29057a;
            Intrinsics.m26843a((Object) generalCarouselCollectionPresentationModel, "carousel");
            legacySubredditListingScreen.m42257a(generalCarouselCollectionPresentationModel);
            return;
        }
        this.f29057a.f40625X = generalCarouselCollectionPresentationModel;
    }
}
