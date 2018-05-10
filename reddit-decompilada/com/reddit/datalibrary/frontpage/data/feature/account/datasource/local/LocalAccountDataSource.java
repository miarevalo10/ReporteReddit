package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import com.google.common.base.Optional;
import com.reddit.datalibrary.frontpage.data.model.Account;
import io.reactivex.Single;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;", "", "getByUsername", "Lio/reactivex/Single;", "Lcom/google/common/base/Optional;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "username", "", "saveOrUpdate", "", "account", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalAccountDataSource.kt */
public interface LocalAccountDataSource {
    Single<Boolean> mo2913a(Account account);

    Single<Optional<Account>> mo2914a(String str);
}
