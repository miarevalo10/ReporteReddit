package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemSectionPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import io.reactivex.functions.Function5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$LinkedCommunityLoadResult;", "multis", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "favorites", "following", "subscriptions", "moderated", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$loadCommunities$combiner$1<T1, T2, T3, T4, T5, R> implements Function5<List<? extends CommunityPresentationModel>, List<? extends CommunityPresentationModel>, List<? extends CommunityPresentationModel>, List<? extends CommunityPresentationModel>, List<? extends CommunityPresentationModel>, LinkedCommunityLoadResult> {
    final /* synthetic */ List f28110a;

    CommunitiesPresenter$loadCommunities$combiner$1(List list) {
        this.f28110a = list;
    }

    public final /* synthetic */ Object mo4803a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i;
        CommunitiesPresenter$loadCommunities$combiner$1 communitiesPresenter$loadCommunities$combiner$1 = this;
        List list = (List) obj;
        List list2 = (List) obj2;
        List list3 = (List) obj3;
        List list4 = (List) obj4;
        List list5 = (List) obj5;
        Intrinsics.m26847b(list, "multis");
        Intrinsics.m26847b(list2, "favorites");
        Intrinsics.m26847b(list3, "following");
        Intrinsics.m26847b(list4, "subscriptions");
        Intrinsics.m26847b(list5, "moderated");
        ArrayList arrayList = new ArrayList(5);
        for (i = 0; i < 5; i++) {
            arrayList.add(Boolean.valueOf(false));
        }
        List list6 = arrayList;
        Iterator it = communitiesPresenter$loadCommunities$combiner$1.f28110a.iterator();
        i = 0;
        int i2 = i;
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                int i3 = i + 1;
                CommunityListItem communityListItem = (CommunityListItem) it.next();
                if ((communityListItem instanceof CommunityListItemPresentationModel) && Intrinsics.m26845a(((CommunityListItemPresentationModel) communityListItem).mo7150a().f20470b, CommunityPresentationModelType.f20483a)) {
                    communityListItem = (CommunityListItem) CollectionsKt___CollectionsKt.m41425c(communitiesPresenter$loadCommunities$combiner$1.f28110a, i3);
                    boolean z2 = communityListItem != null ? communityListItem instanceof CommunityListItemSectionPresentationModel : false;
                    if (i != CollectionsKt__CollectionsKt.m26787a(communitiesPresenter$loadCommunities$combiner$1.f28110a)) {
                        if (!z2) {
                            z = false;
                        }
                    }
                    list6.set(i2, Boolean.valueOf(z));
                    i2++;
                }
                i = i3;
            } else {
                return new LinkedCommunityLoadResult(new CommunityLoadResult(CollectionsKt___CollectionsKt.m41428c(list), ((Boolean) list6.get(0)).booleanValue()), new CommunityLoadResult(CollectionsKt___CollectionsKt.m41428c(list2), ((Boolean) list6.get(1)).booleanValue()), new CommunityLoadResult(CollectionsKt___CollectionsKt.m41428c(list3), ((Boolean) list6.get(2)).booleanValue()), new CommunityLoadResult(CollectionsKt___CollectionsKt.m41428c(list4), ((Boolean) list6.get(3)).booleanValue()), new CommunityLoadResult(CollectionsKt___CollectionsKt.m41428c(list5), ((Boolean) list6.get(4)).booleanValue()));
            }
        }
    }
}
