package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class LegacySubredditListingScreen$bindSubscriptionDiscoveryUnit$1 extends Lambda implements Function2<Integer, Set<? extends String>, Unit> {
    final /* synthetic */ LegacySubredditListingScreen f37275a;
    final /* synthetic */ CarouselAnalytics f37276b;
    final /* synthetic */ GeneralCarouselCollectionPresentationModel f37277c;

    LegacySubredditListingScreen$bindSubscriptionDiscoveryUnit$1(LegacySubredditListingScreen legacySubredditListingScreen, CarouselAnalytics carouselAnalytics, GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel) {
        this.f37275a = legacySubredditListingScreen;
        this.f37276b = carouselAnalytics;
        this.f37277c = generalCarouselCollectionPresentationModel;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        ((Number) obj).intValue();
        Set set = (Set) obj2;
        Intrinsics.m26847b(set, "idsSeen");
        obj = this.f37276b;
        CarouselCollectionPresentationModel carouselCollectionPresentationModel = this.f37277c;
        String analyticsScreenName = this.f37275a.getAnalyticsScreenName();
        if (analyticsScreenName == null) {
            Intrinsics.m26842a();
        }
        obj.mo4776c(set, carouselCollectionPresentationModel, analyticsScreenName);
        return Unit.f25273a;
    }
}
