package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public final class ObservableBlockingSubscribe {
    public static <T> void m26618a(ObservableSource<? extends T> observableSource, Observer<? super T> observer) {
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        observer.onSubscribe(blockingObserver);
        observableSource.subscribe(blockingObserver);
        while (!blockingObserver.mo5627b()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (ObservableSource<? extends T> observableSource2) {
                    blockingObserver.mo5626a();
                    observer.onError(observableSource2);
                    return;
                }
            }
            if (!blockingObserver.mo5627b() && observableSource2 != BlockingObserver.f31136a) {
                if (NotificationLite.m26702b(poll, (Observer) observer)) {
                    break;
                }
            }
            break;
        }
    }

    public static <T> void m26617a(ObservableSource<? extends T> observableSource) {
        CountDownLatch blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        Object lambdaObserver = new LambdaObserver(Functions.m26556b(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.m26556b());
        observableSource.subscribe(lambdaObserver);
        BlockingHelper.m26676a(blockingIgnoringReceiver, lambdaObserver);
        Throwable th = blockingIgnoringReceiver.f32458a;
        if (th != null) {
            throw ExceptionHelper.m26682a(th);
        }
    }

    public static <T> void m26619a(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.m26573a((Object) consumer, "onNext is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        m26618a(observableSource, new LambdaObserver(consumer, consumer2, action, Functions.m26556b()));
    }
}
