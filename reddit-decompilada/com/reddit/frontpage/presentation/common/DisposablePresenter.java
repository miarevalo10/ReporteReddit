package com.reddit.frontpage.presentation.common;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "detach", "", "handleDispose", "disposable", "Lio/reactivex/disposables/Disposable;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DisposablePresenter.kt */
public abstract class DisposablePresenter implements BasePresenter {
    private final CompositeDisposable disposables = new CompositeDisposable();

    public void destroy() {
    }

    public void detach() {
        this.disposables.m32077c();
    }

    protected final void handleDispose(Disposable disposable) {
        Intrinsics.m26847b(disposable, "disposable");
        this.disposables.mo5631a(disposable);
    }
}
