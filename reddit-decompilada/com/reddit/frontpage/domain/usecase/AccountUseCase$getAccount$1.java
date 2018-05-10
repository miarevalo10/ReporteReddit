package com.reddit.frontpage.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "cached", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountUseCase.kt */
final class AccountUseCase$getAccount$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ AccountUseCase f27962a;
    final /* synthetic */ String f27963b;

    public AccountUseCase$getAccount$1(AccountUseCase accountUseCase, String str) {
        this.f27962a = accountUseCase;
        this.f27963b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        obj = (Boolean) obj;
        Intrinsics.m26847b(obj, "cached");
        if (Intrinsics.m26845a(obj, Boolean.valueOf(true))) {
            return this.f27962a.f20266a.m22396b(this.f27963b).toObservable();
        }
        if (Intrinsics.m26845a(obj, Boolean.valueOf(false)) != null) {
            return Observable.empty();
        }
        throw new NoWhenBranchMatchedException();
    }
}
