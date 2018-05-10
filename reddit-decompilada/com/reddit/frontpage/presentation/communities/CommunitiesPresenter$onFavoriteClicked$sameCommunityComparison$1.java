package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "other", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$onFavoriteClicked$sameCommunityComparison$1 extends Lambda implements Function1<CommunityPresentationModel, Integer> {
    final /* synthetic */ CommunityPresentationModel f36420a;

    CommunitiesPresenter$onFavoriteClicked$sameCommunityComparison$1(CommunityPresentationModel communityPresentationModel) {
        this.f36420a = communityPresentationModel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CommunityPresentationModel communityPresentationModel = (CommunityPresentationModel) obj;
        Intrinsics.m26847b(communityPresentationModel, "other");
        return Integer.valueOf(String.CASE_INSENSITIVE_ORDER.compare(communityPresentationModel.f20473e, this.f36420a.f20473e));
    }
}
