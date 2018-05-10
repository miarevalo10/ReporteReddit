package com.reddit.datalibrary.frontpage.data.feature.account.repo;

import com.google.common.base.Optional;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/google/common/base/Optional;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAccountRepository.kt */
final class RedditAccountRepository$isAccountCached$1<T, R> implements Function<T, R> {
    public static final RedditAccountRepository$isAccountCached$1 f15752a = new RedditAccountRepository$isAccountCached$1();

    RedditAccountRepository$isAccountCached$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Optional optional = (Optional) obj;
        Intrinsics.b(optional, "it");
        return Boolean.valueOf(optional.mo2315b());
    }
}
