package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class EndConsumerHelper {
    public static boolean m26678a(Disposable disposable, Disposable disposable2, Class<?> cls) {
        ObjectHelper.m26573a((Object) disposable2, "next is null");
        if (disposable == null) {
            return true;
        }
        disposable2.mo5626a();
        if (disposable != DisposableHelper.f31095a) {
            m26677a(cls);
        }
        return null;
    }

    public static boolean m26679a(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        ObjectHelper.m26573a((Object) disposable, "next is null");
        if (atomicReference.compareAndSet(null, disposable)) {
            return true;
        }
        disposable.mo5626a();
        if (atomicReference.get() != DisposableHelper.f31095a) {
            m26677a(cls);
        }
        return null;
    }

    public static boolean m26681a(Subscription subscription, Subscription subscription2, Class<?> cls) {
        ObjectHelper.m26573a((Object) subscription2, "next is null");
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        if (subscription != SubscriptionHelper.f32454a) {
            m26677a(cls);
        }
        return null;
    }

    public static boolean m26680a(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        ObjectHelper.m26573a((Object) subscription, "next is null");
        if (atomicReference.compareAndSet(null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != SubscriptionHelper.f32454a) {
            m26677a(cls);
        }
        return null;
    }

    private static void m26677a(Class<?> cls) {
        cls = cls.getName();
        StringBuilder stringBuilder = new StringBuilder("It is not allowed to subscribe with a(n) ");
        stringBuilder.append(cls);
        stringBuilder.append(" multiple times. Please create a fresh instance of ");
        stringBuilder.append(cls);
        stringBuilder.append(" and subscribe that to the target source instead.");
        RxJavaPlugins.m26757a(new ProtocolViolationException(stringBuilder.toString()));
    }
}
