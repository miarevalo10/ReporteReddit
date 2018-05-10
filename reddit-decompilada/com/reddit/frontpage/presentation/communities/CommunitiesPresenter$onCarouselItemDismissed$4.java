package com.reddit.frontpage.presentation.communities;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$onCarouselItemDismissed$4 extends Lambda implements Function1<DiscoveryUnit, Unit> {
    final /* synthetic */ CommunitiesPresenter f36413a;

    CommunitiesPresenter$onCarouselItemDismissed$4(CommunitiesPresenter communitiesPresenter) {
        this.f36413a = communitiesPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DiscoveryUnit discoveryUnit = (DiscoveryUnit) obj;
        Intrinsics.m26847b(discoveryUnit, "it");
        CommunitiesPresenter$models$1 a = this.f36413a.f33808b;
        Intrinsics.m26847b(discoveryUnit, "discoveryUnit");
        CollectionsKt__MutableCollectionsKt.m38197b(a.f40003a, (Function1) new CommunitiesPresenter$models$1$removeDiscoveryUnit$1(discoveryUnit));
        a.m40555b();
        return Unit.f25273a;
    }
}
