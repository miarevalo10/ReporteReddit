package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "position", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
final class C2899x406f3747 extends Lambda implements Function3<Integer, ICarouselItemPresentationModel, Set<? extends String>, Unit> {
    final /* synthetic */ LegacySubredditListingScreen f37272a;
    final /* synthetic */ GeneralCarouselCollectionPresentationModel f37273b;
    final /* synthetic */ CarouselAnalytics f37274c;

    C2899x406f3747(LegacySubredditListingScreen legacySubredditListingScreen, GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel, CarouselAnalytics carouselAnalytics) {
        this.f37272a = legacySubredditListingScreen;
        this.f37273b = generalCarouselCollectionPresentationModel;
        this.f37274c = carouselAnalytics;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj = ((Number) obj).intValue();
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        Intrinsics.m26847b(iCarouselItemPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        CarouselAnalytics carouselAnalytics = this.f37274c;
        String analyticsScreenName = this.f37272a.getAnalyticsScreenName();
        if (analyticsScreenName == null) {
            Intrinsics.m26842a();
        }
        carouselAnalytics.mo4771a(set, obj, this.f37273b, analyticsScreenName);
        Routing.m22623a((Screen) this.f37272a, Nav.m22566b(StringsKt__StringsKt.m42465d(iCarouselItemPresentationModel.mo6435b(), "r/")));
        return Unit.f25273a;
    }
}
