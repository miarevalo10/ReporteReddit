package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Multireddit;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "it", "Lcom/reddit/frontpage/domain/model/Multireddit;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$loadCommunities$multis$1<T, R> implements Function<T, R> {
    final /* synthetic */ CommunitiesPresenter f28111a;

    CommunitiesPresenter$loadCommunities$multis$1(CommunitiesPresenter communitiesPresenter) {
        this.f28111a = communitiesPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        Iterable<Multireddit> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Multireddit component1 : iterable) {
            String component12 = component1.component1();
            arrayList.add(new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", CommunityPresentationModelType.f20485c, CommunityPresentationSection.f20489c, component12, component12, null, null, null, Integer.valueOf(C1761R.drawable.ic_icon_feed_posts), Integer.valueOf(C1761R.attr.rdt_default_multireddit_key_color), null, false, -Math.abs((long) component12.hashCode()), false, 9440));
        }
        return CollectionsKt___CollectionsKt.m41418a((Iterable) (List) arrayList, (Comparator) CommunitiesPresenter$sortCaseInsensitive$1.f20448a);
    }
}
