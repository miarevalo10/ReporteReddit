package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.CommunitiesContract.Section;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "items", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$loadDefaultCommunities$2<T> implements Consumer<List<CommunityPresentationModel>> {
    final /* synthetic */ CommunitiesPresenter f28113a;

    CommunitiesPresenter$loadDefaultCommunities$2(CommunitiesPresenter communitiesPresenter) {
        this.f28113a = communitiesPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (List) obj;
        CommunitiesPresenter$models$1 a = this.f28113a.f33808b;
        Intrinsics.m26843a(obj, "items");
        a.m40552a(CollectionsKt__CollectionsKt.m26791a((Object) new LinkedCollapsibleSection(obj, this.f28113a.f33817l, Section.f28098a)));
        this.f28113a.m34644a();
    }
}
