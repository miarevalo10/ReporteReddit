package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableBlockingSubscribe {
    public static <T> void m26585a(Publisher<? extends T> publisher, Subscriber<? super T> subscriber) {
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        publisher.subscribe(blockingSubscriber);
        Object poll;
        do {
            try {
                if (!blockingSubscriber.m35997a()) {
                    poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        if (blockingSubscriber.m35997a()) {
                            break;
                        }
                        BlockingHelper.m26675a();
                        poll = linkedBlockingQueue.take();
                    }
                    if (blockingSubscriber.m35997a() || publisher == BlockingSubscriber.f35905a) {
                        break;
                    }
                } else {
                    break;
                }
            } catch (Publisher<? extends T> publisher2) {
                blockingSubscriber.cancel();
                subscriber.onError(publisher2);
                return;
            }
        } while (!NotificationLite.m26703b(poll, (Subscriber) subscriber));
    }

    public static <T> void m26583a(Publisher<? extends T> publisher) {
        CountDownLatch blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        Object lambdaSubscriber = new LambdaSubscriber(Functions.m26556b(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.f25023l);
        publisher.subscribe(lambdaSubscriber);
        BlockingHelper.m26676a(blockingIgnoringReceiver, lambdaSubscriber);
        Throwable th = blockingIgnoringReceiver.f32458a;
        if (th != null) {
            throw ExceptionHelper.m26682a(th);
        }
    }

    public static <T> void m26584a(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.m26573a((Object) consumer, "onNext is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        m26585a(publisher, new LambdaSubscriber(consumer, consumer2, action, Functions.f25023l));
    }
}
