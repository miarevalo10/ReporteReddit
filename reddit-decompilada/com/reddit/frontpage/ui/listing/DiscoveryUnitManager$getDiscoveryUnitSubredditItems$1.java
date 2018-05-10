package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
final class DiscoveryUnitManager$getDiscoveryUnitSubredditItems$1<T, R> implements Function<T, R> {
    final /* synthetic */ DiscoveryUnitManager f29034a;
    final /* synthetic */ DiscoveryUnit f29035b;
    final /* synthetic */ CarouselCollectionStateKey f29036c;

    DiscoveryUnitManager$getDiscoveryUnitSubredditItems$1(DiscoveryUnitManager discoveryUnitManager, DiscoveryUnit discoveryUnit, CarouselCollectionStateKey carouselCollectionStateKey) {
        this.f29034a = discoveryUnitManager;
        this.f29035b = discoveryUnit;
        this.f29036c = carouselCollectionStateKey;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "<name for destructuring parameter 0>");
        List list = (List) pair.f25267a;
        obj = (CarouselCollectionState) pair.f25268b;
        DiscoveryUnitManager discoveryUnitManager = this.f29034a;
        DiscoveryUnit discoveryUnit = this.f29035b;
        Intrinsics.m26843a(obj, "carouselState");
        return DiscoveryUnitManager.m23399a(discoveryUnitManager, discoveryUnit, list, obj, this.f29036c);
    }
}
