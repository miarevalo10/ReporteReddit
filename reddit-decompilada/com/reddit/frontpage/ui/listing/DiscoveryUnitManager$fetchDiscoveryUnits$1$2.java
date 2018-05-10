package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult.Success;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "it", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
final class DiscoveryUnitManager$fetchDiscoveryUnits$1$2<T, R> implements Function<T, R> {
    public static final DiscoveryUnitManager$fetchDiscoveryUnits$1$2 f29028a = new DiscoveryUnitManager$fetchDiscoveryUnits$1$2();

    DiscoveryUnitManager$fetchDiscoveryUnits$1$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        DiscoveryUnitLoadResult discoveryUnitLoadResult = (DiscoveryUnitLoadResult) obj;
        if (discoveryUnitLoadResult != null) {
            return ((Success) discoveryUnitLoadResult).f29023a;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult.Success");
    }
}
