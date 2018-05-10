package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.SubredditDiscoveryUnitItemPresentationModel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$onCarouselImpression$1 extends Lambda implements Function0<GeneralCarouselCollectionPresentationModel<?>> {
    final /* synthetic */ CommunitiesPresenter f36407a;
    final /* synthetic */ int f36408b;

    CommunitiesPresenter$onCarouselImpression$1(CommunitiesPresenter communitiesPresenter, int i) {
        this.f36407a = communitiesPresenter;
        this.f36408b = i;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        CommunityListItem a = this.f36407a.f33808b.m40549a(this.f36408b);
        if (a != null) {
            return ((SubredditDiscoveryUnitItemPresentationModel) a).mo7151a();
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.model.SubredditDiscoveryUnitItemPresentationModel");
    }
}
