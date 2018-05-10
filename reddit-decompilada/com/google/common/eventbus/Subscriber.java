package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

class Subscriber {
    final Object f8491a;
    private EventBus f8492b;
    private final Method f8493c;
    private final Executor f8494d;

    static final class SynchronizedSubscriber extends Subscriber {
        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }

        final void mo2429b(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.mo2429b(obj);
            }
        }
    }

    private Subscriber(EventBus eventBus, Object obj, Method method) {
        this.f8492b = eventBus;
        this.f8491a = Preconditions.m6908a(obj);
        this.f8493c = method;
        method.setAccessible(true);
        this.f8494d = eventBus.executor();
    }

    final void m7272a(final Object obj) {
        this.f8494d.execute(new Runnable(this) {
            final /* synthetic */ Subscriber f8490b;

            public void run() {
                try {
                    this.f8490b.mo2429b(obj);
                } catch (InvocationTargetException e) {
                    this.f8490b.f8492b.handleSubscriberException(e.getCause(), new SubscriberExceptionContext(this.f8490b.f8492b, obj, this.f8490b.f8491a, this.f8490b.f8493c));
                }
            }
        });
    }

    void mo2429b(Object obj) throws InvocationTargetException {
        StringBuilder stringBuilder;
        try {
            this.f8493c.invoke(this.f8491a, new Object[]{Preconditions.m6908a(obj)});
        } catch (Throwable e) {
            stringBuilder = new StringBuilder("Method rejected target/argument: ");
            stringBuilder.append(obj);
            throw new Error(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder("Method became inaccessible: ");
            stringBuilder.append(obj);
            throw new Error(stringBuilder.toString(), e2);
        } catch (Object obj2) {
            if (obj2.getCause() instanceof Error) {
                throw ((Error) obj2.getCause());
            }
            throw obj2;
        }
    }

    public final int hashCode() {
        return ((this.f8493c.hashCode() + 31) * 31) + System.identityHashCode(this.f8491a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        if (this.f8491a != subscriber.f8491a || this.f8493c.equals(subscriber.f8493c) == null) {
            return false;
        }
        return true;
    }

    static Subscriber m7270a(EventBus eventBus, Object obj, Method method) {
        return (method.getAnnotation(AllowConcurrentEvents.class) != null ? (byte) 1 : (byte) 0) != (byte) 0 ? new Subscriber(eventBus, obj, method) : new SynchronizedSubscriber(eventBus, obj, method);
    }
}
