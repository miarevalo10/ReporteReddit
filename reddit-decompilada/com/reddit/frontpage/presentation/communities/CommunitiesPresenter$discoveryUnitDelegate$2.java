package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.ui.listing.DiscoveryUnitManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$discoveryUnitDelegate$2 extends Lambda implements Function0<DiscoveryUnitManager> {
    final /* synthetic */ CommunitiesPresenter f36405a;

    CommunitiesPresenter$discoveryUnitDelegate$2(CommunitiesPresenter communitiesPresenter) {
        this.f36405a = communitiesPresenter;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new DiscoveryUnitManager(this.f36405a.f33818m);
    }
}
