package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aV\u0010\b\u001a\u00020\u0002\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u0004\u001aV\u0010\b\u001a\u00020\u0002\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u0004\u001a0\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001aV\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u0004\u001aV\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u00122\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u0004\u001aV\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u0004\u001aF\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\t*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\t0\u00142\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00020\u0004\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"onCompleteStub", "Lkotlin/Function0;", "", "onErrorStub", "Lkotlin/Function1;", "", "onNextStub", "", "blockingSubscribeBy", "T", "Lio/reactivex/Flowable;", "onError", "onComplete", "onNext", "Lio/reactivex/Observable;", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Completable;", "Lio/reactivex/Maybe;", "onSuccess", "Lio/reactivex/Single;", "rxkotlin"}, k = 2, mv = {1, 1, 8})
/* compiled from: subscribers.kt */
public final class SubscribersKt {
    private static final Function1<Object, Unit> f25230a = SubscribersKt$onNextStub$1.f38166a;
    private static final Function1<Throwable, Unit> f25231b = SubscribersKt$onErrorStub$1.f38165a;
    private static final Function0<Unit> f25232c = SubscribersKt$onCompleteStub$1.f38164a;

    public static /* synthetic */ Disposable m26768a(Flowable flowable, Function1 function1, Function1 function12) {
        Function0 function0 = f25232c;
        Intrinsics.m26847b(flowable, "$receiver");
        Intrinsics.m26847b(function1, "onError");
        Intrinsics.m26847b(function0, "onComplete");
        Intrinsics.m26847b(function12, "onNext");
        Object subscribe = flowable.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function1), (Action) new SubscribersKt$sam$Action$fd62537c(function0));
        Intrinsics.m26843a(subscribe, "subscribe(onNext, onError, onComplete)");
        return subscribe;
    }

    public static final <T> Disposable m26769a(Single<T> single, Function1<? super Throwable, Unit> function1, Function1<? super T, Unit> function12) {
        Intrinsics.m26847b(single, "$receiver");
        Intrinsics.m26847b(function1, "onError");
        Intrinsics.m26847b(function12, "onSuccess");
        Object subscribe = single.subscribe(new SubscribersKt$sam$Consumer$2b2a3ebc(function12), (Consumer) new SubscribersKt$sam$Consumer$2b2a3ebc(function1));
        Intrinsics.m26843a(subscribe, "subscribe(onSuccess, onError)");
        return subscribe;
    }
}
