package com.reddit.frontpage.presentation.communities;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$models$1$removeDiscoveryUnit$1 extends Lambda implements Function1<GeneralCarouselCollectionPresentationModel<?>, Boolean> {
    final /* synthetic */ DiscoveryUnit f36406a;

    CommunitiesPresenter$models$1$removeDiscoveryUnit$1(DiscoveryUnit discoveryUnit) {
        this.f36406a = discoveryUnit;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = (GeneralCarouselCollectionPresentationModel) obj;
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "it");
        return Boolean.valueOf(Intrinsics.m26845a(generalCarouselCollectionPresentationModel.f36358f, this.f36406a.unique_id));
    }
}
