package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
final class DiscoveryUnitManager$removeProcessed$1$1 extends Lambda implements Function1<DiscoveryUnitLoadResult, Boolean> {
    final /* synthetic */ CarouselCollectionPresentationModel f37261a;

    DiscoveryUnitManager$removeProcessed$1$1(CarouselCollectionPresentationModel carouselCollectionPresentationModel) {
        this.f37261a = carouselCollectionPresentationModel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DiscoveryUnitLoadResult discoveryUnitLoadResult = (DiscoveryUnitLoadResult) obj;
        Intrinsics.m26847b(discoveryUnitLoadResult, "it");
        obj = discoveryUnitLoadResult.mo4981a().unique_id;
        DiscoveryUnit a = this.f37261a.mo6934a();
        if (a == null) {
            Intrinsics.m26842a();
        }
        return Boolean.valueOf(Intrinsics.m26845a(obj, a.unique_id));
    }
}
