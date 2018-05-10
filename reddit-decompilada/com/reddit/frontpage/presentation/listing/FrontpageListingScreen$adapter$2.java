package com.reddit.frontpage.presentation.listing;

import android.content.Context;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen$FrontpageLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/FrontpageListingScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class FrontpageListingScreen$adapter$2 extends Lambda implements Function0<FrontpageLinkAdapter> {
    final /* synthetic */ FrontpageListingScreen f36517a;

    FrontpageListingScreen$adapter$2(FrontpageListingScreen frontpageListingScreen) {
        this.f36517a = frontpageListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        FrontpageListingScreen frontpageListingScreen = this.f36517a;
        Object am_ = this.f36517a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        FrontpageLinkAdapter frontpageLinkAdapter = new FrontpageLinkAdapter(frontpageListingScreen, (Context) am_, new Function4<Integer, Integer, CarouselItemPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                obj = ((Number) obj).intValue();
                obj2 = ((Number) obj2).intValue();
                CarouselItemPresentationModel carouselItemPresentationModel = (CarouselItemPresentationModel) obj3;
                Set set = (Set) obj4;
                Intrinsics.m26847b(carouselItemPresentationModel, "item");
                Intrinsics.m26847b(set, "idsSeen");
                this.f36517a.mo7641w().m37061a(obj, obj2, carouselItemPresentationModel, set);
                return Unit.f25273a;
            }
        }, new Function4<Integer, Integer, CarouselItemPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                int intValue = ((Number) obj).intValue();
                int intValue2 = ((Number) obj2).intValue();
                CarouselItemPresentationModel carouselItemPresentationModel = (CarouselItemPresentationModel) obj3;
                Set set = (Set) obj4;
                Intrinsics.m26847b(carouselItemPresentationModel, "item");
                Intrinsics.m26847b(set, "idsSeen");
                obj = this.f36517a.mo7641w();
                Intrinsics.m26847b(carouselItemPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                ((FrontpageListingPresenter) obj).m37064a(obj.f36637f.mo4786a("frontpage", obj.f36633b, intValue, intValue2, carouselItemPresentationModel, set, (ListingView) obj.f36634c));
                return Unit.f25273a;
            }
        }, new Function4<Integer, Integer, CarouselItemPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                int intValue = ((Number) obj).intValue();
                int intValue2 = ((Number) obj2).intValue();
                CarouselItemPresentationModel carouselItemPresentationModel = (CarouselItemPresentationModel) obj3;
                Set set = (Set) obj4;
                Intrinsics.m26847b(carouselItemPresentationModel, "item");
                Intrinsics.m26847b(set, "idsSeen");
                obj = this.f36517a.mo7641w();
                Intrinsics.m26847b(carouselItemPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                obj.f36637f.mo4789a("frontpage", obj.f36633b, intValue, intValue2, carouselItemPresentationModel, set, obj.f36635d, null);
                return Unit.f25273a;
            }
        }, new Function4<Integer, Integer, CarouselItemPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6942a(Object obj, Object obj2, Object obj3, Object obj4) {
                ((Number) obj).intValue();
                ((Number) obj2).intValue();
                CarouselItemPresentationModel carouselItemPresentationModel = (CarouselItemPresentationModel) obj3;
                Set set = (Set) obj4;
                Intrinsics.m26847b(carouselItemPresentationModel, "item");
                Intrinsics.m26847b(set, "idsSeen");
                obj = this.f36517a.mo7641w();
                Intrinsics.m26847b(carouselItemPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                obj.f36637f.mo4792a("frontpage", obj.f36633b, carouselItemPresentationModel, set, obj.f36635d);
                return Unit.f25273a;
            }
        }, new Function3<Integer, CarouselCollectionPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
                obj = ((Number) obj).intValue();
                CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj2;
                Set set = (Set) obj3;
                Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                if (this.f36517a.am_() != null) {
                    FrontpageListingScreen frontpageListingScreen = this.f36517a;
                    Object am_ = this.f36517a.am_();
                    if (am_ == null) {
                        Intrinsics.m26842a();
                    }
                    Intrinsics.m26843a(am_, "activity!!");
                    FrontpageListingScreen.m41963a(frontpageListingScreen, (Context) am_, carouselCollectionPresentationModel, set, obj);
                }
                return Unit.f25273a;
            }
        }, new Function3<Integer, CarouselCollectionPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
                ((Number) obj).intValue();
                CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj2;
                Set set = (Set) obj3;
                Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                obj = this.f36517a.mo7641w();
                Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                obj.f36637f.mo4791a("frontpage", obj.f36633b, carouselCollectionPresentationModel, set, obj.f36635d);
                return Unit.f25273a;
            }
        }, new Function3<Integer, CarouselCollectionPresentationModel, Set<? extends String>, Unit>() {
            public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
                int intValue = ((Number) obj).intValue();
                CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj2;
                Set set = (Set) obj3;
                Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
                Intrinsics.m26847b(set, "idsSeen");
                obj = this.f36517a.mo7641w();
                Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
                Intrinsics.m26847b(set, "idsSeen");
                ((FrontpageListingPresenter) obj).m37064a(obj.f36637f.mo4787a("frontpage", obj.f36633b, intValue, carouselCollectionPresentationModel, set, (ListingView) obj.f36634c));
                return Unit.f25273a;
            }
        });
        frontpageLinkAdapter.a(true);
        return frontpageLinkAdapter;
    }
}
