package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import com.google.common.base.Optional;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/google/common/base/Optional;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "account", "Lcom/reddit/datalibrary/frontpage/data/model/AccountDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseAccountDataSource.kt */
final class DatabaseAccountDataSource$getByUsername$accountSelect$1<T, R> implements Function<T, R> {
    public static final DatabaseAccountDataSource$getByUsername$accountSelect$1 f15748a = new DatabaseAccountDataSource$getByUsername$accountSelect$1();

    DatabaseAccountDataSource$getByUsername$accountSelect$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Optional optional = (Optional) obj;
        Intrinsics.b(optional, "account");
        return Optional.m6897c(AccountConverter.f18678a.mo3582a().m14544c(optional.mo2317d()));
    }
}
