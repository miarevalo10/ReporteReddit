package com.reddit.frontpage.domain.usecase;

import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00020\u00032\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\u0004\u0012\u0002H\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00028\u0001H$¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/MaybeUseCase;", "T", "P", "Lcom/reddit/frontpage/domain/usecase/Params;", "Lcom/reddit/frontpage/domain/usecase/UseCase;", "Lio/reactivex/Maybe;", "()V", "build", "params", "(Lcom/reddit/frontpage/domain/usecase/Params;)Lio/reactivex/Maybe;", "execute", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MaybeUseCase.kt */
public abstract class MaybeUseCase<T, P extends Params> {
    protected abstract Maybe<T> mo4761a(P p);

    public final Maybe<T> m22526b(P p) {
        Intrinsics.m26847b(p, "params");
        return mo4761a(p);
    }
}
