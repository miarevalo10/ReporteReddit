package com.reddit.frontpage.presentation.carousel;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.carousel.RedditCarouselActions.SubscribeResult;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.CarouselView;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&J¼\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH'JL\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010 \u001a\u00020!H&J^\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010 \u001a\u00020!2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&Jd\u0010#\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH'JV\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010 \u001a\u00020!2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&J`\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010*\u001a\u00020+H&JJ\u0010,\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H'¨\u0006-"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/CarouselActions;", "", "onCarouselImpression", "", "screenName", "", "models", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listablePosition", "", "idsSeen", "", "getCarouselCollection", "Lkotlin/Function0;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "onCarouselItemDismissed", "Lio/reactivex/disposables/Disposable;", "", "carouselItemPosition", "model", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "listingView", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "handleCarouselReplacement", "Lkotlin/Function2;", "Lkotlin/Function1;", "onCarouselRemoved", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "notifyView", "", "onCarouselItemHeaderSelected", "navigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "onCarouselItemSelected", "onCarouselItemSubscribed", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult;", "onCarouselSelected", "onCarouselShowMeLessSelected", "links", "Lcom/reddit/frontpage/domain/model/Link;", "item", "carouselView", "Lcom/reddit/frontpage/presentation/listing/CarouselView;", "onCarouselSubscribed", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselActions.kt */
public interface CarouselActions {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: CarouselActions.kt */
    public static final class DefaultImpls {
    }

    SubscribeResult mo4786a(String str, List<Listable> list, int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingView<? super Listable> listingView);

    SubscribeResult mo4787a(String str, List<Listable> list, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, ListingView<? super Listable> listingView);

    Disposable mo4788a(String str, List<Listable> list, int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingView<? super Listable> listingView, Function0<? extends CarouselCollectionPresentationModel> function0, Function2<? super Integer, ? super CarouselCollectionPresentationModel, Unit> function2, Function1<? super String, Unit> function1, Function1<? super DiscoveryUnit, Unit> function12, boolean z);

    void mo4789a(String str, List<? extends Listable> list, int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingNavigator listingNavigator, Function0<? extends CarouselCollectionPresentationModel> function0);

    void mo4790a(String str, List<? extends Listable> list, int i, Set<String> set, Function0<? extends CarouselCollectionPresentationModel> function0);

    void mo4791a(String str, List<? extends Listable> list, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, ListingNavigator listingNavigator);

    void mo4792a(String str, List<? extends Listable> list, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingNavigator listingNavigator);

    void mo4793a(String str, List<Link> list, List<Listable> list2, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, ListingView<? super Listable> listingView, CarouselView carouselView);
}
