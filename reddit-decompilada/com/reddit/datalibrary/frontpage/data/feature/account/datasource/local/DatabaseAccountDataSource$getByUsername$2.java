package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import com.google.common.base.Optional;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/google/common/base/Optional;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "account", "subreddit", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseAccountDataSource.kt */
final class DatabaseAccountDataSource$getByUsername$2<T1, T2, R> implements BiFunction<Optional<Account>, Optional<UserSubreddit>, Optional<Account>> {
    public static final DatabaseAccountDataSource$getByUsername$2 f15747a = new DatabaseAccountDataSource$getByUsername$2();

    DatabaseAccountDataSource$getByUsername$2() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        Optional optional = (Optional) obj;
        Optional optional2 = (Optional) obj2;
        Intrinsics.b(optional, "account");
        Intrinsics.b(optional2, "subreddit");
        Object copy$default = (optional.mo2315b() && optional2.mo2315b()) ? Account.copy$default((Account) optional.mo2316c(), null, null, 0, false, false, false, null, false, 0, 0, false, false, null, 0, false, false, false, 0, (UserSubreddit) optional2.mo2316c(), null, null, 1835007, null) : optional.mo2315b() ? (Account) optional.mo2316c() : null;
        return Optional.m6897c(copy$default);
    }
}
