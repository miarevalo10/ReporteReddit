package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class HalfSerializer {
    public static <T> void m26689a(Subscriber<? super T> subscriber, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t);
            if (atomicInteger.decrementAndGet() != null) {
                t = ExceptionHelper.m26683a((AtomicReference) atomicThrowable);
                if (t != null) {
                    subscriber.onError(t);
                    return;
                }
                subscriber.onComplete();
            }
        }
    }

    public static void m26691a(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == null) {
            atomicInteger = ExceptionHelper.m26683a((AtomicReference) atomicThrowable);
            if (atomicInteger != null) {
                subscriber.onError(atomicInteger);
                return;
            }
            subscriber.onComplete();
        }
    }

    public static <T> void m26686a(Observer<? super T> observer, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t);
            if (atomicInteger.decrementAndGet() != null) {
                t = ExceptionHelper.m26683a((AtomicReference) atomicThrowable);
                if (t != null) {
                    observer.onError(t);
                    return;
                }
                observer.onComplete();
            }
        }
    }

    public static void m26688a(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == null) {
            atomicInteger = ExceptionHelper.m26683a((AtomicReference) atomicThrowable);
            if (atomicInteger != null) {
                observer.onError(atomicInteger);
                return;
            }
            observer.onComplete();
        }
    }

    public static void m26690a(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!ExceptionHelper.m26684a(atomicThrowable, th)) {
            RxJavaPlugins.m26757a(th);
        } else if (atomicInteger.getAndIncrement() == null) {
            subscriber.onError(ExceptionHelper.m26683a((AtomicReference) atomicThrowable));
        }
    }

    public static void m26687a(Observer<?> observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!ExceptionHelper.m26684a(atomicThrowable, th)) {
            RxJavaPlugins.m26757a(th);
        } else if (atomicInteger.getAndIncrement() == null) {
            observer.onError(ExceptionHelper.m26683a((AtomicReference) atomicThrowable));
        }
    }
}
