package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import com.reddit.frontpage.presentation.communities.LinkedCollapsibleSection;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesContract.Section;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "communitiesImmutable", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModCommunitiesPresenter.kt */
final class ModCommunitiesPresenter$loadCommunities$1<T> implements Consumer<List<? extends CommunityPresentationModel>> {
    final /* synthetic */ ModCommunitiesPresenter f28668a;

    ModCommunitiesPresenter$loadCommunities$1(ModCommunitiesPresenter modCommunitiesPresenter) {
        this.f28668a = modCommunitiesPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "communitiesImmutable");
        list = CollectionsKt___CollectionsKt.m41428c(list);
        this.f28668a.f34081c = new LinkedCollapsibleSection(list, null, Section.f28666a, false);
        this.f28668a.f34082d = CollectionsKt__CollectionsKt.m26791a((Object) ModCommunitiesPresenter.m34804a(this.f28668a));
        this.f28668a.f34079a.mo7397a(list);
    }
}
