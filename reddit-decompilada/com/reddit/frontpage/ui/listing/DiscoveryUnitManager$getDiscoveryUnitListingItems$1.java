package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
final class DiscoveryUnitManager$getDiscoveryUnitListingItems$1<T, R> implements Function<T, R> {
    final /* synthetic */ DiscoveryUnitManager f29029a;
    final /* synthetic */ DiscoveryUnit f29030b;
    final /* synthetic */ CarouselCollectionStateKey f29031c;

    DiscoveryUnitManager$getDiscoveryUnitListingItems$1(DiscoveryUnitManager discoveryUnitManager, DiscoveryUnit discoveryUnit, CarouselCollectionStateKey carouselCollectionStateKey) {
        this.f29029a = discoveryUnitManager;
        this.f29030b = discoveryUnit;
        this.f29031c = carouselCollectionStateKey;
    }

    public final /* synthetic */ Object apply(Object obj) {
        DiscoveryUnitListingDataModel discoveryUnitListingDataModel = (DiscoveryUnitListingDataModel) obj;
        Intrinsics.m26847b(discoveryUnitListingDataModel, "it");
        return DiscoveryUnitManager.m23398a(this.f29029a, this.f29030b, discoveryUnitListingDataModel, this.f29031c);
    }
}
