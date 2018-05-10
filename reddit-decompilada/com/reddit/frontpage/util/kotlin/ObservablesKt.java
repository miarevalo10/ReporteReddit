package com.reddit.frontpage.util.kotlin;

import com.reddit.common.rx.Thread;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a*\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"observeOn", "Lio/reactivex/Observable;", "T", "thread", "Lcom/reddit/common/rx/Thread;", "subscribeOn", "subscribeSafe", "Lio/reactivex/disposables/Disposable;", "ok", "Lkotlin/Function1;", "", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Observables.kt */
public final class ObservablesKt {
    public static final <T> Observable<T> m24090a(Observable<T> observable, Thread thread) {
        Intrinsics.m26847b(observable, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object subscribeOn = observable.subscribeOn(thread.a());
        Intrinsics.m26843a(subscribeOn, "subscribeOn(thread.scheduler)");
        return subscribeOn;
    }

    public static final <T> Observable<T> m24092b(Observable<T> observable, Thread thread) {
        Intrinsics.m26847b(observable, "$receiver");
        Intrinsics.m26847b(thread, "thread");
        Object observeOn = observable.observeOn(thread.a());
        Intrinsics.m26843a(observeOn, "observeOn(thread.scheduler)");
        return observeOn;
    }

    public static final <T> Disposable m24091a(Observable<T> observable, Function1<? super T, Unit> function1) {
        Intrinsics.m26847b(observable, "$receiver");
        Intrinsics.m26847b(function1, "ok");
        Object subscribe = observable.subscribe(new ObservablesKt$subscribeSafe$1(function1), (Consumer) ObservablesKt$subscribeSafe$2.f29410a);
        Intrinsics.m26843a(subscribe, "subscribe({ ok(it) })\n  … e -> Timber.e(e, null) }");
        return subscribe;
    }
}
