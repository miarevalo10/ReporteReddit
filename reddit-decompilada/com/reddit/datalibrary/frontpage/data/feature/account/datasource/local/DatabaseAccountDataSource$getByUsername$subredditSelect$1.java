package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import com.google.common.base.Optional;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/google/common/base/Optional;", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "kotlin.jvm.PlatformType", "subreddit", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubredditDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseAccountDataSource.kt */
final class DatabaseAccountDataSource$getByUsername$subredditSelect$1<T, R> implements Function<T, R> {
    final /* synthetic */ String f15749a;

    DatabaseAccountDataSource$getByUsername$subredditSelect$1(String str) {
        this.f15749a = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Optional optional = (Optional) obj;
        Intrinsics.b(optional, "subreddit");
        return Optional.m6897c(new UserSubredditConverter(this.f15749a).mo3582a().m14544c(optional.mo2317d()));
    }
}
