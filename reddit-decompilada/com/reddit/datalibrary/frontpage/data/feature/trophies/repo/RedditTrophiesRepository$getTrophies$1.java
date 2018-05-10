package com.reddit.datalibrary.frontpage.data.feature.trophies.repo;

import com.reddit.datalibrary.frontpage.data.model.TrophyRemoteDataModel;
import com.reddit.frontpage.domain.model.Trophy;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/TrophyRemoteDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditTrophiesRepository.kt */
final class RedditTrophiesRepository$getTrophies$1<T, R> implements Function<T, R> {
    public static final RedditTrophiesRepository$getTrophies$1 f16216a = new RedditTrophiesRepository$getTrophies$1();

    RedditTrophiesRepository$getTrophies$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        Iterable<TrophyRemoteDataModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (TrophyRemoteDataModel trophyRemoteDataModel : iterable) {
            arrayList.add(new Trophy(trophyRemoteDataModel.getTrophyId(), trophyRemoteDataModel.getAwardId(), trophyRemoteDataModel.getName(), trophyRemoteDataModel.getDescription(), trophyRemoteDataModel.getIcon70Url()));
        }
        return (List) arrayList;
    }
}
