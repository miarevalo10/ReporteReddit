package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public enum SubscriptionHelper implements Subscription {
    ;

    public final void cancel() {
    }

    public final void request(long j) {
    }

    private SubscriptionHelper(String str) {
    }

    public static boolean m32781a(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.m26757a(new NullPointerException("next is null"));
            return false;
        } else if (subscription == null) {
            return true;
        } else {
            subscription2.cancel();
            m32774a();
            return false;
        }
    }

    private static void m32774a() {
        RxJavaPlugins.m26757a(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean m32776a(long j) {
        if (j > 0) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder("n > 0 required but it was ");
        stringBuilder.append(j);
        RxJavaPlugins.m26757a(new IllegalArgumentException(stringBuilder.toString()));
        return 0;
    }

    public static void m32782b(long j) {
        StringBuilder stringBuilder = new StringBuilder("More produced than requested: ");
        stringBuilder.append(j);
        RxJavaPlugins.m26757a(new ProtocolViolationException(stringBuilder.toString()));
    }

    public static boolean m32780a(Subscription subscription) {
        return subscription == f32454a ? true : null;
    }

    public static boolean m32779a(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.m26573a((Object) subscription, "s is null");
        if (atomicReference.compareAndSet(null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != f32454a) {
            m32774a();
        }
        return null;
    }

    public static boolean m32777a(AtomicReference<Subscription> atomicReference) {
        if (((Subscription) atomicReference.get()) != f32454a) {
            Subscription subscription = (Subscription) atomicReference.getAndSet(f32454a);
            if (subscription != f32454a) {
                if (subscription != null) {
                    subscription.cancel();
                }
                return true;
            }
        }
        return null;
    }

    public static boolean m32778a(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (m32779a((AtomicReference) atomicReference, subscription) == null) {
            return null;
        }
        atomicReference = atomicLong.getAndSet(0);
        if (atomicReference != null) {
            subscription.request(atomicReference);
        }
        return true;
    }

    public static void m32775a(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = (Subscription) atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
            return;
        }
        if (m32776a(j)) {
            BackpressureHelper.m26670a(atomicLong, j);
            Subscription subscription2 = (Subscription) atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }
}
