package com.reddit.datalibrary.frontpage.data.feature.account.repo;

import com.google.common.base.Optional;
import com.reddit.datalibrary.frontpage.data.model.Account;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "it", "Lcom/google/common/base/Optional;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAccountRepository.kt */
final class RedditAccountRepository$AccountPersister$read$1<T, R> implements Function<T, R> {
    public static final RedditAccountRepository$AccountPersister$read$1 f15751a = new RedditAccountRepository$AccountPersister$read$1();

    RedditAccountRepository$AccountPersister$read$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Optional optional = (Optional) obj;
        Intrinsics.b(optional, "it");
        return (Account) optional.mo2316c();
    }
}
