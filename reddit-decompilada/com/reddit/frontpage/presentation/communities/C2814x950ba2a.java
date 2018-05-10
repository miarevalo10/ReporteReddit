package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class C2814x950ba2a extends Lambda implements Function1<CommunityPresentationModel, Boolean> {
    final /* synthetic */ CommunitiesPresenter$onFavoriteClicked$1 f36416a;

    C2814x950ba2a(CommunitiesPresenter$onFavoriteClicked$1 communitiesPresenter$onFavoriteClicked$1) {
        this.f36416a = communitiesPresenter$onFavoriteClicked$1;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CommunityPresentationModel communityPresentationModel = (CommunityPresentationModel) obj;
        Intrinsics.m26847b(communityPresentationModel, "it");
        boolean z = true;
        if (!Intrinsics.m26845a(communityPresentationModel.f20469a, this.f36416a.f36418a.f20469a) || (Intrinsics.m26845a(communityPresentationModel.f20471c, CommunityPresentationSection.f20490d) ^ 1) == null) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
