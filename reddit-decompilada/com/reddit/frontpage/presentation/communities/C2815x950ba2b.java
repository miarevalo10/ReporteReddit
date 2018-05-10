package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "it", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class C2815x950ba2b extends Lambda implements Function1<CommunityPresentationModel, CommunityPresentationModel> {
    final /* synthetic */ CommunitiesPresenter$onFavoriteClicked$1 f36417a;

    C2815x950ba2b(CommunitiesPresenter$onFavoriteClicked$1 communitiesPresenter$onFavoriteClicked$1) {
        this.f36417a = communitiesPresenter$onFavoriteClicked$1;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CommunityPresentationModel communityPresentationModel = (CommunityPresentationModel) obj;
        Intrinsics.m26847b(communityPresentationModel, "it");
        return CommunityPresentationModel.m22801a(communityPresentationModel, null, null, null, null, null, null, null, Boolean.valueOf(this.f36417a.f36419b), null, null, null, false, 0, false, 16255);
    }
}
