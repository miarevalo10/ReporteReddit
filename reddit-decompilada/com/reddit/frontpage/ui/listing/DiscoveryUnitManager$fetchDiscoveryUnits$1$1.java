package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult.Success;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
final class DiscoveryUnitManager$fetchDiscoveryUnits$1$1<T> implements Predicate<DiscoveryUnitLoadResult> {
    public static final DiscoveryUnitManager$fetchDiscoveryUnits$1$1 f29027a = new DiscoveryUnitManager$fetchDiscoveryUnits$1$1();

    DiscoveryUnitManager$fetchDiscoveryUnits$1$1() {
    }

    public final /* synthetic */ boolean test(Object obj) {
        DiscoveryUnitLoadResult discoveryUnitLoadResult = (DiscoveryUnitLoadResult) obj;
        Intrinsics.m26847b(discoveryUnitLoadResult, "it");
        return discoveryUnitLoadResult instanceof Success;
    }
}
