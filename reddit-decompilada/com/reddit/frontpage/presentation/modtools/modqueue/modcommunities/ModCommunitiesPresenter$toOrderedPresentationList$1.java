package com.reddit.frontpage.presentation.modtools.modqueue.modcommunities;

import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.presentation.carousel.SubredditMapper;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "subreddits", "Lcom/reddit/frontpage/domain/model/Subreddit;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModCommunitiesPresenter.kt */
final class ModCommunitiesPresenter$toOrderedPresentationList$1<T, R> implements Function<T, R> {
    final /* synthetic */ ModCommunitiesPresenter f28669a;
    final /* synthetic */ CommunityPresentationModelType f28670b;
    final /* synthetic */ CommunityPresentationSection f28671c;

    ModCommunitiesPresenter$toOrderedPresentationList$1(ModCommunitiesPresenter modCommunitiesPresenter, CommunityPresentationModelType communityPresentationModelType, CommunityPresentationSection communityPresentationSection) {
        this.f28669a = modCommunitiesPresenter;
        this.f28670b = communityPresentationModelType;
        this.f28671c = communityPresentationSection;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "subreddits");
        Iterable<Subreddit> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Subreddit subreddit : iterable) {
            SubredditMapper subredditMapper = SubredditMapper.f20341a;
            arrayList.add(SubredditMapper.m22680a(this.f28670b, this.f28671c, subreddit));
        }
        return CollectionsKt___CollectionsKt.m41418a((Iterable) (List) arrayList, (Comparator) ModCommunitiesPresenter$sortCaseInsensitive$1.f20911a);
    }
}
